package org.junit.experimental.theories.internal;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.junit.experimental.theories.DataPoint;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.PotentialAssignment;
import org.junit.runners.model.i;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class a extends org.junit.experimental.theories.b {

    /* renamed from: a, reason: collision with root package name */
    private final i f51373a;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: org.junit.experimental.theories.internal.a$a, reason: collision with other inner class name */
    static /* synthetic */ class C0988a {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class b extends PotentialAssignment {

        /* renamed from: a, reason: collision with root package name */
        private final org.junit.runners.model.d f51374a;

        /* synthetic */ b(org.junit.runners.model.d dVar, C0988a c0988a) {
            this(dVar);
        }

        @Override // org.junit.experimental.theories.PotentialAssignment
        public Object c() throws PotentialAssignment.CouldNotGenerateValueException {
            try {
                return this.f51374a.l(null, new Object[0]);
            } catch (IllegalAccessException unused) {
                throw new RuntimeException("unexpected: getMethods returned an inaccessible method");
            } catch (IllegalArgumentException unused2) {
                throw new RuntimeException("unexpected: argument length is checked");
            } catch (Throwable th) {
                DataPoint dataPoint = (DataPoint) this.f51374a.getAnnotation(DataPoint.class);
                org.junit.b.i(dataPoint == null || !a.o(dataPoint.ignoredExceptions(), th));
                throw new PotentialAssignment.CouldNotGenerateValueException(th);
            }
        }

        private b(org.junit.runners.model.d dVar) {
            this.f51374a = dVar;
        }

        @Override // org.junit.experimental.theories.PotentialAssignment
        public String b() throws PotentialAssignment.CouldNotGenerateValueException {
            return this.f51374a.c();
        }
    }

    private void c(org.junit.experimental.theories.a aVar, String str, List<PotentialAssignment> list, Object obj) {
        for (int i6 = 0; i6 < Array.getLength(obj); i6++) {
            Object obj2 = Array.get(obj, i6);
            if (aVar.c(obj2)) {
                list.add(PotentialAssignment.a(str + "[" + i6 + "]", obj2));
            }
        }
    }

    private Object n(Field field) {
        try {
            return field.get(null);
        } catch (IllegalAccessException unused) {
            throw new RuntimeException("unexpected: getFields returned an inaccessible field");
        } catch (IllegalArgumentException unused2) {
            throw new RuntimeException("unexpected: field from getClass doesn't exist on object");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean o(Class<?>[] clsArr, Object obj) {
        for (Class<?> cls : clsArr) {
            if (cls.isAssignableFrom(obj.getClass())) {
                return true;
            }
        }
        return false;
    }

    @Override // org.junit.experimental.theories.b
    public List<PotentialAssignment> a(org.junit.experimental.theories.a aVar) throws Throwable {
        ArrayList arrayList = new ArrayList();
        h(aVar, arrayList);
        f(aVar, arrayList);
        i(aVar, arrayList);
        g(aVar, arrayList);
        return arrayList;
    }

    protected Collection<Field> j(org.junit.experimental.theories.a aVar) {
        List<org.junit.runners.model.b> e6 = this.f51373a.e(DataPoints.class);
        ArrayList arrayList = new ArrayList();
        Iterator<org.junit.runners.model.b> it = e6.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().i());
        }
        return arrayList;
    }

    protected Collection<org.junit.runners.model.d> k(org.junit.experimental.theories.a aVar) {
        return this.f51373a.i(DataPoints.class);
    }

    protected Collection<Field> l(org.junit.experimental.theories.a aVar) {
        List<org.junit.runners.model.b> e6 = this.f51373a.e(DataPoint.class);
        ArrayList arrayList = new ArrayList();
        Iterator<org.junit.runners.model.b> it = e6.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().i());
        }
        return arrayList;
    }

    protected Collection<org.junit.runners.model.d> m(org.junit.experimental.theories.a aVar) {
        return this.f51373a.i(DataPoint.class);
    }

    public a(i iVar) {
        this.f51373a = iVar;
    }

    private void d(Class<?> cls, org.junit.experimental.theories.a aVar, String str, List<PotentialAssignment> list, Object obj) {
        if (cls.isArray()) {
            c(aVar, str, list, obj);
        } else if (Iterable.class.isAssignableFrom(cls)) {
            e(aVar, str, list, (Iterable) obj);
        }
    }

    private void e(org.junit.experimental.theories.a aVar, String str, List<PotentialAssignment> list, Iterable<?> iterable) {
        int i6 = 0;
        for (Object obj : iterable) {
            if (aVar.c(obj)) {
                list.add(PotentialAssignment.a(str + "[" + i6 + "]", obj));
            }
            i6++;
        }
    }

    private void f(org.junit.experimental.theories.a aVar, List<PotentialAssignment> list) {
        for (Field field : j(aVar)) {
            d(field.getType(), aVar, field.getName(), list, n(field));
        }
    }

    private void g(org.junit.experimental.theories.a aVar, List<PotentialAssignment> list) throws Throwable {
        org.junit.experimental.theories.a aVar2;
        List<PotentialAssignment> list2;
        for (org.junit.runners.model.d dVar : k(aVar)) {
            Class<?> k6 = dVar.k();
            if ((k6.isArray() && aVar.d(k6.getComponentType())) || Iterable.class.isAssignableFrom(k6)) {
                try {
                    aVar2 = aVar;
                    list2 = list;
                    d(k6, aVar2, dVar.c(), list2, dVar.l(null, new Object[0]));
                } catch (Throwable th) {
                    DataPoints dataPoints = (DataPoints) dVar.getAnnotation(DataPoints.class);
                    if (dataPoints != null) {
                        if (!o(dataPoints.ignoredExceptions(), th)) {
                            throw th;
                        }
                        return;
                    }
                    throw th;
                }
            } else {
                aVar2 = aVar;
                list2 = list;
            }
            aVar = aVar2;
            list = list2;
        }
    }

    private void h(org.junit.experimental.theories.a aVar, List<PotentialAssignment> list) {
        for (Field field : l(aVar)) {
            Object n6 = n(field);
            if (aVar.c(n6)) {
                list.add(PotentialAssignment.a(field.getName(), n6));
            }
        }
    }

    private void i(org.junit.experimental.theories.a aVar, List<PotentialAssignment> list) {
        for (org.junit.runners.model.d dVar : m(aVar)) {
            if (aVar.b(dVar.getType())) {
                list.add(new b(dVar, null));
            }
        }
    }
}
