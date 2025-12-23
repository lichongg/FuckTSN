package com.bytedance.adsdk.lottie.r;

import android.graphics.Color;
import android.graphics.PointF;
import android.util.JsonReader;
import android.util.JsonToken;
import com.bytedance.component.sdk.annotation.ColorInt;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\Downloads\app\classes3.dex */
class mi {
    @ColorInt
    static int j(JsonReader jsonReader) throws IOException {
        jsonReader.beginArray();
        int nextDouble = (int) (jsonReader.nextDouble() * 255.0d);
        int nextDouble2 = (int) (jsonReader.nextDouble() * 255.0d);
        int nextDouble3 = (int) (jsonReader.nextDouble() * 255.0d);
        while (jsonReader.hasNext()) {
            jsonReader.skipValue();
        }
        jsonReader.endArray();
        return Color.argb(255, nextDouble, nextDouble2, nextDouble3);
    }

    static PointF xt(JsonReader jsonReader, float f6) throws IOException {
        int i6 = AnonymousClass1.f23507j[jsonReader.peek().ordinal()];
        if (i6 == 1) {
            return cw(jsonReader, f6);
        }
        if (i6 == 2) {
            return r(jsonReader, f6);
        }
        if (i6 == 3) {
            return up(jsonReader, f6);
        }
        throw new IllegalArgumentException("Unknown point starts with " + jsonReader.peek());
    }

    /* renamed from: com.bytedance.adsdk.lottie.r.mi$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: j, reason: collision with root package name */
        static final /* synthetic */ int[] f23507j;

        static {
            int[] iArr = new int[JsonToken.values().length];
            f23507j = iArr;
            try {
                iArr[JsonToken.NUMBER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f23507j[JsonToken.BEGIN_ARRAY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f23507j[JsonToken.BEGIN_OBJECT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private static PointF cw(JsonReader jsonReader, float f6) throws IOException {
        float nextDouble = (float) jsonReader.nextDouble();
        float nextDouble2 = (float) jsonReader.nextDouble();
        while (jsonReader.hasNext()) {
            jsonReader.skipValue();
        }
        return new PointF(nextDouble * f6, nextDouble2 * f6);
    }

    private static PointF r(JsonReader jsonReader, float f6) throws IOException {
        jsonReader.beginArray();
        float nextDouble = (float) jsonReader.nextDouble();
        float nextDouble2 = (float) jsonReader.nextDouble();
        while (jsonReader.peek() != JsonToken.END_ARRAY) {
            jsonReader.skipValue();
        }
        jsonReader.endArray();
        return new PointF(nextDouble * f6, nextDouble2 * f6);
    }

    private static PointF up(JsonReader jsonReader, float f6) throws IOException {
        jsonReader.beginObject();
        float f7 = 0.0f;
        float f8 = 0.0f;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.getClass();
            if (!nextName.equals("x")) {
                if (!nextName.equals("y")) {
                    jsonReader.skipValue();
                } else {
                    f8 = xt(jsonReader);
                }
            } else {
                f7 = xt(jsonReader);
            }
        }
        jsonReader.endObject();
        return new PointF(f7 * f6, f8 * f6);
    }

    static float xt(JsonReader jsonReader) throws IOException {
        JsonToken peek = jsonReader.peek();
        int i6 = AnonymousClass1.f23507j[peek.ordinal()];
        if (i6 == 1) {
            return (float) jsonReader.nextDouble();
        }
        if (i6 == 2) {
            jsonReader.beginArray();
            float nextDouble = (float) jsonReader.nextDouble();
            while (jsonReader.hasNext()) {
                jsonReader.skipValue();
            }
            jsonReader.endArray();
            return nextDouble;
        }
        throw new IllegalArgumentException("Unknown value for token of type ".concat(String.valueOf(peek)));
    }

    static List<PointF> j(JsonReader jsonReader, float f6) throws IOException {
        ArrayList arrayList = new ArrayList();
        jsonReader.beginArray();
        while (jsonReader.peek() == JsonToken.BEGIN_ARRAY) {
            jsonReader.beginArray();
            arrayList.add(xt(jsonReader, f6));
            jsonReader.endArray();
        }
        jsonReader.endArray();
        return arrayList;
    }
}
