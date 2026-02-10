/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication2;

import java.io.IOException;
import org.noear.socketd.SocketD;
import org.noear.socketd.transport.core.Message;
import org.noear.socketd.transport.core.Session;
import org.noear.socketd.transport.core.entity.StringEntity;
import org.noear.socketd.transport.core.listener.SimpleListener;

/**
 *
 * @author Admin
 */
public class JavaApplication2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
         SocketD.createServer("sd:tcp")
                .config(c -> c.port(8602))
                .listen(new SimpleListener(){
                    @Override
                    public void onMessage(Session session, Message message) throws IOException {
                        System.out.println(message);

                        if(message.isRequest()){
                            session.replyEnd(message, new StringEntity("And you too."));
                        }
                    }
                })
                .start();
    }
    
}
