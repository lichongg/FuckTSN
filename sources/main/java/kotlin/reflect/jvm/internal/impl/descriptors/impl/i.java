package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.e1;
import kotlin.reflect.jvm.internal.impl.descriptors.j1;
import kotlin.reflect.jvm.internal.impl.descriptors.q1;
import kotlin.reflect.jvm.internal.impl.descriptors.z0;
import kotlin.reflect.jvm.internal.impl.types.h2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public class i extends s implements kotlin.reflect.jvm.internal.impl.descriptors.c {
    static final /* synthetic */ boolean F = false;
    protected final boolean E;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    protected i(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.d dVar, @Nullable kotlin.reflect.jvm.internal.impl.descriptors.j jVar, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar, boolean z5, @NotNull CallableMemberDescriptor.Kind kind, @NotNull e1 e1Var) {
        super(dVar, jVar, gVar, kotlin.reflect.jvm.internal.impl.name.h.f46364j, kind, e1Var);
        if (dVar == null) {
            T(0);
        }
        if (gVar == null) {
            T(1);
        }
        if (kind == null) {
            T(2);
        }
        if (e1Var == null) {
            T(3);
        }
        this.E = z5;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0018  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00aa A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0053  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static /* synthetic */ void T(int r8) {
        /*
            Method dump skipped, instructions count: 354
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.descriptors.impl.i.T(int):void");
    }

    @NotNull
    public static i i1(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.d dVar, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar, boolean z5, @NotNull e1 e1Var) {
        if (dVar == null) {
            T(4);
        }
        if (gVar == null) {
            T(5);
        }
        if (e1Var == null) {
            T(6);
        }
        return new i(dVar, null, gVar, z5, CallableMemberDescriptor.Kind.DECLARATION, e1Var);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.s, kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor
    public void R(@NotNull Collection<? extends CallableMemberDescriptor> collection) {
        if (collection == null) {
            T(22);
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.s, kotlin.reflect.jvm.internal.impl.descriptors.y, kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.a
    @NotNull
    public Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.y> e() {
        Set set = Collections.EMPTY_SET;
        if (set == null) {
            T(21);
        }
        return set;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.s
    @NotNull
    /* renamed from: j1, reason: merged with bridge method [inline-methods] */
    public i G0(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.k kVar, @Nullable kotlin.reflect.jvm.internal.impl.descriptors.y yVar, @NotNull CallableMemberDescriptor.Kind kind, @Nullable kotlin.reflect.jvm.internal.impl.name.f fVar, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar, @NotNull e1 e1Var) {
        if (kVar == null) {
            T(23);
        }
        if (kind == null) {
            T(24);
        }
        if (gVar == null) {
            T(25);
        }
        if (e1Var == null) {
            T(26);
        }
        CallableMemberDescriptor.Kind kind2 = CallableMemberDescriptor.Kind.DECLARATION;
        if (kind == kind2 || kind == CallableMemberDescriptor.Kind.SYNTHESIZED) {
            return new i((kotlin.reflect.jvm.internal.impl.descriptors.d) kVar, this, gVar, this.E, kind2, e1Var);
        }
        throw new IllegalStateException("Attempt at creating a constructor that is not a declaration: \ncopy from: " + this + "\nnewOwner: " + kVar + "\nkind: " + kind);
    }

    public i l1(@NotNull List<q1> list, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.s sVar) {
        if (list == null) {
            T(13);
        }
        if (sVar == null) {
            T(14);
        }
        m1(list, sVar, b().t());
        return this;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j
    public boolean m0() {
        return this.E;
    }

    public i m1(@NotNull List<q1> list, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.s sVar, @NotNull List<j1> list2) {
        if (list == null) {
            T(10);
        }
        if (sVar == null) {
            T(11);
        }
        if (list2 == null) {
            T(12);
        }
        super.M0(null, g1(), f1(), list2, list, null, Modality.FINAL, sVar);
        return this;
    }

    @NotNull
    private List<z0> f1() {
        kotlin.reflect.jvm.internal.impl.descriptors.d b6 = b();
        if (!b6.j0().isEmpty()) {
            List<z0> j02 = b6.j0();
            if (j02 == null) {
                T(15);
            }
            return j02;
        }
        List<z0> list = Collections.EMPTY_LIST;
        if (list == null) {
            T(16);
        }
        return list;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j
    @NotNull
    public kotlin.reflect.jvm.internal.impl.descriptors.d J() {
        kotlin.reflect.jvm.internal.impl.descriptors.d b6 = b();
        if (b6 == null) {
            T(18);
        }
        return b6;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.s, kotlin.reflect.jvm.internal.impl.descriptors.k
    public <R, D> R W(kotlin.reflect.jvm.internal.impl.descriptors.m<R, D> mVar, D d6) {
        return mVar.f(this, d6);
    }

    @Nullable
    public z0 g1() {
        kotlin.reflect.jvm.internal.impl.descriptors.d b6 = b();
        if (b6.k()) {
            kotlin.reflect.jvm.internal.impl.descriptors.k b7 = b6.b();
            if (b7 instanceof kotlin.reflect.jvm.internal.impl.descriptors.d) {
                return ((kotlin.reflect.jvm.internal.impl.descriptors.d) b7).V();
            }
            return null;
        }
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.s, kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor
    @NotNull
    /* renamed from: h1, reason: merged with bridge method [inline-methods] */
    public kotlin.reflect.jvm.internal.impl.descriptors.c e0(kotlin.reflect.jvm.internal.impl.descriptors.k kVar, Modality modality, kotlin.reflect.jvm.internal.impl.descriptors.s sVar, CallableMemberDescriptor.Kind kind, boolean z5) {
        kotlin.reflect.jvm.internal.impl.descriptors.c cVar = (kotlin.reflect.jvm.internal.impl.descriptors.c) super.e0(kVar, modality, sVar, kind, z5);
        if (cVar == null) {
            T(27);
        }
        return cVar;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.n, kotlin.reflect.jvm.internal.impl.descriptors.k
    @NotNull
    /* renamed from: k1, reason: merged with bridge method [inline-methods] */
    public kotlin.reflect.jvm.internal.impl.descriptors.d b() {
        kotlin.reflect.jvm.internal.impl.descriptors.d dVar = (kotlin.reflect.jvm.internal.impl.descriptors.d) super.b();
        if (dVar == null) {
            T(17);
        }
        return dVar;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.s, kotlin.reflect.jvm.internal.impl.descriptors.y, kotlin.reflect.jvm.internal.impl.descriptors.g1
    @Nullable
    public kotlin.reflect.jvm.internal.impl.descriptors.c c(@NotNull h2 h2Var) {
        if (h2Var == null) {
            T(20);
        }
        return (kotlin.reflect.jvm.internal.impl.descriptors.c) super.c(h2Var);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.s, kotlin.reflect.jvm.internal.impl.descriptors.impl.n
    @NotNull
    public kotlin.reflect.jvm.internal.impl.descriptors.c a() {
        kotlin.reflect.jvm.internal.impl.descriptors.c cVar = (kotlin.reflect.jvm.internal.impl.descriptors.c) super.a();
        if (cVar == null) {
            T(19);
        }
        return cVar;
    }
}
