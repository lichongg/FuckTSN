package kotlin.io.path;

import java.nio.file.FileSystem;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
final class d0 {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final d0 f43889a = new d0();

    /* renamed from: b, reason: collision with root package name */
    private static final Path f43890b;

    /* renamed from: c, reason: collision with root package name */
    private static final Path f43891c;

    static {
        Path path;
        Path path2;
        path = Paths.get("", new String[0]);
        f43890b = path;
        path2 = Paths.get("..", new String[0]);
        f43891c = path2;
    }

    @NotNull
    public final Path a(@NotNull Path path, @NotNull Path base) {
        Path normalize;
        Path normalize2;
        Path relativize;
        int nameCount;
        int nameCount2;
        FileSystem fileSystem;
        String separator;
        FileSystem fileSystem2;
        FileSystem fileSystem3;
        String separator2;
        Path name;
        Path name2;
        kotlin.jvm.internal.g0.p(path, "path");
        kotlin.jvm.internal.g0.p(base, "base");
        normalize = base.normalize();
        normalize2 = path.normalize();
        relativize = normalize.relativize(normalize2);
        nameCount = normalize.getNameCount();
        nameCount2 = normalize2.getNameCount();
        int min = Math.min(nameCount, nameCount2);
        for (int i6 = 0; i6 < min; i6++) {
            name = normalize.getName(i6);
            Path path2 = f43891c;
            if (!kotlin.jvm.internal.g0.g(name, path2)) {
                break;
            }
            name2 = normalize2.getName(i6);
            if (!kotlin.jvm.internal.g0.g(name2, path2)) {
                throw new IllegalArgumentException("Unable to compute relative path");
            }
        }
        if (kotlin.jvm.internal.g0.g(normalize2, normalize) || !kotlin.jvm.internal.g0.g(normalize, f43890b)) {
            String obj = relativize.toString();
            fileSystem = relativize.getFileSystem();
            separator = fileSystem.getSeparator();
            kotlin.jvm.internal.g0.o(separator, "getSeparator(...)");
            if (kotlin.text.u.Z1(obj, separator, false, 2, null)) {
                fileSystem2 = relativize.getFileSystem();
                fileSystem3 = relativize.getFileSystem();
                separator2 = fileSystem3.getSeparator();
                normalize2 = fileSystem2.getPath(kotlin.text.u.d7(obj, separator2.length()), new String[0]);
            } else {
                normalize2 = relativize;
            }
        }
        kotlin.jvm.internal.g0.m(normalize2);
        return normalize2;
    }

    private d0() {
    }
}
