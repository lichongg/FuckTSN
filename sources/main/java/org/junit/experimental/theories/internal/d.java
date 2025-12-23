package org.junit.experimental.theories.internal;

import java.util.ArrayList;
import java.util.List;
import org.junit.experimental.theories.PotentialAssignment;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class d extends org.junit.experimental.theories.b {

    /* renamed from: a, reason: collision with root package name */
    private Class<?> f51378a;

    @Override // org.junit.experimental.theories.b
    public List<PotentialAssignment> a(org.junit.experimental.theories.a aVar) {
        Object[] enumConstants = this.f51378a.getEnumConstants();
        ArrayList arrayList = new ArrayList();
        for (Object obj : enumConstants) {
            arrayList.add(PotentialAssignment.a(obj.toString(), obj));
        }
        return arrayList;
    }

    public d(Class<?> cls) {
        this.f51378a = cls;
    }
}
