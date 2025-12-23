package kotlin.io.path;

import java.io.IOException;
import java.nio.file.CopyOption;
import java.nio.file.DirectoryStream;
import java.nio.file.FileSystem;
import java.nio.file.FileSystemException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.SecureDirectoryStream;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileAttributeView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.SinceKotlin;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nPathRecursiveFunctions.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PathRecursiveFunctions.kt\nkotlin/io/path/PathsKt__PathRecursiveFunctionsKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,532:1\n378#1,2:536\n386#1:538\n386#1:539\n380#1,4:540\n378#1,2:544\n386#1:546\n380#1,4:547\n386#1:551\n378#1,6:552\n378#1,2:558\n386#1:560\n380#1,4:561\n1#2:533\n1869#3,2:534\n*S KotlinDebug\n*F\n+ 1 PathRecursiveFunctions.kt\nkotlin/io/path/PathsKt__PathRecursiveFunctionsKt\n*L\n394#1:536,2\n409#1:538\n412#1:539\n394#1:540,4\n420#1:544,2\n421#1:546\n420#1:547,4\n432#1:551\n440#1:552,6\n463#1:558,2\n464#1:560\n463#1:561,4\n314#1:534,2\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
class y1 extends t0 {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class b implements Function3 {

        /* renamed from: a, reason: collision with root package name */
        public static final b f43967a = new b();

        public final Void a(Path path, Path path2, Exception exception) {
            kotlin.jvm.internal.g0.p(path, "<unused var>");
            kotlin.jvm.internal.g0.p(path2, "<unused var>");
            kotlin.jvm.internal.g0.p(exception, "exception");
            throw exception;
        }

