package com.bytedance.adsdk.lottie.r;

import android.util.JsonReader;
import java.io.IOException;

/* loaded from: D:\Downloads\app\classes3.dex */
public class vl implements nd<Float> {

    /* renamed from: j, reason: collision with root package name */
    public static final vl f23513j = new vl();

    private vl() {
    }

    @Override // com.bytedance.adsdk.lottie.r.nd
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public Float xt(JsonReader jsonReader, float f6) throws IOException {
        return Float.valueOf(mi.xt(jsonReader) * f6);
    }
}
