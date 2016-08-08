package com.example.vtree.calculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class HistoryActivity extends AppCompatActivity {
    DatabaseHandler db;
    ArrayAdapter<String> adapter;
    // List chứa các phép tính đã thực hiện
    List<Oparand> oparandList = new ArrayList<>();
    // List String chứa phép tính và kết quả.
    List<String> oparandList2 = new ArrayList<>();
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        lv = (ListView) findViewById(R.id.listView);
        db = new DatabaseHandler(getApplicationContext());
        oparandList = db.getAllContacts();      // Lấy ra toàn bộ các phép tính
        for (int i = 0; i < oparandList.size(); i++) {
            oparandList2.add(oparandList.get(i).getOp_high() + " = " + oparandList.get(i).getOp_bottom());
        }
        // Add dữ liệu cho List
        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, oparandList2);


        // Assign adapter to ListView
        lv.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.delete:
                db.deleteAll();     //xoa toan bộ các phép tính
                lv.invalidateViews();   // load lại listview
                finish();
                startActivity(getIntent());
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
