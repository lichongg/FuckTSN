package com.ss.android.j.j.up;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.view.View;

/* loaded from: D:\Downloads\app\classes6.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public Context f38247a;

    /* renamed from: b, reason: collision with root package name */
    public String f38248b;

    /* renamed from: c, reason: collision with root package name */
    public String f38249c;

    /* renamed from: d, reason: collision with root package name */
    public String f38250d;

    /* renamed from: e, reason: collision with root package name */
    public String f38251e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f38252f;

    /* renamed from: g, reason: collision with root package name */
    public Drawable f38253g;

    /* renamed from: h, reason: collision with root package name */
    public c f38254h;

    /* renamed from: i, reason: collision with root package name */
    public View f38255i;

    /* renamed from: j, reason: collision with root package name */
    public int f38256j;

    /* renamed from: com.ss.android.j.j.up.a$a, reason: collision with other inner class name */
    static /* synthetic */ class C0767a {
    }

    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        private Context f38257a;

        /* renamed from: b, reason: collision with root package name */
        private String f38258b;

        /* renamed from: c, reason: collision with root package name */
        private String f38259c;

        /* renamed from: d, reason: collision with root package name */
        private String f38260d;

        /* renamed from: e, reason: collision with root package name */
        private String f38261e;

        /* renamed from: f, reason: collision with root package name */
        private boolean f38262f;

        /* renamed from: g, reason: collision with root package name */
        private Drawable f38263g;

        /* renamed from: h, reason: collision with root package name */
        private c f38264h;

        /* renamed from: i, reason: collision with root package name */
        public View f38265i;

        /* renamed from: j, reason: collision with root package name */
        public int f38266j;

        public b b(String str) {
            this.f38260d = str;
            return this;
        }

        public b e(int i6) {
            this.f38266j = i6;
            return this;
        }

        public b f(Drawable drawable) {
            this.f38263g = drawable;
            return this;
        }

        public b g(c cVar) {
            this.f38264h = cVar;
            return this;
        }

        public b h(String str) {
            this.f38258b = str;
            return this;
        }

        public b i(boolean z5) {
            this.f38262f = z5;
            return this;
        }

        public a j() {
            return new a(this, null);
        }

        public b l(String str) {
            this.f38261e = str;
            return this;
        }

        public b p(String str) {
            this.f38259c = str;
            return this;
        }

        public b(Context context) {
            this.f38257a = context;
        }
    }

    public interface c {
        void cw(DialogInterface dialogInterface);

        void j(DialogInterface dialogInterface);

        void xt(DialogInterface dialogInterface);
    }

    /* synthetic */ a(b bVar, C0767a c0767a) {
        this(bVar);
    }

    private a(b bVar) {
        this.f38252f = true;
        this.f38247a = bVar.f38257a;
        this.f38248b = bVar.f38258b;
        this.f38249c = bVar.f38259c;
        this.f38250d = bVar.f38260d;
        this.f38251e = bVar.f38261e;
        this.f38252f = bVar.f38262f;
        this.f38253g = bVar.f38263g;
        this.f38254h = bVar.f38264h;
        this.f38255i = bVar.f38265i;
        this.f38256j = bVar.f38266j;
    }
}
