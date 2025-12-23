package com.bytedance.sdk.openadsdk.core.rn;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.sdk.component.r.j.xt;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public final class s {
    private static AtomicBoolean xt = new AtomicBoolean(true);

    /* renamed from: j, reason: collision with root package name */
    public static volatile Map<String, Boolean> f30154j = new ConcurrentHashMap();

    private static final class j {

        /* renamed from: j, reason: collision with root package name */
        private static final com.bytedance.sdk.component.r.j.xt f30155j;

        static {
            com.bytedance.sdk.component.r.j.xt xt = com.bytedance.sdk.openadsdk.ats.cw.xt("tt_scheme_check_list_cache");
            f30155j = xt;
            File cw = com.bytedance.sdk.openadsdk.ats.cw.cw("tt_scheme_check_list_cache");
            if (!cw.exists() || cw.length() <= 0) {
                return;
            }
            xt.j(new xt.j<Map<String, ?>>() { // from class: com.bytedance.sdk.openadsdk.core.rn.s.j.1
                @Override // com.bytedance.sdk.component.r.j.xt.j
                public void j(Map<String, ?> map) {
                    Object obj;
                    boolean contains = j.f30155j.contains(".i.tt_ect");
                    com.bytedance.sdk.component.utils.vl.xt("SchemeCacheUtils", "clear old cache! ");
                    if (contains) {
                        return;
                    }
                    j.f30155j.j();
                    com.bytedance.sdk.component.ae.j.j jVar = new com.bytedance.sdk.component.ae.j.j();
                    for (String str : map.keySet()) {
                        if (!str.contains("//") && (obj = map.get(str)) != null) {
                            String valueOf = String.valueOf(jVar.xt(obj));
                            String str2 = (String) jVar.xt(str);
                            if (str2 != null && str2.contains("//")) {
                                try {
                                    j.f30155j.j(s.j(Uri.parse(str2)), String.valueOf(new JSONObject(valueOf).opt(str2)));
                                } catch (Exception unused) {
                                }
                            }
                        }
                    }
                }
            });
        }
    }

    public static void j(String str, Boolean bool) {
        String bool2;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (bool == null) {
            bool2 = "";
        } else {
            try {
                bool2 = bool.toString();
            } catch (Throwable unused) {
                return;
            }
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("value", bool2);
        jSONObject.put("time", System.currentTimeMillis());
        j.f30155j.j(str, jSONObject.toString());
        xt.set(true);
    }

    public static Map<String, Boolean> xt(long j6) {
        HashMap hashMap = new HashMap();
        try {
            Map<String, ?> all = j.f30155j.getAll();
            if (all != null && !all.isEmpty()) {
                for (Map.Entry<String, ?> entry : all.entrySet()) {
                    JSONObject jSONObject = new JSONObject(entry.getValue().toString());
                    long currentTimeMillis = System.currentTimeMillis() - jSONObject.getLong("time");
                    String key = entry.getKey();
                    if (currentTimeMillis > 259200000) {
                        j(key);
                    } else if (currentTimeMillis <= j6) {
                        hashMap.put(key, Boolean.valueOf(Boolean.parseBoolean(jSONObject.get("value").toString())));
                    }
                }
                if (f30154j == null) {
                    f30154j = new ConcurrentHashMap();
                } else {
                    f30154j.clear();
                }
                f30154j.putAll(hashMap);
            }
        } catch (Throwable unused) {
        }
        return hashMap;
    }

    private s() {
    }

    public static Map<String, Boolean> j(long j6) {
        try {
            if (xt.get()) {
                synchronized (s.class) {
                    try {
                        if (xt.get()) {
                            Map<String, Boolean> xt2 = xt(j6);
                            xt.set(false);
                            return xt2;
                        }
                    } finally {
                    }
                }
            }
            return new HashMap(f30154j);
        } catch (Throwable unused) {
            return new HashMap();
        }
    }

    private static JSONObject xt(String str) {
        String xt2 = j.f30155j.xt(str, "");
        if (TextUtils.isEmpty(xt2)) {
            return null;
        }
        try {
            return new JSONObject(xt2);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Boolean j(String str, long j6) {
        JSONObject xt2;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            xt2 = xt(str);
        } catch (Throwable unused) {
        }
        if (xt2 == null) {
            return null;
        }
        if (System.currentTimeMillis() - xt2.getLong("time") <= j6) {
            return Boolean.valueOf(Boolean.parseBoolean(xt2.getString("value")));
        }
        return null;
    }

    private static void j(String str) {
        j.f30155j.j(str);
    }

    public static String j(Uri uri) {
        if (uri == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(uri.getScheme());
        sb.append("://");
        sb.append(uri.getHost());
        int port = uri.getPort();
        if (port > 0) {
            sb.append(":");
            sb.append(port);
        }
        String path = uri.getPath();
        if (!TextUtils.isEmpty(path)) {
            sb.append(path);
        }
        return sb.toString();
    }
}
