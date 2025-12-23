package com.beizi.ad.v2.c;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.text.TextUtils;
import com.beizi.ad.internal.f.c;
import com.beizi.ad.internal.h.t;
import com.beizi.ad.internal.k;
import com.beizi.ad.lance.a.m;
import com.beizi.ad.v2.activity.BeiZiNewInterstitialActivity;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class b extends com.beizi.ad.v2.a.b {
    public static b G;
    private com.beizi.ad.a H;

    public b(Context context) {
        super(context, k.INTERSTITIAL);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x() {
        String str;
        String str2;
        boolean z5;
        try {
            c cVar = this.f13086c;
            if (cVar != null) {
                z5 = cVar.N();
                str = this.f13086c.L();
                str2 = this.f13086c.M();
            } else {
                str = null;
                str2 = null;
                z5 = false;
            }
            if (z5) {
                if (!TextUtils.isEmpty(str2)) {
                    t.a().a(this.f13084a, str2, false, new t.a() { // from class: com.beizi.ad.v2.c.b.1
                        @Override // com.beizi.ad.internal.h.t.a
                        public void a(String str3) {
                            m.a("BeiZisAd", "onVideoLoaded: 加载成功");
                            if (b.this.H != null) {
                                ((com.beizi.ad.v2.a.b) b.this).f13090g = true;
                                b.this.H.a();
                            }
                        }

                        @Override // com.beizi.ad.internal.h.t.a
                        public void a() {
                            if (b.this.H != null) {
                                b.this.H.a(6);
                            }
                        }
                    });
                    return;
                }
                com.beizi.ad.a aVar = this.H;
                if (aVar != null) {
                    aVar.a(3);
                    return;
                }
                return;
            }
            if (TextUtils.isEmpty(str)) {
                com.beizi.ad.a aVar2 = this.H;
                if (aVar2 != null) {
                    aVar2.a(3);
                    return;
                }
                return;
            }
            com.beizi.ad.a aVar3 = this.H;
            if (aVar3 != null) {
                this.f13090g = true;
                aVar3.a();
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    @Override // com.beizi.ad.v2.a.b
    public void b(final int i6) {
        if (this.H == null || this.f13093j || this.f13090g) {
            return;
        }
        this.f13093j = true;
        Handler handler = this.F;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.beizi.ad.v2.c.b.2
                @Override // java.lang.Runnable
                public void run() {
                    b.this.H.a(i6);
                }
            });
        }
    }

    public void f(String str) {
        com.beizi.ad.a aVar = this.H;
        if (aVar != null) {
            aVar.a(str);
        }
    }

    public void u() {
        if (this.f13103t) {
            this.f13104u = true;
            com.beizi.ad.internal.a.a.a().a(this.f13101r);
        }
        com.beizi.ad.a aVar = this.H;
        if (aVar != null) {
            aVar.b();
        }
    }

    public void v() {
        c cVar = this.f13086c;
        if (cVar != null) {
            cVar.d(false);
        }
        com.beizi.ad.a aVar = this.H;
        if (aVar != null) {
            aVar.c();
        }
    }

    public void w() {
        com.beizi.ad.a aVar = this.H;
        if (aVar != null) {
            aVar.e();
        }
    }

    public void a(com.beizi.ad.a aVar) {
        this.H = aVar;
    }

    @Override // com.beizi.ad.v2.a.b
    public void q() {
        super.q();
        G = null;
    }

    public void a(Context context) {
        m.c("BeiZisAd", "showInterstitial");
        G = this;
        context.startActivity(new Intent(context, (Class<?>) BeiZiNewInterstitialActivity.class));
    }

    @Override // com.beizi.ad.v2.a.b
    public void a(c cVar) {
        b(cVar.e());
        c(cVar.f());
        a(cVar.P());
        Handler handler = this.F;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.beizi.ad.v2.c.b.3
                @Override // java.lang.Runnable
                public void run() {
                    b.this.x();
                }
            });
        }
    }
}
