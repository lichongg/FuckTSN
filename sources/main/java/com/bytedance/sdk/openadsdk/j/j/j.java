package com.bytedance.sdk.openadsdk.j.j;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.openadsdk.av.r;
import com.bytedance.sdk.openadsdk.core.h;
import com.bytedance.sdk.openadsdk.core.oq;
import com.bytedance.sdk.openadsdk.core.rn.f;
import com.bytedance.sdk.openadsdk.core.v;
import com.volcengine.mobsecBiz.metasec.listener.PglITokenObserver;
import com.volcengine.mobsecBiz.metasec.ml.a;
import com.volcengine.mobsecBiz.metasec.ml.b;
import com.volcengine.mobsecBiz.metasec.ml.c;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import ms.bz.bd.c.Pgl.pblu;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j {

    /* renamed from: g, reason: collision with root package name */
    private static volatile r f31521g = null;

    /* renamed from: j, reason: collision with root package name */
    private static volatile j f31522j = null;

    /* renamed from: m, reason: collision with root package name */
    private static volatile String f31523m = "";
    private final AtomicBoolean ae = new AtomicBoolean(false);
    private volatile boolean cw;

    /* renamed from: r, reason: collision with root package name */
    private final String f31524r;
    private volatile int tl;
    private volatile String up;
    private b xt;

    public static j j() {
        return f31522j;
    }

    public void xt(String str) {
        if (this.cw) {
            cw();
            b bVar = this.xt;
            if (bVar != null) {
                bVar.d(str);
            }
        }
    }

    private void cw() {
        if (this.xt == null) {
            this.xt = c.a("1371");
        }
    }

    private static j r(String str) {
        if (f31522j == null) {
            synchronized (j.class) {
                try {
                    if (f31522j == null) {
                        f31522j = new j(str);
                    }
                } finally {
                }
            }
        }
        return f31522j;
    }

    private boolean up(String str) {
        try {
            Context context = v.getContext();
            a.C0842a c0842a = new a.C0842a("1371", this.f31524r, "THYFfhd167Y/Etj/JFI+OYhGnAsIhCvIXKQbbKuslfRMO6XQmCuZImqOyljyF6dQ900Hy8ecQzUcHu72ks7Xvvncqt7BZjf4VSth/OzZbJlDJqtayy2lcb5mqCQUzE5fIvFXAZkyxl+SRzGnzUojBcyqITZ3bGRvteMi+qu/15oKM3BWY0IDJ9Ry5FUGfzt+FyCqvZI8PFQNAzvZXcWHlJoRXydZUjUbtEy/AFUvusIO1HDx", this.tl);
            c0842a.d(new PglITokenObserver() { // from class: com.bytedance.sdk.openadsdk.j.j.j.1
                @Override // com.volcengine.mobsecBiz.metasec.listener.PglITokenObserver
                public void onTokenLoaded(String str2) {
                    String unused = j.f31523m = str2;
                    if (!TextUtils.isEmpty(str2)) {
                        com.bytedance.sdk.openadsdk.core.cw.r.j().az(str2);
                    }
                }
            });
            if (!oq.i().tl()) {
                c0842a.n("kOA1", "1");
            } else if (!oq.i().qv()) {
                c0842a.u(str);
            }
            if (!oq.i().up()) {
                c0842a.n("kS1", "1");
            }
            if (!oq.i().jy()) {
                c0842a.n("kDisableBlueToothCollection", "1");
            }
            c.b(context, c0842a.s(this.up).q(1).o());
            c.c("1371");
            cw();
            return true;
        } catch (Throwable th) {
            vl.xt("MSSdkImpl", "appid 为空，初始化失败！", th);
            return false;
        }
    }

    public void j(String str) {
        if (this.cw) {
            cw();
            if (TextUtils.isEmpty(str) || str.equals(this.up) || this.xt == null) {
                return;
            }
            this.up = str;
            this.xt.e(str);
        }
    }

    private j(String str) {
        this.tl = pblu.f50357u;
        String f6 = oq.i().f();
        com.bytedance.sdk.openadsdk.i.cw.cw.r w5 = oq.i().w();
        if (w5 != null) {
            if (w5.cw() && w5.r() && w5.up()) {
                if (!w5.xt()) {
                    this.tl = 810;
                }
            } else {
                this.tl = 290;
            }
            if (h.xt >= 4600 && !w5.m()) {
                this.tl = 290;
            }
        }
        this.up = null;
        this.f31524r = f6;
        this.cw = up(str);
    }

    public static String xt() {
        if (TextUtils.isEmpty(f31523m)) {
            f31523m = com.bytedance.sdk.openadsdk.core.cw.r.j().tj();
        }
        return f31523m;
    }

    public Map<String, String> j(String str, byte[] bArr) {
        if (!this.cw) {
            return new HashMap();
        }
        cw();
        b bVar = this.xt;
        if (bVar != null) {
            return bVar.b(str, bArr);
        }
        return new HashMap();
    }

    public static void j(r rVar) {
        f31521g = rVar;
        j(true);
    }

    public static j j(boolean z5) {
        if (oq.i().oq()) {
            if (f31521g != null) {
                if (f31522j == null) {
                    return r(f.cw(f31521g));
                }
                return f31522j;
            }
            if (z5) {
                return r("error");
            }
            return null;
        }
        return r(null);
    }
}
