package IOdemo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class NIOcopy {
    public static void main(String[] args) {
        try {
            Path p1 = Paths.get("G:\\Demo\\WEB-INF/web.txt");
            Path p2 = Paths.get("G:\\Demo\\WEB-INF/web1.txt");

            Files.copy(p1,p2, StandardCopyOption.REPLACE_EXISTING);
        }catch (IOException e){
            e.printStackTrace();
        }




    }
}
