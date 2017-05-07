package grlshop.app.com.grl;

import android.os.Bundle;
import android.os.Handler;
import grlshop.app.com.grl.Widgets.BaseAppCompactActivity;

import static grlshop.app.com.grl.Utils.Constant.SPLASH_TIME;

public class SplashActivity extends BaseAppCompactActivity {
    private Handler handler;
    private Runnable runnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                startActivity(MainActivity.class, true);
            }
        };
    }

    @Override
    protected void onStart() {
        super.onStart();
        handler.postDelayed(runnable, SPLASH_TIME);
    }
}
