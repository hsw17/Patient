package com.wd.mymainmodule.view.zview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bwie.mvplibrary.utils.CustomClickListener;
import com.wd.mymainmodule.R;

import androidx.annotation.Nullable;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * date:2019/12/14
 * author:贺少伟(盗)
 * function:
 */
public class HeadBackView extends LinearLayout {
    @BindView(R.id.head_details_back)
    ImageView headDetailsBack;
    @BindView(R.id.head_text_name)
    TextView headTextName;
    public String name;
    public HeadBackView(Context context) {
        super(context, null);
    }

    public HeadBackView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        View inflate = LayoutInflater.from(context)
                .inflate(R.layout.item_head, null, false);
        ButterKnife.bind(this,inflate);
        headDetailsBack.setOnClickListener(new CustomClickListener() {
            @Override
            protected void onSingleClick() {
                if (doVIew!=null) {
                    doVIew.onLogCurress();
                }
            }

            @Override
            protected void onFastClick() {

            }
        });
    }

    public void setName(String name) {
        this.name = name;
        headTextName.setText(name);
    }

    public void setDoVIew(DoVIew doVIew) {
        this.doVIew = doVIew;
    }

    public static DoVIew doVIew;
    public interface DoVIew{
        void onLogCurress();
        void onLogText(String name);
    }
}
