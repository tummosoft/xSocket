package xsocket.server;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BA.ShortName;
import anywheresoftware.b4a.BA.Version;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.util.HashMap;
import java.util.Map;
import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManagerFactory;
import org.noear.socketd.SocketD;
import org.noear.socketd.exception.SocketDCodecException;
import org.noear.socketd.transport.core.Listener;
import org.noear.socketd.transport.core.Message;
import org.noear.socketd.transport.core.Session;
import org.noear.socketd.transport.core.entity.StringEntity;
import org.noear.socketd.transport.core.listener.SimpleListener;
import org.noear.socketd.transport.server.Server;
import org.noear.socketd.transport.server.ServerConfig;

@Version(3.01F)
@ShortName("xServerSockets")
public class xServerSockets {
   private static Server socketserver;
   private static String chr = "UTF-8";
   private static String mHostName = null;
   private static int mPort;
   private static String mHostString = null;
   private static String mPath;
   private static String mSessionId;
   private static long mLiveTime;
   private static boolean mIsClosing;
   private static String mRemoteAddress;
   private static Session mSession = null;
   private static Message mMessage = null;
   private static String sk;
   private static int mRequestTimeout;
   private static xPathListener pathListener = null;
   private static xPipelineListener pipelineListener = null;
   private static xSimpleListener simpleListener = null;
   private static xEventListener eventListener = null;
   private static xBrokerListener brokerListener = null;
   private SSLContext mSSLContext = null;
   public static final String META_FILE = "Data-Disposition-Filename";
   public static final String META_FRAGMENT_IDX = "Data-Fragment-Idx";
   public static final String META_FRAGMENT_TOTAL = "Data-Fragment-Total";
   public static final String META_ENGTH = "Data-Length";
   public static final String META_TYPE = "Data-Type";
   public static final String META_RANGE_SIZE = "Data-Range-Size";
   public static final String META_REAL_IP = "X-Real-IP";
   private BA ba;
   private String eventname;
   private Map<Object, Object> listen = new HashMap();

   public xServerSockets() {
      socketserver = null;
   }

   public static String getHostString() {
      return mHostString;
   }

   public static String getSessionId() {
      return mSessionId;
   }

   public static long getLiveTime() {
      return mLiveTime;
   }

   public static boolean IsClosing() {
      return mIsClosing;
   }

   public static String getRemoteAddress() {
      return mRemoteAddress;
   }

   public void Initialize(BA var1, String var2, String var3) throws IOException {
     // new xServerSockets();
      this.ba = var1;
      sk = "sd:" + var3;
      this.eventname = var2.toLowerCase();      
   }

   public void EnableSimpleListener(boolean var1) {
      if (var1) {
         simpleListener = new xSimpleListener(this.ba, this.eventname);
      }

   }

   public void EnableEventListener(boolean var1) {
      if (var1) {
         eventListener = new xEventListener(this.ba, this.eventname);
      }

   }

   public void EnablePathListener(boolean var1) {
      if (var1) {
         pathListener = new xPathListener(this.ba, this.eventname);
      }

   }

   public void BrokerListener(boolean var1) {
      if (var1) {
         brokerListener = new xBrokerListener(this.ba, this.eventname);
      }

   }

   private void OpenSocket(int var1, Listener var2) {
      try {
         socketserver = SocketD.createServer(sk).config((var1x) -> {
            var1x.port(var1);
         }).config((var1x) -> {
            ServerConfig var10000 = (ServerConfig)var1x.sslContext(this.mSSLContext);
         }).config((var0) -> {
            var0.host(mHostName);
         }).config((var0) -> {
            ServerConfig var10000 = (ServerConfig)var0.charset(Charset.forName(chr));
         }).config((var0) -> {
            ServerConfig var10000 = (ServerConfig)var0.requestTimeout((long)mRequestTimeout);         
         }).listen(var2).start();
      } catch (IOException var4) {
         BA.LogError(var4.getMessage());
      }

   }

   public void Start(int var1) throws IOException {
      anywheresoftware.b4a.objects.collections.Map var2 = new anywheresoftware.b4a.objects.collections.Map();
      var2.Initialize();

      try {
         if (simpleListener != null) {
            this.OpenSocket(var1, simpleListener);
         } else if (pathListener != null) {
            this.OpenSocket(var1, pathListener);
         } else if (eventListener != null) {
            this.OpenSocket(var1, eventListener);
         } else if (brokerListener != null) {
            this.OpenSocket(var1, brokerListener);
         } else {
            this.OpenSocket(var1, (Listener)null);
         }
      } catch (SocketDCodecException var4) {
         BA.LogError(var4.getMessage());
      }

   }

