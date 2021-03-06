/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smith.tech;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.*;
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.lang.*;
import java.net.*;
/**
 * @version 1.1
 * @author Samuel
 */
public class Guillotine extends javax.swing.JFrame {

    /**
     * Creates new form Guillotine
     */
    public Guillotine() {
        initComponents();
    }
    
    Users[] head;
    String[] data = new String[] {"default"};
    Vector newData = new Vector();
    static int USERNAME = 1;
    static int NAME = 2;
    static int LASTNAME = 3;
    static int mode = USERNAME;

    private String getCurrent() {
        
        for (int i = 0; i < head.length; i++)
        {
            if (head[i].current())
            {
                if (mode == USERNAME)
                    return head[i].getUN();
                else if (mode == NAME)
                    return head[i].getName();
                else if (mode == LASTNAME)
                    return head[i].getLast();
            }
        }
        
        return null;
    }
    
    private String getCurrentName() {
        for (int i = 0; i < head.length; i++)
        {
            if (head[i].current())
            {
                return head[i].getName();
            }
        }
        
        return null;
    }
    
    private void updateLabels() {
        currentData.setText(getCurrent());
        UNDisplay.setText(getCurrentUN());
        NameDisplay.setText(getCurrentName());
    }
    
    private String getCurrentUN() {
        for (int i=0; i < head.length; i++)
        {
            if (head[i].current())
                return head[i].getUN();
        }
        
        return null;
    }
    
    private void icoLoad() {
        java.net.URL url = ClassLoader.getSystemResource("smith/tech/Abercrombie Logo3.png");
        
        Toolkit kit = Toolkit.getDefaultToolkit();
        Image img = kit.createImage(url);
        //img.setSize(400);
        setIconImage(img);
    }
    
    private void updateList() {
        for(int i = 0; i < head.length; i++)
        {
            if(head[i].toAdd())
            {
                if (mode == USERNAME)
                    newData.add(0, head[i].getUN());
                else
                    newData.add(0, head[i].getName());
                head[i].setAdd();
            }
        }
        
        jList1.setListData(newData);
    }
    
    private void loadList() {
                try {
            
            String[] data = Users.loader(FileWork.unFile);
            String[] nameData = Users.loader(FileWork.nameFile);
            int size = data.length;
            head = new Users [size];
            
            for(int i = 0; i < data.length; i++)
            {
                head[i] = new Users();
                head[i].setUsername(data[i]);
                head[i].setName(nameData[i]);
            }
        } catch (IOException ex) {
            Logger.getLogger(Guillotine.class.getName()).log(Level.SEVERE, null, ex);
        }
    }      
    
    public void endOfList() {
        String finalStat = new String();
        
        for (int i = 0; i < head.length; i++)
        {
            finalStat = finalStat + head[i].getStatus() + "\n";
        }
        
        Clip.copy(finalStat);
        
        NameDisplay.show(false);
        UNDisplay.show(false);
        jLabel2.show(false);
        jButton6.show(false);
        jButton5.show(false);
        jButton7.show(true);
        currentData.setText("Results copied to clipboard");
    }
    
    public void beginAgain() {
        for (int i = 0; i < head.length; i++)
        {
            head[i].setStatus("Not Checked");
            head[i].reAdd();
        }
        
        newData.clear();
        
        for (int i = 0; i<head.length; i++)
        {
            if(head[i].notChecked()) {
                head[i].setCurrent();
                break;
            }
            
        }
        
        UNDisplay.show(true);
        NameDisplay.show(true);
        jLabel2.show(true);
        updateLabels();
        updateList();
    }
    
