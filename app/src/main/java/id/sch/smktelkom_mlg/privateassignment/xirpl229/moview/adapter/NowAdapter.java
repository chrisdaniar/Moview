package id.sch.smktelkom_mlg.privateassignment.xirpl229.moview.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import id.sch.smktelkom_mlg.privateassignment.xirpl229.moview.R;
import id.sch.smktelkom_mlg.privateassignment.xirpl229.moview.model.Result;

/**
 * Created by Chrisdaniar on 14/05/2017.
 */

public class NowAdapter extends RecyclerView.Adapter<NowAdapter.ViewHolder> {
    Context context;
    ArrayList<Result> list;
    ISourceAdapter mISourceAdapter;

    public NowAdapter(Context context, ArrayList<Result> list) {
        this.list = list;
        this.context = context;
        mISourceAdapter = (ISourceAdapter) context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.now_list, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Result result = list.get(position);
        holder.tvName.setText(result.title);
        holder.tvDesc.setText(result.overview);
        holder.tvDate.setText(result.release_date);
        Glide.with(context)
                .load("http://image.tmdb.org/t/p/w500" + result.poster_path)
                .into(holder.ivPoster);
    }

    @Override
    public int getItemCount() {
        if (list != null)
            return list.size();
        return 0;
    }

    public interface ISourceAdapter {
        void showArticles(String title, String overview, String poster_path);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvName;
        TextView tvDesc;
        ImageView ivPoster;
        TextView tvDate;

        public ViewHolder(View itemView) {
            super(itemView);
            tvName = (TextView) itemView.findViewById(R.id.textViewName);
            tvDesc = (TextView) itemView.findViewById(R.id.textViewDesc);
            tvDate = (TextView) itemView.findViewById(R.id.textViewDate);
            ivPoster = (ImageView) itemView.findViewById(R.id.imageViewPoster);
        }
    }
}
