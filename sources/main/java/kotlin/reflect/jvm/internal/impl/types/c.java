package kotlin.reflect.jvm.internal.impl.types;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Set;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.types.TypeCheckerState;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nAbstractTypeChecker.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AbstractTypeChecker.kt\norg/jetbrains/kotlin/types/AbstractNullabilityChecker\n+ 2 AbstractTypeChecker.kt\norg/jetbrains/kotlin/types/TypeCheckerState\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,884:1\n140#2,13:885\n153#2,13:899\n140#2,13:912\n153#2,13:926\n1#3:898\n1#3:925\n*S KotlinDebug\n*F\n+ 1 AbstractTypeChecker.kt\norg/jetbrains/kotlin/types/AbstractNullabilityChecker\n*L\n828#1:885,13\n828#1:899,13\n842#1:912,13\n842#1:926,13\n828#1:898\n842#1:925\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f47154a = new c();

    public final boolean a(@NotNull TypeCheckerState typeCheckerState, @NotNull e4.h type, @NotNull TypeCheckerState.b supertypesPolicy) {
        kotlin.jvm.internal.g0.p(typeCheckerState, "<this>");
        kotlin.jvm.internal.g0.p(type, "type");
        kotlin.jvm.internal.g0.p(supertypesPolicy, "supertypesPolicy");
        e4.r j6 = typeCheckerState.j();
        if ((j6.J(type) && !j6.B0(type)) || j6.H(type)) {
            return true;
        }
        typeCheckerState.k();
        ArrayDeque<e4.h> h6 = typeCheckerState.h();
        kotlin.jvm.internal.g0.m(h6);
        Set<e4.h> i6 = typeCheckerState.i();
        kotlin.jvm.internal.g0.m(i6);
        h6.push(type);
        while (!h6.isEmpty()) {
            e4.h pop = h6.pop();
            kotlin.jvm.internal.g0.m(pop);
            if (i6.add(pop)) {
                TypeCheckerState.b bVar = j6.B0(pop) ? TypeCheckerState.b.c.f47140a : supertypesPolicy;
                if (kotlin.jvm.internal.g0.g(bVar, TypeCheckerState.b.c.f47140a)) {
                    bVar = null;
                }
                if (bVar == null) {
                    continue;
                } else {
                    e4.r j7 = typeCheckerState.j();
                    Iterator<e4.g> it = j7.B(j7.c(pop)).iterator();
                    while (it.hasNext()) {
                        e4.h a6 = bVar.a(typeCheckerState, it.next());
                        if ((j6.J(a6) && !j6.B0(a6)) || j6.H(a6)) {
                            typeCheckerState.e();
                            return true;
                        }
                        h6.add(a6);
                    }
                }
            }
        }
        typeCheckerState.e();
        return false;
    }

    public final boolean b(@NotNull TypeCheckerState state, @NotNull e4.h start, @NotNull e4.o end) {
        kotlin.jvm.internal.g0.p(state, "state");
        kotlin.jvm.internal.g0.p(start, "start");
        kotlin.jvm.internal.g0.p(end, "end");
        e4.r j6 = state.j();
        if (f47154a.c(state, start, end)) {
            return true;
        }
        state.k();
        ArrayDeque<e4.h> h6 = state.h();
        kotlin.jvm.internal.g0.m(h6);
        Set<e4.h> i6 = state.i();
        kotlin.jvm.internal.g0.m(i6);
        h6.push(start);
        while (!h6.isEmpty()) {
            e4.h pop = h6.pop();
            kotlin.jvm.internal.g0.m(pop);
            if (i6.add(pop)) {
                TypeCheckerState.b bVar = j6.B0(pop) ? TypeCheckerState.b.c.f47140a : TypeCheckerState.b.C0920b.f47139a;
                if (kotlin.jvm.internal.g0.g(bVar, TypeCheckerState.b.c.f47140a)) {
                    bVar = null;
                }
                if (bVar == null) {
                    continue;
                } else {
                    e4.r j7 = state.j();
                    Iterator<e4.g> it = j7.B(j7.c(pop)).iterator();
                    while (it.hasNext()) {
                        e4.h a6 = bVar.a(state, it.next());
                        if (f47154a.c(state, a6, end)) {
                            state.e();
                            return true;
                        }
                        h6.add(a6);
                    }
                }
            }
        }
        state.e();
        return false;
    }

    public final boolean d(@NotNull TypeCheckerState state, @NotNull e4.h subType, @NotNull e4.h superType) {
        kotlin.jvm.internal.g0.p(state, "state");
        kotlin.jvm.internal.g0.p(subType, "subType");
        kotlin.jvm.internal.g0.p(superType, "superType");
        return e(state, subType, superType);
    }

    private c() {
    }

    private final boolean c(TypeCheckerState typeCheckerState, e4.h hVar, e4.o oVar) {
        e4.r j6 = typeCheckerState.j();
        if (j6.s0(hVar)) {
            return true;
        }
        if (j6.B0(hVar)) {
            return false;
        }
        if (typeCheckerState.o() && j6.A(hVar)) {
            return true;
        }
        return j6.q0(j6.c(hVar), oVar);
    }

    private final boolean e(TypeCheckerState typeCheckerState, e4.h hVar, e4.h hVar2) {
        e4.r j6 = typeCheckerState.j();
        if (h.f47258b) {
            if (!j6.b(hVar) && !j6.h0(j6.c(hVar))) {
                typeCheckerState.l(hVar);
            }
            if (!j6.b(hVar2)) {
                typeCheckerState.l(hVar2);
            }
        }
        if (j6.B0(hVar2) || j6.H(hVar) || j6.u0(hVar)) {
            return true;
        }
        if ((hVar instanceof e4.b) && j6.i0((e4.b) hVar)) {
            return true;
        }
        c cVar = f47154a;
        if (cVar.a(typeCheckerState, hVar, TypeCheckerState.b.C0920b.f47139a)) {
            return true;
        }
        if (j6.H(hVar2) || cVar.a(typeCheckerState, hVar2, TypeCheckerState.b.d.f47141a) || j6.J(hVar)) {
            return false;
        }
        return cVar.b(typeCheckerState, hVar, j6.c(hVar2));
    }
}
