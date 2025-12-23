package kotlin.reflect.jvm.internal.impl.km.internal;

import java.lang.Enum;
import java.util.List;
import kotlin.jvm.internal.g0;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.b;
import kotlin.reflect.jvm.internal.impl.protobuf.h;
import kotlin.reflect.n;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class b<Node, E extends Enum<E>> {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final kotlin.reflect.l<Node, Integer> f45164a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private final b.d<? extends h.a> f45165b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private final kotlin.enums.a<E> f45166c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private final List<d> f45167d;

    public b(@NotNull kotlin.reflect.l<Node, Integer> flags, @NotNull b.d<? extends h.a> protoSet, @NotNull kotlin.enums.a<E> entries, @NotNull List<d> flagValues) {
        g0.p(flags, "flags");
        g0.p(protoSet, "protoSet");
        g0.p(entries, "entries");
        g0.p(flagValues, "flagValues");
        this.f45164a = flags;
        this.f45165b = protoSet;
        this.f45166c = entries;
        this.f45167d = flagValues;
    }

    @NotNull
    public final E a(Node node, @NotNull n<?> property) {
        g0.p(property, "property");
        return (E) this.f45166c.get(this.f45165b.d(this.f45164a.get(node).intValue()).getNumber());
    }
}
