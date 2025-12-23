package kotlin.io.path;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Arrays;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class j0 {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Object d(Path path, LinkOption[] linkOptionArr) {
        BasicFileAttributes readAttributes;
        Object fileKey;
        try {
            LinkOption[] linkOptionArr2 = (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length);
            readAttributes = Files.readAttributes(path, (Class<BasicFileAttributes>) cn.jiguang.i.g.a(), (LinkOption[]) Arrays.copyOf(linkOptionArr2, linkOptionArr2.length));
            kotlin.jvm.internal.g0.o(readAttributes, "readAttributes(...)");
            fileKey = readAttributes.fileKey();
            return fileKey;
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean c(x xVar) {
        boolean isSameFile;
        for (x c6 = xVar.c(); c6 != null; c6 = c6.c()) {
            if (c6.b() == null || xVar.b() == null) {
                try {
                    isSameFile = Files.isSameFile(c6.d(), xVar.d());
                    if (isSameFile) {
                        return true;
                    }
                } catch (IOException | SecurityException unused) {
                    continue;
                }
            } else if (kotlin.jvm.internal.g0.g(c6.b(), xVar.b())) {
                return true;
            }
        }
        return false;
    }
}
