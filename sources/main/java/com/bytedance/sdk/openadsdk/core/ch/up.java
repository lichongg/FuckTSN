package com.bytedance.sdk.openadsdk.core.ch;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.SparseArray;
import com.bykv.j.j.j.j.e;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.sdk.openadsdk.ats.ATS;
import com.bytedance.sdk.openadsdk.ats.ATSMethod;
import com.bytedance.sdk.openadsdk.core.h;
import com.bytedance.sdk.openadsdk.core.kt.ws;
import com.bytedance.sdk.openadsdk.core.rn.j;
import com.bytedance.sdk.openadsdk.core.v;
import com.umeng.analytics.pro.bi;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Function;
import org.json.JSONException;
import org.json.JSONObject;

@ATS(single = true, value = {"pitaya"})
/* loaded from: D:\Downloads\app\classes4.dex */
public class up implements cw, j.xt {
    private Function<SparseArray<Object>, Object> cw;

    /* renamed from: j, reason: collision with root package name */
    private AtomicBoolean f28021j = new AtomicBoolean(false);
    private AtomicBoolean xt = new AtomicBoolean(false);

    @Override // com.bytedance.sdk.openadsdk.core.ch.cw
    @ATSMethod(5)
    public void j(String str, com.bytedance.sdk.component.tl.j.xt xtVar) {
    }

    private Function<SparseArray<Object>, Object> ae() {
        Function<SparseArray<Object>, Object> j6 = v.j(10003);
        if (j6 != null && r()) {
            return j6;
        }
        return null;
    }

