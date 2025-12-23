package com.bytedance.adsdk.lottie.r;

import android.util.JsonReader;
import java.io.IOException;

/* loaded from: D:\Downloads\app\classes3.dex */
public class w implements nd<Integer> {

    /* renamed from: j, reason: collision with root package name */
    public static final w f23514j = new w();

    private w() {
    }

    @Override // com.bytedance.adsdk.lottie.r.nd
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public Integer xt(JsonReader jsonReader, float f6) throws IOException {
        return Integer.valueOf(Math.round(mi.xt(jsonReader) * f6));
    }
}
