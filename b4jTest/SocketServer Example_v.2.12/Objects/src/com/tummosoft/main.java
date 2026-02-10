package com.tummosoft;

import anywheresoftware.b4a.debug.*;

import anywheresoftware.b4a.BA;

public class main extends Object{
public static main mostCurrent = new main();

public static BA ba;
static {
		ba = new  anywheresoftware.b4a.shell.ShellBA("com.tummosoft", "com.tummosoft.main", null);
		ba.loadHtSubs(main.class);
        if (ba.getClass().getName().endsWith("ShellBA")) {
			anywheresoftware.b4a.shell.ShellBA.delegateBA = new anywheresoftware.b4a.StandardBA("com.tummosoft", null, null);
			ba.raiseEvent2(null, true, "SHELL", false);
			ba.raiseEvent2(null, true, "CREATE", true, "com.tummosoft.main", ba);
		}
	}
    public static Class<?> getObject() {
		return main.class;
	}

 
    public static void main(String[] args) throws Exception{
        try {
            anywheresoftware.b4a.keywords.Common.LogDebug("Program started.");
            initializeProcessGlobals();
            ba.raiseEvent(null, "appstart", (Object)args);
        } catch (Throwable t) {
			BA.printException(t, true);
		
        } finally {
            anywheresoftware.b4a.keywords.Common.LogDebug("Program terminated (StartMessageLoop was not called).");
        }
    }


private static boolean processGlobalsRun;
public static void initializeProcessGlobals() {
    
    if (main.processGlobalsRun == false) {
	    main.processGlobalsRun = true;
		try {
		        		
        } catch (Exception e) {
			throw new RuntimeException(e);
		}
    }
}public static anywheresoftware.b4a.keywords.Common __c = null;
public static xsocket.server.xServerSockets _server = null;
public static String  _appstart(String[] _args) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(ba, "appstart", false))
	 {return ((String) Debug.delegate(ba, "appstart", new Object[] {_args}));}
RDebugUtils.currentLine=65536;
 //BA.debugLineNum = 65536;BA.debugLine="Sub AppStart (Args() As String)";
RDebugUtils.currentLine=65541;
 //BA.debugLineNum = 65541;BA.debugLine="server.Initialize(\"server\", \"ws\")";
_server.Initialize(ba,"server","ws");
RDebugUtils.currentLine=65542;
 //BA.debugLineNum = 65542;BA.debugLine="server.SetCharset(\"UTF-8\")";
_server.SetCharset("UTF-8");
RDebugUtils.currentLine=65543;
 //BA.debugLineNum = 65543;BA.debugLine="server.EnablePathListener(True)";
_server.EnablePathListener(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=65544;
 //BA.debugLineNum = 65544;BA.debugLine="server.RequestTimeout(5000)";
_server.RequestTimeout((int) (5000));
RDebugUtils.currentLine=65545;
 //BA.debugLineNum = 65545;BA.debugLine="server.Start(8602)";
_server.Start((int) (8602));
RDebugUtils.currentLine=65547;
 //BA.debugLineNum = 65547;BA.debugLine="StartMessageLoop";
anywheresoftware.b4a.keywords.Common.StartMessageLoop(ba);
RDebugUtils.currentLine=65550;
 //BA.debugLineNum = 65550;BA.debugLine="End Sub";
return "";
}
public static String  _server_onconnected(xsocket.server.xSession _session) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(ba, "server_onconnected", false))
	 {return ((String) Debug.delegate(ba, "server_onconnected", new Object[] {_session}));}
RDebugUtils.currentLine=131072;
 //BA.debugLineNum = 131072;BA.debugLine="Sub server_OnConnected(session As xSession)";
RDebugUtils.currentLine=131073;
 //BA.debugLineNum = 131073;BA.debugLine="Log(\"Server connected: \" & session.localAddress)";
anywheresoftware.b4a.keywords.Common.LogImpl("6131073","Server connected: "+BA.ObjectToString(_session.localAddress()),0);
RDebugUtils.currentLine=131075;
 //BA.debugLineNum = 131075;BA.debugLine="End Sub";
return "";
}
public static String  _server_onerror(xsocket.server.xSession _session,String _error) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(ba, "server_onerror", false))
	 {return ((String) Debug.delegate(ba, "server_onerror", new Object[] {_session,_error}));}
RDebugUtils.currentLine=262144;
 //BA.debugLineNum = 262144;BA.debugLine="Sub server_OnError(session As xSession, error As S";
RDebugUtils.currentLine=262146;
 //BA.debugLineNum = 262146;BA.debugLine="End Sub";
return "";
}
public static String  _server_onmessage(xsocket.server.xSession _session,xsocket.server.xMessage _message) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(ba, "server_onmessage", false))
	 {return ((String) Debug.delegate(ba, "server_onmessage", new Object[] {_session,_message}));}
xsocket.server.xMessage _msg = null;
xsocket.server.xEntityDefault _entry = null;
RDebugUtils.currentLine=196608;
 //BA.debugLineNum = 196608;BA.debugLine="Sub server_OnMessage(session As xSession, message";
RDebugUtils.currentLine=196609;
 //BA.debugLineNum = 196609;BA.debugLine="Log(message.event)";
anywheresoftware.b4a.keywords.Common.LogImpl("6196609",_message.event(),0);
RDebugUtils.currentLine=196610;
 //BA.debugLineNum = 196610;BA.debugLine="Log(message.isSubscribe)";
anywheresoftware.b4a.keywords.Common.LogImpl("6196610",BA.ObjectToString(_message.isSubscribe()),0);
RDebugUtils.currentLine=196611;
 //BA.debugLineNum = 196611;BA.debugLine="If message.isSubscribe Then";
if (_message.isSubscribe()) { 
RDebugUtils.currentLine=196612;
 //BA.debugLineNum = 196612;BA.debugLine="Dim msg As xMessage = message.Message";
_msg = new xsocket.server.xMessage();
_msg = (xsocket.server.xMessage) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new xsocket.server.xMessage(), (org.noear.socketd.transport.core.Message)(_message.getMessage()));
RDebugUtils.currentLine=196614;
 //BA.debugLineNum = 196614;BA.debugLine="Dim entry As xEntityDefault = msg.entity";
_entry = new xsocket.server.xEntityDefault();
_entry = (xsocket.server.xEntityDefault) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new xsocket.server.xEntityDefault(), (org.noear.socketd.transport.core.entity.EntityDefault)(_msg.entity()));
RDebugUtils.currentLine=196615;
 //BA.debugLineNum = 196615;BA.debugLine="Log(\"contet=\" & entry.dataAsString)";
anywheresoftware.b4a.keywords.Common.LogImpl("6196615","contet="+_entry.dataAsString(),0);
 };
RDebugUtils.currentLine=196622;
 //BA.debugLineNum = 196622;BA.debugLine="End Sub";
return "";
}
}