package com.bytedance.adsdk.lottie.r;

import android.graphics.PointF;
import android.util.JsonReader;
import android.util.JsonToken;
import java.io.IOException;
import java.util.ArrayList;

/* loaded from: D:\Downloads\app\classes3.dex */
public class j {
    public static com.bytedance.adsdk.lottie.model.j.up j(JsonReader jsonReader, com.bytedance.adsdk.lottie.m mVar) throws IOException {
        ArrayList arrayList = new ArrayList();
        if (jsonReader.peek() == JsonToken.BEGIN_ARRAY) {
            jsonReader.beginArray();
            while (jsonReader.hasNext()) {
                arrayList.add(s.j(jsonReader, mVar));
            }
            jsonReader.endArray();
            tj.j(arrayList);
        } else {
            arrayList.add(new com.bytedance.adsdk.lottie.m.j(mi.xt(jsonReader, com.bytedance.adsdk.lottie.up.g.j())));
        }
        return new com.bytedance.adsdk.lottie.model.j.up(arrayList);
    }

    static com.bytedance.adsdk.lottie.model.j.jy<PointF, PointF> xt(JsonReader jsonReader, com.bytedance.adsdk.lottie.m mVar) throws IOException {
        jsonReader.beginObject();
        com.bytedance.adsdk.lottie.model.j.up upVar = null;
        com.bytedance.adsdk.lottie.model.j.xt xtVar = null;
        com.bytedance.adsdk.lottie.model.j.xt xtVar2 = null;
        boolean z5 = false;
        while (jsonReader.peek() != JsonToken.END_OBJECT) {
            String nextName = jsonReader.nextName();
            nextName.getClass();
            switch (nextName) {
                case "k":
                    upVar = j(jsonReader, mVar);
                    break;
                case "x":
                    if (jsonReader.peek() == JsonToken.STRING) {
                        z5 = true;
                        jsonReader.skipValue();
                        break;
                    } else {
                        xtVar = r.j(jsonReader, mVar);
                        break;
                    }
                case "y":
                    if (jsonReader.peek() == JsonToken.STRING) {
                        z5 = true;
                        jsonReader.skipValue();
                        break;
                    } else {
                        xtVar2 = r.j(jsonReader, mVar);
                        break;
                    }
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        if (z5) {
            mVar.j("Lottie doesn't support expressions.");
        }
        if (upVar != null) {
            return upVar;
        }
        return new com.bytedance.adsdk.lottie.model.j.g(xtVar, xtVar2);
    }
}
