package b4j.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class main_subs_0 {


public static RemoteObject  _appstart(RemoteObject _form1,RemoteObject _args) throws Exception{
try {
		Debug.PushSubsStack("AppStart (main) ","main",0,main.ba,main.mostCurrent,38);
if (RapidSub.canDelegate("appstart")) { return b4j.example.main.remoteMe.runUserSub(false, "main","appstart", _form1, _args);}
Debug.locals.put("Form1", _form1);
Debug.locals.put("Args", _args);
 BA.debugLineNum = 38;BA.debugLine="Sub AppStart (Form1 As Form, Args() As String)";
Debug.ShouldStop(32);
 BA.debugLineNum = 39;BA.debugLine="MainForm = Form1";
Debug.ShouldStop(64);
main._mainform = _form1;
 BA.debugLineNum = 40;BA.debugLine="MainForm.RootPane.LoadLayout(\"Layout1\")";
Debug.ShouldStop(128);
main._mainform.runMethod(false,"getRootPane").runMethodAndSync(false,"LoadLayout",main.ba,(Object)(RemoteObject.createImmutable("Layout1")));
 BA.debugLineNum = 41;BA.debugLine="MainForm.Show";
Debug.ShouldStop(256);
main._mainform.runVoidMethodAndSync ("Show");
 BA.debugLineNum = 43;BA.debugLine="tcpSocket.Initialize(\"tcpSocket\")";
Debug.ShouldStop(1024);
main._tcpsocket.runVoidMethod ("Initialize",main.ba,(Object)(RemoteObject.createImmutable("tcpSocket")));
 BA.debugLineNum = 44;BA.debugLine="tcpSocket.Connect(\"ws://127.0.0.1:8602/?u=a&p=2\")";
Debug.ShouldStop(2048);
main._tcpsocket.runVoidMethod ("Connect",(Object)(RemoteObject.createImmutable("ws://127.0.0.1:8602/?u=a&p=2")));
 BA.debugLineNum = 45;BA.debugLine="End Sub";
Debug.ShouldStop(4096);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _button1_click() throws Exception{
try {
		Debug.PushSubsStack("Button1_Click (main) ","main",0,main.ba,main.mostCurrent,47);
if (RapidSub.canDelegate("button1_click")) { return b4j.example.main.remoteMe.runUserSub(false, "main","button1_click");}
RemoteObject _clientsession = RemoteObject.declareNull("xsocket.client.xClientSession");
RemoteObject _msg = RemoteObject.declareNull("xsocket.server.xStringEntity");
 BA.debugLineNum = 47;BA.debugLine="Sub Button1_Click";
Debug.ShouldStop(16384);
 BA.debugLineNum = 49;BA.debugLine="Dim clientSession As xClientSession = tcpSocket.C";
Debug.ShouldStop(65536);
_clientsession = RemoteObject.createNew ("xsocket.client.xClientSession");
_clientsession = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("xsocket.client.xClientSession"), main._tcpsocket.runMethod(false,"getClientSession"));Debug.locals.put("clientSession", _clientsession);Debug.locals.put("clientSession", _clientsession);
 BA.debugLineNum = 50;BA.debugLine="Log(\"Session=\" & clientSession.sessionId)";
Debug.ShouldStop(131072);
main.__c.runVoidMethod ("LogImpl","6131075",RemoteObject.concat(RemoteObject.createImmutable("Session="),_clientsession.runMethod(true,"sessionId")),0);
 BA.debugLineNum = 52;BA.debugLine="Dim msg As xStringEntity";
Debug.ShouldStop(524288);
_msg = RemoteObject.createNew ("xsocket.server.xStringEntity");Debug.locals.put("msg", _msg);
 BA.debugLineNum = 53;BA.debugLine="msg.Initialize(\"Hello how are you\")";
Debug.ShouldStop(1048576);
_msg.runVoidMethod ("Initialize",main.ba,(Object)(RemoteObject.createImmutable("Hello how are you")));
 BA.debugLineNum = 55;BA.debugLine="clientSession.sendAndSubscribe(\"reply\",  msg)";
Debug.ShouldStop(4194304);
_clientsession.runVoidMethod ("sendAndSubscribe",(Object)(BA.ObjectToString("reply")),(Object)((_msg.getObject())));
 BA.debugLineNum = 57;BA.debugLine="End Sub";
Debug.ShouldStop(16777216);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}

private static boolean processGlobalsRun;
public static void initializeProcessGlobals() {
    
    if (main.processGlobalsRun == false) {
	    main.processGlobalsRun = true;
		try {
		        main_subs_0._process_globals();
main.myClass = BA.getDeviceClass ("b4j.example.main");
		
        } catch (Exception e) {
			throw new RuntimeException(e);
		}
    }
}public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 29;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 30;BA.debugLine="Private fx As JFX";
main._fx = RemoteObject.createNew ("anywheresoftware.b4j.objects.JFX");
 //BA.debugLineNum = 31;BA.debugLine="Private MainForm As Form";
main._mainform = RemoteObject.createNew ("anywheresoftware.b4j.objects.Form");
 //BA.debugLineNum = 32;BA.debugLine="Private xui As XUI";
main._xui = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XViewWrapper.XUI");
 //BA.debugLineNum = 33;BA.debugLine="Private Button1 As B4XView";
main._button1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XViewWrapper");
 //BA.debugLineNum = 34;BA.debugLine="Dim tcpSocket As xClientSocket";
main._tcpsocket = RemoteObject.createNew ("xsocket.client.xClientSocket");
 //BA.debugLineNum = 36;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _tcpsocket_onconnected(RemoteObject _session) throws Exception{
try {
		Debug.PushSubsStack("tcpSocket_OnConnected (main) ","main",0,main.ba,main.mostCurrent,59);
if (RapidSub.canDelegate("tcpsocket_onconnected")) { return b4j.example.main.remoteMe.runUserSub(false, "main","tcpsocket_onconnected", _session);}
Debug.locals.put("session", _session);
 BA.debugLineNum = 59;BA.debugLine="Sub tcpSocket_OnConnected(session As xSession)";
Debug.ShouldStop(67108864);
 BA.debugLineNum = 60;BA.debugLine="Log(\"Session=\" & session.sessionId)";
Debug.ShouldStop(134217728);
main.__c.runVoidMethod ("LogImpl","6196609",RemoteObject.concat(RemoteObject.createImmutable("Session="),_session.runMethod(true,"sessionId")),0);
 BA.debugLineNum = 62;BA.debugLine="End Sub";
Debug.ShouldStop(536870912);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}