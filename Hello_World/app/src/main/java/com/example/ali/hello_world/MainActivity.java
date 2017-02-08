package com.example.ali.hello_world;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
EditText edit1, edit2;
Button debug;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
tv = (TextView)findViewById(R.id.textdebug);
        debug = (Button)findViewById(R.id.debug);
        edit1 = (EditText)findViewById(R.id.edit1);
        edit2 = (EditText)findViewById(R.id.edit2);
        debug.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                debugPlus();
            }
        });

    }

public void debugPlus()
{
    int x = Integer.parseInt(edit1.getText().toString());
    int y = Integer.parseInt(edit2.getText().toString());
     int a = x+y;
    String g = String.format("a");
    tv.setText(g);

}
    public void debugMinus()
    {
        int x = Integer.parseInt(edit1.getText().toString());
        int y = Integer.parseInt(edit2.getText().toString());
        int a = x-y;
        tv.setText(a);

    }
    public void debugMul()
    {
        int x = Integer.parseInt(edit1.getText().toString());
        int y = Integer.parseInt(edit2.getText().toString());
        int a = x*y;
        tv.setText(a);

    }



}
