import java.io.*;
import java.nio.Buffer;
import java.util.ArrayList;

public class FileEdit {
    public static String regex1 = "[a-zA-Z]";
    public static String regex2 = "\\d";
    public static String filepath = "C:\\JetBrains\\ideafolder\\test\\src\\customerInfo.csv";


    public static int TransferAlpa(String str) {
        int result = -1;
        if (str.equals("A")) {
            result = 0;
        } else if (str.equals("B")) {
            result = 1;
        } else if (str.equals("C")) {
            result = 2;
        } else if (str.equals("D")) {
            result = 3;
        } else if (str.equals("E")) {
            result = 4;
        } else if (str.equals("F")) {
            result = 5;
        } else if (str.equals("G")) {
            result = 6;
        } else if (str.equals("H")) {
            result = 7;
        } else if (str.equals("I")) {
            result = 8;
        }
        return result;
    }
}
//    public static ArrayList<userInfo> getUserList(String filepath) {
//        ArrayList<userInfo> users = new ArrayList<>();
//
//        try {
//            ReadAndWrite readAndWrite=new ReadAndWrite();
//            int i = 0;
//            BufferedReader reader = new BufferedReader(new FileReader(filepath));
//            reader.readLine();
//            String line;
//            while ((line = reader.readLine()) != null) {
//                String[] item = line.split(",");
//                userInfo u = new userInfo();
//                if (!item[0].equals("")) {
//                    u.setBookingNum(Integer.parseInt(item[0]));
//                    if (!item[1].equals("")) {
//                        u.setSurname(item[1]);
//                        if (!item[2].equals("")) {
//                            u.setID(Integer.parseInt(item[2]));
//                            if (!item[3].equals("")) {
//                                u.setSeats(item[3]);
//                                if (!item[4].equals("")) {
//                                    u.setFrom(item[4]);
//                                    if (!item[5].equals("")) {
//                                        u.setTo(item[5]);
//                                        if (!item[6].equals("")) {
//                                            u.setFlight(item[6]);
//                                            if (!item[7].equals("")) {
//                                                u.setDate(item[7]);
//                                                if (!item[8].equals("")) {
//                                                    u.setGate(item[8]);
//                                                    if (!item[9].equals("")) {
//                                                        u.setTime(item[9]);
//                                                        if (!item[10].equals("")) {
//                                                            u.setTagNum(Integer.parseInt(item[10]));
//                                                            if (!item[11].equals("")) {
//                                                                u.setBaggageInfo(item[11]);
//                                                                if (!item[12].equals("")) {
//                                                                    u.setMeal(item[12]);
//                                                                    if (!item[13].equals("")) {
//                                                                        u.setStatus(item[13]);
//                                                                    }
//                                                                }
//                                                            }
//                                                        }
//                                                    }
//                                                }
//                                            }
//                                        }
//                                    }
//                                }
//                            }
//                        }
//                    }
//                }
//                users.add(u);
//            }
//
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return users;
//    }
//    public static ArrayList<String> getKonwnSeats(ArrayList<User> users) {
////       try {
////           BufferedReader br = new BufferedReader(new FileReader(filename));
////           String line = br.readLine();
////
////           while ((line = br.readLine()) != null) {
////               String[] tem = line.split(",");
////               position.add(tem[1]);
////           }
////           return position;
////
////       } catch (Exception e) {
////           e.printStackTrace();
////       }
////       return null;
//       ArrayList<String> position = new ArrayList<>();
//       for (User user:users){
//           if (user.getSeats().equals("00")) {
//               continue;
//           }
//           position.add(user.getSeats());
//       }
//       return  position;
//   }
//    public static void writeUserList(ArrayList<userInfo> users){
//            try {
//                File csv = new File(filepath);
//                BufferedWriter bw = new BufferedWriter(new FileWriter(csv));
//                bw.write(tableHead);
//                for (userInfo u:users) {
//                    bw.newLine();
//                    bw.write(u.getBookingNum()+","+u.getSurname()+","+u.getID()+","+u.getSeats()+","+u.getFrom()+","+u.getTo()+","+u.getFlight()
//                            +","+u.getDate()+","+u.getGate()+","+u.getTime()
//                            +","+u.getTagNum()+","+u.getBaggageInfo()+","+u.getMeal()+","+u.getStatus());
//                }
//                bw.close();
//
//            } catch (FileNotFoundException e) {
//                // File对象的创建过程中的异常捕获
//                e.printStackTrace();
//            }// BufferedWriter在关闭对象捕捉异常
//            catch (IOException e1) {
//                e1.printStackTrace();
//            }
//        }
//    }
//    public static void main(String[] args) {
//        ArrayList<String> stringArrayList=FileEdit.getKonwnSeats("C:\\JetBrains\\ideafolder\\test\\src\\test.csv");
//        for (String a:stringArrayList){
//           int num=Integer.parseInt(a.replaceAll(FileEdit.regex1,""));
//           String alpa=a.replaceAll(FileEdit.regex2,"");
//           System.out.println(num+" "+alpa);
//        }
//  }


