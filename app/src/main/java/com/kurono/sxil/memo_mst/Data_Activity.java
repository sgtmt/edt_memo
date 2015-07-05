package com.kurono.sxil.memo_mst;

import android.app.Dialog;
import android.app.FragmentTransaction;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Data_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final AlertDialog.Builder alert;
        setContentView(R.layout.activity_data_);
        TextInputLayout firstLayout = (TextInputLayout)findViewById(R.id.first_Layout);
        TextInputLayout secondLayout = (TextInputLayout)findViewById(R.id.second_Layout);
        final EditText idEdt = (EditText)findViewById(R.id.id_edt);
        final EditText memoEdt = (EditText)findViewById(R.id.memo_edt);
        final CoordinatorLayout coordinatorLayout = (CoordinatorLayout)findViewById(R.id.coordinator_layout);
        Database_Activity helper = new Database_Activity(this);
        final SQLiteDatabase db = helper.getWritableDatabase();
        FloatingActionButton fab = (FloatingActionButton)findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View v) {
                                       String name = idEdt.getText().toString();
                                       String age = memoEdt.getText().toString();

                                       ContentValues insertValue = new ContentValues();
                                       insertValue.put("name",name);
                                       insertValue.put("age",age);
                                       long id = db.insert("person",name,insertValue);
                                       Snackbar.make(coordinatorLayout, "おしたよ", Snackbar.LENGTH_LONG).show();
//                                       dialogFragment.show(getFragmentManager(),"test");

            }
        });


            }


//        Database_Activity dbHelper = new Database_Activity(this);
//        SQLiteDatabase db = dbHelper.getWritableDatabase();
//        db.close();


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_data_, menu);
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
}
