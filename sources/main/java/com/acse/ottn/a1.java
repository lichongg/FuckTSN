package com.acse.ottn;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import java.io.IOException;
import okhttp3.MediaType;
import okhttp3.RequestBody;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class a1<T> implements retrofit2.g<T, RequestBody> {

    /* renamed from: a, reason: collision with root package name */
    public static final MediaType f4040a = MediaType.parse("application/json; charset=UTF-8");

    @Override // retrofit2.g
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public RequestBody convert(T t5) throws IOException {
        return RequestBody.create(f4040a, JSON.toJSONBytes(t5, new SerializerFeature[0]));
    }
}
