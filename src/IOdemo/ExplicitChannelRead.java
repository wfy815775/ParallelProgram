package IOdemo;

import java.io.FileReader;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ExplicitChannelRead {
    public static void main(String[] args) {
        int count;
        Path filePath = null;

        try {
            filePath = Paths.get("G:\\Demo\\WEB-INF/web.txt");
        } catch (InvalidPathException e) {
            e.printStackTrace();
            return;
        }

        try ( SeekableByteChannel fChan = Files.newByteChannel(filePath)){

            ByteBuffer bf = ByteBuffer.allocate(128);

            do {
                count = fChan.read(bf);

                if (count != -1){

                    bf.rewind();

                    for (int i = 0; i < count; i++) {
                        System.out.print((char) bf.get());


                    }
                }
            }while (count != -1);

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
