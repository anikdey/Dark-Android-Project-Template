package javarank.com.dreamjournalui.home.ui.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import javarank.com.dreamjournalui.R;
import javarank.com.dreamjournalui.home.listener.OnItemClickListener;
import javarank.com.dreamjournalui.home.model.Item;

public class DatesRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    List<Item> list;
    protected OnItemClickListener itemClickListener;

    public DatesRecyclerViewAdapter() {
        list = new ArrayList<>();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.date_item, parent, false);
        return new DateItemViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Item item = list.get(position);
        DateItemViewHolder mHolder = (DateItemViewHolder) holder;
        mHolder.dateTextView.setText(item.getTag());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.itemClickListener = onItemClickListener;
    }

    public void addItems(List<Item> list) {
        this.list = list;
    }

    public void clearItems() {
        this.list.clear();
    }

    class DateItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        @BindView(R.id.date_text_view)
        TextView dateTextView;

        public DateItemViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if( itemClickListener != null && getAdapterPosition() != RecyclerView.NO_POSITION ) {
                itemClickListener.onItemClick(getAdapterPosition(), view);
            }
        }
    }
}