    public void openData() {
        ProcessBuilder pb = new ProcessBuilder("C:/Windows/notepad.exe", FileWork.unFile);
        ProcessBuilder pb2 = new ProcessBuilder("C:/Windows/notepad.exe", FileWork.nameFile);
        try {
            pb.start();
            pb2.start();
        } catch (IOException ex) {
            Logger.getLogger(Guillotine.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public void editOpt() {
        if (mode == USERNAME)
        {
            switchToName.show(true);
            switchToLN.show(true);
            switchToUN.show(false);
        }
        else if (mode == NAME)
        {
            switchToUN.show(true);
            switchToLN.show(true);
            switchToName.show(false);
        }
        else
        {
            switchToUN.show(true);
            switchToName.show(true);
            switchToLN.show(false);
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

        mainUN = new javax.swing.JDesktopPane();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        currentData = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jButton7 = new javax.swing.JButton();
        UNDisplay = new javax.swing.JLabel();
        NameDisplay = new javax.swing.JLabel();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        editDataFiles = new javax.swing.JDesktopPane();
        jPanel3 = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        fileLoadSuccess = new javax.swing.JDesktopPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        firstPage = new javax.swing.JDesktopPane();
        jPanel1 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        openMenuItem = new javax.swing.JMenuItem();
        exitMenuItem = new javax.swing.JMenuItem();
        editMenu = new javax.swing.JMenu();
        switchToName = new javax.swing.JMenuItem();
        switchToUN = new javax.swing.JMenuItem();
        switchToLN = new javax.swing.JMenuItem();
        helpMenu = new javax.swing.JMenu();
        contentMenuItem = new javax.swing.JMenuItem();
        aboutMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        mainUN.show(false);
        mainUN.setLayout(new java.awt.BorderLayout());

        jLabel2.setText("Current:");

        jButton5.setText("Removed");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("Not Present");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jList1.setBackground(new java.awt.Color(204, 204, 255));
        jList1.setModel(new javax.swing.AbstractListModel() {
            //String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return data.length; }
            public Object getElementAt(int i) { return data[i]; }
        });
        jScrollPane1.setViewportView(jList1);
        jList1.setListData(newData);

        jButton7.setText("Begin Again");
        jButton7.show(false);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        UNDisplay.setText("jLabel3");
        UNDisplay.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        NameDisplay.setText("jLabel3");
        NameDisplay.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 145, Short.MAX_VALUE)
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLayeredPane1)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton7)
                                    .addComponent(currentData, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(65, Short.MAX_VALUE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(NameDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(UNDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(185, 185, 185))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(currentData, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(8, 8, 8)
                .addComponent(NameDisplay)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(UNDisplay)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton7)
                .addGap(6, 6, 6)
                .addComponent(jButton6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton5)
                .addGap(52, 52, 52))
            .addComponent(jLayeredPane1)
        );

        mainUN.add(jPanel4, java.awt.BorderLayout.CENTER);

        editDataFiles.show(false);
        editDataFiles.setLayout(new java.awt.BorderLayout());

        jButton4.setText("Click when done");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(192, 192, 192)
                .addComponent(jButton4)
                .addContainerGap(235, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(211, Short.MAX_VALUE)
                .addComponent(jButton4)
                .addGap(208, 208, 208))
        );

        editDataFiles.add(jPanel3, java.awt.BorderLayout.CENTER);

        fileLoadSuccess.show(false);
        fileLoadSuccess.setLayout(new java.awt.BorderLayout());

        jLabel1.setText("Success!");

        jButton3.setText("Click to continue");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(203, 203, 203)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jButton3)
                    .addComponent(jLabel1))
                .addContainerGap(222, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(171, 171, 171)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton3)
                .addContainerGap(215, Short.MAX_VALUE))
        );

        fileLoadSuccess.add(jPanel2, java.awt.BorderLayout.CENTER);

        firstPage.setLayout(new java.awt.BorderLayout());
        icoLoad();

        File yourFile = new File(FileWork.unFile);
        if(!yourFile.exists()) {
            jButton2.show(false);
        }
        jButton2.setText("Load previous data...");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton1.setText("Enter new data...");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(192, 192, 192)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2))
                .addContainerGap(207, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButton1, jButton2});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(178, 178, 178)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addContainerGap(198, Short.MAX_VALUE))
        );

        firstPage.add(jPanel1, java.awt.BorderLayout.CENTER);

        fileMenu.setMnemonic('f');
        fileMenu.setText("File");

        openMenuItem.setMnemonic('o');
        openMenuItem.setText("Open Data Files");
        openMenuItem.setToolTipText("");
        openMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(openMenuItem);

        exitMenuItem.setMnemonic('x');
        exitMenuItem.setText("Exit");
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(exitMenuItem);

        menuBar.add(fileMenu);

        editMenu.setMnemonic('e');
        editMenu.setText("Edit");

        switchToName.setMnemonic('t');
        switchToName.setText("Switch to Names");
        switchToName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                switchToNameActionPerformed(evt);
            }
        });
        editMenu.add(switchToName);

        switchToUN.setMnemonic('y');
        switchToUN.setText("Switch to Usernames");
        switchToUN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                switchToUNActionPerformed(evt);
            }
        });
        editMenu.add(switchToUN);

        switchToLN.setText("Switch to Lastnames");
        switchToLN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                switchToLNActionPerformed(evt);
            }
        });
        editMenu.add(switchToLN);
        switchToLN.show(false);

        menuBar.add(editMenu);

        helpMenu.setMnemonic('h');
        helpMenu.setText("Help");

        contentMenuItem.setMnemonic('c');
        contentMenuItem.setText("Contents");
        helpMenu.add(contentMenuItem);

        aboutMenuItem.setMnemonic('a');
        aboutMenuItem.setText("About");
        helpMenu.add(aboutMenuItem);

        menuBar.add(helpMenu);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(firstPage)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(fileLoadSuccess, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(editDataFiles, javax.swing.GroupLayout.Alignment.TRAILING))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(mainUN, javax.swing.GroupLayout.Alignment.TRAILING))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(firstPage)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(fileLoadSuccess, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(editDataFiles, javax.swing.GroupLayout.Alignment.TRAILING))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(mainUN, javax.swing.GroupLayout.Alignment.TRAILING))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitMenuItemActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        firstPage.show(false);
        fileLoadSuccess.show(true);

        loadList();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        editDataFiles.show(false);
        fileLoadSuccess.show(true);
        
        loadList();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        FileWork.createDir();
        
        firstPage.show(false);
        editDataFiles.show(true);
        openData();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:  
        boolean end = true;
        for (int i = 0; i < head.length; i++)
        {
            if (head[i].current())
            {
                head[i].setStatus("x");
            }
        }
        
        for (int i = 0; i < head.length; i++)
        {
            if (head[i].notChecked())
            {
                head[i].setCurrent();
                updateLabels();
                end = false;
                break;
            }
        }        
        
        updateList();
        
        if(end)
        {
            endOfList();
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        fileLoadSuccess.show(false);
        mainUN.show(true);
        
        for (int i = 0; i<head.length; i++)
        {
            if(head[i].notChecked()) {
                head[i].setCurrent();
                break;
            }
            
        }
        
        editMenu.show(true);
        
        editOpt();
        
        updateLabels();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        boolean end = true;
        
        for (int i = 0; i < head.length; i++)
        {
            if (head[i].current())
            {
                head[i].setStatus("-");
            }
        }
        
        for (int i = 0; i < head.length; i++)
        {
            if (head[i].notChecked())
            {
                head[i].setCurrent();
                updateLabels();
                end = false;
                break;
            }
        }
        
        updateList();
        
        if(end)
            endOfList();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        beginAgain();
        
        jButton6.show(true);
        jButton5.show(true);
        jButton7.show(false);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void openMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openMenuItemActionPerformed
        // TODO add your handling code here:
        openData();
        mainUN.show(false);
        firstPage.show(false);
        fileLoadSuccess.show(false);
        editDataFiles.show(true);
    }//GEN-LAST:event_openMenuItemActionPerformed

    private void switchToNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_switchToNameActionPerformed
        mode = NAME;
        
        editOpt();
        
        beginAgain();
    }//GEN-LAST:event_switchToNameActionPerformed

    private void switchToUNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_switchToUNActionPerformed
        mode = USERNAME;
        
        editOpt();
        
        beginAgain();
    }//GEN-LAST:event_switchToUNActionPerformed

    private void switchToLNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_switchToLNActionPerformed
        mode = LASTNAME;
        
        editOpt();
        
        beginAgain();
    }//GEN-LAST:event_switchToLNActionPerformed

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
            java.util.logging.Logger.getLogger(Guillotine.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Guillotine.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Guillotine.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Guillotine.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Guillotine().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel NameDisplay;
    private javax.swing.JLabel UNDisplay;
    private javax.swing.JMenuItem aboutMenuItem;
    private javax.swing.JMenuItem contentMenuItem;
    private javax.swing.JLabel currentData;
    private javax.swing.JDesktopPane editDataFiles;
    private javax.swing.JMenu editMenu;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JDesktopPane fileLoadSuccess;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JDesktopPane firstPage;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JList jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JDesktopPane mainUN;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem openMenuItem;
    private javax.swing.JMenuItem switchToLN;
    private javax.swing.JMenuItem switchToName;
    private javax.swing.JMenuItem switchToUN;
    // End of variables declaration//GEN-END:variables

}
