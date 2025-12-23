package com.bytedance.sdk.openadsdk.api.plugin.j;

import android.text.TextUtils;
import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.plugin.Plugin;
import java.util.function.Function;

/* loaded from: D:\Downloads\app\classes4.dex */
public final class j implements Function<SparseArray<Object>, Object> {

    /* renamed from: j, reason: collision with root package name */
    private static volatile j f27579j;

    public static j j() {
        if (f27579j == null) {
            synchronized (j.class) {
                try {
                    if (f27579j == null) {
                        f27579j = new j();
                    }
                } finally {
                }
            }
        }
        return f27579j;
    }

    private Plugin j(ValueSet valueSet) {
        if (valueSet == null) {
            return null;
        }
        String stringValue = valueSet.stringValue(0);
        if (TextUtils.isEmpty(stringValue)) {
            return null;
        }
        return Zeus.getPlugin(stringValue);
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00a4  */
    @Override // java.util.function.Function
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object apply(android.util.SparseArray<java.lang.Object> r4) {
        /*
            r3 = this;
            r0 = 0
            if (r4 != 0) goto L4
            return r0
        L4:
            com.bykv.j.j.j.j.a r4 = com.bykv.j.j.j.j.a.j(r4)
            com.bykv.vk.openvk.api.proto.ValueSet r4 = r4.k()
            r1 = -99999987(0xfffffffffa0a1f0d, float:-1.7929169E35)
            int r1 = r4.intValue(r1)
            r2 = -99999986(0xfffffffffa0a1f0e, float:-1.792917E35)
            if (r1 == r2) goto Ld4
            r2 = 13
            if (r1 == r2) goto Lc9
            r2 = 0
            switch(r1) {
                case 4: goto Lbe;
                case 5: goto Lb1;
                case 6: goto La4;
                case 7: goto L97;
                case 8: goto L72;
                default: goto L20;
            }
        L20:
            switch(r1) {
                case 100: goto L6a;
                case 101: goto L5a;
                case 102: goto L4a;
                case 103: goto L3a;
                case 104: goto L97;
                case 105: goto La4;
                case 106: goto L24;
                default: goto L23;
            }
        L23:
            return r0
        L24:
            java.lang.Class<com.bytedance.sdk.openadsdk.TTPluginListener> r1 = com.bytedance.sdk.openadsdk.TTPluginListener.class
            java.lang.Object r4 = r4.objectValue(r2, r1)
            com.bytedance.sdk.openadsdk.TTPluginListener r4 = (com.bytedance.sdk.openadsdk.TTPluginListener) r4
            if (r4 == 0) goto L39
            android.content.Context r1 = com.bytedance.sdk.openadsdk.TTAppContextHolder.getContext()
            com.bytedance.sdk.openadsdk.api.plugin.g r1 = com.bytedance.sdk.openadsdk.api.plugin.g.j(r1)
            r1.xt(r4)
        L39:
            return r0
        L3a:
            com.bytedance.pangle.plugin.Plugin r4 = r3.j(r4)
            if (r4 == 0) goto L49
            int r4 = r4.getVersion()
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            return r4
        L49:
            return r0
        L4a:
            com.bytedance.pangle.plugin.Plugin r4 = r3.j(r4)
            if (r4 == 0) goto L59
            int r4 = r4.getInternalVersionCode()
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            return r4
        L59:
            return r0
        L5a:
            com.bytedance.pangle.plugin.Plugin r4 = r3.j(r4)
            if (r4 == 0) goto L69
            int r4 = r4.getApiVersionCode()
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            return r4
        L69:
            return r0
        L6a:
            java.lang.String r4 = r4.stringValue(r2)
            com.bytedance.pangle.Zeus.unInstallPlugin(r4)
            return r0
        L72:
            java.lang.String r4 = r4.stringValue(r2)
            boolean r0 = android.text.TextUtils.isEmpty(r4)
            if (r0 != 0) goto L8b
            java.lang.String r0 = com.bytedance.sdk.openadsdk.api.plugin.g.j(r4)
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 == 0) goto L8d
            java.lang.String r0 = com.bytedance.sdk.openadsdk.api.plugin.g.xt(r4)
            goto L8d
        L8b:
            java.lang.String r0 = ""
        L8d:
            boolean r4 = android.text.TextUtils.isEmpty(r0)
            if (r4 == 0) goto L96
            java.lang.String r4 = "0.0.0.0"
            return r4
        L96:
            return r0
        L97:
            java.lang.String r4 = r4.stringValue(r2)
            boolean r4 = com.bytedance.pangle.Zeus.isPluginLoaded(r4)
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4)
            return r4
        La4:
            java.lang.String r4 = r4.stringValue(r2)
            boolean r4 = com.bytedance.pangle.Zeus.isPluginInstalled(r4)
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4)
            return r4
        Lb1:
            java.lang.String r4 = r4.stringValue(r2)
            boolean r4 = com.bytedance.pangle.Zeus.loadPlugin(r4)
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4)
            return r4
        Lbe:
            java.lang.String r4 = r4.stringValue(r2)
            com.bytedance.pangle.plugin.Plugin r4 = com.bytedance.pangle.Zeus.getPlugin(r4)
            com.bytedance.pangle.PluginClassLoader r4 = r4.mClassLoader
            return r4
        Lc9:
            com.bytedance.pangle.plugin.Plugin r4 = r3.j(r4)
            if (r4 == 0) goto Ld4
            org.json.JSONObject r4 = r4.getJsonConfig()
            return r4
        Ld4:
            com.bykv.j.j.j.j.a r4 = com.bykv.j.j.j.j.a.a()
            r0 = 10000(0x2710, float:1.4013E-41)
            r1 = 4
            com.bykv.j.j.j.j.a r4 = r4.e(r0, r1)
            com.bykv.vk.openvk.api.proto.ValueSet r4 = r4.k()
            android.util.SparseArray r4 = r4.sparseArray()
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.api.plugin.j.j.apply(android.util.SparseArray):java.lang.Object");
    }
}
