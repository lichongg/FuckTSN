package com.bytedance.adsdk.lottie.r;

import android.graphics.PointF;
import android.util.JsonReader;
import java.io.IOException;

/* loaded from: D:\Downloads\app\classes3.dex */
class h {
    static com.bytedance.adsdk.lottie.model.xt.qv j(JsonReader jsonReader, com.bytedance.adsdk.lottie.m mVar) throws IOException {
        String str = null;
        com.bytedance.adsdk.lottie.model.j.jy<PointF, PointF> jyVar = null;
        com.bytedance.adsdk.lottie.model.j.m mVar2 = null;
        com.bytedance.adsdk.lottie.model.j.xt xtVar = null;
        boolean z5 = false;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.getClass();
            switch (nextName) {
                case "p":
                    jyVar = j.xt(jsonReader, mVar);
                    break;
                case "r":
                    xtVar = r.j(jsonReader, mVar);
                    break;
                case "s":
                    mVar2 = r.cw(jsonReader, mVar);
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
        return new com.bytedance.adsdk.lottie.model.xt.qv(str, jyVar, mVar2, xtVar, z5);
    }
}
