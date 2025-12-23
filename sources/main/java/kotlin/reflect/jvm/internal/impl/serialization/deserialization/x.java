package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class x<T> {

    /* renamed from: a, reason: collision with root package name */
    private final T f47081a;

    /* renamed from: b, reason: collision with root package name */
    private final T f47082b;

    /* renamed from: c, reason: collision with root package name */
    private final T f47083c;

    /* renamed from: d, reason: collision with root package name */
    private final T f47084d;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    private final String f47085e;

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof x)) {
            return false;
        }
        x xVar = (x) obj;
        return kotlin.jvm.internal.g0.g(this.f47081a, xVar.f47081a) && kotlin.jvm.internal.g0.g(this.f47082b, xVar.f47082b) && kotlin.jvm.internal.g0.g(this.f47083c, xVar.f47083c) && kotlin.jvm.internal.g0.g(this.f47084d, xVar.f47084d) && kotlin.jvm.internal.g0.g(this.f47085e, xVar.f47085e);
    }

    public x(T t5, T t6, T t7, T t8, @NotNull String filePath) {
        kotlin.jvm.internal.g0.p(filePath, "filePath");
        this.f47081a = t5;
        this.f47082b = t6;
        this.f47083c = t7;
        this.f47084d = t8;
        this.f47085e = filePath;
    }

    public int hashCode() {
        T t5 = this.f47081a;
        int hashCode = (t5 == null ? 0 : t5.hashCode()) * 31;
        T t6 = this.f47082b;
        int hashCode2 = (hashCode + (t6 == null ? 0 : t6.hashCode())) * 31;
        T t7 = this.f47083c;
        int hashCode3 = (hashCode2 + (t7 == null ? 0 : t7.hashCode())) * 31;
        T t8 = this.f47084d;
        return ((hashCode3 + (t8 != null ? t8.hashCode() : 0)) * 31) + this.f47085e.hashCode();
    }

    @NotNull
    public String toString() {
        return "IncompatibleVersionErrorData(actualVersion=" + this.f47081a + ", compilerVersion=" + this.f47082b + ", languageVersion=" + this.f47083c + ", expectedVersion=" + this.f47084d + ", filePath=" + this.f47085e + ')';
    }
}
