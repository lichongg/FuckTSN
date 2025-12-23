package okio;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.OpenOption;
import java.util.Arrays;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Deprecated(message = "changed in Okio 2.x")
/* renamed from: okio.-DeprecatedOkio, reason: invalid class name */
/* loaded from: D:\Downloads\app\classes4.dex */
public final class DeprecatedOkio {

    @NotNull
    public static final DeprecatedOkio INSTANCE = new DeprecatedOkio();

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @ReplaceWith(expression = "sink.buffer()", imports = {"okio.buffer"}))
    @NotNull
    public final BufferedSink buffer(@NotNull Sink sink) {
        g0.p(sink, "sink");
        return Okio.buffer(sink);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @ReplaceWith(expression = "file.sink()", imports = {"okio.sink"}))
    @NotNull
    public final Sink sink(@NotNull File file) {
        g0.p(file, "file");
        return Okio__JvmOkioKt.sink$default(file, false, 1, null);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @ReplaceWith(expression = "file.source()", imports = {"okio.source"}))
    @NotNull
    public final Source source(@NotNull File file) {
        g0.p(file, "file");
        return Okio.source(file);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @ReplaceWith(expression = "file.appendingSink()", imports = {"okio.appendingSink"}))
    @NotNull
    public final Sink appendingSink(@NotNull File file) {
        g0.p(file, "file");
        return Okio.appendingSink(file);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @ReplaceWith(expression = "source.buffer()", imports = {"okio.buffer"}))
    @NotNull
    public final BufferedSource buffer(@NotNull Source source) {
        g0.p(source, "source");
        return Okio.buffer(source);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @ReplaceWith(expression = "outputStream.sink()", imports = {"okio.sink"}))
    @NotNull
    public final Sink sink(@NotNull OutputStream outputStream) {
        g0.p(outputStream, "outputStream");
        return Okio.sink(outputStream);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @ReplaceWith(expression = "inputStream.source()", imports = {"okio.source"}))
    @NotNull
    public final Source source(@NotNull InputStream inputStream) {
        g0.p(inputStream, "inputStream");
        return Okio.source(inputStream);
    }

    private DeprecatedOkio() {
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @ReplaceWith(expression = "blackholeSink()", imports = {"okio.blackholeSink"}))
    @NotNull
    public final Sink blackhole() {
        return Okio.blackhole();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @ReplaceWith(expression = "path.sink(*options)", imports = {"okio.sink"}))
    @NotNull
    public final Sink sink(@NotNull java.nio.file.Path path, @NotNull OpenOption... options) {
        g0.p(path, "path");
        g0.p(options, "options");
        return Okio.sink(path, (OpenOption[]) Arrays.copyOf(options, options.length));
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @ReplaceWith(expression = "path.source(*options)", imports = {"okio.source"}))
    @NotNull
    public final Source source(@NotNull java.nio.file.Path path, @NotNull OpenOption... options) {
        g0.p(path, "path");
        g0.p(options, "options");
        return Okio.source(path, (OpenOption[]) Arrays.copyOf(options, options.length));
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @ReplaceWith(expression = "socket.sink()", imports = {"okio.sink"}))
    @NotNull
    public final Sink sink(@NotNull java.net.Socket socket) {
        g0.p(socket, "socket");
        return Okio.sink(socket);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @ReplaceWith(expression = "socket.source()", imports = {"okio.source"}))
    @NotNull
    public final Source source(@NotNull java.net.Socket socket) {
        g0.p(socket, "socket");
        return Okio.source(socket);
    }
}
