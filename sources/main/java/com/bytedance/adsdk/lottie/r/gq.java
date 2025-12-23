package com.bytedance.adsdk.lottie.r;

import android.util.JsonReader;
import java.io.IOException;

/* loaded from: D:\Downloads\app\classes3.dex */
public class gq {
    static com.bytedance.adsdk.lottie.model.xt.jy j(JsonReader jsonReader, com.bytedance.adsdk.lottie.m mVar) throws IOException {
        String str = null;
        com.bytedance.adsdk.lottie.model.j.xt xtVar = null;
        boolean z5 = false;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.getClass();
            switch (nextName) {
                case "r":
                    xtVar = r.j(jsonReader, mVar, true);
                    break;
                case "hd":
                    z5 = jsonReader.nextBoolean();
                    break;
                case "nm":
                    str = jsonReader.nextString();
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        if (z5) {
            return null;
        }
        return new com.bytedance.adsdk.lottie.model.xt.jy(str, xtVar);
    }
}
