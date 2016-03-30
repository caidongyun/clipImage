package com.shangzhaohui.clipimage;

import android.graphics.Bitmap;
import android.os.Environment;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by shangzhaohui on 16/3/30.
 */
public class BitmapUtil {

    public static final String SDCARD_DIR = Environment.getExternalStorageDirectory().getAbsolutePath();
    private  static final String FILE_DIR_NAME = "clipimage";
    public static boolean  saveBitmap(Bitmap bm) {
        if (bm == null) {
            return false;
        }
        File fileDir = new File(SDCARD_DIR +File.separator+ FILE_DIR_NAME) ;
        if (!fileDir.exists()) {
            fileDir.mkdirs();
        }
        File f = new File(fileDir.getAbsolutePath(), "result.png");
        if (f.exists()) {
            f.delete();
        }
        try {
            FileOutputStream out = new FileOutputStream(f);
            bm.compress(Bitmap.CompressFormat.PNG, 90, out);
            out.flush();
            out.close();
            return  true;
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return  false;
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return false;
        }
    }
}
