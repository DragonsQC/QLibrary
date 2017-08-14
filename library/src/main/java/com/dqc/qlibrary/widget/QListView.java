package com.dqc.qlibrary.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;

/**
 * 解决嵌套 ListView 显示不正常的问题，显示所有数据，不出现滚动条
 */
@SuppressWarnings("WeakerAccess,unused")
public class QListView extends ListView {

    public QListView(Context context) {
        super(context);
    }

    public QListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public QListView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);
    }
}