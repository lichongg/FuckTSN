package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.app.Activity;
import android.app.Dialog;
import android.view.View;
import com.bytedance.sdk.openadsdk.core.av.j;
import com.bytedance.sdk.openadsdk.core.tj.n;
import java.lang.ref.WeakReference;
import java.util.Map;

/* loaded from: D:\Downloads\app\classes4.dex */
public abstract class xt extends com.bytedance.sdk.openadsdk.i.cw.xt.ws {

    /* renamed from: g, reason: collision with root package name */
    protected Dialog f29753g;

    /* renamed from: j, reason: collision with root package name */
    private Integer[] f29754j;
    protected j tl;

    protected static class j implements com.bytedance.sdk.openadsdk.core.qv.xt.j {

        /* renamed from: j, reason: collision with root package name */
        private WeakReference<com.bytedance.sdk.openadsdk.core.qv.xt.j> f29756j;
        private String xt;

        public void j(com.bytedance.sdk.openadsdk.core.qv.xt.j jVar) {
            this.f29756j = new WeakReference<>(jVar);
        }

        @Override // com.bytedance.sdk.openadsdk.core.qv.xt.j
        public void cw(long j6, long j7, String str, String str2) {
            long j8;
            long j9;
            WeakReference<com.bytedance.sdk.openadsdk.core.qv.xt.j> weakReference = this.f29756j;
            if (weakReference == null || weakReference.get() == null) {
                j8 = j6;
                j9 = j7;
            } else {
                j8 = j6;
                j9 = j7;
                this.f29756j.get().cw(j8, j9, str, str2);
            }
            if (j8 > 0) {
                j.C0431j.j(this.xt, 4, (int) ((j9 * 100) / j8));
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.qv.xt.j
        public void j() {
            WeakReference<com.bytedance.sdk.openadsdk.core.qv.xt.j> weakReference = this.f29756j;
            if (weakReference != null && weakReference.get() != null) {
                this.f29756j.get().j();
            }
            j.C0431j.j(this.xt, 1, 0);
        }

        @Override // com.bytedance.sdk.openadsdk.core.qv.xt.j
        public void xt(long j6, long j7, String str, String str2) {
            long j8;
            long j9;
            WeakReference<com.bytedance.sdk.openadsdk.core.qv.xt.j> weakReference = this.f29756j;
            if (weakReference == null || weakReference.get() == null) {
                j8 = j6;
                j9 = j7;
            } else {
                j8 = j6;
                j9 = j7;
                this.f29756j.get().xt(j8, j9, str, str2);
            }
            if (j8 > 0) {
                j.C0431j.j(this.xt, 2, (int) ((j9 * 100) / j8));
            }
        }

        public j(com.bytedance.sdk.openadsdk.core.qv.xt.j jVar, String str) {
            this.xt = "";
            this.f29756j = new WeakReference<>(jVar);
            this.xt = str;
        }

        @Override // com.bytedance.sdk.openadsdk.core.qv.xt.j
        public void j(long j6, long j7, String str, String str2) {
            long j8;
            long j9;
            WeakReference<com.bytedance.sdk.openadsdk.core.qv.xt.j> weakReference = this.f29756j;
            if (weakReference == null || weakReference.get() == null) {
                j8 = j6;
                j9 = j7;
            } else {
                j8 = j6;
                j9 = j7;
                this.f29756j.get().j(j8, j9, str, str2);
            }
            if (j8 > 0) {
                j.C0431j.j(this.xt, 3, (int) ((j9 * 100) / j8));
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.qv.xt.j
        public void j(long j6, String str, String str2) {
            WeakReference<com.bytedance.sdk.openadsdk.core.qv.xt.j> weakReference = this.f29756j;
            if (weakReference != null && weakReference.get() != null) {
                this.f29756j.get().j(j6, str, str2);
            }
            j.C0431j.j(this.xt, 5, 100);
        }

        @Override // com.bytedance.sdk.openadsdk.core.qv.xt.j
        public void j(String str, String str2) {
            WeakReference<com.bytedance.sdk.openadsdk.core.qv.xt.j> weakReference = this.f29756j;
            if (weakReference != null && weakReference.get() != null) {
                this.f29756j.get().j(str, str2);
            }
            j.C0431j.j(this.xt, 6, 100);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.ws
    public int cw() {
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.ws
    public View j() {
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.ws
    public com.bytedance.sdk.openadsdk.i.cw.xt.r m() {
        return null;
    }

    public abstract n oq();

    public com.bytedance.sdk.openadsdk.core.multipro.xt.j qv() {
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.ws
    public Map<String, Object> tl() {
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.ws
    public int xt() {
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.ws
    public com.bytedance.sdk.openadsdk.i.cw.xt.ae j(Activity activity) {
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.tl
    public void xt(Double d6) {
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.ws
    public void j(int i6) {
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.ws
    public void up() {
        if (oq() != null) {
            com.bytedance.sdk.openadsdk.core.x.j(oq().uv());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.ws
    public void j(Activity activity, com.bytedance.sdk.openadsdk.kt.j.xt.j.j jVar) {
    }

    protected void j(Dialog dialog) {
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.ws
    public void j(com.bytedance.sdk.openadsdk.i.cw.j.cw cwVar) {
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.ws
    public void j(com.bytedance.sdk.openadsdk.s.j.xt.j.cw cwVar) {
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.ws
    public void j(com.bytedance.sdk.openadsdk.s.j.xt.j.j jVar) {
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.ws
    public void j(com.bytedance.sdk.openadsdk.s.j.xt.j.xt xtVar) {
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.tl
    public void j(Double d6) {
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.tl
    public void j(Double d6, String str, String str2) {
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.ws
    public void j(boolean z5) {
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.ws
    public void j(Dialog dialog, Integer[] numArr) {
        this.f29753g = dialog;
        this.f29754j = numArr;
        try {
            dialog.getWindow().getDecorView().addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.xt.1
                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewAttachedToWindow(View view) {
                    if (xt.this.oq() != null) {
                        xt xtVar = xt.this;
                        xtVar.j(xtVar.oq().gs());
                    }
                }

                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewDetachedFromWindow(View view) {
                }
            });
        } catch (Throwable unused) {
        }
        j(this.f29753g);
    }

    protected void j(com.bytedance.sdk.openadsdk.core.dislike.cw.xt xtVar) {
        Dialog dialog;
        if (xtVar == null || (dialog = this.f29753g) == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.dislike.j.xt.j(xtVar, dialog, this.f29754j);
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.tl
    public void j(com.bytedance.sdk.openadsdk.i.cw.j.xt xtVar) {
        if (oq() != null) {
            com.bytedance.sdk.openadsdk.core.x.j(oq().uv(), xtVar, com.bytedance.sdk.openadsdk.i.cw.j.xt.class);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.ws
    public void r() {
    }
}
