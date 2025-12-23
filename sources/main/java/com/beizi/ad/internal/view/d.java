package com.beizi.ad.internal.view;

import android.view.View;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class d implements e {

    /* renamed from: a, reason: collision with root package name */
    private long f12663a;

    /* renamed from: b, reason: collision with root package name */
    private c f12664b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f12665c;

    /* renamed from: d, reason: collision with root package name */
    private com.beizi.ad.internal.d.b f12666d;

    @Override // com.beizi.ad.internal.view.e
    public long a() {
        return this.f12663a;
    }

    @Override // com.beizi.ad.internal.view.e
    public boolean b() {
        return this.f12665c;
    }

    @Override // com.beizi.ad.internal.view.e
    public com.beizi.ad.internal.d.b c() {
        return this.f12666d;
    }

    @Override // com.beizi.ad.internal.view.e
    public View d() {
        c cVar = this.f12664b;
        if (cVar == null) {
            return null;
        }
        return cVar.getView();
    }

    d(c cVar, Long l6, boolean z5, com.beizi.ad.internal.d.b bVar) {
        this.f12663a = l6.longValue();
        this.f12664b = cVar;
        this.f12665c = z5;
        this.f12666d = bVar;
    }
}
