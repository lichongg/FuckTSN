package com.bytedance.adsdk.ugeno.swiper.indicator;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import androidx.core.internal.view.SupportMenu;
import com.bytedance.adsdk.ugeno.swiper.xt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\Downloads\app\classes3.dex */
public abstract class BaseIndicator extends LinearLayout {
    private int ae;
    protected int cw;

    /* renamed from: g, reason: collision with root package name */
    private int f23733g;

    /* renamed from: j, reason: collision with root package name */
    protected Context f23734j;

    /* renamed from: m, reason: collision with root package name */
    private int f23735m;
    private float oq;
    private float qv;

    /* renamed from: r, reason: collision with root package name */
    private List<View> f23736r;
    private boolean tl;
    private int up;
    private String vl;
    protected int xt;

    public void j(int i6, int i7) {
        Iterator<View> it = this.f23736r.iterator();
        while (it.hasNext()) {
            it.next().setBackground(xt(this.f23735m));
        }
        if (i6 < 0 || i6 >= this.f23736r.size()) {
            i6 = 0;
        }
        if (this.f23736r.size() > 0) {
            this.f23736r.get(i6).setBackground(xt(this.up));
            this.f23733g = i7;
        }
    }

    public abstract Drawable xt(int i6);

    public int getSize() {
        return this.f23736r.size();
    }

    public void setIndicatorDirection(String str) {
        this.vl = str;
        if (TextUtils.equals(str, "column")) {
            setOrientation(1);
        } else {
            setOrientation(0);
        }
    }

    public void setIndicatorHeight(int i6) {
        this.cw = i6;
    }

    public void setIndicatorWidth(int i6) {
        this.xt = i6;
    }

    public void setIndicatorX(float f6) {
        this.oq = f6;
    }

    public void setIndicatorY(float f6) {
        this.qv = f6;
    }

    public void setLoop(boolean z5) {
        this.tl = z5;
    }

    public void setSelectedColor(int i6) {
        this.up = i6;
    }

    public void setUnSelectedColor(int i6) {
        this.f23735m = i6;
    }

    public BaseIndicator(Context context) {
        super(context);
        this.up = SupportMenu.CATEGORY_MASK;
        this.f23735m = -16776961;
        this.ae = 5;
        this.xt = 40;
        this.cw = 20;
        this.vl = "row";
        this.f23734j = context;
        this.f23736r = new ArrayList();
        setOrientation(0);
    }

    public void j(int i6) {
        if (this instanceof DotIndicator) {
            this.cw = this.xt;
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.xt, this.cw);
        if (getOrientation() == 1) {
            int i7 = this.ae;
            layoutParams.topMargin = i7;
            layoutParams.bottomMargin = i7;
        } else {
            int i8 = this.ae;
            layoutParams.leftMargin = i8;
            layoutParams.rightMargin = i8;
        }
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(this.xt, this.cw);
        if (getOrientation() == 1) {
            int i9 = this.ae;
            layoutParams2.topMargin = i9;
            layoutParams2.bottomMargin = i9;
        } else {
            int i10 = this.ae;
            layoutParams2.leftMargin = i10;
            layoutParams2.rightMargin = i10;
        }
        int j6 = xt.j(this.tl, this.f23733g, this.f23736r.size());
        int j7 = xt.j(this.tl, i6, this.f23736r.size());
        if (this.f23736r.size() == 0) {
            j7 = 0;
        }
        if (!this.f23736r.isEmpty() && xt.j(j6, this.f23736r) && xt.j(j7, this.f23736r)) {
            this.f23736r.get(j6).setBackground(xt(this.f23735m));
            this.f23736r.get(j6).setLayoutParams(layoutParams2);
            this.f23736r.get(j7).setBackground(xt(this.up));
            this.f23736r.get(j7).setLayoutParams(layoutParams);
            this.f23733g = i6;
        }
    }

    public void j() {
        View view = new View(getContext());
        view.setClickable(false);
        if (this instanceof DotIndicator) {
            this.cw = this.xt;
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.xt, this.cw);
        if (getOrientation() == 1) {
            int i6 = this.ae;
            layoutParams.topMargin = i6;
            layoutParams.bottomMargin = i6;
        } else {
            int i7 = this.ae;
            layoutParams.leftMargin = i7;
            layoutParams.rightMargin = i7;
        }
        addView(view, layoutParams);
        view.setBackground(xt(this.f23735m));
        this.f23736r.add(view);
    }
}
