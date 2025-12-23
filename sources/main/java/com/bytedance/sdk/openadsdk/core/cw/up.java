package com.bytedance.sdk.openadsdk.core.cw;

import android.content.SharedPreferences;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.openadsdk.core.v;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class up {
    private volatile String ae;

    /* renamed from: j, reason: collision with root package name */
    public String f28858j;

    /* renamed from: m, reason: collision with root package name */
    private volatile String f28859m;
    private volatile int cw = -1;

    /* renamed from: r, reason: collision with root package name */
    private volatile long f28860r = -1;
    private volatile float up = -1.0f;
    private volatile int tl = -1;

    /* renamed from: g, reason: collision with root package name */
    private volatile int f28857g = -1;
    private volatile int oq = -1;
    private volatile int qv = -1;
    private volatile int vl = 0;
    private volatile int jy = -1;
    private volatile int ws = -1;
    private volatile int az = -1;
    private volatile SharedPreferences xt = com.bytedance.sdk.openadsdk.api.plugin.xt.xt(v.getContext(), w(), 0);

    private static class j {

        /* renamed from: j, reason: collision with root package name */
        private static up f28861j = new up();
    }

    public static class xt {

        /* renamed from: j, reason: collision with root package name */
        private Map<String, Object> f28862j = new HashMap();

        public xt cw(int i6) {
            if (up.j().tl == i6) {
                return this;
            }
            up.j().tl = i6;
            this.f28862j.put("spl_cache_conf", Integer.valueOf(i6));
            return this;
        }

        public xt j(long j6) {
            if (up.j().f28860r == j6) {
                return this;
            }
            up.j().f28860r = j6;
            this.f28862j.put("duration", Long.valueOf(j6));
            return this;
        }

        public xt xt(String str) {
            if (str != null && str.equals(up.j().ae)) {
                return this;
            }
            up.j().ae = str;
            Map<String, Object> map = this.f28862j;
            if (str == null) {
                str = "";
            }
            map.put("ab_test_param", str);
            return this;
        }

        public xt ae(int i6) {
            if (up.j().vl != i6) {
                up.j().vl = i6;
                this.f28862j.put("splash_render_timeout_backup", Integer.valueOf(i6));
                return this;
            }
            return this;
        }

        public xt m(int i6) {
            if (up.j().f28857g != i6) {
                up.j().f28857g = i6;
                this.f28862j.put("spl_cache_expired", Integer.valueOf(i6));
                return this;
            }
            return this;
        }

        public xt r(int i6) {
            if (up.j().oq != i6) {
                up.j().oq = i6;
                this.f28862j.put("spl_thread_conf", Integer.valueOf(i6));
                return this;
            }
            return this;
        }

        public xt tl(int i6) {
            if (up.j().jy != i6) {
                up.j().jy = i6;
                this.f28862j.put("dl_storage_internal", Integer.valueOf(i6));
                return this;
            }
            return this;
        }

        public xt up(int i6) {
            if (up.j().qv != i6) {
                up.j().qv = i6;
                this.f28862j.put("spl_common_conf", Integer.valueOf(i6));
                return this;
            }
            return this;
        }

        public xt cw(String str) {
            if (str != null && str.equals(up.j().f28858j)) {
                return this;
            }
            up.j().f28858j = str;
            Map<String, Object> map = this.f28862j;
            if (str == null) {
                str = "";
            }
            map.put("drop_cache_black_conf", str);
            return this;
        }

        public xt j(int i6) {
            if (up.j().cw == i6) {
                return this;
            }
            up.j().cw = i6;
            this.f28862j.put("max", Integer.valueOf(i6));
            return this;
        }

        public xt xt(int i6) {
            if (up.j().ws == i6) {
                return this;
            }
            up.j().ws = i6;
            this.f28862j.put("cypher_version", Integer.valueOf(i6));
            return this;
        }

        public xt j(float f6) {
            if (up.j().up == f6) {
                return this;
            }
            up.j().up = f6;
            this.f28862j.put("aggMultiple", Float.valueOf(f6));
            return this;
        }

        public xt j(String str) {
            if (str != null && str.equals(up.j().f28859m)) {
                return this;
            }
            up.j().f28859m = str;
            Map<String, Object> map = this.f28862j;
            if (str == null) {
                str = "";
            }
            map.put("ab_test_version", str);
            return this;
        }

        public xt j(boolean z5) {
            this.f28862j.put("is_spl_cache_remove_change", Boolean.valueOf(z5));
            return this;
        }

        public xt j(JSONObject jSONObject) {
            int optInt;
            if (jSONObject == null || up.j().az == (optInt = jSONObject.optInt("splash_policy", 0))) {
                return this;
            }
            up.j().az = optInt;
            this.f28862j.put("splash_policy", Integer.valueOf(optInt));
            return this;
        }

        public void j() {
            try {
                if (!cw.j().xt()) {
                    SharedPreferences.Editor edit = up.j().xt.edit();
                    for (Map.Entry<String, Object> entry : this.f28862j.entrySet()) {
                        String key = entry.getKey();
                        Object value = entry.getValue();
                        if (value instanceof Boolean) {
                            edit.putBoolean(key, ((Boolean) value).booleanValue());
                        } else if (value instanceof Long) {
                            edit.putLong(key, ((Long) value).longValue());
                        } else if (value instanceof Float) {
                            edit.putFloat(key, ((Float) value).floatValue());
                        } else if (value instanceof Integer) {
                            edit.putInt(key, ((Integer) value).intValue());
                        } else if (value instanceof String) {
                            edit.putString(key, (String) value);
                        }
                    }
                    edit.commit();
                    return;
                }
                String w5 = up.w();
                for (Map.Entry<String, Object> entry2 : this.f28862j.entrySet()) {
                    String key2 = entry2.getKey();
                    Object value2 = entry2.getValue();
                    if (value2 instanceof Boolean) {
                        com.bytedance.sdk.component.ae.cw.j.xt.j(w5, key2, (Boolean) value2);
                    } else if (value2 instanceof Long) {
                        com.bytedance.sdk.component.ae.cw.j.xt.j(w5, key2, (Long) value2);
                    } else if (value2 instanceof Float) {
                        com.bytedance.sdk.component.ae.cw.j.xt.j(w5, key2, (Float) value2);
                    } else if (value2 instanceof Integer) {
                        com.bytedance.sdk.component.ae.cw.j.xt.j(w5, key2, (Integer) value2);
                    } else if (value2 instanceof String) {
                        com.bytedance.sdk.component.ae.cw.j.xt.j(w5, key2, (String) value2);
                    }
                }
            } catch (Exception e6) {
                vl.j(e6);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String w() {
        return "sp_exec_getad_config_bst";
    }

    public void av() {
        try {
            SharedPreferences.Editor edit = this.xt.edit();
            edit.clear();
            edit.apply();
        } catch (Throwable unused) {
        }
    }

    public int az() {
        if (this.az == -1) {
            this.az = j("splash_policy", 0);
        }
        return this.az;
    }

    public int jy() {
        if (this.qv == -1) {
            this.qv = j("spl_common_conf", 0);
        }
        return this.qv;
    }

    public boolean oq() {
        return j("is_spl_cache_remove_change", false);
    }

    public int qv() {
        if (this.tl == -1) {
            this.tl = j("spl_cache_conf", 14);
        }
        return this.tl;
    }

    public int vl() {
        if (this.oq == -1) {
            this.oq = j("spl_thread_conf", 1);
        }
        return this.oq;
    }

    public int ws() {
        if (this.vl <= 0) {
            this.vl = j("splash_render_timeout_backup", 100);
        }
        return this.vl;
    }

    public void ae() {
        this.ae = "";
        this.f28859m = "";
        j("ab_test_version", "");
        j("ab_test_param", "");
    }

    public int cw() {
        if (this.cw == -1) {
            this.cw = j("max", 50);
        }
        return this.cw;
    }

    public int g() {
        if (this.ws == -1) {
            this.ws = j("cypher_version", 40001);
        }
        return this.ws;
    }

    public String m() {
        if (this.ae == null) {
            this.ae = xt("ab_test_param", "");
        }
        return this.ae;
    }

    public float r() {
        if (this.up == -1.0f) {
            this.up = j("aggMultiple", -1.0f);
        }
        return this.up;
    }

    public boolean tl() {
        if (this.jy == -1) {
            this.jy = j("dl_storage_internal", 1);
        }
        return this.jy == 1;
    }

    public String up() {
        if (this.f28859m == null) {
            this.f28859m = xt("ab_test_version", "");
        }
        return this.f28859m;
    }

    public long xt() {
        if (this.f28860r == -1) {
            this.f28860r = j("duration", 10000L);
        }
        return this.f28860r;
    }

    public static up j() {
        return j.f28861j;
    }

    public boolean j(String str, boolean z5) {
        try {
            if (cw.j().xt()) {
                return com.bytedance.sdk.component.ae.cw.j.xt.j(w(), str, z5);
            }
            return this.xt.getBoolean(str, z5);
        } catch (Throwable unused) {
            return z5;
        }
    }

    public String xt(String str, String str2) {
        try {
            if (cw.j().xt()) {
                return com.bytedance.sdk.component.ae.cw.j.xt.xt(w(), str, str2);
            }
            return this.xt.getString(str, str2);
        } catch (Throwable unused) {
            return str2;
        }
    }

    public long j(String str, long j6) {
        try {
            if (cw.j().xt()) {
                return com.bytedance.sdk.component.ae.cw.j.xt.j(w(), str, j6);
            }
            return this.xt.getLong(str, j6);
        } catch (Throwable unused) {
            return j6;
        }
    }

    public float j(String str, float f6) {
        try {
            if (cw.j().xt()) {
                return com.bytedance.sdk.component.ae.cw.j.xt.j(w(), str, f6);
            }
            return this.xt.getFloat(str, f6);
        } catch (Throwable unused) {
            return f6;
        }
    }

    public int j(String str, int i6) {
        try {
            if (cw.j().xt()) {
                return com.bytedance.sdk.component.ae.cw.j.xt.j(w(), str, i6);
            }
            return this.xt.getInt(str, i6);
        } catch (Throwable unused) {
            return i6;
        }
    }

    public void j(String str, String str2) {
        try {
            if (cw.j().xt()) {
                com.bytedance.sdk.component.ae.cw.j.xt.j(w(), str, str2);
                return;
            }
            SharedPreferences.Editor edit = this.xt.edit();
            edit.putString(str, str2);
            edit.apply();
        } catch (Throwable unused) {
        }
    }
}
