package com.bytedance.adsdk.lottie.r;

import android.util.JsonReader;
import android.util.JsonToken;
import java.io.IOException;

/* loaded from: D:\Downloads\app\classes3.dex */
public class rn implements nd<com.bytedance.adsdk.lottie.m.r> {

    /* renamed from: j, reason: collision with root package name */
    public static final rn f23512j = new rn();

    private rn() {
    }

    @Override // com.bytedance.adsdk.lottie.r.nd
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public com.bytedance.adsdk.lottie.m.r xt(JsonReader jsonReader, float f6) throws IOException {
        boolean z5;
        if (jsonReader.peek() == JsonToken.BEGIN_ARRAY) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (z5) {
            jsonReader.beginArray();
        }
        float nextDouble = (float) jsonReader.nextDouble();
        float nextDouble2 = (float) jsonReader.nextDouble();
        while (jsonReader.hasNext()) {
            jsonReader.skipValue();
        }
        if (z5) {
            jsonReader.endArray();
        }
        return new com.bytedance.adsdk.lottie.m.r((nextDouble / 100.0f) * f6, (nextDouble2 / 100.0f) * f6);
    }
}
