package org.junit.runners.model;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
class e {

    /* renamed from: a, reason: collision with root package name */
    private final Method f51557a;

    private void d(Type type, List<Throwable> list) {
        if (type instanceof TypeVariable) {
            list.add(new Exception("Method " + this.f51557a.getName() + "() contains unresolved type variable " + type));
            return;
        }
        if (type instanceof ParameterizedType) {
            c((ParameterizedType) type, list);
        } else if (type instanceof WildcardType) {
            e((WildcardType) type, list);
        } else if (type instanceof GenericArrayType) {
            b((GenericArrayType) type, list);
        }
    }

    void a(List<Throwable> list) {
        for (Type type : this.f51557a.getGenericParameterTypes()) {
            d(type, list);
        }
    }

    e(Method method) {
        this.f51557a = method;
    }

    private void b(GenericArrayType genericArrayType, List<Throwable> list) {
        d(genericArrayType.getGenericComponentType(), list);
    }

    private void c(ParameterizedType parameterizedType, List<Throwable> list) {
        for (Type type : parameterizedType.getActualTypeArguments()) {
            d(type, list);
        }
    }

    private void e(WildcardType wildcardType, List<Throwable> list) {
        for (Type type : wildcardType.getUpperBounds()) {
            d(type, list);
        }
        for (Type type2 : wildcardType.getLowerBounds()) {
            d(type2, list);
        }
    }
}
