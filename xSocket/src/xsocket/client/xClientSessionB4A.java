package xsocket.client;

import anywheresoftware.b4a.AbsObjectWrapper;
import anywheresoftware.b4a.BA.ShortName;
import java.io.IOException;
import org.noear.socketd.transport.client.ClientSession;
import org.noear.socketd.transport.core.Entity;
import org.noear.socketd.transport.stream.RequestStream;
import org.noear.socketd.transport.stream.SendStream;
import org.noear.socketd.transport.stream.SubscribeStream;

@ShortName("xClientSessionB4A")
public class xClientSessionB4A extends AbsObjectWrapper<ClientSession> {
   public ClientSession getClientSession() {
      return (ClientSession)this.getObject();
   }

   public boolean isValid() {
      return ((ClientSession)this.getObject()).isValid();
   }

   public boolean isClosing() {
      return isClosing();
   }

   public String sessionId() {
      return sessionId();
   }

   public SendStream send(String var1, Entity var2) throws IOException {
      return send(var1, var2);
   }

   public RequestStream sendAndRequest(String var1, Entity var2) throws IOException {
      return sendAndRequest(var1, var2);
   }

   public Entity sendAndRequest2(String var1, Entity var2) throws IOException {
      return sendAndRequest(var1, var2).await();
   }

   public RequestStream sendAndRequest(String var1, Entity var2, long var3) throws IOException {
      return sendAndRequest(var1, var2, var3);
   }

   public SubscribeStream sendAndSubscribe(String var1, Entity var2) throws IOException {
      return sendAndSubscribe(var1, var2);
   }

   public SubscribeStream sendAndSubscribe(String var1, Entity var2, long var3) throws IOException {
      return sendAndSubscribe(var1, var2, var3);
   }

   public void closeStarting() throws IOException {
     closeStarting();
   }

   public void close() throws IOException {
      close();
   }

   public void reconnect() throws IOException {
      reconnect();
   }
}
