package com.amap.api.col.p0003l;

import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.Parcelable;
import android.text.TextUtils;
import com.amap.api.fence.GeoFence;
import com.amap.api.fence.GeoFenceListener;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.location.DPoint;
import com.amap.api.services.district.DistrictSearchQuery;
import com.autonavi.aps.amapapi.utils.h;
import com.autonavi.aps.amapapi.utils.j;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.snail.antifake.deviceid.e;
import com.stub.StubApp;
import com.umeng.analytics.pro.bi;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;
import tv.danmaku.ijk.media.player.IMediaPlayer;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SuppressLint({"NewApi"})
/* loaded from: D:\Downloads\app\classes2.dex */
public final class a {
    private static boolean A;

    /* renamed from: b, reason: collision with root package name */
    Context f5574b;

    /* renamed from: a, reason: collision with root package name */
    h f5573a = null;

    /* renamed from: c, reason: collision with root package name */
    PendingIntent f5575c = null;

    /* renamed from: d, reason: collision with root package name */
    String f5576d = null;

    /* renamed from: e, reason: collision with root package name */
    GeoFenceListener f5577e = null;

    /* renamed from: f, reason: collision with root package name */
    private Object f5578f = new Object();

    /* renamed from: g, reason: collision with root package name */
    volatile int f5579g = 1;

    /* renamed from: h, reason: collision with root package name */
    ArrayList<GeoFence> f5580h = new ArrayList<>();

    /* renamed from: i, reason: collision with root package name */
    d f5581i = null;

    /* renamed from: j, reason: collision with root package name */
    Object f5582j = new Object();

    /* renamed from: k, reason: collision with root package name */
    Object f5583k = new Object();

    /* renamed from: l, reason: collision with root package name */
    b f5584l = null;

    /* renamed from: m, reason: collision with root package name */
    c f5585m = null;

    /* renamed from: n, reason: collision with root package name */
    volatile boolean f5586n = false;

    /* renamed from: o, reason: collision with root package name */
    volatile boolean f5587o = false;

    /* renamed from: p, reason: collision with root package name */
    volatile boolean f5588p = false;

    /* renamed from: q, reason: collision with root package name */
    e0 f5589q = null;

    /* renamed from: r, reason: collision with root package name */
    e1 f5590r = null;

    /* renamed from: s, reason: collision with root package name */
    AMapLocationClient f5591s = null;

    /* renamed from: t, reason: collision with root package name */
    volatile AMapLocation f5592t = null;

    /* renamed from: u, reason: collision with root package name */
    long f5593u = 0;

    /* renamed from: v, reason: collision with root package name */
    AMapLocationClientOption f5594v = null;

    /* renamed from: w, reason: collision with root package name */
    int f5595w = 0;

    /* renamed from: x, reason: collision with root package name */
    AMapLocationListener f5596x = new C0087a();

    /* renamed from: y, reason: collision with root package name */
    final int f5597y = 3;

    /* renamed from: z, reason: collision with root package name */
    volatile boolean f5598z = false;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.amap.api.col.3l.a$a, reason: collision with other inner class name */
    final class C0087a implements AMapLocationListener {
        C0087a() {
        }

