package com.beizi.ad.model;

import com.beizi.ad.model.f;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class c {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private f.EnumC0127f f12810a;

        /* renamed from: b, reason: collision with root package name */
        private String f12811b;

        /* renamed from: c, reason: collision with root package name */
        private List<f> f12812c;

        public f.EnumC0127f a() {
            return this.f12810a;
        }

        public void a(f.EnumC0127f enumC0127f) {
            this.f12810a = enumC0127f;
        }

        public String b() {
            return this.f12811b;
        }

        public List<f> c() {
            return this.f12812c;
        }

        public int d() {
            List<f> list = this.f12812c;
            if (list == null) {
                return 0;
            }
            return list.size();
        }

        public void a(String str) {
            this.f12811b = str;
        }

        public void a(List<f> list) {
            this.f12812c = list;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class b {
        private String A;
        private int B;

        /* renamed from: a, reason: collision with root package name */
        private String f12813a;

        /* renamed from: b, reason: collision with root package name */
        private String f12814b;

        /* renamed from: c, reason: collision with root package name */
        private int f12815c;

        /* renamed from: d, reason: collision with root package name */
        private String f12816d;

        /* renamed from: e, reason: collision with root package name */
        private String f12817e;

        /* renamed from: f, reason: collision with root package name */
        private String f12818f;

        /* renamed from: g, reason: collision with root package name */
        private String f12819g;

        /* renamed from: h, reason: collision with root package name */
        private String f12820h;

        /* renamed from: i, reason: collision with root package name */
        private String f12821i;

        /* renamed from: j, reason: collision with root package name */
        private boolean f12822j;

        /* renamed from: k, reason: collision with root package name */
        private int f12823k;

        /* renamed from: l, reason: collision with root package name */
        private j f12824l;

        /* renamed from: m, reason: collision with root package name */
        private C0123b f12825m;

        /* renamed from: n, reason: collision with root package name */
        private C0124c f12826n;

        /* renamed from: o, reason: collision with root package name */
        private List<j> f12827o;

        /* renamed from: p, reason: collision with root package name */
        private String f12828p;

        /* renamed from: q, reason: collision with root package name */
        private String f12829q;

        /* renamed from: r, reason: collision with root package name */
        private String f12830r;

        /* renamed from: s, reason: collision with root package name */
        private String f12831s;

        /* renamed from: t, reason: collision with root package name */
        private String f12832t;

        /* renamed from: u, reason: collision with root package name */
        private String f12833u;

        /* renamed from: v, reason: collision with root package name */
        private String f12834v;

        /* renamed from: w, reason: collision with root package name */
        private a f12835w;

        /* renamed from: x, reason: collision with root package name */
        private String f12836x;

        /* renamed from: y, reason: collision with root package name */
        private String f12837y;

        /* renamed from: z, reason: collision with root package name */
        private String f12838z;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        public static class a {

            /* renamed from: a, reason: collision with root package name */
            private int f12839a;

            /* renamed from: b, reason: collision with root package name */
            private int f12840b;

            /* renamed from: c, reason: collision with root package name */
            private int f12841c;

            public int a() {
                return this.f12839a;
            }

            public int b() {
                return this.f12840b;
            }

            public int c() {
                return this.f12841c;
            }

            public void a(int i6) {
                this.f12839a = i6;
            }

            public void b(int i6) {
                this.f12840b = i6;
            }

            public void c(int i6) {
                this.f12841c = i6;
            }
        }

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        /* renamed from: com.beizi.ad.model.c$b$b, reason: collision with other inner class name */
        public static class C0123b implements Serializable {

            /* renamed from: a, reason: collision with root package name */
            private List<String> f12842a;

            /* renamed from: b, reason: collision with root package name */
            private List<String> f12843b;

            /* renamed from: c, reason: collision with root package name */
            private List<String> f12844c;

            /* renamed from: d, reason: collision with root package name */
            private List<String> f12845d;

            /* renamed from: e, reason: collision with root package name */
            private List<String> f12846e;

            /* renamed from: f, reason: collision with root package name */
            private List<String> f12847f;

            /* renamed from: g, reason: collision with root package name */
            private List<String> f12848g;

            /* renamed from: h, reason: collision with root package name */
            private List<String> f12849h;

            /* renamed from: i, reason: collision with root package name */
            private List<String> f12850i;

            /* renamed from: j, reason: collision with root package name */
            private List<String> f12851j;

            /* renamed from: k, reason: collision with root package name */
            private List<String> f12852k;

            /* renamed from: l, reason: collision with root package name */
            private List<String> f12853l;

            /* renamed from: m, reason: collision with root package name */
            private List<String> f12854m;

            /* renamed from: n, reason: collision with root package name */
            private List<String> f12855n;

            /* renamed from: o, reason: collision with root package name */
            private List<String> f12856o;

            /* renamed from: p, reason: collision with root package name */
            private List<String> f12857p;

            /* renamed from: q, reason: collision with root package name */
            private List<String> f12858q;

            public List<String> a() {
                return this.f12842a;
            }

            public List<String> b() {
                return this.f12843b;
            }

            public List<String> c() {
                return this.f12844c;
            }

            public List<String> d() {
                return this.f12845d;
            }

            public void e(List<String> list) {
                this.f12846e = list;
            }

            public void f(List<String> list) {
                this.f12847f = list;
            }

            public void g(List<String> list) {
                this.f12848g = list;
            }

            public void h(List<String> list) {
                this.f12849h = list;
            }

            public void i(List<String> list) {
                this.f12850i = list;
            }

            public void j(List<String> list) {
                this.f12851j = list;
            }

            public void a(List<String> list) {
                this.f12842a = list;
            }

            public void b(List<String> list) {
                this.f12843b = list;
            }

            public void c(List<String> list) {
                this.f12844c = list;
            }

            public void d(List<String> list) {
                this.f12845d = list;
            }

            public List<String> e() {
                return this.f12853l;
            }

            public List<String> f() {
                return this.f12854m;
            }

            public List<String> g() {
                return this.f12855n;
            }

            public List<String> h() {
                return this.f12856o;
            }

            public List<String> i() {
                return this.f12857p;
            }

            public List<String> j() {
                return this.f12858q;
            }

            public void k(List<String> list) {
                this.f12852k = list;
            }

            public void l(List<String> list) {
                this.f12853l = list;
            }

            public void m(List<String> list) {
                this.f12854m = list;
            }

            public void n(List<String> list) {
                this.f12855n = list;
            }

            public void o(List<String> list) {
                this.f12856o = list;
            }

            public void p(List<String> list) {
                this.f12857p = list;
            }

            public void q(List<String> list) {
                this.f12858q = list;
            }
        }

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        /* renamed from: com.beizi.ad.model.c$b$c, reason: collision with other inner class name */
        public static class C0124c {

            /* renamed from: a, reason: collision with root package name */
            private List<String> f12859a;

            /* renamed from: b, reason: collision with root package name */
            private List<String> f12860b;

            /* renamed from: c, reason: collision with root package name */
            private List<String> f12861c;

            /* renamed from: d, reason: collision with root package name */
            private List<String> f12862d;

            /* renamed from: e, reason: collision with root package name */
            private List<String> f12863e;

            /* renamed from: f, reason: collision with root package name */
            private List<a> f12864f;

            /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
            /* renamed from: com.beizi.ad.model.c$b$c$a */
            public static class a {

                /* renamed from: a, reason: collision with root package name */
                private int f12865a;

                /* renamed from: b, reason: collision with root package name */
                private List<String> f12866b;

                public void a(int i6) {
                    this.f12865a = i6;
                }

                public void a(List<String> list) {
                    this.f12866b = list;
                }
            }

            public void a(List<String> list) {
                this.f12859a = list;
            }

            public void b(List<String> list) {
                this.f12860b = list;
            }

            public void c(List<String> list) {
                this.f12861c = list;
            }

            public void d(List<String> list) {
                this.f12862d = list;
            }

            public void e(List<String> list) {
                this.f12863e = list;
            }

            public void f(List<a> list) {
                this.f12864f = list;
            }
        }

        public String a() {
            return this.f12813a;
        }

        public String b() {
            return this.f12814b;
        }

        public int c() {
            return this.f12815c;
        }

        public String d() {
            return this.f12816d;
        }

        public String e() {
            return this.f12817e;
        }

        public String f() {
            return this.f12819g;
        }

        public String g() {
            return this.f12820h;
        }

        public String h() {
            return this.f12821i;
        }

        public j i() {
            return this.f12824l;
        }

        public C0123b j() {
            return this.f12825m;
        }

        public C0124c k() {
            return this.f12826n;
        }

        public List<j> l() {
            return this.f12827o;
        }

        public String m() {
            return this.f12828p;
        }

        public String n() {
            return this.f12829q;
        }

        public String o() {
            return this.f12830r;
        }

        public String p() {
            return this.f12831s;
        }

        public String q() {
            return this.f12832t;
        }

        public String r() {
            return this.f12833u;
        }

        public void a(String str) {
            this.f12813a = str;
        }

        public void b(String str) {
            this.f12814b = str;
        }

        public void c(String str) {
            this.f12816d = str;
        }

        public void d(String str) {
            this.f12817e = str;
        }

        public void e(String str) {
            this.f12818f = str;
        }

        public void f(String str) {
            this.f12819g = str;
        }

        public void g(String str) {
            this.f12820h = str;
        }

        public void h(String str) {
            this.f12828p = str;
        }

        public void i(String str) {
            this.f12829q = str;
        }

        public void j(String str) {
            this.f12830r = str;
        }

        public void k(String str) {
            this.f12831s = str;
        }

        public void l(String str) {
            this.f12832t = str;
        }

        public void m(String str) {
            this.f12833u = str;
        }

        public void n(String str) {
            this.f12834v = str;
        }

        public void o(String str) {
            this.f12836x = str;
        }

        public void p(String str) {
            this.f12837y = str;
        }

        public void q(String str) {
            this.f12838z = str;
        }

        public void r(String str) {
            this.A = str;
        }

        public String s() {
            return this.f12834v;
        }

        public a t() {
            return this.f12835w;
        }

        public String u() {
            return this.f12836x;
        }

        public String v() {
            return this.f12837y;
        }

        public String w() {
            return this.f12838z;
        }

        public String x() {
            return this.A;
        }

        public int y() {
            return this.B;
        }

        public void a(int i6) {
            this.f12815c = i6;
        }

        public void b(int i6) {
            this.f12823k = i6;
        }

        public void c(int i6) {
            this.B = i6;
        }

        public void a(boolean z5) {
            this.f12822j = z5;
        }

        public void a(C0123b c0123b) {
            this.f12825m = c0123b;
        }

        public void a(C0124c c0124c) {
            this.f12826n = c0124c;
        }

        public void a(List<j> list) {
            this.f12827o = list;
        }

        public void a(a aVar) {
            this.f12835w = aVar;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.beizi.ad.model.c$c, reason: collision with other inner class name */
    public static class C0125c {

        /* renamed from: a, reason: collision with root package name */
        private String f12867a;

        /* renamed from: b, reason: collision with root package name */
        private String f12868b;

        /* renamed from: c, reason: collision with root package name */
        private String f12869c;

        /* renamed from: d, reason: collision with root package name */
        private String f12870d;

        public String a() {
            return this.f12867a;
        }

        public String b() {
            return this.f12868b;
        }

        public String c() {
            return this.f12869c;
        }

        public String d() {
            return this.f12870d;
        }

        public void a(String str) {
            this.f12867a = str;
        }

        public void b(String str) {
            this.f12868b = str;
        }

        public void c(String str) {
            this.f12869c = str;
        }

        public void d(String str) {
            this.f12870d = str;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        private String f12871a;

        /* renamed from: b, reason: collision with root package name */
        private b f12872b;

        /* renamed from: c, reason: collision with root package name */
        private C0125c f12873c;

        /* renamed from: d, reason: collision with root package name */
        private List<a> f12874d;

        /* renamed from: e, reason: collision with root package name */
        private List<g> f12875e;

        /* renamed from: f, reason: collision with root package name */
        private String f12876f;

        /* renamed from: g, reason: collision with root package name */
        private String f12877g;

        /* renamed from: h, reason: collision with root package name */
        private e f12878h;

        /* renamed from: i, reason: collision with root package name */
        private String f12879i;

        /* renamed from: j, reason: collision with root package name */
        private int f12880j;

        /* renamed from: k, reason: collision with root package name */
        private k f12881k;

        /* renamed from: l, reason: collision with root package name */
        private String f12882l;

        /* renamed from: m, reason: collision with root package name */
        private String f12883m;

        /* renamed from: n, reason: collision with root package name */
        private String f12884n;

        public String a() {
            return this.f12871a;
        }

        public String b() {
            return this.f12877g;
        }

        public b c() {
            return this.f12872b;
        }

        public int d() {
            List<a> list = this.f12874d;
            if (list == null) {
                return 0;
            }
            return list.size();
        }

        public C0125c e() {
            return this.f12873c;
        }

        public List<a> f() {
            return this.f12874d;
        }

        public List<g> g() {
            return this.f12875e;
        }

        public void a(String str) {
            this.f12871a = str;
        }

        public void b(String str) {
            this.f12877g = str;
        }

        public void c(String str) {
            this.f12876f = str;
        }

        public void d(String str) {
            this.f12879i = str;
        }

        public void e(String str) {
            this.f12882l = str;
        }

        public void f(String str) {
            this.f12883m = str;
        }

        public void g(String str) {
            this.f12884n = str;
        }

        public int h() {
            List<g> list = this.f12875e;
            if (list == null) {
                return 0;
            }
            return list.size();
        }

        public String i() {
            return this.f12876f;
        }

        public e j() {
            return this.f12878h;
        }

        public String k() {
            return this.f12879i;
        }

        public int l() {
            return this.f12880j;
        }

        public k m() {
            return this.f12881k;
        }

        public String n() {
            return this.f12882l;
        }

        public String o() {
            return this.f12883m;
        }

        public String p() {
            return this.f12884n;
        }

        public void a(b bVar) {
            this.f12872b = bVar;
        }

        public void a(C0125c c0125c) {
            this.f12873c = c0125c;
        }

        public void a(List<a> list) {
            this.f12874d = list;
        }

        public void a(e eVar) {
            this.f12878h = eVar;
        }

        public void a(int i6) {
            this.f12880j = i6;
        }

        public void a(k kVar) {
            this.f12881k = kVar;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class e {

        /* renamed from: a, reason: collision with root package name */
        private boolean f12885a;

        /* renamed from: b, reason: collision with root package name */
        private double f12886b;

        /* renamed from: c, reason: collision with root package name */
        private double f12887c;

        public boolean a() {
            return this.f12885a;
        }

        public double b() {
            return this.f12886b;
        }

        public void a(boolean z5) {
            this.f12885a = z5;
        }

        public void b(double d6) {
            this.f12887c = d6;
        }

        public double c() {
            return this.f12887c;
        }

        public void a(double d6) {
            this.f12886b = d6;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class f {

        /* renamed from: a, reason: collision with root package name */
        private String f12888a;

        /* renamed from: b, reason: collision with root package name */
        private String f12889b;

        public String a() {
            return this.f12888a;
        }

        public String b() {
            return this.f12889b;
        }

        public void a(String str) {
            this.f12888a = str;
        }

        public void b(String str) {
            this.f12889b = str;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class g {

        /* renamed from: a, reason: collision with root package name */
        private String f12890a;

        /* renamed from: b, reason: collision with root package name */
        private String f12891b;

        /* renamed from: c, reason: collision with root package name */
        private String f12892c;

        public String a() {
            return this.f12890a;
        }

        public String b() {
            return this.f12891b;
        }

        public String c() {
            return this.f12892c;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class h {

        /* renamed from: a, reason: collision with root package name */
        private String f12893a;

        /* renamed from: b, reason: collision with root package name */
        private String f12894b;

        public String a() {
            return this.f12893a;
        }

        public String b() {
            return this.f12894b;
        }

        public void a(String str) {
            this.f12893a = str;
        }

        public void b(String str) {
            this.f12894b = str;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class i {

        /* renamed from: a, reason: collision with root package name */
        private int f12895a = -1;

        /* renamed from: b, reason: collision with root package name */
        private int f12896b = -1;

        /* renamed from: c, reason: collision with root package name */
        private int f12897c = -1;

        /* renamed from: d, reason: collision with root package name */
        private int f12898d = -1;

        /* renamed from: e, reason: collision with root package name */
        private String f12899e;

        /* renamed from: f, reason: collision with root package name */
        private String f12900f;

        /* renamed from: g, reason: collision with root package name */
        private String f12901g;

        public int a() {
            return this.f12895a;
        }

        public int b() {
            return this.f12896b;
        }

        public int c() {
            return this.f12897c;
        }

        public int d() {
            return this.f12898d;
        }

        public void a(int i6) {
            this.f12895a = i6;
        }

        public void b(int i6) {
            this.f12896b = i6;
        }

        public void c(int i6) {
            this.f12897c = i6;
        }

        public void d(int i6) {
            this.f12898d = i6;
        }

        public String e() {
            return this.f12899e;
        }

        public String f() {
            return this.f12900f;
        }

        public String g() {
            return this.f12901g;
        }

        public void a(String str) {
            this.f12899e = str;
        }

        public void b(String str) {
            this.f12900f = str;
        }

        public void c(String str) {
            this.f12901g = str;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class j {

        /* renamed from: a, reason: collision with root package name */
        private String f12902a;

        /* renamed from: b, reason: collision with root package name */
        private String f12903b;

        /* renamed from: c, reason: collision with root package name */
        private String f12904c;

        /* renamed from: d, reason: collision with root package name */
        private String f12905d;

        /* renamed from: e, reason: collision with root package name */
        private String f12906e;

        /* renamed from: f, reason: collision with root package name */
        private String f12907f;

        /* renamed from: g, reason: collision with root package name */
        private String f12908g;

        /* renamed from: h, reason: collision with root package name */
        private String f12909h;

        /* renamed from: i, reason: collision with root package name */
        private String f12910i;

        /* renamed from: j, reason: collision with root package name */
        private String f12911j;

        public String a() {
            return this.f12902a;
        }

        public String b() {
            return this.f12903b;
        }

        public String c() {
            return this.f12904c;
        }

        public String d() {
            return this.f12905d;
        }

        public String e() {
            return this.f12906e;
        }

        public void f(String str) {
            this.f12907f = str;
        }

        public void g(String str) {
            this.f12908g = str;
        }

        public void h(String str) {
            this.f12909h = str;
        }

        public void i(String str) {
            this.f12910i = str;
        }

        public void a(String str) {
            this.f12902a = str;
        }

        public void b(String str) {
            this.f12903b = str;
        }

        public void c(String str) {
            this.f12904c = str;
        }

        public void d(String str) {
            this.f12905d = str;
        }

        public void e(String str) {
            this.f12906e = str;
        }

        public String f() {
            return this.f12908g;
        }

        public String g() {
            return this.f12909h;
        }

        public String h() {
            return this.f12910i;
        }

        public String i() {
            return this.f12911j;
        }

        public void j(String str) {
            this.f12911j = str;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class k {

        /* renamed from: a, reason: collision with root package name */
        private int f12912a;

        /* renamed from: b, reason: collision with root package name */
        private int f12913b;

        /* renamed from: c, reason: collision with root package name */
        private int f12914c;

        /* renamed from: d, reason: collision with root package name */
        private int f12915d;

        public int a() {
            return this.f12912a;
        }

        public int b() {
            return this.f12913b;
        }

        public int c() {
            return this.f12914c;
        }

        public int d() {
            return this.f12915d;
        }

        public void a(int i6) {
            this.f12912a = i6;
        }

        public void b(int i6) {
            this.f12913b = i6;
        }

        public void c(int i6) {
            this.f12914c = i6;
        }

        public void d(int i6) {
            this.f12915d = i6;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class l {

        /* renamed from: a, reason: collision with root package name */
        private int f12916a;

        /* renamed from: b, reason: collision with root package name */
        private String f12917b;

        /* renamed from: c, reason: collision with root package name */
        private String f12918c;

        /* renamed from: d, reason: collision with root package name */
        private long f12919d;

        /* renamed from: e, reason: collision with root package name */
        private List<m> f12920e;

        public int a() {
            List<m> list = this.f12920e;
            if (list == null) {
                return 0;
            }
            return list.size();
        }

        public int b() {
            return this.f12916a;
        }

        public List<m> c() {
            return this.f12920e;
        }

        /* JADX WARN: Can't wrap try/catch for region: R(20:19|(4:21|(4:24|(5:26|(4:29|(2:31|32)(2:34|35)|33|27)|36|37|38)(2:40|41)|39|22)|42|43)(1:153)|44|(1:46)|47|(1:49)|50|(10:52|(4:54|(4:57|(2:59|60)(2:62|63)|61|55)|64|65)(1:151)|66|(1:68)|69|(3:71|(4:73|(4:76|(2:78|79)(2:81|82)|80|74)|83|84)|85)|86|87|(2:89|(7:91|(1:93)|94|(1:96)|97|(1:99)|100))|101)(1:152)|(2:102|103)|(3:123|124|(18:126|(1:128)|129|(1:131)|132|133|134|(1:136)|137|106|107|108|(1:112)|113|114|(1:116)|117|118))|105|106|107|108|(2:110|112)|113|114|(0)|117|118) */
        /* JADX WARN: Code restructure failed: missing block: B:121:0x0680, code lost:
        
            r0 = e;
         */
        /* JADX WARN: Removed duplicated region for block: B:116:0x068f A[Catch: JSONException -> 0x0238, TryCatch #19 {JSONException -> 0x0238, blocks: (B:10:0x00a0, B:12:0x00ad, B:15:0x018f, B:17:0x0195, B:19:0x019d, B:22:0x01ce, B:24:0x01d4, B:26:0x0203, B:27:0x020d, B:29:0x0213, B:31:0x0219, B:33:0x0241, B:37:0x0246, B:39:0x024e, B:43:0x025b, B:44:0x026b, B:46:0x0273, B:47:0x029f, B:49:0x02ae, B:50:0x02b5, B:52:0x02c2, B:54:0x02ce, B:55:0x02d4, B:57:0x02da, B:59:0x02e0, B:61:0x034b, B:65:0x0352, B:66:0x035a, B:68:0x0400, B:69:0x04e0, B:71:0x04ed, B:74:0x0540, B:76:0x0546, B:78:0x054c, B:80:0x0573, B:84:0x0578, B:85:0x057b, B:101:0x05c0, B:114:0x0689, B:116:0x068f, B:117:0x0696, B:119:0x06c1, B:122:0x0685, B:150:0x05bd, B:157:0x06d0, B:212:0x080b, B:218:0x0807, B:87:0x057e, B:89:0x0584, B:91:0x058f, B:93:0x0595, B:94:0x059f, B:96:0x05a5, B:97:0x05ac, B:99:0x05b2, B:100:0x05b9), top: B:9:0x00a0, inners: #9 }] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public static com.beizi.ad.model.c.l c(java.lang.String r40) throws org.json.JSONException {
            /*
                Method dump skipped, instructions count: 2173
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.beizi.ad.model.c.l.c(java.lang.String):com.beizi.ad.model.c$l");
        }

        public void a(int i6) {
            this.f12916a = i6;
        }

        public void b(String str) {
            this.f12918c = str;
        }

        private static boolean b(JSONArray jSONArray) {
            return jSONArray != null && jSONArray.length() > 0;
        }

        public void a(String str) {
            this.f12917b = str;
        }

        public void a(long j6) {
            this.f12919d = j6;
        }

        public void a(List<m> list) {
            this.f12920e = list;
        }

        public static l a(byte[] bArr) throws JSONException {
            if (bArr == null) {
                return null;
            }
            try {
                return c(new String(bArr, "UTF-8"));
            } catch (UnsupportedEncodingException e6) {
                e6.printStackTrace();
                return null;
            }
        }

        public static String a(InputStream inputStream) throws IOException {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[1024];
            while (true) {
                int read = inputStream.read(bArr);
                if (read != -1) {
                    byteArrayOutputStream.write(bArr, 0, read);
                } else {
                    return byteArrayOutputStream.toString("UTF-8");
                }
            }
        }

        private static ArrayList<String> a(JSONArray jSONArray) throws JSONException {
            ArrayList<String> arrayList = new ArrayList<>();
            if (b(jSONArray)) {
                for (int i6 = 0; i6 < jSONArray.length(); i6++) {
                    arrayList.add(jSONArray.getString(i6));
                }
            }
            return arrayList;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class m {

        /* renamed from: a, reason: collision with root package name */
        private String f12921a;

        /* renamed from: b, reason: collision with root package name */
        private String f12922b;

        /* renamed from: c, reason: collision with root package name */
        private f.a f12923c;

        /* renamed from: d, reason: collision with root package name */
        private int f12924d;

        /* renamed from: e, reason: collision with root package name */
        private f.h f12925e;

        /* renamed from: f, reason: collision with root package name */
        private String f12926f;

        /* renamed from: g, reason: collision with root package name */
        private String f12927g;

        /* renamed from: h, reason: collision with root package name */
        private h f12928h;

        /* renamed from: i, reason: collision with root package name */
        private boolean f12929i;

        /* renamed from: j, reason: collision with root package name */
        private int f12930j;

        /* renamed from: k, reason: collision with root package name */
        private boolean f12931k;

        /* renamed from: l, reason: collision with root package name */
        private int f12932l;

        /* renamed from: m, reason: collision with root package name */
        private boolean f12933m;

        /* renamed from: n, reason: collision with root package name */
        private boolean f12934n;

        /* renamed from: o, reason: collision with root package name */
        private boolean f12935o;

        /* renamed from: p, reason: collision with root package name */
        private boolean f12936p;

        /* renamed from: q, reason: collision with root package name */
        private boolean f12937q;

        /* renamed from: r, reason: collision with root package name */
        private int f12938r;

        /* renamed from: s, reason: collision with root package name */
        private int f12939s;

        /* renamed from: t, reason: collision with root package name */
        private String f12940t;

        /* renamed from: u, reason: collision with root package name */
        private List<d> f12941u;

        /* renamed from: v, reason: collision with root package name */
        private i f12942v;

        public String a() {
            return this.f12921a;
        }

        public String b() {
            return this.f12922b;
        }

        public f.a c() {
            return this.f12923c;
        }

        public int d() {
            return this.f12924d;
        }

        public f.h e() {
            return this.f12925e;
        }

        public String f() {
            return this.f12926f;
        }

        public void a(String str) {
            this.f12921a = str;
        }

        public void b(String str) {
            this.f12922b = str;
        }

        public void c(String str) {
            this.f12926f = str;
        }

        public void d(String str) {
            this.f12927g = str;
        }

        public void e(boolean z5) {
            this.f12935o = z5;
        }

        public void f(boolean z5) {
            this.f12936p = z5;
        }

        public String g() {
            return this.f12927g;
        }

        public h h() {
            return this.f12928h;
        }

        public boolean i() {
            return this.f12929i;
        }

        public int j() {
            return this.f12930j;
        }

        public boolean k() {
            return this.f12931k;
        }

        public int l() {
            return this.f12932l;
        }

        public boolean m() {
            return this.f12933m;
        }

        public boolean n() {
            return this.f12934n;
        }

        public boolean o() {
            return this.f12935o;
        }

        public boolean p() {
            return this.f12936p;
        }

        public boolean q() {
            return this.f12937q;
        }

        public List<d> r() {
            return this.f12941u;
        }

        public int s() {
            List<d> list = this.f12941u;
            if (list == null) {
                return 0;
            }
            return list.size();
        }

        public i t() {
            return this.f12942v;
        }

        public void a(f.a aVar) {
            this.f12923c = aVar;
        }

        public void b(int i6) {
            this.f12930j = i6;
        }

        public void c(int i6) {
            this.f12932l = i6;
        }

        public void d(boolean z5) {
            this.f12934n = z5;
        }

        public void e(int i6) {
            this.f12939s = i6;
        }

        public void a(int i6) {
            this.f12924d = i6;
        }

        public void b(boolean z5) {
            this.f12931k = z5;
        }

        public void c(boolean z5) {
            this.f12933m = z5;
        }

        public void d(int i6) {
            this.f12938r = i6;
        }

        public void e(String str) {
            this.f12940t = str;
        }

        public void a(f.h hVar) {
            this.f12925e = hVar;
        }

        public void a(h hVar) {
            this.f12928h = hVar;
        }

        public void a(boolean z5) {
            this.f12929i = z5;
        }

        public void a(List<d> list) {
            this.f12941u = list;
        }

        public void a(i iVar) {
            this.f12942v = iVar;
        }
    }
}
