package com.amap.api.maps;

import android.R;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import com.amap.api.col.p0003l.d;
import com.autonavi.amap.mapcore.interfaces.IAMap;
import com.autonavi.amap.mapcore.interfaces.IMapFragmentDelegate;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@TargetApi(20)
/* loaded from: D:\Downloads\app\classes2.dex */
public class WearMapView extends ViewGroup implements BaseMapView {
    private static int pointX;
    private static int pointY;
    private final String TAG;
    private AMap aMap;
    private View mMapView;
    private SwipeDismissView mSwipeDismissView;
    private IMapFragmentDelegate mapFragmentDelegate;
    private int visibility;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface OnDismissCallback {
        void onDismiss();

        void onNotifySwipe();
    }

    public WearMapView(Context context) {
        super(context);
        this.TAG = WearMapView.class.getSimpleName();
        this.visibility = 0;
        getMapFragmentDelegate().setContext(context);
        a(context);
        b(context);
    }

    private static void a(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        if (windowManager != null) {
            Display defaultDisplay = windowManager.getDefaultDisplay();
            Point point = new Point();
            if (defaultDisplay != null) {
                defaultDisplay.getSize(point);
            }
            pointX = point.x;
            pointY = point.y;
        }
    }

    private void b(Context context) {
        this.mSwipeDismissView = new SwipeDismissView(context, this);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams((int) ((context.getResources().getDisplayMetrics().density * 30.0f) + 0.5f), pointY);
        this.mSwipeDismissView.setBackgroundColor(Color.argb(0, 0, 0, 0));
        setBackgroundColor(Color.argb(0, 0, 0, 0));
        addView(this.mSwipeDismissView, layoutParams);
    }

    protected IMapFragmentDelegate getMapFragmentDelegate() {
        IMapFragmentDelegate iMapFragmentDelegate = this.mapFragmentDelegate;
        if (iMapFragmentDelegate == null && iMapFragmentDelegate == null) {
            this.mapFragmentDelegate = new d(1);
        }
        return this.mapFragmentDelegate;
    }

    public void setOnDismissCallbackListener(OnDismissCallback onDismissCallback) {
        SwipeDismissView swipeDismissView = this.mSwipeDismissView;
        if (swipeDismissView != null) {
            swipeDismissView.setCallback(onDismissCallback);
        }
    }

    public AMap getMap() {
        try {
            IAMap map = getMapFragmentDelegate().getMap();
            if (map == null) {
                return null;
            }
            if (this.aMap == null) {
                this.aMap = new AMap(map);
            }
            return this.aMap;
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // com.amap.api.maps.BaseMapView
    public void loadWorldVectorMap(boolean z5) {
        try {
            getMapFragmentDelegate().loadWorldVectorMap(z5);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void onCreate(Bundle bundle) {
        try {
            this.mMapView = getMapFragmentDelegate().onCreateView(null, null, bundle);
            addView(this.mMapView, 0, new ViewGroup.LayoutParams(-1, -1));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void onDestroy() {
        try {
            getMapFragmentDelegate().onDestroy();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void onDismiss() {
        removeAllViews();
    }

    public void onEnterAmbient(Bundle bundle) {
        onResume();
    }

    public void onExitAmbient() {
        onPause();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z5, int i6, int i7, int i8, int i9) {
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            if (childAt == this.mMapView) {
                childAt.layout(0, 0, getWidth(), getHeight());
            } else {
                SwipeDismissView swipeDismissView = this.mSwipeDismissView;
                if (childAt == swipeDismissView) {
                    a(swipeDismissView);
                    this.mSwipeDismissView.layout(0, 0, this.mSwipeDismissView.getMeasuredWidth(), i8);
                }
            }
        }
    }

    public final void onLowMemory() {
        try {
            getMapFragmentDelegate().onLowMemory();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i6, int i7) {
        int childCount = getChildCount();
        for (int i8 = 0; i8 < childCount; i8++) {
            View childAt = getChildAt(i8);
            if (childAt instanceof SwipeDismissView) {
                SwipeDismissView swipeDismissView = (SwipeDismissView) childAt;
                childAt.measure(swipeDismissView.getLayoutParams().width, swipeDismissView.getLayoutParams().height);
            } else {
                childAt.measure(i6, i7);
            }
        }
        super.onMeasure(i6, i7);
    }

    public final void onPause() {
        try {
            getMapFragmentDelegate().onPause();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void onResume() {
        try {
            getMapFragmentDelegate().onResume();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void onSaveInstanceState(Bundle bundle) {
        try {
            getMapFragmentDelegate().onSaveInstanceState(bundle);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // android.view.View
    public void setVisibility(int i6) {
        super.setVisibility(i6);
        getMapFragmentDelegate().setVisibility(i6);
    }

    public WearMapView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.TAG = WearMapView.class.getSimpleName();
        this.visibility = 0;
        this.visibility = attributeSet.getAttributeIntValue(R.attr.visibility, 0);
        getMapFragmentDelegate().setContext(context);
        getMapFragmentDelegate().setVisibility(this.visibility);
        a(context);
        b(context);
    }

    private static void a(View view) {
        int makeMeasureSpec;
        int makeMeasureSpec2;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(-2, -2);
        }
        int i6 = layoutParams.width;
        if (i6 > 0) {
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i6, 1073741824);
        } else {
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        }
        int i7 = layoutParams.height;
        if (i7 > 0) {
            makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i7, 1073741824);
        } else {
            makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
        }
        view.measure(makeMeasureSpec, makeMeasureSpec2);
    }

    public WearMapView(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.TAG = WearMapView.class.getSimpleName();
        this.visibility = 0;
        this.visibility = attributeSet.getAttributeIntValue(R.attr.visibility, 0);
        getMapFragmentDelegate().setContext(context);
        getMapFragmentDelegate().setVisibility(this.visibility);
        a(context);
        b(context);
    }

    public WearMapView(Context context, AMapOptions aMapOptions) {
        super(context);
        this.TAG = WearMapView.class.getSimpleName();
        this.visibility = 0;
        getMapFragmentDelegate().setContext(context);
        getMapFragmentDelegate().setOptions(aMapOptions);
        a(context);
        b(context);
    }

    @Override // android.view.View
    public void setLayerType(int i6, Paint paint) {
    }
}
