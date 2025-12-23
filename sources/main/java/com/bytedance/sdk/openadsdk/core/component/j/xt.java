package com.bytedance.sdk.openadsdk.core.component.j;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.component.utils.ws;
import com.bytedance.sdk.openadsdk.core.f;
import com.bytedance.sdk.openadsdk.core.f.r;
import com.bytedance.sdk.openadsdk.core.rn.ed;
import com.bytedance.sdk.openadsdk.core.rn.uf;
import com.bytedance.sdk.openadsdk.core.tj.n;
import com.bytedance.sdk.openadsdk.core.v;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeDrawVideoTsView;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView;
import com.bytedance.sdk.openadsdk.i.cw.xt.jy;
import com.bytedance.sdk.openadsdk.l.ae;
import com.bytedance.sdk.openadsdk.mediation.MediationNativeManagerDefault;
import com.bytedance.sdk.openadsdk.mediation.manager.j.xt.j.up;
import com.bytedance.sdk.openadsdk.res.layout.LazeLayout;
import com.bytedance.sdk.openadsdk.upie.image.lottie.UpieImageView;
import java.lang.ref.WeakReference;
import java.util.List;

/* loaded from: D:\Downloads\app\classes4.dex */
public class xt extends com.bytedance.sdk.openadsdk.i.cw.j implements LazeLayout.j<NativeVideoTsView>, com.bytedance.sdk.openadsdk.res.layout.j<NativeVideoTsView> {
    private final n ae;
    private int cw;

    /* renamed from: g, reason: collision with root package name */
    private LazeLayout f28045g;

    /* renamed from: j, reason: collision with root package name */
    private boolean f28046j;

    /* renamed from: m, reason: collision with root package name */
    private final Context f28047m;
    private volatile WeakReference<NativeVideoTsView> oq;
    private com.bytedance.sdk.openadsdk.ch.j.xt.j.j qv;

