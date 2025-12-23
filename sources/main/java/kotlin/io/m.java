package kotlin.io;

import java.io.File;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
class m extends l {
    @NotNull
    public static final h O(@NotNull File file, @NotNull FileWalkDirection direction) {
        g0.p(file, "<this>");
        g0.p(direction, "direction");
        return new h(file, direction);
    }

    public static /* synthetic */ h P(File file, FileWalkDirection fileWalkDirection, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            fileWalkDirection = FileWalkDirection.TOP_DOWN;
        }
        return O(file, fileWalkDirection);
    }

    @NotNull
    public static final h Q(@NotNull File file) {
        g0.p(file, "<this>");
        return O(file, FileWalkDirection.BOTTOM_UP);
    }

    @NotNull
    public static final h R(@NotNull File file) {
        g0.p(file, "<this>");
        return O(file, FileWalkDirection.TOP_DOWN);
    }
}
