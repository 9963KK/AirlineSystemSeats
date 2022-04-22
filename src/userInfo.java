import javax.swing.filechooser.FileSystemView;
import java.io.*;
import java.util.ArrayList;

/**
 * userInfo(int BookingNum)用customer的BookingNum确定、实例化一个customer
 * userInfo(String Surname, int ID)用customer的Surname和BookingNum确定、实例化一个customer
 * this class contains others getter and setter methods
 */

public class userInfo {
    private String Surname;
    private int BookingNum;
    private int ID;
    private String Seats;
    private String From;
    private String To;
    private String Flight;
    private String Date;
    private String Gate;
    private String Time;
    private int TagNum;
    private String BaggageInfo;
    private String Meal;
    private String Status;
    private int payment;

    public int getPayment() {
        return payment;
    }

    public void setPayment(int payment) {
        this.payment = payment;
    }

    private String[] paths;
    private static String tableHead;
    private ArrayList<userInfo> userInfoArrayList = new ArrayList<userInfo>();
    ;

    public userInfo() {
    }


    public String getSurname() {
        return this.Surname;
    }

    public int getBookingNum() {
        return this.BookingNum;
    }

    public int getID() {
        return this.ID;
    }

    public String getSeats() {
        return this.Seats;
    }

    public String getFrom() {
        return this.From;
    }

    public String getTo() {
        return this.To;
    }

    public String getFlight() {
        return this.Flight;
    }

    public String getDate() {
        return this.Date;
    }

    public String getGate() {
        return this.Gate;
    }

    public String getTime() {
        return this.Time;
    }

    public int getTagNum() {
        return this.TagNum;
    }

    public String getBaggageInfo() {
        return this.BaggageInfo;
    }

    public String getMeal() {
        return this.Meal;
    }

    public String getStatus() {
        return this.Status;
    }

    public void setSurname(String surname) {
        this.Surname = surname;
    }

