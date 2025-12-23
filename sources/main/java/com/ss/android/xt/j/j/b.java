package com.ss.android.xt.j.j;

import org.json.JSONObject;
import w2.r;

/* loaded from: D:\Downloads\app\classes6.dex */
public class b implements com.ss.android.j.j.cw.c {

    /* renamed from: a, reason: collision with root package name */
    protected int f39072a;

    /* renamed from: b, reason: collision with root package name */
    protected int f39073b;

    /* renamed from: c, reason: collision with root package name */
    protected boolean f39074c;

    /* renamed from: d, reason: collision with root package name */
    protected boolean f39075d;

    /* renamed from: e, reason: collision with root package name */
    protected boolean f39076e;

    /* renamed from: f, reason: collision with root package name */
    protected int f39077f;

    /* renamed from: g, reason: collision with root package name */
    protected JSONObject f39078g;

    /* renamed from: i, reason: collision with root package name */
    protected boolean f39080i;

    /* renamed from: o, reason: collision with root package name */
    protected Object f39086o;

    /* renamed from: p, reason: collision with root package name */
    protected Object f39087p;

    /* renamed from: h, reason: collision with root package name */
    protected boolean f39079h = true;

    /* renamed from: j, reason: collision with root package name */
    protected boolean f39081j = true;

    /* renamed from: k, reason: collision with root package name */
    protected boolean f39082k = true;

    /* renamed from: l, reason: collision with root package name */
    protected boolean f39083l = true;

    /* renamed from: m, reason: collision with root package name */
    protected boolean f39084m = true;

    /* renamed from: n, reason: collision with root package name */
    protected r f39085n = null;

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        b f39088a = new b();

        public a a(boolean z5) {
            this.f39088a.f39081j = z5;
            return this;
        }

        public a b(int i6) {
            this.f39088a.f39077f = i6;
            return this;
        }

        public a d(boolean z5) {
            this.f39088a.f39083l = z5;
            return this;
        }

        public a e(int i6) {
            this.f39088a.f39072a = i6;
            return this;
        }

        public a f(Object obj) {
            this.f39088a.f39087p = obj;
            return this;
        }

        public a g(JSONObject jSONObject) {
            this.f39088a.f39078g = jSONObject;
            return this;
        }

        public a h(boolean z5) {
            this.f39088a.f39074c = z5;
            return this;
        }

        public b i() {
            return this.f39088a;
        }

        public a j(boolean z5) {
            this.f39088a.f39080i = z5;
            return this;
        }

        public a k(boolean z5) {
            this.f39088a.f39084m = z5;
            return this;
        }

        public a l(boolean z5) {
            this.f39088a.f39076e = z5;
            return this;
        }

        public a m(boolean z5) {
            this.f39088a.f39082k = z5;
            return this;
        }

        public a n(boolean z5) {
            this.f39088a.f39079h = z5;
            return this;
        }

        public a o(int i6) {
            this.f39088a.f39073b = i6;
            return this;
        }

        public a p(boolean z5) {
            this.f39088a.f39075d = z5;
            return this;
        }

        @Deprecated
        public a c(boolean z5) {
            return this;
        }
    }

    @Override // com.ss.android.j.j.cw.c
    public int j() {
        return this.f39072a;
    }

    @Override // com.ss.android.j.j.cw.c
    public int m() {
        return 1;
    }

    @Override // com.ss.android.j.j.cw.c
    public boolean up() {
        return false;
    }

    @Override // com.ss.android.j.j.cw.c
    public int xt() {
        return this.f39073b;
    }

    public void a(boolean z5) {
        this.f39080i = z5;
    }

    @Override // com.ss.android.j.j.cw.c
    public Object ae() {
        return this.f39086o;
    }

    @Override // com.ss.android.j.j.cw.c
    public boolean av() {
        return this.f39083l;
    }

    @Override // com.ss.android.j.j.cw.c
    public boolean az() {
        return this.f39082k;
    }

    public boolean b() {
        return this.f39084m;
    }

    public void c(Object obj) {
        this.f39087p = obj;
    }

    @Override // com.ss.android.j.j.cw.c
    public boolean cw() {
        return this.f39074c;
    }

    public void d(JSONObject jSONObject) {
        this.f39078g = jSONObject;
    }

    public void e(r rVar) {
        this.f39085n = rVar;
    }

    public void f(boolean z5) {
        this.f39084m = z5;
    }

    @Override // com.ss.android.j.j.cw.c
    public int g() {
        return this.f39077f;
    }

    public r h() {
        return this.f39085n;
    }

    @Override // com.ss.android.j.j.cw.c
    public void j(int i6) {
        this.f39073b = i6;
    }

    @Override // com.ss.android.j.j.cw.c
    public boolean jy() {
        return this.f39080i;
    }

    @Override // com.ss.android.j.j.cw.c
    public JSONObject oq() {
        return this.f39078g;
    }

    @Override // com.ss.android.j.j.cw.c
    public Object qv() {
        return this.f39087p;
    }

    @Override // com.ss.android.j.j.cw.c
    public boolean r() {
        return this.f39075d;
    }

    @Override // com.ss.android.j.j.cw.c
    public boolean tl() {
        return this.f39076e;
    }

    @Override // com.ss.android.j.j.cw.c
    public boolean vl() {
        return this.f39079h;
    }

    @Override // com.ss.android.j.j.cw.c
    public boolean ws() {
        return this.f39081j;
    }

    @Override // com.ss.android.j.j.cw.c
    public void xt(int i6) {
        this.f39072a = i6;
    }

    @Override // com.ss.android.j.j.cw.c
    public void j(boolean z5) {
        this.f39079h = z5;
    }

    @Override // com.ss.android.j.j.cw.c
    public void xt(boolean z5) {
        this.f39081j = z5;
    }
}
