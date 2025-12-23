package okhttp3;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Pair;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.d0;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.v;
import kotlin.l;
import okhttp3.internal.Internal;
import okhttp3.internal._UtilCommonKt;
import okhttp3.internal._UtilJvmKt;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nResponseBody.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ResponseBody.kt\nokhttp3/ResponseBody\n+ 2 Okio.kt\nokio/Okio__OkioKt\n*L\n1#1,343:1\n141#1,6:344\n147#1,5:373\n141#1,6:378\n147#1,5:407\n72#2:350\n58#2,22:351\n72#2:384\n58#2,22:385\n72#2:412\n58#2,22:413\n72#2:435\n58#2,22:436\n*S KotlinDebug\n*F\n+ 1 ResponseBody.kt\nokhttp3/ResponseBody\n*L\n125#1:344,6\n125#1:373,5\n135#1:378,6\n135#1:407,5\n125#1:350\n125#1:351,22\n135#1:384\n135#1:385,22\n146#1:412\n146#1:413,22\n189#1:435\n189#1:436,22\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public abstract class ResponseBody implements Closeable {

    @NotNull
    public static final Companion Companion;

    @JvmField
    @NotNull
    public static final ResponseBody EMPTY;

    @Nullable
    private Reader reader;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\nResponseBody.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ResponseBody.kt\nokhttp3/ResponseBody$BomAwareReader\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,343:1\n1#2:344\n*E\n"})
    public static final class BomAwareReader extends Reader {

        @NotNull
        private final Charset charset;
        private boolean closed;

        @Nullable
        private Reader delegate;

        @NotNull
        private final BufferedSource source;

        @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.closed = true;
            Reader reader = this.delegate;
            if (reader != null) {
                reader.close();
            } else {
                this.source.close();
            }
        }

        public BomAwareReader(@NotNull BufferedSource source, @NotNull Charset charset) {
            g0.p(source, "source");
            g0.p(charset, "charset");
            this.source = source;
            this.charset = charset;
        }

        @Override // java.io.Reader
        public int read(@NotNull char[] cbuf, int i6, int i7) throws IOException {
            g0.p(cbuf, "cbuf");
            if (this.closed) {
                throw new IOException("Stream closed");
            }
            Reader reader = this.delegate;
            if (reader == null) {
                reader = new InputStreamReader(this.source.inputStream(), _UtilJvmKt.readBomAsCharset(this.source, this.charset));
                this.delegate = reader;
            }
            return reader.read(cbuf, i6, i7);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class Companion {
        public /* synthetic */ Companion(v vVar) {
            this();
        }

        public static /* synthetic */ ResponseBody create$default(Companion companion, String str, MediaType mediaType, int i6, Object obj) {
            if ((i6 & 1) != 0) {
                mediaType = null;
            }
            return companion.create(str, mediaType);
        }

        @JvmStatic
        @JvmName(name = "create")
        @NotNull
        public final ResponseBody create(@NotNull String str, @Nullable MediaType mediaType) {
            g0.p(str, "<this>");
            Pair<Charset, MediaType> chooseCharset = Internal.chooseCharset(mediaType);
            Charset component1 = chooseCharset.component1();
            MediaType component2 = chooseCharset.component2();
            Buffer writeString = new Buffer().writeString(str, component1);
            return create(writeString, component2, writeString.size());
        }

        private Companion() {
        }

        public static /* synthetic */ ResponseBody create$default(Companion companion, byte[] bArr, MediaType mediaType, int i6, Object obj) {
            if ((i6 & 1) != 0) {
                mediaType = null;
            }
            return companion.create(bArr, mediaType);
        }

        public static /* synthetic */ ResponseBody create$default(Companion companion, ByteString byteString, MediaType mediaType, int i6, Object obj) {
            if ((i6 & 1) != 0) {
                mediaType = null;
            }
            return companion.create(byteString, mediaType);
        }

        public static /* synthetic */ ResponseBody create$default(Companion companion, BufferedSource bufferedSource, MediaType mediaType, long j6, int i6, Object obj) {
            if ((i6 & 1) != 0) {
                mediaType = null;
            }
            if ((i6 & 2) != 0) {
                j6 = -1;
            }
            return companion.create(bufferedSource, mediaType, j6);
        }

        @JvmStatic
        @JvmName(name = "create")
        @NotNull
        public final ResponseBody create(@NotNull byte[] bArr, @Nullable MediaType mediaType) {
            g0.p(bArr, "<this>");
            return create(new Buffer().write(bArr), mediaType, bArr.length);
        }

        @JvmStatic
        @JvmName(name = "create")
        @NotNull
        public final ResponseBody create(@NotNull ByteString byteString, @Nullable MediaType mediaType) {
            g0.p(byteString, "<this>");
            return create(new Buffer().write(byteString), mediaType, byteString.size());
        }

        @JvmStatic
        @JvmName(name = "create")
        @NotNull
        public final ResponseBody create(@NotNull final BufferedSource bufferedSource, @Nullable final MediaType mediaType, final long j6) {
            g0.p(bufferedSource, "<this>");
            return new ResponseBody() { // from class: okhttp3.ResponseBody$Companion$asResponseBody$1
                @Override // okhttp3.ResponseBody
                public long contentLength() {
                    return j6;
                }

                @Override // okhttp3.ResponseBody
                public MediaType contentType() {
                    return MediaType.this;
                }

                @Override // okhttp3.ResponseBody
                public BufferedSource source() {
                    return bufferedSource;
                }
            };
        }

        @Deprecated(level = DeprecationLevel.WARNING, message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @ReplaceWith(expression = "content.toResponseBody(contentType)", imports = {"okhttp3.ResponseBody.Companion.toResponseBody"}))
        @JvmStatic
        @NotNull
        public final ResponseBody create(@Nullable MediaType mediaType, @NotNull String content) {
            g0.p(content, "content");
            return create(content, mediaType);
        }

        @Deprecated(level = DeprecationLevel.WARNING, message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @ReplaceWith(expression = "content.toResponseBody(contentType)", imports = {"okhttp3.ResponseBody.Companion.toResponseBody"}))
        @JvmStatic
        @NotNull
        public final ResponseBody create(@Nullable MediaType mediaType, @NotNull byte[] content) {
            g0.p(content, "content");
            return create(content, mediaType);
        }

        @Deprecated(level = DeprecationLevel.WARNING, message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @ReplaceWith(expression = "content.toResponseBody(contentType)", imports = {"okhttp3.ResponseBody.Companion.toResponseBody"}))
        @JvmStatic
        @NotNull
        public final ResponseBody create(@Nullable MediaType mediaType, @NotNull ByteString content) {
            g0.p(content, "content");
            return create(content, mediaType);
        }

        @Deprecated(level = DeprecationLevel.WARNING, message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @ReplaceWith(expression = "content.asResponseBody(contentType, contentLength)", imports = {"okhttp3.ResponseBody.Companion.asResponseBody"}))
        @JvmStatic
        @NotNull
        public final ResponseBody create(@Nullable MediaType mediaType, long j6, @NotNull BufferedSource content) {
            g0.p(content, "content");
            return create(content, mediaType, j6);
        }
    }

    @JvmStatic
    @JvmName(name = "create")
    @NotNull
    public static final ResponseBody create(@NotNull String str, @Nullable MediaType mediaType) {
        return Companion.create(str, mediaType);
    }

    public abstract long contentLength();

    @Nullable
    public abstract MediaType contentType();

    @NotNull
    public abstract BufferedSource source();

    static {
        Companion companion = new Companion(null);
        Companion = companion;
        EMPTY = Companion.create$default(companion, ByteString.EMPTY, (MediaType) null, 1, (Object) null);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @ReplaceWith(expression = "content.asResponseBody(contentType, contentLength)", imports = {"okhttp3.ResponseBody.Companion.asResponseBody"}))
    @JvmStatic
    @NotNull
    public static final ResponseBody create(@Nullable MediaType mediaType, long j6, @NotNull BufferedSource bufferedSource) {
        return Companion.create(mediaType, j6, bufferedSource);
    }

    @NotNull
    public final Reader charStream() {
        Reader reader = this.reader;
        if (reader != null) {
            return reader;
        }
        BomAwareReader bomAwareReader = new BomAwareReader(source(), charset());
        this.reader = bomAwareReader;
        return bomAwareReader;
    }

    private final Charset charset() {
        return Internal.charsetOrUtf8(contentType());
    }

    private final <T> T consumeSource(ResponseBody responseBody, Function1<? super BufferedSource, ? extends T> function1, Function1<? super T, Integer> function12) {
        Object obj;
        long contentLength = responseBody.contentLength();
        if (contentLength <= 2147483647L) {
            BufferedSource source = responseBody.source();
            Throwable th = (Object) null;
            try {
                T invoke = function1.invoke(source);
                d0.d(1);
                Throwable th2 = th;
                if (source != null) {
                    try {
                        source.close();
                        th2 = th;
                    } catch (Throwable 
                    /*  JADX ERROR: Method code generation error
                        java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.SSAVar.getCodeVar()" because "ssaVar" is null
                        */
                    /*
                        this = this;
                        long r0 = r7.contentLength()
                        r2 = 2147483647(0x7fffffff, double:1.060997895E-314)
                        int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
                        if (r4 > 0) goto L75
                        okio.BufferedSource r7 = r7.source()
                        r2 = 0
                        r3 = 1
                        java.lang.Object r8 = r8.invoke(r7)     // Catch: java.lang.Throwable -> L26
                        kotlin.jvm.internal.d0.d(r3)
                        if (r7 == 0) goto L1f
                        r7.close()     // Catch: java.lang.Throwable -> L1e
                        goto L1f
                    L1e:
                        r2 = move-exception
                    L1f:
                        kotlin.jvm.internal.d0.c(r3)
                        r5 = r2
                        r2 = r8
                        r8 = r5
                        goto L37
                    L26:
                        r8 = move-exception
                        kotlin.jvm.internal.d0.d(r3)
                        if (r7 == 0) goto L34
                        r7.close()     // Catch: java.lang.Throwable -> L30
                        goto L34
                    L30:
                        r7 = move-exception
                        kotlin.l.a(r8, r7)
                    L34:
                        kotlin.jvm.internal.d0.c(r3)
                    L37:
                        if (r8 != 0) goto L74
                        java.lang.Object r7 = r9.invoke(r2)
                        java.lang.Number r7 = (java.lang.Number) r7
                        int r7 = r7.intValue()
                        r8 = -1
                        int r3 = (r0 > r8 ? 1 : (r0 == r8 ? 0 : -1))
                        if (r3 == 0) goto L73
                        long r8 = (long) r7
                        int r3 = (r0 > r8 ? 1 : (r0 == r8 ? 0 : -1))
                        if (r3 != 0) goto L4f
                        goto L73
                    L4f:
                        java.io.IOException r8 = new java.io.IOException
                        java.lang.StringBuilder r9 = new java.lang.StringBuilder
                        r9.<init>()
                        java.lang.String r2 = "Content-Length ("
                        r9.append(r2)
                        r9.append(r0)
                        java.lang.String r0 = ") and stream length ("
                        r9.append(r0)
                        r9.append(r7)
                        java.lang.String r7 = ") disagree"
                        r9.append(r7)
                        java.lang.String r7 = r9.toString()
                        r8.<init>(r7)
                        throw r8
                    L73:
                        return r2
                    L74:
                        throw r8
                    L75:
                        java.io.IOException r7 = new java.io.IOException
                        java.lang.StringBuilder r8 = new java.lang.StringBuilder
                        r8.<init>()
                        java.lang.String r9 = "Cannot buffer entire body for content length: "
                        r8.append(r9)
                        r8.append(r0)
                        java.lang.String r8 = r8.toString()
                        r7.<init>(r8)
                        throw r7
                    */
                    throw new UnsupportedOperationException("Method not decompiled: okhttp3.ResponseBody.consumeSource(okhttp3.ResponseBody, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1):java.lang.Object");
                }

                @Deprecated(level = DeprecationLevel.WARNING, message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @ReplaceWith(expression = "content.toResponseBody(contentType)", imports = {"okhttp3.ResponseBody.Companion.toResponseBody"}))
                @JvmStatic
                @NotNull
                public static final ResponseBody create(@Nullable MediaType mediaType, @NotNull String str) {
                    return Companion.create(mediaType, str);
                }

                @NotNull
                public final InputStream byteStream() {
                    return source().inputStream();
                }

                /* JADX WARN: Multi-variable type inference failed */
                /* JADX WARN: Type inference failed for: r4v2, types: [java.lang.Throwable] */
                /* JADX WARN: Type inference failed for: r4v3, types: [java.lang.Throwable] */
                /* JADX WARN: Type inference failed for: r4v8 */
                @NotNull
                public final ByteString byteString() throws IOException {
                    long contentLength = contentLength();
                    if (contentLength <= 2147483647L) {
                        BufferedSource source = source();
                        ByteString th = null;
                        try {
                            ByteString readByteString = source.readByteString();
                            if (source != null) {
                                try {
                                    source.close();
                                } catch (Throwable th2) {
                                    th = th2;
                                }
                            }
                            th = th;
                            th = readByteString;
                        } catch (Throwable th3) {
                            th = th3;
                            if (source != null) {
                                try {
                                    source.close();
                                } catch (Throwable th4) {
                                    l.a(th, th4);
                                }
                            }
                        }
                        if (th == 0) {
                            int size = th.size();
                            if (contentLength != -1 && contentLength != size) {
                                throw new IOException("Content-Length (" + contentLength + ") and stream length (" + size + ") disagree");
                            }
                            return th;
                        }
                        throw th;
                    }
                    throw new IOException("Cannot buffer entire body for content length: " + contentLength);
                }

                /* JADX WARN: Multi-variable type inference failed */
                /* JADX WARN: Type inference failed for: r4v2, types: [java.lang.Throwable] */
                /* JADX WARN: Type inference failed for: r4v3, types: [java.lang.Throwable] */
                /* JADX WARN: Type inference failed for: r4v8 */
                @NotNull
                public final byte[] bytes() throws IOException {
                    long contentLength = contentLength();
                    if (contentLength <= 2147483647L) {
                        BufferedSource source = source();
                        byte[] th = null;
                        try {
                            byte[] readByteArray = source.readByteArray();
                            if (source != null) {
                                try {
                                    source.close();
                                } catch (Throwable th2) {
                                    th = th2;
                                }
                            }
                            th = th;
                            th = readByteArray;
                        } catch (Throwable th3) {
                            th = th3;
                            if (source != null) {
                                try {
                                    source.close();
                                } catch (Throwable th4) {
                                    l.a(th, th4);
                                }
                            }
                        }
                        if (th == 0) {
                            int length = th.length;
                            if (contentLength != -1 && contentLength != length) {
                                throw new IOException("Content-Length (" + contentLength + ") and stream length (" + length + ") disagree");
                            }
                            return th;
                        }
                        throw th;
                    }
                    throw new IOException("Cannot buffer entire body for content length: " + contentLength);
                }

                @Override // java.io.Closeable, java.lang.AutoCloseable
                public void close() {
                    _UtilCommonKt.closeQuietly(source());
                }

                /* JADX WARN: Multi-variable type inference failed */
                /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.Throwable] */
                /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.Throwable] */
                /* JADX WARN: Type inference failed for: r2v5 */
                @NotNull
                public final String string() throws IOException {
                    BufferedSource source = source();
                    String th = null;
                    try {
                        String readString = source.readString(_UtilJvmKt.readBomAsCharset(source, charset()));
                        if (source != null) {
                            try {
                                source.close();
                            } catch (Throwable th2) {
                                th = th2;
                            }
                        }
                        th = th;
                        th = readString;
                    } catch (Throwable th3) {
                        th = th3;
                        if (source != null) {
                            try {
                                source.close();
                            } catch (Throwable th4) {
                                l.a(th, th4);
                            }
                        }
                    }
                    if (th == 0) {
                        return th;
                    }
                    throw th;
                }

                @Deprecated(level = DeprecationLevel.WARNING, message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @ReplaceWith(expression = "content.toResponseBody(contentType)", imports = {"okhttp3.ResponseBody.Companion.toResponseBody"}))
                @JvmStatic
                @NotNull
                public static final ResponseBody create(@Nullable MediaType mediaType, @NotNull ByteString byteString) {
                    return Companion.create(mediaType, byteString);
                }

                @Deprecated(level = DeprecationLevel.WARNING, message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @ReplaceWith(expression = "content.toResponseBody(contentType)", imports = {"okhttp3.ResponseBody.Companion.toResponseBody"}))
                @JvmStatic
                @NotNull
                public static final ResponseBody create(@Nullable MediaType mediaType, @NotNull byte[] bArr) {
                    return Companion.create(mediaType, bArr);
                }

                @JvmStatic
                @JvmName(name = "create")
                @NotNull
                public static final ResponseBody create(@NotNull BufferedSource bufferedSource, @Nullable MediaType mediaType, long j6) {
                    return Companion.create(bufferedSource, mediaType, j6);
                }

                @JvmStatic
                @JvmName(name = "create")
                @NotNull
                public static final ResponseBody create(@NotNull ByteString byteString, @Nullable MediaType mediaType) {
                    return Companion.create(byteString, mediaType);
                }

                @JvmStatic
                @JvmName(name = "create")
                @NotNull
                public static final ResponseBody create(@NotNull byte[] bArr, @Nullable MediaType mediaType) {
                    return Companion.create(bArr, mediaType);
                }
            }
