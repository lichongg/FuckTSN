package okhttp3.internal.publicsuffix;

import kotlin.jvm.JvmField;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.v;
import okio.FileSystem;
import okio.Path;
import okio.Source;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public final class ResourcePublicSuffixList extends BasePublicSuffixList {

    @NotNull
    public static final Companion Companion = new Companion(null);

    @JvmField
    @NotNull
    public static final Path PUBLIC_SUFFIX_RESOURCE = Path.Companion.get$default(Path.Companion, "okhttp3/internal/publicsuffix/" + PublicSuffixDatabase.class.getSimpleName() + ".list", false, 1, (Object) null);

    @NotNull
    private final FileSystem fileSystem;

    @NotNull
    private final Path path;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class Companion {
        public /* synthetic */ Companion(v vVar) {
            this();
        }

        private Companion() {
        }
    }

    public ResourcePublicSuffixList() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public ResourcePublicSuffixList(@NotNull Path path, @NotNull FileSystem fileSystem) {
        g0.p(path, "path");
        g0.p(fileSystem, "fileSystem");
        this.path = path;
        this.fileSystem = fileSystem;
    }

    @NotNull
    public final FileSystem getFileSystem() {
        return this.fileSystem;
    }

    @Override // okhttp3.internal.publicsuffix.BasePublicSuffixList
    @NotNull
    public Path getPath() {
        return this.path;
    }

    @Override // okhttp3.internal.publicsuffix.BasePublicSuffixList
    @NotNull
    public Source listSource() {
        return this.fileSystem.source(getPath());
    }

    public /* synthetic */ ResourcePublicSuffixList(Path path, FileSystem fileSystem, int i6, v vVar) {
        this((i6 & 1) != 0 ? PUBLIC_SUFFIX_RESOURCE : path, (i6 & 2) != 0 ? FileSystem.RESOURCES : fileSystem);
    }
}
