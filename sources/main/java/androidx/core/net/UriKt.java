package androidx.core.net;

import android.net.Uri;
import java.io.File;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import master.flame.danmaku.danmaku.parser.b;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nUri.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Uri.kt\nandroidx/core/net/UriKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,46:1\n1#2:47\n*E\n"})
/* loaded from: D:\Downloads\app\classes.dex */
public final class UriKt {
    @NotNull
    public static final Uri toUri(@NotNull String str) {
        return Uri.parse(str);
    }

    @NotNull
    public static final Uri toUri(@NotNull File file) {
        return Uri.fromFile(file);
    }

    @NotNull
    public static final File toFile(@NotNull Uri uri) {
        if (g0.g(uri.getScheme(), b.f50156c)) {
            String path = uri.getPath();
            if (path != null) {
                return new File(path);
            }
            throw new IllegalArgumentException(("Uri path is null: " + uri).toString());
        }
        throw new IllegalArgumentException(("Uri lacks 'file' scheme: " + uri).toString());
    }
}
