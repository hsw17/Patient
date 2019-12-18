package com.wd.he_home.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bwie.mvplibrary.base.BaseActivity;
import com.wd.he_home.R;
import com.wd.he_home.bean.HomeSearchBean;
import com.wd.he_home.comtract.HomeContract;
import com.wd.he_home.presenter.HomePresenter;
import com.wd.he_home.util.DiseaseSearchVoListAdapter;
import com.wd.he_home.util.DoctorSearchVoListAdapter;
import com.wd.he_home.util.DrugsSearchVoListAdapter;
import com.wd.he_home.util.FlowView;
import com.wd.he_home.util.RecordSQLiteOpenHelper;
import com.zhy.view.flowlayout.TagFlowLayout;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;

public class SearchPageActivity extends BaseActivity<HomePresenter> implements HomeContract.HomeView {

    TagFlowLayout flTopSearch;
    private RecordSQLiteOpenHelper helper;
    private FlowView flSearchHistory;
    private SQLiteDatabase db;
    private boolean hasData;
    private boolean whetherTheQuery = false;
    private ImageView ivHomeSearchBack;
    private EditText etHomeSearchTitle;
    private TextView ivHomeSearch;
    private LinearLayout llRelevantSearchData;
    private ImageView ivNoSearchPic;
    private TextView tvNoSearchName;
    private RelativeLayout rlHomeNoSearch;
    private RecyclerView rvDoctor;
    private RecyclerView rvDrug;
    private RecyclerView rvSymptoms;
    private LinearLayout llSearchData;

    @Override
    protected int bindLayout() {
        return R.layout.activity_search_page;
    }


