package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class h {

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public static final a f45780e = new a(null);

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    private static final h f45781f = new h(null, null, false, false, 8, null);

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    private final NullabilityQualifier f45782a;

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    private final MutabilityQualifier f45783b;

    /* renamed from: c, reason: collision with root package name */
    private final boolean f45784c;

    /* renamed from: d, reason: collision with root package name */
    private final boolean f45785d;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.v vVar) {
            this();
        }

        private a() {
        }

        @NotNull
        public final h a() {
            return h.f45781f;
        }
    }

    public h(@Nullable NullabilityQualifier nullabilityQualifier, @Nullable MutabilityQualifier mutabilityQualifier, boolean z5, boolean z6) {
        this.f45782a = nullabilityQualifier;
        this.f45783b = mutabilityQualifier;
        this.f45784c = z5;
        this.f45785d = z6;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        return this.f45782a == hVar.f45782a && this.f45783b == hVar.f45783b && this.f45784c == hVar.f45784c && this.f45785d == hVar.f45785d;
    }

    public static /* synthetic */ h c(h hVar, NullabilityQualifier nullabilityQualifier, MutabilityQualifier mutabilityQualifier, boolean z5, boolean z6, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            nullabilityQualifier = hVar.f45782a;
        }
        if ((i6 & 2) != 0) {
            mutabilityQualifier = hVar.f45783b;
        }
        if ((i6 & 4) != 0) {
            z5 = hVar.f45784c;
        }
        if ((i6 & 8) != 0) {
            z6 = hVar.f45785d;
        }
        return hVar.b(nullabilityQualifier, mutabilityQualifier, z5, z6);
    }

    @NotNull
    public final h b(@Nullable NullabilityQualifier nullabilityQualifier, @Nullable MutabilityQualifier mutabilityQualifier, boolean z5, boolean z6) {
        return new h(nullabilityQualifier, mutabilityQualifier, z5, z6);
    }

    public final boolean d() {
        return this.f45784c;
    }

    @Nullable
    public final MutabilityQualifier e() {
        return this.f45783b;
    }

    @Nullable
    public final NullabilityQualifier f() {
        return this.f45782a;
    }

    public final boolean g() {
        return this.f45785d;
    }

    public int hashCode() {
        NullabilityQualifier nullabilityQualifier = this.f45782a;
        int hashCode = (nullabilityQualifier == null ? 0 : nullabilityQualifier.hashCode()) * 31;
        MutabilityQualifier mutabilityQualifier = this.f45783b;
        return ((((hashCode + (mutabilityQualifier != null ? mutabilityQualifier.hashCode() : 0)) * 31) + kotlin.reflect.jvm.internal.impl.km.f.a(this.f45784c)) * 31) + kotlin.reflect.jvm.internal.impl.km.f.a(this.f45785d);
    }

    @NotNull
    public String toString() {
        return "JavaTypeQualifiers(nullability=" + this.f45782a + ", mutability=" + this.f45783b + ", definitelyNotNull=" + this.f45784c + ", isNullabilityQualifierForWarning=" + this.f45785d + ')';
    }

    public /* synthetic */ h(NullabilityQualifier nullabilityQualifier, MutabilityQualifier mutabilityQualifier, boolean z5, boolean z6, int i6, kotlin.jvm.internal.v vVar) {
        this(nullabilityQualifier, mutabilityQualifier, z5, (i6 & 8) != 0 ? false : z6);
    }
}
