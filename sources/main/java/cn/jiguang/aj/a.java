package cn.jiguang.aj;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import cn.jiguang.ba.g;
import cn.jiguang.bb.f;
import cn.jiguang.bz.j;
import cn.jiguang.bz.o;
import cn.jiguang.bz.q;
import cn.jiguang.bz.x;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.autonavi.base.amap.mapcore.tools.GLMapStaticValue;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.umeng.analytics.pro.bi;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes2.dex */
public class a extends cn.jiguang.m.a {

    /* renamed from: a, reason: collision with root package name */
    private Context f1518a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f1519b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f1520c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f1521d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f1522e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f1523f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f1524g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f1525h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f1526i;

    /* renamed from: cn.jiguang.aj.a$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* renamed from: cn.jiguang.aj.a$a, reason: collision with other inner class name */
    class CallableC0024a implements Callable<List<cn.jiguang.al.d>> {
        CallableC0024a() {
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public List<cn.jiguang.al.d> call() {
            try {
                cn.jiguang.aj.b bVar = new cn.jiguang.aj.b(a.this.f1518a, a.this.f1520c);
                bVar.c();
                for (int i6 = 0; i6 < 20; i6++) {
                    if (bVar.b()) {
                        return bVar.a();
                    }
                    Thread.sleep(2000L);
                }
            } catch (Throwable th) {
                f.i("JLocation", "JLocationCellInfo call failed:" + th.getMessage());
            }
            cn.jiguang.bw.a.a().d((Object) 2045);
            return null;
        }
    }

    class b implements Callable<cn.jiguang.ak.a> {
        b() {
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public cn.jiguang.ak.a call() {
            try {
                cn.jiguang.aj.c a6 = cn.jiguang.aj.c.a(a.this.f1518a);
                a6.c();
                for (int i6 = 0; i6 < 30; i6++) {
                    if (a6.b()) {
                        return a6.a();
                    }
                    Thread.sleep(1000L);
                }
            } catch (Throwable th) {
                f.i("JLocation", "JLocationGpsInfo call failed:" + th.getMessage());
            }
            cn.jiguang.bw.a.a().b((Object) 2045);
            return null;
        }
    }

    private static final class c {

        /* renamed from: a, reason: collision with root package name */
        private static final a f1529a = new a(null);
    }

    private a() {
        this.f1519b = false;
        this.f1520c = false;
        this.f1521d = false;
        this.f1522e = false;
        this.f1523f = false;
        this.f1524g = false;
        this.f1525h = false;
        this.f1526i = false;
    }

    public int b(boolean z5) {
        int max = Math.max(cn.jiguang.g.a.a().b(1500), 0);
        return z5 ? max + KSImageLoader.InnerImageLoadingListener.MAX_DURATION : max;
    }

    public ArrayList<String> c(Context context, int i6) {
        ArrayList<String> arrayList;
        List<cn.jiguang.ak.b> b6 = b(context, Integer.MAX_VALUE);
        if (b6 != null) {
            arrayList = new ArrayList<>();
            Iterator<cn.jiguang.ak.b> it = b6.iterator();
            while (it.hasNext()) {
                String str = it.next().f1557b;
                if (!TextUtils.isEmpty(str) && !arrayList.contains(str)) {
                    arrayList.add(str);
                    if (arrayList.size() == i6) {
                        break;
                    }
                }
            }
        } else {
            arrayList = null;
        }
        f.c("JLocation", "getWifiNameArray:" + arrayList);
        return arrayList;
    }

    @Override // cn.jiguang.m.a
    protected boolean f(Context context) {
        return true;
    }

    /* synthetic */ a(AnonymousClass1 anonymousClass1) {
        this();
    }

