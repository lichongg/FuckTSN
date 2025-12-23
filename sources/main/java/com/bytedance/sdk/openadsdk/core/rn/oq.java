package com.bytedance.sdk.openadsdk.core.rn;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.net.wifi.WifiInfo;
import android.os.Build;
import android.os.PowerManager;
import android.os.SystemClock;
import android.provider.Settings;
import android.system.OsConstants;
import android.telephony.CellInfo;
import android.telephony.CellInfoCdma;
import android.telephony.CellInfoGsm;
import android.telephony.CellInfoLte;
import android.telephony.CellInfoWcdma;
import android.telephony.CellSignalStrength;
import android.telephony.CellSignalStrengthTdscdma;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.view.accessibility.AccessibilityManager;
import androidx.core.app.NotificationCompat;
import androidx.core.view.MotionEventCompat;
import androidx.work.WorkRequest;
import cn.jiguang.bz.g0;
import cn.jiguang.bz.h0;
import cn.jiguang.bz.o0;
import cn.jiguang.bz.y0;
import com.acse.ottn.j4;
import com.baidu.idl.face.platform.FaceEnvironment;
import com.bytedance.sdk.component.utils.ch;
import com.stub.StubApp;
import com.umeng.analytics.pro.bi;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class oq {
    private static volatile long av;
    private static volatile long ch;
    private static volatile boolean cw;

    /* renamed from: f, reason: collision with root package name */
    private static volatile String f30125f;

    /* renamed from: h, reason: collision with root package name */
    private static volatile xt f30127h;

    /* renamed from: j, reason: collision with root package name */
    private static String f30129j;
    private static volatile long jy;
    private static volatile String kt;
    private static volatile String mi;

    /* renamed from: p, reason: collision with root package name */
    private static volatile r f30132p;
    private static volatile String tj;

    /* renamed from: v, reason: collision with root package name */
    private static volatile long f30135v;

    /* renamed from: w, reason: collision with root package name */
    private static volatile long f30136w;
    private static volatile long ws;

    /* renamed from: x, reason: collision with root package name */
    private static volatile String f30137x;
    private static volatile boolean xt;

    /* renamed from: r, reason: collision with root package name */
    private static AtomicBoolean f30133r = new AtomicBoolean(false);
    private static AtomicBoolean up = new AtomicBoolean(false);

    /* renamed from: m, reason: collision with root package name */
    private static AtomicInteger f30131m = new AtomicInteger(-1);
    private static volatile boolean ae = true;
    private static long tl = 0;

    /* renamed from: g, reason: collision with root package name */
    private static volatile int f30126g = -1;
    private static volatile int oq = -1;
    private static volatile String qv = null;
    private static volatile String vl = null;
    private static volatile float az = -2.0f;

    /* renamed from: i, reason: collision with root package name */
    private static volatile int f30128i = -1;

    /* renamed from: s, reason: collision with root package name */
    private static volatile long f30134s = -1;

    /* renamed from: a, reason: collision with root package name */
    private static volatile long f30124a = System.currentTimeMillis();

    /* renamed from: l, reason: collision with root package name */
    private static volatile int f30130l = -1;

    static class r extends BroadcastReceiver {
        /* JADX INFO: Access modifiers changed from: private */
        public void j(final Intent intent) {
            if ("android.intent.action.SCREEN_ON".equals(intent.getAction())) {
                boolean unused = oq.ae = true;
                com.bytedance.sdk.component.utils.vl.j("DeviceUtils", com.umeng.ccg.a.f41530f);
            } else if (!"android.intent.action.SCREEN_OFF".equals(intent.getAction())) {
                if ("android.intent.action.USER_PRESENT".equals(intent.getAction())) {
                    long unused2 = oq.f30124a = System.currentTimeMillis();
                }
            } else {
                boolean unused3 = oq.ae = false;
                com.bytedance.sdk.component.utils.vl.j("DeviceUtils", com.umeng.ccg.a.f41531g);
                if (com.bytedance.sdk.openadsdk.core.oq.i().la()) {
                    return;
                }
                com.bytedance.sdk.openadsdk.l.ae.j(new com.bytedance.sdk.component.oq.g("updateScreenStatus") { // from class: com.bytedance.sdk.openadsdk.core.rn.oq.r.2
                    @Override // java.lang.Runnable
                    public void run() {
                        com.bytedance.sdk.component.panglearmor.xt.xt.j().xt(intent.getAction());
                    }
                });
            }
        }

        r() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, final Intent intent) {
            com.bytedance.sdk.component.utils.tl.xt().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.rn.oq.r.1
                @Override // java.lang.Runnable
                public void run() {
                    r.this.j(intent);
                }
            });
        }
    }

    static class xt extends BroadcastReceiver {
        /* JADX INFO: Access modifiers changed from: private */
        public void j(Intent intent) {
            int i6 = -1;
            if ("android.intent.action.BATTERY_CHANGED".equals(intent.getAction())) {
                boolean booleanExtra = intent.getBooleanExtra("present", false);
                if (booleanExtra) {
                    int intExtra = intent.getIntExtra(NotificationCompat.CATEGORY_STATUS, -1);
                    if (intExtra == -1) {
                        j.f30138j = intExtra;
                    } else if (intExtra == 2) {
                        j.f30138j = 1;
                    } else {
                        j.f30138j = 0;
                    }
                } else {
                    j.f30138j = 2;
                }
                j.xt = (intent.getIntExtra("level", -1) * 100) / intent.getIntExtra("scale", -1);
                if (!com.bytedance.sdk.openadsdk.core.oq.i().la()) {
                    com.bytedance.sdk.openadsdk.j.xt.xt.j(booleanExtra);
                }
            }
            try {
                i6 = intent.getIntExtra("android.media.EXTRA_VOLUME_STREAM_TYPE", -1);
            } catch (Exception unused) {
            }
            if ("android.media.VOLUME_CHANGED_ACTION".equals(intent.getAction()) && i6 == 3) {
                com.bytedance.sdk.component.utils.tl.j().post(new com.bytedance.sdk.component.oq.g("tt_vol") { // from class: com.bytedance.sdk.openadsdk.core.rn.oq.xt.2
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            AudioManager audioManager = (AudioManager) com.bytedance.sdk.openadsdk.core.v.getContext().getSystemService("audio");
                            if (audioManager != null) {
                                int unused2 = oq.f30130l = audioManager.getStreamVolume(3);
                            }
                        } catch (Exception unused3) {
                        }
                    }
                });
            }
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, final Intent intent) {
            if (intent == null) {
                return;
            }
            com.bytedance.sdk.component.utils.tl.cw().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.rn.oq.xt.1
                @Override // java.lang.Runnable
                public void run() {
                    xt.this.j(intent);
                }
            });
        }

        xt() {
        }
    }

    public static boolean j() {
        if (!ae && SystemClock.elapsedRealtime() - tl >= 10000) {
            tl = SystemClock.elapsedRealtime();
            try {
                PowerManager powerManager = (PowerManager) com.bytedance.sdk.openadsdk.core.v.getContext().getSystemService("power");
                if (powerManager != null) {
                    ae = powerManager.isInteractive();
                }
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.vl.j(th);
            }
        }
        return ae;
    }

    public static int r() {
        if (f30126g == -1 || up.getAndSet(false)) {
            f30126g = com.bytedance.sdk.component.utils.ws.xt(com.bytedance.sdk.openadsdk.core.v.getContext());
        }
        return f30126g;
    }

    public static void up() {
        try {
            if (xt && f30132p != null) {
                StubApp.getOrigApplicationContext(com.bytedance.sdk.openadsdk.core.v.getContext().getApplicationContext()).unregisterReceiver(f30132p);
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.vl.j(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String[] x() {
        String[] strArr = {"", ""};
        try {
            Iterator it = Collections.list(NetworkInterface.getNetworkInterfaces()).iterator();
            boolean z5 = false;
            boolean z6 = false;
            loop0: while (it.hasNext()) {
                for (InetAddress inetAddress : j((NetworkInterface) it.next())) {
                    boolean z7 = inetAddress instanceof Inet4Address;
                    if (!z7 || !z5) {
                        if (z7 || !z6) {
                            if (xt(z7, inetAddress, strArr)) {
                                if (!TextUtils.isEmpty(strArr[0]) && !TextUtils.isEmpty(strArr[1])) {
                                    break loop0;
                                }
                            } else {
                                String hostAddress = inetAddress.getHostAddress();
                                if (!TextUtils.isEmpty(hostAddress) && !hostAddress.startsWith("127")) {
                                    if (z7) {
                                        com.bytedance.sdk.openadsdk.core.cw.r.j().jy(com.bytedance.sdk.component.utils.j.xt(hostAddress));
                                        strArr[0] = hostAddress;
                                        kt = hostAddress;
                                        mi = hostAddress;
                                        if (z6) {
                                            break loop0;
                                        }
                                        z5 = true;
                                    } else {
                                        int indexOf = hostAddress.indexOf(37);
                                        if (indexOf >= 0) {
                                            hostAddress = hostAddress.substring(0, indexOf);
                                        }
                                        if (cw(hostAddress)) {
                                            com.bytedance.sdk.openadsdk.core.cw.r.j().ws(com.bytedance.sdk.component.utils.j.xt(hostAddress));
                                            strArr[1] = hostAddress;
                                            f30125f = hostAddress;
                                            tj = hostAddress;
                                            if (z5) {
                                                break loop0;
                                            }
                                            z6 = true;
                                        } else {
                                            continue;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return strArr;
    }

    static class cw implements ch.j {
        cw() {
        }

        @Override // com.bytedance.sdk.component.utils.ch.j
        public void j(Context context, Intent intent, boolean z5, int i6) {
            if (oq.f30131m.get() != i6) {
                oq.f30131m.set(i6);
                oq.f30133r.set(true);
                oq.up.set(true);
                if (!com.bytedance.sdk.openadsdk.core.oq.i().la()) {
                    com.bytedance.sdk.component.panglearmor.xt.xt.j().j(i6);
                }
            }
        }
    }

    public static class j {

        /* renamed from: j, reason: collision with root package name */
        static int f30138j = -1;
        static float xt;

        public static int j(Context context) {
            com.bytedance.sdk.openadsdk.j.xt.xt.j(context);
            return f30138j;
        }

        public static float xt(Context context) {
            com.bytedance.sdk.openadsdk.j.xt.xt.xt(context);
            return xt;
        }
    }

    public static long av() {
        return f30134s != -1 ? f30134s : com.bytedance.sdk.openadsdk.core.cw.r.j().xt("dev19", -1L);
    }

    public static void cw() {
        f30131m.set(com.bytedance.sdk.component.utils.ws.cw(com.bytedance.sdk.openadsdk.core.v.getContext()));
        r();
        vl();
        ws();
        j(0);
        j(1);
        j(false);
        j((String) null);
    }

    private static boolean f() {
        return (f30133r.get() || j(f30135v, 1800000L) || TextUtils.isEmpty(mi)) ? false : true;
    }

    public static int i() {
        if (f30130l >= 0) {
            return f30130l;
        }
        try {
            AudioManager audioManager = (AudioManager) com.bytedance.sdk.openadsdk.core.v.getContext().getSystemService("audio");
            if (audioManager == null) {
                return 0;
            }
            f30130l = audioManager.getStreamVolume(3);
            return f30130l;
        } catch (Exception unused) {
            return 0;
        }
    }

    public static void jy() {
        try {
            if (cw && f30127h != null) {
                StubApp.getOrigApplicationContext(com.bytedance.sdk.openadsdk.core.v.getContext().getApplicationContext()).unregisterReceiver(f30127h);
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.vl.j(th);
        }
    }

    public static boolean oq() {
        if (!com.bytedance.sdk.openadsdk.core.v.xt().pm()) {
            return true;
        }
        try {
            JSONArray jSONArray = new JSONArray(com.bytedance.sdk.openadsdk.core.oq.i().a());
            int length = jSONArray.length();
            for (int i6 = 0; i6 < length; i6++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i6);
                if (optJSONObject != null && !optJSONObject.isNull(CommonNetImpl.NAME) && "tt_inner_isw".equals(optJSONObject.optString(CommonNetImpl.NAME))) {
                    return optJSONObject.optBoolean("value", true);
                }
            }
        } catch (JSONException unused) {
        }
        return true;
    }

    public static JSONArray tl() {
        JSONArray jSONArray = new JSONArray();
        try {
            if (NetworkInterface.getNetworkInterfaces() == null) {
                return new JSONArray();
            }
            if (!oq()) {
                return new JSONArray();
            }
            Iterator it = Collections.list(NetworkInterface.getNetworkInterfaces()).iterator();
            while (it.hasNext()) {
                NetworkInterface networkInterface = (NetworkInterface) it.next();
                String name = networkInterface.getName();
                if ("dummy0".equals(name) || "wlan0".equals(name)) {
                    Iterator it2 = Collections.list(networkInterface.getInetAddresses()).iterator();
                    while (it2.hasNext()) {
                        String hostAddress = ((InetAddress) it2.next()).getHostAddress();
                        if (!TextUtils.isEmpty(hostAddress) && hostAddress.indexOf(58) >= 0) {
                            int indexOf = hostAddress.indexOf(37);
                            if ("dummy0".equals(name)) {
                                JSONObject jSONObject = new JSONObject();
                                jSONObject.put("type", "client_tun");
                                if (indexOf >= 0) {
                                    hostAddress = hostAddress.substring(0, indexOf);
                                }
                                jSONObject.put("value", hostAddress.toUpperCase());
                                jSONArray.put(jSONObject);
                            } else if ("wlan0".equals(name) || "fe80".equalsIgnoreCase(hostAddress.split("::")[0])) {
                                JSONObject jSONObject2 = new JSONObject();
                                jSONObject2.put("type", "client_anpi");
                                if (indexOf >= 0) {
                                    hostAddress = hostAddress.substring(0, indexOf);
                                }
                                jSONObject2.put("value", hostAddress.toUpperCase());
                                jSONArray.put(jSONObject2);
                            }
                        }
                    }
                }
            }
            return jSONArray;
        } catch (Exception e6) {
            com.bytedance.sdk.component.utils.vl.j(e6);
            return jSONArray;
        }
    }

    public static float vl() {
        if (az != -2.0f && !j(av, WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS)) {
            return az;
        }
        int i6 = -1;
        try {
            Context context = com.bytedance.sdk.openadsdk.core.v.getContext();
            if (context != null) {
                i6 = Settings.System.getInt(context.getContentResolver(), "screen_brightness", -1);
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.vl.r("DeviceUtils", th.getMessage());
        }
        if (i6 < 0) {
            az = -1.0f;
        } else {
            az = Math.round((i6 / 255.0f) * 10.0f) / 10.0f;
        }
        av = System.currentTimeMillis();
        return az;
    }

    public static int ws() {
        if (f30128i != -1 && !j(f30136w, 60000L)) {
            return f30128i;
        }
        AccessibilityManager accessibilityManager = (AccessibilityManager) com.bytedance.sdk.openadsdk.core.v.getContext().getSystemService("accessibility");
        if (accessibilityManager == null) {
            return -1;
        }
        f30128i = accessibilityManager.isEnabled() ? 1 : 0;
        f30136w = System.currentTimeMillis();
        return f30128i;
    }

    public static String ae() {
        if (f()) {
            return tj;
        }
        return j(false)[1];
    }

    public static void az() {
        Context context = com.bytedance.sdk.openadsdk.core.v.getContext();
        if (context != null) {
            int jy2 = uf.jy();
            com.bytedance.sdk.openadsdk.core.cw.r.j().j("cpu_cnt", jy2);
            uf.f30158j = jy2;
            int cw2 = uf.cw(uf.jy());
            com.bytedance.sdk.openadsdk.core.cw.r.j().j("cpu_max_freq", cw2);
            uf.xt = cw2;
            int r5 = uf.r(uf.jy());
            com.bytedance.sdk.openadsdk.core.cw.r.j().j("cpu_min_freq", r5);
            uf.cw = r5;
            String r6 = uf.r(context, "MemTotal");
            if (r6 != null) {
                com.bytedance.sdk.openadsdk.core.cw.r.j().xt("total_memory", r6);
                uf.f30160r = r6;
            }
            long w5 = uf.w();
            com.bytedance.sdk.openadsdk.core.cw.r.j().j("internal_storage", w5);
            uf.up = w5;
            long j6 = com.bytedance.sdk.component.utils.jy.j();
            com.bytedance.sdk.openadsdk.core.cw.r.j().j("free_storage", j6);
            uf.f30159m = j6;
            long tj2 = uf.tj();
            com.bytedance.sdk.openadsdk.core.cw.r.j().j("sdcard_storage", tj2);
            uf.ae = tj2;
            boolean v5 = uf.v();
            com.bytedance.sdk.openadsdk.core.cw.r.j().j("is_root", v5 ? 1 : 0);
            uf.tl = v5 ? 1 : 0;
        }
    }

    public static String[] g() {
        if (!oq()) {
            return new String[]{"", ""};
        }
        if (com.bytedance.sdk.openadsdk.core.r.j.tl() && !TextUtils.isEmpty(kt) && !TextUtils.isEmpty(f30125f)) {
            new com.bytedance.sdk.openadsdk.core.r.xt("device_get_ip").j(5).xt(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.rn.oq.1
                @Override // java.lang.Runnable
                public void run() {
                    oq.x();
                }
            });
            return new String[]{kt, f30125f};
        }
        return x();
    }

    public static String m() {
        if (f()) {
            return mi;
        }
        return j(false)[0];
    }

    public static String qv() {
        String languageTag = Locale.getDefault().toLanguageTag();
        if (!TextUtils.isEmpty(languageTag)) {
            return languageTag;
        }
        return "";
    }

    private static String[] v() {
        String[] g6 = g();
        if (TextUtils.isEmpty(g6[0]) && TextUtils.isEmpty(g6[1])) {
            com.bytedance.sdk.openadsdk.core.cw.r.j().jy("");
        }
        return g6;
    }

    public static long xt() {
        return f30124a;
    }

    public static void r(Context context) {
        if (cw) {
            return;
        }
        try {
            f30127h = new xt();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.BATTERY_CHANGED");
            intentFilter.addAction("android.media.VOLUME_CHANGED_ACTION");
            StubApp.getOrigApplicationContext(context.getApplicationContext()).registerReceiver(f30127h, intentFilter);
            cw = true;
        } catch (Throwable unused) {
        }
    }

    public static void xt(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.cw.r.j().r("dev14", com.bytedance.sdk.component.utils.j.xt(str));
        f30137x = str;
        ch = System.currentTimeMillis();
    }

    public static void up(Context context) {
        com.bytedance.sdk.component.utils.ch.j(new cw(), context);
    }

    public static void j(Context context) {
        if (xt) {
            return;
        }
        try {
            PowerManager powerManager = (PowerManager) context.getSystemService("power");
            if (powerManager != null) {
                ae = powerManager.isScreenOn();
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.vl.j(th);
        }
        try {
            f30132p = new r();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.SCREEN_ON");
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            intentFilter.addAction("android.intent.action.USER_PRESENT");
            StubApp.getOrigApplicationContext(context.getApplicationContext()).registerReceiver(f30132p, intentFilter);
            xt = true;
        } catch (Throwable th2) {
            com.bytedance.sdk.component.utils.vl.j(th2);
        }
    }

    private static boolean xt(boolean z5, InetAddress inetAddress, String[] strArr) {
        Field declaredField;
        if (z5) {
            try {
                if (!TextUtils.isEmpty(strArr[0])) {
                    return true;
                }
            } catch (Throwable unused) {
                return false;
            }
        }
        if (!z5 && !TextUtils.isEmpty(strArr[1])) {
            return true;
        }
        if (Build.VERSION.SDK_INT < 24) {
            return j(z5, inetAddress, strArr);
        }
        if (z5) {
            declaredField = InetAddress.class.getDeclaredField("holder");
        } else {
            declaredField = Inet6Address.class.getDeclaredField("holder6");
        }
        declaredField.setAccessible(true);
        Object obj = declaredField.get(inetAddress);
        Class<?> cls = obj.getClass();
        if (z5) {
            Field declaredField2 = cls.getDeclaredField("address");
            declaredField2.setAccessible(true);
            Object obj2 = declaredField2.get(obj);
            int intValue = obj2 instanceof Integer ? ((Integer) obj2).intValue() : 0;
            byte[] bArr = {(byte) ((intValue >>> 24) & 255), (byte) ((intValue >>> 16) & 255), (byte) ((intValue >>> 8) & 255), (byte) (intValue & 255)};
            String xt2 = xt(bArr);
            if (bArr[0] != Byte.MAX_VALUE) {
                strArr[0] = xt2;
            }
        } else {
            Field declaredField3 = cls.getDeclaredField("ipaddress");
            declaredField3.setAccessible(true);
            Object obj3 = declaredField3.get(obj);
            if (obj3 instanceof byte[]) {
                String j6 = j((byte[]) obj3);
                if (!cw(j6)) {
                    return true;
                }
                strArr[1] = j6;
            }
        }
        return true;
    }

    private static boolean cw(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        char charAt = str.charAt(0);
        if ((charAt != '2' && charAt != '3' && charAt != '5') || str.length() < 2) {
            return false;
        }
        char charAt2 = str.charAt(1);
        if (charAt2 >= '0' && charAt2 <= '9') {
            return true;
        }
        if (charAt2 < 'a' || charAt2 > 'f') {
            return charAt2 >= 'A' && charAt2 <= 'F';
        }
        return true;
    }

    private static String r(int i6) {
        List<CellInfo> allCellInfo;
        CellSignalStrengthTdscdma cellSignalStrength;
        int dbm;
        CellSignalStrength cellSignalStrength2;
        WifiInfo xt2;
        int cw2 = com.bytedance.sdk.component.utils.ws.cw(com.bytedance.sdk.openadsdk.core.v.getContext());
        com.bytedance.sdk.openadsdk.i.cw.cw.r w5 = com.bytedance.sdk.openadsdk.core.oq.i().w();
        if (cw2 == 4) {
            if (i6 == 0) {
                try {
                    if (!w5.r() || (xt2 = com.bytedance.sdk.openadsdk.core.kt.xt()) == null) {
                        return "unknown";
                    }
                    return xt2.getRssi() + "dBm";
                } catch (Throwable unused) {
                }
            }
            return "unknown";
        }
        if (w5.cw() && w5.j() && i6 == 1) {
            try {
                if (com.bytedance.sdk.openadsdk.core.kt.av()) {
                    TelephonyManager j6 = com.bytedance.sdk.openadsdk.core.kt.j();
                    int i7 = Build.VERSION.SDK_INT;
                    if (j6 == null || (allCellInfo = j6.getAllCellInfo()) == null) {
                        return "unknown";
                    }
                    CellInfo cellInfo = allCellInfo.get(0);
                    if (cellInfo instanceof CellInfoGsm) {
                        dbm = ((CellInfoGsm) cellInfo).getCellSignalStrength().getDbm();
                    } else if (cellInfo instanceof CellInfoCdma) {
                        dbm = ((CellInfoCdma) cellInfo).getCellSignalStrength().getDbm();
                    } else if (cellInfo instanceof CellInfoLte) {
                        dbm = ((CellInfoLte) cellInfo).getCellSignalStrength().getDbm();
                    } else if (cellInfo instanceof CellInfoWcdma) {
                        dbm = ((CellInfoWcdma) cellInfo).getCellSignalStrength().getDbm();
                    } else if (i7 >= 29 && o0.a(cellInfo)) {
                        cellSignalStrength2 = y0.a(cellInfo).getCellSignalStrength();
                        dbm = cellSignalStrength2.getDbm();
                    } else if (i7 >= 29 && g0.a(cellInfo)) {
                        cellSignalStrength = h0.a(cellInfo).getCellSignalStrength();
                        dbm = cellSignalStrength.getDbm();
                    }
                    if (Integer.MIN_VALUE == dbm) {
                        return "unknown";
                    }
                    return dbm + "dBm";
                }
            } catch (Throwable unused2) {
            }
        }
        return "unknown";
    }

    public static boolean cw(Context context) {
        return (context.getResources().getConfiguration().uiMode & 15) == 4;
    }

    public static String j(String str) {
        if (!TextUtils.isEmpty(f30137x) && !j(ch, 1800000L)) {
            return f30137x;
        }
        String cw2 = com.bytedance.sdk.openadsdk.core.cw.r.j().cw("dev14", 1800000L);
        if (TextUtils.isEmpty(cw2)) {
            if (str == null) {
                str = m();
            }
            f30137x = str;
        } else {
            f30137x = com.bytedance.sdk.component.utils.j.cw(cw2);
        }
        ch = System.currentTimeMillis();
        return f30137x;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0075 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String[] j(boolean r16) {
        /*
            Method dump skipped, instructions count: 223
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.rn.oq.j(boolean):java.lang.String[]");
    }

    private static String xt(byte[] bArr) {
        return (bArr[0] & 255) + "." + (bArr[1] & 255) + "." + (bArr[2] & 255) + "." + (bArr[3] & 255);
    }

    public static boolean xt(Context context) {
        return (context.getResources().getConfiguration().screenLayout & 15) >= 3;
    }

    public static JSONObject xt(int i6) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("appid", com.bytedance.sdk.openadsdk.core.oq.i().f());
            jSONObject.put(CommonNetImpl.NAME, com.bytedance.sdk.openadsdk.core.oq.i().v());
            xt(jSONObject);
            com.bytedance.sdk.openadsdk.av.xt.j(jSONObject, i6);
            jSONObject.put("is_paid_app", com.bytedance.sdk.openadsdk.core.oq.i().x());
            if (!com.bytedance.sdk.openadsdk.core.cw.r.j().ae(i6)) {
                jSONObject.put("network_speed", com.bytedance.sdk.openadsdk.core.v.j.j());
            }
            jSONObject.put("apk_sign", com.bytedance.sdk.openadsdk.core.tl.j.tl());
            jSONObject.put("useful_open_sdk", com.bytedance.sdk.openadsdk.core.xt.j.xt.r.cw().xt());
            jSONObject.put("real_app_name", com.bytedance.sdk.openadsdk.core.tl.j.xt(com.bytedance.sdk.openadsdk.core.v.getContext()));
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    private static void xt(JSONObject jSONObject) {
        try {
            jSONObject.put(bi.f40972o, uf.g());
            jSONObject.put("version_code", uf.oq());
            jSONObject.put("version", uf.qv());
        } catch (Exception unused) {
        }
    }

    private static List<InetAddress> j(NetworkInterface networkInterface) {
        if (networkInterface == null) {
            return Collections.EMPTY_LIST;
        }
        try {
            if (Build.VERSION.SDK_INT < 24) {
                Object j6 = x.j(networkInterface, "java.net.NetworkInterface", "addresses", null);
                if (!(j6 instanceof List)) {
                    return Collections.list(networkInterface.getInetAddresses());
                }
                return (List) j6;
            }
            Object j7 = x.j(networkInterface, "java.net.NetworkInterface", "addrs", null);
            if (!(j7 instanceof InetAddress[])) {
                return Collections.list(networkInterface.getInetAddresses());
            }
            return Arrays.asList((InetAddress[]) j7);
        } catch (Throwable unused) {
            return Collections.list(networkInterface.getInetAddresses());
        }
    }

    private static boolean j(boolean z5, InetAddress inetAddress, String[] strArr) {
        if (z5) {
            try {
                if (!TextUtils.isEmpty(strArr[0])) {
                    return true;
                }
            } catch (Throwable unused) {
                return false;
            }
        }
        if (!z5 && !TextUtils.isEmpty(strArr[1])) {
            return true;
        }
        Class<?> cls = Class.forName("libcore.io.Libcore");
        Field declaredField = cls.getDeclaredField("os");
        declaredField.setAccessible(true);
        Object obj = declaredField.get(cls);
        Method method = obj.getClass().getMethod("getnameinfo", InetAddress.class, Integer.TYPE);
        method.setAccessible(true);
        Object invoke = method.invoke(obj, inetAddress, Integer.valueOf(OsConstants.NI_NUMERICHOST));
        if (invoke == null) {
            return false;
        }
        String str = (String) invoke;
        if (str.startsWith("127")) {
            return true;
        }
        if (z5) {
            strArr[0] = str;
            return true;
        }
        int indexOf = str.indexOf(37);
        if (indexOf >= 0) {
            str = str.substring(0, indexOf);
        }
        if (!cw(str)) {
            return true;
        }
        strArr[1] = str;
        return true;
    }

    private static String j(byte[] bArr) {
        StringBuilder sb = new StringBuilder(39);
        for (int i6 = 0; i6 < 8; i6++) {
            int i7 = i6 << 1;
            sb.append(Integer.toHexString(((bArr[i7] << 8) & MotionEventCompat.ACTION_POINTER_INDEX_MASK) | (bArr[i7 + 1] & 255)));
            if (i6 < 7) {
                sb.append(":");
            }
        }
        return sb.toString();
    }

    public static int j(Context context, boolean z5) {
        if (oq != -1) {
            return oq;
        }
        if (z5) {
            String cw2 = com.bytedance.sdk.openadsdk.core.cw.r.j().cw("dev06", 2592000000L);
            try {
                if (!TextUtils.isEmpty(cw2)) {
                    oq = Integer.parseInt(cw2);
                }
            } catch (Exception unused) {
            }
            if (oq != -1) {
                return oq;
            }
        }
        if (cw(context)) {
            oq = 3;
        } else if (xt(context)) {
            oq = 2;
        } else {
            oq = 1;
        }
        if (z5) {
            com.bytedance.sdk.openadsdk.core.cw.r.j().r("dev06", String.valueOf(oq));
        }
        return oq;
    }

    public static void j(JSONObject jSONObject) throws JSONException {
        if (jy.xt()) {
            jSONObject.putOpt("os_new", j4.f4664a);
            jSONObject.putOpt("harmonyos_api", jy.up());
            jSONObject.putOpt("harmonyos_version", jy.m());
            jSONObject.putOpt("harmonyos_release_type", jy.ae());
            jSONObject.putOpt("harmonyos_build_version", jy.tl());
            jSONObject.putOpt("pure_mode", Integer.valueOf(jy.j(com.bytedance.sdk.openadsdk.core.v.getContext()) ? 1 : 2));
        } else {
            jSONObject.putOpt("os_new", FaceEnvironment.OS);
        }
        jSONObject.putOpt("rom_name", Build.BRAND);
    }

    public static String j(int i6) {
        if (i6 == 0 && !TextUtils.isEmpty(qv) && !j(jy, 60000L)) {
            return qv;
        }
        if (i6 == 1 && !TextUtils.isEmpty(vl) && !j(ws, 60000L)) {
            return vl;
        }
        String r5 = r(i6);
        if (i6 == 0) {
            qv = r5;
            jy = System.currentTimeMillis();
            return r5;
        }
        if (i6 == 1) {
            vl = r5;
            ws = System.currentTimeMillis();
        }
        return r5;
    }

    private static boolean j(long j6, long j7) {
        return System.currentTimeMillis() - j6 > j7;
    }

    public static void j(long j6) {
        if (j6 == -1 || f30134s == j6) {
            return;
        }
        f30134s = j6;
        com.bytedance.sdk.openadsdk.core.cw.r.j().j("dev19", j6);
    }
}
