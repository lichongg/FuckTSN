package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import java.util.Map;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.v;
import kotlin.reflect.jvm.internal.impl.types.e1;
import kotlin.reflect.jvm.internal.impl.types.t0;
import kotlin.s;
import kotlin.t;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class k implements c {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final kotlin.reflect.jvm.internal.impl.builtins.j f44660a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private final kotlin.reflect.jvm.internal.impl.name.c f44661b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private final Map<kotlin.reflect.jvm.internal.impl.name.f, kotlin.reflect.jvm.internal.impl.resolve.constants.g<?>> f44662c;

    /* renamed from: d, reason: collision with root package name */
    private final boolean f44663d;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    private final s f44664e;

    /* JADX WARN: Multi-variable type inference failed */
    public k(@NotNull kotlin.reflect.jvm.internal.impl.builtins.j builtIns, @NotNull kotlin.reflect.jvm.internal.impl.name.c fqName, @NotNull Map<kotlin.reflect.jvm.internal.impl.name.f, ? extends kotlin.reflect.jvm.internal.impl.resolve.constants.g<?>> allValueArguments, boolean z5) {
        g0.p(builtIns, "builtIns");
        g0.p(fqName, "fqName");
        g0.p(allValueArguments, "allValueArguments");
        this.f44660a = builtIns;
        this.f44661b = fqName;
        this.f44662c = allValueArguments;
        this.f44663d = z5;
        this.f44664e = t.b(LazyThreadSafetyMode.PUBLICATION, new j(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final e1 c(k kVar) {
        return kVar.f44660a.p(kVar.d()).s();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.c
    @NotNull
    public Map<kotlin.reflect.jvm.internal.impl.name.f, kotlin.reflect.jvm.internal.impl.resolve.constants.g<?>> a() {
        return this.f44662c;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.c
    @NotNull
    public kotlin.reflect.jvm.internal.impl.name.c d() {
        return this.f44661b;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.c
    @NotNull
    public kotlin.reflect.jvm.internal.impl.descriptors.e1 getSource() {
        kotlin.reflect.jvm.internal.impl.descriptors.e1 NO_SOURCE = kotlin.reflect.jvm.internal.impl.descriptors.e1.f44683a;
        g0.o(NO_SOURCE, "NO_SOURCE");
        return NO_SOURCE;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.c
    @NotNull
    public t0 getType() {
        Object value = this.f44664e.getValue();
        g0.o(value, "getValue(...)");
        return (t0) value;
    }

    public /* synthetic */ k(kotlin.reflect.jvm.internal.impl.builtins.j jVar, kotlin.reflect.jvm.internal.impl.name.c cVar, Map map, boolean z5, int i6, v vVar) {
        this(jVar, cVar, map, (i6 & 8) != 0 ? false : z5);
    }
}
