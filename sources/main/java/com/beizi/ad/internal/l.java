package com.beizi.ad.internal;

import com.beizi.ad.internal.f.a;
import java.util.LinkedList;
import java.util.concurrent.RejectedExecutionException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class l extends m {

    /* renamed from: a, reason: collision with root package name */
    private com.beizi.ad.internal.f.a f12275a;

    /* renamed from: b, reason: collision with root package name */
    private e f12276b = new e(h.a().e(), com.beizi.ad.internal.h.o.a());

    @Override // com.beizi.ad.internal.f
    public void a(int i6) {
    }

    @Override // com.beizi.ad.internal.f
    public com.beizi.ad.b.a d() {
        return null;
    }

    @Override // com.beizi.ad.internal.f
    public void a(com.beizi.ad.internal.f.c cVar) {
    }

    @Override // com.beizi.ad.internal.f
    public e c() {
        return this.f12276b;
    }

    @Override // com.beizi.ad.internal.m
    public void e() {
        com.beizi.ad.internal.f.a aVar = this.f12275a;
        if (aVar != null) {
            aVar.cancel(true);
            this.f12275a = null;
        }
        a((LinkedList<com.beizi.ad.internal.d.a>) null);
    }

    l() {
    }

    @Override // com.beizi.ad.internal.f
    public void a() {
        this.f12275a = new com.beizi.ad.internal.f.a(new a.C0107a());
        g();
        try {
            this.f12275a.a(this);
            this.f12275a.executeOnExecutor(com.beizi.ad.lance.a.c.b().c(), new Void[0]);
        } catch (IllegalStateException e6) {
            e6.getMessage();
        } catch (RejectedExecutionException unused) {
        }
    }
}
