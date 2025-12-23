package com.amap.api.col.p0003l;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.amap.api.maps.AMapOptions;
import com.amap.api.maps.CameraUpdateFactory;
import com.amap.api.maps.UiSettings;
import com.amap.api.maps.model.CameraPosition;
import com.autonavi.amap.mapcore.interfaces.IAMap;
import com.autonavi.amap.mapcore.interfaces.IMapFragmentDelegate;
import com.baidu.mobads.sdk.internal.a.c;
import com.huawei.hms.framework.common.ContainerUtils;
import com.stub.StubApp;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class d implements IMapFragmentDelegate {

    /* renamed from: f, reason: collision with root package name */
    public static volatile Context f5883f;

    /* renamed from: g, reason: collision with root package name */
    private static String f5884g;

    /* renamed from: a, reason: collision with root package name */
    private IAMap f5885a;

    /* renamed from: c, reason: collision with root package name */
    private int f5887c;

    /* renamed from: d, reason: collision with root package name */
    private AMapOptions f5888d;

    /* renamed from: b, reason: collision with root package name */
    public int f5886b = 0;

    /* renamed from: e, reason: collision with root package name */
    boolean f5889e = true;

    @Override // com.autonavi.amap.mapcore.interfaces.IMapFragmentDelegate
    public final boolean isReady() throws RemoteException {
        return false;
    }

    private static void b(Context context) {
        if (context != null) {
            f5883f = StubApp.getOrigApplicationContext(context.getApplicationContext());
        }
    }

    private void c(AMapOptions aMapOptions) throws RemoteException {
        if (aMapOptions == null || this.f5885a == null) {
            return;
        }
        CameraPosition camera = aMapOptions.getCamera();
        if (camera != null) {
            this.f5885a.moveCamera(CameraUpdateFactory.newCameraPosition(camera));
        }
        UiSettings aMapUiSettings = this.f5885a.getAMapUiSettings();
        aMapUiSettings.setRotateGesturesEnabled(aMapOptions.getRotateGesturesEnabled());
        aMapUiSettings.setScrollGesturesEnabled(aMapOptions.getScrollGesturesEnabled());
        aMapUiSettings.setTiltGesturesEnabled(aMapOptions.getTiltGesturesEnabled());
        aMapUiSettings.setZoomControlsEnabled(aMapOptions.getZoomControlsEnabled());
        aMapUiSettings.setZoomGesturesEnabled(aMapOptions.getZoomGesturesEnabled());
        aMapUiSettings.setCompassEnabled(aMapOptions.getCompassEnabled());
        aMapUiSettings.setScaleControlsEnabled(aMapOptions.getScaleControlsEnabled());
        aMapUiSettings.setLogoPosition(aMapOptions.getLogoPosition());
        this.f5885a.setMapType(aMapOptions.getMapType());
        this.f5885a.setZOrderOnTop(aMapOptions.getZOrderOnTop());
    }

    private static void d() {
        try {
            StringBuilder sb = new StringBuilder();
            for (int i6 = 0; i6 < 80; i6++) {
                sb.append(ContainerUtils.KEY_VALUE_DELIMITER);
            }
            f5884g = sb.toString();
        } catch (Throwable unused) {
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapFragmentDelegate
    public final IAMap getMap() throws RemoteException {
        if (this.f5885a == null) {
            if (f5883f == null) {
                return null;
            }
            int i6 = f5883f.getResources().getDisplayMetrics().densityDpi;
            if (i6 <= 120) {
                ga.f6364a = 0.5f;
            } else if (i6 <= 160) {
                ga.f6364a = 0.8f;
            } else if (i6 <= 240) {
                ga.f6364a = 0.87f;
            } else if (i6 <= 320) {
                ga.f6364a = 1.0f;
            } else if (i6 <= 480) {
                ga.f6364a = 1.5f;
            } else if (i6 <= 640) {
                ga.f6364a = 1.8f;
            } else {
                ga.f6364a = 0.9f;
            }
            int i7 = this.f5887c;
            if (i7 == 0) {
                this.f5885a = new n(f5883f, this.f5889e).b();
            } else if (i7 == 1) {
                this.f5885a = new o(f5883f, this.f5889e).r();
            } else {
                this.f5885a = new y9(f5883f).a();
            }
        }
        return this.f5885a;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapFragmentDelegate
    public final void loadWorldVectorMap(boolean z5) {
        this.f5889e = z5;
        IAMap iAMap = this.f5885a;
        if (iAMap != null) {
            iAMap.loadWorldVectorMap(z5);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapFragmentDelegate
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) throws RemoteException {
        byte[] byteArray;
        if (f5883f == null && layoutInflater != null) {
            setContext(StubApp.getOrigApplicationContext(layoutInflater.getContext().getApplicationContext()));
        }
        try {
            IAMap map = getMap();
            this.f5885a = map;
            map.setVisibilityEx(this.f5886b);
            if (this.f5888d == null && bundle != null && (byteArray = bundle.getByteArray("MAP_OPTIONS")) != null) {
                Parcel obtain = Parcel.obtain();
                obtain.unmarshall(byteArray, 0, byteArray.length);
                obtain.setDataPosition(0);
                this.f5888d = AMapOptions.CREATOR.createFromParcel(obtain);
            }
            c(this.f5888d);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return this.f5885a.getView();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapFragmentDelegate
    public final void onPause() throws RemoteException {
        IAMap iAMap = this.f5885a;
        if (iAMap != null) {
            iAMap.onActivityPause();
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapFragmentDelegate
    public final void onResume() throws RemoteException {
        IAMap iAMap = this.f5885a;
        if (iAMap != null) {
            iAMap.onActivityResume();
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapFragmentDelegate
    public final void onSaveInstanceState(Bundle bundle) throws RemoteException {
        if (this.f5885a != null) {
            if (this.f5888d == null) {
                this.f5888d = new AMapOptions();
            }
            try {
                Parcel obtain = Parcel.obtain();
                AMapOptions camera = this.f5888d.camera(getMap().getCameraPosition());
                this.f5888d = camera;
                camera.writeToParcel(obtain, 0);
                bundle.putByteArray("MAP_OPTIONS", obtain.marshall());
            } catch (Throwable unused) {
            }
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapFragmentDelegate
    public final void setOptions(AMapOptions aMapOptions) {
        this.f5888d = aMapOptions;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapFragmentDelegate
    public final void setVisibility(int i6) {
        this.f5886b = i6;
        IAMap iAMap = this.f5885a;
        if (iAMap != null) {
            iAMap.setVisibilityEx(i6);
        }
    }

    public d(int i6) {
        this.f5887c = i6 % 3;
        d();
    }

    private static void a() {
        try {
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            boolean z5 = false;
            boolean z6 = false;
            boolean z7 = false;
            for (int i6 = 0; i6 < stackTrace.length; i6++) {
                if (stackTrace[i6].getClassName() != null && stackTrace[i6].getClassName().endsWith("TextureMapView")) {
                    z6 = true;
                }
                if (stackTrace[i6].getClassName() != null && stackTrace[i6].getClassName().endsWith(c.f10530e)) {
                    z5 = true;
                }
                if ("OnDestroyView".equalsIgnoreCase(stackTrace[i6].getMethodName())) {
                    z7 = true;
                }
            }
            if (z5 && z6 && !z7) {
                e();
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapFragmentDelegate
    public final void onDestroy() throws RemoteException {
        a();
        IAMap iAMap = this.f5885a;
        if (iAMap != null) {
            iAMap.clear();
            this.f5885a.destroy();
            this.f5885a = null;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapFragmentDelegate
    public final void onInflate(Activity activity, AMapOptions aMapOptions, Bundle bundle) throws RemoteException {
        setContext(StubApp.getOrigApplicationContext(activity.getApplicationContext()));
        this.f5888d = aMapOptions;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapFragmentDelegate
    public final void setContext(Context context) {
        b(context);
    }

    private static void e() {
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapFragmentDelegate
    public void onCreate(Bundle bundle) throws RemoteException {
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapFragmentDelegate
    public final void onDestroyView() throws RemoteException {
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapFragmentDelegate
    public final void onLowMemory() throws RemoteException {
    }
}
