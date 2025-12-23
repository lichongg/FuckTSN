package com.bytedance.sdk.openadsdk.core.live;

import android.content.Context;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import androidx.core.view.MotionEventCompat;
import com.bytedance.sdk.openadsdk.core.h;
import com.bytedance.sdk.openadsdk.core.live.j.ae;
import com.bytedance.sdk.openadsdk.core.live.j.r;
import com.bytedance.sdk.openadsdk.core.live.j.up;
import com.bytedance.sdk.openadsdk.core.p.g;
import com.bytedance.sdk.openadsdk.core.tj.c;
import com.bytedance.sdk.openadsdk.core.tj.n;
import com.bytedance.sdk.openadsdk.core.v;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import java.util.Map;
import java.util.function.Function;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class xt {

    /* renamed from: j, reason: collision with root package name */
    private final r f29495j;

    private static final class j {

        /* renamed from: j, reason: collision with root package name */
        private static final xt f29499j = new xt();
    }

    public static final xt j() {
        return j.f29499j;
    }

    public int cw() {
        return this.f29495j.xt();
    }

    public void r() {
        this.f29495j.r();
    }

    public int up() {
        return this.f29495j.up();
    }

    public int xt(Context context, n nVar, Map<String, Object> map) {
        return this.f29495j.xt(context, nVar, map);
    }

    private xt() {
        if (!g.j()) {
            this.f29495j = new com.bytedance.sdk.openadsdk.core.live.j.xt();
            return;
        }
        if (h.up) {
            this.f29495j = new ae();
        } else if (h.m()) {
            this.f29495j = new up();
        } else {
            this.f29495j = new com.bytedance.sdk.openadsdk.core.live.j.xt();
        }
    }

    public String ae() {
        return this.f29495j.ae();
    }

    public int cw(n nVar) {
        if (v.xt().fz()) {
            return this.f29495j.b_(nVar);
        }
        return 0;
    }

    public long g() {
        return this.f29495j.cw();
    }

    public void j(Function<SparseArray<Object>, Object> function) {
        this.f29495j.j(function);
    }

    public void r(final n nVar) {
        long startElapsedRealtime;
        if (nVar == null) {
            return;
        }
        up(nVar);
        if (TextUtils.isEmpty(nVar.re())) {
            return;
        }
        int cw = com.bytedance.sdk.openadsdk.core.cw.r.j().cw() + 1;
        if (cw > 100) {
            cw = 100;
        }
        com.bytedance.sdk.openadsdk.core.cw.r.j().j(cw);
        final int cw2 = cw();
        final int up = up();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        startElapsedRealtime = Process.getStartElapsedRealtime();
        final long j6 = elapsedRealtime - startElapsedRealtime;
        if (nVar.ww() == 1 && nVar.li() == 1) {
            com.bytedance.sdk.openadsdk.core.kt.xt.cw().j(new com.bytedance.sdk.openadsdk.vl.j.j() { // from class: com.bytedance.sdk.openadsdk.core.live.xt.1
                @Override // com.bytedance.sdk.openadsdk.vl.j.j
                public com.bytedance.sdk.openadsdk.core.kt.j.j j() throws Exception {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put(SocializeProtocolConstants.PROTOCOL_KEY_EXTEND, nVar.os());
                        jSONObject.put("live_sdk_status", cw2);
                        jSONObject.put("live_auth_status", up);
                        jSONObject.put("app_start_time", j6);
                        jSONObject.put("is_web", nVar.j());
                    } catch (Throwable unused) {
                    }
                    return com.bytedance.sdk.openadsdk.core.kt.j.xt.xt().j("saas_miss").xt(jSONObject.toString());
                }
            }, "saas_miss", true);
        }
    }

    public JSONObject tl() {
        return this.f29495j.tl();
    }

    public void up(n nVar) {
        this.f29495j.r(nVar);
    }

    public boolean xt(n nVar) {
        if (nVar == null || TextUtils.isEmpty(nVar.re())) {
            return false;
        }
        return j(nVar.re(), nVar.ww());
    }

    public int j(Context context, n nVar, Map<String, Object> map) {
        if (context == null || nVar == null) {
            return 5;
        }
        return this.f29495j.j(context, nVar, map);
    }

    public int m() {
        return com.bytedance.sdk.openadsdk.core.cw.r.j().cw();
    }

    public void j(String str, boolean z5) {
        this.f29495j.j(str, z5);
    }

    public void xt() {
        this.f29495j.j();
    }

    public int j(n nVar, com.bytedance.sdk.openadsdk.core.live.j.cw cwVar, String str) {
        return this.f29495j.j(nVar, cwVar, str);
    }

    public boolean j(n nVar) {
        return this.f29495j.j(nVar);
    }

    public void j(String str, n nVar, long j6) {
        this.f29495j.j(str, nVar, j6);
    }

    public boolean j(String str, int i6) {
        return this.f29495j.j(str, i6);
    }

    public void j(View view, c cVar, Map<String, Object> map, Map<String, Object> map2) {
        Object tag;
        if (view == null || cVar == null || (tag = view.getTag(67108864)) == null || !(tag instanceof Integer)) {
            return;
        }
        int intValue = ((Integer) tag).intValue();
        int i6 = intValue & 255;
        int i7 = (intValue & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >>> 8;
        if (i6 <= 0 || i7 <= 0) {
            return;
        }
        if (i6 == 101 && !cVar.cw()) {
            i6 = 102;
        }
        map.put("live_saas_param_interaction_type", Integer.valueOf(i6));
        map2.put("click_saas_area", Integer.valueOf(i7));
    }

    public int j(String str) {
        return this.f29495j.j(str);
    }

    public int j(com.bytedance.sdk.openadsdk.core.live.xt.xt xtVar, boolean z5) {
        return this.f29495j.j(xtVar, z5);
    }

    public void j(com.bytedance.sdk.openadsdk.av.r rVar) {
        this.f29495j.j(rVar);
    }
}
