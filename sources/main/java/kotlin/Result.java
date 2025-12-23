package kotlin;

import java.io.Serializable;
import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmInline;
import kotlin.jvm.JvmName;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SinceKotlin(version = "1.3")
@JvmInline
/* loaded from: D:\Downloads\app\classes8.dex */
public final class Result<T> implements Serializable {

    @NotNull
    public static final a Companion = new a(null);

    @Nullable
    private final Object value;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class Failure implements Serializable {

        @JvmField
        @NotNull
        public final Throwable exception;

        public Failure(@NotNull Throwable exception) {
            kotlin.jvm.internal.g0.p(exception, "exception");
            this.exception = exception;
        }

        public boolean equals(@Nullable Object obj) {
            return (obj instanceof Failure) && kotlin.jvm.internal.g0.g(this.exception, ((Failure) obj).exception);
        }

        public int hashCode() {
            return this.exception.hashCode();
        }

        @NotNull
        public String toString() {
            return "Failure(" + this.exception + ')';
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.v vVar) {
            this();
        }

        private a() {
        }

        @InlineOnly
        @JvmName(name = "failure")
        private final <T> Object a(Throwable exception) {
            kotlin.jvm.internal.g0.p(exception, "exception");
            return Result.m130constructorimpl(g0.a(exception));
        }

        @InlineOnly
        @JvmName(name = "success")
        private final <T> Object b(T t5) {
            return Result.m130constructorimpl(t5);
        }
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ Result m129boximpl(Object obj) {
        return new Result(obj);
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m131equalsimpl(Object obj, Object obj2) {
        return (obj2 instanceof Result) && kotlin.jvm.internal.g0.g(obj, ((Result) obj2).m139unboximpl());
    }

    @Nullable
    /* renamed from: exceptionOrNull-impl, reason: not valid java name */
    public static final Throwable m133exceptionOrNullimpl(Object obj) {
        if (obj instanceof Failure) {
            return ((Failure) obj).exception;
        }
        return null;
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m135hashCodeimpl(Object obj) {
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    /* renamed from: isFailure-impl, reason: not valid java name */
    public static final boolean m136isFailureimpl(Object obj) {
        return obj instanceof Failure;
    }

    /* renamed from: isSuccess-impl, reason: not valid java name */
    public static final boolean m137isSuccessimpl(Object obj) {
        return !(obj instanceof Failure);
    }

    @NotNull
    /* renamed from: toString-impl, reason: not valid java name */
    public static String m138toStringimpl(Object obj) {
        if (obj instanceof Failure) {
            return ((Failure) obj).toString();
        }
        return "Success(" + obj + ')';
    }

    public boolean equals(Object obj) {
        return m131equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m135hashCodeimpl(this.value);
    }

    @NotNull
    public String toString() {
        return m138toStringimpl(this.value);
    }

    /* renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ Object m139unboximpl() {
        return this.value;
    }

    @PublishedApi
    private /* synthetic */ Result(Object obj) {
        this.value = obj;
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m132equalsimpl0(Object obj, Object obj2) {
        return kotlin.jvm.internal.g0.g(obj, obj2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @InlineOnly
    /* renamed from: getOrNull-impl, reason: not valid java name */
    private static final T m134getOrNullimpl(Object obj) {
        if (m136isFailureimpl(obj)) {
            return null;
        }
        return obj;
    }

    @PublishedApi
    public static /* synthetic */ void getValue$annotations() {
    }

    @PublishedApi
    @NotNull
    /* renamed from: constructor-impl, reason: not valid java name */
    public static <T> Object m130constructorimpl(@Nullable Object obj) {
        return obj;
    }
}
