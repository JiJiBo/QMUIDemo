package com.rulerbug.mycode.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileUtils {
    private static String storePath = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "aaa";

    //保存图片到本地
    public static String saveBitmap(Bitmap bmp, Context context, Activity ma, String filePath) {  // 首先保存图片的路径

        File appDir = new File(filePath);
        if (!appDir.exists()) {
            appDir.mkdir();
        }
        String fileName = System.currentTimeMillis() + ".jpg";
        File file = new File(appDir, fileName);
        try {
//            ActivityCompat.requestPermissions(ma, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 100);
//            ActivityCompat.requestPermissions(ma, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 101);
            FileOutputStream fos = new FileOutputStream(file);
            //通过io流的方式来压缩保存图片
            bmp.compress(Bitmap.CompressFormat.PNG, 60, fos);
            fos.flush();
            fos.close();

            //把文件插入到系统图库
            MediaStore.Images.Media.insertImage(context.getContentResolver(), file.getAbsolutePath(), fileName, null);

            //保存图片后发送广播通知更新数据库
            Uri uri = Uri.fromFile(file);
            context.sendBroadcast(new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE, uri));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file.getAbsolutePath();
    }

    public static String saveBitmap(Bitmap bmp, Context context, Activity ma) {
        return saveBitmap(bmp, context, ma, storePath);
    }
}
