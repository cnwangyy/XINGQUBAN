package cn.leancloud.leanstoragegettingstarted;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVObject;
import com.avos.avoscloud.AVQuery;
import com.avos.avoscloud.AVUser;
import com.avos.avoscloud.FindCallback;
import com.avos.avoscloud.AVAnalytics;

import java.util.ArrayList;
import java.util.List;

public class List1Activity extends AppCompatActivity {
  private RecyclerView mRecyclerView;
  private MainRecyclerAdapter mRecyclerAdapter;
  private List<AVObject> mList = new ArrayList<>();

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_list1);
    //toolbar中的‘注销’
    final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);
    toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
      @Override
      public boolean onMenuItemClick(MenuItem item) {
        if (item.getItemId() == R.id.action_logout) {
          AVUser.getCurrentUser().logOut();
          startActivity(new Intent(List1Activity.this, LoginActivity.class));
          List1Activity.this.finish();
        }
        return false;
      }
    });
    // fab增加新内容
    FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
    fab.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        startActivity(new Intent(List1Activity.this, PublishActivity.class));
      }
    });
    //recycler列表
    mRecyclerView = (RecyclerView) findViewById(R.id.list_main);
    mRecyclerView.setHasFixedSize(true);
    mRecyclerView.setLayoutManager(new LinearLayoutManager(List1Activity.this));
    mRecyclerAdapter = new MainRecyclerAdapter(mList, List1Activity.this);
    mRecyclerView.setAdapter(mRecyclerAdapter);
  }

  @Override
  protected void onResume() {
    super.onResume();
    AVAnalytics.onResume(this);
    initData();
  }

  @Override
  protected void onPause() {
    super.onPause();
    AVAnalytics.onPause(this);
  }

  private void initData() {
    mList.clear();
    //查询：在Product表中查询‘createdAt’、‘owner’
    AVQuery<AVObject> avQuery = new AVQuery<>("PingLun");
    avQuery.orderByDescending("createdAt");
    avQuery.include("owner");
    avQuery.findInBackground(new FindCallback<AVObject>() {
      @Override
      public void done(List<AVObject> list, AVException e) {
        if (e == null) {
          mList.addAll(list);
          mRecyclerAdapter.notifyDataSetChanged();
        } else {
          e.printStackTrace();
        }
      }
    });
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.menu_main, menu);
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    // Handle action bar item clicks here. The action bar will
    // automatically handle clicks on the Home/Up button, so long
    // as you specify a parent activity in AndroidManifest.xml.
    int id = item.getItemId();

    //noinspection SimplifiableIfStatement
    if (id == R.id.action_logout) {
      return true;
    }

    return super.onOptionsItemSelected(item);
  }
}
