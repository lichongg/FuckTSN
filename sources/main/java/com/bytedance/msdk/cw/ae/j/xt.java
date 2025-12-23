package com.bytedance.msdk.cw.ae.j;

import android.text.TextUtils;
import com.bytedance.msdk.core.oq.oq;
import com.bytedance.msdk.cw.tl.m;
import com.bytedance.msdk.tl.p;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: D:\Downloads\app\classes3.dex */
public class xt implements j {
    @Override // com.bytedance.msdk.cw.ae.j.j
    public boolean j(com.bytedance.msdk.cw.m.j.xt xtVar, com.bytedance.msdk.xt.cw cwVar, List<oq> list) {
        if (cwVar == null || xtVar == null) {
            return false;
        }
        if (xtVar.jy().m(m.j(xtVar.vl(), cwVar)) == 0) {
            return true;
        }
        return j(cwVar, list);
    }

    protected boolean j(com.bytedance.msdk.xt.cw cwVar, List<oq> list) {
        if (cwVar == null || TextUtils.isEmpty(cwVar.qa()) || !cwVar.qe() || p.j(list)) {
            return false;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(list);
        Collections.sort(arrayList);
        return !p.xt(arrayList) && cwVar.qa().equals(((oq) arrayList.get(0)).w());
    }
}
