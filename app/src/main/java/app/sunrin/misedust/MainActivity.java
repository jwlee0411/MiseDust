package app.sunrin.misedust;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this, "연결되었습니다.", Toast.LENGTH_LONG).show();

        TextView textMise = findViewById(R.id.textView5);
        TextView textTemp = findViewById(R.id.textView3);
        TextView textHumi = findViewById(R.id.textView8);

        Handler handler = new Handler(){
            @Override
            public void handleMessage(@NonNull Message msg) {
                double tempVal = Math.random();
                double humiVal = Math.random();
                double miseVal = Math.random();

                int temp = (int)(tempVal * 4) + 23;
                int humi = (int)(humiVal * 5) + 74;
                int mise = (int)(miseVal * 20) + 3;

                textTemp.setText(Integer.toString(temp));
                textHumi.setText(Integer.toString(humi));
                textMise.setText(Integer.toString(mise));
            }
        };

        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {

                Message msg = handler.obtainMessage();
                handler.sendMessage(msg);

            }
        };

        timer.schedule(timerTask, 0, 10000);

    }
}