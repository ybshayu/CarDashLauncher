package com.yourcompany.cardash.service;
import android.app.Service;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
import com.yourcompany.cardash.R;
import java.util.Random;

public class FloatingTrafficLightService extends Service {
    private WindowManager wm;
    private View floatView;
    private TextView textView;
    private Handler handler = new Handler();
    private Random random = new Random();
    @Override public IBinder onBind(Intent i) { return null; }
    @Override public void onCreate() {
        super.onCreate();
        wm = (WindowManager) getSystemService(WINDOW_SERVICE);
        floatView = LayoutInflater.from(this).inflate(R.layout.floating_traffic_light, null);
        textView = floatView.findViewById(R.id.floating_text);
        int type = Build.VERSION.SDK_INT >= 26 ? WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY : WindowManager.LayoutParams.TYPE_PHONE;
        WindowManager.LayoutParams p = new WindowManager.LayoutParams(-2, -2, type, WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE, PixelFormat.TRANSLUCENT);
        p.gravity = Gravity.TOP | Gravity.END;
        p.x = 20; p.y = 100;
        wm.addView(floatView, p);
        startSim();
    }
    private void startSim() {
        handler.postDelayed(new Runnable() {
            @Override public void run() {
                textView.setText(String.format("%s %ds", random.nextBoolean() ? "🔴" : "🟢", random.nextInt(60)+1));
                handler.postDelayed(this, 1000);
            }
        }, 1000);
    }
    @Override public void onDestroy() {
        super.onDestroy();
        if (floatView != null) wm.removeView(floatView);
        handler.removeCallbacksAndMessages(null);
    }
}
