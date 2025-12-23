package com.amap.api.maps.offlinemap;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class CityExpandView extends ExpandableListView {
    public CityExpandView(Context context) {
        this(context, null);
    }

    public CityExpandView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, -1);
        setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.View
    protected void onMeasure(int i6, int i7) {
        System.currentTimeMillis();
        super.onMeasure(i6, View.MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE));
        System.currentTimeMillis();
    }
}
