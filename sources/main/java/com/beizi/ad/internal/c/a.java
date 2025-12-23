package com.beizi.ad.internal.c;

import android.content.Context;
import android.os.CountDownTimer;
import android.text.TextUtils;
import com.beizi.ad.internal.e;
import com.beizi.ad.internal.f.c;
import com.beizi.ad.internal.h.t;
import com.beizi.ad.internal.k;
import com.beizi.ad.lance.a.m;
import com.beizi.fusion.model.AdSpacesBean;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class a extends com.beizi.ad.internal.f.a implements com.beizi.ad.internal.a {

    /* renamed from: b, reason: collision with root package name */
    public static a f11685b;

    /* renamed from: a, reason: collision with root package name */
    public c f11686a;

    /* renamed from: d, reason: collision with root package name */
    private com.beizi.ad.a f11687d;

    /* renamed from: e, reason: collision with root package name */
    private C0103a f11688e;

    /* renamed from: f, reason: collision with root package name */
    private e f11689f;

    /* renamed from: g, reason: collision with root package name */
    private String f11690g;

    /* renamed from: h, reason: collision with root package name */
    private String f11691h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f11692i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f11693j;

    /* renamed from: k, reason: collision with root package name */
    private AdSpacesBean.BuyerBean f11694k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f11695l;

    /* renamed from: m, reason: collision with root package name */
    private Context f11696m;

    /* renamed from: n, reason: collision with root package name */
    private String f11697n;

    /* renamed from: o, reason: collision with root package name */
    private k f11698o;

    /* renamed from: p, reason: collision with root package name */
    private CountDownTimer f11699p;

    /* renamed from: q, reason: collision with root package name */
    private int f11700q;

    /* renamed from: r, reason: collision with root package name */
    private com.beizi.ad.internal.a.b f11701r;

    /* renamed from: s, reason: collision with root package name */
    private boolean f11702s;

    /* renamed from: t, reason: collision with root package name */
    private boolean f11703t;

    /* renamed from: u, reason: collision with root package name */
    private boolean f11704u;

    /* renamed from: v, reason: collision with root package name */
    private boolean f11705v;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.beizi.ad.internal.c.a$a, reason: collision with other inner class name */
    private class C0103a implements com.beizi.ad.internal.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ a f11707a;

        @Override // com.beizi.ad.internal.c
        public void a(long j6) {
        }

        @Override // com.beizi.ad.internal.c
        public void a(String str, int i6) {
        }

        @Override // com.beizi.ad.internal.c
        public void b() {
            if (this.f11707a.f11687d != null) {
                this.f11707a.f11687d.c();
            }
        }

        @Override // com.beizi.ad.internal.c
        public void d() {
            if (this.f11707a.f11687d != null) {
                this.f11707a.f11687d.e();
            }
        }

        @Override // com.beizi.ad.internal.c
        public void a(String str, String str2) {
        }

        @Override // com.beizi.ad.internal.c
        public void a(com.beizi.ad.internal.f.b bVar) {
            try {
                this.f11707a.h();
                if (this.f11707a.f11703t) {
                    this.f11707a.a(bVar.j(), bVar.k());
                } else {
                    if (bVar.j() == null) {
                        if (this.f11707a.g()) {
                            return;
                        }
                        a(0);
                        return;
                    }
                    this.f11707a.a(true, bVar.k(), bVar.j());
                }
            } catch (Exception e6) {
                e6.printStackTrace();
            }
        }

        @Override // com.beizi.ad.internal.c
        public void a() {
            if (this.f11707a.f11703t) {
                this.f11707a.f11704u = true;
                com.beizi.ad.internal.a.a.a().a(this.f11707a.f11701r);
            }
            if (this.f11707a.f11687d != null) {
                this.f11707a.f11687d.b();
            }
        }

        @Override // com.beizi.ad.internal.c
        public void a(int i6) {
            this.f11707a.f11693j = false;
            if (this.f11707a.f11703t) {
                return;
            }
            this.f11707a.h();
            if (this.f11707a.g() || this.f11707a.f11687d == null) {
                return;
            }
            this.f11707a.f11687d.a(i6);
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
        public void a(String str) {
            if (this.f11707a.f11687d != null) {
                this.f11707a.f11687d.a(str);
            }
        }
    }

    private void f() {
        String str;
        boolean z5;
        String str2;
        try {
            c cVar = this.f11686a;
            if (cVar != null) {
                z5 = cVar.N();
                str = this.f11686a.L();
                str2 = this.f11686a.M();
            } else {
                str = null;
                z5 = false;
                str2 = null;
            }
            if (z5) {
                if (!TextUtils.isEmpty(str2)) {
                    t.a().a(this.f11696m, str2, new t.a() { // from class: com.beizi.ad.internal.c.a.1
                        @Override // com.beizi.ad.internal.h.t.a
                        public void a(String str3) {
                            m.a("BeiZisAd", "onVideoLoaded: 加载成功");
                            if (a.this.f11687d != null) {
                                a.this.f11695l = true;
                                a.this.f11687d.a();
                            }
                        }

                        @Override // com.beizi.ad.internal.h.t.a
                        public void a() {
                            if (a.this.f11687d != null) {
                                a.this.f11687d.a(6);
                            }
                        }
                    });
                    return;
                }
                com.beizi.ad.a aVar = this.f11687d;
                if (aVar != null) {
                    aVar.a(3);
                    return;
                }
                return;
            }
            if (TextUtils.isEmpty(str)) {
                com.beizi.ad.a aVar2 = this.f11687d;
                if (aVar2 != null) {
                    aVar2.a(3);
                    return;
                }
                return;
            }
            com.beizi.ad.a aVar3 = this.f11687d;
            if (aVar3 != null) {
                this.f11695l = true;
                aVar3.a();
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean g() {
        c a6;
        if (this.f11700q <= 0 || this.f11702s) {
            return false;
        }
        com.beizi.ad.internal.a.b b6 = com.beizi.ad.internal.a.a.a().b(b());
        this.f11701r = b6;
        if (b6 == null || (a6 = com.beizi.ad.internal.a.a.a().a(this.f11701r, this.f11698o)) == null) {
            return false;
        }
        if (this.f11702s) {
            com.beizi.ad.internal.a.a.a().a(this.f11701r, 1, this.f11700q);
            return false;
        }
        a(false, null, a6);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        CountDownTimer countDownTimer = this.f11699p;
        if (countDownTimer != null) {
            countDownTimer.cancel();
            this.f11699p = null;
        }
    }

    public com.beizi.ad.internal.c d() {
        return this.f11688e;
    }

    public boolean e() {
        return this.f11692i;
    }

    @Override // com.beizi.ad.internal.a
    public k getMediaType() {
        return this.f11689f.i();
    }

    @Override // com.beizi.ad.internal.a
    public boolean isReadyToStart() {
        return this.f11687d != null && this.f11689f.j();
    }

    public String b() {
        return this.f11689f.c();
    }

    public e c() {
        return this.f11689f;
    }

    private void c(c cVar) {
        a(cVar.e());
        b(cVar.f());
        a(cVar.P());
        f();
    }

    public AdSpacesBean.BuyerBean a() {
        return this.f11694k;
    }

    public void b(String str) {
        this.f11691h = str;
    }

    public void a(String str) {
        this.f11690g = str;
    }

    public void a(boolean z5) {
        this.f11692i = z5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(boolean z5, String str, c cVar) {
        try {
            if (this.f11705v) {
                if (z5) {
                    a(cVar, str);
                } else if (this.f11702s) {
                    com.beizi.ad.internal.a.a.a().a(this.f11701r, 1, this.f11700q);
                }
                return;
            }
            this.f11705v = true;
            this.f11686a = cVar;
            if (z5) {
                m.c("BeiZisAd", "handleLocalCacheOrServerResponse use server:");
                this.f11702s = true;
            } else {
                this.f11703t = true;
                this.f11689f.a(this.f11701r.d());
                this.f11686a.c(true);
                m.c("BeiZisAd", "handleLocalCacheOrServerResponse use cache mRequestId:" + this.f11689f.a());
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
        com.beizi.ad.internal.a.a.a().a(cVar, str, this.f11697n, b(), this.f11698o);
    }
}
