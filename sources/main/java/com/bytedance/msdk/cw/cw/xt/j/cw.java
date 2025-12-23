package com.bytedance.msdk.cw.cw.xt.j;

import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bytedance.msdk.api.r.g;
import com.bytedance.msdk.m.xt.up;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.umeng.analytics.pro.d;
import io.netty.handler.codec.http.multipart.HttpPostBodyUtil;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/* loaded from: D:\Downloads\app\classes3.dex */
public class cw extends xt {
    private com.bytedance.msdk.cw.m.xt.xt cw;

    /* renamed from: r, reason: collision with root package name */
    private com.bytedance.msdk.api.j.xt f24864r;
    private j xt;

    @Override // com.bytedance.msdk.cw.cw.xt.j.xt, com.bytedance.msdk.cw.j.j
    public String j(Context context, com.bytedance.msdk.cw.m.xt.xt xtVar, com.bytedance.msdk.api.j.xt xtVar2) {
        if (xtVar != null && xtVar2 != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("bidding_token", "true");
            if (this.xt == null) {
                this.xt = new j(xtVar2, xtVar, this);
                com.bytedance.sdk.openadsdk.i.r j6 = com.bytedance.sdk.openadsdk.i.r.j();
                j6.j(AVMDLDataLoader.KeyIsLiveMobileDownloadAllow, this.xt);
                j6.j(AVMDLDataLoader.KeyIsLiveMobileUploadAllow, xtVar.w());
                com.bytedance.sdk.openadsdk.i.r j7 = com.bytedance.sdk.openadsdk.i.r.j();
                j7.j(8449, hashMap);
                com.bytedance.sdk.openadsdk.i.r j8 = com.bytedance.sdk.openadsdk.i.r.j();
                j8.j(8443, j7.xt());
                j6.j(8090, com.bytedance.sdk.openadsdk.i.r.j(xtVar2.gx()).j(8089, j8.xt()).xt());
                Function<SparseArray<Object>, Object> ae = com.bytedance.msdk.core.qv.j.j().ae();
                if (ae != null) {
                    com.bytedance.sdk.openadsdk.i.r j9 = com.bytedance.sdk.openadsdk.i.r.j();
                    j9.j(AVMDLDataLoader.KeyIsLiveWaitP2pReadyThreshold, com.bytedance.msdk.j.up.j.j(context)).j(8106).j(Void.class);
                    up.j(j9, j6);
                    ae.apply(j9.xt());
                } else {
                    com.bytedance.msdk.j.up.cw.xt(MediationConstant.TAG, "load ad class loader is null ");
                }
            }
            if (this.xt != null && xtVar2.tj() != null) {
                com.bytedance.sdk.openadsdk.mediation.xt.xt.xt l6 = xtVar2.tj().l();
                return this.xt.j(context, xtVar.vl(), com.bytedance.msdk.core.av.j.j(l6 != null ? l6.m() : null));
            }
        }
        return null;
    }

    @Override // com.bytedance.msdk.cw.cw.xt.j.xt
    public void xt(Context context, com.bytedance.msdk.cw.m.xt.xt xtVar, com.bytedance.msdk.api.j.xt xtVar2, Map<String, Object> map) {
        this.cw = xtVar;
        this.f24864r = xtVar2;
        com.bytedance.sdk.openadsdk.i.r j6 = j(xtVar, xtVar2, map);
        if (j6 != null) {
            this.xt = new j(xtVar2, xtVar, this);
            j6.j(8429, xtVar.av());
            j6.j(8430, xtVar.i());
            j6.j(AVMDLDataLoader.KeyIsLiveMobileDownloadAllow, this.xt);
            j6.j(AVMDLDataLoader.KeyIsLiveMobileUploadAllow, xtVar.w());
            j6.j(8561, Integer.valueOf(xtVar.ed()));
            com.bytedance.msdk.m.xt.j.xt(xtVar.jy());
            j(context, j6);
        }
    }

    public cw(com.bytedance.msdk.cw.j.xt xtVar) {
        super(xtVar);
    }

