package com.google.common.reflect;

import com.google.common.annotations.Beta;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Beta
/* loaded from: D:\Downloads\app\classes5.dex */
public abstract class AbstractInvocationHandler implements InvocationHandler {
    private static final Object[] NO_ARGS = new Object[0];

    protected abstract Object handleInvocation(Object obj, Method method, Object[] objArr) throws Throwable;

    @Override // java.lang.reflect.InvocationHandler
    public final Object invoke(Object obj, Method method, @NullableDecl Object[] objArr) throws Throwable {
        if (objArr == null) {
            objArr = NO_ARGS;
        }
        if (objArr.length == 0 && method.getName().equals("hashCode")) {
            return Integer.valueOf(hashCode());
        }
        if (objArr.length != 1 || !method.getName().equals("equals") || method.getParameterTypes()[0] != Object.class) {
            return (objArr.length == 0 && method.getName().equals("toString")) ? toString() : handleInvocation(obj, method, objArr);
        }
        Object obj2 = objArr[0];
        if (obj2 == null) {
            return Boolean.FALSE;
        }
        if (obj == obj2) {
            return Boolean.TRUE;
        }
        return Boolean.valueOf(isProxyOfSameInterfaces(obj2, obj.getClass()) && equals(Proxy.getInvocationHandler(obj2)));
    }

    private static boolean isProxyOfSameInterfaces(Object obj, Class<?> cls) {
        if (!cls.isInstance(obj)) {
            if (!Proxy.isProxyClass(obj.getClass()) || !Arrays.equals(obj.getClass().getInterfaces(), cls.getInterfaces())) {
                return false;
            }
            return true;
        }
        return true;
    }

    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public int hashCode() {
        return super.hashCode();
    }

    public String toString() {
        return super.toString();
    }
}
