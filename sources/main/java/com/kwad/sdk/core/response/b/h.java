package com.kwad.sdk.core.response.b;

import android.graphics.Matrix;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.response.model.PhotoInfo;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class h {
    public static String a(@NonNull PhotoInfo photoInfo) {
        return photoInfo.videoInfo.videoUrl;
    }

    public static boolean a(@Nullable Matrix matrix, int i6, int i7, PhotoInfo.VideoInfo videoInfo) {
        if (matrix != null) {
            matrix.reset();
        }
        if (videoInfo == null) {
            return false;
        }
        float f6 = videoInfo.width;
        float f7 = videoInfo.height;
        if (f6 >= f7) {
            return false;
        }
        float f8 = (float) videoInfo.leftRatio;
        float f9 = (float) videoInfo.topRatio;
        float f10 = (float) videoInfo.widthRatio;
        float f11 = (float) videoInfo.heightRatio;
        float f12 = i6;
        float f13 = f12 / f6;
        float f14 = i7;
        float f15 = f14 / f7;
        float f16 = f13 / f15;
        if (Math.abs(f16 - 1.0f) < 0.01d) {
            return false;
        }
        if (f13 > f15) {
            float f17 = f15 / f13;
            float f18 = (1.0f - f17) / 2.0f;
            float f19 = (f17 + 1.0f) / 2.0f;
            if (f9 < f18 || f9 + f11 > f19) {
                return false;
            }
        } else {
            float f20 = (1.0f - f16) / 2.0f;
            float f21 = (f16 + 1.0f) / 2.0f;
            if (f8 < f20 || f8 + f10 > f21) {
                return false;
            }
            f13 = f15;
        }
        if (matrix == null) {
            return true;
        }
        matrix.preTranslate((f12 - f6) / 2.0f, (f14 - f7) / 2.0f);
        matrix.preScale(f6 / f12, f7 / f14);
        matrix.postScale(f13, f13, f12 / 2.0f, f14 / 2.0f);
        return true;
    }

    public static String b(@NonNull PhotoInfo photoInfo) {
        return photoInfo.videoInfo.manifest;
    }

    public static String c(PhotoInfo photoInfo) {
        return photoInfo.baseInfo.sdkExtraData;
    }
}
