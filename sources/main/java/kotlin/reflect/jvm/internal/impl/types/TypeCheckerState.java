package kotlin.reflect.jvm.internal.impl.types;

import java.util.ArrayDeque;
import java.util.Set;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nAbstractTypeChecker.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AbstractTypeChecker.kt\norg/jetbrains/kotlin/types/TypeCheckerState\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,884:1\n1#2:885\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public class TypeCheckerState {

    /* renamed from: a, reason: collision with root package name */
    private final boolean f47127a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f47128b;

    /* renamed from: c, reason: collision with root package name */
    private final boolean f47129c;

    /* renamed from: d, reason: collision with root package name */
    private final boolean f47130d;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    private final e4.r f47131e;

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    private final r f47132f;

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    private final s f47133g;

    /* renamed from: h, reason: collision with root package name */
    private int f47134h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f47135i;

    /* renamed from: j, reason: collision with root package name */
    @Nullable
    private ArrayDeque<e4.h> f47136j;

    /* renamed from: k, reason: collision with root package name */
    @Nullable
    private Set<e4.h> f47137k;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class LowerCapturedTypePolicy {
        private static final /* synthetic */ kotlin.enums.a $ENTRIES;
        private static final /* synthetic */ LowerCapturedTypePolicy[] $VALUES;
        public static final LowerCapturedTypePolicy CHECK_ONLY_LOWER = new LowerCapturedTypePolicy("CHECK_ONLY_LOWER", 0);
        public static final LowerCapturedTypePolicy CHECK_SUBTYPE_AND_LOWER = new LowerCapturedTypePolicy("CHECK_SUBTYPE_AND_LOWER", 1);
        public static final LowerCapturedTypePolicy SKIP_LOWER = new LowerCapturedTypePolicy("SKIP_LOWER", 2);

        private static final /* synthetic */ LowerCapturedTypePolicy[] $values() {
            return new LowerCapturedTypePolicy[]{CHECK_ONLY_LOWER, CHECK_SUBTYPE_AND_LOWER, SKIP_LOWER};
        }

        static {
            LowerCapturedTypePolicy[] $values = $values();
            $VALUES = $values;
            $ENTRIES = kotlin.enums.c.c($values);
        }

        public static LowerCapturedTypePolicy valueOf(String str) {
            return (LowerCapturedTypePolicy) Enum.valueOf(LowerCapturedTypePolicy.class, str);
        }

        public static LowerCapturedTypePolicy[] values() {
            return (LowerCapturedTypePolicy[]) $VALUES.clone();
        }

        private LowerCapturedTypePolicy(String str, int i6) {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface a {

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        /* renamed from: kotlin.reflect.jvm.internal.impl.types.TypeCheckerState$a$a, reason: collision with other inner class name */
        public static final class C0919a implements a {

            /* renamed from: a, reason: collision with root package name */
            private boolean f47138a;

            @Override // kotlin.reflect.jvm.internal.impl.types.TypeCheckerState.a
            public void a(@NotNull Function0<Boolean> block) {
                kotlin.jvm.internal.g0.p(block, "block");
                if (this.f47138a) {
                    return;
                }
                this.f47138a = block.invoke().booleanValue();
            }

            public final boolean b() {
                return this.f47138a;
            }
        }

        void a(@NotNull Function0<Boolean> function0);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static abstract class b {

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        public static abstract class a extends b {
            public a() {
                super(null);
            }
        }

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        @SourceDebugExtension({"SMAP\nAbstractTypeChecker.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AbstractTypeChecker.kt\norg/jetbrains/kotlin/types/TypeCheckerState$SupertypesPolicy$LowerIfFlexible\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,884:1\n1#2:885\n*E\n"})
        /* renamed from: kotlin.reflect.jvm.internal.impl.types.TypeCheckerState$b$b, reason: collision with other inner class name */
        public static final class C0920b extends b {

            /* renamed from: a, reason: collision with root package name */
            @NotNull
            public static final C0920b f47139a = new C0920b();

            private C0920b() {
                super(null);
            }

            @Override // kotlin.reflect.jvm.internal.impl.types.TypeCheckerState.b
            @NotNull
            public e4.h a(@NotNull TypeCheckerState state, @NotNull e4.g type) {
                kotlin.jvm.internal.g0.p(state, "state");
                kotlin.jvm.internal.g0.p(type, "type");
                return state.j().r0(type);
            }
        }

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        public static final class c extends b {

            /* renamed from: a, reason: collision with root package name */
            @NotNull
            public static final c f47140a = new c();

            private c() {
                super(null);
            }

            @NotNull
            public Void b(@NotNull TypeCheckerState state, @NotNull e4.g type) {
                kotlin.jvm.internal.g0.p(state, "state");
                kotlin.jvm.internal.g0.p(type, "type");
                throw new UnsupportedOperationException("Should not be called");
            }

            @Override // kotlin.reflect.jvm.internal.impl.types.TypeCheckerState.b
            public /* bridge */ /* synthetic */ e4.h a(TypeCheckerState typeCheckerState, e4.g gVar) {
                return (e4.h) b(typeCheckerState, gVar);
            }
        }

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        @SourceDebugExtension({"SMAP\nAbstractTypeChecker.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AbstractTypeChecker.kt\norg/jetbrains/kotlin/types/TypeCheckerState$SupertypesPolicy$UpperIfFlexible\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,884:1\n1#2:885\n*E\n"})
        public static final class d extends b {

            /* renamed from: a, reason: collision with root package name */
            @NotNull
            public static final d f47141a = new d();

            private d() {
                super(null);
            }

            @Override // kotlin.reflect.jvm.internal.impl.types.TypeCheckerState.b
            @NotNull
            public e4.h a(@NotNull TypeCheckerState state, @NotNull e4.g type) {
                kotlin.jvm.internal.g0.p(state, "state");
                kotlin.jvm.internal.g0.p(type, "type");
                return state.j().o(type);
            }
        }

        public /* synthetic */ b(kotlin.jvm.internal.v vVar) {
            this();
        }

        @NotNull
        public abstract e4.h a(@NotNull TypeCheckerState typeCheckerState, @NotNull e4.g gVar);

        private b() {
        }
    }

    public final void k() {
        this.f47135i = true;
        if (this.f47136j == null) {
            this.f47136j = new ArrayDeque<>(4);
        }
        if (this.f47137k == null) {
            this.f47137k = kotlin.reflect.jvm.internal.impl.utils.k.f47493c.a();
        }
    }

    public TypeCheckerState(boolean z5, boolean z6, boolean z7, boolean z8, @NotNull e4.r typeSystemContext, @NotNull r kotlinTypePreparator, @NotNull s kotlinTypeRefiner) {
        kotlin.jvm.internal.g0.p(typeSystemContext, "typeSystemContext");
        kotlin.jvm.internal.g0.p(kotlinTypePreparator, "kotlinTypePreparator");
        kotlin.jvm.internal.g0.p(kotlinTypeRefiner, "kotlinTypeRefiner");
        this.f47127a = z5;
        this.f47128b = z6;
        this.f47129c = z7;
        this.f47130d = z8;
        this.f47131e = typeSystemContext;
        this.f47132f = kotlinTypePreparator;
        this.f47133g = kotlinTypeRefiner;
    }

    public static /* synthetic */ Boolean d(TypeCheckerState typeCheckerState, e4.g gVar, e4.g gVar2, boolean z5, int i6, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addSubtypeConstraint");
        }
        if ((i6 & 4) != 0) {
            z5 = false;
        }
        return typeCheckerState.c(gVar, gVar2, z5);
    }

    @Nullable
    public Boolean c(@NotNull e4.g subType, @NotNull e4.g superType, boolean z5) {
        kotlin.jvm.internal.g0.p(subType, "subType");
        kotlin.jvm.internal.g0.p(superType, "superType");
        return null;
    }

    public final void e() {
        ArrayDeque<e4.h> arrayDeque = this.f47136j;
        kotlin.jvm.internal.g0.m(arrayDeque);
        arrayDeque.clear();
        Set<e4.h> set = this.f47137k;
        kotlin.jvm.internal.g0.m(set);
        set.clear();
        this.f47135i = false;
    }

    public boolean f(@NotNull e4.g subType, @NotNull e4.g superType) {
        kotlin.jvm.internal.g0.p(subType, "subType");
        kotlin.jvm.internal.g0.p(superType, "superType");
        return true;
    }

    @NotNull
    public LowerCapturedTypePolicy g(@NotNull e4.h subType, @NotNull e4.b superType) {
        kotlin.jvm.internal.g0.p(subType, "subType");
        kotlin.jvm.internal.g0.p(superType, "superType");
        return LowerCapturedTypePolicy.CHECK_SUBTYPE_AND_LOWER;
    }

    @Nullable
    public final ArrayDeque<e4.h> h() {
        return this.f47136j;
    }

    @Nullable
    public final Set<e4.h> i() {
        return this.f47137k;
    }

    @NotNull
    public final e4.r j() {
        return this.f47131e;
    }

    public final boolean l(@NotNull e4.g type) {
        kotlin.jvm.internal.g0.p(type, "type");
        return this.f47130d && this.f47131e.m0(type);
    }

    public final boolean m() {
        return this.f47129c;
    }

    public final boolean n() {
        return this.f47127a;
    }

    public final boolean o() {
        return this.f47128b;
    }

    @NotNull
    public final e4.g p(@NotNull e4.g type) {
        kotlin.jvm.internal.g0.p(type, "type");
        return this.f47132f.a(type);
    }

    @NotNull
    public final e4.g q(@NotNull e4.g type) {
        kotlin.jvm.internal.g0.p(type, "type");
        return this.f47133g.a(type);
    }

    public boolean r(@NotNull Function1<? super a, kotlin.n1> block) {
        kotlin.jvm.internal.g0.p(block, "block");
        a.C0919a c0919a = new a.C0919a();
        block.invoke(c0919a);
        return c0919a.b();
    }
}
