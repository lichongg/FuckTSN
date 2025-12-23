package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import com.tencent.open.SocialConstants;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.a;
import kotlin.reflect.jvm.internal.impl.descriptors.e1;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.u0;
import kotlin.reflect.jvm.internal.impl.descriptors.j1;
import kotlin.reflect.jvm.internal.impl.descriptors.q1;
import kotlin.reflect.jvm.internal.impl.descriptors.s1;
import kotlin.reflect.jvm.internal.impl.descriptors.y;
import kotlin.reflect.jvm.internal.impl.descriptors.z0;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.f2;
import kotlin.reflect.jvm.internal.impl.types.h2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public abstract class s extends n implements kotlin.reflect.jvm.internal.impl.descriptors.y {
    private final kotlin.reflect.jvm.internal.impl.descriptors.y A;
    private final CallableMemberDescriptor.Kind B;

    @Nullable
    private kotlin.reflect.jvm.internal.impl.descriptors.y C;
    protected Map<a.InterfaceC0876a<?>, Object> D;

    /* renamed from: e, reason: collision with root package name */
    private List<j1> f44839e;

    /* renamed from: f, reason: collision with root package name */
    private List<q1> f44840f;

    /* renamed from: g, reason: collision with root package name */
    private kotlin.reflect.jvm.internal.impl.types.t0 f44841g;

    /* renamed from: h, reason: collision with root package name */
    private List<z0> f44842h;

    /* renamed from: i, reason: collision with root package name */
    private z0 f44843i;

    /* renamed from: j, reason: collision with root package name */
    private z0 f44844j;

    /* renamed from: k, reason: collision with root package name */
    private Modality f44845k;

    /* renamed from: l, reason: collision with root package name */
    private kotlin.reflect.jvm.internal.impl.descriptors.s f44846l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f44847m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f44848n;

    /* renamed from: o, reason: collision with root package name */
    private boolean f44849o;

    /* renamed from: p, reason: collision with root package name */
    private boolean f44850p;

    /* renamed from: q, reason: collision with root package name */
    private boolean f44851q;

    /* renamed from: r, reason: collision with root package name */
    private boolean f44852r;

    /* renamed from: s, reason: collision with root package name */
    private boolean f44853s;

    /* renamed from: t, reason: collision with root package name */
    private boolean f44854t;

    /* renamed from: u, reason: collision with root package name */
    private boolean f44855u;

    /* renamed from: v, reason: collision with root package name */
    private boolean f44856v;

    /* renamed from: w, reason: collision with root package name */
    private boolean f44857w;

    /* renamed from: x, reason: collision with root package name */
    private boolean f44858x;

    /* renamed from: y, reason: collision with root package name */
    private Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.y> f44859y;

    /* renamed from: z, reason: collision with root package name */
    private volatile Function0<Collection<kotlin.reflect.jvm.internal.impl.descriptors.y>> f44860z;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements Function0<Collection<kotlin.reflect.jvm.internal.impl.descriptors.y>> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ h2 f44861a;

        a(h2 h2Var) {
            this.f44861a = h2Var;
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Collection<kotlin.reflect.jvm.internal.impl.descriptors.y> invoke() {
            kotlin.reflect.jvm.internal.impl.utils.j jVar = new kotlin.reflect.jvm.internal.impl.utils.j();
            Iterator<? extends kotlin.reflect.jvm.internal.impl.descriptors.y> it = s.this.e().iterator();
            while (it.hasNext()) {
                jVar.add(it.next().c(this.f44861a));
            }
            return jVar;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class b implements Function0<List<s1>> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ List f44863a;

        b(List list) {
            this.f44863a = list;
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public List<s1> invoke() {
            return this.f44863a;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class c implements y.a<kotlin.reflect.jvm.internal.impl.descriptors.y> {

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        protected f2 f44864a;

        /* renamed from: b, reason: collision with root package name */
        @NotNull
        protected kotlin.reflect.jvm.internal.impl.descriptors.k f44865b;

        /* renamed from: c, reason: collision with root package name */
        @NotNull
        protected Modality f44866c;

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        protected kotlin.reflect.jvm.internal.impl.descriptors.s f44867d;

        /* renamed from: e, reason: collision with root package name */
        @Nullable
        protected kotlin.reflect.jvm.internal.impl.descriptors.y f44868e;

        /* renamed from: f, reason: collision with root package name */
        @NotNull
        protected CallableMemberDescriptor.Kind f44869f;

        /* renamed from: g, reason: collision with root package name */
        @NotNull
        protected List<q1> f44870g;

        /* renamed from: h, reason: collision with root package name */
        @NotNull
        protected List<z0> f44871h;

        /* renamed from: i, reason: collision with root package name */
        @Nullable
        protected z0 f44872i;

        /* renamed from: j, reason: collision with root package name */
        @Nullable
        protected z0 f44873j;

        /* renamed from: k, reason: collision with root package name */
        @NotNull
        protected kotlin.reflect.jvm.internal.impl.types.t0 f44874k;

        /* renamed from: l, reason: collision with root package name */
        @Nullable
        protected kotlin.reflect.jvm.internal.impl.name.f f44875l;

        /* renamed from: m, reason: collision with root package name */
        protected boolean f44876m;

        /* renamed from: n, reason: collision with root package name */
        protected boolean f44877n;

        /* renamed from: o, reason: collision with root package name */
        protected boolean f44878o;

        /* renamed from: p, reason: collision with root package name */
        protected boolean f44879p;

        /* renamed from: q, reason: collision with root package name */
        private boolean f44880q;

        /* renamed from: r, reason: collision with root package name */
        private List<j1> f44881r;

        /* renamed from: s, reason: collision with root package name */
        private kotlin.reflect.jvm.internal.impl.descriptors.annotations.g f44882s;

        /* renamed from: t, reason: collision with root package name */
        private boolean f44883t;

        /* renamed from: u, reason: collision with root package name */
        private Map<a.InterfaceC0876a<?>, Object> f44884u;

        /* renamed from: v, reason: collision with root package name */
        private Boolean f44885v;

        /* renamed from: w, reason: collision with root package name */
        protected boolean f44886w;

        /* renamed from: x, reason: collision with root package name */
        final /* synthetic */ s f44887x;

        public c(@NotNull s sVar, @NotNull f2 f2Var, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.k kVar, @NotNull Modality modality, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.s sVar2, @NotNull CallableMemberDescriptor.Kind kind, @NotNull List<q1> list, @Nullable List<z0> list2, @NotNull z0 z0Var, @Nullable kotlin.reflect.jvm.internal.impl.types.t0 t0Var, kotlin.reflect.jvm.internal.impl.name.f fVar) {
            if (f2Var == null) {
                u(0);
            }
            if (kVar == null) {
                u(1);
            }
            if (modality == null) {
                u(2);
            }
            if (sVar2 == null) {
                u(3);
            }
            if (kind == null) {
                u(4);
            }
            if (list == null) {
                u(5);
            }
            if (list2 == null) {
                u(6);
            }
            if (t0Var == null) {
                u(7);
            }
            this.f44887x = sVar;
            this.f44868e = null;
            this.f44873j = sVar.f44844j;
            this.f44876m = true;
            this.f44877n = false;
            this.f44878o = false;
            this.f44879p = false;
            this.f44880q = sVar.D0();
            this.f44881r = null;
            this.f44882s = null;
            this.f44883t = sVar.S();
            this.f44884u = new LinkedHashMap();
            this.f44885v = null;
            this.f44886w = false;
            this.f44864a = f2Var;
            this.f44865b = kVar;
            this.f44866c = modality;
            this.f44867d = sVar2;
            this.f44869f = kind;
            this.f44870g = list;
            this.f44871h = list2;
            this.f44872i = z0Var;
            this.f44874k = t0Var;
            this.f44875l = fVar;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.y.a
        @NotNull
        /* renamed from: E, reason: merged with bridge method [inline-methods] */
        public c m() {
            this.f44879p = true;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.y.a
        @NotNull
        /* renamed from: H, reason: merged with bridge method [inline-methods] */
        public c o() {
            this.f44883t = true;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.y.a
        @NotNull
        /* renamed from: I, reason: merged with bridge method [inline-methods] */
        public c e() {
            this.f44880q = true;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.y.a
        @NotNull
        /* renamed from: P, reason: merged with bridge method [inline-methods] */
        public c g() {
            this.f44878o = true;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.y.a
        @NotNull
        /* renamed from: R, reason: merged with bridge method [inline-methods] */
        public c t() {
            this.f44877n = true;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.y.a
        @NotNull
        /* renamed from: B, reason: merged with bridge method [inline-methods] */
        public c l(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar) {
            if (gVar == null) {
                u(35);
            }
            this.f44882s = gVar;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.y.a
        @NotNull
        /* renamed from: C, reason: merged with bridge method [inline-methods] */
        public c j(boolean z5) {
            this.f44876m = z5;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.y.a
        @NotNull
        /* renamed from: D, reason: merged with bridge method [inline-methods] */
        public c a(@Nullable z0 z0Var) {
            this.f44873j = z0Var;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.y.a
        @NotNull
        /* renamed from: F, reason: merged with bridge method [inline-methods] */
        public c b(@Nullable z0 z0Var) {
            this.f44872i = z0Var;
            return this;
        }

        @NotNull
        public c J(boolean z5) {
            this.f44886w = z5;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.y.a
        @NotNull
        /* renamed from: K, reason: merged with bridge method [inline-methods] */
        public c s(@NotNull CallableMemberDescriptor.Kind kind) {
            if (kind == null) {
                u(14);
            }
            this.f44869f = kind;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.y.a
        @NotNull
        /* renamed from: L, reason: merged with bridge method [inline-methods] */
        public c q(@NotNull Modality modality) {
            if (modality == null) {
                u(10);
            }
            this.f44866c = modality;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.y.a
        @NotNull
        /* renamed from: M, reason: merged with bridge method [inline-methods] */
        public c f(@NotNull kotlin.reflect.jvm.internal.impl.name.f fVar) {
            if (fVar == null) {
                u(17);
            }
            this.f44875l = fVar;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.y.a
        @NotNull
        /* renamed from: N, reason: merged with bridge method [inline-methods] */
        public c i(@Nullable CallableMemberDescriptor callableMemberDescriptor) {
            this.f44868e = (kotlin.reflect.jvm.internal.impl.descriptors.y) callableMemberDescriptor;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.y.a
        @NotNull
        /* renamed from: O, reason: merged with bridge method [inline-methods] */
        public c r(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.k kVar) {
            if (kVar == null) {
                u(8);
            }
            this.f44865b = kVar;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.y.a
        @NotNull
        /* renamed from: Q, reason: merged with bridge method [inline-methods] */
        public c h(@NotNull kotlin.reflect.jvm.internal.impl.types.t0 t0Var) {
            if (t0Var == null) {
                u(23);
            }
            this.f44874k = t0Var;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.y.a
        @NotNull
        /* renamed from: S, reason: merged with bridge method [inline-methods] */
        public c c(@NotNull f2 f2Var) {
            if (f2Var == null) {
                u(37);
            }
            this.f44864a = f2Var;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.y.a
        @NotNull
        /* renamed from: T, reason: merged with bridge method [inline-methods] */
        public c k(@NotNull List<j1> list) {
            if (list == null) {
                u(21);
            }
            this.f44881r = list;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.y.a
        @NotNull
        /* renamed from: U, reason: merged with bridge method [inline-methods] */
        public c n(@NotNull List<q1> list) {
            if (list == null) {
                u(19);
            }
            this.f44870g = list;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.y.a
        @NotNull
        /* renamed from: V, reason: merged with bridge method [inline-methods] */
        public c p(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.s sVar) {
            if (sVar == null) {
                u(12);
            }
            this.f44867d = sVar;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.y.a
        @Nullable
        public kotlin.reflect.jvm.internal.impl.descriptors.y build() {
            return this.f44887x.H0(this);
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.y.a
        @NotNull
        public <V> y.a<kotlin.reflect.jvm.internal.impl.descriptors.y> d(@NotNull a.InterfaceC0876a<V> interfaceC0876a, V v5) {
            if (interfaceC0876a == null) {
                u(39);
            }
            this.f44884u.put(interfaceC0876a, v5);
            return this;
        }

        private static /* synthetic */ void u(int i6) {
            String str;
            int i7;
            switch (i6) {
                case 9:
                case 11:
                case 13:
                case 15:
                case 16:
                case 18:
                case 20:
                case 22:
                case 24:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 36:
                case 38:
                case 40:
                case 41:
                case 42:
                    str = "@NotNull method %s.%s must not return null";
                    break;
                case 10:
                case 12:
                case 14:
                case 17:
                case 19:
                case 21:
                case 23:
                case 25:
                case 35:
                case 37:
                case 39:
                default:
                    str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                    break;
            }
            switch (i6) {
                case 9:
                case 11:
                case 13:
                case 15:
                case 16:
                case 18:
                case 20:
                case 22:
                case 24:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 36:
                case 38:
                case 40:
                case 41:
                case 42:
                    i7 = 2;
                    break;
                case 10:
                case 12:
                case 14:
                case 17:
                case 19:
                case 21:
                case 23:
                case 25:
                case 35:
                case 37:
                case 39:
                default:
                    i7 = 3;
                    break;
            }
            Object[] objArr = new Object[i7];
            switch (i6) {
                case 1:
                    objArr[0] = "newOwner";
                    break;
                case 2:
                    objArr[0] = "newModality";
                    break;
                case 3:
                    objArr[0] = "newVisibility";
                    break;
                case 4:
                case 14:
                    objArr[0] = "kind";
                    break;
                case 5:
                    objArr[0] = "newValueParameterDescriptors";
                    break;
                case 6:
                    objArr[0] = "newContextReceiverParameters";
                    break;
                case 7:
                    objArr[0] = "newReturnType";
                    break;
                case 8:
                    objArr[0] = "owner";
                    break;
                case 9:
                case 11:
                case 13:
                case 15:
                case 16:
                case 18:
                case 20:
                case 22:
                case 24:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 36:
                case 38:
                case 40:
                case 41:
                case 42:
                    objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl$CopyConfiguration";
                    break;
                case 10:
                    objArr[0] = "modality";
                    break;
                case 12:
                    objArr[0] = "visibility";
                    break;
                case 17:
                    objArr[0] = CommonNetImpl.NAME;
                    break;
                case 19:
                case 21:
                    objArr[0] = "parameters";
                    break;
                case 23:
                    objArr[0] = "type";
                    break;
                case 25:
                    objArr[0] = "contextReceiverParameters";
                    break;
                case 35:
                    objArr[0] = "additionalAnnotations";
                    break;
                case 37:
                default:
                    objArr[0] = "substitution";
                    break;
                case 39:
                    objArr[0] = "userDataKey";
                    break;
            }
            switch (i6) {
                case 9:
                    objArr[1] = "setOwner";
                    break;
                case 10:
                case 12:
                case 14:
                case 17:
                case 19:
                case 21:
                case 23:
                case 25:
                case 35:
                case 37:
                case 39:
                default:
                    objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl$CopyConfiguration";
                    break;
                case 11:
                    objArr[1] = "setModality";
                    break;
                case 13:
                    objArr[1] = "setVisibility";
                    break;
                case 15:
                    objArr[1] = "setKind";
                    break;
                case 16:
                    objArr[1] = "setCopyOverrides";
                    break;
                case 18:
                    objArr[1] = "setName";
                    break;
                case 20:
                    objArr[1] = "setValueParameters";
                    break;
                case 22:
                    objArr[1] = "setTypeParameters";
                    break;
                case 24:
                    objArr[1] = "setReturnType";
                    break;
                case 26:
                    objArr[1] = "setContextReceiverParameters";
                    break;
                case 27:
                    objArr[1] = "setExtensionReceiverParameter";
                    break;
                case 28:
                    objArr[1] = "setDispatchReceiverParameter";
                    break;
                case 29:
                    objArr[1] = "setOriginal";
                    break;
                case 30:
                    objArr[1] = "setSignatureChange";
                    break;
                case 31:
                    objArr[1] = "setPreserveSourceElement";
                    break;
                case 32:
                    objArr[1] = "setDropOriginalInContainingParts";
                    break;
                case 33:
                    objArr[1] = "setHiddenToOvercomeSignatureClash";
                    break;
                case 34:
                    objArr[1] = "setHiddenForResolutionEverywhereBesideSupercalls";
                    break;
                case 36:
                    objArr[1] = "setAdditionalAnnotations";
                    break;
                case 38:
                    objArr[1] = "setSubstitution";
                    break;
                case 40:
                    objArr[1] = "putUserData";
                    break;
                case 41:
                    objArr[1] = "getSubstitution";
                    break;
                case 42:
                    objArr[1] = "setJustForTypeSubstitution";
                    break;
            }
            switch (i6) {
                case 8:
                    objArr[2] = "setOwner";
                    break;
                case 9:
                case 11:
                case 13:
                case 15:
                case 16:
                case 18:
                case 20:
                case 22:
                case 24:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 36:
                case 38:
                case 40:
                case 41:
                case 42:
                    break;
                case 10:
                    objArr[2] = "setModality";
                    break;
                case 12:
                    objArr[2] = "setVisibility";
                    break;
                case 14:
                    objArr[2] = "setKind";
                    break;
                case 17:
                    objArr[2] = "setName";
                    break;
                case 19:
                    objArr[2] = "setValueParameters";
                    break;
                case 21:
                    objArr[2] = "setTypeParameters";
                    break;
                case 23:
                    objArr[2] = "setReturnType";
                    break;
                case 25:
                    objArr[2] = "setContextReceiverParameters";
                    break;
                case 35:
                    objArr[2] = "setAdditionalAnnotations";
                    break;
                case 37:
                    objArr[2] = "setSubstitution";
                    break;
                case 39:
                    objArr[2] = "putUserData";
                    break;
                default:
                    objArr[2] = "<init>";
                    break;
            }
            String format = String.format(str, objArr);
            switch (i6) {
                case 9:
                case 11:
                case 13:
                case 15:
                case 16:
                case 18:
                case 20:
                case 22:
                case 24:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 36:
                case 38:
                case 40:
                case 41:
                case 42:
                    throw new IllegalStateException(format);
                case 10:
                case 12:
                case 14:
                case 17:
                case 19:
                case 21:
                case 23:
                case 25:
                case 35:
                case 37:
                case 39:
                default:
                    throw new IllegalArgumentException(format);
            }
        }

        public c G(boolean z5) {
            this.f44885v = Boolean.valueOf(z5);
            return this;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    protected s(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.k kVar, @Nullable kotlin.reflect.jvm.internal.impl.descriptors.y yVar, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar, @NotNull kotlin.reflect.jvm.internal.impl.name.f fVar, @NotNull CallableMemberDescriptor.Kind kind, @NotNull e1 e1Var) {
        super(kVar, gVar, fVar, e1Var);
        if (kVar == null) {
            T(0);
        }
        if (gVar == null) {
            T(1);
        }
        if (fVar == null) {
            T(2);
        }
        if (kind == null) {
            T(3);
        }
        if (e1Var == null) {
            T(4);
        }
        this.f44846l = kotlin.reflect.jvm.internal.impl.descriptors.r.f44952i;
        this.f44847m = false;
        this.f44848n = false;
        this.f44849o = false;
        this.f44850p = false;
        this.f44851q = false;
        this.f44852r = false;
        this.f44853s = false;
        this.f44854t = false;
        this.f44855u = false;
        this.f44856v = false;
        this.f44857w = true;
        this.f44858x = false;
        this.f44859y = null;
        this.f44860z = null;
        this.C = null;
        this.D = null;
        this.A = yVar == null ? this : yVar;
        this.B = kind;
    }

    @NotNull
    protected abstract s G0(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.k kVar, @Nullable kotlin.reflect.jvm.internal.impl.descriptors.y yVar, @NotNull CallableMemberDescriptor.Kind kind, @Nullable kotlin.reflect.jvm.internal.impl.name.f fVar, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar, @NotNull e1 e1Var);

    @NotNull
    private e1 I0(boolean z5, @Nullable kotlin.reflect.jvm.internal.impl.descriptors.y yVar) {
        e1 e1Var;
        if (z5) {
            if (yVar == null) {
                yVar = a();
            }
            e1Var = yVar.getSource();
        } else {
            e1Var = e1.f44683a;
        }
        if (e1Var == null) {
            T(27);
        }
        return e1Var;
    }

    @Nullable
    public static List<q1> J0(kotlin.reflect.jvm.internal.impl.descriptors.y yVar, @NotNull List<q1> list, @NotNull h2 h2Var) {
        if (list == null) {
            T(28);
        }
        if (h2Var == null) {
            T(29);
        }
        return K0(yVar, list, h2Var, false, false, null);
    }

    @Nullable
    public static List<q1> K0(kotlin.reflect.jvm.internal.impl.descriptors.y yVar, @NotNull List<q1> list, @NotNull h2 h2Var, boolean z5, boolean z6, @Nullable boolean[] zArr) {
        if (list == null) {
            T(30);
        }
        if (h2Var == null) {
            T(31);
        }
        ArrayList arrayList = new ArrayList(list.size());
        for (q1 q1Var : list) {
            kotlin.reflect.jvm.internal.impl.types.t0 type = q1Var.getType();
            Variance variance = Variance.IN_VARIANCE;
            kotlin.reflect.jvm.internal.impl.types.t0 p5 = h2Var.p(type, variance);
            kotlin.reflect.jvm.internal.impl.types.t0 z02 = q1Var.z0();
            kotlin.reflect.jvm.internal.impl.types.t0 p6 = z02 == null ? null : h2Var.p(z02, variance);
            if (p5 == null) {
                return null;
            }
            if ((p5 != q1Var.getType() || z02 != p6) && zArr != null) {
                zArr[0] = true;
            }
            arrayList.add(u0.G0(yVar, z5 ? null : q1Var, q1Var.getIndex(), q1Var.getAnnotations(), q1Var.getName(), p5, q1Var.Q(), q1Var.w0(), q1Var.u0(), p6, z6 ? q1Var.getSource() : e1.f44683a, q1Var instanceof u0.b ? new b(((u0.b) q1Var).L0()) : null));
        }
        return arrayList;
    }

    private void O0() {
        Function0<Collection<kotlin.reflect.jvm.internal.impl.descriptors.y>> function0 = this.f44860z;
        if (function0 != null) {
            this.f44859y = function0.invoke();
            this.f44860z = null;
        }
    }

    private void V0(boolean z5) {
        this.f44855u = z5;
    }

    private void W0(boolean z5) {
        this.f44854t = z5;
    }

    private void Y0(@Nullable kotlin.reflect.jvm.internal.impl.descriptors.y yVar) {
        this.C = yVar;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a
    @NotNull
    public List<z0> A0() {
        List<z0> list = this.f44842h;
        if (list == null) {
            T(13);
        }
        return list;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.y
    public boolean D0() {
        return this.f44854t;
    }

    @Nullable
    protected kotlin.reflect.jvm.internal.impl.descriptors.y H0(@NotNull c cVar) {
        n0 n0Var;
        kotlin.reflect.jvm.internal.impl.descriptors.y yVar;
        if (cVar == null) {
            T(25);
        }
        boolean[] zArr = new boolean[1];
        kotlin.reflect.jvm.internal.impl.descriptors.annotations.g a6 = cVar.f44882s != null ? kotlin.reflect.jvm.internal.impl.descriptors.annotations.i.a(getAnnotations(), cVar.f44882s) : getAnnotations();
        kotlin.reflect.jvm.internal.impl.descriptors.k kVar = cVar.f44865b;
        kotlin.reflect.jvm.internal.impl.descriptors.y yVar2 = cVar.f44868e;
        s G0 = G0(kVar, yVar2, cVar.f44869f, cVar.f44875l, a6, I0(cVar.f44878o, yVar2));
        List<j1> typeParameters = cVar.f44881r == null ? getTypeParameters() : cVar.f44881r;
        zArr[0] = zArr[0] | (!typeParameters.isEmpty());
        ArrayList arrayList = new ArrayList(typeParameters.size());
        h2 c6 = kotlin.reflect.jvm.internal.impl.types.d0.c(typeParameters, cVar.f44864a, G0, arrayList, zArr);
        z0 z0Var = null;
        if (c6 == null) {
            return null;
        }
        ArrayList arrayList2 = new ArrayList();
        if (!cVar.f44871h.isEmpty()) {
            int i6 = 0;
            for (z0 z0Var2 : cVar.f44871h) {
                kotlin.reflect.jvm.internal.impl.types.t0 p5 = c6.p(z0Var2.getType(), Variance.IN_VARIANCE);
                if (p5 == null) {
                    return null;
                }
                int i7 = i6 + 1;
                arrayList2.add(kotlin.reflect.jvm.internal.impl.resolve.h.b(G0, p5, ((kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.f) z0Var2.getValue()).a(), z0Var2.getAnnotations(), i6));
                zArr[0] = zArr[0] | (p5 != z0Var2.getType());
                i6 = i7;
            }
        }
        z0 z0Var3 = cVar.f44872i;
        if (z0Var3 != null) {
            kotlin.reflect.jvm.internal.impl.types.t0 p6 = c6.p(z0Var3.getType(), Variance.IN_VARIANCE);
            if (p6 == null) {
                return null;
            }
            n0 n0Var2 = new n0(G0, new kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.d(G0, p6, cVar.f44872i.getValue()), cVar.f44872i.getAnnotations());
            zArr[0] = (p6 != cVar.f44872i.getType()) | zArr[0];
            n0Var = n0Var2;
        } else {
            n0Var = null;
        }
        z0 z0Var4 = cVar.f44873j;
        if (z0Var4 != null) {
            z0 c7 = z0Var4.c(c6);
            if (c7 == null) {
                return null;
            }
            zArr[0] = zArr[0] | (c7 != cVar.f44873j);
            yVar = null;
            z0Var = c7;
        } else {
            yVar = null;
        }
        List<q1> K0 = K0(G0, cVar.f44870g, c6, cVar.f44879p, cVar.f44878o, zArr);
        if (K0 == null) {
            return yVar;
        }
        kotlin.reflect.jvm.internal.impl.types.t0 p7 = c6.p(cVar.f44874k, Variance.OUT_VARIANCE);
        if (p7 == null) {
            return yVar;
        }
        boolean z5 = zArr[0] | (p7 != cVar.f44874k);
        zArr[0] = z5;
        if (!z5 && cVar.f44886w) {
            return this;
        }
        G0.M0(n0Var, z0Var, arrayList2, arrayList, K0, p7, cVar.f44866c, cVar.f44867d);
        G0.a1(this.f44847m);
        G0.X0(this.f44848n);
        G0.S0(this.f44849o);
        G0.Z0(this.f44850p);
        G0.d1(this.f44851q);
        G0.c1(this.f44856v);
        G0.R0(this.f44852r);
        G0.Q0(this.f44853s);
        G0.T0(this.f44857w);
        G0.W0(cVar.f44880q);
        G0.V0(cVar.f44883t);
        G0.U0(cVar.f44885v != null ? cVar.f44885v.booleanValue() : this.f44858x);
        if (!cVar.f44884u.isEmpty() || this.D != null) {
            Map<a.InterfaceC0876a<?>, Object> map = cVar.f44884u;
            Map<a.InterfaceC0876a<?>, Object> map2 = this.D;
            if (map2 != null) {
                for (Map.Entry<a.InterfaceC0876a<?>, Object> entry : map2.entrySet()) {
                    if (!map.containsKey(entry.getKey())) {
                        map.put(entry.getKey(), entry.getValue());
                    }
                }
            }
            if (map.size() == 1) {
                G0.D = Collections.singletonMap(map.keySet().iterator().next(), map.values().iterator().next());
            } else {
                G0.D = map;
            }
        }
        if (cVar.f44877n || x0() != null) {
            G0.Y0((x0() != null ? x0() : this).c(c6));
        }
        if (cVar.f44876m && !a().e().isEmpty()) {
            if (cVar.f44864a.f()) {
                Function0<Collection<kotlin.reflect.jvm.internal.impl.descriptors.y>> function0 = this.f44860z;
                if (function0 != null) {
                    G0.f44860z = function0;
                    return G0;
                }
                G0.R(e());
                return G0;
            }
            G0.f44860z = new a(c6);
        }
        return G0;
    }

    public boolean L0() {
        return this.f44857w;
    }

    @NotNull
    public s M0(@Nullable z0 z0Var, @Nullable z0 z0Var2, @NotNull List<z0> list, @NotNull List<? extends j1> list2, @NotNull List<q1> list3, @Nullable kotlin.reflect.jvm.internal.impl.types.t0 t0Var, @Nullable Modality modality, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.s sVar) {
        if (list == null) {
            T(5);
        }
        if (list2 == null) {
            T(6);
        }
        if (list3 == null) {
            T(7);
        }
        if (sVar == null) {
            T(8);
        }
        this.f44839e = kotlin.collections.f0.a6(list2);
        this.f44840f = kotlin.collections.f0.a6(list3);
        this.f44841g = t0Var;
        this.f44845k = modality;
        this.f44846l = sVar;
        this.f44843i = z0Var;
        this.f44844j = z0Var2;
        this.f44842h = list;
        for (int i6 = 0; i6 < list2.size(); i6++) {
            j1 j1Var = list2.get(i6);
            if (j1Var.getIndex() != i6) {
                throw new IllegalStateException(j1Var + " index is " + j1Var.getIndex() + " but position is " + i6);
            }
        }
        for (int i7 = 0; i7 < list3.size(); i7++) {
            q1 q1Var = list3.get(i7);
            if (q1Var.getIndex() != i7) {
                throw new IllegalStateException(q1Var + "index is " + q1Var.getIndex() + " but position is " + i7);
            }
        }
        return this;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a
    public <V> V N(a.InterfaceC0876a<V> interfaceC0876a) {
        Map<a.InterfaceC0876a<?>, Object> map = this.D;
        if (map == null) {
            return null;
        }
        return (V) map.get(interfaceC0876a);
    }

    @NotNull
    protected c N0(@NotNull h2 h2Var) {
        if (h2Var == null) {
            T(24);
        }
        return new c(this, h2Var.j(), b(), i(), getVisibility(), h(), g(), A0(), f0(), getReturnType(), null);
    }

    public <V> void P0(a.InterfaceC0876a<V> interfaceC0876a, Object obj) {
        if (this.D == null) {
            this.D = new LinkedHashMap();
        }
        this.D.put(interfaceC0876a, obj);
    }

    public void Q0(boolean z5) {
        this.f44853s = z5;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void R(@NotNull Collection<? extends CallableMemberDescriptor> collection) {
        if (collection == 0) {
            T(17);
        }
        this.f44859y = collection;
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            if (((kotlin.reflect.jvm.internal.impl.descriptors.y) it.next()).S()) {
                this.f44855u = true;
                return;
            }
        }
    }

    public void R0(boolean z5) {
        this.f44852r = z5;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.y
    public boolean S() {
        return this.f44855u;
    }

    public void S0(boolean z5) {
        this.f44849o = z5;
    }

    public void T0(boolean z5) {
        this.f44857w = z5;
    }

    public void U0(boolean z5) {
        this.f44858x = z5;
    }

    public void X0(boolean z5) {
        this.f44848n = z5;
    }

    public void Z0(boolean z5) {
        this.f44850p = z5;
    }

    public void a1(boolean z5) {
        this.f44847m = z5;
    }

    public void b1(@NotNull kotlin.reflect.jvm.internal.impl.types.t0 t0Var) {
        if (t0Var == null) {
            T(11);
        }
        this.f44841g = t0Var;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.y, kotlin.reflect.jvm.internal.impl.descriptors.g1
    public kotlin.reflect.jvm.internal.impl.descriptors.y c(@NotNull h2 h2Var) {
        if (h2Var == null) {
            T(22);
        }
        return h2Var.k() ? this : N0(h2Var).i(a()).g().J(true).build();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a
    @Nullable
    public z0 c0() {
        return this.f44844j;
    }

    public void c1(boolean z5) {
        this.f44856v = z5;
    }

    public void d1(boolean z5) {
        this.f44851q = z5;
    }

    public void e1(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.s sVar) {
        if (sVar == null) {
            T(10);
        }
        this.f44846l = sVar;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a
    @Nullable
    public z0 f0() {
        return this.f44843i;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a
    @NotNull
    public List<q1> g() {
        List<q1> list = this.f44840f;
        if (list == null) {
            T(19);
        }
        return list;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a
    public kotlin.reflect.jvm.internal.impl.types.t0 getReturnType() {
        return this.f44841g;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a
    @NotNull
    public List<j1> getTypeParameters() {
        List<j1> list = this.f44839e;
        if (list != null) {
            return list;
        }
        throw new IllegalStateException("typeParameters == null for " + this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.o
    @NotNull
    public kotlin.reflect.jvm.internal.impl.descriptors.s getVisibility() {
        kotlin.reflect.jvm.internal.impl.descriptors.s sVar = this.f44846l;
        if (sVar == null) {
            T(16);
        }
        return sVar;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor
    @NotNull
    public CallableMemberDescriptor.Kind h() {
        CallableMemberDescriptor.Kind kind = this.B;
        if (kind == null) {
            T(21);
        }
        return kind;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.c0
    @NotNull
    public Modality i() {
        Modality modality = this.f44845k;
        if (modality == null) {
            T(15);
        }
        return modality;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.c0
    public boolean i0() {
        return this.f44853s;
    }

    public boolean isExternal() {
        return this.f44849o;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.y
    public boolean isInfix() {
        if (this.f44848n) {
            return true;
        }
        Iterator<? extends kotlin.reflect.jvm.internal.impl.descriptors.y> it = a().e().iterator();
        while (it.hasNext()) {
            if (it.next().isInfix()) {
                return true;
            }
        }
        return false;
    }

    public boolean isInline() {
        return this.f44850p;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.y
    public boolean isOperator() {
        if (this.f44847m) {
            return true;
        }
        Iterator<? extends kotlin.reflect.jvm.internal.impl.descriptors.y> it = a().e().iterator();
        while (it.hasNext()) {
            if (it.next().isOperator()) {
                return true;
            }
        }
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.y
    public boolean isSuspend() {
        return this.f44856v;
    }

    @NotNull
    public y.a<? extends kotlin.reflect.jvm.internal.impl.descriptors.y> n() {
        c N0 = N0(h2.f47263b);
        if (N0 == null) {
            T(23);
        }
        return N0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a
    public boolean n0() {
        return this.f44858x;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.c0
    public boolean q0() {
        return this.f44852r;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.y
    @Nullable
    public kotlin.reflect.jvm.internal.impl.descriptors.y x0() {
        return this.C;
    }

    public boolean y() {
        return this.f44851q;
    }

    private static /* synthetic */ void T(int i6) {
        String str;
        int i7;
        switch (i6) {
            case 9:
            case 13:
            case 14:
            case 15:
            case 16:
            case 18:
            case 19:
            case 20:
            case 21:
            case 23:
            case 26:
            case 27:
                str = "@NotNull method %s.%s must not return null";
                break;
            case 10:
            case 11:
            case 12:
            case 17:
            case 22:
            case 24:
            case 25:
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i6) {
            case 9:
            case 13:
            case 14:
            case 15:
            case 16:
            case 18:
            case 19:
            case 20:
            case 21:
            case 23:
            case 26:
            case 27:
                i7 = 2;
                break;
            case 10:
            case 11:
            case 12:
            case 17:
            case 22:
            case 24:
            case 25:
            default:
                i7 = 3;
                break;
        }
        Object[] objArr = new Object[i7];
        switch (i6) {
            case 1:
                objArr[0] = "annotations";
                break;
            case 2:
                objArr[0] = CommonNetImpl.NAME;
                break;
            case 3:
                objArr[0] = "kind";
                break;
            case 4:
                objArr[0] = SocialConstants.PARAM_SOURCE;
                break;
            case 5:
                objArr[0] = "contextReceiverParameters";
                break;
            case 6:
                objArr[0] = "typeParameters";
                break;
            case 7:
            case 28:
            case 30:
                objArr[0] = "unsubstitutedValueParameters";
                break;
            case 8:
            case 10:
                objArr[0] = "visibility";
                break;
            case 9:
            case 13:
            case 14:
            case 15:
            case 16:
            case 18:
            case 19:
            case 20:
            case 21:
            case 23:
            case 26:
            case 27:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl";
                break;
            case 11:
                objArr[0] = "unsubstitutedReturnType";
                break;
            case 12:
                objArr[0] = "extensionReceiverParameter";
                break;
            case 17:
                objArr[0] = "overriddenDescriptors";
                break;
            case 22:
                objArr[0] = "originalSubstitutor";
                break;
            case 24:
            case 29:
            case 31:
                objArr[0] = "substitutor";
                break;
            case 25:
                objArr[0] = "configuration";
                break;
            default:
                objArr[0] = "containingDeclaration";
                break;
        }
        switch (i6) {
            case 9:
                objArr[1] = "initialize";
                break;
            case 10:
            case 11:
            case 12:
            case 17:
            case 22:
            case 24:
            case 25:
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl";
                break;
            case 13:
                objArr[1] = "getContextReceiverParameters";
                break;
            case 14:
                objArr[1] = "getOverriddenDescriptors";
                break;
            case 15:
                objArr[1] = "getModality";
                break;
            case 16:
                objArr[1] = "getVisibility";
                break;
            case 18:
                objArr[1] = "getTypeParameters";
                break;
            case 19:
                objArr[1] = "getValueParameters";
                break;
            case 20:
                objArr[1] = "getOriginal";
                break;
            case 21:
                objArr[1] = "getKind";
                break;
            case 23:
                objArr[1] = "newCopyBuilder";
                break;
            case 26:
                objArr[1] = "copy";
                break;
            case 27:
                objArr[1] = "getSourceToUseForCopy";
                break;
        }
        switch (i6) {
            case 5:
            case 6:
            case 7:
            case 8:
                objArr[2] = "initialize";
                break;
            case 9:
            case 13:
            case 14:
            case 15:
            case 16:
            case 18:
            case 19:
            case 20:
            case 21:
            case 23:
            case 26:
            case 27:
                break;
            case 10:
                objArr[2] = "setVisibility";
                break;
            case 11:
                objArr[2] = "setReturnType";
                break;
            case 12:
                objArr[2] = "setExtensionReceiverParameter";
                break;
            case 17:
                objArr[2] = "setOverriddenDescriptors";
                break;
            case 22:
                objArr[2] = "substitute";
                break;
            case 24:
                objArr[2] = "newCopyBuilder";
                break;
            case 25:
                objArr[2] = "doSubstitute";
                break;
            case 28:
            case 29:
            case 30:
            case 31:
                objArr[2] = "getSubstitutedValueParameters";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String format = String.format(str, objArr);
        switch (i6) {
            case 9:
            case 13:
            case 14:
            case 15:
            case 16:
            case 18:
            case 19:
            case 20:
            case 21:
            case 23:
            case 26:
            case 27:
                throw new IllegalStateException(format);
            case 10:
            case 11:
            case 12:
            case 17:
            case 22:
            case 24:
            case 25:
            default:
                throw new IllegalArgumentException(format);
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor
    @NotNull
    /* renamed from: F0 */
    public kotlin.reflect.jvm.internal.impl.descriptors.y e0(kotlin.reflect.jvm.internal.impl.descriptors.k kVar, Modality modality, kotlin.reflect.jvm.internal.impl.descriptors.s sVar, CallableMemberDescriptor.Kind kind, boolean z5) {
        kotlin.reflect.jvm.internal.impl.descriptors.y build = n().r(kVar).q(modality).p(sVar).s(kind).j(z5).build();
        if (build == null) {
            T(26);
        }
        return build;
    }

    public <R, D> R W(kotlin.reflect.jvm.internal.impl.descriptors.m<R, D> mVar, D d6) {
        return mVar.l(this, d6);
    }

    @NotNull
    public Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.y> e() {
        O0();
        Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.y> collection = this.f44859y;
        if (collection == null) {
            collection = Collections.EMPTY_LIST;
        }
        if (collection == null) {
            T(14);
        }
        return collection;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.n
    @NotNull
    public kotlin.reflect.jvm.internal.impl.descriptors.y a() {
        kotlin.reflect.jvm.internal.impl.descriptors.y yVar = this.A;
        kotlin.reflect.jvm.internal.impl.descriptors.y a6 = yVar == this ? this : yVar.a();
        if (a6 == null) {
            T(20);
        }
        return a6;
    }
}
