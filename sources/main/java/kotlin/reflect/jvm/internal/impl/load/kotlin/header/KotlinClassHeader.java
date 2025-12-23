package kotlin.reflect.jvm.internal.impl.load.kotlin.header;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.f0;
import kotlin.collections.i1;
import kotlin.collections.n;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.v;
import kotlin.ranges.t;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.c;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nKotlinClassHeader.kt\nKotlin\n*S Kotlin\n*F\n+ 1 KotlinClassHeader.kt\norg/jetbrains/kotlin/load/kotlin/header/KotlinClassHeader\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,75:1\n1#2:76\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class KotlinClassHeader {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final Kind f45916a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private final c f45917b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    private final String[] f45918c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    private final String[] f45919d;

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    private final String[] f45920e;

    /* renamed from: f, reason: collision with root package name */
    @Nullable
    private final String f45921f;

    /* renamed from: g, reason: collision with root package name */
    private final int f45922g;

    /* renamed from: h, reason: collision with root package name */
    @Nullable
    private final String f45923h;

    /* renamed from: i, reason: collision with root package name */
    @Nullable
    private final byte[] f45924i;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\nKotlinClassHeader.kt\nKotlin\n*S Kotlin\n*F\n+ 1 KotlinClassHeader.kt\norg/jetbrains/kotlin/load/kotlin/header/KotlinClassHeader$Kind\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,75:1\n8704#2,2:76\n8964#2,4:78\n*S KotlinDebug\n*F\n+ 1 KotlinClassHeader.kt\norg/jetbrains/kotlin/load/kotlin/header/KotlinClassHeader$Kind\n*L\n34#1:76,2\n34#1:78,4\n*E\n"})
    public static final class Kind {
        private static final /* synthetic */ kotlin.enums.a $ENTRIES;
        private static final /* synthetic */ Kind[] $VALUES;

        @NotNull
        public static final a Companion;

        @NotNull
        private static final Map<Integer, Kind> entryById;
        private final int id;
        public static final Kind UNKNOWN = new Kind("UNKNOWN", 0, 0);
        public static final Kind CLASS = new Kind("CLASS", 1, 1);
        public static final Kind FILE_FACADE = new Kind("FILE_FACADE", 2, 2);
        public static final Kind SYNTHETIC_CLASS = new Kind("SYNTHETIC_CLASS", 3, 3);
        public static final Kind MULTIFILE_CLASS = new Kind("MULTIFILE_CLASS", 4, 4);
        public static final Kind MULTIFILE_CLASS_PART = new Kind("MULTIFILE_CLASS_PART", 5, 5);

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        public static final class a {
            public /* synthetic */ a(v vVar) {
                this();
            }

            private a() {
            }

            @JvmStatic
            @NotNull
            public final Kind a(int i6) {
                Kind kind = (Kind) Kind.entryById.get(Integer.valueOf(i6));
                if (kind == null) {
                    return Kind.UNKNOWN;
                }
                return kind;
            }
        }

        private static final /* synthetic */ Kind[] $values() {
            return new Kind[]{UNKNOWN, CLASS, FILE_FACADE, SYNTHETIC_CLASS, MULTIFILE_CLASS, MULTIFILE_CLASS_PART};
        }

        static {
            Kind[] $values = $values();
            $VALUES = $values;
            $ENTRIES = kotlin.enums.c.c($values);
            Companion = new a(null);
            Kind[] values = values();
            LinkedHashMap linkedHashMap = new LinkedHashMap(t.u(i1.j(values.length), 16));
            for (Kind kind : values) {
                linkedHashMap.put(Integer.valueOf(kind.id), kind);
            }
            entryById = linkedHashMap;
        }

        @JvmStatic
        @NotNull
        public static final Kind getById(int i6) {
            return Companion.a(i6);
        }

        public static Kind valueOf(String str) {
            return (Kind) Enum.valueOf(Kind.class, str);
        }

        public static Kind[] values() {
            return (Kind[]) $VALUES.clone();
        }

        private Kind(String str, int i6, int i7) {
            this.id = i7;
        }
    }

    private final boolean h(int i6, int i7) {
        return (i6 & i7) != 0;
    }

    public KotlinClassHeader(@NotNull Kind kind, @NotNull c metadataVersion, @Nullable String[] strArr, @Nullable String[] strArr2, @Nullable String[] strArr3, @Nullable String str, int i6, @Nullable String str2, @Nullable byte[] bArr) {
        g0.p(kind, "kind");
        g0.p(metadataVersion, "metadataVersion");
        this.f45916a = kind;
        this.f45917b = metadataVersion;
        this.f45918c = strArr;
        this.f45919d = strArr2;
        this.f45920e = strArr3;
        this.f45921f = str;
        this.f45922g = i6;
        this.f45923h = str2;
        this.f45924i = bArr;
    }

    @Nullable
    public final String[] a() {
        return this.f45918c;
    }

    @Nullable
    public final String[] b() {
        return this.f45919d;
    }

    @NotNull
    public final Kind c() {
        return this.f45916a;
    }

    @NotNull
    public final c d() {
        return this.f45917b;
    }

    @Nullable
    public final String e() {
        String str = this.f45921f;
        if (this.f45916a == Kind.MULTIFILE_CLASS_PART) {
            return str;
        }
        return null;
    }

    @NotNull
    public final List<String> f() {
        String[] strArr = this.f45918c;
        if (this.f45916a != Kind.MULTIFILE_CLASS) {
            strArr = null;
        }
        List<String> t5 = strArr != null ? n.t(strArr) : null;
        return t5 == null ? f0.J() : t5;
    }

    @Nullable
    public final String[] g() {
        return this.f45920e;
    }

    public final boolean i() {
        return h(this.f45922g, 2);
    }

    public final boolean j() {
        return h(this.f45922g, 16) && !h(this.f45922g, 32);
    }

    @NotNull
    public String toString() {
        return this.f45916a + " version=" + this.f45917b;
    }
}
