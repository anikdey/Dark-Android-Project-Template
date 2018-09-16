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

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import javarank.com.dreamjournalui.R;
import javarank.com.dreamjournalui.home.listener.OnItemClickListener;
import javarank.com.dreamjournalui.home.model.DateItem;
import javarank.com.dreamjournalui.home.model.Item;
import javarank.com.dreamjournalui.home.ui.adapter.DatesRecyclerViewAdapter;
import javarank.com.dreamjournalui.home.ui.adapter.ItemAdapter;
import javarank.com.dreamjournalui.home.ui.util.Month;

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
        setUpDate();
        initRecyclerView();
        setUpListenerForAdapter();
        setItem(Item.getItems());

        initDatesRecyclerView();
        setUpDate();
    }

    private void setUpDate() {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH)+1;
        int date = calendar.get(Calendar.DATE);
        int daysInMonth = getDaysInMonth(year, month, date);
        String monthName = getMonthAsString(month);
        setUpDateItems(monthName, date, daysInMonth);
    }

    private void setUpDateItems(String monthName, int fromToday, int toEnd) {
        ArrayList<DateItem> items = new ArrayList<>();
        for(int i=fromToday; i<=toEnd; i++) {
            items.add(new DateItem(monthName, i));
        }
        setDateItem(items);
    }

    private String getMonthAsString(int monthOfYear) {
        monthOfYear = monthOfYear-1;
        String month = null;
        if( monthOfYear == Month.JANUARY.ordinal() ) {
            month = Month.JANUARY.getName();
        } else if(monthOfYear == Month.FEBRUARY.ordinal()) {
            month = Month.FEBRUARY.getName();
        } else if(monthOfYear == Month.MARCH.ordinal()) {
            month = Month.MARCH.getName();
        }else if(monthOfYear == Month.APRIL.ordinal()) {
            month = Month.APRIL.getName();
        }else if(monthOfYear == Month.MAY.ordinal()) {
            month = Month.MAY.getName();
        }else if(monthOfYear == Month.JUNE.ordinal()) {
            month = Month.JUNE.getName();
        }else if(monthOfYear == Month.JULY.ordinal()) {
            month = Month.JULY.getName();
        }else if(monthOfYear == Month.AUGUST.ordinal()) {
            month = Month.AUGUST.getName();
        }else if(monthOfYear == Month.SEPTEMBER.ordinal()) {
            month = Month.SEPTEMBER.getName();
        }else if(monthOfYear == Month.OCTOBER.ordinal()) {
            month = Month.OCTOBER.getName();
        }else if(monthOfYear == Month.NOVEMBER.ordinal()) {
            month = Month.NOVEMBER.getName();
        }else if(monthOfYear == Month.DECEMBER.ordinal()) {
            month = Month.DECEMBER.getName();
        }
        return month;
    }

    private int getDaysInMonth(int year, int month, int day) {
        Calendar mycal = new GregorianCalendar(year, month, day);
        int daysInMonth = mycal.getActualMaximum(Calendar.DAY_OF_MONTH);
        return daysInMonth;
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

    public void setDateItem(List<DateItem> items) {
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