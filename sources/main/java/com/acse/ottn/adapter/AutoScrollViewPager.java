package com.acse.ottn.adapter;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.acse.ottn.R;
import com.acse.ottn.d0;
import com.acse.ottn.s;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class AutoScrollViewPager extends RelativeLayout {

    /* renamed from: f, reason: collision with root package name */
    public static final String f4186f = "right";

    /* renamed from: g, reason: collision with root package name */
    public static final String f4187g = "center";

    /* renamed from: h, reason: collision with root package name */
    public static final int f4188h = 0;

    /* renamed from: i, reason: collision with root package name */
    public static final int f4189i = 1;

    /* renamed from: a, reason: collision with root package name */
    public s f4190a;

    /* renamed from: b, reason: collision with root package name */
    public Context f4191b;

    /* renamed from: c, reason: collision with root package name */
    public LinearLayout f4192c;

    /* renamed from: d, reason: collision with root package name */
    public View f4193d;

    /* renamed from: e, reason: collision with root package name */
    public TextView f4194e;

    public AutoScrollViewPager(Context context) {
        this(context, null);
    }

    public final void a(Context context) {
        this.f4191b = context;
        s sVar = new s(context);
        this.f4190a = sVar;
        addView(sVar);
        View view = this.f4193d;
        if (view != null) {
            this.f4194e = (TextView) view.findViewById(R.id.subTitle);
            this.f4192c = (LinearLayout) this.f4193d.findViewById(R.id.pointLayout);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(12);
            this.f4193d.setLayoutParams(layoutParams);
            addView(this.f4193d);
        }
    }

    public void b(int i6) {
        int childCount = this.f4192c.getChildCount();
        for (int i7 = 0; i7 < childCount; i7++) {
            ImageView imageView = (ImageView) this.f4192c.getChildAt(i7);
            if (i7 == i6) {
                imageView.setBackgroundResource(R.drawable.point_checked);
            } else {
                imageView.setBackgroundResource(R.drawable.point_normal);
            }
        }
    }

    public AutoScrollViewPager(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void c() {
        s sVar = this.f4190a;
        if (sVar == null || sVar.c()) {
            return;
        }
        this.f4190a.g();
    }

    public TextView getSubTitle() {
        return this.f4194e;
    }

    public s getViewPager() {
        return this.f4190a;
    }

    public void setAdapter(d0 d0Var) {
        s sVar = this.f4190a;
        if (sVar != null) {
            sVar.a(sVar, d0Var);
        }
    }

    public AutoScrollViewPager(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.AutoScrollViewPager, i6, 0);
        String string = obtainStyledAttributes.getString(R.styleable.AutoScrollViewPager_point_layout);
        string = string == null ? f4187g : string;
        if (string.equals(f4187g)) {
            this.f4193d = LayoutInflater.from(context).inflate(R.layout.point_center_text, (ViewGroup) null);
        } else if (!string.equals("right")) {
            this.f4193d = LayoutInflater.from(context).inflate(R.layout.point_center_text, (ViewGroup) null);
        } else {
            this.f4193d = LayoutInflater.from(context).inflate(R.layout.point_right_text, (ViewGroup) null);
        }
        obtainStyledAttributes.recycle();
        a(context);
    }

    public void b() {
        s sVar = this.f4190a;
        if (sVar != null) {
            sVar.f();
        }
    }

    public void a(int i6) {
        a(i6, 0);
    }

    public void a(int i6, int i7) {
        this.f4192c.removeAllViews();
        for (int i8 = 0; i8 < i6; i8++) {
            View imageView = new ImageView(this.f4191b);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(15, 15);
            layoutParams.leftMargin = 8;
            imageView.setLayoutParams(layoutParams);
            if (i8 == i7) {
                imageView.setBackgroundResource(R.drawable.point_checked);
            } else {
                imageView.setBackgroundResource(R.drawable.point_normal);
            }
            this.f4192c.addView(imageView);
        }
    }

    public void a() {
        s sVar = this.f4190a;
        if (sVar != null) {
            sVar.d();
        }
    }
}
