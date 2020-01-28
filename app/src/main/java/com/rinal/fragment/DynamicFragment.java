package com.rinal.fragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ButtonBarLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class DynamicFragment extends AppCompatActivity {

    private Button button;
    private Button button2;
    private simplefragment simplefragment;
    private simplefragment2 simplefragment2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamic_fragment);

        button = findViewById(R.id.btnChange);
        button2 = findViewById(R.id.btnChange2);

        simplefragment = new simplefragment();
        simplefragment2 = new simplefragment2();

        //Fragment Manager
        FragmentManager FM = getSupportFragmentManager();

        //Buat object fragment transaction
        FragmentTransaction FT = FM.beginTransaction();
        //tambahkan object SimpleFragment (object) ke Frame
        FT.add(R.id.Frame_Fragments,simplefragment2);
        FT.hide(simplefragment2);
        FT.add(R.id.Frame_Fragments,new simplefragment());
        //kemudian commit().
        FT.commit();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //ketika btn go to another fragment diklik, akan pindah ke fragment lain
                FragmentTransaction FT = getSupportFragmentManager().beginTransaction();
                //FT.add(R.id.Frame_Fragments,new Another Fragment());
                if (simplefragment2.isAdded()){
                    FT.show(simplefragment2);
                    FT.remove(simplefragment);
                    Toast.makeText(getApplicationContext(), "Fragment di tambahkan sebelumnya", Toast.LENGTH_SHORT).show();
                }
                else {
                    FT.replace(R.id.Frame_Fragments,simplefragment2);
                }
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
