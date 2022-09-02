
package moviestore;

import java.awt.Cursor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;


public class Splash extends javax.swing.JFrame {

    public Splash() {
        
        initComponents();
        setLocationRelativeTo(null);
                                
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/moviestore/Icons/folder_movies_icon_7.png")).getImage());
        setUndecorated(true);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dutch801 Rm BT", 1, 70)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 153, 153));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText(". . . .");

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Infinity Movie Store v1.0");

        jLabel3.setFont(new java.awt.Font("Dialog", 2, 13)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Save time. Make Customer Happy!!!");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 432, Short.MAX_VALUE)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
    }//GEN-LAST:event_formWindowOpened

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
                    UIManager.setLookAndFeel("com.jtattoo.plaf.noire.NoireLookAndFeel");
                    
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        Splash splash = new Splash();
            splash.setVisible(true);
        try {
            splash.showSplash();
        } catch (InterruptedException ex) {
            Logger.getLogger(Splash.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }

    public void showSplash() throws InterruptedException {
        int i = 0;
                                while(i<=100000){
            switch (i) {
                case 0:
                    jLabel1.setText(".");
                    Thread.sleep(100);
                    break;
                case 1000:
                    jLabel1.setText("..");
                    Thread.sleep(100);
                    break;
                case 2000:
                    jLabel1.setText("...");
                    Thread.sleep(100);
                    break;
                case 3000:
                    jLabel1.setText("....");
                    Thread.sleep(100);
                    break;
                case 4000:
                    jLabel1.setText(".");
                    Thread.sleep(100);
                    break;
                case 5000:
                    jLabel1.setText("..");
                    Thread.sleep(100);
                    break;
                case 6000:
                    jLabel1.setText("...");
                    Thread.sleep(100);
                    break;
                case 7000:
                    jLabel1.setText("....");
                    Thread.sleep(100);
                    break;
                    case 8000:
                    jLabel1.setText(".");
                    Thread.sleep(100);
                    break;
                    case 9000:
                    jLabel1.setText("..");
                    Thread.sleep(100);
                    break;
                    case 10000:
                    jLabel1.setText("...");
                    Thread.sleep(100);
                    break;
                    case 15000:
                    jLabel1.setText(".");
                    Thread.sleep(100);
                    break;
                case 20000:
                    jLabel1.setText("..");
                    Thread.sleep(100);
                    break;
                case 25000:
                    jLabel1.setText("...");
                    Thread.sleep(100);
                    break;
                case 30000:
                    jLabel1.setText("....");
                    Thread.sleep(100);
                    break;
                case 35000:
                    jLabel1.setText(".");
                    Thread.sleep(100);
                    break;
                case 40000:
                    jLabel1.setText("..");
                    Thread.sleep(100);
                    break;
                case 45000:
                    jLabel1.setText("...");
                    Thread.sleep(100);
                    break;
                case 50000:
                    jLabel1.setText("....");
                    Thread.sleep(100);
                    break;
                    case 55000:
                    jLabel1.setText(".");
                    Thread.sleep(100);
                    break;
                    case 60000:
                    jLabel1.setText("..");
                    Thread.sleep(100);
                    break;
                    case 70000:
                    jLabel1.setText("...");
                    Thread.sleep(100);
                    break;
                    case 75000:
                    jLabel1.setText("....");
                    Thread.sleep(100);
                    break;
                    case 80000:
                    jLabel1.setText(".");
                    Thread.sleep(100);
                    break;
                    case 85000:
                    jLabel1.setText("..");
                    Thread.sleep(100);
                    break;
                    case 90000:
                    jLabel1.setText("...");
                    Thread.sleep(100);
                    break;
                    case 95000:
                    jLabel1.setText("....");
                    Thread.sleep(100);
                    break;
                    case 100000:
                    jLabel1.setText(".");
                    Thread.sleep(100);
                    break;
                default:
                    break;
            }
                                    i++;
                                }
        ExecutorService service = Executors.newFixedThreadPool(20);
                        service.submit(() -> {
                            try {
                                
                                Thread.sleep(8000);
                                setVisible(false);
                                
                            } catch (InterruptedException ex) {
                                Logger.getLogger(Splash.class.getName()).log(Level.SEVERE, null, ex);
                            }
        });
                        
                        
                        
                        Home home = new Home();
                        home.setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
