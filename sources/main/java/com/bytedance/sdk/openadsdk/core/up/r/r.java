package com.bytedance.sdk.openadsdk.core.up.r;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.rn.uf;
import com.bytedance.sdk.openadsdk.core.tj.n;
import com.bytedance.sdk.openadsdk.core.up.r.up;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class r {
    private final up up;

    /* renamed from: j, reason: collision with root package name */
    private static final r f30878j = new r(7);
    private static final r xt = new r(8);
    private static final r cw = new r(3);

    /* renamed from: r, reason: collision with root package name */
    private static final r f30879r = new r(0);

    public static r j(int i6) {
        return i6 != 3 ? i6 != 7 ? i6 != 8 ? f30879r : xt : f30878j : cw;
    }

    public void cw(String str) {
        this.up.cw(str);
    }

    public void xt(String str) {
        this.up.xt(str);
    }

    private r(int i6) {
        this.up = new up(i6);
    }

    public void j(com.bytedance.sdk.openadsdk.i.cw.cw.xt xtVar, n nVar, boolean z5) {
        if (xtVar == null || nVar == null) {
            return;
        }
        if ((nVar.qf() != null ? nVar.qf().optInt("save_type") : 0) == 1) {
            return;
        }
        this.up.j(xtVar.r(), new up.xt(com.bytedance.sdk.component.utils.j.xt(nVar.tv().toString()), nVar.id(), 1000 * nVar.xj(), nVar.kj()), z5, ((((System.currentTimeMillis() / 1000) / 60) / 60) / 3) + uf.az(nVar));
    }

    public n j(String str, boolean z5, long j6) {
        System.currentTimeMillis();
        up.xt j7 = this.up.j(str, z5, j6);
        if (j7 == null) {
            System.currentTimeMillis();
            return null;
        }
        System.currentTimeMillis();
        try {
            n j8 = com.bytedance.sdk.openadsdk.core.j.j(new JSONObject(com.bytedance.sdk.component.utils.j.cw(j7.cw)));
            j8.tl(true);
            j8.c(101);
            j8.m(j7.f30891j);
            j8.x(j7.up);
            return j8;
        } catch (Exception unused) {
            return null;
        }
    }

    public void j(String str) {
        this.up.j(str);
    }

    public void j(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        this.up.j(str, str2);
    }

    public void j(String str, String str2, boolean z5) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        this.up.j(str, str2, z5);
    }

    public void j() {
        this.up.j();
    }

    public static boolean j(n nVar) {
        if (nVar == null) {
            return false;
        }
        return (nVar.qf() != null ? nVar.qf().optInt("save_type") : 0) != 1;
    }
}
