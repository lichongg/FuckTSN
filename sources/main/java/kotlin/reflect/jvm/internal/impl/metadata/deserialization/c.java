package kotlin.reflect.jvm.internal.impl.metadata.deserialization;

import java.util.Arrays;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class c extends kotlin.reflect.jvm.internal.impl.metadata.deserialization.a {

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    public static final a f46235h = new a(null);

    /* renamed from: i, reason: collision with root package name */
    @JvmField
    @NotNull
    public static final c f46236i;

    /* renamed from: j, reason: collision with root package name */
    @JvmField
    @NotNull
    public static final c f46237j;

    /* renamed from: k, reason: collision with root package name */
    @JvmField
    @NotNull
    public static final c f46238k;

    /* renamed from: g, reason: collision with root package name */
    private final boolean f46239g;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a {
        public /* synthetic */ a(v vVar) {
            this();
        }

        private a() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(@NotNull int[] versionArray, boolean z5) {
        super(Arrays.copyOf(versionArray, versionArray.length));
        g0.p(versionArray, "versionArray");
        this.f46239g = z5;
    }

    static {
        c cVar = new c(2, 2, 0);
        f46236i = cVar;
        f46237j = cVar.m();
        f46238k = new c(new int[0]);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public c(@NotNull int... numbers) {
        this(numbers, false);
        g0.p(numbers, "numbers");
    }

    public final boolean h(@NotNull c metadataVersionFromLanguageVersion) {
        g0.p(metadataVersionFromLanguageVersion, "metadataVersionFromLanguageVersion");
        return i(metadataVersionFromLanguageVersion.k(this.f46239g));
    }

    public final boolean j() {
        return this.f46239g;
    }

    @NotNull
    public final c k(boolean z5) {
        c cVar = z5 ? f46236i : f46237j;
        return cVar.l(this) ? cVar : this;
    }

    private final boolean i(c cVar) {
        if ((a() == 1 && b() == 0) || a() == 0) {
            return false;
        }
        return !l(cVar);
    }

    private final boolean l(c cVar) {
        if (a() > cVar.a()) {
            return true;
        }
        if (a() >= cVar.a() && b() > cVar.b()) {
            return true;
        }
        return false;
    }

    @NotNull
    public final c m() {
        if (a() == 1 && b() == 9) {
            return new c(2, 0, 0);
        }
        return new c(a(), b() + 1, 0);
    }
}
