package com.bytedance.pangle.util.xt.xt;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j {

    /* renamed from: j, reason: collision with root package name */
    private List<cw> f25555j = new ArrayList();

    public List<cw> j() {
        return this.f25555j;
    }

    public void j(Set<String> set) {
        ArrayList arrayList = new ArrayList();
        for (cw cwVar : this.f25555j) {
            if (!set.contains(cwVar.vl())) {
                arrayList.add(cwVar);
            }
        }
        this.f25555j = arrayList;
    }

    public void j(List<cw> list) {
        this.f25555j = list;
    }
}
