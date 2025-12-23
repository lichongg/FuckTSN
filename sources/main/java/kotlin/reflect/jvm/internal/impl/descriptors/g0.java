package kotlin.reflect.jvm.internal.impl.descriptors;

import e4.h;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class g0<Type extends e4.h> extends o1<Type> {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final List<Pair<kotlin.reflect.jvm.internal.impl.name.f, Type>> f44685a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private final Map<kotlin.reflect.jvm.internal.impl.name.f, Type> f44686b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public g0(@NotNull List<? extends Pair<kotlin.reflect.jvm.internal.impl.name.f, ? extends Type>> underlyingPropertyNamesToTypes) {
        super(null);
        kotlin.jvm.internal.g0.p(underlyingPropertyNamesToTypes, "underlyingPropertyNamesToTypes");
        this.f44685a = underlyingPropertyNamesToTypes;
        this.f44686b = kotlin.collections.i1.B0(c());
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.o1
    public boolean a(@NotNull kotlin.reflect.jvm.internal.impl.name.f name) {
        kotlin.jvm.internal.g0.p(name, "name");
        return this.f44686b.containsKey(name);
    }

    @NotNull
    public List<Pair<kotlin.reflect.jvm.internal.impl.name.f, Type>> c() {
        return this.f44685a;
    }

    @NotNull
    public String toString() {
        return "MultiFieldValueClassRepresentation(underlyingPropertyNamesToTypes=" + c() + ')';
    }
}
