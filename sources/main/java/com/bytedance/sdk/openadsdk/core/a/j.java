package com.bytedance.sdk.openadsdk.core.a;

import android.os.Build;
import com.bytedance.sdk.openadsdk.core.a.j.cw;
import com.bytedance.sdk.openadsdk.core.a.j.xt;
import com.bytedance.sdk.openadsdk.core.cw.r;
import com.bytedance.sdk.openadsdk.core.oq;
import com.bytedance.sdk.openadsdk.core.v;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j {

    /* renamed from: j, reason: collision with root package name */
    private static j f27810j = new j();
    private volatile int xt = -1;
    private volatile long cw = 0;

    /* renamed from: r, reason: collision with root package name */
    private volatile long f27811r = 0;

    public static j j() {
        return f27810j;
    }

    public long xt() {
        return this.cw;
    }

    public long cw() {
        return this.f27811r;
    }

    public void j(long j6, long j7) {
        this.cw = j6;
        this.f27811r = j7;
    }

    public boolean up() {
        return this.xt == 0 || this.xt == 3;
    }

    public boolean xt(JSONObject jSONObject) {
        JSONArray optJSONArray;
        if (jSONObject != null && (optJSONArray = jSONObject.optJSONArray("callback")) != null && optJSONArray.length() != 0) {
            for (int i6 = 0; i6 < optJSONArray.length(); i6++) {
                if (j(optJSONArray.optString(i6))) {
                    return true;
                }
            }
        }
        return false;
    }

    private j() {
    }

    public int m() {
        if (!oq.i().up()) {
            return 0;
        }
        if (this.xt == -1) {
            int kt = r.j().kt();
            if (kt == -1) {
                if (v.xt().wf() == null) {
                    this.xt = 1;
                } else {
                    this.xt = 2;
                }
            } else {
                this.xt = kt;
            }
        }
        return this.xt;
    }

    public void r() {
        JSONObject wf = v.xt().wf();
        if (wf == null) {
            this.xt = 1;
        }
        if (j(wf)) {
            new cw().j(wf, this.xt);
        } else if (xt(wf)) {
            new xt().j(wf, this.xt);
        } else {
            this.xt = 1;
        }
    }

    public boolean j(String str) {
        String str2 = Build.MANUFACTURER;
        String str3 = Build.BRAND;
        if (str2 != null && str3 != null) {
            return str2.equalsIgnoreCase(str) || str3.equalsIgnoreCase(str);
        }
        if (str2 != null) {
            return str2.equalsIgnoreCase(str);
        }
        if (str3 != null) {
            return str3.equalsIgnoreCase(str);
        }
        return false;
    }

    public void j(int i6) {
        if (this.xt != i6) {
            r.j().m(i6);
        }
        this.xt = i6;
    }

    public boolean j(JSONObject jSONObject) {
        JSONArray optJSONArray;
        if (jSONObject != null && (optJSONArray = jSONObject.optJSONArray("register")) != null && optJSONArray.length() != 0) {
            for (int i6 = 0; i6 < optJSONArray.length(); i6++) {
                if (j(optJSONArray.optString(i6))) {
                    return true;
                }
            }
        }
        return false;
    }
}
