package kotlin.reflect.jvm.internal.impl.metadata.deserialization;

import kotlin.DeprecationLevel;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.v;
import kotlin.n1;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class i {

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    public static final a f46244f = new a(null);

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final b f46245a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private final ProtoBuf.VersionRequirement.VersionKind f46246b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private final DeprecationLevel f46247c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    private final Integer f46248d;

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    private final String f46249e;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\nVersionRequirement.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VersionRequirement.kt\norg/jetbrains/kotlin/metadata/deserialization/VersionRequirement$Companion\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,119:1\n1617#2,9:120\n1869#2:129\n1870#2:131\n1626#2:132\n1#3:130\n*S KotlinDebug\n*F\n+ 1 VersionRequirement.kt\norg/jetbrains/kotlin/metadata/deserialization/VersionRequirement$Companion\n*L\n94#1:120,9\n94#1:129\n94#1:131\n94#1:132\n94#1:130\n*E\n"})
    public static final class a {
        public /* synthetic */ a(v vVar) {
            this();
        }

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        /* renamed from: kotlin.reflect.jvm.internal.impl.metadata.deserialization.i$a$a, reason: collision with other inner class name */
        public static final /* synthetic */ class C0903a {

            /* renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f46250a;

            static {
                int[] iArr = new int[ProtoBuf.VersionRequirement.Level.values().length];
                try {
                    iArr[ProtoBuf.VersionRequirement.Level.WARNING.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[ProtoBuf.VersionRequirement.Level.ERROR.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[ProtoBuf.VersionRequirement.Level.HIDDEN.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                f46250a = iArr;
            }
        }

        private a() {
        }

        @Nullable
        public final i a(int i6, @NotNull d nameResolver, @NotNull j table) {
            DeprecationLevel deprecationLevel;
            g0.p(nameResolver, "nameResolver");
            g0.p(table, "table");
            ProtoBuf.VersionRequirement b6 = table.b(i6);
            if (b6 == null) {
                return null;
            }
            b a6 = b.f46251d.a(b6.hasVersion() ? Integer.valueOf(b6.getVersion()) : null, b6.hasVersionFull() ? Integer.valueOf(b6.getVersionFull()) : null);
            ProtoBuf.VersionRequirement.Level level = b6.getLevel();
            g0.m(level);
            int i7 = C0903a.f46250a[level.ordinal()];
            if (i7 == 1) {
                deprecationLevel = DeprecationLevel.WARNING;
            } else if (i7 == 2) {
                deprecationLevel = DeprecationLevel.ERROR;
            } else {
                if (i7 != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                deprecationLevel = DeprecationLevel.HIDDEN;
            }
            DeprecationLevel deprecationLevel2 = deprecationLevel;
            Integer valueOf = b6.hasErrorCode() ? Integer.valueOf(b6.getErrorCode()) : null;
            String string = b6.hasMessage() ? nameResolver.getString(b6.getMessage()) : null;
            ProtoBuf.VersionRequirement.VersionKind versionKind = b6.getVersionKind();
            g0.o(versionKind, "getVersionKind(...)");
            return new i(a6, versionKind, deprecationLevel2, valueOf, string);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class b {

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        public static final a f46251d = new a(null);

        /* renamed from: e, reason: collision with root package name */
        @JvmField
        @NotNull
        public static final b f46252e = new b(256, 256, 256);

        /* renamed from: a, reason: collision with root package name */
        private final int f46253a;

        /* renamed from: b, reason: collision with root package name */
        private final int f46254b;

        /* renamed from: c, reason: collision with root package name */
        private final int f46255c;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        public static final class a {
            public /* synthetic */ a(v vVar) {
                this();
            }

            private a() {
            }

            @NotNull
            public final b a(@Nullable Integer num, @Nullable Integer num2) {
                return num2 != null ? new b(num2.intValue() & 255, (num2.intValue() >> 8) & 255, (num2.intValue() >> 16) & 255) : num != null ? new b(num.intValue() & 7, (num.intValue() >> 3) & 15, (num.intValue() >> 7) & 127) : b.f46252e;
            }
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return this.f46253a == bVar.f46253a && this.f46254b == bVar.f46254b && this.f46255c == bVar.f46255c;
        }

        @NotNull
        public final String a() {
            StringBuilder sb;
            int i6;
            if (this.f46255c == 0) {
                sb = new StringBuilder();
                sb.append(this.f46253a);
                sb.append('.');
                i6 = this.f46254b;
            } else {
                sb = new StringBuilder();
                sb.append(this.f46253a);
                sb.append('.');
                sb.append(this.f46254b);
                sb.append('.');
                i6 = this.f46255c;
            }
            sb.append(i6);
            return sb.toString();
        }

        public final int b() {
            return this.f46253a;
        }

        public final int c() {
            return this.f46254b;
        }

        public final int d() {
            return this.f46255c;
        }

        public final void e(@NotNull Function1<? super Integer, n1> writeVersion, @NotNull Function1<? super Integer, n1> writeVersionFull) {
            int i6;
            int i7;
            g0.p(writeVersion, "writeVersion");
            g0.p(writeVersionFull, "writeVersionFull");
            if (g0.g(this, f46252e)) {
                return;
            }
            int i8 = this.f46253a;
            if (i8 > 7 || (i6 = this.f46254b) > 15 || (i7 = this.f46255c) > 127) {
                writeVersionFull.invoke(Integer.valueOf((this.f46254b << 8) | i8 | (this.f46255c << 16)));
            } else {
                writeVersion.invoke(Integer.valueOf((i6 << 3) | i8 | (i7 << 7)));
            }
        }

        public int hashCode() {
            return (((this.f46253a * 31) + this.f46254b) * 31) + this.f46255c;
        }

        public b(int i6, int i7, int i8) {
            this.f46253a = i6;
            this.f46254b = i7;
            this.f46255c = i8;
        }

        @NotNull
        public String toString() {
            return a();
        }
    }

    public i(@NotNull b version, @NotNull ProtoBuf.VersionRequirement.VersionKind kind, @NotNull DeprecationLevel level, @Nullable Integer num, @Nullable String str) {
        g0.p(version, "version");
        g0.p(kind, "kind");
        g0.p(level, "level");
        this.f46245a = version;
        this.f46246b = kind;
        this.f46247c = level;
        this.f46248d = num;
        this.f46249e = str;
    }

    @Nullable
    public final Integer a() {
        return this.f46248d;
    }

    @NotNull
    public final ProtoBuf.VersionRequirement.VersionKind b() {
        return this.f46246b;
    }

    @NotNull
    public final DeprecationLevel c() {
        return this.f46247c;
    }

    @Nullable
    public final String d() {
        return this.f46249e;
    }

    @NotNull
    public final b e() {
        return this.f46245a;
    }

    @NotNull
    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append("since ");
        sb.append(this.f46245a);
        sb.append(' ');
        sb.append(this.f46247c);
        String str2 = "";
        if (this.f46248d != null) {
            str = " error " + this.f46248d;
        } else {
            str = "";
        }
        sb.append(str);
        if (this.f46249e != null) {
            str2 = ": " + this.f46249e;
        }
        sb.append(str2);
        return sb.toString();
    }
}
