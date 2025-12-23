package com.bytedance.adsdk.lottie.r;

import android.util.JsonReader;
import java.io.IOException;

/* loaded from: D:\Downloads\app\classes3.dex */
public class xt {
    public static com.bytedance.adsdk.lottie.model.j.qv j(JsonReader jsonReader, com.bytedance.adsdk.lottie.m mVar) throws IOException {
        jsonReader.beginObject();
        com.bytedance.adsdk.lottie.model.j.qv qvVar = null;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.getClass();
            if (!nextName.equals("a")) {
                jsonReader.skipValue();
            } else {
                qvVar = xt(jsonReader, mVar);
            }
        }
        jsonReader.endObject();
        if (qvVar == null) {
            return new com.bytedance.adsdk.lottie.model.j.qv(null, null, null, null);
        }
        return qvVar;
    }

    private static com.bytedance.adsdk.lottie.model.j.qv xt(JsonReader jsonReader, com.bytedance.adsdk.lottie.m mVar) throws IOException {
        jsonReader.beginObject();
        com.bytedance.adsdk.lottie.model.j.j jVar = null;
        com.bytedance.adsdk.lottie.model.j.j jVar2 = null;
        com.bytedance.adsdk.lottie.model.j.xt xtVar = null;
        com.bytedance.adsdk.lottie.model.j.xt xtVar2 = null;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.getClass();
            switch (nextName) {
                case "t":
                    xtVar2 = r.j(jsonReader, mVar);
                    break;
                case "fc":
                    jVar = r.ae(jsonReader, mVar);
                    break;
                case "sc":
                    jVar2 = r.ae(jsonReader, mVar);
                    break;
                case "sw":
                    xtVar = r.j(jsonReader, mVar);
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return new com.bytedance.adsdk.lottie.model.j.qv(jVar, jVar2, xtVar, xtVar2);
    }
}
