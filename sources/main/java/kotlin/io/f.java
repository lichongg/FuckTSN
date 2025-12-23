package kotlin.io;

import java.io.ByteArrayOutputStream;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
final class f extends ByteArrayOutputStream {
    @NotNull
    public final byte[] a() {
        byte[] buf = ((ByteArrayOutputStream) this).buf;
        g0.o(buf, "buf");
        return buf;
    }

    public f(int i6) {
        super(i6);
    }
}
