package com.bytedance.sdk.openadsdk.core.component.reward.layout;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Outline;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.m.av;
import com.bytedance.sdk.component.m.qv;
import com.bytedance.sdk.openadsdk.ats.ATSMethod;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.rn.ed;
import com.bytedance.sdk.openadsdk.core.rn.uf;
import com.bytedance.sdk.openadsdk.core.tj.h;
import com.bytedance.sdk.openadsdk.core.tj.ln;
import com.bytedance.sdk.openadsdk.core.tj.n;
import com.bytedance.sdk.openadsdk.core.v;
import com.bytedance.sdk.openadsdk.upie.image.lottie.UpieImageView;
import com.bytedance.sdk.openadsdk.widget.TTRoundRectImageView;
import java.util.HashMap;

/* loaded from: D:\Downloads\app\classes4.dex */
public class ae extends xt {
    private TextView av;
    private TextView az;

    /* renamed from: i, reason: collision with root package name */
    private TextView f28308i;
    private ImageView jy;

    /* renamed from: w, reason: collision with root package name */
    private UpieImageView f28309w;
    private TTRoundRectImageView ws;

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.layout.xt
    public void j() {
        super.j();
        this.f28349g = (FrameLayout) this.xt.findViewById(2114387921);
        j(this.ae);
        if (com.bytedance.sdk.openadsdk.core.video.cw.j.j(this.cw)) {
            r();
        } else {
            cw();
            xt();
        }
    }

    private void cw() {
        TextView textView;
        this.jy = (ImageView) this.xt.findViewById(2114387718);
        this.ws = (TTRoundRectImageView) this.xt.findViewById(2114387728);
        this.az = (TextView) this.xt.findViewById(2114387708);
        this.av = (TextView) this.xt.findViewById(2114387962);
        this.f28308i = (TextView) this.xt.findViewById(2114387725);
        if (com.bytedance.sdk.openadsdk.up.j.r(this.cw)) {
            UpieImageView upieImageView = new UpieImageView(this.jy.getContext(), com.bytedance.sdk.openadsdk.up.j.g(this.cw), com.bytedance.sdk.openadsdk.up.j.oq(this.cw));
            this.f28309w = upieImageView;
            upieImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        }
        if (!TextUtils.isEmpty(this.cw.sf()) && (textView = this.av) != null) {
            textView.setText(this.cw.sf());
        }
        if (ln.ws(this.cw) == null || !n.xt(this.cw)) {
            j(this.jy, this.f28309w);
            ed.j((View) this.jy, 0);
            ed.j((View) this.f28349g, 8);
        } else {
            ed.j((View) this.jy, 8);
            ed.j((View) this.f28349g, 0);
        }
        h ig = this.cw.ig();
        if (ig != null) {
            com.bytedance.sdk.openadsdk.g.xt.j(ig).j(this.ws);
        }
        TextView textView2 = this.az;
        if (textView2 != null) {
            textView2.setText(ws());
        }
        TextView textView3 = this.f28308i;
        if (textView3 != null) {
            textView3.setText(az());
        }
        ed.j((TextView) this.xt.findViewById(2114387664), this.cw);
    }

    private float m() {
        return ed.r(this.xt, ed.oq((Context) this.xt));
    }

