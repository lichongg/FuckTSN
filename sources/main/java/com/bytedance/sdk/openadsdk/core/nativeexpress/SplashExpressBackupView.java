package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.activity.k;
import com.bykv.vk.openvk.component.video.api.r.cw;
import com.bytedance.sdk.component.adexpress.widget.GifView;
import com.bytedance.sdk.openadsdk.core.rn.ed;
import com.bytedance.sdk.openadsdk.core.tj.h;
import com.bytedance.sdk.openadsdk.core.tj.ln;
import com.bytedance.sdk.openadsdk.core.tj.n;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView;
import com.bytedance.sdk.openadsdk.upie.image.lottie.UpieImageView;

/* loaded from: D:\Downloads\app\classes4.dex */
public class SplashExpressBackupView extends BackupView implements cw.InterfaceC0306cw {
    private TextView av;
    private GifView az;

    /* renamed from: i, reason: collision with root package name */
    private Button f29638i;
    private NativeExpressView jy;
    private NativeVideoTsView kt;
    private com.bytedance.sdk.openadsdk.core.v.j.xt mi;
    private cw.InterfaceC0306cw tj;

    /* renamed from: w, reason: collision with root package name */
    private FrameLayout f29639w;
    private View ws;

    @Override // com.bykv.vk.openvk.component.video.api.r.cw.InterfaceC0306cw
    public void j(long j6, long j7) {
    }

    private boolean ae() {
        NativeExpressView nativeExpressView = this.jy;
        if (nativeExpressView instanceof NativeExpressVideoView) {
            return false;
        }
        k.a(nativeExpressView);
        return true;
    }

    private void jy() {
        GifView gifView = new GifView(this.f29586j);
        gifView.setScaleType(ImageView.ScaleType.FIT_XY);
        j(gifView, this.xt, this.mi);
        addView(gifView, new ViewGroup.LayoutParams(-1, -1));
        setExpressBackupListener(this);
    }

    private void setExpressBackupListener(View view) {
        n nVar = this.xt;
        if (nVar == null || nVar.im() != 1) {
            return;
        }
        j(view, true);
    }

    private boolean tl() {
        n nVar = this.xt;
        return nVar != null && nVar.zw() == 2;
    }

    private void vl() {
        NativeVideoTsView nativeVideoTsView = (NativeVideoTsView) j(this.jy);
        this.kt = nativeVideoTsView;
        nativeVideoTsView.setVideoAdInteractionListener(this);
        NativeVideoTsView nativeVideoTsView2 = this.kt;
        if (nativeVideoTsView2 == null) {
            return;
        }
        addView(nativeVideoTsView2);
        setExpressBackupListener(this);
    }

    private void ws() {
        View j6 = j(this.f29586j);
        if (j6 == null) {
            return;
        }
        addView(j6);
    }