   // Not yet tested
   public void setSSL(String keystorePath, String keystorePassword) {
    try {
        // 1. Load KeyStore (chứa cert + private key)
        KeyStore keyStore = KeyStore.getInstance("JKS");
        FileInputStream fis = new FileInputStream(keystorePath);
        keyStore.load(fis, keystorePassword.toCharArray());
        fis.close();

        // 2. KeyManager (BẮT BUỘC cho server)
        KeyManagerFactory kmf = KeyManagerFactory.getInstance(
                KeyManagerFactory.getDefaultAlgorithm()
        );
        kmf.init(keyStore, keystorePassword.toCharArray());

        // 3. TrustManager (có thể dùng cùng keystore)
        TrustManagerFactory tmf = TrustManagerFactory.getInstance(
                TrustManagerFactory.getDefaultAlgorithm()
        );
        tmf.init(keyStore);

        // 4. SSLContext
        mSSLContext = SSLContext.getInstance("TLS");
        mSSLContext.init(
                kmf.getKeyManagers(),
                tmf.getTrustManagers(),
                new SecureRandom()
        );

        BA.Log("SSL initialized successfully");

    } catch (Exception e) {
        BA.LogError("SSL init error: " + e.getMessage());
    }
}


   public void AddPath(String var1, String var2) {
      xEventListener var3 = new xEventListener(this.ba, var2);
      pathListener.doOf(var1, var3);
   }

   public void RequestTimeout(int var1) {
      mRequestTimeout = var1;
   }

   public void setHostName(String var1) {
      mHostName = var1;
   }

   public void SendText(String var1, String var2) {
      try {
         mSession.send(var1, new StringEntity(var2));
      } catch (IOException var4) {
         BA.Log(var4.getMessage());
      }

   }

   public void SendAndRequest(String var1, String var2) {
      try {
         mSession.sendAndRequest(var1, new StringEntity(var2));
      } catch (IOException var4) {
         BA.Log(var4.getMessage());
      }

   }

   public void SendAndRequest2(String var1, String var2, long var3) {
      try {
         mSession.sendAndRequest(var1, new StringEntity(var2), var3);
      } catch (IOException var6) {
         BA.Log(var6.getMessage());
      }

   }

   public void SendAlarm(String var1, long var2) {
      try {
         mSession.sendAlarm(mMessage, var1);
      } catch (IOException var5) {
         BA.Log(var5.getMessage());
      }

   }

   public void SendAndSubscribe(String var1, String var2, long var3) {
      try {
         mSession.sendAndSubscribe(var1, new StringEntity(var2), var3);
      } catch (IOException var6) {
         BA.Log(var6.getMessage());
      }

   }

   public void SendReply(String var1) {
      try {
         mSession.reply(mMessage, new StringEntity(var1));
      } catch (IOException var3) {
         BA.Log(var3.getMessage());
      }

   }

   public void SendReplyEnd(String var1) {
      try {
         mSession.replyEnd(mMessage, new StringEntity(var1));
      } catch (IOException var3) {
         BA.Log(var3.getMessage());
      }

   }

   public int getPort() {
      return mPort;
   }

   public String getHostName() {
      return mHostName;
   }

   public void Stop() {
      socketserver.stop();
   }

   public void SetCharset(String var1) {
      chr = var1;
   }

   public String getTitle() {
      return socketserver.getTitle();
   }

   public static String getAttr() {
      return mMessage.atName();
   }

   public static String getPararam(String var0) {
      return mSession.param(var0);
   }

   public static String getMeta(String var0) {
      return mMessage.meta(var0);
   }

   public static anywheresoftware.b4a.objects.collections.Map getAllMeta() {
      anywheresoftware.b4a.objects.collections.Map var0 = new anywheresoftware.b4a.objects.collections.Map();
      var0.setObject(mMessage.metaMap());
      return var0;
   }

   public static void setMeta(String var0, String var1) {
      mMessage.putMeta(var0, var1);
   }

   public static String getAttri(String var0) {
      return (String)mSession.attr(var0);
   }

   public static boolean ExitsAttri(String var0) {
      return mSession.attrHas(var0);
   }

   public static void AddNewPath(String var0) {
      mSession.pathNew(var0);
   }
}
