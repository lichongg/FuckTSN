package com.bytedance.msdk.cw.r;

import android.content.Context;
import android.os.SystemClock;
import com.bytedance.msdk.core.up.xt.r;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: D:\Downloads\app\classes3.dex */
public class cw extends xt implements com.bytedance.msdk.core.up.xt.xt {
    @Override // com.bytedance.msdk.core.up.xt.xt
    public ConcurrentHashMap<String, com.bytedance.msdk.api.xt> cw() {
        com.bytedance.msdk.cw.m.j.xt xtVar = this.cw;
        if (xtVar != null) {
            return xtVar.x();
        }
        return null;
    }

    @Override // com.bytedance.msdk.core.up.xt.xt
    public int e_() {
        com.bytedance.msdk.cw.m.j.xt xtVar = this.cw;
        if (xtVar != null) {
            return xtVar.s();
        }
        return 0;
    }

    @Override // com.bytedance.msdk.core.up.xt.xt
    public com.bytedance.msdk.cw.m.j.xt r() {
        return this.cw;
    }

    public cw(Context context) {
        super(context);
    }

    @Override // com.bytedance.msdk.core.up.xt.xt
    public void j(Context context, com.bytedance.msdk.api.j.xt xtVar, r.cw cwVar) {
        j(xtVar);
        this.cw.xt(true);
        long currentThreadTimeMillis = SystemClock.currentThreadTimeMillis();
        this.cw.j(currentThreadTimeMillis);
        this.cw.j(cwVar);
        com.bytedance.msdk.core.up.xt.r.j().j(this.up, currentThreadTimeMillis);
        g();
    }
}
