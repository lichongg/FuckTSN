package com.beizi.ad.internal.g;

import com.beizi.ad.i;
import com.beizi.ad.internal.e;
import com.beizi.ad.internal.k;
import com.beizi.ad.internal.m;
import com.beizi.ad.lance.a.c;
import java.lang.ref.SoftReference;
import java.util.concurrent.RejectedExecutionException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class b extends m {

    /* renamed from: a, reason: collision with root package name */
    private final SoftReference<a> f11987a;

    @Override // com.beizi.ad.internal.f
    public void a() {
        a aVar = this.f11987a.get();
        if (aVar == null) {
            return;
        }
        g();
        try {
            aVar.a(this);
            aVar.executeOnExecutor(c.b().c(), new Void[0]);
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
    public e c() {
        a aVar = this.f11987a.get();
        if (aVar != null) {
            return aVar.d();
        }
        return null;
    }

    @Override // com.beizi.ad.internal.m
    public void e() {
        a aVar = this.f11987a.get();
        if (aVar != null) {
            aVar.cancel(true);
        }
    }

    public b(a aVar) {
        this.f11987a = new SoftReference<>(aVar);
    }

    @Override // com.beizi.ad.internal.f
    public void a(int i6) {
        h();
        a aVar = this.f11987a.get();
        if (aVar != null) {
            aVar.g().a(i6);
        }
    }

    @Override // com.beizi.ad.internal.f
    public void a(final com.beizi.ad.internal.f.c cVar) {
        a aVar = this.f11987a.get();
        if (aVar != null) {
            boolean h6 = cVar.h();
            boolean z5 = (b() == null || b().isEmpty()) ? false : true;
            if (!h6 && !z5) {
                aVar.g().a(3);
            } else {
                a(new com.beizi.ad.internal.f.b() { // from class: com.beizi.ad.internal.g.b.1
                    @Override // com.beizi.ad.internal.f.b
                    public boolean b() {
                        return false;
                    }

                    @Override // com.beizi.ad.internal.f.b
                    public com.beizi.ad.internal.view.c c() {
                        return null;
                    }

                    @Override // com.beizi.ad.internal.f.b
                    public i d() {
                        return null;
                    }

                    @Override // com.beizi.ad.internal.f.b
                    public k a() {
                        return k.REWARDEDVIDEO;
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
                    public boolean i() {
                        return cVar.P();
                    }

                    @Override // com.beizi.ad.internal.f.b
                    public com.beizi.ad.internal.f.c j() {
                        return cVar;
                    }

                    @Override // com.beizi.ad.internal.f.b
                    public String k() {
                        com.beizi.ad.internal.f.c cVar2 = cVar;
                        if (cVar2 == null) {
                            return null;
                        }
                        return cVar2.W();
                    }

                    @Override // com.beizi.ad.internal.f.b
                    public void h() {
                    }
                });
            }
        }
    }

    public void a(com.beizi.ad.internal.f.b bVar) {
        a aVar = this.f11987a.get();
        if (aVar != null) {
            aVar.g().a(bVar);
        } else {
            bVar.h();
        }
    }
}
