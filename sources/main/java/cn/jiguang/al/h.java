package cn.jiguang.al;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import android.net.wifi.ScanResult;
import android.os.SystemClock;
import android.telephony.NeighboringCellInfo;
import android.text.TextUtils;
import cn.jiguang.bz.o;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.huawei.hms.common.util.Logger;
import com.umeng.analytics.pro.bi;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes2.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    private static h f1618a;

    /* renamed from: b, reason: collision with root package name */
    private Context f1619b;

    /* renamed from: c, reason: collision with root package name */
    private b f1620c;

    /* renamed from: d, reason: collision with root package name */
    private j f1621d;

    public static h a(Context context) {
        if (f1618a == null) {
            f1618a = new h(cn.jiguang.bz.d.a(context));
        }
        return f1618a;
    }

    private String b(Location location) {
        StringBuilder sb = new StringBuilder();
        sb.append("g|");
        sb.append(System.currentTimeMillis());
        sb.append(Logger.f33116c);
        if (location == null) {
            sb.append("none");
            sb.append(Logger.f33116c);
            sb.append("0");
            sb.append(Logger.f33116c);
            sb.append("0");
            sb.append(Logger.f33116c);
            sb.append("0");
            sb.append(Logger.f33116c);
            sb.append("0");
            sb.append(Logger.f33116c);
            sb.append("0");
        } else {
            sb.append(location.getProvider());
            sb.append(Logger.f33116c);
            sb.append(location.getLongitude());
            sb.append(Logger.f33116c);
            sb.append(location.getLatitude());
            sb.append(Logger.f33116c);
            sb.append(location.getAltitude());
            sb.append(Logger.f33116c);
            sb.append(location.getBearing());
            sb.append(Logger.f33116c);
            sb.append(location.getAccuracy());
        }
        return sb.toString();
    }

    private String c(List<ScanResult> list) {
        StringBuilder sb = new StringBuilder();
        if (list != null) {
            if (list.size() > 0) {
                Collections.sort(list, this.f1621d.a());
                sb.append("w|");
                int i6 = 0;
                while (i6 < list.size()) {
                    String a6 = a(list.get(i6), i6 == 0);
                    if (!TextUtils.isEmpty(a6)) {
                        sb.append(a6);
                        if (i6 < list.size() - 1) {
                            sb.append(",");
                        }
                    }
                    i6++;
                }
            } else {
                sb.append("w|");
                sb.append(a(null, false));
            }
        }
        return sb.toString();
    }

    public JSONObject e() {
        synchronized (this) {
            try {
                try {
                    String e6 = cn.jiguang.bz.j.e("rl2.catch");
                    if (!TextUtils.isEmpty(e6)) {
                        JSONObject jSONObject = new JSONObject();
                        JSONArray jSONArray = new JSONArray();
                        JSONArray jSONArray2 = new JSONArray();
                        JSONArray jSONArray3 = new JSONArray();
                        for (String str : e6.split(com.snail.antifake.deviceid.e.f37542d)) {
                            if (!TextUtils.isEmpty(str)) {
                                if (str.startsWith("g|")) {
                                    jSONArray2.put(str.replaceFirst("g\\|", ""));
                                } else if (str.startsWith("w|")) {
                                    jSONArray.put(str.replaceFirst("w\\|", ""));
                                } else if (str.startsWith("c|")) {
                                    jSONArray3.put(str.replaceFirst("c\\|", ""));
                                }
                            }
                        }
                        if (cn.jiguang.g.a.a().e(AVMDLDataLoader.KeyIsIsTestSpeedVersion)) {
                            jSONObject.put("g", jSONArray2);
                        }
                        if (cn.jiguang.g.a.a().e(AVMDLDataLoader.KeyIsIsEncryptVersion)) {
                            jSONObject.put(IAdInterListener.AdReqParam.WIDTH, jSONArray);
                        }
                        if (cn.jiguang.g.a.a().e(1501)) {
                            jSONObject.put("c", jSONArray3);
                        }
                        cn.jiguang.g.a.a().e(AVMDLDataLoader.KeyIsIsGetChecksumInfo);
                        if (cn.jiguang.g.a.a().e(AVMDLDataLoader.KeyIsIsChecksumLevel)) {
                            jSONObject.put(bi.T, o.c(this.f1619b));
                        }
                        String b6 = cn.jiguang.r.f.a().b(this.f1619b);
                        if (!TextUtils.isEmpty(b6)) {
                            jSONObject.put("ipv6", b6);
                        }
                        String a6 = cn.jiguang.bz.a.a().a(false);
                        if (!TextUtils.isEmpty(a6)) {
                            jSONObject.put("ip2", a6);
                        }
                        return jSONObject;
                    }
                } catch (Throwable th) {
                    cn.jiguang.bb.f.i("LBSManager", "readLbsData failed: " + th);
                }
                return null;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public void f() {
        synchronized (this) {
            cn.jiguang.bz.j.d("rl2.catch");
        }
    }

    private String a(ScanResult scanResult, boolean z5) {
        long currentTimeMillis = System.currentTimeMillis() - (((SystemClock.elapsedRealtimeNanos() / 1000) / 1000) - ((scanResult != null ? scanResult.timestamp : 0L) / 1000));
        String b6 = cn.jiguang.bz.a.a().b(this.f1619b, false);
        if (scanResult != null) {
            String replace = scanResult.SSID.replace(Logger.f33116c, "").replace("#", "").replace(",", "");
            String str = scanResult.BSSID;
            return replace + "#" + scanResult.BSSID + "#" + scanResult.level + "#" + scanResult.capabilities + "#" + currentTimeMillis + "#" + ((str == null || !str.equals(b6)) ? z5 ? "strongest" : "" : "connect");
        }
        String a6 = cn.jiguang.bz.a.a().a(this.f1619b, false);
        int m6 = cn.jiguang.bz.a.a().m(this.f1619b);
        if (TextUtils.isEmpty(a6) && TextUtils.isEmpty(b6)) {
            return "";
        }
        String replace2 = a6.replace(Logger.f33116c, "").replace("#", "").replace(",", "");
        String c6 = o.c(this.f1619b);
        return replace2 + "#" + b6 + "#" + m6 + "##" + currentTimeMillis + "#" + ((TextUtils.isEmpty(c6) || !"WIFI".equalsIgnoreCase(c6)) ? "" : "connect");
    }

    public void b() {
        if (this.f1620c != null) {
            cn.jiguang.bb.f.c("LBSManager", "start scanGps");
            this.f1620c.a();
        }
    }

    public void c() {
        boolean b6 = f.a().b();
        b bVar = this.f1620c;
        if (bVar == null || !b6) {
            return;
        }
        Location a6 = bVar.a(false);
        cn.jiguang.bb.f.c("LBSManager", "get gps");
        if (a6 != null) {
            a(a6);
        } else {
            cn.jiguang.an.a.a(this.f1619b, "loc_info_v2", "g", -1);
        }
    }

    public void d() {
        if (this.f1620c != null) {
            cn.jiguang.bb.f.c("LBSManager", "start scan cell");
            this.f1620c.b();
        }
    }

    private h(Context context) {
        try {
            this.f1619b = context;
            f.a().b(context);
            b bVar = new b(context);
            this.f1620c = bVar;
            bVar.a(this);
            j jVar = new j(context);
            this.f1621d = jVar;
            jVar.a(this);
        } catch (Throwable th) {
            cn.jiguang.bb.f.i("LBSManager", "LBSManageer init error:" + th);
        }
    }

    private String a(d dVar) {
        StringBuilder sb = new StringBuilder();
        sb.append("c|");
        sb.append(System.currentTimeMillis());
        sb.append(Logger.f33116c);
        if (dVar == null) {
            sb.append(0);
            sb.append(Logger.f33116c);
            sb.append(0);
            sb.append(Logger.f33116c);
            sb.append(0);
            sb.append(Logger.f33116c);
            sb.append(0);
            sb.append(Logger.f33116c);
            sb.append("");
            sb.append(Logger.f33116c);
            sb.append("");
            sb.append(Logger.f33116c);
            sb.append("");
            sb.append(Logger.f33116c);
        } else {
            sb.append(dVar.f1583d);
            sb.append(Logger.f33116c);
            sb.append(dVar.f1582c);
            sb.append(Logger.f33116c);
            sb.append(dVar.f1584e);
            sb.append(Logger.f33116c);
            sb.append(dVar.f1581b);
            sb.append(Logger.f33116c);
            sb.append(dVar.f1588i);
            sb.append(Logger.f33116c);
            sb.append(dVar.f1587h);
            sb.append(Logger.f33116c);
            sb.append(dVar.f1586g.replace(Logger.f33116c, " "));
            sb.append(Logger.f33116c);
            List<NeighboringCellInfo> list = dVar.f1590k;
            if (list != null) {
                cn.jiguang.bb.f.c("LBSManager", "neighborCells size:" + list.size());
                for (int i6 = 0; i6 < list.size(); i6++) {
                    sb.append(list.get(i6).getCid());
                    if (i6 < list.size() - 1) {
                        sb.append(",");
                    }
                }
            } else {
                cn.jiguang.bb.f.c("LBSManager", "neighborCells is null");
            }
        }
        return sb.toString();
    }

    protected void b(List<ScanResult> list) {
        Context context;
        int i6;
        cn.jiguang.bb.f.c("LBSManager", "wifi data. size:" + list.size());
        String c6 = c(list);
        cn.jiguang.bb.f.c("LBSManager", "info:" + c6);
        if (TextUtils.isEmpty(c6)) {
            context = this.f1619b;
            i6 = -1;
        } else {
            a(c6);
            context = this.f1619b;
            i6 = 0;
        }
        cn.jiguang.an.a.a(context, "loc_info_v2", IAdInterListener.AdReqParam.WIDTH, i6);
    }

    public void a() {
        if (this.f1621d != null) {
            cn.jiguang.bb.f.c("LBSManager", "start scan wifi");
            this.f1621d.b();
        }
    }

    @SuppressLint({"MissingPermission"})
    protected void a(Location location) {
        Context context;
        int i6;
        String b6 = b(location);
        cn.jiguang.bb.f.c("LBSManager", "location data:" + b6);
        if (TextUtils.isEmpty(b6)) {
            context = this.f1619b;
            i6 = -1;
        } else {
            a(b6);
            context = this.f1619b;
            i6 = 0;
        }
        cn.jiguang.an.a.a(context, "loc_info_v2", "g", i6);
    }

    public void a(String str) {
        synchronized (this) {
            cn.jiguang.bb.f.c("LBSManager", "save lbs data success:" + cn.jiguang.bz.j.b("rl2.catch", str + com.snail.antifake.deviceid.e.f37542d));
        }
    }

    public void a(List<d> list) {
        Context context;
        int i6;
        cn.jiguang.bb.f.c("LBSManager", "cell data：" + list);
        if (list == null || list.size() <= 0) {
            context = this.f1619b;
            i6 = -1;
        } else {
            Iterator<d> it = list.iterator();
            while (it.hasNext()) {
                String a6 = a(it.next());
                cn.jiguang.bb.f.c("LBSManager", "cell info:" + a6);
                if (!TextUtils.isEmpty(a6)) {
                    a(a6);
                }
            }
            context = this.f1619b;
            i6 = 0;
        }
        cn.jiguang.an.a.a(context, "loc_info_v2", "c", i6);
    }
}
