package com.example.andrew.gitapp.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.andrew.gitapp.R;

public class MainActivity extends AppCompatActivity {
    public EditText e1,e2;
    public Spinner spin;
    public Button b1,b3;
    public int num1,num2;
    public String s1,s2,s3,s4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        e1=(EditText)findViewById(R.id.edit_overs);
        e2=(EditText)findViewById(R.id.edit_noplay);
        spin=(Spinner)findViewById(R.id.spin_wide);
        b1=(Button)findViewById(R.id.button_accept);
        b3=(Button)findViewById(R.id.button_quit);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    num1 = Integer.parseInt(e1.getText().toString().trim());
                    num2 = Integer.parseInt(e2.getText().toString().trim());

                }
                catch(Exception e)
                {
                    Toast.makeText(MainActivity.this, "please enter a integer", Toast.LENGTH_SHORT).show();
                }
                if(validover(num1) && validplayers(num2) ) {
                    Intent intent = new Intent(MainActivity.this, Teams.class);
                    s1 = e1.getText().toString().trim();
                    s2 = e2.getText().toString().trim();
                    s3 = spin.getSelectedItem().toString();

                    if (s3=="1")
                    {
                        s4 ="1";
                    }
                    else
                    {
                        s4="2";
                    }
                    SharedPreferences data = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
                    data.edit().putString("overs",s1).commit();
                    data.edit().putString("noplay",s2).commit();
                    intent.putExtra("overs", s1);
                    intent.putExtra("noplay", s2);
                    intent.putExtra("nowide", s4);
                    startActivity(intent);
                }
            }

        });
     b3.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
             Toast.makeText(MainActivity.this,"hai"+s3,Toast.LENGTH_LONG).show();
             Intent homeIntent = new Intent(Intent.ACTION_MAIN);
             homeIntent.addCategory( Intent.CATEGORY_HOME );
             homeIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
             startActivity(homeIntent);
         }
     });
    }
    public boolean validover(int num)
    {
        if(num>0&&num<50)
        {
            return true;
        }
        else{
            Toast.makeText(MainActivity.this,"please enter a valid overs b/t 1-50 "+s3,Toast.LENGTH_SHORT).show();
            return false;
        }
    }
    public boolean validplayers(int num)
    {
        if (num>2&&num<14)
        {
            return true;
        }
        else
        {
            Toast.makeText(MainActivity.this,"please enter valid no of players b/t 3-13",Toast.LENGTH_SHORT).show();
            return false;
        }
    }

}
