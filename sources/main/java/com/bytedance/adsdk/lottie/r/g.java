package com.bytedance.adsdk.lottie.r;

import android.graphics.PointF;
import android.util.JsonReader;
import com.bytedance.adsdk.lottie.model.xt;
import java.io.IOException;

/* loaded from: D:\Downloads\app\classes3.dex */
public class g implements nd<com.bytedance.adsdk.lottie.model.xt> {

    /* renamed from: j, reason: collision with root package name */
    public static final g f23504j = new g();

    @Override // com.bytedance.adsdk.lottie.r.nd
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public com.bytedance.adsdk.lottie.model.xt xt(JsonReader jsonReader, float f6) throws IOException {
        xt.j jVar = xt.j.CENTER;
        jsonReader.beginObject();
        xt.j jVar2 = jVar;
        String str = null;
        String str2 = null;
        PointF pointF = null;
        PointF pointF2 = null;
        float f7 = 0.0f;
        int i6 = 0;
        float f8 = 0.0f;
        float f9 = 0.0f;
        int i7 = 0;
        int i8 = 0;
        float f10 = 0.0f;
        boolean z5 = true;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.getClass();
            switch (nextName) {
                case "f":
                    str2 = jsonReader.nextString();
                    break;
                case "j":
                    int nextInt = jsonReader.nextInt();
                    jVar2 = xt.j.CENTER;
                    if (nextInt <= jVar2.ordinal() && nextInt >= 0) {
                        jVar2 = xt.j.values()[nextInt];
                        break;
                    }
                    break;
                case "s":
                    f7 = (float) jsonReader.nextDouble();
                    break;
                case "t":
                    str = jsonReader.nextString();
                    break;
                case "fc":
                    i7 = mi.j(jsonReader);
                    break;
                case "lh":
                    f8 = (float) jsonReader.nextDouble();
                    break;
                case "ls":
                    f9 = (float) jsonReader.nextDouble();
                    break;
                case "of":
                    z5 = jsonReader.nextBoolean();
                    break;
                case "ps":
                    jsonReader.beginArray();
                    PointF pointF3 = new PointF(((float) jsonReader.nextDouble()) * f6, ((float) jsonReader.nextDouble()) * f6);
                    jsonReader.endArray();
                    pointF = pointF3;
                    break;
                case "sc":
                    i8 = mi.j(jsonReader);
                    break;
                case "sw":
                    f10 = (float) jsonReader.nextDouble();
                    break;
                case "sz":
                    jsonReader.beginArray();
                    PointF pointF4 = new PointF(((float) jsonReader.nextDouble()) * f6, ((float) jsonReader.nextDouble()) * f6);
                    jsonReader.endArray();
                    pointF2 = pointF4;
                    break;
                case "tr":
                    i6 = jsonReader.nextInt();
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return new com.bytedance.adsdk.lottie.model.xt(str, str2, f7, jVar2, i6, f8, f9, i7, i8, f10, z5, pointF, pointF2);
    }

    private g() {
    }
}
