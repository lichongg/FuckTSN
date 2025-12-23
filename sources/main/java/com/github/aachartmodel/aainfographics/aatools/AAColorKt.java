package com.github.aachartmodel.aainfographics.aatools;

import io.netty.util.internal.StringUtil;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public final class AAColorKt {
    @NotNull
    public static final String AARgb(int i6, int i7, int i8, float f6) {
        return AARgba(i6, i7, i8, 1.0f);
    }

    public static /* synthetic */ String AARgb$default(int i6, int i7, int i8, float f6, int i9, Object obj) {
        if ((i9 & 8) != 0) {
            f6 = 1.0f;
        }
        return AARgb(i6, i7, i8, f6);
    }

    @NotNull
    public static final String AARgba(int i6, int i7, int i8, float f6) {
        return "rgba(" + i6 + StringUtil.COMMA + i7 + StringUtil.COMMA + i8 + StringUtil.COMMA + f6 + ')';
    }

    public static /* synthetic */ String AARgba$default(int i6, int i7, int i8, float f6, int i9, Object obj) {
        if ((i9 & 8) != 0) {
            f6 = 1.0f;
        }
        return AARgba(i6, i7, i8, f6);
    }
}
