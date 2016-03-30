package com.shangzhaohui.clipimage;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.widget.Toast;

/**
 * Created by shangzhaohui on 16/3/30.
 */
public class BitmapSaveTask extends AsyncTask<Object,Integer,Boolean> {
    private  Bitmap mBitmap;
    private  Context mContext;
    public BitmapSaveTask(Bitmap bitmap,Context context) {
        mBitmap = bitmap;
        mContext =context;
    }
    @Override
    protected Boolean doInBackground(Object[] params) {
       return  BitmapUtil.saveBitmap(mBitmap);
    }

    @Override
    protected void onPostExecute(Boolean result) {
        if (result == true) {
            Toast.makeText(mContext,R.string.save_success,Toast.LENGTH_LONG).show();
        }else {
            Toast.makeText(mContext,R.string.save_fail,Toast.LENGTH_LONG).show();
        }
    }
}
