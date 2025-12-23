package com.bytedance.adsdk.lottie.r;

import android.util.JsonReader;
import com.amap.api.col.p0003l.ef;
import java.io.IOException;

/* loaded from: D:\Downloads\app\classes3.dex */
public class qv {
    private com.bytedance.adsdk.lottie.model.j.xt cw;

    /* renamed from: j, reason: collision with root package name */
    private com.bytedance.adsdk.lottie.model.j.j f23510j;

    /* renamed from: r, reason: collision with root package name */
    private com.bytedance.adsdk.lottie.model.j.xt f23511r;
    private com.bytedance.adsdk.lottie.model.j.xt up;
    private com.bytedance.adsdk.lottie.model.j.xt xt;

    private void xt(JsonReader jsonReader, com.bytedance.adsdk.lottie.m mVar) throws IOException {
        jsonReader.beginObject();
        String str = "";
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.getClass();
            if (!nextName.equals("v")) {
                if (!nextName.equals("nm")) {
                    jsonReader.skipValue();
                } else {
                    str = jsonReader.nextString();
                }
            } else {
                str.getClass();
                switch (str) {
                    case "Distance":
                        this.f23511r = r.j(jsonReader, mVar);
                        break;
                    case "Opacity":
                        this.xt = r.j(jsonReader, mVar, false);
                        break;
                    case "Direction":
                        this.cw = r.j(jsonReader, mVar, false);
                        break;
                    case "Shadow Color":
                        this.f23510j = r.ae(jsonReader, mVar);
                        break;
                    case "Softness":
                        this.up = r.j(jsonReader, mVar);
                        break;
                    default:
                        jsonReader.skipValue();
                        break;
                }
            }
        }
        jsonReader.endObject();
    }

    oq j(JsonReader jsonReader, com.bytedance.adsdk.lottie.m mVar) throws IOException {
        com.bytedance.adsdk.lottie.model.j.xt xtVar;
        com.bytedance.adsdk.lottie.model.j.xt xtVar2;
        com.bytedance.adsdk.lottie.model.j.xt xtVar3;
        com.bytedance.adsdk.lottie.model.j.xt xtVar4;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.getClass();
            if (!nextName.equals(ef.f6043r)) {
                jsonReader.skipValue();
            } else {
                jsonReader.beginArray();
                while (jsonReader.hasNext()) {
                    xt(jsonReader, mVar);
                }
                jsonReader.endArray();
            }
        }
        com.bytedance.adsdk.lottie.model.j.j jVar = this.f23510j;
        if (jVar != null && (xtVar = this.xt) != null && (xtVar2 = this.cw) != null && (xtVar3 = this.f23511r) != null && (xtVar4 = this.up) != null) {
            return new oq(jVar, xtVar, xtVar2, xtVar3, xtVar4);
        }
        return null;
    }
}
