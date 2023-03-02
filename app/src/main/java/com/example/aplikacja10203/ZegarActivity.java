package com.example.aplikacja10203;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ZegarActivity extends AppCompatActivity {
int czasG1=180;
    int czasG2=180;
    boolean gra=true;
    int kto=1;
    TextView gracz1;
    TextView gracz2;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zegar);
        gracz1=findViewById(R.id.textView);
        gracz2=findViewById(R.id.textView2);
        button=findViewById(R.id.button);
        szachy();
    }



    public void szachy(){
        final Handler handler=new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                if (kto==1){
                    czasG1--;

                   gracz1.setText("czas " + Integer.toString(czasG1));
                    handler.postDelayed(this, 1000);



                }
                else{

                    czasG2--;

                    gracz2.setText("czas " + Integer.toString(czasG2));
                    handler.postDelayed(this, 1000);



                }



                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (kto==2) {
                            button.setText("gracz: 1");
                            kto = 1;
                        }
                        else {
                            button.setText("gracz: 2");
                            kto = 2;
                        }

                    }
                });

            }
        });

    }
}