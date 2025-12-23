package com.bumptech.glide.load.engine.prefill;

import android.graphics.Bitmap;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.engine.bitmap_recycle.e;
import com.bumptech.glide.load.engine.cache.j;
import com.bumptech.glide.load.engine.prefill.d;
import com.bumptech.glide.util.l;
import java.util.HashMap;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private final j f15335a;

    /* renamed from: b, reason: collision with root package name */
    private final e f15336b;

    /* renamed from: c, reason: collision with root package name */
    private final DecodeFormat f15337c;

    /* renamed from: d, reason: collision with root package name */
    private a f15338d;

    @VisibleForTesting
    c a(d... dVarArr) {
        long maxSize = (this.f15335a.getMaxSize() - this.f15335a.getCurrentSize()) + this.f15336b.getMaxSize();
        int i6 = 0;
        for (d dVar : dVarArr) {
            i6 += dVar.c();
        }
        float f6 = maxSize / i6;
        HashMap hashMap = new HashMap();
        for (d dVar2 : dVarArr) {
            hashMap.put(dVar2, Integer.valueOf(Math.round(dVar2.c() * f6) / b(dVar2)));
        }
        return new c(hashMap);
    }

    public void c(d.a... aVarArr) {
        a aVar = this.f15338d;
        if (aVar != null) {
            aVar.b();
        }
        d[] dVarArr = new d[aVarArr.length];
        for (int i6 = 0; i6 < aVarArr.length; i6++) {
            d.a aVar2 = aVarArr[i6];
            if (aVar2.b() == null) {
                aVar2.c(this.f15337c == DecodeFormat.PREFER_ARGB_8888 ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565);
            }
            dVarArr[i6] = aVar2.a();
        }
        a aVar3 = new a(this.f15336b, this.f15335a, a(dVarArr));
        this.f15338d = aVar3;
        l.x(aVar3);
    }

    public b(j jVar, e eVar, DecodeFormat decodeFormat) {
        this.f15335a = jVar;
        this.f15336b = eVar;
        this.f15337c = decodeFormat;
    }

    private static int b(d dVar) {
        return l.g(dVar.d(), dVar.b(), dVar.a());
    }
}
