package kotlin.reflect.jvm.internal.impl.km.internal;

import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.reflect.n;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nFlagDelegatesImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FlagDelegatesImpl.kt\nkotlin/metadata/internal/BooleanFlagDelegate\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,88:1\n1#2:89\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class a<Node> {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final kotlin.reflect.l<Node, Integer> f45161a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private final d f45162b;

    /* renamed from: c, reason: collision with root package name */
    private final int f45163c;

    public a(@NotNull kotlin.reflect.l<Node, Integer> flags, @NotNull d flag) {
        g0.p(flags, "flags");
        g0.p(flag, "flag");
        this.f45161a = flags;
        this.f45162b = flag;
        if (flag.a() == 1 && flag.c() == 1) {
            this.f45163c = 1 << flag.b();
            return;
        }
        throw new IllegalArgumentException(("BooleanFlagDelegate can work only with boolean flags (bitWidth = 1 and value = 1), but " + flag + " was passed").toString());
    }

    public final boolean a(Node node, @NotNull n<?> property) {
        g0.p(property, "property");
        return this.f45162b.d(this.f45161a.get(node).intValue());
    }

    public final void b(Node node, @NotNull n<?> property, boolean z5) {
        g0.p(property, "property");
        int intValue = this.f45161a.get(node).intValue();
        this.f45161a.set(node, Integer.valueOf(z5 ? intValue | this.f45163c : intValue & (~this.f45163c)));
    }
}
