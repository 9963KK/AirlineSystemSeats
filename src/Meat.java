import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

public class Meat {
    Meat(userInfo user, ArrayList<userInfo> users) throws IOException {
        ReadAndWrite readAndWrite2 = new ReadAndWrite();
        JLabel imgLabel5 = new JLabel(new ImageIcon(readAndWrite2.readImage("img/drink1.png")));
        imgLabel5.setBounds(300, 30, 60, 60);
        JLabel imgLabel6 = new JLabel(new ImageIcon(readAndWrite2.readImage("img/drink2.png")));
        imgLabel6.setBounds(300, 100, 60, 60);
        JLabel imgLabel7 = new JLabel(new ImageIcon(readAndWrite2.readImage("img/drink3.png")));
        imgLabel7.setBounds(300, 170, 60, 60);
        JLabel imgLabel8 = new JLabel(new ImageIcon(readAndWrite2.readImage("img/drink4.png")));
        imgLabel8.setBounds(300, 240, 60, 60);
        JFrame jf1 = new JFrame();
        jf1.setBounds(200, 300, 500, 400);
        JRadioButton jr5 = new JRadioButton("Pork chops$20");
        jr5.setActionCommand(jr5.getText());
        jr5.setBounds(20, 30, 100, 50);
        JRadioButton jr6 = new JRadioButton("Steak$20");
        jr6.setActionCommand(jr6.getText());
        jr6.setBounds(20, 100, 100, 50);
        JRadioButton jr7 = new JRadioButton("Braised Pork$20");
        jr7.setActionCommand(jr7.getText());
        jr7.setBounds(20, 170, 100, 50);
        JRadioButton jr8 = new JRadioButton("Fried fish$20");
        jr8.setActionCommand(jr8.getText());
        jr8.setBounds(20, 240, 100, 50);
        //JRadioButton jr5 = new JRadioButton("Water$20");
        //jr5.setBounds(500, 50, 100, 50);
        MyJButton jb2 = new MyJButton("Yes");
        jb2.setBounds(200, 300, 70, 30);
        MyJButton jb22 = new MyJButton("Next");
        jb22.setBounds(300, 300, 70, 30);
        JLabel jl2 = new JLabel("MEAT");
        jl2.setBounds(10, 10, 50, 30);
        JPanel jp2 = new JPanel(null);
        ButtonGroup bg2 = new ButtonGroup();
        bg2.add(jr5);
        bg2.add(jr6);
        bg2.add(jr7);
        bg2.add(jr8);
        //bg1.add(jr5);
        jb2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] array = bg2.getSelection().getActionCommand().split("\\$");
                user.setPayment(user.getPayment() + Integer.parseInt(array[1]));
                StringBuilder sb = new StringBuilder(user.getMeal());
                user.setMeal(sb.append(array[0]).append(",").toString());
            }
        });
        jb22.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                jf1.setVisible(false);
                try {
                    new Noodle(user, users);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }

            }
        });
        jp2.add(jr5);
        jp2.add(jr6);
        jp2.add(jr7);
        jp2.add(jr8);
        //jp1.add(jr5);
        jp2.add(jl2);
        jp2.add(jb2);
        jp2.add(jb22);
        jf1.add(imgLabel5);
        jf1.add(imgLabel6);
        jf1.add(imgLabel7);
        jf1.add(imgLabel8);
        jf1.add(jp2);

        jf1.setVisible(true);
    }
}