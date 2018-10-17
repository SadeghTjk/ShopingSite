package com.shadow.shopingsite;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Product> productList;
    RecyclerView rv;
    DividerItemDecoration did;
    NavigationView nv;
    DrawerLayout dl;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        productList = new ArrayList<>();
        rv = findViewById(R.id.rv);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        dl = findViewById(R.id.dl);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dl.openDrawer(Gravity.START);
            }
        });


        CustomAdapter ca = new CustomAdapter(getApplicationContext(), productList);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        did = new DividerItemDecoration(getApplicationContext(), llm.getOrientation());
        did.setDrawable(rv.getContext().getResources().getDrawable(R.drawable.divider));


        rv.setHasFixedSize(true);
        rv.setLayoutManager(llm);
        rv.addItemDecoration(did);
        rv.setAdapter(ca);
        getJson();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_item, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        switch (id) {
            case R.id.i1:
                Toast.makeText(this, "i1", Toast.LENGTH_SHORT).show();
                break;
            case R.id.i2:
                Toast.makeText(this, "i2", Toast.LENGTH_SHORT).show();
                break;
            case R.id.i3:
                Toast.makeText(this, "i3", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void getJson() {
        String json;

        try {
            InputStream is = getAssets().open("list.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();

            json = new String(buffer, "UTF-8");
            JSONArray jsonArray = new JSONArray(json);

            for (int i = 0; i < jsonArray.length(); i++) {

                JSONObject obj = jsonArray.getJSONObject(i);
                Product product = new Product();

                product.setProductId(obj.getInt("id"));
                product.setProductName(obj.getString("name"));
                product.setProductPrice(obj.getInt("price"));
                product.setProductChecked(obj.getInt("checked"));
                // Toast.makeText(this, "hihi", Toast.LENGTH_SHORT).show();
                productList.add(product);
            }
            // Toast.makeText(this, ""+productList.toString(), Toast.LENGTH_SHORT).show();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}


//                //Image
//                int id = getApplicationContext().getResources().getIdentifier("drawable/i" + uniqueItemId, null, getApplicationContext().getPackageName());
//                myItem.setItemImage(id);

//icsp.edit().putBoolean(uniqueItemId, false).apply();
//Toast.makeText(getApplicationContext(), uniqueItemId, Toast.LENGTH_LONG).show();


//Selected
//
//                if ((!icsp.getBoolean(uniqueItemId,false))) {
//                    myItem.setChecked(false);
//                    icsp.edit().putBoolean(uniqueItemId, false).apply();
//                } else {
//                    myItem.setChecked(true);
//                    icsp.edit().putBoolean(uniqueItemId, true).apply();
//                }






