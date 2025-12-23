package com.bytedance.msdk.core.j.j;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.Map;

/* loaded from: D:\Downloads\app\classes3.dex */
public class j {
    private static m cw;

    /* renamed from: j, reason: collision with root package name */
    private static m f24486j;
    private static m xt;

    public static m j(String str) {
        if (TextUtils.equals(str, MediationConstant.ADN_GDT)) {
            if (f24486j == null) {
                f24486j = new xt();
            }
            return f24486j;
        }
        if (TextUtils.equals(str, MediationConstant.ADN_KS)) {
            if (xt == null) {
                xt = new cw();
            }
            return xt;
        }
        if (!TextUtils.equals(str, "xiaomi")) {
            return null;
        }
        if (cw == null) {
            cw = new r();
        }
        return cw;
    }

    public static boolean xt(String str) {
        return TextUtils.equals(str, MediationConstant.ADN_GDT) || TextUtils.equals(str, MediationConstant.ADN_KS) || TextUtils.equals(str, "xiaomi");
    }

    public static void j(Map<String, Object> map) {
        if (map != null) {
            m mVar = f24486j;
            if (mVar != null && !TextUtils.isEmpty(mVar.ae())) {
                map.put("unsupported_gdt_version", f24486j.ae());
                f24486j.j((String) null);
            }
            m mVar2 = xt;
            if (mVar2 != null && !TextUtils.isEmpty(mVar2.ae())) {
                map.put("unsupported_ks_version", xt.ae());
                xt.j((String) null);
            }
            m mVar3 = cw;
            if (mVar3 == null || TextUtils.isEmpty(mVar3.ae())) {
                return;
            }
            map.put("unsupported_xiaomi_version", cw.ae());
            cw.j((String) null);
        }
    }
}
