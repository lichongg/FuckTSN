package com.huawei.hms.hatool;

import android.os.Build;
import android.text.TextUtils;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public class t0 {

    /* renamed from: c, reason: collision with root package name */
    private static t0 f33646c;

    /* renamed from: a, reason: collision with root package name */
    private String f33647a;

    /* renamed from: b, reason: collision with root package name */
    private String f33648b;

    private boolean f(String str) {
        j1.h("hmsSdk", "refresh sp aes key");
        if (TextUtils.isEmpty(str)) {
            j1.h("hmsSdk", "refreshLocalKey(): encrypted key is empty");
            return false;
        }
        l.g(y0.q(), "Privacy_MY", "PrivacyData", str);
        l.f(y0.q(), "Privacy_MY", "flashKeyTime", System.currentTimeMillis());
        return true;
    }

    public static t0 g() {
        if (f33646c == null) {
            j();
        }
        return f33646c;
    }

    private String h() {
        if (TextUtils.isEmpty(this.f33648b)) {
            this.f33648b = new n1().a();
        }
        return this.f33648b;
    }

    private boolean i() {
        return Build.VERSION.SDK_INT >= 23;
    }

    private static synchronized void j() {
        synchronized (t0.class) {
            if (f33646c == null) {
                f33646c = new t0();
            }
        }
    }

    public String a() {
        if (TextUtils.isEmpty(this.f33647a)) {
            this.f33647a = e();
        }
        return this.f33647a;
    }

    public void d() {
        String e6 = d2.b.e(16);
        if (f(c(e6))) {
            this.f33647a = e6;
        }
    }

    private String b(String str) {
        String str2;
        if (i()) {
            str2 = a2.h.d("analytics_keystore", str);
        } else {
            str2 = "";
        }
        if (TextUtils.isEmpty(str2)) {
            j1.h("hmsSdk", "deCrypt work key first");
            String b6 = r0.b(str, h());
            if (TextUtils.isEmpty(b6)) {
                String e6 = d2.b.e(16);
                f(c(e6));
                if (i()) {
                    n1.i();
                }
                return e6;
            }
            if (i()) {
                f(c(b6));
                n1.i();
            }
            return b6;
        }
        return str2;
    }

    private String c(String str) {
        if (i()) {
            return a2.h.g("analytics_keystore", str);
        }
        return r0.d(str, h());
    }

    private String e() {
        String b6 = l.b(y0.q(), "Privacy_MY", "PrivacyData", "");
        if (TextUtils.isEmpty(b6)) {
            String e6 = d2.b.e(16);
            f(c(e6));
            return e6;
        }
        return b(b6);
    }
}
