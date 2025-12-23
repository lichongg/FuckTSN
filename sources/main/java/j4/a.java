package j4;

import kotlin.SinceKotlin;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.g0;
import kotlin.text.m;
import kotlin.text.n;
import kotlin.text.o;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@JvmName(name = "RegexExtensionsJDK8Kt")
/* loaded from: D:\Downloads\app\classes8.dex */
public final class a {
    @SinceKotlin(version = "1.2")
    @Nullable
    public static final m a(@NotNull n nVar, @NotNull String name) {
        g0.p(nVar, "<this>");
        g0.p(name, "name");
        o oVar = nVar instanceof o ? (o) nVar : null;
        if (oVar != null) {
            return oVar.get(name);
        }
        throw new UnsupportedOperationException("Retrieving groups by name is not supported on this platform.");
    }
}
