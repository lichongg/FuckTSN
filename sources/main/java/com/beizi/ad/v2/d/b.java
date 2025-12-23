package com.beizi.ad.v2.d;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import com.beizi.ad.h;
import com.beizi.ad.i;
import com.beizi.ad.internal.e.e;
import com.beizi.ad.internal.k;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class b extends com.beizi.ad.v2.a.b {
    private h G;
    private String H;
    private i I;

    public b(Context context, String str, int i6) {
        super(context, str, k.NATIVE);
    }

    @Override // com.beizi.ad.v2.a.b
    public void b(final int i6) {
        if (this.G == null || this.f13093j || this.f13090g) {
            return;
        }
        this.f13093j = true;
        Handler handler = this.F;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.beizi.ad.v2.d.b.2
                @Override // java.lang.Runnable
                public void run() {
                    if (b.this.G != null) {
                        b.this.G.a(i6);
                    }
                }
            });
        }
    }

    public void f(String str) {
        this.H = str;
    }

    public String u() {
        return this.H;
    }

    public void a(h hVar) {
        this.G = hVar;
    }

    public void a(View view, final e eVar) {
        i iVar = this.I;
        if (iVar == null || view == null || eVar == null) {
            return;
        }
        iVar.a(view, new e() { // from class: com.beizi.ad.v2.d.b.1
            @Override // com.beizi.ad.internal.e.e
            public void a() {
                if (((com.beizi.ad.v2.a.b) b.this).f13103t) {
                    ((com.beizi.ad.v2.a.b) b.this).f13104u = true;
                    com.beizi.ad.internal.a.a.a().a(((com.beizi.ad.v2.a.b) b.this).f13101r);
                }
                e eVar2 = eVar;
                if (eVar2 != null) {
                    eVar2.a();
                }
            }
        });
    }

    @Override // com.beizi.ad.v2.a.b
    public void a(com.beizi.ad.internal.f.c cVar) {
        i a6 = cVar.a();
        this.I = a6;
        if (a6 == null) {
            Handler handler = this.F;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.beizi.ad.v2.d.b.3
                    @Override // java.lang.Runnable
                    public void run() {
                        if (b.this.G != null) {
                            b.this.G.a(3);
                        }
                    }
                });
                return;
            }
            return;
        }
        b(cVar.e());
        c(cVar.f());
        a(cVar.P());
        f(this.I.m());
        ((com.beizi.ad.internal.e.a) this.I).c(this.f13103t);
        ((com.beizi.ad.internal.e.a) this.I).a(this.f13095l);
        Handler handler2 = this.F;
        if (handler2 != null) {
            handler2.post(new Runnable() { // from class: com.beizi.ad.v2.d.b.4
                @Override // java.lang.Runnable
                public void run() {
                    if (b.this.G != null) {
                        b.this.G.a(b.this.I);
                    }
                }
            });
        }
    }
}
