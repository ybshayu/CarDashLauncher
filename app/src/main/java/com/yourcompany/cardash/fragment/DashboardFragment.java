package com.yourcompany.cardash.fragment;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.yourcompany.cardash.R;
import java.util.Random;

public class DashboardFragment extends Fragment {
    private TextView trafficLightText;
    private Handler handler = new Handler();
    private Random random = new Random();
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_dashboard, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        trafficLightText = view.findViewById(R.id.traffic_light_text);
        startSimulate();
    }
    private void startSimulate() {
        handler.post(new Runnable() {
            @Override
            public void run() {
                boolean isRed = random.nextBoolean();
                int seconds = random.nextInt(60) + 1;
                String status = isRed ? "🚦 红灯" : "🚦 绿灯";
                trafficLightText.setText(String.format("%s %ds", status, seconds));
                trafficLightText.setVisibility(View.VISIBLE);
                handler.postDelayed(this, 1000);
            }
        });
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        handler.removeCallbacksAndMessages(null);
    }
}
