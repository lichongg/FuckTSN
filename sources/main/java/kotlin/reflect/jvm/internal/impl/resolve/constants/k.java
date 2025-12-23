package kotlin.reflect.jvm.internal.impl.resolve.constants;

import kotlin.Pair;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.o0;
import kotlin.reflect.jvm.internal.impl.types.e1;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind;
import kotlin.reflect.jvm.internal.impl.types.t0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nconstantValues.kt\nKotlin\n*S Kotlin\n*F\n+ 1 constantValues.kt\norg/jetbrains/kotlin/resolve/constants/EnumValue\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,320:1\n1#2:321\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class k extends g<Pair<? extends kotlin.reflect.jvm.internal.impl.name.b, ? extends kotlin.reflect.jvm.internal.impl.name.f>> {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private final kotlin.reflect.jvm.internal.impl.name.b f46668b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private final kotlin.reflect.jvm.internal.impl.name.f f46669c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(@NotNull kotlin.reflect.jvm.internal.impl.name.b enumClassId, @NotNull kotlin.reflect.jvm.internal.impl.name.f enumEntryName) {
        super(o0.a(enumClassId, enumEntryName));
        g0.p(enumClassId, "enumClassId");
        g0.p(enumEntryName, "enumEntryName");
        this.f46668b = enumClassId;
        this.f46669c = enumEntryName;
    }

    @NotNull
    public final kotlin.reflect.jvm.internal.impl.name.f b() {
        return this.f46669c;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.constants.g
    @NotNull
    public t0 getType(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.f0 module) {
        e1 s5;
        g0.p(module, "module");
        kotlin.reflect.jvm.internal.impl.descriptors.d b6 = kotlin.reflect.jvm.internal.impl.descriptors.x.b(module, this.f46668b);
        if (b6 != null) {
            if (!kotlin.reflect.jvm.internal.impl.resolve.i.A(b6)) {
                b6 = null;
            }
            if (b6 != null && (s5 = b6.s()) != null) {
                return s5;
            }
        }
        return kotlin.reflect.jvm.internal.impl.types.error.i.d(ErrorTypeKind.ERROR_ENUM_TYPE, this.f46668b.toString(), this.f46669c.toString());
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.constants.g
    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f46668b.h());
        sb.append('.');
        sb.append(this.f46669c);
        return sb.toString();
    }
}
