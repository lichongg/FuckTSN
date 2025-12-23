package com.bytedance.sdk.openadsdk.core.component.reward.layout;

import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.kt;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.rn.ed;
import com.bytedance.sdk.openadsdk.core.tj.h;
import com.bytedance.sdk.openadsdk.core.tj.n;
import com.bytedance.sdk.openadsdk.core.widget.vl;
import com.bytedance.sdk.openadsdk.widget.TTRatingBar;
import com.bytedance.sdk.openadsdk.widget.TTRoundRectImageView;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: D:\Downloads\app\classes4.dex */
public class cw extends xt {
    private TextView av;
    private TTRoundRectImageView az;

    /* renamed from: i, reason: collision with root package name */
    private TextView f28313i;
    protected int jy;
    private FrameLayout kt;
    private TTRatingBar mi;
    private FrameLayout tj;

    /* renamed from: w, reason: collision with root package name */
    private TextView f28314w;
    protected final AtomicBoolean ws;

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.layout.xt
    public void j() {
        FrameLayout frameLayout;
        super.j();
        this.tl = (RelativeLayout) this.xt.findViewById(2114387655);
        this.az = (TTRoundRectImageView) this.xt.findViewById(2114387799);
        this.av = (TextView) this.xt.findViewById(2114387881);
        this.f28313i = (TextView) this.xt.findViewById(2114387636);
        this.f28314w = (TextView) this.xt.findViewById(2114387836);
        TTRatingBar tTRatingBar = (TTRatingBar) this.xt.findViewById(2114387615);
        this.mi = tTRatingBar;
        if (tTRatingBar != null) {
            tTRatingBar.setStarEmptyNum(1);
            this.mi.setStarFillNum(4);
            this.mi.setStarImageWidth(ed.cw(this.xt, 15.0f));
            this.mi.setStarImageHeight(ed.cw(this.xt, 14.0f));
            this.mi.setStarImagePadding(ed.cw(this.xt, 4.0f));
            this.mi.j();
        }
        this.oq = (TextView) this.xt.findViewById(2114387664);
        this.f28349g = (FrameLayout) this.xt.findViewById(2114387648);
        this.kt = (FrameLayout) this.xt.findViewById(2114387964);
        this.tj = (FrameLayout) this.xt.findViewById(2114387931);
        ed.j(this.oq, this.cw);
        try {
            if (this.f28352r == 2 && this.cw.kc() == 1 && (this.f28314w.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f28314w.getLayoutParams();
                layoutParams.height = ed.cw(this.xt, 55.0f);
                layoutParams.topMargin = ed.cw(this.xt, 20.0f);
                this.f28314w.setLayoutParams(layoutParams);
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.tl.getLayoutParams();
                layoutParams2.bottomMargin = ed.cw(this.xt, 12.0f);
                this.tl.setLayoutParams(layoutParams2);
            }
        } catch (Throwable unused) {
        }
        if (this.cw.kc() == 1 && (frameLayout = this.f28349g) != null && (frameLayout.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.f28349g.getLayoutParams();
            int r5 = ed.r((Context) this.xt);
            layoutParams3.width = r5;
            int i6 = (r5 * 9) / 16;
            layoutParams3.height = i6;
            this.f28349g.setLayoutParams(layoutParams3);
            this.jy = (ed.up((Context) this.xt) - i6) / 2;
        }
        cw();
        r();
        up();
        m();
        ae();
        qv();
    }

    protected String xt() {
        n nVar = this.cw;
        return nVar == null ? "立即下载" : TextUtils.isEmpty(nVar.sf()) ? this.cw.jl() != 4 ? "查看详情" : "立即下载" : this.cw.sf();
    }

    private void ae() {
        if (this.cw.kc() == 3) {
            int[] iArr = {Color.parseColor("#0070FF")};
            int cw = ed.cw(this.xt, 17.0f);
            int parseColor = Color.parseColor("#80000000");
            vl.j((LinearLayout) this.xt.findViewById(2114387904), new vl.j().j(iArr[0]).xt(parseColor).j(iArr).cw(cw).r(0).up(ed.cw(this.xt, 3.0f)));
        }
    }

    private void cw() {
        if (this.az != null) {
            h ig = this.cw.ig();
            if (ig == null || TextUtils.isEmpty(ig.j())) {
                kt.j((Context) this.xt, "tt_ad_logo_small", (ImageView) this.az);
            } else {
                com.bytedance.sdk.openadsdk.g.xt.j(ig).j(this.az);
            }
        }
        if (this.av != null) {
            if (this.f28352r != 1 || this.cw.by() == null || TextUtils.isEmpty(this.cw.by().cw())) {
                this.av.setText(this.cw.hw());
            } else {
                this.av.setText(this.cw.by().cw());
            }
        }
    }

    private void m() {
        if (this.f28352r == 1) {
            TextView textView = this.av;
            if (textView != null) {
                textView.setMaxWidth(ed.cw(this.xt, 153.0f));
            }
        } else {
            TextView textView2 = this.av;
            if (textView2 != null) {
                textView2.setMaxWidth(ed.cw(this.xt, 404.0f));
            }
        }
        if (this.f28351m) {
            return;
        }
        ed.j((View) this.tl, 0);
    }

    private void r() {
        String valueOf;
        if (this.f28313i == null) {
            return;
        }
        int m6 = this.cw.by() != null ? this.cw.by().m() : 6870;
        if (m6 > 10000) {
            valueOf = (m6 / 10000) + "万";
        } else {
            valueOf = String.valueOf(m6);
        }
        this.f28313i.setText(String.format("%1$s个评分", valueOf));
    }

    /* JADX WARN: Can't wrap try/catch for region: R(14:0|1|(1:3)|4|5|6|(2:10|(7:12|13|14|15|(1:18)|19|(1:21)(4:23|(2:25|(1:(1:28)(1:(1:30))))(2:36|(2:38|(2:46|(1:(1:51)(1:(1:53))))(1:(1:43)(1:(1:45)))))|(1:34)|35)))|58|13|14|15|(1:18)|19|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0044, code lost:
    
        r0 = false;
     */
    /* JADX WARN: Removed duplicated region for block: B:17:0x004a A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0052 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0053  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String tl() {
        /*
            r7 = this;
            com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity r0 = r7.xt
            java.lang.String r0 = com.bytedance.sdk.openadsdk.core.rn.uf.j(r0)
            if (r0 != 0) goto La
            java.lang.String r0 = ""
        La:
            r1 = 1
            r2 = 0
            java.util.Locale r3 = java.util.Locale.CHINESE     // Catch: java.lang.Throwable -> L33
            java.lang.String r3 = r3.getLanguage()     // Catch: java.lang.Throwable -> L33
            boolean r3 = r0.equals(r3)     // Catch: java.lang.Throwable -> L33
            if (r3 != 0) goto L35
            java.util.Locale r3 = java.util.Locale.CHINA     // Catch: java.lang.Throwable -> L33
            java.lang.String r3 = r3.getLanguage()     // Catch: java.lang.Throwable -> L33
            boolean r3 = r0.equals(r3)     // Catch: java.lang.Throwable -> L33
            if (r3 != 0) goto L35
            java.util.Locale r3 = java.util.Locale.TRADITIONAL_CHINESE     // Catch: java.lang.Throwable -> L33
            java.lang.String r3 = r3.getLanguage()     // Catch: java.lang.Throwable -> L33
            boolean r3 = r0.equals(r3)     // Catch: java.lang.Throwable -> L33
            if (r3 == 0) goto L31
            goto L35
        L31:
            r3 = 0
            goto L36
        L33:
            goto L43
        L35:
            r3 = 1
        L36:
            java.util.Locale r4 = java.util.Locale.ENGLISH     // Catch: java.lang.Throwable -> L41
            java.lang.String r4 = r4.getLanguage()     // Catch: java.lang.Throwable -> L41
            boolean r0 = r0.equals(r4)     // Catch: java.lang.Throwable -> L41
            goto L45
        L41:
            goto L44
        L43:
            r3 = 1
        L44:
            r0 = 0
        L45:
            java.lang.String r4 = "下载"
            if (r3 == 0) goto L4a
            goto L4e
        L4a:
            if (r0 == 0) goto L4e
            java.lang.String r4 = "Install"
        L4e:
            com.bytedance.sdk.openadsdk.core.tj.n r5 = r7.cw
            if (r5 != 0) goto L53
            return r4
        L53:
            java.lang.String r5 = r5.sf()
            boolean r5 = android.text.TextUtils.isEmpty(r5)
            if (r5 == 0) goto L70
            com.bytedance.sdk.openadsdk.core.tj.n r1 = r7.cw
            int r1 = r1.jl()
            r2 = 4
            if (r1 == r2) goto Lad
            if (r3 == 0) goto L6b
            java.lang.String r4 = "查看"
            goto Lad
        L6b:
            if (r0 == 0) goto Lad
            java.lang.String r4 = "View"
            goto Lad
        L70:
            com.bytedance.sdk.openadsdk.core.tj.n r4 = r7.cw
            java.lang.String r4 = r4.sf()
            if (r4 == 0) goto Lad
            boolean r5 = com.bytedance.sdk.openadsdk.core.rn.uf.ae(r4)
            if (r5 == 0) goto L93
            int r5 = r4.length()
            r6 = 2
            if (r5 <= r6) goto L93
            if (r3 == 0) goto L8c
            java.lang.String r4 = r7.j(r1)
            goto Lad
        L8c:
            if (r0 == 0) goto Lad
            java.lang.String r4 = r7.j(r2)
            goto Lad
        L93:
            boolean r5 = com.bytedance.sdk.openadsdk.core.rn.uf.ae(r4)
            if (r5 != 0) goto Lad
            int r5 = r4.length()
            r6 = 7
            if (r5 <= r6) goto Lad
            if (r3 == 0) goto La7
            java.lang.String r4 = r7.j(r1)
            goto Lad
        La7:
            if (r0 == 0) goto Lad
            java.lang.String r4 = r7.j(r2)
        Lad:
            if (r0 == 0) goto Lcc
            boolean r0 = com.bytedance.sdk.openadsdk.core.rn.uf.ae(r4)
            if (r0 != 0) goto Lcc
            android.widget.TextView r0 = r7.f28314w
            android.view.ViewGroup$LayoutParams r0 = r0.getLayoutParams()
            android.widget.LinearLayout$LayoutParams r0 = (android.widget.LinearLayout.LayoutParams) r0
            com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity r1 = r7.xt
            r2 = 1082130432(0x40800000, float:4.0)
            int r1 = com.bytedance.sdk.openadsdk.core.rn.ed.cw(r1, r2)
            r0.bottomMargin = r1
            android.widget.TextView r1 = r7.f28314w
            r1.setLayoutParams(r0)
        Lcc:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.component.reward.layout.cw.tl():java.lang.String");
    }

    private void up() {
        TextView textView = this.f28314w;
        if (textView != null) {
            textView.setText(this.cw.kc() == 3 ? tl() : xt());
        }
    }

    public cw(TTBaseVideoActivity tTBaseVideoActivity, n nVar, boolean z5) {
        super(tTBaseVideoActivity, nVar, z5);
        this.jy = 0;
        this.ws = new AtomicBoolean(false);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.layout.xt
    public void xt(int i6) {
        int i7;
        if (this.tl == null || (i7 = this.vl) == -1 || i6 != i7 || this.ws.getAndSet(true)) {
            return;
        }
        ed.j((View) this.tl, 0);
        Keyframe ofFloat = Keyframe.ofFloat(0.0f, 0.0f);
        Keyframe ofFloat2 = Keyframe.ofFloat(0.65f, 1.0f);
        Keyframe ofFloat3 = Keyframe.ofFloat(0.765f, 0.9f);
        Keyframe ofFloat4 = Keyframe.ofFloat(0.88f, 1.0f);
        Keyframe ofFloat5 = Keyframe.ofFloat(0.95f, 0.95f);
        Keyframe ofFloat6 = Keyframe.ofFloat(1.0f, 1.0f);
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.tl, PropertyValuesHolder.ofKeyframe("scaleX", ofFloat, ofFloat2, ofFloat3, ofFloat4, ofFloat5, ofFloat6), PropertyValuesHolder.ofKeyframe("scaleY", ofFloat, ofFloat2, ofFloat3, ofFloat4, ofFloat5, ofFloat6));
        ofPropertyValuesHolder.setDuration(1000L);
        ofPropertyValuesHolder.start();
    }

    private String j(boolean z5) {
        n nVar = this.cw;
        if (nVar == null) {
            return null;
        }
        return z5 ? nVar.jl() == 4 ? "下载" : "查看" : nVar.jl() == 4 ? "Install" : "View";
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.layout.xt
    public void j(com.bytedance.sdk.openadsdk.core.xt.xt xtVar, com.bytedance.sdk.openadsdk.core.xt.xt xtVar2) {
        FrameLayout frameLayout;
        FrameLayout frameLayout2;
        n nVar = this.cw;
        if (nVar != null && nVar.aq() != null) {
            if (this.cw.aq().up) {
                ed.j((View) this.f28314w, (View.OnClickListener) xtVar, (String) null);
                ed.j((View) this.f28314w, (View.OnTouchListener) xtVar, (String) null);
            } else {
                ed.j((View) this.f28314w, (View.OnClickListener) xtVar2, (String) null);
                ed.j((View) this.f28314w, (View.OnTouchListener) xtVar2, (String) null);
            }
            if (this.cw.kc() == 1) {
                if (this.cw.aq().f30271j) {
                    j((View.OnTouchListener) xtVar);
                    j((View.OnClickListener) xtVar);
                } else {
                    j((View.OnTouchListener) xtVar2);
                    j((View.OnClickListener) xtVar2);
                }
            } else if (this.cw.aq().cw) {
                ed.j((View) this.tl, (View.OnClickListener) xtVar, "TTBaseVideoActivity#mRlDownloadBar");
                ed.j((View) this.tl, (View.OnTouchListener) xtVar, "TTBaseVideoActivity#mRlDownloadBar");
            } else {
                ed.j((View) this.tl, (View.OnClickListener) xtVar2, "TTBaseVideoActivity#mRlDownloadBar");
                ed.j((View) this.tl, (View.OnTouchListener) xtVar2, (String) null);
            }
        }
        n nVar2 = this.cw;
        if (nVar2 != null && nVar2.aq() != null) {
            if (this.cw.aq().f30272m) {
                ed.j((View) this.f28349g, (View.OnClickListener) xtVar, "TTBaseVideoActivity#mVideoNativeFrame");
                ed.j((View) this.f28349g, (View.OnTouchListener) xtVar, "TTBaseVideoActivity#mVideoNativeFrame");
            } else {
                ed.j((View) this.f28349g, (View.OnClickListener) xtVar2, "TTBaseVideoActivity#mVideoNativeFrame");
                ed.j((View) this.f28349g, (View.OnTouchListener) xtVar2, "TTBaseVideoActivity#mVideoNativeFrame");
            }
        }
        n nVar3 = this.cw;
        if (nVar3 == null || nVar3.kc() != 1) {
            return;
        }
        if (this.cw.aq() != null && (frameLayout2 = this.kt) != null) {
            ed.j((View) frameLayout2, 0);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.kt.getLayoutParams();
            layoutParams.height = this.jy;
            this.kt.setLayoutParams(layoutParams);
            if (this.cw.aq().xt) {
                this.kt.setOnClickListener(xtVar);
                this.kt.setOnTouchListener(xtVar);
            } else {
                this.kt.setOnClickListener(xtVar2);
                this.kt.setOnTouchListener(xtVar2);
            }
        }
        if (this.cw.aq() == null || (frameLayout = this.tj) == null) {
            return;
        }
        ed.j((View) frameLayout, 0);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.tj.getLayoutParams();
        layoutParams2.height = this.jy;
        this.tj.setLayoutParams(layoutParams2);
        if (this.cw.aq().f30273r) {
            this.tj.setOnClickListener(xtVar);
            this.tj.setOnTouchListener(xtVar);
        } else {
            this.tj.setOnClickListener(xtVar2);
            this.tj.setOnTouchListener(xtVar2);
        }
    }

    private void j(View.OnTouchListener onTouchListener) {
        ed.j(this.tl, onTouchListener, "TTBaseVideoActivity#mRlDownloadBar");
        ed.j(this.av, onTouchListener, (String) null);
        ed.j(this.az, onTouchListener, (String) null);
        ed.j(this.f28313i, onTouchListener, (String) null);
        ed.j(this.mi, onTouchListener, (String) null);
    }

    private void j(View.OnClickListener onClickListener) {
        ed.j(this.tl, onClickListener, "TTBaseVideoActivity#mRlDownloadBar");
        ed.j(this.av, onClickListener, (String) null);
        ed.j(this.az, onClickListener, (String) null);
        ed.j(this.f28313i, onClickListener, (String) null);
        ed.j(this.mi, onClickListener, (String) null);
    }
}
