package kotlin.reflect.jvm.internal.impl.builtins;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.builtins.o;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.f0;
import kotlin.reflect.jvm.internal.impl.descriptors.l0;
import kotlin.reflect.jvm.internal.impl.descriptors.s0;
import kotlin.reflect.jvm.internal.impl.descriptors.w0;
import kotlin.reflect.jvm.internal.impl.descriptors.x;
import kotlin.reflect.jvm.internal.impl.descriptors.x0;
import kotlin.reflect.jvm.internal.impl.descriptors.y0;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.e1;
import kotlin.reflect.jvm.internal.impl.types.e2;
import kotlin.reflect.jvm.internal.impl.types.j2;
import kotlin.reflect.jvm.internal.impl.types.t0;
import kotlin.reflect.jvm.internal.impl.types.u1;
import kotlin.reflect.jvm.internal.impl.types.w1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import r3.a;
import r3.c;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public abstract class j {

    /* renamed from: g, reason: collision with root package name */
    public static final kotlin.reflect.jvm.internal.impl.name.f f44436g = kotlin.reflect.jvm.internal.impl.name.f.k("<built-ins module>");

    /* renamed from: h, reason: collision with root package name */
    static final /* synthetic */ boolean f44437h = false;

    /* renamed from: a, reason: collision with root package name */
    private f0 f44438a;

    /* renamed from: b, reason: collision with root package name */
    private kotlin.reflect.jvm.internal.impl.storage.i<f0> f44439b;

    /* renamed from: c, reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.storage.i<e> f44440c;

    /* renamed from: d, reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.storage.i<Collection<s0>> f44441d;

    /* renamed from: e, reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.storage.g<kotlin.reflect.jvm.internal.impl.name.f, kotlin.reflect.jvm.internal.impl.descriptors.d> f44442e;

    /* renamed from: f, reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.storage.n f44443f;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements Function0<Collection<s0>> {
        a() {
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Collection<s0> invoke() {
            return Arrays.asList(j.this.s().M(o.B), j.this.s().M(o.D), j.this.s().M(o.E), j.this.s().M(o.C));
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b implements Function0<e> {
        b() {
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public e invoke() {
            EnumMap enumMap = new EnumMap(PrimitiveType.class);
            HashMap hashMap = new HashMap();
            HashMap hashMap2 = new HashMap();
            for (PrimitiveType primitiveType : PrimitiveType.values()) {
                e1 r5 = j.this.r(primitiveType.getTypeName().b());
                e1 r6 = j.this.r(primitiveType.getArrayTypeName().b());
                enumMap.put((EnumMap) primitiveType, (PrimitiveType) r6);
                hashMap.put(r5, r6);
                hashMap2.put(r6, r5);
            }
            return new e(enumMap, hashMap, hashMap2, null);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class c implements Function1<kotlin.reflect.jvm.internal.impl.name.f, kotlin.reflect.jvm.internal.impl.descriptors.d> {
        c() {
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public kotlin.reflect.jvm.internal.impl.descriptors.d invoke(kotlin.reflect.jvm.internal.impl.name.f fVar) {
            kotlin.reflect.jvm.internal.impl.descriptors.f g6 = j.this.t().g(fVar, NoLookupLocation.FROM_BUILTINS);
            if (g6 == null) {
                throw new AssertionError("Built-in class " + o.B.b(fVar) + " is not found");
            }
            if (g6 instanceof kotlin.reflect.jvm.internal.impl.descriptors.d) {
                return (kotlin.reflect.jvm.internal.impl.descriptors.d) g6;
            }
            throw new AssertionError("Must be a class descriptor " + fVar + ", but was " + g6);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class d implements Function0<Void> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ f0 f44447a;

        d(f0 f0Var) {
            this.f44447a = f0Var;
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void invoke() {
            if (j.this.f44438a == null) {
                j.this.f44438a = this.f44447a;
                return null;
            }
            throw new AssertionError("Built-ins module is already set: " + j.this.f44438a + " (attempting to reset to " + this.f44447a + ")");
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class e {

        /* renamed from: a, reason: collision with root package name */
        public final Map<PrimitiveType, e1> f44449a;

        /* renamed from: b, reason: collision with root package name */
        public final Map<t0, e1> f44450b;

        /* renamed from: c, reason: collision with root package name */
        public final Map<e1, e1> f44451c;

        /* synthetic */ e(Map map, Map map2, Map map3, a aVar) {
            this(map, map2, map3);
        }

        private static /* synthetic */ void a(int i6) {
            Object[] objArr = new Object[3];
            if (i6 == 1) {
                objArr[0] = "primitiveKotlinTypeToKotlinArrayType";
            } else if (i6 != 2) {
                objArr[0] = "primitiveTypeToArrayKotlinType";
            } else {
                objArr[0] = "kotlinArrayTypeToPrimitiveKotlinType";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns$Primitives";
            objArr[2] = "<init>";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        private e(@NotNull Map<PrimitiveType, e1> map, @NotNull Map<t0, e1> map2, @NotNull Map<e1, e1> map3) {
            if (map == null) {
                a(0);
            }
            if (map2 == null) {
                a(1);
            }
            if (map3 == null) {
                a(2);
            }
            this.f44449a = map;
            this.f44450b = map2;
            this.f44451c = map3;
        }
    }

    protected j(@NotNull kotlin.reflect.jvm.internal.impl.storage.n nVar) {
        if (nVar == null) {
            a(0);
        }
        this.f44443f = nVar;
        this.f44441d = nVar.e(new a());
        this.f44440c = nVar.e(new b());
        this.f44442e = nVar.i(new c());
    }

    public static boolean A0(@NotNull t0 t0Var) {
        if (t0Var == null) {
            a(131);
        }
        return j0(t0Var, o.a.K0.i());
    }

    @Nullable
    private static t0 B(@NotNull t0 t0Var, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.f0 f0Var) {
        kotlin.reflect.jvm.internal.impl.name.b n6;
        kotlin.reflect.jvm.internal.impl.name.b a6;
        kotlin.reflect.jvm.internal.impl.descriptors.d b6;
        if (t0Var == null) {
            a(71);
        }
        if (f0Var == null) {
            a(72);
        }
        kotlin.reflect.jvm.internal.impl.descriptors.f c6 = t0Var.I0().c();
        if (c6 == null) {
            return null;
        }
        q qVar = q.f44636a;
        if (!qVar.b(c6.getName()) || (n6 = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.e.n(c6)) == null || (a6 = qVar.a(n6)) == null || (b6 = x.b(f0Var, a6)) == null) {
            return null;
        }
        return b6.s();
    }

    public static boolean B0(@NotNull t0 t0Var) {
        if (t0Var == null) {
            a(129);
        }
        return j0(t0Var, o.a.I0.i());
    }

    public static boolean C0(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.k kVar) {
        if (kVar == null) {
            a(10);
        }
        while (kVar != null) {
            if (kVar instanceof l0) {
                return ((l0) kVar).d().h(o.A);
            }
            kVar = kVar.b();
        }
        return false;
    }

    public static boolean D0(@NotNull t0 t0Var) {
        if (t0Var == null) {
            a(MediaPlayer.MEDIA_PLAYER_OPTION_META_DATA_INFO);
        }
        return n0(t0Var, o.a.f44593f);
    }

    public static boolean E0(@NotNull t0 t0Var) {
        if (t0Var == null) {
            a(MediaPlayer.MEDIA_PLAYER_OPTION_MEDIA_CODEC_SIDE_DATA);
        }
        return y0(t0Var) || B0(t0Var) || z0(t0Var) || A0(t0Var);
    }

    @Nullable
    public static PrimitiveType O(@NotNull t0 t0Var) {
        if (t0Var == null) {
            a(92);
        }
        kotlin.reflect.jvm.internal.impl.descriptors.f c6 = t0Var.I0().c();
        if (c6 == null) {
            return null;
        }
        return Q(c6);
    }

    @Nullable
    public static PrimitiveType Q(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.k kVar) {
        if (kVar == null) {
            a(77);
        }
        if (o.a.T0.contains(kVar.getName())) {
            return o.a.V0.get(kotlin.reflect.jvm.internal.impl.resolve.i.m(kVar));
        }
        return null;
    }

    @NotNull
    private kotlin.reflect.jvm.internal.impl.descriptors.d R(@NotNull PrimitiveType primitiveType) {
        if (primitiveType == null) {
            a(16);
        }
        return q(primitiveType.getTypeName().b());
    }

    @Nullable
    public static PrimitiveType T(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.k kVar) {
        if (kVar == null) {
            a(76);
        }
        if (o.a.S0.contains(kVar.getName())) {
            return o.a.U0.get(kotlin.reflect.jvm.internal.impl.resolve.i.m(kVar));
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x036f  */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0375  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x037b  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0381  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0387  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x038d  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0393  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0399  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x039f  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x03a5  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x03ab  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x03b0  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x03b5  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x03b8  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x03bb  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x03c0  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x03c5  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x03ca  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x03cd  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x03d2  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x03d7  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x03da  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x03dd  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x03e0  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x03e5  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x03ea  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x03ed  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x03f0  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x03f5  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x03fa  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x03ff  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0409 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:142:0x041c  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x023c  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:213:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:215:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:217:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:219:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:220:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:223:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:224:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:225:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:226:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:227:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:228:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:229:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:230:0x0058 A[FALL_THROUGH] */
    /* JADX WARN: Removed duplicated region for block: B:231:0x0035 A[FALL_THROUGH] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0243  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0249  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x024f  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0255  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x025b  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0261  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0267  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x026d  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0273  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0279  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x027f  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0285  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x028b  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0291  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0297  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x029d  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x02a3  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x02a9  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x02af  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x02b5  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x02bb  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x02c1  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x02c7  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x02cd  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x02d3  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x02d9  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x02df  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x02e5  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x02eb  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x02f1  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x02f7  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x02fd  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0303  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0309  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x030f  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0315  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x031b  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0321  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0327  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x032d  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0333  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0339  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x033f  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0345  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x034b  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0351  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0357  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x035d  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0363  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0369  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static /* synthetic */ void a(int r23) {
        /*
            Method dump skipped, instructions count: 2222
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.builtins.j.a(int):void");
    }

    public static boolean b0(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.d dVar) {
        if (dVar == null) {
            a(108);
        }
        return e(dVar, o.a.f44585b);
    }

    public static boolean c0(@NotNull t0 t0Var) {
        if (t0Var == null) {
            a(MediaPlayer.MEDIA_PLAYER_OPTION_RENDER_DEVICE);
        }
        return i0(t0Var, o.a.f44585b);
    }

    public static boolean d0(@NotNull t0 t0Var) {
        if (t0Var == null) {
            a(88);
        }
        return i0(t0Var, o.a.f44599i);
    }

    private static boolean e(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.f fVar, @NotNull kotlin.reflect.jvm.internal.impl.name.d dVar) {
        if (fVar == null) {
            a(103);
        }
        if (dVar == null) {
            a(104);
        }
        return fVar.getName().equals(dVar.j()) && dVar.equals(kotlin.reflect.jvm.internal.impl.resolve.i.m(fVar));
    }

    public static boolean e0(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.d dVar) {
        if (dVar == null) {
            a(89);
        }
        return e(dVar, o.a.f44599i) || Q(dVar) != null;
    }

    public static boolean f0(@NotNull t0 t0Var) {
        if (t0Var == null) {
            a(90);
        }
        return d0(t0Var) || r0(t0Var);
    }

    public static boolean g0(@NotNull t0 t0Var) {
        if (t0Var == null) {
            a(110);
        }
        return j0(t0Var, o.a.f44601j);
    }

    public static boolean h0(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.k kVar) {
        if (kVar == null) {
            a(9);
        }
        return kotlin.reflect.jvm.internal.impl.resolve.i.r(kVar, kotlin.reflect.jvm.internal.impl.builtins.c.class, false) != null;
    }

    private static boolean i0(@NotNull t0 t0Var, @NotNull kotlin.reflect.jvm.internal.impl.name.d dVar) {
        if (t0Var == null) {
            a(97);
        }
        if (dVar == null) {
            a(98);
        }
        return x0(t0Var.I0(), dVar);
    }

    private static boolean j0(@NotNull t0 t0Var, @NotNull kotlin.reflect.jvm.internal.impl.name.d dVar) {
        if (t0Var == null) {
            a(MediaPlayer.MEDIA_PLAYER_OPTION_SET_MAX_FPS);
        }
        if (dVar == null) {
            a(MediaPlayer.MEDIA_PLAYER_OPTION_SET_PIPE_START_OFFSET);
        }
        return i0(t0Var, dVar) && !t0Var.J0();
    }

    public static boolean k0(@NotNull t0 t0Var) {
        if (t0Var == null) {
            a(MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_CODEC_ID);
        }
        return q0(t0Var);
    }

    public static boolean l0(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.k kVar) {
        if (kVar == null) {
            a(160);
        }
        if (kVar.a().getAnnotations().l(o.a.f44631y)) {
            return true;
        }
        if (kVar instanceof w0) {
            w0 w0Var = (w0) kVar;
            boolean C = w0Var.C();
            x0 getter = w0Var.getGetter();
            y0 setter = w0Var.getSetter();
            if (getter != null && l0(getter) && (!C || (setter != null && l0(setter)))) {
                return true;
            }
        }
        return false;
    }

    public static boolean m0(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.d dVar) {
        if (dVar == null) {
            a(158);
        }
        return e(dVar, o.a.f44606l0);
    }

    private static boolean n0(@NotNull t0 t0Var, @NotNull kotlin.reflect.jvm.internal.impl.name.d dVar) {
        if (t0Var == null) {
            a(105);
        }
        if (dVar == null) {
            a(106);
        }
        return !t0Var.J0() && i0(t0Var, dVar);
    }

    public static boolean o0(@NotNull t0 t0Var) {
        if (t0Var == null) {
            a(MediaPlayer.MEDIA_PLAYER_OPTION_SET_PIPE_DECLARE_LENGTH);
        }
        return p0(t0Var) && !j2.l(t0Var);
    }

    public static boolean p0(@NotNull t0 t0Var) {
        if (t0Var == null) {
            a(MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_END_TIME);
        }
        return i0(t0Var, o.a.f44587c);
    }

    @NotNull
    private kotlin.reflect.jvm.internal.impl.descriptors.d q(@NotNull String str) {
        if (str == null) {
            a(14);
        }
        kotlin.reflect.jvm.internal.impl.descriptors.d invoke = this.f44442e.invoke(kotlin.reflect.jvm.internal.impl.name.f.h(str));
        if (invoke == null) {
            a(15);
        }
        return invoke;
    }

    public static boolean q0(@NotNull t0 t0Var) {
        if (t0Var == null) {
            a(140);
        }
        return c0(t0Var) && t0Var.J0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NotNull
    public e1 r(@NotNull String str) {
        if (str == null) {
            a(47);
        }
        e1 s5 = q(str).s();
        if (s5 == null) {
            a(48);
        }
        return s5;
    }

    public static boolean r0(@NotNull t0 t0Var) {
        if (t0Var == null) {
            a(91);
        }
        kotlin.reflect.jvm.internal.impl.descriptors.f c6 = t0Var.I0().c();
        return (c6 == null || Q(c6) == null) ? false : true;
    }

    public static boolean s0(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.d dVar) {
        if (dVar == null) {
            a(96);
        }
        return T(dVar) != null;
    }

    public static boolean t0(@NotNull t0 t0Var) {
        if (t0Var == null) {
            a(94);
        }
        return !t0Var.J0() && u0(t0Var);
    }

    public static boolean u0(@NotNull t0 t0Var) {
        if (t0Var == null) {
            a(95);
        }
        kotlin.reflect.jvm.internal.impl.descriptors.f c6 = t0Var.I0().c();
        return (c6 instanceof kotlin.reflect.jvm.internal.impl.descriptors.d) && s0((kotlin.reflect.jvm.internal.impl.descriptors.d) c6);
    }

    public static boolean v0(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.d dVar) {
        if (dVar == null) {
            a(107);
        }
        return e(dVar, o.a.f44585b) || e(dVar, o.a.f44587c);
    }

    public static boolean w0(@Nullable t0 t0Var) {
        return t0Var != null && n0(t0Var, o.a.f44597h);
    }

    public static boolean x0(@NotNull w1 w1Var, @NotNull kotlin.reflect.jvm.internal.impl.name.d dVar) {
        if (w1Var == null) {
            a(101);
        }
        if (dVar == null) {
            a(102);
        }
        kotlin.reflect.jvm.internal.impl.descriptors.f c6 = w1Var.c();
        return (c6 instanceof kotlin.reflect.jvm.internal.impl.descriptors.d) && e(c6, dVar);
    }

    public static boolean y0(@NotNull t0 t0Var) {
        if (t0Var == null) {
            a(128);
        }
        return j0(t0Var, o.a.H0.i());
    }

    public static boolean z0(@NotNull t0 t0Var) {
        if (t0Var == null) {
            a(MediaPlayer.MEDIA_PLAYER_OPTION_DEFAULT_VIDEO_BITRATE);
        }
        return j0(t0Var, o.a.J0.i());
    }

    @NotNull
    public e1 A() {
        e1 S = S(PrimitiveType.DOUBLE);
        if (S == null) {
            a(62);
        }
        return S;
    }

    @NotNull
    public e1 C() {
        e1 S = S(PrimitiveType.FLOAT);
        if (S == null) {
            a(61);
        }
        return S;
    }

    @NotNull
    public e1 E() {
        e1 S = S(PrimitiveType.INT);
        if (S == null) {
            a(59);
        }
        return S;
    }

    @NotNull
    public kotlin.reflect.jvm.internal.impl.descriptors.d F() {
        kotlin.reflect.jvm.internal.impl.descriptors.d p5 = p(o.a.f44606l0.m());
        if (p5 == null) {
            a(21);
        }
        return p5;
    }

    public void F0(@NotNull f0 f0Var) {
        if (f0Var == null) {
            a(1);
        }
        this.f44443f.f(new d(f0Var));
    }

    @NotNull
    public e1 G() {
        e1 S = S(PrimitiveType.LONG);
        if (S == null) {
            a(60);
        }
        return S;
    }

    @NotNull
    public kotlin.reflect.jvm.internal.impl.descriptors.d H() {
        return q("Nothing");
    }

    @NotNull
    public kotlin.reflect.jvm.internal.impl.descriptors.d L() {
        return q("Number");
    }

    @NotNull
    protected r3.c N() {
        c.b bVar = c.b.f51991a;
        if (bVar == null) {
            a(4);
        }
        return bVar;
    }

    @NotNull
    public e1 P(@NotNull PrimitiveType primitiveType) {
        if (primitiveType == null) {
            a(73);
        }
        e1 e1Var = this.f44440c.invoke().f44449a.get(primitiveType);
        if (e1Var == null) {
            a(74);
        }
        return e1Var;
    }

    @NotNull
    public e1 S(@NotNull PrimitiveType primitiveType) {
        if (primitiveType == null) {
            a(54);
        }
        e1 s5 = R(primitiveType).s();
        if (s5 == null) {
            a(55);
        }
        return s5;
    }

    @NotNull
    public e1 U() {
        e1 S = S(PrimitiveType.SHORT);
        if (S == null) {
            a(58);
        }
        return S;
    }

    @NotNull
    protected kotlin.reflect.jvm.internal.impl.storage.n V() {
        kotlin.reflect.jvm.internal.impl.storage.n nVar = this.f44443f;
        if (nVar == null) {
            a(6);
        }
        return nVar;
    }

    @NotNull
    public kotlin.reflect.jvm.internal.impl.descriptors.d W() {
        return q("String");
    }

    @NotNull
    public kotlin.reflect.jvm.internal.impl.descriptors.d Y(int i6) {
        kotlin.reflect.jvm.internal.impl.descriptors.d p5 = p(o.f44575s.b(kotlin.reflect.jvm.internal.impl.name.f.h(o.d(i6))));
        if (p5 == null) {
            a(18);
        }
        return p5;
    }

    @NotNull
    public kotlin.reflect.jvm.internal.impl.descriptors.d Z() {
        return q("Unit");
    }

    protected void f(boolean z5) {
        f0 f0Var = new f0(f44436g, this.f44443f, this, null);
        this.f44438a = f0Var;
        f0Var.J0(kotlin.reflect.jvm.internal.impl.builtins.b.f44399a.c().a(this.f44443f, this.f44438a, w(), N(), g(), z5));
        f0 f0Var2 = this.f44438a;
        f0Var2.R0(f0Var2);
    }

    @NotNull
    protected r3.a g() {
        a.C1006a c1006a = a.C1006a.f51989a;
        if (c1006a == null) {
            a(3);
        }
        return c1006a;
    }

    @NotNull
    public kotlin.reflect.jvm.internal.impl.descriptors.d h() {
        return q("Any");
    }

    @NotNull
    public kotlin.reflect.jvm.internal.impl.descriptors.d j() {
        return q("Array");
    }

    @NotNull
    public t0 k(@NotNull t0 t0Var) {
        if (t0Var == null) {
            a(68);
        }
        t0 l6 = l(t0Var);
        if (l6 != null) {
            return l6;
        }
        throw new IllegalStateException("not array: " + t0Var);
    }

    @Nullable
    public t0 l(@NotNull t0 t0Var) {
        t0 B;
        if (t0Var == null) {
            a(70);
        }
        if (d0(t0Var)) {
            if (t0Var.G0().size() != 1) {
                return null;
            }
            return t0Var.G0().get(0).getType();
        }
        t0 n6 = j2.n(t0Var);
        e1 e1Var = this.f44440c.invoke().f44451c.get(n6);
        if (e1Var != null) {
            return e1Var;
        }
        kotlin.reflect.jvm.internal.impl.descriptors.f0 i6 = kotlin.reflect.jvm.internal.impl.resolve.i.i(n6);
        if (i6 == null || (B = B(n6, i6)) == null) {
            return null;
        }
        return B;
    }

    @NotNull
    public e1 m(@NotNull Variance variance, @NotNull t0 t0Var) {
        if (variance == null) {
            a(82);
        }
        if (t0Var == null) {
            a(83);
        }
        e1 n6 = n(variance, t0Var, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g.f44655q0.b());
        if (n6 == null) {
            a(84);
        }
        return n6;
    }

    @NotNull
    public e1 n(@NotNull Variance variance, @NotNull t0 t0Var, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar) {
        if (variance == null) {
            a(78);
        }
        if (t0Var == null) {
            a(79);
        }
        if (gVar == null) {
            a(80);
        }
        e1 h6 = kotlin.reflect.jvm.internal.impl.types.w0.h(u1.b(gVar), j(), Collections.singletonList(new e2(variance, t0Var)));
        if (h6 == null) {
            a(81);
        }
        return h6;
    }

    @NotNull
    public e1 o() {
        e1 S = S(PrimitiveType.BOOLEAN);
        if (S == null) {
            a(64);
        }
        return S;
    }

    @NotNull
    public kotlin.reflect.jvm.internal.impl.descriptors.d p(@NotNull kotlin.reflect.jvm.internal.impl.name.c cVar) {
        if (cVar == null) {
            a(12);
        }
        kotlin.reflect.jvm.internal.impl.descriptors.d d6 = kotlin.reflect.jvm.internal.impl.descriptors.q.d(s(), cVar, NoLookupLocation.FROM_BUILTINS);
        if (d6 == null) {
            a(13);
        }
        return d6;
    }

    @NotNull
    public f0 s() {
        if (this.f44438a == null) {
            this.f44438a = this.f44439b.invoke();
        }
        f0 f0Var = this.f44438a;
        if (f0Var == null) {
            a(7);
        }
        return f0Var;
    }

    @NotNull
    public e1 u() {
        e1 S = S(PrimitiveType.BYTE);
        if (S == null) {
            a(57);
        }
        return S;
    }

    @NotNull
    public e1 v() {
        e1 S = S(PrimitiveType.CHAR);
        if (S == null) {
            a(63);
        }
        return S;
    }

    @NotNull
    protected Iterable<r3.b> w() {
        List singletonList = Collections.singletonList(new kotlin.reflect.jvm.internal.impl.builtins.functions.a(this.f44443f, s()));
        if (singletonList == null) {
            a(5);
        }
        return singletonList;
    }

    @NotNull
    public kotlin.reflect.jvm.internal.impl.descriptors.d x() {
        kotlin.reflect.jvm.internal.impl.descriptors.d p5 = p(o.a.X);
        if (p5 == null) {
            a(35);
        }
        return p5;
    }

    @NotNull
    public kotlin.reflect.jvm.internal.impl.descriptors.d y() {
        return q("Comparable");
    }

    @NotNull
    public kotlin.reflect.jvm.internal.impl.descriptors.d D(int i6) {
        return q(o.b(i6));
    }

    @NotNull
    public e1 I() {
        e1 s5 = H().s();
        if (s5 == null) {
            a(49);
        }
        return s5;
    }

    @NotNull
    public e1 J() {
        e1 M0 = i().M0(true);
        if (M0 == null) {
            a(52);
        }
        return M0;
    }

    @NotNull
    public e1 K() {
        e1 M0 = I().M0(true);
        if (M0 == null) {
            a(50);
        }
        return M0;
    }

    @NotNull
    public e1 M() {
        e1 s5 = L().s();
        if (s5 == null) {
            a(56);
        }
        return s5;
    }

    @NotNull
    public e1 X() {
        e1 s5 = W().s();
        if (s5 == null) {
            a(66);
        }
        return s5;
    }

    @NotNull
    public e1 a0() {
        e1 s5 = Z().s();
        if (s5 == null) {
            a(65);
        }
        return s5;
    }

    @NotNull
    public e1 i() {
        e1 s5 = h().s();
        if (s5 == null) {
            a(51);
        }
        return s5;
    }

    @NotNull
    public kotlin.reflect.jvm.internal.impl.resolve.scopes.k t() {
        kotlin.reflect.jvm.internal.impl.resolve.scopes.k r5 = s().M(o.B).r();
        if (r5 == null) {
            a(11);
        }
        return r5;
    }

    @NotNull
    public e1 z() {
        e1 J = J();
        if (J == null) {
            a(53);
        }
        return J;
    }
}
