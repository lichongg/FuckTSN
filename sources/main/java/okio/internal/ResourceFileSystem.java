package okio.internal;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.JarURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.f0;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.v;
import kotlin.o0;
import kotlin.s;
import kotlin.t;
import kotlin.text.u;
import okio.FileHandle;
import okio.FileMetadata;
import okio.FileSystem;
import okio.Okio;
import okio.Path;
import okio.Sink;
import okio.Source;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nResourceFileSystem.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ResourceFileSystem.kt\nokio/internal/ResourceFileSystem\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,215:1\n774#2:216\n865#2,2:217\n1563#2:219\n1634#2,3:220\n774#2:223\n865#2,2:224\n1563#2:226\n1634#2,3:227\n1617#2,9:230\n1869#2:239\n1870#2:241\n1626#2:242\n1617#2,9:243\n1869#2:252\n1870#2:254\n1626#2:255\n1#3:240\n1#3:253\n*S KotlinDebug\n*F\n+ 1 ResourceFileSystem.kt\nokio/internal/ResourceFileSystem\n*L\n75#1:216\n75#1:217,2\n76#1:219\n76#1:220,3\n91#1:223\n91#1:224,2\n92#1:226\n92#1:227,3\n178#1:230,9\n178#1:239\n178#1:241\n178#1:242\n179#1:243,9\n179#1:252\n179#1:254\n179#1:255\n178#1:240\n179#1:253\n*E\n"})
/* loaded from: D:\Downloads\app\classes4.dex */
public final class ResourceFileSystem extends FileSystem {

    @NotNull
    private static final Companion Companion = new Companion(null);

    @NotNull
    private static final Path ROOT = Path.Companion.get$default(Path.Companion, "/", false, 1, (Object) null);

    @NotNull
    private final ClassLoader classLoader;

    @NotNull
    private final s roots$delegate;

    @NotNull
    private final FileSystem systemFileSystem;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class Companion {
        public /* synthetic */ Companion(v vVar) {
            this();
        }

        private Companion() {
        }

        @NotNull
        public final Path removeBase(@NotNull Path path, @NotNull Path base) {
            g0.p(path, "<this>");
            g0.p(base, "base");
            return getROOT().resolve(u.w2(u.v4(path.toString(), base.toString()), '\\', '/', false, 4, null));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean keepPath(Path path) {
            return !u.Y1(path.name(), ".class", true);
        }

        @NotNull
        public final Path getROOT() {
            return ResourceFileSystem.ROOT;
        }
    }

    public ResourceFileSystem(@NotNull ClassLoader classLoader, boolean z5, @NotNull FileSystem systemFileSystem) {
        g0.p(classLoader, "classLoader");
        g0.p(systemFileSystem, "systemFileSystem");
        this.classLoader = classLoader;
        this.systemFileSystem = systemFileSystem;
        this.roots$delegate = t.c(new Function0() { // from class: okio.internal.b
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                List roots_delegate$lambda$0;
                roots_delegate$lambda$0 = ResourceFileSystem.roots_delegate$lambda$0(ResourceFileSystem.this);
                return roots_delegate$lambda$0;
            }
        });
        if (z5) {
            getRoots().size();
        }
    }

    private final Path canonicalizeInternal(Path path) {
        return ROOT.resolve(path, true);
    }

