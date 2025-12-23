package kotlin.reflect.jvm.internal.impl.resolve;

import com.tencent.connect.common.Constants;
import com.umeng.socialize.common.SocializeConstants;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.f0;
import kotlin.reflect.jvm.internal.impl.descriptors.f1;
import kotlin.reflect.jvm.internal.impl.descriptors.l0;
import kotlin.reflect.jvm.internal.impl.descriptors.s0;
import kotlin.reflect.jvm.internal.impl.descriptors.s1;
import kotlin.reflect.jvm.internal.impl.descriptors.y0;
import kotlin.reflect.jvm.internal.impl.descriptors.z0;
import kotlin.reflect.jvm.internal.impl.types.j2;
import kotlin.reflect.jvm.internal.impl.types.t0;
import kotlin.reflect.jvm.internal.impl.types.w1;
import kotlin.reflect.jvm.internal.impl.types.x0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public class i {

    /* renamed from: a, reason: collision with root package name */
    public static final kotlin.reflect.jvm.internal.impl.name.c f46708a = new kotlin.reflect.jvm.internal.impl.name.c("kotlin.jvm.JvmName");

    /* renamed from: b, reason: collision with root package name */
    static final /* synthetic */ boolean f46709b = false;

    public static boolean E(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.k kVar) {
        if (kVar == null) {
            a(1);
        }
        while (kVar != null) {
            if (u(kVar) || y(kVar)) {
                return true;
            }
            kVar = kVar.b();
        }
        return false;
    }

    public static boolean A(@Nullable kotlin.reflect.jvm.internal.impl.descriptors.k kVar) {
        return D(kVar, ClassKind.ENUM_CLASS);
    }

    public static boolean B(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.k kVar) {
        if (kVar == null) {
            a(36);
        }
        return D(kVar, ClassKind.ENUM_ENTRY);
    }

    public static boolean C(@Nullable kotlin.reflect.jvm.internal.impl.descriptors.k kVar) {
        return D(kVar, ClassKind.INTERFACE);
    }

    private static boolean D(@Nullable kotlin.reflect.jvm.internal.impl.descriptors.k kVar, @NotNull ClassKind classKind) {
        if (classKind == null) {
            a(37);
        }
        return (kVar instanceof kotlin.reflect.jvm.internal.impl.descriptors.d) && ((kotlin.reflect.jvm.internal.impl.descriptors.d) kVar).h() == classKind;
    }

    private static boolean F(@NotNull t0 t0Var, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.k kVar) {
        if (t0Var == null) {
            a(30);
        }
        if (kVar == null) {
            a(31);
        }
        kotlin.reflect.jvm.internal.impl.descriptors.f c6 = t0Var.I0().c();
        if (c6 == null) {
            return false;
        }
        kotlin.reflect.jvm.internal.impl.descriptors.k a6 = c6.a();
        return (a6 instanceof kotlin.reflect.jvm.internal.impl.descriptors.f) && (kVar instanceof kotlin.reflect.jvm.internal.impl.descriptors.f) && ((kotlin.reflect.jvm.internal.impl.descriptors.f) kVar).o().equals(((kotlin.reflect.jvm.internal.impl.descriptors.f) a6).o());
    }

    public static boolean G(@Nullable kotlin.reflect.jvm.internal.impl.descriptors.k kVar) {
        return (D(kVar, ClassKind.CLASS) || D(kVar, ClassKind.INTERFACE)) && ((kotlin.reflect.jvm.internal.impl.descriptors.d) kVar).i() == Modality.SEALED;
    }

    public static boolean H(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.d dVar, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.d dVar2) {
        if (dVar == null) {
            a(28);
        }
        if (dVar2 == null) {
            a(29);
        }
        return I(dVar.s(), dVar2.a());
    }

    public static boolean I(@NotNull t0 t0Var, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.k kVar) {
        if (t0Var == null) {
            a(32);
        }
        if (kVar == null) {
            a(33);
        }
        if (F(t0Var, kVar)) {
            return true;
        }
        Iterator<t0> it = t0Var.I0().i().iterator();
        while (it.hasNext()) {
            if (I(it.next(), kVar)) {
                return true;
            }
        }
        return false;
    }

    public static boolean J(@Nullable kotlin.reflect.jvm.internal.impl.descriptors.k kVar) {
        return kVar != null && (kVar.b() instanceof l0);
    }

    public static boolean K(@NotNull s1 s1Var, @NotNull t0 t0Var) {
        if (s1Var == null) {
            a(65);
        }
        if (t0Var == null) {
            a(66);
        }
        if (s1Var.C() || x0.a(t0Var)) {
            return false;
        }
        if (j2.b(t0Var)) {
            return true;
        }
        kotlin.reflect.jvm.internal.impl.builtins.j m6 = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.e.m(s1Var);
        if (!kotlin.reflect.jvm.internal.impl.builtins.j.t0(t0Var)) {
            kotlin.reflect.jvm.internal.impl.types.checker.e eVar = kotlin.reflect.jvm.internal.impl.types.checker.e.f47168a;
            if (!eVar.a(m6.X(), t0Var) && !eVar.a(m6.L().s(), t0Var) && !eVar.a(m6.i(), t0Var)) {
                kotlin.reflect.jvm.internal.impl.builtins.q qVar = kotlin.reflect.jvm.internal.impl.builtins.q.f44636a;
                if (!kotlin.reflect.jvm.internal.impl.builtins.q.d(t0Var)) {
                    return false;
                }
            }
        }
        return true;
    }

    @NotNull
    public static <D extends CallableMemberDescriptor> D L(@NotNull D d6) {
        if (d6 == null) {
            a(58);
        }
        while (d6.h() == CallableMemberDescriptor.Kind.FAKE_OVERRIDE) {
            Collection<? extends CallableMemberDescriptor> e6 = d6.e();
            if (e6.isEmpty()) {
                throw new IllegalStateException("Fake override should have at least one overridden descriptor: " + d6);
            }
            d6 = (D) e6.iterator().next();
        }
        return d6;
    }

    @NotNull
    public static <D extends kotlin.reflect.jvm.internal.impl.descriptors.o> D M(@NotNull D d6) {
        if (d6 == null) {
            a(63);
        }
        if (d6 instanceof CallableMemberDescriptor) {
            return L((CallableMemberDescriptor) d6);
        }
        if (d6 == null) {
            a(64);
        }
        return d6;
    }

    public static boolean b(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.k kVar, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.k kVar2) {
        if (kVar == null) {
            a(16);
        }
        if (kVar2 == null) {
            a(17);
        }
        return g(kVar).equals(g(kVar2));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static <D extends kotlin.reflect.jvm.internal.impl.descriptors.a> void c(@NotNull D d6, @NotNull Set<D> set) {
        if (d6 == null) {
            a(72);
        }
        if (set == 0) {
            a(73);
        }
        if (set.contains(d6)) {
            return;
        }
        Iterator<? extends kotlin.reflect.jvm.internal.impl.descriptors.a> it = d6.a().e().iterator();
        while (it.hasNext()) {
            kotlin.reflect.jvm.internal.impl.descriptors.a a6 = it.next().a();
            c(a6, set);
            set.add(a6);
        }
    }

    @NotNull
    public static <D extends kotlin.reflect.jvm.internal.impl.descriptors.a> Set<D> d(@NotNull D d6) {
        if (d6 == null) {
            a(70);
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        c(d6.a(), linkedHashSet);
        return linkedHashSet;
    }

    @NotNull
    public static kotlin.reflect.jvm.internal.impl.descriptors.d e(@NotNull t0 t0Var) {
        if (t0Var == null) {
            a(45);
        }
        return f(t0Var.I0());
    }

    @NotNull
    public static kotlin.reflect.jvm.internal.impl.descriptors.d f(@NotNull w1 w1Var) {
        if (w1Var == null) {
            a(46);
        }
        kotlin.reflect.jvm.internal.impl.descriptors.d dVar = (kotlin.reflect.jvm.internal.impl.descriptors.d) w1Var.c();
        if (dVar == null) {
            a(47);
        }
        return dVar;
    }

    @NotNull
    public static f0 g(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.k kVar) {
        if (kVar == null) {
            a(21);
        }
        f0 h6 = h(kVar);
        if (h6 == null) {
            a(22);
        }
        return h6;
    }

    @Nullable
    public static f0 h(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.k kVar) {
        if (kVar == null) {
            a(23);
        }
        while (kVar != null) {
            if (kVar instanceof f0) {
                return (f0) kVar;
            }
            if (kVar instanceof s0) {
                return ((s0) kVar).C0();
            }
            kVar = kVar.b();
        }
        return null;
    }

    @Nullable
    public static f0 i(@NotNull t0 t0Var) {
        if (t0Var == null) {
            a(20);
        }
        kotlin.reflect.jvm.internal.impl.descriptors.f c6 = t0Var.I0().c();
        if (c6 == null) {
            return null;
        }
        return h(c6);
    }

    @NotNull
    public static f1 j(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.k kVar) {
        if (kVar == null) {
            a(81);
        }
        if (kVar instanceof y0) {
            kVar = ((y0) kVar).h0();
        }
        if (kVar instanceof kotlin.reflect.jvm.internal.impl.descriptors.n) {
            f1 b6 = ((kotlin.reflect.jvm.internal.impl.descriptors.n) kVar).getSource().b();
            if (b6 == null) {
                a(82);
            }
            return b6;
        }
        f1 f1Var = f1.f44684a;
        if (f1Var == null) {
            a(83);
        }
        return f1Var;
    }

    @NotNull
    public static kotlin.reflect.jvm.internal.impl.descriptors.s k(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.d dVar, boolean z5) {
        if (dVar == null) {
            a(48);
        }
        ClassKind h6 = dVar.h();
        if (h6 == ClassKind.ENUM_CLASS || h6.isSingleton()) {
            kotlin.reflect.jvm.internal.impl.descriptors.s sVar = kotlin.reflect.jvm.internal.impl.descriptors.r.f44944a;
            if (sVar == null) {
                a(49);
            }
            return sVar;
        }
        if (G(dVar)) {
            if (z5) {
                kotlin.reflect.jvm.internal.impl.descriptors.s sVar2 = kotlin.reflect.jvm.internal.impl.descriptors.r.f44946c;
                if (sVar2 == null) {
                    a(50);
                }
                return sVar2;
            }
            kotlin.reflect.jvm.internal.impl.descriptors.s sVar3 = kotlin.reflect.jvm.internal.impl.descriptors.r.f44944a;
            if (sVar3 == null) {
                a(51);
            }
            return sVar3;
        }
        if (u(dVar)) {
            kotlin.reflect.jvm.internal.impl.descriptors.s sVar4 = kotlin.reflect.jvm.internal.impl.descriptors.r.f44955l;
            if (sVar4 == null) {
                a(52);
            }
            return sVar4;
        }
        kotlin.reflect.jvm.internal.impl.descriptors.s sVar5 = kotlin.reflect.jvm.internal.impl.descriptors.r.f44948e;
        if (sVar5 == null) {
            a(53);
        }
        return sVar5;
    }

    @Nullable
    public static z0 l(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.k kVar) {
        if (kVar == null) {
            a(0);
        }
        if (kVar instanceof kotlin.reflect.jvm.internal.impl.descriptors.d) {
            return ((kotlin.reflect.jvm.internal.impl.descriptors.d) kVar).V();
        }
        return null;
    }

    @NotNull
    public static kotlin.reflect.jvm.internal.impl.name.d m(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.k kVar) {
        if (kVar == null) {
            a(2);
        }
        kotlin.reflect.jvm.internal.impl.name.c o5 = o(kVar);
        return o5 != null ? o5.i() : p(kVar);
    }

    @NotNull
    public static kotlin.reflect.jvm.internal.impl.name.c n(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.k kVar) {
        if (kVar == null) {
            a(3);
        }
        kotlin.reflect.jvm.internal.impl.name.c o5 = o(kVar);
        if (o5 == null) {
            o5 = p(kVar).m();
        }
        if (o5 == null) {
            a(4);
        }
        return o5;
    }

    @Nullable
    private static kotlin.reflect.jvm.internal.impl.name.c o(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.k kVar) {
        if (kVar == null) {
            a(5);
        }
        if ((kVar instanceof f0) || kotlin.reflect.jvm.internal.impl.types.error.i.m(kVar)) {
            return kotlin.reflect.jvm.internal.impl.name.c.f46339d;
        }
        if (kVar instanceof s0) {
            return ((s0) kVar).d();
        }
        if (kVar instanceof l0) {
            return ((l0) kVar).d();
        }
        return null;
    }

    @NotNull
    private static kotlin.reflect.jvm.internal.impl.name.d p(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.k kVar) {
        if (kVar == null) {
            a(6);
        }
        kotlin.reflect.jvm.internal.impl.name.d b6 = m(kVar.b()).b(kVar.getName());
        if (b6 == null) {
            a(7);
        }
        return b6;
    }

    @Nullable
    public static <D extends kotlin.reflect.jvm.internal.impl.descriptors.k> D q(@Nullable kotlin.reflect.jvm.internal.impl.descriptors.k kVar, @NotNull Class<D> cls) {
        if (cls == null) {
            a(18);
        }
        return (D) r(kVar, cls, true);
    }

    @Nullable
    public static <D extends kotlin.reflect.jvm.internal.impl.descriptors.k> D r(@Nullable kotlin.reflect.jvm.internal.impl.descriptors.k kVar, @NotNull Class<D> cls, boolean z5) {
        if (cls == null) {
            a(19);
        }
        if (kVar == null) {
            return null;
        }
        if (z5) {
            kVar = (D) kVar.b();
        }
        while (kVar != null) {
            if (cls.isInstance(kVar)) {
                return (D) kVar;
            }
            kVar = (D) kVar.b();
        }
        return null;
    }

    @Nullable
    public static kotlin.reflect.jvm.internal.impl.descriptors.d s(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.d dVar) {
        if (dVar == null) {
            a(44);
        }
        Iterator<t0> it = dVar.o().i().iterator();
        while (it.hasNext()) {
            kotlin.reflect.jvm.internal.impl.descriptors.d e6 = e(it.next());
            if (e6.h() != ClassKind.INTERFACE) {
                return e6;
            }
        }
        return null;
    }

    public static boolean t(@Nullable kotlin.reflect.jvm.internal.impl.descriptors.k kVar) {
        return D(kVar, ClassKind.ANNOTATION_CLASS);
    }

    public static boolean u(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.k kVar) {
        if (kVar == null) {
            a(34);
        }
        return v(kVar) && kVar.getName().equals(kotlin.reflect.jvm.internal.impl.name.h.f46356b);
    }

    public static boolean v(@Nullable kotlin.reflect.jvm.internal.impl.descriptors.k kVar) {
        return D(kVar, ClassKind.CLASS);
    }

    public static boolean x(@Nullable kotlin.reflect.jvm.internal.impl.descriptors.k kVar) {
        return D(kVar, ClassKind.OBJECT) && ((kotlin.reflect.jvm.internal.impl.descriptors.d) kVar).l0();
    }

    public static boolean y(kotlin.reflect.jvm.internal.impl.descriptors.k kVar) {
        return (kVar instanceof kotlin.reflect.jvm.internal.impl.descriptors.o) && ((kotlin.reflect.jvm.internal.impl.descriptors.o) kVar).getVisibility() == kotlin.reflect.jvm.internal.impl.descriptors.r.f44949f;
    }

    public static boolean z(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.d dVar, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.d dVar2) {
        if (dVar == null) {
            a(26);
        }
        if (dVar2 == null) {
            a(27);
        }
        Iterator<t0> it = dVar.o().i().iterator();
        while (it.hasNext()) {
            if (F(it.next(), dVar2.a())) {
                return true;
            }
        }
        return false;
    }

    private i() {
    }

    private static /* synthetic */ void a(int i6) {
        String str;
        int i7;
        switch (i6) {
            case 4:
            case 7:
            case 9:
            case 10:
            case 12:
            case 22:
            case 40:
            case 42:
            case 43:
            case 47:
            case 49:
            case 50:
            case 51:
            case 52:
            case 53:
            case 59:
            case 61:
            case 62:
            case 64:
            case 71:
            case 75:
            case 82:
            case 83:
            case 85:
            case 88:
            case 93:
            case 95:
                str = "@NotNull method %s.%s must not return null";
                break;
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i6) {
            case 4:
            case 7:
            case 9:
            case 10:
            case 12:
            case 22:
            case 40:
            case 42:
            case 43:
            case 47:
            case 49:
            case 50:
            case 51:
            case 52:
            case 53:
            case 59:
            case 61:
            case 62:
            case 64:
            case 71:
            case 75:
            case 82:
            case 83:
            case 85:
            case 88:
            case 93:
            case 95:
                i7 = 2;
                break;
            default:
                i7 = 3;
                break;
        }
        Object[] objArr = new Object[i7];
        switch (i6) {
            case 1:
            case 2:
            case 3:
            case 5:
            case 6:
            case 8:
            case 11:
            case 13:
            case 14:
            case 15:
            case 21:
            case 23:
            case 24:
            case 34:
            case 35:
            case 36:
            case 57:
            case 58:
            case 60:
            case 63:
            case 81:
            case 94:
                objArr[0] = "descriptor";
                break;
            case 4:
            case 7:
            case 9:
            case 10:
            case 12:
            case 22:
            case 40:
            case 42:
            case 43:
            case 47:
            case 49:
            case 50:
            case 51:
            case 52:
            case 53:
            case 59:
            case 61:
            case 62:
            case 64:
            case 71:
            case 75:
            case 82:
            case 83:
            case 85:
            case 88:
            case 93:
            case 95:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/resolve/DescriptorUtils";
                break;
            case 16:
                objArr[0] = "first";
                break;
            case 17:
                objArr[0] = "second";
                break;
            case 18:
            case 19:
                objArr[0] = "aClass";
                break;
            case 20:
                objArr[0] = "kotlinType";
                break;
            case 25:
                objArr[0] = "declarationDescriptor";
                break;
            case 26:
            case 28:
                objArr[0] = "subClass";
                break;
            case 27:
            case 29:
            case 33:
                objArr[0] = "superClass";
                break;
            case 30:
            case 32:
            case 45:
            case 66:
                objArr[0] = "type";
                break;
            case 31:
                objArr[0] = "other";
                break;
            case 37:
                objArr[0] = "classKind";
                break;
            case 38:
            case 39:
            case 41:
            case 44:
            case 48:
            case 54:
            case 67:
            case 68:
            case 69:
            case 76:
            case 77:
                objArr[0] = "classDescriptor";
                break;
            case 46:
                objArr[0] = "typeConstructor";
                break;
            case 55:
                objArr[0] = "innerClassName";
                break;
            case 56:
                objArr[0] = SocializeConstants.KEY_LOCATION;
                break;
            case 65:
                objArr[0] = "variable";
                break;
            case 70:
                objArr[0] = "f";
                break;
            case 72:
                objArr[0] = "current";
                break;
            case 73:
                objArr[0] = "result";
                break;
            case 74:
                objArr[0] = "memberDescriptor";
                break;
            case 78:
            case 79:
            case 80:
                objArr[0] = "annotated";
                break;
            case 84:
            case 86:
            case 89:
            case 91:
                objArr[0] = Constants.PARAM_SCOPE;
                break;
            case 87:
            case 90:
            case 92:
                objArr[0] = CommonNetImpl.NAME;
                break;
            default:
                objArr[0] = "containingDeclaration";
                break;
        }
        switch (i6) {
            case 4:
                objArr[1] = "getFqNameSafe";
                break;
            case 7:
                objArr[1] = "getFqNameUnsafe";
                break;
            case 9:
            case 10:
                objArr[1] = "getFqNameFromTopLevelClass";
                break;
            case 12:
                objArr[1] = "getClassIdForNonLocalClass";
                break;
            case 22:
                objArr[1] = "getContainingModule";
                break;
            case 40:
                objArr[1] = "getSuperclassDescriptors";
                break;
            case 42:
            case 43:
                objArr[1] = "getSuperClassType";
                break;
            case 47:
                objArr[1] = "getClassDescriptorForTypeConstructor";
                break;
            case 49:
            case 50:
            case 51:
            case 52:
            case 53:
                objArr[1] = "getDefaultConstructorVisibility";
                break;
            case 59:
                objArr[1] = "unwrapFakeOverride";
                break;
            case 61:
            case 62:
                objArr[1] = "unwrapSubstitutionOverride";
                break;
            case 64:
                objArr[1] = "unwrapFakeOverrideToAnyDeclaration";
                break;
            case 71:
                objArr[1] = "getAllOverriddenDescriptors";
                break;
            case 75:
                objArr[1] = "getAllOverriddenDeclarations";
                break;
            case 82:
            case 83:
                objArr[1] = "getContainingSourceFile";
                break;
            case 85:
                objArr[1] = "getAllDescriptors";
                break;
            case 88:
                objArr[1] = "getFunctionByName";
                break;
            case 93:
                objArr[1] = "getPropertyByName";
                break;
            case 95:
                objArr[1] = "getDirectMember";
                break;
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/resolve/DescriptorUtils";
                break;
        }
        switch (i6) {
            case 1:
                objArr[2] = "isLocal";
                break;
            case 2:
                objArr[2] = "getFqName";
                break;
            case 3:
                objArr[2] = "getFqNameSafe";
                break;
            case 4:
            case 7:
            case 9:
            case 10:
            case 12:
            case 22:
            case 40:
            case 42:
            case 43:
            case 47:
            case 49:
            case 50:
            case 51:
            case 52:
            case 53:
            case 59:
            case 61:
            case 62:
            case 64:
            case 71:
            case 75:
            case 82:
            case 83:
            case 85:
            case 88:
            case 93:
            case 95:
                break;
            case 5:
                objArr[2] = "getFqNameSafeIfPossible";
                break;
            case 6:
                objArr[2] = "getFqNameUnsafe";
                break;
            case 8:
                objArr[2] = "getFqNameFromTopLevelClass";
                break;
            case 11:
                objArr[2] = "getClassIdForNonLocalClass";
                break;
            case 13:
                objArr[2] = "isExtension";
                break;
            case 14:
                objArr[2] = "isOverride";
                break;
            case 15:
                objArr[2] = "isStaticDeclaration";
                break;
            case 16:
            case 17:
                objArr[2] = "areInSameModule";
                break;
            case 18:
            case 19:
                objArr[2] = "getParentOfType";
                break;
            case 20:
            case 23:
                objArr[2] = "getContainingModuleOrNull";
                break;
            case 21:
                objArr[2] = "getContainingModule";
                break;
            case 24:
                objArr[2] = "getContainingClass";
                break;
            case 25:
                objArr[2] = "isAncestor";
                break;
            case 26:
            case 27:
                objArr[2] = "isDirectSubclass";
                break;
            case 28:
            case 29:
                objArr[2] = "isSubclass";
                break;
            case 30:
            case 31:
                objArr[2] = "isSameClass";
                break;
            case 32:
            case 33:
                objArr[2] = "isSubtypeOfClass";
                break;
            case 34:
                objArr[2] = "isAnonymousObject";
                break;
            case 35:
                objArr[2] = "isAnonymousFunction";
                break;
            case 36:
                objArr[2] = "isEnumEntry";
                break;
            case 37:
                objArr[2] = "isKindOf";
                break;
            case 38:
                objArr[2] = "hasAbstractMembers";
                break;
            case 39:
                objArr[2] = "getSuperclassDescriptors";
                break;
            case 41:
                objArr[2] = "getSuperClassType";
                break;
            case 44:
                objArr[2] = "getSuperClassDescriptor";
                break;
            case 45:
                objArr[2] = "getClassDescriptorForType";
                break;
            case 46:
                objArr[2] = "getClassDescriptorForTypeConstructor";
                break;
            case 48:
                objArr[2] = "getDefaultConstructorVisibility";
                break;
            case 54:
            case 55:
            case 56:
                objArr[2] = "getInnerClassByName";
                break;
            case 57:
                objArr[2] = "isStaticNestedClass";
                break;
            case 58:
                objArr[2] = "unwrapFakeOverride";
                break;
            case 60:
                objArr[2] = "unwrapSubstitutionOverride";
                break;
            case 63:
                objArr[2] = "unwrapFakeOverrideToAnyDeclaration";
                break;
            case 65:
            case 66:
                objArr[2] = "shouldRecordInitializerForProperty";
                break;
            case 67:
                objArr[2] = "classCanHaveAbstractFakeOverride";
                break;
            case 68:
                objArr[2] = "classCanHaveAbstractDeclaration";
                break;
            case 69:
                objArr[2] = "classCanHaveOpenMembers";
                break;
            case 70:
                objArr[2] = "getAllOverriddenDescriptors";
                break;
            case 72:
            case 73:
                objArr[2] = "collectAllOverriddenDescriptors";
                break;
            case 74:
                objArr[2] = "getAllOverriddenDeclarations";
                break;
            case 76:
                objArr[2] = "isSingletonOrAnonymousObject";
                break;
            case 77:
                objArr[2] = "canHaveDeclaredConstructors";
                break;
            case 78:
                objArr[2] = "getJvmName";
                break;
            case 79:
                objArr[2] = "findJvmNameAnnotation";
                break;
            case 80:
                objArr[2] = "hasJvmNameAnnotation";
                break;
            case 81:
                objArr[2] = "getContainingSourceFile";
                break;
            case 84:
                objArr[2] = "getAllDescriptors";
                break;
            case 86:
            case 87:
                objArr[2] = "getFunctionByName";
                break;
            case 89:
            case 90:
                objArr[2] = "getFunctionByNameOrNull";
                break;
            case 91:
            case 92:
                objArr[2] = "getPropertyByName";
                break;
            case 94:
                objArr[2] = "getDirectMember";
                break;
            default:
                objArr[2] = "getDispatchReceiverParameterIfNeeded";
                break;
        }
        String format = String.format(str, objArr);
        switch (i6) {
            case 4:
            case 7:
            case 9:
            case 10:
            case 12:
            case 22:
            case 40:
            case 42:
            case 43:
            case 47:
            case 49:
            case 50:
            case 51:
            case 52:
            case 53:
            case 59:
            case 61:
            case 62:
            case 64:
            case 71:
            case 75:
            case 82:
            case 83:
            case 85:
            case 88:
            case 93:
            case 95:
                throw new IllegalStateException(format);
            default:
                throw new IllegalArgumentException(format);
        }
    }

    public static boolean w(@Nullable kotlin.reflect.jvm.internal.impl.descriptors.k kVar) {
        if (!v(kVar) && !A(kVar)) {
            return false;
        }
        return true;
    }
}
