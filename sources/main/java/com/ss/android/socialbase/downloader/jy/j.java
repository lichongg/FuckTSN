package com.ss.android.socialbase.downloader.jy;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.bytedance.sdk.component.utils.vl;
import com.ss.android.socialbase.downloader.az.tl;
import com.ss.android.socialbase.downloader.downloader.ae;
import com.ss.android.socialbase.downloader.downloader.cw;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes6.dex */
public class j {
    private static j ae;
    private static JSONObject cw;

    /* renamed from: m, reason: collision with root package name */
    private static boolean f38882m;

    /* renamed from: r, reason: collision with root package name */
    private static JSONObject f38883r;
    private static Boolean up;

    /* renamed from: g, reason: collision with root package name */
    private final JSONObject f38884g;
    private final Boolean oq;
    private int qv;
    private final JSONObject tl;

    /* renamed from: j, reason: collision with root package name */
    private static final tl<Integer, j> f38881j = new tl<>(16, 16);
    private static final j xt = new j(null);

    @NonNull
    public static j cw() {
        return xt;
    }

    public static void j() {
        Boolean bool;
        JSONObject la = cw.la();
        f38882m = la.optInt("disable_task_setting", 0) == 1;
        cw = la.optJSONObject("disabled_task_keys");
        JSONObject optJSONObject = la.optJSONObject("bugfix");
        if (optJSONObject == null || !optJSONObject.has("default")) {
            bool = null;
        } else {
            bool = Boolean.valueOf(optJSONObject.optInt("default", 0) == 1);
        }
        f38883r = optJSONObject;
        up = bool;
    }

    @NonNull
    public static JSONObject xt() {
        return cw.la();
    }

    static {
        j();
    }

    public static boolean m(String str) {
        JSONObject jSONObject = cw;
        return jSONObject != null && jSONObject.optInt(str, 0) == 1;
    }

    public String cw(String str) {
        return j(str, "");
    }

    public JSONObject r(String str) {
        JSONObject jSONObject = this.tl;
        return (jSONObject == null || !jSONObject.has(str) || m(str)) ? xt().optJSONObject(str) : this.tl.optJSONObject(str);
    }

    public JSONArray up(String str) {
        JSONObject jSONObject = this.tl;
        return (jSONObject == null || !jSONObject.has(str) || m(str)) ? xt().optJSONArray(str) : this.tl.optJSONArray(str);
    }

    public boolean xt(String str, boolean z5) {
        if (this.f38884g != null && !m(str)) {
            if (this.f38884g.has(str)) {
                return this.f38884g.optInt(str, z5 ? 1 : 0) == 1;
            }
            Boolean bool = this.oq;
            if (bool != null) {
                return bool.booleanValue();
            }
        }
        JSONObject jSONObject = f38883r;
        if (jSONObject != null) {
            if (jSONObject.has(str)) {
                return f38883r.optInt(str, z5 ? 1 : 0) == 1;
            }
            Boolean bool2 = up;
            if (bool2 != null) {
                return bool2.booleanValue();
            }
        }
        return z5;
    }

    private j(JSONObject jSONObject) {
        Boolean bool;
        this.tl = jSONObject;
        JSONObject jSONObject2 = null;
        r0 = null;
        r0 = null;
        Boolean bool2 = null;
        if (jSONObject != null && !m("bugfix")) {
            JSONObject optJSONObject = jSONObject.optJSONObject("bugfix");
            if (optJSONObject != null && optJSONObject.has("default") && !m("default")) {
                bool2 = Boolean.valueOf(optJSONObject.optInt("default", 0) == 1);
            }
            Boolean bool3 = bool2;
            jSONObject2 = optJSONObject;
            bool = bool3;
        } else {
            bool = null;
        }
        this.f38884g = jSONObject2;
        this.oq = bool;
    }

    private static j cw(int i6) {
        com.ss.android.socialbase.downloader.ae.cw tl;
        if (f38882m) {
            return xt;
        }
        Context nd = cw.nd();
        if (nd != null && (tl = ae.xt(nd).tl(i6)) != null) {
            return xt(tl);
        }
        return xt;
    }

    public static void j(String str, boolean z5) {
        try {
            if (f38883r == null) {
                f38883r = new JSONObject();
            }
            f38883r.put(str, z5 ? 1 : 0);
        } catch (JSONException unused) {
        }
    }

