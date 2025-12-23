package kotlin.reflect.jvm.internal.impl.resolve.constants;

import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nClassLiteralValue.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ClassLiteralValue.kt\norg/jetbrains/kotlin/resolve/constants/ClassLiteralValue\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,17:1\n1#2:18\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final kotlin.reflect.jvm.internal.impl.name.b f46663a;

    /* renamed from: b, reason: collision with root package name */
    private final int f46664b;

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return g0.g(this.f46663a, fVar.f46663a) && this.f46664b == fVar.f46664b;
    }

    public f(@NotNull kotlin.reflect.jvm.internal.impl.name.b classId, int i6) {
        g0.p(classId, "classId");
        this.f46663a = classId;
        this.f46664b = i6;
    }

    @NotNull
    public final kotlin.reflect.jvm.internal.impl.name.b a() {
        return this.f46663a;
    }

    public final int b() {
        return this.f46664b;
    }

    public final int c() {
        return this.f46664b;
    }

    @NotNull
    public final kotlin.reflect.jvm.internal.impl.name.b d() {
        return this.f46663a;
    }

    public int hashCode() {
        return (this.f46663a.hashCode() * 31) + this.f46664b;
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        int i6 = this.f46664b;
        for (int i7 = 0; i7 < i6; i7++) {
            sb.append("kotlin/Array<");
        }
        sb.append(this.f46663a);
        int i8 = this.f46664b;
        for (int i9 = 0; i9 < i8; i9++) {
            sb.append(">");
        }
        return sb.toString();
    }
}
