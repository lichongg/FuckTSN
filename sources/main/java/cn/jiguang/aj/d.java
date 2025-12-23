package cn.jiguang.aj;

import android.content.Context;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.text.TextUtils;
import androidx.work.PeriodicWorkRequest;
import cn.jiguang.bb.f;
import cn.jiguang.bz.k;
import cn.jiguang.bz.o;
import cn.jiguang.bz.q;
import cn.jiguang.bz.w;
import com.autonavi.base.amap.mapcore.tools.GLMapStaticValue;
import com.kuaishou.weapon.p0.g;
import com.stub.StubApp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* loaded from: D:\Downloads\app\classes2.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private static List<cn.jiguang.ak.b> f1548a = new ArrayList();

    private static String a(Context context) {
        String str;
        WifiManager wifiManager;
        try {
        } catch (Throwable unused) {
            str = "";
        }
        if (Build.VERSION.SDK_INT >= 29 && cn.jiguang.g.a.a().a(1608) && (wifiManager = (WifiManager) StubApp.getOrigApplicationContext(context.getApplicationContext()).getSystemService("wifi")) != null) {
            str = cn.jiguang.bz.a.a().a(context, false);
            try {
                int n6 = cn.jiguang.bz.a.a().n(context);
                for (WifiConfiguration wifiConfiguration : wifiManager.getConfiguredNetworks()) {
                    if (wifiConfiguration.networkId == n6) {
                        str = wifiConfiguration.SSID;
                    }
                }
            } catch (Throwable unused2) {
            }
            f.c("JLocationWifi", "ssid is " + str);
            return str.replace("\"", "");
        }
        return "";
    }

    public static List<cn.jiguang.ak.b> a(Context context, int i6, boolean z5) {
        f.c("JLocationWifi", "getWifiInfoList local memory wifiInfoList=" + f1548a);
        boolean a6 = k.a("getWifiInfoList", PeriodicWorkRequest.MIN_PERIODIC_INTERVAL_MILLIS, Integer.MAX_VALUE);
        f.c("JLocationWifi", "getWifiInfoList is freq=" + a6);
        if (a6) {
            cn.jiguang.bw.a.a().e((Object) 2037);
        }
        if (z5 || !a6) {
            f.c("JLocationWifi", "getWifiInfoList no freq,start use api");
            a(context, z5);
        }
        List<cn.jiguang.ak.b> list = f1548a;
        if (list == null || list.size() <= 0) {
            f.c("JLocationWifi", "getWifiInfoList  default data=" + f1548a);
            return f1548a;
        }
        if (i6 > f1548a.size()) {
            i6 = f1548a.size();
        }
        List<cn.jiguang.ak.b> subList = f1548a.subList(0, i6);
        f.c("JLocationWifi", "getWifiInfoList return data=" + subList);
        return subList;
    }

    public static List<cn.jiguang.ak.b> a(Context context, boolean z5) {
        Integer valueOf = Integer.valueOf(GLMapStaticValue.AM_PARAMETERNAME_TEXT_GL_UNIT);
        if (!cn.jiguang.d.a.p(context)) {
            cn.jiguang.bw.a.a().e((Object) 2038);
            return null;
        }
        WifiManager wifiManager = (WifiManager) StubApp.getOrigApplicationContext(context.getApplicationContext()).getSystemService("wifi");
        if (wifiManager == null || !wifiManager.isWifiEnabled()) {
            cn.jiguang.bw.a.a().e((Object) 2039);
            f.i("JLocationWifi", "get wifiManager failed");
            return null;
        }
        f1548a.clear();
        cn.jiguang.ak.b bVar = new cn.jiguang.ak.b();
        bVar.f1556a = cn.jiguang.d.b.b(context);
        if (cn.jiguang.g.a.a().a(1608)) {
            String a6 = cn.jiguang.bz.a.a().a(context, z5);
            if (TextUtils.isEmpty(a6) || "<unknown ssid>".equals(a6)) {
                a6 = a(context);
            }
            bVar.f1557b = w.b(a6);
        }
        cn.jiguang.m.b.s(context, bVar.f1557b);
        String c6 = o.c(context);
        if (!TextUtils.isEmpty(c6) && "WIFI".equalsIgnoreCase(c6)) {
            bVar.f1558c = "connect";
        }
        bVar.f1559d = cn.jiguang.bz.a.a().m(context);
        if (cn.jiguang.g.a.a().a(1601)) {
            bVar.f1560e = cn.jiguang.bz.a.a().b(context, z5);
        }
        f.c("JLocationWifi", "connectingWifi:" + bVar.toString());
        f1548a.add(bVar);
        if (Build.VERSION.SDK_INT >= 23) {
            boolean a7 = q.a(context, g.f36048h);
            boolean a8 = q.a(context, g.f36047g);
            if (!a7) {
                cn.jiguang.bw.a.a().e((Object) 2041);
            }
            if (!a8) {
                cn.jiguang.bw.a.a().e((Object) 2040);
            }
            if (!a7 && !a8) {
                f.i("JLocationWifi", "scan wifi list failed because has no Manifest.permission.LOCATION");
                return f1548a;
            }
        }
        cn.jiguang.bw.a.a().e(valueOf);
        List<ScanResult> scanResults = wifiManager.getScanResults();
        if (scanResults == null || scanResults.size() == 0) {
            f.i("JLocationWifi", "scan wifi list failed");
            cn.jiguang.bw.a.a().e((Object) 2046);
            return f1548a;
        }
        f.c("JLocationWifi", "scan wifi list success:" + scanResults);
        ArrayList<ScanResult> arrayList = new ArrayList(scanResults);
        for (ScanResult scanResult : arrayList) {
            if ((TextUtils.isEmpty(bVar.f1557b) || !bVar.f1557b.equals(w.b(scanResult.SSID)) || TextUtils.isEmpty(bVar.f1560e) || !bVar.f1560e.equals(scanResult.BSSID)) && scanResult.level >= -200) {
                for (ScanResult scanResult2 : arrayList) {
                    if (scanResult2 != scanResult && scanResult.SSID.equals(scanResult2.SSID) && scanResult.BSSID.equals(scanResult2.BSSID)) {
                        scanResults.remove(scanResult);
                    }
                }
            } else {
                scanResults.remove(scanResult);
            }
        }
        arrayList.clear();
        Collections.sort(scanResults, new Comparator<ScanResult>() { // from class: cn.jiguang.aj.d.1
            @Override // java.util.Comparator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public int compare(ScanResult scanResult3, ScanResult scanResult4) {
                return scanResult4.level - scanResult3.level;
            }
        });
        for (int i6 = 0; i6 < scanResults.size(); i6++) {
            ScanResult scanResult3 = scanResults.get(i6);
            String b6 = w.b(scanResult3.SSID);
            cn.jiguang.ak.b bVar2 = new cn.jiguang.ak.b();
            bVar2.f1556a = cn.jiguang.d.b.b(context);
            bVar2.f1557b = b6;
            bVar2.f1558c = null;
            if (i6 == 0) {
                bVar2.f1558c = "strongest";
            }
            bVar2.f1559d = scanResult3.level;
            bVar2.f1560e = scanResult3.BSSID;
            f1548a.add(bVar2);
        }
        return f1548a;
    }
}
