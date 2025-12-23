package com.bytedance.adsdk.lottie.r;

import android.util.JsonReader;
import android.util.JsonToken;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\Downloads\app\classes3.dex */
class tj {
    static <T> List<com.bytedance.adsdk.lottie.m.j<T>> j(JsonReader jsonReader, com.bytedance.adsdk.lottie.m mVar, float f6, nd<T> ndVar, boolean z5) throws IOException {
        JsonReader jsonReader2;
        com.bytedance.adsdk.lottie.m mVar2;
        float f7;
        nd<T> ndVar2;
        boolean z6;
        ArrayList arrayList = new ArrayList();
        if (jsonReader.peek() == JsonToken.STRING) {
            mVar.j("Lottie doesn't support expressions.");
            return arrayList;
        }
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.getClass();
            if (!nextName.equals("k")) {
                jsonReader.skipValue();
            } else if (jsonReader.peek() == JsonToken.BEGIN_ARRAY) {
                jsonReader.beginArray();
                if (jsonReader.peek() == JsonToken.NUMBER) {
                    JsonReader jsonReader3 = jsonReader;
                    com.bytedance.adsdk.lottie.m mVar3 = mVar;
                    float f8 = f6;
                    nd<T> ndVar3 = ndVar;
                    boolean z7 = z5;
                    com.bytedance.adsdk.lottie.m.j j6 = kt.j(jsonReader3, mVar3, f8, ndVar3, false, z7);
                    jsonReader2 = jsonReader3;
                    mVar2 = mVar3;
                    f7 = f8;
                    ndVar2 = ndVar3;
                    z6 = z7;
                    arrayList.add(j6);
                } else {
                    jsonReader2 = jsonReader;
                    mVar2 = mVar;
                    f7 = f6;
                    ndVar2 = ndVar;
                    z6 = z5;
                    while (jsonReader2.hasNext()) {
                        arrayList.add(kt.j(jsonReader2, mVar2, f7, ndVar2, true, z6));
                    }
                }
                jsonReader2.endArray();
                jsonReader = jsonReader2;
                mVar = mVar2;
                f6 = f7;
                ndVar = ndVar2;
                z5 = z6;
            } else {
                JsonReader jsonReader4 = jsonReader;
                arrayList.add(kt.j(jsonReader4, mVar, f6, ndVar, false, z5));
                jsonReader = jsonReader4;
            }
        }
        jsonReader.endObject();
        j(arrayList);
        return arrayList;
    }

    public static <T> void j(List<? extends com.bytedance.adsdk.lottie.m.j<T>> list) {
        int i6;
        T t5;
        int size = list.size();
        int i7 = 0;
        while (true) {
            i6 = size - 1;
            if (i7 >= i6) {
                break;
            }
            com.bytedance.adsdk.lottie.m.j<T> jVar = list.get(i7);
            i7++;
            com.bytedance.adsdk.lottie.m.j<T> jVar2 = list.get(i7);
            jVar.ae = Float.valueOf(jVar2.f23338m);
            if (jVar.xt == null && (t5 = jVar2.f23337j) != null) {
                jVar.xt = t5;
                if (jVar instanceof com.bytedance.adsdk.lottie.j.xt.g) {
                    ((com.bytedance.adsdk.lottie.j.xt.g) jVar).j();
                }
            }
        }
        com.bytedance.adsdk.lottie.m.j<T> jVar3 = list.get(i6);
        if ((jVar3.f23337j == null || jVar3.xt == null) && list.size() > 1) {
            list.remove(jVar3);
        }
    }
}
