import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

public class Rice {
    Rice(userInfo user, ArrayList<userInfo> users) throws IOException {
        ReadAndWrite readAndWrite4 = new ReadAndWrite();
        JLabel imgLabel13 = new JLabel(new ImageIcon(readAndWrite4.readImage("img/drink1.png")));
        imgLabel13.setBounds(300, 30, 60, 60);
        JLabel imgLabel14 = new JLabel(new ImageIcon(readAndWrite4.readImage("img/drink2.png")));
        imgLabel14.setBounds(300, 100, 60, 60);
        JLabel imgLabel15 = new JLabel(new ImageIcon(readAndWrite4.readImage("img/drink3.png")));
        imgLabel15.setBounds(300, 170, 60, 60);
        JLabel imgLabel16 = new JLabel(new ImageIcon(readAndWrite4.readImage("img/drink4.png")));
        imgLabel16.setBounds(300, 240, 60, 60);
        JFrame jf3 = new JFrame();
        jf3.setBounds(200, 300, 500, 400);
        JRadioButton jr13 = new JRadioButton("Rice$0");
        jr13.setActionCommand(jr13.getText());
        jr13.setBounds(20, 30, 100, 50);
        JRadioButton jr14 = new JRadioButton("Pork chop rice$10");
        jr14.setActionCommand(jr14.getText());
        jr14.setBounds(20, 100, 100, 50);
        JRadioButton jr15 = new JRadioButton("Fried rice$10");
        jr15.setActionCommand(jr15.getText());
        jr15.setBounds(20, 170, 100, 50);
        JRadioButton jr16 = new JRadioButton("porridge$5");
        jr16.setActionCommand(jr16.getText());
        jr16.setBounds(20, 240, 100, 50);
        //JRadioButton jr5 = new JRadioButton("Water$20");
        //jr5.setBounds(500, 50, 100, 50);*/
        MyJButton jb4 = new MyJButton("Yes");
        jb4.setBounds(200, 300, 70, 30);
        MyJButton jb44 = new MyJButton("Next");
        jb44.setBounds(300, 300, 70, 30);
        JLabel jl4 = new JLabel("RICE");
        jl4.setBounds(10, 10, 50, 30);
        JPanel jp4 = new JPanel(null);
        ButtonGroup bg4 = new ButtonGroup();
        bg4.add(jr13);
        bg4.add(jr14);
        bg4.add(jr15);
        bg4.add(jr16);
        //bg1.add(jr5);
        jb4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] array = bg4.getSelection().getActionCommand().split("\\$");
                user.setPayment(user.getPayment() + Integer.parseInt(array[1]));
                StringBuilder sb = new StringBuilder(user.getMeal());
                user.setMeal(sb.append(array[0]).append(",").toString());
            }
        });
        jb44.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SeatsAndMealMenu(user, users);
            }
        });
        jp4.add(jr13);
        jp4.add(jr14);
        jp4.add(jr15);
        jp4.add(jr16);
        //jp1.add(jr5);
        jp4.add(jl4);
        jp4.add(jb4);
        jp4.add(jb44);
        jf3.add(imgLabel13);
        jf3.add(imgLabel14);
        jf3.add(imgLabel15);
        jf3.add(imgLabel16);
        jf3.add(jp4);

        jf3.setVisible(true);
    }
}