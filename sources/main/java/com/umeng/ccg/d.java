package com.umeng.ccg;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.umeng.analytics.pro.aa;
import com.umeng.analytics.pro.ab;
import com.umeng.analytics.pro.ac;
import com.umeng.analytics.pro.ad;
import com.umeng.analytics.pro.ae;
import com.umeng.analytics.pro.af;
import com.umeng.analytics.pro.ah;
import com.umeng.analytics.pro.aj;
import com.umeng.analytics.pro.ap;
import com.umeng.analytics.pro.ar;
import com.umeng.analytics.pro.at;
import com.umeng.analytics.pro.au;
import com.umeng.analytics.pro.z;
import com.umeng.ccg.c;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.service.UMGlobalContext;
import com.umeng.commonsdk.statistics.common.HelperUtils;
import com.umeng.commonsdk.statistics.idtracking.ImprintHandler;
import com.umeng.commonsdk.statistics.internal.UMImprintChangeCallback;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class d implements c.a {

    /* renamed from: a, reason: collision with root package name */
    private static final String f41571a = "iucc";

    /* renamed from: b, reason: collision with root package name */
    private static final String f41572b = au.b().b(au.C);

    /* renamed from: c, reason: collision with root package name */
    private static JSONObject f41573c = null;

    /* renamed from: d, reason: collision with root package name */
    private static final String[] f41574d = {com.umeng.ccg.a.f41530f, com.umeng.ccg.a.f41531g, com.umeng.ccg.a.f41532h};

    /* renamed from: e, reason: collision with root package name */
    private static ArrayList<aa> f41575e = null;

    /* renamed from: f, reason: collision with root package name */
    private static ArrayList<aa> f41576f = null;

    /* renamed from: g, reason: collision with root package name */
    private static ArrayList<aa> f41577g = null;

    /* renamed from: j, reason: collision with root package name */
    private static c f41578j = new c();

    /* renamed from: h, reason: collision with root package name */
    private volatile String f41579h = "";

    /* renamed from: i, reason: collision with root package name */
    private Map<String, a> f41580i = new HashMap();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class a {

        /* renamed from: b, reason: collision with root package name */
        private JSONArray f41583b;

        /* renamed from: c, reason: collision with root package name */
        private String f41584c;

        public a(JSONArray jSONArray, String str) {
            this.f41583b = jSONArray;
            this.f41584c = str;
        }

        public JSONArray a() {
            return this.f41583b;
        }

        public String b() {
            return this.f41584c;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class b {

        /* renamed from: a, reason: collision with root package name */
        private static final d f41585a = new d();

        private b() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class c extends BroadcastReceiver {
        public boolean b(ArrayList<aa> arrayList) {
            if (arrayList == null || arrayList.size() <= 0) {
                return false;
            }
            for (int i6 = 0; i6 < arrayList.size(); i6++) {
                if (arrayList.get(i6).b()) {
                    return false;
                }
            }
            return true;
        }

        public long a(ArrayList<aa> arrayList) {
            if (arrayList == null || arrayList.size() <= 0) {
                return 0L;
            }
            for (int i6 = 0; i6 < arrayList.size(); i6++) {
                aa aaVar = arrayList.get(i6);
                if (aaVar instanceof ac) {
                    return ((ac) aaVar).c();
                }
            }
            return 0L;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            try {
                String action = intent.getAction();
                if (!TextUtils.isEmpty(action)) {
                    if (action.equals("android.intent.action.SCREEN_ON")) {
                        UMRTLog.i(UMRTLog.RTLOG_TAG, "recv intent : ACTION_SCREEN_ON");
                        if (b(d.f41575e)) {
                            UMRTLog.i(UMRTLog.RTLOG_TAG, "report screen_on event.");
                            com.umeng.ccg.c.a(UMGlobalContext.getAppContext(), 301, d.a(), null, a(d.f41575e) * 1000);
                        } else {
                            UMRTLog.i(UMRTLog.RTLOG_TAG, "don't report screen_on event.");
                        }
                    }
                    if (action.equals("android.intent.action.SCREEN_OFF")) {
                        UMRTLog.i(UMRTLog.RTLOG_TAG, "recv intent : ACTION_SCREEN_OFF");
                        if (b(d.f41576f)) {
                            UMRTLog.i(UMRTLog.RTLOG_TAG, "report screen_off event.");
                            com.umeng.ccg.c.a(UMGlobalContext.getAppContext(), 302, d.a(), null, a(d.f41576f) * 1000);
                        } else {
                            UMRTLog.i(UMRTLog.RTLOG_TAG, "don't report screen_off event.");
                        }
                    }
                    if (action.equals("android.intent.action.USER_PRESENT")) {
                        UMRTLog.i(UMRTLog.RTLOG_TAG, "recv intent : ACTION_USER_PRESENT");
                        if (b(d.f41577g)) {
                            UMRTLog.i(UMRTLog.RTLOG_TAG, "report screen_unlock event.");
                            com.umeng.ccg.c.a(UMGlobalContext.getAppContext(), 303, d.a(), null, a(d.f41577g) * 1000);
                            return;
                        }
                        UMRTLog.i(UMRTLog.RTLOG_TAG, "don't report screen_unlock event.");
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static void a(Context context, String str) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(str);
        context.registerReceiver(f41578j, intentFilter);
    }

    private String e(Context context) {
        try {
            SharedPreferences a6 = ar.a(context);
            if (a6 != null) {
                return a6.getString(ar.f40888e, "");
            }
        } catch (Throwable unused) {
        }
        return "";
    }

    private long b(JSONObject jSONObject) {
        if (jSONObject == null || !jSONObject.has("ts")) {
            return 0L;
        }
        try {
            return jSONObject.optLong("ts");
        } catch (Throwable unused) {
            return 0L;
        }
    }

    private void c(Context context) {
        ImprintHandler.getImprintService(context).registImprintCallback(f41571a, new UMImprintChangeCallback() { // from class: com.umeng.ccg.d.1
            @Override // com.umeng.commonsdk.statistics.internal.UMImprintChangeCallback
            public void onImprintValueChanged(String str, String str2) {
                com.umeng.ccg.c.a(UMGlobalContext.getAppContext(), 107, d.a(), str2);
            }
        });
    }

    private Long d(Context context) {
        try {
            SharedPreferences a6 = ar.a(context);
            if (a6 != null) {
                return Long.valueOf(a6.getLong(ar.f40887d, 0L));
            }
        } catch (Throwable unused) {
        }
        return 0L;
    }

    private void c(JSONObject jSONObject) {
        if (jSONObject == null || !jSONObject.has(com.umeng.ccg.a.f41525a)) {
            return;
        }
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject(com.umeng.ccg.a.f41525a);
            z a6 = optJSONObject.has(com.umeng.ccg.a.f41526b) ? a(com.umeng.ccg.a.f41526b, optJSONObject.optJSONObject(com.umeng.ccg.a.f41526b)) : null;
            z a7 = optJSONObject.has(com.umeng.ccg.a.f41527c) ? a(com.umeng.ccg.a.f41527c, optJSONObject.optJSONObject(com.umeng.ccg.a.f41527c)) : null;
            z a8 = optJSONObject.has(com.umeng.ccg.a.f41528d) ? a(com.umeng.ccg.a.f41528d, optJSONObject.optJSONObject(com.umeng.ccg.a.f41528d)) : null;
            z a9 = optJSONObject.has(com.umeng.ccg.a.f41529e) ? a(com.umeng.ccg.a.f41529e, optJSONObject.optJSONObject(com.umeng.ccg.a.f41529e)) : null;
            z a10 = optJSONObject.has(com.umeng.ccg.a.f41530f) ? a(com.umeng.ccg.a.f41530f, optJSONObject.optJSONObject(com.umeng.ccg.a.f41530f)) : null;
            z a11 = optJSONObject.has(com.umeng.ccg.a.f41531g) ? a(com.umeng.ccg.a.f41531g, optJSONObject.optJSONObject(com.umeng.ccg.a.f41531g)) : null;
            z a12 = optJSONObject.has(com.umeng.ccg.a.f41532h) ? a(com.umeng.ccg.a.f41532h, optJSONObject.optJSONObject(com.umeng.ccg.a.f41532h)) : null;
            ArrayList arrayList = new ArrayList();
            if (a6 != null) {
                arrayList.add(a6);
            }
            if (a7 != null) {
                arrayList.add(a7);
            }
            if (a8 != null) {
                arrayList.add(a8);
            }
            if (a9 != null) {
                arrayList.add(a9);
            }
            if (a10 != null) {
                arrayList.add(a10);
            }
            if (a11 != null) {
                arrayList.add(a11);
            }
            if (a12 != null) {
                arrayList.add(a12);
            }
            com.umeng.ccg.c.a(UMGlobalContext.getAppContext(), 202, a(), arrayList);
        } catch (Throwable unused) {
        }
    }

    private void f() {
        try {
            SharedPreferences a6 = ar.a(UMGlobalContext.getAppContext());
            if (a6 != null) {
                a6.edit().putString(ar.f40889f, new JSONObject(ap.a()).toString()).commit();
            }
        } catch (Throwable unused) {
        }
    }

    private boolean g() {
        try {
            SharedPreferences a6 = ar.a(UMGlobalContext.getAppContext());
            if (a6 != null) {
                if (!TextUtils.isEmpty(a6.getString(ar.f40890g, ""))) {
                    return true;
                }
                return false;
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static d a() {
        return b.f41585a;
    }

    private JSONObject b(Context context) {
        FileInputStream fileInputStream;
        try {
            File filesDir = context.getFilesDir();
            String str = f41572b;
            if (!new File(filesDir, str).exists()) {
                return null;
            }
            try {
                fileInputStream = context.openFileInput(str);
                try {
                    JSONObject jSONObject = new JSONObject(new String(at.a(HelperUtils.readStreamToByteArray(fileInputStream), UMConfigure.sAppkey.getBytes())));
                    try {
                        ap.a(fileInputStream);
                    } catch (Throwable unused) {
                    }
                    return jSONObject;
                } catch (Throwable unused2) {
                    ap.a(fileInputStream);
                    return null;
                }
            } catch (Throwable unused3) {
                fileInputStream = null;
            }
        } catch (Throwable unused4) {
            return null;
        }
    }

    private boolean e() {
        SharedPreferences a6 = ar.a(UMGlobalContext.getAppContext());
        if (a6 != null) {
            String string = a6.getString(ar.f40889f, "");
            if (TextUtils.isEmpty(string)) {
                f();
                return false;
            }
            try {
                if (!ap.a().keySet().equals(ap.a(new JSONObject(string)).keySet())) {
                    return true;
                }
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    public void a(Context context) {
        com.umeng.ccg.c.a(context, 105, a(), null);
    }

    private boolean a(JSONObject jSONObject) {
        if (jSONObject == null || !jSONObject.has("code")) {
            return false;
        }
        try {
            if (200 == jSONObject.optInt("code") && jSONObject.has(com.umeng.ccg.a.f41525a)) {
                return jSONObject.has("ts");
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    private void a(Context context, JSONObject jSONObject, String str) {
        try {
            long b6 = b(jSONObject);
            byte[] a6 = at.a(jSONObject.toString().getBytes(), UMConfigure.sAppkey.getBytes());
            if (a6 != null && a6.length > 1) {
                FileOutputStream fileOutputStream = new FileOutputStream(new File(context.getFilesDir(), f41572b));
                try {
                    fileOutputStream.write(a6);
                    fileOutputStream.flush();
                    ap.a(fileOutputStream);
                    a(context, str, b6);
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "saveConfigFile success.");
                } catch (Throwable th) {
                    ap.a(fileOutputStream);
                    throw th;
                }
            }
        } catch (Throwable unused) {
        }
    }

    private void b(String str) {
        String str2 = ar.f40885b + str;
        SharedPreferences a6 = ar.a(UMGlobalContext.getAppContext());
        if (a6 != null) {
            a6.edit().putLong(str2, System.currentTimeMillis()).commit();
        }
    }

    private void a(String str, aa aaVar) {
        if (com.umeng.ccg.a.f41530f.equalsIgnoreCase(str)) {
            if (f41575e == null) {
                f41575e = new ArrayList<>();
            }
            f41575e.add(aaVar);
        }
        if (com.umeng.ccg.a.f41531g.equalsIgnoreCase(str)) {
            if (f41576f == null) {
                f41576f = new ArrayList<>();
            }
            f41576f.add(aaVar);
        }
        if (com.umeng.ccg.a.f41532h.equalsIgnoreCase(str)) {
            if (f41577g == null) {
                f41577g = new ArrayList<>();
            }
            f41577g.add(aaVar);
        }
    }

    private z a(String str, JSONObject jSONObject) {
        z zVar;
        JSONArray optJSONArray;
        String str2;
        String str3;
        z zVar2;
        JSONArray optJSONArray2;
        if (jSONObject == null) {
            return null;
        }
        try {
            if (!jSONObject.has(com.umeng.ccg.a.f41533i) || (optJSONArray = jSONObject.optJSONArray(com.umeng.ccg.a.f41533i)) == null || optJSONArray.length() <= 0) {
                return null;
            }
            JSONObject jSONObject2 = (JSONObject) optJSONArray.get(0);
            boolean has = jSONObject2.has(com.umeng.ccg.a.f41534j);
            boolean has2 = jSONObject2.has(com.umeng.ccg.a.f41537m);
            boolean has3 = jSONObject2.has(com.umeng.ccg.a.f41538n);
            if (!has || !has2 || !has3) {
                return null;
            }
            int optInt = jSONObject2.optInt(com.umeng.ccg.a.f41534j);
            try {
                long optLong = jSONObject2.optLong(com.umeng.ccg.a.f41537m);
                long optLong2 = jSONObject2.optLong(com.umeng.ccg.a.f41538n);
                zVar = null;
                try {
                    String optString = jSONObject2.optString(com.umeng.ccg.a.f41539o);
                    ArrayList arrayList = new ArrayList();
                    if (jSONObject2.has(com.umeng.ccg.a.f41535k)) {
                        JSONArray optJSONArray3 = jSONObject2.optJSONArray(com.umeng.ccg.a.f41535k);
                        str2 = com.umeng.ccg.a.f41544t;
                        HashSet hashSet = new HashSet();
                        if (optJSONArray3 != null) {
                            str3 = "sdk";
                            int i6 = 0;
                            for (int length = optJSONArray3.length(); i6 < length; length = length) {
                                hashSet.add(Integer.valueOf(optJSONArray3.getInt(i6)));
                                i6++;
                            }
                        } else {
                            str3 = "sdk";
                        }
                        if (hashSet.size() > 0) {
                            aj ajVar = new aj(hashSet);
                            if (Arrays.asList(f41574d).contains(str)) {
                                a(str, ajVar);
                            } else {
                                arrayList.add(ajVar);
                            }
                        }
                    } else {
                        str2 = com.umeng.ccg.a.f41544t;
                        str3 = "sdk";
                    }
                    if (jSONObject2.has(com.umeng.ccg.a.f41536l)) {
                        String optString2 = jSONObject2.optString(com.umeng.ccg.a.f41536l);
                        if (!TextUtils.isEmpty(optString2)) {
                            ah ahVar = new ah(optString2);
                            HashSet hashSet2 = new HashSet();
                            for (int i7 = 1; i7 <= 24; i7++) {
                                if (ahVar.a(i7)) {
                                    hashSet2.add(Integer.valueOf(i7));
                                }
                            }
                            if (hashSet2.size() > 0) {
                                ad adVar = new ad(hashSet2);
                                if (Arrays.asList(f41574d).contains(str)) {
                                    a(str, adVar);
                                } else {
                                    arrayList.add(adVar);
                                }
                            }
                        }
                    }
                    arrayList.add(new af(optInt));
                    ae aeVar = new ae(str, optLong);
                    String[] strArr = f41574d;
                    if (Arrays.asList(strArr).contains(str)) {
                        a(str, aeVar);
                    } else {
                        arrayList.add(aeVar);
                    }
                    ac acVar = new ac(optLong2);
                    if (Arrays.asList(strArr).contains(str)) {
                        a(str, acVar);
                        arrayList.add(acVar);
                    } else {
                        arrayList.add(acVar);
                    }
                    if (com.umeng.ccg.a.f41529e.equals(str)) {
                        zVar2 = new ab(str, arrayList);
                    } else {
                        zVar2 = new z(str, arrayList);
                    }
                    z zVar3 = zVar2;
                    try {
                        zVar3.a(optString);
                        String str4 = "";
                        String str5 = str3;
                        if (jSONObject.has(str5) && (optJSONArray2 = jSONObject.optJSONArray(str5)) != null) {
                            Map<String, a> map = this.f41580i;
                            if (map != null && !map.containsKey(str)) {
                                this.f41580i.put(str, new a(new JSONArray(optJSONArray2.toString()), optString));
                            }
                            int length2 = optJSONArray2.length();
                            for (int i8 = 0; i8 < optJSONArray2.length(); i8++) {
                                str4 = str4 + optJSONArray2.getString(i8);
                                if (i8 < length2 - 1) {
                                    str4 = str4 + ",";
                                }
                            }
                        }
                        zVar3.b(str4);
                        if (com.umeng.ccg.a.f41529e.equals(str) && (zVar3 instanceof ab)) {
                            String str6 = str2;
                            if (jSONObject2.has(str6)) {
                                ((ab) zVar3).d(jSONObject2.optString(str6));
                            }
                            if (jSONObject2.has(com.umeng.ccg.a.f41543s)) {
                                ((ab) zVar3).c(jSONObject2.optString(com.umeng.ccg.a.f41543s));
                            }
                        }
                        return zVar3;
                    } catch (Throwable unused) {
                        return zVar3;
                    }
                } catch (Throwable unused2) {
                    return zVar;
                }
            } catch (Throwable unused3) {
                zVar = null;
            }
        } catch (Throwable unused4) {
            zVar = null;
        }
    }

    private void a(Context context, String str, long j6) {
        SharedPreferences a6;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            String[] split = str.split("@");
            if (split.length != 4 || (a6 = ar.a(context)) == null) {
                return;
            }
            long parseLong = Long.parseLong(split[0]);
            String str2 = split[1];
            SharedPreferences.Editor edit = a6.edit();
            edit.putLong(ar.f40886c, j6);
            edit.putLong(ar.f40887d, parseLong);
            edit.putString(ar.f40888e, str2).commit();
            UMRTLog.i(UMRTLog.RTLOG_TAG, "updateTsS1S2 : ts = " + j6 + "; s1 = " + parseLong + "; s2 = " + str2);
        } catch (Throwable unused) {
        }
    }

    private void a(String str) {
        try {
            String[] split = str.split("@");
            if (split.length != 4) {
                return;
            }
            long parseLong = Long.parseLong(split[0]);
            String str2 = split[1];
            if (!TextUtils.isEmpty(this.f41579h)) {
                String[] split2 = this.f41579h.split("@");
                if (split2.length == 2) {
                    long parseLong2 = Long.parseLong(split2[0]);
                    String str3 = split2[1];
                    if (parseLong2 == parseLong && str3.equalsIgnoreCase(str2)) {
                        UMRTLog.i(UMRTLog.RTLOG_TAG, "重复的iucc S1 and S2, 忽略本次更新，不发起fetch。");
                        return;
                    }
                }
            }
            SharedPreferences a6 = ar.a(UMGlobalContext.getAppContext());
            if (a6 != null) {
                if (a6.getLong(ar.f40886c, 0L) != parseLong) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "local config ts != iuccS1, send FETCH_NEW_CONFIG msg.");
                    this.f41579h = String.valueOf(parseLong) + "@" + str2;
                    com.umeng.ccg.c.a(UMGlobalContext.getAppContext(), 101, a(), str);
                    return;
                }
                d(UMGlobalContext.getAppContext());
                if (e(UMGlobalContext.getAppContext()).equalsIgnoreCase(str2)) {
                    return;
                }
                UMRTLog.i(UMRTLog.RTLOG_TAG, "local S2 != iuccS2, send FETCH_NEW_CONFIG msg.");
                this.f41579h = String.valueOf(parseLong) + "@" + str2;
                com.umeng.ccg.c.a(UMGlobalContext.getAppContext(), 101, a(), str);
            }
        } catch (Throwable unused) {
        }
    }

    private void a(boolean z5) {
        try {
            SharedPreferences a6 = ar.a(UMGlobalContext.getAppContext());
            if (a6 != null) {
                SharedPreferences.Editor edit = a6.edit();
                if (z5) {
                    edit.putString(ar.f40890g, "1").commit();
                } else {
                    edit.putString(ar.f40890g, "").commit();
                }
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:154:0x039c, code lost:
    
        if (r8 != null) goto L124;
     */
    /* JADX WARN: Code restructure failed: missing block: B:155:0x039e, code lost:
    
        r2.put("config", r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:162:0x03b6, code lost:
    
        if (r8 == null) goto L125;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v11, types: [int] */
    /* JADX WARN: Type inference failed for: r2v12, types: [org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v14, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v15, types: [org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r2v17, types: [org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r2v18, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v69 */
    /* JADX WARN: Type inference failed for: r2v70 */
    /* JADX WARN: Type inference failed for: r2v71 */
    @Override // com.umeng.ccg.c.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(java.lang.Object r21, int r22) {
        /*
            Method dump skipped, instructions count: 1230
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.ccg.d.a(java.lang.Object, int):void");
    }
}
