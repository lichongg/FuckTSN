package kotlin.reflect.full;

import kotlin.SinceKotlin;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.g0;
import kotlin.reflect.jvm.internal.z2;
import kotlin.reflect.r;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@JvmName(name = "KTypes")
/* loaded from: D:\Downloads\app\classes8.dex */
public final class k {
    @SinceKotlin(version = "1.1")
    public static final boolean a(@NotNull r rVar, @NotNull r other) {
        g0.p(rVar, "<this>");
        g0.p(other, "other");
        return kotlin.reflect.jvm.internal.impl.types.typeUtil.e.x(((z2) rVar).getType(), ((z2) other).getType());
    }

    @SinceKotlin(version = "1.1")
    public static final boolean b(@NotNull r rVar, @NotNull r other) {
        g0.p(rVar, "<this>");
        g0.p(other, "other");
        return a(other, rVar);
    }

    @SinceKotlin(version = "1.1")
    @NotNull
    public static final r c(@NotNull r rVar, boolean z5) {
        g0.p(rVar, "<this>");
        return ((z2) rVar).F(z5);
    }
}
