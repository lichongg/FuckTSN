package com.bytedance.msdk.j.r.j;

import a1.a;
import a1.b;
import android.content.Context;
import android.util.SparseArray;
import com.baidu.mobads.sdk.internal.cm;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.msdk.api.r.j.xt.cw.xt;
import com.bytedance.msdk.m.xt.cw;
import com.bytedance.msdk.m.xt.up;
import com.bytedance.sdk.openadsdk.i.r;
import java.util.Map;
import java.util.function.Function;

/* loaded from: D:\Downloads\app\classes3.dex */
public class j extends com.bytedance.msdk.api.r.j.xt.m.j {
    private final Function<SparseArray<Object>, Object> cw = cw.j(com.bytedance.msdk.core.j.qv().ol()).j();

    /* renamed from: r, reason: collision with root package name */
    private Function<SparseArray<Object>, Object> f25138r;

    @Override // com.bytedance.msdk.api.r.j.xt.m.j
    public void j(Context context, xt xtVar, Map<String, Object> map) {
        if (xtVar != null) {
            r j6 = r.j().j(AVMDLDataLoader.KeyIsLiveLoaderEnable).j(Void.class).j(8089, com.bytedance.msdk.core.j.qv().ol().sparseArray()).j(8545, com.bytedance.sdk.openadsdk.i.cw.r.j(xtVar.j())).j(8400, map).j(8401, this).j(8098, Boolean.TRUE);
            up.j(j6);
            this.cw.apply(j6.xt());
        }
    }

    @Override // com.bytedance.msdk.api.r.j.xt.m.j
    public String xt(Context context, Map<String, Object> map) {
        Object apply;
        if (this.f25138r == null) {
            return super.xt(context, map);
        }
        apply = this.f25138r.apply(r.j().j(AVMDLDataLoader.KeyIsLoaderFactoryXYLibValue).j(String.class).j(AVMDLDataLoader.KeyIsLiveWaitP2pReadyThreshold, context).j(8075, map).xt());
        return apply instanceof String ? (String) apply : "";
    }

    @Override // com.bytedance.sdk.openadsdk.core.wq.r
    public <T> T applyFunction(int i6, PluginValueSet pluginValueSet, Class<T> cls) {
        if (i6 == 8216) {
            this.f25138r = b.a(pluginValueSet.objectValue(8402, a.a()));
        } else if (i6 == 8219) {
            cw();
        } else {
            if (i6 == 8220) {
                return (T) Boolean.valueOf(r());
            }
            if (i6 == 8270) {
                long longValue = pluginValueSet.longValue(8073);
                this.xt = pluginValueSet.intValue(8557);
                this.f24375j = longValue;
            }
        }
        return (T) com.bytedance.msdk.core.av.j.j(cls);
    }

    @Override // com.bytedance.msdk.api.r.j.xt.m.j
    public String xt() {
        return cm.f10901d;
    }

    @Override // com.bytedance.msdk.api.r.j.xt.m.j
    public String j(Context context, Map<String, Object> map) {
        Object apply;
        if (this.f25138r != null) {
            apply = this.f25138r.apply(r.j().j(8139).j(String.class).j(AVMDLDataLoader.KeyIsLiveWaitP2pReadyThreshold, context).j(8075, map).xt());
            return apply instanceof String ? (String) apply : "";
        }
        return super.j(context, map);
    }

    @Override // com.bytedance.msdk.api.r.j.xt.m.j
    public String j() {
        Object apply;
        if (this.f25138r == null) {
            return null;
        }
        apply = this.f25138r.apply(r.j().j(AVMDLDataLoader.KeyIsLoaderFactoryP2PStragetyLevel).j(String.class).xt());
        return apply instanceof String ? (String) apply : "";
    }
}
