package bwie.com.cartoon;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.WindowDecorActionBar;

public class MainActivity extends AppCompatActivity {
Handler handler=new Handler(){
    @Override
    public void handleMessage(Message msg) {
        switch (msg.what){
            case 1:

                Intent intent=new Intent(getApplicationContext(),Main.class);
                startActivity(intent);
                finish();
                break;
        }
    }
};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dump();
    }

    private void dump() {
        handler.sendEmptyMessageDelayed(1,2000);

    }
}
