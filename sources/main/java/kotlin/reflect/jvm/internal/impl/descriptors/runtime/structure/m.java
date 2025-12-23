package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.util.Collection;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.e0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class m extends e0 implements y3.f {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private final Type f45019b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private final e0 f45020c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private final Collection<y3.a> f45021d;

    /* renamed from: e, reason: collision with root package name */
    private final boolean f45022e;

    public m(@NotNull Type reflectType) {
        e0 a6;
        kotlin.jvm.internal.g0.p(reflectType, "reflectType");
        this.f45019b = reflectType;
        Type M = M();
        if (!(M instanceof GenericArrayType)) {
            if (M instanceof Class) {
                Class cls = (Class) M;
                if (cls.isArray()) {
                    e0.a aVar = e0.f45001a;
                    Class<?> componentType = cls.getComponentType();
                    kotlin.jvm.internal.g0.o(componentType, "getComponentType(...)");
                    a6 = aVar.a(componentType);
                }
            }
            throw new IllegalArgumentException("Not an array type (" + M().getClass() + "): " + M());
        }
        e0.a aVar2 = e0.f45001a;
        Type genericComponentType = ((GenericArrayType) M).getGenericComponentType();
        kotlin.jvm.internal.g0.o(genericComponentType, "getGenericComponentType(...)");
        a6 = aVar2.a(genericComponentType);
        this.f45020c = a6;
        this.f45021d = kotlin.collections.f0.J();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.e0
    @NotNull
    protected Type M() {
        return this.f45019b;
    }

    @Override // y3.f
    @NotNull
    /* renamed from: N, reason: merged with bridge method [inline-methods] */
    public e0 j() {
        return this.f45020c;
    }

    @Override // y3.d
    @NotNull
    public Collection<y3.a> getAnnotations() {
        return this.f45021d;
    }

    @Override // y3.d
    public boolean s() {
        return this.f45022e;
    }
}
