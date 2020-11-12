package app.sunrin.misedust;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import app.sunrin.misedust.MainActivity;
import app.sunrin.misedust.R;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceStare) {
        super.onCreate(savedInstanceStare);
        setContentView(R.layout.activity_splash);
        Toast.makeText(this, "아두이노 연결 중...", Toast.LENGTH_SHORT).show();
        // 어플리케이션을 열면 처음에 실행됨.(SpalshActivity -> MainActivity로 실행되는 구조)

        Handler handler = new Handler(); // Handler 사용해 1초가 지나면 MainActivity 열기
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, 2500);
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}