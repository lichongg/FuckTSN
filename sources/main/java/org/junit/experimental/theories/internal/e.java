package org.junit.experimental.theories.internal;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import org.junit.experimental.theories.DataPoint;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.FromDataPoints;
import org.junit.runners.model.i;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class e extends a {
    public e(i iVar) {
        super(iVar);
    }

    @Override // org.junit.experimental.theories.internal.a
    protected Collection<Field> j(org.junit.experimental.theories.a aVar) {
        Collection<Field> j6 = super.j(aVar);
        String value = ((FromDataPoints) aVar.g(FromDataPoints.class)).value();
        ArrayList arrayList = new ArrayList();
        for (Field field : j6) {
            if (Arrays.asList(((DataPoints) field.getAnnotation(DataPoints.class)).value()).contains(value)) {
                arrayList.add(field);
            }
        }
        return arrayList;
    }

    @Override // org.junit.experimental.theories.internal.a
    protected Collection<org.junit.runners.model.d> k(org.junit.experimental.theories.a aVar) {
        Collection<org.junit.runners.model.d> k6 = super.k(aVar);
        String value = ((FromDataPoints) aVar.g(FromDataPoints.class)).value();
        ArrayList arrayList = new ArrayList();
        for (org.junit.runners.model.d dVar : k6) {
            if (Arrays.asList(((DataPoints) dVar.getAnnotation(DataPoints.class)).value()).contains(value)) {
                arrayList.add(dVar);
            }
        }
        return arrayList;
    }

    @Override // org.junit.experimental.theories.internal.a
    protected Collection<Field> l(org.junit.experimental.theories.a aVar) {
        Collection<Field> l6 = super.l(aVar);
        String value = ((FromDataPoints) aVar.g(FromDataPoints.class)).value();
        ArrayList arrayList = new ArrayList();
        for (Field field : l6) {
            if (Arrays.asList(((DataPoint) field.getAnnotation(DataPoint.class)).value()).contains(value)) {
                arrayList.add(field);
            }
        }
        return arrayList;
    }

    @Override // org.junit.experimental.theories.internal.a
    protected Collection<org.junit.runners.model.d> m(org.junit.experimental.theories.a aVar) {
        Collection<org.junit.runners.model.d> m6 = super.m(aVar);
        String value = ((FromDataPoints) aVar.g(FromDataPoints.class)).value();
        ArrayList arrayList = new ArrayList();
        for (org.junit.runners.model.d dVar : m6) {
            if (Arrays.asList(((DataPoint) dVar.getAnnotation(DataPoint.class)).value()).contains(value)) {
                arrayList.add(dVar);
            }
        }
        return arrayList;
    }
}
