package org.apache.commons.net.nntp;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
class n {

    /* renamed from: a, reason: collision with root package name */
    o f50951a;

    /* renamed from: b, reason: collision with root package name */
    n f50952b;

    /* renamed from: c, reason: collision with root package name */
    n f50953c;

    /* renamed from: d, reason: collision with root package name */
    n f50954d;

    boolean a(n nVar) {
        n nVar2 = this.f50954d;
        if (nVar2 == null) {
            return false;
        }
        if (nVar2 == nVar) {
            return true;
        }
        return nVar2.a(nVar);
    }

    void b() {
        if (this.f50952b != null && this.f50951a == null) {
            throw new RuntimeException("no threadable in " + toString());
        }
        this.f50952b = null;
        o oVar = this.f50951a;
        if (oVar != null) {
            n nVar = this.f50954d;
            oVar.h(nVar == null ? null : nVar.f50951a);
        }
        n nVar2 = this.f50954d;
        if (nVar2 != null) {
            nVar2.b();
            this.f50954d = null;
        }
        o oVar2 = this.f50951a;
        if (oVar2 != null) {
            n nVar3 = this.f50953c;
            oVar2.c(nVar3 == null ? null : nVar3.f50951a);
        }
        n nVar4 = this.f50953c;
        if (nVar4 != null) {
            nVar4.b();
            this.f50953c = null;
        }
        this.f50951a = null;
    }

    void c() {
        n nVar = this.f50954d;
        if (nVar != null) {
            n nVar2 = nVar.f50953c;
            n nVar3 = null;
            while (nVar != null) {
                nVar.f50953c = nVar3;
                nVar3 = nVar;
                nVar = nVar2;
                nVar2 = nVar2 == null ? null : nVar2.f50953c;
            }
            this.f50954d = nVar3;
            while (nVar3 != null) {
                nVar3.c();
                nVar3 = nVar3.f50953c;
            }
        }
    }

    n() {
    }
}
