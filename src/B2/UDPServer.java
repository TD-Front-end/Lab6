/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package B2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author TienDat
 */
public class UDPServer {
    static final int PORT = 1234;
    private DatagramSocket socket = null;
    public UDPServer(){
        try {
            socket = new DatagramSocket(PORT);
            JOptionPane.showMessageDialog(null, "kết nối đến client thành công!");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Lỗi kết nối");
        }
    }
    //
    public void action(){
        InetAddress host = null;
        int port;
        String chuoi = "";
        try {
            System.out.println("Server đang lắng nghe...");
            while(true){
                DatagramPacket packet = receive();//nhận dữ liệu
                host = packet.getAddress();
                port = packet.getPort();
                chuoi = new String(packet.getData()).trim();//lây dữ liệu của client
                if(!chuoi.equals(""))
                {
                    Scanner sc = new Scanner(chuoi);
                    sc.useDelimiter("@");//cắt chuỗi theo ký tự @
                    int so1 = sc.nextInt();
                    String pheptoan = sc.next();
                    int so2 = sc.nextInt();
                    if(pheptoan.equals("+"))
                    {
                        chuoi = (so1+so2)+"";
                    }else if(pheptoan.equals("-"))
                    {
                        chuoi = (so1 - so2)+"";
                    }else if(pheptoan.equals("*"))
                    {
                        chuoi = (so1*so2)+"";
                    }else if(pheptoan.equals("/"))
                    {
                        chuoi = ((float)so1/so2)+"";
                    }
                    send(chuoi, host, port);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            socket.close();
        }
    }
    //send
    private void send(String chuoi, InetAddress host, int port) throws IOException{
        byte[] buffer = chuoi.getBytes();
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length, host, port);
        socket.send(packet);
    }
    //
    private DatagramPacket receive() throws IOException{
        byte[] buffer = new byte[65507];
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
        socket.receive(packet);
        return packet;
    }
    //
    public static void main(String[] args) {
        new UDPServer().action();
    }
}
