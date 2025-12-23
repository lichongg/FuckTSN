package retrofit2;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import javax.annotation.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
abstract class e0<T> {
    @Nullable
    abstract T a(Object[] objArr);

    e0() {
    }

    static <T> e0<T> b(d0 d0Var, Method method) {
        b0 b6 = b0.b(d0Var, method);
        Type genericReturnType = method.getGenericReturnType();
        if (!f0.j(genericReturnType)) {
            if (genericReturnType != Void.TYPE) {
                return k.f(d0Var, method, b6);
            }
            throw f0.m(method, "Service methods cannot return void.", new Object[0]);
        }
        throw f0.m(method, "Method return type must not include a type variable or wildcard: %s", genericReturnType);
    }
}
