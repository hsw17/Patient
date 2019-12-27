package com.wd.he_home.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.Glide;
import com.bwie.mvplibrary.base.BaseFragment;
import com.bwie.mvplibrary.base.BasePresenter;
import com.google.android.material.tabs.TabLayout;
import com.wd.he_home.MyAdapter;
import com.wd.he_home.R;
import com.wd.he_home.adapter.DateList_Adapter;
import com.wd.he_home.bean.DoctorlistBean;
import com.wd.he_home.bean.EnquirySectionBean;
import com.wd.he_home.comtract.HomeContract;
import com.wd.he_home.presenter.HomePresenter;

import java.util.ArrayList;
import java.util.List;

/**
 * author: [Liu He]
 * data: 2019/12/20.
 * function：
 */
public class Info_Fragment extends BaseFragment<HomePresenter> implements HomeContract.HomeView {
    private TabLayout tablayout;
    private ImageView img, more, up, next;
    private TextView name, work, address, good, number, money, page;
    private Button btn_go;
    private RecyclerView recy;
    int page2 = 1;
    private String doctorId;
    private MyAdapter myAdapter;
    private ArrayList<String> strings;
    private ArrayList<Fragment> fragments = new ArrayList<>();
    @Override
    protected void initData() {
        super.initData();
        fpresenter.HomePresenterYiShengLieBiao("2", "1", "0", page2, "4");
        tablayout = getActivity().findViewById(R.id.tablayout_in);
        img = getActivity().findViewById(R.id.img);
        more = getActivity().findViewById(R.id.more);
        up = getActivity().findViewById(R.id.up);
        next = getActivity().findViewById(R.id.next);
        name = getActivity().findViewById(R.id.name);
        work = getActivity().findViewById(R.id.work);
        address = getActivity().findViewById(R.id.address);
        good = getActivity().findViewById(R.id.good);
        number = getActivity().findViewById(R.id.number);
        money = getActivity().findViewById(R.id.money);
        page = getActivity().findViewById(R.id.page);
        recy = getActivity().findViewById(R.id.recy);
        btn_go = getActivity().findViewById(R.id.btn_go);
        strings = new ArrayList<>();
        strings.add("咨询");
        strings.add("综合");
        strings.add("好评");
        strings.add("价格");
        tablayout.addTab(tablayout.newTab().setText(strings.get(0)));
        tablayout.addTab(tablayout.newTab().setText(strings.get(1)));
        tablayout.addTab(tablayout.newTab().setText(strings.get(2)));
        tablayout.addTab(tablayout.newTab().setText(strings.get(3)));
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("xxxx", "onCreate: onCreate---------");
    }
    @Override
    protected int bindLayout() {
        return R.layout.info_fragment;
    }

    @Override
    protected HomePresenter setPresenter() {
        return new HomePresenter();
    }
    @Override
    public void HomeViewSuccess(Object obj) {
        if (obj instanceof DoctorlistBean) {
            DoctorlistBean doctorlistBean = (DoctorlistBean) obj;
            List<DoctorlistBean.ResultBean> result = doctorlistBean.getResult();
            doctorId = result.get(0).getDoctorId();
            Glide.with(context()).load(result.get(0).getImagePic()).into(img);
            name.setText(result.get(0).getDoctorName() + "");
            address.setText(result.get(0).getInauguralHospital());
            good.setText("好评率 " + result.get(0).getPraise());
            number.setText("服务患者数 " + result.get(0).getPraiseNum());
            money.setText(result.get(0).getServicePrice() + "H币/次");
            page.setText("" + page);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context());
            linearLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
            recy.setLayoutManager(linearLayoutManager);
            myAdapter = new MyAdapter(context(), result);
            recy.setAdapter(myAdapter);
            if (page2 <= 1) {
                up.setVisibility(View.GONE);
            } else {
                up.setVisibility(View.VISIBLE);
            }
            if (result.size() <= 3) {
                next.setVisibility(View.GONE);
            } else {
                next.setVisibility(View.VISIBLE);
            }

            myAdapter.setOnCLickListener(new MyAdapter.OnCLickListener() {
                @Override
                public void onclick(int position) {
                    doctorId = result.get(position).getDoctorId();
                    Glide.with(context()).load(result.get(position).getImagePic()).into(img);
                    name.setText(result.get(position).getDoctorName() + "");
                    address.setText(result.get(position).getInauguralHospital());
                    good.setText("好评率 " + result.get(position).getPraise());
                    number.setText("服务患者数 " + result.get(position).getPraiseNum());
                    money.setText(result.get(position).getServicePrice() + "H币/次");
                }
            });
        }
    }
    @Override
    public void HomeViewError(String e) {
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
