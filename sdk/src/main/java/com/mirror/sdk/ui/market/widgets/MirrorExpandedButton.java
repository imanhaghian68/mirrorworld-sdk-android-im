package com.mirror.sdk.ui.market.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.mirror.sdk.R;

public class MirrorExpandedButton extends ConstraintLayout {

    private TextView mTextView;
    private ImageView mArrowImageUp;
    private ImageView mArrowImageDown;

    private boolean mIsOpen = false;

    public MirrorExpandedButton(@NonNull Context context) {
        super(context);
        initView(context);
    }

    public MirrorExpandedButton(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public MirrorExpandedButton(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    private void initView(Context context){
        LayoutInflater.from(context).inflate(R.layout.extended_button,this);
        mArrowImageUp = findViewById(R.id.extended_button_iv_up);
        mArrowImageDown = findViewById(R.id.extended_button_iv_down);
        mTextView = findViewById(R.id.extended_button_tv);

        mArrowImageUp.setVisibility(View.VISIBLE);
        mArrowImageDown.setVisibility(View.GONE);
    }

    public void setText(String text){
        mTextView.setText(text);
    }

    @Override
    public void setOnClickListener(@Nullable OnClickListener l) {
        super.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mIsOpen == true){
                    mIsOpen = false;
                    mArrowImageUp.setVisibility(View.GONE);
                    mArrowImageDown.setVisibility(View.VISIBLE);
                }else if(mIsOpen == false){
                    mIsOpen = true;
                    mArrowImageUp.setVisibility(View.VISIBLE);
                    mArrowImageDown.setVisibility(View.GONE);
                }
                l.onClick(v);
            }
        });
    }
}
