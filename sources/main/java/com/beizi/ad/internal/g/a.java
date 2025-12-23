package com.beizi.ad.internal.g;

import android.content.Context;
import android.os.CountDownTimer;
import android.text.TextUtils;
import com.beizi.ad.internal.e;
import com.beizi.ad.internal.f.c;
import com.beizi.ad.internal.h.t;
import com.beizi.ad.internal.k;
import com.beizi.ad.j;
import com.beizi.ad.lance.a.m;
import com.beizi.fusion.model.AdSpacesBean;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class a extends com.beizi.ad.internal.f.a implements com.beizi.ad.internal.a {

    /* renamed from: b, reason: collision with root package name */
    public static a f11962b;

    /* renamed from: a, reason: collision with root package name */
    public c f11963a;

    /* renamed from: d, reason: collision with root package name */
    private j f11964d;

    /* renamed from: e, reason: collision with root package name */
    private C0109a f11965e;

    /* renamed from: f, reason: collision with root package name */
    private e f11966f;

    /* renamed from: g, reason: collision with root package name */
    private String f11967g;

    /* renamed from: h, reason: collision with root package name */
    private String f11968h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f11969i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f11970j;

    /* renamed from: k, reason: collision with root package name */
    private AdSpacesBean.BuyerBean f11971k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f11972l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f11973m;

    /* renamed from: n, reason: collision with root package name */
    private String f11974n;

    /* renamed from: o, reason: collision with root package name */
    private Context f11975o;

    /* renamed from: p, reason: collision with root package name */
    private String f11976p;

    /* renamed from: q, reason: collision with root package name */
    private k f11977q;

    /* renamed from: r, reason: collision with root package name */
    private CountDownTimer f11978r;

    /* renamed from: s, reason: collision with root package name */
    private int f11979s;

    /* renamed from: t, reason: collision with root package name */
    private com.beizi.ad.internal.a.b f11980t;

    /* renamed from: u, reason: collision with root package name */
    private boolean f11981u;

    /* renamed from: v, reason: collision with root package name */
    private boolean f11982v;

    /* renamed from: w, reason: collision with root package name */
    private boolean f11983w;

    /* renamed from: x, reason: collision with root package name */
    private boolean f11984x;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.beizi.ad.internal.g.a$a, reason: collision with other inner class name */
    private class C0109a implements com.beizi.ad.internal.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ a f11986a;

        @Override // com.beizi.ad.internal.c
        public void a(long j6) {
        }

        @Override // com.beizi.ad.internal.c
        public void a(String str, String str2) {
        }

        @Override // com.beizi.ad.internal.c
        public void b() {
            if (this.f11986a.f11964d != null) {
                this.f11986a.f11964d.d();
            }
        }

        @Override // com.beizi.ad.internal.c
        public void d() {
            if (this.f11986a.f11964d != null) {
                this.f11986a.f11964d.e();
            }
        }

        @Override // com.beizi.ad.internal.c
        public void a(com.beizi.ad.internal.f.b bVar) {
            try {
                this.f11986a.k();
                if (this.f11986a.f11982v) {
                    this.f11986a.a(bVar.j(), bVar.k());
                } else {
                    if (bVar.j() == null) {
                        if (this.f11986a.j()) {
                            return;
                        }
                        a(0);
                        return;
                    }
                    this.f11986a.a(true, bVar.k(), bVar.j());
                }
            } catch (Exception e6) {
                e6.printStackTrace();
            }
        }

        @Override // com.beizi.ad.internal.c
        public void a() {
            if (this.f11986a.f11982v) {
                this.f11986a.f11983w = true;
                com.beizi.ad.internal.a.a.a().a(this.f11986a.f11980t);
            }
            if (this.f11986a.f11964d != null) {
                this.f11986a.f11964d.c();
            }
        }

        @Override // com.beizi.ad.internal.c
        public void a(int i6) {
            this.f11986a.f11970j = false;
            if (this.f11986a.f11982v) {
                return;
            }
            this.f11986a.k();
            if (this.f11986a.j() || this.f11986a.f11964d == null) {
                return;
            }
            this.f11986a.f11964d.a(i6);
        }

        @Override // com.beizi.ad.internal.c
        public void c() {
        }

        @Override // com.beizi.ad.internal.c
        public void e() {
        }

        @Override // com.beizi.ad.internal.c
        public void f() {
        }

        @Override // com.beizi.ad.internal.c
        public void a(String str, int i6) {
            if (this.f11986a.f11964d != null) {
                this.f11986a.f11964d.a((Map<String, Object>) null);
            }
        }

        @Override // com.beizi.ad.internal.c
        public void a(String str) {
            if (this.f11986a.f11964d != null) {
                this.f11986a.f11964d.a(str);
            }
        }
    }

    private void i() {
        String str;
        boolean z5;
        String str2;
        try {
            c cVar = this.f11963a;
            if (cVar != null) {
                z5 = cVar.N();
                str = this.f11963a.L();
                str2 = this.f11963a.M();
            } else {
                str = null;
                z5 = false;
                str2 = null;
            }
            if (z5) {
                if (TextUtils.isEmpty(str2)) {
                    j jVar = this.f11964d;
                    if (jVar != null) {
                        jVar.a(3);
                        return;
                    }
                    return;
                }
                j jVar2 = this.f11964d;
                if (jVar2 != null) {
                    this.f11972l = true;
                    jVar2.a();
                }
                t.a().a(this.f11975o, str2, new t.a() { // from class: com.beizi.ad.internal.g.a.1
                    @Override // com.beizi.ad.internal.h.t.a
                    public void a() {
                    }

                    @Override // com.beizi.ad.internal.h.t.a
                    public void a(String str3) {
                        m.a("BeiZisAd", "onVideoLoaded: 加载成功");
                        a.this.f11974n = str3;
                        if (a.this.f11964d != null) {
                            a.this.f11973m = true;
                            a.this.f11964d.b();
                        }
                    }
                });
                return;
            }
            if (TextUtils.isEmpty(str)) {
                j jVar3 = this.f11964d;
                if (jVar3 != null) {
                    jVar3.a(3);
                    return;
                }
                return;
            }
            j jVar4 = this.f11964d;
            if (jVar4 != null) {
                this.f11972l = true;
                jVar4.a();
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean j() {
        c a6;
        if (this.f11979s <= 0 || this.f11981u) {
            return false;
        }
        com.beizi.ad.internal.a.b b6 = com.beizi.ad.internal.a.a.a().b(c());
        this.f11980t = b6;
        if (b6 == null || (a6 = com.beizi.ad.internal.a.a.a().a(this.f11980t, this.f11977q)) == null) {
            return false;
        }
        if (this.f11981u) {
            com.beizi.ad.internal.a.a.a().a(this.f11980t, 1, this.f11979s);
            return false;
        }
        a(false, null, a6);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        CountDownTimer countDownTimer = this.f11978r;
        if (countDownTimer != null) {
            countDownTimer.cancel();
            this.f11978r = null;
        }
    }

    public e d() {
        return this.f11966f;
    }

    public boolean e() {
        return this.f11973m;
    }

    public String f() {
        return this.f11974n;
    }

    public com.beizi.ad.internal.c g() {
        return this.f11965e;
    }

    @Override // com.beizi.ad.internal.a
    public k getMediaType() {
        return this.f11966f.i();
    }

    public boolean h() {
        return this.f11969i;
    }

    @Override // com.beizi.ad.internal.a
    public boolean isReadyToStart() {
        return this.f11964d != null && this.f11966f.j();
    }

    public void b() {
        f11962b = null;
    }

    public String c() {
        return this.f11966f.c();
    }

    private void c(c cVar) {
        if (cVar == null) {
            j jVar = this.f11964d;
            if (jVar != null) {
                jVar.a(3);
                return;
            }
            return;
        }
        a(cVar.e());
        b(cVar.f());
        a(cVar.P());
        i();
    }

    public void b(String str) {
        this.f11968h = str;
    }

    public AdSpacesBean.BuyerBean a() {
        return this.f11971k;
    }

    public void a(String str) {
        this.f11967g = str;
    }

    public void a(boolean z5) {
        this.f11969i = z5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(boolean z5, String str, c cVar) {
        try {
            if (this.f11984x) {
                if (z5) {
                    a(cVar, str);
                } else if (this.f11981u) {
                    com.beizi.ad.internal.a.a.a().a(this.f11980t, 1, this.f11979s);
                }
                return;
            }
            this.f11984x = true;
            this.f11963a = cVar;
            if (z5) {
                m.c("BeiZisAd", "handleLocalCacheOrServerResponse use server:");
                this.f11981u = true;
            } else {
                this.f11982v = true;
                this.f11966f.a(this.f11980t.d());
                this.f11963a.c(true);
                m.c("BeiZisAd", "handleLocalCacheOrServerResponse use cache mRequestId:" + this.f11966f.a());
            }
            c(cVar);
        } catch (Throwable th) {
            throw th;
        }
    }

    public void a(c cVar, String str) {
        if (cVar == null || !cVar.h() || TextUtils.isEmpty(str)) {
            return;
        }
        com.beizi.ad.internal.a.a.a().a(cVar, str, this.f11976p, c(), this.f11977q);
    }
}
