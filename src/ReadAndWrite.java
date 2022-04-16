import javax.swing.filechooser.FileSystemView;
import java.io.*;

/**
 * 1. 源代码和作为数据库的文件需要被一起封装在jar包内，因此所有作为数据库的文件需要被放置在IDEA Project ->out -> 与project同名目录下（和.class文件处于同一文件夹）
 * 2. 由于jar包资源文件的性质，只能通过输入流读取，不能通过输出流或File类进行写入，因此使用 createFile() 和 createDataBase() 创建新的文件进行写入
 **/

public class ReadAndWrite {

    private String[] fileNames = {"customerInfo.csv", "customerAccount.csv"};//用来储存作为数据库的文件
    private String[] OrderNames = {"DrinkDishes.txt", "Drinkstore.txt", "FarewellMessages.txt", "FishDishes.txt", "Fishstore.txt", "MeatDishes.txt", "Meatstore.txt", "NoodleDishes.txt", "Noodlestore.txt", "RiceDishes.txt", "Ricestore.txt", "Rsuccess.txt", "spendmoney.csv"};
    private String[] syspath = {"C:\\JetBrains\\ideafolder\\test\\src\\", "C:\\JetBrains\\ideafolder\\test\\src\\backend"};

    public String myRead(String filename) throws IOException {

        InputStream in = this.getClass().getResourceAsStream(filename);
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        String s;
        while ((s = br.readLine()) != null) {
            System.out.println(s);
        }
        return s;
    }//读取jar包内容并返回字符串

    public byte[] readImage(String filename) throws IOException {
        InputStream in = this.getClass().getResourceAsStream(filename);
        ByteArrayOutputStream byteStream = new ByteArrayOutputStream();

        byte[] buffer = new byte[1024];
        int ch;
        while ((ch = in.read(buffer)) != -1) {
            byteStream.write(buffer, 0, ch);

        }
        byte[] data = byteStream.toByteArray();
        return data;
    }

    public void createFile(String srcName, String destName) {
        InputStream inputStream = this.getClass().getResourceAsStream(srcName);

        try {
            File file = new File(destName);
            if (!file.exists()) {
                FileOutputStream outputStream = new FileOutputStream(file);
                int c;
                byte[] buffer = new byte[1024];
                while ((c = inputStream.read(buffer)) != -1) {
                    for (int i = 0; i < c; i++) {
                        outputStream.write(buffer[i]);
                        outputStream.close();
                    }
                }
                inputStream.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }//将jar包内目标文件读取出来并在指定路径创建相同可读写文件

    public String[] createDataBase() {
        String[] paths = new String[2];
        FileSystemView fsv = FileSystemView.getFileSystemView();
        File com = fsv.getHomeDirectory();
        //System.out.println(com.getPath());
        for (int i = 0; i < this.fileNames.length; i++) {
            //File file = new File(("C:\\Users\\BUPT-192\\Desktop\\"+ this.fileNames[i]));
            //if(!file.exists()){
            this.createFile(this.fileNames[i], (syspath[0] + this.fileNames[i]));
            paths[i] = (syspath[0] + this.fileNames[i]);
            //System.out.println("Create "+this.fileNames[i]+" Successfully");
            //}
            /*else {
                System.out.println(this.fileNames[i]+" has existed!");
                paths[i]=("C:\\Users\\BUPT-192\\Desktop"+ this.fileNames[i]);
            }*/

        }
        return paths;
    }//将jar包内所有文件读取出来并在指定路径创建相同可读写文件

    public String[] createOrderBase() {
        String[] paths = new String[13];
        for (int i = 0; i < this.OrderNames.length; i++) {
            this.createFile(this.OrderNames[i], (syspath[1] + this.OrderNames[i]));
            paths[i] = (syspath[1] + this.OrderNames[i]);
            //System.out.println("Create "+this.fileNames[i]+" Successfully");
        }
        return paths;
    }


//    public static void main(String[] args) {
//        ReadAndWrite r = new ReadAndWrite();
//        String[] myPath = r.createDataBase();
//        System.out.println(myPath[0]);
    //r.createFile("DrinkDishes.txt","C:\\Users\\BUPT-192\\Desktop\\DrinkDishes.txt");
       /*try {
           r.myRead("customerInfo.csv");
       }catch (IOException e){
           e.printStackTrace();
       }*/
    //r.createFile("customerInfo.csv","D:\\customerInfo.csv");
        /*for (int i = 0; i < myPath.length; i++) {
            System.out.println(myPath[i]);
        }*/

    //}

}

