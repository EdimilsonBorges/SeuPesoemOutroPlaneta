package br.edimilsonborges.seupesoemoutroplaneta;


import android.os.AsyncTask;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class AsynDataClass extends AsyncTask<String, Void, String>{
    @Override
    protected String doInBackground(String... params) {

        HttpClient httpClient = new DefaultHttpClient(new BasicHttpParams());
        HttpPost httpPost = new HttpPost("https://meupesoemoutroplaneta.000webhostapp.com/content.json");
        String jsonResult = "";
        try {
            HttpResponse response = httpClient.execute(httpPost);
            jsonResult = inputStreamToString(response.getEntity().getContent()).toString();
            System.out.println("Returned Json object " + jsonResult.toString());
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonResult;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        //É indicando que está sendo feito o download do JSON
    }

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
        System.out.println("Resulted Value: " + result);
      try {
         List<ItemObject> parsedObject = returnParsedJsonObject(result);
          String nomeVersao = parsedObject.get(0).getVersaoName();
          int codigoVersao = Integer.parseInt(parsedObject.get(0).getVersaoCodigo());
          MessageAtualizar messageAtualizar = new MessageAtualizar();
          messageAtualizar.message(nomeVersao,codigoVersao);
       }catch (Exception e){
          e.getMessage();
          }
      }

    private StringBuilder inputStreamToString(InputStream is) {
        String rLine = "";
        StringBuilder answer = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        try {
            while ((rLine = br.readLine()) != null) {
                answer.append(rLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return answer;
    }
    private List<ItemObject> returnParsedJsonObject(String result){

        List<ItemObject> jsonObject = new ArrayList<ItemObject>();
        JSONObject resultObject = null;
        JSONArray jsonArray = null;
        ItemObject newItemObject = null;
        try {
            resultObject = new JSONObject(result);
            System.out.println("Testing the water " + resultObject.toString());
            jsonArray = resultObject.optJSONArray("Config_App");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        for(int i = 0; i < jsonArray.length(); i++){
            JSONObject jsonChildNode = null;
            try {
                jsonChildNode = jsonArray.getJSONObject(i);
                String versaoCodigo = jsonChildNode.getString("versao_codigo");
                String versaoName = jsonChildNode.getString("versao_nome");
                newItemObject = new ItemObject(versaoCodigo, versaoName);
                jsonObject.add(newItemObject);
            } catch (JSONException e) {
                e.printStackTrace();
           }
        }
        return jsonObject;
    }
}