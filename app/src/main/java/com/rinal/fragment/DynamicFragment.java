package com.rinal.fragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ButtonBarLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DynamicFragment extends AppCompatActivity {

    private Button button;
    private Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamic_fragment);

        button = findViewById(R.id.btnChange);
        button2 = findViewById(R.id.btnChange2);

        //Fragment Manager
        FragmentManager FM = getSupportFragmentManager();

        //Buat object fragment transaction
        FragmentTransaction FT = FM.beginTransaction();
        //tambahkan object SimpleFragment (object) ke Frame
        FT.add(R.id.Frame_Fragments,new simplefragment());
        //kemudian commit().
        FT.commit();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //ketika btn go to another fragment diklik, akan pindah ke fragment lain
                FragmentTransaction FT = getSupportFragmentManager().beginTransaction();
                //FT.add(R.id.Frame_Fragments,new Another Fragment());
                FT.replace(R.id.Frame_Fragments,new simplefragment2());
                FT.addToBackStack(null);
                FT.commit();

                button2.setVisibility(View.VISIBLE);
                button.setVisibility(View.GONE);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //ketika button go to another fragment di klik, akan pindah ke fragment lain
                FragmentTransaction FT = getSupportFragmentManager().beginTransaction();
                FT.replace(R.id.Frame_Fragments, new simplefragment());
                FT.commit();

                button2.setVisibility(View.GONE);
                button.setVisibility(View.VISIBLE);
            }
        });
    }
}
