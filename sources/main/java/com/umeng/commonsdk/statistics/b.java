package com.umeng.commonsdk.statistics;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Base64;
import com.stub.StubApp;
import com.umeng.analytics.pro.bi;
import com.umeng.analytics.pro.ca;
import com.umeng.analytics.pro.d;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.framework.UMFrUtils;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.statistics.common.DataHelper;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.statistics.common.ULog;
import com.umeng.commonsdk.statistics.idtracking.Envelope;
import com.umeng.commonsdk.statistics.idtracking.e;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import com.umeng.commonsdk.utils.UMUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public static String f41874a = null;

    /* renamed from: b, reason: collision with root package name */
    public static String f41875b = "";

    /* renamed from: c, reason: collision with root package name */
    private static final String f41876c = "EnvelopeManager";

    /* renamed from: d, reason: collision with root package name */
    private static final String f41877d = "debug.umeng.umTaskId";

    /* renamed from: e, reason: collision with root package name */
    private static final String f41878e = "debug.umeng.umCaseId";

    /* renamed from: f, reason: collision with root package name */
    private static final String f41879f = "empty";

    /* renamed from: g, reason: collision with root package name */
    private static String f41880g = "";

    /* renamed from: h, reason: collision with root package name */
    private static String f41881h = "";

    /* renamed from: i, reason: collision with root package name */
    private static String f41882i;

    /* renamed from: j, reason: collision with root package name */
    private static Map<String, String> f41883j;

    /* renamed from: l, reason: collision with root package name */
    private static boolean f41884l;

    /* renamed from: k, reason: collision with root package name */
    private int f41885k = 0;

    public static String a(String str) {
        return f41883j.containsKey(str) ? f41883j.get(str) : str;
    }

    private static boolean b() {
        f41880g = UMUtils.getSystemProperty(f41877d, "");
        f41881h = UMUtils.getSystemProperty(f41878e, "");
        return (!TextUtils.isEmpty(f41880g) && !f41879f.equals(f41880g)) && (!TextUtils.isEmpty(f41881h) && !f41879f.equals(f41881h));
    }

    static {
        HashMap hashMap = new HashMap();
        f41883j = hashMap;
        hashMap.put("header", "#h");
        f41883j.put("sdk_type", "#sdt");
        f41883j.put(bi.Q, "#ac");
        f41883j.put("device_model", "#dm");
        f41883j.put("umid", "#umid");
        f41883j.put("os", "os");
        f41883j.put("language", "#lang");
        f41883j.put(bi.ai, "#dt");
        f41883j.put("resolution", "#rl");
        f41883j.put(bi.H, "#dmf");
        f41883j.put(bi.J, "#dn");
        f41883j.put("platform_version", "#pv");
        f41883j.put("font_size_setting", "#fss");
        f41883j.put("os_version", "#ov");
        f41883j.put(bi.I, "#did");
        f41883j.put("platform_sdk_version", "#psv");
        f41883j.put(bi.F, "#db");
        f41883j.put("appkey", "#ak");
        f41883j.put(bi.Y, "#itr");
        f41883j.put("id_type", "#it");
        f41883j.put("uuid", "#ud");
        f41883j.put("device_id", "#dd");
        f41883j.put(bi.X, "#imp");
        f41883j.put("sdk_version", "#sv");
        f41883j.put("st", "#st");
        f41883j.put("analytics", "#a");
        f41883j.put(bi.f40972o, "#pkg");
        f41883j.put(bi.f40973p, "#sig");
        f41883j.put(bi.f40974q, "#sis1");
        f41883j.put(bi.f40975r, "#sis");
        f41883j.put("app_version", "#av");
        f41883j.put("version_code", "#vc");
        f41883j.put(bi.f40979v, "#imd");
        f41883j.put(bi.B, "#mnc");
        f41883j.put(bi.E, "#boa");
        f41883j.put(bi.G, "#mant");
        f41883j.put(bi.M, "#tz");
        f41883j.put("country", "#ct");
        f41883j.put(bi.P, "#car");
        f41883j.put("display_name", "#disn");
        f41883j.put(bi.T, "#nt");
        f41883j.put(bi.f40959b, "#cv");
        f41883j.put(bi.f40961d, "#mv");
        f41883j.put(bi.f40960c, "#cot");
        f41883j.put(bi.f40962e, "#mod");
        f41883j.put(bi.aj, "#al");
        f41883j.put("session_id", "#sid");
        f41883j.put(bi.S, "#ip");
        f41883j.put(bi.U, "#sre");
        f41883j.put(bi.V, "#fre");
        f41883j.put(bi.W, "#ret");
        f41883j.put("channel", "#chn");
        f41883j.put("wrapper_type", "#wt");
        f41883j.put("wrapper_version", "#wv");
        f41883j.put(bi.aY, "#tsv");
        f41883j.put(bi.aZ, "#rps");
        f41883j.put(bi.bc, "#mov");
        f41883j.put(d.f41190i, "#vt");
        f41883j.put("secret", "#sec");
        f41883j.put(d.an, "#prv");
        f41883j.put(d.f41193l, "#$prv");
        f41883j.put(d.f41194m, "#uda");
        f41883j.put(bi.f40958a, "#tok");
        f41883j.put(bi.aQ, "#iv");
        f41883j.put(bi.R, "#ast");
        f41883j.put("backstate", "#bst");
        f41883j.put("zdata_ver", "#zv");
        f41883j.put("zdata_req_ts", "#zrt");
        f41883j.put("app_b_v", "#bv");
        f41883j.put("zdata", "#zta");
        f41883j.put(bi.ap, "#mt");
        f41883j.put(bi.am, "#zsv");
        f41883j.put(bi.ao, "#oos");
    }

    public static void a() {
        if (f41882i != null) {
            f41882i = null;
            e.a();
        }
    }

    public JSONObject b(Context context, JSONObject jSONObject, JSONObject jSONObject2, String str) {
        Context context2;
        Throwable th;
        Envelope envelope;
        try {
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put(a("header"), new JSONObject());
            try {
                if (b()) {
                    jSONObject.put("umTaskId", f41880g);
                    jSONObject.put("umCaseId", f41881h);
                }
            } catch (Throwable unused) {
            }
            if (jSONObject != null) {
                try {
                    jSONObject3 = a(jSONObject3, jSONObject);
                } catch (Throwable th2) {
                    th = th2;
                    context2 = context;
                    UMCrashManager.reportCrash(context2, th);
                    return a(110, new JSONObject());
                }
            }
            if (jSONObject3 != null && jSONObject2 != null) {
                Iterator<String> keys = jSONObject2.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    if (next != null && (next instanceof String)) {
                        String str2 = next;
                        if (jSONObject2.opt(str2) != null) {
                            try {
                                jSONObject3.put(str2, jSONObject2.opt(str2));
                            } catch (Exception unused2) {
                            }
                        }
                    }
                }
            }
            if (jSONObject3 != null && DataHelper.largeThanMaxSize(jSONObject3.toString().getBytes().length, DataHelper.ENVELOPE_ENTITY_RAW_LENGTH_MAX)) {
                SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(context);
                if (sharedPreferences != null) {
                    sharedPreferences.edit().putInt("serial", sharedPreferences.getInt("serial", 1) + 1).commit();
                }
                return a(113, jSONObject3);
            }
            if (jSONObject3 != null) {
                envelope = a(context, jSONObject3.toString().getBytes());
                if (envelope == null) {
                    return a(111, jSONObject3);
                }
            } else {
                envelope = null;
            }
            Envelope envelope2 = envelope;
            if (envelope2 != null && DataHelper.largeThanMaxSize(envelope2.toBinary().length, DataHelper.ENVELOPE_LENGTH_MAX)) {
                return a(114, jSONObject3);
            }
            context2 = context;
            try {
                int a6 = a(context2, envelope2, "z==1.2.0", DeviceConfig.getAppVersionName(context), str);
                if (a6 != 0) {
                    return a(a6, jSONObject3);
                }
                if (ULog.DEBUG) {
                    int length = jSONObject3.toString().getBytes().length;
                }
                return jSONObject3;
            } catch (Throwable th3) {
                th = th3;
                th = th;
                UMCrashManager.reportCrash(context2, th);
                return a(110, new JSONObject());
            }
        } catch (Throwable th4) {
            th = th4;
            context2 = context;
        }
    }

    public static long a(Context context) {
        long j6 = DataHelper.ENVELOPE_ENTITY_RAW_LENGTH_MAX - DataHelper.ENVELOPE_EXTRA_LENGTH;
        boolean z5 = ULog.DEBUG;
        return j6;
    }

    private JSONObject a(int i6, JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                jSONObject.put("exception", i6);
            } catch (Exception unused) {
            }
            return jSONObject;
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("exception", i6);
        } catch (Exception unused2) {
        }
        return jSONObject2;
    }

    public JSONObject a(Context context, JSONObject jSONObject, JSONObject jSONObject2, String str, String str2, String str3) {
        JSONObject jSONObject3;
        String str4;
        Envelope envelope;
        JSONObject optJSONObject;
        if (ULog.DEBUG && jSONObject != null && jSONObject2 != null) {
            int length = jSONObject.toString().getBytes().length;
            int length2 = jSONObject2.toString().getBytes().length;
        }
        if (context != null && jSONObject2 != null) {
            try {
                boolean z5 = jSONObject2.has("analytics") && (optJSONObject = jSONObject2.optJSONObject("analytics")) != null && optJSONObject.has(d.f41195n);
                String str5 = str2;
                JSONObject a6 = a(context, str5, z5);
                if (a6 != null && jSONObject != null) {
                    a6 = a(a6, jSONObject);
                }
                JSONObject jSONObject4 = a6;
                if (jSONObject4 != null) {
                    Iterator<String> keys = jSONObject2.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        if (next != null && (next instanceof String)) {
                            String str6 = next;
                            if (jSONObject2.opt(str6) != null) {
                                try {
                                    jSONObject4.put(a(str6), jSONObject2.opt(str6));
                                } catch (Exception unused) {
                                }
                            }
                        }
                    }
                }
                if (TextUtils.isEmpty(str5)) {
                    str5 = "u";
                }
                String str7 = TextUtils.isEmpty(str3) ? "1.0.0" : str3;
                if (jSONObject4 != null) {
                    str4 = str5 + "==" + str7 + "&=";
                    if (TextUtils.isEmpty(str4)) {
                        return a(101, jSONObject4);
                    }
                    if (str4.endsWith("&=")) {
                        str4 = str4.substring(0, str4.length() - 2);
                    }
                } else {
                    str4 = null;
                }
                if (jSONObject4 != null) {
                    try {
                        e a7 = e.a(context);
                        if (a7 != null) {
                            a7.b();
                            String encodeToString = Base64.encodeToString(new ca().a(a7.c()), 0);
                            if (!TextUtils.isEmpty(encodeToString)) {
                                JSONObject jSONObject5 = jSONObject4.getJSONObject(a("header"));
                                jSONObject5.put(a(bi.Y), encodeToString);
                                jSONObject4.put(a("header"), jSONObject5);
                            }
                        }
                    } catch (Exception unused2) {
                    }
                }
                if (jSONObject4 != null && DataHelper.largeThanMaxSize(jSONObject4.toString().getBytes().length, DataHelper.ENVELOPE_ENTITY_RAW_LENGTH_MAX)) {
                    SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(context);
                    if (sharedPreferences != null) {
                        sharedPreferences.edit().putInt("serial", sharedPreferences.getInt("serial", 1) + 1).commit();
                    }
                    return a(113, jSONObject4);
                }
                if (jSONObject4 != null) {
                    Envelope a8 = a(context, jSONObject4.toString().getBytes());
                    if (a8 == null) {
                        return a(111, jSONObject4);
                    }
                    envelope = a8;
                } else {
                    envelope = null;
                }
                if (envelope != null && DataHelper.largeThanMaxSize(envelope.toBinary().length, DataHelper.ENVELOPE_LENGTH_MAX)) {
                    return a(114, jSONObject4);
                }
                int a9 = a(context, envelope, str4, jSONObject4 != null ? jSONObject4.optJSONObject(a("header")).optString(a("app_version")) : null, str);
                if (a9 != 0) {
                    return a(a9, jSONObject4);
                }
                if (ULog.DEBUG) {
                    int length3 = jSONObject4.toString().getBytes().length;
                }
                if (!str4.startsWith(bi.aG) && !str4.startsWith("i") && !str4.startsWith(bi.aL) && !str4.startsWith("a") && !com.umeng.commonsdk.stateless.b.a()) {
                    new com.umeng.commonsdk.stateless.b(context);
                    com.umeng.commonsdk.stateless.b.b();
                }
                return jSONObject4;
            } catch (Throwable th) {
                UMCrashManager.reportCrash(context, th);
                if (jSONObject != null) {
                    try {
                        JSONObject jSONObject6 = new JSONObject();
                        try {
                            jSONObject6.put("header", jSONObject);
                        } catch (JSONException unused3) {
                        } catch (Exception e6) {
                            e = e6;
                            jSONObject3 = jSONObject6;
                            UMCrashManager.reportCrash(context, e);
                            return a(110, jSONObject3);
                        }
                        jSONObject3 = jSONObject6;
                    } catch (Exception e7) {
                        e = e7;
                        jSONObject3 = null;
                    }
                } else {
                    jSONObject3 = null;
                }
                if (jSONObject3 == null) {
                    try {
                        jSONObject3 = new JSONObject();
                    } catch (Exception e8) {
                        e = e8;
                        UMCrashManager.reportCrash(context, e);
                        return a(110, jSONObject3);
                    }
                }
                Iterator<String> keys2 = jSONObject2.keys();
                while (keys2.hasNext()) {
                    String next2 = keys2.next();
                    if (next2 != null && (next2 instanceof String)) {
                        String str8 = next2;
                        if (jSONObject2.opt(str8) != null) {
                            try {
                                jSONObject3.put(str8, jSONObject2.opt(str8));
                            } catch (Exception unused4) {
                            }
                        }
                    }
                }
                return a(110, jSONObject3);
            }
        }
        return a(110, (JSONObject) null);
    }

    private static int[] b(Context context) {
        int[] iArr = new int[3];
        try {
            SharedPreferences sharedPreferences = StubApp.getOrigApplicationContext(context.getApplicationContext()).getSharedPreferences(com.umeng.commonsdk.internal.c.f41776a, 0);
            if (sharedPreferences != null) {
                iArr[0] = sharedPreferences.getInt(com.umeng.commonsdk.internal.c.f41777b, 0);
                iArr[1] = sharedPreferences.getInt(com.umeng.commonsdk.internal.c.f41778c, 0);
                iArr[2] = sharedPreferences.getInt("policyGrantResult", 0);
            }
        } catch (Throwable unused) {
        }
        return iArr;
    }

    public JSONObject a(Context context, JSONObject jSONObject, JSONObject jSONObject2, String str) {
        Context context2;
        Throwable th;
        Envelope envelope;
        try {
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put(a("header"), new JSONObject());
            if (jSONObject != null) {
                try {
                    jSONObject3 = a(jSONObject3, jSONObject);
                } catch (Throwable th2) {
                    th = th2;
                    context2 = context;
                    UMCrashManager.reportCrash(context2, th);
                    return a(110, new JSONObject());
                }
            }
            if (jSONObject3 != null && jSONObject2 != null) {
                Iterator<String> keys = jSONObject2.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    if (next != null && (next instanceof String)) {
                        String str2 = next;
                        if (jSONObject2.opt(str2) != null) {
                            try {
                                jSONObject3.put(str2, jSONObject2.opt(str2));
                            } catch (Exception unused) {
                            }
                        }
                    }
                }
            }
            if (jSONObject3 != null && DataHelper.largeThanMaxSize(jSONObject3.toString().getBytes().length, DataHelper.ENVELOPE_ENTITY_RAW_LENGTH_MAX)) {
                SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(context);
                if (sharedPreferences != null) {
                    sharedPreferences.edit().putInt("serial", sharedPreferences.getInt("serial", 1) + 1).commit();
                }
                return a(113, jSONObject3);
            }
            if (jSONObject3 != null) {
                envelope = a(context, jSONObject3.toString().getBytes());
                if (envelope == null) {
                    return a(111, jSONObject3);
                }
            } else {
                envelope = null;
            }
            Envelope envelope2 = envelope;
            if (envelope2 != null && DataHelper.largeThanMaxSize(envelope2.toBinary().length, DataHelper.ENVELOPE_LENGTH_MAX)) {
                return a(114, jSONObject3);
            }
            context2 = context;
            try {
                int a6 = a(context2, envelope2, "h==1.2.0", "", str);
                if (a6 != 0) {
                    return a(a6, jSONObject3);
                }
                if (ULog.DEBUG) {
                    int length = jSONObject3.toString().getBytes().length;
                }
                return jSONObject3;
            } catch (Throwable th3) {
                th = th3;
                th = th;
                UMCrashManager.reportCrash(context2, th);
                return a(110, new JSONObject());
            }
        } catch (Throwable th4) {
            th = th4;
            context2 = context;
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:95:0x03fd
        	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1179)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.collectHandlerRegions(ExcHandlersRegionMaker.java:53)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.process(ExcHandlersRegionMaker.java:38)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:27)
        */
    /* JADX WARN: Type inference failed for: r13v1 */
    /* JADX WARN: Type inference failed for: r13v19 */
    /* JADX WARN: Type inference failed for: r13v2, types: [java.lang.String, org.json.JSONObject] */
    private static org.json.JSONObject a(android.content.Context r17, java.lang.String r18, boolean r19) {
        /*
            Method dump skipped, instructions count: 1541
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.statistics.b.a(android.content.Context, java.lang.String, boolean):org.json.JSONObject");
    }

    private JSONObject a(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject != null && jSONObject2 != null && jSONObject.opt(a("header")) != null && (jSONObject.opt(a("header")) instanceof JSONObject)) {
            JSONObject jSONObject3 = (JSONObject) jSONObject.opt(a("header"));
            Iterator<String> keys = jSONObject2.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (next != null && (next instanceof String)) {
                    String str = next;
                    if (jSONObject2.opt(str) != null) {
                        try {
                            jSONObject3.put(str, jSONObject2.opt(str));
                            if (str.equals(a(d.f41190i)) && (jSONObject2.opt(str) instanceof Integer)) {
                                this.f41885k = ((Integer) jSONObject2.opt(str)).intValue();
                            }
                        } catch (Exception unused) {
                        }
                    }
                }
            }
        }
        return jSONObject;
    }

    private Envelope a(Context context, byte[] bArr) {
        String imprintProperty = UMEnvelopeBuild.imprintProperty(context, "codex", null);
        int i6 = -1;
        try {
            if (!TextUtils.isEmpty(imprintProperty)) {
                i6 = Integer.valueOf(imprintProperty).intValue();
            }
        } catch (NumberFormatException e6) {
            UMCrashManager.reportCrash(context, e6);
        }
        if (i6 == 0) {
            return Envelope.genEnvelope(context, UMUtils.getAppkey(context), bArr);
        }
        if (i6 == 1) {
            return Envelope.genEncryptEnvelope(context, UMUtils.getAppkey(context), bArr);
        }
        if (f41884l) {
            return Envelope.genEncryptEnvelope(context, UMUtils.getAppkey(context), bArr);
        }
        return Envelope.genEnvelope(context, UMUtils.getAppkey(context), bArr);
    }

    private int a(Context context, Envelope envelope, String str, String str2, String str3) {
        if (context == null || envelope == null || TextUtils.isEmpty(str)) {
            return 101;
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = DeviceConfig.getAppVersionName(context);
        }
        String b6 = com.umeng.commonsdk.stateless.d.b(str3);
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append("&&");
        sb.append(str2);
        sb.append("_");
        sb.append(System.currentTimeMillis());
        sb.append("_");
        sb.append(b6);
        sb.append(".log");
        byte[] binary = envelope.toBinary();
        if (com.umeng.commonsdk.utils.c.a()) {
            if (str.startsWith("h")) {
                return UMFrUtils.saveEnvelopeFile(context, sb.toString(), binary);
            }
            return 122;
        }
        if (str.startsWith("h")) {
            return 122;
        }
        if (!str.startsWith(bi.aG) && !str.startsWith("i") && !str.startsWith("a") && !str.startsWith(bi.aL)) {
            return com.umeng.commonsdk.stateless.d.a(context, com.umeng.commonsdk.stateless.a.f41846f, sb.toString(), binary);
        }
        return UMFrUtils.saveEnvelopeFile(context, sb.toString(), binary);
    }

    public static void a(boolean z5) {
        f41884l = z5;
    }
}
