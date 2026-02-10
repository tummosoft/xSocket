package xsocket.server;

import anywheresoftware.b4a.AbsObjectWrapper;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BA.ShortName;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.noear.socketd.transport.core.entity.EntityDefault;
import org.noear.socketd.transport.core.entity.StringEntity;

@ShortName("xStringEntity")
public class xStringEntity extends AbsObjectWrapper<StringEntity> {
   private String dataAsString;

   public void Initialize(BA var1, String var2) {
      this.setObject(new StringEntity(var2));
   }

   public xStringEntity() {
   }

   public xStringEntity(String var1) {
      this.setObject(new StringEntity(var1));
   }

   public void getAT(String var1) {
      ((StringEntity)this.getObject()).at(var1);
   }

   public EntityDefault range(int var1, int var2) {
      return ((StringEntity)this.getObject()).range(var1, var2);
   }

   public EntityDefault metaStringSet(String var1) {
      return ((StringEntity)this.getObject()).metaStringSet(var1);
   }

   public String metaString() {
      return ((StringEntity)this.getObject()).metaString();
   }

   public EntityDefault metaMapPut(Map<String, String> var1) {
      return ((StringEntity)this.getObject()).metaMapPut(var1);
   }

   public Map<String, String> metaMap() {
      return ((StringEntity)this.getObject()).metaMap();
   }

   public EntityDefault metaPut(String var1, String var2) {
      return ((StringEntity)this.getObject()).metaPut(var1, var2);
   }

   public EntityDefault metaDel(String var1) {
      return ((StringEntity)this.getObject()).metaDel(var1);
   }

   public String meta(String var1) {
      return ((StringEntity)this.getObject()).meta(var1);
   }

   public String metaOrDefault(String var1, String var2) {
      return ((StringEntity)this.getObject()).metaOrDefault(var1, var2);
   }

   public void putMeta(String var1, String var2) {
      ((StringEntity)this.getObject()).putMeta(var1, var2);
   }

   public void delMeta(String var1) {
      ((StringEntity)this.getObject()).delMeta(var1);
   }

   public EntityDefault dataSet(byte[] var1) {
      return ((StringEntity)this.getObject()).dataSet(var1);
   }

   public EntityDefault dataSet(ByteBuffer var1) {
      return ((StringEntity)this.getObject()).dataSet(var1);
   }

   public ByteBuffer data() {
      return ((StringEntity)this.getObject()).data();
   }

   public String dataAsString() {
      return ((StringEntity)this.getObject()).dataAsString();
   }

   public byte[] dataAsBytes() {
      return ((StringEntity)this.getObject()).dataAsBytes();
   }

   public int dataSize() {
      return ((StringEntity)this.getObject()).dataSize();
   }

   public void release() {
      try {
         ((StringEntity)this.getObject()).release();
      } catch (IOException var2) {
         Logger.getLogger(xEntityDefault.class.getName()).log(Level.SEVERE, (String)null, var2);
      }

   }

   public String toString() {
      return ((StringEntity)this.getObject()).toString();
   }

   public StringEntity getEntity() {
      return (StringEntity)this.getObject();
   }
}
