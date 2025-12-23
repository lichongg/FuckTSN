package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.o0;
import kotlin.reflect.jvm.internal.impl.descriptors.f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nJvmBuiltIns.kt\nKotlin\n*S Kotlin\n*F\n+ 1 JvmBuiltIns.kt\norg/jetbrains/kotlin/builtins/jvm/JvmBuiltIns\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 coreLib.kt\norg/jetbrains/kotlin/utils/CoreLibKt\n*L\n1#1,103:1\n1#2:104\n19#3:105\n*S KotlinDebug\n*F\n+ 1 JvmBuiltIns.kt\norg/jetbrains/kotlin/builtins/jvm/JvmBuiltIns\n*L\n80#1:105\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class JvmBuiltIns extends kotlin.reflect.jvm.internal.impl.builtins.j {

    /* renamed from: l, reason: collision with root package name */
    static final /* synthetic */ kotlin.reflect.n<Object>[] f44452l = {o0.u(new PropertyReference1Impl(JvmBuiltIns.class, "customizer", "getCustomizer()Lorg/jetbrains/kotlin/builtins/jvm/JvmBuiltInsCustomizer;", 0))};

    /* renamed from: i, reason: collision with root package name */
    @NotNull
    private final Kind f44453i;

    /* renamed from: j, reason: collision with root package name */
    @Nullable
    private Function0<a> f44454j;

    /* renamed from: k, reason: collision with root package name */
    @NotNull
    private final kotlin.reflect.jvm.internal.impl.storage.i f44455k;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class Kind {
        private static final /* synthetic */ kotlin.enums.a $ENTRIES;
        private static final /* synthetic */ Kind[] $VALUES;
        public static final Kind FROM_DEPENDENCIES = new Kind("FROM_DEPENDENCIES", 0);
        public static final Kind FROM_CLASS_LOADER = new Kind("FROM_CLASS_LOADER", 1);
        public static final Kind FALLBACK = new Kind("FALLBACK", 2);

        private static final /* synthetic */ Kind[] $values() {
            return new Kind[]{FROM_DEPENDENCIES, FROM_CLASS_LOADER, FALLBACK};
        }

        static {
            Kind[] $values = $values();
            $VALUES = $values;
            $ENTRIES = kotlin.enums.c.c($values);
        }

        public static Kind valueOf(String str) {
            return (Kind) Enum.valueOf(Kind.class, str);
        }

        public static Kind[] values() {
            return (Kind[]) $VALUES.clone();
        }

        private Kind(String str, int i6) {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        private final f0 f44456a;

        /* renamed from: b, reason: collision with root package name */
        private final boolean f44457b;

        public a(@NotNull f0 ownerModuleDescriptor, boolean z5) {
            g0.p(ownerModuleDescriptor, "ownerModuleDescriptor");
            this.f44456a = ownerModuleDescriptor;
            this.f44457b = z5;
        }

        @NotNull
        public final f0 a() {
            return this.f44456a;
        }

        public final boolean b() {
            return this.f44457b;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f44458a;

        static {
            int[] iArr = new int[Kind.values().length];
            try {
                iArr[Kind.FROM_DEPENDENCIES.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Kind.FROM_CLASS_LOADER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Kind.FALLBACK.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f44458a = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JvmBuiltIns(@NotNull kotlin.reflect.jvm.internal.impl.storage.n storageManager, @NotNull Kind kind) {
        super(storageManager);
        g0.p(storageManager, "storageManager");
        g0.p(kind, "kind");
        this.f44453i = kind;
        this.f44455k = storageManager.e(new h(this, storageManager));
        int i6 = b.f44458a[kind.ordinal()];
        if (i6 != 1) {
            if (i6 == 2) {
                f(false);
            } else {
                if (i6 != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                f(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final t J0(JvmBuiltIns jvmBuiltIns, kotlin.reflect.jvm.internal.impl.storage.n nVar) {
        kotlin.reflect.jvm.internal.impl.descriptors.impl.f0 s5 = jvmBuiltIns.s();
        g0.o(s5, "getBuiltInsModule(...)");
        return new t(s5, nVar, new j(jvmBuiltIns));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final a K0(JvmBuiltIns jvmBuiltIns) {
        Function0<a> function0 = jvmBuiltIns.f44454j;
        if (function0 == null) {
            throw new AssertionError("JvmBuiltins instance has not been initialized properly");
        }
        a invoke = function0.invoke();
        jvmBuiltIns.f44454j = null;
        return invoke;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final a O0(f0 f0Var, boolean z5) {
        return new a(f0Var, z5);
    }

    @NotNull
    public final t M0() {
        return (t) kotlin.reflect.jvm.internal.impl.storage.m.a(this.f44455k, this, f44452l[0]);
    }

    public final void N0(@NotNull f0 moduleDescriptor, boolean z5) {
        g0.p(moduleDescriptor, "moduleDescriptor");
        P0(new i(moduleDescriptor, z5));
    }

    public final void P0(@NotNull Function0<a> computation) {
        g0.p(computation, "computation");
        this.f44454j = computation;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.builtins.j
    @NotNull
    /* renamed from: L0, reason: merged with bridge method [inline-methods] */
    public List<r3.b> w() {
        Iterable<r3.b> w5 = super.w();
        g0.o(w5, "getClassDescriptorFactories(...)");
        kotlin.reflect.jvm.internal.impl.storage.n V = V();
        g0.o(V, "getStorageManager(...)");
        kotlin.reflect.jvm.internal.impl.descriptors.impl.f0 s5 = s();
        g0.o(s5, "getBuiltInsModule(...)");
        return kotlin.collections.f0.F4(w5, new g(V, s5, null, 4, null));
    }

    @Override // kotlin.reflect.jvm.internal.impl.builtins.j
    @NotNull
    protected r3.c N() {
        return M0();
    }

    @Override // kotlin.reflect.jvm.internal.impl.builtins.j
    @NotNull
    protected r3.a g() {
        return M0();
    }
}
