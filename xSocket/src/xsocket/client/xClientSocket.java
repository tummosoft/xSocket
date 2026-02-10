package xsocket.client;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BA.ShortName;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManagerFactory;
import org.noear.socketd.SocketD;
import org.noear.socketd.transport.client.ClientConfig;
import org.noear.socketd.transport.client.ClientSession;
import org.noear.socketd.transport.core.Entity;
import org.noear.socketd.transport.core.Message;
import org.noear.socketd.transport.core.Session;

@ShortName("xClientSocket")
public class xClientSocket {
   private ClientSession clientSession;
   private BA ba;
   private String eventname;
   private static String mHostName;
   private static int mPort;
   private static String mHostString;
   private static String mPath;
   private static String mSessionId;
   private static long mLiveTime;
   private static int mConnectTimeout = 2000;
   private static int mRequestTimeout = 2000;
   private static boolean mReconect = true;
   private static boolean mIsClosing;
   private static String mRemoteAddress;
   private static Session mSession = null;
   private static Message mMessage = null;
   private SSLContext mSSLContext = null;
   private String sk;
   private String mCharset = "";

   public ClientSession getClientSession() {
      return this.clientSession;
   }

   public void Initialize(BA var1, String var2) {
      new xClientSocket();
      this.ba = var1;
      this.eventname = var2.toLowerCase();
   }

   public void Connect(String var1) {
      this.sk = "sd:" + var1;
      this.clientSession = SocketD.createClient(this.sk).config((var1x) -> {
         ClientConfig var10000 = (ClientConfig)var1x.sslContext(this.mSSLContext);
      }).listen(new xClientEvent()).open();
   }

   public void B4AConnect(String var1) {
      this.sk = "sd:" + var1;
      this.clientSession = SocketD.createClient(this.sk).config((var0) -> {
         ClientConfig var10000 = (ClientConfig)((ClientConfig)var0.ioThreads(1)).codecThreads(1);
      }).open();
   }

   public void MQConnect(String var1, int var2) {
      this.sk = "sd:" + var1;
      this.clientSession = SocketD.createClient(this.sk).config((var1x) -> {
         var1x.heartbeatInterval((long)var2);
      }).listen(new xClientEvent()).open();
   }

   public void sendAndSubscribe(String var1, xEntity var2) {
      try {
         this.clientSession.sendAndSubscribe(var1, (Entity)var2.getObject());
      } catch (IOException var4) {
         BA.LogError(var4.getMessage());
      }

   }

   public void sendAndRequest(String var1, xEntity var2) {
      try {
         this.clientSession.sendAndRequest(var1, (Entity)var2.getObject());
      } catch (IOException var4) {
         BA.LogError(var4.getMessage());
      }

   }

   public void sendEvent(String var1, xEntity var2) {
      try {
         this.clientSession.send(var1, (Entity)var2.getObject());
      } catch (IOException var4) {
         BA.LogError(var4.getMessage());
      }

   }

   public String getSessionId() {
      return this.clientSession.sessionId();
   }

   public void ReconnectNow() {
      try {
         this.clientSession.reconnect();
      } catch (IOException var2) {
         BA.LogError(var2.getMessage());
      }

   }

   public void Close() {
      try {
         this.clientSession.reconnect();
         this.clientSession.close();
      } catch (IOException var2) {
         BA.LogError(var2.getMessage());
      }

   }

   public void setRequestTimeout(int var1) {
      mRequestTimeout = var1;
   }

   public void setConnectTimeout(int var1) {
      mConnectTimeout = var1;
   }

   public void setCharset(String var1) {
      this.mCharset = var1;
   }

   public void setReconnect(boolean var1) {
      mReconect = var1;
   }

   public void setSSL(String var1, String var2) {
      try {
         KeyStore var3 = KeyStore.getInstance("JKS");
         var3.load(new FileInputStream(var1), var2.toCharArray());
         TrustManagerFactory var4 = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
         var4.init(var3);
         this.mSSLContext = SSLContext.getInstance("TLS");
         this.mSSLContext.init((KeyManager[])null, var4.getTrustManagers(), (SecureRandom)null);
      } catch (NoSuchAlgorithmException | KeyManagementException | KeyStoreException var5) {
         BA.LogError(var5.getMessage());
      } catch (FileNotFoundException var6) {
         Logger.getLogger(xClientSocket.class.getName()).log(Level.SEVERE, (String)null, var6);
      } catch (IOException var7) {
         Logger.getLogger(xClientSocket.class.getName()).log(Level.SEVERE, (String)null, var7);
      } catch (CertificateException var8) {
         Logger.getLogger(xClientSocket.class.getName()).log(Level.SEVERE, (String)null, var8);
      }

   }
}
