package com.amap.api.col.p0003l;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.text.TextUtils;
import com.amap.api.col.p0003l.ft;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.maps.LocationSource;
import com.amap.api.maps.model.MyLocationStyle;
import com.autonavi.base.ae.gmap.glyph.ReflectUtil;
import io.netty.handler.codec.rtsp.RtspHeaders;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class b0 implements LocationSource {
    private Method A;
    private Method B;
    private Method C;
    private Method D;
    private Method E;
    private Method F;
    private Method G;
    private Method H;
    private Method I;
    private boolean J = false;
    private long K = 2000;
    private InvocationHandler L = new a();

    /* renamed from: a, reason: collision with root package name */
    private Context f5660a;

    /* renamed from: b, reason: collision with root package name */
    private LocationSource.OnLocationChangedListener f5661b;

    /* renamed from: c, reason: collision with root package name */
    private Object f5662c;

    /* renamed from: d, reason: collision with root package name */
    private Object f5663d;

    /* renamed from: e, reason: collision with root package name */
    private Object f5664e;

    /* renamed from: f, reason: collision with root package name */
    private Method f5665f;

    /* renamed from: g, reason: collision with root package name */
    private Method f5666g;

    /* renamed from: h, reason: collision with root package name */
    private Method f5667h;

    /* renamed from: i, reason: collision with root package name */
    private Method f5668i;

    /* renamed from: j, reason: collision with root package name */
    private Method f5669j;

    /* renamed from: k, reason: collision with root package name */
    private Method f5670k;

    /* renamed from: l, reason: collision with root package name */
    private Method f5671l;

    /* renamed from: m, reason: collision with root package name */
    private Method f5672m;

    /* renamed from: n, reason: collision with root package name */
    private Method f5673n;

    /* renamed from: o, reason: collision with root package name */
    private Method f5674o;

    /* renamed from: p, reason: collision with root package name */
    private Method f5675p;

    /* renamed from: q, reason: collision with root package name */
    private Method f5676q;

    /* renamed from: r, reason: collision with root package name */
    private Method f5677r;

    /* renamed from: s, reason: collision with root package name */
    private Method f5678s;

    /* renamed from: t, reason: collision with root package name */
    private Method f5679t;

    /* renamed from: u, reason: collision with root package name */
    private Method f5680u;

    /* renamed from: v, reason: collision with root package name */
    private Method f5681v;

    /* renamed from: w, reason: collision with root package name */
    private Method f5682w;

    /* renamed from: x, reason: collision with root package name */
    private Method f5683x;

    /* renamed from: y, reason: collision with root package name */
    private Method f5684y;

    /* renamed from: z, reason: collision with root package name */
    private Method f5685z;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class a implements InvocationHandler {
        a() {
        }

        @Override // java.lang.reflect.InvocationHandler
        public final Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            if (!TextUtils.equals(method.getName(), "onLocationChanged") || b0.this.f5661b == null || objArr == null || objArr.length != 1) {
                return null;
            }
            Object obj2 = objArr[0];
            Location location = (Location) obj2;
            Bundle extras = location.getExtras();
            if (extras == null) {
                extras = new Bundle();
            }
            Object invokeMethod = ReflectUtil.invokeMethod(obj2, b0.this.f5675p, new Object[0]);
            if (invokeMethod instanceof Integer) {
                extras.putInt("errorCode", ((Integer) invokeMethod).intValue());
            }
            Object invokeMethod2 = ReflectUtil.invokeMethod(obj2, b0.this.f5676q, new Object[0]);
            if (invokeMethod2 instanceof String) {
                extras.putString(MyLocationStyle.ERROR_INFO, (String) invokeMethod2);
            }
            Object invokeMethod3 = ReflectUtil.invokeMethod(obj2, b0.this.f5677r, new Object[0]);
            if (invokeMethod3 instanceof Integer) {
                extras.putInt(MyLocationStyle.LOCATION_TYPE, ((Integer) invokeMethod3).intValue());
            }
            Object invokeMethod4 = ReflectUtil.invokeMethod(obj2, b0.this.f5678s, new Object[0]);
            if (invokeMethod4 instanceof Float) {
                extras.putFloat("Accuracy", ((Float) invokeMethod4).floatValue());
            }
            Object invokeMethod5 = ReflectUtil.invokeMethod(obj2, b0.this.f5679t, new Object[0]);
            if (invokeMethod5 instanceof String) {
                extras.putString("AdCode", (String) invokeMethod5);
            }
            Object invokeMethod6 = ReflectUtil.invokeMethod(obj2, b0.this.f5680u, new Object[0]);
            if (invokeMethod6 instanceof String) {
                extras.putString("Address", (String) invokeMethod6);
            }
            Object invokeMethod7 = ReflectUtil.invokeMethod(obj2, b0.this.f5681v, new Object[0]);
            if (invokeMethod7 instanceof String) {
                extras.putString("AoiName", (String) invokeMethod7);
            }
            Object invokeMethod8 = ReflectUtil.invokeMethod(obj2, b0.this.f5682w, new Object[0]);
            if (invokeMethod8 instanceof String) {
                extras.putString("City", (String) invokeMethod8);
            }
            Object invokeMethod9 = ReflectUtil.invokeMethod(obj2, b0.this.f5683x, new Object[0]);
            if (invokeMethod9 instanceof String) {
                extras.putString("CityCode", (String) invokeMethod9);
            }
            Object invokeMethod10 = ReflectUtil.invokeMethod(obj2, b0.this.f5684y, new Object[0]);
            if (invokeMethod10 instanceof String) {
                extras.putString("Country", (String) invokeMethod10);
            }
            Object invokeMethod11 = ReflectUtil.invokeMethod(obj2, b0.this.f5685z, new Object[0]);
            if (invokeMethod11 instanceof String) {
                extras.putString("District", (String) invokeMethod11);
            }
            Object invokeMethod12 = ReflectUtil.invokeMethod(obj2, b0.this.A, new Object[0]);
            if (invokeMethod12 instanceof String) {
                extras.putString("Street", (String) invokeMethod12);
            }
            Object invokeMethod13 = ReflectUtil.invokeMethod(obj2, b0.this.B, new Object[0]);
            if (invokeMethod13 instanceof String) {
                extras.putString("StreetNum", (String) invokeMethod13);
            }
            Object invokeMethod14 = ReflectUtil.invokeMethod(obj2, b0.this.C, new Object[0]);
            if (invokeMethod14 instanceof String) {
                extras.putString("PoiName", (String) invokeMethod14);
            }
            Object invokeMethod15 = ReflectUtil.invokeMethod(obj2, b0.this.D, new Object[0]);
            if (invokeMethod15 instanceof String) {
                extras.putString("Province", (String) invokeMethod15);
            }
            Object invokeMethod16 = ReflectUtil.invokeMethod(obj2, b0.this.E, new Object[0]);
            if (invokeMethod16 instanceof Float) {
                extras.putFloat(RtspHeaders.Names.SPEED, ((Float) invokeMethod16).floatValue());
            }
            Object invokeMethod17 = ReflectUtil.invokeMethod(obj2, b0.this.F, new Object[0]);
            if (invokeMethod17 instanceof String) {
                extras.putString("Floor", (String) invokeMethod17);
            }
            Object invokeMethod18 = ReflectUtil.invokeMethod(obj2, b0.this.G, new Object[0]);
            if (invokeMethod18 instanceof Float) {
                extras.putFloat("Bearing", ((Float) invokeMethod18).floatValue());
            }
            Object invokeMethod19 = ReflectUtil.invokeMethod(obj2, b0.this.H, new Object[0]);
            if (invokeMethod19 instanceof String) {
                extras.putString("BuildingId", (String) invokeMethod19);
            }
            Object invokeMethod20 = ReflectUtil.invokeMethod(obj2, b0.this.I, new Object[0]);
            if (invokeMethod20 instanceof Double) {
                extras.putDouble("Altitude", ((Double) invokeMethod20).doubleValue());
            }
            location.setExtras(extras);
            b0.this.f5661b.onLocationChanged(location);
            return null;
        }
    }

    public final void c(int i6) {
        if (i6 == 1 || i6 == 0) {
            e(true);
        } else {
            e(false);
        }
    }

    @Override // com.amap.api.maps.LocationSource
    public final void deactivate() {
        this.f5661b = null;
        Object obj = this.f5662c;
        if (obj != null) {
            ReflectUtil.invokeMethod(obj, this.f5668i, new Object[0]);
            ReflectUtil.invokeMethod(this.f5662c, this.f5669j, new Object[0]);
        }
        this.f5662c = null;
    }

    private void b() {
        try {
            this.f5665f = ReflectUtil.getMethod("com.amap.api.location.AMapLocationClient", "setLocationListener", AMapLocationListener.class);
            this.f5666g = ReflectUtil.getMethod("com.amap.api.location.AMapLocationClient", "setLocationOption", Class.forName("com.amap.api.location.AMapLocationClientOption"));
            this.f5667h = ReflectUtil.getMethod("com.amap.api.location.AMapLocationClient", "startLocation", new Class[0]);
            this.f5668i = ReflectUtil.getMethod("com.amap.api.location.AMapLocationClient", "stopLocation", new Class[0]);
            this.f5669j = ReflectUtil.getMethod("com.amap.api.location.AMapLocationClient", "onDestroy", new Class[0]);
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    private void e(boolean z5) {
        Object obj;
        if (this.f5663d != null && (obj = this.f5662c) != null) {
            try {
                ReflectUtil.invokeMethod(obj, this.f5669j, new Object[0]);
                this.f5662c = ReflectUtil.newInstance("com.amap.api.location.AMapLocationClient", new Class[]{Context.class}, new Object[]{this.f5660a});
                Object newProxyInstance = Proxy.newProxyInstance(b0.class.getClassLoader(), new Class[]{AMapLocationListener.class}, this.L);
                this.f5664e = newProxyInstance;
                ReflectUtil.invokeMethod(this.f5662c, this.f5665f, newProxyInstance);
                ReflectUtil.invokeMethod(this.f5663d, this.f5671l, Boolean.valueOf(z5));
                ReflectUtil.invokeMethod(this.f5663d, this.f5673n, Boolean.FALSE);
                if (!z5) {
                    ReflectUtil.invokeMethod(this.f5663d, this.f5670k, Long.valueOf(this.K));
                }
                ReflectUtil.invokeMethod(this.f5662c, this.f5666g, this.f5663d);
                ReflectUtil.invokeMethod(this.f5662c, this.f5667h, new Object[0]);
            } catch (Exception e6) {
                e6.printStackTrace();
            }
        }
        this.J = z5;
    }

    private void g() {
        try {
            this.f5670k = ReflectUtil.getMethod("com.amap.api.location.AMapLocationClientOption", "setInterval", Long.TYPE);
            Class cls = Boolean.TYPE;
            this.f5671l = ReflectUtil.getMethod("com.amap.api.location.AMapLocationClientOption", "setOnceLocation", cls);
            this.f5672m = ReflectUtil.getMethod("com.amap.api.location.AMapLocationClientOption", "setLocationMode", Class.forName("com.amap.api.location.AMapLocationClientOption$AMapLocationMode"));
            this.f5673n = ReflectUtil.getMethod("com.amap.api.location.AMapLocationClientOption", "setNeedAddress", cls);
            this.f5674o = ReflectUtil.getMethod("com.amap.api.location.AMapLocationClientOption", "getInterval", new Class[0]);
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    private void i() {
        try {
            this.f5675p = ReflectUtil.getMethod("com.amap.api.location.AMapLocation", "getErrorCode", new Class[0]);
            this.f5676q = ReflectUtil.getMethod("com.amap.api.location.AMapLocation", "getErrorInfo", new Class[0]);
            this.f5677r = ReflectUtil.getMethod("com.amap.api.location.AMapLocation", "getLocationType", new Class[0]);
            this.f5678s = ReflectUtil.getMethod("com.amap.api.location.AMapLocation", "getAccuracy", new Class[0]);
            this.f5679t = ReflectUtil.getMethod("com.amap.api.location.AMapLocation", "getAdCode", new Class[0]);
            this.f5680u = ReflectUtil.getMethod("com.amap.api.location.AMapLocation", "getAddress", new Class[0]);
            this.f5681v = ReflectUtil.getMethod("com.amap.api.location.AMapLocation", "getAoiName", new Class[0]);
            this.f5682w = ReflectUtil.getMethod("com.amap.api.location.AMapLocation", "getCity", new Class[0]);
            this.f5683x = ReflectUtil.getMethod("com.amap.api.location.AMapLocation", "getCityCode", new Class[0]);
            this.f5684y = ReflectUtil.getMethod("com.amap.api.location.AMapLocation", "getCountry", new Class[0]);
            this.f5685z = ReflectUtil.getMethod("com.amap.api.location.AMapLocation", "getDistrict", new Class[0]);
            this.A = ReflectUtil.getMethod("com.amap.api.location.AMapLocation", "getStreet", new Class[0]);
            this.B = ReflectUtil.getMethod("com.amap.api.location.AMapLocation", "getStreetNum", new Class[0]);
            this.C = ReflectUtil.getMethod("com.amap.api.location.AMapLocation", "getPoiName", new Class[0]);
            this.D = ReflectUtil.getMethod("com.amap.api.location.AMapLocation", "getProvince", new Class[0]);
            this.E = ReflectUtil.getMethod("com.amap.api.location.AMapLocation", "getSpeed", new Class[0]);
            this.F = ReflectUtil.getMethod("com.amap.api.location.AMapLocation", "getFloor", new Class[0]);
            this.G = ReflectUtil.getMethod("com.amap.api.location.AMapLocation", "getBearing", new Class[0]);
            this.H = ReflectUtil.getMethod("com.amap.api.location.AMapLocation", "getBuildingId", new Class[0]);
            this.I = ReflectUtil.getMethod("com.amap.api.location.AMapLocation", "getAltitude", new Class[0]);
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    @Override // com.amap.api.maps.LocationSource
    public final void activate(LocationSource.OnLocationChangedListener onLocationChangedListener) {
        this.f5661b = onLocationChangedListener;
        if (ft.a(this.f5660a, b3.s()).f6803a == ft.c.SuccessCode && this.f5662c == null) {
            try {
                Object newInstance = ReflectUtil.newInstance("com.amap.api.location.AMapLocationClient", new Class[]{Context.class}, new Object[]{this.f5660a});
                this.f5662c = newInstance;
                if (newInstance == null) {
                    return;
                }
                this.f5663d = ReflectUtil.newInstance("com.amap.api.location.AMapLocationClientOption", null, null);
                Object newProxyInstance = Proxy.newProxyInstance(b0.class.getClassLoader(), new Class[]{AMapLocationListener.class}, this.L);
                this.f5664e = newProxyInstance;
                ReflectUtil.invokeMethod(this.f5662c, this.f5665f, newProxyInstance);
                ReflectUtil.invokeMethod(this.f5663d, this.f5670k, Long.valueOf(this.K));
                ReflectUtil.invokeMethod(this.f5663d, this.f5671l, Boolean.valueOf(this.J));
                ReflectUtil.invokeMethod(this.f5663d, this.f5672m, ReflectUtil.getField("com.amap.api.location.AMapLocationClientOption$AMapLocationMode", null, "Hight_Accuracy"));
                ReflectUtil.invokeMethod(this.f5663d, this.f5673n, Boolean.FALSE);
                ReflectUtil.invokeMethod(this.f5662c, this.f5666g, this.f5663d);
                ReflectUtil.invokeMethod(this.f5662c, this.f5667h, new Object[0]);
            } catch (Exception e6) {
                e6.printStackTrace();
            }
        }
    }

    public final void d(long j6) {
        Object obj = this.f5663d;
        if (obj != null && this.f5662c != null) {
            Object invokeMethod = ReflectUtil.invokeMethod(obj, this.f5674o, new Object[0]);
            if ((invokeMethod instanceof Long) && ((Long) invokeMethod).longValue() != j6) {
                ReflectUtil.invokeMethod(this.f5663d, this.f5670k, Long.valueOf(j6));
                ReflectUtil.invokeMethod(this.f5662c, this.f5666g, this.f5663d);
            }
        }
        this.K = j6;
    }

    public b0(Context context) {
        this.f5660a = context;
        b();
        g();
        i();
    }
}
