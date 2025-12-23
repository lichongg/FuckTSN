package kotlin.reflect.jvm.internal.impl.util;

import java.util.Arrays;
import java.util.Collection;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.g0;
import kotlin.reflect.jvm.internal.impl.util.g;
import kotlin.text.Regex;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    private final kotlin.reflect.jvm.internal.impl.name.f f47397a;

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    private final Regex f47398b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    private final Collection<kotlin.reflect.jvm.internal.impl.name.f> f47399c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private final Function1<kotlin.reflect.jvm.internal.impl.descriptors.y, String> f47400d;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    private final f[] f47401e;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class a implements Function1 {

        /* renamed from: a, reason: collision with root package name */
        public static final a f47402a = new a();

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Void invoke(kotlin.reflect.jvm.internal.impl.descriptors.y yVar) {
            g0.p(yVar, "<this>");
            return null;
        }

        a() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class b implements Function1 {

        /* renamed from: a, reason: collision with root package name */
        public static final b f47403a = new b();

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Void invoke(kotlin.reflect.jvm.internal.impl.descriptors.y yVar) {
            g0.p(yVar, "<this>");
            return null;
        }

        b() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class c implements Function1 {

        /* renamed from: a, reason: collision with root package name */
        public static final c f47404a = new c();

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Void invoke(kotlin.reflect.jvm.internal.impl.descriptors.y yVar) {
            g0.p(yVar, "<this>");
            return null;
        }

        c() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private h(kotlin.reflect.jvm.internal.impl.name.f fVar, Regex regex, Collection<kotlin.reflect.jvm.internal.impl.name.f> collection, Function1<? super kotlin.reflect.jvm.internal.impl.descriptors.y, String> function1, f... fVarArr) {
        this.f47397a = fVar;
        this.f47398b = regex;
        this.f47399c = collection;
        this.f47400d = function1;
        this.f47401e = fVarArr;
    }

    @NotNull
    public final g a(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.y functionDescriptor) {
        g0.p(functionDescriptor, "functionDescriptor");
        for (f fVar : this.f47401e) {
            String a6 = fVar.a(functionDescriptor);
            if (a6 != null) {
                return new g.b(a6);
            }
        }
        String invoke = this.f47400d.invoke(functionDescriptor);
        return invoke != null ? new g.b(invoke) : g.c.f47396b;
    }

    public final boolean b(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.y functionDescriptor) {
        g0.p(functionDescriptor, "functionDescriptor");
        if (this.f47397a != null && !g0.g(functionDescriptor.getName(), this.f47397a)) {
            return false;
        }
        if (this.f47398b != null) {
            String b6 = functionDescriptor.getName().b();
            g0.o(b6, "asString(...)");
            if (!this.f47398b.matches(b6)) {
                return false;
            }
        }
        Collection<kotlin.reflect.jvm.internal.impl.name.f> collection = this.f47399c;
        return collection == null || collection.contains(functionDescriptor.getName());
    }

    public /* synthetic */ h(kotlin.reflect.jvm.internal.impl.name.f fVar, f[] fVarArr, Function1 function1, int i6, kotlin.jvm.internal.v vVar) {
        this(fVar, fVarArr, (Function1<? super kotlin.reflect.jvm.internal.impl.descriptors.y, String>) ((i6 & 4) != 0 ? a.f47402a : function1));
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public h(@NotNull kotlin.reflect.jvm.internal.impl.name.f name, @NotNull f[] checks, @NotNull Function1<? super kotlin.reflect.jvm.internal.impl.descriptors.y, String> additionalChecks) {
        this(name, (Regex) null, (Collection<kotlin.reflect.jvm.internal.impl.name.f>) null, additionalChecks, (f[]) Arrays.copyOf(checks, checks.length));
        g0.p(name, "name");
        g0.p(checks, "checks");
        g0.p(additionalChecks, "additionalChecks");
    }

    public /* synthetic */ h(Regex regex, f[] fVarArr, Function1 function1, int i6, kotlin.jvm.internal.v vVar) {
        this(regex, fVarArr, (Function1<? super kotlin.reflect.jvm.internal.impl.descriptors.y, String>) ((i6 & 4) != 0 ? b.f47403a : function1));
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public h(@NotNull Regex regex, @NotNull f[] checks, @NotNull Function1<? super kotlin.reflect.jvm.internal.impl.descriptors.y, String> additionalChecks) {
        this((kotlin.reflect.jvm.internal.impl.name.f) null, regex, (Collection<kotlin.reflect.jvm.internal.impl.name.f>) null, additionalChecks, (f[]) Arrays.copyOf(checks, checks.length));
        g0.p(regex, "regex");
        g0.p(checks, "checks");
        g0.p(additionalChecks, "additionalChecks");
    }

    public /* synthetic */ h(Collection collection, f[] fVarArr, Function1 function1, int i6, kotlin.jvm.internal.v vVar) {
        this((Collection<kotlin.reflect.jvm.internal.impl.name.f>) collection, fVarArr, (Function1<? super kotlin.reflect.jvm.internal.impl.descriptors.y, String>) ((i6 & 4) != 0 ? c.f47404a : function1));
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public h(@NotNull Collection<kotlin.reflect.jvm.internal.impl.name.f> nameList, @NotNull f[] checks, @NotNull Function1<? super kotlin.reflect.jvm.internal.impl.descriptors.y, String> additionalChecks) {
        this((kotlin.reflect.jvm.internal.impl.name.f) null, (Regex) null, nameList, additionalChecks, (f[]) Arrays.copyOf(checks, checks.length));
        g0.p(nameList, "nameList");
        g0.p(checks, "checks");
        g0.p(additionalChecks, "additionalChecks");
    }
}
