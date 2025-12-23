package com.autonavi.aps.amapapi.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.SparseArray;
import com.amap.api.col.p0003l.f7;
import com.amap.api.col.p0003l.fk;
import com.amap.api.col.p0003l.g7;
import com.amap.api.col.p0003l.h7;
import com.amap.api.col.p0003l.i7;
import com.amap.api.col.p0003l.v5;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.kwad.components.offline.api.tk.model.report.TKDownloadReason;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public SparseArray<Long> f10269a = new SparseArray<>();

    /* renamed from: b, reason: collision with root package name */
    public int f10270b = -1;

    /* renamed from: c, reason: collision with root package name */
    public long f10271c = 0;

    /* renamed from: d, reason: collision with root package name */
    String[] f10272d = {"ol", "cl", "gl", "ha", "bs", "ds"};

    /* renamed from: e, reason: collision with root package name */
    public int f10273e = -1;

    /* renamed from: f, reason: collision with root package name */
    public long f10274f = -1;

    /* renamed from: i, reason: collision with root package name */
    private static List<h7> f10267i = new ArrayList();

    /* renamed from: j, reason: collision with root package name */
    private static JSONArray f10268j = null;

    /* renamed from: g, reason: collision with root package name */
    static AMapLocation f10265g = null;

    /* renamed from: h, reason: collision with root package name */
    static boolean f10266h = false;

    private static boolean a(AMapLocation aMapLocation) {
        return j.a(aMapLocation) ? !b.a(aMapLocation.getLatitude(), aMapLocation.getLongitude()) : "http://abroad.apilocate.amap.com/mobile/binary".equals(b.f10236c);
    }

    public static void b(Context context, long j6, boolean z5) {
        if (context != null) {
            try {
                if (a.a()) {
                    a(context, j6, z5, "O024");
                }
            } catch (Throwable th) {
                b.a(th, "ReportUtil", "reportCoarseLocUseTime");
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.autonavi.aps.amapapi.utils.h$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f10275a;

        static {
            int[] iArr = new int[AMapLocationClientOption.AMapLocationMode.values().length];
            f10275a = iArr;
            try {
                iArr[AMapLocationClientOption.AMapLocationMode.Battery_Saving.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f10275a[AMapLocationClientOption.AMapLocationMode.Device_Sensors.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f10275a[AMapLocationClientOption.AMapLocationMode.Hight_Accuracy.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private static void f(Context context) {
        try {
            JSONArray jSONArray = f10268j;
            if (jSONArray == null || jSONArray.length() <= 0) {
                return;
            }
            g7.e(new f7(context, b.c(), f10268j.toString()), context);
            f10268j = null;
        } catch (Throwable th) {
            b.a(th, "ReportUtil", "writeOfflineLocLog");
        }
    }

    public final int c(Context context) {
        try {
            long a6 = i.a(context, "pref1", this.f10272d[2], 0L);
            long a7 = i.a(context, "pref1", this.f10272d[0], 0L);
            long a8 = i.a(context, "pref1", this.f10272d[1], 0L);
            if (a6 == 0 && a7 == 0 && a8 == 0) {
                return -1;
            }
            long j6 = a7 - a6;
            long j7 = a8 - a6;
            return a6 > j6 ? a6 > j7 ? 2 : 1 : j6 > j7 ? 0 : 1;
        } catch (Throwable unused) {
            return -1;
        }
    }

    public final int d(Context context) {
        try {
            long a6 = i.a(context, "pref1", this.f10272d[3], 0L);
            long a7 = i.a(context, "pref1", this.f10272d[4], 0L);
            long a8 = i.a(context, "pref1", this.f10272d[5], 0L);
            if (a6 == 0 && a7 == 0 && a8 == 0) {
                return -1;
            }
            return a6 > a7 ? a6 > a8 ? 3 : 5 : a7 > a8 ? 4 : 5;
        } catch (Throwable unused) {
            return -1;
        }
    }

    public final void e(Context context) {
        try {
            SharedPreferences.Editor a6 = i.a(context, "pref1");
            int i6 = 0;
            while (true) {
                String[] strArr = this.f10272d;
                if (i6 >= strArr.length) {
                    i.a(a6);
                    return;
                } else {
                    i.a(a6, strArr[i6], 0L);
                    i6++;
                }
            }
        } catch (Throwable unused) {
        }
    }

    public static void a(Context context, AMapLocation aMapLocation, com.autonavi.aps.amapapi.a aVar) {
        int i6;
        if (aMapLocation == null) {
            return;
        }
        try {
            if (!GeocodeSearch.GPS.equalsIgnoreCase(aMapLocation.getProvider()) && aMapLocation.getLocationType() != 1) {
                String str = "domestic";
                if (a(aMapLocation)) {
                    str = "abroad";
                }
                String str2 = str;
                int errorCode = aMapLocation.getErrorCode();
                String str3 = TKDownloadReason.KSAD_TK_NET;
                if (errorCode != 0) {
                    int errorCode2 = aMapLocation.getErrorCode();
                    if (errorCode2 != 4 && errorCode2 != 5 && errorCode2 != 6 && errorCode2 != 11) {
                        str3 = "cache";
                    }
                    i6 = 0;
                } else {
                    int locationType = aMapLocation.getLocationType();
                    if (locationType != 5 && locationType != 6) {
                        str3 = "cache";
                    }
                    i6 = 1;
                }
                a(context, "O016", str3, str2, i6, aMapLocation.getErrorCode(), aVar);
            }
        } catch (Throwable th) {
            b.a(th, "ReportUtil", "reportBatting");
        }
    }

    public final void b(Context context) {
        try {
            long b6 = j.b() - this.f10271c;
            int i6 = this.f10270b;
            if (i6 != -1) {
                this.f10269a.append(this.f10270b, Long.valueOf(b6 + this.f10269a.get(i6, 0L).longValue()));
            }
            long b7 = j.b() - this.f10274f;
            int i7 = this.f10273e;
            if (i7 != -1) {
                this.f10269a.append(this.f10273e, Long.valueOf(b7 + this.f10269a.get(i7, 0L).longValue()));
            }
            SharedPreferences.Editor a6 = i.a(context, "pref1");
            for (int i8 = 0; i8 < this.f10272d.length; i8++) {
                long longValue = this.f10269a.get(i8, 0L).longValue();
                if (longValue > 0 && longValue > i.a(context, "pref1", this.f10272d[i8], 0L)) {
                    i.a(a6, this.f10272d[i8], longValue);
                }
            }
            i.a(a6);
        } catch (Throwable th) {
            b.a(th, "ReportUtil", "saveLocationTypeAndMode");
        }
    }

    public static void a(Context context, long j6, boolean z5) {
        if (context != null) {
            try {
                if (a.a()) {
                    a(context, j6, z5, "O015");
                }
            } catch (Throwable th) {
                b.a(th, "ReportUtil", "reportGPSLocUseTime");
            }
        }
    }

    private static void a(Context context, long j6, boolean z5, String str) {
        String str2;
        int intValue = Long.valueOf(j6).intValue();
        if (!z5) {
            str2 = "abroad";
        } else {
            str2 = "domestic";
        }
        a(context, str, str2, intValue);
    }

    private static void a(Context context, String str, String str2, String str3, int i6, int i7, com.autonavi.aps.amapapi.a aVar) {
        if (context != null) {
            try {
                if (a.a()) {
                    JSONObject jSONObject = new JSONObject();
                    if (!TextUtils.isEmpty(str2)) {
                        jSONObject.put("param_string_first", str2);
                    }
                    if (!TextUtils.isEmpty(str3)) {
                        jSONObject.put("param_string_second", str3);
                    }
                    if (i6 != Integer.MAX_VALUE) {
                        jSONObject.put("param_int_first", i6);
                    }
                    if (i7 != Integer.MAX_VALUE) {
                        jSONObject.put("param_int_second", i7);
                    }
                    if (aVar != null) {
                        if (!TextUtils.isEmpty(aVar.d())) {
                            jSONObject.put("dns", aVar.d());
                        }
                        if (!TextUtils.isEmpty(aVar.e())) {
                            jSONObject.put("domain", aVar.e());
                        }
                        if (!TextUtils.isEmpty(aVar.f())) {
                            jSONObject.put("type", aVar.f());
                        }
                        if (!TextUtils.isEmpty(aVar.g())) {
                            jSONObject.put(MediationConstant.KEY_REASON, aVar.g());
                        }
                        if (!TextUtils.isEmpty(aVar.c())) {
                            jSONObject.put(IjkMediaPlayer.OnNativeInvokeListener.ARG_IP, aVar.c());
                        }
                        if (!TextUtils.isEmpty(aVar.b())) {
                            jSONObject.put("stack", aVar.b());
                        }
                        if (aVar.h() > 0) {
                            jSONObject.put("ctime", String.valueOf(aVar.h()));
                        }
                        if (aVar.a() > 0) {
                            jSONObject.put("ntime", String.valueOf(aVar.a()));
                        }
                    }
                    a(context, str, jSONObject);
                }
            } catch (Throwable th) {
                b.a(th, "ReportUtil", "applyStatisticsEx");
            }
        }
    }

    private static void a(Context context, String str, String str2, int i6) {
        if (context != null) {
            try {
                if (a.a()) {
                    JSONObject jSONObject = new JSONObject();
                    if (!TextUtils.isEmpty(str2)) {
                        jSONObject.put("param_string_first", str2);
                    }
                    if (!TextUtils.isEmpty(null)) {
                        jSONObject.put("param_string_second", (Object) null);
                    }
                    if (i6 != Integer.MAX_VALUE) {
                        jSONObject.put("param_int_first", i6);
                    }
                    a(context, str, jSONObject);
                }
            } catch (Throwable th) {
                b.a(th, "ReportUtil", "applyStatisticsEx");
            }
        }
    }

    public static synchronized void a(Context context, String str, JSONObject jSONObject) {
        synchronized (h.class) {
            if (context != null) {
                try {
                    if (a.a()) {
                        h7 h7Var = new h7(context, "loc", "6.4.3", str);
                        if (jSONObject != null) {
                            h7Var.a(jSONObject.toString());
                        }
                        f10267i.add(h7Var);
                        if (f10267i.size() >= 30) {
                            ArrayList arrayList = new ArrayList();
                            arrayList.addAll(f10267i);
                            i7.h(arrayList, context);
                            f10267i.clear();
                        }
                    }
                } catch (Throwable th) {
                    b.a(th, "ReportUtil", "applyStatistics");
                }
            }
        }
    }

    public static synchronized void a(Context context) {
        synchronized (h.class) {
            if (context != null) {
                try {
                    if (a.a()) {
                        List<h7> list = f10267i;
                        if (list != null && list.size() > 0) {
                            ArrayList arrayList = new ArrayList();
                            arrayList.addAll(f10267i);
                            i7.h(arrayList, context);
                            f10267i.clear();
                        }
                        f(context);
                    }
                } catch (Throwable th) {
                    b.a(th, "ReportUtil", "destroy");
                }
            }
        }
    }

    public static void a(String str, String str2) {
        try {
            v5.o(b.c(), str2, str);
        } catch (Throwable th) {
            b.a(th, "ReportUtil", "reportLog");
        }
    }

    public final void a(Context context, int i6) {
        try {
            int i7 = this.f10270b;
            if (i7 == i6) {
                return;
            }
            if (i7 != -1 && i7 != i6) {
                this.f10269a.append(this.f10270b, Long.valueOf((j.b() - this.f10271c) + this.f10269a.get(this.f10270b, 0L).longValue()));
            }
            this.f10271c = j.b() - i.a(context, "pref1", this.f10272d[i6], 0L);
            this.f10270b = i6;
        } catch (Throwable th) {
            b.a(th, "ReportUtil", "setLocationType");
        }
    }

    public final void a(Context context, AMapLocationClientOption aMapLocationClientOption) {
        int i6;
        try {
            int i7 = AnonymousClass1.f10275a[aMapLocationClientOption.getLocationMode().ordinal()];
            if (i7 == 1) {
                i6 = 4;
            } else if (i7 != 2) {
                i6 = 3;
                if (i7 != 3) {
                    i6 = -1;
                }
            } else {
                i6 = 5;
            }
            int i8 = this.f10273e;
            if (i8 == i6) {
                return;
            }
            if (i8 != -1 && i8 != i6) {
                this.f10269a.append(this.f10273e, Long.valueOf((j.b() - this.f10274f) + this.f10269a.get(this.f10273e, 0L).longValue()));
            }
            this.f10274f = j.b() - i.a(context, "pref1", this.f10272d[i6], 0L);
            this.f10273e = i6;
        } catch (Throwable th) {
            b.a(th, "ReportUtil", "setLocationMode");
        }
    }

    public static void a(Context context, int i6, int i7, long j6, long j7) {
        if (i6 == -1 || i7 == -1) {
            return;
        }
        try {
            a(context, "O012", i6, i7, j6, j7);
        } catch (Throwable th) {
            b.a(th, "ReportUtil", "reportServiceAliveTime");
        }
    }

    private static void a(Context context, String str, int i6, int i7, long j6, long j7) {
        if (context != null) {
            try {
                if (a.a()) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("param_int_first", i6);
                    jSONObject.put("param_int_second", i7);
                    jSONObject.put("param_long_first", j6);
                    jSONObject.put("param_long_second", j7);
                    a(context, str, jSONObject);
                }
            } catch (Throwable th) {
                b.a(th, "ReportUtil", "applyStatisticsEx");
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0035 A[Catch: all -> 0x0054, TRY_LEAVE, TryCatch #0 {all -> 0x0054, blocks: (B:4:0x0003, B:9:0x000b, B:21:0x0035, B:31:0x0048, B:33:0x004c, B:34:0x0057, B:36:0x0090, B:38:0x009d, B:39:0x00de, B:41:0x00f0, B:43:0x0096), top: B:3:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static synchronized void a(android.content.Context r8, com.amap.api.location.AMapLocation r9) {
        /*
            Method dump skipped, instructions count: 257
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.aps.amapapi.utils.h.a(android.content.Context, com.amap.api.location.AMapLocation):void");
    }

    private static String a(int i6) {
        if (i6 == 2011) {
            return "ContextIsNull";
        }
        if (i6 == 2031) {
            return "CreateApsReqException";
        }
        if (i6 == 2041) {
            return "ResponseResultIsNull";
        }
        if (i6 == 2081) {
            return "LocalLocException";
        }
        if (i6 == 2091) {
            return "InitException";
        }
        if (i6 == 2111) {
            return "ErrorCgiInfo";
        }
        if (i6 == 2121) {
            return "NotLocPermission";
        }
        if (i6 == 2141) {
            return "NoEnoughStatellites";
        }
        if (i6 == 2021) {
            return "OnlyMainWifi";
        }
        if (i6 == 2022) {
            return "OnlyOneWifiButNotMain";
        }
        if (i6 == 2061) {
            return "ServerRetypeError";
        }
        if (i6 != 2062) {
            switch (i6) {
                case 2051:
                    return "NeedLoginNetWork\t";
                case 2052:
                    return "MaybeIntercepted";
                case 2053:
                    return "DecryptResponseException";
                case 2054:
                    return "ParserDataException";
                default:
                    switch (i6) {
                        case AMapException.CODE_AMAP_NEARBY_KEY_NOT_BIND /* 2101 */:
                            return "BindAPSServiceException";
                        case 2102:
                            return "AuthClientScodeFail";
                        case 2103:
                            return "NotConfigAPSService";
                        default:
                            switch (i6) {
                                case 2131:
                                    return "NoCgiOAndWifiInfo";
                                case 2132:
                                    return "AirPlaneModeAndWifiOff";
                                case 2133:
                                    return "NoCgiAndWifiOff";
                                default:
                                    switch (i6) {
                                        case 2151:
                                            return "MaybeMockNetLoc";
                                        case 2152:
                                            return "MaybeMockGPSLoc";
                                        case 2153:
                                            return "UNSUPPORT_COARSE_LBSLOC";
                                        case 2154:
                                            return "UNSUPPORT_CONTINUE_LOC";
                                        default:
                                            return "";
                                    }
                            }
                    }
            }
        }
        return "ServerLocFail";
    }

    public static void a(String str, int i6) {
        a(str, String.valueOf(i6), a(i6));
    }

    public static void a(String str, String str2, String str3) {
        try {
            v5.k(b.c(), "/mobile/binary", str3, str, str2);
        } catch (Throwable unused) {
        }
    }

    public static void a(String str, Throwable th) {
        try {
            if (th instanceof fk) {
                v5.j(b.c(), str, (fk) th);
            }
        } catch (Throwable unused) {
        }
    }

    public static void a(AMapLocation aMapLocation, AMapLocation aMapLocation2) {
        try {
            if (f10265g == null) {
                if (!j.a(aMapLocation)) {
                    f10265g = aMapLocation2;
                    return;
                }
                f10265g = aMapLocation.m45clone();
            }
            if (j.a(f10265g) && j.a(aMapLocation2)) {
                AMapLocation m45clone = aMapLocation2.m45clone();
                if (f10265g.getLocationType() != 1 && f10265g.getLocationType() != 9 && !GeocodeSearch.GPS.equalsIgnoreCase(f10265g.getProvider()) && f10265g.getLocationType() != 7 && m45clone.getLocationType() != 1 && m45clone.getLocationType() != 9 && !GeocodeSearch.GPS.equalsIgnoreCase(m45clone.getProvider()) && m45clone.getLocationType() != 7) {
                    long abs = Math.abs(m45clone.getTime() - f10265g.getTime()) / 1000;
                    if (abs <= 0) {
                        abs = 1;
                    }
                    if (abs <= 1800) {
                        float a6 = j.a(f10265g, m45clone);
                        float f6 = a6 / abs;
                        if (a6 > 30000.0f && f6 > 1000.0f) {
                            StringBuilder sb = new StringBuilder();
                            sb.append(f10265g.getLatitude());
                            sb.append(",");
                            sb.append(f10265g.getLongitude());
                            sb.append(",");
                            sb.append(f10265g.getAccuracy());
                            sb.append(",");
                            sb.append(f10265g.getLocationType());
                            sb.append(",");
                            if (aMapLocation.getTime() != 0) {
                                sb.append(j.a(f10265g.getTime(), "yyyyMMdd_HH:mm:ss:SS"));
                            } else {
                                sb.append(f10265g.getTime());
                            }
                            sb.append("#");
                            sb.append(m45clone.getLatitude());
                            sb.append(",");
                            sb.append(m45clone.getLongitude());
                            sb.append(",");
                            sb.append(m45clone.getAccuracy());
                            sb.append(",");
                            sb.append(m45clone.getLocationType());
                            sb.append(",");
                            if (m45clone.getTime() != 0) {
                                sb.append(j.a(m45clone.getTime(), "yyyyMMdd_HH:mm:ss:SS"));
                            } else {
                                sb.append(m45clone.getTime());
                            }
                            a("bigshiftstatistics", sb.toString());
                            sb.delete(0, sb.length());
                        }
                    }
                }
                f10265g = m45clone;
            }
        } catch (Throwable unused) {
        }
    }

    public static void a(long j6, long j7) {
        try {
            if (f10266h) {
                return;
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("gpsTime:");
            stringBuffer.append(j.a(j6, "yyyy-MM-dd HH:mm:ss.SSS"));
            stringBuffer.append(",");
            stringBuffer.append("sysTime:");
            stringBuffer.append(j.a(j7, "yyyy-MM-dd HH:mm:ss.SSS"));
            stringBuffer.append(",");
            long u5 = a.u();
            String str = "0";
            if (0 != u5) {
                str = j.a(u5, "yyyy-MM-dd HH:mm:ss.SSS");
            }
            stringBuffer.append("serverTime:");
            stringBuffer.append(str);
            a("checkgpstime", stringBuffer.toString());
            if (0 != u5 && Math.abs(j6 - u5) < 31536000000L) {
                stringBuffer.append(", correctError");
                a("checkgpstimeerror", stringBuffer.toString());
            }
            stringBuffer.delete(0, stringBuffer.length());
            f10266h = true;
        } catch (Throwable unused) {
        }
    }
}
