package kotlin.reflect.jvm.internal.impl.descriptors;

import e4.h;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nInlineClassRepresentation.kt\nKotlin\n*S Kotlin\n*F\n+ 1 InlineClassRepresentation.kt\norg/jetbrains/kotlin/descriptors/InlineClassRepresentation\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,25:1\n1#2:26\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class z<Type extends e4.h> extends o1<Type> {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final kotlin.reflect.jvm.internal.impl.name.f f45060a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private final Type f45061b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z(@NotNull kotlin.reflect.jvm.internal.impl.name.f underlyingPropertyName, @NotNull Type underlyingType) {
        super(null);
        kotlin.jvm.internal.g0.p(underlyingPropertyName, "underlyingPropertyName");
        kotlin.jvm.internal.g0.p(underlyingType, "underlyingType");
        this.f45060a = underlyingPropertyName;
        this.f45061b = underlyingType;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.o1
    public boolean a(@NotNull kotlin.reflect.jvm.internal.impl.name.f name) {
        kotlin.jvm.internal.g0.p(name, "name");
        return kotlin.jvm.internal.g0.g(this.f45060a, name);
    }

    @NotNull
    public final kotlin.reflect.jvm.internal.impl.name.f c() {
        return this.f45060a;
    }

    @NotNull
    public final Type d() {
        return this.f45061b;
    }

    @NotNull
    public String toString() {
        return "InlineClassRepresentation(underlyingPropertyName=" + this.f45060a + ", underlyingType=" + this.f45061b + ')';
    }
}
