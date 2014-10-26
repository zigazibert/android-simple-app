package si.ziga.simpleapp;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends Activity {

    EditText editTextNumber, editTextURL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //reference XML elements
        editTextNumber = (EditText)findViewById(R.id.editText1);
        editTextURL = (EditText)findViewById(R.id.editText2);
        Button buttonNumber = (Button)findViewById(R.id.button1);
        Button buttonURL = (Button)findViewById(R.id.button2);

        //we set onclick listener to button and react to click events
        buttonNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //onClick  method is called every time user clicks button
                //first we read the value from EditText and save it to String variable
                String value = editTextNumber.getText().toString();
                //we check if String value is empty
                if(value.equals("")){
                    //if String value is empty --> show Toast message with prompt to input age
                    Toast.makeText(getApplicationContext(), "Input your age!", Toast.LENGTH_SHORT).show();
                }else{
                    //else: value is not empty --> open new Activity with Intent
                    //and pass in our String variable with unique ID
                    Intent glue = new Intent(MainActivity.this, SubActivity.class);
                    glue.putExtra("unique_ID", value);
                    startActivity(glue);
                }
            }
        });

        //we set another onclick listener to button and react to click events
        buttonURL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //onClick  method is called every time user clicks button
                //first we read the value from EditText and save it to String variable
                String url = editTextURL.getText().toString();
                Intent glue = new Intent(Intent.ACTION_VIEW, Uri.parse("http://" + url));
                startActivity(glue);
            }
        });

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
}
