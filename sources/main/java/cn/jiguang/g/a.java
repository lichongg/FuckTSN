package cn.jiguang.g;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Bundle;
import android.util.ArrayMap;
import androidx.core.view.PointerIconCompat;
import cn.jiguang.bb.f;
import cn.jiguang.bz.d;
import com.amap.api.services.core.AMapException;
import com.autonavi.base.amap.mapcore.tools.GLMapStaticValue;
import com.kwad.library.solder.lib.ext.PluginError;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

@TargetApi(19)
/* loaded from: D:\Downloads\app\classes2.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static Map<String, Integer> f2941a;

    /* renamed from: d, reason: collision with root package name */
    private static Map<Integer, Boolean> f2942d;

    /* renamed from: e, reason: collision with root package name */
    private static ArrayList<Integer> f2943e;

    /* renamed from: f, reason: collision with root package name */
    private static Map<Integer, Integer[]> f2944f;

    /* renamed from: g, reason: collision with root package name */
    private static ArrayList<Integer> f2945g;

    /* renamed from: h, reason: collision with root package name */
    private static ArrayList<Integer> f2946h;

    /* renamed from: i, reason: collision with root package name */
    private static ArrayList<Integer> f2947i = new ArrayList<>();

    /* renamed from: b, reason: collision with root package name */
    public ArrayList<String[]> f2948b;

    /* renamed from: c, reason: collision with root package name */
    private Map<Integer, cn.jiguang.q.a> f2949c;

    /* renamed from: j, reason: collision with root package name */
    private boolean f2950j;

    /* renamed from: k, reason: collision with root package name */
    private Context f2951k;

    /* renamed from: cn.jiguang.g.a$a, reason: collision with other inner class name */
    private static final class C0045a {

        /* renamed from: a, reason: collision with root package name */
        private static final a f2953a = new a();
    }

    private a() {
        this.f2950j = false;
        this.f2951k = d.a();
        this.f2948b = new ArrayList<>();
        this.f2949c = new ArrayMap();
        b();
    }

    private long a(Date date) {
        if (date == null) {
            return 0L;
        }
        try {
            Date date2 = new Date();
            date2.setHours(date.getHours());
            date2.setMinutes(date.getMinutes());
            date2.setSeconds(date.getSeconds());
            return (date2.getTime() / 1000) * 1000;
        } catch (Exception unused) {
            return 0L;
        }
    }

    public synchronized int b(int i6) {
        Map<Integer, Boolean> map;
        cn.jiguang.q.a aVar;
        try {
            map = f2942d;
        } finally {
            return 0;
        }
        if (map != null && map.containsKey(Integer.valueOf(i6))) {
            return 0;
        }
        Map<Integer, cn.jiguang.q.a> map2 = this.f2949c;
        if (map2 != null && map2.containsKey(Integer.valueOf(i6)) && (aVar = this.f2949c.get(Integer.valueOf(i6))) != null) {
            return aVar.c() * 1000;
        }
        return 0;
    }

    public int c(int i6) {
        cn.jiguang.q.a aVar;
        try {
            Map<Integer, cn.jiguang.q.a> map = this.f2949c;
            if (map != null && map.containsKey(Integer.valueOf(i6)) && (aVar = this.f2949c.get(Integer.valueOf(i6))) != null) {
                return aVar.h();
            }
        } catch (Throwable th) {
            f.i("JDataConfigManager", "get bg interval  failed :" + th);
        }
        return f2945g.contains(Integer.valueOf(i6)) ? -1 : 0;
    }

    public int d(int i6) {
        cn.jiguang.q.a aVar;
        int i7 = 0;
        try {
            Map<Integer, cn.jiguang.q.a> map = this.f2949c;
            if (map != null && i6 > 0 && map.containsKey(Integer.valueOf(i6)) && (aVar = this.f2949c.get(Integer.valueOf(i6))) != null) {
                i7 = aVar.i();
                if (i7 > 0) {
                    i7 *= 60000;
                }
            }
        } catch (Throwable th) {
            f.i("JDataConfigManager", "get method interval  failed :" + th);
        }
        f.a(i6, "JDataConfigManager", "configId is " + i6 + ", method freq is " + i7);
        return i7;
    }

    static {
        ArrayMap arrayMap = new ArrayMap();
        f2941a = arrayMap;
        arrayMap.put("JDevice", 1000);
        f2941a.put("JDeviceScreen", 2900);
        f2947i.add(1100);
        f2947i.add(1900);
        f2941a.put("JLocation", 1500);
        f2941a.put("JAppAll", 1100);
        f2941a.put("JAppMovement", Integer.valueOf(AMapException.CODE_AMAP_ENGINE_RESPONSE_DATA_ERROR));
        f2941a.put("JAppPermission", 1300);
        f2941a.put("JAppRunning", Integer.valueOf(AMapException.CODE_AMAP_ENGINE_CONNECT_TIMEOUT));
        f2941a.put("JAppSdk", Integer.valueOf(AMapException.CODE_AMAP_ENGINE_RETURN_TIMEOUT));
        f2941a.put("JDeviceBattery", Integer.valueOf(AMapException.CODE_AMAP_SERVICE_INVALID_PARAMS));
        f2941a.put("JLocationv2", 1500);
        f2941a.put("JDeviceIds", 1900);
        f2941a.put("uid", 2300);
        f2941a.put("JAppActive", 1104);
        f2941a.put("JAppActiveWithFile", 1112);
        f2941a.put("JDataCollectStatistic", 2600);
        f2941a.put("JAppProbe", 1106);
        f2941a.put("JDeviceMac", 2700);
        f2941a.put("JDeviceIp", 2800);
        f2941a.put("JDeviceIdMap", 1030);
        f2941a.put("JArp", 1600);
        f2942d = new ArrayMap();
        ArrayList<Integer> arrayList = new ArrayList<>();
        f2943e = arrayList;
        arrayList.add(Integer.valueOf(AMapException.CODE_AMAP_CLIENT_ERRORCODE_MISSSING));
        ArrayMap arrayMap2 = new ArrayMap();
        f2944f = arrayMap2;
        arrayMap2.put(1022, new Integer[]{1023, 1024, 1025});
        f2945g = new ArrayList<Integer>() { // from class: cn.jiguang.g.a.1
            {
                add(2000);
                add(2002);
                add(Integer.valueOf(PluginError.ERROR_UPD_NO_DOWNLOADER));
                add(Integer.valueOf(PluginError.ERROR_UPD_FILE_NOT_FOUND));
                add(2010);
                add(Integer.valueOf(GLMapStaticValue.MAP_PARAMETERNAME_SATELLITE));
                add(Integer.valueOf(GLMapStaticValue.AM_PARAMETERNAME_SETISSTIMAP));
                add(Integer.valueOf(PointerIconCompat.TYPE_HORIZONTAL_DOUBLE_ARROW));
                add(1009);
                add(Integer.valueOf(PointerIconCompat.TYPE_VERTICAL_DOUBLE_ARROW));
            }
        };
        ArrayList<Integer> arrayList2 = new ArrayList<>();
        f2946h = arrayList2;
        arrayList2.add(Integer.valueOf(PointerIconCompat.TYPE_VERTICAL_DOUBLE_ARROW));
        f2946h.add(Integer.valueOf(PointerIconCompat.TYPE_HORIZONTAL_DOUBLE_ARROW));
        f2946h.add(1009);
    }

    public static a a() {
        return C0045a.f2953a;
    }

    private boolean i(int i6) {
        return (i6 < 2000 || i6 >= 2300 || i6 == 2004 || i6 == 2005 || i6 == 2007) ? false : true;
    }

    public long b(String str) {
        cn.jiguang.q.a aVar;
        try {
            Map<String, Integer> map = f2941a;
            if (map == null) {
                return 86400000L;
            }
            Integer num = map.get(str);
            Map<Integer, cn.jiguang.q.a> map2 = this.f2949c;
            if (map2 == null || num == null || !map2.containsKey(num) || (aVar = this.f2949c.get(num)) == null) {
                return 86400000L;
            }
            return aVar.f() * 1000;
        } catch (Throwable th) {
            f.i("JDataConfigManager", "get clt interval  failed :" + th);
            return 86400000L;
        }
    }

    public long c(String str) {
        cn.jiguang.q.a aVar;
        try {
            Map<String, Integer> map = f2941a;
            if (map == null) {
                return 0L;
            }
            Integer num = map.get(str);
            Map<Integer, cn.jiguang.q.a> map2 = this.f2949c;
            if (map2 == null || num == null || !map2.containsKey(num) || (aVar = this.f2949c.get(num)) == null) {
                return 0L;
            }
            return aVar.d() * 1000;
        } catch (Throwable unused) {
            return 0L;
        }
    }

    public long d(String str) {
        cn.jiguang.q.a aVar;
        try {
            Map<String, Integer> map = f2941a;
            if (map == null) {
                return 86400000L;
            }
            Integer num = map.get(str);
            Map<Integer, cn.jiguang.q.a> map2 = this.f2949c;
            if (map2 == null || num == null || !map2.containsKey(num) || (aVar = this.f2949c.get(num)) == null) {
                return 86400000L;
            }
            return aVar.g() * 1000;
        } catch (Throwable th) {
            f.i("JDataConfigManager", "get rpt interval  failed :" + th);
            return 86400000L;
        }
    }

    public static void a(Bundle bundle) {
        Bundle bundle2 = bundle.getBundle("action_tag_time");
        if (bundle2 != null) {
            for (String str : bundle2.keySet()) {
                a(str, bundle2.getLong(str));
            }
        }
    }

    public void b() {
        if (this.f2950j) {
            return;
        }
        cn.jiguang.be.b.d(new Runnable() { // from class: cn.jiguang.g.a.2
            @Override // java.lang.Runnable
            public void run() {
                cn.jiguang.q.c.b().c(d.a());
            }
        });
        this.f2950j = true;
    }

    public void c() {
        this.f2948b = new ArrayList<>();
        this.f2949c = new ArrayMap();
    }

    public boolean e(int i6) {
        cn.jiguang.bw.a a6;
        int i7;
        int i8;
        boolean z5 = false;
        if (!cn.jiguang.bz.b.a()) {
            f.a(i6, "JDataConfigManager", "isCanCollect isAuth " + cn.jiguang.bz.b.a());
            cn.jiguang.bw.a.a().a(i6, 2030);
            return false;
        }
        boolean a7 = cn.jiguang.m.b.a(i6);
        if (a().a(i6) && !a7) {
            z5 = true;
        }
        if (a7) {
            a6 = cn.jiguang.bw.a.a();
            i7 = 2029;
        } else {
            a6 = cn.jiguang.bw.a.a();
            i7 = 2065;
        }
        a6.a(i6, i7);
        cn.jiguang.bw.a a8 = cn.jiguang.bw.a.a();
        if (z5) {
            i8 = 2031;
        } else {
            i8 = 2032;
        }
        a8.a(i6, i8);
        f.a(i6, "JDataConfigManager", "configId is " + i6 + ", isCanCollect is " + z5);
        return z5;
    }

    public boolean f(int i6) {
        if (!cn.jiguang.bz.b.a()) {
            f.a(i6, "JDataConfigManager", "isConfigCanCollect isAuth " + cn.jiguang.bz.b.a());
            return false;
        }
        boolean a6 = a().a(i6);
        f.a(i6, "JDataConfigManager", "configId is " + i6 + ", isConfigCanCollect is " + a6);
        return a6;
    }

    public boolean g(int i6) {
        StringBuilder sb;
        boolean z5 = true;
        if (!cn.jiguang.bz.b.a()) {
            sb = new StringBuilder();
            sb.append("isNotCollect isAuth ");
            sb.append(cn.jiguang.bz.b.a());
        } else {
            if (a().a(i6) && !cn.jiguang.m.b.a(i6)) {
                z5 = false;
            }
            sb = new StringBuilder();
            sb.append("configId is ");
            sb.append(i6);
            sb.append(", isNotCollect is ");
            sb.append(z5);
        }
        f.a(i6, "JDataConfigManager", sb.toString());
        return z5;
    }

    public boolean h(int i6) {
        boolean a6 = c.a().a(i6);
        boolean b6 = c.a().b(i6);
        f.a(i6, "JDataConfigManager", "isUserEnable with configId: " + i6 + " { containEnableDatas: " + a6 + ", containDisableDatas: " + b6);
        if (a6 || !b6) {
            return true;
        }
        return false;
    }

    public void a(cn.jiguang.q.a aVar) {
        if (aVar == null) {
            return;
        }
        try {
            if (this.f2949c == null) {
                this.f2949c = new ArrayMap();
            }
            int a6 = aVar.a();
            if (!this.f2949c.containsKey(Integer.valueOf(a6))) {
                this.f2949c.put(Integer.valueOf(a6), aVar);
            }
            if (a6 < 2000) {
                int i6 = (a6 / 100) * 100;
                if (f2947i.contains(Integer.valueOf(i6)) || this.f2949c.containsKey(Integer.valueOf(i6))) {
                    return;
                }
                cn.jiguang.q.a aVar2 = new cn.jiguang.q.a();
                aVar2.a(i6);
                aVar2.a(true);
                aVar2.b(aVar.c());
                aVar2.e(aVar.f());
                aVar2.d(aVar.e());
                aVar2.f(aVar.g());
                aVar2.g(aVar.h());
                aVar2.h(aVar.i());
                aVar2.c(aVar.d());
                this.f2949c.put(Integer.valueOf(i6), aVar2);
            }
        } catch (Throwable th) {
            f.i("JDataConfigManager", "addConfig failed :" + th);
        }
    }

    public boolean b(int i6, boolean z5) {
        StringBuilder sb;
        boolean z6 = false;
        if (cn.jiguang.bz.b.a()) {
            if (a().a(i6, z5) && !cn.jiguang.m.b.a(i6)) {
                z6 = true;
            }
            sb = new StringBuilder();
            sb.append("configId is ");
            sb.append(i6);
            sb.append(", isCanCollect is ");
            sb.append(z6);
        } else {
            sb = new StringBuilder();
            sb.append("isCanCollect isAuth ");
            sb.append(cn.jiguang.bz.b.a());
        }
        f.a(i6, "JDataConfigManager", sb.toString());
        return z6;
    }

    public synchronized void a(String str) {
        try {
            Map<String, Integer> map = f2941a;
            if (map != null) {
                Integer num = map.get(str);
                Map<Integer, Boolean> map2 = f2942d;
                if (map2 != null && num != null && !map2.containsKey(num)) {
                    f.c("JDataConfigManager", "mark first collect delay :" + str + ":" + num);
                    f2942d.put(num, Boolean.TRUE);
                }
            }
        } finally {
        }
    }

    private static synchronized void a(String str, long j6) {
        synchronized (a.class) {
        }
    }

    public boolean a(int i6) {
        return a(i6, true);
    }

    /* JADX WARN: Code restructure failed: missing block: B:70:0x0218, code lost:
    
        if (r9 != false) goto L89;
     */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0186 A[Catch: all -> 0x0173, TRY_ENTER, TryCatch #0 {all -> 0x0173, blocks: (B:49:0x0186, B:51:0x01a6, B:54:0x021a, B:55:0x01b0, B:57:0x01b4, B:58:0x01bc, B:61:0x01c5, B:63:0x01f7, B:65:0x0200, B:67:0x020b, B:83:0x015e, B:98:0x0220, B:102:0x0237, B:104:0x0249, B:108:0x0255, B:111:0x0261, B:113:0x026b, B:115:0x0277, B:118:0x029a, B:120:0x02a4), top: B:4:0x001a }] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x01c5 A[Catch: all -> 0x0173, TryCatch #0 {all -> 0x0173, blocks: (B:49:0x0186, B:51:0x01a6, B:54:0x021a, B:55:0x01b0, B:57:0x01b4, B:58:0x01bc, B:61:0x01c5, B:63:0x01f7, B:65:0x0200, B:67:0x020b, B:83:0x015e, B:98:0x0220, B:102:0x0237, B:104:0x0249, B:108:0x0255, B:111:0x0261, B:113:0x026b, B:115:0x0277, B:118:0x029a, B:120:0x02a4), top: B:4:0x001a }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean a(int r21, boolean r22) {
        /*
            Method dump skipped, instructions count: 714
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.g.a.a(int, boolean):boolean");
    }
}
