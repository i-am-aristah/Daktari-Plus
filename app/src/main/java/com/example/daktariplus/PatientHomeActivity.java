package com.example.daktariplus;

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

import com.example.daktariplus.activities.LoginActivity;
import com.example.daktariplus.doctormodule.DoctorAddMedicalRecord;
import com.example.daktariplus.doctormodule.DoctorAppointmentHistory;
import com.example.daktariplus.doctormodule.DoctorAppointmentRequests;
import com.example.daktariplus.doctormodule.DoctorModuleHome;
import com.example.daktariplus.fragments.HomePatientFragment;
import com.example.daktariplus.fragments.MedicalRecordsFragment;
import com.example.daktariplus.fragments.MyAppointmentsFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class PatientHomeActivity extends AppCompatActivity implements  PopupMenu.OnMenuItemClickListener{

    FrameLayout frameLayout;
    BottomNavigationView bottomNavigationView;
   // ImageView  img_top_nav,img_top_menu_doc;

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    String SHAREPREFFILE;

    ImageView img_patient_noti,img_top_menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_patient);

        img_top_menu = findViewById(R.id.img_top_menu);
        img_patient_noti = findViewById(R.id.img_patient_noti);
        bottomNavigationView =findViewById(R.id.bottom_navigation);

        sharedPreferences = getSharedPreferences(SHAREPREFFILE,0);


        getSupportFragmentManager().beginTransaction()
                .add(R.id.container_patient,new HomePatientFragment()).commit();


        img_patient_noti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),NotificationsActivity.class));
            }
        });

        // bottomNavigationView.setOnNavigationItemSelectedListener(nav);

        bottomNavigationView.setOnItemSelectedListener(nav);

        img_top_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu popupMenu = new PopupMenu(getApplicationContext(),img_top_menu);
                popupMenu.inflate(R.menu.top_nav_menu);
                popupMenu.show();
                popupMenu.setOnMenuItemClickListener(PatientHomeActivity.this);
            }
        });
    }

    private final NavigationBarView.OnItemSelectedListener nav =
            new NavigationBarView.OnItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                    switch (item.getItemId()) {
                        case R.id.menu_item_home:
                            showFragment(new HomePatientFragment());
                            Toast.makeText(getApplicationContext(), "Home Selected", Toast.LENGTH_LONG).show();
                            break;
                        case R.id.menu_item_med_rec:
                            showFragment(new MedicalRecordsFragment());
                            break;
                        case R.id.menu_item_my_appointments:
                            showFragment(new MyAppointmentsFragment());
                            break;

                    }
                    return true;
                }
            };


    private void showFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container_patient, fragment)
                .commit();
    }


    @Override
    public boolean onMenuItemClick(MenuItem menuItem) {

        switch (menuItem.getItemId())
        {
            case R.id.logout:
                editor = sharedPreferences.edit();
                editor.putBoolean("login_status",false);
                editor.clear().commit();
                Toast.makeText(getApplicationContext(), "Logout Out Successfully",Toast.LENGTH_LONG).show();
                startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                break;

            case R.id.pharmacy:
                Toast.makeText(getApplicationContext(), "Search Medicine",Toast.LENGTH_LONG).show();
                startActivity(new Intent(getApplicationContext(), PatientSearchPharmacyActivity.class));
                break;
            case R.id.about:
                Toast.makeText(getApplicationContext(), "Logout Out Successfully",Toast.LENGTH_LONG).show();
                startActivity(new Intent(getApplicationContext(),AboutUsActivity.class));
                break;

            case R.id.settings:
                Toast.makeText(getApplicationContext(), "Logout Out Successfully",Toast.LENGTH_LONG).show();
                startActivity(new Intent(getApplicationContext(),SettingsActivity.class));
                break;
            case R.id.doctors:
                Toast.makeText(getApplicationContext(), "Logout Out Successfully",Toast.LENGTH_LONG).show();
                startActivity(new Intent(getApplicationContext(),AllDoctorsActivity.class));
                break;
        }
        return true;
    }
}




