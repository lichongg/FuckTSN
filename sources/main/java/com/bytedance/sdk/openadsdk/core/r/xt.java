package com.bytedance.sdk.openadsdk.core.r;

import com.bytedance.sdk.component.utils.tl;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.openadsdk.core.oq;

/* loaded from: D:\Downloads\app\classes4.dex */
public class xt {
    private long cw;

    /* renamed from: j, reason: collision with root package name */
    private int f30017j = 10000;

    /* renamed from: r, reason: collision with root package name */
    private Runnable f30018r;
    private String xt;

    public void xt(final Runnable runnable) {
        this.cw = System.currentTimeMillis();
        if (!j.up()) {
            xt(1);
            cw(runnable);
        } else if (oq.i().la()) {
            xt(2);
            j();
        } else if (j.j()) {
            tl.j().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.r.xt.1
                @Override // java.lang.Runnable
                public void run() {
                    if (oq.i().la()) {
                        xt.this.xt(2);
                        xt.this.j();
                    } else {
                        xt.this.xt(1);
                        xt.this.cw(runnable);
                    }
                }
            }, this.f30017j);
        } else {
            xt(1);
            cw(runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cw(Runnable runnable) {
        if (runnable != null) {
            runnable.run();
        }
    }

    public xt(String str) {
        this.xt = str;
    }

    public xt j(int i6) {
        this.f30017j = i6 <= 0 ? 10000 : i6 * 1000;
        return this;
    }

    public xt j(Runnable runnable) {
        this.f30018r = runnable;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        Runnable runnable = this.f30018r;
        if (runnable != null) {
            runnable.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xt(int i6) {
        StringBuilder sb = new StringBuilder();
        sb.append(">> tk: ");
        sb.append(this.xt);
        sb.append(i6 == 1 ? " run" : " cancel");
        sb.append(", isBst: true, tmgap: ");
        sb.append((System.currentTimeMillis() - this.cw) / 1000);
        if (i6 == 1) {
            vl.j("bstsdk", sb.toString());
        } else {
            vl.xt("bstsdk", sb.toString());
        }
    }
}
