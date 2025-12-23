package kotlin.reflect;

import com.daimajia.numberprogressbar.BuildConfig;
import kotlin.SinceKotlin;
import kotlin.internal.LowPriorityInOverloadResolution;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@JvmName(name = "KClasses")
@SourceDebugExtension({"SMAP\nKClasses.kt\nKotlin\n*S Kotlin\n*F\n+ 1 KClasses.kt\nkotlin/reflect/KClasses\n+ 2 KClassesImpl.kt\nkotlin/reflect/KClassesImplKt\n*L\n1#1,46:1\n9#2:47\n*S KotlinDebug\n*F\n+ 1 KClasses.kt\nkotlin/reflect/KClasses\n*L\n25#1:47\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class e {
    /* JADX WARN: Multi-variable type inference failed */
    @LowPriorityInOverloadResolution
    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @NotNull
    public static final <T> T a(@NotNull d<T> dVar, @Nullable Object obj) {
        g0.p(dVar, "<this>");
        if (dVar.C(obj)) {
            g0.n(obj, "null cannot be cast to non-null type T of kotlin.reflect.KClasses.cast");
            return obj;
        }
        throw new ClassCastException("Value cannot be cast to " + dVar.x());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @LowPriorityInOverloadResolution
    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @Nullable
    public static final <T> T b(@NotNull d<T> dVar, @Nullable Object obj) {
        g0.p(dVar, "<this>");
        if (!dVar.C(obj)) {
            return null;
        }
        g0.n(obj, "null cannot be cast to non-null type T of kotlin.reflect.KClasses.safeCast");
        return obj;
    }
}
