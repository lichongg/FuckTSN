package xyz.adscope.common.network.simple;

import java.lang.reflect.Type;
import xyz.adscope.common.network.Response;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public interface Converter {
    public static final Converter DEFAULT = new Converter() { // from class: xyz.adscope.common.network.simple.Converter.1
        @Override // xyz.adscope.common.network.simple.Converter
        public <S, F> SimpleResponse<S, F> convert(Type type, Type type2, Response response, boolean z5) {
            return SimpleResponse.newBuilder().code(response.code()).headers(response.headers()).fromCache(z5).succeed(type == String.class ? response.body().string() : null).build();
        }
    };

    <S, F> SimpleResponse<S, F> convert(Type type, Type type2, Response response, boolean z5);
}
