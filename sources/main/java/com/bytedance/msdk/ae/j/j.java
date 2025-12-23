package com.bytedance.msdk.ae.j;

import android.text.TextUtils;
import androidx.work.PeriodicWorkRequest;
import com.bytedance.msdk.core.up.xt.r;
import com.bytedance.msdk.tl.l;
import com.bytedance.sdk.component.utils.vl;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes3.dex */
public class j {

    /* renamed from: j, reason: collision with root package name */
    private static volatile j f24316j;
    private int cw = -1;

    /* renamed from: r, reason: collision with root package name */
    private long f24319r = -1;
    private int up = -1;

    /* renamed from: m, reason: collision with root package name */
    private int f24318m = -1;
    private int ae = -1;
    private int tl = -1;

    /* renamed from: g, reason: collision with root package name */
    private int f24317g = -1;
    private l xt = com.bytedance.msdk.ae.j.xt();

    public static j j() {
        if (f24316j == null) {
            synchronized (j.class) {
                try {
                    if (f24316j == null) {
                        f24316j = new j();
                    }
                } finally {
                }
            }
        }
        return f24316j;
    }

    private synchronized JSONObject oq() {
        try {
            String xt = this.xt.xt("app_common_config");
            if (TextUtils.isEmpty(xt)) {
                return null;
            }
            if (!xt.startsWith("[") && !xt.startsWith("{")) {
                xt = com.bytedance.msdk.tl.j.xt(xt, com.bytedance.msdk.tl.xt.j());
            }
            if (!TextUtils.isEmpty(xt)) {
                try {
                    return new JSONObject(xt);
                } catch (Throwable th) {
                    vl.j(th);
                }
            }
            return null;
        } catch (Throwable th2) {
            throw th2;
        }
    }

    private synchronized void xt(JSONObject jSONObject) {
        try {
            int optInt = jSONObject.optInt("event_batch_size", 100);
            this.cw = optInt;
            if (optInt <= 0 || optInt > 1000) {
                this.cw = 100;
            }
            long optLong = jSONObject.optLong("event_routine_interval", 120000L);
            this.f24319r = optLong;
            if (optLong < 10000 || optLong > PeriodicWorkRequest.MIN_PERIODIC_FLEX_MILLIS) {
                this.f24319r = 120000L;
            }
            int optInt2 = jSONObject.optInt("dynamic_adapter_type", 0);
            this.up = optInt2;
            if (optInt2 != 0 && optInt2 != 1) {
                this.up = 0;
            }
            this.ae = jSONObject.optInt("rv_start_time", 5000);
            int optInt3 = jSONObject.optInt("wf_dynamic_adapter_type", 0);
            this.f24318m = optInt3;
            if (optInt3 != 0 && optInt3 != 1) {
                this.f24318m = 0;
            }
            r.j().j(jSONObject.optInt("pre_fetch_count", 20));
            this.tl = jSONObject.optInt("adapter_plugin_loader_gdt", -1);
            this.f24317g = jSONObject.optInt("can_log", -1);
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized boolean ae() {
        JSONObject oq;
        int i6 = this.tl;
        if (i6 != -1) {
            return i6 == 1;
        }
        if (this.xt == null || (oq = oq()) == null) {
            return false;
        }
        xt(oq);
        return this.tl == 1;
    }

    public synchronized long cw() {
        JSONObject oq;
        long j6 = this.f24319r;
        if (j6 != -1) {
            return j6;
        }
        if (this.xt == null || (oq = oq()) == null) {
            return 120000L;
        }
        xt(oq);
        return this.f24319r;
    }

    public boolean g() {
        JSONObject oq;
        int i6 = this.f24317g;
        if (i6 != -1) {
            return i6 == 1;
        }
        if (this.xt != null && (oq = oq()) != null) {
            xt(oq);
            if (this.f24317g == 1) {
                return true;
            }
        }
        return false;
    }

    public int m() {
        JSONObject oq;
        int i6 = this.ae;
        if (i6 != -1) {
            return i6;
        }
        if (this.xt == null || (oq = oq()) == null) {
            return 5000;
        }
        xt(oq);
        return this.ae;
    }

    public int r() {
        JSONObject oq;
        int i6 = this.up;
        if (i6 != -1) {
            return i6;
        }
        if (this.xt == null || (oq = oq()) == null) {
            return 0;
        }
        xt(oq);
        return this.up;
    }

    public int tl() {
        return this.tl;
    }

    public int up() {
        JSONObject oq;
        int i6 = this.f24318m;
        if (i6 != -1) {
            return i6;
        }
        if (this.xt == null || (oq = oq()) == null) {
            return 0;
        }
        xt(oq);
        return this.f24318m;
    }

    private j() {
    }

    public synchronized void j(JSONObject jSONObject) {
        if (jSONObject != null) {
            xt(jSONObject);
            String jSONObject2 = jSONObject.toString();
            if (!TextUtils.isEmpty(jSONObject2)) {
                this.xt.j("app_common_config", jSONObject2);
            }
        }
    }

    public synchronized int xt() {
        JSONObject oq;
        int i6 = this.cw;
        if (i6 != -1) {
            return i6;
        }
        if (this.xt == null || (oq = oq()) == null) {
            return 100;
        }
        xt(oq);
        return this.cw;
    }
}
