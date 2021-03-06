/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package B4;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.nio.CharBuffer;
import javax.swing.JOptionPane;
import java.io.*;
import java.net.*;
import javax.swing.*;
import sun.awt.WindowClosingSupport;

/**
 *
 * @author TienDat
 */
public class frmChat extends javax.swing.JFrame implements Readable{
    private InetAddress group;
    private int port;
    private String nick;
    private Thread mythread;
    private MulticastSocket socket;
    private DatagramPacket truyen, nhan;
    /**
     * Creates new form frmChat
     */
    public frmChat() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtgroup = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtport = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtnick = new javax.swing.JTextField();
        btnketnoi = new javax.swing.JButton();
        btndong = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtnoidung = new javax.swing.JTextPane();
        btnsend = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtChat = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Nhập địa chỉ multicast");

        jLabel2.setText("port");

        jLabel3.setText("Nick");

        btnketnoi.setBackground(new java.awt.Color(153, 255, 153));
        btnketnoi.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnketnoi.setText("Kết nối");
        btnketnoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnketnoiActionPerformed(evt);
            }
        });

        btndong.setBackground(new java.awt.Color(255, 153, 153));
        btndong.setText("Đóng");
        btndong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndongActionPerformed(evt);
            }
        });

        jScrollPane2.setViewportView(txtnoidung);

        btnsend.setBackground(new java.awt.Color(255, 204, 204));
        btnsend.setText("Send");
        btnsend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsendActionPerformed(evt);
            }
        });

        txtChat.setColumns(20);
        txtChat.setRows(5);
        jScrollPane3.setViewportView(txtChat);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btnketnoi, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(jLabel1))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(63, 63, 63)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel2))))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtgroup, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
                                .addComponent(txtport, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtnick))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(197, 197, 197)
                        .addComponent(btndong)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                        .addComponent(btnsend, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtgroup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(txtport, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtnick, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(36, 36, 36)
                        .addComponent(btnketnoi))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btndong))
                    .addComponent(jScrollPane2)
                    .addComponent(btnsend, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE))
                .addGap(23, 23, 23))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnketnoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnketnoiActionPerformed
        // kết nối
        if (btnketnoi.getText().equals("Kết nối")) {
            //Khi nhấn nút kết nối
            btnketnoi.setText("Ngắt kết nối");
            //chuyển nút kết nối thành nút ngắt kết nối
            txtChat.setEnabled(true);
            txtnoidung.setEnabled(true);
            btnsend.setEnabled(true);
            txtgroup.setEnabled(false);
            txtport.setEnabled(false);
            txtnick.setEnabled(false);
            try {
                group = InetAddress.getByName(txtgroup.getText());
                if (group.isMulticastAddress()) {
                    //Kiểm tra xem địa chỉ nhóm có phải địa chỉ multicast hay không
                    nick = txtnick.getText();
                    port = Integer.parseInt(txtport.getText());
                    if (mythread == null) {
                        //Tạo ra và thiết lập ban đầu cho các đối tượng mạng
                        socket = new MulticastSocket(port);
                        socket.setTimeToLive(1);
                        //Thiết lập đường đi cho gói tin
                        socket.joinGroup(group);
                        //Đăng ký với router là chương trình máy mình đăng ký vào nhóm group
                        truyen = new DatagramPacket(new byte[1], 1, group, port);
                        nhan = new DatagramPacket(new byte[65507], 65507);
                        //Tạo ra thread xử lý dữ liệu truyền đến
                        mythread = new Thread();
                        mythread.start();
                        //Bắt đầu nhận dữ liệu - Lúc này hàm run sẽ dược gọi để thực thi
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Địa chỉ nhập sai rồi!!");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        } else {
            //Sự kiện nhấn nút ngắt kết nối
            txtChat.setEnabled(false);
            txtnoidung.setEnabled(false);
            btnsend.setEnabled(false);
            txtgroup.setEnabled(true);
            txtport.setEnabled(true);
            txtnick.setEnabled(true);
            btnketnoi.setText("Kết nối");
            //chuyển nút ngắt kết nối thành nút kết nối
            if (mythread != null) {
                mythread.interrupt();
//dừng việc nhận dữ liệu
                mythread = null;
                try {
                    socket.leaveGroup(group);//Ra khỏi group
                } catch (IOException e) {
                }
                socket.close();
            }
        }     
    }//GEN-LAST:event_btnketnoiActionPerformed

    private void btndongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndongActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_btndongActionPerformed

    private void btnsendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsendActionPerformed
        // send
        try {
            byte[] utf=(nick+": "+txtnoidung.getText()).getBytes("UTF8");
            truyen.setData(utf);
            truyen.setLength(utf.length);
            socket.send(truyen);
            txtnoidung.setText("");
        } catch (Exception e) {
            if(mythread!=null){
                txtChat.append(e+"\n");
                txtnoidung.setVisible(false);
                this.validate();
                if(mythread!=Thread.currentThread()){
                    mythread.interrupt();
                }
                mythread = null;
                try {
                    socket.leaveGroup(group);
                } catch (Exception ex) {
                    socket.close();                   
                }
            }
        }
    }//GEN-LAST:event_btnsendActionPerformed

    //run
    public void run() {
        try {
            while (!Thread.interrupted()) {
                nhan.setLength(nhan.getData().length);
                socket.receive(nhan);
                String message = new String(nhan.getData(), 0, nhan.getLength(), "UTF8");
                txtChat.append(message + "\n");
            }
        } catch (Exception e) {
            if(mythread != null){
                txtChat.append(e+"\n");
                txtnoidung.setVisible(false);
                this.validate();
                if(mythread!=Thread.currentThread()){
                    mythread.interrupt();
                }
                mythread = null;
                try {
                    socket.leaveGroup(group);
                } catch (Exception ex) {
                    socket.close();
                }
            }
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmChat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmChat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmChat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmChat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmChat().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btndong;
    private javax.swing.JButton btnketnoi;
    private javax.swing.JButton btnsend;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea txtChat;
    private javax.swing.JTextField txtgroup;
    private javax.swing.JTextField txtnick;
    private javax.swing.JTextPane txtnoidung;
    private javax.swing.JTextField txtport;
    // End of variables declaration//GEN-END:variables

    @Override
    public int read(CharBuffer cb) throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
