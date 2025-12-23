package retrofit2;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import javax.annotation.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public interface c<R, T> {
    Type a();

    T b(b<R> bVar);

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static abstract class a {
        @Nullable
        public abstract c<?, ?> a(Type type, Annotation[] annotationArr, d0 d0Var);

        protected static Type b(int i6, ParameterizedType parameterizedType) {
            return f0.g(i6, parameterizedType);
        }

        protected static Class<?> c(Type type) {
            return f0.h(type);
        }
    }
}
