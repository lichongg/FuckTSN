package com.umeng.commonsdk.statistics.idtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    private final int f41932a = 10;

    /* renamed from: b, reason: collision with root package name */
    private final int f41933b = 100;

    /* renamed from: c, reason: collision with root package name */
    private final String f41934c;

    /* renamed from: d, reason: collision with root package name */
    private List<com.umeng.commonsdk.statistics.proto.a> f41935d;

    /* renamed from: e, reason: collision with root package name */
    private com.umeng.commonsdk.statistics.proto.b f41936e;

    public boolean a() {
        return g();
    }

    public abstract String f();

    private boolean g() {
        com.umeng.commonsdk.statistics.proto.b bVar = this.f41936e;
        String b6 = bVar == null ? null : bVar.b();
        int h6 = bVar == null ? 0 : bVar.h();
        String a6 = a(f());
        if (a6 == null || a6.equals(b6)) {
            return false;
        }
        if (bVar == null) {
            bVar = new com.umeng.commonsdk.statistics.proto.b();
        }
        bVar.a(a6);
        bVar.a(System.currentTimeMillis());
        bVar.a(h6 + 1);
        com.umeng.commonsdk.statistics.proto.a aVar = new com.umeng.commonsdk.statistics.proto.a();
        aVar.a(this.f41934c);
        aVar.c(a6);
        aVar.b(b6);
        aVar.a(bVar.e());
        if (this.f41935d == null) {
            this.f41935d = new ArrayList(2);
        }
        this.f41935d.add(aVar);
        if (this.f41935d.size() > 10) {
            this.f41935d.remove(0);
        }
        this.f41936e = bVar;
        return true;
    }

    public void a(com.umeng.commonsdk.statistics.proto.b bVar) {
        this.f41936e = bVar;
    }

    public String b() {
        return this.f41934c;
    }

    public boolean c() {
        com.umeng.commonsdk.statistics.proto.b bVar = this.f41936e;
        return bVar == null || bVar.h() <= 100;
    }

    public com.umeng.commonsdk.statistics.proto.b d() {
        return this.f41936e;
    }

    public List<com.umeng.commonsdk.statistics.proto.a> e() {
        return this.f41935d;
    }

    public a(String str) {
        this.f41934c = str;
    }

    public void a(List<com.umeng.commonsdk.statistics.proto.a> list) {
        this.f41935d = list;
    }

    public String a(String str) {
        if (str == null) {
            return null;
        }
        String trim = str.trim();
        if (trim.length() == 0 || "0".equals(trim) || "unknown".equals(trim.toLowerCase(Locale.US))) {
            return null;
        }
        return trim;
    }

    public void a(com.umeng.commonsdk.statistics.proto.c cVar) {
        this.f41936e = cVar.c().get(this.f41934c);
        List<com.umeng.commonsdk.statistics.proto.a> h6 = cVar.h();
        if (h6 == null || h6.size() <= 0) {
            return;
        }
        if (this.f41935d == null) {
            this.f41935d = new ArrayList();
        }
        for (com.umeng.commonsdk.statistics.proto.a aVar : h6) {
            if (this.f41934c.equals(aVar.f41998a)) {
                this.f41935d.add(aVar);
            }
        }
    }
}
