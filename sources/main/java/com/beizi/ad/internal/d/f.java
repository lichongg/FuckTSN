package com.beizi.ad.internal.d;

import android.content.Context;
import com.beizi.ad.internal.k;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class f extends b {
    @Override // com.beizi.ad.internal.d.b
    public void i() {
        this.f11738i = true;
        com.beizi.ad.b.b bVar = this.f11731b;
        if (bVar != null) {
            bVar.e();
        }
    }

    private f(Context context, com.beizi.ad.internal.f fVar, a aVar, com.beizi.ad.internal.c cVar, com.beizi.ad.internal.f.c cVar2) {
        super(fVar, aVar, cVar, k.INTERSTITIAL, cVar2);
        if (a(g.class)) {
            e();
            g();
            int i6 = 0;
            if (context != null) {
                try {
                    ((g) this.f11731b).a(this, context, this.f11732c.b(), this.f11732c.e(), a());
                    i6 = -1;
                } catch (Error | Exception unused) {
                }
            }
            if (i6 != -1) {
                a(i6);
            }
        }
    }

    public static f a(Context context, com.beizi.ad.internal.f fVar, a aVar, com.beizi.ad.internal.c cVar, com.beizi.ad.internal.f.c cVar2) {
        f fVar2 = new f(context, fVar, aVar, cVar, cVar2);
        if (fVar2.f11736g) {
            return null;
        }
        return fVar2;
    }

    @Override // com.beizi.ad.internal.d.b
    public void c() {
        if (this.f11731b == null || d()) {
            return;
        }
        ((g) this.f11731b).a();
    }

    @Override // com.beizi.ad.internal.d.b
    public void j() {
        com.beizi.ad.b.b bVar = this.f11731b;
        if (bVar != null) {
            bVar.c();
        }
    }

    @Override // com.beizi.ad.internal.d.b
    public void k() {
        com.beizi.ad.b.b bVar = this.f11731b;
        if (bVar != null) {
            bVar.d();
        }
    }
}
