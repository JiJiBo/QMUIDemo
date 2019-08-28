package com.rulerbug.mycode.utils;

import java.io.InputStream;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class OkHttpUtils {
    public static InputStream getInputStrem(String url) {
        try {
            OkHttpClient client = new OkHttpClient();
            //2. 创建请求的Request 对象
            Request request = new Request.Builder()
                    .url(url)
                    .build();

            //3. 在Okhttp中创建Call 对象，将request和Client进行绑定
            //4. 执行Call对象（call 是interface 实际执行的是RealCall）中的`execute`方法

            Response response = client.newCall(request).execute();
            return response.body().byteStream();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getString(String url) {
        try {
            OkHttpClient client = new OkHttpClient();
            //2. 创建请求的Request 对象
            Request request = new Request.Builder()
                    .url(url)
                    .build();

            //3. 在Okhttp中创建Call 对象，将request和Client进行绑定
            //4. 执行Call对象（call 是interface 实际执行的是RealCall）中的`execute`方法

            Response response = client.newCall(request).execute();
            return response.body().string();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
