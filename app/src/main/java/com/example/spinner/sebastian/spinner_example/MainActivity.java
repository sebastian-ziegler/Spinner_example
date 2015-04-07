package com.example.spinner.sebastian.spinner_example;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity {

    private Spinner spinner;
    ArrayAdapter<String> spinnerAdapter;
    ArrayList<String> spinnerStringList;
    ArrayList<TestObject> objectsList;
    private int count = 4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner = (Spinner) findViewById(R.id.spinner);

        spinnerStringList = new ArrayList<String>();
        objectsList = new ArrayList<TestObject>();

        TestObject obj = new TestObject();
        obj.setId("1");
        obj.setName("Med_1");

        spinnerStringList.add("Med_1");

        objectsList.add(obj);

        obj = new TestObject();
        obj.setId("2");
        obj.setName("Med_2");

        spinnerStringList.add("Med_2");

        objectsList.add(obj);

        obj = new TestObject();
        obj.setId("3");
        obj.setName("Med_3");

        spinnerStringList.add("Med_3");

        objectsList.add(obj);

        initSpinner();
    }

    public void initSpinner(){
        spinnerAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item,
                spinnerStringList);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), objectsList.get(position).getName(),
                        Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(getApplicationContext(), "You didn't select anything", Toast.LENGTH_SHORT)
                        .show();
            }
        });

        spinner.setAdapter(spinnerAdapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void addItem(View v){
        TestObject obj = new TestObject();
        obj.setId(Integer.toString(count));
        obj.setName("Med_"+count);

        spinnerStringList.add("Med_"+count++);

        objectsList.add(obj);

        Toast.makeText(getApplicationContext(), "New object added", Toast.LENGTH_SHORT).show();
    }
}
