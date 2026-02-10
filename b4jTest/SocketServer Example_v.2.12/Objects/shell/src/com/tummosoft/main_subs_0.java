package com.tummosoft;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class main_subs_0 {


public static RemoteObject  _appstart(RemoteObject _args) throws Exception{
try {
		Debug.PushSubsStack("AppStart (main) ","main",0,main.ba,main.mostCurrent,33);
if (RapidSub.canDelegate("appstart")) { return com.tummosoft.main.remoteMe.runUserSub(false, "main","appstart", _args);}
Debug.locals.put("Args", _args);
 BA.debugLineNum = 33;BA.debugLine="Sub AppStart (Args() As String)";
Debug.ShouldStop(1);
 BA.debugLineNum = 38;BA.debugLine="server.Initialize(\"server\", \"ws\")";
Debug.ShouldStop(32);
main._server.runVoidMethod ("Initialize",main.ba,(Object)(BA.ObjectToString("server")),(Object)(RemoteObject.createImmutable("ws")));
 BA.debugLineNum = 39;BA.debugLine="server.SetCharset(\"UTF-8\")";
Debug.ShouldStop(64);
main._server.runVoidMethod ("SetCharset",(Object)(RemoteObject.createImmutable("UTF-8")));
 BA.debugLineNum = 40;BA.debugLine="server.EnablePathListener(True)";
Debug.ShouldStop(128);
main._server.runVoidMethod ("EnablePathListener",(Object)(main.__c.getField(true,"True")));
 BA.debugLineNum = 41;BA.debugLine="server.RequestTimeout(5000)";
Debug.ShouldStop(256);
main._server.runVoidMethod ("RequestTimeout",(Object)(BA.numberCast(int.class, 5000)));
 BA.debugLineNum = 42;BA.debugLine="server.Start(8602)";
Debug.ShouldStop(512);
main._server.runVoidMethod ("Start",(Object)(BA.numberCast(int.class, 8602)));
 BA.debugLineNum = 44;BA.debugLine="StartMessageLoop";
Debug.ShouldStop(2048);
main.__c.runVoidMethod ("StartMessageLoop",main.ba);
 BA.debugLineNum = 47;BA.debugLine="End Sub";
Debug.ShouldStop(16384);
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
main.myClass = BA.getDeviceClass ("com.tummosoft.main");
		
        } catch (Exception e) {
			throw new RuntimeException(e);
		}
    }
}public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 29;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 30;BA.debugLine="Dim server As xServerSockets";
main._server = RemoteObject.createNew ("xsocket.server.xServerSockets");
 //BA.debugLineNum = 31;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _server_onconnected(RemoteObject _session) throws Exception{
try {
		Debug.PushSubsStack("server_OnConnected (main) ","main",0,main.ba,main.mostCurrent,49);
if (RapidSub.canDelegate("server_onconnected")) { return com.tummosoft.main.remoteMe.runUserSub(false, "main","server_onconnected", _session);}
Debug.locals.put("session", _session);
 BA.debugLineNum = 49;BA.debugLine="Sub server_OnConnected(session As xSession)";
Debug.ShouldStop(65536);
 BA.debugLineNum = 50;BA.debugLine="Log(\"Server connected: \" & session.localAddress)";
Debug.ShouldStop(131072);
main.__c.runVoidMethod ("LogImpl","6131073",RemoteObject.concat(RemoteObject.createImmutable("Server connected: "),_session.runMethod(false,"localAddress")),0);
 BA.debugLineNum = 52;BA.debugLine="End Sub";
Debug.ShouldStop(524288);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _server_onerror(RemoteObject _session,RemoteObject _error) throws Exception{
try {
		Debug.PushSubsStack("server_OnError (main) ","main",0,main.ba,main.mostCurrent,70);
if (RapidSub.canDelegate("server_onerror")) { return com.tummosoft.main.remoteMe.runUserSub(false, "main","server_onerror", _session, _error);}
Debug.locals.put("session", _session);
Debug.locals.put("error", _error);
 BA.debugLineNum = 70;BA.debugLine="Sub server_OnError(session As xSession, error As S";
Debug.ShouldStop(32);
 BA.debugLineNum = 72;BA.debugLine="End Sub";
Debug.ShouldStop(128);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _server_onmessage(RemoteObject _session,RemoteObject _message) throws Exception{
try {
		Debug.PushSubsStack("server_OnMessage (main) ","main",0,main.ba,main.mostCurrent,54);
if (RapidSub.canDelegate("server_onmessage")) { return com.tummosoft.main.remoteMe.runUserSub(false, "main","server_onmessage", _session, _message);}
RemoteObject _msg = RemoteObject.declareNull("xsocket.server.xMessage");
RemoteObject _entry = RemoteObject.declareNull("xsocket.server.xEntityDefault");
Debug.locals.put("session", _session);
Debug.locals.put("message", _message);
 BA.debugLineNum = 54;BA.debugLine="Sub server_OnMessage(session As xSession, message";
Debug.ShouldStop(2097152);
 BA.debugLineNum = 55;BA.debugLine="Log(message.event)";
Debug.ShouldStop(4194304);
main.__c.runVoidMethod ("LogImpl","6196609",_message.runMethod(true,"event"),0);
 BA.debugLineNum = 56;BA.debugLine="Log(message.isSubscribe)";
Debug.ShouldStop(8388608);
main.__c.runVoidMethod ("LogImpl","6196610",BA.ObjectToString(_message.runMethod(true,"isSubscribe")),0);
 BA.debugLineNum = 57;BA.debugLine="If message.isSubscribe Then";
Debug.ShouldStop(16777216);
if (_message.runMethod(true,"isSubscribe").<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 58;BA.debugLine="Dim msg As xMessage = message.Message";
Debug.ShouldStop(33554432);
_msg = RemoteObject.createNew ("xsocket.server.xMessage");
_msg = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("xsocket.server.xMessage"), _message.runMethod(false,"getMessage"));Debug.locals.put("msg", _msg);Debug.locals.put("msg", _msg);
 BA.debugLineNum = 60;BA.debugLine="Dim entry As xEntityDefault = msg.entity";
Debug.ShouldStop(134217728);
_entry = RemoteObject.createNew ("xsocket.server.xEntityDefault");
_entry = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("xsocket.server.xEntityDefault"), _msg.runMethod(false,"entity"));Debug.locals.put("entry", _entry);Debug.locals.put("entry", _entry);
 BA.debugLineNum = 61;BA.debugLine="Log(\"contet=\" & entry.dataAsString)";
Debug.ShouldStop(268435456);
main.__c.runVoidMethod ("LogImpl","6196615",RemoteObject.concat(RemoteObject.createImmutable("contet="),_entry.runMethod(true,"dataAsString")),0);
 };
 BA.debugLineNum = 68;BA.debugLine="End Sub";
Debug.ShouldStop(8);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}