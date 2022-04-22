import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class SeatsAndMealMenu {
    SeatsAndMealMenu(userInfo user, ArrayList<userInfo> users) {
        HashMap<String, String> info = new HashMap<>();
        info.put(Signs.PAYMENT.getSign(), Integer.toString(user.getPayment()));
        info.put(Signs.SEATS.getSign(), user.getSeats());
        JFrame jFrame = new JFrame("     Menu     ");
        MyJButton jb1 = new MyJButton("      Choose Seats      ");
        MyJButton jb2 = new MyJButton("      Choose Meal      ");
        MyJButton jb3 = new MyJButton("      Next      ");
        MyJButton jb4 = new MyJButton("    Confirm    ");
        jb4.setBounds(350, 140, 100, 30);
        JPanel jp1 = new JPanel(null);
        JPanel jp2 = new JPanel();
        JLabel jl1 = new JLabel(Signs.PAYMENT.getSign() + ":" + info.get(Signs.PAYMENT.getSign()), JLabel.CENTER);
        jl1.setBounds(170, 80, 100, 20);
        JLabel jl2 = new JLabel(Signs.SEATS.getSign() + ":" + info.get(Signs.SEATS.getSign()), JLabel.CENTER);
        jl2.setBounds(170, 100, 100, 20);
        JLabel jl3 = new JLabel("CarID:");
        jl3.setBounds(80, 145, 50, 20);
        JLabel jl4 = new JLabel("MealName" + ":" + user.getMeal(), JLabel.CENTER);
        jl4.setBounds(100, 60, 300, 20);
        JTextField textField1 = new JTextField(40);
        textField1.setOpaque(false);
        textField1.setBounds(130, 140, 200, 30);
        jFrame.setBounds(600, 200, 500, 400);
        jp1.add(jl1);
        jp1.add(jl2);
        jp1.add(jl3);
        jp1.add(jl4);
        jp1.add(textField1);
        jp1.add(jb4);
        if (user.getPayment() == 0) {
            textField1.setEnabled(false);
        }
        jp2.setLayout(new FlowLayout());
        jb1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Seat s1 = new Seat(user.getSeats());
                try {
                    jFrame.setVisible(false);
                    s1.InitSeat(users, user);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }

            }
        });
        jb2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    jFrame.setVisible(false);
                    new Meal(user, users);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });
        jb4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (textField1.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Please input your Card ID", "alert", JOptionPane.ERROR_MESSAGE);


                } else if (textField1.getText().length() != 8) {
                    JOptionPane.showMessageDialog(null, "Card ID should be 8 numbers!", "alert", JOptionPane.ERROR_MESSAGE);

                } else {
                    int cardID = Integer.parseInt(textField1.getText());
                    //System.out.println(cardID);
                    userAccount uA = new userAccount();
                    uA.readAccount(user, cardID);
                    System.out.println(uA.getSurname() + "-- from PayForOrder");
                    System.out.println(uA.getBalance() + "-- from PayForOrder");
                    if (uA.getSurname().equals("0") || uA.getCardID() == 0) {
                        JOptionPane.showMessageDialog(null, "Card ID not match!", "alert", JOptionPane.ERROR_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "Successful Payment", "alert", JOptionPane.INFORMATION_MESSAGE);
                        System.out.println(uA.getBalance() + "-- from PayForOrder");
//                      try {
//                          TicketPrint t = new TicketPrint(user);
//                          frame.setVisible(false);
//                      }
//                      catch (IOException e){
//                          e.printStackTrace();
//
//                      }

                    }
                }
            }
        });
        jp2.add(jb1);
        jp2.add(jb2);
        jp2.add(jb3);
        jb1.setEnabled((user.getSeats().equals("00")) ? true : false);
        jb2.setEnabled((user.getMeal().equals("null")) ? true : false);
        jFrame.getContentPane().add(jp1);
        jFrame.getContentPane().add(jp2, BorderLayout.SOUTH);
        jFrame.setVisible(true);
    }

    public static void main(String[] args) throws IOException {
        ArrayList<userInfo> users = userInfo.seatsInfo();
//        s1.InitSeat(users, userInfo.GetUserByID(12345, users));
        new SeatsAndMealMenu(userInfo.GetUserByID(12345, users), users);

    }

}
