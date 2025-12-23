package com.bytedance.msdk.cw.r;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.msdk.core.views.RefreshableBannerView;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: D:\Downloads\app\classes3.dex */
public class qv {
    private final Handler ae;
    private final Runnable av;
    private final com.bytedance.msdk.api.r.j.j.j az;
    private com.bytedance.msdk.api.j.xt cw;

    /* renamed from: g, reason: collision with root package name */
    private com.bytedance.msdk.api.r.j.j.j f25072g;

    /* renamed from: m, reason: collision with root package name */
    private RefreshableBannerView f25074m;
    private com.bytedance.msdk.api.r.j.j.r oq;

    /* renamed from: r, reason: collision with root package name */
    private m f25075r;
    private final Handler tl;
    private m up;
    private final View.OnAttachStateChangeListener ws;
    private final SoftReference<Context> xt;

    /* renamed from: j, reason: collision with root package name */
    private int f25073j = 0;
    private SoftReference<Activity> qv = new SoftReference<>(null);
    private SoftReference<com.bytedance.sdk.openadsdk.kt.j.xt.j.j> vl = new SoftReference<>(null);
    private SoftReference<Map<String, Object>> jy = new SoftReference<>(null);

    /* renamed from: com.bytedance.msdk.cw.r.qv$3, reason: invalid class name */
    class AnonymousClass3 implements Runnable {
        AnonymousClass3() {
        }

