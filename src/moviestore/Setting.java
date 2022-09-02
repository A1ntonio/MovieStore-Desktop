/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moviestore;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JColorChooser;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import say.swing.JFontChooser;

/**
 *
 * @author user
 */
public class Setting extends javax.swing.JFrame {

    String name;
    File f1;
    FileInputStream fis;
    String image_fullPath;
    ImageIcon image;
    ButtonGroup group;
    int selectedLook;
    String selectedLookAndFeel = "com.jtattoo.plaf.noire.NoireLookAndFeel";
    JFrame frame;
    String look;
    JList[] lists;
    Font defaultFont;
    Color defaultForegroundColor, defaultBackgroundColor;
    String fontFamily;
    int fontStyle;
    int fontSize;
    int foregroundR;
    int foregroundB;
    int foregroundG;
    int backgroundR;
    int backgroundB;
    int backgroundG;
    String fontFamilyC;
    int fontStyleC;
    int fontSizeC;
    int foregroundRC;
    int foregroundBC;
    int foregroundGC;
    int backgroundRC;
    int backgroundBC;
    int backgroundGC;
    int defaultValue = 1;
    int state = 1;
    
    Connection conn = (Connection) Connectivity.openConnection();
    PreparedStatement stmt;
    
    public Setting(JFrame frame,String look, JList[] lists, Font defaultFont, Color defaultForegrounColor, Color defaultBackgroundColor) {
        this.frame = frame;
        this.look = look;
        this.lists = lists;
        this.defaultFont = defaultFont;
        this.defaultBackgroundColor = defaultBackgroundColor;
        this.defaultForegroundColor = defaultForegroundColor;
        
        try {
            this.stmt = conn.prepareStatement("select * from setting");
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                if(rs.getRow()>0){
                    selectedLookAndFeel = rs.getString("lookAndFeel");
                fontFamily = rs.getString("fontFamily");
                fontFamilyC = rs.getString("fontFamily");
                fontSize = rs.getInt("fontSize");
                fontSizeC = rs.getInt("fontSize");
                fontStyle = rs.getInt("fontStyle");
                fontStyleC = rs.getInt("fontStyle");
                foregroundR = rs.getInt("foregroundR");
                foregroundRC = rs.getInt("foregroundR");
                foregroundB = rs.getInt("foregroundB");
                foregroundBC = rs.getInt("foregroundB");
                foregroundG = rs.getInt("foregroundG");
                foregroundGC = rs.getInt("foregroundG");
                backgroundR = rs.getInt("backgroundR");
                backgroundRC = rs.getInt("backgroundR");
                backgroundB = rs.getInt("backgroundB");
                backgroundBC = rs.getInt("backgroundB");
                backgroundG = rs.getInt("backgroundG");
                backgroundGC = rs.getInt("backgroundG");
                defaultValue = rs.getInt("default");
                state = rs.getInt("state");
                }
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
        initComponents();
        setLocationRelativeTo(null);
        
        
            switch (selectedLookAndFeel) {
                case "com.jtattoo.plaf.noire.NoireLookAndFeel":
                    jRadioButton1.setSelected(true);
                    break;
                case "com.jtattoo.plaf.acryl.AcrylLookAndFeel":
                    jRadioButton2.setSelected(true);
                    break;
                case "com.jtattoo.plaf.aero.AeroLookAndFeel":
                    jRadioButton3.setSelected(true);
                    break;
                default:
                    jRadioButton4.setSelected(true);
                    break;
            }
        if(defaultValue == 0){
            fontField.setText(fontFamily+" "+String.valueOf(fontStyle)+" "+String.valueOf(fontSize));
            foregroundField.setText("["+foregroundR+","+foregroundG+","+foregroundB+"]");
            foregroundField.setForeground(new Color(foregroundR,foregroundG,foregroundB));
            backgroundField.setText("["+backgroundR+","+backgroundG+","+backgroundB+"]");
            backgroundField.setForeground(foregroundField.getForeground());
            backgroundField.setBackground(new Color(backgroundR,backgroundG,backgroundB));
            jCheckBox1.setSelected(false);
        }
        else{
            jCheckBox1.setSelected(true);
        }
        
        if(state == 1){
            jToggleButton1.setSelected(true);
        }else{
            jToggleButton1.setSelected(false);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        fontField = new javax.swing.JTextField();
        foregroundField = new javax.swing.JTextField();
        backgroundField = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jCheckBox1 = new javax.swing.JCheckBox();
        jPanel4 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jToggleButton1 = new javax.swing.JToggleButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Setting");
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/moviestore/Icons/folder_movies_icon_7.png")).getImage());
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        File file1 = new File("Themes/Acryl.png");
        image_fullPath = file1.getAbsolutePath();
        name = file1.getName();
        try {

            f1 = file1;
            fis = new FileInputStream(f1);
            try {
                BufferedImage bi = ImageIO.read(fis);
                Image scaledImage = bi.getScaledInstance(182, 117, Image.SCALE_SMOOTH);
                image = new ImageIcon(scaledImage);
                jLabel1.setIcon(image);
            } catch (IOException ex) {
                Logger.getLogger(Add_or_edit.class.getName()).log(Level.SEVERE, null, ex);
            }} catch (FileNotFoundException ex) {
                Logger.getLogger(Add_or_edit.class.getName()).log(Level.SEVERE, null, ex);
            }
            jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
            jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    jLabel1MouseClicked(evt);
                }
            });

