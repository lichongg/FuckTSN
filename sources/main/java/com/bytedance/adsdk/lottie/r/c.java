package com.bytedance.adsdk.lottie.r;

import android.util.JsonReader;
import java.io.IOException;

/* loaded from: D:\Downloads\app\classes3.dex */
class c {
    static com.bytedance.adsdk.lottie.model.xt.i j(JsonReader jsonReader, com.bytedance.adsdk.lottie.m mVar) throws IOException {
        String str = null;
        com.bytedance.adsdk.lottie.model.j.tl tlVar = null;
        int i6 = 0;
        boolean z5 = false;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.getClass();
            switch (nextName) {
                case "hd":
                    z5 = jsonReader.nextBoolean();
                    break;
                case "ks":
                    tlVar = r.up(jsonReader, mVar);
                    break;
                case "nm":
                    str = jsonReader.nextString();
                    break;
                case "ind":
                    i6 = jsonReader.nextInt();
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        return new com.bytedance.adsdk.lottie.model.xt.i(str, i6, tlVar, z5);
    }
}
