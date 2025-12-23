package kotlin.reflect.jvm.internal.impl.builtins.functions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.u1;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.reflect.jvm.internal.impl.builtins.functions.f;
import kotlin.reflect.jvm.internal.impl.builtins.h;
import kotlin.reflect.jvm.internal.impl.descriptors.f0;
import kotlin.reflect.jvm.internal.impl.descriptors.l0;
import kotlin.reflect.jvm.internal.impl.storage.n;
import kotlin.text.u;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nBuiltInFictitiousFunctionClassFactory.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BuiltInFictitiousFunctionClassFactory.kt\norg/jetbrains/kotlin/builtins/functions/BuiltInFictitiousFunctionClassFactory\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,70:1\n808#2,11:71\n808#2,11:82\n*S KotlinDebug\n*F\n+ 1 BuiltInFictitiousFunctionClassFactory.kt\norg/jetbrains/kotlin/builtins/functions/BuiltInFictitiousFunctionClassFactory\n*L\n55#1:71,11\n59#1:82,11\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class a implements r3.b {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final n f44405a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private final f0 f44406b;

    public a(@NotNull n storageManager, @NotNull f0 module) {
        g0.p(storageManager, "storageManager");
        g0.p(module, "module");
        this.f44405a = storageManager;
        this.f44406b = module;
    }

    @Override // r3.b
    public boolean a(@NotNull kotlin.reflect.jvm.internal.impl.name.c packageFqName, @NotNull kotlin.reflect.jvm.internal.impl.name.f name) {
        g0.p(packageFqName, "packageFqName");
        g0.p(name, "name");
        String b6 = name.b();
        g0.o(b6, "asString(...)");
        return (u.H2(b6, "Function", false, 2, null) || u.H2(b6, "KFunction", false, 2, null) || u.H2(b6, "SuspendFunction", false, 2, null) || u.H2(b6, "KSuspendFunction", false, 2, null)) && f.f44428c.a().c(packageFqName, b6) != null;
    }

    @Override // r3.b
    @Nullable
    public kotlin.reflect.jvm.internal.impl.descriptors.d b(@NotNull kotlin.reflect.jvm.internal.impl.name.b classId) {
        kotlin.reflect.jvm.internal.impl.name.c f6;
        f.b c6;
        g0.p(classId, "classId");
        if (classId.i() || classId.j()) {
            return null;
        }
        String a6 = classId.g().a();
        if (!u.l3(a6, "Function", false, 2, null) || (c6 = f.f44428c.a().c((f6 = classId.f()), a6)) == null) {
            return null;
        }
        e a7 = c6.a();
        int b6 = c6.b();
        List<l0> L = this.f44406b.M(f6).L();
        ArrayList arrayList = new ArrayList();
        for (Object obj : L) {
            if (obj instanceof kotlin.reflect.jvm.internal.impl.builtins.c) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj2 : arrayList) {
            if (obj2 instanceof h) {
                arrayList2.add(obj2);
            }
        }
        l0 l0Var = (h) kotlin.collections.f0.L2(arrayList2);
        if (l0Var == null) {
            l0Var = (kotlin.reflect.jvm.internal.impl.builtins.c) kotlin.collections.f0.G2(arrayList);
        }
        return new b(this.f44405a, l0Var, a7, b6);
    }

    @Override // r3.b
    @NotNull
    public Collection<kotlin.reflect.jvm.internal.impl.descriptors.d> c(@NotNull kotlin.reflect.jvm.internal.impl.name.c packageFqName) {
        g0.p(packageFqName, "packageFqName");
        return u1.k();
    }
}
