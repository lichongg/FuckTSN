package com.acse.ottn;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.g;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class z0 extends g.a {
    public static z0 a() {
        return new z0();
    }

    @Override // retrofit2.g.a
    public retrofit2.g<?, RequestBody> requestBodyConverter(Type type, Annotation[] annotationArr, Annotation[] annotationArr2, retrofit2.d0 d0Var) {
        return new a1();
    }

    @Override // retrofit2.g.a
    public retrofit2.g<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotationArr, retrofit2.d0 d0Var) {
        return new b1(type);
    }
}
