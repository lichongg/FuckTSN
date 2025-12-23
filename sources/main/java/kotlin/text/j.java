package kotlin.text;

import io.netty.util.internal.StringUtil;
import kotlin.ExperimentalStdlibApi;
import kotlin.PublishedApi;
import kotlin.SinceKotlin;
import kotlin.WasExperimental;
import kotlin.internal.InlineOnly;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.n1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SinceKotlin(version = "2.2")
@WasExperimental(markerClass = {ExperimentalStdlibApi.class})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class j {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final c f47879d = new c(null);

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    private static final j f47880e;

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    private static final j f47881f;

    /* renamed from: a, reason: collision with root package name */
    private final boolean f47882a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private final b f47883b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private final d f47884c;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private boolean f47885a = j.f47879d.a().e();

        /* renamed from: b, reason: collision with root package name */
        @Nullable
        private b.a f47886b;

        /* renamed from: c, reason: collision with root package name */
        @Nullable
        private d.a f47887c;

        @InlineOnly
        private final void b(Function1<? super b.a, n1> builderAction) {
            kotlin.jvm.internal.g0.p(builderAction, "builderAction");
            builderAction.invoke(c());
        }

        @InlineOnly
        private final void f(Function1<? super d.a, n1> builderAction) {
            kotlin.jvm.internal.g0.p(builderAction, "builderAction");
            builderAction.invoke(d());
        }

        @PublishedApi
        @NotNull
        public final j a() {
            b a6;
            d a7;
            boolean z5 = this.f47885a;
            b.a aVar = this.f47886b;
            if (aVar == null || (a6 = aVar.a()) == null) {
                a6 = b.f47888j.a();
            }
            d.a aVar2 = this.f47887c;
            if (aVar2 == null || (a7 = aVar2.a()) == null) {
                a7 = d.f47905h.a();
            }
            return new j(z5, a6, a7);
        }

        @NotNull
        public final b.a c() {
            if (this.f47886b == null) {
                this.f47886b = new b.a();
            }
            b.a aVar = this.f47886b;
            kotlin.jvm.internal.g0.m(aVar);
            return aVar;
        }

        @NotNull
        public final d.a d() {
            if (this.f47887c == null) {
                this.f47887c = new d.a();
            }
            d.a aVar = this.f47887c;
            kotlin.jvm.internal.g0.m(aVar);
            return aVar;
        }

        public final boolean e() {
            return this.f47885a;
        }

        public final void g(boolean z5) {
            this.f47885a = z5;
        }

        @PublishedApi
        public a() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class b {

        /* renamed from: j, reason: collision with root package name */
        @NotNull
        public static final C0927b f47888j = new C0927b(null);

        /* renamed from: k, reason: collision with root package name */
        @NotNull
        private static final b f47889k = new b(Integer.MAX_VALUE, Integer.MAX_VALUE, "  ", "", "", "");

        /* renamed from: a, reason: collision with root package name */
        private final int f47890a;

        /* renamed from: b, reason: collision with root package name */
        private final int f47891b;

        /* renamed from: c, reason: collision with root package name */
        @NotNull
        private final String f47892c;

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        private final String f47893d;

        /* renamed from: e, reason: collision with root package name */
        @NotNull
        private final String f47894e;

        /* renamed from: f, reason: collision with root package name */
        @NotNull
        private final String f47895f;

        /* renamed from: g, reason: collision with root package name */
        private final boolean f47896g;

        /* renamed from: h, reason: collision with root package name */
        private final boolean f47897h;

        /* renamed from: i, reason: collision with root package name */
        private final boolean f47898i;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        public static final class a {

            /* renamed from: a, reason: collision with root package name */
            private int f47899a;

            /* renamed from: b, reason: collision with root package name */
            private int f47900b;

            /* renamed from: c, reason: collision with root package name */
            @NotNull
            private String f47901c;

            /* renamed from: d, reason: collision with root package name */
            @NotNull
            private String f47902d;

            /* renamed from: e, reason: collision with root package name */
            @NotNull
            private String f47903e;

            /* renamed from: f, reason: collision with root package name */
            @NotNull
            private String f47904f;

            @NotNull
            public final b a() {
                return new b(this.f47899a, this.f47900b, this.f47901c, this.f47902d, this.f47903e, this.f47904f);
            }

            @NotNull
            public final String b() {
                return this.f47903e;
            }

            @NotNull
            public final String c() {
                return this.f47902d;
            }

            @NotNull
            public final String d() {
                return this.f47904f;
            }

            public final int e() {
                return this.f47900b;
            }

            public final int f() {
                return this.f47899a;
            }

            @NotNull
            public final String g() {
                return this.f47901c;
            }

            public final void h(@NotNull String value) {
                kotlin.jvm.internal.g0.p(value, "value");
                if (!l0.k3(value, '\n', false, 2, null) && !l0.k3(value, StringUtil.CARRIAGE_RETURN, false, 2, null)) {
                    this.f47903e = value;
                    return;
                }
                throw new IllegalArgumentException("LF and CR characters are prohibited in bytePrefix, but was " + value);
            }

            public final void i(@NotNull String value) {
                kotlin.jvm.internal.g0.p(value, "value");
                if (!l0.k3(value, '\n', false, 2, null) && !l0.k3(value, StringUtil.CARRIAGE_RETURN, false, 2, null)) {
                    this.f47902d = value;
                    return;
                }
                throw new IllegalArgumentException("LF and CR characters are prohibited in byteSeparator, but was " + value);
            }

            public final void j(@NotNull String value) {
                kotlin.jvm.internal.g0.p(value, "value");
                if (!l0.k3(value, '\n', false, 2, null) && !l0.k3(value, StringUtil.CARRIAGE_RETURN, false, 2, null)) {
                    this.f47904f = value;
                    return;
                }
                throw new IllegalArgumentException("LF and CR characters are prohibited in byteSuffix, but was " + value);
            }

            public final void k(int i6) {
                if (i6 > 0) {
                    this.f47900b = i6;
                    return;
                }
                throw new IllegalArgumentException("Non-positive values are prohibited for bytesPerGroup, but was " + i6);
            }

            public final void l(int i6) {
                if (i6 > 0) {
                    this.f47899a = i6;
                    return;
                }
                throw new IllegalArgumentException("Non-positive values are prohibited for bytesPerLine, but was " + i6);
            }

            public final void m(@NotNull String str) {
                kotlin.jvm.internal.g0.p(str, "<set-?>");
                this.f47901c = str;
            }

            public a() {
                C0927b c0927b = b.f47888j;
                this.f47899a = c0927b.a().g();
                this.f47900b = c0927b.a().f();
                this.f47901c = c0927b.a().h();
                this.f47902d = c0927b.a().d();
                this.f47903e = c0927b.a().c();
                this.f47904f = c0927b.a().e();
            }
        }

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        /* renamed from: kotlin.text.j$b$b, reason: collision with other inner class name */
        public static final class C0927b {
            public /* synthetic */ C0927b(kotlin.jvm.internal.v vVar) {
                this();
            }

            private C0927b() {
            }

            @NotNull
            public final b a() {
                return b.f47889k;
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:19:0x005e, code lost:
        
            if (r4 != false) goto L23;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public b(int r4, int r5, @org.jetbrains.annotations.NotNull java.lang.String r6, @org.jetbrains.annotations.NotNull java.lang.String r7, @org.jetbrains.annotations.NotNull java.lang.String r8, @org.jetbrains.annotations.NotNull java.lang.String r9) {
            /*
                r3 = this;
                java.lang.String r0 = "groupSeparator"
                kotlin.jvm.internal.g0.p(r6, r0)
                java.lang.String r0 = "byteSeparator"
                kotlin.jvm.internal.g0.p(r7, r0)
                java.lang.String r0 = "bytePrefix"
                kotlin.jvm.internal.g0.p(r8, r0)
                java.lang.String r0 = "byteSuffix"
                kotlin.jvm.internal.g0.p(r9, r0)
                r3.<init>()
                r3.f47890a = r4
                r3.f47891b = r5
                r3.f47892c = r6
                r3.f47893d = r7
                r3.f47894e = r8
                r3.f47895f = r9
                r0 = 0
                r1 = 1
                r2 = 2147483647(0x7fffffff, float:NaN)
                if (r4 != r2) goto L2e
                if (r5 != r2) goto L2e
                r4 = 1
                goto L2f
            L2e:
                r4 = 0
            L2f:
                r3.f47896g = r4
                int r4 = r8.length()
                if (r4 != 0) goto L45
                int r4 = r9.length()
                if (r4 != 0) goto L45
                int r4 = r7.length()
                if (r4 > r1) goto L45
                r4 = 1
                goto L46
            L45:
                r4 = 0
            L46:
                r3.f47897h = r4
                boolean r4 = kotlin.text.k.b(r6)
                if (r4 != 0) goto L60
                boolean r4 = kotlin.text.k.b(r7)
                if (r4 != 0) goto L60
                boolean r4 = kotlin.text.k.b(r8)
                if (r4 != 0) goto L60
                boolean r4 = kotlin.text.k.b(r9)
                if (r4 == 0) goto L61
            L60:
                r0 = 1
            L61:
                r3.f47898i = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.text.j.b.<init>(int, int, java.lang.String, java.lang.String, java.lang.String, java.lang.String):void");
        }

        @NotNull
        public final StringBuilder b(@NotNull StringBuilder sb, @NotNull String indent) {
            kotlin.jvm.internal.g0.p(sb, "sb");
            kotlin.jvm.internal.g0.p(indent, "indent");
            sb.append(indent);
            sb.append("bytesPerLine = ");
            sb.append(this.f47890a);
            sb.append(",");
            sb.append('\n');
            sb.append(indent);
            sb.append("bytesPerGroup = ");
            sb.append(this.f47891b);
            sb.append(",");
            sb.append('\n');
            sb.append(indent);
            sb.append("groupSeparator = \"");
            sb.append(this.f47892c);
            sb.append("\",");
            sb.append('\n');
            sb.append(indent);
            sb.append("byteSeparator = \"");
            sb.append(this.f47893d);
            sb.append("\",");
            sb.append('\n');
            sb.append(indent);
            sb.append("bytePrefix = \"");
            sb.append(this.f47894e);
            sb.append("\",");
            sb.append('\n');
            sb.append(indent);
            sb.append("byteSuffix = \"");
            sb.append(this.f47895f);
            sb.append("\"");
            return sb;
        }

        @NotNull
        public final String c() {
            return this.f47894e;
        }

        @NotNull
        public final String d() {
            return this.f47893d;
        }

        @NotNull
        public final String e() {
            return this.f47895f;
        }

        public final int f() {
            return this.f47891b;
        }

        public final int g() {
            return this.f47890a;
        }

        @NotNull
        public final String h() {
            return this.f47892c;
        }

        public final boolean i() {
            return this.f47898i;
        }

        public final boolean j() {
            return this.f47896g;
        }

        public final boolean k() {
            return this.f47897h;
        }

        @NotNull
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("BytesHexFormat(");
            sb.append('\n');
            b(sb, "    ").append('\n');
            sb.append(")");
            return sb.toString();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class c {
        public /* synthetic */ c(kotlin.jvm.internal.v vVar) {
            this();
        }

        private c() {
        }

        @NotNull
        public final j a() {
            return j.f47880e;
        }

        @NotNull
        public final j b() {
            return j.f47881f;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class d {

        /* renamed from: h, reason: collision with root package name */
        @NotNull
        public static final b f47905h = new b(null);

        /* renamed from: i, reason: collision with root package name */
        @NotNull
        private static final d f47906i = new d("", "", false, 1);

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        private final String f47907a;

        /* renamed from: b, reason: collision with root package name */
        @NotNull
        private final String f47908b;

        /* renamed from: c, reason: collision with root package name */
        private final boolean f47909c;

        /* renamed from: d, reason: collision with root package name */
        private final int f47910d;

        /* renamed from: e, reason: collision with root package name */
        private final boolean f47911e;

        /* renamed from: f, reason: collision with root package name */
        private final boolean f47912f;

        /* renamed from: g, reason: collision with root package name */
        private final boolean f47913g;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        @SourceDebugExtension({"SMAP\nHexFormat.kt\nKotlin\n*S Kotlin\n*F\n+ 1 HexFormat.kt\nkotlin/text/HexFormat$NumberHexFormat$Builder\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,845:1\n1#2:846\n*E\n"})
        public static final class a {

            /* renamed from: a, reason: collision with root package name */
            @NotNull
            private String f47914a;

            /* renamed from: b, reason: collision with root package name */
            @NotNull
            private String f47915b;

            /* renamed from: c, reason: collision with root package name */
            private boolean f47916c;

            /* renamed from: d, reason: collision with root package name */
            private int f47917d;

            @NotNull
            public final d a() {
                return new d(this.f47914a, this.f47915b, this.f47916c, this.f47917d);
            }

            public final int b() {
                return this.f47917d;
            }

            @NotNull
            public final String d() {
                return this.f47914a;
            }

            public final boolean e() {
                return this.f47916c;
            }

            @NotNull
            public final String f() {
                return this.f47915b;
            }

            public final void g(int i6) {
                if (i6 > 0) {
                    this.f47917d = i6;
                    return;
                }
                throw new IllegalArgumentException(("Non-positive values are prohibited for minLength, but was " + i6).toString());
            }

            public final void h(@NotNull String value) {
                kotlin.jvm.internal.g0.p(value, "value");
                if (!l0.k3(value, '\n', false, 2, null) && !l0.k3(value, StringUtil.CARRIAGE_RETURN, false, 2, null)) {
                    this.f47914a = value;
                    return;
                }
                throw new IllegalArgumentException("LF and CR characters are prohibited in prefix, but was " + value);
            }

            public final void i(boolean z5) {
                this.f47916c = z5;
            }

            public final void j(@NotNull String value) {
                kotlin.jvm.internal.g0.p(value, "value");
                if (!l0.k3(value, '\n', false, 2, null) && !l0.k3(value, StringUtil.CARRIAGE_RETURN, false, 2, null)) {
                    this.f47915b = value;
                    return;
                }
                throw new IllegalArgumentException("LF and CR characters are prohibited in suffix, but was " + value);
            }

            public a() {
                b bVar = d.f47905h;
                this.f47914a = bVar.a().f();
                this.f47915b = bVar.a().h();
                this.f47916c = bVar.a().g();
                this.f47917d = bVar.a().d();
            }

            @SinceKotlin(version = "2.0")
            public static /* synthetic */ void c() {
            }
        }

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        public static final class b {
            public /* synthetic */ b(kotlin.jvm.internal.v vVar) {
                this();
            }

            private b() {
            }

            @NotNull
            public final d a() {
                return d.f47906i;
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:13:0x003b, code lost:
        
            if (r3 != false) goto L17;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public d(@org.jetbrains.annotations.NotNull java.lang.String r3, @org.jetbrains.annotations.NotNull java.lang.String r4, boolean r5, int r6) {
            /*
                r2 = this;
                java.lang.String r0 = "prefix"
                kotlin.jvm.internal.g0.p(r3, r0)
                java.lang.String r0 = "suffix"
                kotlin.jvm.internal.g0.p(r4, r0)
                r2.<init>()
                r2.f47907a = r3
                r2.f47908b = r4
                r2.f47909c = r5
                r2.f47910d = r6
                int r5 = r3.length()
                r0 = 0
                r1 = 1
                if (r5 != 0) goto L25
                int r5 = r4.length()
                if (r5 != 0) goto L25
                r5 = 1
                goto L26
            L25:
                r5 = 0
            L26:
                r2.f47911e = r5
                if (r5 == 0) goto L2e
                if (r6 != r1) goto L2e
                r5 = 1
                goto L2f
            L2e:
                r5 = 0
            L2f:
                r2.f47912f = r5
                boolean r3 = kotlin.text.k.b(r3)
                if (r3 != 0) goto L3d
                boolean r3 = kotlin.text.k.b(r4)
                if (r3 == 0) goto L3e
            L3d:
                r0 = 1
            L3e:
                r2.f47913g = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.text.j.d.<init>(java.lang.String, java.lang.String, boolean, int):void");
        }

        @NotNull
        public final StringBuilder b(@NotNull StringBuilder sb, @NotNull String indent) {
            kotlin.jvm.internal.g0.p(sb, "sb");
            kotlin.jvm.internal.g0.p(indent, "indent");
            sb.append(indent);
            sb.append("prefix = \"");
            sb.append(this.f47907a);
            sb.append("\",");
            sb.append('\n');
            sb.append(indent);
            sb.append("suffix = \"");
            sb.append(this.f47908b);
            sb.append("\",");
            sb.append('\n');
            sb.append(indent);
            sb.append("removeLeadingZeros = ");
            sb.append(this.f47909c);
            sb.append(StringUtil.COMMA);
            sb.append('\n');
            sb.append(indent);
            sb.append("minLength = ");
            sb.append(this.f47910d);
            return sb;
        }

        public final boolean c() {
            return this.f47913g;
        }

        public final int d() {
            return this.f47910d;
        }

        @NotNull
        public final String f() {
            return this.f47907a;
        }

        public final boolean g() {
            return this.f47909c;
        }

        @NotNull
        public final String h() {
            return this.f47908b;
        }

        public final boolean i() {
            return this.f47911e;
        }

        public final boolean j() {
            return this.f47912f;
        }

        @NotNull
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("NumberHexFormat(");
            sb.append('\n');
            b(sb, "    ").append('\n');
            sb.append(")");
            return sb.toString();
        }

        @SinceKotlin(version = "2.0")
        public static /* synthetic */ void e() {
        }
    }

    static {
        b.C0927b c0927b = b.f47888j;
        b a6 = c0927b.a();
        d.b bVar = d.f47905h;
        f47880e = new j(false, a6, bVar.a());
        f47881f = new j(true, c0927b.a(), bVar.a());
    }

    public j(boolean z5, @NotNull b bytes, @NotNull d number) {
        kotlin.jvm.internal.g0.p(bytes, "bytes");
        kotlin.jvm.internal.g0.p(number, "number");
        this.f47882a = z5;
        this.f47883b = bytes;
        this.f47884c = number;
    }

    @NotNull
    public final b c() {
        return this.f47883b;
    }

    @NotNull
    public final d d() {
        return this.f47884c;
    }

    public final boolean e() {
        return this.f47882a;
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("HexFormat(");
        sb.append('\n');
        sb.append("    upperCase = ");
        sb.append(this.f47882a);
        sb.append(",");
        sb.append('\n');
        sb.append("    bytes = BytesHexFormat(");
        sb.append('\n');
        this.f47883b.b(sb, "        ").append('\n');
        sb.append("    ),");
        sb.append('\n');
        sb.append("    number = NumberHexFormat(");
        sb.append('\n');
        this.f47884c.b(sb, "        ").append('\n');
        sb.append("    )");
        sb.append('\n');
        sb.append(")");
        return sb.toString();
    }
}
