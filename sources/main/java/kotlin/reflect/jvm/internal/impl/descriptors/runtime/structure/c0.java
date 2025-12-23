package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.util.Collection;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class c0 extends e0 implements y3.v {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private final Class<?> f44995b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private final Collection<y3.a> f44996c;

    /* renamed from: d, reason: collision with root package name */
    private final boolean f44997d;

    public c0(@NotNull Class<?> reflectType) {
        kotlin.jvm.internal.g0.p(reflectType, "reflectType");
        this.f44995b = reflectType;
        this.f44996c = kotlin.collections.f0.J();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.e0
    @NotNull
    /* renamed from: N, reason: merged with bridge method [inline-methods] */
    public Class<?> M() {
        return this.f44995b;
    }

    @Override // y3.d
    @NotNull
    public Collection<y3.a> getAnnotations() {
        return this.f44996c;
    }

    @Override // y3.d
    public boolean s() {
        return this.f44997d;
    }

    @Override // y3.v
    @Nullable
    public PrimitiveType getType() {
        if (kotlin.jvm.internal.g0.g(M(), Void.TYPE)) {
            return null;
        }
        return JvmPrimitiveType.get(M().getName()).getPrimitiveType();
    }
}
