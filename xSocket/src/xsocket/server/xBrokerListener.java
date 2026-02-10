package xsocket.server;

import anywheresoftware.b4a.BA;
import java.io.IOException;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import org.noear.socketd.broker.BrokerListener;
import org.noear.socketd.transport.core.Entity;
import org.noear.socketd.transport.core.Message;
import org.noear.socketd.transport.core.Session;
import org.noear.socketd.transport.core.listener.MessageHandler;
import org.noear.socketd.transport.core.listener.RouteSelector;
import org.noear.socketd.transport.core.listener.RouteSelectorDefault;
import org.noear.socketd.utils.IoConsumer;

public class xBrokerListener extends BrokerListener {
   private IoConsumer<Session> doOnOpenHandler;
   private MessageHandler doOnMessageHandler;
   private Consumer<Session> doOnCloseHandler;
   private BiConsumer<Session, Throwable> doOnErrorHandler;
   private final RouteSelector<MessageHandler> eventRouteSelector;
   private BA ba;
   private String eventname;
   private static String mHostName;
   private static int mPort;
   private static String mHostString;
   private static String mPath;
   private static String mSessionId;
   private static long mLiveTime;
   private static boolean mIsClosing;
   private static String mRemoteAddress;
   private static Session mSession = null;
   private static Message mMessage = null;

   public void Initialize(BA var1, String var2) throws IOException {
      this.ba = var1;
      this.eventname = var2.toLowerCase();
   }

   public xBrokerListener() {
      this.eventRouteSelector = new RouteSelectorDefault();
   }

   public xBrokerListener(BA var1, String var2) {
      this.ba = var1;
      this.eventname = var2.toLowerCase();
      this.eventRouteSelector = new RouteSelectorDefault();
   }

   public xBrokerListener(RouteSelector<MessageHandler> var1) {
      this.eventRouteSelector = var1;
   }

   public xBrokerListener doOnOpen(IoConsumer<Session> var1) {
      this.doOnOpenHandler = var1;
      return this;
   }

   public xBrokerListener doOnMessage(MessageHandler var1) {
      this.doOnMessageHandler = var1;
      return this;
   }

   public xBrokerListener doOnClose(Consumer<Session> var1) {
      this.doOnCloseHandler = var1;
      return this;
   }

   public xBrokerListener doOnError(BiConsumer<Session, Throwable> var1) {
      this.doOnErrorHandler = var1;
      return this;
   }

   public xBrokerListener doOn(String var1, MessageHandler var2) {
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
         this.ba.raiseEvent(this, this.eventname + "_onmessage", var5);
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
         this.ba.raiseEvent(this, this.eventname + "_onclose", var3);
         this.doOnCloseHandler.accept(var1);
      }

   }

   public void onError(Session var1, Throwable var2) {
      if (this.doOnErrorHandler != null) {
         xSession var3 = new xSession();
         var3.setObject(var1);
         Object[] var4 = new Object[]{var3, var2.getMessage()};
         this.ba.raiseEvent(this, this.eventname + "_onerror", var4);
         this.doOnErrorHandler.accept(var1, var2);
      }

   }

   public void broadcast(String var1, Entity var2) throws IOException {
   }

   public boolean forwardToName(Session var1, Message var2, String var3) throws IOException {
      return true;
   }

   public void forwardToSession(Session var1, Message var2, Session var3) throws IOException {
      this.forwardToSession(var1, var2, var3, -1L);
   }

   public void forwardToSession(Session var1, Message var2, Session var3, long var4) throws IOException {
   }
}
