package com.amap.api.offlineservice;

import android.view.View;
import android.widget.RelativeLayout;
import com.amap.api.maps.offlinemap.OfflineMapActivity;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    protected OfflineMapActivity f9090a = null;

    public abstract void c(View view);

    public abstract void e();

    public boolean f() {
        return true;
    }

    public abstract RelativeLayout g();

    public abstract void h();

    public final int a(float f6) {
        return this.f9090a != null ? (int) ((f6 * (r0.getResources().getDisplayMetrics().densityDpi / 160.0f)) + 0.5f) : (int) f6;
    }

    public final void b() {
        this.f9090a.showScr();
    }

    public final void d(OfflineMapActivity offlineMapActivity) {
        this.f9090a = offlineMapActivity;
    }
}
