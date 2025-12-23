package com.bytedance.sdk.openadsdk.core.m;

import android.text.TextUtils;
import com.bytedance.sdk.component.g.xt.r;
import com.bytedance.sdk.component.oq.ae;
import com.bytedance.sdk.component.oq.g;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.openadsdk.api.plugin.PluginConstants;
import com.bytedance.sdk.openadsdk.core.h;
import com.bytedance.sdk.openadsdk.core.oq;
import com.bytedance.sdk.openadsdk.core.rn.gx;
import com.bytedance.sdk.openadsdk.core.rn.j;
import com.bytedance.sdk.openadsdk.core.rn.uf;
import com.bytedance.sdk.openadsdk.core.v;
import com.bytedance.sdk.openadsdk.core.v.up;
import java.io.IOException;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j implements j.xt {

    /* renamed from: j, reason: collision with root package name */
    private static volatile j f29510j = null;

    /* renamed from: m, reason: collision with root package name */
    private static final HashSet f29511m;

    /* renamed from: r, reason: collision with root package name */
    private static final String f29512r = "com.bytedance.sdk.openadsdk.core.m.j";
    private static HashMap<String, Long> up;
    private com.bytedance.sdk.openadsdk.core.rn.j cw;
    private CopyOnWriteArrayList<JSONObject> xt = new CopyOnWriteArrayList<>();

    @Override // com.bytedance.sdk.openadsdk.core.rn.j.xt
    public void j() {
    }

    static {
        String name = j.class.getName();
        up = new HashMap<>();
        f29511m = new HashSet(Arrays.asList("dalvik.system.VMStack.getThreadStackTrace", "java.lang.Thread.getStackTrace", name));
    }

    public static j cw() {
        if (f29510j == null) {
            synchronized (j.class) {
                try {
                    if (f29510j == null) {
                        f29510j = new j();
                    }
                } finally {
                }
            }
        }
        return f29510j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        CopyOnWriteArrayList<JSONObject> copyOnWriteArrayList = this.xt;
        if (copyOnWriteArrayList == null || copyOnWriteArrayList.size() <= 0) {
            return;
        }
        JSONArray jSONArray = new JSONArray();
        Iterator<JSONObject> it = this.xt.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next());
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("stats_list", jSONArray);
        } catch (JSONException e6) {
            vl.j(e6);
        }
        this.xt.clear();
        String g6 = uf.g("/api/ad/union/sdk/callstack/batch/");
        gx gxVar = new gx(up.j().xt().m());
        gxVar.j(g6);
        gxVar.cw(jSONObject, "callstack");
        gxVar.j(new com.bytedance.sdk.component.g.j.j() { // from class: com.bytedance.sdk.openadsdk.core.m.j.2
            @Override // com.bytedance.sdk.component.g.j.j
            public void j(r rVar, com.bytedance.sdk.component.g.xt xtVar) {
                if (xtVar != null) {
                    vl.j("CallChainStatistic", Boolean.valueOf(xtVar.tl()), xtVar.r());
                } else {
                    vl.j("CallChainStatistic", "NetResponse is null");
                }
            }

            @Override // com.bytedance.sdk.component.g.j.j
            public void j(r rVar, IOException iOException) {
                vl.j("CallChainStatistic", iOException.getMessage());
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.rn.j.xt
    public void xt() {
        if (oq.i().la()) {
            return;
        }
        r();
    }

    private j() {
        com.bytedance.sdk.openadsdk.core.rn.j r5 = oq.i().r();
        this.cw = r5;
        if (r5 != null) {
            r5.xt(this);
        }
    }

    public void j(int i6, com.bytedance.sdk.openadsdk.i.cw.cw.xt xtVar) {
        if (xtVar == null) {
            return;
        }
        j(i6, xtVar.r());
    }

    private boolean j(Long l6) {
        return !j(new Date(), new Date(l6.longValue()));
    }

    private boolean j(Date date, Date date2) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(date2);
        return calendar.get(1) == calendar2.get(1) && calendar.get(2) == calendar2.get(2) && calendar.get(5) == calendar2.get(5);
    }

    private boolean j(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            Long l6 = up.get(str);
            if (l6 != null && l6.longValue() != 0) {
                if (!j(l6)) {
                    return false;
                }
            } else {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis > 0) {
                    up.put(str, Long.valueOf(currentTimeMillis));
                }
            }
            return true;
        } catch (Throwable th) {
            vl.cw("callstack error:" + th.getMessage());
            return true;
        }
    }

    public void j(final int i6, final String str) {
        if (xt.j() && j(str)) {
            final StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            ae.j(new g("callChainStatistic") { // from class: com.bytedance.sdk.openadsdk.core.m.j.1
                @Override // java.lang.Runnable
                public void run() {
                    j.this.xt.add(j.this.j(i6, str, stackTrace));
                    if (j.this.xt.size() < 3) {
                        return;
                    }
                    try {
                        j.this.r();
                    } catch (OutOfMemoryError e6) {
                        vl.j(e6);
                    }
                }
            }, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject j(int i6, String str, Object obj) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("rit", str);
            jSONObject.put("appid", oq.i().f());
            jSONObject.put("app_version", uf.qv());
            jSONObject.put("ad_sdk_version", h.cw);
            jSONObject.put(PluginConstants.KEY_PLUGIN_VERSION, "7.0.1.2");
            jSONObject.put("adtype", i6);
            jSONObject.put("timestamp", System.currentTimeMillis());
            jSONObject.put("callstack", j(obj));
            jSONObject.put("type", "callstack");
            jSONObject.put("device_info", com.bytedance.sdk.openadsdk.core.cw.j.j(v.getContext(), i6));
            return jSONObject;
        } catch (JSONException e6) {
            vl.j(e6);
            return jSONObject;
        }
    }

    private JSONArray j(Object obj) {
        JSONArray jSONArray = new JSONArray();
        if (obj != null) {
            for (StackTraceElement stackTraceElement : (StackTraceElement[]) obj) {
                if (stackTraceElement != null) {
                    if (!f29511m.contains(stackTraceElement.getClassName() + "." + stackTraceElement.getMethodName())) {
                        String className = stackTraceElement.getClassName();
                        if (className != null && className.startsWith("android.app")) {
                            break;
                        }
                        jSONArray.put(stackTraceElement.toString());
                    } else {
                        continue;
                    }
                }
            }
        }
        return jSONArray;
    }
}
