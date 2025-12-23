package com.amap.api.col.p0003l;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Process;
import android.text.TextUtils;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.autonavi.aps.amapapi.utils.d;
import com.autonavi.aps.amapapi.utils.f;
import com.autonavi.aps.amapapi.utils.h;
import com.autonavi.aps.amapapi.utils.j;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class e3 {
    static boolean A;

    /* renamed from: l, reason: collision with root package name */
    Context f5976l;

    /* renamed from: s, reason: collision with root package name */
    private List<Messenger> f5983s;

    /* renamed from: a, reason: collision with root package name */
    private boolean f5965a = false;

    /* renamed from: b, reason: collision with root package name */
    private boolean f5966b = false;

    /* renamed from: c, reason: collision with root package name */
    String f5967c = null;

    /* renamed from: d, reason: collision with root package name */
    b f5968d = null;

    /* renamed from: e, reason: collision with root package name */
    private long f5969e = 0;

    /* renamed from: f, reason: collision with root package name */
    private long f5970f = 0;

    /* renamed from: g, reason: collision with root package name */
    private com.autonavi.aps.amapapi.model.a f5971g = null;

    /* renamed from: h, reason: collision with root package name */
    AMapLocation f5972h = null;

    /* renamed from: i, reason: collision with root package name */
    private long f5973i = 0;

    /* renamed from: j, reason: collision with root package name */
    private int f5974j = 0;

    /* renamed from: k, reason: collision with root package name */
    a f5975k = null;

    /* renamed from: m, reason: collision with root package name */
    private t7 f5977m = null;

    /* renamed from: n, reason: collision with root package name */
    com.autonavi.aps.amapapi.b f5978n = null;

    /* renamed from: o, reason: collision with root package name */
    HashMap<Messenger, Long> f5979o = new HashMap<>();

    /* renamed from: p, reason: collision with root package name */
    h f5980p = null;

    /* renamed from: q, reason: collision with root package name */
    long f5981q = 0;

    /* renamed from: r, reason: collision with root package name */
    long f5982r = 0;

    /* renamed from: t, reason: collision with root package name */
    private long f5984t = 0;

    /* renamed from: u, reason: collision with root package name */
    private HashMap<String, Boolean> f5985u = new HashMap<>();

    /* renamed from: v, reason: collision with root package name */
    String f5986v = null;

    /* renamed from: w, reason: collision with root package name */
    private boolean f5987w = true;

    /* renamed from: x, reason: collision with root package name */
    private String f5988x = "";

    /* renamed from: y, reason: collision with root package name */
    AMapLocationClientOption f5989y = null;

    /* renamed from: z, reason: collision with root package name */
    AMapLocationClientOption f5990z = new AMapLocationClientOption();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class a extends Handler {
        /* JADX WARN: Removed duplicated region for block: B:55:0x0151 A[Catch: all -> 0x0083, TryCatch #0 {all -> 0x0083, blocks: (B:7:0x0058, B:13:0x0067, B:15:0x006d, B:17:0x0088, B:19:0x008e, B:20:0x00a4, B:21:0x00b2, B:23:0x00b6, B:25:0x00be, B:27:0x00ca, B:28:0x00d3, B:30:0x00db, B:32:0x00e7, B:33:0x00ef, B:35:0x00f3, B:37:0x00fb, B:39:0x0107, B:41:0x011c, B:42:0x0122, B:43:0x0128, B:44:0x012e, B:45:0x013b, B:46:0x015b, B:54:0x0146, B:55:0x0151, B:69:0x0051), top: B:68:0x0051 }] */
        /* JADX WARN: Removed duplicated region for block: B:9:0x005c  */
        @Override // android.os.Handler
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void handleMessage(android.os.Message r9) {
            /*
                Method dump skipped, instructions count: 382
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.3l.e3.a.handleMessage(android.os.Message):void");
        }

        public a(Looper looper) {
            super(looper);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b extends HandlerThread {
        public b(String str) {
            super(str);
        }

        @Override // android.os.HandlerThread
        protected final void onLooperPrepared() {
            try {
                try {
                    e3.this.f5977m = new t7(e3.this.f5976l);
                } catch (Throwable th) {
                    com.autonavi.aps.amapapi.utils.b.a(th, "APSManager$ActionThread", "init 2");
                }
                try {
                    com.autonavi.aps.amapapi.utils.a.b(e3.this.f5976l);
                    com.autonavi.aps.amapapi.utils.a.a(e3.this.f5976l);
                } catch (Throwable th2) {
                    com.autonavi.aps.amapapi.utils.b.a(th2, "APSManager$ActionThread", "init 3");
                }
                e3.this.f5978n = new com.autonavi.aps.amapapi.b(false);
                super.onLooperPrepared();
            } catch (Throwable th3) {
                com.autonavi.aps.amapapi.utils.b.a(th3, "APSManager$ActionThread", "onLooperPrepared");
            }
        }

        @Override // android.os.HandlerThread, java.lang.Thread, java.lang.Runnable
        public final void run() {
            try {
                super.run();
            } catch (Throwable th) {
                com.autonavi.aps.amapapi.utils.b.a(th, "APSManager$ActionThread", "run");
            }
        }
    }

    public static void E() {
        A = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F() {
        if (j.m(this.f5976l)) {
            d.a();
            return;
        }
        try {
            com.autonavi.aps.amapapi.b bVar = this.f5978n;
            if (bVar == null || bVar == null) {
                return;
            }
            bVar.a(this.f5975k);
            this.f5978n.g();
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "ApsServiceCore", "startColl");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G() {
        try {
            com.autonavi.aps.amapapi.utils.a.c(this.f5976l);
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "ApsServiceCore", "doCallOtherSer");
        }
    }

    private static com.autonavi.aps.amapapi.model.a b(int i6, String str) {
        try {
            com.autonavi.aps.amapapi.model.a aVar = new com.autonavi.aps.amapapi.model.a("");
            aVar.setErrorCode(i6);
            aVar.setLocationDetail(str);
            return aVar;
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "ApsServiceCore", "newInstanceAMapLoc");
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(Bundle bundle) {
        try {
            if (this.f5965a) {
                com.autonavi.aps.amapapi.b bVar = this.f5978n;
                if (bVar != null) {
                    bVar.a();
                    return;
                }
                return;
            }
            com.autonavi.aps.amapapi.utils.b.a(this.f5976l);
            if (bundle != null) {
                this.f5990z = com.autonavi.aps.amapapi.utils.b.a(bundle.getBundle("optBundle"));
            }
            this.f5978n.a(this.f5976l);
            this.f5978n.b();
            q(this.f5990z);
            this.f5978n.c();
            this.f5965a = true;
            this.f5987w = true;
            this.f5988x = "";
            List<Messenger> list = this.f5983s;
            if (list == null || list.size() <= 0) {
                return;
            }
            F();
        } catch (Throwable th) {
            this.f5987w = false;
            th.printStackTrace();
            this.f5988x = th.getMessage();
            com.autonavi.aps.amapapi.utils.b.a(th, "ApsServiceCore", "init");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(Messenger messenger) {
        this.f5979o.remove(messenger);
    }

    private static void g(Messenger messenger, int i6, Bundle bundle) {
        if (messenger != null) {
            try {
                Message obtain = Message.obtain();
                obtain.setData(bundle);
                obtain.what = i6;
                messenger.send(obtain);
            } catch (Throwable th) {
                com.autonavi.aps.amapapi.utils.b.a(th, "ApsServiceCore", "sendMessage");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(Messenger messenger, Bundle bundle) {
        if (bundle != null) {
            try {
                if (!bundle.isEmpty() && !this.f5966b) {
                    this.f5966b = true;
                    x(messenger);
                }
            } catch (Throwable th) {
                com.autonavi.aps.amapapi.utils.b.a(th, "ApsServiceCore", "doInitAuth");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(Messenger messenger, AMapLocation aMapLocation, String str, com.autonavi.aps.amapapi.a aVar) {
        Bundle bundle = new Bundle();
        bundle.setClassLoader(AMapLocation.class.getClassLoader());
        bundle.putParcelable("loc", aMapLocation);
        bundle.putString("nb", str);
        bundle.putParcelable("statics", aVar);
        this.f5979o.put(messenger, Long.valueOf(j.b()));
        g(messenger, 1, bundle);
    }

    private void k(Messenger messenger, String str) {
        Bundle bundle = new Bundle();
        bundle.setClassLoader(AMapLocation.class.getClassLoader());
        bundle.putInt("I_MAX_GEO_DIS", com.autonavi.aps.amapapi.utils.a.i() * 3);
        bundle.putInt("I_MIN_GEO_DIS", com.autonavi.aps.amapapi.utils.a.i());
        bundle.putParcelable("loc", this.f5972h);
        if ("COARSE_LOC".equals(str)) {
            g(messenger, 103, bundle);
        } else {
            g(messenger, 6, bundle);
        }
    }

    private void q(AMapLocationClientOption aMapLocationClientOption) {
        try {
            com.autonavi.aps.amapapi.b bVar = this.f5978n;
            if (bVar != null) {
                bVar.a(aMapLocationClientOption);
            }
            if (aMapLocationClientOption != null) {
                A = aMapLocationClientOption.isKillProcess();
                if (this.f5989y != null) {
                    if (aMapLocationClientOption.isOffset() != this.f5989y.isOffset() || aMapLocationClientOption.isNeedAddress() != this.f5989y.isNeedAddress() || aMapLocationClientOption.isLocationCacheEnable() != this.f5989y.isLocationCacheEnable() || this.f5989y.getGeoLanguage() != aMapLocationClientOption.getGeoLanguage()) {
                        this.f5970f = 0L;
                    }
                    if (aMapLocationClientOption.isOffset() != this.f5989y.isOffset() || this.f5989y.getGeoLanguage() != aMapLocationClientOption.getGeoLanguage()) {
                        this.f5972h = null;
                    }
                }
                this.f5989y = aMapLocationClientOption;
            }
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "ApsServiceCore", "setExtra");
        }
    }

    private static AMapLocationClientOption t(Bundle bundle) {
        AMapLocationClientOption aMapLocationClientOption = null;
        try {
            aMapLocationClientOption = com.autonavi.aps.amapapi.utils.b.a(bundle.getBundle("optBundle"));
            try {
                String string = bundle.getString("d");
                if (!TextUtils.isEmpty(string)) {
                    i4.s(string);
                }
            } catch (Throwable th) {
                com.autonavi.aps.amapapi.utils.b.a(th, "APSManager", "doLocation setUmidToken");
            }
        } catch (Throwable th2) {
            com.autonavi.aps.amapapi.utils.b.a(th2, "APSManager", "parseBundle");
        }
        return aMapLocationClientOption;
    }

    static /* synthetic */ com.autonavi.aps.amapapi.model.a u(String str) {
        return b(10, str);
    }

    private void x(Messenger messenger) {
        try {
            this.f5978n.f();
            if (com.autonavi.aps.amapapi.utils.a.l()) {
                Bundle bundle = new Bundle();
                bundle.putBoolean("installMockApp", true);
                g(messenger, 9, bundle);
            }
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "ApsServiceCore", "initAuth");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(18:27|28|29|30|(14:35|(1:37)(2:62|(1:64))|38|39|(1:41)|42|(1:44)|45|(2:47|48)(1:60)|49|50|(1:54)|56|57)|65|38|39|(0)|42|(0)|45|(0)(0)|49|50|(2:52|54)|56|57) */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0167, code lost:
    
        r13 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0168, code lost:
    
        com.autonavi.aps.amapapi.utils.b.a(r13, "ApsServiceCore", "fixLastLocation");
     */
    /* JADX WARN: Removed duplicated region for block: B:41:0x012c A[Catch: all -> 0x0048, TryCatch #2 {all -> 0x0048, blocks: (B:4:0x0008, B:9:0x0010, B:11:0x0029, B:13:0x002f, B:17:0x004b, B:19:0x0050, B:21:0x007d, B:23:0x008a, B:25:0x0093, B:27:0x00a4, B:39:0x0124, B:41:0x012c, B:42:0x0132, B:44:0x0136, B:45:0x0141, B:47:0x0145, B:56:0x016d, B:59:0x0168, B:69:0x00fe, B:50:0x0154, B:52:0x015a, B:54:0x015e, B:30:0x00ad, B:32:0x00bd, B:35:0x00c7, B:37:0x00cf, B:38:0x00f1, B:62:0x00d9, B:64:0x00e2, B:65:0x00ea), top: B:3:0x0008, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0136 A[Catch: all -> 0x0048, TryCatch #2 {all -> 0x0048, blocks: (B:4:0x0008, B:9:0x0010, B:11:0x0029, B:13:0x002f, B:17:0x004b, B:19:0x0050, B:21:0x007d, B:23:0x008a, B:25:0x0093, B:27:0x00a4, B:39:0x0124, B:41:0x012c, B:42:0x0132, B:44:0x0136, B:45:0x0141, B:47:0x0145, B:56:0x016d, B:59:0x0168, B:69:0x00fe, B:50:0x0154, B:52:0x015a, B:54:0x015e, B:30:0x00ad, B:32:0x00bd, B:35:0x00c7, B:37:0x00cf, B:38:0x00f1, B:62:0x00d9, B:64:0x00e2, B:65:0x00ea), top: B:3:0x0008, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0145 A[Catch: all -> 0x0048, TRY_LEAVE, TryCatch #2 {all -> 0x0048, blocks: (B:4:0x0008, B:9:0x0010, B:11:0x0029, B:13:0x002f, B:17:0x004b, B:19:0x0050, B:21:0x007d, B:23:0x008a, B:25:0x0093, B:27:0x00a4, B:39:0x0124, B:41:0x012c, B:42:0x0132, B:44:0x0136, B:45:0x0141, B:47:0x0145, B:56:0x016d, B:59:0x0168, B:69:0x00fe, B:50:0x0154, B:52:0x015a, B:54:0x015e, B:30:0x00ad, B:32:0x00bd, B:35:0x00c7, B:37:0x00cf, B:38:0x00f1, B:62:0x00d9, B:64:0x00e2, B:65:0x00ea), top: B:3:0x0008, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0153  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void y(android.os.Messenger r12, android.os.Bundle r13) {
        /*
            Method dump skipped, instructions count: 375
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0003l.e3.y(android.os.Messenger, android.os.Bundle):void");
    }

    public final void B() {
        HashMap<String, Boolean> hashMap;
        if (this.f5978n == null || (hashMap = this.f5985u) == null || hashMap.isEmpty()) {
            return;
        }
        Iterator<Boolean> it = this.f5985u.values().iterator();
        while (it.hasNext()) {
            if (it.next().booleanValue()) {
                this.f5978n.a(true);
                return;
            }
        }
        this.f5978n.a(false);
    }

    public final void C() {
        try {
            HashMap<Messenger, Long> hashMap = this.f5979o;
            if (hashMap != null) {
                hashMap.clear();
                this.f5979o = null;
            }
            try {
                List<Messenger> list = this.f5983s;
                if (list != null) {
                    list.clear();
                }
            } catch (Throwable th) {
                com.autonavi.aps.amapapi.utils.b.a(th, "apm", "des1");
            }
            t7 t7Var = this.f5977m;
            if (t7Var != null) {
                t7Var.e();
                this.f5977m = null;
            }
            this.f5965a = false;
            this.f5966b = false;
            this.f5978n.e();
            a aVar = this.f5975k;
            if (aVar != null) {
                aVar.removeCallbacksAndMessages(null);
            }
            this.f5975k = null;
            b bVar = this.f5968d;
            if (bVar != null) {
                try {
                    f.a(bVar, (Class<?>) HandlerThread.class, "quitSafely", new Object[0]);
                } catch (Throwable unused) {
                    this.f5968d.quit();
                }
            }
            this.f5968d = null;
            if (this.f5980p != null && this.f5981q != 0 && this.f5982r != 0) {
                long b6 = j.b() - this.f5981q;
                h.a(this.f5976l, this.f5980p.c(this.f5976l), this.f5980p.d(this.f5976l), this.f5982r, b6);
                this.f5980p.e(this.f5976l);
            }
            HashMap<String, Boolean> hashMap2 = this.f5985u;
            if (hashMap2 != null) {
                hashMap2.clear();
                this.f5985u = null;
            }
            h.a(this.f5976l);
            v5.m();
            if (A) {
                Process.killProcess(Process.myPid());
            }
        } catch (Throwable th2) {
            com.autonavi.aps.amapapi.utils.b.a(th2, "apm", "tdest");
        }
    }

    public final void c() {
        try {
            this.f5980p = new h();
            b bVar = new b("amapLocCoreThread");
            this.f5968d = bVar;
            bVar.setPriority(5);
            this.f5968d.start();
            this.f5975k = new a(this.f5968d.getLooper());
            this.f5983s = new ArrayList();
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "ApsServiceCore", "onCreate");
        }
    }

    public final void d(Intent intent) {
        a aVar;
        if (!"true".equals(intent.getStringExtra(CommonNetImpl.AS)) || (aVar = this.f5975k) == null) {
            return;
        }
        aVar.sendEmptyMessageDelayed(9, 100L);
    }

    final void i(Messenger messenger, Bundle bundle, String str) {
        AMapLocationClientOption t5;
        float f6;
        if (bundle != null) {
            try {
                if (bundle.isEmpty()) {
                    return;
                }
                double d6 = bundle.getDouble(com.umeng.analytics.pro.d.C);
                double d7 = bundle.getDouble("lon");
                float f7 = bundle.getFloat("radius");
                long j6 = bundle.getLong("time");
                if ("FINE_LOC".equals(str)) {
                    AMapLocation aMapLocation = new AMapLocation(GeocodeSearch.GPS);
                    aMapLocation.setLatitude(d6);
                    aMapLocation.setLocationType(1);
                    aMapLocation.setLongitude(d7);
                    aMapLocation.setAccuracy(f7);
                    aMapLocation.setTime(j6);
                    this.f5978n.a(aMapLocation);
                }
                if (com.autonavi.aps.amapapi.utils.a.h() && (t5 = t(bundle)) != null && t5.isNeedAddress()) {
                    q(t5);
                    AMapLocation aMapLocation2 = this.f5972h;
                    if (aMapLocation2 != null) {
                        f6 = j.a(new double[]{d6, d7, aMapLocation2.getLatitude(), this.f5972h.getLongitude()});
                        if (f6 < com.autonavi.aps.amapapi.utils.a.i() * 3) {
                            k(messenger, str);
                        }
                    } else {
                        f6 = -1.0f;
                    }
                    if (f6 == -1.0f || (f6 > com.autonavi.aps.amapapi.utils.a.i() && j.b() - this.f5984t > com.autonavi.aps.amapapi.utils.a.j() * 1000)) {
                        e(bundle);
                        this.f5972h = this.f5978n.a(d6, d7);
                        this.f5984t = j.b();
                        AMapLocation aMapLocation3 = this.f5972h;
                        if (aMapLocation3 == null || TextUtils.isEmpty(aMapLocation3.getAdCode())) {
                            return;
                        }
                        k(messenger, str);
                    }
                }
            } catch (Throwable th) {
                com.autonavi.aps.amapapi.utils.b.a(th, "ApsServiceCore", "doLocationGeo");
            }
        }
    }

    public final boolean r(String str) {
        if (TextUtils.isEmpty(this.f5986v)) {
            this.f5986v = com.autonavi.aps.amapapi.utils.b.b(this.f5976l);
        }
        return !TextUtils.isEmpty(str) && str.equals(this.f5986v);
    }

    public final Handler s() {
        return this.f5975k;
    }

    public final void w(Intent intent) {
        String stringExtra = intent.getStringExtra("a");
        if (!TextUtils.isEmpty(stringExtra)) {
            g4.l(this.f5976l, stringExtra);
        }
        String stringExtra2 = intent.getStringExtra("b");
        this.f5967c = stringExtra2;
        f4.c(stringExtra2);
        String stringExtra3 = intent.getStringExtra("d");
        if (TextUtils.isEmpty(stringExtra3)) {
            return;
        }
        i4.s(stringExtra3);
    }

    public e3(Context context) {
        this.f5976l = null;
        this.f5976l = context;
    }
}
