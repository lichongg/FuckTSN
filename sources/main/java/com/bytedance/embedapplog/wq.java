package com.bytedance.embedapplog;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.huawei.hms.framework.common.hianalytics.WiseOpenHianalyticsData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes3.dex */
public class wq {

    /* renamed from: m, reason: collision with root package name */
    private static final String[] f24095m = {"channel", WiseOpenHianalyticsData.UNION_PACKAGE, "app_version"};
    private final SharedPreferences ae;
    private final rn cw;

    /* renamed from: j, reason: collision with root package name */
    private boolean f24096j;
    private final Context xt;
    private final ArrayList<l> up = new ArrayList<>(32);
    private int tl = 0;

    /* renamed from: r, reason: collision with root package name */
    @NonNull
    private JSONObject f24097r = new JSONObject();

    @Nullable
    public JSONObject j() {
        if (this.f24096j) {
            return ws();
        }
        return null;
    }

    public int xt() {
        int optInt = this.f24096j ? ws().optInt("version_code", -1) : -1;
        for (int i6 = 0; i6 < 3 && optInt == -1; i6++) {
            m();
            optInt = this.f24096j ? ws().optInt("version_code", -1) : -1;
        }
        return optInt;
    }

    @NonNull
    private JSONObject ws() {
        return this.f24097r;
    }

    public String cw() {
        String optString = this.f24096j ? ws().optString("app_version", null) : null;
        for (int i6 = 0; i6 < 3 && optString == null; i6++) {
            m();
            optString = this.f24096j ? ws().optString("app_version", null) : null;
        }
        return optString;
    }

    @Nullable
    public <T> T j(String str, T t5) {
        T t6;
        JSONObject ws = ws();
        if (ws == null || (t6 = (T) ws.opt(str)) == null) {
            t6 = null;
        }
        return t6 == null ? t5 : t6;
    }

