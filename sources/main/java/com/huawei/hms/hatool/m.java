package com.huawei.hms.hatool;

import android.content.Context;
import android.text.TextUtils;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public abstract class m {
    public abstract String c();

    public abstract String d(String str);

    public abstract String f();

    public abstract String g();

    public abstract int h();

    private b0 a(int i6) {
        String str;
        if (i6 != 0) {
            str = j();
            if (!TextUtils.isEmpty(str)) {
                return new b0(d0.UDID, str);
            }
        } else {
            str = "";
        }
        return new b0(d0.EMPTY, str);
    }

    private b0 e(int i6) {
        String str;
        if ((i6 & 4) != 0) {
            str = j();
            if (!TextUtils.isEmpty(str)) {
                return new b0(d0.UDID, str);
            }
        } else {
            str = "";
        }
        return new b0(d0.EMPTY, str);
    }

    private boolean i() {
        u d6 = d1.e().d();
        if (TextUtils.isEmpty(d6.x())) {
            d6.q(s0.c());
        }
        return !TextUtils.isEmpty(d6.x());
    }

    private String j() {
        u d6 = d1.e().d();
        if (TextUtils.isEmpty(d6.r())) {
            d6.k(m1.k());
        }
        return d6.r();
    }

    public b0 b(Context context) {
        String g6 = g();
        if (!TextUtils.isEmpty(g6)) {
            return new b0(d0.UDID, g6);
        }
        String c6 = c();
        if (!TextUtils.isEmpty(c6)) {
            return new b0(d0.IMEI, c6);
        }
        boolean i6 = i();
        String f6 = f();
        if (!TextUtils.isEmpty(f6)) {
            if (i6) {
                return new b0(d0.SN, f6);
            }
            return new b0(d0.UDID, d(f6));
        }
        if (i6) {
            return a(h());
        }
        return e(h());
    }
}
