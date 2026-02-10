package xsocket.server;

import anywheresoftware.b4a.BA;
import java.io.IOException;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import org.noear.socketd.transport.core.Listener;
import org.noear.socketd.transport.core.Message;
import org.noear.socketd.transport.core.Session;
import org.noear.socketd.transport.core.listener.MessageHandler;
import org.noear.socketd.transport.core.listener.RouteSelector;
import org.noear.socketd.transport.core.listener.RouteSelectorDefault;
import org.noear.socketd.utils.IoConsumer;

public class xEventListener implements Listener {
   private IoConsumer<Session> doOnOpenHandler;
   private MessageHandler doOnMessageHandler;
   private Consumer<Session> doOnCloseHandler;
   private BiConsumer<Session, Throwable> doOnErrorHandler;
   private BA ba;
   private String eventname;
   private final RouteSelector<MessageHandler> eventRouteSelector;

   public xEventListener() {
      this.eventRouteSelector = new RouteSelectorDefault();
   }

   public xEventListener(BA var1, String var2) {
      this.ba = var1;
      this.eventname = var2.toLowerCase();
      this.eventRouteSelector = new RouteSelectorDefault();
   }

   public xEventListener(RouteSelector<MessageHandler> var1) {
      this.eventRouteSelector = var1;
   }

   public xEventListener doOnOpen(IoConsumer<Session> var1) {
      this.doOnOpenHandler = var1;
      return this;
   }

   public xEventListener doOnMessage(MessageHandler var1) {
      this.doOnMessageHandler = var1;
      return this;
   }

   public xEventListener doOnClose(Consumer<Session> var1) {
      this.doOnCloseHandler = var1;
      return this;
   }

   public xEventListener doOnError(BiConsumer<Session, Throwable> var1) {
      this.doOnErrorHandler = var1;
      return this;
   }

   public xEventListener doOn(String var1, MessageHandler var2) {
      this.eventRouteSelector.put(var1, var2);
      return this;
   }

   public void onOpen(Session var1) throws IOException {
      if (this.doOnOpenHandler != null) {
         xSession var2 = new xSession();
         var2.setObject(var1);
         this.ba.raiseEvent(this, this.eventname + "_onconnected", new Object[]{var2});
         this.doOnOpenHandler.accept(var1);
      }

   }

   public void onMessage(Session var1, Message var2) throws IOException {
      if (this.doOnMessageHandler != null) {
         xSession var3 = new xSession();
         var3.setObject(var1);
         xMessage var4 = new xMessage();
         var4.setObject(var2);
         Object[] var5 = new Object[]{var3, var4};
         this.ba.raiseEvent(this, this.eventname + "_mqonmessage", var5);
         this.doOnMessageHandler.handle(var1, var2);
      }

      MessageHandler var6 = (MessageHandler)this.eventRouteSelector.select(var2.event());
      if (var6 != null) {
         var6.handle(var1, var2);
      }

   }

   public void onClose(Session var1) {
      if (this.doOnCloseHandler != null) {
         xSession var2 = new xSession();
         var2.setObject(var1);
         Object[] var3 = new Object[]{var2};
         this.ba.raiseEvent(this, this.eventname + "_mqonclose", var3);
         this.doOnCloseHandler.accept(var1);
      }

   }

   public void onError(Session var1, Throwable var2) {
      if (this.doOnErrorHandler != null) {
         xSession var3 = new xSession();
         var3.setObject(var1);
         Object[] var4 = new Object[]{var3, var2.getMessage()};
         this.ba.raiseEvent(this, this.eventname + "_mqonerror", var4);
         this.doOnErrorHandler.accept(var1, var2);
      }

   }
}
