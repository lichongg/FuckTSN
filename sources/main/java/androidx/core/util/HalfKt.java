package androidx.core.util;

import android.annotation.SuppressLint;
import android.util.Half;
import androidx.annotation.RequiresApi;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SuppressLint({"ClassVerificationFailure"})
@SourceDebugExtension({"SMAP\nHalf.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Half.kt\nandroidx/core/util/HalfKt\n*L\n1#1,60:1\n43#1:61\n*S KotlinDebug\n*F\n+ 1 Half.kt\nandroidx/core/util/HalfKt\n*L\n51#1:61\n*E\n"})
/* loaded from: D:\Downloads\app\classes.dex */
public final class HalfKt {
    @RequiresApi(26)
    @NotNull
    public static final Half toHalf(short s5) {
        Half valueOf;
        valueOf = Half.valueOf(s5);
        return valueOf;
    }

    @RequiresApi(26)
    @NotNull
    public static final Half toHalf(float f6) {
        Half valueOf;
        valueOf = Half.valueOf(f6);
        return valueOf;
    }

    @RequiresApi(26)
    @NotNull
    public static final Half toHalf(@NotNull String str) {
        Half valueOf;
        valueOf = Half.valueOf(str);
        return valueOf;
    }

    @RequiresApi(26)
    @NotNull
    public static final Half toHalf(double d6) {
        Half valueOf;
        valueOf = Half.valueOf((float) d6);
        return valueOf;
    }
}
