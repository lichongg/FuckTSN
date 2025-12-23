package com.amap.api.col.p0003l;

import android.text.TextUtils;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@hk(a = "a")
/* loaded from: D:\Downloads\app\classes2.dex */
public final class p4 {

    /* renamed from: a, reason: collision with root package name */
    @hl(a = "a1", b = 6)
    private String f6897a;

    /* renamed from: b, reason: collision with root package name */
    @hl(a = "a2", b = 6)
    private String f6898b;

    /* renamed from: c, reason: collision with root package name */
    @hl(a = "a6", b = 2)
    private int f6899c;

    /* renamed from: d, reason: collision with root package name */
    @hl(a = "a3", b = 6)
    private String f6900d;

    /* renamed from: e, reason: collision with root package name */
    @hl(a = "a4", b = 6)
    private String f6901e;

    /* renamed from: f, reason: collision with root package name */
    @hl(a = "a5", b = 6)
    private String f6902f;

    /* renamed from: g, reason: collision with root package name */
    private String f6903g;

    /* renamed from: h, reason: collision with root package name */
    private String f6904h;

    /* renamed from: i, reason: collision with root package name */
    private String f6905i;

    /* renamed from: j, reason: collision with root package name */
    private String f6906j;

    /* renamed from: k, reason: collision with root package name */
    private String f6907k;

    /* renamed from: l, reason: collision with root package name */
    private String[] f6908l;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private String f6909a;

        /* renamed from: b, reason: collision with root package name */
        private String f6910b;

        /* renamed from: c, reason: collision with root package name */
        private String f6911c;

        /* renamed from: d, reason: collision with root package name */
        private String f6912d;

        /* renamed from: e, reason: collision with root package name */
        private boolean f6913e = true;

        /* renamed from: f, reason: collision with root package name */
        private String f6914f = "standard";

        /* renamed from: g, reason: collision with root package name */
        private String[] f6915g = null;

        public final a a(String str) {
            this.f6910b = str;
            return this;
        }

        public final a b(String[] strArr) {
            if (strArr != null) {
                this.f6915g = (String[]) strArr.clone();
            }
            return this;
        }

        public final p4 c() throws fk {
            if (this.f6915g != null) {
                return new p4(this, (byte) 0);
            }
            throw new fk("sdk packages is null");
        }

        public a(String str, String str2, String str3) {
            this.f6909a = str2;
            this.f6910b = str2;
            this.f6912d = str3;
            this.f6911c = str;
        }
    }

    /* synthetic */ p4(a aVar, byte b6) {
        this(aVar);
    }

    private static String b(String[] strArr) {
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

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (p4.class != obj.getClass()) {
            return false;
        }
        try {
            if (this.f6906j.equals(((p4) obj).f6906j) && this.f6903g.equals(((p4) obj).f6903g)) {
                if (this.f6904h.equals(((p4) obj).f6904h)) {
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    private p4() {
        this.f6899c = 1;
        this.f6908l = null;
    }

    private static String[] d(String str) {
        try {
            return str.split(";");
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public final String a() {
        if (TextUtils.isEmpty(this.f6906j) && !TextUtils.isEmpty(this.f6897a)) {
            this.f6906j = q4.u(this.f6897a);
        }
        return this.f6906j;
    }

    public final void c(boolean z5) {
        this.f6899c = z5 ? 1 : 0;
    }

    public final String e() {
        return this.f6903g;
    }

    public final String f() {
        if (TextUtils.isEmpty(this.f6904h) && !TextUtils.isEmpty(this.f6898b)) {
            this.f6904h = q4.u(this.f6898b);
        }
        return this.f6904h;
    }

    public final String g() {
        if (TextUtils.isEmpty(this.f6907k) && !TextUtils.isEmpty(this.f6902f)) {
            this.f6907k = q4.u(this.f6902f);
        }
        if (TextUtils.isEmpty(this.f6907k)) {
            this.f6907k = "standard";
        }
        return this.f6907k;
    }

    public final boolean h() {
        return this.f6899c == 1;
    }

    public final String[] i() {
        String[] strArr = this.f6908l;
        if ((strArr == null || strArr.length == 0) && !TextUtils.isEmpty(this.f6901e)) {
            this.f6908l = d(q4.u(this.f6901e));
        }
        return (String[]) this.f6908l.clone();
    }

    private p4(a aVar) {
        this.f6899c = 1;
        this.f6908l = null;
        this.f6903g = aVar.f6909a;
        this.f6904h = aVar.f6910b;
        this.f6906j = aVar.f6911c;
        this.f6905i = aVar.f6912d;
        this.f6899c = aVar.f6913e ? 1 : 0;
        this.f6907k = aVar.f6914f;
        this.f6908l = aVar.f6915g;
        this.f6898b = q4.q(this.f6904h);
        this.f6897a = q4.q(this.f6906j);
        this.f6900d = q4.q(this.f6905i);
        this.f6901e = q4.q(b(this.f6908l));
        this.f6902f = q4.q(this.f6907k);
    }
}