        b() {
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            return a(f.a(obj), f.a(obj2), (Exception) obj3);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class c implements Function3 {

        /* renamed from: a, reason: collision with root package name */
        public static final c f43968a = new c();

        public final Void a(Path path, Path path2, Exception exception) {
            kotlin.jvm.internal.g0.p(path, "<unused var>");
            kotlin.jvm.internal.g0.p(path2, "<unused var>");
            kotlin.jvm.internal.g0.p(exception, "exception");
            throw exception;
        }

        c() {
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            return a(f.a(obj), f.a(obj2), (Exception) obj3);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final /* synthetic */ class d extends FunctionReferenceImpl implements Function2<Path, BasicFileAttributes, FileVisitResult> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ArrayList<Path> f43969a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Function3<kotlin.io.path.a, Path, Path, CopyActionResult> f43970b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Path f43971c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Path f43972d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Path f43973e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Function3<Path, Path, Exception, OnErrorResult> f43974f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        d(ArrayList<Path> arrayList, Function3<? super kotlin.io.path.a, ? super Path, ? super Path, ? extends CopyActionResult> function3, Path path, Path path2, Path path3, Function3<? super Path, ? super Path, ? super Exception, ? extends OnErrorResult> function32) {
            super(2, g0.a.class, "copy", "copyToRecursively$copy$PathsKt__PathRecursiveFunctionsKt(Ljava/util/ArrayList;Lkotlin/jvm/functions/Function3;Ljava/nio/file/Path;Ljava/nio/file/Path;Ljava/nio/file/Path;Lkotlin/jvm/functions/Function3;Ljava/nio/file/Path;Ljava/nio/file/attribute/BasicFileAttributes;)Ljava/nio/file/FileVisitResult;", 0);
            this.f43969a = arrayList;
            this.f43970b = function3;
            this.f43971c = path;
            this.f43972d = path2;
            this.f43973e = path3;
            this.f43974f = function32;
        }

        public final FileVisitResult c(Path p02, BasicFileAttributes p12) {
            kotlin.jvm.internal.g0.p(p02, "p0");
            kotlin.jvm.internal.g0.p(p12, "p1");
            return y1.T(this.f43969a, this.f43970b, this.f43971c, this.f43972d, this.f43973e, this.f43974f, p02, p12);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ FileVisitResult invoke(Path path, BasicFileAttributes basicFileAttributes) {
            return c(f.a(path), z1.a(basicFileAttributes));
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final /* synthetic */ class e extends FunctionReferenceImpl implements Function2<Path, Exception, FileVisitResult> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function3<Path, Path, Exception, OnErrorResult> f43975a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Path f43976b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Path f43977c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Path f43978d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        e(Function3<? super Path, ? super Path, ? super Exception, ? extends OnErrorResult> function3, Path path, Path path2, Path path3) {
            super(2, g0.a.class, "error", "copyToRecursively$error$PathsKt__PathRecursiveFunctionsKt(Lkotlin/jvm/functions/Function3;Ljava/nio/file/Path;Ljava/nio/file/Path;Ljava/nio/file/Path;Ljava/nio/file/Path;Ljava/lang/Exception;)Ljava/nio/file/FileVisitResult;", 0);
            this.f43975a = function3;
            this.f43976b = path;
            this.f43977c = path2;
            this.f43978d = path3;
        }

        public final FileVisitResult c(Path p02, Exception p12) {
            kotlin.jvm.internal.g0.p(p02, "p0");
            kotlin.jvm.internal.g0.p(p12, "p1");
            return y1.X(this.f43975a, this.f43976b, this.f43977c, this.f43978d, p02, p12);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ FileVisitResult invoke(Path path, Exception exc) {
            return c(f.a(path), exc);
        }
    }

    private static final void f0(SecureDirectoryStream<Path> secureDirectoryStream, Path path, q qVar) {
        SecureDirectoryStream secureDirectoryStream2;
        Iterator it;
        Path fileName;
        LinkOption linkOption;
        try {
            try {
                linkOption = LinkOption.NOFOLLOW_LINKS;
                secureDirectoryStream2 = secureDirectoryStream.newDirectoryStream(path, linkOption);
            } catch (NoSuchFileException unused) {
                secureDirectoryStream2 = null;
            }
            if (secureDirectoryStream2 == null) {
                return;
            }
            try {
                SecureDirectoryStream a6 = o1.a(secureDirectoryStream2);
                it = a6.iterator();
                kotlin.jvm.internal.g0.o(it, "iterator(...)");
                while (it.hasNext()) {
                    fileName = f.a(it.next()).getFileName();
                    kotlin.jvm.internal.g0.o(fileName, "getFileName(...)");
                    g0(a6, fileName, qVar.e(), qVar);
                }
                kotlin.n1 n1Var = kotlin.n1.f44123a;
                kotlin.io.b.a(secureDirectoryStream2, null);
            } finally {
            }
        } catch (Exception e6) {
            qVar.a(e6);
        }
    }

    private static final void h0(Path path, q qVar) {
        DirectoryStream directoryStream;
        Iterator it;
        try {
            try {
                directoryStream = Files.newDirectoryStream(path);
            } catch (NoSuchFileException unused) {
                directoryStream = null;
            }
            if (directoryStream == null) {
                return;
            }
            try {
                it = m1.a(directoryStream).iterator();
                kotlin.jvm.internal.g0.o(it, "iterator(...)");
                while (it.hasNext()) {
                    Path a6 = f.a(it.next());
                    kotlin.jvm.internal.g0.m(a6);
                    i0(a6, path, qVar);
                }
                kotlin.n1 n1Var = kotlin.n1.f44123a;
                kotlin.io.b.a(directoryStream, null);
            } finally {
            }
        } catch (Exception e6) {
            qVar.a(e6);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f43965a;

        /* renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f43966b;

        static {
            int[] iArr = new int[CopyActionResult.values().length];
            try {
                iArr[CopyActionResult.CONTINUE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[CopyActionResult.TERMINATE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[CopyActionResult.SKIP_SUBTREE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f43965a = iArr;
            int[] iArr2 = new int[OnErrorResult.values().length];
            try {
                iArr2[OnErrorResult.TERMINATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[OnErrorResult.SKIP_SUBTREE.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            f43966b = iArr2;
        }
    }

    public static final void O(@NotNull Path path) {
        kotlin.jvm.internal.g0.p(path, "<this>");
        String d12 = e3.d1(path);
        int hashCode = d12.hashCode();
        if (hashCode != 46) {
            if (hashCode != 1518) {
                if (hashCode != 45679) {
                    if (hashCode != 45724) {
                        if (hashCode != 1472) {
                            if (hashCode != 1473 || !d12.equals("./")) {
                                return;
                            }
                        } else if (!d12.equals("..")) {
                            return;
                        }
                    } else if (!d12.equals("..\\")) {
                        return;
                    }
                } else if (!d12.equals("../")) {
                    return;
                }
            } else if (!d12.equals(".\\")) {
                return;
            }
        } else if (!d12.equals(".")) {
            return;
        }
        throw new IllegalFileNameException(path);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0063, code lost:
    
        if (r7 == false) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0043, code lost:
    
        if (r3 == false) goto L9;
     */
    /* JADX WARN: Removed duplicated region for block: B:14:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00b1  */
    @kotlin.SinceKotlin(version = "1.8")
    @kotlin.io.path.ExperimentalPathApi
    @org.jetbrains.annotations.NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.nio.file.Path R(@org.jetbrains.annotations.NotNull final java.nio.file.Path r9, @org.jetbrains.annotations.NotNull final java.nio.file.Path r10, @org.jetbrains.annotations.NotNull final kotlin.jvm.functions.Function3<? super java.nio.file.Path, ? super java.nio.file.Path, ? super java.lang.Exception, ? extends kotlin.io.path.OnErrorResult> r11, boolean r12, @org.jetbrains.annotations.NotNull final kotlin.jvm.functions.Function3<? super kotlin.io.path.a, ? super java.nio.file.Path, ? super java.nio.file.Path, ? extends kotlin.io.path.CopyActionResult> r13) {
        /*
            java.lang.String r1 = "<this>"
            kotlin.jvm.internal.g0.p(r9, r1)
            java.lang.String r1 = "target"
            kotlin.jvm.internal.g0.p(r10, r1)
            java.lang.String r1 = "onError"
            kotlin.jvm.internal.g0.p(r11, r1)
            java.lang.String r1 = "copyAction"
            kotlin.jvm.internal.g0.p(r13, r1)
            kotlin.io.path.w r1 = kotlin.io.path.w.f43945a
            java.nio.file.LinkOption[] r1 = r1.a(r12)
            int r3 = r1.length
            java.lang.Object[] r1 = java.util.Arrays.copyOf(r1, r3)
            java.nio.file.LinkOption[] r1 = (java.nio.file.LinkOption[]) r1
            int r3 = r1.length
            java.lang.Object[] r1 = java.util.Arrays.copyOf(r1, r3)
            java.nio.file.LinkOption[] r1 = (java.nio.file.LinkOption[]) r1
            boolean r1 = kotlin.io.path.e0.a(r9, r1)
            if (r1 == 0) goto Le0
            r1 = 0
            java.nio.file.LinkOption[] r3 = new java.nio.file.LinkOption[r1]
            java.lang.Object[] r3 = java.util.Arrays.copyOf(r3, r1)
            java.nio.file.LinkOption[] r3 = (java.nio.file.LinkOption[]) r3
            boolean r3 = kotlin.io.path.e0.a(r9, r3)
            if (r3 == 0) goto Lc3
            if (r12 != 0) goto L45
            boolean r3 = cn.jiguang.bz.h1.a(r9)
            if (r3 != 0) goto Lc3
        L45:
            java.nio.file.LinkOption[] r3 = new java.nio.file.LinkOption[r1]
            java.lang.Object[] r3 = java.util.Arrays.copyOf(r3, r1)
            java.nio.file.LinkOption[] r3 = (java.nio.file.LinkOption[]) r3
            boolean r3 = kotlin.io.path.e0.a(r10, r3)
            r5 = 1
            if (r3 == 0) goto L5c
            boolean r3 = cn.jiguang.bz.h1.a(r10)
            if (r3 != 0) goto L5c
            r3 = 1
            goto L5d
        L5c:
            r3 = 0
        L5d:
            if (r3 == 0) goto L65
            boolean r7 = kotlin.io.path.i0.a(r9, r10)
            if (r7 != 0) goto Lc3
        L65:
            java.nio.file.FileSystem r7 = com.huawei.secure.android.common.util.u.a(r9)
            java.nio.file.FileSystem r8 = com.huawei.secure.android.common.util.u.a(r10)
            boolean r7 = kotlin.jvm.internal.g0.g(r7, r8)
            if (r7 != 0) goto L74
            goto Lae
        L74:
            if (r3 == 0) goto L87
            java.nio.file.LinkOption[] r3 = new java.nio.file.LinkOption[r1]
            java.nio.file.Path r3 = kotlin.io.path.q1.a(r10, r3)
            java.nio.file.LinkOption[] r1 = new java.nio.file.LinkOption[r1]
            java.nio.file.Path r1 = kotlin.io.path.q1.a(r9, r1)
            boolean r1 = kotlin.io.path.p1.a(r3, r1)
            goto Lae
        L87:
            java.nio.file.Path r3 = kotlin.io.path.l.a(r10)
            if (r3 == 0) goto Lae
            java.nio.file.LinkOption[] r7 = new java.nio.file.LinkOption[r1]
            java.lang.Object[] r7 = java.util.Arrays.copyOf(r7, r1)
            java.nio.file.LinkOption[] r7 = (java.nio.file.LinkOption[]) r7
            boolean r7 = kotlin.io.path.e0.a(r3, r7)
            if (r7 == 0) goto Lae
            java.nio.file.LinkOption[] r7 = new java.nio.file.LinkOption[r1]
            java.nio.file.Path r3 = kotlin.io.path.q1.a(r3, r7)
            java.nio.file.LinkOption[] r7 = new java.nio.file.LinkOption[r1]
            java.nio.file.Path r7 = kotlin.io.path.q1.a(r9, r7)
            boolean r3 = kotlin.io.path.p1.a(r3, r7)
            if (r3 == 0) goto Lae
            r1 = 1
        Lae:
            if (r1 != 0) goto Lb1
            goto Lc3
        Lb1:
            kotlin.io.path.p.a()
            java.lang.String r0 = r9.toString()
            java.lang.String r1 = r10.toString()
            java.lang.String r2 = "Recursively copying a directory into its subdirectory is prohibited."
            java.nio.file.FileSystemException r0 = kotlin.io.path.j1.a(r0, r1, r2)
            throw r0
        Lc3:
            java.nio.file.Path r5 = kotlin.io.path.y.a(r10)
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            kotlin.io.path.v1 r3 = new kotlin.io.path.v1
            r4 = r10
            r6 = r11
            r2 = r13
            r0 = r3
            r3 = r9
            r0.<init>()
            r4 = 1
            r5 = 0
            r1 = 0
            r2 = r12
            r3 = r0
            r0 = r9
            kotlin.io.path.e3.O1(r0, r1, r2, r3, r4, r5)
            return r10
        Le0:
            kotlin.io.path.k1.a()
            java.lang.String r0 = r9.toString()
            java.lang.String r1 = r10.toString()
            java.lang.String r2 = "The source file doesn't exist."
            java.nio.file.NoSuchFileException r0 = kotlin.io.path.i1.a(r0, r1, r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.io.path.y1.R(java.nio.file.Path, java.nio.file.Path, kotlin.jvm.functions.Function3, boolean, kotlin.jvm.functions.Function3):java.nio.file.Path");
    }

    @SinceKotlin(version = "1.8")
    @ExperimentalPathApi
    @NotNull
    public static final Path S(@NotNull Path path, @NotNull Path target, @NotNull Function3<? super Path, ? super Path, ? super Exception, ? extends OnErrorResult> onError, final boolean z5, boolean z6) {
        kotlin.jvm.internal.g0.p(path, "<this>");
        kotlin.jvm.internal.g0.p(target, "target");
        kotlin.jvm.internal.g0.p(onError, "onError");
        return z6 ? R(path, target, onError, z5, new Function3() { // from class: kotlin.io.path.u1
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                CopyActionResult Y;
                Y = y1.Y(z5, (a) obj, (Path) obj2, (Path) obj3);
                return Y;
            }
        }) : U(path, target, onError, z5, null, 8, null);
    }

    public static /* synthetic */ Path U(Path path, Path path2, Function3 function3, final boolean z5, Function3 function32, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            function3 = c.f43968a;
        }
        if ((i6 & 8) != 0) {
            function32 = new Function3() { // from class: kotlin.io.path.t1
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj2, Object obj3, Object obj4) {
                    CopyActionResult Z;
                    Z = y1.Z(z5, (a) obj2, (Path) obj3, (Path) obj4);
                    return Z;
                }
            };
        }
        return R(path, path2, function3, z5, function32);
    }

    public static /* synthetic */ Path V(Path path, Path path2, Function3 function3, boolean z5, boolean z6, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            function3 = b.f43967a;
        }
        return S(path, path2, function3, z5, z6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CopyActionResult Y(boolean z5, kotlin.io.path.a copyToRecursively, Path src, Path dst) {
        LinkOption linkOption;
        boolean isDirectory;
        boolean isDirectory2;
        StandardCopyOption standardCopyOption;
        Path copy;
        kotlin.jvm.internal.g0.p(copyToRecursively, "$this$copyToRecursively");
        kotlin.jvm.internal.g0.p(src, "src");
        kotlin.jvm.internal.g0.p(dst, "dst");
        LinkOption[] a6 = w.f43945a.a(z5);
        linkOption = LinkOption.NOFOLLOW_LINKS;
        isDirectory = Files.isDirectory(dst, (LinkOption[]) Arrays.copyOf(new LinkOption[]{linkOption}, 1));
        LinkOption[] linkOptionArr = (LinkOption[]) Arrays.copyOf(a6, a6.length);
        isDirectory2 = Files.isDirectory(src, (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length));
        if (!isDirectory2 || !isDirectory) {
            if (isDirectory) {
                d0(dst);
            }
            kotlin.jvm.internal.s0 s0Var = new kotlin.jvm.internal.s0(2);
            s0Var.b(a6);
            standardCopyOption = StandardCopyOption.REPLACE_EXISTING;
            s0Var.a(standardCopyOption);
            CopyOption[] copyOptionArr = (CopyOption[]) s0Var.d(new CopyOption[s0Var.c()]);
            copy = Files.copy(src, dst, (CopyOption[]) Arrays.copyOf(copyOptionArr, copyOptionArr.length));
            kotlin.jvm.internal.g0.o(copy, "copy(...)");
        }
        return CopyActionResult.CONTINUE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CopyActionResult Z(boolean z5, kotlin.io.path.a aVar, Path src, Path dst) {
        kotlin.jvm.internal.g0.p(aVar, "<this>");
        kotlin.jvm.internal.g0.p(src, "src");
        kotlin.jvm.internal.g0.p(dst, "dst");
        return aVar.a(src, dst, z5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FileVisitResult a0(ArrayList arrayList, Function3 function3, Path path, Path path2, Path path3, Function3 function32, Path directory, BasicFileAttributes attributes) {
        FileVisitResult fileVisitResult;
        kotlin.jvm.internal.g0.p(directory, "directory");
        kotlin.jvm.internal.g0.p(attributes, "attributes");
        FileVisitResult T = T(arrayList, function3, path, path2, path3, function32, directory, attributes);
        fileVisitResult = FileVisitResult.CONTINUE;
        if (T == fileVisitResult) {
            arrayList.add(directory);
        }
        return T;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FileVisitResult b0(ArrayList arrayList, Function3 function3, Path path, Path path2, Path path3, Path directory, IOException iOException) {
        FileVisitResult fileVisitResult;
        kotlin.jvm.internal.g0.p(directory, "directory");
        kotlin.collections.f0.Q0(arrayList);
        if (iOException != null) {
            return X(function3, path, path2, path3, directory, iOException);
        }
        fileVisitResult = FileVisitResult.CONTINUE;
        return fileVisitResult;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.n1 c0(final ArrayList arrayList, final Function3 function3, final Path path, final Path path2, final Path path3, final Function3 function32, r visitFileTree) {
        kotlin.jvm.internal.g0.p(visitFileTree, "$this$visitFileTree");
        visitFileTree.c(new Function2() { // from class: kotlin.io.path.w1
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                FileVisitResult a02;
                a02 = y1.a0(arrayList, function3, path, path2, path3, function32, (Path) obj, (BasicFileAttributes) obj2);
                return a02;
            }
        });
        visitFileTree.b(new d(arrayList, function3, path, path2, path3, function32));
        visitFileTree.d(new e(function32, path, path2, path3));
        visitFileTree.a(new Function2() { // from class: kotlin.io.path.x1
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                FileVisitResult b02;
                b02 = y1.b0(arrayList, function32, path, path2, path3, (Path) obj, (IOException) obj2);
                return b02;
            }
        });
        return kotlin.n1.f44123a;
    }

    @SinceKotlin(version = "1.8")
    @ExperimentalPathApi
    public static final void d0(@NotNull Path path) {
        kotlin.jvm.internal.g0.p(path, "<this>");
        List<Exception> e02 = e0(path);
        if (e02.isEmpty()) {
            return;
        }
        FileSystemException a6 = o.a("Failed to delete one or more files. See suppressed exceptions for details.");
        Iterator<T> it = e02.iterator();
        while (it.hasNext()) {
            kotlin.l.a(a6, (Exception) it.next());
        }
        throw a6;
    }

    private static final List<Exception> e0(Path path) {
        Path fileName;
        Path parent;
        DirectoryStream directoryStream;
        FileSystem fileSystem;
        boolean z5 = false;
        boolean z6 = true;
        q qVar = new q(0, 1, null);
        fileName = path.getFileName();
        if (fileName != null) {
            parent = path.getParent();
            if (parent == null) {
                fileSystem = path.getFileSystem();
                parent = fileSystem.getPath("", new String[0]);
            }
            try {
                directoryStream = Files.newDirectoryStream(parent);
            } catch (Throwable unused) {
                directoryStream = null;
            }
            if (directoryStream != null) {
                try {
                    DirectoryStream a6 = m1.a(directoryStream);
                    if (n1.a(a6)) {
                        qVar.g(parent);
                        g0(o1.a(a6), fileName, null, qVar);
                    } else {
                        z5 = true;
                    }
                    kotlin.n1 n1Var = kotlin.n1.f44123a;
                    kotlin.io.b.a(directoryStream, null);
                    z6 = z5;
                } finally {
                }
            }
        }
        if (z6) {
            i0(path, null, qVar);
        }
        return qVar.d();
    }

    private static final void i0(Path path, Path path2, q qVar) {
        LinkOption linkOption;
        boolean isDirectory;
        if (path2 != null) {
            try {
                O(path);
                P(path, path2);
            } catch (Exception e6) {
                qVar.a(e6);
                return;
            }
        }
        linkOption = LinkOption.NOFOLLOW_LINKS;
        isDirectory = Files.isDirectory(path, (LinkOption[]) Arrays.copyOf(new LinkOption[]{linkOption}, 1));
        if (!isDirectory) {
            Files.deleteIfExists(path);
            return;
        }
        int f6 = qVar.f();
        h0(path, qVar);
        if (f6 == qVar.f()) {
            Files.deleteIfExists(path);
        }
    }

    @ExperimentalPathApi
    private static final FileVisitResult k0(CopyActionResult copyActionResult) {
        FileVisitResult fileVisitResult;
        FileVisitResult fileVisitResult2;
        FileVisitResult fileVisitResult3;
        int i6 = a.f43965a[copyActionResult.ordinal()];
        if (i6 == 1) {
            fileVisitResult = FileVisitResult.CONTINUE;
            return fileVisitResult;
        }
        if (i6 == 2) {
            fileVisitResult2 = FileVisitResult.TERMINATE;
            return fileVisitResult2;
        }
        if (i6 != 3) {
            throw new NoWhenBranchMatchedException();
        }
        fileVisitResult3 = FileVisitResult.SKIP_SUBTREE;
        return fileVisitResult3;
    }

    @ExperimentalPathApi
    private static final FileVisitResult l0(OnErrorResult onErrorResult) {
        FileVisitResult fileVisitResult;
        FileVisitResult fileVisitResult2;
        int i6 = a.f43966b[onErrorResult.ordinal()];
        if (i6 == 1) {
            fileVisitResult = FileVisitResult.TERMINATE;
            return fileVisitResult;
        }
        if (i6 != 2) {
            throw new NoWhenBranchMatchedException();
        }
        fileVisitResult2 = FileVisitResult.SKIP_SUBTREE;
        return fileVisitResult2;
    }

    private static final void P(Path path, Path path2) {
        boolean isSymbolicLink;
        boolean isSameFile;
        isSymbolicLink = Files.isSymbolicLink(path);
        if (!isSymbolicLink) {
            isSameFile = Files.isSameFile(path, path2);
            if (isSameFile) {
                g0.a();
                throw f0.a(path.toString());
            }
        }
    }

    private static final void Q(q qVar, Function0<kotlin.n1> function0) {
        try {
            function0.invoke();
        } catch (Exception e6) {
            qVar.a(e6);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FileVisitResult T(ArrayList<Path> arrayList, Function3<? super kotlin.io.path.a, ? super Path, ? super Path, ? extends CopyActionResult> function3, Path path, Path path2, Path path3, Function3<? super Path, ? super Path, ? super Exception, ? extends OnErrorResult> function32, Path path4, BasicFileAttributes basicFileAttributes) {
        try {
            if (!arrayList.isEmpty()) {
                O(path4);
                Object u32 = kotlin.collections.f0.u3(arrayList);
                kotlin.jvm.internal.g0.o(u32, "last(...)");
                P(path4, f.a(u32));
            }
            return k0(function3.invoke(kotlin.io.path.d.f43888a, path4, W(path, path2, path3, path4)));
        } catch (Exception e6) {
            return X(function32, path, path2, path3, path4, e6);
        }
    }

    private static final Path W(Path path, Path path2, Path path3, Path path4) {
        Path resolve;
        Path normalize;
        boolean startsWith;
        resolve = path2.resolve(e3.C1(path4, path).toString());
        normalize = resolve.normalize();
        startsWith = normalize.startsWith(path3);
        if (startsWith) {
            kotlin.jvm.internal.g0.m(resolve);
            return resolve;
        }
        throw new IllegalFileNameException(path4, resolve, "Copying files to outside the specified target directory is prohibited. The directory being recursively copied might contain an entry with an illegal name.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FileVisitResult X(Function3<? super Path, ? super Path, ? super Exception, ? extends OnErrorResult> function3, Path path, Path path2, Path path3, Path path4, Exception exc) {
        return l0(function3.invoke(path4, W(path, path2, path3, path4), exc));
    }

    private static final void g0(SecureDirectoryStream<Path> secureDirectoryStream, Path path, Path path2, q qVar) {
        LinkOption linkOption;
        qVar.b(path);
        if (path2 != null) {
            try {
                Path e6 = qVar.e();
                kotlin.jvm.internal.g0.m(e6);
                O(e6);
                P(e6, path2);
            } catch (Exception e7) {
                qVar.a(e7);
            }
        }
        linkOption = LinkOption.NOFOLLOW_LINKS;
        if (!j0(secureDirectoryStream, path, linkOption)) {
            secureDirectoryStream.deleteFile(path);
            kotlin.n1 n1Var = kotlin.n1.f44123a;
        } else {
            int f6 = qVar.f();
            f0(secureDirectoryStream, path, qVar);
            if (f6 == qVar.f()) {
                secureDirectoryStream.deleteDirectory(path);
                kotlin.n1 n1Var2 = kotlin.n1.f44123a;
            }
            qVar.c(path);
        }
        qVar.c(path);
    }

    private static final boolean j0(SecureDirectoryStream<Path> secureDirectoryStream, Path path, LinkOption... linkOptionArr) {
        Boolean bool;
        FileAttributeView fileAttributeView;
        BasicFileAttributes readAttributes;
        boolean isDirectory;
        try {
            fileAttributeView = secureDirectoryStream.getFileAttributeView(path, y0.a(), (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length));
            readAttributes = a1.a(fileAttributeView).readAttributes();
            isDirectory = readAttributes.isDirectory();
            bool = Boolean.valueOf(isDirectory);
        } catch (NoSuchFileException unused) {
            bool = null;
        }
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    private static final <R> R m0(Function0<? extends R> function0) {
        try {
            return function0.invoke();
        } catch (NoSuchFileException unused) {
            return null;
        }
    }
}
