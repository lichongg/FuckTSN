package com.bytedance.adsdk.lottie.r;

import android.util.JsonReader;
import java.io.IOException;
import java.util.ArrayList;

/* loaded from: D:\Downloads\app\classes3.dex */
class ed {
    static com.bytedance.adsdk.lottie.model.xt.av j(JsonReader jsonReader, com.bytedance.adsdk.lottie.m mVar) throws IOException {
        ArrayList arrayList = new ArrayList();
        String str = null;
        boolean z5 = false;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.getClass();
            switch (nextName) {
                case "hd":
                    z5 = jsonReader.nextBoolean();
                    break;
                case "it":
                    jsonReader.beginArray();
                    while (jsonReader.hasNext()) {
                        com.bytedance.adsdk.lottie.model.xt.cw j6 = tl.j(jsonReader, mVar);
                        if (j6 != null) {
                            arrayList.add(j6);
                        }
                    }
                    jsonReader.endArray();
                    break;
                case "nm":
                    str = jsonReader.nextString();
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        return new com.bytedance.adsdk.lottie.model.xt.av(str, arrayList, z5);
    }
}
