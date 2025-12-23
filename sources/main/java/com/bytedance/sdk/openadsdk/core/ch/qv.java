package com.bytedance.sdk.openadsdk.core.ch;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.ats.AutoService;
import com.bytedance.sdk.openadsdk.core.tj.n;
import java.util.HashMap;

/* loaded from: D:\Downloads\app\classes4.dex */
public class qv {

    /* renamed from: j, reason: collision with root package name */
    private static final HashMap<String, vl> f28017j = new HashMap<>();

    public static void j(n nVar) {
        cw cwVar = (cw) AutoService.j(cw.class);
        if (cwVar != null && cwVar.r() && cwVar.cw() && oq.xt() && nVar != null && nVar.rr() != null) {
            String ej = nVar.ej();
            String so = nVar.so();
            String r5 = nVar.rr().r();
            if (TextUtils.isEmpty(r5)) {
                return;
            }
            vl vlVar = new vl();
            vlVar.j(1);
            vlVar.j(ej);
            vlVar.xt(so);
            f28017j.put(r5, vlVar);
        }
    }
}
