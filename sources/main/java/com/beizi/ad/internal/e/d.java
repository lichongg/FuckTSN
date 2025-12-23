package com.beizi.ad.internal.e;

import com.beizi.ad.i;
import com.beizi.ad.internal.k;
import com.beizi.ad.internal.m;
import java.lang.ref.SoftReference;
import java.util.LinkedList;
import java.util.concurrent.RejectedExecutionException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class d extends m {

    /* renamed from: a, reason: collision with root package name */
    private final SoftReference<c> f11867a;

    /* renamed from: b, reason: collision with root package name */
    private com.beizi.ad.internal.e.a.a f11868b;

    @Override // com.beizi.ad.internal.f
    public void a() {
        c cVar = this.f11867a.get();
        if (cVar == null) {
            return;
        }
        g();
        try {
            cVar.a(this);
            cVar.executeOnExecutor(com.beizi.ad.lance.a.c.b().c(), new Void[0]);
        } catch (IllegalStateException e6) {
            e6.getMessage();
        } catch (RejectedExecutionException unused) {
        }
    }

    @Override // com.beizi.ad.internal.f
    public com.beizi.ad.b.a d() {
        return null;
    }

    @Override // com.beizi.ad.internal.f
    public com.beizi.ad.internal.e c() {
        c cVar = this.f11867a.get();
        if (cVar != null) {
            return cVar.d();
        }
        return null;
    }

    @Override // com.beizi.ad.internal.m
    public void e() {
        c cVar = this.f11867a.get();
        if (cVar != null) {
            cVar.cancel(true);
        }
        a((LinkedList<com.beizi.ad.internal.d.a>) null);
        com.beizi.ad.internal.e.a.a aVar = this.f11868b;
        if (aVar != null) {
            aVar.a(true);
            this.f11868b = null;
        }
    }

    public d(c cVar) {
        this.f11867a = new SoftReference<>(cVar);
    }

    @Override // com.beizi.ad.internal.f
    public void a(int i6) {
        h();
        c cVar = this.f11867a.get();
        if (cVar != null) {
            cVar.e().a(i6);
        }
    }

    @Override // com.beizi.ad.internal.f
    public void a(final com.beizi.ad.internal.f.c cVar) {
        c cVar2 = this.f11867a.get();
        if (cVar2 != null) {
            boolean h6 = cVar.h();
            boolean z5 = (b() == null || b().isEmpty()) ? false : true;
            if (!h6 && !z5) {
                cVar2.e().a(3);
                return;
            }
            if (h6) {
                a(cVar.g());
            }
            if (b() != null && !b().isEmpty()) {
                com.beizi.ad.internal.d.a i6 = i();
                if (i6 != null) {
                    i6.a(cVar.j());
                }
                this.f11868b = com.beizi.ad.internal.e.a.a.a(i6, this, cVar);
                return;
            }
            final a aVar = (a) cVar.a();
            aVar.a(cVar2.d().a());
            aVar.a(cVar2.a());
            aVar.b(cVar2.b());
            a(new com.beizi.ad.internal.f.b() { // from class: com.beizi.ad.internal.e.d.1
                @Override // com.beizi.ad.internal.f.b
                public boolean b() {
                    return false;
                }

                @Override // com.beizi.ad.internal.f.b
                public com.beizi.ad.internal.view.c c() {
                    return null;
                }

                @Override // com.beizi.ad.internal.f.b
                public k a() {
                    return k.NATIVE;
                }

                @Override // com.beizi.ad.internal.f.b
                public i d() {
                    return aVar;
                }

                @Override // com.beizi.ad.internal.f.b
                public String e() {
                    return "";
                }

                @Override // com.beizi.ad.internal.f.b
                public String f() {
                    return cVar.e();
                }

                @Override // com.beizi.ad.internal.f.b
                public String g() {
                    return cVar.f();
                }

                @Override // com.beizi.ad.internal.f.b
                public void h() {
                    aVar.h();
                }

                @Override // com.beizi.ad.internal.f.b
                public boolean i() {
                    return cVar.P();
                }

                @Override // com.beizi.ad.internal.f.b
                public com.beizi.ad.internal.f.c j() {
                    return cVar;
                }

                @Override // com.beizi.ad.internal.f.b
                public String k() {
                    com.beizi.ad.internal.f.c cVar3 = cVar;
                    if (cVar3 == null) {
                        return null;
                    }
                    return cVar3.W();
                }
            });
        }
    }

    public void a(com.beizi.ad.internal.f.b bVar) {
        h();
        if (this.f11868b != null) {
            this.f11868b = null;
        }
        c cVar = this.f11867a.get();
        if (cVar != null) {
            cVar.e().a(bVar);
        } else {
            bVar.h();
        }
    }
}
