package com.bytedance.msdk.tl;

import android.text.TextUtils;
import java.util.Map;

/* loaded from: D:\Downloads\app\classes3.dex */
public class h {
    public static void j(com.bytedance.msdk.xt.cw cwVar, com.bytedance.msdk.core.oq.oq oqVar, com.bytedance.msdk.api.j.xt xtVar, boolean z5) {
        if (cwVar == null || !cwVar.yl()) {
            return;
        }
        if (oqVar == null) {
            cwVar.j(0.0d);
        }
        String q5 = cwVar.q();
        Map<String, String> p5 = oqVar.p();
        if (TextUtils.isEmpty(q5)) {
            if (z5) {
                com.bytedance.msdk.up.m.j(oqVar, xtVar, cwVar, 40061, com.bytedance.msdk.api.j.j(40061));
            }
            cwVar.jy(com.bytedance.msdk.api.j.j(40061));
            cwVar.j(0.0d);
            return;
        }
        if (p5 == null) {
            if (z5) {
                com.bytedance.msdk.up.m.j(oqVar, xtVar, cwVar, 40062, com.bytedance.msdk.api.j.j(40062));
            }
            cwVar.jy(com.bytedance.msdk.api.j.j(40062));
            cwVar.j(0.0d);
            return;
        }
        String str = p5.get(q5);
        if (TextUtils.isEmpty(str)) {
            if (z5) {
                com.bytedance.msdk.up.m.j(oqVar, xtVar, cwVar, 40062, com.bytedance.msdk.api.j.j(40062));
            }
            cwVar.j(0.0d);
        } else {
            try {
                cwVar.j(Double.valueOf(str).doubleValue());
            } catch (Exception unused) {
                cwVar.j(0.0d);
            }
        }
    }
}
