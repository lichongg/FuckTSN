package org.junit.rules;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.junit.runner.Description;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class g implements l {

    /* renamed from: b, reason: collision with root package name */
    private static final g f51465b = new g(Collections.EMPTY_LIST);

    /* renamed from: a, reason: collision with root package name */
    private List<l> f51466a;

    public static g c() {
        return f51465b;
    }

    @Override // org.junit.rules.l
    public org.junit.runners.model.h a(org.junit.runners.model.h hVar, Description description) {
        Iterator<l> it = this.f51466a.iterator();
        while (it.hasNext()) {
            hVar = it.next().a(hVar, description);
        }
        return hVar;
    }

    public g b(l lVar) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(lVar);
        arrayList.addAll(this.f51466a);
        return new g(arrayList);
    }

    private g(List<l> list) {
        this.f51466a = list;
    }

    public static g d(l lVar) {
        return c().b(lVar);
    }
}
