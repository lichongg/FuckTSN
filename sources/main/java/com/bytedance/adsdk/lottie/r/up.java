package com.bytedance.adsdk.lottie.r;

import android.util.JsonReader;
import com.amap.api.col.p0003l.ef;
import java.io.IOException;

/* loaded from: D:\Downloads\app\classes3.dex */
class up {
    static com.bytedance.adsdk.lottie.model.xt.j j(JsonReader jsonReader, com.bytedance.adsdk.lottie.m mVar) throws IOException {
        com.bytedance.adsdk.lottie.model.xt.j jVar = null;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.getClass();
            if (nextName.equals(ef.f6043r)) {
                jsonReader.beginArray();
                while (jsonReader.hasNext()) {
                    com.bytedance.adsdk.lottie.model.xt.j xt = xt(jsonReader, mVar);
                    if (xt != null) {
                        jVar = xt;
                    }
                }
                jsonReader.endArray();
            } else {
                jsonReader.skipValue();
            }
        }
        return jVar;
    }

    private static com.bytedance.adsdk.lottie.model.xt.j xt(JsonReader jsonReader, com.bytedance.adsdk.lottie.m mVar) throws IOException {
        jsonReader.beginObject();
        com.bytedance.adsdk.lottie.model.xt.j jVar = null;
        while (true) {
            boolean z5 = false;
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                nextName.getClass();
                if (!nextName.equals("v")) {
                    if (!nextName.equals("ty")) {
                        jsonReader.skipValue();
                    } else if (jsonReader.nextInt() == 0) {
                        z5 = true;
                    }
                } else if (z5) {
                    jVar = new com.bytedance.adsdk.lottie.model.xt.j(r.j(jsonReader, mVar));
                } else {
                    jsonReader.skipValue();
                }
            }
            jsonReader.endObject();
            return jVar;
        }
    }
}
