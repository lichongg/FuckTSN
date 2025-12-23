package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import kotlin.reflect.jvm.internal.impl.types.f2;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public abstract class z implements kotlin.reflect.jvm.internal.impl.descriptors.d {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f44926a = new a(null);

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.v vVar) {
            this();
        }

        private a() {
        }

        @NotNull
        public final kotlin.reflect.jvm.internal.impl.resolve.scopes.k a(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.d dVar, @NotNull f2 typeSubstitution, @NotNull kotlin.reflect.jvm.internal.impl.types.checker.g kotlinTypeRefiner) {
            kotlin.reflect.jvm.internal.impl.resolve.scopes.k T;
            kotlin.jvm.internal.g0.p(dVar, "<this>");
            kotlin.jvm.internal.g0.p(typeSubstitution, "typeSubstitution");
            kotlin.jvm.internal.g0.p(kotlinTypeRefiner, "kotlinTypeRefiner");
            z zVar = dVar instanceof z ? (z) dVar : null;
            if (zVar != null && (T = zVar.T(typeSubstitution, kotlinTypeRefiner)) != null) {
                return T;
            }
            kotlin.reflect.jvm.internal.impl.resolve.scopes.k v02 = dVar.v0(typeSubstitution);
            kotlin.jvm.internal.g0.o(v02, "getMemberScope(...)");
            return v02;
        }

        @NotNull
        public final kotlin.reflect.jvm.internal.impl.resolve.scopes.k b(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.d dVar, @NotNull kotlin.reflect.jvm.internal.impl.types.checker.g kotlinTypeRefiner) {
            kotlin.reflect.jvm.internal.impl.resolve.scopes.k o02;
            kotlin.jvm.internal.g0.p(dVar, "<this>");
            kotlin.jvm.internal.g0.p(kotlinTypeRefiner, "kotlinTypeRefiner");
            z zVar = dVar instanceof z ? (z) dVar : null;
            if (zVar != null && (o02 = zVar.o0(kotlinTypeRefiner)) != null) {
                return o02;
            }
            kotlin.reflect.jvm.internal.impl.resolve.scopes.k H = dVar.H();
            kotlin.jvm.internal.g0.o(H, "getUnsubstitutedMemberScope(...)");
            return H;
        }
    }

    @NotNull
    protected abstract kotlin.reflect.jvm.internal.impl.resolve.scopes.k T(@NotNull f2 f2Var, @NotNull kotlin.reflect.jvm.internal.impl.types.checker.g gVar);

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d, kotlin.reflect.jvm.internal.impl.descriptors.k
    @NotNull
    public /* bridge */ /* synthetic */ kotlin.reflect.jvm.internal.impl.descriptors.f a() {
        return a();
    }

    @NotNull
    protected abstract kotlin.reflect.jvm.internal.impl.resolve.scopes.k o0(@NotNull kotlin.reflect.jvm.internal.impl.types.checker.g gVar);

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.k
    @NotNull
    public /* bridge */ /* synthetic */ kotlin.reflect.jvm.internal.impl.descriptors.k a() {
        return a();
    }
}
