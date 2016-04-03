package com.example.lindyzeng.munchwithme;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import java.io.InputStream;
import java.net.HttpCookie;


public class UserAreaActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_area);



        final Button bCreateEvent = (Button) findViewById(R.id.bCreateEvent);
        bCreateEvent.setOnClickListener(new View.OnClickListener() {
            // @Override
            Intent intent = getIntent();
            String name = intent.getStringExtra("name");

            public void onClick(View v) {
                Intent createEventIntent = new Intent(UserAreaActivity.this, CreateEvent.class);
                createEventIntent.putExtra("name", name);
                UserAreaActivity.this.startActivity(createEventIntent);
            }
        });

        String[] names = {"Lindy", "Luisa", "Jessica"};

        ListView listv = (ListView) findViewById(R.id.list);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.layout_userarea, R.id.name, names);
        listv.setAdapter(adapter);
        // listv.setOnItemClickListener(new ItemList());
    }

    class ItemList implements AdapterView.OnItemClickListener {
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            ViewGroup vg = (ViewGroup) view;
            TextView tv = (TextView) vg.findViewById(R.id.name);
            Toast.makeText(UserAreaActivity.this, tv.getText().toString(), Toast.LENGTH_SHORT).show();
        }
    }

}
