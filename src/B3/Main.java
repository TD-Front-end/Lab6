/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package B3;

import static B3.frmClientChat.PORT;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 *
 * @author TienDat
 */
public class Main {
    public static void main(String[] args) {
        frmClientChat app = new frmClientChat();
        app.setVisible(true);
        DatagramSocket socket;
        String strContent="";
        try {
            byte []buffer = new byte[1024];
            socket = new DatagramSocket(PORT);
            boolean ktFinish = false;
            DatagramPacket receivePacket;
            String stReceive;
            while(ktFinish!=true){
                receivePacket = new DatagramPacket(buffer, buffer.length);
                socket.receive(receivePacket);
                stReceive = new String(receivePacket.getData(), 0, receivePacket.getLength());
                strContent = app.getContentChat();
                strContent += "Nhan: " + stReceive + "\n";
                app.setContentChat(strContent);
                if(stReceive.equals("end") || strContent.equals("end")){
                    ktFinish = true;
                }
            }
        } catch (Exception e) {
        }
    }
    
}
