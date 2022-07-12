package WalletPack;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class Wallet extends JFrame implements ActionListener{
    private double uan = 0;
    private double euro = 0;
    private double dollars = 0;
    private double pln = 0;

    private final String path = "C:\\WalletSource\\Source.txt";

    JLabel uanLab;
    JLabel euroLab;
    JLabel dollarsLab;
    JLabel plnLab;

    JLabel earnLab;
    JLabel spendLab;

    JPanel leftPanel;
    JPanel rightPanel;
    JPanel earnPanel;
    JPanel spendPanel;

    JTextField spendTF;
    JTextField earnTF;

    JButton spendButton;
    JButton earnButton;

    JRadioButton spendUanRB;
    JRadioButton spendEuroRB;
    JRadioButton spendDollarsRB;
    JRadioButton spendPlnRB;

    JRadioButton earnUanRB;
    JRadioButton earnEuroRB;
    JRadioButton earnDollarsRB;
    JRadioButton earnPlnRB;

    ButtonGroup spendButtonGroup;
    ButtonGroup earnButtonGroup;

    Wallet() throws IOException {

        File file = new File(path);
        if(!file.exists()){
            try {
                boolean newFile = file.createNewFile();
                if(!newFile){
                    System.out.println("File was not created!!!");
                }

                System.out.println("**File was created\n");
                FileWriter fileWriter = new FileWriter(path);
                fileWriter.write("0\n0\n0\n0");
                fileWriter.close();
            }
            catch(Exception e) {
                System.out.println(e.toString());
                throw e;
            }
        }
        else if(file.exists()){
            BufferedReader reader = new BufferedReader(new FileReader(path));

            String value = reader.readLine();
            System.out.println(value);
            uan = Double.parseDouble(value);

            value = reader.readLine();
            euro = Double.parseDouble(value);
            System.out.println(value);

            value = reader.readLine();
            dollars = Double.parseDouble(value);
            System.out.println(value);

            value = reader.readLine();
            pln = Double.parseDouble(value);
            System.out.println(value);
        }

        //Labels
        uanLab = new JLabel("Гривні - " + uan, SwingConstants.CENTER);
        euroLab = new JLabel("Євро - " + euro, SwingConstants.CENTER);
        dollarsLab = new JLabel("Долари - " + dollars, SwingConstants.CENTER);
        plnLab = new JLabel("Злоті - " + pln, SwingConstants.CENTER);
        spendLab = new JLabel("Витрати");
        earnLab = new JLabel("Заробіток");
        //Labels

        //Panels
        leftPanel = new JPanel();
        rightPanel = new JPanel();
        spendPanel = new JPanel();
        earnPanel = new JPanel();
        //Panels

        //TextFields
        spendTF = new JTextField();
        earnTF = new JTextField();
        //TextFields

        //RadioButtons
        spendUanRB = new JRadioButton("Грн");
        earnUanRB = new JRadioButton("Грн");
        spendEuroRB = new JRadioButton("Eur");
        earnEuroRB = new JRadioButton("Eur");
        spendDollarsRB = new JRadioButton("USD");
        earnDollarsRB = new JRadioButton("USD");
        spendPlnRB = new JRadioButton("PLN");
        earnPlnRB = new JRadioButton("PLN");

        spendUanRB.setBounds(30, 120, 50, 15);
        earnUanRB.setBounds(30, 120, 50, 15);
        spendEuroRB.setBounds(80, 120, 50, 15);
        earnEuroRB.setBounds(80, 120, 50, 15);
        spendDollarsRB.setBounds(130,120, 55, 15);
        earnDollarsRB.setBounds(130,120, 55, 15);
        spendPlnRB.setBounds(185, 120, 50, 15);
        earnPlnRB.setBounds(185, 120, 50, 15);
        //RadioButtons

        //ButtonGroups
        spendButtonGroup = new ButtonGroup();
        earnButtonGroup = new ButtonGroup();

        spendButtonGroup.add(spendUanRB);
        spendButtonGroup.add(spendDollarsRB);
        spendButtonGroup.add(spendEuroRB);
        spendButtonGroup.add(spendPlnRB);

        earnButtonGroup.add(earnUanRB);
        earnButtonGroup.add(earnDollarsRB);
        earnButtonGroup.add(earnEuroRB);
        earnButtonGroup.add(earnPlnRB);
        //ButtonGroups

        //Buttons
        spendButton = new JButton("Підтвердити");
        spendButton.addActionListener(this);
        spendButton.setBounds(50, 150, 130, 20);

        earnButton = new JButton("Підтвердити");
        earnButton.addActionListener(this);
        earnButton.setBounds(50, 150, 130, 20);
        //Buttons

        //SetColors
        leftPanel.setBackground(Color.GRAY);
        rightPanel.setBackground(Color.darkGray);
        //SetColors


        rightPanel.setLayout(new GridLayout(2, 1));

        spendLab.setBounds(50, 50, 70, 40);
        spendTF.setBounds(50, 80, 130, 30);

        earnLab.setBounds(50, 50, 70, 40);
        earnTF.setBounds(50, 80, 130, 30);


        spendPanel.add(spendLab);
        spendPanel.add(spendTF);
        spendPanel.add(spendButton);
        spendPanel.add(spendUanRB);
        spendPanel.add(spendEuroRB);
        spendPanel.add(spendDollarsRB);
        spendPanel.add(spendPlnRB);

        spendPanel.setLayout(null);

        earnPanel.add(earnLab);
        earnPanel.add(earnTF);
        earnPanel.add(earnButton);

        earnPanel.add(earnUanRB);
        earnPanel.add(earnEuroRB);
        earnPanel.add(earnDollarsRB);
        earnPanel.add(earnPlnRB);
        earnPanel.setLayout(null);

        rightPanel.add(spendPanel);
        rightPanel.add(earnPanel);

        leftPanel.add(uanLab);
        leftPanel.add(dollarsLab);
        leftPanel.add(euroLab);
        leftPanel.add(plnLab);

        leftPanel.setLayout(new GridLayout(4, 1));


        //MAIN FRAME
        add(leftPanel);
        add(rightPanel);

        setTitle("Твої мікроскопічні гроші");
        setLayout(new GridLayout(1, 2));
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Set the standard JFrame close button operation
        setSize(500, 450);                            //Pass in variables to size the JFrame, frm
        setLocationRelativeTo(null);                    //Locate frm relative to the screen center
        setVisible(true);                               //Make JFrame frm visible
    }

    @Override
    public void actionPerformed(ActionEvent e){
        //TODO Create method for choosing different valuta
        if(e.getSource()==earnButton){
            try{
                double new_money = Double.parseDouble(earnTF.getText());
                earnTF.setText("");
                if(earnUanRB.isSelected()) {
                    uan += new_money;
                    uanLab.setText("Гривні - " + uan);
                }
                else if(earnEuroRB.isSelected()){
                    euro += new_money;
                    euroLab.setText("Євро - " + euro);
                }
                else if(earnDollarsRB.isSelected()){
                    dollars += new_money;
                    dollarsLab.setText("Долари - " + dollars);
                }
                else if(earnPlnRB.isSelected()){
                    pln += new_money;
                    plnLab.setText("Злоті - " + pln);
                }
                else{
                    earnTF.setText("Вибери валюту!");
                }

                FileWriter refresher = new FileWriter(path);
                refresher.write("" + uan + "\n" + euro + "\n" + dollars + "\n" + pln);
                refresher.close();
            }
            catch (Exception exception){
                System.out.println(exception.toString());
                earnTF.setText("Пиши по-людськи!");
            }
        }
        else if(e.getSource()==spendButton){
            try{
                double spends = Double.parseDouble(spendTF.getText());
                spendTF.setText("");

                if(spendUanRB.isSelected()) {
                    uan -= spends;
                    uanLab.setText("Гривні - " + uan);
                }
                else if(spendEuroRB.isSelected()){
                    euro -= spends;
                    euroLab.setText("Євро - " + euro);
                }
                else if(spendDollarsRB.isSelected()){
                    dollars -= spends;
                    dollarsLab.setText("Долари - " + dollars);
                }
                else if(spendPlnRB.isSelected()){
                    pln -= spends;
                    plnLab.setText("Злоті - " + pln);
                }
                else{
                    spendTF.setText("Вибери валюту!");
                }

                FileWriter refresher = new FileWriter(path);
                refresher.write("" + uan + "\n" + euro + "\n" + dollars + "\n" + pln);
                refresher.close();
            }
            catch (Exception exception){
                System.out.println(exception.toString());
                spendTF.setText("Пиши по-людськи!");
            }
        }
    }

    public static void main(String[] args) throws IOException {
        //TODO Wallet application
        Wallet w = new Wallet();
    }
}
