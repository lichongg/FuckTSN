package com.bytedance.embedapplog.util;

/* loaded from: D:\Downloads\app\classes3.dex */
public class j {
    private final String ae;
    private final String[] cw;

    /* renamed from: j, reason: collision with root package name */
    private final String f24075j;

    /* renamed from: m, reason: collision with root package name */
    private final String f24076m;

    /* renamed from: r, reason: collision with root package name */
    private final String f24077r;
    private final String up;
    private final String[] xt;

    /* renamed from: com.bytedance.embedapplog.util.j$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* renamed from: com.bytedance.embedapplog.util.j$j, reason: collision with other inner class name */
    public static class C0339j {
        private String ae;
        private String[] cw;

        /* renamed from: j, reason: collision with root package name */
        private String f24078j;

        /* renamed from: m, reason: collision with root package name */
        private String f24079m;

        /* renamed from: r, reason: collision with root package name */
        private String f24080r;
        private String up;
        private String[] xt;

        public C0339j cw(String str) {
            this.up = str;
            return this;
        }

        public C0339j j(String str) {
            this.f24078j = str;
            return this;
        }

        public C0339j r(String str) {
            this.ae = str;
            return this;
        }

        public C0339j xt(String[] strArr) {
            this.cw = strArr;
            return this;
        }

        public C0339j j(String[] strArr) {
            this.xt = strArr;
            return this;
        }

        public C0339j xt(String str) {
            this.f24080r = str;
            return this;
        }

        public j j() {
            return new j(this, null);
        }
    }

    /* synthetic */ j(C0339j c0339j, AnonymousClass1 anonymousClass1) {
        this(c0339j);
    }

    public String j() {
        return this.f24075j;
    }

    private j(C0339j c0339j) {
        this.f24075j = c0339j.f24078j;
        this.xt = c0339j.xt;
        this.cw = c0339j.cw;
        this.f24077r = c0339j.f24080r;
        this.up = c0339j.up;
        this.f24076m = c0339j.f24079m;
        this.ae = c0339j.ae;
    }

    public static j j(int i6) {
        return xt.j(i6);
    }

    public String cw() {
        return this.f24077r;
    }

    public String r() {
        return this.up;
    }

    public String[] xt() {
        return this.xt;
    }
}
