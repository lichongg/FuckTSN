package kotlin.reflect;

import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import kotlin.ExperimentalStdlibApi;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@ExperimentalStdlibApi
/* loaded from: D:\Downloads\app\classes8.dex */
final class z implements WildcardType, v {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f47647c = new a(null);

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private static final z f47648d = new z(null, null);

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    private final Type f47649a;

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    private final Type f47650b;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.v vVar) {
            this();
        }

        private a() {
        }

        @NotNull
        public final z a() {
            return z.f47648d;
        }
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof WildcardType)) {
            return false;
        }
        WildcardType wildcardType = (WildcardType) obj;
        return Arrays.equals(getUpperBounds(), wildcardType.getUpperBounds()) && Arrays.equals(getLowerBounds(), wildcardType.getLowerBounds());
    }

    @Override // java.lang.reflect.WildcardType
    @NotNull
    public Type[] getLowerBounds() {
        Type type = this.f47650b;
        return type == null ? new Type[0] : new Type[]{type};
    }

    @Override // java.lang.reflect.Type, kotlin.reflect.v
    @NotNull
    public String getTypeName() {
        String j6;
        String j7;
        if (this.f47650b != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("? super ");
            j7 = y.j(this.f47650b);
            sb.append(j7);
            return sb.toString();
        }
        Type type = this.f47649a;
        if (type == null || g0.g(type, Object.class)) {
            return "?";
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("? extends ");
        j6 = y.j(this.f47649a);
        sb2.append(j6);
        return sb2.toString();
    }

    @Override // java.lang.reflect.WildcardType
    @NotNull
    public Type[] getUpperBounds() {
        Type type = this.f47649a;
        if (type == null) {
            type = Object.class;
        }
        return new Type[]{type};
    }

    public z(@Nullable Type type, @Nullable Type type2) {
        this.f47649a = type;
        this.f47650b = type2;
    }

    public int hashCode() {
        return Arrays.hashCode(getUpperBounds()) ^ Arrays.hashCode(getLowerBounds());
    }

    @NotNull
    public String toString() {
        return getTypeName();
    }
}
