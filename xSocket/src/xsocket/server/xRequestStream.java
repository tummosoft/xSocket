package xsocket.server;

import anywheresoftware.b4a.AbsObjectWrapper;
import anywheresoftware.b4a.BA.ShortName;
import java.util.function.Consumer;
import org.noear.socketd.transport.core.Reply;
import org.noear.socketd.transport.stream.RequestStream;
import org.noear.socketd.utils.IoConsumer;
import org.noear.socketd.utils.TriConsumer;

@ShortName("xRequestStream")
public class xRequestStream extends AbsObjectWrapper<RequestStream> {
   public Reply await() {
      return ((RequestStream)this.getObject()).await();
   }

   public RequestStream thenReply(IoConsumer<Reply> var1) {
      return ((RequestStream)this.getObject()).thenReply(var1);
   }

   public String sid() {
      return ((RequestStream)this.getObject()).sid();
   }

   public boolean isDone() {
      return ((RequestStream)this.getObject()).isDone();
   }

   public RequestStream thenError(Consumer<Throwable> var1) {
      return (RequestStream)((RequestStream)this.getObject()).thenError(var1);
   }

   public RequestStream thenProgress(TriConsumer<Boolean, Integer, Integer> var1) {
      return (RequestStream)((RequestStream)this.getObject()).thenProgress(var1);
   }
}
