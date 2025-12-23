package com.bytedance.adsdk.lottie.r;

import android.graphics.PointF;
import android.util.JsonReader;
import com.bytedance.adsdk.lottie.model.xt.oq;
import java.io.IOException;

/* loaded from: D:\Downloads\app\classes3.dex */
class p {
    static com.bytedance.adsdk.lottie.model.xt.oq j(JsonReader jsonReader, com.bytedance.adsdk.lottie.m mVar, int i6) throws IOException {
        boolean z5 = i6 == 3;
        String str = null;
        oq.j jVar = null;
        com.bytedance.adsdk.lottie.model.j.xt xtVar = null;
        com.bytedance.adsdk.lottie.model.j.jy<PointF, PointF> jyVar = null;
        com.bytedance.adsdk.lottie.model.j.xt xtVar2 = null;
        com.bytedance.adsdk.lottie.model.j.xt xtVar3 = null;
        com.bytedance.adsdk.lottie.model.j.xt xtVar4 = null;
        com.bytedance.adsdk.lottie.model.j.xt xtVar5 = null;
        com.bytedance.adsdk.lottie.model.j.xt xtVar6 = null;
        boolean z6 = false;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.getClass();
            switch (nextName) {
                case "d":
                    if (jsonReader.nextInt() != 3) {
                        z5 = false;
                        break;
                    } else {
                        z5 = true;
                        break;
                    }
                case "p":
                    jyVar = j.xt(jsonReader, mVar);
                    break;
                case "r":
                    xtVar2 = r.j(jsonReader, mVar, false);
                    break;
                case "hd":
                    z6 = jsonReader.nextBoolean();
                    break;
                case "ir":
                    xtVar3 = r.j(jsonReader, mVar);
                    break;
                case "is":
                    xtVar5 = r.j(jsonReader, mVar, false);
                    break;
                case "nm":
                    str = jsonReader.nextString();
                    break;
                case "or":
                    xtVar4 = r.j(jsonReader, mVar);
                    break;
                case "os":
                    xtVar6 = r.j(jsonReader, mVar, false);
                    break;
                case "pt":
                    xtVar = r.j(jsonReader, mVar, false);
                    break;
                case "sy":
                    jVar = oq.j.j(jsonReader.nextInt());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        return new com.bytedance.adsdk.lottie.model.xt.oq(str, jVar, xtVar, jyVar, xtVar2, xtVar3, xtVar4, xtVar5, xtVar6, z6, z5);
    }
}
