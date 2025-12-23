package com.bytedance.sdk.component.adexpress.dynamic.r;

import com.bytedance.sdk.component.adexpress.dynamic.r.xt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\Downloads\app\classes4.dex */
public class oq {
    public static float j(float f6) {
        return (float) Math.ceil((f6 * 16.0f) / 16.0f);
    }

    public static List<xt.j> j(float f6, List<xt.j> list) {
        ArrayList<xt.j> arrayList = new ArrayList();
        Iterator<xt.j> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add((xt.j) it.next().clone());
        }
        boolean z5 = true;
        int i6 = 0;
        int i7 = 0;
        for (xt.j jVar : arrayList) {
            if (jVar.xt) {
                i6 = (int) (i6 + jVar.f25803j);
            } else {
                i7 = (int) (i7 + jVar.f25803j);
                z5 = false;
            }
        }
        if (!z5 || f6 <= i6) {
            float f7 = i6;
            float f8 = f6 < f7 ? f6 / f7 : 1.0f;
            float f9 = f6 > f7 ? (f6 - f7) / i7 : 0.0f;
            if (f9 > 1.0f) {
                ArrayList arrayList2 = new ArrayList();
                boolean z6 = false;
                for (xt.j jVar2 : arrayList) {
                    if (!jVar2.xt) {
                        float f10 = jVar2.cw;
                        if (f10 != 0.0f && jVar2.f25803j * f9 > f10) {
                            jVar2.f25803j = f10;
                            jVar2.xt = true;
                            z6 = true;
                        }
                    }
                    arrayList2.add(jVar2);
                }
                if (z6) {
                    return j(f6, arrayList2);
                }
            }
            int i8 = 0;
            for (xt.j jVar3 : arrayList) {
                if (jVar3.xt) {
                    jVar3.f25803j = j(jVar3.f25803j * f8);
                } else {
                    jVar3.f25803j = j(jVar3.f25803j * f9);
                }
                i8 = (int) (i8 + jVar3.f25803j);
            }
            float f11 = i8;
            if (f11 < f6) {
                float f12 = f6 - f11;
                for (int i9 = 0; i9 < arrayList.size() && f12 > 0.0f; i9 = (i9 + 1) % arrayList.size()) {
                    xt.j jVar4 = (xt.j) arrayList.get(i9);
                    if ((f6 < f7 && jVar4.xt) || (f6 > f7 && !jVar4.xt)) {
                        jVar4.f25803j += 0.0625f;
                        f12 -= 0.0625f;
                    }
                }
            }
        }
        return arrayList;
    }
}