            File file2 = new File("Themes/Aero.png");
            image_fullPath = file2.getAbsolutePath();
            name = file2.getName();
            try {

                f1 = file2;
                fis = new FileInputStream(f1);
                try {
                    BufferedImage bi = ImageIO.read(fis);
                    Image scaledImage = bi.getScaledInstance(182, 117, Image.SCALE_SMOOTH);
                    image = new ImageIcon(scaledImage);
                    jLabel2.setIcon(image);
                } catch (IOException ex) {
                    Logger.getLogger(Add_or_edit.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Add_or_edit.class.getName()).log(Level.SEVERE, null, ex);
            }
            jLabel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
            jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    jLabel2MouseClicked(evt);
                }
            });

            File file3 = new File("Themes/McWin.png");
            image_fullPath = file3.getAbsolutePath();
            name = file3.getName();
            try{
                f1 = file3;
                fis = new FileInputStream(f1);
                try {
                    BufferedImage bi = ImageIO.read(fis);
                    Image scaledImage = bi.getScaledInstance(182, 117, Image.SCALE_SMOOTH);
                    image = new ImageIcon(scaledImage);
                    jLabel3.setIcon(image);
                } catch (IOException ex) {
                    Logger.getLogger(Add_or_edit.class.getName()).log(Level.SEVERE, null, ex);
                }} catch (FileNotFoundException ex) {
                    Logger.getLogger(Add_or_edit.class.getName()).log(Level.SEVERE, null, ex);
                }
                jLabel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
                jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
                    public void mouseClicked(java.awt.event.MouseEvent evt) {
                        jLabel3MouseClicked(evt);
                    }
                });

                File file = new File("Themes/noire.png");
                image_fullPath = file.getAbsolutePath();
                try{
                    f1 = new File(file.getPath());
                    fis = new FileInputStream(f1);
                    try{
                        BufferedImage bi = ImageIO.read(fis);
                        Image scaledImage = bi.getScaledInstance(182, 117, Image.SCALE_SMOOTH);
                        image = new ImageIcon(scaledImage);
                        jLabel4.setIcon(image);
                    }catch (IOException e){

                    }}catch (FileNotFoundException ex) {
                        Logger.getLogger(Add_or_edit.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    jLabel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());
                    jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
                        public void mouseClicked(java.awt.event.MouseEvent evt) {
                            jLabel4MouseClicked(evt);
                        }
                    });

                    jRadioButton1.setText("Noire Look And Feel");
                    jRadioButton1.addItemListener(new java.awt.event.ItemListener() {
                        public void itemStateChanged(java.awt.event.ItemEvent evt) {
                            jRadioButton1ItemStateChanged(evt);
                        }
                    });

                    jRadioButton2.setText("Acryl Look And Feel");
                    jRadioButton2.addItemListener(new java.awt.event.ItemListener() {
                        public void itemStateChanged(java.awt.event.ItemEvent evt) {
                            jRadioButton2ItemStateChanged(evt);
                        }
                    });

                    jRadioButton3.setText("Aero Look And Feel");
                    jRadioButton3.addItemListener(new java.awt.event.ItemListener() {
                        public void itemStateChanged(java.awt.event.ItemEvent evt) {
                            jRadioButton3ItemStateChanged(evt);
                        }
                    });

                    jRadioButton4.setText("McWin Look And Feel");
                    jRadioButton4.addItemListener(new java.awt.event.ItemListener() {
                        public void itemStateChanged(java.awt.event.ItemEvent evt) {
                            jRadioButton4ItemStateChanged(evt);
                        }
                    });

                    jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

                    jLabel5.setText("Lists Font : ");

                    jLabel6.setText("Lists Foreground : ");

                    jLabel7.setText("Lists Background :");

                    jButton3.setText("...");
                    jButton3.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                            jButton3ActionPerformed(evt);
                        }
                    });

                    jButton4.setText("...");
                    jButton4.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                            jButton4ActionPerformed(evt);
                        }
                    });

                    jButton5.setText("...");
                    jButton5.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                            jButton5ActionPerformed(evt);
                        }
                    });

                    jCheckBox1.setText("Default");
                    jCheckBox1.addItemListener(new java.awt.event.ItemListener() {
                        public void itemStateChanged(java.awt.event.ItemEvent evt) {
                            jCheckBox1ItemStateChanged(evt);
                        }
                    });

                    javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
                    jPanel3.setLayout(jPanel3Layout);
                    jPanel3Layout.setHorizontalGroup(
                        jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGap(26, 26, 26)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jCheckBox1)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(fontField, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
                                        .addComponent(foregroundField)
                                        .addComponent(backgroundField))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, Short.MAX_VALUE)
                                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))))
                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    );
                    jPanel3Layout.setVerticalGroup(
                        jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGap(17, 17, 17)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel5)
                                .addComponent(fontField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel6)
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(foregroundField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel7)
                                .addComponent(backgroundField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(20, 20, 20)
                            .addComponent(jCheckBox1)
                            .addContainerGap())
                    );

                    jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

                    jLabel8.setText("Notification Sound :");

                    jToggleButton1.setSelected(true);
                    jToggleButton1.setText("On");
                    jToggleButton1.addItemListener(new java.awt.event.ItemListener() {
                        public void itemStateChanged(java.awt.event.ItemEvent evt) {
                            jToggleButton1ItemStateChanged(evt);
                        }
                    });
                    jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                            jToggleButton1ActionPerformed(evt);
                        }
                    });

                    javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
                    jPanel4.setLayout(jPanel4Layout);
                    jPanel4Layout.setHorizontalGroup(
                        jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addGap(20, 20, 20)
                            .addComponent(jLabel8)
                            .addGap(18, 18, 18)
                            .addComponent(jToggleButton1)
                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    );
                    jPanel4Layout.setVerticalGroup(
                        jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addGap(14, 14, 14)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel8)
                                .addComponent(jToggleButton1))
                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    );

                    javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
                    jPanel2.setLayout(jPanel2Layout);
                    jPanel2Layout.setHorizontalGroup(
                        jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(32, 32, 32)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addGap(6, 6, 6)
                                            .addComponent(jRadioButton1)))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addGap(6, 6, 6)
                                            .addComponent(jRadioButton2)))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addGap(6, 6, 6)
                                            .addComponent(jRadioButton3)))
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addGap(18, 18, 18)
                                            .addComponent(jRadioButton4))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addContainerGap(30, Short.MAX_VALUE))
                    );
                    jPanel2Layout.setVerticalGroup(
                        jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jRadioButton1)
                                .addComponent(jRadioButton2)
                                .addComponent(jRadioButton3)
                                .addComponent(jRadioButton4))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(0, 0, Short.MAX_VALUE))
                                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addContainerGap())
                    );

                    jTabbedPane1.addTab("Themes and Font and Notification", jPanel2);

                    jButton1.setText("Save");
                    jButton1.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                            jButton1ActionPerformed(evt);
                        }
                    });

                    jButton2.setText("Cancel");
                    jButton2.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                            jButton2ActionPerformed(evt);
                        }
                    });

                    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
                    jPanel1.setLayout(jPanel1Layout);
                    jPanel1Layout.setHorizontalGroup(
                        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jTabbedPane1)
                            .addContainerGap())
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(20, 20, 20))
                    );
                    jPanel1Layout.setVerticalGroup(
                        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jTabbedPane1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jButton2)
                                .addComponent(jButton1))
                            .addContainerGap())
                    );

                    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
                    getContentPane().setLayout(layout);
                    layout.setHorizontalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addContainerGap())
                    );
                    layout.setVerticalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addContainerGap())
                    );

                    pack();
                }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(defaultValue == 1){
            try {
                defaultFrameUI();
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                Logger.getLogger(Setting.class.getName()).log(Level.SEVERE, null, ex);
            }

        }else{
            int i = 0;
            while(i < lists.length){
                lists[i].setFont(new java.awt.Font(fontFamily, fontStyle, fontSize));
                lists[i].setForeground(new Color(foregroundR,foregroundG,foregroundB));
                lists[i].setBackground(new Color(backgroundR,backgroundG,backgroundB));
                SwingUtilities.updateComponentTreeUI(lists[i]);
                i++;
            }
        }
        
        try {
            PreparedStatement stmt1 = conn.prepareStatement("update setting set lookAndFeel = '"+selectedLookAndFeel+"', fontFamily = '"+fontFamily+"', fontStyle = "+fontStyle+", fontSize = "+fontSize+", foregroundR = "+foregroundR+", foregroundB = "+foregroundB+", foregroundG = "+foregroundG+", backgroundR = "+backgroundR+", backgroundB = "+backgroundB+", backgroundG = "+backgroundG+", default = "+defaultValue+", state = "+state+" where ID = 1");
            stmt1.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Setting.class.getName()).log(Level.SEVERE, null, ex);
        }
        