    @Override
    protected void initData() {
        super.initData();
        //获取资源ID
        ivHomeSearchBack = findViewById(R.id.iv_home_search_back);
        etHomeSearchTitle = findViewById(R.id.et_home_search_title);
        ivHomeSearch = findViewById(R.id.iv_home_search);
        flSearchHistory = findViewById(R.id.fl_searchHistory);
        llRelevantSearchData = findViewById(R.id.ll_relevantSearchData);
        ivNoSearchPic = findViewById(R.id.iv_noSearch_pic);
        tvNoSearchName = findViewById(R.id.tv_noSearch_name);
        rlHomeNoSearch = findViewById(R.id.rl_home_noSearch);
        rvDoctor = findViewById(R.id.rv_doctor);
        rvDrug = findViewById(R.id.rv_drug);
        rvSymptoms = findViewById(R.id.rv_symptoms);
        llSearchData = findViewById(R.id.ll_searchData);
        flTopSearch = findViewById(R.id.fl_topSearch);
        ivHomeSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String keyword = etHomeSearchTitle.getText().toString();
                search(keyword);
            }


        });
        ivHomeSearchBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        //首页搜索
        presenter.HomePresenterShouYeSouSuo("好");
        //热门搜索
        presenter.HomePresenterReMenSouSuo();
        helper = new RecordSQLiteOpenHelper(this);
        String tempName = etHomeSearchTitle.getText().toString();
        queryData(tempName);
    }

    @Override
    protected HomePresenter setPresenter() {
        return new HomePresenter();
    }

    @Override
    public void HomeViewSuccess(Object obj) {
        if (obj instanceof HomeSearchBean) {
            //首页搜索
            HomeSearchBean homeSearchBean = (HomeSearchBean) obj;
            HomeSearchBean.ResultBean result = homeSearchBean.getResult();

            //病症
            List<HomeSearchBean.ResultBean.DiseaseSearchVoListBean> diseaseSearchVoList = result.getDiseaseSearchVoList();
            //医生
            List<HomeSearchBean.ResultBean.DoctorSearchVoListBean> doctorSearchVoList = result.getDoctorSearchVoList();
            //药品
            List<HomeSearchBean.ResultBean.DrugsSearchVoListBean> drugsSearchVoList = result.getDrugsSearchVoList();
            if (diseaseSearchVoList != null && diseaseSearchVoList.size() > 0 || doctorSearchVoList != null && doctorSearchVoList.size() > 0 || drugsSearchVoList != null && drugsSearchVoList.size() > 0) {
                rlHomeNoSearch.setVisibility(View.GONE);
                llSearchData.setVisibility(View.VISIBLE);
                llRelevantSearchData.setVisibility(View.GONE);

                //创建适配器
                DiseaseSearchVoListAdapter diseaseSearchVoListAdapter = new DiseaseSearchVoListAdapter(R.layout.layout_home_search_item, diseaseSearchVoList);
                //设置每个item的排列方式
                rvSymptoms.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
                //设置上适配器
                rvSymptoms.setAdapter(diseaseSearchVoListAdapter);

                //创建适配器
                DoctorSearchVoListAdapter doctorSearchVoListAdapter = new DoctorSearchVoListAdapter(R.layout.layout_home_search_item, doctorSearchVoList);
                //设置每个item的排列方式
                rvDoctor.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
                //设置上适配器
                rvDoctor.setAdapter(doctorSearchVoListAdapter);

                //创建适配器
                DrugsSearchVoListAdapter drugsSearchVoListAdapter = new DrugsSearchVoListAdapter(R.layout.layout_home_search_item, drugsSearchVoList);
                //设置每个item的排列方式
                rvDrug.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
                //设置上适配器
                rvDrug.setAdapter(drugsSearchVoListAdapter);
            } else {
                rlHomeNoSearch.setVisibility(View.VISIBLE);
                llSearchData.setVisibility(View.GONE);
                llRelevantSearchData.setVisibility(View.GONE);
                tvNoSearchName.setText(etHomeSearchTitle.getText().toString());
                //llRelevantSearchData,llSearchData,rlHomeNoSearch
            }
        }
    }

    @Override
    public void HomeViewError(String e) {

    }

    private void search(String keyword) {
        try {
            //添加到流式布局中
            TextView tv = new TextView(this);
            tv.setText(keyword);
            flSearchHistory.addView(tv);
            // 转编码格式
            String UTF8 = URLDecoder.decode(keyword, "UTF-8");
            //请求搜索数据
            presenter.HomePresenterShouYeSouSuo(UTF8);
            //添加到历史记录中
            AddHistory();


        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    private void AddHistory() {
        hasData = hasData(etHomeSearchTitle.getText().toString().trim());
        // 3. 若存在，则不保存；若不存在，则将该搜索字段保存（插入）到数据库，并作为历史搜索记录
        if (!hasData) {
            insertData(etHomeSearchTitle.getText().toString().trim()); // ->>关注4
            queryData("");
        }
    }

    private boolean hasData(String trim) {
        // 从数据库中Record表里找到name=tempName的id
        Cursor cursor = helper.getReadableDatabase().rawQuery(
                "select id as _id,name from records where name =?", new String[]{trim});
        //  判断是否有下一个

        return cursor.moveToNext();
    }

    private void insertData(String tempName) {
        db = helper.getWritableDatabase();
        db.execSQL("insert into records(name) values('" + tempName + "')");
        db.close();
    }

    private void queryData(String tempName) {
        if (!whetherTheQuery) {
            // 1. 模糊搜索
            Cursor cursor = helper.getReadableDatabase().rawQuery(
                    "select id as _id,name from records where name like '%" + tempName + "%' order by id desc ", null);
            while (cursor.moveToNext()) {
                String name = cursor.getString(cursor.getColumnIndex("name"));
                // 2. 创建adapter适配器对象 & 装入模糊搜索的结果
                TextView tv = new TextView(this);
                tv.setPadding(0, 10, 0, 10);
                tv.setText(name);
                flSearchHistory.addView(tv);
                whetherTheQuery = true;
            }

        }
    }
}
