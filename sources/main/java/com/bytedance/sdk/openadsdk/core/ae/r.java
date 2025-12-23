package com.bytedance.sdk.openadsdk.core.ae;

import com.bytedance.sdk.openadsdk.core.tj.n;
import com.bytedance.sdk.openadsdk.tools.LogAdapter;

/* loaded from: D:\Downloads\app\classes4.dex */
public class r {
    private static r up = new r();
    private int cw;

    /* renamed from: j, reason: collision with root package name */
    private n f27951j;

    /* renamed from: r, reason: collision with root package name */
    private volatile com.bytedance.sdk.component.j f27952r;
    private int xt;

    public static r j() {
        return up;
    }

    private boolean xt() {
        this.f27952r = LogAdapter.f31848j;
        return this.f27952r != null;
    }

    private String cw() {
        n nVar = this.f27951j;
        return nVar != null ? com.bytedance.sdk.component.utils.j.j(nVar.tv()).toString() : "";
    }

    public r j(n nVar) {
        if (xt()) {
            this.f27951j = nVar;
        }
        return this;
    }

    public r xt(int i6) {
        if (xt()) {
            this.cw = i6;
        }
        return this;
    }

    public r j(int i6) {
        if (xt()) {
            this.xt = i6;
        }
        return this;
    }

    public void j(Thread thread, Throwable th) {
        String str;
        if (xt()) {
            if (thread != null) {
                str = thread.getName() + "-" + thread.getId();
            } else {
                str = "";
            }
            this.f27952r.j(str, "-------fatal----------");
            this.f27952r.j(str, "last show rit:" + this.cw);
            this.f27952r.j(str, "last show adtype:" + this.xt);
            this.f27952r.j(str, cw());
            this.f27952r.j(str, th);
            this.f27952r.j(str, "-------finish----------");
            LogAdapter.f31848j.j().j();
        }
    }
}