    /* renamed from: r, reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.f.j.xt.j.j f28048r;
    private com.bytedance.sdk.openadsdk.i.cw.cw.xt tl;
    private cw up;
    private Bitmap xt;

    public xt(Context context, n nVar, int i6, com.bytedance.sdk.openadsdk.i.cw.cw.xt xtVar) {
        super(new cw(context, nVar, i6, xtVar));
        this.f28045g = null;
        this.oq = null;
        this.qv = new com.bytedance.sdk.openadsdk.ch.j.xt.j.j(null) { // from class: com.bytedance.sdk.openadsdk.core.component.j.xt.3
            @Override // com.bytedance.sdk.openadsdk.ch.j.xt.j.j
            public void j(View view, jy jyVar) {
                NativeVideoTsView s5 = xt.this.up.s();
                if (s5 != null) {
                    s5.oq();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.ch.j.xt.j.j
            public void xt(View view, jy jyVar) {
                NativeVideoTsView s5 = xt.this.up.s();
                if (s5 != null) {
                    s5.oq();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.ch.j.xt.j.j
            public void j(jy jyVar) {
                NativeVideoTsView s5 = xt.this.up.s();
                if (s5 != null) {
                    s5.mi();
                }
            }
        };
        this.tl = xtVar;
        cw cwVar = (cw) s();
        this.up = cwVar;
        this.ae = nVar;
        this.f28047m = context;
        ((r) cwVar.gq()).j(this.qv);
    }

    private void l() {
        int i6 = this.cw;
        if (i6 >= 200) {
            this.cw = 200;
        } else if (i6 <= 20) {
            this.cw = 20;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.jy
    public up ch() {
        return new MediationNativeManagerDefault();
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.j, com.bytedance.sdk.openadsdk.i.cw.xt.jy
    public View tj() {
        NativeVideoTsView nativeVideoTsView = null;
        if (this.ae == null || this.f28047m == null) {
            return null;
        }
        if (this.up.h()) {
            if (!ae.j()) {
                try {
                    nativeVideoTsView = xt(this.f28047m);
                } catch (Throwable unused) {
                }
                if (nativeVideoTsView != null) {
                    j(nativeVideoTsView);
                }
                return nativeVideoTsView;
            }
            this.f28045g = new LazeLayout(this.f28047m, this, this);
        } else if (com.bytedance.sdk.openadsdk.up.j.tl(this.ae)) {
            return new UpieImageView(this.f28047m, com.bytedance.sdk.openadsdk.up.j.g(this.ae), null);
        }
        com.bytedance.sdk.openadsdk.core.ae.r.j().j(this.ae).j(this.up.a()).xt(this.up.l());
        return this.f28045g;
    }

    @Override // com.bytedance.sdk.openadsdk.res.layout.j
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public NativeVideoTsView xt(Context context) {
        NativeVideoTsView j6 = this.up.j(true);
        j6.setControllerStatusCallBack(new NativeVideoTsView.r() { // from class: com.bytedance.sdk.openadsdk.core.component.j.xt.1
            @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView.r
            public void j(boolean z5, long j7, long j8, long j9, boolean z6, boolean z7) {
                xt.this.up.f28028j.f29581j = z5;
                xt.this.up.f28028j.up = j7;
                xt.this.up.f28028j.f29582m = j8;
                xt.this.up.f28028j.ae = j9;
                xt.this.up.f28028j.f29583r = z6;
                xt.this.up.f28028j.tl = z7;
            }
        });
        j6.setAdCreativeClickListener(new NativeVideoTsView.j() { // from class: com.bytedance.sdk.openadsdk.core.component.j.xt.2
            @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView.j
            public void j(View view, int i6) {
                f r5 = ((r) xt.this.up.gq()).r();
                if (r5 != null) {
                    r5.j(view, i6);
                }
            }
        });
        j6.setVideoAdLoadListener(this.up);
        j6.setVideoAdInteractionListener(this.up);
        int g6 = uf.g(this.ae);
        j6.setIsAutoPlay(j(g6));
        j6.setIsQuiet(v.xt().r(g6));
        NativeDrawVideoTsView nativeDrawVideoTsView = (NativeDrawVideoTsView) j6;
        nativeDrawVideoTsView.setCanInterruptVideoPlay(this.f28046j);
        Bitmap bitmap = this.xt;
        if (bitmap != null) {
            nativeDrawVideoTsView.j(bitmap, this.cw);
        }
        j6.setDrawVideoListener(this.f28048r);
        this.oq = new WeakReference<>(j6);
        return j6;
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.j, com.bytedance.sdk.openadsdk.i.cw.xt.jy
    public void x() {
        NativeVideoTsView nativeVideoTsView;
        super.x();
        if (this.oq != null && (nativeVideoTsView = this.oq.get()) != null) {
            nativeVideoTsView.mi();
        }
        LazeLayout lazeLayout = this.f28045g;
        if (lazeLayout != null) {
            lazeLayout.j();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.res.layout.LazeLayout.j
    public void j(NativeVideoTsView nativeVideoTsView) {
        if (nativeVideoTsView != null) {
            nativeVideoTsView.j(0L, true, false);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.jy
    public void j(Activity activity, ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, com.bytedance.sdk.openadsdk.ch.j.xt.j.j jVar, com.bytedance.sdk.openadsdk.mediation.ad.j.xt.j.r rVar) {
        View tj;
        try {
            j(viewGroup, (List<View>) null, list, list2, list3, (View) null, jVar);
            if (rVar != null) {
                View findViewById = viewGroup.findViewById(rVar.vl());
                if (findViewById != null && m() != null) {
                    findViewById.setVisibility(0);
                    if (findViewById instanceof ViewGroup) {
                        ((ViewGroup) findViewById).removeAllViews();
                        ImageView imageView = new ImageView(viewGroup.getContext());
                        imageView.setImageBitmap(m());
                        imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                        ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
                        layoutParams.width = ed.cw(viewGroup.getContext(), 38.0f);
                        layoutParams.height = ed.cw(viewGroup.getContext(), 38.0f);
                        findViewById.setLayoutParams(layoutParams);
                        ((ViewGroup) findViewById).addView(imageView, -1, -1);
                    } else if (findViewById instanceof ImageView) {
                        ((ImageView) findViewById).setImageBitmap(m());
                    }
                }
                FrameLayout frameLayout = (FrameLayout) viewGroup.findViewById(rVar.ae());
                if (frameLayout != null && (tj = tj()) != null) {
                    ed.tl(tj);
                    frameLayout.removeAllViews();
                    frameLayout.addView(tj, -1, -1);
                }
            }
        } catch (Throwable th) {
            vl.j(th);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.jy
    public void j(com.bytedance.sdk.openadsdk.ch.j.xt.j.xt xtVar) {
        cw cwVar = this.up;
        if (cwVar != null) {
            cwVar.j(xtVar);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.g
    public void j(boolean z5) {
        this.f28046j = z5;
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.g
    public void j(Bitmap bitmap, int i6) {
        this.xt = bitmap;
        this.cw = i6;
        l();
    }

    private boolean j(int i6) {
        int ae = v.xt().ae(i6);
        if (3 == ae) {
            return false;
        }
        if (1 != ae || !ws.r(this.f28047m)) {
            if (2 == ae) {
                if (!ws.up(this.f28047m) && !ws.r(this.f28047m)) {
                    ws.m(this.f28047m);
                }
                return true;
            }
            if (5 == ae && !ws.r(this.f28047m)) {
                ws.m(this.f28047m);
            }
        }
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.g
    public void j(com.bytedance.sdk.openadsdk.f.j.xt.j.j jVar) {
        this.f28048r = jVar;
    }
}
