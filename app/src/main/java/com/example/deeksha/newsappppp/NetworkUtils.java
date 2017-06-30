package com.example.deeksha.newsappppp;
import android.net.Uri;
import android.util.Log;

import com.example.deeksha.newsappppp.model.NewsItem;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

import static android.content.ContentValues.TAG;


/**
 * Created by deeksha on 6/12/2017.
 */

public class NetworkUtils {

    public static final String TAG = "NetworkUtils";

    public static final String BASE_URL = "https://newsapi.org/v1/articles?source=the-next-web&sortBy=latest&apiKey=";
    public static final String PARAM_QUERY = "q";
    public static final String PARAM_SORT = "sort";

    public static URL makeURL(String searchQuery, String sortBy) {
        Uri uri = Uri.parse(BASE_URL).buildUpon()
                .appendQueryParameter(PARAM_QUERY, searchQuery)
                .appendQueryParameter(PARAM_SORT, sortBy).build();

        URL url = null;
        try {
            String urlString = uri.toString();
            Log.d(TAG, "Url: " + urlString);
            url = new URL(uri.toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        return url;
    }

    public static String getResponseFromHttpUrl(URL url) throws IOException {
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        try {
            InputStream in = urlConnection.getInputStream();
            Scanner input = new Scanner(in);

            input.useDelimiter("\\A");
            return (input.hasNext()) ? input.next() : null;

        } finally {
            urlConnection.disconnect();
        }
    }

    public static ArrayList<NewsItem> parseJSON(String json) throws JSONException {
        ArrayList<NewsItem> result = new ArrayList<>();
        JSONObject main = new JSONObject(json);
        JSONArray articles = main.getJSONArray("articles");

        for(int i = 0; i < articles.length(); i++){
            JSONObject item = articles.getJSONObject(i);
            String title = item.getString("title");
            String description=item.getString("description");
            String publishedAt=item.getString("publishedAt");
            String url = item.getString("url");
            NewsItem repo = new NewsItem(title, description ,publishedAt , url);
            result.add(repo);
        }
        return result;
    }
}