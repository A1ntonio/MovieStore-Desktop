/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moviestore;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Image;
import java.awt.Point;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.embed.swing.JFXPanel;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.filechooser.FileSystemView;

/**
 *
 * @author user
 */
public class Home extends javax.swing.JFrame {

    /**
     * Creates new form Home
     */
    
    File[] oldListRoot = File.listRoots();
    String play_path;
    public String selection;
    int id;
    String totalSpace, free_space;
    String drivePath;
    String file_name;
    String sizes;
    int count = 0;
    File[] ep_path;
    int serialId;
    Object[] selectedFile;
    String[] items;
    String[] jlist2items = new String[1000000];
    String[] jlist1items = new String[1000000];
    String[] jlist3items = new String[1000000];
    String[] jlist4items = new String[1000000];
    String[] jlist5items = new String[1000000];
    String[] jlist6items = new String[1000000];
    String[] jlist7items = new String[1000000];
    String[] jlist8items = new String[1000000];
    String[] jlist9items = new String[1000000];
    String[] jlist10items = new String[1000000];
    String[] jlist11items = new String[1000000];
    String[] jlist12items = new String[1000000];
    String[] jlist13items = new String[1000000];
    String[] jlist14items = new String[1000000];
    String[] jlist16items = new String[1000000];
    String[] jlist17items = new String[1000000];
    String[] jlist18items = new String[1000000];
    String[] jlist19items = new String[1000000];
    String[] jlist20items = new String[1000000];
    String[] jlist21items = new String[1000000];
    String[] jlist22items = new String[1000000];
    String[] jlist23items = new String[1000000];
    String[] jlist24items = new String[1000000];
    String[] jlist25items = new String[1000000];
    String[] jlist26items = new String[1000000];
    String[] jlist27items = new String[1000000];
    String[] jlist28items = new String[1000000];
    String[] jlist29items = new String[1000000];
    String[] search1items = new String[1000000];
    String[] search2items = new String[1000000];
    String[] search3items = new String[1000000];
    String[] search4items = new String[1000000];
    String[] search5items = new String[1000000];
    String[] search6items = new String[1000000];
    String[] search7items = new String[1000000];
    String[] search8items = new String[1000000];
    String[] search9items = new String[1000000];
    String[] search10items = new String[1000000];
    String[] search11items = new String[1000000];
    String[] search12items = new String[1000000];
    String[] search13items = new String[1000000];
    String[] search14items = new String[1000000];
    String[] search16items = new String[1000000];
    String[] search17items = new String[1000000];
    String[] search18items = new String[1000000];
    String[] search19items = new String[1000000];
    String[] search20items = new String[1000000];
    String[] search21items = new String[1000000];
    String[] search22items = new String[1000000];
    String[] search23items = new String[1000000];
    String[] search24items = new String[1000000];
    String[] search25items = new String[1000000];
    String[] search26items = new String[1000000];
    String[] search27items = new String[1000000];
    String[] search28items = new String[1000000];
    String[] search29items = new String[1000000];
    String[] episodeitems = new String[100000];
    String[] recentitems = new String[1000];
    String[] check;
    
    String cata;
    String searching2 = "title", sort = "asc";
    long driveReminingSize;
    long fileSize;
    Connection conn;
    String lookAndFeel = "com.jtattoo.plaf.noire.NoireLookAndFeel";
    String fontFamily;
    int fontSize;
    int fontStyle;
    int foregroundR;
    int foregroundB;
    int foregroundG;
    int backgroundR;
    PreparedStatement stmt;
    PreparedStatement stmt2;
    int backgroundB;
    int backgroundG;
    int defaultValue = 1;
    String folderName = "Infinity Movie";
    String infoText = "Inifinity Movie Store App.";
    private String editSelected;
    private String openImage;
    String selectedList;
    int state = 1;
    boolean recentButtonClicked;
    boolean transfering = false;
    boolean categorySelected = false;
    boolean visible = false;
    
