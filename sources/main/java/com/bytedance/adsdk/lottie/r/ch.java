package com.bytedance.adsdk.lottie.r;

import android.util.JsonReader;
import com.bytedance.adsdk.lottie.model.xt.g;
import java.io.IOException;

/* loaded from: D:\Downloads\app\classes3.dex */
class ch {
    static com.bytedance.adsdk.lottie.model.xt.g j(JsonReader jsonReader) throws IOException {
        String str = null;
        g.j jVar = null;
        boolean z5 = false;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.getClass();
            switch (nextName) {
                case "hd":
                    z5 = jsonReader.nextBoolean();
                    break;
                case "mm":
                    jVar = g.j.j(jsonReader.nextInt());
                    break;
                case "nm":
                    str = jsonReader.nextString();
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        return new com.bytedance.adsdk.lottie.model.xt.g(str, jVar, z5);
    }
}
