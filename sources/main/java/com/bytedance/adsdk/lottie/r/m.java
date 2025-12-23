package com.bytedance.adsdk.lottie.r;

import android.graphics.PointF;
import android.util.JsonReader;
import java.io.IOException;

/* loaded from: D:\Downloads\app\classes3.dex */
class m {
    static com.bytedance.adsdk.lottie.model.xt.xt j(JsonReader jsonReader, com.bytedance.adsdk.lottie.m mVar, int i6) throws IOException {
        boolean z5 = i6 == 3;
        String str = null;
        com.bytedance.adsdk.lottie.model.j.jy<PointF, PointF> jyVar = null;
        com.bytedance.adsdk.lottie.model.j.m mVar2 = null;
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
                case "s":
                    mVar2 = r.cw(jsonReader, mVar);
                    break;
                case "hd":
                    z6 = jsonReader.nextBoolean();
                    break;
                case "nm":
                    str = jsonReader.nextString();
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        return new com.bytedance.adsdk.lottie.model.xt.xt(str, jyVar, mVar2, z5, z6);
    }
}
