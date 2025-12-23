package com.amap.api.col.p0003l;

import android.app.Application;
import android.app.Notification;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.text.TextUtils;
import android.webkit.WebView;
import androidx.core.view.PointerIconCompat;
import androidx.work.PeriodicWorkRequest;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.location.AMapLocationQualityReport;
import com.amap.api.location.APSService;
import com.amap.api.location.UmidtokenInfo;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.autonavi.aps.amapapi.utils.g;
import com.autonavi.aps.amapapi.utils.h;
import com.autonavi.aps.amapapi.utils.j;
import com.stub.StubApp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class e2 {
    private static boolean L = true;
    public static volatile boolean M;
    private static boolean N;
    private static AtomicBoolean O = new AtomicBoolean(false);

    /* renamed from: a, reason: collision with root package name */
    com.autonavi.aps.amapapi.model.a f5933a;

    /* renamed from: b, reason: collision with root package name */
    private Context f5934b;

    /* renamed from: d, reason: collision with root package name */
    public f f5936d;

    /* renamed from: f, reason: collision with root package name */
    private t4 f5938f;

    /* renamed from: n, reason: collision with root package name */
    t7 f5946n;

    /* renamed from: q, reason: collision with root package name */
    Intent f5949q;

    /* renamed from: c, reason: collision with root package name */
    AMapLocationClientOption f5935c = new AMapLocationClientOption();

    /* renamed from: e, reason: collision with root package name */
    u5 f5937e = null;

    /* renamed from: g, reason: collision with root package name */
    private boolean f5939g = false;

    /* renamed from: h, reason: collision with root package name */
    private volatile boolean f5940h = false;

    /* renamed from: i, reason: collision with root package name */
    ArrayList<AMapLocationListener> f5941i = new ArrayList<>();

    /* renamed from: j, reason: collision with root package name */
    boolean f5942j = false;

    /* renamed from: k, reason: collision with root package name */
    public boolean f5943k = true;

    /* renamed from: l, reason: collision with root package name */
    public boolean f5944l = true;

    /* renamed from: m, reason: collision with root package name */
    public boolean f5945m = true;

    /* renamed from: o, reason: collision with root package name */
    Messenger f5947o = null;

    /* renamed from: p, reason: collision with root package name */
    Messenger f5948p = null;

    /* renamed from: r, reason: collision with root package name */
    int f5950r = 0;

    /* renamed from: s, reason: collision with root package name */
    private boolean f5951s = true;

    /* renamed from: t, reason: collision with root package name */
    e f5952t = null;

    /* renamed from: u, reason: collision with root package name */
    boolean f5953u = false;

    /* renamed from: v, reason: collision with root package name */
    AMapLocationClientOption.AMapLocationMode f5954v = AMapLocationClientOption.AMapLocationMode.Hight_Accuracy;

    /* renamed from: w, reason: collision with root package name */
    Object f5955w = new Object();

    /* renamed from: x, reason: collision with root package name */
    h f5956x = null;

    /* renamed from: y, reason: collision with root package name */
    boolean f5957y = false;

    /* renamed from: z, reason: collision with root package name */
    e3 f5958z = null;
    private AMapLocationClientOption A = new AMapLocationClientOption();
    private t6 B = null;
    String C = null;
    private ServiceConnection D = new b();
    AMapLocationQualityReport E = null;
    boolean F = false;
    boolean G = false;
    private volatile boolean H = false;
    d I = null;
    String J = null;
    boolean K = false;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class a extends b8 {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Context f5959d;

        a(Context context) {
            this.f5959d = context;
        }

        @Override // com.amap.api.col.p0003l.b8
        public final void runTask() {
            i4.R();
            i4.o(this.f5959d);
            i4.F(this.f5959d);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class b implements ServiceConnection {
        b() {
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                e2.this.f5947o = new Messenger(iBinder);
                e2.this.f5939g = true;
                e2.this.f5957y = true;
            } catch (Throwable th) {
                com.autonavi.aps.amapapi.utils.b.a(th, "ALManager", "onServiceConnected");
            }
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
            e2 e2Var = e2.this;
            e2Var.f5947o = null;
            e2Var.f5939g = false;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class d extends Handler {
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v0 */
        /* JADX WARN: Type inference failed for: r0v1 */
        /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.String] */
        /* JADX WARN: Type inference failed for: r0v3, types: [java.lang.String] */
        /* JADX WARN: Type inference failed for: r0v7 */
        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            ?? r02 = 0;
            try {
                super.handleMessage(message);
                if (com.autonavi.aps.amapapi.utils.a.f10214h) {
                }
                int i6 = message.what;
                if (i6 == 11) {
                    e2.this.k(message.getData());
                    return;
                }
                if (i6 == 12) {
                    e2.this.I(message);
                    return;
                }
                if (i6 == 1011) {
                    e2.this.f(14, null);
                    e2.this.i0();
                    return;
                }
                try {
                    switch (i6) {
                        case 1002:
                            e2.this.V((AMapLocationListener) message.obj);
                            break;
                        case 1003:
                            e2.this.p0();
                            e2.this.f(13, null);
                            break;
                        case 1004:
                            e2.this.s0();
                            e2.this.f(14, null);
                            break;
                        case 1005:
                            e2.this.b0((AMapLocationListener) message.obj);
                            break;
                        default:
                            switch (i6) {
                                case PointerIconCompat.TYPE_HORIZONTAL_DOUBLE_ARROW /* 1014 */:
                                    e2.this.l(message);
                                    break;
                                case PointerIconCompat.TYPE_VERTICAL_DOUBLE_ARROW /* 1015 */:
                                    e2 e2Var = e2.this;
                                    e2Var.f5937e.p(e2Var.f5935c);
                                    e2.this.g(1025, null, PeriodicWorkRequest.MIN_PERIODIC_FLEX_MILLIS);
                                    break;
                                case PointerIconCompat.TYPE_TOP_RIGHT_DIAGONAL_DOUBLE_ARROW /* 1016 */:
                                    if (!j.m(e2.this.f5934b)) {
                                        if (!e2.this.f5937e.v()) {
                                            e2.this.u0();
                                            break;
                                        } else {
                                            e2.this.g(PointerIconCompat.TYPE_TOP_RIGHT_DIAGONAL_DOUBLE_ARROW, null, 1000L);
                                            break;
                                        }
                                    } else {
                                        com.autonavi.aps.amapapi.utils.d.a();
                                        e2.this.y0();
                                        break;
                                    }
                                case PointerIconCompat.TYPE_TOP_LEFT_DIAGONAL_DOUBLE_ARROW /* 1017 */:
                                    e2.this.f5937e.c();
                                    e2.this.d(1025);
                                    break;
                                case PointerIconCompat.TYPE_ZOOM_IN /* 1018 */:
                                    e2 e2Var2 = e2.this;
                                    AMapLocationClientOption aMapLocationClientOption = (AMapLocationClientOption) message.obj;
                                    e2Var2.f5935c = aMapLocationClientOption;
                                    if (aMapLocationClientOption != null) {
                                        e2Var2.z0();
                                        break;
                                    }
                                    break;
                                default:
                                    switch (i6) {
                                        case 1023:
                                            e2.this.S(message);
                                            break;
                                        case 1024:
                                            e2.this.X(message);
                                            break;
                                        case 1025:
                                            if (e2.this.f5937e.F()) {
                                                e2.this.f5937e.c();
                                                e2 e2Var3 = e2.this;
                                                e2Var3.f5937e.p(e2Var3.f5935c);
                                            }
                                            e2.this.g(1025, null, PeriodicWorkRequest.MIN_PERIODIC_FLEX_MILLIS);
                                            break;
                                        case 1026:
                                            com.autonavi.aps.amapapi.utils.d.b();
                                            e2.this.f5938f.l(e2.this.f5935c);
                                            break;
                                        case 1027:
                                            e2.this.f5938f.b();
                                            break;
                                        case 1028:
                                            e2.this.k0((AMapLocation) message.obj);
                                            break;
                                        case 1029:
                                            Bundle bundle = new Bundle();
                                            bundle.putString("objHash", Integer.toString(System.identityHashCode(this)));
                                            e2.this.f(16, bundle);
                                            break;
                                        case 1030:
                                            Bundle bundle2 = new Bundle();
                                            bundle2.putString("objHash", Integer.toString(System.identityHashCode(this)));
                                            e2.this.f(17, bundle2);
                                            break;
                                    }
                            }
                    }
                } catch (Throwable th) {
                    r02 = message;
                    th = th;
                    if (r02 == 0) {
                        r02 = "handleMessage";
                    }
                    com.autonavi.aps.amapapi.utils.b.a(th, "AMapLocationManage$MHandlerr", r02);
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }

        public d(Looper looper) {
            super(looper);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class e extends HandlerThread {

        /* renamed from: a, reason: collision with root package name */
        e2 f5963a;

        @Override // android.os.HandlerThread
        protected final void onLooperPrepared() {
            try {
                this.f5963a.f5946n.b();
                g.a(this.f5963a.f5934b);
                this.f5963a.w0();
                e2 e2Var = this.f5963a;
                if (e2Var != null && e2Var.f5934b != null) {
                    com.autonavi.aps.amapapi.utils.a.b(this.f5963a.f5934b);
                    com.autonavi.aps.amapapi.utils.a.a(this.f5963a.f5934b);
                }
                super.onLooperPrepared();
            } catch (Throwable unused) {
            }
        }

        public e(String str, e2 e2Var) {
            super(str);
            this.f5963a = e2Var;
        }

        @Override // android.os.HandlerThread, java.lang.Thread, java.lang.Runnable
        public final void run() {
            try {
                super.run();
            } catch (Throwable unused) {
            }
        }
    }

    private synchronized void e0(AMapLocation aMapLocation) {
        if (aMapLocation == null) {
            try {
                aMapLocation = new AMapLocation("");
                aMapLocation.setErrorCode(8);
                aMapLocation.setLocationDetail("coarse amapLocation is null#2005");
            } catch (Throwable th) {
                com.autonavi.aps.amapapi.utils.b.a(th, "ALManager", "handlerCoarseLocation part2");
                return;
            }
        }
        if (this.E == null) {
            this.E = new AMapLocationQualityReport();
        }
        this.E.setLocationMode(this.f5935c.getLocationMode());
        if (this.f5938f != null) {
            this.E.setGPSSatellites(aMapLocation.getSatellites());
            this.E.setGpsStatus(this.f5938f.n());
        }
        this.E.setWifiAble(j.g(this.f5934b));
        this.E.setNetworkType(j.h(this.f5934b));
        this.E.setNetUseTime(0L);
        this.E.setInstallHighDangerMockApp(N);
        aMapLocation.setLocationQualityReport(this.E);
        try {
            if (this.f5940h) {
                h.a(this.f5934b, aMapLocation);
                a0(aMapLocation.m45clone());
                g.a(this.f5934b).a(aMapLocation);
                g.a(this.f5934b).b();
            }
        } catch (Throwable th2) {
            com.autonavi.aps.amapapi.utils.b.a(th2, "ALManager", "handlerCoarseLocation part");
        }
        if (this.f5953u) {
            return;
        }
        if (this.f5938f != null) {
            s0();
        }
        f(14, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(Bundle bundle) {
        com.autonavi.aps.amapapi.a aVar;
        AMapLocation aMapLocation;
        u5 u5Var;
        AMapLocation aMapLocation2 = null;
        if (bundle != null) {
            try {
                bundle.setClassLoader(AMapLocation.class.getClassLoader());
                aMapLocation = (AMapLocation) bundle.getParcelable("loc");
                this.J = bundle.getString("nb");
                aVar = (com.autonavi.aps.amapapi.a) bundle.getParcelable("statics");
                if (aMapLocation != null) {
                    try {
                        if (aMapLocation.getErrorCode() == 0 && (u5Var = this.f5937e) != null) {
                            u5Var.x();
                            if (!TextUtils.isEmpty(aMapLocation.getAdCode())) {
                                u5.J = aMapLocation;
                            }
                        }
                    } catch (Throwable th) {
                        th = th;
                        com.autonavi.aps.amapapi.utils.b.a(th, "AmapLocationManager", "resultLbsLocationSuccess");
                        u(aMapLocation2, aVar);
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                aVar = null;
                com.autonavi.aps.amapapi.utils.b.a(th, "AmapLocationManager", "resultLbsLocationSuccess");
                u(aMapLocation2, aVar);
            }
        } else {
            aVar = null;
            aMapLocation = null;
        }
        u5 u5Var2 = this.f5937e;
        aMapLocation2 = u5Var2 != null ? u5Var2.b(aMapLocation, this.J) : aMapLocation;
        u(aMapLocation2, aVar);
    }

    private boolean o0() {
        boolean z5 = false;
        int i6 = 0;
        while (this.f5947o == null) {
            try {
                Thread.sleep(100L);
                i6++;
                if (i6 >= 50) {
                    break;
                }
            } catch (Throwable th) {
                com.autonavi.aps.amapapi.utils.b.a(th, "ALManager", "checkAPSManager");
            }
        }
        if (this.f5947o == null) {
            Message obtain = Message.obtain();
            Bundle bundle = new Bundle();
            AMapLocation aMapLocation = new AMapLocation("");
            aMapLocation.setErrorCode(10);
            if (j.k(StubApp.getOrigApplicationContext(this.f5934b.getApplicationContext()))) {
                aMapLocation.setLocationDetail("启动ApsServcie失败#1001");
            } else {
                aMapLocation.setLocationDetail("请检查配置文件是否配置服务，并且manifest中service标签是否配置在application标签内#1003");
            }
            bundle.putParcelable("loc", aMapLocation);
            obtain.setData(bundle);
            obtain.what = 1;
            this.f5936d.sendMessage(obtain);
        } else {
            z5 = true;
        }
        if (!z5) {
            if (j.k(StubApp.getOrigApplicationContext(this.f5934b.getApplicationContext()))) {
                h.a((String) null, AMapException.CODE_AMAP_NEARBY_KEY_NOT_BIND);
            } else {
                h.a((String) null, 2103);
            }
        }
        return z5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void p0() {
        try {
            int i6 = Build.VERSION.SDK_INT;
            if (i6 < 29) {
                if (i6 >= 23) {
                    if (!j.c(this.f5934b, "EYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19DT0FSU0VfTE9DQVRJT04=")) {
                        if (j.c(this.f5934b, "EYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19GSU5FX0xPQ0FUSU9O")) {
                        }
                        r0();
                    }
                }
            }
            if ((i6 >= 31 || i6 < 29 || this.f5934b.getApplicationInfo().targetSdkVersion < 29 || j.c(this.f5934b, "EYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19GSU5FX0xPQ0FUSU9O")) && ((i6 >= 31 || i6 < 29 || this.f5934b.getApplicationInfo().targetSdkVersion >= 29 || j.c(this.f5934b, "EYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19DT0FSU0VfTE9DQVRJT04=") || j.c(this.f5934b, "EYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19GSU5FX0xPQ0FUSU9O")) && (i6 < 31 || j.c(this.f5934b, "EYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19DT0FSU0VfTE9DQVRJT04=") || j.c(this.f5934b, "EYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19GSU5FX0xPQ0FUSU9O")))) {
                if (this.f5935c == null) {
                    this.f5935c = new AMapLocationClientOption();
                }
                if (this.f5940h) {
                    return;
                }
                this.f5940h = true;
                long j6 = 0;
                g(1029, null, 0L);
                int i7 = c.f5961a[this.f5935c.getLocationMode().ordinal()];
                if (i7 == 1) {
                    g(1027, null, 0L);
                    g(PointerIconCompat.TYPE_TOP_LEFT_DIAGONAL_DOUBLE_ARROW, null, 0L);
                    g(PointerIconCompat.TYPE_TOP_RIGHT_DIAGONAL_DOUBLE_ARROW, null, 0L);
                    return;
                }
                if (i7 == 2) {
                    if (j.m(this.f5934b)) {
                        d(PointerIconCompat.TYPE_TOP_RIGHT_DIAGONAL_DOUBLE_ARROW);
                        g(PointerIconCompat.TYPE_TOP_LEFT_DIAGONAL_DOUBLE_ARROW, null, 0L);
                        g(1026, null, 0L);
                        return;
                    } else {
                        d(PointerIconCompat.TYPE_TOP_RIGHT_DIAGONAL_DOUBLE_ARROW);
                        g(1027, null, 0L);
                        g(PointerIconCompat.TYPE_VERTICAL_DOUBLE_ARROW, null, 0L);
                        return;
                    }
                }
                if (i7 == 3) {
                    if (j.m(this.f5934b)) {
                        d(PointerIconCompat.TYPE_TOP_RIGHT_DIAGONAL_DOUBLE_ARROW);
                        g(PointerIconCompat.TYPE_TOP_LEFT_DIAGONAL_DOUBLE_ARROW, null, 0L);
                        g(1026, null, 0L);
                        return;
                    } else {
                        g(1027, null, 0L);
                        g(PointerIconCompat.TYPE_VERTICAL_DOUBLE_ARROW, null, 0L);
                        if (this.f5935c.isGpsFirst() && this.f5935c.isOnceLocation()) {
                            j6 = this.f5935c.getGpsFirstTimeout();
                        }
                        g(PointerIconCompat.TYPE_TOP_RIGHT_DIAGONAL_DOUBLE_ARROW, null, j6);
                    }
                }
                return;
            }
            r0();
        } finally {
        }
    }

    private synchronized void u(AMapLocation aMapLocation, com.autonavi.aps.amapapi.a aVar) {
        if (aMapLocation == null) {
            try {
                aMapLocation = new AMapLocation("");
                aMapLocation.setErrorCode(8);
                aMapLocation.setLocationDetail("amapLocation is null#0801");
            } catch (Throwable th) {
                com.autonavi.aps.amapapi.utils.b.a(th, "ALManager", "handlerLocation part3");
                return;
            }
        }
        if (!GeocodeSearch.GPS.equalsIgnoreCase(aMapLocation.getProvider())) {
            aMapLocation.setProvider("lbs");
        }
        if (this.E == null) {
            this.E = new AMapLocationQualityReport();
        }
        this.E.setLocationMode(this.f5935c.getLocationMode());
        u5 u5Var = this.f5937e;
        if (u5Var != null) {
            this.E.setGPSSatellites(u5Var.C());
            this.E.setGpsStatus(this.f5937e.A());
        }
        this.E.setWifiAble(j.g(this.f5934b));
        this.E.setNetworkType(j.h(this.f5934b));
        if (aMapLocation.getLocationType() == 1 || GeocodeSearch.GPS.equalsIgnoreCase(aMapLocation.getProvider())) {
            this.E.setNetUseTime(0L);
        }
        if (aVar != null) {
            this.E.setNetUseTime(aVar.a());
        }
        this.E.setInstallHighDangerMockApp(N);
        aMapLocation.setLocationQualityReport(this.E);
        try {
            if (this.f5940h) {
                v(aMapLocation, this.J);
                if (aVar != null) {
                    aVar.d(j.b());
                }
                h.a(this.f5934b, aMapLocation, aVar);
                h.a(this.f5934b, aMapLocation);
                a0(aMapLocation.m45clone());
                g.a(this.f5934b).a(aMapLocation);
                g.a(this.f5934b).b();
            }
        } catch (Throwable th2) {
            com.autonavi.aps.amapapi.utils.b.a(th2, "ALManager", "handlerLocation part2");
        }
        if (this.f5953u) {
            return;
        }
        if (this.f5935c.isOnceLocation()) {
            s0();
            f(14, null);
        }
    }

    public final void R() {
        try {
            g(1004, null, 0L);
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "ALManager", "stopLocation");
        }
    }

    public final AMapLocation c0() {
        AMapLocation aMapLocation = null;
        try {
            t7 t7Var = this.f5946n;
            if (t7Var == null || (aMapLocation = t7Var.d()) == null) {
                return aMapLocation;
            }
            aMapLocation.setTrustedLevel(3);
            return aMapLocation;
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "ALManager", "getLastKnownLocation");
            return aMapLocation;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static /* synthetic */ class c {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f5961a;

        static {
            int[] iArr = new int[AMapLocationClientOption.AMapLocationMode.values().length];
            f5961a = iArr;
            try {
                iArr[AMapLocationClientOption.AMapLocationMode.Battery_Saving.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f5961a[AMapLocationClientOption.AMapLocationMode.Device_Sensors.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f5961a[AMapLocationClientOption.AMapLocationMode.Hight_Accuracy.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class f extends Handler {
        public f(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            f fVar;
            f fVar2;
            try {
                super.handleMessage(message);
                e2 e2Var = e2.this;
                if (e2Var.f5953u) {
                    return;
                }
                int i6 = message.what;
                if (i6 == 1) {
                    Message obtainMessage = e2Var.I.obtainMessage();
                    obtainMessage.what = 11;
                    obtainMessage.setData(message.getData());
                    e2.this.I.sendMessage(obtainMessage);
                    return;
                }
                if (i6 != 2) {
                    if (i6 == 13) {
                        com.autonavi.aps.amapapi.model.a aVar = e2Var.f5933a;
                        if (aVar != null) {
                            e2Var.t(aVar);
                            return;
                        }
                        AMapLocation aMapLocation = new AMapLocation("LBS");
                        aMapLocation.setErrorCode(33);
                        e2.this.t(aMapLocation);
                        return;
                    }
                    switch (i6) {
                        case 5:
                            Bundle data = message.getData();
                            data.putBundle("optBundle", com.autonavi.aps.amapapi.utils.b.a(e2.this.f5935c));
                            e2.this.f(10, data);
                            return;
                        case 6:
                            Bundle data2 = message.getData();
                            u5 u5Var = e2.this.f5937e;
                            if (u5Var != null) {
                                u5Var.h(data2);
                                return;
                            }
                            return;
                        case 7:
                            e2.this.f5951s = message.getData().getBoolean("ngpsAble");
                            return;
                        case 8:
                            h.a((String) null, 2141);
                            break;
                        case 9:
                            boolean unused = e2.N = message.getData().getBoolean("installMockApp");
                            return;
                        case 10:
                            e2Var.t((AMapLocation) message.obj);
                            return;
                        default:
                            switch (i6) {
                                case 100:
                                    h.a((String) null, 2155);
                                    break;
                                case 101:
                                    break;
                                case 102:
                                    Bundle data3 = message.getData();
                                    data3.putBundle("optBundle", com.autonavi.aps.amapapi.utils.b.a(e2.this.f5935c));
                                    e2.this.f(15, data3);
                                    return;
                                case 103:
                                    Bundle data4 = message.getData();
                                    if (e2.this.f5938f != null) {
                                        e2.this.f5938f.f(data4);
                                        return;
                                    }
                                    return;
                                default:
                                    return;
                            }
                            Message obtain = Message.obtain();
                            obtain.what = 1028;
                            obtain.obj = message.obj;
                            e2.this.I.sendMessage(obtain);
                            if (e2.this.A == null || !e2.this.A.getCacheCallBack() || (fVar2 = e2.this.f5936d) == null) {
                                return;
                            }
                            fVar2.removeMessages(13);
                            return;
                    }
                }
                Message obtain2 = Message.obtain();
                obtain2.what = 12;
                obtain2.obj = message.obj;
                e2.this.I.sendMessage(obtain2);
                if (e2.this.A == null || !e2.this.A.getCacheCallBack() || (fVar = e2.this.f5936d) == null) {
                    return;
                }
                fVar.removeMessages(13);
            } catch (Throwable th) {
                com.autonavi.aps.amapapi.utils.b.a(th, "AmapLocationManager$MainHandler", 0 == 0 ? "handleMessage" : null);
            }
        }

        public f() {
        }
    }

    private static void A(com.autonavi.aps.amapapi.b bVar, com.autonavi.aps.amapapi.model.a aVar) {
        if (aVar != null) {
            try {
                if (aVar.getErrorCode() == 0) {
                    bVar.b(aVar);
                }
            } catch (Throwable th) {
                com.autonavi.aps.amapapi.utils.b.a(th, "ALManager", "apsLocation:doFirstAddCache");
            }
        }
    }

    private boolean A0() {
        int i6;
        if (j.j(this.f5934b)) {
            try {
                i6 = com.autonavi.aps.amapapi.utils.f.b(((Application) StubApp.getOrigApplicationContext(this.f5934b.getApplicationContext())).getBaseContext(), "checkSelfPermission", "android.permission.FOREGROUND_SERVICE");
            } catch (Throwable unused) {
                i6 = -1;
            }
            if (i6 != 0) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(30:0|1|2|3|(3:4|5|(1:7))|(3:9|10|(1:12))|14|15|(2:16|17)|(3:19|(2:21|(2:99|(2:101|(1:105)))(1:23))|106)(1:107)|24|(21:26|27|28|(2:30|(1:32))|34|(3:87|88|89)(1:36)|37|38|(1:42)|44|45|(1:49)|51|52|(1:54)|55|(1:57)|(1:63)|65|66|67)(1:98)|94|(0)(0)|37|38|(2:40|42)|44|45|(2:47|49)|51|52|(0)|55|(0)|(2:61|63)|65|66|67|(1:(0))) */
    /* JADX WARN: Can't wrap try/catch for region: R(33:0|1|2|3|(3:4|5|(1:7))|9|10|(1:12)|14|15|16|17|(3:19|(2:21|(2:99|(2:101|(1:105)))(1:23))|106)(1:107)|24|(21:26|27|28|(2:30|(1:32))|34|(3:87|88|89)(1:36)|37|38|(1:42)|44|45|(1:49)|51|52|(1:54)|55|(1:57)|(1:63)|65|66|67)(1:98)|94|(0)(0)|37|38|(2:40|42)|44|45|(2:47|49)|51|52|(0)|55|(0)|(2:61|63)|65|66|67|(1:(0))) */
    /* JADX WARN: Can't wrap try/catch for region: R(35:0|1|2|3|4|5|(1:7)|9|10|(1:12)|14|15|16|17|(3:19|(2:21|(2:99|(2:101|(1:105)))(1:23))|106)(1:107)|24|(21:26|27|28|(2:30|(1:32))|34|(3:87|88|89)(1:36)|37|38|(1:42)|44|45|(1:49)|51|52|(1:54)|55|(1:57)|(1:63)|65|66|67)(1:98)|94|(0)(0)|37|38|(2:40|42)|44|45|(2:47|49)|51|52|(0)|55|(0)|(2:61|63)|65|66|67|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x011c, code lost:
    
        r1 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x0127, code lost:
    
        com.autonavi.aps.amapapi.utils.b.a(r1, "ALManager", "apsLocation:callback");
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x00ea, code lost:
    
        r8 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x00eb, code lost:
    
        com.autonavi.aps.amapapi.utils.b.a(r8, "ALManager", "fixLastLocation");
     */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0108 A[Catch: all -> 0x011c, TryCatch #11 {all -> 0x011c, blocks: (B:52:0x0101, B:54:0x0108, B:55:0x011e, B:57:0x0123), top: B:51:0x0101, outer: #8 }] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0123 A[Catch: all -> 0x011c, TRY_LEAVE, TryCatch #11 {all -> 0x011c, blocks: (B:52:0x0101, B:54:0x0108, B:55:0x011e, B:57:0x0123), top: B:51:0x0101, outer: #8 }] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x00c3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.autonavi.aps.amapapi.model.a F(com.autonavi.aps.amapapi.b r14) {
        /*
            Method dump skipped, instructions count: 332
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0003l.e2.F(com.autonavi.aps.amapapi.b):com.autonavi.aps.amapapi.model.a");
    }

    private void H(Looper looper) {
        try {
            if (looper != null) {
                this.f5936d = new f(looper);
            } else if (Looper.myLooper() == null) {
                this.f5936d = new f(this.f5934b.getMainLooper());
            } else {
                this.f5936d = new f();
            }
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "ALManager", "init 1");
        }
        try {
            try {
                this.f5946n = new t7(this.f5934b);
            } catch (Throwable th2) {
                com.autonavi.aps.amapapi.utils.b.a(th2, "ALManager", "init 5");
            }
        } catch (Throwable th3) {
            com.autonavi.aps.amapapi.utils.b.a(th3, "ALManager", "init 2");
        }
        e eVar = new e("amapLocManagerThread", this);
        this.f5952t = eVar;
        eVar.setPriority(5);
        this.f5952t.start();
        this.I = a(this.f5952t.getLooper());
        try {
            this.f5937e = new u5(this.f5934b, this.f5936d);
            this.f5938f = new t4(this.f5934b, this.f5936d);
        } catch (Throwable th4) {
            com.autonavi.aps.amapapi.utils.b.a(th4, "ALManager", "init 3");
        }
        if (this.f5956x == null) {
            this.f5956x = new h();
        }
        h(this.f5934b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I(Message message) {
        try {
            AMapLocation aMapLocation = (AMapLocation) message.obj;
            if (this.f5943k && this.f5947o != null) {
                Bundle bundle = new Bundle();
                bundle.putBundle("optBundle", com.autonavi.aps.amapapi.utils.b.a(this.f5935c));
                f(0, bundle);
                if (this.f5940h) {
                    f(13, null);
                }
                this.f5943k = false;
            }
            u(aMapLocation, null);
            d(1025);
            g(1025, null, PeriodicWorkRequest.MIN_PERIODIC_FLEX_MILLIS);
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "ALManager", "resultGpsLocationSuccess");
        }
    }

    private static void M(AMapLocation aMapLocation) {
        if (aMapLocation == null) {
            return;
        }
        try {
            if (2 == aMapLocation.getLocationType() || 4 == aMapLocation.getLocationType()) {
                long time = aMapLocation.getTime();
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis > time) {
                    aMapLocation.setTime(currentTimeMillis);
                }
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S(Message message) {
        if (message == null) {
            return;
        }
        try {
            Bundle data = message.getData();
            if (data == null) {
                return;
            }
            int i6 = data.getInt("i", 0);
            Notification notification = (Notification) data.getParcelable("h");
            Intent x02 = x0();
            x02.putExtra("i", i6);
            x02.putExtra("h", notification);
            x02.putExtra("g", 1);
            j(x02, true);
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "ALManager", "doEnableBackgroundLocation");
        }
    }

    private void U(AMapLocation aMapLocation) {
        if (aMapLocation != null) {
            try {
                String locationDetail = aMapLocation.getLocationDetail();
                StringBuilder sb = TextUtils.isEmpty(locationDetail) ? new StringBuilder() : new StringBuilder(locationDetail);
                boolean c6 = j.c(this.f5934b, "EYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19XSUZJX1NUQVRF");
                boolean c7 = j.c(this.f5934b, "WYW5kcm9pZC5wZXJtaXNzaW9uLkNIQU5HRV9XSUZJX1NUQVRF");
                boolean c8 = j.c(this.f5934b, "WYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19MT0NBVElPTl9FWFRSQV9DT01NQU5EUw==");
                boolean c9 = j.c(this.f5934b, "EYW5kcm9pZC5wZXJtaXNzaW9uLlJFQURfUEhPTkVfU1RBVEU=");
                boolean c10 = j.c(this.f5934b, "EYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19GSU5FX0xPQ0FUSU9O");
                boolean c11 = j.c(this.f5934b, "EYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19DT0FSU0VfTE9DQVRJT04=");
                sb.append(c6 ? "#pm1" : "#pm0");
                sb.append(c7 ? "1" : "0");
                sb.append(c8 ? "1" : "0");
                sb.append(c9 ? "1" : "0");
                sb.append(c10 ? "1" : "0");
                sb.append(c11 ? "1" : "0");
                aMapLocation.setLocationDetail(sb.toString());
            } catch (Throwable unused) {
                com.autonavi.aps.amapapi.utils.d.b();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V(AMapLocationListener aMapLocationListener) {
        if (aMapLocationListener == null) {
            throw new IllegalArgumentException("listener参数不能为null");
        }
        if (this.f5941i == null) {
            this.f5941i = new ArrayList<>();
        }
        if (this.f5941i.contains(aMapLocationListener)) {
            return;
        }
        this.f5941i.add(aMapLocationListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X(Message message) {
        if (message == null) {
            return;
        }
        try {
            Bundle data = message.getData();
            if (data == null) {
                return;
            }
            boolean z5 = data.getBoolean("j", true);
            Intent x02 = x0();
            x02.putExtra("j", z5);
            x02.putExtra("g", 2);
            j(x02, false);
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "ALManager", "doDisableBackgroundLocation");
        }
    }

    private d a(Looper looper) {
        d dVar;
        synchronized (this.f5955w) {
            dVar = new d(looper);
            this.I = dVar;
        }
        return dVar;
    }

    private void a0(AMapLocation aMapLocation) {
        Message obtainMessage = this.f5936d.obtainMessage();
        obtainMessage.what = 10;
        obtainMessage.obj = aMapLocation;
        this.f5936d.sendMessage(obtainMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b0(AMapLocationListener aMapLocationListener) {
        if (!this.f5941i.isEmpty() && this.f5941i.contains(aMapLocationListener)) {
            this.f5941i.remove(aMapLocationListener);
        }
        if (this.f5941i.isEmpty()) {
            s0();
        }
    }

    private com.autonavi.aps.amapapi.model.a c(com.autonavi.aps.amapapi.b bVar, boolean z5) {
        if (!this.f5935c.isLocationCacheEnable()) {
            return null;
        }
        try {
            return bVar.b(z5);
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "ALManager", "doFirstCacheLoc");
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(int i6) {
        synchronized (this.f5955w) {
            try {
                d dVar = this.I;
                if (dVar != null) {
                    dVar.removeMessages(i6);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(int i6, Bundle bundle) {
        if (bundle == null) {
            try {
                bundle = new Bundle();
            } catch (Throwable th) {
                boolean z5 = (th instanceof IllegalStateException) && th.getMessage().contains("sending message to a Handler on a dead thread");
                if ((th instanceof RemoteException) || z5) {
                    this.f5947o = null;
                    this.f5939g = false;
                }
                com.autonavi.aps.amapapi.utils.b.a(th, "ALManager", "sendLocMessage");
                return;
            }
        }
        if (TextUtils.isEmpty(this.C)) {
            this.C = com.autonavi.aps.amapapi.utils.b.b(this.f5934b);
        }
        bundle.putString("c", this.C);
        Message obtain = Message.obtain();
        obtain.what = i6;
        obtain.setData(bundle);
        obtain.replyTo = this.f5948p;
        Messenger messenger = this.f5947o;
        if (messenger != null) {
            messenger.send(obtain);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(int i6, Object obj, long j6) {
        synchronized (this.f5955w) {
            try {
                if (this.I != null) {
                    Message obtain = Message.obtain();
                    obtain.what = i6;
                    if (obj instanceof Bundle) {
                        obtain.setData((Bundle) obj);
                    } else {
                        obtain.obj = obj;
                    }
                    this.I.sendMessageDelayed(obtain, j6);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private static void h(Context context) {
        if (O.compareAndSet(false, true)) {
            a8.h().b(new a(context));
        }
    }

    private void h0(AMapLocation aMapLocation) {
        AMapLocation a6;
        if (aMapLocation == null) {
            return;
        }
        try {
            com.autonavi.aps.amapapi.storage.b bVar = t7.f7302g;
            if (bVar == null) {
                t7 t7Var = this.f5946n;
                a6 = t7Var != null ? t7Var.d() : null;
            } else {
                a6 = bVar.a();
            }
            h.a(a6, aMapLocation);
        } catch (Throwable unused) {
        }
    }

    private void i(Intent intent) {
        try {
            this.f5934b.bindService(intent, this.D, 1);
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "ALManager", "startServiceImpl");
        }
    }

    private void j(Intent intent, boolean z5) {
        Context context = this.f5934b;
        if (context != null) {
            if (Build.VERSION.SDK_INT < 26 || !z5) {
                context.startService(intent);
            } else {
                if (!A0()) {
                    return;
                }
                try {
                    this.f5934b.getClass().getMethod("startForegroundService", Intent.class).invoke(this.f5934b, intent);
                } catch (Throwable unused) {
                    this.f5934b.startService(intent);
                }
            }
            this.K = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k0(AMapLocation aMapLocation) {
        try {
            if (this.f5944l && this.f5947o != null) {
                Bundle bundle = new Bundle();
                bundle.putBundle("optBundle", com.autonavi.aps.amapapi.utils.b.a(this.f5935c));
                f(0, bundle);
                if (this.f5940h) {
                    f(13, null);
                }
                this.f5944l = false;
            }
            e0(aMapLocation);
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "ALManager", "resultGpsLocationSuccess");
        }
    }

    private void l0() {
        synchronized (this.f5955w) {
            try {
                d dVar = this.I;
                if (dVar != null) {
                    dVar.removeCallbacksAndMessages(null);
                }
                this.I = null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void r0() {
        AMapLocation aMapLocation = new AMapLocation("");
        aMapLocation.setErrorCode(12);
        aMapLocation.setLocationDetail("定位权限被禁用,请授予应用定位权限 #1201");
        if (this.E == null) {
            this.E = new AMapLocationQualityReport();
        }
        AMapLocationQualityReport aMapLocationQualityReport = new AMapLocationQualityReport();
        this.E = aMapLocationQualityReport;
        aMapLocationQualityReport.setGpsStatus(4);
        this.E.setGPSSatellites(0);
        this.E.setLocationMode(this.f5935c.getLocationMode());
        this.E.setWifiAble(j.g(this.f5934b));
        this.E.setNetworkType(j.h(this.f5934b));
        this.E.setNetUseTime(0L);
        aMapLocation.setLocationQualityReport(this.E);
        h.a((String) null, 2121);
        a0(aMapLocation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s0() {
        try {
            d(1025);
            u5 u5Var = this.f5937e;
            if (u5Var != null) {
                u5Var.c();
            }
            t4 t4Var = this.f5938f;
            if (t4Var != null) {
                t4Var.b();
            }
            d(PointerIconCompat.TYPE_TOP_RIGHT_DIAGONAL_DOUBLE_ARROW);
            g(1030, null, 0L);
            this.f5940h = false;
            this.f5950r = 0;
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "ALManager", "stopLocation");
        }
    }

    private void t0() {
        com.autonavi.aps.amapapi.model.a F = F(new com.autonavi.aps.amapapi.b(true));
        if (o0()) {
            Bundle bundle = new Bundle();
            String str = (F == null || !(F.getLocationType() == 2 || F.getLocationType() == 4)) ? "0" : "1";
            bundle.putBundle("optBundle", com.autonavi.aps.amapapi.utils.b.a(this.f5935c));
            bundle.putString("isCacheLoc", str);
            f(0, bundle);
            if (this.f5940h) {
                f(13, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u0() {
        try {
            try {
                if (L || !(this.f5957y || this.H)) {
                    L = false;
                    this.H = true;
                    t0();
                } else {
                    try {
                        if (this.f5957y && !C() && !this.G) {
                            this.G = true;
                            w0();
                        }
                    } catch (Throwable th) {
                        this.G = true;
                        com.autonavi.aps.amapapi.utils.b.a(th, "ALManager", "doLBSLocation reStartService");
                    }
                    if (o0()) {
                        this.G = false;
                        Bundle bundle = new Bundle();
                        bundle.putBundle("optBundle", com.autonavi.aps.amapapi.utils.b.a(this.f5935c));
                        bundle.putString("d", UmidtokenInfo.getUmidtoken());
                        if (!this.f5937e.v()) {
                            f(1, bundle);
                        }
                    }
                }
                if (this.f5935c.isOnceLocation()) {
                    return;
                }
            } catch (Throwable unused) {
                return;
            }
        } catch (Throwable th2) {
            try {
                com.autonavi.aps.amapapi.utils.b.a(th2, "ALManager", "doLBSLocation");
                if (this.f5935c.isOnceLocation()) {
                    return;
                }
            } catch (Throwable th3) {
                try {
                    if (!this.f5935c.isOnceLocation()) {
                        v0();
                    }
                } catch (Throwable unused2) {
                }
                throw th3;
            }
        }
        v0();
    }

    private void v(AMapLocation aMapLocation, String str) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("loc", aMapLocation);
        bundle.putString("lastLocNb", str);
        g(PointerIconCompat.TYPE_HORIZONTAL_DOUBLE_ARROW, bundle, 0L);
    }

    private void v0() {
        if (this.f5935c.getLocationMode() != AMapLocationClientOption.AMapLocationMode.Device_Sensors) {
            g(PointerIconCompat.TYPE_TOP_RIGHT_DIAGONAL_DOUBLE_ARROW, null, this.f5935c.getInterval() >= 1000 ? this.f5935c.getInterval() : 1000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w0() {
        try {
            if (this.f5948p == null) {
                this.f5948p = new Messenger(this.f5936d);
            }
            i(x0());
        } catch (Throwable unused) {
        }
    }

    private Intent x0() {
        String str;
        if (this.f5949q == null) {
            this.f5949q = new Intent(this.f5934b, (Class<?>) APSService.class);
        }
        try {
            str = !TextUtils.isEmpty(AMapLocationClientOption.getAPIKEY()) ? AMapLocationClientOption.getAPIKEY() : f4.j(this.f5934b);
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "ALManager", "startServiceImpl p2");
            str = "";
        }
        this.f5949q.putExtra("a", str);
        this.f5949q.putExtra("b", f4.g(this.f5934b));
        this.f5949q.putExtra("d", UmidtokenInfo.getUmidtoken());
        return this.f5949q;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y0() {
        try {
            StringBuilder sb = new StringBuilder();
            new com.autonavi.aps.amapapi.a().f("#2001");
            sb.append("模糊权限下不支持低功耗定位#2001");
            h.a((String) null, 2153);
            com.autonavi.aps.amapapi.model.a aVar = new com.autonavi.aps.amapapi.model.a("");
            aVar.setErrorCode(20);
            aVar.setLocationDetail(sb.toString());
            k0(aVar);
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "ALManager", "apsLocation:callback");
        }
    }

    private void z(com.autonavi.aps.amapapi.b bVar, com.autonavi.aps.amapapi.a aVar) {
        try {
            bVar.a(this.f5934b);
            bVar.a(this.f5935c);
            bVar.b(aVar);
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "ALManager", "initApsBase");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z0() {
        this.f5937e.u(this.f5935c);
        this.f5938f.q(this.f5935c);
        if (this.f5940h && !this.f5935c.getLocationMode().equals(this.f5954v)) {
            s0();
            p0();
        }
        this.f5954v = this.f5935c.getLocationMode();
        if (this.f5956x != null) {
            if (this.f5935c.isOnceLocation()) {
                this.f5956x.a(this.f5934b, 0);
            } else {
                this.f5956x.a(this.f5934b, 1);
            }
            this.f5956x.a(this.f5934b, this.f5935c);
        }
    }

    public final void B(boolean z5) {
        try {
            Bundle bundle = new Bundle();
            bundle.putBoolean("j", z5);
            g(1024, bundle, 0L);
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "ALManager", "disableBackgroundLocation");
        }
    }

    public final boolean C() {
        return this.f5939g;
    }

    public final void G() {
        f fVar;
        try {
            if (this.A.getCacheCallBack() && (fVar = this.f5936d) != null) {
                fVar.sendEmptyMessageDelayed(13, this.A.getCacheCallBackTime());
            }
        } catch (Throwable unused) {
        }
        try {
            g(1003, null, 0L);
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "ALManager", "startLocation");
        }
    }

    public final void N(AMapLocationListener aMapLocationListener) {
        try {
            g(1005, aMapLocationListener, 0L);
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "ALManager", "unRegisterLocationListener");
        }
    }

    public final void W() {
        try {
            t6 t6Var = this.B;
            if (t6Var != null) {
                t6Var.h();
                this.B = null;
            }
            g(1011, null, 0L);
            this.f5953u = true;
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "ALManager", "onDestroy");
        }
    }

    public final void e(int i6, Notification notification) {
        if (i6 == 0 || notification == null) {
            return;
        }
        try {
            if (this.f5945m && this.f5947o != null) {
                Bundle bundle = new Bundle();
                bundle.putBundle("optBundle", com.autonavi.aps.amapapi.utils.b.a(this.f5935c));
                f(0, bundle);
                this.f5945m = false;
            }
            Bundle bundle2 = new Bundle();
            bundle2.putInt("i", i6);
            bundle2.putParcelable("h", notification);
            g(1023, bundle2, 0L);
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "ALManager", "disableBackgroundLocation");
        }
    }

    public final void f0() {
        try {
            t6 t6Var = this.B;
            if (t6Var != null) {
                t6Var.h();
                this.B = null;
            }
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "ALManager", "stopAssistantLocation");
        }
    }

    final void i0() {
        f(12, null);
        this.f5943k = true;
        this.f5944l = true;
        this.f5945m = true;
        this.f5939g = false;
        this.f5957y = false;
        s0();
        h hVar = this.f5956x;
        if (hVar != null) {
            hVar.b(this.f5934b);
        }
        g.a(this.f5934b).a();
        h.a(this.f5934b);
        e3 e3Var = this.f5958z;
        if (e3Var != null) {
            e3Var.s().sendEmptyMessage(11);
        } else {
            ServiceConnection serviceConnection = this.D;
            if (serviceConnection != null) {
                this.f5934b.unbindService(serviceConnection);
            }
        }
        try {
            if (this.K) {
                this.f5934b.stopService(x0());
            }
        } catch (Throwable unused) {
        }
        this.K = false;
        ArrayList<AMapLocationListener> arrayList = this.f5941i;
        if (arrayList != null) {
            arrayList.clear();
            this.f5941i = null;
        }
        this.D = null;
        l0();
        e eVar = this.f5952t;
        if (eVar != null) {
            try {
                com.autonavi.aps.amapapi.utils.f.a(eVar, (Class<?>) HandlerThread.class, "quitSafely", new Object[0]);
            } catch (Throwable unused2) {
                this.f5952t.quit();
            }
        }
        this.f5952t = null;
        f fVar = this.f5936d;
        if (fVar != null) {
            fVar.removeCallbacksAndMessages(null);
        }
        t7 t7Var = this.f5946n;
        if (t7Var != null) {
            t7Var.e();
            this.f5946n = null;
        }
    }

    public final void m(WebView webView) {
        if (this.B == null) {
            this.B = new t6(this.f5934b, webView);
        }
        this.B.c();
    }

    public final void x(AMapLocationListener aMapLocationListener) {
        try {
            g(1002, aMapLocationListener, 0L);
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "ALManager", "setLocationListener");
        }
    }

    public e2(Context context, Intent intent, Looper looper) {
        this.f5949q = null;
        this.f5934b = context;
        this.f5949q = intent;
        H(looper);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(Message message) {
        try {
            Bundle data = message.getData();
            AMapLocation aMapLocation = (AMapLocation) data.getParcelable("loc");
            String string = data.getString("lastLocNb");
            h0(aMapLocation);
            if (this.f5946n.c(aMapLocation, string)) {
                this.f5946n.f();
            }
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "ALManager", "doSaveLastLocation");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(AMapLocation aMapLocation) {
        try {
            if (aMapLocation.getErrorCode() != 0) {
                aMapLocation.setLocationType(0);
            }
            if (aMapLocation.getErrorCode() == 0) {
                double latitude = aMapLocation.getLatitude();
                double longitude = aMapLocation.getLongitude();
                if ((latitude == 0.0d && longitude == 0.0d) || latitude < -90.0d || latitude > 90.0d || longitude < -180.0d || longitude > 180.0d) {
                    h.a("errorLatLng", aMapLocation.toStr());
                    aMapLocation.setLocationType(0);
                    aMapLocation.setErrorCode(8);
                    aMapLocation.setLocationDetail("LatLng is error#0802");
                }
            }
            if (GeocodeSearch.GPS.equalsIgnoreCase(aMapLocation.getProvider()) || !this.f5937e.v()) {
                aMapLocation.setAltitude(j.c(aMapLocation.getAltitude()));
                aMapLocation.setBearing(j.a(aMapLocation.getBearing()));
                aMapLocation.setSpeed(j.a(aMapLocation.getSpeed()));
                U(aMapLocation);
                M(aMapLocation);
                Iterator<AMapLocationListener> it = this.f5941i.iterator();
                while (it.hasNext()) {
                    try {
                        it.next().onLocationChanged(aMapLocation);
                    } catch (Throwable unused) {
                    }
                }
            }
        } catch (Throwable unused2) {
        }
    }

    private static void y(com.autonavi.aps.amapapi.b bVar) {
        try {
            bVar.d();
            bVar.a(new AMapLocationClientOption().setNeedAddress(false));
            bVar.a(true, new com.autonavi.aps.amapapi.a());
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "ALManager", "apsLocation:doFirstNetLocate 2");
        }
    }

    public final void w(AMapLocationClientOption aMapLocationClientOption) {
        try {
            this.A = aMapLocationClientOption.m46clone();
            g(PointerIconCompat.TYPE_ZOOM_IN, aMapLocationClientOption.m46clone(), 0L);
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "ALManager", "setLocationOption");
        }
    }
}
