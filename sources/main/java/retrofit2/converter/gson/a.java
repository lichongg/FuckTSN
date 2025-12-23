package retrofit2.converter.gson;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.d0;
import retrofit2.g;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class a extends g.a {

    /* renamed from: a, reason: collision with root package name */
    private final Gson f52090a;

    public static a b() {
        return c(new Gson());
    }

    public static a c(Gson gson) {
        if (gson != null) {
            return new a(gson);
        }
        throw new NullPointerException("gson == null");
    }

    @Override // retrofit2.g.a
    public g<?, RequestBody> requestBodyConverter(Type type, Annotation[] annotationArr, Annotation[] annotationArr2, d0 d0Var) {
        return new b(this.f52090a, this.f52090a.getAdapter(TypeToken.get(type)));
    }

    @Override // retrofit2.g.a
    public g<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotationArr, d0 d0Var) {
        return new c(this.f52090a, this.f52090a.getAdapter(TypeToken.get(type)));
    }

    private a(Gson gson) {
        this.f52090a = gson;
    }
}