    @NonNull
    public static j j(int i6) {
        return j(i6, (com.ss.android.socialbase.downloader.ae.cw) null);
    }

    public int xt(String str) {
        return j(str, 0);
    }

    @NonNull
    public static j j(com.ss.android.socialbase.downloader.ae.cw cwVar) {
        if (cwVar == null) {
            return xt;
        }
        return j(cwVar.ae(), cwVar);
    }

    public static void xt(int i6) {
        j jVar = ae;
        if (jVar != null && jVar.qv == i6) {
            ae = null;
        }
        tl<Integer, j> tlVar = f38881j;
        synchronized (tlVar) {
            tlVar.remove(Integer.valueOf(i6));
        }
    }

    private static j j(int i6, com.ss.android.socialbase.downloader.ae.cw cwVar) {
        j jVar;
        j jVar2 = ae;
        if (jVar2 != null && jVar2.qv == i6) {
            return jVar2;
        }
        tl<Integer, j> tlVar = f38881j;
        synchronized (tlVar) {
            jVar = tlVar.get(Integer.valueOf(i6));
        }
        if (jVar == null) {
            jVar = cwVar == null ? cw(i6) : xt(cwVar);
            synchronized (tlVar) {
                tlVar.put(Integer.valueOf(i6), jVar);
            }
        }
        jVar.qv = i6;
        ae = jVar;
        return jVar;
    }

    private static j xt(com.ss.android.socialbase.downloader.ae.cw cwVar) {
        if (f38882m) {
            return xt;
        }
        try {
            String hl = cwVar.hl();
            if (!TextUtils.isEmpty(hl)) {
                return new j(new JSONObject(hl));
            }
        } catch (Throwable th) {
            vl.j(th);
        }
        return xt;
    }

    public boolean j(String str) {
        return xt(str, false);
    }

    public int j(String str, int i6) {
        JSONObject jSONObject = this.tl;
        if (jSONObject != null && jSONObject.has(str) && !m(str)) {
            return this.tl.optInt(str, i6);
        }
        return xt().optInt(str, i6);
    }

    public long j(String str, long j6) {
        JSONObject jSONObject = this.tl;
        if (jSONObject != null && jSONObject.has(str) && !m(str)) {
            return this.tl.optLong(str, j6);
        }
        return xt().optLong(str, j6);
    }

    public double j(String str, double d6) {
        JSONObject jSONObject = this.tl;
        if (jSONObject != null && jSONObject.has(str) && !m(str)) {
            return this.tl.optDouble(str, d6);
        }
        return xt().optDouble(str, d6);
    }

    public String j(String str, String str2) {
        JSONObject jSONObject = this.tl;
        if (jSONObject != null && jSONObject.has(str) && !m(str)) {
            return this.tl.optString(str, str2);
        }
        return xt().optString(str, str2);
    }

    @NonNull
    public static j j(JSONObject jSONObject) {
        if (jSONObject != null && jSONObject != xt() && !f38882m) {
            j jVar = ae;
            if (jVar != null && jVar.tl == jSONObject) {
                return jVar;
            }
            tl<Integer, j> tlVar = f38881j;
            synchronized (tlVar) {
                try {
                    for (j jVar2 : tlVar.values()) {
                        if (jVar2.tl == jSONObject) {
                            ae = jVar2;
                            return jVar2;
                        }
                    }
                    j jVar3 = new j(jSONObject);
                    ae = jVar3;
                    return jVar3;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return xt;
    }

    public static void j(int i6, JSONObject jSONObject) {
        j jVar;
        if (jSONObject == null || jSONObject == xt() || f38882m) {
            return;
        }
        tl<Integer, j> tlVar = f38881j;
        synchronized (tlVar) {
            try {
                j jVar2 = ae;
                if (jVar2 != null && jVar2.tl == jSONObject) {
                    jVar2.qv = i6;
                } else {
                    Iterator<j> it = tlVar.values().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            jVar = null;
                            break;
                        }
                        jVar = it.next();
                        if (jVar.tl == jSONObject) {
                            jVar.qv = i6;
                            break;
                        }
                    }
                    if (jVar == null) {
                        jVar2 = new j(jSONObject);
                        jVar2.qv = i6;
                    } else {
                        jVar2 = jVar;
                    }
                    ae = jVar2;
                }
                f38881j.put(Integer.valueOf(i6), jVar2);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
