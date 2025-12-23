package com.bytedance.adsdk.lottie.r;

import android.graphics.PointF;
import android.util.JsonReader;
import android.util.JsonToken;
import java.io.IOException;

/* loaded from: D:\Downloads\app\classes3.dex */
public class l implements nd<PointF> {

    /* renamed from: j, reason: collision with root package name */
    public static final l f23506j = new l();

    private l() {
    }

    @Override // com.bytedance.adsdk.lottie.r.nd
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public PointF xt(JsonReader jsonReader, float f6) throws IOException {
        JsonToken peek = jsonReader.peek();
        if (peek == JsonToken.BEGIN_ARRAY) {
            return mi.xt(jsonReader, f6);
        }
        if (peek == JsonToken.BEGIN_OBJECT) {
            return mi.xt(jsonReader, f6);
        }
        if (peek == JsonToken.NUMBER) {
            PointF pointF = new PointF(((float) jsonReader.nextDouble()) * f6, ((float) jsonReader.nextDouble()) * f6);
            while (jsonReader.hasNext()) {
                jsonReader.skipValue();
            }
            return pointF;
        }
        throw new IllegalArgumentException("Cannot convert json to point. Next token is ".concat(String.valueOf(peek)));
    }
}
