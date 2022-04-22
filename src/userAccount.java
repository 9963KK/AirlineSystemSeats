import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

public class userAccount {
    private String Surname;
    private int CardID;
    private int Balance;

    private String[] paths;
    private String tableHead;
    private ArrayList<userAccount> userAccountArrayList = new ArrayList<>();

    public void setSurname(String surname) {
        this.Surname = surname;
    }

    public void setCardID(int cardID) {
        this.CardID = cardID;
    }

    public void setBalance(int balance) {
        this.Balance = balance;
    }

    public String getSurname() {
        return this.Surname;
    }

    public int getCardID() {
        return this.CardID;
    }

    public int getBalance() {
        return this.Balance;
    }

    public int getCustomerNum() {
        int lines = 0;
        ReadAndWrite readAndWrite = new ReadAndWrite();
        String[] paths = readAndWrite.createDataBase();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(paths[1]));
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

    public void readAccount(userInfo u, int cardID) {
        ReadAndWrite readAndWrite = new ReadAndWrite();
        this.paths = readAndWrite.createDataBase();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(this.paths[1]));
            reader.readLine();
            String line;
            while ((line = reader.readLine()) != null) {
                String[] item = line.split(",");
                if (!item[0].equals("")) {
                    this.Surname = item[0];
                    if (!item[1].equals("")) {
                        this.CardID = Integer.parseInt(item[1]);
                        if (!item[2].equals("")) {
                            this.Balance = Integer.parseInt(item[2]);
                        }
                    }
                }
                if (u.getSurname().equals(this.Surname) && cardID == this.CardID) {
                    break;
                }

            }
            //this.Surname = "0";
            //this.CardID = 0;
            //this.Balance = 0;
            //System.out.println(this.BookingNum+" "+this.Surname);
            reader.close();
            //System.out.println("InputStream closed");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean isDeal(int payment) {
        int originalBalance = getBalance();
        int updateBalance;
        if (originalBalance >= payment) {
            updateBalance = originalBalance - payment;
            setBalance(updateBalance);
            return true;
        } else {
            return false;
        }
    }

    public void changeAccount(int cardID, userAccount userAccount) {
        userAccount[] userAccounts = new userAccount[getCustomerNum()];
        ReadAndWrite readAndWrite = new ReadAndWrite();
        String[] paths = readAndWrite.createDataBase();
        try {
            int i = 0;
            BufferedReader reader = new BufferedReader(new FileReader(paths[1]));
            reader.readLine();
            String line;
            while ((line = reader.readLine()) != null) {
                String[] item = line.split(",");
                userAccount u = new userAccount();
                if (!item[0].equals("")) {
                    u.setSurname(item[0]);
                    if (!item[1].equals(""))
                        u.setCardID(Integer.parseInt(item[1]));
                    if (!item[2].equals("")) {
                        u.setBalance(Integer.parseInt(item[2]));
                    }
                }
                userAccounts[i] = u;
                userAccountArrayList.add(userAccounts[i]);
            }
            //reader.close();
            //System.out.println("InputStream closed");

            //System.out.println(userInfos.length);
            //System.out.println(userInfoArrayList.get(0).getBookingNum());
            for (int j = 0; j < userAccountArrayList.size(); j++) {
                if (userAccountArrayList.get(j).getCardID() == cardID) {
                    userAccountArrayList.set(j, userAccount);
                    break;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void writeAccount(int cardID) {
        ReadAndWrite readAndWrite = new ReadAndWrite();
        String[] paths = readAndWrite.createDataBase();
        try {
            File csv = new File(paths[1]);
            BufferedWriter bw = new BufferedWriter(new FileWriter(csv));
            bw.write(this.tableHead);
            for (int i = 0; i < this.userAccountArrayList.size(); i++) {
                bw.newLine();
                bw.write(userAccountArrayList.get(i).getSurname() + "," + userAccountArrayList.get(i).getCardID() + "," + userAccountArrayList.get(i).getBalance());
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


//    public static void main(String[] args) {
//        userInfo userInfo = new userInfo();
//        userInfo.readInfo(152220);
//        userAccount u = new userAccount();
//        u.readAccount(userInfo,12581996);
//        System.out.println(u.getBalance());
//        //u.setBalance(56);
//
//        //u.changeAccount(12581996,u);
//        //u.writeAccount(12581996);
//        System.out.println(u.isDeal(80));
//        System.out.println(u.isDeal(50));
//        System.out.println(u.getBalance());
//    }

}
