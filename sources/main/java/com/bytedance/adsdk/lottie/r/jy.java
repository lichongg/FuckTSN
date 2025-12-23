package com.bytedance.adsdk.lottie.r;

import android.util.JsonReader;
import java.io.IOException;
import java.util.ArrayList;

/* loaded from: D:\Downloads\app\classes3.dex */
class jy {
    static com.bytedance.adsdk.lottie.model.r j(JsonReader jsonReader, com.bytedance.adsdk.lottie.m mVar) throws IOException {
        ArrayList arrayList = new ArrayList();
        jsonReader.beginObject();
        double d6 = 0.0d;
        String str = null;
        String str2 = null;
        double d7 = 0.0d;
        char c6 = 0;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.getClass();
            switch (nextName) {
                case "fFamily":
                    str2 = jsonReader.nextString();
                    break;
                case "w":
                    d6 = jsonReader.nextDouble();
                    break;
                case "ch":
                    c6 = jsonReader.nextString().charAt(0);
                    break;
                case "data":
                    jsonReader.beginObject();
                    while (jsonReader.hasNext()) {
                        if ("shapes".equals(jsonReader.nextName())) {
                            jsonReader.beginArray();
                            while (jsonReader.hasNext()) {
                                arrayList.add((com.bytedance.adsdk.lottie.model.xt.av) tl.j(jsonReader, mVar));
                            }
                            jsonReader.endArray();
                        } else {
                            jsonReader.skipValue();
                        }
                    }
                    jsonReader.endObject();
                    break;
                case "size":
                    d7 = jsonReader.nextDouble();
                    break;
                case "style":
                    str = jsonReader.nextString();
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return new com.bytedance.adsdk.lottie.model.r(arrayList, c6, d7, d6, str, str2);
    }
}
