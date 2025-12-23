package com.baidu.mobads.sdk.api;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.mobads.sdk.internal.av;
import com.baidu.mobads.sdk.internal.bt;
import com.baidu.mobads.sdk.internal.z;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class BDMarketingLabel extends LinearLayout {
    private View mAdView;
    private Context mContext;
    private ClassLoader mLoader;

    public BDMarketingLabel(Context context) {
        super(context);
        this.mContext = context;
        initView(context);
    }

    private void initView(Context context) {
        this.mContext = context;
        Object[] objArr = {context};
        ClassLoader a6 = bt.a(context);
        this.mLoader = a6;
        View view = (View) av.a(z.f11217g, a6, (Class<?>[]) new Class[]{Context.class}, objArr);
        this.mAdView = view;
        if (view != null) {
            addView(view, new RelativeLayout.LayoutParams(-2, -2));
        }
    }

    public void setAdData(NativeResponse nativeResponse) {
        View view = this.mAdView;
        if (view != null) {
            av.a(z.f11217g, view, this.mLoader, "setAdData", new Class[]{Object.class}, nativeResponse);
        }
    }

    public void setLabelFontSizeSp(int i6) {
        View view = this.mAdView;
        if (view != null) {
            av.a(z.f11217g, view, this.mLoader, "setLabelFontSizeSp", new Class[]{Integer.TYPE}, Integer.valueOf(i6));
        }
    }

    public void setLabelFontTypeFace(Typeface typeface) {
        View view = this.mAdView;
        if (view != null) {
            av.a(z.f11217g, view, this.mLoader, "setLabelFontTypeFace", new Class[]{Typeface.class}, typeface);
        }
    }

    public BDMarketingLabel(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BDMarketingLabel(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        initView(context);
    }
}
