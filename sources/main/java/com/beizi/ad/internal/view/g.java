package com.beizi.ad.internal.view;

import android.graphics.Canvas;
import com.beizi.ad.internal.view.f;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
class g extends AdWebView {

    /* renamed from: d, reason: collision with root package name */
    f f12704d;

    g(AdViewImpl adViewImpl, f fVar) {
        super(adViewImpl);
        this.f12532b = f.f12667a[f.b.STARTING_EXPANDED.ordinal()];
        this.f12704d = fVar;
    }

    @Override // com.beizi.ad.internal.view.AdWebView
    void e() {
        super.e();
        this.f12704d.a();
    }

    @Override // com.beizi.ad.internal.view.AdWebView, android.webkit.WebView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }
}