    public Home(){
            setExtendedState(JFrame.MAXIMIZED_BOTH);
            this.conn = (Connection) Connectivity.openConnection();
            if(conn == null){
                JOptionPane.showMessageDialog(Home.this, "Database location not spesfied!");
            }else{
                
        try {
            
            this.stmt = conn.prepareStatement("select * from setting");
            this.stmt2 = conn.prepareStatement("select * from aboutYou");
            ResultSet rs = stmt.executeQuery();
            ResultSet rs2 = stmt2.executeQuery();
            while(rs.next()){
                if(rs.getRow()>0){
                    lookAndFeel = rs.getString("lookAndFeel");
                fontFamily = rs.getString("fontFamily");
                fontSize = rs.getInt("fontSize");
                fontStyle = rs.getInt("fontStyle");
                foregroundR = rs.getInt("foregroundR");
                foregroundB = rs.getInt("foregroundB");
                foregroundG = rs.getInt("foregroundG");
                backgroundR = rs.getInt("backgroundR");
                backgroundB = rs.getInt("backgroundB");
                backgroundG = rs.getInt("backgroundG");
                defaultValue = rs.getInt("default");
                                
                
                try {
                    for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                        if ("Nimbus".equals(info.getName())) {
                            javax.swing.UIManager.setLookAndFeel(info.getClassName());
                            UIManager.setLookAndFeel(lookAndFeel);
                            SwingUtilities.updateComponentTreeUI(Home.this);
                            break;
                        }
                    }
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
                    java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                }
                
                }
                
            }
            while(rs2.next()){
                if(rs2.getRow()>0){
                   folderName = rs2.getString("folderName");
                   infoText = rs2.getString("infoText");
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
            }
        
        initComponents();
        setLocationRelativeTo(null);
        JList[] listoch = {jList1,jList2,jList3,jList4,jList5,jList6,jList7,jList8,jList9,jList10,jList12,jList13,jList14,jList16,jList17,jList18,jList19,jList20,jList21,jList22,jList23,jList24,jList25,jList26,jList27,jList28,jList29};
        if(defaultValue == 0){
            int i = 0;
            while(i < listoch.length){
                listoch[i].setFont(new java.awt.Font(fontFamily, fontStyle, fontSize));
                listoch[i].setForeground(new Color(foregroundR,foregroundG,foregroundB));
                listoch[i].setBackground(new Color(backgroundR,backgroundG,backgroundB));
                SwingUtilities.updateComponentTreeUI(listoch[i]);
                i++;
            }
            
        }
    
        try {
            PreparedStatement stmt = conn.prepareStatement("select category from category");
            ResultSet rs = stmt.executeQuery();
            DefaultComboBoxModel model = new DefaultComboBoxModel();
            model.removeAllElements();
            while(rs.next()){
                model.addElement(rs.getString("category"));
            }
            category.setModel(model);
        } catch (SQLException ex) {
            Logger.getLogger(Add_or_edit.class.getName()).log(Level.SEVERE, null, ex);
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

        jMenuItem15 = new javax.swing.JMenuItem();
        jMenuItem19 = new javax.swing.JMenuItem();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList<>();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jList3 = new javax.swing.JList<>();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jList4 = new javax.swing.JList<>();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jList5 = new javax.swing.JList<>();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jList6 = new javax.swing.JList<>();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jList7 = new javax.swing.JList<>();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        jList8 = new javax.swing.JList<>();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane9 = new javax.swing.JScrollPane();
        jList9 = new javax.swing.JList<>();
        jPanel10 = new javax.swing.JPanel();
        jScrollPane10 = new javax.swing.JScrollPane();
        jList10 = new javax.swing.JList<>();
        jPanel11 = new javax.swing.JPanel();
        jScrollPane11 = new javax.swing.JScrollPane();
        jList11 = new javax.swing.JList<>();
        jPanel12 = new javax.swing.JPanel();
        jScrollPane12 = new javax.swing.JScrollPane();
        jList12 = new javax.swing.JList<>();
        jPanel13 = new javax.swing.JPanel();
        jScrollPane13 = new javax.swing.JScrollPane();
        jList13 = new javax.swing.JList<>();
        jPanel19 = new javax.swing.JPanel();
        jScrollPane14 = new javax.swing.JScrollPane();
        jList14 = new javax.swing.JList<>();
        jPanel20 = new javax.swing.JPanel();
        jScrollPane17 = new javax.swing.JScrollPane();
        jList16 = new javax.swing.JList<>();
        jPanel21 = new javax.swing.JPanel();
        jScrollPane18 = new javax.swing.JScrollPane();
        jList17 = new javax.swing.JList<>();
        jPanel22 = new javax.swing.JPanel();
        jScrollPane19 = new javax.swing.JScrollPane();
        jList18 = new javax.swing.JList<>();
        jPanel23 = new javax.swing.JPanel();
        jScrollPane20 = new javax.swing.JScrollPane();
        jList19 = new javax.swing.JList<>();
        jPanel24 = new javax.swing.JPanel();
        jScrollPane21 = new javax.swing.JScrollPane();
        jList20 = new javax.swing.JList<>();
        jPanel25 = new javax.swing.JPanel();
        jScrollPane22 = new javax.swing.JScrollPane();
        jList21 = new javax.swing.JList<>();
        jPanel26 = new javax.swing.JPanel();
        jScrollPane23 = new javax.swing.JScrollPane();
        jList22 = new javax.swing.JList<>();
        jPanel27 = new javax.swing.JPanel();
        jScrollPane24 = new javax.swing.JScrollPane();
        jList23 = new javax.swing.JList<>();
        jPanel28 = new javax.swing.JPanel();
        jScrollPane25 = new javax.swing.JScrollPane();
        jList24 = new javax.swing.JList<>();
        jPanel29 = new javax.swing.JPanel();
        jScrollPane26 = new javax.swing.JScrollPane();
        jList25 = new javax.swing.JList<>();
        jPanel30 = new javax.swing.JPanel();
        jScrollPane27 = new javax.swing.JScrollPane();
        jList26 = new javax.swing.JList<>();
        jPanel31 = new javax.swing.JPanel();
        jScrollPane28 = new javax.swing.JScrollPane();
        jList27 = new javax.swing.JList<>();
        jPanel32 = new javax.swing.JPanel();
        jScrollPane29 = new javax.swing.JScrollPane();
        jList28 = new javax.swing.JList<>();
        jPanel33 = new javax.swing.JPanel();
        jScrollPane30 = new javax.swing.JScrollPane();
        jList29 = new javax.swing.JList<>();
        jPanel14 = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        title = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        size = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        type = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        duration = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        year = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        language = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        genre = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        season = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        episode = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cover_image = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        producer = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        content_provider = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        writer = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        photographer = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        musician = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        publisher = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        director = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        editor = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        actors = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        arrangement = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        searchField = new javax.swing.JTextField();
        feature = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        jScrollPane16 = new javax.swing.JScrollPane();
        episodesList = new javax.swing.JList<>();
        sortCombo = new javax.swing.JComboBox<>();
        jPanel18 = new javax.swing.JPanel();
        jScrollPane15 = new javax.swing.JScrollPane();
        jList15 = new javax.swing.JList<>();
        jButton6 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        total_space = new javax.swing.JLabel();
        freeSpace = new javax.swing.JLabel();
        total_space1 = new javax.swing.JLabel();
        total_space2 = new javax.swing.JLabel();
        selectedDrive = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jProgressBar1 = new javax.swing.JProgressBar();
        sending = new javax.swing.JLabel();
        sizeCount = new javax.swing.JLabel();
        remining = new javax.swing.JLabel();
        sendingNumber = new javax.swing.JLabel();
        searchCombo = new javax.swing.JComboBox<>();
        jButton7 = new javax.swing.JButton();
        selectedPath = new javax.swing.JLabel();
        EditSerial = new javax.swing.JButton();
        EditSerial1 = new javax.swing.JButton();
        reminTime = new javax.swing.JLabel();
        episodesNumber = new javax.swing.JLabel();
        recent = new javax.swing.JButton();
        category = new javax.swing.JComboBox<>();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem18 = new javax.swing.JMenuItem();
        jMenuItem20 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem22 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem16 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenuItem17 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem13 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem14 = new javax.swing.JMenuItem();
        jMenuItem21 = new javax.swing.JMenuItem();

        jMenuItem15.setText("jMenuItem15");

        jMenuItem19.setText("jMenuItem19");

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Infinity Movie Store");
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/moviestore/Icons/folder_movies_icon_6.png")).getImage());
        setLocationByPlatform(true);
        setMinimumSize(new java.awt.Dimension(1310, 743));
        setSize(new java.awt.Dimension(1070, 630));
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                formMouseMoved(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jTabbedPane1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jTabbedPane1.setTabPlacement(javax.swing.JTabbedPane.RIGHT);
        jTabbedPane1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jTabbedPane1MouseMoved(evt);
            }
        });

        jList2.setFont(new java.awt.Font("Power Geez Unicode2", 0, 14)); // NOI18N
        jList2.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jList2.setDragEnabled(true);
        jList2.setName("jList2"); // NOI18N
        Select select = new Select();
        jlist2items = Select.listAllMediaInJList(jList2, Home.this, searching2, sort);
        jList2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList2MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jList2MousePressed(evt);
            }
        });
        jList2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jList2KeyPressed(evt);
            }
        });
        jList2.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jList2ValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(jList2);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );

        jTabbedPane1.addTab("All Medias", jPanel1);

        jList1.setFont(new java.awt.Font("Power Geez Unicode2", 0, 14)); // NOI18N
        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jList1.setDragEnabled(true);
        jList1.setName("jList1"); // NOI18N
        jList1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jList1MouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jList1MousePressed(evt);
            }
        });
        jList1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jList1KeyPressed(evt);
            }
        });
        jList1.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jList1ValueChanged(evt);
            }
        });
        jlist1items = Select.listMediaInJList(jList1, Home.this, "Action or Adventure", searching2, sort);
        jScrollPane2.setViewportView(jList1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 555, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Action or Adventure", jPanel2);

        jList3.setFont(new java.awt.Font("Power Geez Unicode2", 0, 14)); // NOI18N
        jList3.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jList3.setDragEnabled(true);
        jList3.setName("jList3"); // NOI18N
        jlist3items = Select.listMediaInJList(jList3, Home.this, "Comedy film", searching2, sort);
        jList3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList3MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jList3MousePressed(evt);
            }
        });
        jList3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jList3KeyPressed(evt);
            }
        });
        jList3.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jList3ValueChanged(evt);
            }
        });
        jScrollPane3.setViewportView(jList3);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 555, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Comedy film", jPanel3);

        jList4.setFont(new java.awt.Font("Power Geez Unicode2", 0, 14)); // NOI18N
        jList4.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jList4.setDragEnabled(true);
        jList4.setName("jList4"); // NOI18N
        jlist4items = Select.listMediaInJList(jList4, Home.this, "Crime and Gangster", searching2, sort);
        jList4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList4MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jList4MousePressed(evt);
            }
        });
        jList4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jList4KeyPressed(evt);
            }
        });
        jList4.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jList4ValueChanged(evt);
            }
        });
        jScrollPane4.setViewportView(jList4);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 555, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Crime and Gangster", jPanel4);

        jList5.setFont(new java.awt.Font("Power Geez Unicode2", 0, 14)); // NOI18N
        jList5.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jList5.setDragEnabled(true);
        jList5.setName("jList5"); // NOI18N
        jlist5items = Select.listMediaInJList(jList5, Home.this, "Drama", searching2, sort);
        jList5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList5MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jList5MousePressed(evt);
            }
        });
        jList5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jList5KeyPressed(evt);
            }
        });
        jList5.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jList5ValueChanged(evt);
            }
        });
        jScrollPane5.setViewportView(jList5);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 555, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Drama", jPanel5);

        jList6.setFont(new java.awt.Font("Power Geez Unicode2", 0, 14)); // NOI18N
        jList6.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jList6.setDragEnabled(true);
        jList6.setName("jList6"); // NOI18N
        jlist6items = Select.listMediaInJList(jList6, Home.this, "Epics or historical", searching2, sort);
        jList6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList6MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jList6MousePressed(evt);
            }
        });
        jList6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jList6KeyPressed(evt);
            }
        });
        jList6.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jList6ValueChanged(evt);
            }
        });
        jScrollPane6.setViewportView(jList6);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 555, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Epics or historical", jPanel6);

        jList7.setFont(new java.awt.Font("Power Geez Unicode2", 0, 14)); // NOI18N
        jList7.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jList7.setDragEnabled(true);
        jList7.setName("jList7"); // NOI18N
        jlist7items = Select.listMediaInJList(jList7, Home.this, "Horror", searching2, sort);
        jList7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList7MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jList7MousePressed(evt);
            }
        });
        jList7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jList7KeyPressed(evt);
            }
        });
        jList7.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jList7ValueChanged(evt);
            }
        });
        jScrollPane7.setViewportView(jList7);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 555, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Horror", jPanel7);

        jList8.setFont(new java.awt.Font("Power Geez Unicode2", 0, 14)); // NOI18N
        jList8.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jList8.setDragEnabled(true);
        jList8.setName("jList8"); // NOI18N
        jlist8items = Select.listMediaInJList(jList8, Home.this, "Musicals and dance", searching2, sort);
        jList8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList8MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jList8MousePressed(evt);
            }
        });
        jList8.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jList8KeyPressed(evt);
            }
        });
        jList8.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jList8ValueChanged(evt);
            }
        });
        jScrollPane8.setViewportView(jList8);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 555, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Musicals and dance", jPanel8);

        jList9.setFont(new java.awt.Font("Power Geez Unicode2", 0, 14)); // NOI18N
        jList9.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jList9.setDragEnabled(true);
        jList9.setName("jList9"); // NOI18N
        jlist9items = Select.listMediaInJList(jList9, Home.this, "Science fiction (Sci-Fi)", searching2, sort);
        jList9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList9MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jList9MousePressed(evt);
            }
        });
        jList9.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jList9KeyPressed(evt);
            }
        });
        jList9.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jList9ValueChanged(evt);
            }
        });
        jScrollPane9.setViewportView(jList9);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 555, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Science fiction (Si-Fi)", jPanel9);

        jList10.setFont(new java.awt.Font("Power Geez Unicode2", 0, 14)); // NOI18N
        jList10.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jList10.setDragEnabled(true);
        jList10.setName("jList10"); // NOI18N
        jlist10items = Select.listMediaInJList(jList10, Home.this, "War", searching2, sort);
        jList10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList10MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jList10MousePressed(evt);
            }
        });
        jList10.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jList10KeyPressed(evt);
            }
        });
        jList10.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jList10ValueChanged(evt);
            }
        });
        jScrollPane10.setViewportView(jList10);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane10, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane10, javax.swing.GroupLayout.DEFAULT_SIZE, 555, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("War", jPanel10);

        jList11.setFont(new java.awt.Font("Power Geez Unicode2", 0, 14)); // NOI18N
        jList11.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jList11.setDragEnabled(true);
        jList11.setName("jList11"); // NOI18N
        jlist11items = Select.listMediaInJList(jList11, Home.this, "Westerns", searching2, sort);
        jList11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList11MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jList11MousePressed(evt);
            }
        });
        jList11.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jList11KeyPressed(evt);
            }
        });
        jList11.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jList11ValueChanged(evt);
            }
        });
        jScrollPane11.setViewportView(jList11);

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane11, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane11, javax.swing.GroupLayout.DEFAULT_SIZE, 555, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Westerns", jPanel11);

        jList12.setFont(new java.awt.Font("Power Geez Unicode2", 0, 14)); // NOI18N
        jList12.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jList12.setDragEnabled(true);
        jList12.setName("jList12"); // NOI18N
        jlist12items = Select.listMediaInJList(jList12, Home.this, "Tv shows", searching2, sort);
        jList12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList12MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jList12MousePressed(evt);
            }
        });
        jList12.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jList12KeyPressed(evt);
            }
        });
        jList12.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jList12ValueChanged(evt);
            }
        });
        jScrollPane12.setViewportView(jList12);

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane12, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane12, javax.swing.GroupLayout.DEFAULT_SIZE, 555, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Tv shows", jPanel12);

        jList13.setFont(new java.awt.Font("Power Geez Unicode2", 0, 14)); // NOI18N
        jList13.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jList13.setDragEnabled(true);
        jList13.setName("jList13"); // NOI18N
        jlist13items = Select.listMediaInJList(jList13, Home.this, "Funny video", searching2, sort);
        jList13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList13MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jList13MousePressed(evt);
            }
        });
        jList13.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jList13KeyPressed(evt);
            }
        });
        jList13.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jList13ValueChanged(evt);
            }
        });
        jScrollPane13.setViewportView(jList13);

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane13, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane13, javax.swing.GroupLayout.DEFAULT_SIZE, 555, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Funny video", jPanel13);

        jList14.setFont(new java.awt.Font("Power Geez Unicode2", 0, 14)); // NOI18N
        jList14.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jList14.setDragEnabled(true);
        jList14.setName("jList14"); // NOI18N
        jlist14items = Select.listMediaInJList(jList14, Home.this, "Amazing video", searching2, sort);
        jList14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList14MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jList14MousePressed(evt);
            }
        });
        jList14.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jList14KeyPressed(evt);
            }
        });
        jList14.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jList14ValueChanged(evt);
            }
        });
        jScrollPane14.setViewportView(jList14);

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane14, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane14, javax.swing.GroupLayout.DEFAULT_SIZE, 555, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Amazing video", jPanel19);

        jList16.setFont(new java.awt.Font("Power Geez Unicode2", 0, 14)); // NOI18N
        jList16.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jList16.setDragEnabled(true);
        jList16.setName("jList16"); // NOI18N
        jlist16items = Select.listMediaInJList(jList16, Home.this, "Adult video", searching2, sort);
        jList16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList16MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jList16MousePressed(evt);
            }
        });
        jList16.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jList16KeyPressed(evt);
            }
        });
        jList16.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jList16ValueChanged(evt);
            }
        });
        jScrollPane17.setViewportView(jList16);

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane17, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane17, javax.swing.GroupLayout.DEFAULT_SIZE, 555, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Adult video", jPanel20);

        jList17.setFont(new java.awt.Font("Power Geez Unicode2", 0, 14)); // NOI18N
        jList17.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jList17.setDragEnabled(true);
        jList17.setName("jList17"); // NOI18N
        jlist17items = Select.listMediaInJList(jList17, Home.this, "Music video", searching2, sort);
        jList17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList17MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jList17MousePressed(evt);
            }
        });
        jList17.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jList17KeyPressed(evt);
            }
        });
        jList17.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jList17ValueChanged(evt);
            }
        });
        jScrollPane18.setViewportView(jList17);

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane18, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane18, javax.swing.GroupLayout.DEFAULT_SIZE, 555, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Music video", jPanel21);

        jList18.setFont(new java.awt.Font("Power Geez Unicode2", 0, 14)); // NOI18N
        jList18.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jList18.setDragEnabled(true);
        jList18.setName("jList18"); // NOI18N
        jlist18items = Select.listMediaInJList(jList18, Home.this, "Christian video", searching2, sort);
        jList18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList18MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jList18MousePressed(evt);
            }
        });
        jList18.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jList18KeyPressed(evt);
            }
        });
        jList18.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jList18ValueChanged(evt);
            }
        });
        jScrollPane19.setViewportView(jList18);

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane19, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane19, javax.swing.GroupLayout.DEFAULT_SIZE, 555, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Christian video", jPanel22);

        jList19.setFont(new java.awt.Font("Power Geez Unicode2", 0, 14)); // NOI18N
        jList19.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jList19.setDragEnabled(true);
        jList19.setName("jList19"); // NOI18N
        jlist19items = Select.listMediaInJList(jList19, Home.this, "Islamic video", searching2, sort);
        jList19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList19MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jList19MousePressed(evt);
            }
        });
        jList19.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jList19KeyPressed(evt);
            }
        });
        jList19.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jList19ValueChanged(evt);
            }
        });
        jScrollPane20.setViewportView(jList19);

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane20, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane20, javax.swing.GroupLayout.DEFAULT_SIZE, 555, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Islamic video", jPanel23);

        jList20.setFont(new java.awt.Font("Power Geez Unicode2", 0, 14)); // NOI18N
        jList20.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jList20.setDragEnabled(true);
        jList20.setName("jList20"); // NOI18N
        jlist20items = Select.listMediaInJList(jList20, Home.this, "Other religion video", searching2, sort);
        jList20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList20MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jList20MousePressed(evt);
            }
        });
        jList20.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jList20KeyPressed(evt);
            }
        });
        jList20.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jList20ValueChanged(evt);
            }
        });
        jScrollPane21.setViewportView(jList20);

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane21, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane21, javax.swing.GroupLayout.DEFAULT_SIZE, 555, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Other religion video", jPanel24);

        jList21.setFont(new java.awt.Font("Power Geez Unicode2", 0, 14)); // NOI18N
        jList21.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jList21.setDragEnabled(true);
        jList21.setName("jList21"); // NOI18N
        jlist21items = Select.listMediaInJList(jList21, Home.this, "Native film", searching2, sort);
        jList21.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList21MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jList21MousePressed(evt);
            }
        });
        jList21.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jList21KeyPressed(evt);
            }
        });
        jList21.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jList21ValueChanged(evt);
            }
        });
        jScrollPane22.setViewportView(jList21);

        javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane22, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane22, javax.swing.GroupLayout.DEFAULT_SIZE, 555, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Native  Film/ movie", jPanel25);

        jList22.setFont(new java.awt.Font("Power Geez Unicode2", 0, 14)); // NOI18N
        jList22.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jList22.setDragEnabled(true);
        jList22.setName("jList22"); // NOI18N
        jlist22items = Select.listMediaInJList(jList22, Home.this, "Native Tv shows", searching2, sort);
        jList22.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList22MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jList22MousePressed(evt);
            }
        });
        jList22.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jList22KeyPressed(evt);
            }
        });
        jList22.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jList22ValueChanged(evt);
            }
        });
        jScrollPane23.setViewportView(jList22);

        javax.swing.GroupLayout jPanel26Layout = new javax.swing.GroupLayout(jPanel26);
        jPanel26.setLayout(jPanel26Layout);
        jPanel26Layout.setHorizontalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane23, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel26Layout.setVerticalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane23, javax.swing.GroupLayout.DEFAULT_SIZE, 555, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Native Tv shows", jPanel26);

        jList23.setFont(new java.awt.Font("Power Geez Unicode2", 0, 14)); // NOI18N
        jList23.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jList23.setDragEnabled(true);
        jList23.setName("jList23"); // NOI18N
        jlist23items = Select.listMediaInJList(jList23, Home.this, "Native fun video", searching2, sort);
        jList23.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList23MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jList23MousePressed(evt);
            }
        });
        jList23.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jList23KeyPressed(evt);
            }
        });
        jList23.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jList23ValueChanged(evt);
            }
        });
        jScrollPane24.setViewportView(jList23);

        javax.swing.GroupLayout jPanel27Layout = new javax.swing.GroupLayout(jPanel27);
        jPanel27.setLayout(jPanel27Layout);
        jPanel27Layout.setHorizontalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane24, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel27Layout.setVerticalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane24, javax.swing.GroupLayout.DEFAULT_SIZE, 555, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Native fun video", jPanel27);

        jList24.setFont(new java.awt.Font("Power Geez Unicode2", 0, 14)); // NOI18N
        jList24.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jList24.setDragEnabled(true);
        jList24.setName("jList24"); // NOI18N
        jlist24items = Select.listMediaInJList(jList24, Home.this, "Native music video", searching2, sort);
        jList24.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList24MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jList24MousePressed(evt);
            }
        });
        jList24.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jList24KeyPressed(evt);
            }
        });
        jList24.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jList24ValueChanged(evt);
            }
        });
        jScrollPane25.setViewportView(jList24);

        javax.swing.GroupLayout jPanel28Layout = new javax.swing.GroupLayout(jPanel28);
        jPanel28.setLayout(jPanel28Layout);
        jPanel28Layout.setHorizontalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane25, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel28Layout.setVerticalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane25, javax.swing.GroupLayout.DEFAULT_SIZE, 555, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Native music video", jPanel28);

        jList25.setFont(new java.awt.Font("Power Geez Unicode2", 0, 14)); // NOI18N
        jList25.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jList25.setDragEnabled(true);
        jList25.setName("jList25"); // NOI18N
        jlist25items = Select.listMediaInJList(jList25, Home.this, "Foreign Music / Audio", searching2, sort);
        jList25.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList25MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jList25MousePressed(evt);
            }
        });
        jList25.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jList25KeyPressed(evt);
            }
        });
        jList25.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jList25ValueChanged(evt);
            }
        });
        jScrollPane26.setViewportView(jList25);

        javax.swing.GroupLayout jPanel29Layout = new javax.swing.GroupLayout(jPanel29);
        jPanel29.setLayout(jPanel29Layout);
        jPanel29Layout.setHorizontalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel29Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane26, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel29Layout.setVerticalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel29Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane26, javax.swing.GroupLayout.DEFAULT_SIZE, 555, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Foreign Music / Audio", jPanel29);

        jList26.setFont(new java.awt.Font("Power Geez Unicode2", 0, 14)); // NOI18N
        jList26.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jList26.setDragEnabled(true);
        jList26.setName("jList26"); // NOI18N
        jlist26items = Select.listMediaInJList(jList26, Home.this, "Native Music / Audio", searching2, sort);
        jList26.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList26MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jList26MousePressed(evt);
            }
        });
        jList26.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jList26KeyPressed(evt);
            }
        });
        jList26.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jList26ValueChanged(evt);
            }
        });
        jScrollPane27.setViewportView(jList26);

        javax.swing.GroupLayout jPanel30Layout = new javax.swing.GroupLayout(jPanel30);
        jPanel30.setLayout(jPanel30Layout);
        jPanel30Layout.setHorizontalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel30Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane27, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel30Layout.setVerticalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel30Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane27, javax.swing.GroupLayout.DEFAULT_SIZE, 555, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Native Music / Audio", jPanel30);

        jList27.setFont(new java.awt.Font("Power Geez Unicode2", 0, 14)); // NOI18N
        jList27.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jList27.setDragEnabled(true);
        jList27.setName("jList27"); // NOI18N
        jlist27items = Select.listMediaInJList(jList27, Home.this, "Religion Music / Audio", searching2, sort);
        jList27.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList27MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jList27MousePressed(evt);
            }
        });
        jList27.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jList27KeyPressed(evt);
            }
        });
        jList27.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jList27ValueChanged(evt);
            }
        });
        jScrollPane28.setViewportView(jList27);

        javax.swing.GroupLayout jPanel31Layout = new javax.swing.GroupLayout(jPanel31);
        jPanel31.setLayout(jPanel31Layout);
        jPanel31Layout.setHorizontalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel31Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane28, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel31Layout.setVerticalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel31Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane28, javax.swing.GroupLayout.DEFAULT_SIZE, 555, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Religion Music / Audio", jPanel31);

        jList28.setFont(new java.awt.Font("Power Geez Unicode2", 0, 14)); // NOI18N
        jList28.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jList28.setDragEnabled(true);
        jList28.setName("jList28"); // NOI18N
        jlist28items = Select.listMediaInJList(jList28, Home.this, "Anniversary Music / Audio", searching2, sort);
        jList28.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList28MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jList28MousePressed(evt);
            }
        });
        jList28.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jList28KeyPressed(evt);
            }
        });
        jList28.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jList28ValueChanged(evt);
            }
        });
        jScrollPane29.setViewportView(jList28);

        javax.swing.GroupLayout jPanel32Layout = new javax.swing.GroupLayout(jPanel32);
        jPanel32.setLayout(jPanel32Layout);
        jPanel32Layout.setHorizontalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel32Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane29, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel32Layout.setVerticalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel32Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane29, javax.swing.GroupLayout.DEFAULT_SIZE, 555, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Anniversary Music / Audio", jPanel32);

        jList29.setFont(new java.awt.Font("Power Geez Unicode2", 0, 14)); // NOI18N
        jList29.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jList29.setDragEnabled(true);
        jList29.setName("jList29"); // NOI18N
        jlist29items = Select.listMediaInJList(jList29, Home.this, "Other", searching2, sort);
        jList29.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList29MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jList29MousePressed(evt);
            }
        });
        jList29.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jList29KeyPressed(evt);
            }
        });
        jList29.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jList29ValueChanged(evt);
            }
        });
        jScrollPane30.setViewportView(jList29);

        javax.swing.GroupLayout jPanel33Layout = new javax.swing.GroupLayout(jPanel33);
        jPanel33.setLayout(jPanel33Layout);
        jPanel33Layout.setHorizontalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel33Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane30, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel33Layout.setVerticalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel33Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane30, javax.swing.GroupLayout.DEFAULT_SIZE, 555, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Other", jPanel33);

        jPanel14.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Detail", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 12))); // NOI18N
        jPanel14.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jPanel14MouseMoved(evt);
            }
        });
        jPanel14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel14MouseEntered(evt);
            }
        });

        jPanel16.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Description", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 12))); // NOI18N

        jLabel3.setBackground(new java.awt.Color(0, 153, 255));
        jLabel3.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel3.setText("Title  :");

        title.setFont(new java.awt.Font("Power Geez Unicode2", 0, 14)); // NOI18N
        title.setText("-----");

        jLabel5.setBackground(new java.awt.Color(0, 153, 255));
        jLabel5.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel5.setText("Size  :");

        size.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        size.setText("-----");

        jLabel6.setBackground(new java.awt.Color(0, 153, 255));
        jLabel6.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel6.setText("Type of file  :");

        type.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        type.setText("-----");

        jLabel7.setBackground(new java.awt.Color(0, 153, 255));
        jLabel7.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel7.setText("Duration  :");

        duration.setFont(new java.awt.Font("DS-Digital", 0, 14)); // NOI18N
        duration.setText("-----");

        jLabel8.setBackground(new java.awt.Color(0, 153, 255));
        jLabel8.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel8.setText("Year  :");

        year.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        year.setText("-----");

        jLabel9.setBackground(new java.awt.Color(0, 153, 255));
        jLabel9.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel9.setText("Language  :");

        language.setFont(new java.awt.Font("Power Geez Unicode2", 0, 14)); // NOI18N
        language.setText("-----");

        jLabel10.setBackground(new java.awt.Color(0, 153, 255));
        jLabel10.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel10.setText("Sub genre  :");

        genre.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        genre.setText("-----");

        jLabel11.setBackground(new java.awt.Color(0, 153, 255));
        jLabel11.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel11.setText("Season  :");

        season.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        season.setText("-----");

        jLabel12.setBackground(new java.awt.Color(0, 153, 255));
        jLabel12.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel12.setText("Episodes  :");

        episode.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        episode.setText("-----");

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel2.setText("Cover Image");

        cover_image.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        cover_image.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cover_imageMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cover_imageMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                cover_imageMouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                cover_imageMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel5)
                        .addComponent(jLabel3))
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12))
                        .addGap(1, 1, 1)))
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(episode, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(year, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(duration, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(type, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(size, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(language, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(season, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(genre, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(58, 58, 58))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                        .addComponent(cover_image, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(title))
                        .addGap(8, 8, 8)
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(size))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(type))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(duration))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(year))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(language))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(genre))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(season))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(episode)))
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cover_image, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel17.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Origin", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 12))); // NOI18N

        jLabel22.setBackground(new java.awt.Color(0, 153, 204));
        jLabel22.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel22.setText("Actors/Artists  :");

        producer.setFont(new java.awt.Font("Power Geez Unicode2", 0, 14)); // NOI18N
        producer.setText("-----");

        jLabel23.setBackground(new java.awt.Color(0, 153, 204));
        jLabel23.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel23.setText("Directors  :");

        content_provider.setFont(new java.awt.Font("Power Geez Unicode2", 0, 14)); // NOI18N
        content_provider.setText("-----");

        jLabel24.setBackground(new java.awt.Color(0, 153, 204));
        jLabel24.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel24.setText("Producers  :");

        writer.setFont(new java.awt.Font("Power Geez Unicode2", 0, 14)); // NOI18N
        writer.setText("-----");

        jLabel25.setBackground(new java.awt.Color(0, 153, 204));
        jLabel25.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel25.setText("Writers  :");

        photographer.setFont(new java.awt.Font("Power Geez Unicode2", 0, 14)); // NOI18N
        photographer.setText("-----");

        jLabel26.setBackground(new java.awt.Color(0, 153, 204));
        jLabel26.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel26.setText("Editor  :");

        musician.setFont(new java.awt.Font("Power Geez Unicode2", 0, 14)); // NOI18N
        musician.setText("-----");

        jLabel27.setBackground(new java.awt.Color(0, 153, 204));
        jLabel27.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel27.setText("Photographer  :");

        publisher.setFont(new java.awt.Font("Power Geez Unicode2", 0, 14)); // NOI18N
        publisher.setText("-----");

        jLabel28.setBackground(new java.awt.Color(0, 153, 204));
        jLabel28.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel28.setText("Musician  :");

        director.setFont(new java.awt.Font("Power Geez Unicode2", 0, 14)); // NOI18N
        director.setText("-----");

        jLabel29.setBackground(new java.awt.Color(0, 153, 204));
        jLabel29.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel29.setText("Publisher  :");

        editor.setFont(new java.awt.Font("Power Geez Unicode2", 0, 14)); // NOI18N
        editor.setText("-----");

        jLabel30.setBackground(new java.awt.Color(0, 153, 204));
        jLabel30.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel30.setText("Content Provider  :");

        actors.setFont(new java.awt.Font("Power Geez Unicode2", 0, 14)); // NOI18N
        actors.setText("-----");

        jLabel1.setBackground(new java.awt.Color(0, 153, 204));
        jLabel1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel1.setText("Arrangement  :");

        arrangement.setFont(new java.awt.Font("Power Geez Unicode2", 0, 14)); // NOI18N
        arrangement.setText("------");

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel23)
                    .addComponent(jLabel22)
                    .addComponent(jLabel24)
                    .addComponent(jLabel26)
                    .addComponent(jLabel25)
                    .addComponent(jLabel28)
                    .addComponent(jLabel27)
                    .addComponent(jLabel29)
                    .addComponent(jLabel30))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(director, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(producer, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(writer, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(musician, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(photographer, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(publisher, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(content_provider, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(arrangement, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(actors, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(actors))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(director))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(producer))
                .addGap(3, 3, 3)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(editor))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(writer))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28)
                    .addComponent(musician))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(photographer))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(publisher))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30)
                    .addComponent(content_provider))
                .addGap(9, 9, 9)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(arrangement))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/moviestore/Icons/plus_16px.png"))); // NOI18N
        jButton1.setText("Add Media");
        jButton1.setToolTipText("Add Media");
        jButton1.setIconTextGap(2);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/moviestore/Icons/add_folder_16px.png"))); // NOI18N
        jButton2.setText("Add Folder");
        jButton2.setToolTipText("Add Folder");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/moviestore/Icons/edit_file_16px.png"))); // NOI18N
        jButton3.setText("Edit");
        jButton3.setToolTipText("Edit selected file");
        if (selection == null){
            jButton3.setEnabled(false);
        }
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/moviestore/Icons/play_20px.png"))); // NOI18N
        jButton4.setText("Play");
        jButton4.setToolTipText("Play selected file");
        if (play_path == null){
            jButton4.setEnabled(false);
        }
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        searchField.setFont(new java.awt.Font("Power Geez Unicode2", 0, 12)); // NOI18N
        searchField.setToolTipText("Search");
        searchField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                searchFieldKeyTyped(evt);
            }
        });

        feature.setFont(new java.awt.Font("Power Geez Unicode2", 0, 12)); // NOI18N
        feature.setText("Description of video.");
        feature.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Media Feature", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 12))); // NOI18N

        jPanel15.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Episodes", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 12))); // NOI18N

        episodesList.setFont(new java.awt.Font("Power Geez Unicode2", 0, 12)); // NOI18N
        episodesList.setToolTipText("Episodes");
        episodesList.setDragEnabled(true);
        episodesList.setName("episodesList"); // NOI18N
        episodesList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                episodesListMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                episodesListMousePressed(evt);
            }
        });
        episodesList.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                episodesListKeyPressed(evt);
            }
        });
        episodesList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                episodesListValueChanged(evt);
            }
        });
        jScrollPane16.setViewportView(episodesList);

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane16, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addComponent(jScrollPane16, javax.swing.GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE)
                .addContainerGap())
        );

        sortCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "A-Z", "Z-A", "Year desc", "Modified time desc" }));
        sortCombo.setToolTipText("Sort");
        sortCombo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                sortComboItemStateChanged(evt);
            }
        });

        jPanel18.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "USB Devices", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 12))); // NOI18N
        jPanel18.setToolTipText("");

        jList15.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "C:", "D:", "E:", "F:", "G:", "H:", "I:", "J:", "K:", "L:" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jList15.setToolTipText("USB Driver");
        DefaultListModel listModel = new DefaultListModel();
        listModel.clear();
        FileSystemView fsv = FileSystemView.getFileSystemView();
        if (oldListRoot != null && oldListRoot.length > 0){
            for (File aDrive : oldListRoot){
                String driveType = fsv.getSystemTypeDescription(aDrive);
                switch (driveType) {
                    case "Local Disk":
                    listModel.addElement(new ImageAndText(driveType+" "+aDrive, new ImageIcon(Home.class.getResource("/moviestore/Icons/compact_disc_25px.png"))));
                    break;
                    case "CD Drive":
                    listModel.addElement(new ImageAndText(driveType+" "+aDrive, new ImageIcon(Home.class.getResource("/moviestore/Icons/cd_25px.png"))));
                    break;
                    default:
                    listModel.addElement(new ImageAndText(driveType+" "+aDrive, new ImageIcon(Home.class.getResource("/moviestore/Icons/usb_25px.png"))));
                    break;
                }
            }
        }
        jList15.setCellRenderer(new Renderer());
        jList15.setModel(listModel);
        waitForNotifying(jList15);
        jList15.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jList15MouseMoved(evt);
            }
        });
        jList15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList15MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jList15MousePressed(evt);
            }
        });
        jList15.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jList15KeyPressed(evt);
            }
        });
        jList15.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jList15ValueChanged(evt);
            }
        });
        jList15.setDropTarget(new DropTarget() {
            public synchronized void drop(DropTargetDropEvent evt){

                evt.acceptDrop(DnDConstants.ACTION_COPY);

                if(drivePath!=null){

                    String droppedfile = evt.getTransferable().toString();
                    try{
                        PreparedStatement stmt = conn.prepareStatement("select * from medias where title = '" + droppedfile + "'");
                        ResultSet rs = stmt.executeQuery();

                        while(rs.next()){
                            play_path = rs.getString("media_path");
                        }
                    }catch(SQLException e){

                    }
                    if(drivePath != null && play_path != null){
                        File f = new File(play_path);
                        if(f.isDirectory()){
                            count = count + ep_path.length;
                            File[] play_paths = ep_path;
                            File dire1 = new File(drivePath + folderName);
                            dire1.mkdir();
                            File txt = new File(dire1.getPath()+"\\readme.txt");
                            try {
                                txt.createNewFile();
                                try (FileWriter write = new FileWriter(txt)) {
                                    write.write(infoText);
                                }
                            } catch (IOException ex) {
                                JOptionPane.showMessageDialog(Home.this, ex.getMessage());
                            }
                            remining.setText("Remining : ");
                            //copy file conventional way using stream

                            ExecutorService service = Executors.newFixedThreadPool(6);
                            service.submit(new Runnable(){
                                public void run(){

                                    String drivepath = drivePath;
                                    int i = 1;
                                    for(File fi : play_paths){
                                        File source = new File(fi.getPath());
                                        File dire = new File(drivepath + folderName);
                                        dire.mkdir();
                                        String path = dire.getPath()+"\\"+f.getName();

                                        File direct = new File(path);
                                        direct.mkdir();
                                        String path2 = direct.getPath();
                                        File dest = new File(path2 + "\\" + fi.getName());

                                            copyFileUsingStream(source, dest);

                                            if(play_paths.length == i){
                                                bipSound();
                                                Select.transferHistory(source.getParentFile(), dest);
                                            }
                                            i++;
                                        }

                                    }

                                });

                            }else{
                                count++;
                                remining.setText("Remining : ");
                                File source = new File(play_path);
                                File dire = new File(drivePath + folderName);
                                dire.mkdir();
                                String path = dire.getPath();

                                File txt = new File(dire.getPath()+"\\readme.txt");
                                try {
                                    txt.createNewFile();
                                    try (FileWriter write = new FileWriter(txt)) {
                                        write.write(infoText);
                                    }
                                } catch (IOException ex) {
                                    Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
                                }

                                File dest = new File(path +"\\"+ file_name);

                                    //copy file conventional way using stream

                                    ExecutorService service = Executors.newFixedThreadPool(6);
                                    service.submit(new Runnable(){
                                        public void run(){

                                            copyFileUsingStream(source, dest);
                                            bipSound();
                                            Select.transferHistory(source.getParentFile(), dest);
                                        }
                                    });
                                }
                            }else{
                                JOptionPane.showMessageDialog(Home.this, "Please select at least one drive or file.");
                            }

                        }else{
                            JOptionPane.showMessageDialog(Home.this, "Select at least one USB Device!");
                        }
                    }
                });
                jScrollPane15.setViewportView(jList15);

                if (drivePath == null){
                    jButton6.setEnabled(false);
                }
                jButton6.setText("Send");
                jButton6.setToolTipText("Or Press F2 to send");
                jButton6.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        jButton6ActionPerformed(evt);
                    }
                });

                jLabel13.setText("Total Spa :");

                jLabel14.setText("Free Spa :");

                total_space.setText("-----");

                freeSpace.setText("-----");

                total_space1.setText("GB");

                total_space2.setText("GB");

                selectedDrive.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
                selectedDrive.setForeground(new java.awt.Color(255, 153, 51));
                selectedDrive.setText("-");

                javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
                jPanel18.setLayout(jPanel18Layout);
                jPanel18Layout.setHorizontalGroup(
                    jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane15)
                            .addGroup(jPanel18Layout.createSequentialGroup()
                                .addGap(52, 52, 52)
                                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(selectedDrive, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel18Layout.createSequentialGroup()
                                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(jPanel18Layout.createSequentialGroup()
                                        .addComponent(jLabel13)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(total_space, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(total_space1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel18Layout.createSequentialGroup()
                                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(freeSpace, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(total_space2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap())))
                );
                jPanel18Layout.setVerticalGroup(
                    jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(selectedDrive)
                        .addGap(10, 10, 10)
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(total_space1)
                            .addComponent(total_space)
                            .addComponent(jLabel13))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(freeSpace)
                            .addComponent(total_space2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton6)
                        .addContainerGap(16, Short.MAX_VALUE))
                );

                jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/moviestore/Icons/restart_16px.png"))); // NOI18N
                jButton5.setText("Refresh");
                jButton5.setToolTipText("Refresh lists");
                jButton5.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        jButton5ActionPerformed(evt);
                    }
                });

                jProgressBar1.setVisible(false);
                jProgressBar1.setBackground(new java.awt.Color(255, 255, 255));
                jProgressBar1.setForeground(new java.awt.Color(0, 153, 204));
                jProgressBar1.setIndeterminate(true);

                sending.setFont(new java.awt.Font("Dialog", 3, 12)); // NOI18N
                sending.setForeground(new java.awt.Color(0, 102, 102));
                sending.setText("Sending...");
                sending.setVisible(false);

                sizeCount.setFont(new java.awt.Font("DS-Digital", 1, 18)); // NOI18N
                sizeCount.setForeground(new java.awt.Color(0, 153, 204));
                sizeCount.setVisible(false);
                sizeCount.setText("1234567890");

                remining.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
                remining.setVisible(false);
                remining.setText("Remining :");

                sendingNumber.setFont(new java.awt.Font("DS-Digital", 1, 18)); // NOI18N
                sendingNumber.setVisible(false);
                sendingNumber.setForeground(new java.awt.Color(0, 102, 153));

                searchCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Title", "Sub Genre", "Year", "Language", "Actors", "Directors", "Arrangement" }));
                searchCombo.setToolTipText("Search using");

                jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/moviestore/Icons/remove_16px.png"))); // NOI18N
                jButton7.setEnabled(false);
                jButton7.setText("Delete");
                jButton7.setToolTipText("Delete Selected file");
                jButton7.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        jButton7ActionPerformed(evt);
                    }
                });

                selectedPath.setVisible(false);
                selectedPath.setFont(new java.awt.Font("Power Geez Unicode2", 0, 12)); // NOI18N
                selectedPath.setForeground(new java.awt.Color(0, 153, 255));
                selectedPath.setIcon(new javax.swing.ImageIcon(getClass().getResource("/moviestore/Icons/file_20px.png"))); // NOI18N
                selectedPath.setText("jLabel4");

                EditSerial.setEnabled(false);
                EditSerial.setIcon(new javax.swing.ImageIcon(getClass().getResource("/moviestore/Icons/plus_16px.png"))); // NOI18N
                EditSerial.setToolTipText("Add Episode");
                EditSerial.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        EditSerialActionPerformed(evt);
                    }
                });

                EditSerial1.setEnabled(false);
                EditSerial1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/moviestore/Icons/minus_16px.png"))); // NOI18N
                EditSerial1.setToolTipText("Delete Episode");
                EditSerial1.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        EditSerial1ActionPerformed(evt);
                    }
                });

                reminTime.setFont(new java.awt.Font("DS-Digital", 1, 18)); // NOI18N
                reminTime.setForeground(new java.awt.Color(0, 153, 255));
                reminTime.setVisible(false);
                reminTime.setText("12 : 00 min");

                EditSerial1.setEnabled(false);
                recent.setIcon(new javax.swing.ImageIcon(getClass().getResource("/moviestore/Icons/time_machine_16px.png"))); // NOI18N
                recent.setToolTipText("Recent");
                recent.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        recentActionPerformed(evt);
                    }
                });

                category.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
                category.setToolTipText("Film categoty");
                category.addItemListener(new java.awt.event.ItemListener() {
                    public void itemStateChanged(java.awt.event.ItemEvent evt) {
                        categoryItemStateChanged(evt);
                    }
                });

                jMenuBar1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

                jMenu1.setText("File");
                if(selection == null){
                    jMenuItem7.setEnabled(false);
                    jMenuItem8.setEnabled(false);
                    jMenuItem9.setEnabled(false);
                }
                jMenu1.addItemListener(new java.awt.event.ItemListener() {
                    public void itemStateChanged(java.awt.event.ItemEvent evt) {
                        jMenu1ItemStateChanged(evt);
                    }
                });

                jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_MASK));
                jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/moviestore/Icons/database_restore_25px.png"))); // NOI18N
                jMenuItem3.setText("Reload Database");
                jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        jMenuItem3ActionPerformed(evt);
                    }
                });
                jMenu1.add(jMenuItem3);

                jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
                jMenuItem4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/moviestore/Icons/save_25px.png"))); // NOI18N
                jMenuItem4.setText("Save Database");
                jMenu1.add(jMenuItem4);

                jMenuItem5.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, java.awt.event.InputEvent.CTRL_MASK));
                jMenuItem5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/moviestore/Icons/data_backup_25px.png"))); // NOI18N
                jMenuItem5.setText("Backup Database");
                jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        jMenuItem5ActionPerformed(evt);
                    }
                });
                jMenu1.add(jMenuItem5);

                jMenuItem6.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
                jMenuItem6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/moviestore/Icons/add_file_25px.png"))); // NOI18N
                jMenuItem6.setText("Add Media");
                jMenuItem6.addMouseListener(new java.awt.event.MouseAdapter() {
                    public void mouseClicked(java.awt.event.MouseEvent evt) {
                        jMenuItem6MouseClicked(evt);
                    }
                });
                jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        jMenuItem6ActionPerformed(evt);
                    }
                });
                jMenu1.add(jMenuItem6);

                jMenuItem18.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.CTRL_MASK));
                jMenuItem18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/moviestore/Icons/add_folder_25px.png"))); // NOI18N
                jMenuItem18.setText("Add Folder/ Serial Movies");
                jMenuItem18.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        jMenuItem18ActionPerformed(evt);
                    }
                });
                jMenu1.add(jMenuItem18);

                jMenuItem20.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
                jMenuItem20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/moviestore/Icons/add_list_25px.png"))); // NOI18N
                jMenuItem20.setText("Add Episodes");
                jMenuItem20.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        jMenuItem20ActionPerformed(evt);
                    }
                });
                jMenu1.add(jMenuItem20);

                jMenuItem7.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
                jMenuItem7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/moviestore/Icons/edit_property_25px.png"))); // NOI18N
                jMenuItem7.setText("Edit Media Property");
                jMenuItem7.addMouseListener(new java.awt.event.MouseAdapter() {
                    public void mouseClicked(java.awt.event.MouseEvent evt) {
                        jMenuItem7MouseClicked(evt);
                    }
                });
                jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        jMenuItem7ActionPerformed(evt);
                    }
                });
                jMenu1.add(jMenuItem7);

                jMenuItem8.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ENTER, 0));
                jMenuItem8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/moviestore/Icons/play_25px.png"))); // NOI18N
                jMenuItem8.setText("Play Media");
                jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        jMenuItem8ActionPerformed(evt);
                    }
                });
                jMenu1.add(jMenuItem8);

                jMenuItem9.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_DELETE, 0));
                jMenuItem9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/moviestore/Icons/remove_25px.png"))); // NOI18N
                jMenuItem9.setText("Delete");
                jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        jMenuItem9ActionPerformed(evt);
                    }
                });
                jMenu1.add(jMenuItem9);

                jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, 0));
                jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/moviestore/Icons/restart_25px.png"))); // NOI18N
                jMenuItem1.setText("Refresh Lists");
                jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        jMenuItem1ActionPerformed(evt);
                    }
                });
                jMenu1.add(jMenuItem1);

                jMenuItem11.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F2, 0));
                jMenuItem11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/moviestore/Icons/send_letter_25px.png"))); // NOI18N
                jMenuItem11.setText("Send to selected drive");
                jMenuItem11.setEnabled(false);
                jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        jMenuItem11ActionPerformed(evt);
                    }
                });
                jMenu1.add(jMenuItem11);

                jMenu4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/moviestore/Icons/share_25px.png"))); // NOI18N
                jMenu4.setText("Share");
                jMenu4.setEnabled(false);
                jMenu1.add(jMenu4);
                oldListRoot = File.listRoots();
                FileSystemView fsv1 = FileSystemView.getFileSystemView();
                if (oldListRoot != null && oldListRoot.length > 0){
                    for (File aDrive : oldListRoot){
                        String driveType = fsv1.getSystemTypeDescription(aDrive);

                        switch (driveType) {
                            case "Local Disk":
                            JMenuItem menu1 = jMenu4.add(new JMenuItem(aDrive.toString(), new javax.swing.ImageIcon(getClass().getResource("/moviestore/Icons/compact_disc_25px.png"))));
                            menu1.addActionListener((ActionEvent e) -> {
                                File f = new File(play_path);
                                if(f.isDirectory()){
                                    count = count + ep_path.length;
                                    File[] play_paths = ep_path;
                                    File dire1 = new File(menu1.getText() + folderName);
                                    dire1.mkdir();
                                    File txt = new File(dire1.getPath()+"\\readme.txt");
                                    try {
                                        txt.createNewFile();
                                        try (FileWriter write = new FileWriter(txt)) {
                                            write.write(infoText);
                                        }
                                    } catch (IOException ex) {
                                        JOptionPane.showMessageDialog(Home.this, ex.getMessage());
                                    }

                                    //copy file conventional way using stream

                                    ExecutorService service = Executors.newFixedThreadPool(6);
                                    service.submit(new Runnable(){
                                        public void run(){

                                            int i = 1;
                                            for(File fi : play_paths){
                                                File source = new File(fi.getPath());
                                                File dire = new File(menu1.getText() + folderName);
                                                dire.mkdir();
                                                String path = dire.getPath()+"\\"+f.getName();

                                                File direct = new File(path);
                                                direct.mkdir();
                                                String path2 = direct.getPath();
                                                File dest = new File(path2 +"\\" + fi.getName());
                                                    copyFileUsingStream(source, dest);
                                                    if(play_paths.length == i){
                                                        bipSound();
                                                        Select.transferHistory(source.getParentFile(), dest);
                                                    }
                                                    i++;
                                                }

                                            }
                                        });

                                    }else{
                                        count++;
                                        File source = new File(play_path);
                                        File dire = new File(menu1.getText() + folderName);
                                        dire.mkdir();
                                        String path = dire.getPath();

                                        File txt = new File(dire.getPath()+"\\readme.txt");
                                        try {
                                            txt.createNewFile();
                                            try (FileWriter write = new FileWriter(txt)) {
                                                write.write(infoText);
                                            }
                                        } catch (IOException ex) {
                                            JOptionPane.showMessageDialog(Home.this, ex.getMessage());
                                        }

                                        File dest = new File(path + "\\" + file_name);

                                            //copy file conventional way using stream

                                            ExecutorService service = Executors.newFixedThreadPool(6);
                                            service.submit(new Runnable(){
                                                public void run(){

                                                    copyFileUsingStream(source, dest);
                                                    bipSound();
                                                    Select.transferHistory(source.getParentFile(), dest);

                                                }
                                            });
                                        }
                                    });                                 break;
                                    case "CD Drive":
                                    JMenuItem menu2 = jMenu4.add(new JMenuItem(aDrive.toString(), new javax.swing.ImageIcon(getClass().getResource("/moviestore/Icons/cd_25px.png"))));
                                    menu2.addActionListener((ActionEvent e) -> {

                                        File f = new File(play_path);
                                        if(f.isDirectory()){
                                            count = count + ep_path.length;
                                            File[] play_paths = ep_path;
                                            File dire1 = new File(menu2.getText() + folderName);
                                            dire1.mkdir();
                                            File txt = new File(dire1.getPath()+"\\readme.txt");
                                            try {
                                                txt.createNewFile();
                                                try (FileWriter write = new FileWriter(txt)) {
                                                    write.write(infoText);
                                                }
                                            } catch (IOException ex) {
                                                JOptionPane.showMessageDialog(Home.this, ex.getMessage());
                                            }

                                            //copy file conventional way using stream

                                            ExecutorService service = Executors.newFixedThreadPool(6);
                                            service.submit(new Runnable(){
                                                public void run(){

                                                    int i = 1;
                                                    for(File fi : play_paths){
                                                        File source = new File(fi.getPath());
                                                        File dire = new File(menu2.getText() + folderName);
                                                        dire.mkdir();
                                                        String path = dire.getPath()+"\\"+f.getName();

                                                        File direct = new File(path);
                                                        direct.mkdir();
                                                        String path2 = direct.getPath();
                                                        File dest = new File(path2 + "\\" + fi.getName());
                                                            copyFileUsingStream(source, dest);
                                                            if(play_paths.length == i){
                                                                bipSound();
                                                                Select.transferHistory(source.getParentFile(), dest);
                                                            }
                                                            i++;
                                                        }

                                                    }
                                                });

                                            }else{
                                                count++;
                                                File source = new File(play_path);
                                                File dire = new File(menu2.getText() + folderName);
                                                dire.mkdir();
                                                String path = dire.getPath();

                                                File txt = new File(dire.getPath()+"\\readme.txt");
                                                try {
                                                    txt.createNewFile();
                                                    try (FileWriter write = new FileWriter(txt)) {
                                                        write.write(infoText);
                                                    }
                                                } catch (IOException ex) {
                                                    JOptionPane.showMessageDialog(Home.this, ex.getMessage());
                                                }

                                                File dest = new File(path + "\\" + file_name);

                                                    //        //copy file conventional way using stream

                                                    ExecutorService service = Executors.newFixedThreadPool(6);
                                                    service.submit(new Runnable(){
                                                        public void run(){

                                                            copyFileUsingStream(source, dest);
                                                            bipSound();
                                                            Select.transferHistory(source.getParentFile(), dest);

                                                        }
                                                    });
                                                }
                                            });                                 break;
                                            default:
                                            JMenuItem menu3 = jMenu4.add(new JMenuItem(aDrive.toString(), new javax.swing.ImageIcon(getClass().getResource("/moviestore/Icons/usb_25px.png"))));
                                            menu3.addActionListener((ActionEvent e) -> {

                                                if(selectedFile.length>1){
                                                    Spacecraft ss;
                                                    int i = 0;
                                                    while(i<selectedFile.length){
                                                        try {
                                                            ss = (Spacecraft) Select.quarySingleRow(selectedFile[i].toString());
                                                            String pp = ss.getMedia_fullPath();
                                                            serialId = ss.getId();

                                                            try {
                                                                PreparedStatement stmt = conn.prepareStatement("select * from serial where serial_id = '" + serialId + "'");
                                                                ResultSet rs = stmt.executeQuery();
                                                                int f = 0;
                                                                while(rs.next()){
                                                                    f++;
                                                                }

                                                                ResultSet rs3 = stmt.executeQuery();

                                                                ep_path = new File[f];
                                                                int k = 0;
                                                                while(rs3.next()){
                                                                    ep_path[k] = new File(rs3.getString("path"));
                                                                    k++;
                                                                }
                                                            } catch (SQLException ex) {
                                                                JOptionPane.showMessageDialog(this, "Loading Error " + ex.getMessage());
                                                            }

                                                            play_path = pp;

                                                            transperPath2(play_path, ep_path, menu3);

                                                        } catch (SQLException ex) {
                                                            JOptionPane.showMessageDialog(this, ex);
                                                        }
                                                        i++;
                                                    }
                                                }else{
                                                    if(play_path != null){
                                                        File f = new File(play_path);
                                                        if(f.isDirectory()){
                                                            count = count + ep_path.length;
                                                            File[] play_paths = ep_path;
                                                            File dire1 = new File(menu3.getText() + folderName);
                                                            dire1.mkdir();
                                                            File txt = new File(dire1.getPath()+"\\readme.txt");
                                                            try {
                                                                txt.createNewFile();
                                                                try (FileWriter write = new FileWriter(txt)) {
                                                                    write.write(infoText);
                                                                }
                                                            } catch (IOException ex) {
                                                                JOptionPane.showMessageDialog(Home.this, ex.getMessage());
                                                            }
                                                            //copy file conventional way using stream

                                                            ExecutorService service = Executors.newFixedThreadPool(6);
                                                            service.submit(new Runnable(){
                                                                public void run(){

                                                                    int i = 1;
                                                                    for(File fi : play_paths){
                                                                        File source = new File(fi.getPath());
                                                                        File dire = new File(menu3.getText() + folderName);
                                                                        dire.mkdir();
                                                                        String path = dire.getPath()+"\\"+f.getName();

                                                                        File direct = new File(path);
                                                                        direct.mkdir();
                                                                        String path2 = direct.getPath();
                                                                        File dest = new File(path2 + "\\" + fi.getName());

                                                                            copyFileUsingStream(source, dest);
                                                                            if(play_paths.length == i){
                                                                                bipSound();
                                                                                Select.transferHistory(source.getParentFile(), dest);
                                                                            }
                                                                            i++;
                                                                        }

                                                                    }

                                                                });

                                                            }else{
                                                                count++;
                                                                File source = new File(play_path);
                                                                File dire = new File(menu3.getText() + folderName);
                                                                dire.mkdir();
                                                                String path = dire.getPath();

                                                                File txt = new File(dire.getPath()+"\\readme.txt");
                                                                try {
                                                                    txt.createNewFile();
                                                                    try (FileWriter write = new FileWriter(txt)) {
                                                                        write.write(infoText);
                                                                    }
                                                                } catch (IOException ex) {
                                                                    JOptionPane.showMessageDialog(Home.this, ex.getMessage());
                                                                }

                                                                File dest = new File(path +"\\"+ file_name);

                                                                    //copy file conventional way using stream

                                                                    ExecutorService service = Executors.newFixedThreadPool(6);
                                                                    service.submit(new Runnable(){
                                                                        public void run(){

                                                                            copyFileUsingStream(source, dest);
                                                                            bipSound();
                                                                            Select.transferHistory(source.getParentFile(), dest);

                                                                        }
                                                                    });
                                                                }
                                                            }else{
                                                                JOptionPane.showMessageDialog(Home.this, "Please select at least one drive or file.");
                                                            }
                                                        }
                                                    });                                 break;
                                                }
                                            }
                                        }

                                        jMenuItem22.setText("Change Music Album Art");
                                        jMenuItem22.addActionListener(new java.awt.event.ActionListener() {
                                            public void actionPerformed(java.awt.event.ActionEvent evt) {
                                                jMenuItem22ActionPerformed(evt);
                                            }
                                        });
                                        jMenu1.add(jMenuItem22);

                                        jMenuItem10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/moviestore/Icons/shutdown_25px.png"))); // NOI18N
                                        jMenuItem10.setText("Exit");
                                        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
                                            public void actionPerformed(java.awt.event.ActionEvent evt) {
                                                jMenuItem10ActionPerformed(evt);
                                            }
                                        });
                                        jMenu1.add(jMenuItem10);

                                        jMenuBar1.add(jMenu1);

                                        jMenu2.setText("Tools");
                                        jMenu2.addActionListener(new java.awt.event.ActionListener() {
                                            public void actionPerformed(java.awt.event.ActionEvent evt) {
                                                jMenu2ActionPerformed(evt);
                                            }
                                        });

                                        jMenuItem16.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_H, java.awt.event.InputEvent.CTRL_MASK));
                                        jMenuItem16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/moviestore/Icons/clock_25px.png"))); // NOI18N
                                        jMenuItem16.setText("History");
                                        jMenuItem16.addActionListener(new java.awt.event.ActionListener() {
                                            public void actionPerformed(java.awt.event.ActionEvent evt) {
                                                jMenuItem16ActionPerformed(evt);
                                            }
                                        });
                                        jMenu2.add(jMenuItem16);

                                        jMenu5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/moviestore/Icons/settings_25px.png"))); // NOI18N
                                        jMenu5.setText("Setting");

                                        jMenuItem12.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_T, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
                                        jMenuItem12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/moviestore/Icons/change_theme_25px.png"))); // NOI18N
                                        jMenuItem12.setText("Theme and Font and Notif...");
                                        jMenuItem12.addActionListener(new java.awt.event.ActionListener() {
                                            public void actionPerformed(java.awt.event.ActionEvent evt) {
                                                jMenuItem12ActionPerformed(evt);
                                            }
                                        });
                                        jMenu5.add(jMenuItem12);

                                        jMenuItem17.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
                                        jMenuItem17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/moviestore/Icons/more_info_25px.png"))); // NOI18N
                                        jMenuItem17.setText("About You");
                                        jMenuItem17.addActionListener(new java.awt.event.ActionListener() {
                                            public void actionPerformed(java.awt.event.ActionEvent evt) {
                                                jMenuItem17ActionPerformed(evt);
                                            }
                                        });
                                        jMenu5.add(jMenuItem17);

                                        jMenu2.add(jMenu5);

                                        jMenuBar1.add(jMenu2);

                                        jMenu3.setText("Help");

                                        jMenuItem13.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_H, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
                                        jMenuItem13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/moviestore/Icons/help_25px.png"))); // NOI18N
                                        jMenuItem13.setText("Help Contents");
                                        jMenuItem13.addActionListener(new java.awt.event.ActionListener() {
                                            public void actionPerformed(java.awt.event.ActionEvent evt) {
                                                jMenuItem13ActionPerformed(evt);
                                            }
                                        });
                                        jMenu3.add(jMenuItem13);

                                        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_K, java.awt.event.InputEvent.CTRL_MASK));
                                        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/moviestore/Icons/keyboard_25px.png"))); // NOI18N
                                        jMenuItem2.setText("Keyboard Shortcuts");
                                        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
                                            public void actionPerformed(java.awt.event.ActionEvent evt) {
                                                jMenuItem2ActionPerformed(evt);
                                            }
                                        });
                                        jMenu3.add(jMenuItem2);

                                        jMenuItem14.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
                                        jMenuItem14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/moviestore/Icons/about_25px.png"))); // NOI18N
                                        jMenuItem14.setText("About Infinity Movie Store");
                                        jMenuItem14.addActionListener(new java.awt.event.ActionListener() {
                                            public void actionPerformed(java.awt.event.ActionEvent evt) {
                                                jMenuItem14ActionPerformed(evt);
                                            }
                                        });
                                        jMenu3.add(jMenuItem14);

                                        jMenuItem21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/moviestore/Icons/update_25px.png"))); // NOI18N
                                        jMenuItem21.setText("Check for Update");
                                        jMenuItem21.addActionListener(new java.awt.event.ActionListener() {
                                            public void actionPerformed(java.awt.event.ActionEvent evt) {
                                                jMenuItem21ActionPerformed(evt);
                                            }
                                        });
                                        jMenu3.add(jMenuItem21);

                                        jMenuBar1.add(jMenu3);

                                        setJMenuBar(jMenuBar1);

                                        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
                                        getContentPane().setLayout(layout);
                                        layout.setHorizontalGroup(
                                            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(remining, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(reminTime, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(sizeCount, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(sending, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(sendingNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 511, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                            .addGroup(layout.createSequentialGroup()
                                                                                .addGap(10, 10, 10)
                                                                                .addComponent(EditSerial, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                    .addComponent(EditSerial1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                    .addComponent(episodesNumber, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                    .addComponent(recent, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                .addGap(10, 10, 10)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                    .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                    .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                                            .addComponent(selectedPath, javax.swing.GroupLayout.PREFERRED_SIZE, 760, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addGroup(layout.createSequentialGroup()
                                                                .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(searchCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(sortCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(category, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                        .addGap(0, 0, Short.MAX_VALUE)))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(feature, javax.swing.GroupLayout.PREFERRED_SIZE, 529, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        );
                                        layout.setVerticalGroup(
                                            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(feature, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                            .addComponent(sortCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(searchCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(category, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 575, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                    .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING)
                                                                    .addComponent(jButton7, javax.swing.GroupLayout.Alignment.TRAILING)
                                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                                            .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                    .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                    .addGroup(layout.createSequentialGroup()
                                                                        .addComponent(EditSerial, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                        .addComponent(EditSerial1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                        .addComponent(recent, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(episodesNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addGap(42, 42, 42)))))
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addGroup(layout.createSequentialGroup()
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                    .addComponent(remining)
                                                                    .addComponent(reminTime)
                                                                    .addComponent(sizeCount)))
                                                            .addGroup(layout.createSequentialGroup()
                                                                .addGap(10, 10, 10)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                    .addComponent(sending)
                                                                    .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                    .addComponent(sendingNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGap(0, 0, Short.MAX_VALUE)))
                                                        .addComponent(selectedPath, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(8, 8, 8)))
                                                .addContainerGap())
                                        );

                                        pack();
                                    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        selection = null;
        id = 0;
        Add_or_edit add = new Add_or_edit(selection, id, selectedList);
        add.setVisible(true);
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        selection = null;
        id = 0;
        Add_or_edit edit2 = new Add_or_edit(selection, id, selectedList);
        edit2.setVisible(true);
    }//GEN-LAST:event_jMenuItem6ActionPerformed
    
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        selection = null;
        id = 0;
        Add_or_edit_series edit = new Add_or_edit_series(selection, id, selectedList, false);
        edit.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

          File f1;
          FileInputStream fis;
          ImageIcon image;
          Image scaledImage;
          
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        
        Add_or_edit edit2 = new Add_or_edit(editSelected, id, selectedList);
        edit2.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jMenuItem6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem6MouseClicked
        
    }//GEN-LAST:event_jMenuItem6MouseClicked

    private void jMenuItem7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem7MouseClicked
        
    }//GEN-LAST:event_jMenuItem7MouseClicked

    private void jMenu1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jMenu1ItemStateChanged
       
    }//GEN-LAST:event_jMenu1ItemStateChanged

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        
        try {
            Spacecraft sc = (Spacecraft) Select.quarySingleRow(editSelected);
            id = sc.getId();
        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
        Add_or_edit edit2 = new Add_or_edit(editSelected, id, selectedList);
        edit2.setVisible(true);
        
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        
        if(null != play_path){
            File file = new File(play_path);
            try {
                Desktop.getDesktop().open(file);
            } catch (IOException ex) {
                Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            
            JOptionPane.showMessageDialog(this, "Please select at least one video or audio from the list!");
        }
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        category.setSelectedIndex(0);
        refreshLists();
        categorySelected = false;
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        if(null != play_path){
            File file = new File(play_path);
            try {
                Desktop.getDesktop().open(file);
            } catch (IOException ex) {
                Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    
    private void jList15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList15MouseClicked
        driverRootSelected(evt);
    }//GEN-LAST:event_jList15MouseClicked

    private void formMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseMoved
        
    }//GEN-LAST:event_formMouseMoved

    private void jPanel14MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel14MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel14MouseMoved

    private void jList15MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList15MouseMoved
        
    }//GEN-LAST:event_jList15MouseMoved

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        try {
            transferAllFile();
        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void searchFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchFieldKeyTyped
        String searchString = searchField.getText();
        String searching = "title";
        switch (searchCombo.getSelectedIndex()) {
            case 0:
                searching = "title";
                break;
            case 1:
                searching = "sub_genre";
                break;
            case 2:
                searching = "created_year";
                break;
            case 3:
                searching = "language";
                break;
            case 4:
                searching = "actors";
                break;
            case 5:
                searching = "directors";
                break;
            case 6:
                searching = "arrangement";
                break;
            default:
                break;
        }
        
        Select select = new Select();
        if(categorySelected){
            search1items = select.searchListMediaInJListCatagory(jList1, Home.this, searching, searchString, "Action or Adventure", searching2, sort, cata);
        search2items = select.searchAllListMediaInJListCatagory(jList2, Home.this, searching, searchString, searching2, sort, cata);
        search3items = select.searchListMediaInJListCatagory(jList3, Home.this, searching, searchString,"Comedy film", searching2, sort, cata);
        search4items = select.searchListMediaInJListCatagory(jList4, Home.this, searching, searchString, "Crime and Gangster", searching2, sort, cata);
        search5items = select.searchListMediaInJListCatagory(jList5, Home.this, searching, searchString, "Drama", searching2, sort, cata);
        search6items = select.searchListMediaInJListCatagory(jList6, Home.this, searching, searchString, "Epics or historical", searching2, sort, cata);
        search7items = select.searchListMediaInJListCatagory(jList7, Home.this, searching, searchString, "Horror", searching2, sort, cata);
        search8items = select.searchListMediaInJListCatagory(jList8, Home.this, searching, searchString, "Musicals and dance", searching2, sort, cata);
        search9items = select.searchListMediaInJListCatagory(jList9, Home.this, searching, searchString, "Science and Fiction (Sci-Fi)", searching2, sort, cata);
        search10items = select.searchListMediaInJListCatagory(jList10, Home.this, searching, searchString, "War", searching2, sort, cata);
        search11items = select.searchListMediaInJListCatagory(jList11, Home.this, searching, searchString, "Westerns", searching2, sort, cata);
        search12items = select.searchListMediaInJListCatagory(jList12, Home.this, searching, searchString, "Tv shows", searching2, sort, cata);
        search13items = select.searchListMediaInJListCatagory(jList13, Home.this, searching, searchString, "Funny video", searching2, sort, cata);
        search14items = select.searchListMediaInJListCatagory(jList14, Home.this, searching, searchString, "Amazing video", searching2, sort, cata);
        search16items = select.searchListMediaInJListCatagory(jList16, Home.this, searching, searchString, "Adult video", searching2, sort, cata);
        search17items = select.searchListMediaInJListCatagory(jList17, Home.this, searching, searchString, "Music video", searching2, sort, cata);
        search18items = select.searchListMediaInJListCatagory(jList8, Home.this, searching, searchString, "Christian video", searching2, sort, cata);
        search19items = select.searchListMediaInJListCatagory(jList9, Home.this, searching, searchString, "Islamic video", searching2, sort, cata);
        search20items = select.searchListMediaInJListCatagory(jList20, Home.this, searching, searchString, "Other religion video", searching2, sort, cata);
        search21items = select.searchListMediaInJListCatagory(jList21, Home.this, searching, searchString, "Native film", searching2, sort, cata);
        search22items = select.searchListMediaInJListCatagory(jList22, Home.this, searching, searchString, "Native Tv shows", searching2, sort, cata);
        search23items = select.searchListMediaInJListCatagory(jList23, Home.this, searching, searchString, "Native fun video", searching2, sort, cata);
        search24items = select.searchListMediaInJListCatagory(jList24, Home.this, searching, searchString, "Native music video", searching2, sort, cata);
        search25items = select.searchListMediaInJListCatagory(jList25, Home.this, searching, searchString, "Foreign Music / Audio", searching2, sort, cata);
        search26items = select.searchListMediaInJListCatagory(jList26, Home.this, searching, searchString, "Native Music / Audio", searching2, sort, cata);
        search27items = select.searchListMediaInJListCatagory(jList27, Home.this, searching, searchString, "Religion Music / Audio", searching2, sort, cata);
        search28items = select.searchListMediaInJListCatagory(jList28, Home.this, searching, searchString, "Anniversary Music / Audio", searching2, sort, cata);
        search29items = select.searchListMediaInJListCatagory(jList29, Home.this, searching, searchString, "Other", searching2, sort, cata);
        }else{
            search1items = select.searchListMediaInJList(jList1, Home.this, searching, searchString, "Action or Adventure", searching2, sort);
        search2items = select.searchAllListMediaInJList(jList2, Home.this, searching, searchString, searching2, sort);
        search3items = select.searchListMediaInJList(jList3, Home.this, searching, searchString,"Comedy film", searching2, sort);
        search4items = select.searchListMediaInJList(jList4, Home.this, searching, searchString, "Crime and Gangster", searching2, sort);
        search5items = select.searchListMediaInJList(jList5, Home.this, searching, searchString, "Drama", searching2, sort);
        search6items = select.searchListMediaInJList(jList6, Home.this, searching, searchString, "Epics or historical", searching2, sort);
        search7items = select.searchListMediaInJList(jList7, Home.this, searching, searchString, "Horror", searching2, sort);
        search8items = select.searchListMediaInJList(jList8, Home.this, searching, searchString, "Musicals and dance", searching2, sort);
        search9items = select.searchListMediaInJList(jList9, Home.this, searching, searchString, "Science and Fiction (Sci-Fi)", searching2, sort);
        search10items = select.searchListMediaInJList(jList10, Home.this, searching, searchString, "War", searching2, sort);
        search11items = select.searchListMediaInJList(jList11, Home.this, searching, searchString, "Westerns", searching2, sort);
        search12items = select.searchListMediaInJList(jList12, Home.this, searching, searchString, "Tv shows", searching2, sort);
        search13items = select.searchListMediaInJList(jList13, Home.this, searching, searchString, "Funny video", searching2, sort);
        search14items = select.searchListMediaInJList(jList14, Home.this, searching, searchString, "Amazing video", searching2, sort);
        search16items = select.searchListMediaInJList(jList16, Home.this, searching, searchString, "Adult video", searching2, sort);
        search17items = select.searchListMediaInJList(jList17, Home.this, searching, searchString, "Music video", searching2, sort);
        search18items = select.searchListMediaInJList(jList8, Home.this, searching, searchString, "Christian video", searching2, sort);
        search19items = select.searchListMediaInJList(jList9, Home.this, searching, searchString, "Islamic video", searching2, sort);
        search20items = select.searchListMediaInJList(jList20, Home.this, searching, searchString, "Other religion video", searching2, sort);
        search21items = select.searchListMediaInJList(jList21, Home.this, searching, searchString, "Native film", searching2, sort);
        search22items = select.searchListMediaInJList(jList22, Home.this, searching, searchString, "Native Tv shows", searching2, sort);
        search23items = select.searchListMediaInJList(jList23, Home.this, searching, searchString, "Native fun video", searching2, sort);
        search24items = select.searchListMediaInJList(jList24, Home.this, searching, searchString, "Native music video", searching2, sort);
        search25items = select.searchListMediaInJList(jList25, Home.this, searching, searchString, "Foreign Music / Audio", searching2, sort);
        search26items = select.searchListMediaInJList(jList26, Home.this, searching, searchString, "Native Music / Audio", searching2, sort);
        search27items = select.searchListMediaInJList(jList27, Home.this, searching, searchString, "Religion Music / Audio", searching2, sort);
        search28items = select.searchListMediaInJList(jList28, Home.this, searching, searchString, "Anniversary Music / Audio", searching2, sort);
        search29items = select.searchListMediaInJList(jList29, Home.this, searching, searchString, "Other", searching2, sort);
        }
        
    }//GEN-LAST:event_searchFieldKeyTyped

    private void sortComboItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_sortComboItemStateChanged
        
        searching2 = "title";
        sort = "asc";
        switch (searchCombo.getSelectedIndex()) {
            case 0:
                searching2 = "title";
                sort = "desc";
                break;
            case 1:
                searching2 = "title";
                sort = "asc";
                break;
            case 2:
                searching2 = "created_year";
                sort = "desc";
                break;
            case 3:
                searching2 = "modified_at";
                sort = "desc";
                break;
            default:
                break;
        }
        
    }//GEN-LAST:event_sortComboItemStateChanged

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        deleteRow();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        deleteRow();
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed
        try {
            transferAllFile();
        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jMenuItem11ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        DefaultListModel listModel = new DefaultListModel();
        listModel.clear();
        jList2.setModel(listModel);
        Select select1 = new Select();
        jlist2items = Select.listAllMediaInJList(jList2, Home.this, searching2, sort);
        jButton4.setEnabled(false);
        jButton3.setEnabled(false);
        jButton6.setEnabled(false);
        jButton7.setEnabled(false);
        jMenuItem7.setEnabled(false);
        jMenuItem8.setEnabled(false);
        jMenuItem9.setEnabled(false);
        jMenuItem11.setEnabled(false);
        jMenu4.setEnabled(false);
        selection = null;
        play_path = null;
        id = 0;
        
               title.setText("");
               size.setText("");
               type.setText("");
               duration.setText("");
               year.setText("");
               language.setText("");
               genre.setText("");
               season.setText("");
               episode.setText("");
               actors.setText("");
               director.setText("");
               producer.setText("");
               editor.setText("");
               writer.setText("");
               musician.setText("");
               photographer.setText("");
               publisher.setText("");
               content_provider.setText("");
               arrangement.setText("");
               feature.setText("");
               cover_image.setText("No image");
               cover_image.setIcon(null);
               
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void episodesListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_episodesListMouseClicked
        findSelectedFile(episodesList);
        EditSerial1.setEnabled(true);
        if(episodesList.getSelectedIndex()>-1){
        if(evt.getClickCount()==2){
            if(null != play_path){
            File file = new File(play_path);
            try {
                Desktop.getDesktop().open(file);
            } catch (IOException ex) {
                Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            
            JOptionPane.showMessageDialog(this, "Please select at least one video or audio from the list!");
        }
        } else{
            Spacecraft s = null;
            if(recentButtonClicked){
                String name = items[episodesList.getSelectedIndex()];
                selection = name;

                try {
                    s = (Spacecraft) Select.quarySingleRecentEpisode(name);
                } catch (SQLException ex) {
                    Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                play_path = s.getMedia_fullPath();
               selectedPath.setText(play_path);
               file_name = s.getTitle_field();
               sizes = String.valueOf(s.getSize());
                
            }else{
                try {
            String name = items[episodesList.getSelectedIndex()];
            selection = name;
            
            s = (Spacecraft) Select.quarySingleEpisode(name);
            
               
        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        title.setText(s.getTitle_field());
        double l1 = 0;
        double valueMB = 0,valueGB = 0;
            
                l1 = Double.parseDouble(String.valueOf(s.getSize()));
               
               if(l1<1024){
                   valueMB = 0.0;
               }else{
                   valueMB = Math.round(l1/1024);
               }
               if(valueMB<1024){
                   valueGB = 0.0;
               }else{
                   valueGB = Math.round(valueMB/1024);
               }
        
               
               
               size.setText(String.valueOf(l1)+ " KB/" +String.valueOf(valueMB)+" MB/"+String.valueOf(valueGB)+" GB");
               type.setText(s.getFileType());
               year.setText(s.getYear());
               language.setText(s.getLanguage());
               season.setText(s.getSeason());
               episode.setText(s.getEpisodes());
               
               play_path = s.getMedia_fullPath();
               selectedPath.setText(play_path);
               id = s.getId();
               file_name = s.getTitle_field();
               sizes = String.valueOf(s.getSize());
            }
            
        
               
        }
        jButton4.setEnabled(true);
        jButton3.setEnabled(true);
        jButton7.setEnabled(true);
        
        if(play_path != null && drivePath != null){
            jButton6.setEnabled(true);
            jMenuItem11.setEnabled(true);
            jMenu4.setEnabled(true);
        }
        
        jMenuItem7.setEnabled(true);
        jMenuItem8.setEnabled(true);
        jMenuItem9.setEnabled(true);
        }
    }//GEN-LAST:event_episodesListMouseClicked

    private void episodesListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_episodesListValueChanged
        findSelectedFile(episodesList);
        int[] indexs = episodesList.getSelectedIndices();
        int a = 0;
        String[] selectedFile1 = new String[indexs.length];
        while(a<indexs.length){
            
            selectedFile1[a] = items[indexs[a]];
            a++;
        }
        selectedFile = selectedFile1;
        if(episodesList.getSelectedIndex()!=-1){
            Spacecraft s = null;
            if(recentButtonClicked){
                String name = items[episodesList.getSelectedIndex()];
                selection = name;

                try {
                    s = (Spacecraft) Select.quarySingleRecentEpisode(name);
                } catch (SQLException ex) {
                    Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                play_path = s.getMedia_fullPath();
               selectedPath.setText(play_path);
               file_name = s.getTitle_field();
               sizes = String.valueOf(s.getSize());
                
            }else{
                try {
            String name = items[episodesList.getSelectedIndex()];
            selection = name;
            
            s = (Spacecraft) Select.quarySingleEpisode(name);
            
               
        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        title.setText(s.getTitle_field());
        double l1 = 0;
        double valueMB = 0,valueGB = 0;
            
                l1 = Double.parseDouble(String.valueOf(s.getSize()));
               
               if(l1<1024){
                   valueMB = 0.0;
               }else{
                   valueMB = Math.round(l1/1024);
               }
               if(valueMB<1024){
                   valueGB = 0.0;
               }else{
                   valueGB = Math.round(valueMB/1024);
               }
        
               
               
               size.setText(String.valueOf(l1)+ " KB/" +String.valueOf(valueMB)+" MB/"+String.valueOf(valueGB)+" GB");
               type.setText(s.getFileType());
               year.setText(s.getYear());
               language.setText(s.getLanguage());
               season.setText(s.getSeason());
               episode.setText(s.getEpisodes());
               
               play_path = s.getMedia_fullPath();
               selectedPath.setText(play_path);
               id = s.getId();
               file_name = s.getTitle_field();
               sizes = String.valueOf(s.getSize());
            }
        
        jButton4.setEnabled(true);
        jButton3.setEnabled(true);
        jButton7.setEnabled(true);
        
        if(play_path != null && drivePath != null){
            jButton6.setEnabled(true);
            jMenuItem11.setEnabled(true);
            jMenu4.setEnabled(true);
        }
        
        jMenuItem7.setEnabled(true);
        jMenuItem8.setEnabled(true);
        jMenuItem9.setEnabled(true);
        }
    }//GEN-LAST:event_episodesListValueChanged

    private void EditSerialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditSerialActionPerformed
        File checkFile = new File(play_path);
        if(checkFile.isDirectory()){
            Add_or_edit_series editSerial = new Add_or_edit_series(selection, id, selectedList, false);
            editSerial.setVisible(true);
        }
        
    }//GEN-LAST:event_EditSerialActionPerformed

    private void jTabbedPane1MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane1MouseMoved

    }//GEN-LAST:event_jTabbedPane1MouseMoved

    private void jList1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList1MousePressed
        listMousePressed(evt, jList1);
    }//GEN-LAST:event_jList1MousePressed

    private void jList1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList1MouseEntered
        
    }//GEN-LAST:event_jList1MouseEntered

    private void jList1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList1MouseClicked
        listMouseClicked(evt, jList1);
    }//GEN-LAST:event_jList1MouseClicked

    private void jList1ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jList1ValueChanged
         displayListValues(jList1);
    }//GEN-LAST:event_jList1ValueChanged

    private void jList3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList3MouseClicked
        listMouseClicked(evt, jList3);
    }//GEN-LAST:event_jList3MouseClicked

    private void jList3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList3MousePressed
        listMousePressed(evt, jList3);
    }//GEN-LAST:event_jList3MousePressed

    private void jList3ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jList3ValueChanged
        displayListValues(jList3);
    }//GEN-LAST:event_jList3ValueChanged

    private void jList4ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jList4ValueChanged
        displayListValues(jList4);
    }//GEN-LAST:event_jList4ValueChanged

    private void jList4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList4MouseClicked
        listMouseClicked(evt, jList4);
    }//GEN-LAST:event_jList4MouseClicked

    private void jList4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList4MousePressed
        listMousePressed(evt, jList4);
    }//GEN-LAST:event_jList4MousePressed

    private void jList5ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jList5ValueChanged
        displayListValues(jList5);
    }//GEN-LAST:event_jList5ValueChanged

    private void jList5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList5MouseClicked
        listMouseClicked(evt, jList5);
    }//GEN-LAST:event_jList5MouseClicked

    private void jList5MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList5MousePressed
        listMousePressed(evt, jList5);
    }//GEN-LAST:event_jList5MousePressed

    private void jList6ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jList6ValueChanged
        displayListValues(jList6);
    }//GEN-LAST:event_jList6ValueChanged

    private void jList6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList6MouseClicked
        listMouseClicked(evt, jList6);
    }//GEN-LAST:event_jList6MouseClicked

    private void jList6MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList6MousePressed
        listMousePressed(evt, jList6);
    }//GEN-LAST:event_jList6MousePressed

    private void jList7ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jList7ValueChanged
        displayListValues(jList7);
    }//GEN-LAST:event_jList7ValueChanged

    private void jList7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList7MouseClicked
        listMouseClicked(evt, jList7);
    }//GEN-LAST:event_jList7MouseClicked

    private void jList7MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList7MousePressed
        listMousePressed(evt, jList7);
    }//GEN-LAST:event_jList7MousePressed

    private void jList8ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jList8ValueChanged
        displayListValues(jList8);
    }//GEN-LAST:event_jList8ValueChanged

    private void jList8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList8MouseClicked
        listMouseClicked(evt, jList8);
    }//GEN-LAST:event_jList8MouseClicked

    private void jList8MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList8MousePressed
        listMousePressed(evt, jList8);
    }//GEN-LAST:event_jList8MousePressed

    private void jList9ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jList9ValueChanged
        displayListValues(jList9);
    }//GEN-LAST:event_jList9ValueChanged

    private void jList9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList9MouseClicked
        listMouseClicked(evt, jList9);
    }//GEN-LAST:event_jList9MouseClicked

    private void jList9MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList9MousePressed
        listMousePressed(evt, jList9);
    }//GEN-LAST:event_jList9MousePressed

    private void jList10ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jList10ValueChanged
        displayListValues(jList10);
    }//GEN-LAST:event_jList10ValueChanged

    private void jList10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList10MouseClicked
        listMouseClicked(evt, jList10);
    }//GEN-LAST:event_jList10MouseClicked

    private void jList10MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList10MousePressed
        listMousePressed(evt, jList10);
    }//GEN-LAST:event_jList10MousePressed

    private void jList11ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jList11ValueChanged
        displayListValues(jList11);
    }//GEN-LAST:event_jList11ValueChanged

    private void jList11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList11MouseClicked
        listMouseClicked(evt, jList11);
    }//GEN-LAST:event_jList11MouseClicked

    private void jList11MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList11MousePressed
        listMousePressed(evt, jList11);
    }//GEN-LAST:event_jList11MousePressed

    private void jList12ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jList12ValueChanged
        displayListValues(jList12);
    }//GEN-LAST:event_jList12ValueChanged

    private void jList12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList12MouseClicked
        listMouseClicked(evt, jList12);
    }//GEN-LAST:event_jList12MouseClicked

    private void jList12MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList12MousePressed
        // TODO add your handling code here:
        listMousePressed(evt, jList12);
    }//GEN-LAST:event_jList12MousePressed

    private void jList13ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jList13ValueChanged
        displayListValues(jList13);
    }//GEN-LAST:event_jList13ValueChanged

    private void jList13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList13MouseClicked
        listMouseClicked(evt, jList13);
    }//GEN-LAST:event_jList13MouseClicked

    private void jList13MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList13MousePressed
        // TODO add your handling code here:
        listMousePressed(evt, jList13);
    }//GEN-LAST:event_jList13MousePressed

    private void jList14ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jList14ValueChanged
        displayListValues(jList14);
    }//GEN-LAST:event_jList14ValueChanged

    private void jList14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList14MouseClicked
        // TODO add your handling code here:
        listMouseClicked(evt, jList14);
    }//GEN-LAST:event_jList14MouseClicked

    private void jList14MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList14MousePressed
        // TODO add your handling code here:
        listMousePressed(evt, jList14);
    }//GEN-LAST:event_jList14MousePressed

    private void jList16ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jList16ValueChanged
        displayListValues(jList16);
    }//GEN-LAST:event_jList16ValueChanged

    private void jList16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList16MouseClicked
        // TODO add your handling code here:
        listMouseClicked(evt, jList16);
    }//GEN-LAST:event_jList16MouseClicked

    private void jList16MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList16MousePressed
        // TODO add your handling code here:
        listMousePressed(evt, jList16);
    }//GEN-LAST:event_jList16MousePressed

    private void jList17ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jList17ValueChanged
        displayListValues(jList17);
    }//GEN-LAST:event_jList17ValueChanged

    private void jList17MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList17MouseClicked
        // TODO add your handling code here:
        listMouseClicked(evt, jList17);
    }//GEN-LAST:event_jList17MouseClicked

    private void jList17MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList17MousePressed
        // TODO add your handling code here:
        listMousePressed(evt, jList17);
    }//GEN-LAST:event_jList17MousePressed

    private void jList18ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jList18ValueChanged
        displayListValues(jList18);
    }//GEN-LAST:event_jList18ValueChanged

    private void jList18MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList18MouseClicked
        // TODO add your handling code here:
        listMouseClicked(evt, jList18);
    }//GEN-LAST:event_jList18MouseClicked

    private void jList18MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList18MousePressed
        // TODO add your handling code here:
        listMousePressed(evt, jList18);
    }//GEN-LAST:event_jList18MousePressed

    private void jList19ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jList19ValueChanged
        displayListValues(jList19);
    }//GEN-LAST:event_jList19ValueChanged

    private void jList19MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList19MouseClicked
        // TODO add your handling code here:
        listMouseClicked(evt, jList19);
    }//GEN-LAST:event_jList19MouseClicked

    private void jList19MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList19MousePressed
        // TODO add your handling code here:
        listMousePressed(evt, jList19);
    }//GEN-LAST:event_jList19MousePressed

    private void jList20ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jList20ValueChanged
        displayListValues(jList20);
    }//GEN-LAST:event_jList20ValueChanged

    private void jList20MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList20MouseClicked
        // TODO add your handling code here:
        listMouseClicked(evt, jList20);
    }//GEN-LAST:event_jList20MouseClicked

    private void jList20MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList20MousePressed
        // TODO add your handling code here:
        listMousePressed(evt, jList20);
    }//GEN-LAST:event_jList20MousePressed

    private void jList21ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jList21ValueChanged
        displayListValues(jList21);
    }//GEN-LAST:event_jList21ValueChanged

    private void jList21MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList21MouseClicked
        // TODO add your handling code here:
        listMouseClicked(evt, jList21);
    }//GEN-LAST:event_jList21MouseClicked

    private void jList21MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList21MousePressed
        // TODO add your handling code here:
        listMousePressed(evt, jList21);
    }//GEN-LAST:event_jList21MousePressed

    private void jList22ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jList22ValueChanged
        displayListValues(jList22);
    }//GEN-LAST:event_jList22ValueChanged

    private void jList22MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList22MouseClicked
        // TODO add your handling code here:
        listMouseClicked(evt, jList22);
    }//GEN-LAST:event_jList22MouseClicked

    private void jList22MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList22MousePressed
        // TODO add your handling code here:
        listMousePressed(evt, jList22);
    }//GEN-LAST:event_jList22MousePressed

    private void jList23ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jList23ValueChanged
        displayListValues(jList23);
    }//GEN-LAST:event_jList23ValueChanged

    private void jList23MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList23MouseClicked
        // TODO add your handling code here:
        listMouseClicked(evt, jList23);
    }//GEN-LAST:event_jList23MouseClicked

    private void jList23MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList23MousePressed
        // TODO add your handling code here:
        listMousePressed(evt, jList23);
    }//GEN-LAST:event_jList23MousePressed

    private void jList24ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jList24ValueChanged
        displayListValues(jList24);
    }//GEN-LAST:event_jList24ValueChanged

    private void jList24MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList24MouseClicked
        // TODO add your handling code here:
        listMouseClicked(evt, jList24);
    }//GEN-LAST:event_jList24MouseClicked

    private void jList24MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList24MousePressed
        // TODO add your handling code here:
        listMousePressed(evt, jList24);
    }//GEN-LAST:event_jList24MousePressed

    private void jList25ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jList25ValueChanged
        displayListValues(jList25);
    }//GEN-LAST:event_jList25ValueChanged

    private void jList25MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList25MouseClicked
        // TODO add your handling code here:
        listMouseClicked(evt, jList25);
    }//GEN-LAST:event_jList25MouseClicked

    private void jList25MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList25MousePressed
        // TODO add your handling code here:
        listMousePressed(evt, jList25);
    }//GEN-LAST:event_jList25MousePressed

    private void jList26ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jList26ValueChanged
        displayListValues(jList26);
    }//GEN-LAST:event_jList26ValueChanged

    private void jList26MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList26MouseClicked
        // TODO add your handling code here:
        listMouseClicked(evt, jList26);
    }//GEN-LAST:event_jList26MouseClicked

    private void jList26MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList26MousePressed
        // TODO add your handling code here:
        listMousePressed(evt, jList26);
    }//GEN-LAST:event_jList26MousePressed

    private void jList27ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jList27ValueChanged
        displayListValues(jList27);
    }//GEN-LAST:event_jList27ValueChanged

    private void jList27MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList27MouseClicked
        // TODO add your handling code here:
        listMouseClicked(evt, jList27);
    }//GEN-LAST:event_jList27MouseClicked

    private void jList27MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList27MousePressed
        // TODO add your handling code here:
        listMousePressed(evt, jList27);
    }//GEN-LAST:event_jList27MousePressed

    private void jList28ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jList28ValueChanged
        displayListValues(jList28);
    }//GEN-LAST:event_jList28ValueChanged

    private void jList28MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList28MouseClicked
        // TODO add your handling code here:
        listMouseClicked(evt, jList28);
    }//GEN-LAST:event_jList28MouseClicked

    private void jList28MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList28MousePressed
        // TODO add your handling code here:
        listMousePressed(evt, jList28);
    }//GEN-LAST:event_jList28MousePressed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        
    }//GEN-LAST:event_formWindowOpened

    private void jList1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jList1KeyPressed
        findSelectedFile(jList1);
    }//GEN-LAST:event_jList1KeyPressed

    private void jList3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jList3KeyPressed
         findSelectedFile(jList3);
    }//GEN-LAST:event_jList3KeyPressed

    private void jList4KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jList4KeyPressed
        findSelectedFile(jList4);
    }//GEN-LAST:event_jList4KeyPressed

    private void jList5KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jList5KeyPressed
        findSelectedFile(jList5);
    }//GEN-LAST:event_jList5KeyPressed

    private void jList6KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jList6KeyPressed
        findSelectedFile(jList6);
    }//GEN-LAST:event_jList6KeyPressed

    private void jList7KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jList7KeyPressed
        findSelectedFile(jList7);
    }//GEN-LAST:event_jList7KeyPressed

    private void jList8KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jList8KeyPressed
        findSelectedFile(jList8);
    }//GEN-LAST:event_jList8KeyPressed

    private void jList9KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jList9KeyPressed
         findSelectedFile(jList9);
    }//GEN-LAST:event_jList9KeyPressed

    private void jList10KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jList10KeyPressed
         findSelectedFile(jList10);
    }//GEN-LAST:event_jList10KeyPressed

    private void jList11KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jList11KeyPressed
        findSelectedFile(jList11);
    }//GEN-LAST:event_jList11KeyPressed

    private void jList12KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jList12KeyPressed
        findSelectedFile(jList12);
    }//GEN-LAST:event_jList12KeyPressed

    private void jList13KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jList13KeyPressed
        findSelectedFile(jList13);
    }//GEN-LAST:event_jList13KeyPressed

    private void jList14KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jList14KeyPressed
        findSelectedFile(jList14);
    }//GEN-LAST:event_jList14KeyPressed

    private void jList16KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jList16KeyPressed
        findSelectedFile(jList16);
    }//GEN-LAST:event_jList16KeyPressed

    private void jList17KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jList17KeyPressed
         findSelectedFile(jList17);
    }//GEN-LAST:event_jList17KeyPressed

    private void jList18KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jList18KeyPressed
         findSelectedFile(jList18);
    }//GEN-LAST:event_jList18KeyPressed

    private void jList19KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jList19KeyPressed
         findSelectedFile(jList19);
    }//GEN-LAST:event_jList19KeyPressed

    private void jList20KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jList20KeyPressed
        findSelectedFile(jList20);
    }//GEN-LAST:event_jList20KeyPressed

    private void jList21KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jList21KeyPressed
        findSelectedFile(jList21);
    }//GEN-LAST:event_jList21KeyPressed

    private void jList22KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jList22KeyPressed
        findSelectedFile(jList22);
    }//GEN-LAST:event_jList22KeyPressed

    private void jList23KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jList23KeyPressed
        findSelectedFile(jList23);
    }//GEN-LAST:event_jList23KeyPressed

    private void jList24KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jList24KeyPressed
        findSelectedFile(jList24);
    }//GEN-LAST:event_jList24KeyPressed

    private void jList25KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jList25KeyPressed
        findSelectedFile(jList25);
    }//GEN-LAST:event_jList25KeyPressed

    private void jList26KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jList26KeyPressed
         findSelectedFile(jList26);
    }//GEN-LAST:event_jList26KeyPressed

    private void jList27KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jList27KeyPressed
         findSelectedFile(jList27);
    }//GEN-LAST:event_jList27KeyPressed

    private void jList28KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jList28KeyPressed
         findSelectedFile(jList28);
    }//GEN-LAST:event_jList28KeyPressed

    private void jList29KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jList29KeyPressed
         findSelectedFile(jList29);
    }//GEN-LAST:event_jList29KeyPressed

    private void jList29ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jList29ValueChanged
         displayListValues(jList29);
    }//GEN-LAST:event_jList29ValueChanged

    private void jList29MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList29MouseClicked
        listMouseClicked(evt, jList29);
    }//GEN-LAST:event_jList29MouseClicked

    private void jList29MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList29MousePressed
        listMousePressed(evt, jList29);
    }//GEN-LAST:event_jList29MousePressed

    private void EditSerial1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditSerial1ActionPerformed
        deleteRow();
    }//GEN-LAST:event_EditSerial1ActionPerformed

    private void episodesListKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_episodesListKeyPressed
         findSelectedFile(episodesList);
    }//GEN-LAST:event_episodesListKeyPressed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        refreshLists();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        if(transfering){
            int pane = JOptionPane.showConfirmDialog(Home.this, "Transfering will be terminated!", "Exit?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                    if(pane == 0){
                        System.exit(0);
                    }
        }else{
            int pane = JOptionPane.showConfirmDialog(Home.this, "Exit?", "Exit?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                    if(pane == 0){
                        System.exit(0);
                    }
        }
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void jList15KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jList15KeyPressed
        
    }//GEN-LAST:event_jList15KeyPressed

    private void jList15ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jList15ValueChanged
        driverSelected();
    }//GEN-LAST:event_jList15ValueChanged

    private void jList2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jList2KeyPressed
        findSelectedFile(jList2);
    }//GEN-LAST:event_jList2KeyPressed

    private void jList2ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jList2ValueChanged
        displayListValues(jList2);
    }//GEN-LAST:event_jList2ValueChanged

    private void jList2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList2MouseClicked
        listMouseClicked(evt, jList2);
    }//GEN-LAST:event_jList2MouseClicked

    private void jList2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList2MousePressed
         listMousePressed(evt, jList2);
    }//GEN-LAST:event_jList2MousePressed

    private void jList15MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList15MousePressed
        if(SwingUtilities.isRightMouseButton(evt)){
            JPopupMenu popup = new JPopupMenu("open");
            JMenuItem open = new JMenuItem("Open path");
            open.addActionListener((ActionEvent e) -> {
                if(jList15.getSelectedIndex()<oldListRoot.length && jList15.getSelectedIndex()>-1){
                    File file = new File(oldListRoot[jList15.getSelectedIndex()].getPath());
                    
                    try {
                        if(file.exists()){
                            Desktop.getDesktop().open(file);
                        }
                        
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(this, ex.getMessage());
                    }
                }
            });
            popup.add(open);
            popup.show(this, evt.getXOnScreen(), evt.getYOnScreen());
                                    jList15.setSelectedIndex(getRow(evt.getPoint(), jList15));
        }
    }//GEN-LAST:event_jList15MousePressed

    private void jMenu2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu2ActionPerformed
         
    }//GEN-LAST:event_jMenu2ActionPerformed

    private void jMenuItem16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem16ActionPerformed
       History history = new History();
         history.setVisible(true);
    }//GEN-LAST:event_jMenuItem16ActionPerformed

    private void jMenuItem12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem12ActionPerformed
        JList[] lists = {jList1,jList2,jList3,jList4,jList5,jList6,jList7,jList8,jList9,jList10,jList12,jList13,jList14,jList16,jList17,jList18,jList19,jList20,jList21,jList22,jList23,jList24,jList25,jList26,jList27,jList28,jList29};
        try {
            this.stmt = conn.prepareStatement("select * from setting");
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                if(rs.getRow()>0){
                    lookAndFeel = rs.getString("lookAndFeel");
                }
                
                }
        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
        Setting setting = new Setting(Home.this, lookAndFeel, lists, jList1.getFont(),jList1.getForeground(),jList15.getBackground());
         setting.setVisible(true);
    }//GEN-LAST:event_jMenuItem12ActionPerformed

    private void jMenuItem17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem17ActionPerformed
        AboutYou aboutYou = new AboutYou(this);
        aboutYou.setVisible(true);
    }//GEN-LAST:event_jMenuItem17ActionPerformed

    private void cover_imageMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cover_imageMouseClicked
         
             if(evt.getClickCount()==2){
                if(null != openImage){
                    File file = new File(openImage);
                    try {
                        Desktop.getDesktop().open(file);
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(this, ex.getMessage());
                    }
                } else {

                    JOptionPane.showMessageDialog(this, "Please select at least one video or audio from the list!");
                }
            }
    }//GEN-LAST:event_cover_imageMouseClicked

    private void jMenuItem18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem18ActionPerformed
        selection = null;
        id = 0;
        Add_or_edit_series edit = new Add_or_edit_series(selection, id, selectedList, false);
        edit.setVisible(true);
    }//GEN-LAST:event_jMenuItem18ActionPerformed

    private void jMenuItem13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem13ActionPerformed
         HelpContent helpContent = new HelpContent();
         helpContent.setVisible(true);
    }//GEN-LAST:event_jMenuItem13ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        ShortKey shortKey = new ShortKey();
        shortKey.setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem14ActionPerformed
        AboutInfinity about = new AboutInfinity();
        about.setVisible(true);
    }//GEN-LAST:event_jMenuItem14ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
         JFileChooser chooser = new JFileChooser();
         chooser.setDialogTitle("Choose the destination folder");
           chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
           int returnVal = chooser.showOpenDialog(this);
           if(returnVal == JFileChooser.APPROVE_OPTION){
               String source = System.getProperty("user.dir")+"\\Database\\moviestore.accdb";
               File s = new File(source);
               String destination = chooser.getSelectedFile().getPath()+"\\"+s.getName();
               File d = new File(destination);
               count++;
               copyFileUsingStream(s, d);
               JOptionPane.showMessageDialog(this, "Backup Completed!\n"+destination);
           }
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
//        String test = Home.class.getProtectionDomain().getCodeSource().getLocation().getPath();
//            JOptionPane.showMessageDialog(this, test);
    }//GEN-LAST:event_formMouseClicked

    private void recentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_recentActionPerformed
        recentButtonClicked = true;
        jPanel15.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Recent", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 12)));
        
        Select sele = new Select();
            recentitems = Select.listRecentMediaInEpisodes(episodesList,Home.this);
            
    }//GEN-LAST:event_recentActionPerformed

    private void jMenuItem20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem20ActionPerformed
       if(play_path != null){
           File checkFile = new File(play_path);
        if(checkFile.isDirectory()){
            Add_or_edit_series editSerial = new Add_or_edit_series(selection, id, selectedList, false);
            editSerial.setVisible(true);
        }
       }
        
    }//GEN-LAST:event_jMenuItem20ActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        if(transfering){
            int pane = JOptionPane.showConfirmDialog(Home.this, "Transfering will be terminated!", "Exit?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                    if(pane == 0){
                        System.exit(0);
                    }
        }else{
            int pane = JOptionPane.showConfirmDialog(Home.this, "Exit?", "Exit?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                    if(pane == 0){
                        System.exit(0);
                    }
        }
        
    }//GEN-LAST:event_formWindowClosing

    private void jMenuItem21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem21ActionPerformed
       try {
             URI uri = new URI("https://t.me/Infinity_movie_store");
                Desktop.getDesktop().browse(uri);
            } catch (URISyntaxException | IOException ex) {
            Logger.getLogger(Add_or_edit_series.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jMenuItem21ActionPerformed

    private void categoryItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_categoryItemStateChanged
        categorySelected = true;
        cata = category.getSelectedItem().toString();
        DefaultListModel listModel = new DefaultListModel();
        listModel.clear();
        jList1.setModel(listModel);
        jList2.setModel(listModel);
        jList3.setModel(listModel);
        jList4.setModel(listModel);
        jList5.setModel(listModel);
        jList6.setModel(listModel);
        jList7.setModel(listModel);
        jList8.setModel(listModel);
        jList9.setModel(listModel);
        jList10.setModel(listModel);
        jList11.setModel(listModel);
        jList12.setModel(listModel);
        jList13.setModel(listModel);
        jList14.setModel(listModel);
        jList16.setModel(listModel);
        jList17.setModel(listModel);
        jList18.setModel(listModel);
        jList19.setModel(listModel);
        jList20.setModel(listModel);
        jList21.setModel(listModel);
        jList22.setModel(listModel);
        jList23.setModel(listModel);
        jList24.setModel(listModel);
        jList25.setModel(listModel);
        jList26.setModel(listModel);
        jList27.setModel(listModel);
        jList28.setModel(listModel);
        jList29.setModel(listModel);
        Select select = new Select();
        jlist1items = select.ListMediaInJListCategory(jList1, Home.this,"Action or Adventure", searching2, sort, cata);
        jlist2items = select.AllListMediaInJListCategory(jList2, Home.this, searching2, sort, cata);
        jlist3items = select.ListMediaInJListCategory(jList3, Home.this,"Comedy film", searching2, sort, cata);
        jlist4items = select.ListMediaInJListCategory(jList4, Home.this,"Crime and Gangster", searching2, sort, cata);
        jlist5items = select.ListMediaInJListCategory(jList5, Home.this,"Drama", searching2, sort, cata);
        jlist6items = select.ListMediaInJListCategory(jList6, Home.this,"Epics or historical", searching2, sort, cata);
        jlist7items = select.ListMediaInJListCategory(jList7, Home.this,"Horror", searching2, sort, cata);
        jlist8items = select.ListMediaInJListCategory(jList8, Home.this,"Musicals and dance", searching2, sort, cata);
        jlist9items = select.ListMediaInJListCategory(jList9, Home.this,"Science and Fiction (Sci-Fi)", searching2, sort, cata);
        jlist10items = select.ListMediaInJListCategory(jList10, Home.this,"War", searching2, sort, cata);
        jlist11items = select.ListMediaInJListCategory(jList11, Home.this,"Westerns", searching2, sort, cata);
        jlist12items = select.ListMediaInJListCategory(jList12, Home.this,"Tv shows", searching2, sort, cata);
        jlist13items = select.ListMediaInJListCategory(jList13, Home.this,"Funny video", searching2, sort, cata);
        jlist14items = select.ListMediaInJListCategory(jList14, Home.this,"Amazing video", searching2, sort, cata);
        jlist16items = select.ListMediaInJListCategory(jList16, Home.this,"Adult video", searching2, sort, cata);
        jlist17items = select.ListMediaInJListCategory(jList17, Home.this,"Music video", searching2, sort, cata);
        jlist18items = select.ListMediaInJListCategory(jList8, Home.this,"Christian video", searching2, sort, cata);
        jlist19items = select.ListMediaInJListCategory(jList9, Home.this,"Islamic video", searching2, sort, cata);
        jlist20items = select.ListMediaInJListCategory(jList20, Home.this,"Other religion video", searching2, sort, cata);
        jlist21items = select.ListMediaInJListCategory(jList21, Home.this,"Native film", searching2, sort, cata);
        jlist22items = select.ListMediaInJListCategory(jList22, Home.this,"Native Tv shows", searching2, sort, cata);
        jlist23items = select.ListMediaInJListCategory(jList23, Home.this,"Native fun video", searching2, sort, cata);
        jlist24items = select.ListMediaInJListCategory(jList24, Home.this,"Native music video", searching2, sort, cata);
        jlist25items = select.ListMediaInJListCategory(jList25, Home.this,"Foreign Music / Audio", searching2, sort, cata);
        jlist26items = select.ListMediaInJListCategory(jList26, Home.this,"Native Music / Audio", searching2, sort, cata);
        jlist27items = select.ListMediaInJListCategory(jList27, Home.this,"Religion Music / Audio", searching2, sort, cata);
        jlist28items = select.ListMediaInJListCategory(jList28, Home.this,"Anniversary Music / Audio", searching2, sort, cata);
        jlist29items = select.ListMediaInJListCategory(jList29, Home.this,"Other", searching2, sort, cata);
        jButton4.setEnabled(false);
                    jButton3.setEnabled(false);
                    jButton6.setEnabled(false);
                    jButton7.setEnabled(false);
                    jMenuItem7.setEnabled(false);
                    jMenuItem8.setEnabled(false);
                    jMenuItem9.setEnabled(false);
                    jMenuItem11.setEnabled(false);
                    jMenu4.setEnabled(false);
                    EditSerial.setEnabled(false);
                    EditSerial1.setEnabled(false);
                    selection = null;
                    play_path = null;
                    id = 0;
                    episodesList.setModel(listModel);
                    remining.setVisible(false);
    }//GEN-LAST:event_categoryItemStateChanged

    private void jMenuItem22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem22ActionPerformed
         MusicAlbum musicAlbum = new MusicAlbum();
         musicAlbum.setVisible(true);
    }//GEN-LAST:event_jMenuItem22ActionPerformed

    private void cover_imageMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cover_imageMouseEntered
        
    }//GEN-LAST:event_cover_imageMouseEntered

    private void cover_imageMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cover_imageMouseReleased
        
    }//GEN-LAST:event_cover_imageMouseReleased

    private void cover_imageMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cover_imageMouseExited
       
    }//GEN-LAST:event_cover_imageMouseExited

    private void jPanel14MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel14MouseEntered
        
    }//GEN-LAST:event_jPanel14MouseEntered

    private void episodesListMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_episodesListMousePressed
       if(SwingUtilities.isRightMouseButton(evt)){
            JPopupMenu popup = new JPopupMenu("open");
            
            JMenuItem play = new JMenuItem("Play");
            play.addActionListener((ActionEvent e) -> {
                if(episodesList.getSelectedIndex()>-1){
                    if(null != play_path){
                        File file = new File(play_path);
                        try {
                            Desktop.getDesktop().open(file);
                        } catch (IOException ex) {
                            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            });
            JMenuItem edit = new JMenuItem("Edit Episodes");
            edit.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Add_or_edit_series ae = new Add_or_edit_series(editSelected, id, selectedList, true);
                    ae.setVisible(true);
                }
            });
            popup.add(play);
            popup.add(edit);
            popup.show(this, evt.getXOnScreen(), evt.getYOnScreen());
                                    episodesList.setSelectedIndex(getRow(evt.getPoint(), episodesList));
        }
    }//GEN-LAST:event_episodesListMousePressed

   
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
//                    SwingUtilities.updateComponentTreeUI(Home.this);
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>
        

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                 new Home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton EditSerial;
    private javax.swing.JButton EditSerial1;
    private javax.swing.JLabel actors;
    private javax.swing.JLabel arrangement;
    private javax.swing.JComboBox<String> category;
    private javax.swing.JLabel content_provider;
    private javax.swing.JLabel cover_image;
    private javax.swing.JLabel director;
    private javax.swing.JLabel duration;
    private javax.swing.JLabel editor;
    private javax.swing.JLabel episode;
    private javax.swing.JList<String> episodesList;
    private javax.swing.JLabel episodesNumber;
    private javax.swing.JLabel feature;
    private javax.swing.JLabel freeSpace;
    private javax.swing.JLabel genre;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JList<String> jList1;
    private javax.swing.JList<String> jList10;
    private javax.swing.JList<String> jList11;
    private javax.swing.JList<String> jList12;
    private javax.swing.JList<String> jList13;
    private javax.swing.JList<String> jList14;
    private javax.swing.JList<String> jList15;
    private javax.swing.JList<String> jList16;
    private javax.swing.JList<String> jList17;
    private javax.swing.JList<String> jList18;
    private javax.swing.JList<String> jList19;
    private javax.swing.JList<String> jList2;
    private javax.swing.JList<String> jList20;
    private javax.swing.JList<String> jList21;
    private javax.swing.JList<String> jList22;
    private javax.swing.JList<String> jList23;
    private javax.swing.JList<String> jList24;
    private javax.swing.JList<String> jList25;
    private javax.swing.JList<String> jList26;
    private javax.swing.JList<String> jList27;
    private javax.swing.JList<String> jList28;
    private javax.swing.JList<String> jList29;
    private javax.swing.JList<String> jList3;
    private javax.swing.JList<String> jList4;
    private javax.swing.JList<String> jList5;
    private javax.swing.JList<String> jList6;
    private javax.swing.JList<String> jList7;
    private javax.swing.JList<String> jList8;
    private javax.swing.JList<String> jList9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem14;
    private javax.swing.JMenuItem jMenuItem15;
    private javax.swing.JMenuItem jMenuItem16;
    private javax.swing.JMenuItem jMenuItem17;
    private javax.swing.JMenuItem jMenuItem18;
    private javax.swing.JMenuItem jMenuItem19;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem20;
    private javax.swing.JMenuItem jMenuItem21;
    private javax.swing.JMenuItem jMenuItem22;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel33;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane16;
    private javax.swing.JScrollPane jScrollPane17;
    private javax.swing.JScrollPane jScrollPane18;
    private javax.swing.JScrollPane jScrollPane19;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane20;
    private javax.swing.JScrollPane jScrollPane21;
    private javax.swing.JScrollPane jScrollPane22;
    private javax.swing.JScrollPane jScrollPane23;
    private javax.swing.JScrollPane jScrollPane24;
    private javax.swing.JScrollPane jScrollPane25;
    private javax.swing.JScrollPane jScrollPane26;
    private javax.swing.JScrollPane jScrollPane27;
    private javax.swing.JScrollPane jScrollPane28;
    private javax.swing.JScrollPane jScrollPane29;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane30;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel language;
    private javax.swing.JLabel musician;
    private javax.swing.JLabel photographer;
    private javax.swing.JLabel producer;
    private javax.swing.JLabel publisher;
    private javax.swing.JButton recent;
    private javax.swing.JLabel reminTime;
    private javax.swing.JLabel remining;
    private javax.swing.JComboBox<String> searchCombo;
    private javax.swing.JTextField searchField;
    private javax.swing.JLabel season;
    private javax.swing.JLabel selectedDrive;
    private javax.swing.JLabel selectedPath;
    private javax.swing.JLabel sending;
    private javax.swing.JLabel sendingNumber;
    private javax.swing.JLabel size;
    private javax.swing.JLabel sizeCount;
    private javax.swing.JComboBox<String> sortCombo;
    private javax.swing.JLabel title;
    private javax.swing.JLabel total_space;
    private javax.swing.JLabel total_space1;
    private javax.swing.JLabel total_space2;
    private javax.swing.JLabel type;
    private javax.swing.JLabel writer;
    private javax.swing.JLabel year;
    // End of variables declaration//GEN-END:variables

    private int getRow(Point point,JList list) {
       return list.locationToIndex(point);
    }

    private void copyFileUsingStream(File source, File dest) {
            InputStream is = null;
            OutputStream os = null;
            int sizeof = Integer.parseInt(String.valueOf(source.length()/1024));
            
            transfering = true;
            sendingNumber.setText(String.valueOf(count));
            selectedPath.setVisible(true);
            reminTime.setVisible(true);
            selectedPath.setText("Path : "+source+ "   to   "+dest.getParent());
            String notPathedFile = source.getName();
        try {
            
            is = new FileInputStream(source);
            os = new FileOutputStream(dest);
            
            byte[] buffer = new byte[1024];
            int length;
            
            jProgressBar1.setVisible(true);
            sending.setVisible(true);
            remining.setVisible(true);
            sizeCount.setVisible(true);
            sendingNumber.setVisible(true);
            sending.setVisible(true);
                try {
                    while((length = is.read(buffer)) > 0){
                        os.write(buffer, 0, length);
                        sizeCount.setText(String.valueOf(sizeof) + " KB");
                        reminTime.setText(String.valueOf(sizeof/614400)+":"+String.valueOf(sizeof/10240)+ " Min");
                        sizeof--;
                    }   } catch (IOException ex) {
                    JOptionPane.showMessageDialog(this, ex.getMessage(), "Warining!", JOptionPane.WARNING_MESSAGE);
                            jProgressBar1.setVisible(false);
                            sending.setVisible(false);
                            sizeCount.setVisible(false);
                            
                }
            
                
            
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "Selected Drive unpluged or The file : ["+notPathedFile+"] location changed or removed or renamed!.\n\tIf the file location changed, you should edit it or upload again.");
            selectedDrive.setText("-");
            total_space.setText("-----");
            freeSpace.setText("-----");
            jList15.setEnabled(true);
            sendingNumber.setText("0");
        }finally{
                try {
                     is.close();
                    os.close();
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(this, "Ooop! Incorrect path!");
                }
                    }
        jProgressBar1.setVisible(false);
        sending.setVisible(false);
        sizeCount.setText("0 KB  Done!");
        sizeof = 0;
        count = count - 1;
        sendingNumber.setText(String.valueOf(count));
        selectedPath.setText("Path : "+source+ "   to   "+dest.getParent()+"   sent!");
        transfering = false;
        
    }

    private void deleteRow() {
        if(recentButtonClicked){
            try {
                PreparedStatement stmt = conn.prepareStatement("delete from recent");
                stmt.executeUpdate();
                DefaultListModel listModel = new DefaultListModel();
                listModel.clear();
                episodesList.setModel(listModel);
            } catch (SQLException ex) {
                Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            Select select = new Select();
                    int pane = JOptionPane.showConfirmDialog(Home.this, "Delete selected("+selectedFile.length+") files?", "Delete", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                    if(pane == 0){
                    try {
                       Object[] selected = selectedFile;
                       for(Object sele : selected){
                           if(episodesList.getSelectedValues().length>0){
                                select.deleteEpisode2(sele.toString());
                            }else{
                                PreparedStatement stmt = conn.prepareStatement("select * from medias where title = '" + sele.toString() + "'");
                                ResultSet rs = stmt.executeQuery();

                                String serialId = null;
                                while(rs.next()){
                                    serialId = rs.getString("ID");
                                }

                               select.deleteEpisode(serialId);
                               Select.delete(sele.toString());
                           }
                           
                       }
                        
                    } catch (SQLException ex) {
                        Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    DefaultListModel listModel = new DefaultListModel();
                    listModel.clear();
                    jList2.setModel(listModel);
                    jList1.setModel(listModel);
                    jList3.setModel(listModel);
                    jList4.setModel(listModel);
                    jList5.setModel(listModel);
                    jList6.setModel(listModel);
                    jList7.setModel(listModel);
                    jList8.setModel(listModel);
                    jList9.setModel(listModel);
                    jList10.setModel(listModel);
                    jList11.setModel(listModel);
                    jList12.setModel(listModel);
                    jList13.setModel(listModel);
                    jList14.setModel(listModel);
                    jList16.setModel(listModel);
                    jList17.setModel(listModel);
                    jList18.setModel(listModel);
                    jList19.setModel(listModel);
                    jList20.setModel(listModel);
                    jList21.setModel(listModel);
                    jList22.setModel(listModel);
                    jList23.setModel(listModel);
                    jList24.setModel(listModel);
                    jList25.setModel(listModel);
                    jList26.setModel(listModel);
                    jList27.setModel(listModel);
                    jList28.setModel(listModel);
                    jList29.setModel(listModel);
                    jlist2items = Select.listAllMediaInJList(jList2, Home.this, searching2, sort);
                    jlist1items = Select.listMediaInJList(jList1, Home.this, "Action or Adventure", searching2, sort);
                    jlist3items = Select.listMediaInJList(jList3, Home.this, "Comedy film", searching2, sort);
                    jlist4items = Select.listMediaInJList(jList4, Home.this, "Crime and Gangster", searching2, sort);
                    jlist5items = Select.listMediaInJList(jList5, Home.this, "Drama", searching2, sort);
                    jlist6items = Select.listMediaInJList(jList6, Home.this, "Epics or historical", searching2, sort);
                    jlist7items = Select.listMediaInJList(jList7, Home.this, "Horror", searching2, sort);
                    jlist8items = Select.listMediaInJList(jList8, Home.this, "Musicals and dance", searching2, sort);
                    jlist9items = Select.listMediaInJList(jList9, Home.this, "Science fiction (Sci-Fi)", searching2, sort);
                    jlist10items = Select.listMediaInJList(jList10, Home.this, "War", searching2, sort);
                    jlist11items = Select.listMediaInJList(jList11, Home.this, "Westerns", searching2, sort);
                    jlist12items = Select.listMediaInJList(jList12, Home.this, "Tv shows", searching2, sort);
                    jlist13items = Select.listMediaInJList(jList13, Home.this, "Funny video", searching2, sort);
                    jlist14items = Select.listMediaInJList(jList14, Home.this, "Amazing video", searching2, sort);
                    jlist16items = Select.listMediaInJList(jList16, Home.this, "Adult video", searching2, sort);
                    jlist17items = Select.listMediaInJList(jList17, Home.this, "Music video", searching2, sort);
                    jlist18items = Select.listMediaInJList(jList18, Home.this, "Christian video", searching2, sort);
                    jlist19items = Select.listMediaInJList(jList19, Home.this, "Islamic video", searching2, sort);
                    jlist20items = Select.listMediaInJList(jList20, Home.this, "Other religion video", searching2, sort);
                    jlist21items = Select.listMediaInJList(jList21, Home.this, "Native Film/ movie", searching2, sort);
                    jlist22items = Select.listMediaInJList(jList22, Home.this, "Native Tv shows", searching2, sort);
                    jlist23items = Select.listMediaInJList(jList23, Home.this, "Native fun video", searching2, sort);
                    jlist24items = Select.listMediaInJList(jList24, Home.this, "Native music video", searching2, sort);
                    jlist25items = Select.listMediaInJList(jList25, Home.this, "Foreign Music / Audio", searching2, sort);
                    jlist26items = Select.listMediaInJList(jList26, Home.this, "Native Music / Audio", searching2, sort);
                    jlist27items = Select.listMediaInJList(jList27, Home.this, "Religion Music / Audio", searching2, sort);
                    jlist28items = Select.listMediaInJList(jList28, Home.this, "Anniversary Music / Audio", searching2, sort);
                    jlist29items = Select.listMediaInJList(jList29, Home.this, "Other", searching2, sort);
                    jButton4.setEnabled(false);
                    jButton3.setEnabled(false);
                    jButton6.setEnabled(false);
                    jButton7.setEnabled(false);
                    jMenuItem7.setEnabled(false);
                    jMenuItem8.setEnabled(false);
                    jMenuItem9.setEnabled(false);
                    jMenuItem11.setEnabled(false);
                    jMenu4.setEnabled(false);
                    EditSerial.setEnabled(false);
                    EditSerial1.setEnabled(false);
                    selection = null;
                    play_path = null;
                    id = 0;
                    episodesList.setModel(listModel);
                    Select.listMediaInEpisodes(episodesList,Home.this,String.valueOf(serialId));
                    remining.setVisible(false);
                }
        }
        
    }

    private void displayListValues(JList<String> list) {
            jPanel15.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Episodes", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 12)));
            selectedList = list.getName();
            String listName = list.getName();
            if("".equals(searchField.getText())){
                selectItems(listName);
            }else{
                searchselectItems(listName);
            }            
            
            int[] indexs = list.getSelectedIndices();
            int a = 0;
            String[] selectedFile1 = new String[indexs.length];
            while(a<indexs.length){

                selectedFile1[a] = items[indexs[a]];
                a++;
            }
            selectedFile = selectedFile1;
        
            Spacecraft s1 = null;
            String name;
            if(list.getSelectedIndex()==-1){
                name = "";
            }else{
                name = items[list.getSelectedIndex()];
            }
            
            selection = name;
            editSelected = selection;
            
            if(name != null){
        try {
            
            s1 = (Spacecraft) Select.quarySingleRow(name);
            int serialId = s1.getId();
            play_path = s1.getMedia_fullPath();
            fileSize = s1.getSize();
            selectedPath.setVisible(true);
            selectedPath.setText("Path : "+play_path+ "   selected");
            openImage = s1.getImage_fullPath();
            
            Select sele = new Select();
            episodeitems = Select.listMediaInEpisodes(episodesList,Home.this,String.valueOf(serialId));
            
               try {
               
          if(s1.getImage_fullPath()!= null){
               f1 = new File(s1.getImage_fullPath());
               fis = new FileInputStream(f1);
               try {
                   BufferedImage bi = ImageIO.read(fis);
                   
                   scaledImage = bi.getScaledInstance(cover_image.getWidth(), cover_image.getHeight(), Image.SCALE_SMOOTH);
                   image = new ImageIcon(scaledImage);
                   cover_image.setIcon(image);
               } catch (IOException ex) {
                   Logger.getLogger(Add_or_edit.class.getName()).log(Level.SEVERE, null, ex);
               }
               }else{
                f1 = new File("Images/noimage1.jpg");
                 fis = new FileInputStream(f1);
                 try {
                     BufferedImage bi = ImageIO.read(fis);

                     scaledImage = bi.getScaledInstance(cover_image.getWidth(), cover_image.getHeight(), Image.SCALE_SMOOTH);
                     image = new ImageIcon(scaledImage);
                     cover_image.setIcon(image);
                 } catch (IOException ex) {
                     Logger.getLogger(Add_or_edit.class.getName()).log(Level.SEVERE, null, ex);
                 }
          }
               
               
           } catch (FileNotFoundException ex) {
               cover_image.setText("No Image");
           }
        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        title.setText(s1.getOriginal_title());
        
               double l1 = Double.parseDouble(String.valueOf(s1.getSize()));
               double valueMB,valueGB;
               if(l1<1024){
                   valueMB = 0.0;
               }else{
                   valueMB = Math.round(l1/1024);
               }
               if(valueMB<1024){
                   valueGB = 0.0;
               }else{
                   valueGB = Math.round(valueMB/1024);
               }
               
               
               size.setText(String.valueOf(l1)+ " KB/" +String.valueOf(valueMB)+" MB/"+String.valueOf(valueGB)+" GB");
               type.setText(s1.getFileType());
               duration.setText(s1.getLength());
               year.setText(s1.getYear());
               language.setText(s1.getLanguage());
               genre.setText(s1.getSubgenre());
               season.setText(s1.getSeason());
               actors.setText(s1.getActors());
               director.setText(s1.getDiroctors());
               producer.setText(s1.getProducers());
               editor.setText(s1.getEditors());
               writer.setText(s1.getWriters());
               musician.setText(s1.getMusician());
               photographer.setText(s1.getPhotographer());
               publisher.setText(s1.getPublisher());
               content_provider.setText(s1.getContent_provider());
               arrangement.setText(s1.getArrangement());
               feature.setText(s1.getMedia_feature());
               
               play_path = s1.getMedia_fullPath();
               id = s1.getId();
               file_name = s1.getTitle_field();
               sizes = String.valueOf(s1.getSize());
               episodesNumber.setText(String.valueOf(episodesList.getModel().getSize()));
        
        jButton4.setEnabled(true);
        jButton3.setEnabled(true);
        jButton7.setEnabled(true);
        
        if(play_path != null && drivePath != null){
            jButton6.setEnabled(true);
        }
        
        jMenuItem7.setEnabled(true);
        jMenuItem8.setEnabled(true);
        jMenuItem9.setEnabled(true);
        jMenuItem11.setEnabled(true);
        jMenu4.setEnabled(true);
        
            }
    }

    private void bipSound() {
        try {
            stmt = conn.prepareStatement("select * from setting");
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                state = rs.getInt("state");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(state == 1){
            final JFXPanel fxPanel = new JFXPanel();
        String bip = "SoundEffects/soundeffect.mp3";
        Media hit = new Media(new File(bip).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(hit);
        mediaPlayer.play();
        }
        
    }

    private void listMouseClicked(MouseEvent evt, JList<String> list) {
        recentButtonClicked = false;
        String listName = list.getName();
        if("".equals(searchField.getText())){
            selectItems(listName);
        }else{
            searchselectItems(listName);
        }
        
        selectedList = listName;
        int i = list.getSelectedValues().length;
        
        remining.setVisible(true);
         remining.setText(String.valueOf(i)+" files selected!");
        
        if(list.getSelectedIndex()!=-1){
            if(evt.getClickCount()==2){
                if(null != play_path){
                    File file = new File(play_path);
                    try {
                        Desktop.getDesktop().open(file);
                    } catch (IOException ex) {
                        Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {

                    JOptionPane.showMessageDialog(this, "Please select at least one video or audio from the list!");
                }
            } else{
                Spacecraft s = null;
                try {
                    String name = items[list.getSelectedIndex()];
                    selection = name;

                    s = (Spacecraft) Select.quarySingleRow(name);

                    serialId = s.getId();
                    fileSize = s.getSize();
                    Select sele = new Select();
                    episodeitems = Select.listMediaInEpisodes(episodesList,Home.this,String.valueOf(serialId));
                    try {

                        if(s.getImage_fullPath()!= null){
                            f1 = new File(s.getImage_fullPath());
                            fis = new FileInputStream(f1);
                            try {
                                BufferedImage bi = ImageIO.read(fis);

                                scaledImage = bi.getScaledInstance(cover_image.getWidth(), cover_image.getHeight(), Image.SCALE_SMOOTH);
                                image = new ImageIcon(scaledImage);
                                cover_image.setIcon(image);
                            } catch (IOException ex) {
                                Logger.getLogger(Add_or_edit.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                        else{
                            f1 = new File(System.getProperty("user.dir")+"\\Images\\noimage1.jpg");
                            fis = new FileInputStream(f1);
                            try {
                                BufferedImage bi = ImageIO.read(fis);

                                scaledImage = bi.getScaledInstance(cover_image.getWidth(), cover_image.getHeight(), Image.SCALE_SMOOTH);
                                image = new ImageIcon(scaledImage);
                                cover_image.setIcon(image);
                            } catch (IOException ex) {
                                Logger.getLogger(Add_or_edit.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }

                    } catch (FileNotFoundException ex) {
                        cover_image.setText("No Image");
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
                }

                title.setText(s.getOriginal_title());

                double l1 = Double.parseDouble(String.valueOf(s.getSize()));
                double valueMB,valueGB;
                if(l1<1024){
                    valueMB = 0.0;
                }else{
                    valueMB = Math.round(l1/1024);
                }
                if(valueMB<1024){
                    valueGB = 0.0;
                }else{
                    valueGB = Math.round(valueMB/1024);
                }

                size.setText(String.valueOf(l1)+ " KB/" +String.valueOf(valueMB)+" MB/"+String.valueOf(valueGB)+" GB");
                type.setText(s.getFileType());
                duration.setText(s.getLength());
                year.setText(s.getYear());
                language.setText(s.getLanguage());
                genre.setText(s.getSubgenre());
                season.setText(s.getSeason());
                actors.setText(s.getActors());
                director.setText(s.getDiroctors());
                producer.setText(s.getProducers());
                editor.setText(s.getEditors());
                writer.setText(s.getWriters());
                musician.setText(s.getMusician());
                photographer.setText(s.getPhotographer());
                publisher.setText(s.getPublisher());
                content_provider.setText(s.getContent_provider());
                arrangement.setText(s.getArrangement());
                feature.setText(s.getMedia_feature());

                play_path = s.getMedia_fullPath();
                selectedPath.setText("Path : "+play_path+ "   selected");
                id = s.getId();
                file_name = s.getTitle_field();
                sizes = String.valueOf(s.getSize());

            }
            jButton4.setEnabled(true);
            jButton3.setEnabled(true);
            jButton7.setEnabled(true);

            if(play_path != null && drivePath != null){
                jButton6.setEnabled(true);
                jMenuItem11.setEnabled(true);
                jMenu4.setEnabled(true);
            }

            jMenuItem7.setEnabled(true);
            jMenuItem8.setEnabled(true);
            jMenuItem9.setEnabled(true);
            EditSerial.setEnabled(true);
            EditSerial1.setEnabled(false);

            try {

                PreparedStatement stmt = conn.prepareStatement("select * from serial where serial_id = '" + serialId + "'");
                ResultSet rs = stmt.executeQuery();

                ep_path = new File[episodesList.getModel().getSize()];
                int k = 0;
                while(rs.next()){
                    ep_path[k] = new File(rs.getString("path"));
                    k++;
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Loading Error " + ex.getMessage());
            }

        }
    }

    private void listMousePressed(MouseEvent evt, JList<String> list) {
        if(SwingUtilities.isRightMouseButton(evt)){
            JPopupMenu popup = new JPopupMenu("Edit");
            JMenu share = new JMenu("Share");
            JMenuItem play = new JMenuItem("Play");
            play.addActionListener((ActionEvent e) -> {
                if(null != play_path){
                    File file = new File(play_path);
                    try {
                        Desktop.getDesktop().open(file);
                    } catch (IOException ex) {
                        Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });
            
            JMenuItem delete = new JMenuItem("Delete");
            delete.addActionListener((ActionEvent e) -> {
                deleteRow();
            });
            
            JMenuItem addEp = new JMenuItem("Add Episode");
            addEp.addActionListener((ActionEvent e) -> {
                Add_or_edit_series editSerial = new Add_or_edit_series(selection, id, selectedList, false);
                editSerial.setVisible(true);
            });
            JMenuItem edit = new JMenuItem("Edit media");
            edit.addActionListener((ActionEvent e) -> {
                Add_or_edit edit2 = new Add_or_edit(selection, id, selectedList);
                edit2.setVisible(true);
            });
            JMenuItem add = new JMenuItem("Add Tv/Series shows");
            add.addActionListener((ActionEvent e) -> {
                selection = null;
                id = 0;
                Add_or_edit_series edit1 = new Add_or_edit_series(selection, id, selectedList, false);
                edit1.setVisible(true);
            });
            JMenuItem media = new JMenuItem("Add media");
            media.addActionListener((ActionEvent e) -> {
                selection = null;
                id = 0;
                Add_or_edit add1 = new Add_or_edit(selection, id, selectedList);
                add1.setVisible(true);
            });
            
            File[] drives = File.listRoots();
            FileSystemView fsv = FileSystemView.getFileSystemView();
            if (drives != null && drives.length > 0){
                for (File aDrive : drives){
                    String driveType = fsv.getSystemTypeDescription(aDrive);
                    if(driveType.equals("Local Disk")){
                        JMenuItem add12 = share.add(new JMenuItem(aDrive.toString(), new javax.swing.ImageIcon(getClass().getResource("/moviestore/Icons/compact_disc_25px.png"))));

                        add12.addActionListener((ActionEvent e) -> {
                            remining.setText("Remining : ");
                            File f = new File(play_path);
                            if(f.isDirectory()){
                                count = count + ep_path.length;
                                File[] play_paths = ep_path;
                                File dire1 = new File(add12.getText() + folderName);
                                dire1.mkdir();
                                File txt = new File(dire1.getPath()+"\\readme.txt");
                                 try {
                                     txt.createNewFile();
                                     try (FileWriter write = new FileWriter(txt)) {
                                                         write.write(infoText);
                                                     }
                                 } catch (IOException ex) {
                                     JOptionPane.showMessageDialog(Home.this, ex.getMessage());
                                 }
                                
                                //copy file conventional way using stream

                                ExecutorService service = Executors.newFixedThreadPool(20);
                                service.submit(new Runnable(){
                                    public void run(){

                                        try {
                                            int i = 1;
                                            for(File fi : play_paths){
                                                File source = new File(fi.getPath());
                                                File dire = new File(add12.getText() + folderName);
                                                dire.mkdir();
                                                String path = dire.getPath()+"\\"+f.getName();

                                                File txt = new File(dire.getPath()+"\\readme.txt");
                                                txt.createNewFile();
                                                try (FileWriter write = new FileWriter(txt)) {
                                                    write.write(infoText);
                                                }

                                                File direct = new File(path);
                                                direct.mkdir();
                                                String path2 = direct.getPath();
                                                File dest = new File(path2 + "\\" + fi.getName());
                                                    copyFileUsingStream(source, dest);
                                                    if(play_paths.length == i){
                                                        bipSound();
                                                        Select.transferHistory(source.getParentFile(), dest);
                                                        if(SystemTray.isSupported()){
                                                            Home td = new Home();
                                                            td.displayTray(source.getParentFile(), dest);
                                                        }else{
                                                            System.out.println("System tray error");
                                                        }
                                                    }
                                                    i++;
                                                }

                                            } catch (IOException ex) {
                                                JOptionPane.showMessageDialog(Home.this, ex.getMessage());
                                            }
                                        }
                                    });
                                

                                }else{
                                    count++;
                                    File source = new File(play_path);
                                    File dire = new File(add12.getText() + folderName);
                                    dire.mkdir();

                                    File txt = new File(dire.getPath()+"\\readme.txt");
                                    try {
                                        txt.createNewFile();
                                        try (FileWriter write = new FileWriter(txt)) {
                                            write.write(infoText);
                                        }
                                    } catch (IOException ex) {
                                        JOptionPane.showMessageDialog(Home.this, ex.getMessage());
                                    }

                                    String path = dire.getPath();
                                    File dest = new File(path +"\\"+ file_name);

                                        //copy file conventional way using stream

                                        ExecutorService service = Executors.newFixedThreadPool(20);
                                        service.submit(new Runnable(){
                                            public void run(){

                                               
                                                    copyFileUsingStream(source, dest);
                                                    bipSound();
                                                    Select.transferHistory(source.getParentFile(), dest);
                                                    if(SystemTray.isSupported()){
                                                            Home td = new Home();
                                                            td.displayTray(source, dest);
                                                        }

                                               
                                            }
                                        });
                                    }
                                });
                            }else if(driveType.equals("CD Drive")){
                                JMenuItem add13 = share.add(new JMenuItem(aDrive.toString(), new javax.swing.ImageIcon(getClass().getResource("/moviestore/Icons/cd_25px.png"))));

                                add13.addActionListener((ActionEvent e) -> {
                                    remining.setText("Remining : ");
                                    File f = new File(play_path);
                                    if(f.isDirectory()){
                                        count = count + ep_path.length;
                                        File[] play_paths = ep_path;
                                        File dire1 = new File(add13.getText() + folderName);
                                        dire1.mkdir();
                                        File txt = new File(dire1.getPath()+"\\readme.txt");
                                         try {
                                             txt.createNewFile();
                                             try (FileWriter write = new FileWriter(txt)) {
                                                                 write.write(infoText);
                                                             }
                                         } catch (IOException ex) {
                                             JOptionPane.showMessageDialog(Home.this, ex.getMessage());
                                         }

                                        //copy file conventional way using stream

                                        ExecutorService service = Executors.newFixedThreadPool(20);
                                        service.submit(new Runnable(){
                                            public void run(){

                                                try {
                                                    int i = 0;
                                                    for(File fi : play_paths){
                                                        File source = new File(fi.getPath());
                                                        File dire = new File(add13.getText() + folderName);
                                                        dire.mkdir();
                                                        String path = dire.getPath()+"\\"+f.getName();

                                                        File txt = new File(dire.getPath()+"\\readme.txt");
                                                        txt.createNewFile();
                                                        try (FileWriter write = new FileWriter(txt)) {
                                                            write.write(infoText);
                                                        }

                                                        File direct = new File(path);
                                                        direct.mkdir();
                                                        String path2 = direct.getPath();
                                                        File dest = new File(path2 + "\\" + fi.getName());
                                                            copyFileUsingStream(source, dest);
                                                            if(play_paths.length == i){
                                                                bipSound();
                                                                Select.transferHistory(source.getParentFile(), dest);
                                                                if(SystemTray.isSupported()){
                                                                    Home td = new Home();
                                                                    td.displayTray(source.getParentFile(), dest);
                                                                }else{
                                                                    System.out.println("System tray error");
                                                                }
                                                            }
                                                            i++;
                                                        }

                                                    } catch (IOException ex) {
                                                        JOptionPane.showMessageDialog(Home.this, ex.getMessage());
                                                    }
                                                }
                                            });

                                        }else{
                                            count++;
                                                File source = new File(play_path);
                                            File dire = new File(add13.getText() + folderName);
                                            dire.mkdir();

                                            File txt = new File(dire.getPath()+"\\readme.txt");
                                            try {
                                                txt.createNewFile();
                                                try (FileWriter write = new FileWriter(txt)) {
                                                    write.write(infoText);
                                                }
                                            } catch (IOException ex) {
                                                JOptionPane.showMessageDialog(Home.this, ex.getMessage());
                                            }

                                            String path = dire.getPath();
                                            File dest = new File(path +"\\"+ file_name);

                                                //copy file conventional way using stream

                                                ExecutorService service = Executors.newFixedThreadPool(20);
                                                service.submit(new Runnable(){
                                                    public void run(){

                                                            copyFileUsingStream(source, dest);
                                                            bipSound();
                                                            Select.transferHistory(source.getParentFile(), dest);
                                                            if(SystemTray.isSupported()){
                                                                Home td = new Home();
                                                                td.displayTray(source, dest);
                                                            }else{
                                                                System.out.println("System tray error");
                                                            }

                                                    }
                                                });
                                            
                                            
                                            }
                                        });
                                    }else{
                                        JMenuItem add1 = share.add(new JMenuItem(aDrive.toString(), new javax.swing.ImageIcon(getClass().getResource("/moviestore/Icons/usb_25px.png"))));

                                        add1.addActionListener((ActionEvent e) -> {
                                            remining.setText("Remining : ");
                                            File f = new File(play_path);
                                            if(f.isDirectory()){
                                                count = count + ep_path.length;
                                                File[] play_paths = ep_path;
                                                File dire1 = new File(add1.getText() + folderName);
                                                dire1.mkdir();
                                                File txt = new File(dire1.getPath()+"\\readme.txt");
                                                 try {
                                                     txt.createNewFile();
                                                     try (FileWriter write = new FileWriter(txt)) {
                                                                         write.write(infoText);
                                                                     }
                                                 } catch (IOException ex) {
                                                     JOptionPane.showMessageDialog(Home.this, ex.getMessage());
                                                 }

                                                //copy file conventional way using stream

                                                ExecutorService service = Executors.newFixedThreadPool(20);
                                                service.submit(new Runnable(){
                                                    public void run(){

                                                        try {
                                                            int i = 1;
                                                            for(File fi : play_paths){
                                                                File source = new File(fi.getPath());
                                                                File dire = new File(add1.getText() + folderName);
                                                                dire.mkdir();
                                                                String path = dire.getPath()+"\\"+f.getName();

                                                                File txt = new File(dire.getPath()+"\\readme.txt");
                                                                txt.createNewFile();
                                                                try (FileWriter write = new FileWriter(txt)) {
                                                                    write.write(infoText);
                                                                }

                                                                File direct = new File(path);
                                                                direct.mkdir();
                                                                String path2 = direct.getPath();
                                                                File dest = new File(path2 + "\\" + fi.getName());
                                                                    copyFileUsingStream(source, dest);
                                                                    if(play_paths.length == i){
                                                                        bipSound();
                                                                        Select.transferHistory(source.getParentFile(), dest);
                                                                        if(SystemTray.isSupported()){
                                                                            Home td = new Home();
                                                                            td.displayTray(source.getParentFile(), dest);
                                                                        }else{
                                                                            System.out.println("System tray error");
                                                                        }
                                                                    }
                                                                    i++;
                                                                }

                                                            } catch (IOException ex) {
                                                                JOptionPane.showMessageDialog(Home.this, ex.getMessage());
                                                            }
                                                        }
                                                    });

                                                }else{
                                                    count++;
                                                    File source = new File(play_path);
                                                    File dire = new File(add1.getText() + folderName);
                                                    dire.mkdir();
                                                    String path = dire.getPath();

                                                    File txt = new File(dire.getPath()+"\\readme.txt");
                                                    try {
                                                        txt.createNewFile();
                                                        try (FileWriter write = new FileWriter(txt)) {
                                                            write.write(infoText);
                                                        }
                                                    } catch (IOException ex) {
                                                        JOptionPane.showMessageDialog(Home.this, ex.getMessage());
                                                    }

                                                    File dest = new File(path +"\\"+ file_name);

                                                        //copy file conventional way using stream

                                                        ExecutorService service = Executors.newFixedThreadPool(20);
                                                        service.submit(new Runnable(){
                                                            public void run(){

                                                                copyFileUsingStream(source, dest);
                                                                bipSound();
                                                                Select.transferHistory(source.getParentFile(), dest);
                                                                if(SystemTray.isSupported()){
                                                                    Home td = new Home();
                                                                    td.displayTray(source, dest);
                                                                }else{
                                                                    System.out.println("System tray error");
                                                                }
                                                            }
                                                        });
                                                    }
                                                });
                                            }

                                        }
                                    }

                                    popup.add(share);
                                    popup.add(play);
                                    popup.add(delete);
                                    popup.add(edit);
                                    popup.add(add);
                                    popup.add(media);
                                    popup.show(this, evt.getXOnScreen(), evt.getYOnScreen());
                                    list.setSelectedIndex(getRow(evt.getPoint(), list));
                                }
    }

    private void transperPath(String play_path, File[] ep_path, String drivepath) {
        
        String drivepaths = drivepath;
        if(drivePath != null && play_path != null){
        File f = new File(play_path);
               if(f.isDirectory()){
                   count = count + ep_path.length;
                   File[] play_paths = ep_path;
                   File dire1 = new File(drivepaths + folderName);
                   dire1.mkdir();
                   File txt = new File(dire1.getPath()+"\\readme.txt");
                    try {
                        txt.createNewFile();
                        try (FileWriter write = new FileWriter(txt)) {
                                            write.write(infoText);
                                        }
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(Home.this, ex.getMessage());
                    }
                   
                        //copy file conventional way using stream
                        
                        ExecutorService service = Executors.newFixedThreadPool(20);
                        service.submit(new Runnable(){
                            public void run(){

                                
                            int i = 1;
                            for(File fi : play_paths){
                                File source = new File(fi.getPath());
                                File dire = new File(drivepaths + folderName);
                                dire.mkdir();
                                String path = dire.getPath()+"\\"+f.getName();
                                
                                File direct = new File(path);
                                direct.mkdir();
                                String path2 = direct.getPath();
                                File dest = new File(path2 + "\\" + fi.getName());
                                
                                     copyFileUsingStream(source, dest);
                                     if(play_paths.length == i){
                                         bipSound();
                                         Select.transferHistory(source.getParentFile(), dest);
                                         if(SystemTray.isSupported()){
                                            Home td = new Home();
                                            td.displayTray(source.getParentFile(), dest);
                                        }else{
                                            System.out.println("System tray error");
                                        }
                                     }
                                     
                                     i++;
                            }
                            

                        
                            }
                            
                        });
                   
               }else{
        count++;
        File source = new File(play_path);
        file_name = source.getName();
        File dire = new File(drivepaths + folderName);
        dire.mkdir();
        String path = dire.getPath();
        
        File txt = new File(dire.getPath()+"\\readme.txt");
            try {
                txt.createNewFile();
                try (FileWriter write = new FileWriter(txt)) {
                                    write.write(infoText);
                                }
            } catch (IOException ex) {
                Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        File dest = new File(path +"\\"+ file_name);
        
        //copy file conventional way using stream
        
        ExecutorService service = Executors.newFixedThreadPool(20);
        service.submit(new Runnable(){
            public void run(){
                
        
            
            copyFileUsingStream(source, dest);
            bipSound();
            Select.transferHistory(source.getParentFile(), dest);
            if(SystemTray.isSupported()){
                                            Home td = new Home();
                                            td.displayTray(source, dest);
                                        }else{
                                            System.out.println("System tray error");
                                        }
            }
        });
               }
        }else{
            JOptionPane.showMessageDialog(Home.this, "Please select at least one drive or file.");
        }
    }

    private void transferAllFile() throws SQLException {
        remining.setText("Remining : ");
        
        if(selectedFile.length>1){
            Spacecraft ss;
            int i = 0;
            while(i<selectedFile.length){
                if(episodesList.getSelectedValues().length>0){
                    if(recentButtonClicked){
                        try {
                    ss = (Spacecraft) Select.quarySingleRow(selectedFile[i].toString());
                    String pp = ss.getMedia_fullPath();
                    serialId = ss.getId();
 
                    try {

                            PreparedStatement stmt = conn.prepareStatement("select * from serial where serial_id = '" + serialId + "'");
                            ResultSet rs = stmt.executeQuery();
                            int f = 0;
                            while(rs.next()){
                                f++;
                            }
                            
                            ResultSet rs3 = stmt.executeQuery();
                            
                            ep_path = new File[f];
                            int k = 0;
                            while(rs3.next()){
                                ep_path[k] = new File(rs3.getString("path"));
                                k++;
                            }
                        } catch (SQLException ex) {
                            JOptionPane.showMessageDialog(this, "Loading Error " + ex.getMessage());
                        }
                    
                    play_path = pp;
                    String drivepath = drivePath;
                    transperPath(play_path, ep_path, drivepath);
                    
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(this, ex.getMessage());
                }
                    }else{
                        ss = (Spacecraft) Select.quarySingleEpisode(selectedFile[i].toString());
                        String pp = ss.getMedia_fullPath();
                        play_path = pp;
                        String drivepath = drivePath;
                        transperPath(play_path, ep_path, drivepath);
                        File f = new File(play_path);
                        stmt = conn.prepareStatement("insert into recent values(?,?,?)");
                        stmt.setLong(1,1);
                        stmt.setString(2, f.getName());
                        stmt.setString(3, play_path);
                        stmt.executeUpdate();
                    }
                    
                }else{
                try {
                    ss = (Spacecraft) Select.quarySingleRow(selectedFile[i].toString());
                    String pp = ss.getMedia_fullPath();
                    serialId = ss.getId();
 
                    try {

                            PreparedStatement stmt = conn.prepareStatement("select * from serial where serial_id = '" + serialId + "'");
                            ResultSet rs = stmt.executeQuery();
                            int f = 0;
                            while(rs.next()){
                                f++;
                            }
                            
                            ResultSet rs3 = stmt.executeQuery();
                            
                            ep_path = new File[f];
                            int k = 0;
                            while(rs3.next()){
                                ep_path[k] = new File(rs3.getString("path"));
                                k++;
                            }
                        } catch (SQLException ex) {
                            JOptionPane.showMessageDialog(this, "Loading Error " + ex.getMessage());
                        }
                    
                    play_path = pp;
                    String drivepath = drivePath;
                    transperPath(play_path, ep_path, drivepath);
                    File f = new File(play_path);
                    stmt = conn.prepareStatement("insert into recent values(?,?,?)");
                   stmt.setLong(1,1);
                   stmt.setString(2, f.getName());
                   stmt.setString(3, play_path);
                   stmt.executeUpdate();
                    
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(this, ex.getMessage());
                }
                }
                i++;
            }
            
        }else{
        if(drivePath != null && play_path != null){
        File f = new File(play_path);
        Spacecraft ss;
               if(f.isDirectory()){
                   
                   if(recentButtonClicked){
                        try {
                    ss = (Spacecraft) Select.quarySingleRow(f.getName());
                    String pp = ss.getMedia_fullPath();
                    serialId = ss.getId();
 
                    try {

                            PreparedStatement stmt = conn.prepareStatement("select * from serial where serial_id = '" + serialId + "'");
                            ResultSet rs = stmt.executeQuery();
                            int ff = 0;
                            while(rs.next()){
                                ff++;
                            }
                            
                            ResultSet rs3 = stmt.executeQuery();
                            
                            ep_path = new File[ff];
                            int k = 0;
                            while(rs3.next()){
                                ep_path[k] = new File(rs3.getString("path"));
                                k++;
                            }
                        } catch (SQLException ex) {
                            JOptionPane.showMessageDialog(this, "Loading Error " + ex.getMessage());
                        }
                    
                    play_path = pp;
                    String drivepath = drivePath;
                    transperPath(play_path, ep_path, drivepath);
                    
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(this, ex.getMessage());
                }
                   }  else{
                   count = count + ep_path.length;
                   File[] play_paths = ep_path;
                   stmt = conn.prepareStatement("insert into recent values(?,?,?)");
                   stmt.setLong(1,1);
                   stmt.setString(2, f.getName());
                   stmt.setString(3, play_path);
                   stmt.executeUpdate();
                        //copy file conventional way using stream
                        String drivepath = drivePath;
                        File dire1 = new File(drivepath + folderName);
                        dire1.mkdir();
                        File txt = new File(dire1.getPath()+"\\readme.txt");
                         try {
                             txt.createNewFile();
                             try (FileWriter write = new FileWriter(txt)) {
                                                 write.write(infoText);
                                             }
                         } catch (IOException ex) {
                             JOptionPane.showMessageDialog(Home.this, ex.getMessage());
                         }
                        ExecutorService service = Executors.newFixedThreadPool(20);
                        service.submit(new Runnable(){
                            public void run(){

                                int i = 1;
                                for(File fi : play_paths){
                                    File source = new File(fi.getPath());
                                    File dire = new File(drivepath + folderName);
                                    dire.mkdir();
                                    String path = dire.getPath()+"\\"+f.getName();
                                    
                                    File direct = new File(path);
                                    direct.mkdir();
                                    String path2 = direct.getPath();
                                    File dest = new File(path2 + "\\" + fi.getName());
                                    
                                    copyFileUsingStream(source, dest);
                                    if(play_paths.length == i){
                                        bipSound();
                                        Select.transferHistory(source.getParentFile(), dest);
                                        if(SystemTray.isSupported()){
                                            Home td = new Home();
                                            td.displayTray(source.getParentFile(), dest);
                                        }else{
                                            System.out.println("System tray error");
                                        }
                                    }
                                    i++;
                                }
                            }
                            
                        });
               }
               }else{
                   count++;
                   stmt = conn.prepareStatement("insert into recent values(?,?,?)");
                   stmt.setLong(1,1);
                   stmt.setString(2, f.getName());
                   stmt.setString(3, play_path);
                   stmt.executeUpdate();
        File source = new File(play_path);
        File dire = new File(drivePath + folderName);
        dire.mkdir();
        String path = dire.getPath();
        
        File txt = new File(dire.getPath()+"\\readme.txt");
            try {
                txt.createNewFile();
                try (FileWriter write = new FileWriter(txt)) {
                                    write.write(infoText);
                                }
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
        
        File dest = new File(path +"\\"+ file_name);
        
        //copy file conventional way using stream
        
        ExecutorService service = Executors.newFixedThreadPool(20);
        service.submit(new Runnable(){
            public void run(){
                
                copyFileUsingStream(source, dest);
                bipSound();
                Select.transferHistory(source.getParentFile(), dest);
                if(SystemTray.isSupported()){
                                            Home td = new Home();
                                            td.displayTray(source, dest);
                                        }else{
                                            System.out.println("System tray error");
                                        }
            }
        });
               }
        }else{
            JOptionPane.showMessageDialog(Home.this, "Please select at least one drive or file.");
        }
        }
    }

    private void findSelectedFile(JList<String> jList) {
        String listName = jList.getName();
        if("".equals(searchField.getText())){
            selectItems(listName);
        }else{
            searchselectItems(listName);
        }
        
         int i = jList.getSelectedValues().length;
         remining.setVisible(true);
         remining.setText("  "+String.valueOf(i)+" files selected!");
    }

    private void transperPath2(String play_path, File[] ep_path, JMenuItem menu3) {
        remining.setText("Remining : ");
        if(play_path != null){
        File f = new File(play_path);
               if(f.isDirectory()){
                   count = count + ep_path.length;
                   File[] play_paths = ep_path;
                   
                   File dire1 = new File(menu3.getText() + folderName);
                   dire1.mkdir();
                   File txt = new File(dire1.getPath()+"\\readme.txt");
                    try {
                        txt.createNewFile();
                        try (FileWriter write = new FileWriter(txt)) {
                                            write.write(infoText);
                                        }
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(Home.this, ex.getMessage());
                    }
                   
                        //copy file conventional way using stream

                        ExecutorService service = Executors.newFixedThreadPool(20);
                        service.submit(new Runnable(){
                            public void run(){

                                int i = 1;
                                for(File fi : play_paths){
                                    File source = new File(fi.getPath());
                                    File dire = new File(menu3.getText() + folderName);
                                    dire.mkdir();
                                    String path = dire.getPath()+"\\"+f.getName();
                                    
                                    File direct = new File(path);
                                    direct.mkdir();
                                    String path2 = direct.getPath();
                                    File dest = new File(path2 + "\\" + fi.getName());
                                    
                                    copyFileUsingStream(source, dest);
                                    if(play_paths.length == i){
                                        bipSound();
                                        Select.transferHistory(source.getParentFile(), dest);
                                        if(SystemTray.isSupported()){
                                            Home td = new Home();
                                            td.displayTray(source.getParentFile() , dest);
                                        }else{
                                            System.out.println("System tray error");
                                        }
                                    }
                                    i++;
                                }
                            }
                            
                        });
                   
               }else{
        count++;
        File source = new File(play_path);
        file_name = source.getName();
        File dire = new File(menu3.getText() + folderName);
        dire.mkdir();
        String path = dire.getPath();
        
        File txt = new File(dire.getPath()+"\\readme.txt");
            try {
                txt.createNewFile();
                try (FileWriter write = new FileWriter(txt)) {
                                    write.write(infoText);
                                }
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(Home.this, ex.getMessage());
            }
        
        File dest = new File(path +"\\"+ file_name);
        
        //copy file conventional way using stream
        
        ExecutorService service = Executors.newFixedThreadPool(20);
        service.submit(new Runnable(){
            public void run(){
                
                copyFileUsingStream(source, dest);
                bipSound();
                Select.transferHistory(source.getParentFile(), dest);
                if(SystemTray.isSupported()){
                                            Home td = new Home();
                                            td.displayTray(source , dest);
                                        }else{
                                            System.out.println("System tray error");
                                        }
            }
        });
               }
        }else{
            JOptionPane.showMessageDialog(Home.this, "Please select at least one drive or file.");
        }
    }

    private void refreshLists() {
        DefaultListModel listModel = new DefaultListModel();
        listModel.clear();
        jList1.setModel(listModel);
        jList2.setModel(listModel);
        jList3.setModel(listModel);
        jList4.setModel(listModel);
        jList5.setModel(listModel);
        jList6.setModel(listModel);
        jList7.setModel(listModel);
        jList8.setModel(listModel);
        jList9.setModel(listModel);
        jList10.setModel(listModel);
        jList11.setModel(listModel);
        jList12.setModel(listModel);
        jList13.setModel(listModel);
        jList14.setModel(listModel);
        jList16.setModel(listModel);
        jList17.setModel(listModel);
        jList18.setModel(listModel);
        jList19.setModel(listModel);
        jList20.setModel(listModel);
        jList21.setModel(listModel);
        jList22.setModel(listModel);
        jList23.setModel(listModel);
        jList24.setModel(listModel);
        jList25.setModel(listModel);
        jList26.setModel(listModel);
        jList27.setModel(listModel);
        jList28.setModel(listModel);
        jList29.setModel(listModel);
        
        jlist2items = Select.listAllMediaInJList(jList2, Home.this, searching2, sort);
        jlist1items = Select.listMediaInJList(jList1, Home.this, "Action or Adventure", searching2, sort);
        jlist3items = Select.listMediaInJList(jList3, Home.this, "Comedy film", searching2, sort);
        jlist4items = Select.listMediaInJList(jList4, Home.this, "Crime and Gangster", searching2, sort);
        jlist5items = Select.listMediaInJList(jList5, Home.this, "Drama", searching2, sort);
        jlist6items = Select.listMediaInJList(jList6, Home.this, "Epics or historical", searching2, sort);
        jlist7items = Select.listMediaInJList(jList7, Home.this, "Horror", searching2, sort);
        jlist8items = Select.listMediaInJList(jList8, Home.this, "Musicals and dance", searching2, sort);
        jlist9items = Select.listMediaInJList(jList9, Home.this, "Science fiction (Sci-Fi)", searching2, sort);
        jlist10items = Select.listMediaInJList(jList10, Home.this, "War", searching2, sort);
        jlist11items = Select.listMediaInJList(jList11, Home.this, "Westerns", searching2, sort);
        jlist12items = Select.listMediaInJList(jList12, Home.this, "Tv shows", searching2, sort);
        jlist13items = Select.listMediaInJList(jList13, Home.this, "Funny video", searching2, sort);
        jlist14items = Select.listMediaInJList(jList14, Home.this, "Amazing video", searching2, sort);
        jlist16items = Select.listMediaInJList(jList16, Home.this, "Adult video", searching2, sort);
        jlist17items = Select.listMediaInJList(jList17, Home.this, "Music video", searching2, sort);
        jlist18items = Select.listMediaInJList(jList18, Home.this, "Christian video", searching2, sort);
        jlist19items = Select.listMediaInJList(jList19, Home.this, "Islamic video", searching2, sort);
        jlist20items = Select.listMediaInJList(jList20, Home.this, "Other religion video", searching2, sort);
        jlist21items = Select.listMediaInJList(jList21, Home.this, "Native film", searching2, sort);
        jlist22items = Select.listMediaInJList(jList22, Home.this, "Native Tv shows", searching2, sort);
        jlist23items = Select.listMediaInJList(jList23, Home.this, "Native fun video", searching2, sort);
        jlist24items = Select.listMediaInJList(jList24, Home.this, "Native music video", searching2, sort);
        jlist25items = Select.listMediaInJList(jList25, Home.this, "Foreign Music / Audio", searching2, sort);
        jlist26items = Select.listMediaInJList(jList26, Home.this, "Native Music / Audio", searching2, sort);
        jlist27items = Select.listMediaInJList(jList27, Home.this, "Religion Music / Audio", searching2, sort);
        jlist28items = Select.listMediaInJList(jList28, Home.this, "Anniversary Music / Audio", searching2, sort);
        jlist29items = Select.listMediaInJList(jList29, Home.this, "Other", searching2, sort);

        jButton4.setEnabled(false);
        jButton3.setEnabled(false);
        jButton6.setEnabled(false);
        jButton7.setEnabled(false);
        jMenuItem7.setEnabled(false);
        jMenuItem8.setEnabled(false);
        jMenuItem9.setEnabled(false);
        jMenuItem11.setEnabled(false);
        jMenu4.setEnabled(false);
        EditSerial.setEnabled(false);
        EditSerial1.setEnabled(false);
        selection = null;
        play_path = null;
        id = 0;
    }

    private void driverSelected() {
        FileSystemView fsv = FileSystemView.getFileSystemView();
        if (oldListRoot != null && oldListRoot.length > 0){
            if(jList15.getSelectedIndex()<oldListRoot.length && jList15.getSelectedIndex() > -1){
                String driveType = fsv.getSystemTypeDescription(oldListRoot[jList15.getSelectedIndex()]);
                
               
                    totalSpace = String.valueOf(oldListRoot[jList15.getSelectedIndex()].getTotalSpace());
                    free_space = String.valueOf(oldListRoot[jList15.getSelectedIndex()].getFreeSpace());
                    driveReminingSize = oldListRoot[jList15.getSelectedIndex()].getFreeSpace();
                    float f = Float.valueOf(totalSpace);
                    float f2 = 1073741824;
                    float total_gigabyte = (f/f2);
                    
                    float f3 = Float.valueOf(free_space);
                    float free_gigabyte = (f3/f2);
                    if(free_gigabyte<0.0){
                        freeSpace.setText(String.valueOf(free_gigabyte/1024));
                        total_space2.setText("MB");
                    }else{
                        freeSpace.setText(String.valueOf(free_gigabyte));
                    }
                    total_space.setText(String.valueOf(total_gigabyte));
                    
                    
                    drivePath = oldListRoot[jList15.getSelectedIndex()].toString();
                    selectedDrive.setText(driveType+" "+oldListRoot[jList15.getSelectedIndex()] + "    selected");
                    
            }
                
        }
        
        if(play_path != null && drivePath != null){
            jButton6.setEnabled(true);
            jMenuItem11.setEnabled(true);
            jMenu4.setEnabled(true);
        }
        
    }

    private void selectItems(String listName) {
        switch(listName){
                case "jList1":
                    items = jlist1items;
                break;
                case "jList2":
                    items = jlist2items;
                break;
                case "jList3":
                    items = jlist3items;
                break;
                case "jList4":
                    items = jlist4items;
                break;
                case "jList5":
                    items = jlist5items;
                break;
                case "jList6":
                    items = jlist6items;
                break;
                case "jList7":
                    items = jlist7items;
                break;
                case "jList8":
                    items = jlist8items;
                break;
                case "jList9":
                    items = jlist9items;
                break;
                case "jList10":
                    items = jlist10items;
                break;
                case "jList11":
                    items = jlist11items;
                break;
                case "jList12":
                    items = jlist12items;
                break;
                case "jList13":
                    items = jlist13items;
                break;
                case "jList14":
                    items = jlist14items;
                break;
                case "jList16":
                    items = jlist16items;
                break;
                case "jList17":
                    items = jlist17items;
                break;
                case "jList18":
                    items = jlist18items;
                break;
                case "jList19":
                    items = jlist19items;
                break;
                case "jList20":
                    items = jlist20items;
                break;
                case "jList21":
                    items = jlist21items;
                break;
                case "jList22":
                    items = jlist22items;
                break;
                case "jList23":
                    items = jlist23items;
                break;
                case "jList24":
                    items = jlist24items;
                break;
                case "jList25":
                    items = jlist25items;
                break;
                case "jList26":
                    items = jlist26items;
                break;
                case "jList27":
                    items = jlist27items;
                break;
                case "jList28":
                    items = jlist28items;
                break;
                case "jList29":
                    items = jlist29items;
                break;
                case "episodesList":
                    if(recentButtonClicked){
                        items = recentitems;
                    }else{
                        items = episodeitems;
                    }
                break;
                default:
                    break;
                
        }
    }

    private void searchselectItems(String listName) {
        switch(listName){
                case "jList1":
                    items = search1items;
                break;
                case "jList2":
                    items = search2items;
                break;
                case "jList3":
                    items = search3items;
                break;
                case "jList4":
                    items = search4items;
                break;
                case "jList5":
                    items = search5items;
                break;
                case "jList6":
                    items = search6items;
                break;
                case "jList7":
                    items = search7items;
                break;
                case "jList8":
                    items = search8items;
                break;
                case "jList9":
                    items = search9items;
                break;
                case "jList10":
                    items = search10items;
                break;
                case "jList11":
                    items = search11items;
                break;
                case "jList12":
                    items = search12items;
                break;
                case "jList13":
                    items = search13items;
                break;
                case "jList14":
                    items = search14items;
                break;
                case "jList16":
                    items = search16items;
                break;
                case "jList17":
                    items = search17items;
                break;
                case "jList18":
                    items = search18items;
                break;
                case "jList19":
                    items = search19items;
                break;
                case "jList20":
                    items = search20items;
                break;
                case "jList21":
                    items = search21items;
                break;
                case "jList22":
                    items = search22items;
                break;
                case "jList23":
                    items = search23items;
                break;
                case "jList24":
                    items = search24items;
                break;
                case "jList25":
                    items = search25items;
                break;
                case "jList26":
                    items = search26items;
                break;
                case "jList27":
                    items = search27items;
                break;
                case "jList28":
                    items = search28items;
                break;
                case "jList29":
                    items = search29items;
                break;
                case "episodesList":
                    if(recentButtonClicked){
                        items = recentitems;
                    }else{
                        items = episodeitems;
                    }
                break;
                default:
                    break;
                
        }
    }

    private void displayTray(File source, File dest) {
        try {
            SystemTray tray = SystemTray.getSystemTray();
            Image image = Toolkit.getDefaultToolkit().createImage(getClass().getResource("Icons/notification.png"));
            TrayIcon trayIcon = new TrayIcon(image, folderName);
            trayIcon.setImageAutoSize(true);
            trayIcon.setToolTip("System tray icon demo");
            tray.add(trayIcon);
            trayIcon.displayMessage("Movie Store!",source.getName()+" to\n "+dest.getParentFile().getPath()+"  sent!", TrayIcon.MessageType.INFO);
        } catch (AWTException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void waitForNotifying(JList<String> jList15) {
        Thread t = new Thread(() -> {
            while(true){
                try {
                    Thread.sleep(100);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
                }
                if(File.listRoots().length>oldListRoot.length){
                    oldListRoot = File.listRoots();
                    DefaultListModel listModel = new DefaultListModel();
                    listModel.clear();
                    FileSystemView fsv = FileSystemView.getFileSystemView();
                    if (oldListRoot != null && oldListRoot.length > 0){
                        for (File aDrive : oldListRoot){
                            String driveType = fsv.getSystemTypeDescription(aDrive);
                            switch (driveType) {
                                case "Local Disk":
                                    listModel.addElement(new ImageAndText(driveType+" "+aDrive, new ImageIcon(Home.class.getResource("/moviestore/Icons/compact_disc_25px.png"))));
                                    break;
                                case "CD Drive":
                                    listModel.addElement(new ImageAndText(driveType+" "+aDrive, new ImageIcon(Home.class.getResource("/moviestore/Icons/cd_25px.png"))));
                                    break;
                                default:
                                    listModel.addElement(new ImageAndText(driveType+" "+aDrive, new ImageIcon(Home.class.getResource("/moviestore/Icons/usb_25px.png"))));
                                    break;
                            }
                        }
                    }
                    jList15.setCellRenderer(new Renderer());
                    jList15.setModel(listModel);
                }else if(File.listRoots().length < oldListRoot.length){
                    oldListRoot = File.listRoots();
                    DefaultListModel listModel = new DefaultListModel();
                    listModel.clear();
                    FileSystemView fsv = FileSystemView.getFileSystemView();
                    if (oldListRoot != null && oldListRoot.length > 0){
                        for (File aDrive : oldListRoot){
                            String driveType = fsv.getSystemTypeDescription(aDrive);
                            switch (driveType) {
                                case "Local Disk":
                                    listModel.addElement(new ImageAndText(driveType+" "+aDrive, new ImageIcon(Home.class.getResource("/moviestore/Icons/compact_disc_25px.png"))));
                                    break;
                                case "CD Drive":
                                    listModel.addElement(new ImageAndText(driveType+" "+aDrive, new ImageIcon(Home.class.getResource("/moviestore/Icons/cd_25px.png"))));
                                    break;
                                default:
                                    listModel.addElement(new ImageAndText(driveType+" "+aDrive, new ImageIcon(Home.class.getResource("/moviestore/Icons/usb_25px.png"))));
                                    break;
                            }
                        }
                    }
                    
                    jList15.setCellRenderer(new Renderer());
                    jList15.setModel(listModel);
                }
                
            }
        });
        t.start();
    }

    private void driverRootSelected(MouseEvent evt) {
        if(evt.getClickCount() == 2){
            if(jList15.getSelectedIndex()<oldListRoot.length && jList15.getSelectedIndex()>-1){
                    File file = new File(oldListRoot[jList15.getSelectedIndex()].getPath());
                    
                    try {
                        if(file.exists()){
                            Desktop.getDesktop().open(file);
                        }
                        
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(this, ex.getMessage());
                    }
                }
        }
        
    }

}


