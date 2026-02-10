package xsocket.server;

import anywheresoftware.b4a.AbsObjectWrapper;
import anywheresoftware.b4a.BA.ShortName;
import java.util.function.Consumer;
import org.noear.socketd.transport.stream.SendStream;
import org.noear.socketd.utils.TriConsumer;

@ShortName("xSendStream")
public class xSendStream extends AbsObjectWrapper<SendStream> {
   public String sid() {
      return ((SendStream)this.getObject()).sid();
   }

   public boolean isDone() {
      return ((SendStream)this.getObject()).isDone();
   }

   public SendStream thenError(Consumer<Throwable> var1) {
      return (SendStream)((SendStream)this.getObject()).thenError(var1);
   }

   public SendStream thenProgress(TriConsumer<Boolean, Integer, Integer> var1) {
      return (SendStream)((SendStream)this.getObject()).thenProgress(var1);
   }
}