        @Override // java.lang.Runnable
        public void run() {
            qv.this.tl.post(new Runnable() { // from class: com.bytedance.msdk.cw.r.qv.3.1
                @Override // java.lang.Runnable
                public void run() {
                    if (qv.this.f25073j == 0 || qv.this.up == null) {
                        return;
                    }
                    View j6 = qv.this.up.j((Context) qv.this.xt.get());
                    if (j6 != null) {
                        qv qvVar = qv.this;
                        qvVar.j(qvVar.up);
                        if (qv.this.f25074m != null) {
                            qv.this.f25074m.j(j6);
                        }
                        qv.this.tl.postDelayed(new Runnable() { // from class: com.bytedance.msdk.cw.r.qv.3.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (qv.this.f25075r != null) {
                                    qv.this.f25075r.j();
                                }
                                qv qvVar2 = qv.this;
                                qvVar2.f25075r = qvVar2.up;
                                qv.this.i();
                            }
                        }, 250L);
                    } else {
                        if (qv.this.up != null) {
                            qv.this.up.j();
                        }
                        qv.this.i();
                    }
                    qv.this.az();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void av() {
        this.ae.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void az() {
        this.ae.removeCallbacksAndMessages(null);
        this.ae.postDelayed(this.av, this.f25073j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        Context context;
        SoftReference<Context> softReference = this.xt;
        if (softReference == null || (context = softReference.get()) == null) {
            return;
        }
        m mVar = new m(context);
        this.up = mVar;
        mVar.j(this.az);
        this.up.j(this.oq);
        j(this.cw);
        this.up.j(this.cw, (com.bytedance.msdk.api.r.j.j.xt) null);
    }

    public Map<String, Object> ae() {
        m mVar = this.f25075r;
        return mVar != null ? mVar.w() : new HashMap();
    }

    public void cw() {
        this.tl.removeCallbacksAndMessages(null);
        av();
        RefreshableBannerView refreshableBannerView = this.f25074m;
        if (refreshableBannerView != null) {
            refreshableBannerView.removeOnAttachStateChangeListener(this.ws);
        }
        m mVar = this.f25075r;
        if (mVar != null) {
            mVar.j();
        }
        m mVar2 = this.up;
        if (mVar2 != null) {
            mVar2.j();
        }
    }

    public List<com.bytedance.msdk.api.cw> g() {
        m mVar = this.f25075r;
        if (mVar != null) {
            return mVar.qv();
        }
        return null;
    }

    public int jy() {
        m mVar = this.f25075r;
        if (mVar != null) {
            return mVar.i();
        }
        return -1;
    }

    public int m() {
        m mVar = this.f25075r;
        if (mVar != null) {
            return mVar.r();
        }
        return 0;
    }

    public com.bytedance.msdk.api.cw oq() {
        m mVar = this.f25075r;
        if (mVar != null) {
            return mVar.av();
        }
        return null;
    }

    public List<com.bytedance.msdk.api.cw> qv() {
        m mVar = this.f25075r;
        if (mVar != null) {
            return mVar.vl();
        }
        return null;
    }

    public boolean r() {
        m mVar = this.f25075r;
        if (mVar != null) {
            return mVar.cw();
        }
        return false;
    }

    public List<com.bytedance.msdk.api.xt> tl() {
        m mVar = this.f25075r;
        return mVar != null ? mVar.oq() : new ArrayList();
    }

    @Nullable
    public View up() {
        m mVar = this.f25075r;
        if (mVar == null) {
            return null;
        }
        View j6 = mVar.j(this.xt.get());
        m mVar2 = this.f25075r;
        mVar2.j(mVar2.f25123r);
        if (j6 == null || this.f25074m == null) {
            return null;
        }
        j6.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.bytedance.msdk.cw.r.qv.5
            @Override // android.view.View.OnLayoutChangeListener
            public void onLayoutChange(View view, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13) {
                if (view.getVisibility() == 0) {
                    qv qvVar = qv.this;
                    qvVar.j(qvVar.f25075r);
                    view.removeOnLayoutChangeListener(this);
                }
            }
        });
        this.f25074m.removeAllViews();
        ViewParent parent = j6.getParent();
        if (parent != null && (parent instanceof ViewGroup)) {
            ((ViewGroup) parent).removeView(j6);
        }
        this.f25074m.addView(j6);
        return this.f25074m;
    }

    public com.bytedance.msdk.api.cw vl() {
        m mVar = this.f25075r;
        if (mVar != null) {
            return mVar.az();
        }
        return null;
    }

    public com.bytedance.sdk.openadsdk.i.cw.xt.r ws() {
        m mVar = this.f25075r;
        if (mVar != null) {
            return mVar.tj();
        }
        return null;
    }

    public qv(Context context) {
        View.OnAttachStateChangeListener onAttachStateChangeListener = new View.OnAttachStateChangeListener() { // from class: com.bytedance.msdk.cw.r.qv.1
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
                if (qv.this.f25073j == 0) {
                    return;
                }
                qv.this.i();
                qv.this.az();
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
                qv.this.av();
            }
        };
        this.ws = onAttachStateChangeListener;
        this.az = new com.bytedance.msdk.api.r.j.j.j() { // from class: com.bytedance.msdk.cw.r.qv.2
            @Override // com.bytedance.msdk.api.r.j.j.j
            public void j(View view) {
                if (qv.this.f25072g != null) {
                    qv.this.f25072g.j(view);
                }
            }

            @Override // com.bytedance.msdk.api.r.j.j.j
            public void f_() {
                qv.this.av();
                if (qv.this.f25072g != null) {
                    qv.this.f25072g.f_();
                }
            }

            @Override // com.bytedance.msdk.api.r.j.j.j
            public void xt(View view) {
                if (qv.this.f25072g != null) {
                    qv.this.f25072g.xt(view);
                }
            }

            @Override // com.bytedance.msdk.api.r.j.j.j
            public void j(com.bytedance.msdk.api.j jVar) {
                if (qv.this.f25072g != null) {
                    qv.this.f25072g.j(jVar);
                }
            }
        };
        this.av = new AnonymousClass3();
        this.xt = new SoftReference<>(context);
        this.f25075r = new m(context);
        if (context != null) {
            RefreshableBannerView refreshableBannerView = new RefreshableBannerView(context);
            this.f25074m = refreshableBannerView;
            refreshableBannerView.addOnAttachStateChangeListener(onAttachStateChangeListener);
            this.f25074m.setVisibilityChangeListener(new RefreshableBannerView.j() { // from class: com.bytedance.msdk.cw.r.qv.4
                @Override // com.bytedance.msdk.core.views.RefreshableBannerView.j
                public void j(boolean z5) {
                    if (!z5) {
                        qv.this.av();
                    } else {
                        if (qv.this.f25073j == 0) {
                            return;
                        }
                        qv.this.az();
                    }
                }
            });
        }
        this.ae = new Handler(com.bytedance.msdk.j.up.m.xt());
        this.tl = new Handler(Looper.getMainLooper());
    }

    private void j(com.bytedance.msdk.api.j.xt xtVar) {
        com.bytedance.msdk.core.oq.xt j6;
        if (xtVar == null || (j6 = com.bytedance.msdk.core.xt.xt().j(xtVar.v(), 1, 100)) == null) {
            return;
        }
        int g6 = j6.g(1);
        if (g6 >= 10000 && g6 <= 180000) {
            this.f25073j = g6;
            com.bytedance.msdk.j.up.cw.j("TMe", "---==-----banner轮播时间：" + this.f25073j);
            return;
        }
        com.bytedance.msdk.j.up.cw.j("TMe", "---==-----banner轮播时间下发不在10*1000～180*1000范围内：" + g6 + "，禁止banner轮播");
    }

    public void xt() {
        m mVar = this.f25075r;
        if (mVar != null) {
            mVar.m();
        }
    }

    public void j(com.bytedance.msdk.api.j.xt xtVar, com.bytedance.msdk.api.r.j.j.xt xtVar2) {
        SoftReference<Context> softReference;
        if (this.f25075r == null || (softReference = this.xt) == null || softReference.get() == null) {
            return;
        }
        this.cw = xtVar;
        j(xtVar);
        if (!com.bytedance.msdk.core.xt.xt().j(xtVar.v(), 1) && xtVar2 != null) {
            xtVar2.j(new com.bytedance.msdk.api.j(840031, com.bytedance.msdk.api.j.j(840031)));
        } else if (com.bytedance.msdk.core.xt.xt().az()) {
            this.f25075r.j(this.cw, xtVar2);
        } else if (xtVar2 != null) {
            xtVar2.j(new com.bytedance.msdk.api.j(840032, com.bytedance.msdk.api.j.j(840032)));
        }
    }

    public void j(com.bytedance.msdk.api.r.j.j.j jVar) {
        this.f25072g = jVar;
        m mVar = this.f25075r;
        if (mVar != null) {
            mVar.j(this.az);
        }
    }

    public void j(com.bytedance.msdk.api.r.j.j.r rVar) {
        this.oq = rVar;
        m mVar = this.f25075r;
        if (mVar != null) {
            mVar.j(rVar);
        }
    }

    public void j() {
        m mVar = this.f25075r;
        if (mVar != null) {
            mVar.up();
        }
    }

    public void j(com.bytedance.sdk.openadsdk.i.cw.j.cw cwVar) {
        m mVar = this.f25075r;
        if (mVar != null) {
            mVar.j(cwVar);
        }
    }

    public void j(com.bytedance.sdk.openadsdk.i.cw.j.xt xtVar) {
        m mVar = this.f25075r;
        if (mVar != null) {
            mVar.xt(xtVar);
        }
    }

    public void j(com.bytedance.sdk.openadsdk.s.j.xt.j.cw cwVar) {
        m mVar = this.f25075r;
        if (mVar != null) {
            mVar.j(cwVar);
        }
    }

    public void j(Activity activity, com.bytedance.sdk.openadsdk.kt.j.xt.j.j jVar) {
        this.qv = new SoftReference<>(activity);
        this.vl = new SoftReference<>(jVar);
    }

    public void j(Dialog dialog, Integer[] numArr) {
        HashMap hashMap = new HashMap();
        hashMap.put("dislike_dialog", dialog);
        hashMap.put("dislike_ids", numArr);
        this.jy = new SoftReference<>(hashMap);
    }

    public com.bytedance.sdk.openadsdk.i.cw.xt.ae j(Activity activity) {
        m mVar = this.f25075r;
        if (mVar != null) {
            return mVar.j(activity);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(@NonNull m mVar) {
        Map<String, Object> map = this.jy.get();
        if (map != null) {
            Dialog dialog = (Dialog) map.get("dislike_dialog");
            Integer[] numArr = (Integer[]) map.get("dislike_ids");
            if (dialog != null && numArr != null) {
                mVar.j(dialog, numArr);
            }
        }
        Activity activity = this.qv.get();
        com.bytedance.sdk.openadsdk.kt.j.xt.j.j jVar = this.vl.get();
        if (activity == null || jVar == null) {
            return;
        }
        mVar.j(activity, jVar);
    }

    public void j(String str) {
        m mVar = this.f25075r;
        if (mVar != null) {
            mVar.r(str);
        }
    }
}