        @Override // com.amap.api.location.AMapLocationListener
        public final void onLocationChanged(AMapLocation aMapLocation) {
            boolean z5;
            int i6;
            try {
                if (!a.this.f5598z && a.this.f5588p) {
                    a.this.f5592t = aMapLocation;
                    if (aMapLocation != null) {
                        i6 = aMapLocation.getErrorCode();
                        if (aMapLocation.getErrorCode() == 0) {
                            a.this.f5593u = j.b();
                            a.this.j(5, null, 0L);
                            z5 = true;
                        } else {
                            a.p("定位失败", aMapLocation.getErrorCode(), aMapLocation.getErrorInfo(), "locationDetail:" + aMapLocation.getLocationDetail());
                            z5 = false;
                        }
                    } else {
                        z5 = false;
                        i6 = 8;
                    }
                    if (z5) {
                        a aVar = a.this;
                        aVar.f5595w = 0;
                        aVar.j(6, null, 0L);
                        return;
                    }
                    Bundle bundle = new Bundle();
                    if (!a.this.f5586n) {
                        a.this.D(7);
                        bundle.putLong(bi.aX, 2000L);
                        a.this.j(8, bundle, 2000L);
                    }
                    a aVar2 = a.this;
                    int i7 = aVar2.f5595w + 1;
                    aVar2.f5595w = i7;
                    if (i7 >= 3) {
                        bundle.putInt(GeoFence.BUNDLE_KEY_LOCERRORCODE, i6);
                        a.this.i(1002, bundle);
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b extends Handler {
        public b(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            try {
                switch (message.what) {
                    case 0:
                        a.this.F(message.getData());
                        break;
                    case 1:
                        a.this.M(message.getData());
                        break;
                    case 2:
                        a.this.S(message.getData());
                        break;
                    case 3:
                        a.this.P(message.getData());
                        break;
                    case 4:
                        a.this.U(message.getData());
                        break;
                    case 5:
                        a.this.R();
                        break;
                    case 6:
                        a aVar = a.this;
                        aVar.m(aVar.f5592t);
                        break;
                    case 7:
                        a.this.O();
                        break;
                    case 8:
                        a.this.c0(message.getData());
                        break;
                    case 9:
                        a.this.k(message.getData());
                        break;
                    case 10:
                        a.this.K();
                        break;
                    case 11:
                        a.this.Y(message.getData());
                        break;
                    case 12:
                        a.this.W(message.getData());
                        break;
                    case 13:
                        a.this.V();
                        break;
                }
            } catch (Throwable unused) {
            }
        }
    }

    static float A(DPoint dPoint, List<DPoint> list) {
        float f6 = Float.MIN_VALUE;
        if (dPoint != null && list != null && !list.isEmpty()) {
            Iterator<DPoint> it = list.iterator();
            while (it.hasNext()) {
                f6 = Math.max(f6, j.a(dPoint, it.next()));
            }
        }
        return f6;
    }

    private static boolean H(AMapLocation aMapLocation, GeoFence geoFence) {
        boolean z5 = false;
        try {
            if (y(aMapLocation, geoFence)) {
                if (geoFence.getEnterTime() == -1) {
                    if (geoFence.getStatus() != 1) {
                        geoFence.setEnterTime(j.b());
                        geoFence.setStatus(1);
                        return true;
                    }
                } else if (geoFence.getStatus() != 3 && j.b() - geoFence.getEnterTime() > TTAdConstant.AD_MAX_EVENT_TIME) {
                    geoFence.setStatus(3);
                    return true;
                }
            } else if (geoFence.getStatus() != 2) {
                try {
                    geoFence.setStatus(2);
                    geoFence.setEnterTime(-1L);
                    return true;
                } catch (Throwable th) {
                    th = th;
                    z5 = true;
                    com.autonavi.aps.amapapi.utils.b.a(th, "Utils", "isFenceStatusChanged");
                    return z5;
                }
            }
            return false;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private int J(GeoFence geoFence) {
        try {
            if (this.f5580h == null) {
                this.f5580h = new ArrayList<>();
            }
            if (this.f5580h.contains(geoFence)) {
                return 17;
            }
            this.f5580h.add(geoFence);
            return 0;
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "GeoFenceManager", "addGeoFence2List");
            p("添加围栏失败", 8, th.getMessage(), new String[0]);
            return 8;
        }
    }

    private static int N(int i6) {
        if (i6 != 1 && i6 != 7 && i6 != 4 && i6 != 5 && i6 != 16 && i6 != 17) {
            switch (i6) {
                case 10000:
                    i6 = 0;
                    break;
                case 10001:
                case 10002:
                case 10007:
                case IMediaPlayer.MEDIA_INFO_VIDEO_SEEK_RENDERING_START /* 10008 */:
                case IMediaPlayer.MEDIA_INFO_AUDIO_SEEK_RENDERING_START /* 10009 */:
                case 10012:
                case 10013:
                    i6 = 7;
                    break;
                case 10003:
                case 10004:
                case 10005:
                case 10006:
                case 10010:
                case 10011:
                case 10014:
                case 10015:
                case 10016:
                case 10017:
                    i6 = 4;
                    break;
                default:
                    switch (i6) {
                        case 20000:
                        case IjkMediaPlayer.FFP_PROP_INT64_SELECTED_VIDEO_STREAM /* 20001 */:
                        case IjkMediaPlayer.FFP_PROP_INT64_SELECTED_AUDIO_STREAM /* 20002 */:
                            i6 = 1;
                            break;
                        case IjkMediaPlayer.FFP_PROP_INT64_VIDEO_DECODER /* 20003 */:
                        default:
                            i6 = 8;
                            break;
                    }
            }
        }
        if (i6 != 0) {
            p("添加围栏失败", i6, "searchErrCode is ".concat(String.valueOf(i6)), new String[0]);
        }
        return i6;
    }

    private int c(List<GeoFence> list) {
        try {
            if (this.f5580h == null) {
                this.f5580h = new ArrayList<>();
            }
            Iterator<GeoFence> it = list.iterator();
            while (it.hasNext()) {
                J(it.next());
            }
            return 0;
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "GeoFenceManager", "addGeoFenceList");
            p("添加围栏失败", 8, th.getMessage(), new String[0]);
            return 8;
        }
    }

    private static boolean y(AMapLocation aMapLocation, GeoFence geoFence) {
        boolean z5 = false;
        try {
            if (j.a(aMapLocation) && geoFence != null && geoFence.getPointList() != null && !geoFence.getPointList().isEmpty()) {
                int type = geoFence.getType();
                if (type != 0) {
                    if (type != 1) {
                        if (type != 2) {
                            if (type != 3) {
                            }
                        }
                    }
                    Iterator<List<DPoint>> it = geoFence.getPointList().iterator();
                    while (it.hasNext()) {
                        if (I(aMapLocation, it.next())) {
                            z5 = true;
                        }
                    }
                    return z5;
                }
                if (z(aMapLocation, geoFence.getCenter(), geoFence.getRadius())) {
                    return true;
                }
            }
            return false;
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "Utils", "isInGeoFence");
            return false;
        }
    }

    final void P(Bundle bundle) {
        E(2, bundle);
    }

    final void S(Bundle bundle) {
        E(1, bundle);
    }

    final void U(Bundle bundle) {
        E(3, bundle);
    }

    final void V() {
        try {
            D(7);
            D(8);
            AMapLocationClient aMapLocationClient = this.f5591s;
            if (aMapLocationClient != null) {
                aMapLocationClient.stopLocation();
            }
            this.f5586n = false;
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "GeoFenceManager", "doPauseGeoFence");
        }
    }

    public final void g() {
        try {
            this.f5588p = false;
            j(10, null, 0L);
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "GeoFenceManager", "removeGeoFence");
        }
    }

    final void k(Bundle bundle) {
        int i6 = 1;
        if (bundle != null) {
            try {
                i6 = bundle.getInt("activatesAction", 1);
            } catch (Throwable th) {
                com.autonavi.aps.amapapi.utils.b.a(th, "GeoFenceManager", "doSetActivatesAction");
                return;
            }
        }
        if (this.f5579g != i6) {
            ArrayList<GeoFence> arrayList = this.f5580h;
            if (arrayList != null && !arrayList.isEmpty()) {
                Iterator<GeoFence> it = this.f5580h.iterator();
                while (it.hasNext()) {
                    GeoFence next = it.next();
                    next.setStatus(0);
                    next.setEnterTime(-1L);
                }
            }
            g0();
        }
        this.f5579g = i6;
    }

    public final boolean w(GeoFence geoFence) {
        try {
            ArrayList<GeoFence> arrayList = this.f5580h;
            if (arrayList != null && !arrayList.isEmpty()) {
                if (!this.f5580h.contains(geoFence)) {
                    return false;
                }
                if (this.f5580h.size() == 1) {
                    this.f5588p = false;
                }
                Bundle bundle = new Bundle();
                bundle.putParcelable("fc", geoFence);
                j(11, bundle, 0L);
                return true;
            }
            this.f5588p = false;
            j(10, null, 0L);
            return true;
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "GeoFenceManager", "removeGeoFence(GeoFence)");
            return false;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class c extends HandlerThread {
        public c(String str) {
            super(str);
        }

        @Override // android.os.HandlerThread, java.lang.Thread, java.lang.Runnable
        public final void run() {
            try {
                super.run();
            } catch (Throwable unused) {
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class d extends Handler {
        public d(Looper looper) {
            super(looper);
        }

        public d() {
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            try {
                Bundle data = message.getData();
                switch (message.what) {
                    case 1000:
                        a.this.Z(data);
                        return;
                    case 1001:
                        try {
                            a.this.G((GeoFence) data.getParcelable("geoFence"));
                            return;
                        } catch (Throwable th) {
                            th.printStackTrace();
                            return;
                        }
                    case 1002:
                        try {
                            a.this.L(data.getInt(GeoFence.BUNDLE_KEY_LOCERRORCODE));
                            return;
                        } catch (Throwable th2) {
                            th2.printStackTrace();
                            return;
                        }
                    default:
                        return;
                }
            } catch (Throwable unused) {
            }
        }
    }

    private static DPoint B(List<DPoint> list) {
        DPoint dPoint = new DPoint();
        if (list != null) {
            try {
                double d6 = 0.0d;
                double d7 = 0.0d;
                for (DPoint dPoint2 : list) {
                    d6 += dPoint2.getLatitude();
                    d7 += dPoint2.getLongitude();
                }
                return new DPoint(j.b(d6 / list.size()), j.b(d7 / list.size()));
            } catch (Throwable th) {
                com.autonavi.aps.amapapi.utils.b.a(th, "GeoFenceUtil", "getPolygonCenter");
            }
        }
        return dPoint;
    }

    private void E(int i6, Bundle bundle) {
        int i7;
        int i8;
        int i9;
        int i10;
        String b6;
        Bundle bundle2 = new Bundle();
        try {
            ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
            if (bundle == null || bundle.isEmpty()) {
                i8 = 1;
            } else {
                List<GeoFence> arrayList2 = new ArrayList<>();
                String string = bundle.getString(GeoFence.BUNDLE_KEY_CUSTOMID);
                String string2 = bundle.getString("keyWords");
                String string3 = bundle.getString(DistrictSearchQuery.KEYWORDS_CITY);
                String string4 = bundle.getString("poiType");
                DPoint dPoint = (DPoint) bundle.getParcelable("centerPoint");
                int i11 = bundle.getInt("searchSize", 10);
                float f6 = bundle.getFloat("aroundRadius", 3000.0f);
                if (v(i6, string2, string4, dPoint)) {
                    Bundle bundle3 = new Bundle();
                    bundle3.putString(GeoFence.BUNDLE_KEY_CUSTOMID, string);
                    bundle3.putString("pendingIntentAction", this.f5576d);
                    bundle3.putLong("expiration", -1L);
                    bundle3.putInt("activatesAction", this.f5579g);
                    if (i6 == 1) {
                        i9 = 3;
                        i10 = 2;
                        bundle3.putFloat("fenceRadius", 1000.0f);
                        b6 = this.f5589q.b(this.f5574b, "http://restsdk.amap.com/v3/place/text?", string2, string4, string3, String.valueOf(i11));
                    } else if (i6 != 2) {
                        b6 = i6 != 3 ? null : this.f5589q.a(this.f5574b, "http://restsdk.amap.com/v3/config/district?", string2);
                        i9 = 3;
                        i10 = 2;
                    } else {
                        double b7 = j.b(dPoint.getLatitude());
                        double b8 = j.b(dPoint.getLongitude());
                        int intValue = Float.valueOf(f6).intValue();
                        bundle3.putFloat("fenceRadius", 200.0f);
                        e0 e0Var = this.f5589q;
                        Context context = this.f5574b;
                        String valueOf = String.valueOf(i11);
                        String valueOf2 = String.valueOf(b7);
                        String valueOf3 = String.valueOf(b8);
                        String valueOf4 = String.valueOf(intValue);
                        i9 = 3;
                        i10 = 2;
                        b6 = e0Var.c(context, "http://restsdk.amap.com/v3/place/around?", string2, string4, valueOf, valueOf2, valueOf3, valueOf4);
                    }
                    if (b6 != null) {
                        int b9 = 1 == i6 ? e1.b(b6, arrayList2, bundle3) : 0;
                        if (i10 == i6) {
                            b9 = e1.e(b6, arrayList2, bundle3);
                        }
                        if (i9 == i6) {
                            b9 = this.f5590r.f(b6, arrayList2, bundle3);
                        }
                        if (b9 != 10000) {
                            i7 = N(b9);
                        } else if (arrayList2.isEmpty()) {
                            i7 = 16;
                        } else {
                            i7 = c(arrayList2);
                            if (i7 == 0) {
                                try {
                                    arrayList.addAll(arrayList2);
                                } catch (Throwable th) {
                                    th = th;
                                    try {
                                        com.autonavi.aps.amapapi.utils.b.a(th, "GeoFenceManager", "doAddGeoFenceNearby");
                                        bundle2.putInt("errorCode", 8);
                                        i(1000, bundle2);
                                    } catch (Throwable th2) {
                                        bundle2.putInt("errorCode", i7);
                                        i(1000, bundle2);
                                        throw th2;
                                    }
                                }
                            }
                        }
                    } else {
                        i7 = 4;
                    }
                } else {
                    i7 = 1;
                }
                bundle2.putString(GeoFence.BUNDLE_KEY_CUSTOMID, string);
                bundle2.putParcelableArrayList("resultList", arrayList);
                i8 = i7;
            }
            bundle2.putInt("errorCode", i8);
        } catch (Throwable th3) {
            th = th3;
            i7 = 0;
        }
        i(1000, bundle2);
    }

    private void Q(GeoFence geoFence) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("geoFence", geoFence);
        i(1001, bundle);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:40:0x002d -> B:12:0x0032). Please report as a decompilation issue!!! */
    private void b0() {
        if (!this.f5588p) {
            this.f5588p = true;
        }
        if (this.f5587o) {
            return;
        }
        try {
            if (Looper.myLooper() == null) {
                this.f5581i = new d(this.f5574b.getMainLooper());
            } else {
                this.f5581i = new d();
            }
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "GeoFenceManger", "init 1");
        }
        try {
            c cVar = new c("fenceActionThread");
            this.f5585m = cVar;
            cVar.setPriority(5);
            this.f5585m.start();
            this.f5584l = new b(this.f5585m.getLooper());
        } catch (Throwable th2) {
            com.autonavi.aps.amapapi.utils.b.a(th2, "GeoFenceManger", "init 2");
        }
        try {
            this.f5589q = new e0(this.f5574b);
            this.f5590r = new e1();
            this.f5594v = new AMapLocationClientOption();
            AMapLocationClient aMapLocationClient = new AMapLocationClient(this.f5574b);
            this.f5591s = aMapLocationClient;
            aMapLocationClient.setLocationListener(this.f5596x);
            if (this.f5573a == null) {
                this.f5573a = new h();
            }
        } catch (Throwable th3) {
            com.autonavi.aps.amapapi.utils.b.a(th3, "GeoFenceManger", "initBase");
        }
        this.f5587o = true;
        try {
            String str = this.f5576d;
            if (str != null && this.f5575c == null) {
                d(str);
            }
        } catch (Throwable th4) {
            com.autonavi.aps.amapapi.utils.b.a(th4, "GeoFenceManger", "init 4");
        }
        if (A) {
            return;
        }
        A = true;
        h.a(this.f5574b, "O020", (JSONObject) null);
    }

    private boolean d0() {
        ArrayList<GeoFence> arrayList = this.f5580h;
        if (arrayList != null && !arrayList.isEmpty()) {
            Iterator<GeoFence> it = this.f5580h.iterator();
            while (it.hasNext()) {
                if (it.next().isAble()) {
                    return false;
                }
            }
        }
        return true;
    }

    private static Bundle e(GeoFence geoFence, String str, String str2, int i6, int i7) {
        Bundle bundle = new Bundle();
        if (str == null) {
            str = "";
        }
        bundle.putString(GeoFence.BUNDLE_KEY_FENCEID, str);
        bundle.putString(GeoFence.BUNDLE_KEY_CUSTOMID, str2);
        bundle.putInt("event", i6);
        bundle.putInt(GeoFence.BUNDLE_KEY_LOCERRORCODE, i7);
        bundle.putParcelable(GeoFence.BUNDLE_KEY_FENCE, geoFence);
        return bundle;
    }

    private void e0() {
        try {
            synchronized (this.f5583k) {
                try {
                    d dVar = this.f5581i;
                    if (dVar != null) {
                        dVar.removeCallbacksAndMessages(null);
                    }
                    this.f5581i = null;
                } catch (Throwable th) {
                    throw th;
                }
            }
        } catch (Throwable th2) {
            com.autonavi.aps.amapapi.utils.b.a(th2, "GeoFenceManager", "destroyResultHandler");
        }
    }

    private GeoFence f(Bundle bundle, boolean z5) {
        GeoFence geoFence = new GeoFence();
        ArrayList arrayList = new ArrayList();
        DPoint dPoint = new DPoint();
        if (z5) {
            geoFence.setType(1);
            arrayList = bundle.getParcelableArrayList("pointList");
            if (arrayList != null) {
                dPoint = B(arrayList);
            }
            geoFence.setMaxDis2Center(A(dPoint, arrayList));
            geoFence.setMinDis2Center(b(dPoint, arrayList));
        } else {
            geoFence.setType(0);
            dPoint = (DPoint) bundle.getParcelable("centerPoint");
            if (dPoint != null) {
                arrayList.add(dPoint);
            }
            float f6 = bundle.getFloat("fenceRadius", 1000.0f);
            float f7 = f6 > 0.0f ? f6 : 1000.0f;
            geoFence.setRadius(f7);
            geoFence.setMinDis2Center(f7);
            geoFence.setMaxDis2Center(f7);
        }
        geoFence.setActivatesAction(this.f5579g);
        geoFence.setCustomId(bundle.getString(GeoFence.BUNDLE_KEY_CUSTOMID));
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(arrayList);
        geoFence.setPointList(arrayList2);
        geoFence.setCenter(dPoint);
        geoFence.setPendingIntentAction(this.f5576d);
        geoFence.setExpiration(-1L);
        geoFence.setPendingIntent(this.f5575c);
        StringBuilder sb = new StringBuilder();
        sb.append(e1.c());
        geoFence.setFenceId(sb.toString());
        h hVar = this.f5573a;
        if (hVar != null) {
            hVar.a(this.f5574b, 2);
        }
        return geoFence;
    }

    private void f0() {
        try {
            synchronized (this.f5582j) {
                try {
                    b bVar = this.f5584l;
                    if (bVar != null) {
                        bVar.removeCallbacksAndMessages(null);
                    }
                    this.f5584l = null;
                } catch (Throwable th) {
                    throw th;
                }
            }
        } catch (Throwable th2) {
            com.autonavi.aps.amapapi.utils.b.a(th2, "GeoFenceManager", "destroyActionHandler");
        }
    }

    private void g0() {
        if (this.f5598z || this.f5584l == null) {
            return;
        }
        if (i0()) {
            j(6, null, 0L);
            j(5, null, 0L);
        } else {
            D(7);
            j(7, null, 0L);
        }
    }

    private void h0() {
        try {
            if (this.f5586n) {
                D(8);
            }
            AMapLocationClient aMapLocationClient = this.f5591s;
            if (aMapLocationClient != null) {
                aMapLocationClient.stopLocation();
            }
            this.f5586n = false;
        } catch (Throwable unused) {
        }
    }

    private boolean i0() {
        return this.f5592t != null && j.a(this.f5592t) && j.b() - this.f5593u < 10000;
    }

    static void p(String str, int i6, String str2, String... strArr) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("===========================================\n");
        stringBuffer.append("              " + str + "                ");
        stringBuffer.append(e.f37542d);
        stringBuffer.append("-------------------------------------------\n");
        stringBuffer.append("errorCode:".concat(String.valueOf(i6)));
        stringBuffer.append(e.f37542d);
        stringBuffer.append("错误信息:".concat(String.valueOf(str2)));
        stringBuffer.append(e.f37542d);
        if (strArr.length > 0) {
            for (String str3 : strArr) {
                stringBuffer.append(str3);
                stringBuffer.append(e.f37542d);
            }
        }
        stringBuffer.append("===========================================\n");
    }

    private static boolean x(GeoFence geoFence, int i6) {
        boolean z5 = false;
        if ((i6 & 1) == 1) {
            try {
                if (geoFence.getStatus() == 1) {
                    z5 = true;
                }
            } catch (Throwable th) {
                com.autonavi.aps.amapapi.utils.b.a(th, "Utils", "remindStatus");
            }
        }
        if ((i6 & 2) == 2 && geoFence.getStatus() == 2) {
            z5 = true;
        }
        if ((i6 & 4) == 4) {
            if (geoFence.getStatus() == 3) {
                return true;
            }
        }
        return z5;
    }

    public final List<GeoFence> C() {
        try {
            if (this.f5580h == null) {
                this.f5580h = new ArrayList<>();
            }
            return (ArrayList) this.f5580h.clone();
        } catch (Throwable unused) {
            return new ArrayList();
        }
    }

    final void D(int i6) {
        try {
            synchronized (this.f5582j) {
                try {
                    b bVar = this.f5584l;
                    if (bVar != null) {
                        bVar.removeMessages(i6);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        } catch (Throwable th2) {
            com.autonavi.aps.amapapi.utils.b.a(th2, "GeoFenceManager", "removeActionHandlerMessage");
        }
    }

    final void F(Bundle bundle) {
        String str;
        try {
            ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
            String str2 = "";
            int i6 = 1;
            if (bundle != null && !bundle.isEmpty()) {
                DPoint dPoint = (DPoint) bundle.getParcelable("centerPoint");
                str = bundle.getString(GeoFence.BUNDLE_KEY_CUSTOMID);
                if (dPoint != null) {
                    if (dPoint.getLatitude() <= 90.0d && dPoint.getLatitude() >= -90.0d && dPoint.getLongitude() <= 180.0d && dPoint.getLongitude() >= -180.0d) {
                        GeoFence f6 = f(bundle, false);
                        i6 = J(f6);
                        if (i6 == 0) {
                            arrayList.add(f6);
                        }
                        Bundle bundle2 = new Bundle();
                        bundle2.putInt("errorCode", i6);
                        bundle2.putParcelableArrayList("resultList", arrayList);
                        bundle2.putString(GeoFence.BUNDLE_KEY_CUSTOMID, str);
                        i(1000, bundle2);
                    }
                    p("添加围栏失败", 1, "经纬度错误，传入的纬度：" + dPoint.getLatitude() + "传入的经度:" + dPoint.getLongitude(), new String[0]);
                    Bundle bundle22 = new Bundle();
                    bundle22.putInt("errorCode", i6);
                    bundle22.putParcelableArrayList("resultList", arrayList);
                    bundle22.putString(GeoFence.BUNDLE_KEY_CUSTOMID, str);
                    i(1000, bundle22);
                }
                str2 = str;
            }
            str = str2;
            Bundle bundle222 = new Bundle();
            bundle222.putInt("errorCode", i6);
            bundle222.putParcelableArrayList("resultList", arrayList);
            bundle222.putString(GeoFence.BUNDLE_KEY_CUSTOMID, str);
            i(1000, bundle222);
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "GeoFenceManager", "doAddGeoFenceRound");
        }
    }

    final void G(GeoFence geoFence) {
        try {
            synchronized (this.f5578f) {
                try {
                    if (this.f5574b != null) {
                        if (this.f5575c == null && geoFence.getPendingIntent() == null) {
                            return;
                        }
                        Intent intent = new Intent();
                        intent.putExtras(e(geoFence, geoFence.getFenceId(), geoFence.getCustomId(), geoFence.getStatus(), 0));
                        String str = this.f5576d;
                        if (str != null) {
                            intent.setAction(str);
                        }
                        intent.setPackage(f4.g(this.f5574b));
                        if (geoFence.getPendingIntent() != null) {
                            geoFence.getPendingIntent().send(this.f5574b, 0, intent);
                        } else {
                            this.f5575c.send(this.f5574b, 0, intent);
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        } catch (Throwable th2) {
            com.autonavi.aps.amapapi.utils.b.a(th2, "GeoFenceManager", "resultTriggerGeoFence");
        }
    }

    final void K() {
        if (this.f5587o) {
            ArrayList<GeoFence> arrayList = this.f5580h;
            if (arrayList != null) {
                arrayList.clear();
                this.f5580h = null;
            }
            if (this.f5588p) {
                return;
            }
            f0();
            AMapLocationClient aMapLocationClient = this.f5591s;
            if (aMapLocationClient != null) {
                aMapLocationClient.stopLocation();
                this.f5591s.onDestroy();
            }
            this.f5591s = null;
            c cVar = this.f5585m;
            if (cVar != null) {
                cVar.quitSafely();
            }
            this.f5585m = null;
            this.f5589q = null;
            synchronized (this.f5578f) {
                try {
                    PendingIntent pendingIntent = this.f5575c;
                    if (pendingIntent != null) {
                        pendingIntent.cancel();
                    }
                    this.f5575c = null;
                } finally {
                }
            }
            e0();
            h hVar = this.f5573a;
            if (hVar != null) {
                hVar.b(this.f5574b);
            }
            this.f5586n = false;
            this.f5587o = false;
        }
    }

    final void L(int i6) {
        try {
            if (this.f5574b != null) {
                synchronized (this.f5578f) {
                    try {
                        if (this.f5575c == null) {
                            return;
                        }
                        Intent intent = new Intent();
                        intent.putExtras(e(null, null, null, 4, i6));
                        this.f5575c.send(this.f5574b, 0, intent);
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        } catch (Throwable th2) {
            com.autonavi.aps.amapapi.utils.b.a(th2, "GeoFenceManager", "resultRemindLocationError");
        }
    }

    final void M(Bundle bundle) {
        GeoFence f6;
        try {
            ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
            String str = "";
            int i6 = 1;
            if (bundle != null && !bundle.isEmpty()) {
                ArrayList parcelableArrayList = bundle.getParcelableArrayList("pointList");
                String string = bundle.getString(GeoFence.BUNDLE_KEY_CUSTOMID);
                if (parcelableArrayList != null && parcelableArrayList.size() > 2 && (i6 = J((f6 = f(bundle, true)))) == 0) {
                    arrayList.add(f6);
                }
                str = string;
            }
            Bundle bundle2 = new Bundle();
            bundle2.putString(GeoFence.BUNDLE_KEY_CUSTOMID, str);
            bundle2.putInt("errorCode", i6);
            bundle2.putParcelableArrayList("resultList", arrayList);
            i(1000, bundle2);
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "GeoFenceManager", "doAddGeoFencePolygon");
        }
    }

    final void O() {
        try {
            if (this.f5591s != null) {
                h0();
                this.f5594v.setLocationCacheEnable(true);
                this.f5594v.setNeedAddress(false);
                this.f5594v.setOnceLocation(true);
                this.f5591s.setLocationOption(this.f5594v);
                this.f5591s.startLocation();
            }
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "GeoFenceManager", "doStartOnceLocation");
        }
    }

    final void R() {
        try {
            if (!this.f5598z && j.a(this.f5592t)) {
                float a6 = a(this.f5592t, this.f5580h);
                if (a6 == Float.MAX_VALUE) {
                    return;
                }
                if (a6 < 1000.0f) {
                    D(7);
                    Bundle bundle = new Bundle();
                    bundle.putLong(bi.aX, 2000L);
                    j(8, bundle, 500L);
                    return;
                }
                if (a6 < 5000.0f) {
                    h0();
                    D(7);
                    j(7, null, 10000L);
                } else {
                    h0();
                    D(7);
                    j(7, null, (long) (((a6 - 4000.0f) / 100.0f) * 1000.0f));
                }
            }
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "GeoFenceManager", "doCheckLocationPolicy");
        }
    }

    final void W(Bundle bundle) {
        if (bundle != null) {
            try {
                if (bundle.isEmpty()) {
                    return;
                }
                String string = bundle.getString("fid");
                if (TextUtils.isEmpty(string)) {
                    return;
                }
                boolean z5 = bundle.getBoolean("ab", true);
                ArrayList<GeoFence> arrayList = this.f5580h;
                if (arrayList != null && !arrayList.isEmpty()) {
                    Iterator<GeoFence> it = this.f5580h.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        GeoFence next = it.next();
                        if (next.getFenceId().equals(string)) {
                            next.setAble(z5);
                            break;
                        }
                    }
                }
                if (z5) {
                    g0();
                } else if (d0()) {
                    V();
                }
            } catch (Throwable th) {
                com.autonavi.aps.amapapi.utils.b.a(th, "GeoFenceManager", "doSetGeoFenceAble");
            }
        }
    }

    final void Y(Bundle bundle) {
        try {
            if (this.f5580h != null) {
                GeoFence geoFence = (GeoFence) bundle.getParcelable("fc");
                if (this.f5580h.contains(geoFence)) {
                    this.f5580h.remove(geoFence);
                }
                if (this.f5580h.size() <= 0) {
                    K();
                } else {
                    g0();
                }
            }
        } catch (Throwable unused) {
        }
    }

    final void Z(Bundle bundle) {
        if (bundle != null) {
            try {
                if (bundle.isEmpty()) {
                    return;
                }
                int i6 = bundle.getInt("errorCode");
                ArrayList parcelableArrayList = bundle.getParcelableArrayList("resultList");
                if (parcelableArrayList == null) {
                    parcelableArrayList = new ArrayList();
                }
                String string = bundle.getString(GeoFence.BUNDLE_KEY_CUSTOMID);
                if (string == null) {
                    string = "";
                }
                GeoFenceListener geoFenceListener = this.f5577e;
                if (geoFenceListener != null) {
                    geoFenceListener.onGeoFenceCreateFinished((ArrayList) parcelableArrayList.clone(), i6, string);
                }
                if (i6 == 0) {
                    g0();
                }
            } catch (Throwable th) {
                com.autonavi.aps.amapapi.utils.b.a(th, "GeoFenceManager", "resultAddGeoFenceFinished");
            }
        }
    }

    public final boolean a0() {
        return this.f5598z;
    }

    final void c0(Bundle bundle) {
        try {
            if (this.f5591s != null) {
                long j6 = 2000;
                if (bundle != null && !bundle.isEmpty()) {
                    j6 = bundle.getLong(bi.aX, 2000L);
                }
                this.f5594v.setOnceLocation(false);
                this.f5594v.setInterval(j6);
                this.f5594v.setLocationCacheEnable(true);
                this.f5594v.setNeedAddress(false);
                this.f5591s.setLocationOption(this.f5594v);
                if (this.f5586n) {
                    return;
                }
                this.f5591s.stopLocation();
                this.f5591s.startLocation();
                this.f5586n = true;
            }
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "GeoFenceManager", "doStartContinueLocation");
        }
    }

    public final PendingIntent d(String str) {
        synchronized (this.f5578f) {
            try {
                Intent intent = new Intent(str);
                intent.setPackage(f4.g(this.f5574b));
                if (Build.VERSION.SDK_INT < 31 || this.f5574b.getApplicationInfo().targetSdkVersion < 31) {
                    this.f5575c = PendingIntent.getBroadcast(this.f5574b, 0, intent, 0);
                } else {
                    this.f5575c = PendingIntent.getBroadcast(this.f5574b, 0, intent, CommonNetImpl.FLAG_SHARE_JUMP);
                }
                this.f5576d = str;
                ArrayList<GeoFence> arrayList = this.f5580h;
                if (arrayList != null && !arrayList.isEmpty()) {
                    Iterator<GeoFence> it = this.f5580h.iterator();
                    while (it.hasNext()) {
                        GeoFence next = it.next();
                        next.setPendingIntent(this.f5575c);
                        next.setPendingIntentAction(this.f5576d);
                    }
                }
            } finally {
                return this.f5575c;
            }
        }
        return this.f5575c;
    }

    final void i(int i6, Bundle bundle) {
        try {
            synchronized (this.f5583k) {
                try {
                    d dVar = this.f5581i;
                    if (dVar != null) {
                        Message obtainMessage = dVar.obtainMessage();
                        obtainMessage.what = i6;
                        obtainMessage.setData(bundle);
                        this.f5581i.sendMessage(obtainMessage);
                    }
                } finally {
                }
            }
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "GeoFenceManager", "sendResultHandlerMessage");
        }
    }

    final void j(int i6, Bundle bundle, long j6) {
        try {
            synchronized (this.f5582j) {
                try {
                    b bVar = this.f5584l;
                    if (bVar != null) {
                        Message obtainMessage = bVar.obtainMessage();
                        obtainMessage.what = i6;
                        obtainMessage.setData(bundle);
                        this.f5584l.sendMessageDelayed(obtainMessage, j6);
                    }
                } finally {
                }
            }
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "GeoFenceManager", "sendActionHandlerMessage");
        }
    }

    public final void l(GeoFenceListener geoFenceListener) {
        try {
            this.f5577e = geoFenceListener;
        } catch (Throwable unused) {
        }
    }

    final void m(AMapLocation aMapLocation) {
        ArrayList<GeoFence> arrayList;
        try {
            if (this.f5598z || (arrayList = this.f5580h) == null || arrayList.isEmpty() || aMapLocation == null || aMapLocation.getErrorCode() != 0) {
                return;
            }
            Iterator<GeoFence> it = this.f5580h.iterator();
            while (it.hasNext()) {
                GeoFence next = it.next();
                if (next.isAble() && H(aMapLocation, next) && x(next, this.f5579g)) {
                    next.setCurrentLocation(aMapLocation);
                    Q(next);
                }
            }
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "GeoFenceManager", "doCheckFence");
        }
    }

    public a(Context context) {
        this.f5574b = null;
        try {
            this.f5574b = StubApp.getOrigApplicationContext(context.getApplicationContext());
            b0();
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "GeoFenceManger", "<init>");
        }
    }

    private static boolean I(AMapLocation aMapLocation, List<DPoint> list) {
        if (list.size() < 3) {
            return false;
        }
        return com.autonavi.aps.amapapi.utils.b.a(new DPoint(aMapLocation.getLatitude(), aMapLocation.getLongitude()), list);
    }

    private static float a(AMapLocation aMapLocation, List<GeoFence> list) {
        float f6 = Float.MAX_VALUE;
        if (aMapLocation != null && aMapLocation.getErrorCode() == 0 && list != null && !list.isEmpty()) {
            DPoint dPoint = new DPoint(aMapLocation.getLatitude(), aMapLocation.getLongitude());
            for (GeoFence geoFence : list) {
                if (geoFence.isAble()) {
                    float a6 = j.a(dPoint, geoFence.getCenter());
                    if (a6 > geoFence.getMinDis2Center() && a6 < geoFence.getMaxDis2Center()) {
                        return 0.0f;
                    }
                    if (a6 > geoFence.getMaxDis2Center()) {
                        f6 = Math.min(f6, a6 - geoFence.getMaxDis2Center());
                    }
                    if (a6 < geoFence.getMinDis2Center()) {
                        f6 = Math.min(f6, geoFence.getMinDis2Center() - a6);
                    }
                }
            }
        }
        return f6;
    }

    static float b(DPoint dPoint, List<DPoint> list) {
        float f6 = Float.MAX_VALUE;
        if (dPoint != null && list != null && !list.isEmpty()) {
            Iterator<DPoint> it = list.iterator();
            while (it.hasNext()) {
                f6 = Math.min(f6, j.a(dPoint, it.next()));
            }
        }
        return f6;
    }

    private static boolean v(int i6, String str, String str2, DPoint dPoint) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (i6 != 1) {
            if (i6 == 2) {
                if (dPoint == null) {
                    return false;
                }
                if (dPoint.getLatitude() > 90.0d || dPoint.getLatitude() < -90.0d || dPoint.getLongitude() > 180.0d || dPoint.getLongitude() < -180.0d) {
                    p("添加围栏失败", 0, "经纬度错误，传入的纬度：" + dPoint.getLatitude() + "传入的经度:" + dPoint.getLongitude(), new String[0]);
                    return false;
                }
            }
        } else if (TextUtils.isEmpty(str2)) {
            return false;
        }
        return true;
    }

    private static boolean z(AMapLocation aMapLocation, DPoint dPoint, float f6) {
        if (j.a(new double[]{dPoint.getLatitude(), dPoint.getLongitude(), aMapLocation.getLatitude(), aMapLocation.getLongitude()}) > f6) {
            return false;
        }
        return true;
    }

    public final void T() {
        try {
            b0();
            this.f5598z = true;
            j(13, null, 0L);
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "GeoFenceManager", "pauseGeoFence");
        }
    }

