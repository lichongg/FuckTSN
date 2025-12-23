package kotlin.io.path;

import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.util.Arrays;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@ExperimentalPathApi
/* loaded from: D:\Downloads\app\classes8.dex */
final class d implements a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final d f43888a = new d();

    @Override // kotlin.io.path.a
    @NotNull
    public CopyActionResult a(@NotNull Path path, @NotNull Path target, boolean z5) {
        boolean isDirectory;
        Path copy;
        LinkOption linkOption;
        boolean isDirectory2;
        kotlin.jvm.internal.g0.p(path, "<this>");
        kotlin.jvm.internal.g0.p(target, "target");
        LinkOption[] a6 = w.f43945a.a(z5);
        LinkOption[] linkOptionArr = (LinkOption[]) Arrays.copyOf(a6, a6.length);
        isDirectory = Files.isDirectory(path, (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length));
        if (isDirectory) {
            linkOption = LinkOption.NOFOLLOW_LINKS;
            isDirectory2 = Files.isDirectory(target, (LinkOption[]) Arrays.copyOf(new LinkOption[]{linkOption}, 1));
            if (isDirectory2) {
                kotlin.n1 n1Var = kotlin.n1.f44123a;
                return CopyActionResult.CONTINUE;
            }
        }
        CopyOption[] copyOptionArr = (CopyOption[]) Arrays.copyOf(a6, a6.length);
        copy = Files.copy(path, target, (CopyOption[]) Arrays.copyOf(copyOptionArr, copyOptionArr.length));
        kotlin.jvm.internal.g0.o(copy, "copy(...)");
        return CopyActionResult.CONTINUE;
    }

    private d() {
    }
}
