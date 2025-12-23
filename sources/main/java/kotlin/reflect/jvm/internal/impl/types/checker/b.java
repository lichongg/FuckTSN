package kotlin.reflect.jvm.internal.impl.types.checker;

import java.util.Collection;
import java.util.List;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.o0;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.builtins.o;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.i1;
import kotlin.reflect.jvm.internal.impl.descriptors.j1;
import kotlin.reflect.jvm.internal.impl.types.TypeCheckerState;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.b1;
import kotlin.reflect.jvm.internal.impl.types.c2;
import kotlin.reflect.jvm.internal.impl.types.d1;
import kotlin.reflect.jvm.internal.impl.types.e1;
import kotlin.reflect.jvm.internal.impl.types.f0;
import kotlin.reflect.jvm.internal.impl.types.h1;
import kotlin.reflect.jvm.internal.impl.types.h2;
import kotlin.reflect.jvm.internal.impl.types.i2;
import kotlin.reflect.jvm.internal.impl.types.j2;
import kotlin.reflect.jvm.internal.impl.types.k0;
import kotlin.reflect.jvm.internal.impl.types.m2;
import kotlin.reflect.jvm.internal.impl.types.model.CaptureStatus;
import kotlin.reflect.jvm.internal.impl.types.model.TypeVariance;
import kotlin.reflect.jvm.internal.impl.types.s0;
import kotlin.reflect.jvm.internal.impl.types.t0;
import kotlin.reflect.jvm.internal.impl.types.w0;
import kotlin.reflect.jvm.internal.impl.types.w1;
import kotlin.reflect.jvm.internal.impl.types.x0;
import kotlin.reflect.jvm.internal.impl.types.x1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public interface b extends i2, e4.t {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\nClassicTypeSystemContext.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ClassicTypeSystemContext.kt\norg/jetbrains/kotlin/types/checker/ClassicTypeSystemContext$DefaultImpls\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 ClassicTypeSystemContext.kt\norg/jetbrains/kotlin/types/checker/ClassicTypeSystemContextKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 5 addToStdlib.kt\norg/jetbrains/kotlin/utils/addToStdlib/AddToStdlibKt\n+ 6 TypeUtils.kt\norg/jetbrains/kotlin/types/typeUtil/TypeUtilsKt\n*L\n1#1,970:1\n1#2:971\n964#3:972\n964#3:973\n964#3:974\n964#3:975\n964#3:976\n964#3:977\n964#3:978\n964#3:979\n964#3:980\n964#3:981\n964#3:982\n964#3:983\n964#3:984\n964#3:985\n964#3:986\n964#3:987\n964#3:988\n964#3:989\n964#3:990\n964#3:991\n964#3:992\n964#3:993\n964#3:994\n964#3:995\n964#3:996\n964#3:997\n964#3:998\n964#3:999\n964#3:1000\n964#3:1001\n964#3:1002\n964#3:1003\n964#3:1004\n964#3:1005\n964#3:1006\n964#3:1007\n964#3:1008\n964#3:1009\n964#3:1010\n964#3:1011\n964#3:1012\n964#3:1013\n964#3:1014\n964#3:1015\n964#3:1016\n964#3:1017\n964#3:1018\n964#3:1019\n964#3:1020\n964#3:1021\n964#3:1022\n964#3:1023\n964#3:1024\n964#3:1025\n964#3:1026\n964#3:1027\n964#3:1028\n964#3:1029\n964#3:1030\n964#3:1031\n964#3:1032\n964#3:1033\n964#3:1034\n964#3:1035\n964#3:1036\n964#3:1037\n964#3:1038\n964#3:1039\n964#3:1040\n964#3:1041\n964#3:1042\n964#3:1043\n964#3:1044\n964#3:1048\n964#3:1049\n964#3:1050\n964#3:1051\n964#3:1052\n964#3:1053\n964#3:1054\n964#3:1055\n964#3:1061\n964#3:1062\n964#3:1063\n964#3:1064\n964#3:1065\n964#3:1066\n964#3:1073\n964#3:1074\n964#3:1075\n964#3:1090\n964#3:1091\n964#3:1092\n964#3:1093\n964#3:1104\n964#3:1105\n964#3:1106\n964#3:1107\n964#3:1108\n964#3:1109\n964#3:1110\n964#3:1111\n964#3:1112\n964#3:1113\n964#3:1114\n964#3:1115\n964#3:1116\n964#3:1117\n964#3:1118\n964#3:1119\n964#3:1120\n964#3:1121\n964#3:1122\n964#3:1123\n964#3:1124\n964#3:1125\n964#3:1126\n964#3:1127\n964#3:1128\n964#3:1129\n827#4:1045\n855#4,2:1046\n774#4:1058\n865#4,2:1059\n1563#4:1069\n1634#4,3:1070\n1563#4:1076\n1634#4,3:1077\n2783#4,7:1080\n827#4:1087\n855#4,2:1088\n1563#4:1094\n1634#4,3:1095\n1285#4,2:1098\n1299#4,4:1100\n21#5,2:1056\n264#6,2:1067\n*S KotlinDebug\n*F\n+ 1 ClassicTypeSystemContext.kt\norg/jetbrains/kotlin/types/checker/ClassicTypeSystemContext$DefaultImpls\n*L\n41#1:972\n46#1:973\n59#1:974\n64#1:975\n70#1:976\n76#1:977\n81#1:978\n86#1:979\n91#1:980\n96#1:981\n101#1:982\n106#1:983\n111#1:984\n120#1:985\n126#1:986\n131#1:987\n136#1:988\n137#1:989\n142#1:990\n147#1:991\n152#1:992\n157#1:993\n166#1:994\n171#1:995\n176#1:996\n181#1:997\n193#1:998\n198#1:999\n203#1:1000\n208#1:1001\n213#1:1002\n218#1:1003\n223#1:1004\n228#1:1005\n233#1:1006\n234#1:1007\n240#1:1008\n246#1:1009\n251#1:1010\n256#1:1011\n261#1:1012\n266#1:1013\n271#1:1014\n276#1:1015\n281#1:1016\n286#1:1017\n291#1:1018\n292#1:1019\n298#1:1020\n299#1:1021\n304#1:1022\n309#1:1023\n314#1:1024\n320#1:1025\n328#1:1026\n334#1:1027\n339#1:1028\n344#1:1029\n349#1:1030\n354#1:1031\n359#1:1032\n364#1:1033\n378#1:1034\n388#1:1035\n393#1:1036\n419#1:1037\n424#1:1038\n429#1:1039\n430#1:1040\n471#1:1041\n477#1:1042\n482#1:1043\n487#1:1044\n493#1:1048\n498#1:1049\n515#1:1050\n521#1:1051\n526#1:1052\n531#1:1053\n542#1:1054\n553#1:1055\n576#1:1061\n581#1:1062\n586#1:1063\n593#1:1064\n598#1:1065\n604#1:1066\n609#1:1073\n636#1:1074\n637#1:1075\n693#1:1090\n698#1:1091\n703#1:1092\n708#1:1093\n746#1:1104\n751#1:1105\n756#1:1106\n761#1:1107\n766#1:1108\n771#1:1109\n776#1:1110\n781#1:1111\n786#1:1112\n791#1:1113\n796#1:1114\n801#1:1115\n806#1:1116\n811#1:1117\n816#1:1118\n821#1:1119\n826#1:1120\n831#1:1121\n836#1:1122\n845#1:1123\n846#1:1124\n857#1:1125\n862#1:1126\n867#1:1127\n898#1:1128\n905#1:1129\n488#1:1045\n488#1:1046,2\n561#1:1058\n561#1:1059,2\n605#1:1069\n605#1:1070,3\n679#1:1076\n679#1:1077,3\n679#1:1080,7\n685#1:1087\n685#1:1088,2\n734#1:1094\n734#1:1095,3\n735#1:1098,2\n735#1:1100,4\n555#1:1056,2\n605#1:1067,2\n*E\n"})
    public static final class a {

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        /* renamed from: kotlin.reflect.jvm.internal.impl.types.checker.b$a$a, reason: collision with other inner class name */
        public static final class C0921a extends TypeCheckerState.b.a {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ b f47157a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ h2 f47158b;

            C0921a(b bVar, h2 h2Var) {
                this.f47157a = bVar;
                this.f47158b = h2Var;
            }

            @Override // kotlin.reflect.jvm.internal.impl.types.TypeCheckerState.b
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public e4.i a(TypeCheckerState state, e4.g type) {
                g0.p(state, "state");
                g0.p(type, "type");
                b bVar = this.f47157a;
                h2 h2Var = this.f47158b;
                e4.g r02 = bVar.r0(type);
                g0.n(r02, "null cannot be cast to non-null type org.jetbrains.kotlin.types.KotlinType");
                t0 n6 = h2Var.n((t0) r02, Variance.INVARIANT);
                g0.o(n6, "safeSubstitute(...)");
                e4.i f6 = bVar.f((e4.g) n6);
                g0.m(f6);
                return f6;
            }
        }

        public static boolean M(@NotNull b bVar) {
            return false;
        }

        public static boolean A(@NotNull b bVar, @NotNull e4.g receiver, @NotNull kotlin.reflect.jvm.internal.impl.name.c fqName) {
            g0.p(receiver, "$receiver");
            g0.p(fqName, "fqName");
            if (receiver instanceof t0) {
                return ((t0) receiver).getAnnotations().l(fqName);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + o0.d(receiver.getClass())).toString());
        }

        public static boolean B(@NotNull b bVar, @NotNull e4.p receiver, @Nullable e4.o oVar) {
            g0.p(receiver, "$receiver");
            if (!(receiver instanceof j1)) {
                throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + o0.d(receiver.getClass())).toString());
            }
            j1 j1Var = (j1) receiver;
            if (oVar == null ? true : oVar instanceof w1) {
                return kotlin.reflect.jvm.internal.impl.types.typeUtil.e.s(j1Var, (w1) oVar, null, 4, null);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + j1Var + ", " + o0.d(j1Var.getClass())).toString());
        }

        public static boolean C(@NotNull b bVar, @NotNull e4.h a6, @NotNull e4.h b6) {
            g0.p(a6, "a");
            g0.p(b6, "b");
            if (!(a6 instanceof e1)) {
                throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + a6 + ", " + o0.d(a6.getClass())).toString());
            }
            if (b6 instanceof e1) {
                return ((e1) a6).G0() == ((e1) b6).G0();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + b6 + ", " + o0.d(b6.getClass())).toString());
        }

        @NotNull
        public static e4.g D(@NotNull b bVar, @NotNull Collection<? extends e4.g> types) {
            g0.p(types, "types");
            return d.a(types);
        }

        public static boolean E(@NotNull b bVar, @NotNull e4.o receiver) {
            g0.p(receiver, "$receiver");
            if (receiver instanceof w1) {
                return kotlin.reflect.jvm.internal.impl.builtins.j.x0((w1) receiver, o.a.f44585b);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + o0.d(receiver.getClass())).toString());
        }

        public static boolean F(@NotNull b bVar, @NotNull e4.o receiver) {
            g0.p(receiver, "$receiver");
            if (receiver instanceof w1) {
                return ((w1) receiver).c() instanceof kotlin.reflect.jvm.internal.impl.descriptors.d;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + o0.d(receiver.getClass())).toString());
        }

        public static boolean G(@NotNull b bVar, @NotNull e4.o receiver) {
            g0.p(receiver, "$receiver");
            if (receiver instanceof w1) {
                kotlin.reflect.jvm.internal.impl.descriptors.f c6 = ((w1) receiver).c();
                kotlin.reflect.jvm.internal.impl.descriptors.d dVar = c6 instanceof kotlin.reflect.jvm.internal.impl.descriptors.d ? (kotlin.reflect.jvm.internal.impl.descriptors.d) c6 : null;
                return (dVar == null || !kotlin.reflect.jvm.internal.impl.descriptors.d0.a(dVar) || dVar.h() == ClassKind.ENUM_ENTRY || dVar.h() == ClassKind.ANNOTATION_CLASS) ? false : true;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + o0.d(receiver.getClass())).toString());
        }

        public static boolean H(@NotNull b bVar, @NotNull e4.o receiver) {
            g0.p(receiver, "$receiver");
            if (receiver instanceof w1) {
                return ((w1) receiver).d();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + o0.d(receiver.getClass())).toString());
        }

        public static boolean I(@NotNull b bVar, @NotNull e4.g receiver) {
            g0.p(receiver, "$receiver");
            if (receiver instanceof t0) {
                return x0.a((t0) receiver);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + o0.d(receiver.getClass())).toString());
        }

        public static boolean J(@NotNull b bVar, @NotNull e4.o receiver) {
            g0.p(receiver, "$receiver");
            if (receiver instanceof w1) {
                kotlin.reflect.jvm.internal.impl.descriptors.f c6 = ((w1) receiver).c();
                kotlin.reflect.jvm.internal.impl.descriptors.d dVar = c6 instanceof kotlin.reflect.jvm.internal.impl.descriptors.d ? (kotlin.reflect.jvm.internal.impl.descriptors.d) c6 : null;
                return (dVar != null ? dVar.g0() : null) instanceof kotlin.reflect.jvm.internal.impl.descriptors.z;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + o0.d(receiver.getClass())).toString());
        }

        public static boolean K(@NotNull b bVar, @NotNull e4.o receiver) {
            g0.p(receiver, "$receiver");
            if (receiver instanceof w1) {
                return receiver instanceof kotlin.reflect.jvm.internal.impl.resolve.constants.q;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + o0.d(receiver.getClass())).toString());
        }

        public static boolean L(@NotNull b bVar, @NotNull e4.o receiver) {
            g0.p(receiver, "$receiver");
            if (receiver instanceof w1) {
                return receiver instanceof s0;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + o0.d(receiver.getClass())).toString());
        }

        public static boolean N(@NotNull b bVar, @NotNull e4.g receiver) {
            g0.p(receiver, "$receiver");
            return (receiver instanceof e1) && ((e1) receiver).J0();
        }

        public static boolean O(@NotNull b bVar, @NotNull e4.g receiver) {
            g0.p(receiver, "$receiver");
            return receiver instanceof b1;
        }

        public static boolean P(@NotNull b bVar, @NotNull e4.o receiver) {
            g0.p(receiver, "$receiver");
            if (receiver instanceof w1) {
                return kotlin.reflect.jvm.internal.impl.builtins.j.x0((w1) receiver, o.a.f44587c);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + o0.d(receiver.getClass())).toString());
        }

        public static boolean Q(@NotNull b bVar, @NotNull e4.g receiver) {
            g0.p(receiver, "$receiver");
            if (receiver instanceof t0) {
                return j2.l((t0) receiver);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + o0.d(receiver.getClass())).toString());
        }

        public static boolean R(@NotNull b bVar, @NotNull e4.b receiver) {
            g0.p(receiver, "$receiver");
            return receiver instanceof kotlin.reflect.jvm.internal.impl.resolve.calls.inference.a;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static boolean S(@NotNull b bVar, @NotNull e4.i receiver) {
            g0.p(receiver, "$receiver");
            if (receiver instanceof t0) {
                return kotlin.reflect.jvm.internal.impl.builtins.j.t0((t0) receiver);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + o0.d(receiver.getClass())).toString());
        }

        public static boolean T(@NotNull b bVar, @NotNull e4.b receiver) {
            g0.p(receiver, "$receiver");
            if (receiver instanceof i) {
                return ((i) receiver).U0();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + o0.d(receiver.getClass())).toString());
        }

        public static boolean U(@NotNull b bVar, @NotNull e4.g receiver) {
            g0.p(receiver, "$receiver");
            if (receiver instanceof t0) {
                return receiver instanceof d1;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + o0.d(receiver.getClass())).toString());
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static boolean V(@NotNull b bVar, @NotNull e4.h receiver) {
            g0.p(receiver, "$receiver");
            if (receiver instanceof e1) {
                if (x0.a((t0) receiver)) {
                    return false;
                }
                e1 e1Var = (e1) receiver;
                if (e1Var.I0().c() instanceof i1) {
                    return false;
                }
                return e1Var.I0().c() != null || (receiver instanceof kotlin.reflect.jvm.internal.impl.resolve.calls.inference.a) || (receiver instanceof i) || (receiver instanceof kotlin.reflect.jvm.internal.impl.types.z) || (e1Var.I0() instanceof kotlin.reflect.jvm.internal.impl.resolve.constants.q) || W(bVar, (e4.i) receiver);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + o0.d(receiver.getClass())).toString());
        }

        private static boolean W(b bVar, e4.i iVar) {
            return (iVar instanceof h1) && bVar.b(((h1) iVar).T());
        }

        public static boolean X(@NotNull b bVar, @NotNull e4.l receiver) {
            g0.p(receiver, "$receiver");
            if (receiver instanceof c2) {
                return ((c2) receiver).b();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + o0.d(receiver.getClass())).toString());
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static boolean Y(@NotNull b bVar, @NotNull e4.h receiver) {
            g0.p(receiver, "$receiver");
            if (receiver instanceof e1) {
                return kotlin.reflect.jvm.internal.impl.types.typeUtil.e.v((t0) receiver);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + o0.d(receiver.getClass())).toString());
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static boolean Z(@NotNull b bVar, @NotNull e4.h receiver) {
            g0.p(receiver, "$receiver");
            if (receiver instanceof e1) {
                return kotlin.reflect.jvm.internal.impl.types.typeUtil.e.w((t0) receiver);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + o0.d(receiver.getClass())).toString());
        }

        public static boolean a(@NotNull b bVar, @NotNull e4.o c12, @NotNull e4.o c22) {
            g0.p(c12, "c1");
            g0.p(c22, "c2");
            if (!(c12 instanceof w1)) {
                throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + c12 + ", " + o0.d(c12.getClass())).toString());
            }
            if (c22 instanceof w1) {
                return g0.g(c12, c22);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + c22 + ", " + o0.d(c22.getClass())).toString());
        }

        public static boolean a0(@NotNull b bVar, @NotNull e4.g receiver) {
            g0.p(receiver, "$receiver");
            return (receiver instanceof m2) && (((m2) receiver).I0() instanceof r);
        }

        public static int b(@NotNull b bVar, @NotNull e4.g receiver) {
            g0.p(receiver, "$receiver");
            if (receiver instanceof t0) {
                return ((t0) receiver).G0().size();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + o0.d(receiver.getClass())).toString());
        }

        public static boolean b0(@NotNull b bVar, @NotNull e4.o receiver) {
            g0.p(receiver, "$receiver");
            if (receiver instanceof w1) {
                kotlin.reflect.jvm.internal.impl.descriptors.f c6 = ((w1) receiver).c();
                return c6 != null && kotlin.reflect.jvm.internal.impl.builtins.j.C0(c6);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + o0.d(receiver.getClass())).toString());
        }

        @NotNull
        public static e4.k c(@NotNull b bVar, @NotNull e4.h receiver) {
            g0.p(receiver, "$receiver");
            if (receiver instanceof e1) {
                return (e4.k) receiver;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + o0.d(receiver.getClass())).toString());
        }

        @NotNull
        public static e4.i c0(@NotNull b bVar, @NotNull e4.e receiver) {
            g0.p(receiver, "$receiver");
            if (receiver instanceof k0) {
                return ((k0) receiver).Q0();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + o0.d(receiver.getClass())).toString());
        }

        @Nullable
        public static e4.b d(@NotNull b bVar, @NotNull e4.i receiver) {
            g0.p(receiver, "$receiver");
            if (receiver instanceof e1) {
                if (receiver instanceof h1) {
                    return bVar.d(((h1) receiver).T());
                }
                if (receiver instanceof i) {
                    return (i) receiver;
                }
                return null;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + o0.d(receiver.getClass())).toString());
        }

        @Nullable
        public static e4.g d0(@NotNull b bVar, @NotNull e4.b receiver) {
            g0.p(receiver, "$receiver");
            if (receiver instanceof i) {
                return ((i) receiver).T0();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + o0.d(receiver.getClass())).toString());
        }

        @Nullable
        public static e4.c e(@NotNull b bVar, @NotNull e4.h receiver) {
            g0.p(receiver, "$receiver");
            if (receiver instanceof e1) {
                if (receiver instanceof kotlin.reflect.jvm.internal.impl.types.z) {
                    return (kotlin.reflect.jvm.internal.impl.types.z) receiver;
                }
                return null;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + o0.d(receiver.getClass())).toString());
        }

        @NotNull
        public static e4.g e0(@NotNull b bVar, @NotNull e4.g receiver, boolean z5) {
            m2 b6;
            g0.p(receiver, "$receiver");
            if (receiver instanceof m2) {
                b6 = c.b((m2) receiver);
                return b6;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + o0.d(receiver.getClass())).toString());
        }

        @Nullable
        public static e4.d f(@NotNull b bVar, @NotNull e4.e receiver) {
            g0.p(receiver, "$receiver");
            if (receiver instanceof k0) {
                if (receiver instanceof f0) {
                    return (f0) receiver;
                }
                return null;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + o0.d(receiver.getClass())).toString());
        }

        @NotNull
        public static TypeCheckerState f0(@NotNull b bVar, boolean z5, boolean z6, boolean z7) {
            return kotlin.reflect.jvm.internal.impl.types.checker.a.b(z5, z6, bVar, null, null, 24, null);
        }

        @Nullable
        public static e4.e g(@NotNull b bVar, @NotNull e4.g receiver) {
            g0.p(receiver, "$receiver");
            if (receiver instanceof t0) {
                m2 L0 = ((t0) receiver).L0();
                if (L0 instanceof k0) {
                    return (k0) L0;
                }
                return null;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + o0.d(receiver.getClass())).toString());
        }

        @NotNull
        public static e4.i g0(@NotNull b bVar, @NotNull e4.c receiver) {
            g0.p(receiver, "$receiver");
            if (receiver instanceof kotlin.reflect.jvm.internal.impl.types.z) {
                return ((kotlin.reflect.jvm.internal.impl.types.z) receiver).U0();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + o0.d(receiver.getClass())).toString());
        }

        @Nullable
        public static e4.g getType(@NotNull b bVar, @NotNull e4.l receiver) {
            g0.p(receiver, "$receiver");
            if (bVar.g(receiver)) {
                return null;
            }
            if (receiver instanceof c2) {
                return ((c2) receiver).getType().L0();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + o0.d(receiver.getClass())).toString());
        }

        @Nullable
        public static e4.i h(@NotNull b bVar, @NotNull e4.g receiver) {
            g0.p(receiver, "$receiver");
            if (receiver instanceof t0) {
                m2 L0 = ((t0) receiver).L0();
                if (L0 instanceof e1) {
                    return (e1) L0;
                }
                return null;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + o0.d(receiver.getClass())).toString());
        }

        public static int h0(@NotNull b bVar, @NotNull e4.o receiver) {
            g0.p(receiver, "$receiver");
            if (receiver instanceof w1) {
                return ((w1) receiver).getParameters().size();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + o0.d(receiver.getClass())).toString());
        }

        @NotNull
        public static e4.l i(@NotNull b bVar, @NotNull e4.g receiver) {
            g0.p(receiver, "$receiver");
            if (receiver instanceof t0) {
                return kotlin.reflect.jvm.internal.impl.types.typeUtil.e.e((t0) receiver);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + o0.d(receiver.getClass())).toString());
        }

        @NotNull
        public static Collection<e4.g> i0(@NotNull b bVar, @NotNull e4.h receiver) {
            g0.p(receiver, "$receiver");
            e4.o c6 = bVar.c(receiver);
            if (c6 instanceof kotlin.reflect.jvm.internal.impl.resolve.constants.q) {
                return ((kotlin.reflect.jvm.internal.impl.resolve.constants.q) c6).j();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + o0.d(receiver.getClass())).toString());
        }

        @Nullable
        public static e1 j(@NotNull b bVar, @NotNull e4.h type, @NotNull CaptureStatus status) {
            g0.p(type, "type");
            g0.p(status, "status");
            if (type instanceof e1) {
                return o.b((e1) type, status);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + type + ", " + o0.d(type.getClass())).toString());
        }

        @NotNull
        public static e4.l j0(@NotNull b bVar, @NotNull e4.a receiver) {
            g0.p(receiver, "$receiver");
            if (receiver instanceof n) {
                return ((n) receiver).getProjection();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + o0.d(receiver.getClass())).toString());
        }

        @NotNull
        public static CaptureStatus k(@NotNull b bVar, @NotNull e4.b receiver) {
            g0.p(receiver, "$receiver");
            if (receiver instanceof i) {
                return ((i) receiver).R0();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + o0.d(receiver.getClass())).toString());
        }

        /* JADX WARN: Multi-variable type inference failed */
        @NotNull
        public static TypeCheckerState.b k0(@NotNull b bVar, @NotNull e4.h type) {
            g0.p(type, "type");
            if (type instanceof e1) {
                return new C0921a(bVar, x1.f47366c.a((t0) type).c());
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + type + ", " + o0.d(type.getClass())).toString());
        }

        @NotNull
        public static e4.g l(@NotNull b bVar, @NotNull e4.h lowerBound, @NotNull e4.h upperBound) {
            g0.p(lowerBound, "lowerBound");
            g0.p(upperBound, "upperBound");
            if (!(lowerBound instanceof e1)) {
                throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + bVar + ", " + o0.d(bVar.getClass())).toString());
            }
            if (upperBound instanceof e1) {
                return w0.e((e1) lowerBound, (e1) upperBound);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + bVar + ", " + o0.d(bVar.getClass())).toString());
        }

        @NotNull
        public static Collection<e4.g> l0(@NotNull b bVar, @NotNull e4.o receiver) {
            g0.p(receiver, "$receiver");
            if (receiver instanceof w1) {
                Collection<t0> i6 = ((w1) receiver).i();
                g0.o(i6, "getSupertypes(...)");
                return i6;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + o0.d(receiver.getClass())).toString());
        }

        @NotNull
        public static e4.l m(@NotNull b bVar, @NotNull e4.g receiver, int i6) {
            g0.p(receiver, "$receiver");
            if (receiver instanceof t0) {
                return ((t0) receiver).G0().get(i6);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + o0.d(receiver.getClass())).toString());
        }

        @NotNull
        public static e4.a m0(@NotNull b bVar, @NotNull e4.b receiver) {
            g0.p(receiver, "$receiver");
            if (receiver instanceof i) {
                return ((i) receiver).I0();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + o0.d(receiver.getClass())).toString());
        }

        @NotNull
        public static List<e4.l> n(@NotNull b bVar, @NotNull e4.g receiver) {
            g0.p(receiver, "$receiver");
            if (receiver instanceof t0) {
                return ((t0) receiver).G0();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + o0.d(receiver.getClass())).toString());
        }

        @NotNull
        public static e4.o n0(@NotNull b bVar, @NotNull e4.h receiver) {
            g0.p(receiver, "$receiver");
            if (receiver instanceof e1) {
                return ((e1) receiver).I0();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + o0.d(receiver.getClass())).toString());
        }

        @NotNull
        public static kotlin.reflect.jvm.internal.impl.name.d o(@NotNull b bVar, @NotNull e4.o receiver) {
            g0.p(receiver, "$receiver");
            if (receiver instanceof w1) {
                kotlin.reflect.jvm.internal.impl.descriptors.f c6 = ((w1) receiver).c();
                g0.n(c6, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                return kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.e.p((kotlin.reflect.jvm.internal.impl.descriptors.d) c6);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + o0.d(receiver.getClass())).toString());
        }

        @NotNull
        public static e4.i o0(@NotNull b bVar, @NotNull e4.e receiver) {
            g0.p(receiver, "$receiver");
            if (receiver instanceof k0) {
                return ((k0) receiver).R0();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + o0.d(receiver.getClass())).toString());
        }

        @NotNull
        public static e4.p p(@NotNull b bVar, @NotNull e4.o receiver, int i6) {
            g0.p(receiver, "$receiver");
            if (receiver instanceof w1) {
                j1 j1Var = ((w1) receiver).getParameters().get(i6);
                g0.o(j1Var, "get(...)");
                return j1Var;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + o0.d(receiver.getClass())).toString());
        }

        @NotNull
        public static e4.g p0(@NotNull b bVar, @NotNull e4.g receiver, boolean z5) {
            g0.p(receiver, "$receiver");
            if (receiver instanceof e4.h) {
                return bVar.a((e4.h) receiver, z5);
            }
            if (!(receiver instanceof e4.e)) {
                throw new IllegalStateException("sealed");
            }
            e4.e eVar = (e4.e) receiver;
            return bVar.f0(bVar.a((e4.h) bVar.e(eVar), z5), bVar.a((e4.h) bVar.h(eVar), z5));
        }

        @NotNull
        public static List<e4.p> q(@NotNull b bVar, @NotNull e4.o receiver) {
            g0.p(receiver, "$receiver");
            if (receiver instanceof w1) {
                List<j1> parameters = ((w1) receiver).getParameters();
                g0.o(parameters, "getParameters(...)");
                return parameters;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + o0.d(receiver.getClass())).toString());
        }

        @NotNull
        public static e4.i q0(@NotNull b bVar, @NotNull e4.h receiver, boolean z5) {
            g0.p(receiver, "$receiver");
            if (receiver instanceof e1) {
                return ((e1) receiver).M0(z5);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + o0.d(receiver.getClass())).toString());
        }

        @Nullable
        public static PrimitiveType r(@NotNull b bVar, @NotNull e4.o receiver) {
            g0.p(receiver, "$receiver");
            if (receiver instanceof w1) {
                kotlin.reflect.jvm.internal.impl.descriptors.f c6 = ((w1) receiver).c();
                g0.n(c6, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                return kotlin.reflect.jvm.internal.impl.builtins.j.Q((kotlin.reflect.jvm.internal.impl.descriptors.d) c6);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + o0.d(receiver.getClass())).toString());
        }

        @Nullable
        public static PrimitiveType s(@NotNull b bVar, @NotNull e4.o receiver) {
            g0.p(receiver, "$receiver");
            if (receiver instanceof w1) {
                kotlin.reflect.jvm.internal.impl.descriptors.f c6 = ((w1) receiver).c();
                g0.n(c6, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                return kotlin.reflect.jvm.internal.impl.builtins.j.T((kotlin.reflect.jvm.internal.impl.descriptors.d) c6);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + o0.d(receiver.getClass())).toString());
        }

        @NotNull
        public static e4.g t(@NotNull b bVar, @NotNull e4.p receiver) {
            g0.p(receiver, "$receiver");
            if (receiver instanceof j1) {
                return kotlin.reflect.jvm.internal.impl.types.typeUtil.e.p((j1) receiver);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + o0.d(receiver.getClass())).toString());
        }

        @Nullable
        public static e4.p u(@NotNull b bVar, @NotNull e4.w receiver) {
            g0.p(receiver, "$receiver");
            if (receiver instanceof r) {
                return ((r) receiver).b();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + o0.d(receiver.getClass())).toString());
        }

        @Nullable
        public static e4.p v(@NotNull b bVar, @NotNull e4.o receiver) {
            g0.p(receiver, "$receiver");
            if (receiver instanceof w1) {
                kotlin.reflect.jvm.internal.impl.descriptors.f c6 = ((w1) receiver).c();
                if (c6 instanceof j1) {
                    return (j1) c6;
                }
                return null;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + o0.d(receiver.getClass())).toString());
        }

        @Nullable
        public static e4.g w(@NotNull b bVar, @NotNull e4.g receiver) {
            g0.p(receiver, "$receiver");
            if (receiver instanceof t0) {
                return kotlin.reflect.jvm.internal.impl.resolve.j.k((t0) receiver);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + o0.d(receiver.getClass())).toString());
        }

        @NotNull
        public static List<e4.g> x(@NotNull b bVar, @NotNull e4.p receiver) {
            g0.p(receiver, "$receiver");
            if (receiver instanceof j1) {
                List<t0> upperBounds = ((j1) receiver).getUpperBounds();
                g0.o(upperBounds, "getUpperBounds(...)");
                return upperBounds;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + o0.d(receiver.getClass())).toString());
        }

        @NotNull
        public static TypeVariance y(@NotNull b bVar, @NotNull e4.l receiver) {
            g0.p(receiver, "$receiver");
            if (receiver instanceof c2) {
                Variance c6 = ((c2) receiver).c();
                g0.o(c6, "getProjectionKind(...)");
                return e4.s.a(c6);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + o0.d(receiver.getClass())).toString());
        }

        @NotNull
        public static TypeVariance z(@NotNull b bVar, @NotNull e4.p receiver) {
            g0.p(receiver, "$receiver");
            if (receiver instanceof j1) {
                Variance l6 = ((j1) receiver).l();
                g0.o(l6, "getVariance(...)");
                return e4.s.a(l6);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + o0.d(receiver.getClass())).toString());
        }
    }

    @Override // e4.r
    @NotNull
    e4.i a(@NotNull e4.h hVar, boolean z5);

    @Override // e4.r
    boolean b(@NotNull e4.h hVar);

    @Override // e4.r
    @NotNull
    e4.o c(@NotNull e4.h hVar);

    @Override // e4.r
    @Nullable
    e4.b d(@NotNull e4.i iVar);

    @Override // e4.r
    @NotNull
    e4.i e(@NotNull e4.e eVar);

    @Override // e4.r
    @Nullable
    e4.i f(@NotNull e4.g gVar);

    @NotNull
    e4.g f0(@NotNull e4.h hVar, @NotNull e4.h hVar2);

    @Override // e4.r
    boolean g(@NotNull e4.l lVar);

    @Override // e4.r
    @NotNull
    e4.i h(@NotNull e4.e eVar);
}
