package com.beizi.ad.internal.e;

import android.os.CountDownTimer;
import android.text.TextUtils;
import com.beizi.ad.h;
import com.beizi.ad.i;
import com.beizi.ad.internal.k;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class c extends com.beizi.ad.internal.f.a implements com.beizi.ad.internal.a {

    /* renamed from: a, reason: collision with root package name */
    public com.beizi.ad.internal.f.c f11847a;

    /* renamed from: b, reason: collision with root package name */
    private h f11848b;

    /* renamed from: d, reason: collision with root package name */
    private a f11849d;

    /* renamed from: e, reason: collision with root package name */
    private com.beizi.ad.internal.e f11850e;

    /* renamed from: f, reason: collision with root package name */
    private String f11851f;

    /* renamed from: g, reason: collision with root package name */
    private String f11852g;

    /* renamed from: h, reason: collision with root package name */
    private String f11853h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f11854i;

    /* renamed from: j, reason: collision with root package name */
    private String f11855j;

    /* renamed from: k, reason: collision with root package name */
    private i f11856k;

    /* renamed from: l, reason: collision with root package name */
    private String f11857l;

    /* renamed from: m, reason: collision with root package name */
    private k f11858m;

    /* renamed from: n, reason: collision with root package name */
    private CountDownTimer f11859n;

    /* renamed from: o, reason: collision with root package name */
    private int f11860o;

    /* renamed from: p, reason: collision with root package name */
    private com.beizi.ad.internal.a.b f11861p;

    /* renamed from: q, reason: collision with root package name */
    private boolean f11862q;

    /* renamed from: r, reason: collision with root package name */
    private boolean f11863r;

    /* renamed from: s, reason: collision with root package name */
    private boolean f11864s;

    /* renamed from: t, reason: collision with root package name */
    private boolean f11865t;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private class a implements com.beizi.ad.internal.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ c f11866a;

        @Override // com.beizi.ad.internal.c
        public void a() {
        }

        @Override // com.beizi.ad.internal.c
        public void a(long j6) {
        }

        @Override // com.beizi.ad.internal.c
        public void a(String str) {
        }

        @Override // com.beizi.ad.internal.c
        public void a(String str, int i6) {
        }

        @Override // com.beizi.ad.internal.c
        public void a(String str, String str2) {
        }

        @Override // com.beizi.ad.internal.c
        public void a(com.beizi.ad.internal.f.b bVar) {
            try {
                this.f11866a.g();
                if (this.f11866a.f11863r) {
                    this.f11866a.a(bVar.j(), bVar.k());
                    return;
                }
                if (bVar.j() == null) {
                    if (this.f11866a.f()) {
                        return;
                    }
                    a(0);
                } else {
                    this.f11866a.f11862q = true;
                    this.f11866a.a(true, bVar.k(), bVar.j());
                }
            } catch (Exception e6) {
                e6.printStackTrace();
            }
        }

        @Override // com.beizi.ad.internal.c
        public void a(int i6) {
            this.f11866a.f11865t = false;
            if (this.f11866a.f11863r) {
                return;
            }
            this.f11866a.g();
            if (this.f11866a.f() || this.f11866a.f11848b == null) {
                return;
            }
            this.f11866a.f11848b.a(i6);
        }

        @Override // com.beizi.ad.internal.c
        public void b() {
        }

        @Override // com.beizi.ad.internal.c
        public void c() {
        }

        @Override // com.beizi.ad.internal.c
        public void d() {
        }

        @Override // com.beizi.ad.internal.c
        public void e() {
        }

        @Override // com.beizi.ad.internal.c
        public void f() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean f() {
        com.beizi.ad.internal.f.c a6;
        if (this.f11860o <= 0 || this.f11862q) {
            return false;
        }
        com.beizi.ad.internal.a.b b6 = com.beizi.ad.internal.a.a.a().b(c());
        this.f11861p = b6;
        if (b6 == null || (a6 = com.beizi.ad.internal.a.a.a().a(this.f11861p, this.f11858m)) == null) {
            return false;
        }
        if (this.f11862q) {
            com.beizi.ad.internal.a.a.a().a(this.f11861p, 1, this.f11860o);
            return false;
        }
        a(false, null, a6);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        CountDownTimer countDownTimer = this.f11859n;
        if (countDownTimer != null) {
            countDownTimer.cancel();
            this.f11859n = null;
        }
    }

    public String c() {
        return this.f11850e.c();
    }

    com.beizi.ad.internal.e d() {
        return this.f11850e;
    }

    public com.beizi.ad.internal.c e() {
        return this.f11849d;
    }

    @Override // com.beizi.ad.internal.a
    public k getMediaType() {
        return this.f11850e.i();
    }

    @Override // com.beizi.ad.internal.a
    public boolean isReadyToStart() {
        return this.f11848b != null && this.f11850e.j();
    }

    public boolean b() {
        com.beizi.ad.internal.e eVar = this.f11850e;
        if (eVar != null) {
            return eVar.l();
        }
        return true;
    }

    public void c(String str) {
        this.f11853h = str;
    }

    public void d(String str) {
        this.f11855j = str;
    }

    private void c(com.beizi.ad.internal.f.c cVar) {
        i a6 = cVar.a();
        this.f11856k = a6;
        if (a6 == null) {
            h hVar = this.f11848b;
            if (hVar != null) {
                hVar.a(3);
                return;
            }
            return;
        }
        a(cVar.e());
        b(cVar.f());
        a(cVar.P());
        c(this.f11856k.m());
        d(cVar.R());
        ((com.beizi.ad.internal.e.a) this.f11856k).c(this.f11863r);
        ((com.beizi.ad.internal.e.a) this.f11856k).a(d().a());
        h hVar2 = this.f11848b;
        if (hVar2 != null) {
            hVar2.a(this.f11856k);
        }
    }

    public boolean a() {
        return this.f11850e.h();
    }

    public void a(String str) {
        this.f11851f = str;
    }

    public void b(String str) {
        this.f11852g = str;
    }

    public void a(boolean z5) {
        this.f11854i = z5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(boolean z5, String str, com.beizi.ad.internal.f.c cVar) {
        try {
            if (this.f11864s) {
                if (z5) {
                    a(cVar, str);
                } else if (this.f11862q) {
                    com.beizi.ad.internal.a.a.a().a(this.f11861p, 1, this.f11860o);
                }
                return;
            }
            this.f11864s = true;
            this.f11847a = cVar;
            if (z5) {
                this.f11862q = true;
            } else {
                this.f11863r = true;
                this.f11850e.a(this.f11861p.d());
                this.f11847a.c(true);
            }
            c(cVar);
        } catch (Throwable th) {
            throw th;
        }
    }

    public void a(com.beizi.ad.internal.f.c cVar, String str) {
        if (cVar == null || !cVar.h() || TextUtils.isEmpty(str)) {
            return;
        }
        com.beizi.ad.internal.a.a.a().a(cVar, str, this.f11857l, c(), this.f11858m);
    }
}
