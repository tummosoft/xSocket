package xsocket.server;

import anywheresoftware.b4a.AbsObjectWrapper;
import anywheresoftware.b4a.BA.ShortName;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.noear.socketd.transport.core.entity.EntityDefault;

@ShortName("xEntityDefault")
public class xEntityDefault extends AbsObjectWrapper<EntityDefault> {
   private String dataAsString;

   public xEntityDefault() {
      this.setObject(new EntityDefault());
   }

   public EntityDefault at(String var1) {
      return ((EntityDefault)this.getObject()).at(var1);
   }

   public EntityDefault range(int var1, int var2) {
      return ((EntityDefault)this.getObject()).range(var1, var2);
   }

   public EntityDefault metaStringSet(String var1) {
      return ((EntityDefault)this.getObject()).metaStringSet(var1);
   }

   public String metaString() {
      return ((EntityDefault)this.getObject()).metaString();
   }

   public EntityDefault metaMapPut(Map<String, String> var1) {
      return ((EntityDefault)this.getObject()).metaMapPut(var1);
   }

   public Map<String, String> metaMap() {
      return ((EntityDefault)this.getObject()).metaMap();
   }

   public EntityDefault metaPut(String var1, String var2) {
      return ((EntityDefault)this.getObject()).metaPut(var1, var2);
   }

   public EntityDefault metaDel(String var1) {
      return ((EntityDefault)this.getObject()).metaDel(var1);
   }

   public String meta(String var1) {
      return ((EntityDefault)this.getObject()).meta(var1);
   }

   public String metaOrDefault(String var1, String var2) {
      return ((EntityDefault)this.getObject()).metaOrDefault(var1, var2);
   }

   public void putMeta(String var1, String var2) {
      ((EntityDefault)this.getObject()).putMeta(var1, var2);
   }

   public void delMeta(String var1) {
      ((EntityDefault)this.getObject()).delMeta(var1);
   }

   public EntityDefault dataSet(byte[] var1) {
      return ((EntityDefault)this.getObject()).dataSet(var1);
   }

   public EntityDefault dataSet(ByteBuffer var1) {
      return ((EntityDefault)this.getObject()).dataSet(var1);
   }

   public ByteBuffer data() {
      return ((EntityDefault)this.getObject()).data();
   }

   public String dataAsString() {
      return ((EntityDefault)this.getObject()).dataAsString();
   }

   public byte[] dataAsBytes() {
      return ((EntityDefault)this.getObject()).dataAsBytes();
   }

   public int dataSize() {
      return ((EntityDefault)this.getObject()).dataSize();
   }

   public void release() {
      try {
         ((EntityDefault)this.getObject()).release();
      } catch (IOException var2) {
         Logger.getLogger(xEntityDefault.class.getName()).log(Level.SEVERE, (String)null, var2);
      }

   }

   public String toString() {
      return ((EntityDefault)this.getObject()).toString();
   }
}
