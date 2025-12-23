package com.beizi.ad.v2.c;

import android.content.Context;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class a extends com.beizi.ad.v2.a.a {
    public void a(com.beizi.ad.a aVar) {
        com.beizi.ad.v2.a.b bVar = this.f13083a;
        if (bVar != null && (bVar instanceof b)) {
            ((b) bVar).a(aVar);
        }
    }

    public a(Context context, boolean z5) {
        this.f13083a = new b(context);
    }

    public void a(com.beizi.ad.b bVar) {
        com.beizi.ad.v2.a.b bVar2 = this.f13083a;
        if (bVar2 == null) {
            return;
        }
        bVar2.b();
    }

    public void a(Context context) {
        com.beizi.ad.v2.a.b bVar = this.f13083a;
        if (bVar != null && (bVar instanceof b)) {
            ((b) bVar).a(context);
        }
    }
}
