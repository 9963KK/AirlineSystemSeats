import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

public class Meal extends JFrame {

    Meal(userInfo user, ArrayList<userInfo> users) throws IOException {
//drink
        ReadAndWrite readAndWrite1 = new ReadAndWrite();
        JLabel imgLabel1 = new JLabel(new ImageIcon(readAndWrite1.readImage("img/drink1.png")));
        imgLabel1.setBounds(300, 30, 60, 60);
        JLabel imgLabel2 = new JLabel(new ImageIcon(readAndWrite1.readImage("img/drink2.png")));
        imgLabel2.setBounds(300, 100, 60, 60);
        JLabel imgLabel3 = new JLabel(new ImageIcon(readAndWrite1.readImage("img/drink3.png")));
        imgLabel3.setBounds(300, 170, 60, 60);
        JLabel imgLabel4 = new JLabel(new ImageIcon(readAndWrite1.readImage("img/drink4.png")));
        imgLabel4.setBounds(300, 240, 60, 60);
        JFrame jf = new JFrame();
        jf.setBounds(200, 300, 500, 400);
        //TimePanel jPanel1 = new TimePanel();
        JRadioButton jr1 = new JRadioButton("Mineral water$0");
        jr1.setActionCommand(jr1.getText());
        jr1.setBounds(20, 30, 100, 50);
        JRadioButton jr2 = new JRadioButton("Coke$1");
        jr2.setActionCommand(jr2.getText());
        jr2.setBounds(20, 100, 100, 50);
        JRadioButton jr3 = new JRadioButton("Coffee$3");
        jr3.setActionCommand(jr3.getText());
        jr3.setBounds(20, 170, 100, 50);
        JRadioButton jr4 = new JRadioButton("Tea$5");
        jr4.setActionCommand(jr4.getText());
        jr4.setBounds(20, 240, 100, 50);
        //JRadioButton jr5 = new JRadioButton("Water$20");
        //jr5.setBounds(500, 50, 100, 50);
        MyJButton jb1 = new MyJButton("Yes");
        jb1.setBounds(100, 300, 70, 30);
        MyJButton jb11 = new MyJButton("Next");
        jb11.setBounds(300, 300, 70, 30);
        JLabel jl = new JLabel("DRINK");
        jl.setBounds(10, 10, 50, 30);
        JPanel jp1 = new JPanel(null);
        ButtonGroup bg1 = new ButtonGroup();
        bg1.add(jr1);
        bg1.add(jr2);
        bg1.add(jr3);
        bg1.add(jr4);
        //bg1.add(jr5);
        jb1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] array = bg1.getSelection().getActionCommand().split("\\$");
                user.setPayment(user.getPayment() + Integer.parseInt(array[1]));
                StringBuilder sb = new StringBuilder();
                user.setMeal(sb.append(array[0]).toString());
            }
        });
        jb11.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                jf.setVisible(false);
                try {
                    new Meat(user, users);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }

            }
        });
        jp1.add(jr1);
        jp1.add(jr2);
        jp1.add(jr3);
        jp1.add(jr4);
        //jp1.add(jr5);
        jp1.add(jl);
        jp1.add(jb1);
        jp1.add(jb11);
        jf.add(imgLabel1);
        jf.add(imgLabel2);
        jf.add(imgLabel3);
        jf.add(imgLabel4);
        jf.add(jp1);
        // jf.add(jPanel1);
        jf.setVisible(true);

    }
}
