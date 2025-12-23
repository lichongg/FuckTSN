package com.bytedance.msdk.j.r.j.j;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.sdk.openadsdk.i.cw;
import java.util.Map;
import java.util.function.Function;

/* loaded from: D:\Downloads\app\classes3.dex */
public class j extends com.bytedance.msdk.api.r.j.ae.j {
    public j(Function<SparseArray<Object>, Object> function) {
        PluginValueSet xt;
        if (function != null && (xt = cw.xt(function)) != null) {
            r(xt.stringValue(8505));
            up(xt.stringValue(8506));
            j(xt.longValue(8507));
            m(xt.stringValue(8508));
            j((Map<String, String>) xt.objectValue(8509, Map.class));
            ae(xt.stringValue(8510));
            tl(xt.stringValue(8511));
            xt((Map<String, Object>) xt.objectValue(8512, Map.class));
            cw(xt.stringValue(8551));
        }
    }
}
