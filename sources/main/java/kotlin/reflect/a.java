package kotlin.reflect;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import kotlin.ExperimentalStdlibApi;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@ExperimentalStdlibApi
/* loaded from: D:\Downloads\app\classes8.dex */
final class a implements GenericArrayType, v {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final Type f44213a;

    public a(@NotNull Type elementType) {
        g0.p(elementType, "elementType");
        this.f44213a = elementType;
    }

    public boolean equals(@Nullable Object obj) {
        return (obj instanceof GenericArrayType) && g0.g(getGenericComponentType(), ((GenericArrayType) obj).getGenericComponentType());
    }

    @Override // java.lang.reflect.GenericArrayType
    @NotNull
    public Type getGenericComponentType() {
        return this.f44213a;
    }

    @Override // java.lang.reflect.Type, kotlin.reflect.v
    @NotNull
    public String getTypeName() {
        String j6;
        StringBuilder sb = new StringBuilder();
        j6 = y.j(this.f44213a);
        sb.append(j6);
        sb.append("[]");
        return sb.toString();
    }

    public int hashCode() {
        return getGenericComponentType().hashCode();
    }

    @NotNull
    public String toString() {
        return getTypeName();
    }
}