    private void xt(Context context, com.bytedance.sdk.openadsdk.i.r rVar) {
        Function<SparseArray<Object>, Object> ae = com.bytedance.msdk.core.qv.j.j().ae();
        if (ae != null) {
            if (com.bytedance.sdk.gromore.init.j.j() >= 5900) {
                com.bytedance.sdk.openadsdk.i.r j6 = com.bytedance.sdk.openadsdk.i.r.j().j(AVMDLDataLoader.KeyIsLiveWaitP2pReadyThreshold, com.bytedance.msdk.j.up.j.j(context)).j(8106).j(Void.class);
                up.j(j6, rVar);
                ae.apply(j6.xt());
                return;
            } else {
                rVar.j(AVMDLDataLoader.KeyIsLiveWaitP2pReadyThreshold, com.bytedance.msdk.j.up.j.j(context)).j(8106).j(Void.class);
                ae.apply(rVar.xt());
                return;
            }
        }
        com.bytedance.msdk.j.up.cw.xt(MediationConstant.TAG, "load ad class loader is null ");
    }

    private void j(Context context, com.bytedance.sdk.openadsdk.i.r rVar) {
        com.bytedance.msdk.cw.m.xt.xt xtVar = this.cw;
        Function<SparseArray<Object>, Object> j6 = (xtVar == null || this.f24864r == null) ? null : com.bytedance.msdk.core.j.j.up.j(xtVar.jy(), this.f24864r.f(), this.cw.az());
        if (j6 != null) {
            j6.apply(com.bytedance.sdk.openadsdk.i.r.j().j(8241).j(Void.class).j(AVMDLDataLoader.KeyIsLiveWaitP2pReadyThreshold, com.bytedance.msdk.j.up.j.j(context)).j(8424, rVar.xt()).xt());
        } else {
            xt(context, rVar);
        }
    }

