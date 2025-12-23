package com.amap.api.col.p0003l;

import android.os.RemoteException;
import com.amap.api.maps.MapsInitializer;
import com.amap.api.maps.model.TileOverlay;
import com.amap.api.maps.model.TileOverlayOptions;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class r1 {

    /* renamed from: a, reason: collision with root package name */
    private final IAMapDelegate f7161a;

    /* renamed from: b, reason: collision with root package name */
    private TileOverlay f7162b;

    /* renamed from: c, reason: collision with root package name */
    private TileOverlay f7163c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f7164d = false;

    /* renamed from: e, reason: collision with root package name */
    private boolean f7165e = false;

    private void b() {
        if (this.f7162b == null) {
            TileOverlayOptions tileProvider = new TileOverlayOptions().tileProvider(new j2(this.f7161a.getMapConfig()));
            tileProvider.memCacheSize(10485760);
            tileProvider.diskCacheSize(20480);
            tileProvider.visible(this.f7164d);
            try {
                this.f7162b = this.f7161a.addTileOverlay(tileProvider);
                this.f7163c = this.f7161a.addTileOverlay(tileProvider);
            } catch (RemoteException e6) {
                e6.printStackTrace();
            }
        }
    }

    private boolean e() {
        IAMapDelegate iAMapDelegate = this.f7161a;
        if (iAMapDelegate == null) {
            return false;
        }
        return iAMapDelegate.getMapConfig().getMapLanguage().equals("en");
    }

    public r1(IAMapDelegate iAMapDelegate) {
        this.f7161a = iAMapDelegate;
    }

    private void c() {
        boolean e6 = e();
        if (e6) {
            b();
        }
        if (this.f7164d != e6) {
            this.f7164d = e6;
            TileOverlay tileOverlay = this.f7162b;
            if (tileOverlay != null) {
                tileOverlay.setVisible(e6);
            }
        }
    }

    private void d() {
        boolean f6 = f();
        if (f6) {
            b();
        }
        if (this.f7165e != f6) {
            this.f7165e = f6;
            TileOverlay tileOverlay = this.f7163c;
            if (tileOverlay != null) {
                tileOverlay.setVisible(f6);
            }
        }
    }

    private static boolean f() {
        return MapsInitializer.isLoadWorldGridMap();
    }

    public final void a() {
        c();
        d();
    }
}
