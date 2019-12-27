package com.wd.he_bing.view;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.wd.he_bing.R;
import com.wd.he_bing.utils.ImagesViewPager;
import com.ypx.imagepicker.ImagePicker;
import com.ypx.imagepicker.bean.ImageItem;
import com.ypx.imagepicker.utils.PStatusBarUtil;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {
    ArrayList<ImageItem> imageItems = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        PStatusBarUtil.fullScreen(this);
        setContentView(R.layout.activity_second);
        imageItems = (ArrayList<ImageItem>) getIntent().getSerializableExtra(ImagePicker.INTENT_KEY_PICKER_RESULT);
        ImagesViewPager viewPager = findViewById(R.id.viewpager);
        viewPager.setImageViewList(imageItems);
}
    public void click(View view) {
        ImagePicker.closePickerWithCallback(imageItems);
        finish();
    }
}
