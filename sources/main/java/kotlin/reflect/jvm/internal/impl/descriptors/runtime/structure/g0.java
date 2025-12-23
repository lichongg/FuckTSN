package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nReflectJavaValueParameter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ReflectJavaValueParameter.kt\norg/jetbrains/kotlin/descriptors/runtime/structure/ReflectJavaValueParameter\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,46:1\n1#2:47\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class g0 extends u implements y3.b0 {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final e0 f45008a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private final Annotation[] f45009b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    private final String f45010c;

    /* renamed from: d, reason: collision with root package name */
    private final boolean f45011d;

    @Override // y3.d
    public boolean s() {
        return false;
    }

    public g0(@NotNull e0 type, @NotNull Annotation[] reflectAnnotations, @Nullable String str, boolean z5) {
        kotlin.jvm.internal.g0.p(type, "type");
        kotlin.jvm.internal.g0.p(reflectAnnotations, "reflectAnnotations");
        this.f45008a = type;
        this.f45009b = reflectAnnotations;
        this.f45010c = str;
        this.f45011d = z5;
    }

    @Override // y3.b0
    public boolean a() {
        return this.f45011d;
    }

    @Override // y3.d
    @Nullable
    public g b(@NotNull kotlin.reflect.jvm.internal.impl.name.c fqName) {
        kotlin.jvm.internal.g0.p(fqName, "fqName");
        return k.a(this.f45009b, fqName);
    }

    @Override // y3.d
    @NotNull
    public List<g> getAnnotations() {
        return k.b(this.f45009b);
    }

    @Override // y3.b0
    @Nullable
    public kotlin.reflect.jvm.internal.impl.name.f getName() {
        String str = this.f45010c;
        if (str != null) {
            return kotlin.reflect.jvm.internal.impl.name.f.d(str);
        }
        return null;
    }

    @Override // y3.b0
    @NotNull
    public e0 getType() {
        return this.f45008a;
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(g0.class.getName());
        sb.append(": ");
        sb.append(a() ? "vararg " : "");
        sb.append(getName());
        sb.append(": ");
        sb.append(getType());
        return sb.toString();
    }
}
