package kotlin.reflect.jvm.internal.impl.types;

import java.util.List;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nTypeSubstitution.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TypeSubstitution.kt\norg/jetbrains/kotlin/types/IndexedParametersSubstitution\n+ 2 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,207:1\n37#2:208\n36#2,3:209\n*S KotlinDebug\n*F\n+ 1 TypeSubstitution.kt\norg/jetbrains/kotlin/types/IndexedParametersSubstitution\n*L\n127#1:208\n127#1:209,3\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class o0 extends f2 {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private final kotlin.reflect.jvm.internal.impl.descriptors.j1[] f47301c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private final c2[] f47302d;

    /* renamed from: e, reason: collision with root package name */
    private final boolean f47303e;

    public /* synthetic */ o0(kotlin.reflect.jvm.internal.impl.descriptors.j1[] j1VarArr, c2[] c2VarArr, boolean z5, int i6, kotlin.jvm.internal.v vVar) {
        this(j1VarArr, c2VarArr, (i6 & 4) != 0 ? false : z5);
    }

    public o0(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.j1[] parameters, @NotNull c2[] arguments, boolean z5) {
        kotlin.jvm.internal.g0.p(parameters, "parameters");
        kotlin.jvm.internal.g0.p(arguments, "arguments");
        this.f47301c = parameters;
        this.f47302d = arguments;
        this.f47303e = z5;
        int length = parameters.length;
        int length2 = arguments.length;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.f2
    public boolean b() {
        return this.f47303e;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.f2
    @Nullable
    public c2 e(@NotNull t0 key) {
        kotlin.jvm.internal.g0.p(key, "key");
        kotlin.reflect.jvm.internal.impl.descriptors.f c6 = key.I0().c();
        kotlin.reflect.jvm.internal.impl.descriptors.j1 j1Var = c6 instanceof kotlin.reflect.jvm.internal.impl.descriptors.j1 ? (kotlin.reflect.jvm.internal.impl.descriptors.j1) c6 : null;
        if (j1Var == null) {
            return null;
        }
        int index = j1Var.getIndex();
        kotlin.reflect.jvm.internal.impl.descriptors.j1[] j1VarArr = this.f47301c;
        if (index >= j1VarArr.length || !kotlin.jvm.internal.g0.g(j1VarArr[index].o(), j1Var.o())) {
            return null;
        }
        return this.f47302d[index];
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.f2
    public boolean f() {
        return this.f47302d.length == 0;
    }

    @NotNull
    public final c2[] i() {
        return this.f47302d;
    }

    @NotNull
    public final kotlin.reflect.jvm.internal.impl.descriptors.j1[] j() {
        return this.f47301c;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public o0(@NotNull List<? extends kotlin.reflect.jvm.internal.impl.descriptors.j1> parameters, @NotNull List<? extends c2> argumentsList) {
        this((kotlin.reflect.jvm.internal.impl.descriptors.j1[]) parameters.toArray(new kotlin.reflect.jvm.internal.impl.descriptors.j1[0]), (c2[]) argumentsList.toArray(new c2[0]), false, 4, null);
        kotlin.jvm.internal.g0.p(parameters, "parameters");
        kotlin.jvm.internal.g0.p(argumentsList, "argumentsList");
    }
}
