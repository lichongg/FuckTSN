package com.bytedance.sdk.openadsdk.core.component.splash;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.sdk.openadsdk.core.EmptyView;
import com.bytedance.sdk.openadsdk.core.tj.n;
import com.bytedance.sdk.openadsdk.core.tj.xq;
import com.bytedance.sdk.openadsdk.core.xt.j.j.j;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\Downloads\app\classes4.dex */
public class ae {
    private SoftReference<com.bytedance.sdk.openadsdk.core.component.splash.j> ae;
    private FrameLayout cw;

    /* renamed from: g, reason: collision with root package name */
    private Handler f28598g = new Handler(Looper.getMainLooper());

    /* renamed from: j, reason: collision with root package name */
    private Context f28599j;

    /* renamed from: m, reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.qv.xt.cw f28600m;

    /* renamed from: r, reason: collision with root package name */
    private xt f28601r;
    private SoftReference<com.bytedance.sdk.openadsdk.i.cw.j.cw> tl;
    private com.bytedance.sdk.openadsdk.core.xt.j up;
    private n xt;

    public interface j {
        Context getActivity();

        void j();

        void j(long j6);

        void xt();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cw() {
        this.f28598g.postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.ae.4
            @Override // java.lang.Runnable
            public void run() {
                if (!com.bytedance.sdk.openadsdk.core.qv.cw.cw.m.f29896j) {
                    ae.this.xt();
                    return;
                }
                com.bytedance.sdk.openadsdk.core.qv.cw.cw.m.f29896j = false;
                if (ae.this.f28600m instanceof com.bytedance.sdk.openadsdk.core.qv.cw.up) {
                    ((com.bytedance.sdk.openadsdk.core.qv.cw.up) ae.this.f28600m).tl().j(new com.bytedance.sdk.openadsdk.core.qv.cw.j.j() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.ae.4.1
                        @Override // com.bytedance.sdk.openadsdk.core.qv.cw.j.j
                        public void j() {
                            ae.this.xt();
                        }
                    });
                }
            }
        }, 100L);
    }

    public void j(Context context, n nVar) {
        this.f28599j = context;
        this.xt = nVar;
        this.cw = new FrameLayout(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        this.cw.setLayoutParams(layoutParams);
        xq.xt(this.xt);
    }

    public void xt() {
        xt xtVar = this.f28601r;
        if (xtVar != null) {
            xtVar.xt();
        }
    }

    public ViewGroup j() {
        return this.cw;
    }

    public void j(String str, int i6, com.bytedance.sdk.openadsdk.core.component.splash.j jVar, com.bytedance.sdk.openadsdk.i.cw.j.cw cwVar) {
        this.ae = new SoftReference<>(jVar);
        if (cwVar != null) {
            this.tl = new SoftReference<>(cwVar);
        }
        HashMap hashMap = new HashMap();
        hashMap.put("splash_show_type", Integer.valueOf(i6));
        com.bytedance.sdk.openadsdk.core.xt.j jVar2 = new com.bytedance.sdk.openadsdk.core.xt.j(this.f28599j, this.xt, str, 4);
        ((com.bytedance.sdk.openadsdk.core.xt.j.j.j) jVar2.j(com.bytedance.sdk.openadsdk.core.xt.j.j.j.class)).j(this);
        ((com.bytedance.sdk.openadsdk.core.xt.j.cw.j) jVar2.j(com.bytedance.sdk.openadsdk.core.xt.j.cw.j.class)).j(hashMap);
        SoftReference<com.bytedance.sdk.openadsdk.i.cw.j.cw> softReference = this.tl;
        if (softReference == null) {
            j(str, this.cw, null);
        } else {
            j(str, this.cw, softReference.get());
        }
        ((com.bytedance.sdk.openadsdk.core.xt.j.j.j) jVar2.j(com.bytedance.sdk.openadsdk.core.xt.j.j.j.class)).j(this.f28600m);
        ((com.bytedance.sdk.openadsdk.core.xt.j.j.j) jVar2.j(com.bytedance.sdk.openadsdk.core.xt.j.j.j.class)).j(new j.InterfaceC0499j() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.ae.1
            @Override // com.bytedance.sdk.openadsdk.core.xt.j.j.j.InterfaceC0499j
            public void j(View view, int i7) {
                if (ae.this.ae != null && ae.this.ae.get() != null) {
                    ((com.bytedance.sdk.openadsdk.core.component.splash.j) ae.this.ae.get()).xt();
                }
                ae.this.cw();
            }
        });
        this.up = jVar2;
        xt xtVar = this.f28601r;
        if (xtVar != null) {
            xtVar.j(jVar2);
        }
    }

    private com.bytedance.sdk.openadsdk.core.qv.xt.cw j(n nVar, String str) {
        if (nVar.jl() == 4) {
            return com.bytedance.sdk.openadsdk.core.qv.tl.j(this.f28599j, nVar, str, false);
        }
        return null;
    }

    private void j(String str, final ViewGroup viewGroup, com.bytedance.sdk.openadsdk.i.cw.j.cw cwVar) {
        n nVar = this.xt;
        if (nVar == null || this.f28599j == null || viewGroup == null) {
            return;
        }
        this.f28600m = j(nVar, str);
        EmptyView emptyView = new EmptyView(this.f28599j, viewGroup, this.xt.at());
        emptyView.j(this.xt, str);
        emptyView.setAdType(3);
        viewGroup.addView(emptyView);
        if (cwVar != null) {
            j(cwVar);
        }
        emptyView.setCallback(new EmptyView.j() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.ae.2
            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.j
            public void j(View view, Map<String, Object> map) {
            }

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.j
            public void j(boolean z5) {
                if (ae.this.f28600m != null && z5) {
                    ae.this.f28600m.j();
                }
                ae.this.j(z5);
            }

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.j
            public void xt() {
                if (ae.this.f28600m != null) {
                    ae.this.f28600m.xt();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.j
            public void j() {
                ViewGroup viewGroup2;
                Context context;
                if (ae.this.f28600m != null) {
                    ae.this.f28600m.j(false);
                }
                if (ae.this.f28600m == null || (viewGroup2 = viewGroup) == null || viewGroup2.getParent() == null) {
                    return;
                }
                try {
                    context = ((View) viewGroup.getParent()).getContext();
                } catch (Exception unused) {
                    context = null;
                }
                if (context == null || !(context instanceof Activity)) {
                    return;
                }
                ae.this.f28600m.j((Activity) context);
            }
        });
    }

    private void j(final com.bytedance.sdk.openadsdk.i.cw.j.cw cwVar) {
        com.bytedance.sdk.openadsdk.core.qv.xt.cw cwVar2 = this.f28600m;
        if (cwVar2 == null) {
            return;
        }
        cwVar2.j(new com.bytedance.sdk.openadsdk.core.qv.xt.j() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.ae.3
            @Override // com.bytedance.sdk.openadsdk.core.qv.xt.j
            public void j() {
                com.bytedance.sdk.openadsdk.i.cw.j.cw cwVar3 = cwVar;
                if (cwVar3 != null) {
                    cwVar3.j();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.qv.xt.j
            public void cw(long j6, long j7, String str, String str2) {
                com.bytedance.sdk.openadsdk.i.cw.j.cw cwVar3 = cwVar;
                if (cwVar3 != null) {
                    cwVar3.cw(j6, j7, str, str2);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.qv.xt.j
            public void xt(long j6, long j7, String str, String str2) {
                com.bytedance.sdk.openadsdk.i.cw.j.cw cwVar3 = cwVar;
                if (cwVar3 != null) {
                    cwVar3.xt(j6, j7, str, str2);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.qv.xt.j
            public void j(long j6, long j7, String str, String str2) {
                com.bytedance.sdk.openadsdk.i.cw.j.cw cwVar3 = cwVar;
                if (cwVar3 != null) {
                    cwVar3.j(j6, j7, str, str2);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.qv.xt.j
            public void j(long j6, String str, String str2) {
                com.bytedance.sdk.openadsdk.i.cw.j.cw cwVar3 = cwVar;
                if (cwVar3 != null) {
                    cwVar3.j(j6, str, str2);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.qv.xt.j
            public void j(String str, String str2) {
                com.bytedance.sdk.openadsdk.i.cw.j.cw cwVar3 = cwVar;
                if (cwVar3 != null) {
                    cwVar3.j(str, str2);
                }
            }
        });
    }

    public void j(int i6) {
        if (i6 == 2 && xq.j(this.xt)) {
            this.f28601r = new cw();
        }
        xt xtVar = this.f28601r;
        if (xtVar != null) {
            xtVar.j(this.f28599j, this.cw, this.xt);
            this.f28601r.j(this.up);
        }
    }

    public void j(com.bytedance.sdk.openadsdk.core.video.nativevideo.r rVar, j jVar) {
        xt xtVar = this.f28601r;
        if (xtVar != null) {
            xtVar.j(rVar, jVar);
        }
    }

    public void j(boolean z5) {
        xt xtVar = this.f28601r;
        if (xtVar != null) {
            xtVar.j(z5);
        }
    }
}
