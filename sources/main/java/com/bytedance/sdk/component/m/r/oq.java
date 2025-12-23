package com.bytedance.sdk.component.m.r;

import android.graphics.Bitmap;
import com.bytedance.sdk.component.m.w;
import java.util.Collection;
import java.util.Iterator;

/* loaded from: D:\Downloads\app\classes4.dex */
public class oq extends j {
    @Override // com.bytedance.sdk.component.m.r.g
    public void j(com.bytedance.sdk.component.m.cw.cw cwVar) {
        int jy = cwVar.jy();
        Bitmap xt = (jy == 2 || jy == 1) ? (cwVar.f() || cwVar.tj().m()) ? xt(cwVar) : cw(cwVar) : null;
        if (xt != null) {
            cwVar.j(new jy(xt, null, null, false));
        } else if (cwVar.tj().ae()) {
            cwVar.j(new vl());
        } else {
            cwVar.j(new m());
        }
    }

    private Bitmap cw(com.bytedance.sdk.component.m.cw.cw cwVar) {
        return cwVar.kt().j(cwVar.tj()).j((w) cwVar.ae());
    }

    private Bitmap xt(com.bytedance.sdk.component.m.cw.cw cwVar) {
        Collection<w> j6 = cwVar.kt().j();
        Bitmap bitmap = null;
        if (j6 == null) {
            return null;
        }
        Iterator<w> it = j6.iterator();
        while (it.hasNext() && (bitmap = it.next().j((w) cwVar.ae())) == null) {
        }
        return bitmap;
    }

    @Override // com.bytedance.sdk.component.m.r.g
    public String j() {
        return "memory_cache";
    }
}
