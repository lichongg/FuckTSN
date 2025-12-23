package com.beizi.ad.v2.f;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.text.TextUtils;
import com.beizi.ad.internal.f.c;
import com.beizi.ad.internal.h.t;
import com.beizi.ad.internal.k;
import com.beizi.ad.j;
import com.beizi.ad.lance.a.m;
import com.beizi.ad.v2.activity.BeiZiNewRewardVideoActivity;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class b extends com.beizi.ad.v2.a.b {
    public static b G;
    private j H;
    private boolean I;
    private String J;

    public b(Context context) {
        super(context, k.REWARDEDVIDEO);
        this.I = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z() {
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
                if (TextUtils.isEmpty(str2)) {
                    j jVar = this.H;
                    if (jVar != null) {
                        jVar.a(3);
                        return;
                    }
                    return;
                }
                j jVar2 = this.H;
                if (jVar2 != null) {
                    this.f13090g = true;
                    jVar2.a();
                }
                t.a().a(this.f13084a, str2, false, new t.a() { // from class: com.beizi.ad.v2.f.b.1
                    @Override // com.beizi.ad.internal.h.t.a
                    public void a() {
                    }

                    @Override // com.beizi.ad.internal.h.t.a
                    public void a(String str3) {
                        m.a("BeiZisAd", "onVideoLoaded: 加载成功");
                        b.this.J = str3;
                        if (b.this.H != null) {
                            b.this.I = true;
                            b.this.H.b();
                        }
                    }
                });
                return;
            }
            if (TextUtils.isEmpty(str)) {
                j jVar3 = this.H;
                if (jVar3 != null) {
                    jVar3.a(3);
                    return;
                }
                return;
            }
            j jVar4 = this.H;
            if (jVar4 != null) {
                this.f13090g = true;
                jVar4.a();
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
            handler.post(new Runnable() { // from class: com.beizi.ad.v2.f.b.2
                @Override // java.lang.Runnable
                public void run() {
                    b.this.H.a(i6);
                }
            });
        }
    }

    public void f(String str) {
        j jVar = this.H;
        if (jVar != null) {
            jVar.a(str);
        }
    }

    public boolean u() {
        return this.I;
    }

    public String v() {
        return this.J;
    }

    public void w() {
        if (this.f13103t) {
            this.f13104u = true;
            com.beizi.ad.internal.a.a.a().a(this.f13101r);
        }
        j jVar = this.H;
        if (jVar != null) {
            jVar.c();
        }
    }

    public void x() {
        c cVar = this.f13086c;
        if (cVar != null) {
            cVar.d(false);
        }
        j jVar = this.H;
        if (jVar != null) {
            jVar.d();
        }
    }

    public void y() {
        j jVar = this.H;
        if (jVar != null) {
            jVar.e();
        }
    }

    @Override // com.beizi.ad.v2.a.b
    public void q() {
        super.q();
        G = null;
    }

    public void a(j jVar) {
        this.H = jVar;
    }

    public void a(Context context) {
        m.c("BeiZisAd", "showRewardVideo");
        G = this;
        context.startActivity(new Intent(context, (Class<?>) BeiZiNewRewardVideoActivity.class));
    }

    public void a(String str, int i6) {
        j jVar = this.H;
        if (jVar != null) {
            jVar.a((Map<String, Object>) null);
        }
    }

    @Override // com.beizi.ad.v2.a.b
    public void a(c cVar) {
        if (cVar == null) {
            j jVar = this.H;
            if (jVar != null) {
                jVar.a(3);
                return;
            }
            return;
        }
        b(cVar.e());
        c(cVar.f());
        a(cVar.P());
        Handler handler = this.F;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.beizi.ad.v2.f.b.3
                @Override // java.lang.Runnable
                public void run() {
                    b.this.z();
                }
            });
        }
    }
}
