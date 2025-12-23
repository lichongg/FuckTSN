package com.amap.api.maps;

import android.R;
import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.amap.api.col.p0003l.d;
import com.autonavi.amap.mapcore.interfaces.IAMap;
import com.autonavi.amap.mapcore.interfaces.IMapFragmentDelegate;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class TextureMapView extends FrameLayout implements BaseMapView {
    private AMap aMap;
    private IMapFragmentDelegate mapFragmentDelegate;
    private int visibility;

    public TextureMapView(Context context) {
        super(context);
        this.visibility = 0;
        getMapFragmentDelegate().setContext(context);
    }

    protected IMapFragmentDelegate getMapFragmentDelegate() {
        if (this.mapFragmentDelegate == null) {
            this.mapFragmentDelegate = new d(1);
        }
        return this.mapFragmentDelegate;
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
            addView(getMapFragmentDelegate().onCreateView(null, null, bundle), new ViewGroup.LayoutParams(-1, -1));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void onDestroy() {
        try {
            getMapFragmentDelegate().onDestroy();
            this.aMap = null;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void onLowMemory() {
        try {
            getMapFragmentDelegate().onLowMemory();
        } catch (Throwable th) {
            th.printStackTrace();
        }
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

    public TextureMapView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.visibility = 0;
        this.visibility = attributeSet.getAttributeIntValue(R.attr.visibility, 0);
        getMapFragmentDelegate().setContext(context);
        getMapFragmentDelegate().setVisibility(this.visibility);
    }

    public TextureMapView(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.visibility = 0;
        this.visibility = attributeSet.getAttributeIntValue(R.attr.visibility, 0);
        getMapFragmentDelegate().setContext(context);
        getMapFragmentDelegate().setVisibility(this.visibility);
    }

    public TextureMapView(Context context, AMapOptions aMapOptions) {
        super(context);
        this.visibility = 0;
        getMapFragmentDelegate().setContext(context);
        getMapFragmentDelegate().setOptions(aMapOptions);
    }
}