//        homelook(frame, selectedLookAndFeel);
        setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
//        homelook(frame, look);
        cancelClicked(frame, look);
        setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        
        group = new ButtonGroup();
        group.add(jRadioButton1);
        group.add(jRadioButton2);
        group.add(jRadioButton3);
        group.add(jRadioButton4);
    }//GEN-LAST:event_formWindowOpened

    private void jRadioButton1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jRadioButton1ItemStateChanged
        selectedLookAndFeel();
    }//GEN-LAST:event_jRadioButton1ItemStateChanged

    private void jRadioButton2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jRadioButton2ItemStateChanged
       selectedLookAndFeel();
    }//GEN-LAST:event_jRadioButton2ItemStateChanged

    private void jRadioButton3ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jRadioButton3ItemStateChanged
        selectedLookAndFeel();
    }//GEN-LAST:event_jRadioButton3ItemStateChanged

    private void jRadioButton4ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jRadioButton4ItemStateChanged
        selectedLookAndFeel();
    }//GEN-LAST:event_jRadioButton4ItemStateChanged

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        JFontChooser font = new JFontChooser();
                 font.setSelectedFont(new Font("Power Geez Unicode2", 0, 12));
        int retur = font.showDialog(jTabbedPane1);
        if(retur == JFontChooser.OK_OPTION){
            Font f = font.getSelectedFont();
            fontFamily = f.getFamily();
            fontStyle = f.getStyle();
            fontSize = f.getSize();
            fontField.setText(fontFamily+" "+String.valueOf(fontStyle)+" "+String.valueOf(fontSize));
            int i = 0;
            while(i < lists.length){
                lists[i].setFont(f);
                SwingUtilities.updateComponentTreeUI(lists[i]);
                i++;
            }
            
        }
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        Color color = JColorChooser.showDialog(this, "Select a color", lists[0].getForeground());
        foregroundR = color.getRed();
        foregroundG = color.getGreen();
        foregroundB = color.getBlue();
        foregroundField.setText("["+foregroundR+","+foregroundG+","+foregroundB+"]");
        foregroundField.setForeground(color);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        jRadioButton1.setSelected(true);
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
         jRadioButton2.setSelected(true);
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
         jRadioButton3.setSelected(true);
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
         jRadioButton4.setSelected(true);
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jCheckBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCheckBox1ItemStateChanged
        if(jCheckBox1.isSelected()){
            fontField.setEditable(false);
            backgroundField.setEditable(false);
            foregroundField.setEditable(false);
            jButton3.setEnabled(false);
            jButton4.setEnabled(false);
            jButton5.setEnabled(false);
            defaultValue = 1;
            
            try {
                defaultFrameUI();
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                Logger.getLogger(Setting.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            fontField.setEditable(true);
            backgroundField.setEditable(true);
            foregroundField.setEditable(true);
            jButton3.setEnabled(true);
            jButton4.setEnabled(true);
            jButton5.setEnabled(true);
            defaultValue = 0;
            homelook(frame, look);
        }
    }//GEN-LAST:event_jCheckBox1ItemStateChanged

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        cancelClicked(frame, look);
    }//GEN-LAST:event_formWindowClosed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        Color color = JColorChooser.showDialog(this, "Select a color", lists[0].getBackground());
        backgroundR = color.getRed();
        backgroundG = color.getGreen();
        backgroundB = color.getBlue();
        backgroundField.setText("["+backgroundR+","+backgroundG+","+backgroundB+"]");
        backgroundField.setForeground(foregroundField.getForeground());
        backgroundField.setBackground(color);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void jToggleButton1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jToggleButton1ItemStateChanged
         if(jToggleButton1.isSelected()){
            jToggleButton1.setText("ON");
            state = 1;
        }else{
            jToggleButton1.setText("OFF");
            state = 2;
        }
    }//GEN-LAST:event_jToggleButton1ItemStateChanged
 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField backgroundField;
    private javax.swing.JTextField fontField;
    private javax.swing.JTextField foregroundField;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JToggleButton jToggleButton1;
    // End of variables declaration//GEN-END:variables

    private void selectedLookAndFeel() {
        if(jRadioButton1.isSelected()){
            changeTheLookAndFeel("com.jtattoo.plaf.noire.NoireLookAndFeel");
            selectedLookAndFeel = "com.jtattoo.plaf.noire.NoireLookAndFeel";
            selectedLook = 0;
        }else if(jRadioButton2.isSelected()){
            selectedLook = 1;
            selectedLookAndFeel = "com.jtattoo.plaf.acryl.AcrylLookAndFeel";
            changeTheLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");
        }else if(jRadioButton3.isSelected()){
            selectedLook = 2;
            selectedLookAndFeel = "com.jtattoo.plaf.aero.AeroLookAndFeel";
            changeTheLookAndFeel("com.jtattoo.plaf.aero.AeroLookAndFeel");
        }else if(jRadioButton4.isSelected()){
            selectedLook = 3;
            selectedLookAndFeel = "com.jtattoo.plaf.mcwin.McWinLookAndFeel";
            changeTheLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
        }
    }

    private void changeTheLookAndFeel(String LookAndFeel) {
        try {
            UIManager.setLookAndFeel(LookAndFeel);
            SwingUtilities.updateComponentTreeUI(this);
            SwingUtilities.updateComponentTreeUI(frame);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Setting.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void homelook(JFrame frame, String selectedlook) {
       
            int i = 0;
            while(i < lists.length){
                lists[i].setFont(new java.awt.Font(fontFamilyC, fontStyleC, fontSizeC));
                lists[i].setForeground(new Color(foregroundRC,foregroundGC,foregroundBC));
                lists[i].setBackground(new Color(backgroundRC,backgroundGC,backgroundBC));
                SwingUtilities.updateComponentTreeUI(lists[i]);
                i++;
            }
        try {
            UIManager.setLookAndFeel(selectedlook);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Setting.class.getName()).log(Level.SEVERE, null, ex);
        }
        SwingUtilities.updateComponentTreeUI(frame);
    }

    private void defaultFrameUI() throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
        
        int i = 0;
            while(i < lists.length){
                lists[i].setFont(new java.awt.Font("Power Geez Unicode2", 0, 14));
                lists[i].setForeground(defaultForegroundColor);
                lists[i].setBackground(defaultBackgroundColor);
                SwingUtilities.updateComponentTreeUI(lists[i]);
                i++;
            }
            
    }

    private void cancelClicked(JFrame frame, String look) {
        int i = 0;
            while(i < lists.length){
                lists[i].setFont(defaultFont);
                lists[i].setForeground(defaultForegroundColor);
                lists[i].setBackground(defaultBackgroundColor);
                SwingUtilities.updateComponentTreeUI(lists[i]);
                i++;
            }
            
            try {
            UIManager.setLookAndFeel(look);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Setting.class.getName()).log(Level.SEVERE, null, ex);
        }
        SwingUtilities.updateComponentTreeUI(frame);
    }
}