    private void r() {
        this.qv = (RelativeLayout) this.xt.findViewById(2114387850);
        if (com.bytedance.sdk.openadsdk.core.tj.ed.j(this.cw)) {
            String tl = com.bytedance.sdk.openadsdk.core.tj.ed.tl(this.cw);
            if (TextUtils.isEmpty(tl)) {
                return;
            }
            com.bytedance.sdk.openadsdk.g.xt.j(tl).j(Bitmap.Config.ARGB_4444).cw(2).j(new av<Bitmap>() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.layout.ae.2
                @Override // com.bytedance.sdk.component.m.av
                @ATSMethod(2)
                public void j(int i6, String str, Throwable th) {
                }

                @Override // com.bytedance.sdk.component.m.av
                @ATSMethod(1)
                public void j(qv<Bitmap> qvVar) {
                    Bitmap j6 = com.bytedance.sdk.component.adexpress.r.xt.j(ae.this.xt, qvVar.cw(), 25);
                    if (j6 == null) {
                        return;
                    }
                    final BitmapDrawable bitmapDrawable = new BitmapDrawable(ae.this.xt.getResources(), j6);
                    com.bytedance.sdk.openadsdk.l.ae.j(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.layout.ae.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            ViewGroup viewGroup = ae.this.ae;
                            if (viewGroup != null) {
                                viewGroup.setBackground(bitmapDrawable);
                            }
                        }
                    });
                }
            }, 4);
        }
    }

    private float up() {
        return ed.r(this.xt, ed.g((Context) this.xt));
    }

    private void xt() {
        int i6 = (int) (this.up * 1000.0f);
        if (i6 == 666 || i6 == 1500 || i6 == 1777 || i6 == 562 || i6 == 1000) {
            return;
        }
        j(this.f28352r == 1 ? 0.562f : 1.777f);
    }

    public ae(TTBaseVideoActivity tTBaseVideoActivity, n nVar, boolean z5) {
        super(tTBaseVideoActivity, nVar, z5);
    }

    private void j(View view) {
        n nVar = this.cw;
        if (nVar == null || view == null) {
            return;
        }
        final float rf = nVar.rf();
        if (rf <= 0.0f) {
            return;
        }
        view.setOutlineProvider(new ViewOutlineProvider() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.layout.ae.1
            @Override // android.view.ViewOutlineProvider
            public void getOutline(View view2, Outline outline) {
                if (outline == null) {
                    return;
                }
                outline.setRoundRect(0, 0, view2.getWidth(), view2.getHeight(), ed.cw(v.getContext(), rf));
            }
        });
        view.setClipToOutline(true);
    }

    private void j(float f6) {
        float min;
        float max;
        int max2;
        float up = up();
        float m6 = m();
        if (this.f28352r == 2) {
            min = Math.max(up, m6);
            max = Math.min(up, m6);
        } else {
            min = Math.min(up, m6);
            max = Math.max(up, m6);
        }
        int min2 = (int) (Math.min(min, max) * this.cw.bh());
        if (this.f28352r != 2) {
            TTBaseVideoActivity tTBaseVideoActivity = this.xt;
            max -= ed.r(tTBaseVideoActivity, ed.qv((Context) tTBaseVideoActivity));
        }
        if (this.f28352r != 2) {
            float f7 = min2;
            min2 = (int) Math.max((max - (((min - f7) - f7) / f6)) / 2.0f, 0.0f);
            max2 = min2;
        } else {
            float f8 = min2;
            max2 = (int) Math.max((min - (((max - f8) - f8) * f6)) / 2.0f, 0.0f);
        }
        float f9 = min2;
        float f10 = max2;
        try {
            this.xt.getWindow().getDecorView().setPadding(ed.cw(this.xt, f10), ed.cw(this.xt, f9), ed.cw(this.xt, f10), ed.cw(this.xt, f9));
        } catch (Throwable unused) {
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.layout.xt
    public void j(com.bytedance.sdk.openadsdk.core.xt.xt xtVar, com.bytedance.sdk.openadsdk.core.xt.xt xtVar2) {
        ae aeVar;
        if (com.bytedance.sdk.openadsdk.core.video.cw.j.j(this.cw)) {
            TTBaseVideoActivity tTBaseVideoActivity = this.xt;
            n nVar = this.cw;
            String str = this.f28350j;
            final com.bytedance.sdk.openadsdk.core.xt.j jVar = new com.bytedance.sdk.openadsdk.core.xt.j(tTBaseVideoActivity, nVar, str, uf.xt(str));
            FrameLayout frameLayout = this.f28349g;
            if (frameLayout != null) {
                TTBaseVideoActivity tTBaseVideoActivity2 = this.xt;
                n nVar2 = this.cw;
                String str2 = this.f28350j;
                aeVar = this;
                frameLayout.setOnClickListener(new com.bytedance.sdk.openadsdk.core.xt.xt(tTBaseVideoActivity2, nVar2, str2, uf.xt(str2)) { // from class: com.bytedance.sdk.openadsdk.core.component.reward.layout.ae.3
                    @Override // com.bytedance.sdk.openadsdk.core.xt.xt, com.bytedance.sdk.openadsdk.core.xt.r
                    public void j(View view, com.bytedance.sdk.openadsdk.core.tj.qv qvVar) {
                        HashMap hashMap = new HashMap();
                        hashMap.put("click_live_element", "click_live_feed");
                        ((com.bytedance.sdk.openadsdk.core.xt.j.cw.j) jVar.j(com.bytedance.sdk.openadsdk.core.xt.j.cw.j.class)).j(hashMap);
                        jVar.j(view, qvVar);
                    }
                });
            } else {
                aeVar = this;
            }
        } else {
            aeVar = this;
            j(aeVar.f28349g, xtVar, xtVar);
        }
        j(aeVar.jy, xtVar, xtVar);
        j(aeVar.ws, xtVar, xtVar);
        j(aeVar.az, xtVar, xtVar);
        j(aeVar.av, xtVar, xtVar);
        j(aeVar.f28308i, xtVar, xtVar);
        j(aeVar.ae, xtVar, xtVar);
        j(aeVar.f28309w, xtVar, xtVar);
    }

    private void j(View view, com.bytedance.sdk.openadsdk.core.xt.xt xtVar, View.OnTouchListener onTouchListener) {
        if (view == null) {
            return;
        }
        view.setOnTouchListener(onTouchListener);
        view.setOnClickListener(xtVar);
    }
}