    public boolean m() {
        synchronized (this.up) {
            try {
                if (this.up.size() == 0) {
                    this.up.add(new p(this.xt, this.cw));
                    this.up.add(new la(this.xt));
                    this.up.add(new gq(this.xt, this.cw));
                    this.up.add(new uf(this.xt));
                    this.up.add(new c(this.xt));
                    this.up.add(new gx(this.xt, this.cw));
                    this.up.add(new n(this.xt));
                    this.up.add(new rh(this.xt, this.cw));
                    this.up.add(new ol(this.xt, this.cw));
                    this.up.add(new hh());
                    this.up.add(new z(this.cw));
                    this.up.add(new hl(this.xt));
                    this.up.add(new b(this.xt));
                    this.up.add(new e(this.xt, this.cw));
                    this.up.add(new s(this.xt, this.cw));
                    this.up.add(new nd(this.xt, this.cw));
                    this.up.add(new h(this.xt, this.cw));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        JSONObject ws = ws();
        JSONObject jSONObject = new JSONObject();
        ri.xt(jSONObject, ws);
        Iterator<l> it = this.up.iterator();
        boolean z5 = true;
        int i6 = 0;
        int i7 = 0;
        while (it.hasNext()) {
            l next = it.next();
            if (!next.f24009j || next.cw || j(next)) {
                try {
                    next.f24009j = next.j(jSONObject);
                } catch (SecurityException e6) {
                    if (!next.xt) {
                        i6++;
                        uc.xt("loadHeader, " + this.tl, e6);
                        if (!next.f24009j && this.tl > 10) {
                            next.f24009j = true;
                        }
                    }
                } catch (JSONException e7) {
                    uc.xt(e7);
                }
                if (!next.f24009j && !next.xt) {
                    i7++;
                }
            }
            z5 &= next.f24009j || next.xt;
        }
        if (z5) {
            int length = f24095m.length;
            for (int i8 = 0; i8 < length; i8++) {
                z5 &= !TextUtils.isEmpty(jSONObject.optString(r7[i8]));
            }
            String optString = jSONObject.optString("user_unique_id", null);
            if (!TextUtils.isEmpty(optString)) {
                try {
                    jSONObject.put("user_unique_id", optString);
                } catch (JSONException unused) {
                }
            }
        }
        this.f24097r = jSONObject;
        this.f24096j = z5;
        if (uc.xt) {
            uc.j("loadHeader, " + this.f24096j + ", " + this.tl + ", " + this.f24097r.toString(), null);
        } else {
            uc.r("loadHeader, " + this.f24096j + ", " + this.tl, null);
        }
        if (i6 > 0 && i6 == i7) {
            this.tl++;
            if (qv() != 0) {
                this.tl += 10;
            }
        }
        if (this.f24096j) {
            j.qv().j(ae(), tl(), g());
        }
        return this.f24096j;
    }

    public void up() {
        try {
            new nd(this.xt, this.cw).j(this.f24097r);
        } catch (Exception e6) {
            com.bytedance.sdk.component.utils.vl.cw("od", "e:" + e6.getMessage(), e6);
        }
    }

    public wq(Context context, rn rnVar) {
        this.xt = context;
        this.cw = rnVar;
        this.ae = rnVar.r();
        if (j.xt) {
            wo.j(context);
        }
    }

    public String ae() {
        return ws().optString("device_id", "");
    }

    public String g() {
        return ws().optString("ssid", "");
    }

    public String jy() {
        return ws().optString("ab_sdk_version", "");
    }

    public String oq() {
        return ws().optString("user_unique_id", "");
    }

    public int qv() {
        String optString = ws().optString("device_id", "");
        ws().optString("install_id", "");
        if (!xt(optString)) {
            return 0;
        }
        if (this.ae.getInt("version_code", 0) == ws().optInt("version_code", -1)) {
            return 1;
        }
        return 2;
    }

    public void r() {
        f.m().g();
    }

    public String tl() {
        return ws().optString("install_id", "");
    }

    public long vl() {
        return ws().optLong("register_time", 0L);
    }

    private boolean j(l lVar) {
        boolean z5 = !this.cw.i() && lVar.f24010r;
        if (uc.xt) {
            uc.j("needSyncFromSub " + lVar + " " + z5, null);
        }
        return z5;
    }

    private synchronized void xt(JSONObject jSONObject) {
        if (jSONObject == null) {
            uc.xt("null abconfig", null);
            return;
        }
        String optString = ws().optString("ab_version");
        if (!TextUtils.isEmpty(optString)) {
            String[] split = optString.split(",");
            Set<String> hashSet = new HashSet<>();
            for (String str : split) {
                if (!TextUtils.isEmpty(str)) {
                    hashSet.add(str);
                }
            }
            Iterator<String> keys = jSONObject.keys();
            HashSet hashSet2 = new HashSet();
            while (keys.hasNext()) {
                String next = keys.next();
                if (next instanceof String) {
                    String str2 = next;
                    if (!TextUtils.isEmpty(str2)) {
                        try {
                            hashSet2.add(jSONObject.getJSONObject(str2).optString("vid"));
                        } catch (JSONException e6) {
                            uc.xt(e6);
                        }
                    }
                }
            }
            hashSet.retainAll(hashSet2);
            xt("ab_version", j(hashSet));
        }
    }

    public void j(JSONObject jSONObject) {
        this.cw.cw(jSONObject);
        xt(jSONObject);
    }

    private String j(Set<String> set) {
        StringBuilder sb = new StringBuilder();
        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            if (it.hasNext()) {
                sb.append(",");
            }
        }
        return sb.toString();
    }

    public void j(HashMap<String, Object> hashMap) {
        JSONObject jSONObject = null;
        if (hashMap != null && !hashMap.isEmpty()) {
            try {
                jSONObject = ws().optJSONObject("custom");
                if (jSONObject == null) {
                    jSONObject = new JSONObject();
                }
                for (Map.Entry<String, Object> entry : hashMap.entrySet()) {
                    if (!TextUtils.isEmpty(entry.getKey())) {
                        jSONObject.put(entry.getKey(), entry.getValue());
                    }
                }
            } catch (JSONException e6) {
                uc.xt(e6);
            }
        }
        if (xt("custom", jSONObject)) {
            this.cw.xt(jSONObject);
        }
    }

    static void j(JSONObject jSONObject, String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        jSONObject.put(str, str2);
    }

    static boolean j(String str) {
        int length = str != null ? str.length() : 0;
        if (length < 13 || length > 128) {
            return false;
        }
        for (int i6 = 0; i6 < length; i6++) {
            char charAt = str.charAt(i6);
            if ((charAt < '0' || charAt > '9') && ((charAt < 'a' || charAt > 'f') && ((charAt < 'A' || charAt > 'F') && charAt != '-'))) {
                return false;
            }
        }
        return true;
    }

    private boolean xt(String str, Object obj) {
        boolean z5;
        Object opt = ws().opt(str);
        if ((obj == null || obj.equals(opt)) && (obj != null || opt == null)) {
            z5 = false;
        } else {
            synchronized (this) {
                try {
                    JSONObject jSONObject = this.f24097r;
                    JSONObject jSONObject2 = new JSONObject();
                    ri.xt(jSONObject2, jSONObject);
                    jSONObject2.put(str, obj);
                    this.f24097r = jSONObject2;
                } catch (JSONException e6) {
                    uc.xt(e6);
                }
            }
            z5 = true;
        }
        uc.j("updateHeader, " + str + ", " + opt + ", " + obj, null);
        return z5;
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x00f3 A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean j(org.json.JSONObject r20, java.lang.String r21, java.lang.String r22, java.lang.String r23) {
        /*
            Method dump skipped, instructions count: 247
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.embedapplog.wq.j(org.json.JSONObject, java.lang.String, java.lang.String, java.lang.String):boolean");
    }

    public static boolean xt(String str) {
        if (!TextUtils.isEmpty(str) && !"unknown".equalsIgnoreCase(str) && !"Null".equalsIgnoreCase(str)) {
            for (int i6 = 0; i6 < str.length(); i6++) {
                if (str.charAt(i6) != '0') {
                    return true;
                }
            }
        }
        return false;
    }
}
