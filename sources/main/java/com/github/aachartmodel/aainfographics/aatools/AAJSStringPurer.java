package com.github.aachartmodel.aainfographics.aatools;

import com.snail.antifake.deviceid.e;
import kotlin.jvm.internal.g0;
import kotlin.text.u;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public final class AAJSStringPurer {
    public static final AAJSStringPurer INSTANCE = new AAJSStringPurer();

    @Nullable
    public final String pureAnonymousJSFunctionString(@Nullable String str) {
        return pureJavaScriptFunctionString('(' + str + ')');
    }

    @NotNull
    public final String pureJavaScriptFunctionString(@NotNull String JSStr) {
        g0.p(JSStr, "JSStr");
        return u.x2(u.x2(u.x2(u.x2(u.x2(u.x2(u.x2(u.x2(u.x2(u.x2(JSStr, "'", "\"", false, 4, null), "\u0000", "", false, 4, null), e.f37542d, "", false, 4, null), "\\", "\\\\", false, 4, null), "\"", "\\\"", false, 4, null), "'", "\\'", false, 4, null), e.f37542d, "\\n", false, 4, null), "\r", "\\r", false, 4, null), "\u2028", "\\u2028", false, 4, null), "\u2029", "\\u2029", false, 4, null);
    }

    private AAJSStringPurer() {
    }
}
