package main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;

public class compressor {
    static String fileDir;

    public compressor() {}

    public static void compressFile(File file) throws IOException {
        fileDir = file.getParent();

        FileInputStream fis = new FileInputStream(file);
        FileOutputStream fos = new FileOutputStream(fileDir+"/compressed.gz");
        GZIPOutputStream gos = new GZIPOutputStream(fos);

        byte[] buffer = new byte[1024];
        int len;

        while ((len=fis.read(buffer))!=-1) {
            gos.write(buffer,0,len);
        }

        gos.close();
        fos.close();
        fis.close();
    }
}
