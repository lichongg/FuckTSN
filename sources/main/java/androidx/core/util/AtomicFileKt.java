package androidx.core.util;

import java.io.FileOutputStream;
import java.nio.charset.Charset;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.d0;
import kotlin.jvm.internal.g0;
import kotlin.n1;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nAtomicFile.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AtomicFile.kt\nandroidx/core/util/AtomicFileKt\n*L\n1#1,76:1\n30#1,13:77\n*S KotlinDebug\n*F\n+ 1 AtomicFile.kt\nandroidx/core/util/AtomicFileKt\n*L\n48#1:77,13\n*E\n"})
/* loaded from: D:\Downloads\app\classes.dex */
public final class AtomicFileKt {
    @NotNull
    public static final String readText(@NotNull android.util.AtomicFile atomicFile, @NotNull Charset charset) {
        return new String(atomicFile.readFully(), charset);
    }

    public static /* synthetic */ String readText$default(android.util.AtomicFile atomicFile, Charset charset, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            charset = kotlin.text.e.f47851b;
        }
        return readText(atomicFile, charset);
    }

    public static /* synthetic */ void writeText$default(android.util.AtomicFile atomicFile, String str, Charset charset, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            charset = kotlin.text.e.f47851b;
        }
        writeText(atomicFile, str, charset);
    }

    @NotNull
    public static final byte[] readBytes(@NotNull android.util.AtomicFile atomicFile) {
        return atomicFile.readFully();
    }

    public static final void tryWrite(@NotNull android.util.AtomicFile atomicFile, @NotNull Function1<? super FileOutputStream, n1> function1) {
        FileOutputStream startWrite = atomicFile.startWrite();
        try {
            function1.invoke(startWrite);
            d0.d(1);
            atomicFile.finishWrite(startWrite);
            d0.c(1);
        } catch (Throwable th) {
            d0.d(1);
            atomicFile.failWrite(startWrite);
            d0.c(1);
            throw th;
        }
    }

    public static final void writeBytes(@NotNull android.util.AtomicFile atomicFile, @NotNull byte[] bArr) {
        FileOutputStream startWrite = atomicFile.startWrite();
        try {
            startWrite.write(bArr);
            atomicFile.finishWrite(startWrite);
        } catch (Throwable th) {
            atomicFile.failWrite(startWrite);
            throw th;
        }
    }

    public static final void writeText(@NotNull android.util.AtomicFile atomicFile, @NotNull String str, @NotNull Charset charset) {
        byte[] bytes = str.getBytes(charset);
        g0.o(bytes, "this as java.lang.String).getBytes(charset)");
        writeBytes(atomicFile, bytes);
    }
}
