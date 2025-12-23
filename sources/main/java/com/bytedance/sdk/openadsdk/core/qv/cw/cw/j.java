package com.bytedance.sdk.openadsdk.core.qv.cw.cw;

import android.content.Context;
import com.bytedance.sdk.component.utils.a;
import com.bytedance.sdk.component.utils.kt;
import com.bytedance.sdk.component.utils.ws;
import com.bytedance.sdk.openadsdk.core.oq;
import com.bytedance.sdk.openadsdk.core.tj.n;
import com.bytedance.sdk.openadsdk.core.tj.tj;

/* loaded from: D:\Downloads\app\classes4.dex */
public abstract class j {
    protected int cw;

    /* renamed from: j, reason: collision with root package name */
    protected Context f29894j;

    /* renamed from: r, reason: collision with root package name */
    protected boolean f29895r = true;
    protected n xt;

    abstract boolean cw();

    public void j(Context context) {
        this.f29894j = context;
    }

    public void j(n nVar) {
        this.xt = nVar;
    }

    protected boolean r() {
        int cw = ws.cw(this.f29894j);
        n nVar = this.xt;
        if (nVar == null) {
            return false;
        }
        int az = tj.az(nVar);
        if (az == -1) {
            return !oq.i().cw(cw);
        }
        if (az != 0) {
            if (az != 2) {
                if (az == 3) {
                    return true;
                }
                if (!oq.i().cw(cw)) {
                    com.bytedance.sdk.openadsdk.core.tj.up by = this.xt.by();
                    if (((by == null || by.ae() <= 0) ? 104857600 : by.ae()) > tj.av(this.xt)) {
                        return true;
                    }
                }
                return false;
            }
            if (cw != 4) {
                return true;
            }
        }
        return false;
    }

    public int xt() {
        return this.cw;
    }

    public void j(boolean z5) {
        this.f29895r = z5;
    }

    public boolean j() {
        Context context;
        if (this.xt == null || (context = this.f29894j) == null) {
            return true;
        }
        if (!this.f29895r) {
            return false;
        }
        if (ws.cw(context) == 0) {
            try {
                Context context2 = this.f29894j;
                a.j(context2, kt.j(context2, "tt_no_network"), 0);
            } catch (Throwable unused) {
            }
        }
        boolean cw = cw();
        if (cw) {
            m.f29896j = true;
            m.cw = true;
        }
        return cw;
    }
}
