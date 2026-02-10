package xsocket.server;

import anywheresoftware.b4a.AbsObjectWrapper;
import anywheresoftware.b4a.BA.ShortName;
import anywheresoftware.b4a.objects.collections.Map;
import java.io.IOException;
import java.net.InetSocketAddress;
import org.noear.socketd.transport.core.Entity;
import org.noear.socketd.transport.core.Handshake;
import org.noear.socketd.transport.core.Message;
import org.noear.socketd.transport.core.Session;
import org.noear.socketd.transport.stream.SendStream;
import org.noear.socketd.transport.stream.SubscribeStream;

@ShortName("xSession")
public class xSession extends AbsObjectWrapper<Session> {
   public InetSocketAddress remoteAddress() throws IOException {
      return ((Session)this.getObject()).remoteAddress();
   }

   public InetSocketAddress localAddress() throws IOException {
      return ((Session)this.getObject()).localAddress();
   }

   public Handshake handshake() {
      return ((Session)this.getObject()).handshake();
   }

   public String param(String var1) {
      return ((Session)this.getObject()).param(var1);
   }

   public String paramOrDefault(String var1, String var2) {
      return ((Session)this.getObject()).paramOrDefault(var1, var2);
   }

   public String path() {
      return ((Session)this.getObject()).path();
   }

   public void pathNew(String var1) {
      ((Session)this.getObject()).pathNew(var1);
   }

   public Map attrMap() {
      Map var1 = new Map();
      var1.setObject(((Session)this.getObject()).attrMap());
      return var1;
   }

   public boolean attrHas(String var1) {
      return ((Session)this.getObject()).attrHas(var1);
   }

   public <T> T attr(String var1) {
      return ((Session)this.getObject()).attr(var1);
   }

   public <T> T attrOrDefault(String var1, T var2) {
      return ((Session)this.getObject()).attrOrDefault(var1, var2);
   }

   public <T> Session attrPut(String var1, T var2) {
      return ((Session)this.getObject()).attrPut(var1, var2);
   }

   public boolean isValid() {
      return ((Session)this.getObject()).isValid();
   }

   public boolean isClosing() {
      return ((Session)this.getObject()).isClosing();
   }

   public String sessionId() {
      return ((Session)this.getObject()).sessionId();
   }

   public long liveTime() {
      return ((Session)this.getObject()).liveTime();
   }

   public void reconnect() throws IOException {
      ((Session)this.getObject()).reconnect();
   }

   public void sendPing() throws IOException {
      ((Session)this.getObject()).sendPing();
   }

   public void sendAlarm(Message var1, String var2) throws IOException {
      ((Session)this.getObject()).sendAlarm(var1, var2);
   }

   public void reply(Message var1, Entity var2) throws IOException {
      ((Session)this.getObject()).reply(var1, var2);
   }

   public void replyEnd(Message var1, Entity var2) throws IOException {
      ((Session)this.getObject()).replyEnd(var1, var2);
   }

   public void closeStarting() throws IOException {
      ((Session)this.getObject()).closeStarting();
   }

   public SendStream send(String var1, Entity var2) throws IOException {
      return ((Session)this.getObject()).send(var1, var2);
   }

   public xRequestStream sendAndRequest(String var1, Entity var2, long var3) throws IOException {
      xRequestStream var5 = new xRequestStream();
      var5.setObject(((Session)this.getObject()).sendAndRequest(var1, var2, var3));
      return var5;
   }

   public SubscribeStream sendAndSubscribe(String var1, Entity var2, long var3) throws IOException {
      return ((Session)this.getObject()).sendAndSubscribe(var1, var2, var3);
   }

   public void close() throws IOException {
      ((Session)this.getObject()).close();
   }

   public Session getSession() {
      return (Session)this.getObject();
   }
}
