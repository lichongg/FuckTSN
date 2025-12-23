package kotlin.io.path;

import java.nio.file.FileVisitOption;
import java.nio.file.LinkOption;
import java.util.Set;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class w {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final w f43945a = new w();

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private static final LinkOption[] f43946b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private static final LinkOption[] f43947c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private static final Set<FileVisitOption> f43948d;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    private static final Set<FileVisitOption> f43949e;

    static {
        LinkOption linkOption;
        FileVisitOption fileVisitOption;
        linkOption = LinkOption.NOFOLLOW_LINKS;
        f43946b = new LinkOption[]{linkOption};
        f43947c = new LinkOption[0];
        f43948d = kotlin.collections.u1.k();
        fileVisitOption = FileVisitOption.FOLLOW_LINKS;
        f43949e = kotlin.collections.u1.f(fileVisitOption);
    }

    @NotNull
    public final LinkOption[] a(boolean z5) {
        return z5 ? f43947c : f43946b;
    }

    @NotNull
    public final Set<FileVisitOption> b(boolean z5) {
        return z5 ? f43949e : f43948d;
    }

    private w() {
    }
}