    private com.bytedance.sdk.openadsdk.i.r j(com.bytedance.msdk.cw.m.xt.xt xtVar, com.bytedance.msdk.api.j.xt xtVar2, Map<String, Object> map) {
        HashMap hashMap = null;
        if (xtVar == null || xtVar2 == null || xtVar2.tj() == null) {
            return null;
        }
        com.bytedance.sdk.openadsdk.i.r j6 = com.bytedance.sdk.openadsdk.i.r.j();
        com.bytedance.sdk.openadsdk.mediation.xt.xt.j tj = xtVar2.tj();
        com.bytedance.sdk.openadsdk.mediation.xt.xt.xt l6 = tj.l();
        com.bytedance.sdk.openadsdk.i.r j7 = com.bytedance.sdk.openadsdk.i.r.j(xtVar2.gx()).j(15, tj.ws()).j(13, Integer.valueOf(xtVar2.a())).j(7, Integer.valueOf(tj.m())).j(8, Integer.valueOf(tj.ae())).j(16, Integer.valueOf(tj.az())).j(20, Integer.valueOf(tj.w())).j(11, Boolean.valueOf(tj.oq())).j(17, Integer.valueOf(xtVar2.i()));
        com.bytedance.sdk.openadsdk.i.r j8 = com.bytedance.sdk.openadsdk.i.r.j();
        HashMap hashMap2 = new HashMap();
        if (l6 != null) {
            if (l6.m() != null) {
                hashMap2.putAll(l6.m());
            }
            if (xtVar.tl() != null) {
                hashMap2.put("waterfall_config", xtVar.tl());
            }
            hashMap2.put("dynamic_adapter_type", Integer.valueOf(com.bytedance.msdk.ae.j.j.j().r()));
            hashMap2.put("wf_dynamic_adapter_type", Integer.valueOf(com.bytedance.msdk.ae.j.j.j().up()));
            com.bytedance.msdk.core.r.j.j(xtVar2, xtVar.tl(), hashMap2);
            j8.j(8444, Boolean.valueOf(l6.cw())).j(8445, Boolean.valueOf(l6.j())).j(8446, Boolean.valueOf(l6.xt())).j(8447, Float.valueOf(l6.r())).j(8448, Boolean.valueOf(l6.up())).j(8450, Boolean.valueOf(l6.ae())).j(8451, l6.tl()).j(8454, Boolean.valueOf(l6.g())).j(8455, Float.valueOf(l6.qv())).j(8456, Float.valueOf(l6.vl()));
        } else {
            hashMap2.put("dynamic_adapter_type", Integer.valueOf(com.bytedance.msdk.ae.j.j.j().r()));
            hashMap2.put("wf_dynamic_adapter_type", Integer.valueOf(com.bytedance.msdk.ae.j.j.j().up()));
        }
        g xt = com.bytedance.msdk.core.j.qv().p().xt();
        if (xt != null) {
            hashMap2.put(d.D, Double.valueOf(xt.xt()));
            hashMap2.put(d.C, Double.valueOf(xt.j()));
            hashMap2.put("loc_time", Long.valueOf(System.currentTimeMillis() / 1000));
        } else {
            hashMap2.put(d.D, -1);
            hashMap2.put(d.C, -1);
            hashMap2.put("loc_time", -1);
        }
        hashMap2.put("load_type", com.bytedance.msdk.core.j.j.up.j());
        hashMap2.put("load_can_log", Boolean.valueOf(com.bytedance.msdk.ae.j.j.j().g()));
        j8.j(8449, hashMap2);
        j8.j(8044, hashMap2);
        j(j8, tj, l6);
        j7.j(8443, j8.xt());
        j6.j(8090, com.bytedance.sdk.openadsdk.i.cw.r.j(com.bytedance.sdk.openadsdk.i.r.j(xtVar2.gx()).j(8089, j7.xt()).xt()));
        j6.j(AVMDLDataLoader.KeyIsLiveCacheThresholdP2pToHttp, xtVar.vl());
        j6.j(4, xtVar2.v());
        j6.j(8003, xtVar.jy());
        j6.j(17, Integer.valueOf(xtVar2.i()));
        if (xtVar2.c() != null) {
            HashMap hashMap3 = new HashMap();
            for (Map.Entry<String, Object> entry : xtVar2.c().entrySet()) {
                Object value = entry.getValue();
                hashMap3.put(entry.getKey(), value == null ? null : value.toString());
            }
            hashMap = hashMap3;
        }
        if (hashMap != null) {
            j6.j(8013, hashMap);
        }
        if (map != null) {
            j6.j(HttpPostBodyUtil.chunkSize, Integer.valueOf(map.get("ad_load_timeout") != null ? ((Integer) map.get("ad_load_timeout")).intValue() : 3000));
        }
        Object obj = map.get("contentUrl");
        if (obj instanceof String) {
            j6.j(8083, (String) obj);
        }
        Object obj2 = map.get("testDevices");
        if (obj2 instanceof String) {
            j6.j(8084, (String) obj2);
        }
        Object obj3 = map.get("tt_ad_origin_type");
        if (obj3 != null) {
            Integer num = (Integer) obj3;
            int intValue = num.intValue();
            if (intValue == 1 || intValue == 3) {
                j6.j(8033, Boolean.TRUE);
            }
            j6.j(8085, num);
        }
        Object obj4 = map.get("tt_ad_sub_type");
        if (obj4 != null) {
            j6.j(8094, (Integer) obj4);
        }
        Object obj5 = map.get("render_control");
        if (obj5 instanceof Integer) {
            j6.j(8553, (Integer) obj5);
        }
        return j6;
    }

    private void j(com.bytedance.sdk.openadsdk.i.r rVar, com.bytedance.sdk.openadsdk.mediation.xt.xt.j jVar, com.bytedance.sdk.openadsdk.mediation.xt.xt.xt xtVar) {
        if (rVar == null || jVar == null) {
            return;
        }
        if (xtVar != null && !TextUtils.isEmpty(xtVar.ws()) && xtVar.az() != 0) {
            rVar.j(8452, xtVar.ws());
            rVar.j(8453, Integer.valueOf(xtVar.az()));
        } else {
            if (TextUtils.isEmpty(jVar.x()) || jVar.ch() == 0) {
                return;
            }
            rVar.j(8452, jVar.x());
            rVar.j(8453, Integer.valueOf(jVar.ch()));
        }
    }

    @Override // com.bytedance.msdk.cw.j.j
    public String j(String str) {
        com.bytedance.msdk.j.j.r j6 = com.bytedance.msdk.m.xt.xt.j().j(str);
        if (j6 != null) {
            return j6.xt();
        }
        return null;
    }
}
