package kotlin.reflect.jvm.internal.impl.km;

import java.util.ArrayList;
import java.util.List;
import kotlin.contracts.ExperimentalContracts;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@ExperimentalContracts
/* loaded from: D:\Downloads\app\classes8.dex */
public final class m {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private KmEffectType f45248a;

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    private KmEffectInvocationKind f45249b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private final List<n> f45250c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    private n f45251d;

    public m(@NotNull KmEffectType type, @Nullable KmEffectInvocationKind kmEffectInvocationKind) {
        g0.p(type, "type");
        this.f45248a = type;
        this.f45249b = kmEffectInvocationKind;
        this.f45250c = new ArrayList(1);
    }

    @NotNull
    public final List<n> a() {
        return this.f45250c;
    }

    public final void b(@Nullable n nVar) {
        this.f45251d = nVar;
    }
}
