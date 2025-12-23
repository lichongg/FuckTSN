package com.autonavi.aps.amapapi;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.wifi.WifiInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import androidx.core.view.MotionEventCompat;
import com.amap.api.col.p0003l.a8;
import com.amap.api.col.p0003l.b8;
import com.amap.api.col.p0003l.c7;
import com.amap.api.col.p0003l.d7;
import com.amap.api.col.p0003l.f4;
import com.amap.api.col.p0003l.g9;
import com.amap.api.col.p0003l.h6;
import com.amap.api.col.p0003l.i4;
import com.amap.api.col.p0003l.j4;
import com.amap.api.col.p0003l.j7;
import com.amap.api.col.p0003l.j8;
import com.amap.api.col.p0003l.k9;
import com.amap.api.col.p0003l.ko;
import com.amap.api.col.p0003l.l8;
import com.amap.api.col.p0003l.l9;
import com.amap.api.col.p0003l.o6;
import com.amap.api.col.p0003l.p9;
import com.amap.api.col.p0003l.q4;
import com.amap.api.col.p0003l.r6;
import com.amap.api.col.p0003l.r9;
import com.amap.api.col.p0003l.s5;
import com.amap.api.col.p0003l.s9;
import com.amap.api.col.p0003l.u7;
import com.amap.api.col.p0003l.v5;
import com.amap.api.col.p0003l.w7;
import com.amap.api.col.p0003l.z6;
import com.autonavi.aps.amapapi.restruct.e;
import com.autonavi.aps.amapapi.restruct.h;
import com.autonavi.aps.amapapi.restruct.k;
import com.autonavi.aps.amapapi.utils.j;
import com.kuaishou.weapon.p0.t;
import com.umeng.socialize.common.SocializeConstants;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.crypto.KeyGenerator;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class c implements s9 {

    /* renamed from: k, reason: collision with root package name */
    private static long f9945k;

    /* renamed from: a, reason: collision with root package name */
    Context f9946a;

    /* renamed from: d, reason: collision with root package name */
    g9 f9949d;

    /* renamed from: e, reason: collision with root package name */
    c7 f9950e;

    /* renamed from: g, reason: collision with root package name */
    private Handler f9952g;

    /* renamed from: h, reason: collision with root package name */
    private LocationManager f9953h;

    /* renamed from: i, reason: collision with root package name */
    private a f9954i;

    /* renamed from: f, reason: collision with root package name */
    private ArrayList<l8> f9951f = new ArrayList<>();

    /* renamed from: b, reason: collision with root package name */
    k f9947b = null;

    /* renamed from: c, reason: collision with root package name */
    e f9948c = null;

    /* renamed from: j, reason: collision with root package name */
    private volatile boolean f9955j = false;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class a implements LocationListener {

        /* renamed from: a, reason: collision with root package name */
        private c f9957a;

        final void a(c cVar) {
            this.f9957a = cVar;
        }

        final void a() {
            this.f9957a = null;
        }

        @Override // android.location.LocationListener
        public final void onLocationChanged(Location location) {
            try {
                c cVar = this.f9957a;
                if (cVar != null) {
                    cVar.a(location);
                }
            } catch (Throwable unused) {
            }
        }

        a(c cVar) {
            this.f9957a = cVar;
        }

        @Override // android.location.LocationListener
        public final void onProviderDisabled(String str) {
        }

        @Override // android.location.LocationListener
        public final void onProviderEnabled(String str) {
        }

        @Override // android.location.LocationListener
        public final void onStatusChanged(String str, int i6, Bundle bundle) {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b extends b8 {

        /* renamed from: b, reason: collision with root package name */
        private int f9959b;

        /* renamed from: c, reason: collision with root package name */
        private Location f9960c;

        b(int i6) {
            this.f9959b = i6;
        }

        @Override // com.amap.api.col.p0003l.b8
        public final void runTask() {
            int i6 = this.f9959b;
            if (i6 == 1) {
                a();
            } else if (i6 == 2) {
                b();
            } else if (i6 == 3) {
                c.this.g();
            }
        }

        b(c cVar, Location location) {
            this(1);
            this.f9960c = location;
        }

        private void a() {
            int i6;
            try {
                com.autonavi.aps.amapapi.utils.d.a();
                if (this.f9960c != null && c.this.f9955j) {
                    if (j.m(c.this.f9946a)) {
                        com.autonavi.aps.amapapi.utils.d.a();
                        return;
                    }
                    Bundle extras = this.f9960c.getExtras();
                    if (extras != null) {
                        i6 = extras.getInt("satellites");
                    } else {
                        i6 = 0;
                    }
                    if (!j.a(this.f9960c, i6)) {
                        k kVar = c.this.f9947b;
                        if (kVar != null && !kVar.f10116s) {
                            kVar.f();
                        }
                        ArrayList<l9> a6 = c.this.f9947b.a();
                        List<ko> a7 = c.this.f9948c.a();
                        j8.a aVar = new j8.a();
                        k9 k9Var = new k9();
                        k9Var.f6661i = this.f9960c.getAccuracy();
                        k9Var.f6658f = this.f9960c.getAltitude();
                        k9Var.f6656d = this.f9960c.getLatitude();
                        k9Var.f6660h = this.f9960c.getBearing();
                        k9Var.f6657e = this.f9960c.getLongitude();
                        k9Var.f6662j = this.f9960c.isFromMockProvider();
                        k9Var.f6653a = this.f9960c.getProvider();
                        k9Var.f6659g = this.f9960c.getSpeed();
                        k9Var.f6698l = (byte) i6;
                        k9Var.f6654b = System.currentTimeMillis();
                        k9Var.f6655c = this.f9960c.getTime();
                        k9Var.f6697k = this.f9960c.getTime();
                        aVar.f6643a = k9Var;
                        aVar.f6644b = a6;
                        WifiInfo c6 = c.this.f9947b.c();
                        if (c6 != null) {
                            aVar.f6645c = l9.a(h.a(c6));
                        }
                        aVar.f6646d = k.f10102z;
                        aVar.f6648f = this.f9960c.getTime();
                        aVar.f6649g = (byte) i4.K(c.this.f9946a);
                        aVar.f6650h = i4.V(c.this.f9946a);
                        aVar.f6647e = c.this.f9947b.k();
                        aVar.f6652j = j.a(c.this.f9946a);
                        aVar.f6651i = a7;
                        l8 a8 = g9.a(aVar);
                        if (a8 != null) {
                            synchronized (c.this.f9951f) {
                                try {
                                    c.this.f9951f.add(a8);
                                    if (c.this.f9951f.size() >= 5) {
                                        c.this.e();
                                    }
                                } finally {
                                }
                            }
                            c.this.d();
                        }
                    }
                }
            } catch (Throwable th) {
                com.autonavi.aps.amapapi.utils.b.a(th, "cl", "coll");
            }
        }

        private void b() {
            com.autonavi.aps.amapapi.utils.d.a();
            if (j.m(c.this.f9946a)) {
                com.autonavi.aps.amapapi.utils.d.a();
                return;
            }
            o6 o6Var = null;
            try {
                long unused = c.f9945k = System.currentTimeMillis();
                if (c.this.f9950e.f5854f.e()) {
                    o6Var = o6.b(new File(c.this.f9950e.f5849a), c.this.f9950e.f5850b);
                    ArrayList arrayList = new ArrayList();
                    byte[] f6 = c.f();
                    if (f6 != null) {
                        List b6 = c.b(o6Var, c.this.f9950e, arrayList, f6);
                        if (b6 != null && b6.size() != 0) {
                            c.this.f9950e.f5854f.c(true);
                            if (g9.f(q4.t(g9.h(com.autonavi.aps.amapapi.security.a.a(f6), j4.h(f6, g9.g(), q4.v()), b6)))) {
                                c.b(o6Var, arrayList);
                            }
                        }
                        try {
                            o6Var.close();
                            return;
                        } catch (Throwable unused2) {
                            return;
                        }
                    }
                    try {
                        o6Var.close();
                        return;
                    } catch (Throwable unused3) {
                        return;
                    }
                }
                if (o6Var != null) {
                    try {
                        o6Var.close();
                    } catch (Throwable unused4) {
                    }
                }
            } catch (Throwable th) {
                try {
                    v5.p(th, "leg", "uts");
                    if (o6Var != null) {
                        try {
                            o6Var.close();
                        } catch (Throwable unused5) {
                        }
                    }
                } catch (Throwable th2) {
                    if (o6Var != null) {
                        try {
                            o6Var.close();
                        } catch (Throwable unused6) {
                        }
                    }
                    throw th2;
                }
            }
        }
    }

    static /* synthetic */ byte[] f() {
        return a(128);
    }

    public final void b() {
        try {
            com.autonavi.aps.amapapi.utils.d.a();
            Handler handler = this.f9952g;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.autonavi.aps.amapapi.c.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        k kVar;
                        try {
                            c cVar = c.this;
                            if (cVar.f9949d == null || (kVar = cVar.f9947b) == null) {
                                return;
                            }
                            g9.k(kVar.a());
                        } catch (Throwable th) {
                            com.autonavi.aps.amapapi.utils.b.a(th, "cl", "upwr");
                        }
                    }
                });
            }
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "cl", "upw");
        }
    }

    public final void c() {
        e eVar;
        try {
            com.autonavi.aps.amapapi.utils.d.a();
            if (this.f9949d == null || (eVar = this.f9948c) == null) {
                return;
            }
            g9.e(eVar.a());
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "cl", "upc");
        }
    }

    public final void d() {
        try {
            if (j.m(this.f9946a)) {
                com.autonavi.aps.amapapi.utils.d.a();
            } else {
                if (System.currentTimeMillis() - f9945k < 60000) {
                    return;
                }
                a8.h().b(new b(2));
            }
        } catch (Throwable unused) {
        }
    }

    c(Context context) {
        this.f9946a = null;
        this.f9946a = context;
        c7 c7Var = new c7();
        this.f9950e = c7Var;
        j7.f(this.f9946a, c7Var, s5.f7241k, 100, 1024000, "0");
        c7 c7Var2 = this.f9950e;
        int i6 = com.autonavi.aps.amapapi.utils.a.f10213g;
        boolean z5 = com.autonavi.aps.amapapi.utils.a.f10211e;
        int i7 = com.autonavi.aps.amapapi.utils.a.f10212f;
        c7Var2.f5854f = new w7(context, i6, "kKey", new u7(context, z5, i7, i7 * 10, "carrierLocKey"));
        this.f9950e.f5853e = new h6();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        try {
            com.autonavi.aps.amapapi.utils.d.a();
            if (j.m(this.f9946a)) {
                com.autonavi.aps.amapapi.utils.d.a();
                return;
            }
            ArrayList<l8> arrayList = this.f9951f;
            if (arrayList != null && arrayList.size() != 0) {
                ArrayList arrayList2 = new ArrayList();
                synchronized (this.f9951f) {
                    arrayList2.addAll(this.f9951f);
                    this.f9951f.clear();
                }
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                byte[] a6 = a(256);
                if (a6 != null) {
                    byteArrayOutputStream.write(c(a6.length));
                    byteArrayOutputStream.write(a6);
                    Iterator it = arrayList2.iterator();
                    while (it.hasNext()) {
                        l8 l8Var = (l8) it.next();
                        byte[] b6 = l8Var.b();
                        if (b6.length >= 10 && b6.length <= 65535) {
                            byte[] h6 = j4.h(a6, b6, q4.v());
                            byteArrayOutputStream.write(c(h6.length));
                            byteArrayOutputStream.write(h6);
                            byteArrayOutputStream.write(b(l8Var.a()));
                        }
                    }
                    d7.c(Long.toString(System.currentTimeMillis()), byteArrayOutputStream.toByteArray(), this.f9950e);
                }
            }
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "clm", "wtD");
        }
    }

    public final void e() {
        try {
            a8.h().b(new b(3));
        } catch (Throwable unused) {
        }
    }

    final void a() {
        LocationManager locationManager;
        if (j.m(this.f9946a)) {
            com.autonavi.aps.amapapi.utils.d.a();
            return;
        }
        try {
            a aVar = this.f9954i;
            if (aVar != null && (locationManager = this.f9953h) != null) {
                locationManager.removeUpdates(aVar);
            }
            a aVar2 = this.f9954i;
            if (aVar2 != null) {
                aVar2.a();
            }
            if (this.f9955j) {
                g();
                this.f9947b.a((c) null);
                this.f9948c.a((c) null);
                this.f9948c = null;
                this.f9947b = null;
                this.f9952g = null;
                this.f9955j = false;
            }
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "clm", "stc");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(o6 o6Var, List<String> list) {
        if (o6Var != null) {
            try {
                Iterator<String> it = list.iterator();
                while (it.hasNext()) {
                    o6Var.q(it.next());
                }
                o6Var.close();
            } catch (Throwable th) {
                v5.p(th, t.f36155p, "dlo");
            }
        }
    }

    private static byte[] c(int i6) {
        return new byte[]{(byte) ((i6 & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8), (byte) (i6 & 255)};
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(6:14|(3:15|16|17)|(2:18|19)|(0)(3:29|30|(1:(2:33|34))(3:37|38|(10:42|(7:45|46|47|48|49|50|43)|68|69|70|71|72|73|74|(6:76|77|56|57|59|24)(0))(0)))|25|26) */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x003a, code lost:
    
        if (r9 != null) goto L109;
     */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0104 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00f8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.List<com.amap.api.col.p0003l.l8> b(com.amap.api.col.p0003l.o6 r17, com.amap.api.col.p0003l.c7 r18, java.util.List<java.lang.String> r19, byte[] r20) {
        /*
            Method dump skipped, instructions count: 278
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.aps.amapapi.c.b(com.amap.api.col.3l.o6, com.amap.api.col.3l.c7, java.util.List, byte[]):java.util.List");
    }

    public final void a(e eVar, k kVar, Handler handler) {
        Throwable th;
        LocationManager locationManager;
        com.autonavi.aps.amapapi.utils.d.a();
        if (!this.f9955j && eVar != null && kVar != null && handler != null) {
            if (j.m(this.f9946a)) {
                com.autonavi.aps.amapapi.utils.d.a();
                return;
            }
            this.f9955j = true;
            this.f9948c = eVar;
            this.f9947b = kVar;
            kVar.a(this);
            this.f9948c.a(this);
            this.f9952g = handler;
            try {
                if (this.f9953h == null) {
                    try {
                        this.f9953h = (LocationManager) this.f9946a.getSystemService(SocializeConstants.KEY_LOCATION);
                    } catch (Throwable th2) {
                        th = th2;
                        com.autonavi.aps.amapapi.utils.b.a(th, "col", "init");
                    }
                }
                if (this.f9954i == null) {
                    this.f9954i = new a(this);
                }
                this.f9954i.a(this);
                a aVar = this.f9954i;
                if (aVar != null && (locationManager = this.f9953h) != null) {
                    locationManager.requestLocationUpdates("passive", 1000L, -1.0f, aVar);
                }
                if (this.f9949d == null) {
                    try {
                        g9 g9Var = new g9("6.4.3", f4.j(this.f9946a), "S128DF1572465B890OE3F7A13167KLEI", f4.g(this.f9946a), this);
                        this.f9949d = g9Var;
                        g9Var.d(i4.P()).i(i4.F(this.f9946a)).l(i4.o(this.f9946a)).m(i4.D(this.f9946a)).n(i4.U()).o(i4.E()).p(Build.MODEL).q(Build.MANUFACTURER).r(Build.BRAND).b(Build.VERSION.SDK_INT).s(Build.VERSION.RELEASE).c(l9.a(i4.I())).t(i4.I());
                        g9.j();
                    } catch (Throwable th3) {
                        th = th3;
                        th = th;
                        com.autonavi.aps.amapapi.utils.b.a(th, "col", "init");
                    }
                }
            } catch (Throwable th4) {
                th = th4;
            }
        }
    }

    private static byte[] b(int i6) {
        return new byte[]{(byte) ((i6 >> 24) & 255), (byte) ((i6 >> 16) & 255), (byte) ((i6 >> 8) & 255), (byte) (i6 & 255)};
    }

    public final void a(Location location) {
        try {
            Handler handler = this.f9952g;
            if (handler != null) {
                handler.post(new b(this, location));
            }
        } catch (Throwable th) {
            v5.p(th, "cl", "olcc");
        }
    }

    @Override // com.amap.api.col.p0003l.s9
    public final r9 a(p9 p9Var) {
        try {
            com.autonavi.aps.amapapi.trans.b bVar = new com.autonavi.aps.amapapi.trans.b();
            bVar.a(p9Var.f6925b);
            bVar.a(p9Var.f6924a);
            bVar.a(p9Var.f6927d);
            r6.b();
            z6 d6 = r6.d(bVar);
            r9 r9Var = new r9();
            r9Var.f7191c = d6.f7800a;
            r9Var.f7190b = d6.f7801b;
            r9Var.f7189a = 200;
            return r9Var;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static byte[] a(int i6) {
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
            if (keyGenerator == null) {
                return null;
            }
            keyGenerator.init(i6);
            return keyGenerator.generateKey().getEncoded();
        } catch (Throwable unused) {
            return null;
        }
    }

    private static int a(byte[] bArr) {
        return ((bArr[0] & 255) << 24) | (bArr[3] & 255) | ((bArr[2] & 255) << 8) | ((bArr[1] & 255) << 16);
    }
}
