package com.bytedance.sdk.openadsdk.core.ch;

import android.text.TextUtils;
import android.util.SparseArray;
import com.baidu.idl.face.platform.common.ConstantHelper;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.sdk.component.utils.ws;
import com.bytedance.sdk.openadsdk.ats.AutoService;
import com.bytedance.sdk.openadsdk.core.h;
import com.bytedance.sdk.openadsdk.core.kt;
import com.bytedance.sdk.openadsdk.core.rn.uf;
import com.bytedance.sdk.openadsdk.core.tj.n;
import com.bytedance.sdk.openadsdk.core.v;
import com.bytedance.sdk.openadsdk.core.wq;
import com.huawei.hms.framework.common.hianalytics.WiseOpenHianalyticsData;
import com.umeng.analytics.pro.bi;
import java.util.Calendar;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class jy {

    /* renamed from: j, reason: collision with root package name */
    private static final ConcurrentHashMap<String, JSONObject> f28012j = new ConcurrentHashMap<>();
    private static AtomicInteger xt = new AtomicInteger();
    private JSONObject cw;

    /* renamed from: r, reason: collision with root package name */
    private JSONObject f28013r;

    private JSONObject xt(com.bykv.vk.openvk.component.video.api.cw.r rVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            n j6 = com.bytedance.sdk.openadsdk.core.video.r.xt.j(rVar);
            if (j6 != null) {
                String j7 = uf.j(j6, "");
                int parseInt = !TextUtils.isEmpty(j7) ? Integer.parseInt(j7) : 0;
                int tl = uf.tl(j6);
                jSONObject.put("video_count", com.bytedance.sdk.openadsdk.m.xt.xt.j());
                JSONObject j8 = j();
                jSONObject.put(ConstantHelper.LOG_DE, j8);
                JSONObject j9 = j(rVar, parseInt, tl);
                jSONObject.put("current_video", j9);
                jSONObject.put("predict_use", j(String.valueOf(parseInt)));
                jSONObject.put("csj_plugin", xt());
                jSONObject.put(WiseOpenHianalyticsData.UNION_PACKAGE, xt("video_cache"));
                jSONObject.put("hour", j8.optInt("hour"));
                jSONObject.put("video_size", rVar.vl());
                jSONObject.put("rit", parseInt);
                jSONObject.put("preload_size", rVar.m());
                jSONObject.put(bi.Q, j8.optString(bi.Q));
                jSONObject.put("sdk_fg_time", j8.optLong("sdk_fg_time"));
                jSONObject.put("ad_slot_type", j9.optInt("ad_slot_type"));
            }
            return jSONObject;
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.vl.j(th);
            return jSONObject;
        }
    }

    private static String j(int i6, String str) {
        int incrementAndGet = xt.incrementAndGet();
        return i6 + "-" + kt.cw() + "-" + incrementAndGet + "-" + str + "-" + System.currentTimeMillis();
    }

    private static JSONObject j(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return f28012j.get(str);
    }

    public static void j(int i6, long j6, n nVar, com.bykv.vk.openvk.component.video.api.cw.r rVar) {
        com.bytedance.sdk.openadsdk.i.cw.cw.xt rr;
        if (nVar == null || rVar == null || (rr = nVar.rr()) == null) {
            return;
        }
        try {
            JSONObject j7 = j(rr.r());
            if (j7 != null) {
                String i7 = rVar.i();
                String optString = j7.optString("trace_id");
                if (!TextUtils.isEmpty(optString) && optString.contains(i7)) {
                    j7.put("play_type", i6);
                    j7.put("cache_size", j6);
                }
            }
        } catch (Exception e6) {
            com.bytedance.sdk.component.utils.vl.j(e6);
        }
    }

    public static void j(long j6, n nVar, com.bykv.vk.openvk.component.video.api.cw.r rVar) {
        com.bytedance.sdk.openadsdk.i.cw.cw.xt rr;
        if (nVar == null || rVar == null || (rr = nVar.rr()) == null) {
            return;
        }
        try {
            JSONObject j7 = j(rr.r());
            if (j7 != null) {
                String optString = j7.optString("trace_id");
                if (!TextUtils.isEmpty(optString) && optString.contains(rVar.i())) {
                    j7.put("play_duration", j6);
                    j7.put("pitaya_meet_cache", 1);
                }
            }
        } catch (Exception e6) {
            com.bytedance.sdk.component.utils.vl.j(e6);
        }
    }

    private JSONObject j() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(bi.Q, ws.ae(v.getContext()));
            jSONObject.put("hour", Calendar.getInstance().get(11));
            long currentTimeMillis = System.currentTimeMillis() - com.bytedance.sdk.openadsdk.core.rn.j.xt;
            if (currentTimeMillis <= 0) {
                return jSONObject;
            }
            jSONObject.put("sdk_fg_time", currentTimeMillis);
            return jSONObject;
        } catch (Exception e6) {
            com.bytedance.sdk.component.utils.vl.j(e6);
            return jSONObject;
        }
    }

    private JSONObject xt(final String str) {
        cw cwVar = (cw) AutoService.j(cw.class);
        if (cwVar != null) {
            cwVar.j(str, new ae() { // from class: com.bytedance.sdk.openadsdk.core.ch.jy.1
                @Override // com.bytedance.sdk.openadsdk.core.ch.ae
                protected PluginValueSet xt(int i6, SparseArray<Object> sparseArray) {
                    if (sparseArray == null) {
                        return null;
                    }
                    com.bytedance.sdk.openadsdk.i.j jVar = new com.bytedance.sdk.openadsdk.i.j(sparseArray);
                    PluginValueSet r5 = jVar.r();
                    boolean j6 = jVar.j();
                    if (r5 != null) {
                        if (TextUtils.equals(str, r5.stringValue(5))) {
                            if (j6) {
                                jy.this.cw = (JSONObject) r5.objectValue(3, JSONObject.class);
                                JSONObject unused = jy.this.cw;
                            } else {
                                jy.this.f28013r = (JSONObject) r5.objectValue(4, JSONObject.class);
                            }
                        }
                    }
                    return super.xt(i6, sparseArray);
                }
            });
        } else {
            this.cw = new JSONObject();
        }
        return this.cw;
    }

    private JSONObject xt() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("core_api_code", h.xt);
            jSONObject.put("core_plugin_code", 7012);
            jSONObject.put("ext_api_code", h.f29118r);
            jSONObject.put("ext_plugin_code", wq.xt());
            return jSONObject;
        } catch (Exception e6) {
            com.bytedance.sdk.component.utils.vl.j(e6);
            return jSONObject;
        }
    }

    private JSONObject j(com.bykv.vk.openvk.component.video.api.cw.r rVar, int i6, int i7) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("video_size", rVar.vl());
            jSONObject.put("preload_size", rVar.m());
            jSONObject.put("video_duration", rVar.ch().m());
            jSONObject.put("ad_slot_type", i7);
            jSONObject.put("rit", i6);
            jSONObject.put("video_url", rVar.av());
            jSONObject.put("preload_all", rVar.jy());
            jSONObject.put("trace_id", j(i6, rVar.i()));
            return jSONObject;
        } catch (Exception e6) {
            com.bytedance.sdk.component.utils.vl.j(e6);
            return jSONObject;
        }
    }

    public static void j(com.bykv.vk.openvk.component.video.api.cw.r rVar, JSONObject jSONObject, int i6, int i7) {
        int optInt;
        if (rVar == null || jSONObject == null || (optInt = jSONObject.optInt("rit", 0)) <= 0) {
            return;
        }
        f28012j.put(String.valueOf(optInt), jSONObject);
    }

    public JSONObject j(com.bykv.vk.openvk.component.video.api.cw.r rVar) {
        return xt(rVar);
    }
}
