package com.loresky.zoom.test.RecyclerSwipeRefresh;

import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.loresky.zoom.R;
import com.loresky.zoom.common.BaseActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cy on 15-5-6.
 * http://stackoverflow.com/questions/25178329/recyclerview-and-swiperefreshlayout/25227797#25227797
 * https://gist.github.com/VladSumtsov/ad4e13511a9b73ff3b13
 */
public class RecyclerSwipeActivity extends BaseActivity implements SwipeRefreshLayout.OnRefreshListener {
    private SwipeRefreshLayout mSwipeRefresh;
    private RecyclerView mRecycler;
    private CustomAdapter mAdapter;
    private List<String> mList;

    @Override
    public void loadContentView() {
        setContentView(R.layout.activity_recycler);
    }

    @Override
    public void initViews() {
        mSwipeRefresh = (SwipeRefreshLayout) findViewById(R.id.swipe_container);
        mRecycler = (RecyclerView) findViewById(R.id.recycler_container);

        mSwipeRefresh.setColorSchemeResources(android.R.color.holo_blue_bright,
                android.R.color.holo_green_light, android.R.color.holo_orange_light,
                android.R.color.holo_red_light);

    }

    @Override
    public void initData() {
        mList = new ArrayList<String>();
        refreshData(0, 10);
        mAdapter = new CustomAdapter(mList);
        mRecycler.setAdapter(mAdapter);

        //每个item高度一致，可设置为true，提高性能
        mRecycler.setHasFixedSize(true);

        //设置横、纵向
        final LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        //        mLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecycler.setLayoutManager(mLayoutManager);

        //修改下拉刷新报错
        mRecycler.setOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                //解决RecyclerView和SwipeRefreshLayout共用存在的bug
                //                int topRowVerticalPosition =
                //                        (recyclerView == null || recyclerView.getChildCount() == 0) ? 0 : recyclerView.getChildAt(0).getTop();
                //                mSwipeRefresh.setEnabled(topRowVerticalPosition >= 0);

                mSwipeRefresh.setEnabled(mLayoutManager.findFirstCompletelyVisibleItemPosition() == 0);
            }
        });
    }

    @Override
    public void setListener() {
        mSwipeRefresh.setOnRefreshListener(this);
    }

    @Override
    public void onRefresh() {
        refreshData(11, 20);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mAdapter.notifyDataSetChanged();
                mSwipeRefresh.setRefreshing(false);
            }
        }, 3000);
    }

    public void refreshData(int frist, int last) {
        for (int i = frist; i < last; i++) {
            mList.add("count:" + i);
        }
    }

}
