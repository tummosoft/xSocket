package xsocket.server;

import anywheresoftware.b4a.AbsObjectWrapper;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BA.ShortName;
import anywheresoftware.b4a.objects.collections.Map;
import java.io.IOException;
import java.nio.ByteBuffer;
import org.noear.socketd.transport.core.Entity;
import org.noear.socketd.transport.core.Message;

@ShortName("xMessage")
public class xMessage extends AbsObjectWrapper<Message> {
   private BA ba;
   private String eventname;

   public void Initialize(BA var1) throws IOException {
      this.ba = var1;
   }

   public String atName() {
      return ((Message)this.getObject()).atName();
   }

   public int rangeStart() {
      return ((Message)this.getObject()).rangeStart();
   }

   public int rangeSize() {
      return ((Message)this.getObject()).rangeSize();
   }

   public boolean isRequest() {
      return ((Message)this.getObject()).isRequest();
   }

   public boolean isSubscribe() {
      return ((Message)this.getObject()).isSubscribe();
   }

   public String sid() {
      return ((Message)this.getObject()).sid();
   }

   public String event() {
      return ((Message)this.getObject()).event();
   }

   public Entity entity() {
      return ((Message)this.getObject()).entity();
   }

   public String metaString() {
      return ((Message)this.getObject()).metaString();
   }

   public Map metaMap() {
      Map var1 = new Map();
      var1.setObject(((Message)this.getObject()).metaMap());
      return var1;
   }

   public String meta(String var1) {
      return ((Message)this.getObject()).meta(var1);
   }

   public String metaOrDefault(String var1, String var2) {
      return ((Message)this.getObject()).metaOrDefault(var1, var2);
   }

   public int metaAsInt(String var1) {
      return ((Message)this.getObject()).metaAsInt(var1);
   }

   public long metaAsLong(String var1) {
      return ((Message)this.getObject()).metaAsLong(var1);
   }

   public float metaAsFloat(String var1) {
      return ((Message)this.getObject()).metaAsFloat(var1);
   }

   public double metaAsDouble(String var1) {
      return ((Message)this.getObject()).metaAsDouble(var1);
   }

   public void putMeta(String var1, String var2) {
      ((Message)this.getObject()).putMeta(var1, var2);
   }

   public void delMeta(String var1) {
      ((Message)this.getObject()).delMeta(var1);
   }

   public ByteBuffer data() {
      return ((Message)this.getObject()).data();
   }

   public String dataAsString() {
      return ((Message)this.getObject()).dataAsString();
   }

   public byte[] dataAsBytes() {
      return ((Message)this.getObject()).dataAsBytes();
   }

   public int dataSize() {
      return ((Message)this.getObject()).dataSize();
   }

   public void release() throws IOException {
      ((Message)this.getObject()).release();
   }

   public Message getMessage() {
      return (Message)this.getObject();
   }
}
