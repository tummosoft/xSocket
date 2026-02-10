package xsocket.server;

import anywheresoftware.b4a.AbsObjectWrapper;
import anywheresoftware.b4a.BA.ShortName;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Map;
import org.noear.socketd.transport.core.Entity;
import org.noear.socketd.transport.core.entity.MessageDefault;

@ShortName("xMessageDefault")
public class xMessageDefault extends AbsObjectWrapper<MessageDefault> {
   public xMessageDefault(int var1, String var2, String var3, Entity var4) {
      this.setObject(new MessageDefault(var1, var2, var3, var4));
   }

   public int flag() {
      return ((MessageDefault)this.getObject()).flag();
   }

   public boolean isEnd() {
      return ((MessageDefault)this.getObject()).isEnd();
   }

   public boolean isRequest() {
      return ((MessageDefault)this.getObject()).isRequest();
   }

   public boolean isSubscribe() {
      return ((MessageDefault)this.getObject()).isSubscribe();
   }

   public String sid() {
      return ((MessageDefault)this.getObject()).sid();
   }

   public String event() {
      return ((MessageDefault)this.getObject()).event();
   }

   public Entity entity() {
      return ((MessageDefault)this.getObject()).entity();
   }

   public String toString() {
      return ((MessageDefault)this.getObject()).toString();
   }

   public String metaString() {
      return ((MessageDefault)this.getObject()).metaString();
   }

   public Map<String, String> metaMap() {
      return ((MessageDefault)this.getObject()).metaMap();
   }

   public String meta(String var1) {
      return ((MessageDefault)this.getObject()).meta(var1);
   }

   public String metaOrDefault(String var1, String var2) {
      return ((MessageDefault)this.getObject()).metaOrDefault(var1, var2);
   }

   public void putMeta(String var1, String var2) {
      ((MessageDefault)this.getObject()).putMeta(var1, var2);
   }

   public void delMeta(String var1) {
      ((MessageDefault)this.getObject()).delMeta(var1);
   }

   public ByteBuffer data() {
      return ((MessageDefault)this.getObject()).data();
   }

   public String dataAsString() {
      return ((MessageDefault)this.getObject()).dataAsString();
   }

   public byte[] dataAsBytes() {
      return ((MessageDefault)this.getObject()).dataAsBytes();
   }

   public int dataSize() {
      return ((MessageDefault)this.getObject()).dataSize();
   }

   public void release() throws IOException {
      ((MessageDefault)this.getObject()).release();
   }
}
