package IOdemo;

import java.io.File;
import java.io.FileFilter;

public class onlyExt implements FileFilter {
               String ext ;
    public onlyExt(String ext) {
        this.ext = "."+ext;
    }

    @Override
    public boolean accept(File pathname) {

        return pathname.getName().endsWith(ext);
    }
}