    public com.bykv.vk.openvk.component.video.api.r.cw getVideoController() {
        NativeVideoTsView nativeVideoTsView = this.kt;
        if (nativeVideoTsView == null) {
            return null;
        }
        return nativeVideoTsView.getNativeVideoController();
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.BackupView
    protected void j(View view, int i6, com.bytedance.sdk.openadsdk.core.tj.x xVar) {
        NativeExpressView nativeExpressView = this.jy;
        if (nativeExpressView != null) {
            nativeExpressView.j(view, i6, xVar);
        }
    }

    public void setVideoAdListener(cw.InterfaceC0306cw interfaceC0306cw) {
        this.tj = interfaceC0306cw;
    }

    @Override // com.bykv.vk.openvk.component.video.api.r.cw.InterfaceC0306cw
    public void t_() {
        cw.InterfaceC0306cw interfaceC0306cw = this.tj;
        if (interfaceC0306cw != null) {
            interfaceC0306cw.t_();
        }
    }

    public SplashExpressBackupView(Context context) {
        super(context);
        this.f29586j = context;
        this.up = "splash_ad";
    }

    private void g() {
        ws();
        this.az.setVisibility(0);
        this.f29639w.setVisibility(8);
        ViewGroup.LayoutParams layoutParams = this.az.getLayoutParams();
        layoutParams.height = ed.cw(this.f29586j, 291.0f);
        this.az.setLayoutParams(layoutParams);
        j(this.az, this.xt, this.mi);
        this.av.setText(this.xt.zk());
        if (this.xt.gr() != null) {
            ed.j((View) this.f29638i, 8);
        } else {
            ed.j((View) this.f29638i, 0);
            this.f29638i.setText(this.xt.sf());
            j((View) this.f29638i, true);
        }
        setExpressBackupListener(this.ws);
    }

    private void m() {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(this.f29587m, this.ae);
        }
        layoutParams.width = this.f29587m;
        layoutParams.height = this.ae;
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            ((FrameLayout.LayoutParams) layoutParams).gravity = 17;
        }
        setLayoutParams(layoutParams);
        j(this.xt.ve(), this.xt);
    }

    private void oq() {
        ws();
        this.az.setVisibility(0);
        this.f29639w.setVisibility(8);
        j(this.az, this.xt, this.mi);
        this.av.setText(this.xt.zk());
        if (this.xt.gr() != null) {
            ed.j((View) this.f29638i, 8);
        } else {
            ed.j((View) this.f29638i, 0);
            this.f29638i.setText(this.xt.sf());
            j((View) this.f29638i, true);
        }
        setExpressBackupListener(this.ws);
    }

    private void qv() {
        ws();
        this.az.setVisibility(8);
        this.f29639w.setVisibility(0);
        if (ln.ws(this.xt) != null) {
            NativeVideoTsView nativeVideoTsView = (NativeVideoTsView) j(this.jy);
            this.kt = nativeVideoTsView;
            nativeVideoTsView.setVideoAdInteractionListener(this);
            if (this.kt == null) {
                return;
            }
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            layoutParams.gravity = 17;
            this.f29639w.addView(this.kt, layoutParams);
        }
        this.av.setText(this.xt.zk());
        if (this.xt.gr() != null) {
            ed.j((View) this.f29638i, 8);
        } else {
            ed.j((View) this.f29638i, 0);
            this.f29638i.setText(this.xt.sf());
            j((View) this.f29638i, true);
        }
        setExpressBackupListener(this.ws);
    }

    public void j(com.bytedance.sdk.openadsdk.core.v.j.xt xtVar, n nVar, NativeExpressView nativeExpressView) {
        this.xt = nVar;
        this.jy = nativeExpressView;
        this.f29587m = ed.cw(this.f29586j, nativeExpressView.getExpectExpressWidth());
        this.ae = ed.cw(this.f29586j, this.jy.getExpectExpressWidth());
        this.mi = xtVar;
        m();
        this.jy.addView(this, new ViewGroup.LayoutParams(-1, -1));
    }

    private void j(int i6, n nVar) {
        if (!ae()) {
            if (i6 != 5) {
                vl();
                return;
            } else {
                qv();
                return;
            }
        }
        if (i6 != 2) {
            if (i6 != 3) {
                if (i6 != 4) {
                    if (i6 != 5) {
                        jy();
                        return;
                    }
                }
            }
            if (tl()) {
                jy();
                return;
            } else {
                oq();
                return;
            }
        }
        g();
    }

    private View j(Context context) {
        if (context == null) {
            return null;
        }
        Resources resources = context.getResources();
        LinearLayout linearLayout = new LinearLayout(context);
        ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(layoutParams);
        com.bytedance.sdk.component.utils.kt.j(context, "tt_splash_ad_backup_bg", linearLayout);
        TextView textView = new TextView(context);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.topMargin = ed.cw(context, 79.0f);
        textView.setLayoutParams(layoutParams2);
        textView.setText(com.bytedance.sdk.component.utils.kt.j(context, "tt_splash_backup_ad_title"));
        textView.setGravity(17);
        textView.setTextSize(2, 30.0f);
        textView.setTypeface(Typeface.defaultFromStyle(1));
        textView.setTextColor(Color.parseColor("#895434"));
        linearLayout.addView(textView);
        TextView textView2 = new TextView(context);
        this.av = textView2;
        textView2.setId(2114387477);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams((int) TypedValue.applyDimension(1, 218.0f, resources.getDisplayMetrics()), -2);
        layoutParams3.topMargin = ed.cw(context, 31.0f);
        layoutParams3.gravity = 1;
        this.av.setLayoutParams(layoutParams3);
        this.av.setGravity(1);
        this.av.setTextSize(2, 15.0f);
        this.av.setTextColor(Color.parseColor("#895434"));
        this.av.setSingleLine(false);
        linearLayout.addView(this.av);
        GifView gifView = new GifView(context);
        this.az = gifView;
        gifView.setId(2114387476);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, (int) TypedValue.applyDimension(1, 219.0f, resources.getDisplayMetrics()));
        layoutParams4.topMargin = ed.cw(context, 29.0f);
        layoutParams4.setMarginStart(ed.cw(context, 15.0f));
        layoutParams4.setMarginEnd(ed.cw(context, 15.0f));
        layoutParams4.gravity = 1;
        this.az.setLayoutParams(layoutParams4);
        this.az.setScaleType(ImageView.ScaleType.FIT_XY);
        linearLayout.addView(this.az);
        FrameLayout frameLayout = new FrameLayout(context);
        this.f29639w = frameLayout;
        frameLayout.setId(2114387475);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-1, (int) TypedValue.applyDimension(1, 185.0f, resources.getDisplayMetrics()));
        layoutParams5.setMarginStart(ed.cw(context, 15.0f));
        layoutParams5.setMarginEnd(ed.cw(context, 15.0f));
        this.f29639w.setLayoutParams(layoutParams5);
        this.f29639w.setVisibility(8);
        linearLayout.addView(this.f29639w);
        Button button = new Button(context);
        this.f29638i = button;
        button.setId(2114387474);
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams((int) TypedValue.applyDimension(1, 145.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 43.0f, resources.getDisplayMetrics()));
        layoutParams6.topMargin = ed.cw(context, 37.0f);
        layoutParams6.gravity = 1;
        this.f29638i.setLayoutParams(layoutParams6);
        this.f29638i.setText(com.bytedance.sdk.component.utils.kt.j(context, "tt_splash_backup_ad_btn"));
        this.f29638i.setTextColor(Color.parseColor("#ffffff"));
        this.f29638i.setTypeface(Typeface.defaultFromStyle(1));
        com.bytedance.sdk.component.utils.kt.j(context, "tt_splash_ad_backup_btn_bg", this.f29638i);
        linearLayout.addView(this.f29638i);
        return linearLayout;
    }

    @Override // com.bykv.vk.openvk.component.video.api.r.cw.InterfaceC0306cw
    public void q_() {
    }

    @Override // com.bykv.vk.openvk.component.video.api.r.cw.InterfaceC0306cw
    public void r_() {
    }

    @Override // com.bykv.vk.openvk.component.video.api.r.cw.InterfaceC0306cw
    public void s_() {
    }

    private void j(GifView gifView) {
        h hVar = this.xt.fp().get(0);
        if (hVar != null) {
            com.bytedance.sdk.openadsdk.g.xt.j(hVar).j(gifView);
        }
        if (com.bytedance.sdk.openadsdk.up.j.r(this.xt)) {
            UpieImageView upieImageView = new UpieImageView(gifView.getContext(), com.bytedance.sdk.openadsdk.up.j.g(this.xt), com.bytedance.sdk.openadsdk.up.j.oq(this.xt));
            upieImageView.setScaleType(ImageView.ScaleType.FIT_XY);
            com.bytedance.sdk.openadsdk.up.j.j(gifView, upieImageView);
        }
    }

    void j(byte[] bArr, GifView gifView) {
        if (bArr == null || gifView == null) {
            return;
        }
        gifView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        gifView.j(bArr, false);
    }

    void j(Drawable drawable, GifView gifView) {
        if (drawable == null || gifView == null) {
            return;
        }
        gifView.setImageDrawable(drawable);
    }

    void j(GifView gifView, n nVar, com.bytedance.sdk.openadsdk.core.v.j.xt xtVar) {
        Drawable j6;
        if (xtVar == null) {
            j(gifView);
            return;
        }
        if (xtVar.up()) {
            j(xtVar.cw(), gifView);
            return;
        }
        if (nVar.fp() == null || nVar.fp().get(0) == null) {
            return;
        }
        if (xtVar.j() != null) {
            j6 = new BitmapDrawable(xtVar.j());
        } else {
            j6 = com.bytedance.sdk.openadsdk.core.rn.i.j(xtVar.cw(), nVar.fp().get(0).xt());
        }
        j(j6, gifView);
        if (com.bytedance.sdk.openadsdk.up.j.r(this.xt)) {
            UpieImageView upieImageView = new UpieImageView(gifView.getContext(), com.bytedance.sdk.openadsdk.up.j.g(this.xt), com.bytedance.sdk.openadsdk.up.j.oq(this.xt));
            upieImageView.setScaleType(ImageView.ScaleType.FIT_XY);
            com.bytedance.sdk.openadsdk.up.j.j(gifView, upieImageView);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.BackupView
    protected void j(View view, boolean z5) {
        n nVar = this.xt;
        if (nVar == null || nVar.gr() == null || this.xt.gr().j() != 1) {
            return;
        }
        super.j(view, z5);
    }
}
