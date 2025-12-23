package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import com.tencent.open.SocialConstants;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.d1;
import kotlin.reflect.jvm.internal.impl.descriptors.j1;
import kotlin.reflect.jvm.internal.impl.descriptors.o1;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.k;
import kotlin.reflect.jvm.internal.impl.types.e1;
import kotlin.reflect.jvm.internal.impl.types.w1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public class q extends j {

    /* renamed from: n, reason: collision with root package name */
    static final /* synthetic */ boolean f44818n = false;

    /* renamed from: j, reason: collision with root package name */
    private final w1 f44819j;

    /* renamed from: k, reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.resolve.scopes.k f44820k;

    /* renamed from: l, reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.storage.i<Set<kotlin.reflect.jvm.internal.impl.name.f>> f44821l;

    /* renamed from: m, reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.descriptors.annotations.g f44822m;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private class a extends kotlin.reflect.jvm.internal.impl.resolve.scopes.l {

        /* renamed from: f, reason: collision with root package name */
        static final /* synthetic */ boolean f44823f = false;

        /* renamed from: b, reason: collision with root package name */
        private final kotlin.reflect.jvm.internal.impl.storage.g<kotlin.reflect.jvm.internal.impl.name.f, Collection<? extends d1>> f44824b;

        /* renamed from: c, reason: collision with root package name */
        private final kotlin.reflect.jvm.internal.impl.storage.g<kotlin.reflect.jvm.internal.impl.name.f, Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.w0>> f44825c;

        /* renamed from: d, reason: collision with root package name */
        private final kotlin.reflect.jvm.internal.impl.storage.i<Collection<kotlin.reflect.jvm.internal.impl.descriptors.k>> f44826d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ q f44827e;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        /* renamed from: kotlin.reflect.jvm.internal.impl.descriptors.impl.q$a$a, reason: collision with other inner class name */
        class C0880a implements Function1<kotlin.reflect.jvm.internal.impl.name.f, Collection<? extends d1>> {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ q f44828a;

            C0880a(q qVar) {
                this.f44828a = qVar;
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Collection<? extends d1> invoke(kotlin.reflect.jvm.internal.impl.name.f fVar) {
                return a.this.n(fVar);
            }
        }

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        class b implements Function1<kotlin.reflect.jvm.internal.impl.name.f, Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.w0>> {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ q f44830a;

            b(q qVar) {
                this.f44830a = qVar;
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.w0> invoke(kotlin.reflect.jvm.internal.impl.name.f fVar) {
                return a.this.o(fVar);
            }
        }

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        class c implements Function0<Collection<kotlin.reflect.jvm.internal.impl.descriptors.k>> {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ q f44832a;

            c(q qVar) {
                this.f44832a = qVar;
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Collection<kotlin.reflect.jvm.internal.impl.descriptors.k> invoke() {
                return a.this.m();
            }
        }

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        class d extends kotlin.reflect.jvm.internal.impl.resolve.l {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ Set f44834a;

            private static /* synthetic */ void f(int i6) {
                Object[] objArr = new Object[3];
                if (i6 == 1) {
                    objArr[0] = "fromSuper";
                } else if (i6 != 2) {
                    objArr[0] = "fakeOverride";
                } else {
                    objArr[0] = "fromCurrent";
                }
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/EnumEntrySyntheticClassDescriptor$EnumEntryScope$4";
                if (i6 == 1 || i6 == 2) {
                    objArr[2] = "conflict";
                } else {
                    objArr[2] = "addFakeOverride";
                }
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
            }

            d(Set set) {
                this.f44834a = set;
            }

            @Override // kotlin.reflect.jvm.internal.impl.resolve.m
            public void a(@NotNull CallableMemberDescriptor callableMemberDescriptor) {
                if (callableMemberDescriptor == null) {
                    f(0);
                }
                OverridingUtil.K(callableMemberDescriptor, null);
                this.f44834a.add(callableMemberDescriptor);
            }

            @Override // kotlin.reflect.jvm.internal.impl.resolve.l
            protected void e(@NotNull CallableMemberDescriptor callableMemberDescriptor, @NotNull CallableMemberDescriptor callableMemberDescriptor2) {
                if (callableMemberDescriptor == null) {
                    f(1);
                }
                if (callableMemberDescriptor2 == null) {
                    f(2);
                }
            }
        }

        public a(@NotNull q qVar, kotlin.reflect.jvm.internal.impl.storage.n nVar) {
            if (nVar == null) {
                i(0);
            }
            this.f44827e = qVar;
            this.f44824b = nVar.i(new C0880a(qVar));
            this.f44825c = nVar.i(new b(qVar));
            this.f44826d = nVar.e(new c(qVar));
        }

        /* JADX WARN: Removed duplicated region for block: B:14:0x0022  */
        /* JADX WARN: Removed duplicated region for block: B:17:0x002d  */
        /* JADX WARN: Removed duplicated region for block: B:20:0x005d  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x0090  */
        /* JADX WARN: Removed duplicated region for block: B:27:0x0095  */
        /* JADX WARN: Removed duplicated region for block: B:28:0x009a  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x009d  */
        /* JADX WARN: Removed duplicated region for block: B:30:0x00a0  */
        /* JADX WARN: Removed duplicated region for block: B:31:0x00a5  */
        /* JADX WARN: Removed duplicated region for block: B:32:0x00a8  */
        /* JADX WARN: Removed duplicated region for block: B:33:0x00ad  */
        /* JADX WARN: Removed duplicated region for block: B:36:0x00b5 A[ADDED_TO_REGION] */
        /* JADX WARN: Removed duplicated region for block: B:40:0x00be  */
        /* JADX WARN: Removed duplicated region for block: B:53:0x008b  */
        /* JADX WARN: Removed duplicated region for block: B:54:0x0032  */
        /* JADX WARN: Removed duplicated region for block: B:55:0x0037  */
        /* JADX WARN: Removed duplicated region for block: B:56:0x003c  */
        /* JADX WARN: Removed duplicated region for block: B:57:0x0041  */
        /* JADX WARN: Removed duplicated region for block: B:58:0x0046  */
        /* JADX WARN: Removed duplicated region for block: B:59:0x0049  */
        /* JADX WARN: Removed duplicated region for block: B:60:0x004e  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private static /* synthetic */ void i(int r13) {
            /*
                Method dump skipped, instructions count: 346
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.descriptors.impl.q.a.i(int):void");
        }

        /* JADX INFO: Access modifiers changed from: private */
        @NotNull
        public Collection<kotlin.reflect.jvm.internal.impl.descriptors.k> m() {
            HashSet hashSet = new HashSet();
            for (kotlin.reflect.jvm.internal.impl.name.f fVar : (Set) this.f44827e.f44821l.invoke()) {
                NoLookupLocation noLookupLocation = NoLookupLocation.FOR_NON_TRACKED_SCOPE;
                hashSet.addAll(a(fVar, noLookupLocation));
                hashSet.addAll(c(fVar, noLookupLocation));
            }
            return hashSet;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @NotNull
        public Collection<? extends d1> n(@NotNull kotlin.reflect.jvm.internal.impl.name.f fVar) {
            if (fVar == null) {
                i(8);
            }
            return q(fVar, p().a(fVar, NoLookupLocation.FOR_NON_TRACKED_SCOPE));
        }

        /* JADX INFO: Access modifiers changed from: private */
        @NotNull
        public Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.w0> o(@NotNull kotlin.reflect.jvm.internal.impl.name.f fVar) {
            if (fVar == null) {
                i(4);
            }
            return q(fVar, p().c(fVar, NoLookupLocation.FOR_NON_TRACKED_SCOPE));
        }

        @NotNull
        private kotlin.reflect.jvm.internal.impl.resolve.scopes.k p() {
            kotlin.reflect.jvm.internal.impl.resolve.scopes.k r5 = this.f44827e.o().i().iterator().next().r();
            if (r5 == null) {
                i(9);
            }
            return r5;
        }

        @NotNull
        private <D extends CallableMemberDescriptor> Collection<? extends D> q(@NotNull kotlin.reflect.jvm.internal.impl.name.f fVar, @NotNull Collection<? extends D> collection) {
            if (fVar == null) {
                i(10);
            }
            if (collection == null) {
                i(11);
            }
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            OverridingUtil.f46633f.v(fVar, collection, Collections.EMPTY_SET, this.f44827e, new d(linkedHashSet));
            return linkedHashSet;
        }

        @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.l, kotlin.reflect.jvm.internal.impl.resolve.scopes.k, kotlin.reflect.jvm.internal.impl.resolve.scopes.n
        @NotNull
        public Collection<? extends d1> a(@NotNull kotlin.reflect.jvm.internal.impl.name.f fVar, @NotNull u3.b bVar) {
            if (fVar == null) {
                i(5);
            }
            if (bVar == null) {
                i(6);
            }
            Collection<? extends d1> invoke = this.f44824b.invoke(fVar);
            if (invoke == null) {
                i(7);
            }
            return invoke;
        }

        @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.l, kotlin.reflect.jvm.internal.impl.resolve.scopes.k
        @NotNull
        public Set<kotlin.reflect.jvm.internal.impl.name.f> b() {
            Set<kotlin.reflect.jvm.internal.impl.name.f> set = (Set) this.f44827e.f44821l.invoke();
            if (set == null) {
                i(17);
            }
            return set;
        }

        @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.l, kotlin.reflect.jvm.internal.impl.resolve.scopes.k
        @NotNull
        public Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.w0> c(@NotNull kotlin.reflect.jvm.internal.impl.name.f fVar, @NotNull u3.b bVar) {
            if (fVar == null) {
                i(1);
            }
            if (bVar == null) {
                i(2);
            }
            Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.w0> invoke = this.f44825c.invoke(fVar);
            if (invoke == null) {
                i(3);
            }
            return invoke;
        }

        @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.l, kotlin.reflect.jvm.internal.impl.resolve.scopes.k
        @NotNull
        public Set<kotlin.reflect.jvm.internal.impl.name.f> d() {
            Set<kotlin.reflect.jvm.internal.impl.name.f> set = (Set) this.f44827e.f44821l.invoke();
            if (set == null) {
                i(19);
            }
            return set;
        }

        @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.l, kotlin.reflect.jvm.internal.impl.resolve.scopes.k
        @NotNull
        public Set<kotlin.reflect.jvm.internal.impl.name.f> f() {
            Set<kotlin.reflect.jvm.internal.impl.name.f> set = Collections.EMPTY_SET;
            if (set == null) {
                i(18);
            }
            return set;
        }

        @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.l, kotlin.reflect.jvm.internal.impl.resolve.scopes.n
        @NotNull
        public Collection<kotlin.reflect.jvm.internal.impl.descriptors.k> h(@NotNull kotlin.reflect.jvm.internal.impl.resolve.scopes.d dVar, @NotNull Function1<? super kotlin.reflect.jvm.internal.impl.name.f, Boolean> function1) {
            if (dVar == null) {
                i(13);
            }
            if (function1 == null) {
                i(14);
            }
            Collection<kotlin.reflect.jvm.internal.impl.descriptors.k> invoke = this.f44826d.invoke();
            if (invoke == null) {
                i(15);
            }
            return invoke;
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d
    @Nullable
    public o1<e1> g0() {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.c0
    public boolean i0() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d
    public boolean isInline() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.g
    public boolean k() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d
    public boolean l0() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.c0
    public boolean q0() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d
    @Nullable
    public kotlin.reflect.jvm.internal.impl.descriptors.d s0() {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d
    public boolean u() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d
    public boolean v() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d
    public boolean w() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d
    @Nullable
    public kotlin.reflect.jvm.internal.impl.descriptors.c z() {
        return null;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    private q(@NotNull kotlin.reflect.jvm.internal.impl.storage.n nVar, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.d dVar, @NotNull kotlin.reflect.jvm.internal.impl.types.t0 t0Var, @NotNull kotlin.reflect.jvm.internal.impl.name.f fVar, @NotNull kotlin.reflect.jvm.internal.impl.storage.i<Set<kotlin.reflect.jvm.internal.impl.name.f>> iVar, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.e1 e1Var) {
        super(nVar, dVar, fVar, e1Var, false);
        if (nVar == null) {
            p0(6);
        }
        if (dVar == null) {
            p0(7);
        }
        if (t0Var == null) {
            p0(8);
        }
        if (fVar == null) {
            p0(9);
        }
        if (iVar == null) {
            p0(10);
        }
        if (gVar == null) {
            p0(11);
        }
        if (e1Var == null) {
            p0(12);
        }
        this.f44822m = gVar;
        this.f44819j = new kotlin.reflect.jvm.internal.impl.types.v(this, Collections.EMPTY_LIST, Collections.singleton(t0Var), nVar);
        this.f44820k = new a(this, nVar);
        this.f44821l = iVar;
    }

    @NotNull
    public static q G0(@NotNull kotlin.reflect.jvm.internal.impl.storage.n nVar, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.d dVar, @NotNull kotlin.reflect.jvm.internal.impl.name.f fVar, @NotNull kotlin.reflect.jvm.internal.impl.storage.i<Set<kotlin.reflect.jvm.internal.impl.name.f>> iVar, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.e1 e1Var) {
        if (nVar == null) {
            p0(0);
        }
        if (dVar == null) {
            p0(1);
        }
        if (fVar == null) {
            p0(2);
        }
        if (iVar == null) {
            p0(3);
        }
        if (gVar == null) {
            p0(4);
        }
        if (e1Var == null) {
            p0(5);
        }
        return new q(nVar, dVar, dVar.s(), fVar, iVar, gVar, e1Var);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d
    @NotNull
    public Collection<kotlin.reflect.jvm.internal.impl.descriptors.c> f() {
        List list = Collections.EMPTY_LIST;
        if (list == null) {
            p0(16);
        }
        return list;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.a
    @NotNull
    public kotlin.reflect.jvm.internal.impl.descriptors.annotations.g getAnnotations() {
        kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar = this.f44822m;
        if (gVar == null) {
            p0(21);
        }
        return gVar;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d, kotlin.reflect.jvm.internal.impl.descriptors.c0, kotlin.reflect.jvm.internal.impl.descriptors.o
    @NotNull
    public kotlin.reflect.jvm.internal.impl.descriptors.s getVisibility() {
        kotlin.reflect.jvm.internal.impl.descriptors.s sVar = kotlin.reflect.jvm.internal.impl.descriptors.r.f44948e;
        if (sVar == null) {
            p0(20);
        }
        return sVar;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d
    @NotNull
    public ClassKind h() {
        ClassKind classKind = ClassKind.ENUM_ENTRY;
        if (classKind == null) {
            p0(18);
        }
        return classKind;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d, kotlin.reflect.jvm.internal.impl.descriptors.c0
    @NotNull
    public Modality i() {
        Modality modality = Modality.FINAL;
        if (modality == null) {
            p0(19);
        }
        return modality;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.f
    @NotNull
    public w1 o() {
        w1 w1Var = this.f44819j;
        if (w1Var == null) {
            p0(17);
        }
        return w1Var;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.z
    @NotNull
    public kotlin.reflect.jvm.internal.impl.resolve.scopes.k o0(@NotNull kotlin.reflect.jvm.internal.impl.types.checker.g gVar) {
        if (gVar == null) {
            p0(13);
        }
        kotlin.reflect.jvm.internal.impl.resolve.scopes.k kVar = this.f44820k;
        if (kVar == null) {
            p0(14);
        }
        return kVar;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d
    @NotNull
    public kotlin.reflect.jvm.internal.impl.resolve.scopes.k r0() {
        k.c cVar = k.c.f46780b;
        if (cVar == null) {
            p0(15);
        }
        return cVar;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d, kotlin.reflect.jvm.internal.impl.descriptors.g
    @NotNull
    public List<j1> t() {
        List<j1> list = Collections.EMPTY_LIST;
        if (list == null) {
            p0(22);
        }
        return list;
    }

    public String toString() {
        return "enum entry " + getName();
    }

    private static /* synthetic */ void p0(int i6) {
        String str;
        int i7;
        switch (i6) {
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
                str = "@NotNull method %s.%s must not return null";
                break;
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i6) {
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
                i7 = 2;
                break;
            default:
                i7 = 3;
                break;
        }
        Object[] objArr = new Object[i7];
        switch (i6) {
            case 1:
                objArr[0] = "enumClass";
                break;
            case 2:
            case 9:
                objArr[0] = CommonNetImpl.NAME;
                break;
            case 3:
            case 10:
                objArr[0] = "enumMemberNames";
                break;
            case 4:
            case 11:
                objArr[0] = "annotations";
                break;
            case 5:
            case 12:
                objArr[0] = SocialConstants.PARAM_SOURCE;
                break;
            case 6:
            default:
                objArr[0] = "storageManager";
                break;
            case 7:
                objArr[0] = "containingClass";
                break;
            case 8:
                objArr[0] = "supertype";
                break;
            case 13:
                objArr[0] = "kotlinTypeRefiner";
                break;
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/EnumEntrySyntheticClassDescriptor";
                break;
        }
        switch (i6) {
            case 14:
                objArr[1] = "getUnsubstitutedMemberScope";
                break;
            case 15:
                objArr[1] = "getStaticScope";
                break;
            case 16:
                objArr[1] = "getConstructors";
                break;
            case 17:
                objArr[1] = "getTypeConstructor";
                break;
            case 18:
                objArr[1] = "getKind";
                break;
            case 19:
                objArr[1] = "getModality";
                break;
            case 20:
                objArr[1] = "getVisibility";
                break;
            case 21:
                objArr[1] = "getAnnotations";
                break;
            case 22:
                objArr[1] = "getDeclaredTypeParameters";
                break;
            case 23:
                objArr[1] = "getSealedSubclasses";
                break;
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/EnumEntrySyntheticClassDescriptor";
                break;
        }
        switch (i6) {
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
                objArr[2] = "<init>";
                break;
            case 13:
                objArr[2] = "getUnsubstitutedMemberScope";
                break;
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
                break;
            default:
                objArr[2] = "create";
                break;
        }
        String format = String.format(str, objArr);
        switch (i6) {
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
                throw new IllegalStateException(format);
            default:
                throw new IllegalArgumentException(format);
        }
    }
}
