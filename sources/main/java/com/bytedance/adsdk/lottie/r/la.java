package com.bytedance.adsdk.lottie.r;

import android.util.JsonReader;
import java.io.IOException;

/* loaded from: D:\Downloads\app\classes3.dex */
class la {
    static com.bytedance.adsdk.lottie.model.xt.vl j(JsonReader jsonReader, com.bytedance.adsdk.lottie.m mVar) throws IOException {
        String str = null;
        com.bytedance.adsdk.lottie.model.j.xt xtVar = null;
        com.bytedance.adsdk.lottie.model.j.xt xtVar2 = null;
        com.bytedance.adsdk.lottie.model.j.vl vlVar = null;
        boolean z5 = false;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.getClass();
            switch (nextName) {
                case "c":
                    xtVar = r.j(jsonReader, mVar, false);
                    break;
                case "o":
                    xtVar2 = r.j(jsonReader, mVar, false);
                    break;
                case "hd":
                    z5 = jsonReader.nextBoolean();
                    break;
                case "nm":
                    str = jsonReader.nextString();
                    break;
                case "tr":
                    vlVar = cw.j(jsonReader, mVar);
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        return new com.bytedance.adsdk.lottie.model.xt.vl(str, xtVar, xtVar2, vlVar, z5);
    }
}
