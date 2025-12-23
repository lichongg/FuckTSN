package com.bytedance.sdk.gromore.init;

import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import com.bykv.j.j.j.j.e;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.openadsdk.core.gq;
import com.bytedance.sdk.openadsdk.i.cw.cw.xt;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.util.function.Function;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class m implements Function<SparseArray<Object>, Object> {

    /* renamed from: j, reason: collision with root package name */
    private Function<SparseArray<Object>, Object> f27337j;
    private Context xt;

    private PluginValueSet j(PluginValueSet pluginValueSet) {
        if (pluginValueSet == null) {
            return null;
        }
        String f6 = new com.bytedance.sdk.openadsdk.i.cw.cw.xt(pluginValueSet.sparseArray()).f();
        try {
            JSONArray jSONArray = TextUtils.isEmpty(f6) ? new JSONArray() : new JSONArray(f6);
            for (int i6 = 0; i6 < jSONArray.length(); i6++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i6);
                if (optJSONObject != null && TextUtils.equals("personal_ads_type", optJSONObject.optString(CommonNetImpl.NAME))) {
                    return pluginValueSet;
                }
            }
            JSONObject jSONObject = new JSONObject();
            com.bytedance.msdk.j.cw.cw xt = com.bytedance.msdk.core.j.qv().xt();
            if (xt == null) {
                return pluginValueSet;
            }
            String str = xt.ae() ? "0" : "1";
            jSONObject.put(CommonNetImpl.NAME, "personal_ads_type");
            jSONObject.put("value", str);
            jSONArray.put(jSONObject);
            return com.bytedance.sdk.openadsdk.mediation.xt.xt.j.j(pluginValueSet, jSONArray.toString());
        } catch (Throwable th) {
            vl.j(th);
            return pluginValueSet;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:149:0x0414  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x013d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void xt(android.util.SparseArray<java.lang.Object> r17) {
        /*
            Method dump skipped, instructions count: 1139
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.gromore.init.m.xt(android.util.SparseArray):void");
    }

    public m(Context context, Function<SparseArray<Object>, Object> function) {
        this.f27337j = function;
        this.xt = context;
    }

    @Override // java.util.function.Function
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (sparseArray == null) {
            return null;
        }
        xt(sparseArray);
        return null;
    }

    private void j(int i6, PluginValueSet pluginValueSet) {
        if (this.f27337j instanceof gq) {
            Object objectValue = j(pluginValueSet).objectValue(1, Object.class);
            if (objectValue == null) {
                vl.cw("apply->load with null callback");
            } else {
                ((gq) this.f27337j).j(i6, pluginValueSet, com.bytedance.sdk.openadsdk.p.cw.j(objectValue));
            }
        }
    }

    private void j(com.bytedance.sdk.gromore.j.j jVar, xt.j jVar2) {
        jVar2.r(jVar.up());
        jVar2.j(jVar.cw());
        jVar2.xt(jVar.r());
        jVar2.xt(jVar.xt());
        jVar2.j(jVar.j());
    }

    private PluginValueSet j(PluginValueSet pluginValueSet, com.bytedance.sdk.openadsdk.i.cw.cw.xt xtVar) {
        e j6 = e.j(pluginValueSet);
        j6.d(260009, xtVar.g());
        j6.d(260008, xtVar.tl());
        j6.e(260007, xtVar.ae());
        j6.e(260006, xtVar.m());
        j6.g(260004, xtVar.r());
        return j6.k();
    }
}
