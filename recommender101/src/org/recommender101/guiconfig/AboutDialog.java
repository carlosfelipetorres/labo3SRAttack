package org.recommender101.guiconfig;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;


public class AboutDialog extends javax.swing.JFrame {

    /**
     * Creates new form AboutDialog
     */
    public AboutDialog() {
        try {
			initComponents();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     * @throws IOException 
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() throws IOException {

        lblHeader = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblTULogo = new javax.swing.JLabel();
        lblFILogo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("About Recommender101");
        setMaximumSize(new java.awt.Dimension(490, 320));
        setMinimumSize(new java.awt.Dimension(490, 320));
        setName("frmAboutDialog"); // NOI18N
        setPreferredSize(new java.awt.Dimension(490, 320));
        setResizable(false);
        setBackground(Color.WHITE);
        getContentPane().setBackground(Color.white);
        
        // Position the window in the middle of the screen
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();        
        setLocation(d.width / 2 - 490 / 2, d.height / 2 - 320 / 2);

        lblHeader.setText("jLabel1");
        lblHeader.setMaximumSize(new java.awt.Dimension(480, 70));
        lblHeader.setMinimumSize(new java.awt.Dimension(480, 70));
        lblHeader.setPreferredSize(new java.awt.Dimension(480, 70));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("About Recommender101");

        jLabel3.setText("GUI version: 0.1 alpha");

        jLabel4.setText("<html>Technical University of Dortmund <br>Department of Computer Science   <br><br>Computer Science XIII <br>Prof. Dr. Dietmar Jannach <br>dietmar.jannach@tu-dortmund.de");

        lblTULogo.setText("jLabel5");

        lblFILogo.setText("jLabel6");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 2, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblFILogo, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblTULogo, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblFILogo, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblTULogo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addGap(42, 42, 42)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 47, Short.MAX_VALUE))
        );

        // Set images
        BufferedImage pic = ImageIO.read(new File("images/rec101header.png"));
        lblHeader.setIcon(new ImageIcon( pic ));
        
        pic = ImageIO.read(new File("images/tu_logo.png"));
        lblTULogo.setIcon(new ImageIcon( pic ));
        
        pic = ImageIO.read(new File("images/fi_logo.png"));
        lblFILogo.setIcon(new ImageIcon( pic ));
        
        pack();
    }// </editor-fold>

   
    // Variables declaration - do not modify
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel lblFILogo;
    private javax.swing.JLabel lblHeader;
    private javax.swing.JLabel lblTULogo;
    // End of variables declaration
}
