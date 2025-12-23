package i3;

import kotlin.SinceKotlin;
import kotlin.contracts.ExperimentalContracts;
import kotlin.contracts.ExperimentalExtendedContracts;
import kotlin.contracts.InvocationKind;
import kotlin.internal.ContractsDsl;
import kotlin.n;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SinceKotlin(version = "1.3")
@ContractsDsl
@ExperimentalContracts
/* loaded from: D:\Downloads\app\classes7.dex */
public interface c {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a {
        public static /* synthetic */ i3.a a(c cVar, n nVar, InvocationKind invocationKind, int i6, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: callsInPlace");
            }
            if ((i6 & 2) != 0) {
                invocationKind = InvocationKind.UNKNOWN;
            }
            return cVar.e(nVar, invocationKind);
        }
    }

    @ExperimentalExtendedContracts
    @ContractsDsl
    @NotNull
    <R> f a(boolean z5, @NotNull n<? extends R> nVar);

    @ContractsDsl
    @NotNull
    g b();

    @ContractsDsl
    @NotNull
    g c(@Nullable Object obj);

    @ContractsDsl
    @NotNull
    h d();

    @ContractsDsl
    @NotNull
    <R> i3.a e(@NotNull n<? extends R> nVar, @NotNull InvocationKind invocationKind);

    @ExperimentalExtendedContracts
    @ContractsDsl
    void f(boolean z5, @NotNull h hVar);
}
