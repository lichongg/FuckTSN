package com.beizi.ad.internal.d;

import android.content.Context;
import android.view.ViewGroup;
import com.beizi.ad.internal.k;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class h extends b {
    @Override // com.beizi.ad.internal.d.b
    public void i() {
        this.f11738i = true;
        com.beizi.ad.b.b bVar = this.f11731b;
        if (bVar != null) {
            bVar.e();
        }
    }

    private h(Context context, com.beizi.ad.internal.f fVar, a aVar, com.beizi.ad.internal.c cVar, ViewGroup viewGroup, com.beizi.ad.internal.f.c cVar2) {
        super(fVar, aVar, cVar, k.SPLASH, cVar2);
        if (a(i.class)) {
            e();
            g();
            int i6 = 0;
            if (context != null) {
                try {
                    if (!d()) {
                        ((i) this.f11731b).a(this, context, this.f11732c.b(), this.f11732c.e(), this.f11732c.c(), this.f11732c.d(), a(), viewGroup);
                        i6 = -1;
                    }
                } catch (Error | Exception unused) {
                }
            }
            if (i6 != -1) {
                a(i6);
            }
        }
    }

    public static h a(Context context, com.beizi.ad.internal.f fVar, a aVar, com.beizi.ad.internal.c cVar, ViewGroup viewGroup, com.beizi.ad.internal.f.c cVar2) {
        h hVar = new h(context, fVar, aVar, cVar, viewGroup, cVar2);
        if (hVar.f11736g) {
            return null;
        }
        return hVar;
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

    @Override // com.beizi.ad.internal.d.b
    public void c() {
    }
}
