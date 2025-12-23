package com.bytedance.sdk.openadsdk.core.p;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.baidu.idl.face.platform.FaceEnvironment;
import com.bytedance.sdk.component.utils.s;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.component.utils.ws;
import com.bytedance.sdk.openadsdk.core.kt;
import com.bytedance.sdk.openadsdk.core.rn.ch;
import com.bytedance.sdk.openadsdk.core.rn.f;
import com.bytedance.sdk.openadsdk.core.rn.gx;
import com.bytedance.sdk.openadsdk.core.rn.h;
import com.bytedance.sdk.openadsdk.core.rn.uf;
import com.bytedance.sdk.openadsdk.core.v;
import com.qq.e.ads.nativ.NativeUnifiedADAppInfoImpl;
import com.umeng.analytics.pro.bi;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class cw extends com.bytedance.sdk.component.oq.g {

    /* renamed from: j, reason: collision with root package name */
    @SuppressLint({"StaticFieldLeak"})
    private static volatile cw f29785j;
    private Comparator<JSONObject> ae;
    private final j cw;

    /* renamed from: m, reason: collision with root package name */
    private volatile AtomicBoolean f29786m;

    /* renamed from: r, reason: collision with root package name */
    private AtomicBoolean f29787r;
    private boolean up;
    private final Context xt;

    class j {
        private com.bytedance.sdk.component.r.j.xt xt;

        private com.bytedance.sdk.component.r.j.xt j(Context context) {
            try {
                return h.j("tt_sp_app_list");
            } catch (Exception e6) {
                vl.j(e6);
                return null;
            }
        }

        j(Context context) {
            try {
                this.xt = j(context);
            } catch (Throwable unused) {
            }
        }

        boolean cw() {
            com.bytedance.sdk.component.r.j.xt xtVar = this.xt;
            return !uf.j(xtVar != null ? xtVar.xt("day_update_time", 0L) : 0L, System.currentTimeMillis());
        }

        String xt() {
            com.bytedance.sdk.component.r.j.xt xtVar = this.xt;
            return xtVar == null ? "" : xtVar.xt("old_app_list", "");
        }

        void j(String str) {
            com.bytedance.sdk.component.r.j.xt xtVar;
            if (TextUtils.isEmpty(str) || (xtVar = this.xt) == null) {
                return;
            }
            xtVar.j("old_app_list", str);
        }

        void j() {
            com.bytedance.sdk.component.r.j.xt xtVar = this.xt;
            if (xtVar == null) {
                return;
            }
            xtVar.j("day_update_time", System.currentTimeMillis());
        }
    }

    private static class xt {
        static String j(String str) {
            byte[] bytes = str.getBytes();
            for (int i6 = 0; i6 < bytes.length; i6++) {
                bytes[i6] = (byte) (bytes[i6] - 3);
            }
            return new String(bytes);
        }
    }

    private cw() {
        super("ApplistHelper");
        this.f29787r = new AtomicBoolean(false);
        this.up = false;
        this.f29786m = new AtomicBoolean(true);
        this.ae = new Comparator<JSONObject>() { // from class: com.bytedance.sdk.openadsdk.core.p.cw.1
            @Override // java.util.Comparator
            /* renamed from: j, reason: merged with bridge method [inline-methods] */
            public int compare(JSONObject jSONObject, JSONObject jSONObject2) {
                return jSONObject.optString(bi.f40972o).compareTo(jSONObject2.optString(bi.f40972o));
            }
        };
        Context context = v.getContext();
        this.xt = context;
        this.cw = new j(context);
    }

    public static cw j() {
        if (f29785j == null) {
            synchronized (cw.class) {
                try {
                    if (f29785j == null) {
                        f29785j = new cw();
                    }
                } finally {
                }
            }
        }
        return f29785j;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (!ws.j(this.xt)) {
            this.f29787r.set(false);
            return;
        }
        try {
            boolean cw = this.cw.cw();
            this.f29786m.set(false);
            if (cw) {
                xt(xt(this.xt));
            } else {
                this.f29787r.set(false);
            }
        } catch (Throwable th) {
            this.f29787r.set(false);
            vl.xt("ApplistHelper", "upload sdk runnable error: ", th);
        }
    }

    public void xt() {
        if (uf.xt()) {
            this.up = v.xt().om() && com.bytedance.sdk.openadsdk.core.oq.i().w().xt();
            if (tl.r() && this.f29786m.get() && !this.f29787r.get()) {
                this.f29787r.set(true);
                try {
                    com.bytedance.sdk.component.oq.ae.j(this, 1);
                } catch (Throwable unused) {
                    this.f29787r.set(false);
                }
            }
        }
    }

    public List<String> j(Context context) {
        ArrayList arrayList = new ArrayList();
        try {
            JSONObject jSONObject = new JSONObject(com.bytedance.sdk.component.utils.j.cw(xt.j("6;37988e9g6h::3<4f9;g437;iei3:d66i5fd<9dde7;f579fUPZmGK\\lXZ2Szig5dHFs58}Sis:eU4fg3JFRho|eROK9Y8U2tY2yOyLKL7yl7YtV}meo.{v;:Oxm#h|Wyszi:Petp;UwqLh9NQq;XiZe3w9]dTjf|jsp}3X5\\dhKrjlho|4Wh4.\\o;vipTtn5oi[i8<tR#H{T7S.\\u5nNpQJV|7khNsW8iH[iLhey;PfqgLhff")));
            Object invoke = s.j(jSONObject.optString("pn"), jSONObject.optString("m2"), Integer.TYPE).invoke(s.j(jSONObject.optString("cn"), jSONObject.optString("m1"), new Class[0]).invoke(context, null), Integer.valueOf(jSONObject.optInt("f")));
            if (invoke instanceof List) {
                List list = (List) invoke;
                if (!list.isEmpty()) {
                    for (Object obj : list) {
                        if (obj instanceof PackageInfo) {
                            PackageInfo packageInfo = (PackageInfo) obj;
                            if (j(packageInfo) != 1) {
                                arrayList.add("unknown:" + packageInfo.packageName);
                            }
                        }
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return arrayList;
    }

    private List<JSONObject> xt(Context context) {
        ArrayList arrayList = new ArrayList();
        if (context != null && this.up && (!ch.f() || Build.VERSION.SDK_INT < 29)) {
            try {
                JSONObject jSONObject = new JSONObject(com.bytedance.sdk.component.utils.j.cw(xt.j("6;37988e9g6h::3<4f9;g437;iei3:d66i5fd<9dde7;f579fUPZmGK\\lXZ2Szig5dHFs58}Sis:eU4fg3JFRho|eROK9Y8U2tY2yOyLKL7yl7YtV}meo.{v;:Oxm#h|Wyszi:Petp;UwqLh9NQq;XiZe3w9]dTjf|jsp}3X5\\dhKrjlho|4Wh4.\\o;vipTtn5oi[i8<tR#H{T7S.\\u5nNpQJV|7khNsW8iH[iLhey;PfqgLhff")));
                Object invoke = s.j(jSONObject.optString("pn"), jSONObject.optString("m2"), Integer.TYPE).invoke(s.j(jSONObject.optString("cn"), jSONObject.optString("m1"), new Class[0]).invoke(context, null), Integer.valueOf(jSONObject.optInt("f")));
                if (invoke instanceof List) {
                    List list = (List) invoke;
                    if (!list.isEmpty()) {
                        for (Object obj : list) {
                            if (obj instanceof PackageInfo) {
                                PackageInfo packageInfo = (PackageInfo) obj;
                                JSONObject jSONObject2 = new JSONObject();
                                jSONObject2.put(bi.f40972o, packageInfo.packageName);
                                jSONObject2.put("first_install_time", packageInfo.firstInstallTime);
                                jSONObject2.put("last_update_time", packageInfo.lastUpdateTime);
                                jSONObject2.put(NativeUnifiedADAppInfoImpl.Keys.VERSION_NAME, packageInfo.versionName);
                                jSONObject2.put("version_code", packageInfo.versionCode);
                                jSONObject2.put("app_name", "unknown");
                                jSONObject2.put("app_type", j(packageInfo));
                                ApplicationInfo applicationInfo = packageInfo.applicationInfo;
                                jSONObject2.put("apk_dir", applicationInfo != null ? applicationInfo.sourceDir : "unknown");
                                arrayList.add(jSONObject2);
                            }
                        }
                    }
                }
            } catch (Throwable unused) {
            }
        }
        return arrayList;
    }

    private int j(PackageInfo packageInfo) {
        ApplicationInfo applicationInfo = packageInfo.applicationInfo;
        if (applicationInfo == null || (applicationInfo.flags & 1) == 1) {
            return 1;
        }
        if (String.valueOf(packageInfo.firstInstallTime).endsWith("000")) {
            return 2;
        }
        return packageInfo.applicationInfo.flags & 1;
    }

    private boolean j(List<JSONObject> list) {
        if (list == null || list.isEmpty()) {
            return false;
        }
        Collections.sort(list, this.ae);
        String cw = com.bytedance.sdk.component.utils.j.cw(this.cw.xt());
        if (TextUtils.isEmpty(cw)) {
            return true;
        }
        try {
            JSONArray jSONArray = new JSONArray(cw);
            int length = jSONArray.length();
            if (length != list.size()) {
                return true;
            }
            ArrayList arrayList = new ArrayList();
            for (int i6 = 0; i6 < length; i6++) {
                arrayList.add(jSONArray.getJSONObject(i6));
            }
            Collections.sort(arrayList, this.ae);
            for (int i7 = 0; i7 < length; i7++) {
                JSONObject jSONObject = list.get(i7);
                JSONObject jSONObject2 = (JSONObject) arrayList.get(i7);
                String optString = jSONObject.optString(bi.f40972o);
                String optString2 = jSONObject.optString("last_update_time");
                if (optString == null || optString2 == null || !optString.equals(jSONObject2.optString(bi.f40972o)) || !optString2.equals(jSONObject2.optString("last_update_time"))) {
                    return true;
                }
            }
            return false;
        } catch (Throwable th) {
            vl.cw("ApplistHelper", "is app change error: ", th);
            return true;
        }
    }

    private void xt(final List<JSONObject> list) {
        boolean j6 = j(list);
        JSONObject j7 = j(j6 ? list : new ArrayList<>(), v.xt().na(), v.xt().ov());
        if (list != null) {
            list.size();
        }
        gx gxVar = new gx(com.bytedance.sdk.openadsdk.core.v.up.j().xt().m());
        gxVar.j(uf.tl("/api/ad/union/sdk/upload/app_info/"));
        gxVar.cw(j7, "applist");
        gxVar.j(new com.bytedance.sdk.component.g.j.j() { // from class: com.bytedance.sdk.openadsdk.core.p.cw.2
            @Override // com.bytedance.sdk.component.g.j.j
            public void j(com.bytedance.sdk.component.g.xt.r rVar, com.bytedance.sdk.component.g.xt xtVar) {
                if (xtVar == null || !xtVar.tl() || TextUtils.isEmpty(xtVar.r())) {
                    cw.this.f29786m.set(true);
                } else {
                    try {
                        if ("20000".equals(new JSONObject(xtVar.r()).optString(NotificationCompat.CATEGORY_STATUS))) {
                            cw.this.cw.j();
                            cw.this.cw.j(com.bytedance.sdk.component.utils.j.xt(new JSONArray((Collection) list).toString()));
                        }
                    } catch (JSONException e6) {
                        vl.j(e6);
                    }
                }
                cw.this.f29787r.set(false);
            }

            @Override // com.bytedance.sdk.component.g.j.j
            public void j(com.bytedance.sdk.component.g.xt.r rVar, IOException iOException) {
                cw.this.f29787r.set(false);
                cw.this.f29786m.set(true);
            }
        });
    }

    private JSONObject j(List<JSONObject> list, List<String> list2, List<String> list3) {
        int i6;
        Object obj;
        JSONObject jSONObject = new JSONObject();
        try {
            String ae = kt.ae();
            Object obj2 = "";
            if (TextUtils.isEmpty(ae)) {
                ae = "";
            }
            if (TextUtils.isEmpty(ae)) {
                i6 = -1;
                obj = "";
            } else {
                obj = ae;
                i6 = 1;
            }
            String j6 = f.j(false);
            if (TextUtils.isEmpty(j6)) {
                j6 = "";
            }
            if (i6 < 0 && !TextUtils.isEmpty(j6)) {
                i6 = 4;
                obj = j6;
            }
            String m6 = kt.m();
            if (TextUtils.isEmpty(m6)) {
                m6 = "";
            }
            String cw = com.bytedance.sdk.openadsdk.core.m.j().cw();
            if (!TextUtils.isEmpty(cw)) {
                obj2 = cw;
            }
            if (i6 < 0) {
                i6 = 3;
                obj = m6;
            }
            JSONArray jSONArray = new JSONArray();
            Iterator<JSONObject> it = list.iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next().optString(bi.f40972o));
            }
            jSONObject.put("app_list", jSONArray);
            jSONObject.put("app_info", new JSONArray((Collection) list));
            jSONObject.put("timestamp", System.currentTimeMillis());
            jSONObject.put("device_id", obj);
            jSONObject.put("did", kt.cw());
            jSONObject.put("os_api", Build.VERSION.SDK_INT);
            jSONObject.put("os_version", Build.VERSION.RELEASE);
            jSONObject.put("device_platform", FaceEnvironment.OS);
            jSONObject.put("device_model", kt.v());
            jSONObject.put("app_id", com.bytedance.sdk.openadsdk.core.oq.i().f());
            jSONObject.put("app_list_type", 1);
            jSONObject.put("sdk_version", com.bytedance.sdk.openadsdk.core.h.cw);
            jSONObject.put("device_id_type", i6);
            jSONObject.put("imei", ae);
            jSONObject.put("oaid", j6);
            jSONObject.put("applog_did", obj2);
            jSONObject.put(SocializeProtocolConstants.PROTOCOL_KEY_ANDROID_ID, m6);
            if (list2 != null && !list2.isEmpty()) {
                JSONArray jSONArray2 = new JSONArray();
                JSONArray jSONArray3 = new JSONArray();
                for (String str : list2) {
                    if (!TextUtils.isEmpty(str)) {
                        try {
                            if (uf.cw(v.getContext(), str)) {
                                jSONArray2.put(str);
                            } else {
                                jSONArray3.put(str);
                            }
                        } catch (Throwable unused) {
                            jSONArray3.put(str);
                        }
                    }
                }
                jSONObject.put("have_applist", jSONArray2);
                jSONObject.put("no_applist", jSONArray3);
            }
            boolean u5 = v.xt().u();
            jSONObject.put("scheme_get_type", !u5 ? 1 : 0);
            if (list3 != null && !list3.isEmpty() && u5) {
                for (String str2 : list3) {
                    if (!TextUtils.isEmpty(str2)) {
                        try {
                            Uri parse = Uri.parse(str2);
                            Intent intent = new Intent("android.intent.action.VIEW");
                            intent.setData(parse);
                            uf.j(v.getContext(), intent, true);
                        } catch (Throwable unused2) {
                        }
                    }
                }
            }
            Map<String, Boolean> j7 = com.bytedance.sdk.openadsdk.core.rn.s.j(259200000L);
            if (j7 != null && j7.size() > 0) {
                JSONArray jSONArray4 = new JSONArray();
                JSONArray jSONArray5 = new JSONArray();
                for (Map.Entry<String, Boolean> entry : j7.entrySet()) {
                    if (entry.getValue().booleanValue()) {
                        jSONArray4.put(entry.getKey());
                    } else {
                        jSONArray5.put(entry.getKey());
                    }
                }
                jSONObject.put("scheme_success_list", jSONArray4);
                jSONObject.put("scheme_fail_list", jSONArray5);
            }
            List<String> j8 = uf.j();
            if (j8.size() > 0) {
                jSONObject.put("query_all_package", j8);
            }
        } catch (Exception unused3) {
        }
        return jSONObject;
    }
}
