package si.ziga.simpleapp;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class SubActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        //reference XML elements
        RelativeLayout layout = (RelativeLayout)findViewById(R.id.layout);
        TextView text = (TextView)findViewById(R.id.text);

        //We intercept Intent
        Intent glue = getIntent();
        //We read our data from intent and save it to local String variable
        String data = glue.getStringExtra("unique_ID");
        //we parse/transform our String variable to Integer
        int age = Integer.parseInt(data);
        //based on user age we write something on screen and change background color
        if(age < 18){
            text.setText("Oh my you are young :-)");
            layout.setBackgroundColor(Color.CYAN);
        }else if(age >= 18 && age < 26){
            text.setText("Party every day till you drop dead :-)");
            layout.setBackgroundColor(Color.MAGENTA);
        }else{
            text.setText("Old is new young :-)");
            layout.setBackgroundColor(Color.GREEN);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_sub, menu);
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
