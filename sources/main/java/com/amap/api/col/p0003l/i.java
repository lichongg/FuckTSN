package com.amap.api.col.p0003l;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import com.autonavi.base.amap.api.mapcore.IUiSettingsDelegate;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
final class i implements IUiSettingsDelegate {

    /* renamed from: a, reason: collision with root package name */
    private IAMapDelegate f6440a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f6441b = true;

    /* renamed from: c, reason: collision with root package name */
    private boolean f6442c = true;

    /* renamed from: d, reason: collision with root package name */
    private boolean f6443d = true;

    /* renamed from: e, reason: collision with root package name */
    private boolean f6444e = false;

    /* renamed from: f, reason: collision with root package name */
    private boolean f6445f = true;

    /* renamed from: g, reason: collision with root package name */
    private boolean f6446g = true;

    /* renamed from: h, reason: collision with root package name */
    private boolean f6447h = true;

    /* renamed from: i, reason: collision with root package name */
    private boolean f6448i = false;

    /* renamed from: j, reason: collision with root package name */
    private boolean f6449j = true;

    /* renamed from: k, reason: collision with root package name */
    private int f6450k = 0;

    /* renamed from: l, reason: collision with root package name */
    private int f6451l = 1;

    /* renamed from: m, reason: collision with root package name */
    private boolean f6452m = true;

    /* renamed from: n, reason: collision with root package name */
    private boolean f6453n = false;

    /* renamed from: o, reason: collision with root package name */
    private boolean f6454o = false;

    /* renamed from: p, reason: collision with root package name */
    final Handler f6455p = new a(Looper.getMainLooper());

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class a extends Handler {
        a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            if (message == null || i.this.f6440a == null) {
                return;
            }
            try {
                switch (message.what) {
                    case 0:
                        i.this.f6440a.showZoomControlsEnabled(i.this.f6446g);
                        break;
                    case 1:
                        i.this.f6440a.showScaleEnabled(i.this.f6448i);
                        break;
                    case 2:
                        i.this.f6440a.showCompassEnabled(i.this.f6447h);
                        break;
                    case 3:
                        i.this.f6440a.showMyLocationButtonEnabled(i.this.f6444e);
                        break;
                    case 4:
                        i.this.f6440a.showIndoorSwitchControlsEnabled(i.this.f6452m);
                        break;
                    case 5:
                        i.this.f6440a.showLogoEnabled(i.this.f6449j);
                        break;
                    case 6:
                        i.this.f6440a.refreshLogo();
                        break;
                }
            } catch (Throwable th) {
                v5.p(th, "UiSettingsDelegateImp", "handleMessage");
            }
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public final float getLogoMarginRate(int i6) {
        return this.f6440a.getLogoMarginRate(i6);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public final int getLogoPosition() throws RemoteException {
        return this.f6450k;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public final int getZoomPosition() throws RemoteException {
        return this.f6451l;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public final boolean isCompassEnabled() throws RemoteException {
        return this.f6447h;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public final boolean isGestureScaleByMapCenter() throws RemoteException {
        return this.f6454o;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public final boolean isIndoorSwitchEnabled() throws RemoteException {
        return this.f6452m;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public final boolean isLogoEnable() {
        return this.f6449j;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public final boolean isMyLocationButtonEnabled() throws RemoteException {
        return this.f6444e;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public final boolean isRotateGesturesEnabled() throws RemoteException {
        return this.f6441b;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public final boolean isScaleControlsEnabled() throws RemoteException {
        return this.f6448i;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public final boolean isScrollGesturesEnabled() throws RemoteException {
        return this.f6442c;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public final boolean isTiltGesturesEnabled() throws RemoteException {
        return this.f6443d;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public final boolean isZoomControlsEnabled() throws RemoteException {
        return this.f6446g;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public final boolean isZoomGesturesEnabled() throws RemoteException {
        return this.f6445f;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public final boolean isZoomInByScreenCenter() {
        return this.f6453n;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public final void requestRefreshLogo() {
        this.f6455p.obtainMessage(6).sendToTarget();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public final void setCompassEnabled(boolean z5) throws RemoteException {
        this.f6447h = z5;
        this.f6455p.obtainMessage(2).sendToTarget();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public final void setGestureScaleByMapCenter(boolean z5) throws RemoteException {
        this.f6454o = z5;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public final void setIndoorSwitchEnabled(boolean z5) throws RemoteException {
        this.f6452m = z5;
        this.f6455p.obtainMessage(4).sendToTarget();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public final void setLogoBottomMargin(int i6) {
        this.f6440a.setLogoBottomMargin(i6);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public final void setLogoEnable(boolean z5) {
        this.f6449j = z5;
        this.f6455p.obtainMessage(5).sendToTarget();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public final void setLogoLeftMargin(int i6) {
        this.f6440a.setLogoLeftMargin(i6);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public final void setLogoMarginRate(int i6, float f6) {
        this.f6440a.setLogoMarginRate(i6, f6);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public final void setLogoPosition(int i6) throws RemoteException {
        this.f6450k = i6;
        this.f6440a.setLogoPosition(i6);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public final void setMyLocationButtonEnabled(boolean z5) throws RemoteException {
        this.f6444e = z5;
        this.f6455p.obtainMessage(3).sendToTarget();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public final void setRotateGesturesEnabled(boolean z5) throws RemoteException {
        this.f6441b = z5;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public final void setScaleControlsEnabled(boolean z5) throws RemoteException {
        this.f6448i = z5;
        this.f6455p.obtainMessage(1).sendToTarget();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public final void setScrollGesturesEnabled(boolean z5) throws RemoteException {
        this.f6442c = z5;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public final void setTiltGesturesEnabled(boolean z5) throws RemoteException {
        this.f6443d = z5;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public final void setZoomControlsEnabled(boolean z5) throws RemoteException {
        this.f6446g = z5;
        this.f6455p.obtainMessage(0).sendToTarget();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public final void setZoomGesturesEnabled(boolean z5) throws RemoteException {
        this.f6445f = z5;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public final void setZoomInByScreenCenter(boolean z5) {
        this.f6453n = z5;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public final void setZoomPosition(int i6) throws RemoteException {
        this.f6451l = i6;
        this.f6440a.setZoomPosition(i6);
    }

    i(IAMapDelegate iAMapDelegate) {
        this.f6440a = iAMapDelegate;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public final void setAllGesturesEnabled(boolean z5) throws RemoteException {
        setRotateGesturesEnabled(z5);
        setTiltGesturesEnabled(z5);
        setZoomGesturesEnabled(z5);
        setScrollGesturesEnabled(z5);
    }
}
