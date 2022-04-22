import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TimePanel extends JPanel {
    private JPanel timePanel;
    private JLabel timeLabel;
    private JLabel displayArea;
    private String TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    private String time;
    private int ONE_SECOND = 1000;

    public TimePanel() {
        //this.setLayout(null);
        timePanel = new JPanel();
        timeLabel = new JLabel("CurrentTime: ");
        displayArea = new JLabel();
        timePanel.setOpaque(false);


        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new JLabelTimerTask(), new Date(), ONE_SECOND);

        this.add(timeLabel);
        this.add(displayArea);

    }

    protected class JLabelTimerTask extends TimerTask {
        SimpleDateFormat dateFormatter = new SimpleDateFormat(TIME_FORMAT);

        @Override
        public void run() {
            time = dateFormatter.format(Calendar.getInstance().getTime());
            displayArea.setText(time);
        }
    }

//    public static void main(String[] args) {
//        JFrame frame = new JFrame("Show time");
//        TimePanel timePanel = new TimePanel();
//        frame.getContentPane().add(timePanel);
//        frame.setVisible(true);
//        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        frame.setLocationRelativeTo(null);
//        frame.setSize(400,200);
//
//        //在其他地方调用时 添加 ——> timePanel.setOpaque(false);
//    }
}
