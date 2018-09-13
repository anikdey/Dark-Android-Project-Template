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
import javarank.com.dreamjournalui.R;
import javarank.com.dreamjournalui.home.model.Item;
import javarank.com.dreamjournalui.home.ui.adapter.ItemAdapter;

public class AddDreamFragment extends BasePageFragment {
    public static final String TAG = AddDreamFragment.class.getSimpleName();

    @BindView(R.id.scroll_position_text_view)
    TextView scrollPositionTextView;
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    @BindView(R.id.nothing_found_linear_layout)
    LinearLayout nothingFoundLinearLayout;

    private ItemAdapter adapter;

    public static AddDreamFragment getInstance() {
        AddDreamFragment fragment = new AddDreamFragment();
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        adapter = new ItemAdapter();
    }

    @Override
    public void updatePagePosition(int currentPosition, int totalPages) {
        scrollPositionTextView.setText("" + (currentPosition + 1) + " of " + totalPages);
    }

    @Override
    protected void init() {
        initRecyclerView();
        setItem(Item.getItems());
    }

    private void initRecyclerView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.hasFixedSize();
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    public void setItem(List<Item> materialToImages) {
        if( materialToImages != null && materialToImages.size()>0 ) {
            controlVisibility(View.VISIBLE, View.GONE);
            adapter.clearItems();
            adapter.addItems(materialToImages);
            adapter.notifyDataSetChanged();
        } else {
            controlVisibility(View.GONE, View.VISIBLE);
        }
    }

    private void controlVisibility(int listVisibility, int noDataVisibility){
        recyclerView.setVisibility(listVisibility);
        nothingFoundLinearLayout.setVisibility(noDataVisibility);
    }

    @Override
    protected void onCreateComponent() {

    }

    @Override
    protected View getRootView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_add_dream, container, false);
    }
}