    private final List<Pair<FileSystem, Path>> getRoots() {
        return (List) this.roots$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List roots_delegate$lambda$0(ResourceFileSystem resourceFileSystem) {
        return resourceFileSystem.toClasspathRoots(resourceFileSystem.classLoader);
    }

    private final List<Pair<FileSystem, Path>> toClasspathRoots(ClassLoader classLoader) {
        Enumeration<URL> resources = classLoader.getResources("");
        g0.o(resources, "getResources(...)");
        ArrayList<URL> list = Collections.list(resources);
        g0.o(list, "list(...)");
        ArrayList arrayList = new ArrayList();
        for (URL url : list) {
            g0.m(url);
            Pair<FileSystem, Path> fileRoot = toFileRoot(url);
            if (fileRoot != null) {
                arrayList.add(fileRoot);
            }
        }
        Enumeration<URL> resources2 = classLoader.getResources("META-INF/MANIFEST.MF");
        g0.o(resources2, "getResources(...)");
        ArrayList<URL> list2 = Collections.list(resources2);
        g0.o(list2, "list(...)");
        ArrayList arrayList2 = new ArrayList();
        for (URL url2 : list2) {
            g0.m(url2);
            Pair<FileSystem, Path> jarRoot = toJarRoot(url2);
            if (jarRoot != null) {
                arrayList2.add(jarRoot);
            }
        }
        return f0.I4(arrayList, arrayList2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean toJarRoot$lambda$0(ZipEntry entry) {
        g0.p(entry, "entry");
        return Companion.keepPath(entry.getCanonicalPath());
    }

    @Override // okio.FileSystem
    @NotNull
    public Sink appendingSink(@NotNull Path file, boolean z5) {
        g0.p(file, "file");
        throw new IOException(this + " is read-only");
    }

    @Override // okio.FileSystem
    public void atomicMove(@NotNull Path source, @NotNull Path target) {
        g0.p(source, "source");
        g0.p(target, "target");
        throw new IOException(this + " is read-only");
    }

    @Override // okio.FileSystem
    @NotNull
    public Path canonicalize(@NotNull Path path) {
        g0.p(path, "path");
        return canonicalizeInternal(path);
    }

    @Override // okio.FileSystem
    public void createDirectory(@NotNull Path dir, boolean z5) {
        g0.p(dir, "dir");
        throw new IOException(this + " is read-only");
    }

    @Override // okio.FileSystem
    public void createSymlink(@NotNull Path source, @NotNull Path target) {
        g0.p(source, "source");
        g0.p(target, "target");
        throw new IOException(this + " is read-only");
    }

    @Override // okio.FileSystem
    public void delete(@NotNull Path path, boolean z5) {
        g0.p(path, "path");
        throw new IOException(this + " is read-only");
    }

    @Override // okio.FileSystem
    @NotNull
    public List<Path> list(@NotNull Path dir) {
        g0.p(dir, "dir");
        String relativePath = toRelativePath(dir);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        boolean z5 = false;
        for (Pair<FileSystem, Path> pair : getRoots()) {
            FileSystem component1 = pair.component1();
            Path component2 = pair.component2();
            try {
                List<Path> list = component1.list(component2.resolve(relativePath));
                ArrayList arrayList = new ArrayList();
                for (Object obj : list) {
                    if (Companion.keepPath((Path) obj)) {
                        arrayList.add(obj);
                    }
                }
                ArrayList arrayList2 = new ArrayList(f0.d0(arrayList, 10));
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    arrayList2.add(Companion.removeBase((Path) it.next(), component2));
                }
                f0.s0(linkedHashSet, arrayList2);
                z5 = true;
            } catch (IOException unused) {
            }
        }
        if (z5) {
            return f0.a6(linkedHashSet);
        }
        throw new FileNotFoundException("file not found: " + dir);
    }

    @Override // okio.FileSystem
    @Nullable
    public List<Path> listOrNull(@NotNull Path dir) {
        g0.p(dir, "dir");
        String relativePath = toRelativePath(dir);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator<Pair<FileSystem, Path>> it = getRoots().iterator();
        boolean z5 = false;
        while (true) {
            ArrayList arrayList = null;
            if (!it.hasNext()) {
                break;
            }
            Pair<FileSystem, Path> next = it.next();
            FileSystem component1 = next.component1();
            Path component2 = next.component2();
            List<Path> listOrNull = component1.listOrNull(component2.resolve(relativePath));
            if (listOrNull != null) {
                ArrayList arrayList2 = new ArrayList();
                for (Object obj : listOrNull) {
                    if (Companion.keepPath((Path) obj)) {
                        arrayList2.add(obj);
                    }
                }
                ArrayList arrayList3 = new ArrayList(f0.d0(arrayList2, 10));
                Iterator it2 = arrayList2.iterator();
                while (it2.hasNext()) {
                    arrayList3.add(Companion.removeBase((Path) it2.next(), component2));
                }
                arrayList = arrayList3;
            }
            if (arrayList != null) {
                f0.s0(linkedHashSet, arrayList);
                z5 = true;
            }
        }
        if (z5) {
            return f0.a6(linkedHashSet);
        }
        return null;
    }

    @Override // okio.FileSystem
    @Nullable
    public FileMetadata metadataOrNull(@NotNull Path path) {
        g0.p(path, "path");
        if (!Companion.keepPath(path)) {
            return null;
        }
        String relativePath = toRelativePath(path);
        for (Pair<FileSystem, Path> pair : getRoots()) {
            FileMetadata metadataOrNull = pair.component1().metadataOrNull(pair.component2().resolve(relativePath));
            if (metadataOrNull != null) {
                return metadataOrNull;
            }
        }
        return null;
    }

    @Override // okio.FileSystem
    @NotNull
    public FileHandle openReadOnly(@NotNull Path file) {
        g0.p(file, "file");
        if (!Companion.keepPath(file)) {
            throw new FileNotFoundException("file not found: " + file);
        }
        String relativePath = toRelativePath(file);
        for (Pair<FileSystem, Path> pair : getRoots()) {
            try {
                return pair.component1().openReadOnly(pair.component2().resolve(relativePath));
            } catch (FileNotFoundException unused) {
            }
        }
        throw new FileNotFoundException("file not found: " + file);
    }

    @Override // okio.FileSystem
    @NotNull
    public FileHandle openReadWrite(@NotNull Path file, boolean z5, boolean z6) {
        g0.p(file, "file");
        throw new IOException("resources are not writable");
    }

    @Override // okio.FileSystem
    @NotNull
    public Sink sink(@NotNull Path file, boolean z5) {
        g0.p(file, "file");
        throw new IOException(this + " is read-only");
    }

    @Override // okio.FileSystem
    @NotNull
    public Source source(@NotNull Path file) {
        g0.p(file, "file");
        if (!Companion.keepPath(file)) {
            throw new FileNotFoundException("file not found: " + file);
        }
        Path path = ROOT;
        URL resource = this.classLoader.getResource(Path.resolve$default(path, file, false, 2, (Object) null).relativeTo(path).toString());
        if (resource == null) {
            throw new FileNotFoundException("file not found: " + file);
        }
        URLConnection openConnection = resource.openConnection();
        if (openConnection instanceof JarURLConnection) {
            ((JarURLConnection) openConnection).setUseCaches(false);
        }
        InputStream inputStream = openConnection.getInputStream();
        g0.o(inputStream, "getInputStream(...)");
        return Okio.source(inputStream);
    }

    private final Pair<FileSystem, Path> toFileRoot(URL url) {
        if (!g0.g(url.getProtocol(), master.flame.danmaku.danmaku.parser.b.f50156c)) {
            return null;
        }
        return o0.a(this.systemFileSystem, Path.Companion.get$default(Path.Companion, new File(url.toURI()), false, 1, (Object) null));
    }

    private final Pair<FileSystem, Path> toJarRoot(URL url) {
        int W3;
        String url2 = url.toString();
        g0.o(url2, "toString(...)");
        if (!u.H2(url2, "jar:file:", false, 2, null) || (W3 = u.W3(url2, "!", 0, false, 6, null)) == -1) {
            return null;
        }
        Path.Companion companion = Path.Companion;
        String substring = url2.substring(4, W3);
        g0.o(substring, "substring(...)");
        return o0.a(ZipFilesKt.openZip(Path.Companion.get$default(companion, new File(URI.create(substring)), false, 1, (Object) null), this.systemFileSystem, new Function1() { // from class: okio.internal.a
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                boolean jarRoot$lambda$0;
                jarRoot$lambda$0 = ResourceFileSystem.toJarRoot$lambda$0((ZipEntry) obj);
                return Boolean.valueOf(jarRoot$lambda$0);
            }
        }), ROOT);
    }

    private final String toRelativePath(Path path) {
        return canonicalizeInternal(path).relativeTo(ROOT).toString();
    }

    public /* synthetic */ ResourceFileSystem(ClassLoader classLoader, boolean z5, FileSystem fileSystem, int i6, v vVar) {
        this(classLoader, z5, (i6 & 4) != 0 ? FileSystem.SYSTEM : fileSystem);
    }
}
