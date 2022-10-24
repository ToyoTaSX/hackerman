package com.hacktools.hackerman;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;

public class MainMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        ImageButton search_button = findViewById(R.id.search_button);
        FrameLayout frameLayout = findViewById(R.id.frame_layout);
        SearchFragment searchFragment = new SearchFragment();
        search_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setNewFragment(frameLayout.getId(), searchFragment);
            }
        });
    }

    private void setNewFragment(int frameLayoutID, Fragment fragment){
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(frameLayoutID, fragment);
        ft.addToBackStack(null);
        ft.commit();
    }
}