package com.bytedance.adsdk.lottie.r;

import android.util.JsonReader;
import com.bytedance.adsdk.lottie.model.xt.mi;
import java.io.IOException;

/* loaded from: D:\Downloads\app\classes3.dex */
class n {
    static com.bytedance.adsdk.lottie.model.xt.mi j(JsonReader jsonReader, com.bytedance.adsdk.lottie.m mVar) throws IOException {
        String str = null;
        mi.j jVar = null;
        com.bytedance.adsdk.lottie.model.j.xt xtVar = null;
        com.bytedance.adsdk.lottie.model.j.xt xtVar2 = null;
        com.bytedance.adsdk.lottie.model.j.xt xtVar3 = null;
        boolean z5 = false;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.getClass();
            switch (nextName) {
                case "e":
                    xtVar2 = r.j(jsonReader, mVar, false);
                    break;
                case "m":
                    jVar = mi.j.j(jsonReader.nextInt());
                    break;
                case "o":
                    xtVar3 = r.j(jsonReader, mVar, false);
                    break;
                case "s":
                    xtVar = r.j(jsonReader, mVar, false);
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
        return new com.bytedance.adsdk.lottie.model.xt.mi(str, jVar, xtVar, xtVar2, xtVar3, z5);
    }
}
