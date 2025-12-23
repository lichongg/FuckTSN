package com.bytedance.sdk.openadsdk.core.ch;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.sdk.openadsdk.ats.AutoService;
import com.bytedance.sdk.openadsdk.core.v;
import com.bytedance.sdk.openadsdk.core.wq;
import java.util.function.Function;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class oq {
    public static boolean j() {
        JSONObject ln = v.xt().ln();
        return ln != null && ln.optInt("video_cache", 0) == 1;
    }

    public static boolean cw() {
        if (com.bytedance.sdk.openadsdk.core.cw.up.j().az() == 1) {
            return true;
        }
        return false;
    }

    public static void j(final Function<SparseArray<Object>, Object> function) {
        Object apply;
        Object apply2;
        cw cwVar;
        Function<SparseArray<Object>, Object> qb = com.bytedance.sdk.openadsdk.core.oq.i().qb();
        if (v.xt().ch()) {
            apply = qb.apply(com.bytedance.sdk.openadsdk.i.r.j().j(6).j(Boolean.class).j(0, "com.byted.csj.ext").xt());
            if (apply != null ? ((Boolean) apply).booleanValue() : false) {
                apply2 = qb.apply(com.bytedance.sdk.openadsdk.i.r.j().j(7).j(Boolean.class).j(0, "com.byted.csj.ext").xt());
                if (((apply2 != null ? ((Boolean) apply2).booleanValue() : false) || wq.j().j(qb, false)) && (cwVar = (cw) AutoService.j(cw.class)) != null) {
                    cwVar.j(v.getContext(), new com.bytedance.sdk.openadsdk.core.wq.r() { // from class: com.bytedance.sdk.openadsdk.core.ch.oq.1
                        @Override // com.bytedance.sdk.openadsdk.core.wq.r
                        public <T> T applyFunction(int i6, PluginValueSet pluginValueSet, Class<T> cls) {
                            if (function == null) {
                                return null;
                            }
                            function.apply(com.bytedance.sdk.openadsdk.i.r.j().j(i6).j(Void.class).j(-99999979, (SparseArray) pluginValueSet.objectValue(-99999979, SparseArray.class)).xt());
                            return null;
                        }
                    });
                }
            }
        }
    }

    public static boolean xt() {
        JSONObject ln = v.xt().ln();
        if (ln == null || ln.optInt("pre_drop", 0) != 1) {
            return false;
        }
        return true;
    }
}
