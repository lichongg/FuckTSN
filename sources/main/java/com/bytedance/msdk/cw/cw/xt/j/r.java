package com.bytedance.msdk.cw.cw.xt.j;

import com.bytedance.msdk.cw.cw.xt.j.j.tl;
import com.bytedance.msdk.cw.cw.xt.j.xt.ae;
import com.bytedance.msdk.cw.cw.xt.j.xt.m;
import com.bytedance.msdk.cw.cw.xt.j.xt.oq;
import com.bytedance.msdk.cw.cw.xt.j.xt.qv;
import com.bytedance.msdk.cw.cw.xt.j.xt.up;
import com.bytedance.msdk.cw.cw.xt.j.xt.vl;

/* loaded from: D:\Downloads\app\classes3.dex */
public class r {
    public static com.bytedance.msdk.cw.j.j j(com.bytedance.msdk.cw.m.xt.xt xtVar, com.bytedance.msdk.cw.j.xt xtVar2) {
        if (xtVar == null) {
            return null;
        }
        int az = xtVar.az();
        switch (xtVar.s()) {
            case 1:
                return new com.bytedance.msdk.cw.cw.xt.j.xt.j(xtVar2);
            case 2:
                return new ae(xtVar2);
            case 3:
                return new vl(xtVar2);
            case 4:
            case 6:
            default:
                return null;
            case 5:
                return az == 4 ? new oq(xtVar2) : az == 5 ? new up(xtVar2) : az == 3 ? new com.bytedance.msdk.cw.cw.xt.j.xt.j(xtVar2) : new oq(xtVar2);
            case 7:
                return az == 6 ? new qv(xtVar2) : az == 7 ? new m(xtVar2) : new qv(xtVar2);
            case 8:
                return new m(xtVar2);
            case 9:
                return new up(xtVar2);
            case 10:
                if (az == 1) {
                    return new ae(xtVar2);
                }
                if (az == 2) {
                    return new m(xtVar2);
                }
                return null;
        }
    }

    public static com.bytedance.msdk.cw.j.j j(String str, com.bytedance.msdk.cw.m.xt.xt xtVar, com.bytedance.msdk.cw.j.xt xtVar2) {
        if (xtVar == null) {
            return null;
        }
        int az = xtVar.az();
        switch (xtVar.s()) {
            case 1:
                return new com.bytedance.msdk.cw.cw.xt.j.j.j(str, xtVar2);
            case 2:
                return new com.bytedance.msdk.cw.cw.xt.j.j.m(str, xtVar2);
            case 3:
                return new tl(str, xtVar2);
            case 4:
            case 6:
            default:
                return null;
            case 5:
                if (az == 4) {
                    return new com.bytedance.msdk.cw.cw.xt.j.j.r(str, xtVar2);
                }
                if (az == 5) {
                    return new com.bytedance.msdk.cw.cw.xt.j.j.cw(str, xtVar2);
                }
                if (az == 3) {
                    return new com.bytedance.msdk.cw.cw.xt.j.j.j(str, xtVar2);
                }
                return new com.bytedance.msdk.cw.cw.xt.j.j.r(str, xtVar2);
            case 7:
                if (az == 6) {
                    return new com.bytedance.msdk.cw.cw.xt.j.j.ae(str, xtVar2);
                }
                if (az == 7) {
                    return new com.bytedance.msdk.cw.cw.xt.j.j.up(str, xtVar2);
                }
                return new com.bytedance.msdk.cw.cw.xt.j.j.ae(str, xtVar2);
            case 8:
                return new com.bytedance.msdk.cw.cw.xt.j.j.up(str, xtVar2);
            case 9:
                return new com.bytedance.msdk.cw.cw.xt.j.j.cw(str, xtVar2);
            case 10:
                if (az == 1) {
                    return new com.bytedance.msdk.cw.cw.xt.j.j.m(str, xtVar2);
                }
                if (az == 2) {
                    return new com.bytedance.msdk.cw.cw.xt.j.j.up(str, xtVar2);
                }
                return null;
        }
    }
}
