package xsocket.client;

import anywheresoftware.b4a.AbsObjectWrapper;
import anywheresoftware.b4a.BA.ShortName;
import anywheresoftware.b4a.objects.collections.Map;
import java.io.IOException;
import java.nio.ByteBuffer;
import org.noear.socketd.transport.core.Entity;

@ShortName("xEntity")
public class xEntity extends AbsObjectWrapper<Entity> {
   public void Initialize() {
   }

   public Entity getEntity() {
      return (Entity)this.getObject();
   }

   public String metaString() {
      return ((Entity)this.getObject()).metaString();
   }

   public Map metaMap() {
      Map var1 = new Map();
      var1.setObject(((Entity)this.getObject()).metaMap());
      return var1;
   }

   public String meta(String var1) {
      return ((Entity)this.getObject()).meta(var1);
   }

   public String metaOrDefault(String var1, String var2) {
      return ((Entity)this.getObject()).metaOrDefault(var1, var2);
   }

   public int setMetaAsInt(String var1) {
      return ((Entity)this.getObject()).metaAsInt(var1);
   }

   public long setMetaAsLong(String var1) {
      return ((Entity)this.getObject()).metaAsLong(var1);
   }

   public float setMetaAsFloat(String var1) {
      return ((Entity)this.getObject()).metaAsFloat(var1);
   }

   public double setMetaAsDouble(String var1) {
      return ((Entity)this.getObject()).metaAsDouble(var1);
   }

   public void PutMeta(String var1, String var2) {
      ((Entity)this.getObject()).putMeta(var1, var2);
   }

   public void DeleteMeta(String var1) {
      ((Entity)this.getObject()).delMeta(var1);
   }

   public ByteBuffer GetData() {
      return ((Entity)this.getObject()).data();
   }

   public String GetString() {
      return ((Entity)this.getObject()).dataAsString();
   }

   public byte[] GetBytes() {
      return ((Entity)this.getObject()).dataAsBytes();
   }

   public int Size() {
      return ((Entity)this.getObject()).dataSize();
   }

   public void release() throws IOException {
      ((Entity)this.getObject()).release();
   }
}