    public void setBookingNum(int bookingNum) {
        this.BookingNum = bookingNum;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setFrom(String from) {
        this.From = from;
    }

    public void setFlight(String flight) {
        this.Flight = flight;
    }

    public void setTime(String time) {
        this.Time = time;
    }

    public void setTo(String to) {
        this.To = to;
    }

    public void setTagNum(int tagNum) {
        this.TagNum = tagNum;
    }

    public void setGate(String gate) {
        this.Gate = gate;
    }

    public void setDate(String date) {
        this.Date = date;
    }

    public void setBaggageInfo(String baggageInfo) {
        this.BaggageInfo = baggageInfo;
    }

    public void setSeats(String seats) {
        this.Seats = seats;
    }

    public void setMeal(String meal) {
        this.Meal = meal;
    }

    public void setStatus(String status) {
        this.Status = status;
    }
    public void readInfo(int BookingNum) {
        ReadAndWrite readAndWrite = new ReadAndWrite();
        this.paths = readAndWrite.createDataBase();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(this.paths[0]));
            reader.readLine();
            String line;
            while ((line = reader.readLine()) != null) {
                String[] item = line.split(",");

                if (!item[0].equals("")) {
                    this.BookingNum = Integer.parseInt(item[0]);
                    if (!item[1].equals("")) {
                        this.Surname = item[1];
                        if (!item[2].equals("")) {
                            this.ID = Integer.parseInt(item[2]);
                            if (!item[3].equals("")) {
                                this.Seats = item[3];
                                if (!item[4].equals("")) {
                                    this.From = item[4];
                                    if (!item[5].equals("")) {
                                        this.To = item[5];
                                        if (!item[6].equals("")) {
                                            this.Flight = item[6];
                                            if (!item[7].equals("")) {
                                                this.Date = item[7];
                                                if (!item[8].equals("")) {
                                                    this.Gate = item[8];
                                                    if (!item[9].equals("")) {
                                                        this.Time = item[9];
                                                        if (!item[10].equals("")) {
                                                            this.TagNum = Integer.parseInt(item[10]);
                                                            if (!item[11].equals("")) {
                                                                this.BaggageInfo = item[11];
                                                                if (!item[12].equals("")) {
                                                                    this.Meal = item[12];
                                                                    if (!item[13].equals("")) {
                                                                        this.Status = item[13];
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                if (BookingNum == this.BookingNum) {
                    break;
                }

            }
            //System.out.println(this.BookingNum+" "+this.Surname);
            reader.close();
            System.out.println("InputStream closed");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readInfo(String Surname, int ID) {
        ReadAndWrite readAndWrite = new ReadAndWrite();
        this.paths = readAndWrite.createDataBase();
        try {
            FileReader fileReader = new FileReader(this.paths[0]);
            BufferedReader reader = new BufferedReader(fileReader);
            reader.readLine();
            String line;
            while ((line = reader.readLine()) != null) {
                String[] item = line.split(",");

                if (!item[0].equals("")) {
                    this.BookingNum = Integer.parseInt(item[0]);
                    if (!item[1].equals("")) {
                        this.Surname = item[1];
                        if (!item[2].equals("")) {
                            this.ID = Integer.parseInt(item[2]);
                            if (!item[3].equals("")) {
                                this.Seats = item[3];
                                if (!item[4].equals("")) {
                                    this.From = item[4];
                                    if (!item[5].equals("")) {
                                        this.To = item[5];
                                        if (!item[6].equals("")) {
                                            this.Flight = item[6];
                                            if (!item[7].equals("")) {
                                                this.Date = item[7];
                                                if (!item[8].equals("")) {
                                                    this.Gate = item[8];
                                                    if (!item[9].equals("")) {
                                                        this.Time = item[9];
                                                        if (!item[10].equals("")) {
                                                            this.TagNum = Integer.parseInt(item[10]);
                                                            if (!item[11].equals("")) {
                                                                this.BaggageInfo = item[11];
                                                                if (!item[12].equals("")) {
                                                                    this.Meal = item[12];
                                                                    if (!item[13].equals("")) {
                                                                        this.Status = item[13];
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                if (this.Surname.equals(Surname) && this.ID == ID) {
                    break;
                }

            }
            //System.out.println(this.BookingNum+" "+this.Surname);
            reader.close();
            System.out.println("InputStream closed");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int getCustomerNum() {
        int lines = 0;
        ReadAndWrite readAndWrite = new ReadAndWrite();
        String[] paths = readAndWrite.createDataBase();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(paths[0]));
            tableHead = reader.readLine();
            //System.out.println(tableHead);
            String line;

            while ((line = reader.readLine()) != null) {
                lines++;
            }
            //reader.close();
            //System.out.println("InputStream closed");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

    public void changeInfo(int BookingNum, userInfo userInfo) {
        userInfo[] userInfos = new userInfo[getCustomerNum()];
        ReadAndWrite readAndWrite = new ReadAndWrite();
        String[] paths = readAndWrite.createDataBase();
        try {
            int i = 0;
            BufferedReader reader = new BufferedReader(new FileReader(paths[0]));
            reader.readLine();
            String line;
            while ((line = reader.readLine()) != null) {
                String[] item = line.split(",");
                userInfo u = new userInfo();
                if (!item[0].equals("")) {
                    u.setBookingNum(Integer.parseInt(item[0]));
                    if (!item[1].equals("")) {
                        u.setSurname(item[1]);
                        if (!item[2].equals("")) {
                            u.setID(Integer.parseInt(item[2]));
                            if (!item[3].equals("")) {
                                u.setSeats(item[3]);
                                if (!item[4].equals("")) {
                                    u.setFrom(item[4]);
                                    if (!item[5].equals("")) {
                                        u.setTo(item[5]);
                                        if (!item[6].equals("")) {
                                            u.setFlight(item[6]);
                                            if (!item[7].equals("")) {
                                                u.setDate(item[7]);
                                                if (!item[8].equals("")) {
                                                    u.setGate(item[8]);
                                                    if (!item[9].equals("")) {
                                                        u.setTime(item[9]);
                                                        if (!item[10].equals("")) {
                                                            u.setTagNum(Integer.parseInt(item[10]));
                                                            if (!item[11].equals("")) {
                                                                u.setBaggageInfo(item[11]);
                                                                if (!item[12].equals("")) {
                                                                    u.setMeal(item[12]);
                                                                    if (!item[13].equals("")) {
                                                                        u.setStatus(item[13]);
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                userInfos[i] = u;
                userInfoArrayList.add(userInfos[i]);
            }
            //reader.close();
            //System.out.println("InputStream closed");

            //System.out.println(userInfos.length);
            //System.out.println(userInfoArrayList.get(0).getBookingNum());
            for (int j = 0; j < userInfoArrayList.size(); j++) {
                if (userInfoArrayList.get(j).getBookingNum() == BookingNum) {
                    userInfoArrayList.set(j, userInfo);
                    System.out.println(userInfo.getStatus());
                    break;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeInfo() {
        ReadAndWrite readAndWrite = new ReadAndWrite();
        String[] paths = readAndWrite.createDataBase();
        try {
            File csv = new File(paths[0]);
            BufferedWriter bw = new BufferedWriter(new FileWriter(csv));
            bw.write(tableHead);
            for (int i = 0; i < this.userInfoArrayList.size(); i++) {
                bw.newLine();
                bw.write(userInfoArrayList.get(i).getBookingNum() + "," + userInfoArrayList.get(i).getSurname() + "," + userInfoArrayList.get(i).getID() + "," + userInfoArrayList.get(i).getSeats() + "," + userInfoArrayList.get(i).getFrom() + "," + userInfoArrayList.get(i).getTo() + "," + userInfoArrayList.get(i).getFlight()
                        + "," + userInfoArrayList.get(i).getDate() + "," + userInfoArrayList.get(i).getGate() + "," + userInfoArrayList.get(i).getTime()
                        + "," + userInfoArrayList.get(i).getTagNum() + "," + userInfoArrayList.get(i).getBaggageInfo() + "," + userInfoArrayList.get(i).getMeal() + "," + userInfoArrayList.get(i).getStatus());
            }
            bw.close();

        } catch (FileNotFoundException e) {
            // File对象的创建过程中的异常捕获
            e.printStackTrace();
        }// BufferedWriter在关闭对象捕捉异常
        catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    // Special for Seats Module
    public static ArrayList<userInfo> seatsInfo() {
        ArrayList<userInfo> myUserInfoArrayList = new ArrayList<userInfo>();
        userInfo[] userInfos = new userInfo[getCustomerNum()];
        System.out.println(userInfos.length);
        ReadAndWrite readAndWrite = new ReadAndWrite();
        String[] paths = readAndWrite.createDataBase();
        try {
            int i = 0;
            BufferedReader reader = new BufferedReader(new FileReader(paths[0]));
            reader.readLine();
            String line;
            while ((line = reader.readLine()) != null) {
                String[] item = line.split(",");
                userInfo u = new userInfo();
                if (!item[0].equals("")) {
                    u.setBookingNum(Integer.parseInt(item[0]));
                    if (!item[1].equals("")) {
                        u.setSurname(item[1]);
                        if (!item[2].equals("")) {
                            u.setID(Integer.parseInt(item[2]));
                            if (!item[3].equals("")) {
                                u.setSeats(item[3]);
                                if (!item[4].equals("")) {
                                    u.setFrom(item[4]);
                                    if (!item[5].equals("")) {
                                        u.setTo(item[5]);
                                        if (!item[6].equals("")) {
                                            u.setFlight(item[6]);
                                            if (!item[7].equals("")) {
                                                u.setDate(item[7]);
                                                if (!item[8].equals("")) {
                                                    u.setGate(item[8]);
                                                    if (!item[9].equals("")) {
                                                        u.setTime(item[9]);
                                                        if (!item[10].equals("")) {
                                                            u.setTagNum(Integer.parseInt(item[10]));
                                                            if (!item[11].equals("")) {
                                                                u.setBaggageInfo(item[11]);
                                                                if (!item[12].equals("")) {
                                                                    u.setMeal(item[12]);
                                                                    if (!item[13].equals("")) {
                                                                        u.setStatus(item[13]);
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                userInfos[i] = u;
                myUserInfoArrayList.add(userInfos[i]);
            }
        } catch (IOException e11) {
            e11.printStackTrace();
        }
        System.out.println(myUserInfoArrayList.size());
        return myUserInfoArrayList;
    }

    //    public String[] seatsInfoToString(){
//        ArrayList<userInfo> MyUserInfoArrayList = seatsInfo();
//        String[] seatsInfo = new String[MyUserInfoArrayList.size()];
//        for (int i =0; i<MyUserInfoArrayList.size();i++){
//            seatsInfo[i] = MyUserInfoArrayList.get(i).getSeats();
//        }
//        return seatsInfo;
//    }
    public static userInfo GetUserByID(int id, ArrayList<userInfo> users) {
        for (userInfo u : users) {
            if (u.getID() == id) {
                return u;
            }
        }
        return null;
    }

    public void EditSeatsAndMeal(ArrayList<userInfo> users) {
        for (userInfo u : users) {
            if (this.getID() == u.getID()) {
                u.setSeats(this.getSeats());
                u.setMeal(this.getMeal());
            }
        }
    }

//    public static void main(String[] args) {
        /*userInfo u = new userInfo();
        u.readInfo(152220);
        u.setStatus("Check");
        u.setMeal("Bread");

        u.changeInfo(152220,u);//changeInfo用于替换arrayList中的userInfo对象
        //System.out.println(u.getID()+" "+u.getFlight()+" "+u.getBaggageInfo()+" "+u.getStatus());
        u.writeInfo();//将更改后的arrayList写入.csv文件*/
//        userInfo u = new userInfo();
//        ArrayList<userInfo> users = u.seatsInfo();
//        System.out.println(users.get(0).getSeats());
//        String[] info = u.seatsInfoToString();
//        System.out.println("=====");
//        for (int i =0;i<info.length;i++){
//            System.out.println(info[i]);
//        }
//        //System.out.println(u.getCustomerNum());
//    }
}
