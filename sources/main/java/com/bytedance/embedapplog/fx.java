package com.bytedance.embedapplog;

import android.content.Context;
import android.os.Build;

/* loaded from: D:\Downloads\app\classes3.dex */
final class fx {
    static tk j(Context context) {
        if (g.m()) {
            return new ov(new qv());
        }
        if (g.ae() && qv.j()) {
            return new qv();
        }
        if (et.j()) {
            return new et(context);
        }
        if (g.cw() && g.r()) {
            return new ll();
        }
        if (g.cw() && !g.r()) {
            return new qe();
        }
        if (!g.j(context) && !g.cw()) {
            if (g.g()) {
                return new ov();
            }
            if (g.tl()) {
                return new xw();
            }
            if (Build.VERSION.SDK_INT > 28) {
                if (g.oq()) {
                    return new om();
                }
                if (g.vl()) {
                    return new d();
                }
                if (g.qv()) {
                    return new px();
                }
                if (g.jy()) {
                    return new ed();
                }
                u uVar = new u(context);
                if (uVar.j(context)) {
                    return uVar;
                }
                return new ka();
            }
            if (!g.up() && ll.cw(context)) {
                return new ll();
            }
            return null;
        }
        return new ll();
    }
}
