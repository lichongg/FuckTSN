package retrofit2;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import javax.annotation.Nullable;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public interface g<F, T> {
    @Nullable
    T convert(F f6) throws IOException;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static abstract class a {
        @Nullable
        public g<?, RequestBody> requestBodyConverter(Type type, Annotation[] annotationArr, Annotation[] annotationArr2, d0 d0Var) {
            return null;
        }

        @Nullable
        public g<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotationArr, d0 d0Var) {
            return null;
        }

        @Nullable
        public g<?, String> stringConverter(Type type, Annotation[] annotationArr, d0 d0Var) {
            return null;
        }

        protected static Type getParameterUpperBound(int i6, ParameterizedType parameterizedType) {
            return f0.g(i6, parameterizedType);
        }

        protected static Class<?> getRawType(Type type) {
            return f0.h(type);
        }
    }
}
