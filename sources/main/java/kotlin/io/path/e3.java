package kotlin.io.path;

import androidx.exifinterface.media.ExifInterface;
import com.daimajia.numberprogressbar.BuildConfig;
import java.io.IOException;
import java.net.URI;
import java.nio.file.CopyOption;
import java.nio.file.DirectoryStream;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.FileStore;
import java.nio.file.FileSystem;
import java.nio.file.FileVisitOption;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.FileAttributeView;
import java.nio.file.attribute.FileTime;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.UserPrincipal;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.KotlinNothingValueException;
import kotlin.PublishedApi;
import kotlin.ReplaceWith;
import kotlin.SinceKotlin;
import kotlin.WasExperimental;
import kotlin.internal.InlineOnly;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nPathUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PathUtils.kt\nkotlin/io/path/PathsKt__PathUtilsKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,1195:1\n1#2:1196\n1869#3,2:1197\n*S KotlinDebug\n*F\n+ 1 PathUtils.kt\nkotlin/io/path/PathsKt__PathUtilsKt\n*L\n415#1:1197,2\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public class e3 extends y1 {
    static /* synthetic */ Object L1(Path path, String glob, Function1 block, int i6, Object obj) throws IOException {
        DirectoryStream newDirectoryStream;
        if ((i6 & 1) != 0) {
            glob = "*";
        }
        kotlin.jvm.internal.g0.p(path, "<this>");
        kotlin.jvm.internal.g0.p(glob, "glob");
        kotlin.jvm.internal.g0.p(block, "block");
        newDirectoryStream = Files.newDirectoryStream(path, glob);
        try {
            DirectoryStream a6 = m1.a(newDirectoryStream);
            kotlin.jvm.internal.g0.m(a6);
            Object invoke = block.invoke(kotlin.collections.f0.E1(a6));
            kotlin.jvm.internal.d0.d(1);
            kotlin.io.b.a(newDirectoryStream, null);
            kotlin.jvm.internal.d0.c(1);
            return invoke;
        } finally {
        }
    }

    static /* synthetic */ void U0(Path path, String glob, Function1 action, int i6, Object obj) throws IOException {
        DirectoryStream newDirectoryStream;
        if ((i6 & 1) != 0) {
            glob = "*";
        }
        kotlin.jvm.internal.g0.p(path, "<this>");
        kotlin.jvm.internal.g0.p(glob, "glob");
        kotlin.jvm.internal.g0.p(action, "action");
        newDirectoryStream = Files.newDirectoryStream(path, glob);
        try {
            DirectoryStream a6 = m1.a(newDirectoryStream);
            kotlin.jvm.internal.g0.m(a6);
            Iterator it = a6.iterator();
            while (it.hasNext()) {
                action.invoke(it.next());
            }
            kotlin.n1 n1Var = kotlin.n1.f44123a;
            kotlin.jvm.internal.d0.d(1);
            kotlin.io.b.a(newDirectoryStream, null);
            kotlin.jvm.internal.d0.c(1);
        } finally {
        }
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    private static final Path A0(String str, FileAttribute<?>... attributes) throws IOException {
        Path createTempDirectory;
        kotlin.jvm.internal.g0.p(attributes, "attributes");
        createTempDirectory = Files.createTempDirectory(str, (FileAttribute[]) Arrays.copyOf(attributes, attributes.length));
        kotlin.jvm.internal.g0.o(createTempDirectory, "createTempDirectory(...)");
        return createTempDirectory;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    private static final Map<String, Object> A1(Path path, String attributes, LinkOption... options) throws IOException {
        Map<String, Object> readAttributes;
        kotlin.jvm.internal.g0.p(path, "<this>");
        kotlin.jvm.internal.g0.p(attributes, "attributes");
        kotlin.jvm.internal.g0.p(options, "options");
        readAttributes = Files.readAttributes(path, attributes, (LinkOption[]) Arrays.copyOf(options, options.length));
        kotlin.jvm.internal.g0.o(readAttributes, "readAttributes(...)");
        return readAttributes;
    }

    @SinceKotlin(version = "1.5")
    @NotNull
    public static final Path B0(@Nullable Path path, @Nullable String str, @NotNull FileAttribute<?>... attributes) throws IOException {
        Path createTempDirectory;
        Path createTempDirectory2;
        kotlin.jvm.internal.g0.p(attributes, "attributes");
        if (path != null) {
            createTempDirectory2 = Files.createTempDirectory(path, str, (FileAttribute[]) Arrays.copyOf(attributes, attributes.length));
            kotlin.jvm.internal.g0.o(createTempDirectory2, "createTempDirectory(...)");
            return createTempDirectory2;
        }
        createTempDirectory = Files.createTempDirectory(str, (FileAttribute[]) Arrays.copyOf(attributes, attributes.length));
        kotlin.jvm.internal.g0.o(createTempDirectory, "createTempDirectory(...)");
        return createTempDirectory;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    private static final Path B1(Path path) throws IOException {
        Path readSymbolicLink;
        kotlin.jvm.internal.g0.p(path, "<this>");
        readSymbolicLink = Files.readSymbolicLink(path);
        kotlin.jvm.internal.g0.o(readSymbolicLink, "readSymbolicLink(...)");
        return readSymbolicLink;
    }

    static /* synthetic */ Path C0(String str, FileAttribute[] attributes, int i6, Object obj) throws IOException {
        Path createTempDirectory;
        if ((i6 & 1) != 0) {
            str = null;
        }
        kotlin.jvm.internal.g0.p(attributes, "attributes");
        createTempDirectory = Files.createTempDirectory(str, (FileAttribute[]) Arrays.copyOf(attributes, attributes.length));
        kotlin.jvm.internal.g0.o(createTempDirectory, "createTempDirectory(...)");
        return createTempDirectory;
    }

    @SinceKotlin(version = "1.5")
    @NotNull
    public static final Path C1(@NotNull Path path, @NotNull Path base) {
        kotlin.jvm.internal.g0.p(path, "<this>");
        kotlin.jvm.internal.g0.p(base, "base");
        try {
            return d0.f43889a.a(path, base);
        } catch (IllegalArgumentException e6) {
            throw new IllegalArgumentException(e6.getMessage() + "\nthis path: " + path + "\nbase path: " + base, e6);
        }
    }

    public static /* synthetic */ Path D0(Path path, String str, FileAttribute[] fileAttributeArr, int i6, Object obj) throws IOException {
        if ((i6 & 2) != 0) {
            str = null;
        }
        return B0(path, str, fileAttributeArr);
    }

    @SinceKotlin(version = "1.5")
    @Nullable
    public static final Path D1(@NotNull Path path, @NotNull Path base) {
        kotlin.jvm.internal.g0.p(path, "<this>");
        kotlin.jvm.internal.g0.p(base, "base");
        try {
            return d0.f43889a.a(path, base);
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    private static final Path E0(String str, String str2, FileAttribute<?>... attributes) throws IOException {
        Path createTempFile;
        kotlin.jvm.internal.g0.p(attributes, "attributes");
        createTempFile = Files.createTempFile(str, str2, (FileAttribute[]) Arrays.copyOf(attributes, attributes.length));
        kotlin.jvm.internal.g0.o(createTempFile, "createTempFile(...)");
        return createTempFile;
    }

    @SinceKotlin(version = "1.5")
    @NotNull
    public static final Path E1(@NotNull Path path, @NotNull Path base) {
        kotlin.jvm.internal.g0.p(path, "<this>");
        kotlin.jvm.internal.g0.p(base, "base");
        Path D1 = D1(path, base);
        return D1 == null ? path : D1;
    }

    @SinceKotlin(version = "1.5")
    @NotNull
    public static final Path F0(@Nullable Path path, @Nullable String str, @Nullable String str2, @NotNull FileAttribute<?>... attributes) throws IOException {
        Path createTempFile;
        Path createTempFile2;
        kotlin.jvm.internal.g0.p(attributes, "attributes");
        if (path != null) {
            createTempFile2 = Files.createTempFile(path, str, str2, (FileAttribute[]) Arrays.copyOf(attributes, attributes.length));
            kotlin.jvm.internal.g0.o(createTempFile2, "createTempFile(...)");
            return createTempFile2;
        }
        createTempFile = Files.createTempFile(str, str2, (FileAttribute[]) Arrays.copyOf(attributes, attributes.length));
        kotlin.jvm.internal.g0.o(createTempFile, "createTempFile(...)");
        return createTempFile;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    private static final Path F1(Path path, String attribute, Object obj, LinkOption... options) throws IOException {
        Path attribute2;
        kotlin.jvm.internal.g0.p(path, "<this>");
        kotlin.jvm.internal.g0.p(attribute, "attribute");
        kotlin.jvm.internal.g0.p(options, "options");
        attribute2 = Files.setAttribute(path, attribute, obj, (LinkOption[]) Arrays.copyOf(options, options.length));
        kotlin.jvm.internal.g0.o(attribute2, "setAttribute(...)");
        return attribute2;
    }

    static /* synthetic */ Path G0(String str, String str2, FileAttribute[] attributes, int i6, Object obj) throws IOException {
        Path createTempFile;
        if ((i6 & 1) != 0) {
            str = null;
        }
        if ((i6 & 2) != 0) {
            str2 = null;
        }
        kotlin.jvm.internal.g0.p(attributes, "attributes");
        createTempFile = Files.createTempFile(str, str2, (FileAttribute[]) Arrays.copyOf(attributes, attributes.length));
        kotlin.jvm.internal.g0.o(createTempFile, "createTempFile(...)");
        return createTempFile;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    private static final Path G1(Path path, FileTime value) throws IOException {
        Path lastModifiedTime;
        kotlin.jvm.internal.g0.p(path, "<this>");
        kotlin.jvm.internal.g0.p(value, "value");
        lastModifiedTime = Files.setLastModifiedTime(path, value);
        kotlin.jvm.internal.g0.o(lastModifiedTime, "setLastModifiedTime(...)");
        return lastModifiedTime;
    }

    public static /* synthetic */ Path H0(Path path, String str, String str2, FileAttribute[] fileAttributeArr, int i6, Object obj) throws IOException {
        if ((i6 & 2) != 0) {
            str = null;
        }
        if ((i6 & 4) != 0) {
            str2 = null;
        }
        return F0(path, str, str2, fileAttributeArr);
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    private static final Path H1(Path path, UserPrincipal value) throws IOException {
        Path owner;
        kotlin.jvm.internal.g0.p(path, "<this>");
        kotlin.jvm.internal.g0.p(value, "value");
        owner = Files.setOwner(path, value);
        kotlin.jvm.internal.g0.o(owner, "setOwner(...)");
        return owner;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    private static final void I0(Path path) throws IOException {
        kotlin.jvm.internal.g0.p(path, "<this>");
        Files.delete(path);
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    private static final Path I1(Path path, Set<? extends PosixFilePermission> value) throws IOException {
        Path posixFilePermissions;
        kotlin.jvm.internal.g0.p(path, "<this>");
        kotlin.jvm.internal.g0.p(value, "value");
        posixFilePermissions = Files.setPosixFilePermissions(path, value);
        kotlin.jvm.internal.g0.o(posixFilePermissions, "setPosixFilePermissions(...)");
        return posixFilePermissions;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    private static final boolean J0(Path path) throws IOException {
        boolean deleteIfExists;
        kotlin.jvm.internal.g0.p(path, "<this>");
        deleteIfExists = Files.deleteIfExists(path);
        return deleteIfExists;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    private static final Path J1(URI uri) {
        Path path;
        kotlin.jvm.internal.g0.p(uri, "<this>");
        path = Paths.get(uri);
        kotlin.jvm.internal.g0.o(path, "get(...)");
        return path;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    private static final Path K0(Path path, String other) {
        Path resolve;
        kotlin.jvm.internal.g0.p(path, "<this>");
        kotlin.jvm.internal.g0.p(other, "other");
        resolve = path.resolve(other);
        kotlin.jvm.internal.g0.o(resolve, "resolve(...)");
        return resolve;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    private static final <T> T K1(Path path, String glob, Function1<? super kotlin.sequences.m<? extends Path>, ? extends T> block) throws IOException {
        DirectoryStream newDirectoryStream;
        kotlin.jvm.internal.g0.p(path, "<this>");
        kotlin.jvm.internal.g0.p(glob, "glob");
        kotlin.jvm.internal.g0.p(block, "block");
        newDirectoryStream = Files.newDirectoryStream(path, glob);
        try {
            DirectoryStream a6 = m1.a(newDirectoryStream);
            kotlin.jvm.internal.g0.m(a6);
            T invoke = block.invoke(kotlin.collections.f0.E1(a6));
            kotlin.jvm.internal.d0.d(1);
            kotlin.io.b.a(newDirectoryStream, null);
            kotlin.jvm.internal.d0.c(1);
            return invoke;
        } finally {
        }
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    private static final Path L0(Path path, Path other) {
        Path resolve;
        kotlin.jvm.internal.g0.p(path, "<this>");
        kotlin.jvm.internal.g0.p(other, "other");
        resolve = path.resolve(other);
        kotlin.jvm.internal.g0.o(resolve, "resolve(...)");
        return resolve;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    private static final boolean M0(Path path, LinkOption... options) {
        boolean exists;
        kotlin.jvm.internal.g0.p(path, "<this>");
        kotlin.jvm.internal.g0.p(options, "options");
        exists = Files.exists(path, (LinkOption[]) Arrays.copyOf(options, options.length));
        return exists;
    }

    @SinceKotlin(version = "2.1")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    public static final void M1(@NotNull Path path, int i6, boolean z5, @NotNull Function1<? super r, kotlin.n1> builderAction) {
        kotlin.jvm.internal.g0.p(path, "<this>");
        kotlin.jvm.internal.g0.p(builderAction, "builderAction");
        N1(path, S0(builderAction), i6, z5);
    }

    @PublishedApi
    @NotNull
    public static final Void N0(@NotNull Path path, @NotNull Class<?> attributeViewClass) {
        kotlin.jvm.internal.g0.p(path, "path");
        kotlin.jvm.internal.g0.p(attributeViewClass, "attributeViewClass");
        throw new UnsupportedOperationException("The desired attribute view type " + attributeViewClass + " is not available for the file " + path + '.');
    }

    @SinceKotlin(version = "2.1")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    public static final void N1(@NotNull Path path, @NotNull FileVisitor<Path> visitor, int i6, boolean z5) {
        Set k6;
        FileVisitOption fileVisitOption;
        kotlin.jvm.internal.g0.p(path, "<this>");
        kotlin.jvm.internal.g0.p(visitor, "visitor");
        if (z5) {
            fileVisitOption = FileVisitOption.FOLLOW_LINKS;
            k6 = kotlin.collections.u1.f(fileVisitOption);
        } else {
            k6 = kotlin.collections.u1.k();
        }
        Files.walkFileTree(path, k6, i6, visitor);
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    private static final /* synthetic */ <V extends FileAttributeView> V O0(Path path, LinkOption... options) {
        FileAttributeView fileAttributeView;
        kotlin.jvm.internal.g0.p(path, "<this>");
        kotlin.jvm.internal.g0.p(options, "options");
        kotlin.jvm.internal.g0.y(4, ExifInterface.GPS_MEASUREMENT_INTERRUPTED);
        fileAttributeView = Files.getFileAttributeView(path, c3.a(), (LinkOption[]) Arrays.copyOf(options, options.length));
        if (fileAttributeView != null) {
            return (V) b2.a(fileAttributeView);
        }
        kotlin.jvm.internal.g0.y(4, ExifInterface.GPS_MEASUREMENT_INTERRUPTED);
        N0(path, c3.a());
        throw new KotlinNothingValueException();
    }

    public static /* synthetic */ void O1(Path path, int i6, boolean z5, Function1 function1, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            i6 = Integer.MAX_VALUE;
        }
        if ((i7 & 2) != 0) {
            z5 = false;
        }
        M1(path, i6, z5, function1);
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    private static final /* synthetic */ <V extends FileAttributeView> V P0(Path path, LinkOption... options) {
        FileAttributeView fileAttributeView;
        kotlin.jvm.internal.g0.p(path, "<this>");
        kotlin.jvm.internal.g0.p(options, "options");
        kotlin.jvm.internal.g0.y(4, ExifInterface.GPS_MEASUREMENT_INTERRUPTED);
        fileAttributeView = Files.getFileAttributeView(path, c3.a(), (LinkOption[]) Arrays.copyOf(options, options.length));
        return (V) fileAttributeView;
    }

    public static /* synthetic */ void P1(Path path, FileVisitor fileVisitor, int i6, boolean z5, int i7, Object obj) {
        if ((i7 & 2) != 0) {
            i6 = Integer.MAX_VALUE;
        }
        if ((i7 & 4) != 0) {
            z5 = false;
        }
        N1(path, fileVisitor, i6, z5);
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    private static final long Q0(Path path) throws IOException {
        long size;
        kotlin.jvm.internal.g0.p(path, "<this>");
        size = Files.size(path);
        return size;
    }

    @SinceKotlin(version = "2.1")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    @NotNull
    public static final kotlin.sequences.m<Path> Q1(@NotNull Path path, @NotNull PathWalkOption... options) {
        kotlin.jvm.internal.g0.p(path, "<this>");
        kotlin.jvm.internal.g0.p(options, "options");
        return new h0(path, options);
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    private static final FileStore R0(Path path) throws IOException {
        FileStore fileStore;
        kotlin.jvm.internal.g0.p(path, "<this>");
        fileStore = Files.getFileStore(path);
        kotlin.jvm.internal.g0.o(fileStore, "getFileStore(...)");
        return fileStore;
    }

    @SinceKotlin(version = "2.1")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    @NotNull
    public static final FileVisitor<Path> S0(@NotNull Function1<? super r, kotlin.n1> builderAction) {
        kotlin.jvm.internal.g0.p(builderAction, "builderAction");
        s sVar = new s();
        builderAction.invoke(sVar);
        return sVar.e();
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    private static final void T0(Path path, String glob, Function1<? super Path, kotlin.n1> action) throws IOException {
        DirectoryStream newDirectoryStream;
        kotlin.jvm.internal.g0.p(path, "<this>");
        kotlin.jvm.internal.g0.p(glob, "glob");
        kotlin.jvm.internal.g0.p(action, "action");
        newDirectoryStream = Files.newDirectoryStream(path, glob);
        try {
            DirectoryStream a6 = m1.a(newDirectoryStream);
            kotlin.jvm.internal.g0.m(a6);
            Iterator it = a6.iterator();
            while (it.hasNext()) {
                action.invoke(it.next());
            }
            kotlin.n1 n1Var = kotlin.n1.f44123a;
            kotlin.jvm.internal.d0.d(1);
            kotlin.io.b.a(newDirectoryStream, null);
            kotlin.jvm.internal.d0.c(1);
        } finally {
        }
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    private static final Object V0(Path path, String attribute, LinkOption... options) throws IOException {
        Object attribute2;
        kotlin.jvm.internal.g0.p(path, "<this>");
        kotlin.jvm.internal.g0.p(attribute, "attribute");
        kotlin.jvm.internal.g0.p(options, "options");
        attribute2 = Files.getAttribute(path, attribute, (LinkOption[]) Arrays.copyOf(options, options.length));
        return attribute2;
    }

    @NotNull
    public static final String W0(@NotNull Path path) {
        Path fileName;
        String obj;
        String L5;
        kotlin.jvm.internal.g0.p(path, "<this>");
        fileName = path.getFileName();
        return (fileName == null || (obj = fileName.toString()) == null || (L5 = kotlin.text.u.L5(obj, '.', "")) == null) ? "" : L5;
    }

    private static final String Y0(Path path) {
        kotlin.jvm.internal.g0.p(path, "<this>");
        return a1(path);
    }

    @NotNull
    public static final String a1(@NotNull Path path) {
        FileSystem fileSystem;
        String separator;
        kotlin.jvm.internal.g0.p(path, "<this>");
        fileSystem = path.getFileSystem();
        separator = fileSystem.getSeparator();
        if (kotlin.jvm.internal.g0.g(separator, "/")) {
            return path.toString();
        }
        String obj = path.toString();
        kotlin.jvm.internal.g0.m(separator);
        return kotlin.text.u.x2(obj, separator, "/", false, 4, null);
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    private static final FileTime c1(Path path, LinkOption... options) throws IOException {
        FileTime lastModifiedTime;
        kotlin.jvm.internal.g0.p(path, "<this>");
        kotlin.jvm.internal.g0.p(options, "options");
        lastModifiedTime = Files.getLastModifiedTime(path, (LinkOption[]) Arrays.copyOf(options, options.length));
        kotlin.jvm.internal.g0.o(lastModifiedTime, "getLastModifiedTime(...)");
        return lastModifiedTime;
    }

    @NotNull
    public static final String d1(@NotNull Path path) {
        Path fileName;
        kotlin.jvm.internal.g0.p(path, "<this>");
        fileName = path.getFileName();
        String obj = fileName != null ? fileName.toString() : null;
        return obj == null ? "" : obj;
    }

    @NotNull
    public static final String f1(@NotNull Path path) {
        Path fileName;
        String obj;
        String W5;
        kotlin.jvm.internal.g0.p(path, "<this>");
        fileName = path.getFileName();
        return (fileName == null || (obj = fileName.toString()) == null || (W5 = kotlin.text.u.W5(obj, ".", null, 2, null)) == null) ? "" : W5;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    private static final UserPrincipal h1(Path path, LinkOption... options) throws IOException {
        UserPrincipal owner;
        kotlin.jvm.internal.g0.p(path, "<this>");
        kotlin.jvm.internal.g0.p(options, "options");
        owner = Files.getOwner(path, (LinkOption[]) Arrays.copyOf(options, options.length));
        return owner;
    }

    private static final String i1(Path path) {
        kotlin.jvm.internal.g0.p(path, "<this>");
        return path.toString();
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    private static final Set<PosixFilePermission> k1(Path path, LinkOption... options) throws IOException {
        Set<PosixFilePermission> posixFilePermissions;
        kotlin.jvm.internal.g0.p(path, "<this>");
        kotlin.jvm.internal.g0.p(options, "options");
        posixFilePermissions = Files.getPosixFilePermissions(path, (LinkOption[]) Arrays.copyOf(options, options.length));
        kotlin.jvm.internal.g0.o(posixFilePermissions, "getPosixFilePermissions(...)");
        return posixFilePermissions;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    private static final boolean l1(Path path, LinkOption... options) {
        boolean isDirectory;
        kotlin.jvm.internal.g0.p(path, "<this>");
        kotlin.jvm.internal.g0.p(options, "options");
        isDirectory = Files.isDirectory(path, (LinkOption[]) Arrays.copyOf(options, options.length));
        return isDirectory;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    private static final boolean m1(Path path) {
        boolean isExecutable;
        kotlin.jvm.internal.g0.p(path, "<this>");
        isExecutable = Files.isExecutable(path);
        return isExecutable;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    private static final Path n0(String path) {
        Path path2;
        kotlin.jvm.internal.g0.p(path, "path");
        path2 = Paths.get(path, new String[0]);
        kotlin.jvm.internal.g0.o(path2, "get(...)");
        return path2;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    private static final boolean n1(Path path) throws IOException {
        boolean isHidden;
        kotlin.jvm.internal.g0.p(path, "<this>");
        isHidden = Files.isHidden(path);
        return isHidden;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    private static final Path o0(String base, String... subpaths) {
        Path path;
        kotlin.jvm.internal.g0.p(base, "base");
        kotlin.jvm.internal.g0.p(subpaths, "subpaths");
        path = Paths.get(base, (String[]) Arrays.copyOf(subpaths, subpaths.length));
        kotlin.jvm.internal.g0.o(path, "get(...)");
        return path;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    private static final boolean o1(Path path) {
        boolean isReadable;
        kotlin.jvm.internal.g0.p(path, "<this>");
        isReadable = Files.isReadable(path);
        return isReadable;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    private static final Path p0(Path path) {
        Path absolutePath;
        kotlin.jvm.internal.g0.p(path, "<this>");
        absolutePath = path.toAbsolutePath();
        kotlin.jvm.internal.g0.o(absolutePath, "toAbsolutePath(...)");
        return absolutePath;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    private static final boolean p1(Path path, LinkOption... options) {
        boolean isRegularFile;
        kotlin.jvm.internal.g0.p(path, "<this>");
        kotlin.jvm.internal.g0.p(options, "options");
        isRegularFile = Files.isRegularFile(path, (LinkOption[]) Arrays.copyOf(options, options.length));
        return isRegularFile;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    private static final String q0(Path path) {
        Path absolutePath;
        kotlin.jvm.internal.g0.p(path, "<this>");
        absolutePath = path.toAbsolutePath();
        return absolutePath.toString();
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    private static final boolean q1(Path path, Path other) throws IOException {
        boolean isSameFile;
        kotlin.jvm.internal.g0.p(path, "<this>");
        kotlin.jvm.internal.g0.p(other, "other");
        isSameFile = Files.isSameFile(path, other);
        return isSameFile;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    private static final Path r0(Path path, Path target, boolean z5) throws IOException {
        CopyOption[] copyOptionArr;
        Path copy;
        StandardCopyOption standardCopyOption;
        kotlin.jvm.internal.g0.p(path, "<this>");
        kotlin.jvm.internal.g0.p(target, "target");
        if (z5) {
            standardCopyOption = StandardCopyOption.REPLACE_EXISTING;
            copyOptionArr = new CopyOption[]{standardCopyOption};
        } else {
            copyOptionArr = new CopyOption[0];
        }
        copy = Files.copy(path, target, (CopyOption[]) Arrays.copyOf(copyOptionArr, copyOptionArr.length));
        kotlin.jvm.internal.g0.o(copy, "copy(...)");
        return copy;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    private static final boolean r1(Path path) {
        boolean isSymbolicLink;
        kotlin.jvm.internal.g0.p(path, "<this>");
        isSymbolicLink = Files.isSymbolicLink(path);
        return isSymbolicLink;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    private static final Path s0(Path path, Path target, CopyOption... options) throws IOException {
        Path copy;
        kotlin.jvm.internal.g0.p(path, "<this>");
        kotlin.jvm.internal.g0.p(target, "target");
        kotlin.jvm.internal.g0.p(options, "options");
        copy = Files.copy(path, target, (CopyOption[]) Arrays.copyOf(options, options.length));
        kotlin.jvm.internal.g0.o(copy, "copy(...)");
        return copy;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    private static final boolean s1(Path path) {
        boolean isWritable;
        kotlin.jvm.internal.g0.p(path, "<this>");
        isWritable = Files.isWritable(path);
        return isWritable;
    }

    static /* synthetic */ Path t0(Path path, Path target, boolean z5, int i6, Object obj) throws IOException {
        CopyOption[] copyOptionArr;
        Path copy;
        StandardCopyOption standardCopyOption;
        if ((i6 & 2) != 0) {
            z5 = false;
        }
        kotlin.jvm.internal.g0.p(path, "<this>");
        kotlin.jvm.internal.g0.p(target, "target");
        if (z5) {
            standardCopyOption = StandardCopyOption.REPLACE_EXISTING;
            copyOptionArr = new CopyOption[]{standardCopyOption};
        } else {
            copyOptionArr = new CopyOption[0];
        }
        copy = Files.copy(path, target, (CopyOption[]) Arrays.copyOf(copyOptionArr, copyOptionArr.length));
        kotlin.jvm.internal.g0.o(copy, "copy(...)");
        return copy;
    }

    @SinceKotlin(version = "1.5")
    @NotNull
    public static final List<Path> t1(@NotNull Path path, @NotNull String glob) throws IOException {
        DirectoryStream newDirectoryStream;
        kotlin.jvm.internal.g0.p(path, "<this>");
        kotlin.jvm.internal.g0.p(glob, "glob");
        newDirectoryStream = Files.newDirectoryStream(path, glob);
        try {
            DirectoryStream a6 = m1.a(newDirectoryStream);
            kotlin.jvm.internal.g0.m(a6);
            List<Path> a62 = kotlin.collections.f0.a6(a6);
            kotlin.io.b.a(newDirectoryStream, null);
            return a62;
        } finally {
        }
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    private static final Path u0(Path path, FileAttribute<?>... attributes) throws IOException {
        Path createDirectories;
        kotlin.jvm.internal.g0.p(path, "<this>");
        kotlin.jvm.internal.g0.p(attributes, "attributes");
        createDirectories = Files.createDirectories(path, (FileAttribute[]) Arrays.copyOf(attributes, attributes.length));
        kotlin.jvm.internal.g0.o(createDirectories, "createDirectories(...)");
        return createDirectories;
    }

    public static /* synthetic */ List u1(Path path, String str, int i6, Object obj) throws IOException {
        if ((i6 & 1) != 0) {
            str = "*";
        }
        return t1(path, str);
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    private static final Path v0(Path path, FileAttribute<?>... attributes) throws IOException {
        Path createDirectory;
        kotlin.jvm.internal.g0.p(path, "<this>");
        kotlin.jvm.internal.g0.p(attributes, "attributes");
        createDirectory = Files.createDirectory(path, (FileAttribute[]) Arrays.copyOf(attributes, attributes.length));
        kotlin.jvm.internal.g0.o(createDirectory, "createDirectory(...)");
        return createDirectory;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    private static final Path v1(Path path, Path target, boolean z5) throws IOException {
        CopyOption[] copyOptionArr;
        Path move;
        StandardCopyOption standardCopyOption;
        kotlin.jvm.internal.g0.p(path, "<this>");
        kotlin.jvm.internal.g0.p(target, "target");
        if (z5) {
            standardCopyOption = StandardCopyOption.REPLACE_EXISTING;
            copyOptionArr = new CopyOption[]{standardCopyOption};
        } else {
            copyOptionArr = new CopyOption[0];
        }
        move = Files.move(path, target, (CopyOption[]) Arrays.copyOf(copyOptionArr, copyOptionArr.length));
        kotlin.jvm.internal.g0.o(move, "move(...)");
        return move;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    private static final Path w0(Path path, FileAttribute<?>... attributes) throws IOException {
        Path createFile;
        kotlin.jvm.internal.g0.p(path, "<this>");
        kotlin.jvm.internal.g0.p(attributes, "attributes");
        createFile = Files.createFile(path, (FileAttribute[]) Arrays.copyOf(attributes, attributes.length));
        kotlin.jvm.internal.g0.o(createFile, "createFile(...)");
        return createFile;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    private static final Path w1(Path path, Path target, CopyOption... options) throws IOException {
        Path move;
        kotlin.jvm.internal.g0.p(path, "<this>");
        kotlin.jvm.internal.g0.p(target, "target");
        kotlin.jvm.internal.g0.p(options, "options");
        move = Files.move(path, target, (CopyOption[]) Arrays.copyOf(options, options.length));
        kotlin.jvm.internal.g0.o(move, "move(...)");
        return move;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    private static final Path x0(Path path, Path target) throws IOException {
        Path createLink;
        kotlin.jvm.internal.g0.p(path, "<this>");
        kotlin.jvm.internal.g0.p(target, "target");
        createLink = Files.createLink(path, target);
        kotlin.jvm.internal.g0.o(createLink, "createLink(...)");
        return createLink;
    }

    static /* synthetic */ Path x1(Path path, Path target, boolean z5, int i6, Object obj) throws IOException {
        CopyOption[] copyOptionArr;
        Path move;
        StandardCopyOption standardCopyOption;
        if ((i6 & 2) != 0) {
            z5 = false;
        }
        kotlin.jvm.internal.g0.p(path, "<this>");
        kotlin.jvm.internal.g0.p(target, "target");
        if (z5) {
            standardCopyOption = StandardCopyOption.REPLACE_EXISTING;
            copyOptionArr = new CopyOption[]{standardCopyOption};
        } else {
            copyOptionArr = new CopyOption[0];
        }
        move = Files.move(path, target, (CopyOption[]) Arrays.copyOf(copyOptionArr, copyOptionArr.length));
        kotlin.jvm.internal.g0.o(move, "move(...)");
        return move;
    }

    @SinceKotlin(version = "1.9")
    @NotNull
    public static final Path y0(@NotNull Path path, @NotNull FileAttribute<?>... attributes) throws IOException {
        Path parent;
        boolean isDirectory;
        boolean isDirectory2;
        Path createDirectories;
        kotlin.jvm.internal.g0.p(path, "<this>");
        kotlin.jvm.internal.g0.p(attributes, "attributes");
        parent = path.getParent();
        if (parent != null) {
            isDirectory = Files.isDirectory(parent, (LinkOption[]) Arrays.copyOf(new LinkOption[0], 0));
            if (!isDirectory) {
                try {
                    FileAttribute[] fileAttributeArr = (FileAttribute[]) Arrays.copyOf(attributes, attributes.length);
                    createDirectories = Files.createDirectories(parent, (FileAttribute[]) Arrays.copyOf(fileAttributeArr, fileAttributeArr.length));
                    kotlin.jvm.internal.g0.o(createDirectories, "createDirectories(...)");
                    return path;
                } catch (FileAlreadyExistsException e6) {
                    isDirectory2 = Files.isDirectory(parent, (LinkOption[]) Arrays.copyOf(new LinkOption[0], 0));
                    if (!isDirectory2) {
                        throw e6;
                    }
                }
            }
        }
        return path;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    private static final boolean y1(Path path, LinkOption... options) {
        boolean notExists;
        kotlin.jvm.internal.g0.p(path, "<this>");
        kotlin.jvm.internal.g0.p(options, "options");
        notExists = Files.notExists(path, (LinkOption[]) Arrays.copyOf(options, options.length));
        return notExists;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    private static final Path z0(Path path, Path target, FileAttribute<?>... attributes) throws IOException {
        Path createSymbolicLink;
        kotlin.jvm.internal.g0.p(path, "<this>");
        kotlin.jvm.internal.g0.p(target, "target");
        kotlin.jvm.internal.g0.p(attributes, "attributes");
        createSymbolicLink = Files.createSymbolicLink(path, target, (FileAttribute[]) Arrays.copyOf(attributes, attributes.length));
        kotlin.jvm.internal.g0.o(createSymbolicLink, "createSymbolicLink(...)");
        return createSymbolicLink;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    private static final /* synthetic */ <A extends BasicFileAttributes> A z1(Path path, LinkOption... options) throws IOException {
        BasicFileAttributes readAttributes;
        kotlin.jvm.internal.g0.p(path, "<this>");
        kotlin.jvm.internal.g0.p(options, "options");
        kotlin.jvm.internal.g0.y(4, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS);
        readAttributes = Files.readAttributes(path, (Class<BasicFileAttributes>) cn.jiguang.i.g.a(), (LinkOption[]) Arrays.copyOf(options, options.length));
        kotlin.jvm.internal.g0.o(readAttributes, "readAttributes(...)");
        return (A) z1.a(readAttributes);
    }

    @SinceKotlin(version = "1.5")
    public static /* synthetic */ void X0(Path path) {
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    @Deprecated(level = DeprecationLevel.ERROR, message = "Use invariantSeparatorsPathString property instead.", replaceWith = @ReplaceWith(expression = "invariantSeparatorsPathString", imports = {}))
    @ExperimentalPathApi
    public static /* synthetic */ void Z0(Path path) {
    }

    @SinceKotlin(version = "1.5")
    public static /* synthetic */ void b1(Path path) {
    }

    @SinceKotlin(version = "1.5")
    public static /* synthetic */ void e1(Path path) {
    }

    @SinceKotlin(version = "1.5")
    public static /* synthetic */ void g1(Path path) {
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    public static /* synthetic */ void j1(Path path) {
    }
}
