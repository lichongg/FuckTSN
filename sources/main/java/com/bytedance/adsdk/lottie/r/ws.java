package com.bytedance.adsdk.lottie.r;

import android.util.JsonReader;
import java.io.IOException;

/* loaded from: D:\Downloads\app\classes3.dex */
class ws {
    static com.bytedance.adsdk.lottie.model.cw j(JsonReader jsonReader) throws IOException {
        jsonReader.beginObject();
        String str = null;
        String str2 = null;
        String str3 = null;
        float f6 = 0.0f;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.getClass();
            switch (nextName) {
                case "fFamily":
                    str = jsonReader.nextString();
                    break;
                case "ascent":
                    f6 = (float) jsonReader.nextDouble();
                    break;
                case "fStyle":
                    str3 = jsonReader.nextString();
                    break;
                case "fName":
                    str2 = jsonReader.nextString();
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return new com.bytedance.adsdk.lottie.model.cw(str, str2, str3, f6);
    }
}
