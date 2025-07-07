/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.ac.tut.client;

import za.ac.entity.Client;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Owethu
 */
public class ClietFrame extends JFrame {

    private JPanel mainPln;
    private JPanel headingPln;
    private JPanel namePln;
    private JPanel surnamePln;
    private JPanel clientPln;
    private JPanel membershipPln;
    private JPanel personalPln;
    private JPanel genderPln;
    private JPanel commentsPln;
    private JPanel idNoPln;
    private JPanel contractPln;
    private JPanel headingClientPln;
    private JPanel membershipCommentsPln;

    //labels
    private JLabel headingLbl;
    private JLabel personalLbl;
    private JLabel nameLbl;
    private JLabel surnameLbl;
    private JLabel idNoLbl;
    private JLabel genderLbl;
    private JLabel contractTypeLbl;

    //textfields
    private JTextField nameTxtFld;
    private JTextField surnameTxtFld;
    private JTextField idNoTxtFld;

    //combobox
    private JComboBox genderComboBox;

    //radio buttons
    private JRadioButton monthToMonthRadBtn;
    private JRadioButton sixMonthsRadBtn;
    private JRadioButton annualRadBtn;

    //checkbox
    private JCheckBox personalTrainerChkBx;

    //buttongroup
    private ButtonGroup btnGrp;

    //textarea
    private JTextArea commentsArea;

    //scrollpane
    private JScrollPane scrollableTxtArea;

    //menubar
    private JMenuBar menuBar;

    //menu items
    private JMenuItem openFileMenuItem;
    private JMenuItem viewFileMenuItem;
    private JMenuItem clearMenuItem;
    private JMenuItem exitMenuItem;

    //menu
    private JMenu fileMenu;

    public ClietFrame() {

        setTitle("Cleint Membership");
        setSize(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        JFrame.setDefaultLookAndFeelDecorated(true);

        //menubar
        //menu bar
        menuBar = new JMenuBar();

        //menu 
        fileMenu = new JMenu("File");
        //menu item
        openFileMenuItem = new JMenuItem("Register member...");
        openFileMenuItem.addActionListener(new RegisterButtonListener());
        viewFileMenuItem = new JMenuItem("Display members...");
        viewFileMenuItem.addActionListener(new Display());
  
        clearMenuItem = new JMenuItem("Clear");
          clearMenuItem.addActionListener(new Clear());
        exitMenuItem = new JMenuItem("Exit");
          exitMenuItem.addActionListener(new Exit());

        //add items to the file menu
        fileMenu.add(openFileMenuItem);
        fileMenu.add(viewFileMenuItem);
        fileMenu.addSeparator();
        fileMenu.add(clearMenuItem);
        fileMenu.add(exitMenuItem);

        menuBar.add(fileMenu);

        headingPln = new JPanel(new FlowLayout(FlowLayout.CENTER));
        clientPln = new JPanel(new GridLayout(4, 1, 1, 1));
        clientPln.setBorder(new TitledBorder(new LineBorder(Color.RED,9), "CLIEBT INFO"));

        namePln = new JPanel(new FlowLayout(FlowLayout.LEFT));
        surnamePln = new JPanel(new FlowLayout(FlowLayout.LEFT));
        idNoPln = new JPanel(new FlowLayout(FlowLayout.LEFT));
        genderPln = new JPanel(new FlowLayout(FlowLayout.LEFT));

        membershipPln = new JPanel(new GridLayout(2, 1, 1, 1));
        membershipPln.setBorder(new TitledBorder(new LineBorder(Color.BLACK, 1), "MEMBERSHIP DETAILS"));

        contractPln = new JPanel(new FlowLayout(FlowLayout.LEFT));
        personalPln = new JPanel(new FlowLayout(FlowLayout.LEFT));

        commentsPln = new JPanel(new FlowLayout(FlowLayout.LEFT));

        headingClientPln = new JPanel(new BorderLayout());
        membershipCommentsPln = new JPanel(new BorderLayout());
        mainPln = new JPanel(new BorderLayout());

        headingLbl = new JLabel("Client Registration");
        headingLbl.setFont(new Font(Font.SANS_SERIF, Font.ITALIC + Font.BOLD, 20));
        headingLbl.setForeground(Color.BLUE);
        headingLbl.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED));

        nameLbl = new JLabel("Name ");
        surnameLbl = new JLabel("Surname ");
        genderLbl = new JLabel("Gender ");
        idNoLbl = new JLabel("id bumber ");
        contractTypeLbl = new JLabel("Type of contract ");
        personalLbl = new JLabel("Select check box if personal trainer is needed ");

        nameTxtFld = new JTextField(10);
        surnameTxtFld = new JTextField(10);
        idNoTxtFld = new JTextField(10);

        genderComboBox = new JComboBox();
        genderComboBox.addItem("Male");
        genderComboBox.addItem("Female");

