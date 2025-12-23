package com.bytedance.sdk.openadsdk.core.widget;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.kt;
import com.bytedance.sdk.openadsdk.core.rn.ed;
import com.bytedance.sdk.openadsdk.widget.TTProgressBar;

/* loaded from: D:\Downloads\app\classes4.dex */
public class m extends Dialog {
    private Button ae;
    private String av;
    private String az;
    public View.OnClickListener cw;

    /* renamed from: g, reason: collision with root package name */
    private Button f31220g;

    /* renamed from: i, reason: collision with root package name */
    private int f31221i;

    /* renamed from: j, reason: collision with root package name */
    TTProgressBar f31222j;
    private String jy;
    private View kt;

    /* renamed from: m, reason: collision with root package name */
    private TextView f31223m;
    private boolean mi;
    private View oq;
    private ViewGroup qv;

    /* renamed from: r, reason: collision with root package name */
    private ImageView f31224r;
    private Button tl;
    private TextView up;
    private Context vl;

    /* renamed from: w, reason: collision with root package name */
    private Drawable f31225w;
    private String ws;
    public j xt;

    public interface j {
        void j();

        void xt();
    }

    private void cw() {
        ed.j(this.tl, new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.m.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                j jVar = m.this.xt;
                if (jVar != null) {
                    jVar.j();
                }
            }
        }, "positiveBn");
        ed.j(this.ae, new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.m.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                j jVar = m.this.xt;
                if (jVar != null) {
                    jVar.xt();
                }
            }
        }, "negtiveBn");
        ed.j(this.f31220g, new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.m.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                View.OnClickListener onClickListener = m.this.cw;
                if (onClickListener != null) {
                    onClickListener.onClick(view);
                }
            }
        }, "dialog_change_btn");
    }

    private void r() {
        Button button;
        if (this.up != null) {
            if (TextUtils.isEmpty(this.ws)) {
                this.up.setVisibility(8);
            } else {
                this.up.setText(this.ws);
                this.up.setVisibility(0);
            }
        }
        if (this.f31223m != null && !TextUtils.isEmpty(this.jy)) {
            this.f31223m.setText(this.jy);
        }
        if (this.tl != null) {
            if (TextUtils.isEmpty(this.az)) {
                this.tl.setText("确定");
            } else {
                this.tl.setText(this.az);
            }
            int i6 = this.f31221i;
            if (i6 != -1) {
                this.tl.setBackgroundColor(i6);
            }
        }
        if (this.ae != null) {
            if (TextUtils.isEmpty(this.av)) {
                this.ae.setText("取消");
            } else {
                this.ae.setText(this.av);
            }
        }
        ImageView imageView = this.f31224r;
        if (imageView != null) {
            Drawable drawable = this.f31225w;
            if (drawable != null) {
                imageView.setImageDrawable(drawable);
                this.f31224r.setVisibility(0);
            } else {
                imageView.setVisibility(8);
            }
        }
        View view = this.oq;
        if (view == null || (button = this.ae) == null) {
            return;
        }
        if (this.mi) {
            view.setVisibility(8);
            this.ae.setVisibility(8);
            return;
        }
        button.setVisibility(0);
        View view2 = this.oq;
        if (view2 != null) {
            view2.setVisibility(0);
        }
    }

    public m j(j jVar) {
        this.xt = jVar;
        return this;
    }

    public m xt(String str) {
        this.ws = str;
        return this;
    }

    public m j(View.OnClickListener onClickListener) {
        this.cw = onClickListener;
        return this;
    }

    public void xt() {
        ViewGroup viewGroup = this.qv;
        if (viewGroup != null) {
            viewGroup.setVisibility(8);
        }
    }

    public m(Context context) {
        super(context);
        this.f31221i = -1;
        this.mi = false;
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        this.vl = context;
    }

    private void up() {
        this.ae = (Button) findViewById(2114387835);
        this.tl = (Button) findViewById(2114387920);
        this.up = (TextView) findViewById(2114387808);
        this.f31223m = (TextView) findViewById(2114387863);
        this.f31224r = (ImageView) findViewById(2114387838);
        this.oq = findViewById(2114387781);
        this.qv = (ViewGroup) findViewById(2114387855);
        this.f31220g = (Button) findViewById(2114387755);
    }

    public m j(String str) {
        this.jy = str;
        return this;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setCanceledOnTouchOutside(false);
        View view = this.kt;
        if (view == null) {
            view = com.bytedance.sdk.openadsdk.res.up.xq(this.vl);
        }
        setContentView(view);
        up();
        r();
        cw();
    }

    @Override // android.app.Dialog
    public void show() {
        try {
            super.show();
            r();
        } catch (Exception unused) {
        }
    }

    public m cw(String str) {
        this.az = str;
        return this;
    }

    public m j(int i6) {
        this.f31221i = i6;
        return this;
    }

    public m j(Drawable drawable) {
        this.f31225w = drawable;
        return this;
    }

    public m j(View view) {
        this.kt = view;
        return this;
    }

    public void j() {
        if (this.qv == null) {
            return;
        }
        if (this.f31222j == null) {
            try {
                this.f31222j = new TTProgressBar(this.vl);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(240, 240);
                layoutParams.gravity = 17;
                this.f31222j.setLayoutParams(layoutParams);
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setColor(Color.parseColor("#77000000"));
                gradientDrawable.setCornerRadius(ed.cw(this.vl, 2.0f));
                this.f31222j.setBackground(gradientDrawable);
                int cw = ed.cw(this.vl, 10.0f);
                this.f31222j.setPadding(cw, cw, cw, cw);
                this.f31222j.setIndeterminateDrawable(kt.cw(this.vl, "tt_video_loading_progress_bar"));
                this.qv.addView(this.f31222j);
            } catch (Exception unused) {
            }
        }
        this.qv.setVisibility(0);
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
    }

    public m r(String str) {
        this.av = str;
        return this;
    }
}
