package okio;

import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.OpenOption;
import java.security.MessageDigest;
import javax.crypto.Cipher;
import javax.crypto.Mac;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;

/* loaded from: D:\Downloads\app\classes4.dex */
public final class Okio {
    @NotNull
    public static final BufferedSink buffer(@NotNull Sink sink) {
        return Okio__OkioKt.buffer(sink);
    }

    @NotNull
    public static final HashingSink hashingSink(@NotNull Sink sink, @NotNull MessageDigest messageDigest) {
        return Okio__JvmOkioKt.hashingSink(sink, messageDigest);
    }

    @NotNull
    public static final HashingSource hashingSource(@NotNull Source source, @NotNull MessageDigest messageDigest) {
        return Okio__JvmOkioKt.hashingSource(source, messageDigest);
    }

    @JvmOverloads
    @NotNull
    public static final Sink sink(@NotNull File file) throws FileNotFoundException {
        return Okio__JvmOkioKt.sink(file);
    }

    @NotNull
    public static final Source source(@NotNull File file) throws FileNotFoundException {
        return Okio__JvmOkioKt.source(file);
    }

    @NotNull
    public static final BufferedSource buffer(@NotNull Source source) {
        return Okio__OkioKt.buffer(source);
    }

    @NotNull
    public static final HashingSink hashingSink(@NotNull Sink sink, @NotNull Mac mac) {
        return Okio__JvmOkioKt.hashingSink(sink, mac);
    }

    @NotNull
    public static final HashingSource hashingSource(@NotNull Source source, @NotNull Mac mac) {
        return Okio__JvmOkioKt.hashingSource(source, mac);
    }

    @JvmOverloads
    @NotNull
    public static final Sink sink(@NotNull File file, boolean z5) throws FileNotFoundException {
        return Okio__JvmOkioKt.sink(file, z5);
    }

    @NotNull
    public static final Source source(@NotNull InputStream inputStream) {
        return Okio__JvmOkioKt.source(inputStream);
    }

    @NotNull
    public static final Sink appendingSink(@NotNull File file) throws FileNotFoundException {
        return Okio__JvmOkioKt.appendingSink(file);
    }

    @NotNull
    public static final FileSystem asResourceFileSystem(@NotNull ClassLoader classLoader) {
        return Okio__JvmOkioKt.asResourceFileSystem(classLoader);
    }

    @JvmName(name = "blackhole")
    @NotNull
    public static final Sink blackhole() {
        return Okio__OkioKt.blackhole();
    }

    @NotNull
    public static final CipherSink cipherSink(@NotNull Sink sink, @NotNull Cipher cipher) {
        return Okio__JvmOkioKt.cipherSink(sink, cipher);
    }

    @NotNull
    public static final CipherSource cipherSource(@NotNull Source source, @NotNull Cipher cipher) {
        return Okio__JvmOkioKt.cipherSource(source, cipher);
    }

    @NotNull
    public static final Socket[] inMemorySocketPair(long j6) {
        return Okio__JvmOkioKt.inMemorySocketPair(j6);
    }

    @NotNull
    public static final FileSystem openZip(@NotNull FileSystem fileSystem, @NotNull Path path) throws IOException {
        return Okio__ZlibOkioKt.openZip(fileSystem, path);
    }

    @NotNull
    public static final Sink sink(@NotNull OutputStream outputStream) {
        return Okio__JvmOkioKt.sink(outputStream);
    }

    @JvmName(name = "socket")
    @NotNull
    public static final Socket socket(@NotNull java.net.Socket socket) {
        return Okio__JvmOkioKt.socket(socket);
    }

    @NotNull
    public static final Source source(@NotNull java.net.Socket socket) throws IOException {
        return Okio__JvmOkioKt.source(socket);
    }

    public static final <T extends Closeable, R> R use(T t5, @NotNull Function1<? super T, ? extends R> function1) {
        return (R) Okio__OkioKt.use(t5, function1);
    }

    @NotNull
    public static final Sink sink(@NotNull java.net.Socket socket) throws IOException {
        return Okio__JvmOkioKt.sink(socket);
    }

    @NotNull
    public static final Source source(@NotNull java.nio.file.Path path, @NotNull OpenOption... openOptionArr) throws IOException {
        return Okio__JvmOkioKt.source(path, openOptionArr);
    }

    @NotNull
    public static final Sink sink(@NotNull java.nio.file.Path path, @NotNull OpenOption... openOptionArr) throws IOException {
        return Okio__JvmOkioKt.sink(path, openOptionArr);
    }
}
