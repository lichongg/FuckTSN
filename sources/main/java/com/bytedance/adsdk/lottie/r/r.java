package com.bytedance.adsdk.lottie.r;

import android.util.JsonReader;
import java.io.IOException;
import java.util.List;

/* loaded from: D:\Downloads\app\classes3.dex */
public class r {
    public static com.bytedance.adsdk.lottie.model.j.xt j(JsonReader jsonReader, com.bytedance.adsdk.lottie.m mVar) throws IOException {
        return j(jsonReader, mVar, true);
    }

    static com.bytedance.adsdk.lottie.model.j.j ae(JsonReader jsonReader, com.bytedance.adsdk.lottie.m mVar) throws IOException {
        return new com.bytedance.adsdk.lottie.model.j.j(j(jsonReader, mVar, ae.f23501j));
    }

    static com.bytedance.adsdk.lottie.model.j.m cw(JsonReader jsonReader, com.bytedance.adsdk.lottie.m mVar) throws IOException {
        return new com.bytedance.adsdk.lottie.model.j.m(tj.j(jsonReader, mVar, com.bytedance.adsdk.lottie.up.g.j(), l.f23506j, true));
    }

    public static com.bytedance.adsdk.lottie.model.j.xt j(JsonReader jsonReader, com.bytedance.adsdk.lottie.m mVar, boolean z5) throws IOException {
        return new com.bytedance.adsdk.lottie.model.j.xt(j(jsonReader, z5 ? com.bytedance.adsdk.lottie.up.g.j() : 1.0f, mVar, vl.f23513j));
    }

    static com.bytedance.adsdk.lottie.model.j.oq m(JsonReader jsonReader, com.bytedance.adsdk.lottie.m mVar) throws IOException {
        return new com.bytedance.adsdk.lottie.model.j.oq(j(jsonReader, com.bytedance.adsdk.lottie.up.g.j(), mVar, g.f23504j));
    }

    static com.bytedance.adsdk.lottie.model.j.ae r(JsonReader jsonReader, com.bytedance.adsdk.lottie.m mVar) throws IOException {
        return new com.bytedance.adsdk.lottie.model.j.ae(j(jsonReader, mVar, rn.f23512j));
    }

    static com.bytedance.adsdk.lottie.model.j.tl up(JsonReader jsonReader, com.bytedance.adsdk.lottie.m mVar) throws IOException {
        return new com.bytedance.adsdk.lottie.model.j.tl(j(jsonReader, com.bytedance.adsdk.lottie.up.g.j(), mVar, wq.f23515j));
    }

    static com.bytedance.adsdk.lottie.model.j.r xt(JsonReader jsonReader, com.bytedance.adsdk.lottie.m mVar) throws IOException {
        return new com.bytedance.adsdk.lottie.model.j.r(j(jsonReader, mVar, w.f23514j));
    }

    static com.bytedance.adsdk.lottie.model.j.cw j(JsonReader jsonReader, com.bytedance.adsdk.lottie.m mVar, int i6) throws IOException {
        return new com.bytedance.adsdk.lottie.model.j.cw(j(jsonReader, mVar, new az(i6)));
    }

    private static <T> List<com.bytedance.adsdk.lottie.m.j<T>> j(JsonReader jsonReader, com.bytedance.adsdk.lottie.m mVar, nd<T> ndVar) throws IOException {
        return tj.j(jsonReader, mVar, 1.0f, ndVar, false);
    }

    private static <T> List<com.bytedance.adsdk.lottie.m.j<T>> j(JsonReader jsonReader, float f6, com.bytedance.adsdk.lottie.m mVar, nd<T> ndVar) throws IOException {
        return tj.j(jsonReader, mVar, f6, ndVar, false);
    }
}
