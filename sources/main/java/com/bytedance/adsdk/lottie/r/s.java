package com.bytedance.adsdk.lottie.r;

import android.util.JsonReader;
import android.util.JsonToken;
import java.io.IOException;

/* loaded from: D:\Downloads\app\classes3.dex */
class s {
    static com.bytedance.adsdk.lottie.j.xt.g j(JsonReader jsonReader, com.bytedance.adsdk.lottie.m mVar) throws IOException {
        boolean z5;
        if (jsonReader.peek() == JsonToken.BEGIN_OBJECT) {
            z5 = true;
        } else {
            z5 = false;
        }
        return new com.bytedance.adsdk.lottie.j.xt.g(mVar, kt.j(jsonReader, mVar, com.bytedance.adsdk.lottie.up.g.j(), a.f23500j, z5, false));
    }
}
