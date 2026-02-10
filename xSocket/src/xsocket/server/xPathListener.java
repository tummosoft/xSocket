package xsocket.server;

import anywheresoftware.b4a.BA;
import java.io.IOException;
import org.noear.socketd.transport.core.Listener;
import org.noear.socketd.transport.core.Message;
import org.noear.socketd.transport.core.Session;
import org.noear.socketd.transport.core.listener.EventListener;
import org.noear.socketd.transport.core.listener.RouteSelector;
import org.noear.socketd.transport.core.listener.RouteSelectorDefault;

public class xPathListener implements Listener {
   private BA ba1;
   private String eventname1;
   private static String mHostName1;
   private static int mPort1;
   private static String mHostString1;
   private static String mPath1;
   private static String mSessionId1;
   private static long mLiveTime1;
   private static boolean mIsClosing1;
   private static String mRemoteAddress1;
   private static Session mSession1 = null;
   private static Message mMessage1 = null;
   protected RouteSelector<Listener> pathRouteSelector = null;

   public xPathListener(BA var1, String var2) {
      this.ba1 = var1;
      this.eventname1 = var2.toLowerCase();
      this.pathRouteSelector = new RouteSelectorDefault();
   }

   public xPathListener() {
      this.pathRouteSelector = new RouteSelectorDefault();
   }

   public xPathListener(RouteSelector<Listener> var1) {
      this.pathRouteSelector = var1;
   }

   public xPathListener doOf(String var1, Listener var2) {
      this.pathRouteSelector.put(var1, var2);
      return this;
   }

   public EventListener of(String var1) {
      EventListener var2 = new EventListener();
      this.pathRouteSelector.put(var1, var2);
      return var2;
   }

   public int size() {
      return this.pathRouteSelector.size();
   }

   public void onOpen(Session var1) throws IOException {
      xSession var2 = new xSession();
      var2.setObject(var1);
      Object[] var3 = new Object[]{var2};
      this.ba1.raiseEvent(this, this.eventname1 + "_onconnected", var3);
   }

   public void onMessage(Session var1, Message var2) throws IOException {
      xSession var3 = new xSession();
      var3.setObject(var1);
      xMessage var4 = new xMessage();
      var4.setObject(var2);
      Object[] var5 = new Object[]{var3, var4};
      this.ba1.raiseEvent(this, this.eventname1 + "_onmessage", var5);
   }

   public void onClose(Session var1) {
      xSession var2 = new xSession();
      var2.setObject(var1);
      Object[] var3 = new Object[]{var2};
      this.ba1.raiseEvent(this, this.eventname1 + "_onclose", var3);
   }

   public void onError(Session var1, Throwable var2) {
      xSession var3 = new xSession();
      var3.setObject(var1);
      Object[] var4 = new Object[]{var3, var2.getMessage()};
      this.ba1.raiseEvent(this, this.eventname1 + "_onerror", var4);
   }
}
