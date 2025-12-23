package kotlin.reflect.jvm.internal;

import java.lang.reflect.Method;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class m3 {
    /* JADX INFO: Access modifiers changed from: private */
    public static final String d(Method method) {
        StringBuilder sb = new StringBuilder();
        sb.append(method.getName());
        Class<?>[] parameterTypes = method.getParameterTypes();
        kotlin.jvm.internal.g0.o(parameterTypes, "getParameterTypes(...)");
        sb.append(kotlin.collections.n.Eh(parameterTypes, "", "(", ")", 0, null, l3.f47519a, 24, null));
        Class<?> returnType = method.getReturnType();
        kotlin.jvm.internal.g0.o(returnType, "getReturnType(...)");
        sb.append(kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.f.f(returnType));
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence a(Class cls) {
        kotlin.jvm.internal.g0.m(cls);
        return kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.f.f(cls);
    }
}
