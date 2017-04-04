package cn.leancloud.leanstoragegettingstarted;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.avos.avoscloud.AVUser;

public class Wode extends AppCompatActivity {
    private TextView currentUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wode);

//        currentUser.setText((CharSequence) AVUser.getCurrentUser().getUsername());
//        currentUser = (TextView) findViewById(R.id.currentuser_textview_wode);

        findViewById(R.id.daohang2_textview_shouye).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Wode.this.finish();
                startActivity(new Intent(Wode.this, Fenlei.class));
            }
        });
        findViewById(R.id.daohang1_textview_shouye).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Wode.this.finish();
                startActivity(new Intent(Wode.this, Zhuye.class));
            }
        });
        findViewById(R.id.zhuxiao_button_wode).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //将当前的最近用户清空，否则返回登录界面时，会默认为最近用户直接跳转到主页。
                AVUser.changeCurrentUser(null,true);
                Wode.this.finish();
                startActivity(new Intent(Wode.this, LoginActivity.class));
            }
        });

    }
}
