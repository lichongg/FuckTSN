package com.baidu.mobads.sdk.api;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import com.baidu.mobads.sdk.internal.av;
import com.baidu.mobads.sdk.internal.bt;
import com.baidu.mobads.sdk.internal.z;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class BDMarketingTextView extends RelativeLayout {
    private View mAdView;
    private Context mContext;
    private ClassLoader mLoader;

    public BDMarketingTextView(Context context) {
        super(context);
        this.mContext = context;
        initView(context);
    }

    private void initView(Context context) {
        try {
            this.mContext = context;
            Object[] objArr = {context};
            ClassLoader a6 = bt.a(context);
            this.mLoader = a6;
            View view = (View) av.a(z.f11216f, a6, (Class<?>[]) new Class[]{Context.class}, objArr);
            this.mAdView = view;
            if (view != null) {
                addView(view, new RelativeLayout.LayoutParams(-2, -2));
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setAdData(NativeResponse nativeResponse, String str) {
        View view = this.mAdView;
        if (view != null) {
            av.a(z.f11216f, view, this.mLoader, "setAdData", new Class[]{Object.class, String.class}, nativeResponse, str);
        }
    }

    public void setEllipsize(TextUtils.TruncateAt truncateAt) {
        View view = this.mAdView;
        if (view != null) {
            av.a(z.f11216f, view, this.mLoader, "setEllipsize", new Class[]{TextUtils.TruncateAt.class}, truncateAt);
        }
    }

    public void setLabelFontSizeSp(int i6) {
        View view = this.mAdView;
        if (view != null) {
            av.a(z.f11216f, view, this.mLoader, "setLabelFontSizeSp", new Class[]{Integer.TYPE}, Integer.valueOf(i6));
        }
    }

    public void setLabelFontTypeFace(Typeface typeface) {
        View view = this.mAdView;
        if (view != null) {
            av.a(z.f11216f, view, this.mLoader, "setLabelFontTypeFace", new Class[]{Typeface.class}, typeface);
        }
    }

    public void setLabelVisibility(int i6) {
        View view = this.mAdView;
        if (view != null) {
            av.a(z.f11216f, view, this.mLoader, "setLabelVisibility", new Class[]{Integer.TYPE}, Integer.valueOf(i6));
        }
    }

    public void setLineSpacingExtra(int i6) {
        View view = this.mAdView;
        if (view != null) {
            av.a(z.f11216f, view, this.mLoader, "setLineSpacingExtra", new Class[]{Integer.TYPE}, Integer.valueOf(i6));
        }
    }

    public void setTextFontColor(int i6) {
        View view = this.mAdView;
        if (view != null) {
            av.a(z.f11216f, view, this.mLoader, "setTextFontColor", new Class[]{Integer.TYPE}, Integer.valueOf(i6));
        }
    }

    public void setTextFontSizeSp(int i6) {
        View view = this.mAdView;
        if (view != null) {
            av.a(z.f11216f, view, this.mLoader, "setTextFontSizeSp", new Class[]{Integer.TYPE}, Integer.valueOf(i6));
        }
    }

    public void setTextFontTypeFace(Typeface typeface) {
        View view = this.mAdView;
        if (view != null) {
            av.a(z.f11216f, view, this.mLoader, "setTextFontTypeFace", new Class[]{Typeface.class}, typeface);
        }
    }

    public void setTextMaxLines(int i6) {
        View view = this.mAdView;
        if (view != null) {
            av.a(z.f11216f, view, this.mLoader, "setTextMaxLines", new Class[]{Integer.TYPE}, Integer.valueOf(i6));
        }
    }

    public BDMarketingTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BDMarketingTextView(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        initView(context);
    }
}
