package com.beizi.ad.internal.d;

import android.view.View;
import com.beizi.ad.internal.h.u;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class e implements com.beizi.ad.internal.view.c {

    /* renamed from: a, reason: collision with root package name */
    private View f11758a;

    /* renamed from: b, reason: collision with root package name */
    private b f11759b;

    void a(View view) {
        this.f11758a = view;
    }

    @Override // com.beizi.ad.internal.view.c
    public int getRefreshInterval() {
        return 0;
    }

    public b a() {
        return this.f11759b;
    }

    @Override // com.beizi.ad.internal.view.c
    public void destroy() {
        this.f11759b.b();
        u.a(this.f11758a);
    }

    @Override // com.beizi.ad.internal.view.c
    public boolean failed() {
        return this.f11759b.f11736g;
    }

    @Override // com.beizi.ad.internal.view.c
    public int getCreativeHeight() {
        View view = this.f11758a;
        if (view != null) {
            return view.getHeight();
        }
        return -1;
    }

    @Override // com.beizi.ad.internal.view.c
    public int getCreativeWidth() {
        View view = this.f11758a;
        if (view != null) {
            return view.getWidth();
        }
        return -1;
    }

    @Override // com.beizi.ad.internal.view.c
    public View getView() {
        return this.f11758a;
    }

    @Override // com.beizi.ad.internal.view.c
    public void onDestroy() {
        this.f11759b.i();
        destroy();
    }

    @Override // com.beizi.ad.internal.view.c
    public void onPause() {
        this.f11759b.j();
    }

    @Override // com.beizi.ad.internal.view.c
    public void onResume() {
        this.f11759b.k();
    }

    e(b bVar) {
        this.f11759b = bVar;
    }

    @Override // com.beizi.ad.internal.view.c
    public void visible() {
    }
}
