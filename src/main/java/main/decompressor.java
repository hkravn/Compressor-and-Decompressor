package main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;

public class decompressor {
    static String fileDir;
    public decompressor() {}

    public static void decompressFile(File file) throws IOException {
        fileDir = file.getParent();

        FileInputStream fis = new FileInputStream(file);
        GZIPInputStream gis = new GZIPInputStream(fis);
        FileOutputStream fos = new FileOutputStream(fileDir + "/decompressed");

        byte[] buffer = new byte[1024];
        int len;

        while ((len=gis.read(buffer))!=-1) {
            fos.write(buffer,0,len);
        }

        gis.close();
        fos.close();
        fis.close();
    }
}
