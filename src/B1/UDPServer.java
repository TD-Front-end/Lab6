/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package B1;

import com.sun.management.jmx.Trace;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 *
 * @author TienDat
 */
public class UDPServer {
    static  final int PORT = 1234;
    private DatagramSocket socket = null;
    public UDPServer(){
        try {
            
            socket = new DatagramSocket(PORT);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void action(){
        InetAddress host = null;
        int port;
        String chuoi="";
        try {
            System.out.println("Server đang lắng nghe!");
            while(true){
                DatagramPacket packet = receive();//nhận dữ liệu
                host = packet.getAddress();
                port = packet.getPort();
                chuoi = new String(packet.getData()).trim();
                chuoi = chuoi.toUpperCase();
                if(!chuoi.equals("")){
                    send(chuoi,host,port);//
               
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            socket.close();
        }
    }
    //send
    private void send(String chuoi, InetAddress host, int port)throws IOException{
        byte[] buffer = chuoi.getBytes();
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length,host, port);
        socket.send(packet);
    }
    //receive
    private DatagramPacket receive() throws IOException{
        byte[] bufer = new byte[65507];
        DatagramPacket packet = new DatagramPacket(bufer, bufer.length);
        socket.receive(packet);
        return packet;
    }
    //
    public static void main(String[] args) {
        new UDPServer().action();
    }
    
}
