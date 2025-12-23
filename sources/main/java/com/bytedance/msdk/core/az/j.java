package com.bytedance.msdk.core.az;

import android.text.TextUtils;
import com.bytedance.msdk.core.oq.oq;
import com.bytedance.msdk.core.oq.xt;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: D:\Downloads\app\classes3.dex */
public class j {
    public static xt j(xt xtVar, String str) {
        if (xtVar == null || TextUtils.isEmpty(str) || xtVar.ol() == null || xtVar.ol().size() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<oq> it = xtVar.ol().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            oq next = it.next();
            if (str.equals(next.w())) {
                arrayList.add(next.up());
                break;
            }
        }
        if (arrayList.size() == 0) {
            return null;
        }
        oq oqVar = arrayList.get(0);
        if (oqVar != null && oqVar.h() && !MediationConstant.ADN_PANGLE.equals(oqVar.az())) {
            Iterator<oq> it2 = xtVar.ol().iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                oq next2 = it2.next();
                if (next2.h() && MediationConstant.ADN_PANGLE.equals(next2.az())) {
                    arrayList.add(next2.up());
                    break;
                }
            }
        }
        xt az = xtVar.az();
        if (az.qv()) {
            az.xt(arrayList);
        } else {
            az.j(arrayList);
        }
        oq oqVar2 = arrayList.get(0);
        oqVar2.up(0);
        if (oqVar2.mi() == 0) {
            az.r(oqVar2.v());
        }
        if (oqVar2.mi() == 2) {
            az.j(true);
        }
        if (oqVar2.mi() == 1 || oqVar2.mi() == 3) {
            az.xt(true);
        }
        az.vl(0);
        return az;
    }

    public static String j(String str) {
        try {
            if (!TextUtils.isEmpty(str) && str.startsWith("gm_test_slot_")) {
                return str.substring(13);
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }
}
