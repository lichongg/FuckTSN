package com.bytedance.adsdk.lottie.r;

import android.graphics.Path;
import android.util.JsonReader;
import java.io.IOException;
import java.util.Collections;

/* loaded from: D:\Downloads\app\classes3.dex */
class uf {
    static com.bytedance.adsdk.lottie.model.xt.az j(JsonReader jsonReader, com.bytedance.adsdk.lottie.m mVar) throws IOException {
        com.bytedance.adsdk.lottie.model.j.r rVar = null;
        String str = null;
        com.bytedance.adsdk.lottie.model.j.j jVar = null;
        int i6 = 1;
        boolean z5 = false;
        boolean z6 = false;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.getClass();
            switch (nextName) {
                case "fillEnabled":
                    z5 = jsonReader.nextBoolean();
                    break;
                case "c":
                    jVar = r.ae(jsonReader, mVar);
                    break;
                case "o":
                    rVar = r.xt(jsonReader, mVar);
                    break;
                case "r":
                    i6 = jsonReader.nextInt();
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
        if (rVar == null) {
            rVar = new com.bytedance.adsdk.lottie.model.j.r(Collections.singletonList(new com.bytedance.adsdk.lottie.m.j(100)));
        }
        return new com.bytedance.adsdk.lottie.model.xt.az(str, z5, i6 == 1 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD, jVar, rVar, z6);
    }
}
