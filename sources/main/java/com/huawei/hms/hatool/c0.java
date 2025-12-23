package com.huawei.hms.hatool;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import java.util.UUID;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public class c0 {

    /* renamed from: b, reason: collision with root package name */
    private static c0 f33511b;

    /* renamed from: a, reason: collision with root package name */
    private Context f33512a;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class a extends m {

        /* renamed from: a, reason: collision with root package name */
        String f33513a;

        /* renamed from: b, reason: collision with root package name */
        String f33514b;

        @Override // com.huawei.hms.hatool.m
        public String c() {
            return r1.d(this.f33513a, this.f33514b);
        }

        @Override // com.huawei.hms.hatool.m
        public String f() {
            return r1.g(this.f33513a, this.f33514b);
        }

        @Override // com.huawei.hms.hatool.m
        public String g() {
            return r1.j(this.f33513a, this.f33514b);
        }

        @Override // com.huawei.hms.hatool.m
        public int h() {
            return (r1.k(this.f33513a, this.f33514b) ? 4 : 0) | (r1.e(this.f33513a, this.f33514b) ? 2 : 0) | (r1.h(this.f33513a, this.f33514b) ? 1 : 0);
        }

        public a(String str, String str2) {
            this.f33513a = str;
            this.f33514b = str2;
        }

        @Override // com.huawei.hms.hatool.m
        public String d(String str) {
            return z1.d.b(str);
        }
    }

    public static c0 a() {
        c0 c0Var;
        synchronized (c0.class) {
            try {
                if (f33511b == null) {
                    f33511b = new c0();
                }
                c0Var = f33511b;
            } catch (Throwable th) {
                throw th;
            }
        }
        return c0Var;
    }

    public String b(String str, String str2) {
        return z.a(this.f33512a, str, str2);
    }

    public String c(boolean z5) {
        if (!z5) {
            return "";
        }
        String i6 = y0.i();
        if (TextUtils.isEmpty(i6)) {
            i6 = l.b(this.f33512a, "global_v2", "uuid", "");
            if (TextUtils.isEmpty(i6)) {
                i6 = UUID.randomUUID().toString().replace("-", "");
                l.g(this.f33512a, "global_v2", "uuid", i6);
            }
            y0.p(i6);
        }
        return i6;
    }

    public void d(Context context) {
        if (this.f33512a == null) {
            this.f33512a = context;
        }
    }

    public String e(String str, String str2) {
        return z.b(this.f33512a, str, str2);
    }

    public b0 f(String str, String str2) {
        return new a(str, str2).b(this.f33512a);
    }

    public String g(String str, String str2) {
        return q.f(str, str2);
    }

    public Pair<String, String> h(String str, String str2) {
        if (r1.f(str, str2)) {
            String F = d1.e().d().F();
            String H = d1.e().d().H();
            if (!TextUtils.isEmpty(F) && !TextUtils.isEmpty(H)) {
                return new Pair<>(F, H);
            }
            Pair<String, String> l6 = m1.l(this.f33512a);
            d1.e().d().w((String) l6.first);
            d1.e().d().y((String) l6.second);
            return l6;
        }
        return new Pair<>("", "");
    }

    public String i(String str, String str2) {
        return q.e(str, str2);
    }
}
