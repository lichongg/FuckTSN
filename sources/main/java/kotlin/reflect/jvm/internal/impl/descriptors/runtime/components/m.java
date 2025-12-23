package kotlin.reflect.jvm.internal.impl.descriptors.runtime.components;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Iterator;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
final class m {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final m f44979a = new m();

    @NotNull
    public final String a(@NotNull Constructor<?> constructor) {
        g0.p(constructor, "constructor");
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        Iterator a6 = kotlin.jvm.internal.h.a(constructor.getParameterTypes());
        while (a6.hasNext()) {
            Class cls = (Class) a6.next();
            g0.m(cls);
            sb.append(kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.f.f(cls));
        }
        sb.append(")V");
        String sb2 = sb.toString();
        g0.o(sb2, "toString(...)");
        return sb2;
    }

    @NotNull
    public final String b(@NotNull Field field) {
        g0.p(field, "field");
        Class<?> type = field.getType();
        g0.o(type, "getType(...)");
        return kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.f.f(type);
    }

    @NotNull
    public final String c(@NotNull Method method) {
        g0.p(method, "method");
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        Iterator a6 = kotlin.jvm.internal.h.a(method.getParameterTypes());
        while (a6.hasNext()) {
            Class cls = (Class) a6.next();
            g0.m(cls);
            sb.append(kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.f.f(cls));
        }
        sb.append(")");
        Class<?> returnType = method.getReturnType();
        g0.o(returnType, "getReturnType(...)");
        sb.append(kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.f.f(returnType));
        String sb2 = sb.toString();
        g0.o(sb2, "toString(...)");
        return sb2;
    }

    private m() {
    }
}
