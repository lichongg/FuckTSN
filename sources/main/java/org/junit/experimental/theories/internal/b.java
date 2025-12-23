package org.junit.experimental.theories.internal;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.experimental.theories.ParametersSuppliedBy;
import org.junit.experimental.theories.PotentialAssignment;
import org.junit.runners.model.i;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private final List<PotentialAssignment> f51375a;

    /* renamed from: b, reason: collision with root package name */
    private final List<org.junit.experimental.theories.a> f51376b;

    /* renamed from: c, reason: collision with root package name */
    private final i f51377c;

    public Object[] h() throws PotentialAssignment.CouldNotGenerateValueException {
        return e(0, i());
    }

    private int i() {
        return org.junit.experimental.theories.a.n(this.f51377c.l()).size();
    }

    private org.junit.experimental.theories.b k(org.junit.experimental.theories.a aVar) throws Exception {
        ParametersSuppliedBy parametersSuppliedBy = (ParametersSuppliedBy) aVar.e(ParametersSuppliedBy.class);
        return parametersSuppliedBy != null ? c(parametersSuppliedBy.value()) : new a(this.f51377c);
    }

    public b b(PotentialAssignment potentialAssignment) {
        ArrayList arrayList = new ArrayList(this.f51375a);
        arrayList.add(potentialAssignment);
        List<org.junit.experimental.theories.a> list = this.f51376b;
        return new b(arrayList, list.subList(1, list.size()), this.f51377c);
    }

    public Object[] e(int i6, int i7) throws PotentialAssignment.CouldNotGenerateValueException {
        Object[] objArr = new Object[i7 - i6];
        for (int i8 = i6; i8 < i7; i8++) {
            objArr[i8 - i6] = this.f51375a.get(i8).c();
        }
        return objArr;
    }

    public Object[] f() throws PotentialAssignment.CouldNotGenerateValueException {
        return e(0, this.f51375a.size());
    }

    public Object[] g(boolean z5) throws PotentialAssignment.CouldNotGenerateValueException {
        int size = this.f51375a.size();
        Object[] objArr = new Object[size];
        for (int i6 = 0; i6 < size; i6++) {
            objArr[i6] = this.f51375a.get(i6).b();
        }
        return objArr;
    }

    public boolean l() {
        return this.f51376b.size() == 0;
    }

    public org.junit.experimental.theories.a m() {
        return this.f51376b.get(0);
    }

    private b(List<PotentialAssignment> list, List<org.junit.experimental.theories.a> list2, i iVar) {
        this.f51376b = list2;
        this.f51375a = list;
        this.f51377c = iVar;
    }

    public static b a(Method method, i iVar) {
        List<org.junit.experimental.theories.a> n6 = org.junit.experimental.theories.a.n(iVar.l());
        n6.addAll(org.junit.experimental.theories.a.l(method));
        return new b(new ArrayList(), n6, iVar);
    }

    private org.junit.experimental.theories.b c(Class<? extends org.junit.experimental.theories.b> cls) throws Exception {
        for (Constructor<?> constructor : cls.getConstructors()) {
            Class<?>[] parameterTypes = constructor.getParameterTypes();
            if (parameterTypes.length == 1 && parameterTypes[0].equals(i.class)) {
                return (org.junit.experimental.theories.b) constructor.newInstance(this.f51377c);
            }
        }
        return cls.newInstance();
    }

    private List<PotentialAssignment> d(org.junit.experimental.theories.a aVar) {
        Class<?> type = aVar.getType();
        if (type.isEnum()) {
            return new d(type).a(aVar);
        }
        if (!type.equals(Boolean.class) && !type.equals(Boolean.TYPE)) {
            return Collections.EMPTY_LIST;
        }
        return new c().a(aVar);
    }

    public Object[] j() throws PotentialAssignment.CouldNotGenerateValueException {
        return e(i(), this.f51375a.size());
    }

    public List<PotentialAssignment> n() throws Throwable {
        org.junit.experimental.theories.a m6 = m();
        List<PotentialAssignment> a6 = k(m6).a(m6);
        if (a6.size() == 0) {
            return d(m6);
        }
        return a6;
    }
}
