package com.bytedance.msdk.cw.j;

import a1.a;
import a1.b;
import android.text.TextUtils;
import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.Map;
import java.util.function.Function;

/* loaded from: D:\Downloads\app\classes3.dex */
public abstract class r extends com.bytedance.msdk.xt.cw {

    /* renamed from: g, reason: collision with root package name */
    protected Function<SparseArray<Object>, Object> f25000g;
    protected com.bytedance.msdk.cw.m.xt.j oq;

    public abstract <T> T j(int i6, PluginValueSet pluginValueSet, Class<T> cls);

    @Override // com.bytedance.msdk.xt.cw
    public void j(Map<String, Object> map) {
        if (oy()) {
            Object obj = map.get("bidding_lose_reason_NUM");
            int intValue = obj instanceof Integer ? ((Integer) obj).intValue() : 0;
            if (intValue <= 0) {
                intValue = 10001;
            }
            map.put(MediationConstant.BIDDING_LOSE_REASON_DEX_ADAPTER, Integer.valueOf(com.bytedance.msdk.core.j.j.up.j(zz(), intValue)));
            if (this.f25000g != null) {
                this.f25000g.apply(com.bytedance.sdk.openadsdk.i.r.j().j(8144).j(Void.class).j(AVMDLDataLoader.KeyIsLiveCacheThresholdHttpToP2p, map).xt());
            }
        }
    }

    @Override // com.bytedance.msdk.xt.cw, com.bytedance.sdk.openadsdk.core.wq.r
    public <T> T applyFunction(int i6, PluginValueSet pluginValueSet, Class<T> cls) {
        if (i6 == 8128) {
            this.f25000g = b.a(pluginValueSet.objectValue(8035, a.a()));
        } else if (i6 == 8208) {
            String stringValue = pluginValueSet.stringValue(8058);
            if (!TextUtils.isEmpty(stringValue)) {
                ws(stringValue);
            }
        } else if (i6 == 8209) {
            qv(pluginValueSet.intValue(8060));
        } else if (i6 == 8140) {
            vl(pluginValueSet.intValue(8059));
        }
        return (T) j(i6, pluginValueSet, cls);
    }

    /* renamed from: if, reason: not valid java name */
    public boolean m109if() {
        com.bytedance.msdk.cw.m.xt.j jVar = this.oq;
        if (jVar != null) {
            return jVar.j();
        }
        return false;
    }

    @Override // com.bytedance.msdk.xt.cw
    public long ig() {
        Object apply;
        if (this.f25000g == null) {
            return super.ig();
        }
        apply = this.f25000g.apply(com.bytedance.sdk.openadsdk.i.r.j().j(8245).j(Long.class).xt());
        if (apply instanceof Long) {
            return ((Long) apply).longValue();
        }
        return 0L;
    }

    @Override // com.bytedance.msdk.xt.cw
    public Map<String, Object> p() {
        Object apply;
        if (this.f25000g != null) {
            apply = this.f25000g.apply(com.bytedance.sdk.openadsdk.i.r.j().j(8239).j(Map.class).xt());
            cw(apply instanceof Map ? (Map) apply : null);
        }
        return super.p();
    }

    @Override // com.bytedance.msdk.xt.cw
    public boolean up() {
        if (this.f25000g == null) {
            return false;
        }
        this.f25000g.apply(com.bytedance.sdk.openadsdk.i.r.j().j(8120).j(Boolean.class).xt());
        return false;
    }

    @Override // com.bytedance.msdk.xt.cw
    public long yb() {
        Object apply;
        if (this.f25000g == null) {
            return super.yb();
        }
        apply = this.f25000g.apply(com.bytedance.sdk.openadsdk.i.r.j().j(8246).j(Long.class).xt());
        if (apply instanceof Long) {
            return ((Long) apply).longValue();
        }
        return 0L;
    }

    public r(com.bytedance.msdk.cw.m.xt.j jVar) {
        this.oq = jVar;
    }

    @Override // com.bytedance.msdk.xt.cw
    public void av() {
        super.av();
        if (this.f25000g != null) {
            this.f25000g.apply(com.bytedance.sdk.openadsdk.i.r.j().j(8149).j(Void.class).xt());
        }
    }

    @Override // com.bytedance.msdk.xt.cw
    public void i() {
        super.i();
        if (this.f25000g != null) {
            this.f25000g.apply(com.bytedance.sdk.openadsdk.i.r.j().j(8148).j(Void.class).xt());
        }
    }

    @Override // com.bytedance.msdk.xt.cw
    public void w() {
        super.w();
        if (this.f25000g != null) {
            this.f25000g.apply(com.bytedance.sdk.openadsdk.i.r.j().j(8109).j(Void.class).xt());
        }
    }

    @Override // com.bytedance.msdk.xt.cw
    public void xt(Map<String, Object> map) {
        if (oy() && this.f25000g != null) {
            this.f25000g.apply(com.bytedance.sdk.openadsdk.i.r.j().j(8142).j(Void.class).j(AVMDLDataLoader.KeyIsLiveCacheThresholdHttpToP2p, map).xt());
        }
    }
}
