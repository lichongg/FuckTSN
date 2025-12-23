package com.bytedance.sdk.openadsdk.core.nativeexpress;

import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.Queue;

/* loaded from: D:\Downloads\app\classes4.dex */
public class vl implements qv {

    /* renamed from: j, reason: collision with root package name */
    private WeakReference<qv> f29733j;
    private Queue<Runnable> xt = new LinkedList();

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.qv
    public int xt() {
        WeakReference<qv> weakReference = this.f29733j;
        if (weakReference == null || weakReference.get() == null) {
            return 0;
        }
        return this.f29733j.get().xt();
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.qv
    public void ae() {
        WeakReference<qv> weakReference = this.f29733j;
        if (weakReference == null || weakReference.get() == null) {
            this.xt.add(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.vl.8
                @Override // java.lang.Runnable
                public void run() {
                    if (vl.this.f29733j == null || vl.this.f29733j.get() == null) {
                        return;
                    }
                    ((qv) vl.this.f29733j.get()).ae();
                }
            });
        } else {
            this.f29733j.get().ae();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.qv
    public int cw() {
        WeakReference<qv> weakReference = this.f29733j;
        if (weakReference == null || weakReference.get() == null) {
            return 0;
        }
        return this.f29733j.get().cw();
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.qv
    public void g() {
        WeakReference<qv> weakReference = this.f29733j;
        if (weakReference == null || weakReference.get() == null) {
            this.xt.add(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.vl.11
                @Override // java.lang.Runnable
                public void run() {
                    if (vl.this.f29733j == null || vl.this.f29733j.get() == null) {
                        return;
                    }
                    ((qv) vl.this.f29733j.get()).g();
                }
            });
        } else {
            this.f29733j.get().g();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.qv
    public long getActualPlayDuration() {
        WeakReference<qv> weakReference = this.f29733j;
        if (weakReference == null || weakReference.get() == null) {
            return 0L;
        }
        return this.f29733j.get().getActualPlayDuration();
    }

    public void j(qv qvVar) {
        this.f29733j = new WeakReference<>(qvVar);
        while (!this.xt.isEmpty()) {
            try {
                Runnable poll = this.xt.poll();
                if (poll != null) {
                    poll.run();
                }
            } catch (Exception unused) {
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.qv
    public void m() {
        WeakReference<qv> weakReference = this.f29733j;
        if (weakReference == null || weakReference.get() == null) {
            this.xt.add(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.vl.7
                @Override // java.lang.Runnable
                public void run() {
                    if (vl.this.f29733j == null || vl.this.f29733j.get() == null) {
                        return;
                    }
                    ((qv) vl.this.f29733j.get()).m();
                }
            });
        } else {
            this.f29733j.get().m();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.qv
    public void oq() {
        WeakReference<qv> weakReference = this.f29733j;
        if (weakReference == null || weakReference.get() == null) {
            this.xt.add(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.vl.12
                @Override // java.lang.Runnable
                public void run() {
                    if (vl.this.f29733j == null || vl.this.f29733j.get() == null) {
                        return;
                    }
                    ((qv) vl.this.f29733j.get()).oq();
                }
            });
        } else {
            this.f29733j.get().oq();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.qv
    public void qv() {
        WeakReference<qv> weakReference = this.f29733j;
        if (weakReference == null || weakReference.get() == null) {
            this.xt.add(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.vl.13
                @Override // java.lang.Runnable
                public void run() {
                    if (vl.this.f29733j == null || vl.this.f29733j.get() == null) {
                        return;
                    }
                    ((qv) vl.this.f29733j.get()).qv();
                }
            });
        } else {
            this.f29733j.get().qv();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.qv
    public void r() {
        WeakReference<qv> weakReference = this.f29733j;
        if (weakReference == null || weakReference.get() == null) {
            this.xt.add(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.vl.15
                @Override // java.lang.Runnable
                public void run() {
                    if (vl.this.f29733j == null || vl.this.f29733j.get() == null) {
                        return;
                    }
                    ((qv) vl.this.f29733j.get()).r();
                }
            });
        } else {
            this.f29733j.get().r();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.qv
    public void setPauseFromExpressView(final boolean z5) {
        WeakReference<qv> weakReference = this.f29733j;
        if (weakReference == null || weakReference.get() == null) {
            this.xt.add(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.vl.5
                @Override // java.lang.Runnable
                public void run() {
                    if (vl.this.f29733j == null || vl.this.f29733j.get() == null) {
                        return;
                    }
                    ((qv) vl.this.f29733j.get()).setPauseFromExpressView(z5);
                }
            });
        } else {
            this.f29733j.get().setPauseFromExpressView(z5);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.qv
    public void tl() {
        WeakReference<qv> weakReference = this.f29733j;
        if (weakReference == null || weakReference.get() == null) {
            this.xt.add(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.vl.9
                @Override // java.lang.Runnable
                public void run() {
                    if (vl.this.f29733j == null || vl.this.f29733j.get() == null) {
                        return;
                    }
                    ((qv) vl.this.f29733j.get()).tl();
                }
            });
        } else {
            this.f29733j.get().tl();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.qv
    public void up() {
        WeakReference<qv> weakReference = this.f29733j;
        if (weakReference == null || weakReference.get() == null) {
            this.xt.add(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.vl.3
                @Override // java.lang.Runnable
                public void run() {
                    if (vl.this.f29733j == null || vl.this.f29733j.get() == null) {
                        return;
                    }
                    ((qv) vl.this.f29733j.get()).up();
                }
            });
        } else {
            this.f29733j.get().up();
        }
    }

    public qv vl() {
        WeakReference<qv> weakReference = this.f29733j;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.qv
    public void xt(final int i6) {
        WeakReference<qv> weakReference = this.f29733j;
        if (weakReference != null && weakReference.get() != null) {
            this.f29733j.get().xt(i6);
        } else {
            this.xt.add(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.vl.2
                @Override // java.lang.Runnable
                public void run() {
                    if (vl.this.f29733j == null || vl.this.f29733j.get() == null) {
                        return;
                    }
                    ((qv) vl.this.f29733j.get()).xt(i6);
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.qv
    public void j(final boolean z5) {
        WeakReference<qv> weakReference = this.f29733j;
        if (weakReference != null && weakReference.get() != null) {
            this.f29733j.get().j(z5);
        } else {
            this.xt.add(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.vl.1
                @Override // java.lang.Runnable
                public void run() {
                    if (vl.this.f29733j == null || vl.this.f29733j.get() == null) {
                        return;
                    }
                    ((qv) vl.this.f29733j.get()).j(z5);
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.qv
    public void j(final int i6) {
        WeakReference<qv> weakReference = this.f29733j;
        if (weakReference != null && weakReference.get() != null) {
            this.f29733j.get().j(i6);
        } else {
            this.xt.add(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.vl.10
                @Override // java.lang.Runnable
                public void run() {
                    if (vl.this.f29733j == null || vl.this.f29733j.get() == null) {
                        return;
                    }
                    ((qv) vl.this.f29733j.get()).j(i6);
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.qv
    public long j() {
        WeakReference<qv> weakReference = this.f29733j;
        if (weakReference == null || weakReference.get() == null) {
            return 0L;
        }
        return this.f29733j.get().j();
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.qv
    public void j(final float f6, final float f7, final float f8, final float f9, final int i6) {
        WeakReference<qv> weakReference = this.f29733j;
        if (weakReference != null && weakReference.get() != null) {
            this.f29733j.get().j(f6, f7, f8, f9, i6);
        } else {
            this.xt.add(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.vl.14
                @Override // java.lang.Runnable
                public void run() {
                    if (vl.this.f29733j == null || vl.this.f29733j.get() == null) {
                        return;
                    }
                    ((qv) vl.this.f29733j.get()).j(f6, f7, f8, f9, i6);
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.qv
    public void j(final int i6, final String str) {
        WeakReference<qv> weakReference = this.f29733j;
        if (weakReference != null && weakReference.get() != null) {
            this.f29733j.get().j(i6, str);
        } else {
            this.xt.add(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.vl.4
                @Override // java.lang.Runnable
                public void run() {
                    if (vl.this.f29733j == null || vl.this.f29733j.get() == null) {
                        return;
                    }
                    ((qv) vl.this.f29733j.get()).j(i6, str);
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.qv
    public void j(final float f6) {
        WeakReference<qv> weakReference = this.f29733j;
        if (weakReference != null && weakReference.get() != null) {
            this.f29733j.get().j(f6);
        } else {
            this.xt.add(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.vl.6
                @Override // java.lang.Runnable
                public void run() {
                    if (vl.this.f29733j == null || vl.this.f29733j.get() == null) {
                        return;
                    }
                    ((qv) vl.this.f29733j.get()).j(f6);
                }
            });
        }
    }
}
