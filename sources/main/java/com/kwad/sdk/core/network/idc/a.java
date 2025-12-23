package com.kwad.sdk.core.network.idc;

import android.content.Context;
import android.net.Uri;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import cn.jpush.android.local.JPushConstants;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.core.network.d;
import com.kwad.sdk.export.proxy.AdHttpProxy;
import com.kwad.sdk.g;
import com.kwad.sdk.utils.ao;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.h;
import com.stub.StubApp;
import java.net.URLDecoder;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class a {
    private static final int aFx;
    private final Map<String, String> aFs;
    private final com.kwad.sdk.core.network.idc.a.b aFt;
    private final Random aFu;
    private final Map<String, AtomicBoolean> aFv;
    private final Map<String, com.kwad.sdk.core.network.idc.a.a> aFw;
    private volatile int aFy;
    private volatile boolean aFz;
    private Context mContext;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.kwad.sdk.core.network.idc.a$a, reason: collision with other inner class name */
    static final class C0689a {
        private static final a aFC = new a(0);
    }

    /* synthetic */ a(byte b6) {
        this();
    }

    static {
        aFx = com.kwad.framework.a.a.oz.booleanValue() ? 0 : 60000;
    }

    private a() {
        this.aFs = new ConcurrentHashMap(8);
        this.aFt = new com.kwad.sdk.core.network.idc.a.b();
        this.aFu = new Random(System.currentTimeMillis());
        HashMap hashMap = new HashMap();
        this.aFv = hashMap;
        this.aFw = new ConcurrentHashMap(4);
        this.aFy = 0;
        this.aFz = false;
        hashMap.put("api", new AtomicBoolean(false));
        hashMap.put("ulog", new AtomicBoolean(false));
        hashMap.put("zt", new AtomicBoolean(false));
        hashMap.put("cdn", new AtomicBoolean(false));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    public void HG() {
        com.kwad.sdk.core.network.idc.a.b bA = b.bA(this.mContext);
        if (bA.isEmpty()) {
            bA = b.bz(this.mContext);
        }
        this.aFt.a(bA);
    }

    @WorkerThread
    private void V(@NonNull String str, String str2) {
        String host;
        StringBuilder sb;
        List<String> eg = this.aFt.eg(str2);
        if (eg.isEmpty() || (host = Uri.parse(str).getHost()) == null || host.isEmpty()) {
            return;
        }
        c.d("IdcManager", ">>> switchHost start, try get lock, type = " + str2 + ", old host = " + host);
        AtomicBoolean atomicBoolean = this.aFv.get(str2);
        if (atomicBoolean.compareAndSet(false, true)) {
            try {
                String ee = ee(str2);
                if (TextUtils.isEmpty(ee) || host.equals(ee)) {
                    int size = eg.size();
                    int indexOf = eg.indexOf(host);
                    boolean z5 = indexOf >= 0;
                    if (z5) {
                        size--;
                    }
                    if (size <= 0) {
                        atomicBoolean.set(false);
                        sb = new StringBuilder("<<< switchHost end, type = ");
                    } else {
                        int nextInt = this.aFu.nextInt(size) + 1;
                        if (z5) {
                            nextInt += indexOf;
                        }
                        int size2 = nextInt % eg.size();
                        String str3 = eg.get(size2);
                        c.d("IdcManager", "switchHost success, type = " + str2 + ", old host = " + host + ",new host = " + str3 + ",hostList = " + eg + ", key = " + size2);
                        X(str2, str3);
                        if (p(str2, size2)) {
                            eb(str2);
                        }
                        atomicBoolean.set(false);
                        sb = new StringBuilder("<<< switchHost end, type = ");
                    }
                } else {
                    atomicBoolean.set(false);
                    sb = new StringBuilder("<<< switchHost end, type = ");
                }
                sb.append(str2);
                sb.append(", old host = ");
                sb.append(host);
                c.d("IdcManager", sb.toString());
            } catch (Throwable th) {
                atomicBoolean.set(false);
                c.d("IdcManager", "<<< switchHost end, type = " + str2 + ", old host = " + host);
                throw th;
            }
        }
    }

    private void X(String str, String str2) {
        c.d("IdcManager", "updateCurrentIdc: hostType = " + str + ",new host = " + str2);
        this.aFs.put(str, str2);
        h.execute(new bg() { // from class: com.kwad.sdk.core.network.idc.a.3
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                b.a(a.this.mContext, (Map<String, String>) a.this.aFs);
            }
        });
    }

    @WorkerThread
    private static boolean c(final String str, Context context) {
        boolean isNetworkConnected = ao.isNetworkConnected(context);
        c.d("IdcManager", "connect host = " + str + ",isNetworkConnected = " + isNetworkConnected);
        if (isNetworkConnected && str != null) {
            AdHttpProxy AI = g.AI();
            d dVar = new d() { // from class: com.kwad.sdk.core.network.idc.a.4
                @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.f
                public final String getUrl() {
                    return com.kwad.sdk.h.ce(JPushConstants.HTTPS_PRE + str);
                }

                @Override // com.kwad.sdk.core.network.d, com.kwad.sdk.core.network.b
                public final void buildBaseBody() {
                }

                @Override // com.kwad.sdk.core.network.d, com.kwad.sdk.core.network.b
                public final void buildBaseHeader() {
                }
            };
            com.kwad.sdk.core.network.c doGet = AI.doGet(dVar.getUrl(), Collections.EMPTY_MAP);
            c.d("IdcManager", "perform connect host:" + dVar.getUrl());
            if (doGet != null) {
                c.d("IdcManager", "connect host response, rawCode = " + doGet.aEi + ",body = " + doGet.aEk);
                if (doGet.aEi == 200) {
                    return true;
                }
            }
        }
        return false;
    }

    private String ee(String str) {
        return this.aFs.get(str);
    }

    private boolean p(String str, int i6) {
        return "api".equals(str) && i6 > 0 && !this.aFw.containsKey(str) && this.aFy > 0;
    }

    public final boolean HH() {
        return !this.aFw.isEmpty();
    }

    @Nullable
    public final String W(String str, String str2) {
        String str3 = this.aFs.get(str);
        return TextUtils.isEmpty(str3) ? str2 : str3;
    }

    public final void ec(String str) {
        int i6 = this.aFy;
        if (this.aFz || i6 <= 0) {
            c.d("IdcManager", "performHostRollback is invalid, by in prepare = " + this.aFz + ",rollbackInterval = " + i6);
            return;
        }
        com.kwad.sdk.core.network.idc.a.a aVar = this.aFw.get(str);
        if (aVar != null) {
            long elapsedRealtime = SystemClock.elapsedRealtime() - aVar.HK();
            boolean z5 = elapsedRealtime > ((long) Math.max(i6, aFx));
            c.d("IdcManager", "handleHostRollback: isAvailable = " + z5 + ",interval = " + elapsedRealtime + ",rollbackInterval = " + i6 + ",hostType = hostType");
            if (z5) {
                AtomicBoolean atomicBoolean = this.aFv.get(str);
                try {
                    if (atomicBoolean.compareAndSet(false, true)) {
                        try {
                            boolean HJ = aVar.HJ();
                            c.d("IdcManager", "handleHostRollback: isInRollback = " + HJ);
                            if (!HJ) {
                                aVar.bq(true);
                                if (ed(str)) {
                                    this.aFw.remove(str);
                                    c.d("IdcManager", "handleHostRollback success,remove switched host, type = " + str);
                                } else {
                                    c.d("IdcManager", "rollbackToMainHost failed, reset attempt time.");
                                    eb(str);
                                }
                            }
                            atomicBoolean.set(false);
                            c.d("IdcManager", "handleHostRollback end, release lock.host = " + str);
                        } catch (Exception e6) {
                            c.e("IdcManager", "handleHostRollback failed by " + e6.getMessage());
                            atomicBoolean.set(false);
                            c.d("IdcManager", "handleHostRollback end, release lock.host = " + str);
                        }
                    }
                } catch (Throwable th) {
                    atomicBoolean.set(false);
                    c.d("IdcManager", "handleHostRollback end, release lock.host = " + str);
                    throw th;
                }
            }
        }
    }

    public final String ef(String str) {
        return Y(str, "cdn");
    }

    public final void h(String str, Throwable th) {
        a(str, "cdn", new DomainException(th));
    }

    public static a HF() {
        return C0689a.aFC;
    }

    static /* synthetic */ boolean a(a aVar, boolean z5) {
        aVar.aFz = false;
        return false;
    }

    private void eb(String str) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        c.d("IdcManager", "save switched host, type = " + str);
        this.aFw.put(str, new com.kwad.sdk.core.network.idc.a.a(elapsedRealtime, false));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    public boolean ed(String str) {
        boolean hc;
        String str2;
        String ee = ee(str);
        List<String> eg = this.aFt.eg(str);
        if (eg.isEmpty()) {
            return false;
        }
        String str3 = eg.get(0);
        if (TextUtils.equals(str3, ee)) {
            return true;
        }
        if ("api".equals(str)) {
            if (com.kwad.framework.a.a.oz.booleanValue()) {
                str2 = "beta2-ad-open-api.test.gifshow.com";
            } else {
                str2 = str3;
            }
            hc = c(str2, this.mContext);
        } else {
            hc = ao.hc(str3);
        }
        c.d("IdcManager", "perform ping action for " + str + ",mainHost = " + str3 + ",isSuccess = " + hc);
        if (hc) {
            X(str, str3);
        }
        return hc;
    }

    public final String Y(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String ee = ee(str2);
        if (ee != null && !ee.isEmpty()) {
            Uri parse = Uri.parse(str);
            if (!TextUtils.isEmpty(parse.getPath()) && !ee.equals(parse.getHost())) {
                Uri.Builder builder = new Uri.Builder();
                builder.authority(ee);
                if (TextUtils.isEmpty(parse.getScheme())) {
                    builder.scheme(master.flame.danmaku.danmaku.parser.b.f50155b);
                } else {
                    builder.scheme(parse.getScheme());
                }
                builder.path(parse.getPath());
                if (!TextUtils.isEmpty(parse.getQuery())) {
                    builder.query(parse.getQuery());
                }
                return URLDecoder.decode(builder.build().toString());
            }
            return str;
        }
        return str;
    }

    public final void init(final Context context) {
        this.mContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
        this.aFz = true;
        h.execute(new bg() { // from class: com.kwad.sdk.core.network.idc.a.1
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                a.this.aFs.putAll(b.bB(context));
                a.this.HG();
                if (!a.this.aFt.isEmpty()) {
                    Iterator<String> it = a.this.aFt.HM().iterator();
                    while (it.hasNext()) {
                        a.this.ed(it.next());
                    }
                }
                c.d("IdcManager", "idc prepare done.");
                a.a(a.this, false);
            }
        });
    }

    public final void a(com.kwad.sdk.core.network.idc.a.b bVar, int i6) {
        this.aFy = i6 * 1000;
        c.d("IdcManager", "updateIdcData,rollback interval = " + i6);
        if (i6 == 0) {
            this.aFw.clear();
        }
        this.aFt.a(bVar);
        h.execute(new bg() { // from class: com.kwad.sdk.core.network.idc.a.2
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                b.a(a.this.mContext, a.this.aFt);
            }
        });
    }

    public final void a(String str, int i6, Throwable th) {
        a(str, "ulog", new DomainException(i6, th));
    }

    public final void a(String str, String str2, DomainException domainException) {
        if (str != null && a(domainException)) {
            V(str, str2);
        }
    }

    private static boolean a(DomainException domainException) {
        if (domainException.getHttpCode() >= 500) {
            return true;
        }
        return domainException.isConnectException();
    }
}
