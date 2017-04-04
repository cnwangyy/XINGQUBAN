package cn.leancloud.leanstoragegettingstarted;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Zhuye extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhuye);

        findViewById(R.id.daohang2_textview_shouye).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Zhuye.this.finish();
                startActivity(new Intent(Zhuye.this, Fenlei.class));
            }
        });
        findViewById(R.id.daohang3_textview_shouye).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Zhuye.this.finish();
                startActivity(new Intent(Zhuye.this, Wode.class));
            }
        });
        findViewById(R.id.testdetail_textview_zhuye).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Zhuye.this, Detail.class));
            }
        });
    }
}
