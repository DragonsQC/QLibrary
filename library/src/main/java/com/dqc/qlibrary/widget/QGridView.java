package com.dqc.qlibrary.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;

/**
 * 解决嵌套 GridView 显示不正常的问题，显示所有数据，不出现滚动条
 */
public class QGridView extends GridView {
    public QGridView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public QGridView(Context context) {
        super(context);
    }

    public QGridView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);
    }
}