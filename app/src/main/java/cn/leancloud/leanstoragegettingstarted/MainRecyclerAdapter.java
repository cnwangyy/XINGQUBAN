package cn.leancloud.leanstoragegettingstarted;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.avos.avoscloud.AVObject;
import com.squareup.picasso.Picasso;

import java.util.Date;
import java.util.List;

/**
 * Created by BinaryHB on 11/24/15.
 */
public class MainRecyclerAdapter extends RecyclerView.Adapter<MainRecyclerAdapter.MainViewHolder> {
  private Context mContext;
  private List<AVObject> mList;

  public MainRecyclerAdapter(List<AVObject> list, Context context) {
    this.mContext = context;
    this.mList = list;
  }
 //在oncreateviewholder里绑定资源布局来创建view
  @Override
  public MainViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    return new MainViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_list_main, parent, false));
  }
 // 在onbindviewholder里给子对象赋值
  @Override
  public void onBindViewHolder(MainViewHolder holder, final int position) {
//    holder.mTitle.setText((CharSequence) mList.get(position).get("title"));
//    holder.mPrice.setText(mList.get(position).get("price") == null ? "￥" : "￥ " + mList.get(position).get("price"));
    holder.mName.setText(mList.get(position).getAVUser("owner") == null ? "" : mList.get(position).getAVUser("owner").getUsername());
    holder.mdescription.setText((CharSequence) mList.get(position).get("description"));
//    holder.mdatetime.setText((CharSequence) mList.get(position).get("createdAt")) ;
      Picasso.with(mContext).load(mList.get(position).getAVFile("image") == null ? "www" : mList.get(position).getAVFile("image").getUrl()).transform(new RoundedTransformation(9, 0)).into(holder.mPicture);
//    holder.mItem.setOnClickListener(new View.OnClickListener() {
//      @Override
//      public void onClick(View view) {
//        Intent intent = new Intent(mContext, DetailActivity.class);
//        intent.putExtra("goodsObjectId", mList.get(position).getObjectId());
//        mContext.startActivity(intent);
//      }
//    });
  }
  //返回多少个数据
  @Override
  public int getItemCount() {
    return mList.size();
  }
  //定义recyclerview 子对象视图的类（对应item_list_main.xml）
  class MainViewHolder extends RecyclerView.ViewHolder {
    private TextView mName;
//    private TextView mPrice;
    private TextView mdescription;
    private TextView mdatetime;
    private CardView mItem;
    private ImageView mPicture;

    public MainViewHolder(View itemView) {
      super(itemView);
      mName = (TextView) itemView.findViewById(R.id.name_item_main);
      mdescription = (TextView) itemView.findViewById(R.id.description_item_main);
//      mdatetime = (TextView) itemView.findViewById(R.id.pinglun_datetime_item_main);
//      mTitle = (TextView) itemView.findViewById(R.id.title_item_main);
//      mPrice = (TextView) itemView.findViewById(R.id.price_item_main);
      mPicture = (ImageView) itemView.findViewById(R.id.picture_item_main);
      mItem = (CardView) itemView.findViewById(R.id.item_main);

    }
  }
}
