package retrofit2;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Optional;
import javax.annotation.Nullable;
import okhttp3.ResponseBody;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;
import retrofit2.g;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@IgnoreJRERequirement
/* loaded from: D:\Downloads\app\classes7.dex */
final class q extends g.a {

    /* renamed from: a, reason: collision with root package name */
    static final g.a f52180a = new q();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @IgnoreJRERequirement
    static final class a<T> implements g<ResponseBody, Optional<T>> {

        /* renamed from: a, reason: collision with root package name */
        final g<ResponseBody, T> f52181a;

        @Override // retrofit2.g
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Optional<T> convert(ResponseBody responseBody) throws IOException {
            Optional<T> ofNullable;
            ofNullable = Optional.ofNullable(this.f52181a.convert(responseBody));
            return ofNullable;
        }

        a(g<ResponseBody, T> gVar) {
            this.f52181a = gVar;
        }
    }

    q() {
    }

    @Override // retrofit2.g.a
    @Nullable
    public g<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotationArr, d0 d0Var) {
        if (g.a.getRawType(type) != o.a()) {
            return null;
        }
        return new a(d0Var.n(g.a.getParameterUpperBound(0, (ParameterizedType) type), annotationArr));
    }
}
