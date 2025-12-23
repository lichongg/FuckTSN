package okio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.security.MessageDigest;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.Mac;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.g0;
import okio.internal.DefaultSocket;
import okio.internal.PipeSocket;
import okio.internal.ResourceFileSystem;
import okio.internal.SocketAsyncTimeout;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
final /* synthetic */ class Okio__JvmOkioKt {
    @NotNull
    public static final HashingSink hashingSink(@NotNull Sink sink, @NotNull Mac mac) {
        g0.p(sink, "<this>");
        g0.p(mac, "mac");
        return new HashingSink(sink, mac);
    }

    @NotNull
    public static final HashingSource hashingSource(@NotNull Source source, @NotNull Mac mac) {
        g0.p(source, "<this>");
        g0.p(mac, "mac");
        return new HashingSource(source, mac);
    }

    @JvmOverloads
    @NotNull
    public static final Sink sink(@NotNull File file) throws FileNotFoundException {
        g0.p(file, "<this>");
        return sink$default(file, false, 1, null);
    }

    @NotNull
    public static final Source source(@NotNull InputStream inputStream) {
        g0.p(inputStream, "<this>");
        return new InputStreamSource(inputStream, new Timeout());
    }

    @NotNull
    public static final Sink appendingSink(@NotNull File file) throws FileNotFoundException {
        g0.p(file, "<this>");
        return Okio.sink(new FileOutputStream(file, true));
    }

    @NotNull
    public static final FileSystem asResourceFileSystem(@NotNull ClassLoader classLoader) {
        g0.p(classLoader, "<this>");
        return new ResourceFileSystem(classLoader, true, null, 4, null);
    }

    @NotNull
    public static final CipherSink cipherSink(@NotNull Sink sink, @NotNull Cipher cipher) {
        g0.p(sink, "<this>");
        g0.p(cipher, "cipher");
        return new CipherSink(Okio.buffer(sink), cipher);
    }

    @NotNull
    public static final CipherSource cipherSource(@NotNull Source source, @NotNull Cipher cipher) {
        g0.p(source, "<this>");
        g0.p(cipher, "cipher");
        return new CipherSource(Okio.buffer(source), cipher);
    }

    @NotNull
    public static final HashingSink hashingSink(@NotNull Sink sink, @NotNull MessageDigest digest) {
        g0.p(sink, "<this>");
        g0.p(digest, "digest");
        return new HashingSink(sink, digest);
    }

    @NotNull
    public static final HashingSource hashingSource(@NotNull Source source, @NotNull MessageDigest digest) {
        g0.p(source, "<this>");
        g0.p(digest, "digest");
        return new HashingSource(source, digest);
    }

    @NotNull
    public static final Socket[] inMemorySocketPair(long j6) {
        Pipe pipe = new Pipe(j6);
        Pipe pipe2 = new Pipe(j6);
        return new Socket[]{new PipeSocket(pipe, pipe2), new PipeSocket(pipe2, pipe)};
    }

    @NotNull
    public static final Sink sink(@NotNull OutputStream outputStream) {
        g0.p(outputStream, "<this>");
        return new OutputStreamSink(outputStream, new Timeout());
    }

    public static /* synthetic */ Sink sink$default(File file, boolean z5, int i6, Object obj) throws FileNotFoundException {
        if ((i6 & 1) != 0) {
            z5 = false;
        }
        return Okio.sink(file, z5);
    }

    @JvmName(name = "socket")
    @NotNull
    public static final Socket socket(@NotNull java.net.Socket socket) {
        g0.p(socket, "<this>");
        return new DefaultSocket(socket);
    }

    @NotNull
    public static final Source source(@NotNull java.net.Socket socket) throws IOException {
        g0.p(socket, "<this>");
        SocketAsyncTimeout socketAsyncTimeout = new SocketAsyncTimeout(socket);
        InputStream inputStream = socket.getInputStream();
        g0.o(inputStream, "getInputStream(...)");
        return socketAsyncTimeout.source(new InputStreamSource(inputStream, socketAsyncTimeout));
    }

    @NotNull
    public static final Sink sink(@NotNull java.net.Socket socket) throws IOException {
        g0.p(socket, "<this>");
        SocketAsyncTimeout socketAsyncTimeout = new SocketAsyncTimeout(socket);
        OutputStream outputStream = socket.getOutputStream();
        g0.o(outputStream, "getOutputStream(...)");
        return socketAsyncTimeout.sink(new OutputStreamSink(outputStream, socketAsyncTimeout));
    }

    @NotNull
    public static final Source source(@NotNull File file) throws FileNotFoundException {
        g0.p(file, "<this>");
        return new InputStreamSource(new FileInputStream(file), Timeout.NONE);
    }

    @JvmOverloads
    @NotNull
    public static final Sink sink(@NotNull File file, boolean z5) throws FileNotFoundException {
        g0.p(file, "<this>");
        return Okio.sink(new FileOutputStream(file, z5));
    }

    @NotNull
    public static final Source source(@NotNull java.nio.file.Path path, @NotNull OpenOption... options) throws IOException {
        InputStream newInputStream;
        g0.p(path, "<this>");
        g0.p(options, "options");
        newInputStream = Files.newInputStream(path, (OpenOption[]) Arrays.copyOf(options, options.length));
        g0.o(newInputStream, "newInputStream(...)");
        return Okio.source(newInputStream);
    }

    @NotNull
    public static final Sink sink(@NotNull java.nio.file.Path path, @NotNull OpenOption... options) throws IOException {
        OutputStream newOutputStream;
        g0.p(path, "<this>");
        g0.p(options, "options");
        newOutputStream = Files.newOutputStream(path, (OpenOption[]) Arrays.copyOf(options, options.length));
        g0.o(newOutputStream, "newOutputStream(...)");
        return Okio.sink(newOutputStream);
    }
}
