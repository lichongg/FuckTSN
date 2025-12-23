package com.beizi.ad.internal.splash;

import android.os.CountDownTimer;
import android.text.TextUtils;
import com.beizi.ad.internal.e;
import com.beizi.ad.internal.f.c;
import com.beizi.ad.internal.k;
import com.beizi.ad.m;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class c extends com.beizi.ad.internal.f.a implements com.beizi.ad.internal.a {

    /* renamed from: a, reason: collision with root package name */
    public com.beizi.ad.internal.f.c f12343a;

    /* renamed from: b, reason: collision with root package name */
    private m f12344b;

    /* renamed from: d, reason: collision with root package name */
    private a f12345d;

    /* renamed from: e, reason: collision with root package name */
    private e f12346e;

    /* renamed from: f, reason: collision with root package name */
    private String f12347f;

    /* renamed from: g, reason: collision with root package name */
    private String f12348g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f12349h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f12350i;

    /* renamed from: j, reason: collision with root package name */
    private String f12351j;

    /* renamed from: k, reason: collision with root package name */
    private k f12352k;

    /* renamed from: l, reason: collision with root package name */
    private CountDownTimer f12353l;

    /* renamed from: m, reason: collision with root package name */
    private int f12354m;

    /* renamed from: n, reason: collision with root package name */
    private com.beizi.ad.internal.a.b f12355n;

    /* renamed from: o, reason: collision with root package name */
    private boolean f12356o;

    /* renamed from: p, reason: collision with root package name */
    private boolean f12357p;

    /* renamed from: q, reason: collision with root package name */
    private boolean f12358q;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private class a implements com.beizi.ad.internal.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ c f12359a;

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
                this.f12359a.e();
                if (this.f12359a.f12357p) {
                    this.f12359a.a(bVar.j(), bVar.k());
                } else {
                    if (bVar.j() == null) {
                        if (this.f12359a.d()) {
                            return;
                        }
                        a(0);
                        return;
                    }
                    this.f12359a.a(true, bVar.k(), bVar.j());
                }
            } catch (Exception e6) {
                e6.printStackTrace();
            }
        }

        @Override // com.beizi.ad.internal.c
        public void a(int i6) {
            this.f12359a.f12350i = false;
            if (this.f12359a.f12357p) {
                return;
            }
            this.f12359a.e();
            if (this.f12359a.d() || this.f12359a.f12344b == null) {
                return;
            }
            this.f12359a.f12344b.a(i6);
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
    public boolean d() {
        com.beizi.ad.internal.f.c a6;
        if (this.f12354m <= 0 || this.f12356o) {
            return false;
        }
        com.beizi.ad.internal.a.b b6 = com.beizi.ad.internal.a.a.a().b(a());
        this.f12355n = b6;
        if (b6 == null || (a6 = com.beizi.ad.internal.a.a.a().a(this.f12355n, this.f12352k)) == null) {
            return false;
        }
        if (this.f12356o) {
            com.beizi.ad.internal.a.a.a().a(this.f12355n, 1, this.f12354m);
            return false;
        }
        a(false, null, a6);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        CountDownTimer countDownTimer = this.f12353l;
        if (countDownTimer != null) {
            countDownTimer.cancel();
            this.f12353l = null;
        }
    }

    public void b(String str) {
        this.f12348g = str;
    }

    public com.beizi.ad.internal.c c() {
        return this.f12345d;
    }

    @Override // com.beizi.ad.internal.a
    public k getMediaType() {
        return this.f12346e.i();
    }

    @Override // com.beizi.ad.internal.a
    public boolean isReadyToStart() {
        return this.f12344b != null && this.f12346e.j();
    }

    private void c(com.beizi.ad.internal.f.c cVar) {
        a(cVar.e());
        b(cVar.f());
        a(cVar.P());
        SplashUnifiedAdResponse splashUnifiedAdResponse = new SplashUnifiedAdResponse();
        splashUnifiedAdResponse.setImageUrl(cVar.U());
        c.a A = cVar.A();
        if (A != null) {
            splashUnifiedAdResponse.setIconUrl(A.a());
        }
        c.a z5 = cVar.z();
        if (z5 != null) {
            splashUnifiedAdResponse.setTextUrl(z5.a());
        }
        splashUnifiedAdResponse.setPrice(cVar.e());
        if (cVar.P()) {
            splashUnifiedAdResponse.setElements("应用名称：" + cVar.B() + " | 开发者：" + cVar.D() + " | 应用版本：" + cVar.C() + " | 权限详情 | 隐私协议 | 功能介绍");
        }
        splashUnifiedAdResponse.setDownloadApp(cVar.P());
        m mVar = this.f12344b;
        if (mVar != null) {
            mVar.a(splashUnifiedAdResponse);
        }
    }

    e b() {
        return this.f12346e;
    }

    public String a() {
        return this.f12346e.c();
    }

    public void a(String str) {
        this.f12347f = str;
    }

    public void a(boolean z5) {
        this.f12349h = z5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(boolean z5, String str, com.beizi.ad.internal.f.c cVar) {
        try {
            if (this.f12358q) {
                if (z5) {
                    a(cVar, str);
                } else if (this.f12356o) {
                    com.beizi.ad.internal.a.a.a().a(this.f12355n, 1, this.f12354m);
                }
                return;
            }
            this.f12358q = true;
            this.f12343a = cVar;
            if (z5) {
                this.f12356o = true;
            } else {
                this.f12357p = true;
                this.f12346e.a(this.f12355n.d());
                this.f12343a.c(true);
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
        com.beizi.ad.internal.a.a.a().a(cVar, str, this.f12351j, a(), this.f12352k);
    }
}
