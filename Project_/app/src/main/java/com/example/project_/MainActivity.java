package com.example.project_;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListAdapter listAdapter;
    private RecyclerView recyclerView;
    private ArrayList<List> lists;
    private RequestQueue requestQueue;
    int jmldata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.rv_list);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        lists = new ArrayList<>();
        requestQueue = Volley.newRequestQueue(this);
        parseJSON();
    }

    private void parseJSON() {
        String url = "https://viradarmayanti.000webhostapp.com/koneksi.php";
        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        jmldata = response.length();
                        try {
                            for (int i = 0; i < jmldata; i++) {
                                JSONObject data = response.getJSONObject(i);
                                String gambarlist = data.getString("gambar");
                                String namalist = data.getString("nama");
                                String deskripsilist = data.getString("deskripsi");
                                String sejarahlist = data.getString("sejarah");
                                String cirilist = data.getString("ciri");
                                lists.add(new List(gambarlist, namalist, deskripsilist, sejarahlist, cirilist));
                            }
                            listAdapter = new ListAdapter(MainActivity.this, lists);
                            recyclerView.setAdapter(listAdapter);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        requestQueue.add(request);
    }
}