    private Bundle a(long j6, double d6, double d7) {
        Bundle bundle = new Bundle();
        bundle.putLong("time", j6);
        bundle.putDouble("lot", d6);
        bundle.putDouble(com.umeng.analytics.pro.d.C, d7);
        return bundle;
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0079, code lost:
    
        cn.jiguang.bw.a.a().d((java.lang.Object) 2044);
        r7 = new java.util.concurrent.FutureTask(new cn.jiguang.aj.a.CallableC0024a(r6));
        cn.jiguang.be.b.e(r7);
        r7 = (java.util.List) r7.get(20000, java.util.concurrent.TimeUnit.MILLISECONDS);
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x009d, code lost:
    
        if (r7 == null) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x00be, code lost:
    
        r0 = 2042;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00c0, code lost:
    
        cn.jiguang.bw.a.a().d(java.lang.Integer.valueOf(r0));
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00cb, code lost:
    
        return r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00ba, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00bb, code lost:
    
        r2 = r7;
        r7 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00df, code lost:
    
        cn.jiguang.bw.a.a().d((java.lang.Object) 2043);
        cn.jiguang.bb.f.i("JLocation", "collect cell throwable:" + r7.getMessage());
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0104, code lost:
    
        return r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x009f, code lost:
    
        cn.jiguang.bb.f.c("JLocation", "collect cell success:" + r7.toString());
        r0 = com.autonavi.base.amap.mapcore.tools.GLMapStaticValue.AM_PARAMETERNAME_SETCOLORBLINDSTATUS;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.util.List<cn.jiguang.al.d> h(android.content.Context r7) {
        /*
            Method dump skipped, instructions count: 261
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.aj.a.h(android.content.Context):java.util.List");
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x00ae, code lost:
    
        if (cn.jiguang.aj.c.a(r9).e() == false) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x00b0, code lost:
    
        cn.jiguang.bw.a.a().b((java.lang.Object) 2044);
        r3 = cn.jiguang.aj.c.a(r9).d();
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00c5, code lost:
    
        if (r3 != null) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00c7, code lost:
    
        r1 = new java.util.concurrent.FutureTask(new cn.jiguang.aj.a.b(r8));
        cn.jiguang.be.b.e(r1);
        r1 = (cn.jiguang.ak.a) r1.get(31000, java.util.concurrent.TimeUnit.MILLISECONDS);
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00de, code lost:
    
        if (r1 == null) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00e0, code lost:
    
        cn.jiguang.bb.f.c("JLocation", "collect gps success:" + r1.toString());
        r3 = cn.jiguang.bw.a.a();
        r4 = java.lang.Integer.valueOf(com.autonavi.base.amap.mapcore.tools.GLMapStaticValue.AM_PARAMETERNAME_SETCOLORBLINDSTATUS);
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0102, code lost:
    
        r3.b(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x011a, code lost:
    
        r3 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0141, code lost:
    
        if (r3 == null) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0143, code lost:
    
        cn.jiguang.m.b.r(r9, r3.f1549a + "," + r3.f1552d + "," + r3.f1551c);
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0164, code lost:
    
        return r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x010a, code lost:
    
        cn.jiguang.bb.f.c("JLocation", "collect gps failed");
        r3 = cn.jiguang.bw.a.a();
        r4 = 2042;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0106, code lost:
    
        r9 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0107, code lost:
    
        r3 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0184, code lost:
    
        cn.jiguang.bw.a.a().b((java.lang.Object) 2043);
        cn.jiguang.bb.f.i("JLocation", "collect gps throwable:" + r9.getMessage());
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x01a9, code lost:
    
        return r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x011c, code lost:
    
        cn.jiguang.bw.a.a().b((java.lang.Object) 2049);
        cn.jiguang.bb.f.c("JLocation", "load  last gps success:" + r3.toString());
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0165, code lost:
    
        cn.jiguang.bw.a.a().b((java.lang.Object) 2048);
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0172, code lost:
    
        return null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private cn.jiguang.ak.a i(android.content.Context r9) {
        /*
            Method dump skipped, instructions count: 426
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.aj.a.i(android.content.Context):cn.jiguang.ak.a");
    }

    @Override // cn.jiguang.m.a
    protected boolean a_() {
        if (this.f1526i) {
            return this.f1525h;
        }
        return true;
    }

    @Override // cn.jiguang.m.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public Bundle g(Context context) {
        a aVar;
        Bundle a6;
        String g6 = cn.jiguang.m.b.g(context);
        if (TextUtils.isEmpty(g6)) {
            a6 = a(0L, 200.0d, 200.0d);
            aVar = this;
        } else {
            String[] split = g6.split(",");
            aVar = this;
            a6 = aVar.a(Long.valueOf(split[0]).longValue(), Double.valueOf(split[1]).doubleValue(), Double.valueOf(split[2]).doubleValue());
        }
        String h6 = cn.jiguang.m.b.h(context);
        if (!TextUtils.isEmpty(h6)) {
            a6.putString("wss", h6);
        }
        String a7 = x.a(context, aVar.f1525h);
        String a8 = o.a(context);
        a6.putString("operator", a7);
        a6.putString("networkType", a8);
        return a6;
    }

    @Override // cn.jiguang.m.a
    protected void c(Context context, String str) {
        cn.jiguang.bw.a.a().c((Object) 2083);
        JSONObject a6 = a(a(b(context, Integer.MAX_VALUE), h(context), i(context)), j.a("rl.catch"));
        if (a6 != null) {
            f.c("JLocation", "save json:" + a6);
            cn.jiguang.bw.a.a().c((Object) 2060);
            j.a("rl.catch", a6);
        }
        g.a().a("deviceinfo", g(context));
        super.c(context, str);
    }

    public boolean e() {
        return this.f1519b;
    }

    public static a a() {
        return c.f1529a;
    }

    public List<cn.jiguang.ak.b> b(Context context, int i6) {
        String str;
        try {
            if (!this.f1521d) {
                this.f1524g = cn.jiguang.g.a.a().e(AVMDLDataLoader.KeyIsIsEncryptVersion);
            }
            f.c("JLocation", "configWIfiEnable:" + this.f1524g + " cmdWifiEnable=" + this.f1521d);
            if (!this.f1521d && !this.f1524g) {
                return null;
            }
            if (!q.b(context, com.kuaishou.weapon.p0.g.f36044d)) {
                cn.jiguang.bw.a.a().e((Object) 2033);
                str = "collect wifi failed because has no android.permission.ACCESS_WIFI_STATE";
            } else {
                if (cn.jiguang.bz.a.h(context)) {
                    cn.jiguang.bw.a.a().e((Object) 2044);
                    List<cn.jiguang.ak.b> a6 = d.a(context, i6, this.f1521d);
                    if (a6 == null || a6.size() <= 0) {
                        cn.jiguang.bw.a.a().e((Object) 2042);
                        return a6;
                    }
                    cn.jiguang.bw.a.a().e(Integer.valueOf(GLMapStaticValue.AM_PARAMETERNAME_SETCOLORBLINDSTATUS));
                    f.c("JLocation", "collect wifi success:" + a6);
                    return a6;
                }
                cn.jiguang.bw.a.a().e((Object) 2034);
                str = "collect wifi failed because not enable to collect wifi list";
            }
            f.i("JLocation", str);
            return null;
        } catch (Exception e6) {
            cn.jiguang.bw.a.a().e((Object) 2043);
            f.c("JLocation", "collect wifi failed :" + e6.getMessage());
            return null;
        }
    }

    @Override // cn.jiguang.m.a
    protected boolean c() {
        return true;
    }

    @Override // cn.jiguang.m.a
    protected void d(Context context, String str) {
        cn.jiguang.bw.a.a().c((Object) 2084);
        this.f1525h = false;
        this.f1521d = false;
        this.f1519b = false;
        this.f1520c = false;
        this.f1526i = false;
        JSONObject a6 = j.a("rl.catch");
        if (a6 != null && !"{}".equals(a6.toString())) {
            JSONArray optJSONArray = a6.optJSONArray("content");
            if (optJSONArray != null) {
                try {
                } catch (Throwable th) {
                    f.i("JLocation", "report failed, " + th.getMessage());
                }
                if (optJSONArray.length() != 0 && (optJSONArray.length() != 1 || !"{}".equals(optJSONArray.getJSONObject(0).toString()))) {
                    cn.jiguang.bw.a.a().c((Object) 2064);
                    cn.jiguang.bd.f.a(context, optJSONArray);
                    f.c("JLocation", "report success.clean cache json=" + optJSONArray);
                    j.d("rl.catch");
                    super.d(context, str);
                    return;
                }
            }
            f.c("JLocation", "there are no content data to report");
            cn.jiguang.bw.a.a().c((Object) 2063);
            return;
        }
        f.c("JLocation", "there are no data to report");
        cn.jiguang.bw.a.a().c((Object) 2062);
    }

    @Override // cn.jiguang.m.a
    protected String a(Context context) {
        this.f1518a = context;
        return "JLocation";
    }

    private JSONObject a(List<cn.jiguang.ak.b> list, List<cn.jiguang.al.d> list2, cn.jiguang.ak.a aVar) {
        int i6;
        JSONObject jSONObject;
        String str;
        JSONObject jSONObject2 = new JSONObject();
        boolean z5 = this.f1521d;
        String str2 = "signal_strength";
        String str3 = CommonNetImpl.TAG;
        if (!(z5 || this.f1524g) || list == null || list.isEmpty()) {
            cn.jiguang.bw.a.a().e((Object) 2059);
        } else {
            JSONArray jSONArray = new JSONArray();
            for (int i7 = 0; i7 < list.size(); i7 = i6 + 1) {
                try {
                    jSONObject = new JSONObject();
                    cn.jiguang.ak.b bVar = list.get(i7);
                    i6 = i7;
                    try {
                        jSONObject.put("itime", bVar.f1556a);
                        String str4 = bVar.f1558c;
                        if (str4 != null) {
                            jSONObject.put(CommonNetImpl.TAG, str4);
                        }
                        jSONObject.put("ssid", bVar.f1557b);
                        jSONObject.put("mac_address", bVar.f1560e);
                        jSONObject.put("signal_strength", bVar.f1559d);
                    } catch (Throwable th) {
                        th = th;
                        cn.jiguang.bw.a.a().e((Object) 2057);
                        f.i("JLocation", "package wifi json exception:" + th.getMessage());
                    }
                } catch (Throwable th2) {
                    th = th2;
                    i6 = i7;
                }
                try {
                    jSONObject.put("age", 0);
                    jSONArray.put(jSONObject);
                    jSONObject2.put("wifi", jSONArray);
                } catch (Throwable th3) {
                    th = th3;
                    cn.jiguang.bw.a.a().e((Object) 2057);
                    f.i("JLocation", "package wifi json exception:" + th.getMessage());
                }
            }
            cn.jiguang.bw.a.a().e((Object) 2058);
        }
        if ((this.f1520c || this.f1523f) && list2 != null) {
            try {
                JSONArray jSONArray2 = new JSONArray();
                for (cn.jiguang.al.d dVar : list2) {
                    if (dVar != null) {
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.put("itime", dVar.f1580a);
                        jSONObject3.put("radio_type", dVar.f1588i);
                        jSONObject3.put("generation", dVar.f1587h);
                        jSONObject3.put(bi.P, dVar.f1586g);
                        jSONObject3.put("mobile_country_code", dVar.f1583d);
                        jSONObject3.put("mobile_network_code", dVar.f1584e);
                        jSONObject3.put(str2, dVar.f1589j);
                        String str5 = str2;
                        str = str3;
                        try {
                            jSONObject3.put("cell_id", dVar.f1581b);
                            jSONObject3.put("location_area_code", dVar.f1582c);
                            jSONArray2.put(jSONObject3);
                            str2 = str5;
                            str3 = str;
                        } catch (Throwable th4) {
                            th = th4;
                            cn.jiguang.bw.a.a().d((Object) 2057);
                            f.i("JLocation", "package cell json exception:" + th.getMessage());
                            if (this.f1519b) {
                            }
                            try {
                                JSONArray jSONArray3 = new JSONArray();
                                JSONObject jSONObject4 = new JSONObject();
                                jSONObject4.put("itime", aVar.f1549a);
                                jSONObject4.put(str, aVar.f1550b);
                                jSONObject4.put(com.umeng.analytics.pro.d.C, aVar.f1551c);
                                jSONObject4.put(com.umeng.analytics.pro.d.D, aVar.f1552d);
                                jSONObject4.put("alt", aVar.f1553e);
                                jSONObject4.put("bear", aVar.f1554f);
                                jSONObject4.put("acc", aVar.f1555g);
                                jSONArray3.put(jSONObject4);
                                jSONObject2.put(GeocodeSearch.GPS, jSONArray3);
                                cn.jiguang.bw.a.a().b((Object) 2058);
                            } catch (Throwable th5) {
                                cn.jiguang.bw.a.a().b((Object) 2057);
                                f.i("JLocation", "package gps json exception:" + th5.getMessage());
                            }
                            return jSONObject2;
                        }
                    }
                }
                str = str3;
                jSONObject2.put("cell", jSONArray2);
                cn.jiguang.bw.a.a().d((Object) 2058);
            } catch (Throwable th6) {
                th = th6;
                str = str3;
            }
        } else {
            str = CommonNetImpl.TAG;
            cn.jiguang.bw.a.a().d((Object) 2059);
        }
        if ((!this.f1519b || this.f1522e) && aVar != null) {
            JSONArray jSONArray32 = new JSONArray();
            JSONObject jSONObject42 = new JSONObject();
            jSONObject42.put("itime", aVar.f1549a);
            jSONObject42.put(str, aVar.f1550b);
            jSONObject42.put(com.umeng.analytics.pro.d.C, aVar.f1551c);
            jSONObject42.put(com.umeng.analytics.pro.d.D, aVar.f1552d);
            jSONObject42.put("alt", aVar.f1553e);
            jSONObject42.put("bear", aVar.f1554f);
            jSONObject42.put("acc", aVar.f1555g);
            jSONArray32.put(jSONObject42);
            jSONObject2.put(GeocodeSearch.GPS, jSONArray32);
            cn.jiguang.bw.a.a().b((Object) 2058);
        } else {
            cn.jiguang.bw.a.a().b((Object) 2059);
        }
        return jSONObject2;
    }

    private JSONObject a(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject != null) {
            try {
                if (!"{}".equals(jSONObject.toString())) {
                    JSONArray jSONArray = new JSONArray();
                    try {
                        if (jSONObject2 == null) {
                            jSONObject2 = new JSONObject();
                        } else {
                            jSONArray = jSONObject2.getJSONArray("content");
                        }
                    } catch (Throwable unused) {
                    }
                    for (int i6 = 0; i6 < jSONArray.length(); i6++) {
                        JSONObject optJSONObject = jSONArray.optJSONObject(i6);
                        if (this.f1521d || this.f1524g) {
                            JSONArray optJSONArray = optJSONObject.optJSONArray("wifi");
                            JSONArray optJSONArray2 = jSONObject.optJSONArray("wifi");
                            if (optJSONArray != null && optJSONArray.equals(optJSONArray2)) {
                                jSONObject.remove("wifi");
                            }
                        }
                        if (this.f1520c || this.f1523f) {
                            JSONArray optJSONArray3 = optJSONObject.optJSONArray("cell");
                            JSONArray optJSONArray4 = jSONObject.optJSONArray("cell");
                            if (optJSONArray3 != null && optJSONArray3.equals(optJSONArray4)) {
                                jSONObject.remove("cell");
                            }
                        }
                        if (this.f1519b || this.f1522e) {
                            JSONArray optJSONArray5 = optJSONObject.optJSONArray(GeocodeSearch.GPS);
                            JSONArray optJSONArray6 = jSONObject.optJSONArray(GeocodeSearch.GPS);
                            if (optJSONArray5 != null && optJSONArray5.equals(optJSONArray6)) {
                                jSONObject.remove(GeocodeSearch.GPS);
                            }
                        }
                    }
                    if (jSONObject.length() != 0) {
                        try {
                            if (cn.jiguang.g.a.a().e(AVMDLDataLoader.KeyIsIsChecksumLevel)) {
                                jSONObject.put(bi.T, o.c(this.f1518a));
                            }
                            if (cn.jiguang.g.a.a().e(AVMDLDataLoader.KeyIsIsGetChecksumInfo)) {
                                jSONObject.put("local_dns", cn.jiguang.bz.a.a().e());
                            }
                            String a6 = cn.jiguang.bz.a.a().a(this.f1525h);
                            String b6 = cn.jiguang.r.f.a().b(this.f1518a);
                            if (!TextUtils.isEmpty(b6)) {
                                jSONObject.put("ipv6", b6);
                            }
                            if (!TextUtils.isEmpty(a6)) {
                                jSONObject.put("ip2", a6);
                            }
                            cn.jiguang.d.a.a(this.f1518a, jSONObject, "loc_info");
                            jSONArray.put(jSONObject);
                        } catch (JSONException e6) {
                            f.i("JLocation", "package json exception:" + e6.getMessage());
                        }
                    }
                    jSONObject2.put("content", jSONArray);
                }
            } catch (Throwable unused2) {
            }
        }
        return jSONObject2;
    }

    @Override // cn.jiguang.m.a
    protected void a(String str, JSONObject jSONObject) {
        int optInt = jSONObject.optInt("cmd");
        JSONObject optJSONObject = jSONObject.optJSONObject("content");
        if (optInt != 5) {
            if (optInt == 45) {
                cn.jiguang.m.b.b(this.f1518a, "JLocation", optJSONObject.optLong(bi.aX, 0L) * 1000);
                return;
            }
            return;
        }
        int optInt2 = optJSONObject.optInt("en_config", 0);
        boolean z5 = (optInt2 & 1) != 0;
        this.f1519b = z5;
        boolean z6 = (optInt2 & 2) != 0;
        this.f1520c = z6;
        boolean z7 = (optInt2 & 4) != 0;
        this.f1521d = z7;
        this.f1525h = z5 || z6 || z7;
        f.c("JLocation", "gpsEnable=" + this.f1519b + " ,cellEnable=" + this.f1520c + " ,wifiEnable=" + this.f1521d);
        if (this.f1525h) {
            cn.jiguang.m.b.c(this.f1518a, "JLocation", optJSONObject.optLong("frequency", 0L) * 1000);
        }
    }

    public void a(boolean z5) {
        this.f1526i = z5;
    }

    @Override // cn.jiguang.m.a
    protected boolean a(Context context, String str) {
        return cn.jiguang.m.b.a(context, str);
    }
}
