package com.beizi.ad.v2.f;

import android.content.Context;
import com.beizi.ad.j;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class a extends com.beizi.ad.v2.a.a {
    public void a(com.beizi.ad.b bVar) {
        com.beizi.ad.v2.a.b bVar2 = this.f13083a;
        if (bVar2 == null) {
            return;
        }
        bVar2.b();
    }

    public a(Context context) {
        this.f13083a = new b(context);
    }

    public void a(j jVar) {
        com.beizi.ad.v2.a.b bVar = this.f13083a;
        if (bVar != null && (bVar instanceof b)) {
            ((b) bVar).a(jVar);
        }
    }

    public void a(Context context) {
        com.beizi.ad.v2.a.b bVar = this.f13083a;
        if (bVar != null && (bVar instanceof b)) {
            ((b) bVar).a(context);
        }
    }
}
