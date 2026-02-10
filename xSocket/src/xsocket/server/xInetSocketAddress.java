package xsocket.server;

import anywheresoftware.b4a.AbsObjectWrapper;
import anywheresoftware.b4a.BA.ShortName;
import java.net.InetSocketAddress;

@ShortName("xInetSocketAddress")
public class xInetSocketAddress extends AbsObjectWrapper<InetSocketAddress> {
   public xInetSocketAddress(int var1) {
      this.setObject(new InetSocketAddress(var1));
   }

   public String getHostName() {
      return ((InetSocketAddress)this.getObject()).getHostName();
   }

   public String getHostString() {
      return ((InetSocketAddress)this.getObject()).getHostString();
   }

   public int getPort() {
      return ((InetSocketAddress)this.getObject()).getPort();
   }

   public boolean isUnresolved() {
      return ((InetSocketAddress)this.getObject()).isUnresolved();
   }
}
