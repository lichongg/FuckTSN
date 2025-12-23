package okhttp3;

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Pair;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.v;
import kotlin.n1;
import okhttp3.internal.Internal;
import okhttp3.internal._UtilCommonKt;
import okio.BufferedSink;
import okio.ByteString;
import okio.FileSystem;
import okio.HashingSink;
import okio.Okio;
import okio.Path;
import okio.Source;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public abstract class RequestBody {

    @NotNull
    public static final Companion Companion;

    @JvmField
    @NotNull
    public static final RequestBody EMPTY;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class Companion {
        public /* synthetic */ Companion(v vVar) {
            this();
        }

        public static /* synthetic */ RequestBody create$default(Companion companion, String str, MediaType mediaType, int i6, Object obj) {
            if ((i6 & 1) != 0) {
                mediaType = null;
            }
            return companion.create(str, mediaType);
        }

        @JvmStatic
        @NotNull
        @Deprecated(level = DeprecationLevel.WARNING, message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @ReplaceWith(expression = "content.toRequestBody(contentType, offset, byteCount)", imports = {"okhttp3.RequestBody.Companion.toRequestBody"}))
        @JvmOverloads
        public final RequestBody create(@Nullable MediaType mediaType, @NotNull byte[] content) {
            g0.p(content, "content");
            return create$default(this, mediaType, content, 0, 0, 12, (Object) null);
        }

        private Companion() {
        }

        public static /* synthetic */ RequestBody create$default(Companion companion, ByteString byteString, MediaType mediaType, int i6, Object obj) {
            if ((i6 & 1) != 0) {
                mediaType = null;
            }
            return companion.create(byteString, mediaType);
        }

        @JvmStatic
        @NotNull
        @Deprecated(level = DeprecationLevel.WARNING, message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @ReplaceWith(expression = "content.toRequestBody(contentType, offset, byteCount)", imports = {"okhttp3.RequestBody.Companion.toRequestBody"}))
        @JvmOverloads
        public final RequestBody create(@Nullable MediaType mediaType, @NotNull byte[] content, int i6) {
            g0.p(content, "content");
            return create$default(this, mediaType, content, i6, 0, 8, (Object) null);
        }

        public static /* synthetic */ RequestBody create$default(Companion companion, FileDescriptor fileDescriptor, MediaType mediaType, int i6, Object obj) {
            if ((i6 & 1) != 0) {
                mediaType = null;
            }
            return companion.create(fileDescriptor, mediaType);
        }

        @JvmStatic
        @JvmName(name = "create")
        @NotNull
        @JvmOverloads
        public final RequestBody create(@NotNull byte[] bArr) {
            g0.p(bArr, "<this>");
            return create$default(this, bArr, (MediaType) null, 0, 0, 7, (Object) null);
        }

        public static /* synthetic */ RequestBody create$default(Companion companion, byte[] bArr, MediaType mediaType, int i6, int i7, int i8, Object obj) {
            if ((i8 & 1) != 0) {
                mediaType = null;
            }
            if ((i8 & 2) != 0) {
                i6 = 0;
            }
            if ((i8 & 4) != 0) {
                i7 = bArr.length;
            }
            return companion.create(bArr, mediaType, i6, i7);
        }

        @JvmStatic
        @JvmName(name = "create")
        @NotNull
        @JvmOverloads
        public final RequestBody create(@NotNull byte[] bArr, @Nullable MediaType mediaType) {
            g0.p(bArr, "<this>");
            return create$default(this, bArr, mediaType, 0, 0, 6, (Object) null);
        }

        @JvmStatic
        @JvmName(name = "create")
        @NotNull
        @JvmOverloads
        public final RequestBody create(@NotNull byte[] bArr, @Nullable MediaType mediaType, int i6) {
            g0.p(bArr, "<this>");
            return create$default(this, bArr, mediaType, i6, 0, 4, (Object) null);
        }

        public static /* synthetic */ RequestBody create$default(Companion companion, File file, MediaType mediaType, int i6, Object obj) {
            if ((i6 & 1) != 0) {
                mediaType = null;
            }
            return companion.create(file, mediaType);
        }

        @JvmStatic
        @JvmName(name = "create")
        @NotNull
        public final RequestBody create(@NotNull String str, @Nullable MediaType mediaType) {
            g0.p(str, "<this>");
            Pair<Charset, MediaType> chooseCharset = Internal.chooseCharset(mediaType);
            Charset component1 = chooseCharset.component1();
            MediaType component2 = chooseCharset.component2();
            byte[] bytes = str.getBytes(component1);
            g0.o(bytes, "getBytes(...)");
            return create(bytes, component2, 0, bytes.length);
        }

        public static /* synthetic */ RequestBody create$default(Companion companion, Path path, FileSystem fileSystem, MediaType mediaType, int i6, Object obj) {
            if ((i6 & 2) != 0) {
                mediaType = null;
            }
            return companion.create(path, fileSystem, mediaType);
        }

        public static /* synthetic */ RequestBody create$default(Companion companion, MediaType mediaType, byte[] bArr, int i6, int i7, int i8, Object obj) {
            if ((i8 & 4) != 0) {
                i6 = 0;
            }
            if ((i8 & 8) != 0) {
                i7 = bArr.length;
            }
            return companion.create(mediaType, bArr, i6, i7);
        }

        @JvmStatic
        @JvmName(name = "create")
        @NotNull
        public final RequestBody create(@NotNull final ByteString byteString, @Nullable final MediaType mediaType) {
            g0.p(byteString, "<this>");
            return new RequestBody() { // from class: okhttp3.RequestBody$Companion$toRequestBody$1
                @Override // okhttp3.RequestBody
                public long contentLength() {
                    return byteString.size();
                }

                @Override // okhttp3.RequestBody
                public MediaType contentType() {
                    return MediaType.this;
                }

                @Override // okhttp3.RequestBody
                public void writeTo(BufferedSink sink) {
                    g0.p(sink, "sink");
                    sink.write(byteString);
                }
            };
        }

        @JvmStatic
        @JvmName(name = "create")
        @NotNull
        public final RequestBody create(@NotNull final FileDescriptor fileDescriptor, @Nullable final MediaType mediaType) {
            g0.p(fileDescriptor, "<this>");
            return new RequestBody() { // from class: okhttp3.RequestBody$Companion$toRequestBody$2
                @Override // okhttp3.RequestBody
                public boolean isOneShot() {
                    return true;
                }

                @Override // okhttp3.RequestBody
                public MediaType contentType() {
                    return MediaType.this;
                }

                @Override // okhttp3.RequestBody
                public void writeTo(BufferedSink sink) {
                    g0.p(sink, "sink");
                    FileInputStream fileInputStream = new FileInputStream(fileDescriptor);
                    try {
                        sink.getBuffer().writeAll(Okio.source(fileInputStream));
                        kotlin.io.b.a(fileInputStream, null);
                    } finally {
                    }
                }
            };
        }

        @JvmStatic
        @JvmName(name = "create")
        @NotNull
        @JvmOverloads
        public final RequestBody create(@NotNull final byte[] bArr, @Nullable final MediaType mediaType, final int i6, final int i7) {
            g0.p(bArr, "<this>");
            _UtilCommonKt.checkOffsetAndCount(bArr.length, i6, i7);
            return new RequestBody() { // from class: okhttp3.RequestBody$Companion$toRequestBody$3
                @Override // okhttp3.RequestBody
                public long contentLength() {
                    return i7;
                }

                @Override // okhttp3.RequestBody
                public MediaType contentType() {
                    return MediaType.this;
                }

                @Override // okhttp3.RequestBody
                public void writeTo(BufferedSink sink) {
                    g0.p(sink, "sink");
                    sink.write(bArr, i6, i7);
                }
            };
        }

        @JvmStatic
        @JvmName(name = "create")
        @NotNull
        public final RequestBody create(@NotNull final File file, @Nullable final MediaType mediaType) {
            g0.p(file, "<this>");
            return new RequestBody() { // from class: okhttp3.RequestBody$Companion$asRequestBody$1
                @Override // okhttp3.RequestBody
                public long contentLength() {
                    return file.length();
                }

                @Override // okhttp3.RequestBody
                public MediaType contentType() {
                    return MediaType.this;
                }

                @Override // okhttp3.RequestBody
                public void writeTo(BufferedSink sink) {
                    g0.p(sink, "sink");
                    Source source = Okio.source(file);
                    try {
                        sink.writeAll(source);
                        kotlin.io.b.a(source, null);
                    } finally {
                    }
                }
            };
        }

        @JvmStatic
        @JvmName(name = "create")
        @NotNull
        public final RequestBody create(@NotNull final Path path, @NotNull final FileSystem fileSystem, @Nullable final MediaType mediaType) {
            g0.p(path, "<this>");
            g0.p(fileSystem, "fileSystem");
            return new RequestBody() { // from class: okhttp3.RequestBody$Companion$asRequestBody$2
                @Override // okhttp3.RequestBody
                public long contentLength() {
                    Long size = fileSystem.metadata(path).getSize();
                    if (size != null) {
                        return size.longValue();
                    }
                    return -1L;
                }

                @Override // okhttp3.RequestBody
                public MediaType contentType() {
                    return MediaType.this;
                }

                @Override // okhttp3.RequestBody
                public void writeTo(BufferedSink sink) {
                    g0.p(sink, "sink");
                    Source source = fileSystem.source(path);
                    try {
                        sink.writeAll(source);
                        kotlin.io.b.a(source, null);
                    } finally {
                    }
                }
            };
        }

        @Deprecated(level = DeprecationLevel.WARNING, message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @ReplaceWith(expression = "content.toRequestBody(contentType)", imports = {"okhttp3.RequestBody.Companion.toRequestBody"}))
        @JvmStatic
        @NotNull
        public final RequestBody create(@Nullable MediaType mediaType, @NotNull String content) {
            g0.p(content, "content");
            return create(content, mediaType);
        }

        @Deprecated(level = DeprecationLevel.WARNING, message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @ReplaceWith(expression = "content.toRequestBody(contentType)", imports = {"okhttp3.RequestBody.Companion.toRequestBody"}))
        @JvmStatic
        @NotNull
        public final RequestBody create(@Nullable MediaType mediaType, @NotNull ByteString content) {
            g0.p(content, "content");
            return create(content, mediaType);
        }

        @JvmStatic
        @NotNull
        @Deprecated(level = DeprecationLevel.WARNING, message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @ReplaceWith(expression = "content.toRequestBody(contentType, offset, byteCount)", imports = {"okhttp3.RequestBody.Companion.toRequestBody"}))
        @JvmOverloads
        public final RequestBody create(@Nullable MediaType mediaType, @NotNull byte[] content, int i6, int i7) {
            g0.p(content, "content");
            return create(content, mediaType, i6, i7);
        }

        @Deprecated(level = DeprecationLevel.WARNING, message = "Moved to extension function. Put the 'file' argument first to fix Java", replaceWith = @ReplaceWith(expression = "file.asRequestBody(contentType)", imports = {"okhttp3.RequestBody.Companion.asRequestBody"}))
        @JvmStatic
        @NotNull
        public final RequestBody create(@Nullable MediaType mediaType, @NotNull File file) {
            g0.p(file, "file");
            return create(file, mediaType);
        }
    }

    @JvmStatic
    @JvmName(name = "create")
    @NotNull
    public static final RequestBody create(@NotNull File file, @Nullable MediaType mediaType) {
        return Companion.create(file, mediaType);
    }

    @Nullable
    public abstract MediaType contentType();

    public boolean isDuplex() {
        return false;
    }

    public boolean isOneShot() {
        return false;
    }

    public abstract void writeTo(@NotNull BufferedSink bufferedSink) throws IOException;

    static {
        Companion companion = new Companion(null);
        Companion = companion;
        EMPTY = Companion.create$default(companion, ByteString.EMPTY, (MediaType) null, 1, (Object) null);
    }

    @JvmStatic
    @JvmName(name = "create")
    @NotNull
    public static final RequestBody create(@NotNull FileDescriptor fileDescriptor, @Nullable MediaType mediaType) {
        return Companion.create(fileDescriptor, mediaType);
    }

    public long contentLength() throws IOException {
        return -1L;
    }

    @NotNull
    public final ByteString sha256() throws IOException {
        HashingSink sha256 = HashingSink.Companion.sha256(Okio.blackhole());
        BufferedSink buffer = Okio.buffer(sha256);
        try {
            writeTo(buffer);
            n1 n1Var = n1.f44123a;
            kotlin.io.b.a(buffer, null);
            return sha256.hash();
        } finally {
        }
    }

    @JvmStatic
    @JvmName(name = "create")
    @NotNull
    public static final RequestBody create(@NotNull String str, @Nullable MediaType mediaType) {
        return Companion.create(str, mediaType);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Moved to extension function. Put the 'file' argument first to fix Java", replaceWith = @ReplaceWith(expression = "file.asRequestBody(contentType)", imports = {"okhttp3.RequestBody.Companion.asRequestBody"}))
    @JvmStatic
    @NotNull
    public static final RequestBody create(@Nullable MediaType mediaType, @NotNull File file) {
        return Companion.create(mediaType, file);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @ReplaceWith(expression = "content.toRequestBody(contentType)", imports = {"okhttp3.RequestBody.Companion.toRequestBody"}))
    @JvmStatic
    @NotNull
    public static final RequestBody create(@Nullable MediaType mediaType, @NotNull String str) {
        return Companion.create(mediaType, str);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @ReplaceWith(expression = "content.toRequestBody(contentType)", imports = {"okhttp3.RequestBody.Companion.toRequestBody"}))
    @JvmStatic
    @NotNull
    public static final RequestBody create(@Nullable MediaType mediaType, @NotNull ByteString byteString) {
        return Companion.create(mediaType, byteString);
    }

    @JvmStatic
    @NotNull
    @Deprecated(level = DeprecationLevel.WARNING, message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @ReplaceWith(expression = "content.toRequestBody(contentType, offset, byteCount)", imports = {"okhttp3.RequestBody.Companion.toRequestBody"}))
    @JvmOverloads
    public static final RequestBody create(@Nullable MediaType mediaType, @NotNull byte[] bArr) {
        return Companion.create(mediaType, bArr);
    }

    @JvmStatic
    @NotNull
    @Deprecated(level = DeprecationLevel.WARNING, message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @ReplaceWith(expression = "content.toRequestBody(contentType, offset, byteCount)", imports = {"okhttp3.RequestBody.Companion.toRequestBody"}))
    @JvmOverloads
    public static final RequestBody create(@Nullable MediaType mediaType, @NotNull byte[] bArr, int i6) {
        return Companion.create(mediaType, bArr, i6);
    }

    @JvmStatic
    @NotNull
    @Deprecated(level = DeprecationLevel.WARNING, message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @ReplaceWith(expression = "content.toRequestBody(contentType, offset, byteCount)", imports = {"okhttp3.RequestBody.Companion.toRequestBody"}))
    @JvmOverloads
    public static final RequestBody create(@Nullable MediaType mediaType, @NotNull byte[] bArr, int i6, int i7) {
        return Companion.create(mediaType, bArr, i6, i7);
    }

    @JvmStatic
    @JvmName(name = "create")
    @NotNull
    public static final RequestBody create(@NotNull ByteString byteString, @Nullable MediaType mediaType) {
        return Companion.create(byteString, mediaType);
    }

    @JvmStatic
    @JvmName(name = "create")
    @NotNull
    public static final RequestBody create(@NotNull Path path, @NotNull FileSystem fileSystem, @Nullable MediaType mediaType) {
        return Companion.create(path, fileSystem, mediaType);
    }

    @JvmStatic
    @JvmName(name = "create")
    @NotNull
    @JvmOverloads
    public static final RequestBody create(@NotNull byte[] bArr) {
        return Companion.create(bArr);
    }

    @JvmStatic
    @JvmName(name = "create")
    @NotNull
    @JvmOverloads
    public static final RequestBody create(@NotNull byte[] bArr, @Nullable MediaType mediaType) {
        return Companion.create(bArr, mediaType);
    }

    @JvmStatic
    @JvmName(name = "create")
    @NotNull
    @JvmOverloads
    public static final RequestBody create(@NotNull byte[] bArr, @Nullable MediaType mediaType, int i6) {
        return Companion.create(bArr, mediaType, i6);
    }

    @JvmStatic
    @JvmName(name = "create")
    @NotNull
    @JvmOverloads
    public static final RequestBody create(@NotNull byte[] bArr, @Nullable MediaType mediaType, int i6, int i7) {
        return Companion.create(bArr, mediaType, i6, i7);
    }
}
