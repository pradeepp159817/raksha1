package com.example.pradeep.raksha1;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;
import android.widget.Toast;

public class Wearer extends AppCompatActivity implements View.OnClickListener {
   Button b5,sendbuttuon,langbutton,helpbutton,messages,numbers;
   private long backpresstime;
   private Toast backtoast;
   Toolbar toolbar1;
   Menu menu;
   TextView mTextField;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wearer);
        b5=(Button)findViewById(R.id.button2);
        mTextField=(TextView)findViewById(R.id.textView4);
        helpbutton=(Button)findViewById(R.id.help);
        toolbar1=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar1);
        toolbar1.setTitle("hi");
        b5.setOnClickListener(this);

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater= getMenuInflater();
        inflater.inflate(R.menu.menu,menu);

        return super.onCreateOptionsMenu(menu);
    }



    @Override
    public void onClick(View view) {
        Intent intent = new Intent(Wearer.this, MainActivity.class);
        intent.putExtra("EXIT", false);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        if (backpresstime + 2000 > System.currentTimeMillis()) {
            backtoast.cancel();
            //super.onBackPressed();
            System.exit(0);
            return;
        }
        else {
            backtoast = Toast.makeText(getBaseContext(),"Press back again to exit",Toast.LENGTH_SHORT);
            backtoast.show();
        }
        backpresstime=System.currentTimeMillis();


    }
   

    public void help(MenuItem item) {
        Intent intent = new Intent(this, helpactivity.class);
        intent.putExtra("EXIT", false);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);

    }
    public void settings(MenuItem item)
    {

    }

    public void sendmessage(MenuItem item) {
    }
}
