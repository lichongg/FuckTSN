package com.bytedance.adsdk.lottie.r;

import android.graphics.Color;
import android.util.JsonReader;
import android.util.JsonToken;
import java.io.IOException;

/* loaded from: D:\Downloads\app\classes3.dex */
public class ae implements nd<Integer> {

    /* renamed from: j, reason: collision with root package name */
    public static final ae f23501j = new ae();

    private ae() {
    }

    @Override // com.bytedance.adsdk.lottie.r.nd
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public Integer xt(JsonReader jsonReader, float f6) throws IOException {
        boolean z5;
        double d6;
        if (jsonReader.peek() == JsonToken.BEGIN_ARRAY) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (z5) {
            jsonReader.beginArray();
        }
        double nextDouble = jsonReader.nextDouble();
        double nextDouble2 = jsonReader.nextDouble();
        double nextDouble3 = jsonReader.nextDouble();
        if (jsonReader.peek() == JsonToken.NUMBER) {
            d6 = jsonReader.nextDouble();
        } else {
            d6 = 1.0d;
        }
        if (z5) {
            jsonReader.endArray();
        }
        if (nextDouble <= 1.0d && nextDouble2 <= 1.0d && nextDouble3 <= 1.0d) {
            nextDouble *= 255.0d;
            nextDouble2 *= 255.0d;
            nextDouble3 *= 255.0d;
            if (d6 <= 1.0d) {
                d6 *= 255.0d;
            }
        }
        return Integer.valueOf(Color.argb((int) d6, (int) nextDouble, (int) nextDouble2, (int) nextDouble3));
    }
}
