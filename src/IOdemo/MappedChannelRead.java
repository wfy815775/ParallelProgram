package IOdemo;

import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Paths;

public class MappedChannelRead {
    public static void main(String[] args) {
        try (FileChannel fileChannel = (FileChannel) Files.newByteChannel(Paths.get("G:/Demo/WEB-INF/web.txt"))){

            long fsize = fileChannel.size();

            MappedByteBuffer mappedByteBuffer = fileChannel.map(FileChannel.MapMode.READ_ONLY,0,fsize);

            for (int i = 0; i < fsize; i++) {
                System.out.print((char) mappedByteBuffer.get(i));
            }


        }catch (IOException e){
            e.printStackTrace();
        }

    }
}
