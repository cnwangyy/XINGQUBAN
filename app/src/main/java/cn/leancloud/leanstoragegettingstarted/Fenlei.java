package cn.leancloud.leanstoragegettingstarted;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Fenlei extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fenlei);
        findViewById(R.id.daohang1_textview_shouye).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fenlei.this.finish();
                startActivity(new Intent(Fenlei.this, Zhuye.class));
            }
        });
        findViewById(R.id.daohang3_textview_shouye).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fenlei.this.finish();
                startActivity(new Intent(Fenlei.this, Wode.class));
            }
        });
    }
}
