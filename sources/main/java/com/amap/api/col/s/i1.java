package com.amap.api.col.s;

import android.text.TextUtils;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class i1 {

    /* renamed from: a, reason: collision with root package name */
    private String f8147a;

    /* renamed from: b, reason: collision with root package name */
    private String f8148b;

    /* renamed from: c, reason: collision with root package name */
    private int f8149c;

    /* renamed from: d, reason: collision with root package name */
    private String f8150d;

    /* renamed from: e, reason: collision with root package name */
    private String f8151e;

    /* renamed from: f, reason: collision with root package name */
    private String f8152f;

    /* renamed from: g, reason: collision with root package name */
    private String f8153g;

    /* renamed from: h, reason: collision with root package name */
    private String f8154h;

    /* renamed from: i, reason: collision with root package name */
    private String f8155i;

    /* renamed from: j, reason: collision with root package name */
    private String f8156j;

    /* renamed from: k, reason: collision with root package name */
    private String f8157k;

    /* renamed from: l, reason: collision with root package name */
    private String[] f8158l;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private String f8159a;

        /* renamed from: b, reason: collision with root package name */
        private String f8160b;

        /* renamed from: c, reason: collision with root package name */
        private String f8161c;

        /* renamed from: d, reason: collision with root package name */
        private String f8162d;

        /* renamed from: e, reason: collision with root package name */
        private boolean f8163e = true;

        /* renamed from: f, reason: collision with root package name */
        private String f8164f = "standard";

        /* renamed from: g, reason: collision with root package name */
        private String[] f8165g = null;

        public final a a(String str) {
            this.f8160b = str;
            return this;
        }

        public final a b(boolean z5) {
            this.f8163e = z5;
            return this;
        }

        public final a c(String[] strArr) {
            if (strArr != null) {
                this.f8165g = (String[]) strArr.clone();
            }
            return this;
        }

        public final i1 d() throws bv {
            if (this.f8165g != null) {
                return new i1(this, (byte) 0);
            }
            throw new bv("sdk packages is null");
        }

        public a(String str, String str2, String str3) {
            this.f8159a = str2;
            this.f8160b = str2;
            this.f8162d = str3;
            this.f8161c = str;
        }
    }

    /* synthetic */ i1(a aVar, byte b6) {
        this(aVar);
    }

    private static String a(String[] strArr) {
        if (strArr == null) {
            return null;
        }
        try {
            StringBuilder sb = new StringBuilder();
            for (String str : strArr) {
                sb.append(str);
                sb.append(";");
            }
            return sb.toString();
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public final void b() {
        this.f8149c = 1;
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (i1.class != obj.getClass()) {
            return false;
        }
        try {
            if (this.f8156j.equals(((i1) obj).f8156j) && this.f8153g.equals(((i1) obj).f8153g)) {
                if (this.f8154h.equals(((i1) obj).f8154h)) {
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    private i1() {
        this.f8149c = 1;
        this.f8158l = null;
    }

    private static String[] c(String str) {
        try {
            return str.split(";");
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public final String d() {
        if (TextUtils.isEmpty(this.f8156j) && !TextUtils.isEmpty(this.f8147a)) {
            this.f8156j = j1.t(this.f8147a);
        }
        return this.f8156j;
    }

    public final String e() {
        return this.f8153g;
    }

    public final String f() {
        if (TextUtils.isEmpty(this.f8154h) && !TextUtils.isEmpty(this.f8148b)) {
            this.f8154h = j1.t(this.f8148b);
        }
        return this.f8154h;
    }

    public final String g() {
        if (TextUtils.isEmpty(this.f8157k) && !TextUtils.isEmpty(this.f8152f)) {
            this.f8157k = j1.t(this.f8152f);
        }
        if (TextUtils.isEmpty(this.f8157k)) {
            this.f8157k = "standard";
        }
        return this.f8157k;
    }

    public final boolean h() {
        return this.f8149c == 1;
    }

    public final String[] i() {
        String[] strArr = this.f8158l;
        if ((strArr == null || strArr.length == 0) && !TextUtils.isEmpty(this.f8151e)) {
            this.f8158l = c(j1.t(this.f8151e));
        }
        return (String[]) this.f8158l.clone();
    }

    private i1(a aVar) {
        this.f8149c = 1;
        this.f8158l = null;
        this.f8153g = aVar.f8159a;
        this.f8154h = aVar.f8160b;
        this.f8156j = aVar.f8161c;
        this.f8155i = aVar.f8162d;
        this.f8149c = aVar.f8163e ? 1 : 0;
        this.f8157k = aVar.f8164f;
        this.f8158l = aVar.f8165g;
        this.f8148b = j1.q(this.f8154h);
        this.f8147a = j1.q(this.f8156j);
        this.f8150d = j1.q(this.f8155i);
        this.f8151e = j1.q(a(this.f8158l));
        this.f8152f = j1.q(this.f8157k);
    }
}
