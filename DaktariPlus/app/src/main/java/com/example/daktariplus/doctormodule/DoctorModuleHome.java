package com.example.daktariplus.doctormodule;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.Toast;

import com.example.daktariplus.R;
import com.example.daktariplus.activities.LoginActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class DoctorModuleHome extends AppCompatActivity implements  PopupMenu.OnMenuItemClickListener{

    FrameLayout frameLayout;
    BottomNavigationView bottomNavigationView;
    ImageView  img_top_nav,img_top_menu_doc;

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    String SHAREPREFFILE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_module_home);

        frameLayout = findViewById(R.id.container_doctor);
        bottomNavigationView = findViewById(R.id.doc_bottom_navigation);
        img_top_nav = findViewById(R.id.img_top_menu_doc);
        img_top_menu_doc=findViewById(R.id.img_top_menu_doc);


        sharedPreferences = getSharedPreferences(SHAREPREFFILE,0);






        getSupportFragmentManager().beginTransaction()
                .add(R.id.container_doctor,new DoctorAppointmentRequests()).commit();

        //bottomNavigationView.setOnNavigationItemSelectedListener(nav);

        bottomNavigationView.setOnItemSelectedListener(nav);

        img_top_menu_doc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu popupMenu = new PopupMenu(getApplicationContext(),img_top_nav);
                popupMenu.inflate(R.menu.top_nav_doc_menu);
                popupMenu.show();
                popupMenu.setOnMenuItemClickListener(DoctorModuleHome.this);
            }
        });
    }

    private final NavigationBarView.OnItemSelectedListener nav =
            new NavigationBarView.OnItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                    switch (item.getItemId()) {
                        case R.id.menu_item_a_req:
                            showFragment(new DoctorAppointmentRequests());
                            Toast.makeText(getApplicationContext(), "Home Selected", Toast.LENGTH_LONG).show();
                            break;
                        case R.id.menu_item_a_his:
                            showFragment(new DoctorAppointmentHistory());
                            break;
                        case R.id.menu_item_add_med_rec:
                            showFragment(new DoctorAddMedicalRecord());
                            break;

                    }
                    return true;
                }
            };


    private void showFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container_doctor, fragment)
                .commit();
    }


    @Override
    public boolean onMenuItemClick(MenuItem menuItem) {

        switch (menuItem.getItemId())
        {
            case R.id.doc_logout:
                editor = sharedPreferences.edit();
                editor.putBoolean("login_status",false);
                editor.clear().commit();
                Toast.makeText(getApplicationContext(), "Logout Out Successfully",Toast.LENGTH_LONG).show();
                startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                break;

        }
        return true;
    }
}




