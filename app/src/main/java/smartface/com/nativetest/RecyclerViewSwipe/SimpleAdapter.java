package smartface.com.nativetest.RecyclerViewSwipe;

import android.content.Context;
import android.graphics.Color;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.ItemTouchHelper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class SimpleAdapter extends RecyclerView.Adapter<SimpleAdapter.MyViewHolder>  {

    final Context ctx;
    String[] dataset;
    ItemTouchHelper itemTouchHelper;
    SimpleAdapter simpleAdapter;
    RecyclerView mRecyclerView;

    SimpleAdapter(Context ctx, String[] dataset, ItemTouchHelper itemTouchHelper, RecyclerView mRecyclerView){
        this.ctx = ctx;
        this.dataset = dataset;
        this.itemTouchHelper = itemTouchHelper;
        simpleAdapter = this;
        this.mRecyclerView = mRecyclerView;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        RelativeLayout relativeLayout = new RelativeLayout(ctx);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 200 );
        layoutParams.setMargins(20,20,20,20);
        relativeLayout.setLayoutParams(layoutParams);

        relativeLayout.setBackgroundColor(Color.GRAY);

        MyViewHolder myHolder = new MyViewHolder(relativeLayout);

        return myHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.itemView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                int position = mRecyclerView.getChildAdapterPosition(holder.itemView);
                Toast.makeText(ctx, " Item Position " + position, Toast.LENGTH_SHORT).show();
//                simpleAdapter.notifyItemRangeRemoved(1, 3);
//                itemTouchHelper.startDrag(holder);
                return false;
            }
        });
    }

    public final void setDataSet(String[] dataset){
        this.dataset = dataset;
    }

    @Override
    public int getItemCount() {
//        Toast.makeText(ctx, " dataset.length " + dataset.length, Toast.LENGTH_SHORT).show();
        return dataset.length - 1;
    }

    public static class  MyViewHolder extends RecyclerView.ViewHolder{

        public MyViewHolder(View itemView) {
            super(itemView);
        }
    }

}
