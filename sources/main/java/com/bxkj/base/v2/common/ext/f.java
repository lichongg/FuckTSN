package com.bxkj.base.v2.common.ext;

import java.io.File;
import kotlin.jvm.internal.g0;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class f {
    @NotNull
    public static final MultipartBody.Part a(@NotNull File file, @Nullable String str, @Nullable String str2) {
        g0.p(file, "<this>");
        RequestBody create = RequestBody.Companion.create(file, str2 != null ? MediaType.Companion.parse(str2) : null);
        MultipartBody.Part.Companion companion = MultipartBody.Part.Companion;
        if (str == null) {
            str = master.flame.danmaku.danmaku.parser.b.f50156c;
        }
        return companion.createFormData(str, file.getName(), create);
    }

    public static /* synthetic */ MultipartBody.Part b(File file, String str, String str2, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            str = master.flame.danmaku.danmaku.parser.b.f50156c;
        }
        if ((i6 & 2) != 0) {
            str2 = "image/jpg";
        }
        return a(file, str, str2);
    }
}
