package okhttp3.internal.cache2;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.v;
import kotlin.n1;
import okhttp3.internal._UtilCommonKt;
import okhttp3.internal.concurrent.Lockable;
import okio.Buffer;
import okio.ByteString;
import okio.Source;
import okio.Timeout;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class Relay implements Lockable {

    @NotNull
    public static final Companion Companion = new Companion(null);
    private static final long FILE_HEADER_SIZE = 32;

    @JvmField
    @NotNull
    public static final ByteString PREFIX_CLEAN;

    @JvmField
    @NotNull
    public static final ByteString PREFIX_DIRTY;
    private static final int SOURCE_FILE = 2;
    private static final int SOURCE_UPSTREAM = 1;

    @NotNull
    private final Buffer buffer;
    private final long bufferMaxSize;
    private boolean complete;

    @Nullable
    private RandomAccessFile file;

    @NotNull
    private final ByteString metadata;
    private int sourceCount;

    @Nullable
    private Source upstream;

    @NotNull
    private final Buffer upstreamBuffer;
    private long upstreamPos;

    @Nullable
    private Thread upstreamReader;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class Companion {
        public /* synthetic */ Companion(v vVar) {
            this();
        }

        private Companion() {
        }

        @NotNull
        public final Relay edit(@NotNull File file, @NotNull Source upstream, @NotNull ByteString metadata, long j6) throws IOException {
            g0.p(file, "file");
            g0.p(upstream, "upstream");
            g0.p(metadata, "metadata");
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            Relay relay = new Relay(randomAccessFile, upstream, 0L, metadata, j6, null);
            randomAccessFile.setLength(0L);
            relay.writeHeader(Relay.PREFIX_DIRTY, -1L, -1L);
            return relay;
        }

        @NotNull
        public final Relay read(@NotNull File file) throws IOException {
            g0.p(file, "file");
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            FileChannel channel = randomAccessFile.getChannel();
            g0.o(channel, "getChannel(...)");
            FileOperator fileOperator = new FileOperator(channel);
            Buffer buffer = new Buffer();
            fileOperator.read(0L, buffer, 32L);
            if (!g0.g(buffer.readByteString(r11.size()), Relay.PREFIX_CLEAN)) {
                throw new IOException("unreadable cache file");
            }
            long readLong = buffer.readLong();
            long readLong2 = buffer.readLong();
            Buffer buffer2 = new Buffer();
            fileOperator.read(32 + readLong, buffer2, readLong2);
            return new Relay(randomAccessFile, null, readLong, buffer2.readByteString(), 0L, null);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\nRelay.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Relay.kt\nokhttp3/internal/cache2/Relay$RelaySource\n+ 2 Lockable.kt\nokhttp3/internal/concurrent/LockableKt\n*L\n1#1,362:1\n38#2:363\n*S KotlinDebug\n*F\n+ 1 Relay.kt\nokhttp3/internal/cache2/Relay$RelaySource\n*L\n272#1:363\n*E\n"})
    public final class RelaySource implements Source {

        @Nullable
        private FileOperator fileOperator;
        private long sourcePos;

        @NotNull
        private final Timeout timeout = new Timeout();

        public RelaySource() {
            RandomAccessFile file = Relay.this.getFile();
            g0.m(file);
            FileChannel channel = file.getChannel();
            g0.o(channel, "getChannel(...)");
            this.fileOperator = new FileOperator(channel);
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.fileOperator == null) {
                return;
            }
            RandomAccessFile randomAccessFile = null;
            this.fileOperator = null;
            Relay relay = Relay.this;
            synchronized (relay) {
                try {
                    relay.setSourceCount(relay.getSourceCount() - 1);
                    if (relay.getSourceCount() == 0) {
                        RandomAccessFile file = relay.getFile();
                        relay.setFile(null);
                        randomAccessFile = file;
                    }
                    n1 n1Var = n1.f44123a;
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (randomAccessFile != null) {
                _UtilCommonKt.closeQuietly(randomAccessFile);
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:17:0x0056, code lost:
        
            if (r4 != 2) goto L27;
         */
        /* JADX WARN: Code restructure failed: missing block: B:18:0x0058, code lost:
        
            r6 = java.lang.Math.min(r23, r21.this$0.getUpstreamPos() - r21.sourcePos);
            r2 = r21.fileOperator;
            kotlin.jvm.internal.g0.m(r2);
            r2.read(r21.sourcePos + 32, r22, r6);
            r21.sourcePos += r6;
         */
        /* JADX WARN: Code restructure failed: missing block: B:19:0x0075, code lost:
        
            return r6;
         */
        /* JADX WARN: Code restructure failed: missing block: B:23:0x0077, code lost:
        
            r0 = r21.this$0.getUpstream();
            kotlin.jvm.internal.g0.m(r0);
            r13 = r0.read(r21.this$0.getUpstreamBuffer(), r21.this$0.getBufferMaxSize());
         */
        /* JADX WARN: Code restructure failed: missing block: B:24:0x0092, code lost:
        
            if (r13 != (-1)) goto L41;
         */
        /* JADX WARN: Code restructure failed: missing block: B:25:0x0094, code lost:
        
            r0 = r21.this$0;
            r0.commit(r0.getUpstreamPos());
         */
        /* JADX WARN: Code restructure failed: missing block: B:26:0x009d, code lost:
        
            r2 = r21.this$0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:27:0x009f, code lost:
        
            monitor-enter(r2);
         */
        /* JADX WARN: Code restructure failed: missing block: B:29:0x00a0, code lost:
        
            r2.setUpstreamReader(null);
            kotlin.jvm.internal.g0.n(r2, "null cannot be cast to non-null type java.lang.Object");
            r2.notifyAll();
            r0 = kotlin.n1.f44123a;
         */
        /* JADX WARN: Code restructure failed: missing block: B:30:0x00ad, code lost:
        
            monitor-exit(r2);
         */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x00ae, code lost:
        
            return -1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:35:0x00b5, code lost:
        
            r6 = java.lang.Math.min(r13, r23);
            r21.this$0.getUpstreamBuffer().copyTo(r22, 0, r6);
            r21.sourcePos += r6;
            r13 = r21.fileOperator;
            kotlin.jvm.internal.g0.m(r13);
            r13.write(r21.this$0.getUpstreamPos() + 32, r21.this$0.getUpstreamBuffer().clone(), r13);
            r4 = r21.this$0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:36:0x00eb, code lost:
        
            monitor-enter(r4);
         */
        /* JADX WARN: Code restructure failed: missing block: B:38:0x00ec, code lost:
        
            r4.getBuffer().write(r4.getUpstreamBuffer(), r13);
         */
        /* JADX WARN: Code restructure failed: missing block: B:39:0x0105, code lost:
        
            if (r4.getBuffer().size() <= r4.getBufferMaxSize()) goto L48;
         */
        /* JADX WARN: Code restructure failed: missing block: B:40:0x0107, code lost:
        
            r4.getBuffer().skip(r4.getBuffer().size() - r4.getBufferMaxSize());
         */
        /* JADX WARN: Code restructure failed: missing block: B:41:0x011e, code lost:
        
            r4.setUpstreamPos(r4.getUpstreamPos() + r13);
            r0 = kotlin.n1.f44123a;
         */
        /* JADX WARN: Code restructure failed: missing block: B:42:0x0128, code lost:
        
            monitor-exit(r4);
         */
        /* JADX WARN: Code restructure failed: missing block: B:43:0x0129, code lost:
        
            r2 = r21.this$0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:44:0x012b, code lost:
        
            monitor-enter(r2);
         */
        /* JADX WARN: Code restructure failed: missing block: B:46:0x012c, code lost:
        
            r2.setUpstreamReader(null);
            kotlin.jvm.internal.g0.n(r2, "null cannot be cast to non-null type java.lang.Object");
            r2.notifyAll();
         */
        /* JADX WARN: Code restructure failed: missing block: B:47:0x0137, code lost:
        
            monitor-exit(r2);
         */
        /* JADX WARN: Code restructure failed: missing block: B:48:0x0138, code lost:
        
            return r6;
         */
        /* JADX WARN: Code restructure failed: missing block: B:53:0x011c, code lost:
        
            r0 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:56:0x013d, code lost:
        
            throw r0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:57:0x00b2, code lost:
        
            r0 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:58:0x013e, code lost:
        
            r2 = r21.this$0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:59:0x0140, code lost:
        
            monitor-enter(r2);
         */
        /* JADX WARN: Code restructure failed: missing block: B:61:0x0141, code lost:
        
            r2.setUpstreamReader(null);
            kotlin.jvm.internal.g0.n(r2, "null cannot be cast to non-null type java.lang.Object");
            r2.notifyAll();
            r3 = kotlin.n1.f44123a;
         */
        /* JADX WARN: Code restructure failed: missing block: B:63:0x014f, code lost:
        
            throw r0;
         */
        @Override // okio.Source
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public long read(@org.jetbrains.annotations.NotNull okio.Buffer r22, long r23) throws java.io.IOException {
            /*
                Method dump skipped, instructions count: 385
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.cache2.Relay.RelaySource.read(okio.Buffer, long):long");
        }

        @Override // okio.Source
        @NotNull
        public Timeout timeout() {
            return this.timeout;
        }
    }

    public /* synthetic */ Relay(RandomAccessFile randomAccessFile, Source source, long j6, ByteString byteString, long j7, v vVar) {
        this(randomAccessFile, source, j6, byteString, j7);
    }

    @Nullable
    public final Source newSource() {
        synchronized (this) {
            if (this.file == null) {
                return null;
            }
            this.sourceCount++;
            return new RelaySource();
        }
    }

    static {
        ByteString.Companion companion = ByteString.Companion;
        PREFIX_CLEAN = companion.encodeUtf8("OkHttp cache v1\n");
        PREFIX_DIRTY = companion.encodeUtf8("OkHttp DIRTY :(\n");
    }

    private Relay(RandomAccessFile randomAccessFile, Source source, long j6, ByteString byteString, long j7) {
        this.file = randomAccessFile;
        this.upstream = source;
        this.upstreamPos = j6;
        this.metadata = byteString;
        this.bufferMaxSize = j7;
        this.upstreamBuffer = new Buffer();
        this.complete = this.upstream == null;
        this.buffer = new Buffer();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void writeHeader(ByteString byteString, long j6, long j7) throws IOException {
        Buffer buffer = new Buffer();
        buffer.write(byteString);
        buffer.writeLong(j6);
        buffer.writeLong(j7);
        if (buffer.size() != 32) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        RandomAccessFile randomAccessFile = this.file;
        g0.m(randomAccessFile);
        FileChannel channel = randomAccessFile.getChannel();
        g0.o(channel, "getChannel(...)");
        new FileOperator(channel).write(0L, buffer, 32L);
    }

    private final void writeMetadata(long j6) throws IOException {
        Buffer buffer = new Buffer();
        buffer.write(this.metadata);
        RandomAccessFile randomAccessFile = this.file;
        g0.m(randomAccessFile);
        FileChannel channel = randomAccessFile.getChannel();
        g0.o(channel, "getChannel(...)");
        new FileOperator(channel).write(32 + j6, buffer, this.metadata.size());
    }

    @NotNull
    public final Buffer getBuffer() {
        return this.buffer;
    }

    public final long getBufferMaxSize() {
        return this.bufferMaxSize;
    }

    public final boolean getComplete() {
        return this.complete;
    }

    @Nullable
    public final RandomAccessFile getFile() {
        return this.file;
    }

    public final int getSourceCount() {
        return this.sourceCount;
    }

    @Nullable
    public final Source getUpstream() {
        return this.upstream;
    }

    @NotNull
    public final Buffer getUpstreamBuffer() {
        return this.upstreamBuffer;
    }

    public final long getUpstreamPos() {
        return this.upstreamPos;
    }

    @Nullable
    public final Thread getUpstreamReader() {
        return this.upstreamReader;
    }

    public final boolean isClosed() {
        return this.file == null;
    }

    @NotNull
    public final ByteString metadata() {
        return this.metadata;
    }

    public final void setComplete(boolean z5) {
        this.complete = z5;
    }

    public final void setFile(@Nullable RandomAccessFile randomAccessFile) {
        this.file = randomAccessFile;
    }

    public final void setSourceCount(int i6) {
        this.sourceCount = i6;
    }

    public final void setUpstream(@Nullable Source source) {
        this.upstream = source;
    }

    public final void setUpstreamPos(long j6) {
        this.upstreamPos = j6;
    }

    public final void setUpstreamReader(@Nullable Thread thread) {
        this.upstreamReader = thread;
    }

    public final void commit(long j6) throws IOException {
        writeMetadata(j6);
        RandomAccessFile randomAccessFile = this.file;
        g0.m(randomAccessFile);
        randomAccessFile.getChannel().force(false);
        writeHeader(PREFIX_CLEAN, j6, this.metadata.size());
        RandomAccessFile randomAccessFile2 = this.file;
        g0.m(randomAccessFile2);
        randomAccessFile2.getChannel().force(false);
        synchronized (this) {
            this.complete = true;
            n1 n1Var = n1.f44123a;
        }
        Source source = this.upstream;
        if (source != null) {
            _UtilCommonKt.closeQuietly(source);
        }
        this.upstream = null;
    }
}
