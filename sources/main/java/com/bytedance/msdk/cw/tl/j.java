package com.bytedance.msdk.cw.tl;

import android.os.SystemClock;
import java.util.List;

/* loaded from: D:\Downloads\app\classes3.dex */
public class j {
    public static void j(com.bytedance.msdk.cw.m.j.xt xtVar, List<com.bytedance.msdk.xt.cw> list, boolean z5) {
        if (xtVar == null) {
            return;
        }
        com.bytedance.msdk.xt.cw j6 = j(list);
        if (xtVar.rn()) {
            return;
        }
        xtVar.cw(SystemClock.elapsedRealtime());
        com.bytedance.msdk.up.m.j(j6, xtVar.mi(), xtVar.vl(), xtVar.gq() - xtVar.la(), xtVar.wq().f24631j, !xtVar.v(), list != null ? list.size() : 0, xtVar.wq().up, z5);
        xtVar.r(true);
    }

    private static com.bytedance.msdk.xt.cw j(List<com.bytedance.msdk.xt.cw> list) {
        com.bytedance.msdk.xt.cw cwVar = null;
        if (list != null && list.size() != 0) {
            for (com.bytedance.msdk.xt.cw cwVar2 : list) {
                if (cwVar == null || cwVar2.sm() < cwVar.sm()) {
                    cwVar = cwVar2;
                }
            }
        }
        return cwVar;
    }
}
