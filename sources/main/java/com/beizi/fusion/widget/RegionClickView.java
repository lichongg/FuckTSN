package com.beizi.fusion.widget;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.beizi.fusion.model.AdSpacesBean;
import com.beizi.fusion.tool.ap;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class RegionClickView extends LinearLayout {

    /* renamed from: a, reason: collision with root package name */
    GradientDrawable f13906a;

    /* renamed from: b, reason: collision with root package name */
    TextView f13907b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f13908c;

    /* renamed from: d, reason: collision with root package name */
    private Boolean f13909d;

    public RegionClickView(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.f13908c = false;
        init(context);
    }

    private void a(Context context, int i6) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        this.f13906a = gradientDrawable;
        gradientDrawable.setColor(Color.parseColor("#80000000"));
        if (i6 == 1) {
            this.f13906a.setStroke(1, Color.parseColor("#E8E8E8"));
        }
        this.f13906a.setCornerRadius(ap.a(context, 30.0f));
        setBackgroundDrawable(this.f13906a);
    }

    public void init(Context context) {
        if (this.f13908c) {
            return;
        }
        this.f13908c = true;
        a(context, 1);
        TextView textView = new TextView(context);
        this.f13907b = textView;
        textView.setLines(1);
        this.f13907b.setTextSize(2, 18.0f);
        this.f13907b.setTextColor(Color.parseColor("#949494"));
        this.f13907b.setText("点击跳转详情页或第三方应用     >");
        this.f13907b.setGravity(17);
        setGravity(17);
        setOrientation(1);
        addView(this.f13907b);
    }

    public void setBackGroundAlpha(double d6) {
        GradientDrawable gradientDrawable = this.f13906a;
        if (gradientDrawable == null || d6 <= 0.0d) {
            return;
        }
        gradientDrawable.setAlpha((int) (d6 * 255.0d));
    }

    public void setBackgroundColor(String str) {
        GradientDrawable gradientDrawable = this.f13906a;
        if (gradientDrawable == null || str == null) {
            return;
        }
        try {
            gradientDrawable.setColor(Color.parseColor(str));
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    public void setDownloadApp(Boolean bool) {
        this.f13909d = bool;
    }

    public void setRegionalClickViewBean(AdSpacesBean.BuyerBean.RegionalClickViewBean regionalClickViewBean) {
        String downloadTitle;
        if (regionalClickViewBean == null) {
            return;
        }
        if (this.f13909d.booleanValue()) {
            downloadTitle = regionalClickViewBean.getDownloadTitle();
            if (TextUtils.isEmpty(downloadTitle)) {
                downloadTitle = "点击下载应用";
            }
        } else {
            downloadTitle = regionalClickViewBean.getTitle();
        }
        setTitle(downloadTitle);
        setTitleColor(regionalClickViewBean.getTitleColor());
        setBackGroundAlpha(regionalClickViewBean.getBackgroundAlpha());
        setBackgroundColor(regionalClickViewBean.getBackgroundColor());
    }

    public void setTitle(String str) {
        TextView textView = this.f13907b;
        if (textView == null || str == null) {
            return;
        }
        try {
            textView.setText(str);
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    public void setTitleColor(String str) {
        TextView textView = this.f13907b;
        if (textView == null || str == null) {
            return;
        }
        try {
            textView.setTextColor(Color.parseColor(str));
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    public RegionClickView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f13908c = false;
        init(context);
    }

    public RegionClickView(Context context) {
        super(context);
        this.f13908c = false;
        init(context);
    }
}
