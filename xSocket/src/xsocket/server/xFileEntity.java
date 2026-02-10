package xsocket.server;

import anywheresoftware.b4a.AbsObjectWrapper;
import anywheresoftware.b4a.BA.ShortName;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.noear.socketd.transport.core.entity.FileEntity;

@ShortName("xFileEntity")
public class xFileEntity extends AbsObjectWrapper<FileEntity> {
   public xFileEntity() throws IOException {
   }

   public void Initialize(String var1) {
      try {
         this.setObject(new FileEntity(new File(var1)));
      } catch (IOException var3) {
         Logger.getLogger(xFileEntity.class.getName()).log(Level.SEVERE, (String)null, var3);
      }

   }

   public void release() throws IOException {
      ((FileEntity)this.getObject()).release();
   }
}
