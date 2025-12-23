package com.bytedance.sdk.openadsdk.core.up;

import android.text.TextUtils;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.openadsdk.core.a;
import com.bytedance.sdk.openadsdk.core.cw.m;
import com.bytedance.sdk.openadsdk.core.kt.ws;
import com.bytedance.sdk.openadsdk.core.tj.n;
import com.bytedance.sdk.openadsdk.core.up.r.r;
import com.bytedance.sdk.openadsdk.core.v;
import java.util.List;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j {
    public static boolean j(com.bytedance.sdk.openadsdk.i.cw.cw.xt xtVar, n nVar, boolean z5) {
        int i6;
        if (!v.xt().xt(xtVar.r())) {
            return true;
        }
        if (nVar == null) {
            ws.j().xt(3);
            return false;
        }
        String tj = xtVar.tj();
        long ch = nVar.ch();
        String wq = nVar.wq();
        try {
            if (TextUtils.isEmpty(tj)) {
                ws.j().xt(1);
                return false;
            }
            JSONObject j6 = m.j(new JSONObject(tj), false, true);
            if (j6 == null) {
                ws.j().xt(1);
                return false;
            }
            a.j j7 = a.j.j(j6, xtVar, null);
            com.bytedance.sdk.openadsdk.core.tj.j jVar = j7.tl;
            if (jVar == null) {
                ws.j().xt(1);
                return false;
            }
            jVar.j(j6);
            List<n> xt = j7.tl.xt();
            if (xt == null) {
                ws.j().xt(1);
                return false;
            }
            for (n nVar2 : xt) {
                if (TextUtils.isEmpty(nVar2.wq())) {
                    ws.j().xt(2);
                    return false;
                }
                if (!nVar2.gq()) {
                    ws.j().xt(5);
                    return false;
                }
                if (TextUtils.equals(nVar2.wq(), wq)) {
                    nVar.l(nVar2.ua());
                    if (nVar.c() + ch >= System.currentTimeMillis()) {
                        return true;
                    }
                    if (z5) {
                        i6 = 7;
                    } else {
                        i6 = 8;
                    }
                    r.j(i6).j(xtVar.r());
                    ws.j().xt(4);
                    return false;
                }
            }
            ws.j().xt(3);
            return false;
        } catch (Exception e6) {
            ws.j().xt(1000);
            vl.j(e6);
            return false;
        }
    }
}
