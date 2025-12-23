package com.bxkj.base.v2.common.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ListView;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class ListViewFullHeight extends ListView {
    public ListViewFullHeight(Context context) {
        super(context);
    }

    public ListViewFullHeight(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ListViewFullHeight(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.View
    protected void onMeasure(int i6, int i7) {
        super.onMeasure(i6, View.MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE));
    }
}