        monthToMonthRadBtn = new JRadioButton("Month-to-month");
        sixMonthsRadBtn = new JRadioButton("Six months");
        annualRadBtn = new JRadioButton("Annual");

        //create csheck box
        personalTrainerChkBx = new JCheckBox();

        //create button group
        btnGrp = new ButtonGroup();
        btnGrp.add(monthToMonthRadBtn);
        btnGrp.add(sixMonthsRadBtn);
        btnGrp.add(annualRadBtn);

        commentsArea = new JTextArea(15, 50);
        commentsArea.setBorder(new TitledBorder(new LineBorder(Color.GREEN, 5), "CLIENT DETAILS"));
        commentsArea.setEditable(false);

        scrollableTxtArea = new JScrollPane(commentsArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

//        scrollableTxtArea =
        headingPln.add(headingLbl);

        namePln.add(nameLbl);
        namePln.add(nameTxtFld);
        surnamePln.add(surnameLbl);
        surnamePln.add(surnameTxtFld);
        idNoPln.add(idNoLbl);
        idNoPln.add(idNoTxtFld);
        genderPln.add(genderLbl);
        genderPln.add(genderComboBox);

        clientPln.add(namePln);
        clientPln.add(surnamePln);
        clientPln.add(idNoPln);
        clientPln.add(genderPln);

        headingClientPln.add(headingPln, BorderLayout.NORTH);
        headingClientPln.add(clientPln, BorderLayout.CENTER);

        contractPln.add(contractTypeLbl);
        contractPln.add(monthToMonthRadBtn); //---> third collective panel
        contractPln.add(sixMonthsRadBtn);
        contractPln.add(annualRadBtn);

        personalPln.add(personalLbl);
        personalPln.add(personalTrainerChkBx);

        membershipPln.add(contractPln);
        membershipPln.add(personalPln);

        commentsPln.add(scrollableTxtArea); //---> fourth collective panel

        membershipCommentsPln.add(membershipPln, BorderLayout.NORTH);
        membershipCommentsPln.add(commentsPln, BorderLayout.CENTER);

        mainPln.add(headingClientPln, BorderLayout.NORTH);
        mainPln.add(membershipCommentsPln, BorderLayout.CENTER);

        add(mainPln);

        pack();

        setResizable(true);

        //add 
        setJMenuBar(menuBar);

        setVisible(true);

    }

    private class RegisterButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String name = nameTxtFld.getText();
            String surname = surnameTxtFld.getText();
            String idNo = idNoTxtFld.getText();
            String gender = (String) genderComboBox.getSelectedItem();
            boolean personal = personalTrainerChkBx.isSelected();
            String contract = "Month-To-Month";

            if (sixMonthsRadBtn.isSelected()) {
                contract = "six months";
            } else if (annualRadBtn.isSelected()) {
                contract = "annual";
            }

            Client c = new Client(name, surname, idNo, gender, contract, personal);

            //open file chooser
            JFileChooser fc = new JFileChooser();
            //assign a val to the file chooser
            int val = fc.showSaveDialog(ClietFrame.this);

            if (val == JFileChooser.APPROVE_OPTION) {

                try {
                    File f = fc.getSelectedFile();
                    BufferedWriter bw = new BufferedWriter(new FileWriter(f));
                    bw.write(c.toString());
                    bw.newLine();
                    bw.close();
                    JOptionPane.showMessageDialog(ClietFrame.this, "Registered and saved on file");
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            } else {
                JOptionPane.showMessageDialog(ClietFrame.this, "The if statement failed.The returned value is " + val);
            }

        }

    }

    private class Display implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
           
            JFileChooser fc = new JFileChooser();
              String data, record ="";
            int val = fc.showOpenDialog(ClietFrame.this);
            
            if(val == JFileChooser.APPROVE_OPTION){
                BufferedReader br = null;
                try {
                    File f = fc.getSelectedFile();
                    br = new BufferedReader(new FileReader(f));
                  
                    while((data=br.readLine())!= null){
                   
                     record = record+ data + "\n";
                      
                    }
                    commentsArea.append(record +"\n");
                      br.close();
                     
                    
                } catch (FileNotFoundException ex) {
                   ex.printStackTrace();
                } catch (IOException ex) {
                   ex.printStackTrace();
                } finally {
                    try {
                        br.close();
                    } catch (IOException ex) {
                       ex.printStackTrace();
                    }
                }
             
            }
            
                  
        }

    }
    public class Clear implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
        
           nameTxtFld.setText("");
           surnameTxtFld.setText("");
           idNoTxtFld.setText("");
           personalTrainerChkBx.setSelected(false);
           btnGrp.clearSelection();
           commentsArea.setText("");
        }
    
    }
    public class Exit implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
        
            System.exit(0);
        }
    
    }

}
