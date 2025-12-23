package kotlin.reflect.jvm.internal.impl.load.java.lazy.types;

import java.util.Set;
import kotlin.collections.u1;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.v;
import kotlin.reflect.jvm.internal.impl.descriptors.j1;
import kotlin.reflect.jvm.internal.impl.types.TypeUsage;
import kotlin.reflect.jvm.internal.impl.types.e1;
import kotlin.reflect.jvm.internal.impl.types.i0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class a extends i0 {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private final TypeUsage f45697d;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    private final JavaTypeFlexibility f45698e;

    /* renamed from: f, reason: collision with root package name */
    private final boolean f45699f;

    /* renamed from: g, reason: collision with root package name */
    private final boolean f45700g;

    /* renamed from: h, reason: collision with root package name */
    @Nullable
    private final Set<j1> f45701h;

    /* renamed from: i, reason: collision with root package name */
    @Nullable
    private final e1 f45702i;

    public /* synthetic */ a(TypeUsage typeUsage, JavaTypeFlexibility javaTypeFlexibility, boolean z5, boolean z6, Set set, e1 e1Var, int i6, v vVar) {
        this(typeUsage, (i6 & 2) != 0 ? JavaTypeFlexibility.INFLEXIBLE : javaTypeFlexibility, (i6 & 4) != 0 ? false : z5, (i6 & 8) != 0 ? false : z6, (i6 & 16) != 0 ? null : set, (i6 & 32) != 0 ? null : e1Var);
    }

    public static /* synthetic */ a f(a aVar, TypeUsage typeUsage, JavaTypeFlexibility javaTypeFlexibility, boolean z5, boolean z6, Set set, e1 e1Var, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            typeUsage = aVar.f45697d;
        }
        if ((i6 & 2) != 0) {
            javaTypeFlexibility = aVar.f45698e;
        }
        if ((i6 & 4) != 0) {
            z5 = aVar.f45699f;
        }
        if ((i6 & 8) != 0) {
            z6 = aVar.f45700g;
        }
        if ((i6 & 16) != 0) {
            set = aVar.f45701h;
        }
        if ((i6 & 32) != 0) {
            e1Var = aVar.f45702i;
        }
        Set set2 = set;
        e1 e1Var2 = e1Var;
        return aVar.e(typeUsage, javaTypeFlexibility, z5, z6, set2, e1Var2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.i0
    @Nullable
    public e1 a() {
        return this.f45702i;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.i0
    @NotNull
    public TypeUsage b() {
        return this.f45697d;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.i0
    @Nullable
    public Set<j1> c() {
        return this.f45701h;
    }

    @NotNull
    public final a e(@NotNull TypeUsage howThisTypeIsUsed, @NotNull JavaTypeFlexibility flexibility, boolean z5, boolean z6, @Nullable Set<? extends j1> set, @Nullable e1 e1Var) {
        g0.p(howThisTypeIsUsed, "howThisTypeIsUsed");
        g0.p(flexibility, "flexibility");
        return new a(howThisTypeIsUsed, flexibility, z5, z6, set, e1Var);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.i0
    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return g0.g(aVar.a(), a()) && aVar.b() == b() && aVar.f45698e == this.f45698e && aVar.f45699f == this.f45699f && aVar.f45700g == this.f45700g;
    }

    @NotNull
    public final JavaTypeFlexibility g() {
        return this.f45698e;
    }

    public final boolean h() {
        return this.f45700g;
    }

    public final boolean i() {
        return this.f45699f;
    }

    @NotNull
    public final a j(boolean z5) {
        return f(this, null, null, z5, false, null, null, 59, null);
    }

    @NotNull
    public a k(@Nullable e1 e1Var) {
        return f(this, null, null, false, false, null, e1Var, 31, null);
    }

    @NotNull
    public final a l(@NotNull JavaTypeFlexibility flexibility) {
        g0.p(flexibility, "flexibility");
        return f(this, null, flexibility, false, false, null, null, 61, null);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.i0
    @NotNull
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public a d(@NotNull j1 typeParameter) {
        g0.p(typeParameter, "typeParameter");
        return f(this, null, null, false, false, c() != null ? u1.D(c(), typeParameter) : u1.f(typeParameter), null, 47, null);
    }

    @NotNull
    public String toString() {
        return "JavaTypeAttributes(howThisTypeIsUsed=" + this.f45697d + ", flexibility=" + this.f45698e + ", isRaw=" + this.f45699f + ", isForAnnotationParameter=" + this.f45700g + ", visitedTypeParameters=" + this.f45701h + ", defaultType=" + this.f45702i + ')';
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public a(@NotNull TypeUsage howThisTypeIsUsed, @NotNull JavaTypeFlexibility flexibility, boolean z5, boolean z6, @Nullable Set<? extends j1> set, @Nullable e1 e1Var) {
        super(howThisTypeIsUsed, set, e1Var);
        g0.p(howThisTypeIsUsed, "howThisTypeIsUsed");
        g0.p(flexibility, "flexibility");
        this.f45697d = howThisTypeIsUsed;
        this.f45698e = flexibility;
        this.f45699f = z5;
        this.f45700g = z6;
        this.f45701h = set;
        this.f45702i = e1Var;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.i0
    public int hashCode() {
        int i6;
        e1 a6 = a();
        if (a6 != null) {
            i6 = a6.hashCode();
        } else {
            i6 = 0;
        }
        int hashCode = i6 + (i6 * 31) + b().hashCode();
        int hashCode2 = hashCode + (hashCode * 31) + this.f45698e.hashCode();
        int i7 = hashCode2 + (hashCode2 * 31) + (this.f45699f ? 1 : 0);
        return i7 + (i7 * 31) + (this.f45700g ? 1 : 0);
    }
}
