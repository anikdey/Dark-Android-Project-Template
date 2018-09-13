package javarank.com.dreamjournalui.home.ui.fragment.pages;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import javarank.com.dreamjournalui.R;
import javarank.com.dreamjournalui.home.listener.OnItemClickListener;
import javarank.com.dreamjournalui.home.model.Item;
import javarank.com.dreamjournalui.home.ui.adapter.DatesRecyclerViewAdapter;
import javarank.com.dreamjournalui.home.ui.adapter.ItemAdapter;

public class AddDreamFragment extends BasePageFragment {
    public static final String TAG = AddDreamFragment.class.getSimpleName();

    @BindView(R.id.scroll_position_text_view)
    TextView scrollPositionTextView;
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    @BindView(R.id.dates_recycler_view)
    RecyclerView datesRecyclerView;
    @BindView(R.id.nothing_found_linear_layout)
    LinearLayout nothingFoundLinearLayout;

    private ItemAdapter adapter;
    private DatesRecyclerViewAdapter datesRecyclerViewAdapter;

    public static AddDreamFragment getInstance() {
        AddDreamFragment fragment = new AddDreamFragment();
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        adapter = new ItemAdapter();
        datesRecyclerViewAdapter = new DatesRecyclerViewAdapter();
    }

    @Override
    public void updatePagePosition(int currentPosition, int totalPages) {
        scrollPositionTextView.setText("" + (currentPosition + 1) + " of " + totalPages);
    }

    @Override
    protected void init() {
        initRecyclerView();
        setUpListenerForAdapter();
        setItem(Item.getItems());

        initDatesRecyclerView();
        setDateItem(Item.getItems());
    }

    private void initRecyclerView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.hasFixedSize();
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    private void setUpListenerForAdapter() {
        adapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(int position, View view) {
                showMessage("You click on "+ position);
            }
        });
    }

    private void initDatesRecyclerView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        datesRecyclerView.hasFixedSize();
        datesRecyclerView.setLayoutManager(layoutManager);
        datesRecyclerView.setAdapter(datesRecyclerViewAdapter);
    }

    public void setItem(List<Item> items) {
        if( items != null && items.size()>0 ) {
            controlVisibility(View.VISIBLE, View.GONE);
            adapter.clearItems();
            adapter.addItems(items);
            adapter.notifyDataSetChanged();
        } else {
            controlVisibility(View.GONE, View.VISIBLE);
        }
    }

    public void setDateItem(List<Item> items) {
        if( items != null && items.size()>0 ) {
            datesRecyclerViewAdapter.clearItems();
            datesRecyclerViewAdapter.addItems(items);
            datesRecyclerViewAdapter.notifyDataSetChanged();
        }
    }

    private void controlVisibility(int listVisibility, int noDataVisibility){
        recyclerView.setVisibility(listVisibility);
        nothingFoundLinearLayout.setVisibility(noDataVisibility);
    }

    @OnClick(R.id.fab)
    protected void onAddFabClick() {
        showMessage(getString(R.string.todo));
    }

    @Override
    protected void onCreateComponent() {

    }

    @Override
    protected View getRootView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_add_dream, container, false);
    }
}
