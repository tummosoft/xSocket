package xsocket.server;

import anywheresoftware.b4a.BA;
import java.io.IOException;
import org.noear.socketd.transport.core.Listener;
import org.noear.socketd.transport.core.Message;
import org.noear.socketd.transport.core.Session;

public class xSimpleListener implements Listener {
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

   public xSimpleListener(BA var1, String var2) {
      this.ba = var1;
      this.eventname = var2.toLowerCase();
   }

   public void onOpen(Session var1) throws IOException {
      xSession var2 = new xSession();
      var2.setObject(var1);
      Object[] var3 = new Object[]{var2};
      this.ba.raiseEvent(this, this.eventname + "_onconnected", var3);
   }

   public void onMessage(Session var1, Message var2) throws IOException {
      xSession var3 = new xSession();
      var3.setObject(var1);
      xMessage var4 = new xMessage();
      var4.setObject(var2);
      Object[] var5 = new Object[]{var3, var4};
      this.ba.raiseEvent(this, this.eventname + "_onmessage", var5);
   }

   public void onClose(Session var1) {
      xSession var2 = new xSession();
      var2.setObject(var1);
      Object[] var3 = new Object[]{var2};
      this.ba.raiseEvent(this, this.eventname + "_onclose", var3);
   }

   public void onError(Session var1, Throwable var2) {
      xSession var3 = new xSession();
      var3.setObject(var1);
      Object[] var4 = new Object[]{var3, var2.getMessage()};
      this.ba.raiseEvent(this, this.eventname + "_onerror", var4);
   }
}