    public final void X() {
        try {
            b0();
            if (this.f5598z) {
                this.f5598z = false;
                g0();
            }
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "GeoFenceManager", "resumeGeoFence");
        }
    }

    public final void h(int i6) {
        try {
            b0();
            if (i6 > 7 || i6 <= 0) {
                i6 = 1;
            }
            Bundle bundle = new Bundle();
            bundle.putInt("activatesAction", i6);
            j(9, bundle, 0L);
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "GeoFenceManager", "setActivateAction");
        }
    }

    public final void n(AMapLocationClientOption aMapLocationClientOption) {
        try {
            this.f5594v = aMapLocationClientOption.m46clone();
        } catch (Throwable unused) {
        }
    }

    public final void o(DPoint dPoint, float f6, String str) {
        try {
            b0();
            Bundle bundle = new Bundle();
            bundle.putParcelable("centerPoint", dPoint);
            bundle.putFloat("fenceRadius", f6);
            bundle.putString(GeoFence.BUNDLE_KEY_CUSTOMID, str);
            j(0, bundle, 0L);
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "GeoFenceManager", "addRoundGeoFence");
        }
    }

    public final void q(String str, String str2) {
        try {
            b0();
            Bundle bundle = new Bundle();
            bundle.putString("keyWords", str);
            bundle.putString(GeoFence.BUNDLE_KEY_CUSTOMID, str2);
            j(4, bundle, 0L);
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "GeoFenceManager", "addDistricetGeoFence");
        }
    }

    public final void r(String str, String str2, DPoint dPoint, float f6, int i6, String str3) {
        try {
            b0();
            if (f6 <= 0.0f || f6 > 50000.0f) {
                f6 = 3000.0f;
            }
            if (i6 <= 0) {
                i6 = 10;
            }
            if (i6 > 25) {
                i6 = 25;
            }
            Bundle bundle = new Bundle();
            bundle.putString("keyWords", str);
            bundle.putString("poiType", str2);
            bundle.putParcelable("centerPoint", dPoint);
            bundle.putFloat("aroundRadius", f6);
            bundle.putInt("searchSize", i6);
            bundle.putString(GeoFence.BUNDLE_KEY_CUSTOMID, str3);
            j(3, bundle, 0L);
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "GeoFenceManager", "addNearbyGeoFence");
        }
    }

    public final void s(String str, String str2, String str3, int i6, String str4) {
        try {
            b0();
            if (i6 <= 0) {
                i6 = 10;
            }
            if (i6 > 25) {
                i6 = 25;
            }
            Bundle bundle = new Bundle();
            bundle.putString("keyWords", str);
            bundle.putString("poiType", str2);
            bundle.putString(DistrictSearchQuery.KEYWORDS_CITY, str3);
            bundle.putInt("searchSize", i6);
            bundle.putString(GeoFence.BUNDLE_KEY_CUSTOMID, str4);
            j(2, bundle, 0L);
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "GeoFenceManager", "addKeywordGeoFence");
        }
    }

    public final void t(String str, boolean z5) {
        try {
            b0();
            Bundle bundle = new Bundle();
            bundle.putString("fid", str);
            bundle.putBoolean("ab", z5);
            j(12, bundle, 0L);
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "GeoFenceManager", "setGeoFenceAble");
        }
    }

    public final void u(List<DPoint> list, String str) {
        try {
            b0();
            Bundle bundle = new Bundle();
            bundle.putParcelableArrayList("pointList", new ArrayList<>(list));
            bundle.putString(GeoFence.BUNDLE_KEY_CUSTOMID, str);
            j(1, bundle, 0L);
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "GeoFenceManager", "addPolygonGeoFence");
        }
    }
}
