package kotlin.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.collections.f0;
import kotlin.collections.r0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.n1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Utils.kt\nkotlin/io/FilesKt__UtilsKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Sequences.kt\nkotlin/sequences/SequencesKt___SequencesKt\n*L\n1#1,473:1\n1#2:474\n1292#3,3:475\n*S KotlinDebug\n*F\n+ 1 Utils.kt\nkotlin/io/FilesKt__UtilsKt\n*L\n347#1:475,3\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
class o extends m {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class a implements Function2 {

        /* renamed from: a, reason: collision with root package name */
        public static final a f43878a = new a();

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Void invoke(File file, IOException exception) {
            g0.p(file, "<unused var>");
            g0.p(exception, "exception");
            throw exception;
        }

        a() {
        }
    }

    public static final boolean T(@NotNull File file, @NotNull File target, boolean z5, @NotNull final Function2<? super File, ? super IOException, ? extends OnErrorAction> onError) {
        g0.p(file, "<this>");
        g0.p(target, "target");
        g0.p(onError, "onError");
        if (!file.exists()) {
            return onError.invoke(file, new NoSuchFileException(file, null, "The source file doesn't exist.", 2, null)) != OnErrorAction.TERMINATE;
        }
        try {
            Iterator<File> it = m.R(file).k(new Function2() { // from class: kotlin.io.n
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    n1 V;
                    V = o.V(Function2.this, (File) obj, (IOException) obj2);
                    return V;
                }
            }).iterator();
            while (it.hasNext()) {
                File next = it.next();
                if (next.exists()) {
                    File file2 = new File(target, u0(next, file));
                    if (file2.exists() && (!next.isDirectory() || !file2.isDirectory())) {
                        if (z5) {
                            if (file2.isDirectory()) {
                                if (!c0(file2)) {
                                }
                            } else if (!file2.delete()) {
                            }
                        }
                        if (onError.invoke(file2, new FileAlreadyExistsException(next, file2, "The destination file already exists.")) == OnErrorAction.TERMINATE) {
                            return false;
                        }
                    }
                    if (next.isDirectory()) {
                        file2.mkdirs();
                    } else {
                        boolean z6 = z5;
                        if (X(next, file2, z6, 0, 4, null).length() != next.length() && onError.invoke(next, new IOException("Source file wasn't copied completely, length of destination file differs.")) == OnErrorAction.TERMINATE) {
                            return false;
                        }
                        z5 = z6;
                    }
                } else if (onError.invoke(next, new NoSuchFileException(next, null, "The source file doesn't exist.", 2, null)) == OnErrorAction.TERMINATE) {
                    return false;
                }
            }
            return true;
        } catch (s unused) {
            return false;
        }
    }

    public static /* synthetic */ boolean U(File file, File file2, boolean z5, Function2 function2, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            z5 = false;
        }
        if ((i6 & 4) != 0) {
            function2 = a.f43878a;
        }
        return T(file, file2, z5, function2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 V(Function2 function2, File f6, IOException e6) {
        g0.p(f6, "f");
        g0.p(e6, "e");
        if (function2.invoke(f6, e6) != OnErrorAction.TERMINATE) {
            return n1.f44123a;
        }
        throw new s(f6);
    }

    @NotNull
    public static final File W(@NotNull File file, @NotNull File target, boolean z5, int i6) {
        g0.p(file, "<this>");
        g0.p(target, "target");
        if (!file.exists()) {
            throw new NoSuchFileException(file, null, "The source file doesn't exist.", 2, null);
        }
        if (target.exists()) {
            if (!z5) {
                throw new FileAlreadyExistsException(file, target, "The destination file already exists.");
            }
            if (!target.delete()) {
                throw new FileAlreadyExistsException(file, target, "Tried to overwrite the destination, but failed to delete it.");
            }
        }
        if (file.isDirectory()) {
            if (target.mkdirs()) {
                return target;
            }
            throw new FileSystemException(file, target, "Failed to create target directory.");
        }
        File parentFile = target.getParentFile();
        if (parentFile != null) {
            parentFile.mkdirs();
        }
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(target);
            try {
                kotlin.io.a.k(fileInputStream, fileOutputStream, i6);
                b.a(fileOutputStream, null);
                b.a(fileInputStream, null);
                return target;
            } finally {
            }
        } finally {
        }
    }

    public static /* synthetic */ File X(File file, File file2, boolean z5, int i6, int i7, Object obj) {
        if ((i7 & 2) != 0) {
            z5 = false;
        }
        if ((i7 & 4) != 0) {
            i6 = 8192;
        }
        return W(file, file2, z5, i6);
    }

    @Deprecated(message = "Avoid creating temporary directories in the default temp location with this function due to too wide permissions on the newly created directory. Use kotlin.io.path.createTempDirectory instead.")
    @NotNull
    public static final File Y(@NotNull String prefix, @Nullable String str, @Nullable File file) {
        g0.p(prefix, "prefix");
        File createTempFile = File.createTempFile(prefix, str, file);
        createTempFile.delete();
        if (createTempFile.mkdir()) {
            g0.m(createTempFile);
            return createTempFile;
        }
        throw new IOException("Unable to create temporary directory " + createTempFile + '.');
    }

    public static /* synthetic */ File Z(String str, String str2, File file, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            str = "tmp";
        }
        if ((i6 & 2) != 0) {
            str2 = null;
        }
        if ((i6 & 4) != 0) {
            file = null;
        }
        return Y(str, str2, file);
    }

    @Deprecated(message = "Avoid creating temporary files in the default temp location with this function due to too wide permissions on the newly created file. Use kotlin.io.path.createTempFile instead or resort to java.io.File.createTempFile.")
    @NotNull
    public static final File a0(@NotNull String prefix, @Nullable String str, @Nullable File file) {
        g0.p(prefix, "prefix");
        File createTempFile = File.createTempFile(prefix, str, file);
        g0.o(createTempFile, "createTempFile(...)");
        return createTempFile;
    }

    public static /* synthetic */ File b0(String str, String str2, File file, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            str = "tmp";
        }
        if ((i6 & 2) != 0) {
            str2 = null;
        }
        if ((i6 & 4) != 0) {
            file = null;
        }
        return a0(str, str2, file);
    }

    public static final boolean c0(@NotNull File file) {
        g0.p(file, "<this>");
        while (true) {
            boolean z5 = true;
            for (File file2 : m.Q(file)) {
                if (file2.delete() || !file2.exists()) {
                    if (z5) {
                        break;
                    }
                }
                z5 = false;
            }
            return z5;
        }
    }

    public static final boolean d0(@NotNull File file, @NotNull File other) {
        g0.p(file, "<this>");
        g0.p(other, "other");
        g f6 = j.f(file);
        g f7 = j.f(other);
        if (f7.i()) {
            return g0.g(file, other);
        }
        int h6 = f6.h() - f7.h();
        if (h6 < 0) {
            return false;
        }
        return f6.g().subList(h6, f6.h()).equals(f7.g());
    }

    public static final boolean e0(@NotNull File file, @NotNull String other) {
        g0.p(file, "<this>");
        g0.p(other, "other");
        return d0(file, new File(other));
    }

    @NotNull
    public static final String f0(@NotNull File file) {
        g0.p(file, "<this>");
        String name = file.getName();
        g0.o(name, "getName(...)");
        return kotlin.text.u.L5(name, '.', "");
    }

    @NotNull
    public static final String g0(@NotNull File file) {
        g0.p(file, "<this>");
        char c6 = File.separatorChar;
        if (c6 != '/') {
            String path = file.getPath();
            g0.o(path, "getPath(...)");
            return kotlin.text.u.w2(path, c6, '/', false, 4, null);
        }
        String path2 = file.getPath();
        g0.o(path2, "getPath(...)");
        return path2;
    }

    @NotNull
    public static final String h0(@NotNull File file) {
        g0.p(file, "<this>");
        String name = file.getName();
        g0.o(name, "getName(...)");
        return kotlin.text.u.W5(name, ".", null, 2, null);
    }

    @NotNull
    public static final File i0(@NotNull File file) {
        g0.p(file, "<this>");
        g f6 = j.f(file);
        File e6 = f6.e();
        List<File> j02 = j0(f6.g());
        String separator = File.separator;
        g0.o(separator, "separator");
        return p0(e6, f0.r3(j02, separator, null, null, 0, null, null, 62, null));
    }

    private static final List<File> j0(List<? extends File> list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (File file : list) {
            String name = file.getName();
            if (g0.g(name, ".")) {
                n1 n1Var = n1.f44123a;
            } else if (!g0.g(name, "..")) {
                arrayList.add(file);
            } else if (arrayList.isEmpty() || g0.g(((File) f0.u3(arrayList)).getName(), "..")) {
                arrayList.add(file);
            }
        }
        return arrayList;
    }

    private static final g k0(g gVar) {
        return new g(gVar.e(), j0(gVar.g()));
    }

    @NotNull
    public static final File l0(@NotNull File file, @NotNull File base) {
        g0.p(file, "<this>");
        g0.p(base, "base");
        return new File(u0(file, base));
    }

    @Nullable
    public static final File m0(@NotNull File file, @NotNull File base) {
        g0.p(file, "<this>");
        g0.p(base, "base");
        String v02 = v0(file, base);
        if (v02 != null) {
            return new File(v02);
        }
        return null;
    }

    @NotNull
    public static final File n0(@NotNull File file, @NotNull File base) {
        g0.p(file, "<this>");
        g0.p(base, "base");
        String v02 = v0(file, base);
        return v02 != null ? new File(v02) : file;
    }

    @NotNull
    public static final File o0(@NotNull File file, @NotNull File relative) {
        g0.p(file, "<this>");
        g0.p(relative, "relative");
        if (j.d(relative)) {
            return relative;
        }
        String file2 = file.toString();
        g0.o(file2, "toString(...)");
        if (file2.length() != 0) {
            char c6 = File.separatorChar;
            if (!kotlin.text.u.q3(file2, c6, false, 2, null)) {
                return new File(file2 + c6 + relative);
            }
        }
        return new File(file2 + relative);
    }

    @NotNull
    public static final File p0(@NotNull File file, @NotNull String relative) {
        g0.p(file, "<this>");
        g0.p(relative, "relative");
        return o0(file, new File(relative));
    }

    @NotNull
    public static final File q0(@NotNull File file, @NotNull File relative) {
        g0.p(file, "<this>");
        g0.p(relative, "relative");
        g f6 = j.f(file);
        return o0(o0(f6.e(), f6.h() == 0 ? new File("..") : f6.j(0, f6.h() - 1)), relative);
    }

    @NotNull
    public static final File r0(@NotNull File file, @NotNull String relative) {
        g0.p(file, "<this>");
        g0.p(relative, "relative");
        return q0(file, new File(relative));
    }

    public static final boolean s0(@NotNull File file, @NotNull File other) {
        g0.p(file, "<this>");
        g0.p(other, "other");
        g f6 = j.f(file);
        g f7 = j.f(other);
        if (g0.g(f6.e(), f7.e()) && f6.h() >= f7.h()) {
            return f6.g().subList(0, f7.h()).equals(f7.g());
        }
        return false;
    }

    public static final boolean t0(@NotNull File file, @NotNull String other) {
        g0.p(file, "<this>");
        g0.p(other, "other");
        return s0(file, new File(other));
    }

    @NotNull
    public static final String u0(@NotNull File file, @NotNull File base) {
        g0.p(file, "<this>");
        g0.p(base, "base");
        String v02 = v0(file, base);
        if (v02 != null) {
            return v02;
        }
        throw new IllegalArgumentException("this and base files have different roots: " + file + " and " + base + '.');
    }

    private static final String v0(File file, File file2) {
        g k02 = k0(j.f(file));
        g k03 = k0(j.f(file2));
        if (!g0.g(k02.e(), k03.e())) {
            return null;
        }
        int h6 = k03.h();
        int h7 = k02.h();
        int min = Math.min(h7, h6);
        int i6 = 0;
        while (i6 < min && g0.g(k02.g().get(i6), k03.g().get(i6))) {
            i6++;
        }
        StringBuilder sb = new StringBuilder();
        int i7 = h6 - 1;
        if (i6 <= i7) {
            while (!g0.g(k03.g().get(i7).getName(), "..")) {
                sb.append("..");
                if (i7 != i6) {
                    sb.append(File.separatorChar);
                }
                if (i7 != i6) {
                    i7--;
                }
            }
            return null;
        }
        if (i6 < h7) {
            if (i6 < h6) {
                sb.append(File.separatorChar);
            }
            List g22 = f0.g2(k02.g(), i6);
            String separator = File.separator;
            g0.o(separator, "separator");
            r0.o3(g22, sb, (r14 & 2) != 0 ? ", " : separator, (r14 & 4) != 0 ? "" : null, (r14 & 8) == 0 ? null : "", (r14 & 16) != 0 ? -1 : 0, (r14 & 32) != 0 ? "..." : null, (r14 & 64) != 0 ? null : null);
        }
        return sb.toString();
    }
}
