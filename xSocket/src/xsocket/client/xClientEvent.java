package xsocket.client;

import anywheresoftware.b4a.BA;
import java.io.IOException;
import org.noear.socketd.transport.core.Listener;
import org.noear.socketd.transport.core.Message;
import org.noear.socketd.transport.core.Session;
import xsocket.server.xMessage;
import xsocket.server.xSession;

public class xClientEvent implements Listener {
   private BA ba;
   private String eventname;

   public xClientEvent() {
   }

   public void Initialize(BA var1, String var2) throws IOException {
      this.ba = var1;
      this.eventname = var2.toLowerCase();
   }

   public xClientEvent(BA var1, String var2) {
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
