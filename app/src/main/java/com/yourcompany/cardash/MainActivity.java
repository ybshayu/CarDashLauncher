package com.yourcompany.cardash;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;
import com.yourcompany.cardash.fragment.DashboardFragment;
import com.yourcompany.cardash.fragment.AppGridFragment;

public class MainActivity extends AppCompatActivity {
    private LinearLayout dockMap, dockMusic, dockPhone, dockSettings;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initDock();
        if (savedInstanceState == null) showFragment(new DashboardFragment());
    }
    private void initDock() {
        dockMap = findViewById(R.id.dock_map);
        dockMusic = findViewById(R.id.dock_music);
        dockPhone = findViewById(R.id.dock_phone);
        dockSettings = findViewById(R.id.dock_settings);
        dockMap.setOnClickListener(v -> showFragment(new DashboardFragment()));
        dockMusic.setOnClickListener(v -> showFragment(new AppGridFragment()));
        dockPhone.setOnClickListener(v -> {});
        dockSettings.setOnClickListener(v -> {});
    }
    private void showFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
            .replace(R.id.fragment_container, fragment).commit();
    }
}
