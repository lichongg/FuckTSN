package com.bytedance.sdk.openadsdk.core.ch;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class r extends tl {
    public r(SparseArray<Object> sparseArray, int i6) {
        super(sparseArray, i6);
    }

    public boolean j() {
        if (cw() != null) {
            return cw().j();
        }
        return false;
    }

    public m xt() {
        PluginValueSet r5;
        if (cw() != null && (r5 = cw().r()) != null) {
            return new m((JSONObject) r5.objectValue(4, JSONObject.class));
        }
        return null;
    }
}
