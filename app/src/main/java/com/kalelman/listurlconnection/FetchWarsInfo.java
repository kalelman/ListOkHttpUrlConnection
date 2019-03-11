package com.kalelman.listurlconnection;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import com.kalelman.listurlconnection.activity.MainActivity;
import com.kalelman.listurlconnection.model.ModelWarDetail;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


public class FetchWarsInfo extends AsyncTask<String, Void, List<ModelWarDetail>> {

    public static final String URL_STRING ="https://blogurl-3f73f.firebaseapp.com/";

    private List<ModelWarDetail> listWarDetails = new ArrayList<>();
    private Context context;
    private Activity mainActivity;

    public FetchWarsInfo(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    @Override
    protected void onPreExecute() {

    }

    @Override
    protected List<ModelWarDetail> doInBackground(String... params) {
        String response = creatingURLConnection(params[0]);
        List<ModelWarDetail> modelWarDetail = null;
        try{
            modelWarDetail = parseResponse(response);
        }catch (JSONException e){
            e.printStackTrace();
        }
        return modelWarDetail;
    }

    @Override
    protected void onPostExecute(List<ModelWarDetail> warDetails) {
        Toast.makeText(mainActivity, "ON post execute called", Toast.LENGTH_LONG).show();

        ((MainActivity)mainActivity).initRecyclerView(warDetails);
    }

    private String creatingURLConnection(String urlString) {

        String response = "";

        HttpURLConnection conn ;
        StringBuilder jsonResults = new StringBuilder();
        try {
            URL url = new URL(urlString);
            conn = (HttpURLConnection) url.openConnection();
           /*
            converting response into String
            */
            InputStreamReader in = new InputStreamReader(conn.getInputStream());
            int read;
            char[] buff = new char[1024];
            while ((read = in.read(buff)) != -1) {
                jsonResults.append(buff, 0, read);
            }
            response = jsonResults.toString();
        }catch(Exception e){
            e.printStackTrace();
        }
        return response;
    }

    private List<ModelWarDetail> parseResponse(String response) throws JSONException {
        if(response!=null && !response.equals("")){
            JSONArray responseArray = new JSONArray(response);
            if(responseArray.length()>0){

                for(int i=0;i<responseArray.length();i++){
                    JSONObject battleObj = responseArray.getJSONObject(i);

                    //creating object of model class(ModelWarDetails)
                    ModelWarDetail modelWarDetails = new ModelWarDetail();
                            /*
                            fetching data based on key from JSON and setting into model class
                            */
                    modelWarDetails.setName(battleObj.optString("name"));
                    modelWarDetails.setAttackerKing(battleObj.optString("attacker_king"));
                    modelWarDetails.setDefenderKing(battleObj.optString("defender_king"));
                    modelWarDetails.setLocation(battleObj.optString("location"));

                    //adding data into List
                    listWarDetails.add(modelWarDetails);
                }
            }
        }
        return listWarDetails;
    }
}
