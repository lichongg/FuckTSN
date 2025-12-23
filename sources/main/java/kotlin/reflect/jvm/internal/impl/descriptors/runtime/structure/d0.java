package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.reflect.Member;
import java.lang.reflect.Method;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nReflectJavaRecordComponent.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ReflectJavaRecordComponent.kt\norg/jetbrains/kotlin/descriptors/runtime/structure/ReflectJavaRecordComponent\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,68:1\n1#2:69\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class d0 extends y implements y3.w {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final Object f44999a;

    @Override // y3.w
    public boolean a() {
        return false;
    }

    public d0(@NotNull Object recordComponent) {
        kotlin.jvm.internal.g0.p(recordComponent, "recordComponent");
        this.f44999a = recordComponent;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.y
    @NotNull
    public Member N() {
        Method c6 = a.f44980a.c(this.f44999a);
        if (c6 != null) {
            return c6;
        }
        throw new NoSuchMethodError("Can't find `getAccessor` method");
    }

    @Override // y3.w
    @NotNull
    public y3.x getType() {
        Class<?> d6 = a.f44980a.d(this.f44999a);
        if (d6 != null) {
            return new s(d6);
        }
        throw new NoSuchMethodError("Can't find `getType` method");
    }
}
