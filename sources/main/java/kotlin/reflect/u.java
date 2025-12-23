package kotlin.reflect;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;
import kotlin.ExperimentalStdlibApi;
import kotlin.collections.a0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@ExperimentalStdlibApi
@SourceDebugExtension({"SMAP\nTypesJVM.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TypesJVM.kt\nkotlin/reflect/ParameterizedTypeImpl\n+ 2 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,230:1\n37#2,2:231\n*S KotlinDebug\n*F\n+ 1 TypesJVM.kt\nkotlin/reflect/ParameterizedTypeImpl\n*L\n190#1:231,2\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
final class u implements ParameterizedType, v {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final Class<?> f47640a;

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    private final Type f47641b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private final Type[] f47642c;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final /* synthetic */ class a extends FunctionReferenceImpl implements Function1<Type, String> {

        /* renamed from: a, reason: collision with root package name */
        public static final a f47643a = new a();

        a() {
            super(1, y.class, "typeToString", "typeToString(Ljava/lang/reflect/Type;)Ljava/lang/String;", 1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public final String invoke(Type p02) {
            String j6;
            g0.p(p02, "p0");
            j6 = y.j(p02);
            return j6;
        }
    }

    public u(@NotNull Class<?> rawType, @Nullable Type type, @NotNull List<? extends Type> typeArguments) {
        g0.p(rawType, "rawType");
        g0.p(typeArguments, "typeArguments");
        this.f47640a = rawType;
        this.f47641b = type;
        this.f47642c = (Type[]) typeArguments.toArray(new Type[0]);
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof ParameterizedType)) {
            return false;
        }
        ParameterizedType parameterizedType = (ParameterizedType) obj;
        return g0.g(this.f47640a, parameterizedType.getRawType()) && g0.g(this.f47641b, parameterizedType.getOwnerType()) && Arrays.equals(getActualTypeArguments(), parameterizedType.getActualTypeArguments());
    }

    @Override // java.lang.reflect.ParameterizedType
    @NotNull
    public Type[] getActualTypeArguments() {
        return this.f47642c;
    }

    @Override // java.lang.reflect.ParameterizedType
    @Nullable
    public Type getOwnerType() {
        return this.f47641b;
    }

    @Override // java.lang.reflect.ParameterizedType
    @NotNull
    public Type getRawType() {
        return this.f47640a;
    }

    @Override // java.lang.reflect.Type, kotlin.reflect.v
    @NotNull
    public String getTypeName() {
        String j6;
        String j7;
        StringBuilder sb = new StringBuilder();
        Type type = this.f47641b;
        if (type != null) {
            j7 = y.j(type);
            sb.append(j7);
            sb.append("$");
            sb.append(this.f47640a.getSimpleName());
        } else {
            j6 = y.j(this.f47640a);
            sb.append(j6);
        }
        Type[] typeArr = this.f47642c;
        if (!(typeArr.length == 0)) {
            a0.dh(typeArr, sb, (r14 & 2) != 0 ? ", " : null, (r14 & 4) != 0 ? "" : "<", (r14 & 8) == 0 ? ">" : "", (r14 & 16) != 0 ? -1 : 0, (r14 & 32) != 0 ? "..." : null, (r14 & 64) != 0 ? null : a.f47643a);
        }
        return sb.toString();
    }

    public int hashCode() {
        int hashCode = this.f47640a.hashCode();
        Type type = this.f47641b;
        return (hashCode ^ (type != null ? type.hashCode() : 0)) ^ Arrays.hashCode(getActualTypeArguments());
    }

    @NotNull
    public String toString() {
        return getTypeName();
    }
}
