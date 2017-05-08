package bwie.com.cartoon;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import bwie.com.cartoon.bean.Week;
import bwie.com.cartoon.util.StringUtils;

/**
 * Created by $USER_NAME on 2017/4/24.
 */

public class MyAsynctask extends AsyncTask<String,Void,String> {
    Handler handler;

    public MyAsynctask(Handler handler) {
        this.handler = handler;
    }

    @Override
    protected String doInBackground(String... params) {
        String path=params[0];
        try {
            HttpURLConnection connectionne = (HttpURLConnection) new URL(path).openConnection();
            connectionne.setRequestMethod("GET");
            connectionne.setReadTimeout(10000);
            connectionne.setConnectTimeout(10000);
            if (connectionne.getResponseCode()==200){
                InputStream is = connectionne.getInputStream();
                String json = StringUtils.inputStreamToString(is);
//                System.out.println(json);
                return  json;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(String json) {
        super.onPostExecute(json);
        Gson gson=new Gson();
        Week week = gson.fromJson(json, Week.class);
        Message msg=Message.obtain();
        msg.what=2;
       msg.obj=week.getData().getComics();
        handler.sendMessage(msg);

    }
}
