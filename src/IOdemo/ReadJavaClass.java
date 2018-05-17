package IOdemo;

import java.io.*;

public class ReadJavaClass {
   static String dirName = "F:\\IDEA_PROJECT\\WebDemo";
//
   static String str = "";
    static int size = 0;
    static char a = '.';
    static char b = ';';
    static char c = '{';
    static char d = '}';
    public static void main(String[] args) {
          FileFilter fileFilter = new onlyExt("java");
           ReadJavaClass readJavaClass = new ReadJavaClass();
         if ( readJavaClass.isDir(dirName)){
             readJavaClass.enterDir(dirName);
         }



    }

    public boolean isDir(String dirName) {
        File jFile = new File(dirName);
        if (jFile.isDirectory()) {
            System.out.println(jFile.getName() + " 是目录");


            return true;
        }
        return false;

    }

    public void enterDir(String dirName) {

        File jFile = new File(dirName);
        String[] sFile = jFile.list();
        for (String fileName : sFile) {
            fileName = dirName+File.separator+fileName;
           if (isDir(fileName)){

               enterDir(fileName);
           }else {

               if (fileName.endsWith(".html")) {
 System.out.println(fileName + " 找到文件");
                   try (BufferedReader bf = new BufferedReader(new FileReader(fileName)) ){
//                       FileInputStream f = new FileInputStream(fileName)
//                       size =f.available();
//
//                       for (int i = 0; i < size; i++) {
//                           if ((char) f.read() != a ||
//                                   (char) f.read() != b ||
//                                   (char) f.read() != c ||
//                                   (char) f.read() != d) System.out.print((char) f.read());
//                           else System.out.println((char) f.read());
//
//                       }

                       while ((str = bf.readLine())!= null)

                           System.out.println(str);

                   } catch (FileNotFoundException e) {
                       e.printStackTrace();
                   } catch (IOException e) {
                       e.printStackTrace();
                   }
               }
           }


        }

    }
}
