package com.admin.lnct;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class UpdateBackgroundTask extends AsyncTask<Void , Void , String>
{
    Context context;


    public  UpdateBackgroundTask()
    {

    }

    public UpdateBackgroundTask(Context context)
    {
        this.context=context;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(Void... voids) {
        Exception e;
        //connection
        String update_url="http://ucdapeiron.heliohost.org/adminphp/updateadmin.php";
        try {
            URL url=new URL(update_url);
            HttpURLConnection  httpURLConnection=(HttpURLConnection)url.openConnection();
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setRequestMethod("POST");
            OutputStream os=httpURLConnection.getOutputStream();
            BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(os,"UTF-8"));
            String data= URLEncoder.encode("busnumber","UTF-8") +" = "+URLEncoder.encode("100","UTF-8") + "&" +
                    URLEncoder.encode("route","UTF-8")  +" = "+URLEncoder.encode("ranchi","UTF-8");

            bufferedWriter.write(data);
            bufferedWriter.flush();
            BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
            StringBuilder stringBuilder=new StringBuilder();
            String line="";
            while((line=bufferedReader.readLine())!=null)
            {
                stringBuilder.append(line+"\n");

            }
            bufferedWriter.close();
            os.close();

            InputStream inputStream=httpURLConnection.getInputStream();
            inputStream.close();
            httpURLConnection.disconnect();
            return "updated Succesfully"+stringBuilder;


        } catch (Exception e1) {
          e=e1;

        }

        return "not updated"+e;
    }

    @Override
    protected void onPostExecute(String sToast) {
        super.onPostExecute(sToast);
        Toast.makeText(context, ""+sToast, Toast.LENGTH_SHORT).show();
    }
}
