package com.kurono.sxil.memo_mst;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Date;

public class show_Activity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
          setContentView(R.layout.activity_show_);

        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        setContentView(layout);

       Database_Activity helper = new Database_Activity(this);
        SQLiteDatabase db = helper.getReadableDatabase();


        Cursor c = db.query("person",new  String[]{"name","age"},null,null,null,null,null);
        Date d = new Date();
        boolean mov =  c.moveToFirst();
        while (mov){
            TextView textView = new TextView(this);
            textView.setText(String.format("タイトル:%s%nメモ:%s%n%tY/%tm/%td %tT%n",c.getString(0),c.getString(0), d, d, d,d));
//            textView.setText(String.format("タイトル:%s %n%s%n%tY/%tm/%td %tT%n",c.getString(0),c.getInt(0), d, d, d,d));
            mov= c.moveToNext();
            layout.addView(textView);
        }
        c.close();
        db.close();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_show_, menu);
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
