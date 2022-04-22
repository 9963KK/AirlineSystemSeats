import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

public class Noodle {
    Noodle(userInfo user, ArrayList<userInfo> users) throws IOException {
        ReadAndWrite readAndWrite3 = new ReadAndWrite();
        JLabel imgLabel9 = new JLabel(new ImageIcon(readAndWrite3.readImage("img/drink1.png")));
        imgLabel9.setBounds(300, 30, 60, 60);
        JLabel imgLabel10 = new JLabel(new ImageIcon(readAndWrite3.readImage("img/drink2.png")));
        imgLabel10.setBounds(300, 100, 60, 60);
        JLabel imgLabel11 = new JLabel(new ImageIcon(readAndWrite3.readImage("img/drink3.png")));
        imgLabel11.setBounds(300, 170, 60, 60);
        JLabel imgLabel12 = new JLabel(new ImageIcon(readAndWrite3.readImage("img/drink4.png")));
        imgLabel12.setBounds(300, 240, 60, 60);
        JFrame jf2 = new JFrame();
        jf2.setBounds(200, 300, 500, 400);
        JRadioButton jr9 = new JRadioButton("Braised beef noodles$10");
        jr9.setActionCommand(jr9.getText());
        jr9.setBounds(20, 30, 100, 50);
        JRadioButton jr10 = new JRadioButton("Dan Dan noodles$10");
        jr10.setActionCommand(jr10.getText());
        jr10.setBounds(20, 100, 100, 50);
        JRadioButton jr11 = new JRadioButton("pasta$10");
        jr11.setActionCommand(jr11.getText());
        jr11.setBounds(20, 170, 100, 50);
        JRadioButton jr12 = new JRadioButton("Udon noodles$10");
        jr12.setActionCommand(jr12.getText());
        jr12.setBounds(20, 240, 100, 50);
        //JRadioButton jr5 = new JRadioButton("Water$20");
        //jr5.setBounds(500, 50, 100, 50);
        MyJButton jb3 = new MyJButton("Yes");
        jb3.setBounds(200, 300, 70, 30);
        MyJButton jb33 = new MyJButton("Next");
        jb33.setBounds(300, 300, 70, 30);
        JLabel jl3 = new JLabel("NOODLE");
        jl3.setBounds(10, 10, 50, 30);
        JPanel jp3 = new JPanel(null);
        ButtonGroup bg3 = new ButtonGroup();
        bg3.add(jr9);
        bg3.add(jr10);
        bg3.add(jr11);
        bg3.add(jr12);
        //bg1.add(jr5);
        jb3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] array = bg3.getSelection().getActionCommand().split("\\$");
                user.setPayment(user.getPayment() + Integer.parseInt(array[1]));
                StringBuilder sb = new StringBuilder(user.getMeal());
                user.setMeal(sb.append(array[0]).append(",").toString());
            }
        });
        jb33.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                jf2.setVisible(false);
                try {
                    new Rice(user, users);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }

            }
        });
        jp3.add(jr9);
        jp3.add(jr10);
        jp3.add(jr11);
        jp3.add(jr12);
        //jp1.add(jr5);
        jp3.add(jl3);
        jp3.add(jb3);
        jp3.add(jb33);
        jf2.add(imgLabel9);
        jf2.add(imgLabel10);
        jf2.add(imgLabel11);
        jf2.add(imgLabel12);
        jf2.add(jp3);

        jf2.setVisible(true);
    }
}