import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Seat extends JFrame {
    String seatsdata;

    public void setSeats(String seatsdata) {
        this.seatsdata = seatsdata;
    }

    public String getSeats() {
        return this.seatsdata;
    }

    public void SelectedSeats(ArrayList<userInfo> users, userInfo user, int x, int y, MyRadioButton jrb) {
        Coords userC = new Coords(user);
        for (userInfo u : users) {
            Coords temp = new Coords(u);
            if (x == userC.getRow() && y == userC.getColm()) {
                jrb.setSelected(true);
                break;
            }
            if (x == temp.getRow() && y == temp.getColm()) {
                jrb.setEnabled(false);
                break;
            }
        }
    }

    public int VIPOrNot(Seat seat) {
        Coords temp = new Coords(seat);
        int result;
        if (temp.VIP()) {
            result = JOptionPane.showConfirmDialog(null, "You should pay $1000.", "Notice", JOptionPane.OK_OPTION, JOptionPane.NO_OPTION);
        } else {
            result = JOptionPane.showConfirmDialog(null, "You should pay $500.", "Notice", JOptionPane.OK_OPTION, JOptionPane.NO_OPTION);
        }

        return result;
    }

    public static String switchSeat(int a) {
        switch (a) {
            case 0:
                return "A";
            case 1:
                return "B";
            case 2:
                return "C";
            case 3:
                return "D";
            case 4:
                return "E";
            case 5:
                return "F";
            case 6:
                return "G";
            case 7:
                return "H";
            case 8:
                return "I";
            default:
                return null;
        }
    }

    public static ArrayList<MyRadioButton> createJRB(int a) throws IOException {
        ArrayList<MyRadioButton> JRBList = new ArrayList<>();
        for (int i = 0; i < a; i++) {
            MyRadioButton njrb = new MyRadioButton();
            JRBList.add(njrb);

        }
        return JRBList;
    }

    public static void setVIPClass(ArrayList<JPanel> jPanels, int rows) {
        for (int i = 0; i < rows; i++) {
            jPanels.get(i).setBorder(BorderFactory.createTitledBorder("VIP"));
        }

    }

    public static ArrayList<ArrayList<MyRadioButton>> createJRBL(int x, int y) throws IOException {
        ArrayList<ArrayList<MyRadioButton>> JRBLL = new ArrayList<>();
        for (int i = 0; i < x; i++) {
            JRBLL.add(createJRB(y));
        }
        return JRBLL;
    }

    public void InitSeat(ArrayList<userInfo> users, userInfo user) throws IOException {
        Seat s1 = this;
        JFrame frame = new JFrame();
        frame.setTitle("Seats");
        JPanel j1 = new JPanel();
        JPanel j2 = new JPanel();
        JPanel j3 = new JPanel();
        JPanel j4 = new JPanel();
        MyJButton b1 = new MyJButton("Done", 1);
        MyJButton b3 = new MyJButton("Print Straightly", 1);
        MyJButton b2 = new MyJButton("Choose some food & drink", 1);
        JLabel[] jlarray = new JLabel[9];
        JLabel jl1 = new JLabel("A");
        JLabel jl2 = new JLabel("B");
        JLabel jl3 = new JLabel("C");
        JLabel jl4 = new JLabel("D");
        JLabel jl5 = new JLabel("E");
        JLabel jl6 = new JLabel("F");
        JLabel jl7 = new JLabel("G");
        JLabel jl8 = new JLabel("H");
        JLabel jl9 = new JLabel("I");

        ButtonGroup bg = new ButtonGroup();
        ButtonGroup bg2 = new ButtonGroup();
        MyRadioButton mrb1 = new MyRadioButton();
        MyRadioButton mrb2 = new MyRadioButton();
        MyRadioButton mrb3 = new MyRadioButton();
        bg2.add(mrb2);
        bg2.add(mrb3);
        mrb1.setEnabled(false);
        mrb1.setText("Been Selected");
        mrb2.setSelected(true);
        mrb2.setText("Chosen");
        mrb3.setSelected(false);
        mrb3.setText("Available");
        ArrayList<ArrayList<MyRadioButton>> jrbll = createJRBL(10, 9);
        ArrayList<JPanel> jPanels = new ArrayList<>();
        jlarray[0] = jl1;
        jlarray[1] = jl2;
        jlarray[2] = jl3;
        jlarray[3] = jl4;
        jlarray[4] = jl5;
        jlarray[5] = jl6;
        jlarray[6] = jl7;
        jlarray[7] = jl8;
        jlarray[8] = jl9;
        j4.setLayout(new GridLayout(1, 0));
        for (int i = 0; i < jlarray.length; i++) {
            j4.add(jlarray[i]);
        }
        j2.add(j4);//修改框架
        for (ArrayList<MyRadioButton> jrbl : jrbll) {
            for (MyRadioButton jrb : jrbl) {
                jrb.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String seats = switchSeat(jrbl.indexOf(jrb)) + jrbll.indexOf(jrbl);
                        s1.setSeats(seats);
                    }
                });
                bg.add(jrb);
            }
        }
        for (ArrayList<MyRadioButton> jrbl : jrbll) {
            int rows = jrbll.indexOf(jrbl);
            JPanel njpanel = new JPanel();
            njpanel.setLayout(new GridLayout(1, 0));
            njpanel.setVisible(true);
            for (MyRadioButton jrb :
                    jrbl) {
                njpanel.add(jrb);
                int colms = jrbl.indexOf(jrb);
                s1.SelectedSeats(users, user, rows, colms, jrb);
            }
            jPanels.add(njpanel);
        }
        setVIPClass(jPanels, 3);
        for (JPanel j : jPanels) {
            j2.add(j);
        }

        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(userInfo.GetUserByID(user.getID(), users).getSeats());//获得当前用户的座位信息
                if (VIPOrNot(s1) == 0) {
                    user.setSeats(s1.getSeats());
                    user.EditSeats(users);
                    System.out.println(userInfo.GetUserByID(user.getID(), users).getSeats());//修改后的信息
                }
            }
        });// Button Done action
        frame.setSize(400, 600);
        frame.setLocation(600, 200);
        j2.setLayout(new GridLayout(0, 1));
        j3.setLayout((new GridLayout(0, 3)));
        b1.setSize(30, 20);
        j1.add(b1);
        j1.add(b2);
        j1.add(b3);
        j3.add(mrb1);
        j3.add(mrb2);
        j3.add(mrb3);
        j3.setEnabled(false);
        frame.getContentPane().add(j1, BorderLayout.SOUTH);
        frame.getContentPane().add(j2, BorderLayout.CENTER);
        frame.getContentPane().add(j3, BorderLayout.NORTH);
        frame.setVisible(true);
    }

    public static void main(String[] args) throws IOException {
        Seat s1 = new Seat();
        ArrayList<userInfo> users = userInfo.seatsInfo();
        s1.InitSeat(users, userInfo.GetUserByID(12345, users));
    }

}