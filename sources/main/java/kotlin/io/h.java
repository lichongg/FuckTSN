package kotlin.io;

import java.io.File;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Iterator;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.v;
import kotlin.n1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class h implements kotlin.sequences.m<File> {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final File f43855a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private final FileWalkDirection f43856b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    private final Function1<File, Boolean> f43857c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    private final Function1<File, n1> f43858d;

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    private final Function2<File, IOException, n1> f43859e;

    /* renamed from: f, reason: collision with root package name */
    private final int f43860f;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\nFileTreeWalk.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FileTreeWalk.kt\nkotlin/io/FileTreeWalk$DirectoryState\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,273:1\n1#2:274\n*E\n"})
    private static abstract class a extends c {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(@NotNull File rootDir) {
            super(rootDir);
            g0.p(rootDir, "rootDir");
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private final class b extends kotlin.collections.c<File> {

        /* renamed from: c, reason: collision with root package name */
        @NotNull
        private final ArrayDeque<c> f43861c;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        private final class a extends a {

            /* renamed from: b, reason: collision with root package name */
            private boolean f43863b;

            /* renamed from: c, reason: collision with root package name */
            @Nullable
            private File[] f43864c;

            /* renamed from: d, reason: collision with root package name */
            private int f43865d;

            /* renamed from: e, reason: collision with root package name */
            private boolean f43866e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ b f43867f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(@NotNull b bVar, File rootDir) {
                super(rootDir);
                g0.p(rootDir, "rootDir");
                this.f43867f = bVar;
            }

            @Override // kotlin.io.h.c
            @Nullable
            public File b() {
                if (!this.f43866e && this.f43864c == null) {
                    Function1 function1 = h.this.f43857c;
                    if (function1 != null && !((Boolean) function1.invoke(a())).booleanValue()) {
                        return null;
                    }
                    File[] listFiles = a().listFiles();
                    this.f43864c = listFiles;
                    if (listFiles == null) {
                        Function2 function2 = h.this.f43859e;
                        if (function2 != null) {
                            function2.invoke(a(), new AccessDeniedException(a(), null, "Cannot list files in a directory", 2, null));
                        }
                        this.f43866e = true;
                    }
                }
                File[] fileArr = this.f43864c;
                if (fileArr != null) {
                    int i6 = this.f43865d;
                    g0.m(fileArr);
                    if (i6 < fileArr.length) {
                        File[] fileArr2 = this.f43864c;
                        g0.m(fileArr2);
                        int i7 = this.f43865d;
                        this.f43865d = i7 + 1;
                        return fileArr2[i7];
                    }
                }
                if (!this.f43863b) {
                    this.f43863b = true;
                    return a();
                }
                Function1 function12 = h.this.f43858d;
                if (function12 != null) {
                    function12.invoke(a());
                }
                return null;
            }
        }

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        @SourceDebugExtension({"SMAP\nFileTreeWalk.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FileTreeWalk.kt\nkotlin/io/FileTreeWalk$FileTreeWalkIterator$SingleFileState\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,273:1\n1#2:274\n*E\n"})
        /* renamed from: kotlin.io.h$b$b, reason: collision with other inner class name */
        private final class C0866b extends c {

            /* renamed from: b, reason: collision with root package name */
            private boolean f43868b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ b f43869c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0866b(@NotNull b bVar, File rootFile) {
                super(rootFile);
                g0.p(rootFile, "rootFile");
                this.f43869c = bVar;
            }

            @Override // kotlin.io.h.c
            @Nullable
            public File b() {
                if (this.f43868b) {
                    return null;
                }
                this.f43868b = true;
                return a();
            }
        }

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        private final class c extends a {

            /* renamed from: b, reason: collision with root package name */
            private boolean f43870b;

            /* renamed from: c, reason: collision with root package name */
            @Nullable
            private File[] f43871c;

            /* renamed from: d, reason: collision with root package name */
            private int f43872d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ b f43873e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public c(@NotNull b bVar, File rootDir) {
                super(rootDir);
                g0.p(rootDir, "rootDir");
                this.f43873e = bVar;
            }

            /* JADX WARN: Code restructure failed: missing block: B:29:0x007e, code lost:
            
                if (r0.length == 0) goto L31;
             */
            @Override // kotlin.io.h.c
            @org.jetbrains.annotations.Nullable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public java.io.File b() {
                /*
                    r9 = this;
                    boolean r0 = r9.f43870b
                    r1 = 0
                    if (r0 != 0) goto L28
                    kotlin.io.h$b r0 = r9.f43873e
                    kotlin.io.h r0 = kotlin.io.h.this
                    kotlin.jvm.functions.Function1 r0 = kotlin.io.h.e(r0)
                    if (r0 == 0) goto L20
                    java.io.File r2 = r9.a()
                    java.lang.Object r0 = r0.invoke(r2)
                    java.lang.Boolean r0 = (java.lang.Boolean) r0
                    boolean r0 = r0.booleanValue()
                    if (r0 != 0) goto L20
                    return r1
                L20:
                    r0 = 1
                    r9.f43870b = r0
                    java.io.File r0 = r9.a()
                    return r0
                L28:
                    java.io.File[] r0 = r9.f43871c
                    if (r0 == 0) goto L47
                    int r2 = r9.f43872d
                    kotlin.jvm.internal.g0.m(r0)
                    int r0 = r0.length
                    if (r2 >= r0) goto L35
                    goto L47
                L35:
                    kotlin.io.h$b r0 = r9.f43873e
                    kotlin.io.h r0 = kotlin.io.h.this
                    kotlin.jvm.functions.Function1 r0 = kotlin.io.h.g(r0)
                    if (r0 == 0) goto L46
                    java.io.File r2 = r9.a()
                    r0.invoke(r2)
                L46:
                    return r1
                L47:
                    java.io.File[] r0 = r9.f43871c
                    if (r0 != 0) goto L92
                    java.io.File r0 = r9.a()
                    java.io.File[] r0 = r0.listFiles()
                    r9.f43871c = r0
                    if (r0 != 0) goto L76
                    kotlin.io.h$b r0 = r9.f43873e
                    kotlin.io.h r0 = kotlin.io.h.this
                    kotlin.jvm.functions.Function2 r0 = kotlin.io.h.f(r0)
                    if (r0 == 0) goto L76
                    java.io.File r2 = r9.a()
                    kotlin.io.AccessDeniedException r3 = new kotlin.io.AccessDeniedException
                    java.io.File r4 = r9.a()
                    r7 = 2
                    r8 = 0
                    r5 = 0
                    java.lang.String r6 = "Cannot list files in a directory"
                    r3.<init>(r4, r5, r6, r7, r8)
                    r0.invoke(r2, r3)
                L76:
                    java.io.File[] r0 = r9.f43871c
                    if (r0 == 0) goto L80
                    kotlin.jvm.internal.g0.m(r0)
                    int r0 = r0.length
                    if (r0 != 0) goto L92
                L80:
                    kotlin.io.h$b r0 = r9.f43873e
                    kotlin.io.h r0 = kotlin.io.h.this
                    kotlin.jvm.functions.Function1 r0 = kotlin.io.h.g(r0)
                    if (r0 == 0) goto L91
                    java.io.File r2 = r9.a()
                    r0.invoke(r2)
                L91:
                    return r1
                L92:
                    java.io.File[] r0 = r9.f43871c
                    kotlin.jvm.internal.g0.m(r0)
                    int r1 = r9.f43872d
                    int r2 = r1 + 1
                    r9.f43872d = r2
                    r0 = r0[r1]
                    return r0
                */
                throw new UnsupportedOperationException("Method not decompiled: kotlin.io.h.b.c.b():java.io.File");
            }
        }

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        public static final /* synthetic */ class d {

            /* renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f43874a;

            static {
                int[] iArr = new int[FileWalkDirection.values().length];
                try {
                    iArr[FileWalkDirection.TOP_DOWN.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[FileWalkDirection.BOTTOM_UP.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                f43874a = iArr;
            }
        }

        public b() {
            ArrayDeque<c> arrayDeque = new ArrayDeque<>();
            this.f43861c = arrayDeque;
            if (h.this.f43855a.isDirectory()) {
                arrayDeque.push(g(h.this.f43855a));
            } else if (h.this.f43855a.isFile()) {
                arrayDeque.push(new C0866b(this, h.this.f43855a));
            } else {
                c();
            }
        }

        private final a g(File file) {
            int i6 = d.f43874a[h.this.f43856b.ordinal()];
            if (i6 == 1) {
                return new c(this, file);
            }
            if (i6 == 2) {
                return new a(this, file);
            }
            throw new NoWhenBranchMatchedException();
        }

        private final File h() {
            File b6;
            while (true) {
                c peek = this.f43861c.peek();
                if (peek == null) {
                    return null;
                }
                b6 = peek.b();
                if (b6 == null) {
                    this.f43861c.pop();
                } else {
                    if (g0.g(b6, peek.a()) || !b6.isDirectory() || this.f43861c.size() >= h.this.f43860f) {
                        break;
                    }
                    this.f43861c.push(g(b6));
                }
            }
            return b6;
        }

        @Override // kotlin.collections.c
        protected void a() {
            File h6 = h();
            if (h6 != null) {
                e(h6);
            } else {
                c();
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static abstract class c {

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        private final File f43875a;

        @Nullable
        public abstract File b();

        public c(@NotNull File root) {
            g0.p(root, "root");
            this.f43875a = root;
        }

        @NotNull
        public final File a() {
            return this.f43875a;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private h(File file, FileWalkDirection fileWalkDirection, Function1<? super File, Boolean> function1, Function1<? super File, n1> function12, Function2<? super File, ? super IOException, n1> function2, int i6) {
        this.f43855a = file;
        this.f43856b = fileWalkDirection;
        this.f43857c = function1;
        this.f43858d = function12;
        this.f43859e = function2;
        this.f43860f = i6;
    }

    @NotNull
    public final h i(int i6) {
        if (i6 > 0) {
            return new h(this.f43855a, this.f43856b, this.f43857c, this.f43858d, this.f43859e, i6);
        }
        throw new IllegalArgumentException("depth must be positive, but was " + i6 + '.');
    }

    @Override // kotlin.sequences.m
    @NotNull
    public Iterator<File> iterator() {
        return new b();
    }

    @NotNull
    public final h j(@NotNull Function1<? super File, Boolean> function) {
        g0.p(function, "function");
        return new h(this.f43855a, this.f43856b, function, this.f43858d, this.f43859e, this.f43860f);
    }

    @NotNull
    public final h k(@NotNull Function2<? super File, ? super IOException, n1> function) {
        g0.p(function, "function");
        return new h(this.f43855a, this.f43856b, this.f43857c, this.f43858d, function, this.f43860f);
    }

    @NotNull
    public final h l(@NotNull Function1<? super File, n1> function) {
        g0.p(function, "function");
        return new h(this.f43855a, this.f43856b, this.f43857c, function, this.f43859e, this.f43860f);
    }

    /* synthetic */ h(File file, FileWalkDirection fileWalkDirection, Function1 function1, Function1 function12, Function2 function2, int i6, int i7, v vVar) {
        this(file, (i7 & 2) != 0 ? FileWalkDirection.TOP_DOWN : fileWalkDirection, function1, function12, function2, (i7 & 32) != 0 ? Integer.MAX_VALUE : i6);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public h(@NotNull File start, @NotNull FileWalkDirection direction) {
        this(start, direction, null, null, null, 0, 32, null);
        g0.p(start, "start");
        g0.p(direction, "direction");
    }

    public /* synthetic */ h(File file, FileWalkDirection fileWalkDirection, int i6, v vVar) {
        this(file, (i6 & 2) != 0 ? FileWalkDirection.TOP_DOWN : fileWalkDirection);
    }
}