    private void tl() {
        if (this.cw == null) {
            this.cw = new ae() { // from class: com.bytedance.sdk.openadsdk.core.ch.up.2
                @Override // com.bytedance.sdk.openadsdk.core.ch.ae, com.bytedance.sdk.openadsdk.core.wq.r
                public <T> T applyFunction(int i6, PluginValueSet pluginValueSet, Class<T> cls) {
                    com.bytedance.sdk.openadsdk.i.j jVar = new com.bytedance.sdk.openadsdk.i.j((SparseArray) pluginValueSet.objectValue(-99999979, SparseArray.class));
                    try {
                        if (i6 != 1) {
                            if (i6 != 2) {
                                return (T) super.applyFunction(i6, pluginValueSet, cls);
                            }
                            JSONObject jSONObject = (JSONObject) jVar.r().objectValue(10, JSONObject.class);
                            String optString = jSONObject.optString(bi.f40962e);
                            String optString2 = jSONObject.optString("key");
                            String j6 = j.j().j(optString, optString2);
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put(optString2, j6);
                            return (T) com.bytedance.sdk.openadsdk.i.r.j().j(37, jSONObject2).xt();
                        }
                        JSONObject jSONObject3 = (JSONObject) jVar.r().objectValue(10, JSONObject.class);
                        j.j().j(jSONObject3.optString(bi.f40962e), jSONObject3.optString("key"), jSONObject3.optString("value"));
                        JSONObject jSONObject4 = new JSONObject();
                        jSONObject4.put("success", true);
                        return (T) com.bytedance.sdk.openadsdk.i.r.j().j(37, jSONObject4).xt();
                    } catch (JSONException e6) {
                        com.bytedance.sdk.component.utils.vl.j(e6);
                        return (T) com.bytedance.sdk.openadsdk.i.r.j().j(37, new JSONObject()).xt();
                    }
                }
            };
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.ch.cw
    @ATSMethod(3)
    public boolean r() {
        return this.xt.get();
    }

    public boolean up() {
        String str = Build.MANUFACTURER;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.toLowerCase().contains("oppo") || str.toLowerCase().contains("realme");
    }

    @Override // com.bytedance.sdk.openadsdk.core.rn.j.xt
    public void xt() {
        Function<SparseArray<Object>, Object> ae;
        try {
            if (com.bytedance.sdk.openadsdk.core.oq.i().la() || (ae = ae()) == null) {
                return;
            }
            ae.apply(com.bytedance.sdk.openadsdk.i.r.j().j(1008).j(Void.class).j(36, 1).xt());
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.vl.j(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        com.bytedance.sdk.openadsdk.core.rn.j r5 = com.bytedance.sdk.openadsdk.core.oq.i().r();
        if (r5 != null) {
            r5.j(this);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.ch.cw
    @ATSMethod(2)
    public boolean cw() {
        int i6;
        if (!h.j() || h.xt < 5003 || (i6 = Build.VERSION.SDK_INT) < 28) {
            return false;
        }
        if (up() && i6 == 29) {
            return false;
        }
        return com.bytedance.sdk.openadsdk.core.mi.xt.xt(v.xt().la());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(long j6, r rVar) {
        ws.j().j(j6, rVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.rn.j.xt
    public void j() {
        Function<SparseArray<Object>, Object> ae;
        try {
            if (com.bytedance.sdk.openadsdk.core.oq.i().la() || (ae = ae()) == null) {
                return;
            }
            ae.apply(com.bytedance.sdk.openadsdk.i.r.j().j(1008).j(Void.class).j(36, 0).xt());
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.vl.j(th);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.ch.cw
    @ATSMethod(4)
    public void j(String str, JSONObject jSONObject, Function<SparseArray<Object>, Object> function) {
        Function<SparseArray<Object>, Object> j6 = v.j(10003);
        if (j6 == null) {
            if (function != null) {
                function.apply(com.bytedance.sdk.openadsdk.i.r.j().j(8).j(Void.class).j(-99999979, com.bytedance.sdk.openadsdk.i.up.j().j(-6).j(false).j("predict bridge is null").j(com.bytedance.sdk.openadsdk.i.r.j().j(5, str).xt()).xt()).xt());
                return;
            }
            return;
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("run_package_start", System.currentTimeMillis());
        } catch (JSONException e6) {
            com.bytedance.sdk.component.utils.vl.j(e6);
        }
        j6.apply(com.bytedance.sdk.openadsdk.i.r.j().j(1003).j(Void.class).j(25, str).j(26, jSONObject).j(1, function).j(37, jSONObject2).xt());
    }

    @Override // com.bytedance.sdk.openadsdk.core.ch.cw
    @ATSMethod(1)
    public void j(Context context, final Function<SparseArray<Object>, Object> function) {
        final long currentTimeMillis = System.currentTimeMillis();
        if (v.j(10003) == null) {
            if (function != null) {
                function.apply(com.bytedance.sdk.openadsdk.i.r.j().j(-1).j(Void.class).xt());
                return;
            }
            return;
        }
        if (r()) {
            if (function != null) {
                function.apply(com.bytedance.sdk.openadsdk.i.r.j().j(0).j(Void.class).xt());
                return;
            }
            return;
        }
        try {
            if (this.f28021j.compareAndSet(false, true)) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(CommonNetImpl.AID, "1371");
                jSONObject.put("channel", h.f29117m);
                jSONObject.put("core_api_version", h.cw);
                jSONObject.put("core_plugin_version", "7.0.1.2");
                jSONObject.put("debug", false);
                jSONObject.put("update", true);
                jSONObject.put("download_concurrency", 2);
                jSONObject.put("py_concurrency", 2);
                jSONObject.put("provide_applog", true);
                jSONObject.put("sdk_session_id", com.bytedance.sdk.openadsdk.core.kt.xt.f29419j);
                tl();
                function.apply(com.bytedance.sdk.openadsdk.i.r.j(e.a().f(21, jSONObject).f(22, context).f(38, this.cw).f(1, new ae() { // from class: com.bytedance.sdk.openadsdk.core.ch.up.1
                    @Override // com.bytedance.sdk.openadsdk.core.ch.ae
                    protected PluginValueSet j(int i6, r rVar) {
                        up.this.xt.set(rVar.j());
                        if (rVar.j()) {
                            Function function2 = function;
                            if (function2 != null) {
                                function2.apply(com.bytedance.sdk.openadsdk.i.r.j().j(0).j(Void.class).xt());
                            }
                            up.this.m();
                        } else {
                            if (rVar.xt() != null) {
                                com.bytedance.sdk.component.utils.vl.r("pitaya_ext_plugin", "pit error:" + rVar.xt().toString());
                            }
                            Function function3 = function;
                            if (function3 != null) {
                                function3.apply(com.bytedance.sdk.openadsdk.i.r.j().j(-1).j(Void.class).xt());
                            }
                        }
                        up.this.j(System.currentTimeMillis() - currentTimeMillis, rVar);
                        return super.j(i6, rVar);
                    }
                }).f(13, com.bytedance.sdk.component.oq.ae.j()).k().sparseArray()).j(1001).j(Void.class).xt());
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.vl.r("pitaya_ext_plugin", "pit#initPit:" + th.getMessage());
            if (function != null) {
                function.apply(com.bytedance.sdk.openadsdk.i.r.j().j(-1).j(Void.class).xt());
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.ch.cw
    @ATSMethod(6)
    public void j(String str, Function<SparseArray<Object>, Object> function) {
        Function<SparseArray<Object>, Object> j6 = v.j(10003);
        if (j6 != null) {
            e a6 = e.a();
            a6.f(1, function);
            a6.g(25, str);
            j6.apply(com.bytedance.sdk.openadsdk.i.r.j(a6.k().sparseArray()).j(1004).j(Void.class).xt());
        }
    }
}
