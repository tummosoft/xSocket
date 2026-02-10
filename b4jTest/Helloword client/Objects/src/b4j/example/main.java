package b4j.example;

import anywheresoftware.b4a.debug.*;

import anywheresoftware.b4a.BA;

public class main extends javafx.application.Application{
public static main mostCurrent = new main();

public static BA ba;
static {
		ba = new  anywheresoftware.b4a.shell.ShellBA("b4j.example", "b4j.example.main", null);
		ba.loadHtSubs(main.class);
        if (ba.getClass().getName().endsWith("ShellBA")) {
			anywheresoftware.b4a.shell.ShellBA.delegateBA = new anywheresoftware.b4j.objects.FxBA("b4j.example", null, null);
			ba.raiseEvent2(null, true, "SHELL", false);
			ba.raiseEvent2(null, true, "CREATE", true, "b4j.example.main", ba);
		}
	}
    public static Class<?> getObject() {
		return main.class;
	}

 
    public static void main(String[] args) {
    	launch(args);
    }
    public void start (javafx.stage.Stage stage) {
        try {
            if (!false)
                System.setProperty("prism.lcdtext", "false");
            anywheresoftware.b4j.objects.FxBA.application = this;
		    anywheresoftware.b4a.keywords.Common.setDensity(javafx.stage.Screen.getPrimary().getDpi());
            anywheresoftware.b4a.keywords.Common.LogDebug("Program started.");
            initializeProcessGlobals();
            anywheresoftware.b4j.objects.Form frm = new anywheresoftware.b4j.objects.Form();
            frm.initWithStage(ba, stage, 600, 600);
            ba.raiseEvent(null, "appstart", frm, (String[])getParameters().getRaw().toArray(new String[0]));
        } catch (Throwable t) {
            BA.printException(t, true);
            System.exit(1);
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
public static anywheresoftware.b4j.objects.JFX _fx = null;
public static anywheresoftware.b4j.objects.Form _mainform = null;
public static anywheresoftware.b4a.objects.B4XViewWrapper.XUI _xui = null;
public static anywheresoftware.b4a.objects.B4XViewWrapper _button1 = null;
public static xsocket.client.xClientSocket _tcpsocket = null;
public static String  _appstart(anywheresoftware.b4j.objects.Form _form1,String[] _args) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(ba, "appstart", false))
	 {return ((String) Debug.delegate(ba, "appstart", new Object[] {_form1,_args}));}
RDebugUtils.currentLine=65536;
 //BA.debugLineNum = 65536;BA.debugLine="Sub AppStart (Form1 As Form, Args() As String)";
RDebugUtils.currentLine=65537;
 //BA.debugLineNum = 65537;BA.debugLine="MainForm = Form1";
_mainform = _form1;
RDebugUtils.currentLine=65538;
 //BA.debugLineNum = 65538;BA.debugLine="MainForm.RootPane.LoadLayout(\"Layout1\")";
_mainform.getRootPane().LoadLayout(ba,"Layout1");
RDebugUtils.currentLine=65539;
 //BA.debugLineNum = 65539;BA.debugLine="MainForm.Show";
_mainform.Show();
RDebugUtils.currentLine=65541;
 //BA.debugLineNum = 65541;BA.debugLine="tcpSocket.Initialize(\"tcpSocket\")";
_tcpsocket.Initialize(ba,"tcpSocket");
RDebugUtils.currentLine=65542;
 //BA.debugLineNum = 65542;BA.debugLine="tcpSocket.Connect(\"ws://127.0.0.1:8602/?u=a&p=2\")";
_tcpsocket.Connect("ws://127.0.0.1:8602/?u=a&p=2");
RDebugUtils.currentLine=65543;
 //BA.debugLineNum = 65543;BA.debugLine="End Sub";
return "";
}
public static String  _button1_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(ba, "button1_click", false))
	 {return ((String) Debug.delegate(ba, "button1_click", null));}
xsocket.client.xClientSession _clientsession = null;
xsocket.server.xStringEntity _msg = null;
RDebugUtils.currentLine=131072;
 //BA.debugLineNum = 131072;BA.debugLine="Sub Button1_Click";
RDebugUtils.currentLine=131074;
 //BA.debugLineNum = 131074;BA.debugLine="Dim clientSession As xClientSession = tcpSocket.C";
_clientsession = new xsocket.client.xClientSession();
_clientsession = (xsocket.client.xClientSession) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new xsocket.client.xClientSession(), (org.noear.socketd.transport.client.ClientSession)(_tcpsocket.getClientSession()));
RDebugUtils.currentLine=131075;
 //BA.debugLineNum = 131075;BA.debugLine="Log(\"Session=\" & clientSession.sessionId)";
anywheresoftware.b4a.keywords.Common.LogImpl("6131075","Session="+_clientsession.sessionId(),0);
RDebugUtils.currentLine=131077;
 //BA.debugLineNum = 131077;BA.debugLine="Dim msg As xStringEntity";
_msg = new xsocket.server.xStringEntity();
RDebugUtils.currentLine=131078;
 //BA.debugLineNum = 131078;BA.debugLine="msg.Initialize(\"Hello how are you\")";
_msg.Initialize(ba,"Hello how are you");
RDebugUtils.currentLine=131080;
 //BA.debugLineNum = 131080;BA.debugLine="clientSession.sendAndSubscribe(\"reply\",  msg)";
_clientsession.sendAndSubscribe("reply",(org.noear.socketd.transport.core.Entity)(_msg.getObject()));
RDebugUtils.currentLine=131082;
 //BA.debugLineNum = 131082;BA.debugLine="End Sub";
return "";
}
public static String  _tcpsocket_onconnected(xsocket.server.xSession _session) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(ba, "tcpsocket_onconnected", false))
	 {return ((String) Debug.delegate(ba, "tcpsocket_onconnected", new Object[] {_session}));}
RDebugUtils.currentLine=196608;
 //BA.debugLineNum = 196608;BA.debugLine="Sub tcpSocket_OnConnected(session As xSession)";
RDebugUtils.currentLine=196609;
 //BA.debugLineNum = 196609;BA.debugLine="Log(\"Session=\" & session.sessionId)";
anywheresoftware.b4a.keywords.Common.LogImpl("6196609","Session="+_session.sessionId(),0);
RDebugUtils.currentLine=196611;
 //BA.debugLineNum = 196611;BA.debugLine="End Sub";
return "";
}
}