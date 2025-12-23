package com.amap.api.maps;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import com.amap.api.maps.WearMapView;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SuppressLint({"ViewConstructor"})
/* loaded from: D:\Downloads\app\classes2.dex */
public class SwipeDismissView extends RelativeLayout {
    protected WearMapView.OnDismissCallback onDismissCallback;

    public SwipeDismissView(Context context, View view) {
        super(context);
        this.onDismissCallback = null;
        setOnTouchListener(view);
    }

    public void setCallback(WearMapView.OnDismissCallback onDismissCallback) {
        this.onDismissCallback = onDismissCallback;
    }

    protected void setOnTouchListener(View view) {
        setOnTouchListener(new SwipeDismissTouchListener(view, new Object(), new SwipeDismissCallBack(this)));
    }

    public SwipeDismissView(Context context, AttributeSet attributeSet, View view) {
        super(context, attributeSet);
        this.onDismissCallback = null;
        setOnTouchListener(view);
    }

    public SwipeDismissView(Context context, AttributeSet attributeSet, int i6, View view) {
        super(context, attributeSet, i6);
        this.onDismissCallback = null;
        setOnTouchListener(view);
    }
}
