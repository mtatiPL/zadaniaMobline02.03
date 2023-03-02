package com.example.aplikacja10203;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class Pacak_Activity extends AppCompatActivity {
int sekundy=20;
int punktacja=0;
boolean gra=true;
TextView textView;
TextView punkty;
private ArrayList<ImageView>obrazki =new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pacak);
        obrazki.add(findViewById(R.id.imageView1));
        punkty=findViewById(R.id.PunktyTextView);
        obrazki.add(findViewById(R.id.imageView2));
        obrazki.add(findViewById(R.id.imageView3));
        obrazki.add(findViewById(R.id.imageView4));
        textView=findViewById(R.id.CzasTextView);
        pokazWylosowanyObraz();
        zlicz();




    }
private void pokazWylosowanyObraz(){
        for(ImageView obrazek:obrazki){
            obrazek.setVisibility(View.INVISIBLE);
        }
  int indeks=(int)(Math.random()*obrazki.size());
        obrazki.get(indeks).setVisibility(View.VISIBLE);
        obrazki.get(indeks).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                punktacja++;
                punkty.setText("Punkty "+Integer.toString(punktacja));
                pokazWylosowanyObraz();

            }
        });

}
    private void zlicz(){
        final Handler handler=new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                if (gra) {

                    sekundy--;

                    pokazWylosowanyObraz();
                    textView.setText("czas " + Integer.toString(sekundy));
                    handler.postDelayed(this, 1000);
                }
                if(sekundy==0){
                    gra=false;
                    textView.setText("Koniec");
                }




            }
        });


    }


}