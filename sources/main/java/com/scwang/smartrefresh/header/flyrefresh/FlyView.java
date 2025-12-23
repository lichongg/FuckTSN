package com.scwang.smartrefresh.header.flyrefresh;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.scwang.smartrefresh.layout.internal.pathview.PathsView;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class FlyView extends PathsView {
    public FlyView(Context context) {
        super(context);
        a(context, null, 0);
    }

    private void a(Context context, AttributeSet attributeSet, int i6) {
        b(-1);
        c("M2.01,21L23,12 2.01,3 2,10l15,2 -15,2z");
        setMinimumWidth(com.scwang.smartrefresh.layout.util.c.b(25.0f));
        setMinimumHeight(com.scwang.smartrefresh.layout.util.c.b(25.0f));
    }

    public FlyView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, attributeSet, 0);
    }

    @Override // com.scwang.smartrefresh.layout.internal.pathview.PathsView, android.view.View
    protected void onMeasure(int i6, int i7) {
        setMeasuredDimension(View.resolveSize(getSuggestedMinimumWidth(), i6), View.resolveSize(getSuggestedMinimumHeight(), i7));
    }

    public FlyView(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        a(context, attributeSet, i6);
    }
}
