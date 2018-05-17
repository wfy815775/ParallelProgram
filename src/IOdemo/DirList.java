package IOdemo;

import java.io.File;
import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class DirList {


    public static void main(String[] args) {
        String dirName = "F:\\IDEA_PROJECT\\WebDemo";

        DirList dirList = new DirList();
        dirList.readDir(dirName);
    }


    public void readDir(String dirName) {
        try (DirectoryStream<Path> dirStream = Files.newDirectoryStream(Paths.get(dirName))) {

            for (Path entry : dirStream) {
                BasicFileAttributes attributes = Files.readAttributes(entry, BasicFileAttributes.class);
                if (attributes.isDirectory()) {

                    System.out.println(entry.getName(entry.getNameCount() - 1) + " 是目录");
                   String dir;
                    dir = dirName + File.separator + entry.getName(entry.getNameCount() - 1);

                    readDir(dir);

                } else if (attributes.isRegularFile()) {

                    System.out.println(entry.getName(entry.getNameCount() - 1) + " 是文件");
                    readFile(entry);
                }

            }
        } catch (IOException e) {

        }


    }

    public void readFile(Path entry) {


        if (entry.toString().endsWith(".xml")) {

            try (FileChannel fileChannel = (FileChannel) Files.newByteChannel(entry)) {

                long size = fileChannel.size();
                MappedByteBuffer mb = fileChannel.map(FileChannel.MapMode.READ_ONLY, 0, size);

                for (int i = 0; i < size; i++) {
                    System.out.print((char) mb.get(i));

                }

            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }


}
