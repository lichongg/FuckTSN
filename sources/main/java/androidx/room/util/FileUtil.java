package androidx.room.util;

import android.annotation.SuppressLint;
import android.os.Build;
import androidx.annotation.RestrictTo;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
@JvmName(name = "FileUtil")
@SourceDebugExtension({"SMAP\nFileUtil.android.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FileUtil.android.kt\nandroidx/room/util/FileUtil\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,59:1\n1#2:60\n*E\n"})
/* loaded from: D:\Downloads\app\classes.dex */
public final class FileUtil {
    @SuppressLint({"LambdaLast"})
    public static final void copy(@NotNull ReadableByteChannel input, @NotNull FileChannel output) throws IOException {
        ReadableByteChannel readableByteChannel;
        FileChannel fileChannel;
        g0.p(input, "input");
        g0.p(output, "output");
        try {
            try {
                if (Build.VERSION.SDK_INT <= 23) {
                    readableByteChannel = input;
                    fileChannel = output;
                    InputStream newInputStream = Channels.newInputStream(readableByteChannel);
                    OutputStream newOutputStream = Channels.newOutputStream(fileChannel);
                    byte[] bArr = new byte[4096];
                    while (true) {
                        int read = newInputStream.read(bArr);
                        if (read <= 0) {
                            break;
                        } else {
                            newOutputStream.write(bArr, 0, read);
                        }
                    }
                } else {
                    readableByteChannel = input;
                    fileChannel = output;
                    fileChannel.transferFrom(readableByteChannel, 0L, Long.MAX_VALUE);
                }
                fileChannel.force(false);
                readableByteChannel.close();
                fileChannel.close();
            } catch (Throwable th) {
                th = th;
                Throwable th2 = th;
                readableByteChannel.close();
                fileChannel.close();
                throw th2;
            }
        } catch (Throwable th3) {
            th = th3;
            readableByteChannel = input;
            fileChannel = output;
        }
    }
}
