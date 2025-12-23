package okhttp3.internal.cache;

import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.Flushable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.v;
import kotlin.l;
import kotlin.n1;
import kotlin.text.Regex;
import kotlin.text.u;
import okhttp3.internal._UtilCommonKt;
import okhttp3.internal._UtilJvmKt;
import okhttp3.internal.cache.DiskLruCache;
import okhttp3.internal.concurrent.Lockable;
import okhttp3.internal.concurrent.Task;
import okhttp3.internal.concurrent.TaskQueue;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.platform.Platform;
import okio.BufferedSink;
import okio.FileSystem;
import okio.ForwardingFileSystem;
import okio.ForwardingSource;
import okio.Okio;
import okio.Path;
import okio.Sink;
import okio.Source;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nDiskLruCache.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DiskLruCache.kt\nokhttp3/internal/cache/DiskLruCache\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 Lockable.kt\nokhttp3/internal/concurrent/LockableKt\n+ 4 Okio.kt\nokio/Okio__OkioKt\n+ 5 FileSystem.kt\nokio/FileSystem\n+ 6 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,1120:1\n1#2:1121\n55#3,4:1122\n55#3,4:1189\n72#4:1126\n58#4,4:1128\n66#4,10:1133\n62#4,3:1143\n77#4,3:1146\n58#4,4:1152\n66#4,10:1157\n62#4,18:1167\n73#5:1127\n74#5:1132\n86#5:1149\n191#5:1150\n95#5:1151\n96#5:1156\n37#6,2:1185\n37#6,2:1187\n*S KotlinDebug\n*F\n+ 1 DiskLruCache.kt\nokhttp3/internal/cache/DiskLruCache\n*L\n230#1:1122,4\n324#1:1189,4\n279#1:1126\n279#1:1128,4\n279#1:1133,10\n279#1:1143,3\n279#1:1146,3\n411#1:1152,4\n411#1:1157,10\n411#1:1167,18\n279#1:1127\n279#1:1132\n411#1:1149\n411#1:1150\n411#1:1151\n411#1:1156\n715#1:1185,2\n765#1:1187,2\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class DiskLruCache implements Closeable, Flushable, Lockable {
    private final int appVersion;
    private boolean civilizedFileSystem;

    @NotNull
    private final TaskQueue cleanupQueue;

    @NotNull
    private final DiskLruCache$cleanupTask$1 cleanupTask;
    private boolean closed;

    @NotNull
    private final Path directory;

    @NotNull
    private final FileSystem fileSystem;
    private boolean hasJournalErrors;
    private boolean initialized;

    @NotNull
    private final Path journalFile;

    @NotNull
    private final Path journalFileBackup;

    @NotNull
    private final Path journalFileTmp;

    @Nullable
    private BufferedSink journalWriter;

    @NotNull
    private final LinkedHashMap<String, Entry> lruEntries;
    private long maxSize;
    private boolean mostRecentRebuildFailed;
    private boolean mostRecentTrimFailed;
    private long nextSequenceNumber;
    private int redundantOpCount;
    private long size;
    private final int valueCount;

    @NotNull
    public static final Companion Companion = new Companion(null);

    @JvmField
    @NotNull
    public static final String JOURNAL_FILE = "journal";

    @JvmField
    @NotNull
    public static final String JOURNAL_FILE_TEMP = "journal.tmp";

    @JvmField
    @NotNull
    public static final String JOURNAL_FILE_BACKUP = "journal.bkp";

    @JvmField
    @NotNull
    public static final String MAGIC = "libcore.io.DiskLruCache";

    @JvmField
    @NotNull
    public static final String VERSION_1 = "1";

    @JvmField
    public static final long ANY_SEQUENCE_NUMBER = -1;

    @JvmField
    @NotNull
    public static final Regex LEGAL_KEY_PATTERN = new Regex("[a-z0-9_-]{1,120}");

    @JvmField
    @NotNull
    public static final String CLEAN = "CLEAN";

    @JvmField
    @NotNull
    public static final String DIRTY = "DIRTY";

    @JvmField
    @NotNull
    public static final String REMOVE = "REMOVE";

    @JvmField
    @NotNull
    public static final String READ = "READ";

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class Companion {
        public /* synthetic */ Companion(v vVar) {
            this();
        }

        private Companion() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public final class Editor {
        private boolean done;

        @NotNull
        private final Entry entry;
        final /* synthetic */ DiskLruCache this$0;

        @Nullable
        private final boolean[] written;

        public Editor(@NotNull DiskLruCache diskLruCache, Entry entry) {
            g0.p(entry, "entry");
            this.this$0 = diskLruCache;
            this.entry = entry;
            this.written = entry.getReadable$okhttp() ? null : new boolean[diskLruCache.getValueCount$okhttp()];
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final n1 newSink$lambda$0$0(DiskLruCache diskLruCache, Editor editor, IOException it) {
            n1 n1Var;
            g0.p(it, "it");
            synchronized (diskLruCache) {
                editor.detach$okhttp();
                n1Var = n1.f44123a;
            }
            return n1Var;
        }

        public final void abort() throws IOException {
            DiskLruCache diskLruCache = this.this$0;
            synchronized (diskLruCache) {
                try {
                    if (this.done) {
                        throw new IllegalStateException("Check failed.");
                    }
                    if (g0.g(this.entry.getCurrentEditor$okhttp(), this)) {
                        diskLruCache.completeEdit$okhttp(this, false);
                    }
                    this.done = true;
                    n1 n1Var = n1.f44123a;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public final void commit() throws IOException {
            DiskLruCache diskLruCache = this.this$0;
            synchronized (diskLruCache) {
                try {
                    if (this.done) {
                        throw new IllegalStateException("Check failed.");
                    }
                    if (g0.g(this.entry.getCurrentEditor$okhttp(), this)) {
                        diskLruCache.completeEdit$okhttp(this, true);
                    }
                    this.done = true;
                    n1 n1Var = n1.f44123a;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public final void detach$okhttp() {
            if (g0.g(this.entry.getCurrentEditor$okhttp(), this)) {
                if (this.this$0.civilizedFileSystem) {
                    this.this$0.completeEdit$okhttp(this, false);
                } else {
                    this.entry.setZombie$okhttp(true);
                }
            }
        }

        @NotNull
        public final Entry getEntry$okhttp() {
            return this.entry;
        }

        @Nullable
        public final boolean[] getWritten$okhttp() {
            return this.written;
        }

        @NotNull
        public final Sink newSink(int i6) {
            final DiskLruCache diskLruCache = this.this$0;
            synchronized (diskLruCache) {
                if (this.done) {
                    throw new IllegalStateException("Check failed.");
                }
                if (!g0.g(this.entry.getCurrentEditor$okhttp(), this)) {
                    return Okio.blackhole();
                }
                if (!this.entry.getReadable$okhttp()) {
                    boolean[] zArr = this.written;
                    g0.m(zArr);
                    zArr[i6] = true;
                }
                try {
                    return new FaultHidingSink(diskLruCache.getFileSystem$okhttp().sink(this.entry.getDirtyFiles$okhttp().get(i6)), new Function1() { // from class: okhttp3.internal.cache.b
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            n1 newSink$lambda$0$0;
                            newSink$lambda$0$0 = DiskLruCache.Editor.newSink$lambda$0$0(DiskLruCache.this, this, (IOException) obj);
                            return newSink$lambda$0$0;
                        }
                    });
                } catch (FileNotFoundException unused) {
                    return Okio.blackhole();
                }
            }
        }

        @Nullable
        public final Source newSource(int i6) {
            DiskLruCache diskLruCache = this.this$0;
            synchronized (diskLruCache) {
                if (this.done) {
                    throw new IllegalStateException("Check failed.");
                }
                Source source = null;
                if (!this.entry.getReadable$okhttp() || !g0.g(this.entry.getCurrentEditor$okhttp(), this) || this.entry.getZombie$okhttp()) {
                    return null;
                }
                try {
                    source = diskLruCache.getFileSystem$okhttp().source(this.entry.getCleanFiles$okhttp().get(i6));
                } catch (FileNotFoundException unused) {
                }
                return source;
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\nDiskLruCache.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DiskLruCache.kt\nokhttp3/internal/cache/DiskLruCache$Entry\n+ 2 Lockable.kt\nokhttp3/internal/concurrent/LockableKt\n*L\n1#1,1120:1\n55#2,4:1121\n*S KotlinDebug\n*F\n+ 1 DiskLruCache.kt\nokhttp3/internal/cache/DiskLruCache$Entry\n*L\n1045#1:1121,4\n*E\n"})
    public final class Entry {

        @NotNull
        private final List<Path> cleanFiles;

        @Nullable
        private Editor currentEditor;

        @NotNull
        private final List<Path> dirtyFiles;

        @NotNull
        private final String key;

        @NotNull
        private final long[] lengths;
        private int lockingSourceCount;
        private boolean readable;
        private long sequenceNumber;
        final /* synthetic */ DiskLruCache this$0;
        private boolean zombie;

        public Entry(@NotNull DiskLruCache diskLruCache, String key) {
            g0.p(key, "key");
            this.this$0 = diskLruCache;
            this.key = key;
            this.lengths = new long[diskLruCache.getValueCount$okhttp()];
            this.cleanFiles = new ArrayList();
            this.dirtyFiles = new ArrayList();
            StringBuilder sb = new StringBuilder(key);
            sb.append('.');
            int length = sb.length();
            int valueCount$okhttp = diskLruCache.getValueCount$okhttp();
            for (int i6 = 0; i6 < valueCount$okhttp; i6++) {
                sb.append(i6);
                List<Path> list = this.cleanFiles;
                Path directory = this.this$0.getDirectory();
                String sb2 = sb.toString();
                g0.o(sb2, "toString(...)");
                list.add(directory.resolve(sb2));
                sb.append(".tmp");
                List<Path> list2 = this.dirtyFiles;
                Path directory2 = this.this$0.getDirectory();
                String sb3 = sb.toString();
                g0.o(sb3, "toString(...)");
                list2.add(directory2.resolve(sb3));
                sb.setLength(length);
            }
        }

        private final Void invalidLengths(List<String> list) throws IOException {
            throw new IOException("unexpected journal line: " + list);
        }

        private final Source newSource(int i6) {
            final Source source = this.this$0.getFileSystem$okhttp().source(this.cleanFiles.get(i6));
            if (this.this$0.civilizedFileSystem) {
                return source;
            }
            this.lockingSourceCount++;
            final DiskLruCache diskLruCache = this.this$0;
            return new ForwardingSource(source) { // from class: okhttp3.internal.cache.DiskLruCache$Entry$newSource$1
                private boolean closed;

                @Override // okio.ForwardingSource, okio.Source, java.io.Closeable, java.lang.AutoCloseable
                public void close() {
                    super.close();
                    if (!this.closed) {
                        this.closed = true;
                        DiskLruCache diskLruCache2 = diskLruCache;
                        DiskLruCache.Entry entry = this;
                        synchronized (diskLruCache2) {
                            try {
                                entry.setLockingSourceCount$okhttp(entry.getLockingSourceCount$okhttp() - 1);
                                if (entry.getLockingSourceCount$okhttp() == 0 && entry.getZombie$okhttp()) {
                                    diskLruCache2.removeEntry$okhttp(entry);
                                }
                                n1 n1Var = n1.f44123a;
                            } catch (Throwable th) {
                                throw th;
                            }
                        }
                    }
                }
            };
        }

        @NotNull
        public final List<Path> getCleanFiles$okhttp() {
            return this.cleanFiles;
        }

        @Nullable
        public final Editor getCurrentEditor$okhttp() {
            return this.currentEditor;
        }

        @NotNull
        public final List<Path> getDirtyFiles$okhttp() {
            return this.dirtyFiles;
        }

        @NotNull
        public final String getKey$okhttp() {
            return this.key;
        }

        @NotNull
        public final long[] getLengths$okhttp() {
            return this.lengths;
        }

        public final int getLockingSourceCount$okhttp() {
            return this.lockingSourceCount;
        }

        public final boolean getReadable$okhttp() {
            return this.readable;
        }

        public final long getSequenceNumber$okhttp() {
            return this.sequenceNumber;
        }

        public final boolean getZombie$okhttp() {
            return this.zombie;
        }

        public final void setCurrentEditor$okhttp(@Nullable Editor editor) {
            this.currentEditor = editor;
        }

        public final void setLengths$okhttp(@NotNull List<String> strings) throws IOException {
            g0.p(strings, "strings");
            if (strings.size() != this.this$0.getValueCount$okhttp()) {
                invalidLengths(strings);
                throw new KotlinNothingValueException();
            }
            try {
                int size = strings.size();
                for (int i6 = 0; i6 < size; i6++) {
                    this.lengths[i6] = Long.parseLong(strings.get(i6));
                }
            } catch (NumberFormatException unused) {
                invalidLengths(strings);
                throw new KotlinNothingValueException();
            }
        }

        public final void setLockingSourceCount$okhttp(int i6) {
            this.lockingSourceCount = i6;
        }

        public final void setReadable$okhttp(boolean z5) {
            this.readable = z5;
        }

        public final void setSequenceNumber$okhttp(long j6) {
            this.sequenceNumber = j6;
        }

        public final void setZombie$okhttp(boolean z5) {
            this.zombie = z5;
        }

        @Nullable
        public final Snapshot snapshot$okhttp() {
            DiskLruCache diskLruCache = this.this$0;
            if (_UtilJvmKt.assertionsEnabled && !Thread.holdsLock(diskLruCache)) {
                throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + diskLruCache);
            }
            if (!this.readable) {
                return null;
            }
            if (!this.this$0.civilizedFileSystem && (this.currentEditor != null || this.zombie)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            long[] jArr = (long[]) this.lengths.clone();
            try {
                int valueCount$okhttp = this.this$0.getValueCount$okhttp();
                for (int i6 = 0; i6 < valueCount$okhttp; i6++) {
                    arrayList.add(newSource(i6));
                }
                return new Snapshot(this.this$0, this.key, this.sequenceNumber, arrayList, jArr);
            } catch (FileNotFoundException unused) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    _UtilCommonKt.closeQuietly((Source) it.next());
                }
                try {
                    this.this$0.removeEntry$okhttp(this);
                } catch (IOException unused2) {
                }
                return null;
            }
        }

        public final void writeLengths$okhttp(@NotNull BufferedSink writer) throws IOException {
            g0.p(writer, "writer");
            for (long j6 : this.lengths) {
                writer.writeByte(32).writeDecimalLong(j6);
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public final class Snapshot implements Closeable {

        @NotNull
        private final String key;

        @NotNull
        private final long[] lengths;
        private final long sequenceNumber;

        @NotNull
        private final List<Source> sources;
        final /* synthetic */ DiskLruCache this$0;

        /* JADX WARN: Multi-variable type inference failed */
        public Snapshot(@NotNull DiskLruCache diskLruCache, String key, @NotNull long j6, @NotNull List<? extends Source> sources, long[] lengths) {
            g0.p(key, "key");
            g0.p(sources, "sources");
            g0.p(lengths, "lengths");
            this.this$0 = diskLruCache;
            this.key = key;
            this.sequenceNumber = j6;
            this.sources = sources;
            this.lengths = lengths;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            Iterator<Source> it = this.sources.iterator();
            while (it.hasNext()) {
                _UtilCommonKt.closeQuietly(it.next());
            }
        }

        @Nullable
        public final Editor edit() throws IOException {
            return this.this$0.edit(this.key, this.sequenceNumber);
        }

        public final long getLength(int i6) {
            return this.lengths[i6];
        }

        @NotNull
        public final Source getSource(int i6) {
            return this.sources.get(i6);
        }

        @NotNull
        public final String key() {
            return this.key;
        }
    }

    private final synchronized void checkNotClosed() {
        if (this.closed) {
            throw new IllegalStateException("cache is closed");
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        Editor currentEditor$okhttp;
        try {
            if (this.initialized && !this.closed) {
                Collection<Entry> values = this.lruEntries.values();
                g0.o(values, "<get-values>(...)");
                for (Entry entry : (Entry[]) values.toArray(new Entry[0])) {
                    g0.m(entry);
                    if (entry.getCurrentEditor$okhttp() != null && (currentEditor$okhttp = entry.getCurrentEditor$okhttp()) != null) {
                        currentEditor$okhttp.detach$okhttp();
                    }
                }
                trimToSize();
                BufferedSink bufferedSink = this.journalWriter;
                if (bufferedSink != null) {
                    _UtilCommonKt.closeQuietly(bufferedSink);
                }
                this.journalWriter = null;
                this.closed = true;
                return;
            }
            this.closed = true;
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void completeEdit$okhttp(@NotNull Editor editor, boolean z5) throws IOException {
        g0.p(editor, "editor");
        Entry entry$okhttp = editor.getEntry$okhttp();
        if (!g0.g(entry$okhttp.getCurrentEditor$okhttp(), editor)) {
            throw new IllegalStateException("Check failed.");
        }
        if (z5 && !entry$okhttp.getReadable$okhttp()) {
            int i6 = this.valueCount;
            for (int i7 = 0; i7 < i6; i7++) {
                boolean[] written$okhttp = editor.getWritten$okhttp();
                g0.m(written$okhttp);
                if (!written$okhttp[i7]) {
                    editor.abort();
                    throw new IllegalStateException("Newly created entry didn't create value for index " + i7);
                }
                if (!this.fileSystem.exists(entry$okhttp.getDirtyFiles$okhttp().get(i7))) {
                    editor.abort();
                    return;
                }
            }
        }
        int i8 = this.valueCount;
        for (int i9 = 0; i9 < i8; i9++) {
            Path path = entry$okhttp.getDirtyFiles$okhttp().get(i9);
            if (!z5 || entry$okhttp.getZombie$okhttp()) {
                _UtilCommonKt.deleteIfExists(this.fileSystem, path);
            } else if (this.fileSystem.exists(path)) {
                Path path2 = entry$okhttp.getCleanFiles$okhttp().get(i9);
                this.fileSystem.atomicMove(path, path2);
                long j6 = entry$okhttp.getLengths$okhttp()[i9];
                Long size = this.fileSystem.metadata(path2).getSize();
                long longValue = size != null ? size.longValue() : 0L;
                entry$okhttp.getLengths$okhttp()[i9] = longValue;
                this.size = (this.size - j6) + longValue;
            }
        }
        entry$okhttp.setCurrentEditor$okhttp(null);
        if (entry$okhttp.getZombie$okhttp()) {
            removeEntry$okhttp(entry$okhttp);
            return;
        }
        this.redundantOpCount++;
        BufferedSink bufferedSink = this.journalWriter;
        g0.m(bufferedSink);
        if (!entry$okhttp.getReadable$okhttp() && !z5) {
            this.lruEntries.remove(entry$okhttp.getKey$okhttp());
            bufferedSink.writeUtf8(REMOVE).writeByte(32);
            bufferedSink.writeUtf8(entry$okhttp.getKey$okhttp());
            bufferedSink.writeByte(10);
            bufferedSink.flush();
            if (this.size <= this.maxSize || journalRebuildRequired()) {
                TaskQueue.schedule$default(this.cleanupQueue, this.cleanupTask, 0L, 2, null);
            }
        }
        entry$okhttp.setReadable$okhttp(true);
        bufferedSink.writeUtf8(CLEAN).writeByte(32);
        bufferedSink.writeUtf8(entry$okhttp.getKey$okhttp());
        entry$okhttp.writeLengths$okhttp(bufferedSink);
        bufferedSink.writeByte(10);
        if (z5) {
            long j7 = this.nextSequenceNumber;
            this.nextSequenceNumber = 1 + j7;
            entry$okhttp.setSequenceNumber$okhttp(j7);
        }
        bufferedSink.flush();
        if (this.size <= this.maxSize) {
        }
        TaskQueue.schedule$default(this.cleanupQueue, this.cleanupTask, 0L, 2, null);
    }

    @JvmOverloads
    @Nullable
    public final Editor edit(@NotNull String key) throws IOException {
        g0.p(key, "key");
        return edit$default(this, key, 0L, 2, null);
    }

    public final synchronized void evictAll() throws IOException {
        try {
            initialize();
            Collection<Entry> values = this.lruEntries.values();
            g0.o(values, "<get-values>(...)");
            for (Entry entry : (Entry[]) values.toArray(new Entry[0])) {
                g0.m(entry);
                removeEntry$okhttp(entry);
            }
            this.mostRecentTrimFailed = false;
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // java.io.Flushable
    public synchronized void flush() throws IOException {
        if (this.initialized) {
            checkNotClosed();
            trimToSize();
            BufferedSink bufferedSink = this.journalWriter;
            g0.m(bufferedSink);
            bufferedSink.flush();
        }
    }

    @Nullable
    public final synchronized Snapshot get(@NotNull String key) throws IOException {
        g0.p(key, "key");
        initialize();
        checkNotClosed();
        validateKey(key);
        Entry entry = this.lruEntries.get(key);
        if (entry == null) {
            return null;
        }
        Snapshot snapshot$okhttp = entry.snapshot$okhttp();
        if (snapshot$okhttp == null) {
            return null;
        }
        this.redundantOpCount++;
        BufferedSink bufferedSink = this.journalWriter;
        g0.m(bufferedSink);
        bufferedSink.writeUtf8(READ).writeByte(32).writeUtf8(key).writeByte(10);
        if (journalRebuildRequired()) {
            TaskQueue.schedule$default(this.cleanupQueue, this.cleanupTask, 0L, 2, null);
        }
        return snapshot$okhttp;
    }

    public final synchronized long getMaxSize() {
        return this.maxSize;
    }

    public final synchronized void initialize() throws IOException {
        try {
            if (_UtilJvmKt.assertionsEnabled && !Thread.holdsLock(this)) {
                throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + this);
            }
            if (this.initialized) {
                return;
            }
            if (this.fileSystem.exists(this.journalFileBackup)) {
                if (this.fileSystem.exists(this.journalFile)) {
                    this.fileSystem.delete(this.journalFileBackup);
                } else {
                    this.fileSystem.atomicMove(this.journalFileBackup, this.journalFile);
                }
            }
            this.civilizedFileSystem = _UtilCommonKt.isCivilized(this.fileSystem, this.journalFileBackup);
            if (this.fileSystem.exists(this.journalFile)) {
                try {
                    readJournal();
                    processJournal();
                    this.initialized = true;
                    return;
                } catch (IOException e6) {
                    Platform.Companion.get().log("DiskLruCache " + this.directory + " is corrupt: " + e6.getMessage() + ", removing", 5, e6);
                    try {
                        delete();
                        this.closed = false;
                    } catch (Throwable th) {
                        this.closed = false;
                        throw th;
                    }
                }
            }
            rebuildJournal$okhttp();
            this.initialized = true;
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public final synchronized boolean isClosed() {
        return this.closed;
    }

    public final synchronized void rebuildJournal$okhttp() throws IOException {
        Throwable th;
        try {
            BufferedSink bufferedSink = this.journalWriter;
            if (bufferedSink != null) {
                bufferedSink.close();
            }
            BufferedSink buffer = Okio.buffer(this.fileSystem.sink(this.journalFileTmp, false));
            try {
                buffer.writeUtf8(MAGIC).writeByte(10);
                buffer.writeUtf8(VERSION_1).writeByte(10);
                buffer.writeDecimalLong(this.appVersion).writeByte(10);
                buffer.writeDecimalLong(this.valueCount).writeByte(10);
                buffer.writeByte(10);
                for (Entry entry : this.lruEntries.values()) {
                    g0.o(entry, "next(...)");
                    Entry entry2 = entry;
                    if (entry2.getCurrentEditor$okhttp() != null) {
                        buffer.writeUtf8(DIRTY).writeByte(32);
                        buffer.writeUtf8(entry2.getKey$okhttp());
                        buffer.writeByte(10);
                    } else {
                        buffer.writeUtf8(CLEAN).writeByte(32);
                        buffer.writeUtf8(entry2.getKey$okhttp());
                        entry2.writeLengths$okhttp(buffer);
                        buffer.writeByte(10);
                    }
                }
                n1 n1Var = n1.f44123a;
                if (buffer != null) {
                    try {
                        buffer.close();
                    } catch (Throwable th2) {
                        th = th2;
                    }
                }
                th = null;
            } catch (Throwable th3) {
                if (buffer != null) {
                    try {
                        buffer.close();
                    } catch (Throwable th4) {
                        l.a(th3, th4);
                    }
                }
                th = th3;
            }
            if (th != null) {
                throw th;
            }
            if (this.fileSystem.exists(this.journalFile)) {
                this.fileSystem.atomicMove(this.journalFile, this.journalFileBackup);
                this.fileSystem.atomicMove(this.journalFileTmp, this.journalFile);
                _UtilCommonKt.deleteIfExists(this.fileSystem, this.journalFileBackup);
            } else {
                this.fileSystem.atomicMove(this.journalFileTmp, this.journalFile);
            }
            BufferedSink bufferedSink2 = this.journalWriter;
            if (bufferedSink2 != null) {
                _UtilCommonKt.closeQuietly(bufferedSink2);
            }
            this.journalWriter = newJournalWriter();
            this.hasJournalErrors = false;
            this.mostRecentRebuildFailed = false;
        } catch (Throwable th5) {
            throw th5;
        }
    }

    public final synchronized boolean remove(@NotNull String key) throws IOException {
        g0.p(key, "key");
        initialize();
        checkNotClosed();
        validateKey(key);
        Entry entry = this.lruEntries.get(key);
        if (entry == null) {
            return false;
        }
        boolean removeEntry$okhttp = removeEntry$okhttp(entry);
        if (removeEntry$okhttp && this.size <= this.maxSize) {
            this.mostRecentTrimFailed = false;
        }
        return removeEntry$okhttp;
    }

    public final synchronized void setMaxSize(long j6) {
        this.maxSize = j6;
        if (this.initialized) {
            TaskQueue.schedule$default(this.cleanupQueue, this.cleanupTask, 0L, 2, null);
        }
    }

    public final synchronized long size() throws IOException {
        initialize();
        return this.size;
    }

    @NotNull
    public final synchronized Iterator<Snapshot> snapshots() throws IOException {
        initialize();
        return new DiskLruCache$snapshots$1(this);
    }

    /* JADX WARN: Type inference failed for: r5v5, types: [okhttp3.internal.cache.DiskLruCache$cleanupTask$1] */
    public DiskLruCache(@NotNull final FileSystem fileSystem, @NotNull Path directory, int i6, int i7, long j6, @NotNull TaskRunner taskRunner) {
        g0.p(fileSystem, "fileSystem");
        g0.p(directory, "directory");
        g0.p(taskRunner, "taskRunner");
        this.directory = directory;
        this.appVersion = i6;
        this.valueCount = i7;
        this.fileSystem = new ForwardingFileSystem(fileSystem) { // from class: okhttp3.internal.cache.DiskLruCache$fileSystem$1
            @Override // okio.ForwardingFileSystem, okio.FileSystem
            public Sink sink(Path file, boolean z5) {
                g0.p(file, "file");
                Path parent = file.parent();
                if (parent != null) {
                    createDirectories(parent);
                }
                return super.sink(file, z5);
            }
        };
        this.maxSize = j6;
        this.lruEntries = new LinkedHashMap<>(0, 0.75f, true);
        this.cleanupQueue = taskRunner.newQueue();
        final String str = _UtilJvmKt.okHttpName + " Cache";
        this.cleanupTask = new Task(str) { // from class: okhttp3.internal.cache.DiskLruCache$cleanupTask$1
            @Override // okhttp3.internal.concurrent.Task
            public long runOnce() {
                boolean z5;
                BufferedSink bufferedSink;
                boolean journalRebuildRequired;
                DiskLruCache diskLruCache = DiskLruCache.this;
                synchronized (diskLruCache) {
                    z5 = diskLruCache.initialized;
                    if (!z5 || diskLruCache.getClosed$okhttp()) {
                        return -1L;
                    }
                    try {
                        diskLruCache.trimToSize();
                    } catch (IOException unused) {
                        diskLruCache.mostRecentTrimFailed = true;
                    }
                    try {
                        journalRebuildRequired = diskLruCache.journalRebuildRequired();
                        if (journalRebuildRequired) {
                            diskLruCache.rebuildJournal$okhttp();
                            diskLruCache.redundantOpCount = 0;
                        }
                    } catch (IOException unused2) {
                        diskLruCache.mostRecentRebuildFailed = true;
                        bufferedSink = diskLruCache.journalWriter;
                        if (bufferedSink != null) {
                            _UtilCommonKt.closeQuietly(bufferedSink);
                        }
                        diskLruCache.journalWriter = Okio.buffer(Okio.blackhole());
                    }
                    return -1L;
                }
            }
        };
        if (j6 <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        if (i7 <= 0) {
            throw new IllegalArgumentException("valueCount <= 0");
        }
        this.journalFile = directory.resolve(JOURNAL_FILE);
        this.journalFileTmp = directory.resolve(JOURNAL_FILE_TEMP);
        this.journalFileBackup = directory.resolve(JOURNAL_FILE_BACKUP);
    }

    public static /* synthetic */ Editor edit$default(DiskLruCache diskLruCache, String str, long j6, int i6, Object obj) throws IOException {
        if ((i6 & 2) != 0) {
            j6 = ANY_SEQUENCE_NUMBER;
        }
        return diskLruCache.edit(str, j6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean journalRebuildRequired() {
        int i6 = this.redundantOpCount;
        return i6 >= 2000 && i6 >= this.lruEntries.size();
    }

    private final BufferedSink newJournalWriter() throws FileNotFoundException {
        return Okio.buffer(new FaultHidingSink(this.fileSystem.appendingSink(this.journalFile), new Function1() { // from class: okhttp3.internal.cache.a
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                n1 newJournalWriter$lambda$0;
                newJournalWriter$lambda$0 = DiskLruCache.newJournalWriter$lambda$0(DiskLruCache.this, (IOException) obj);
                return newJournalWriter$lambda$0;
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 newJournalWriter$lambda$0(DiskLruCache diskLruCache, IOException it) {
        g0.p(it, "it");
        if (!_UtilJvmKt.assertionsEnabled || Thread.holdsLock(diskLruCache)) {
            diskLruCache.hasJournalErrors = true;
            return n1.f44123a;
        }
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + diskLruCache);
    }

    private final void processJournal() throws IOException {
        _UtilCommonKt.deleteIfExists(this.fileSystem, this.journalFileTmp);
        Iterator<Entry> it = this.lruEntries.values().iterator();
        while (it.hasNext()) {
            Entry next = it.next();
            g0.o(next, "next(...)");
            Entry entry = next;
            int i6 = 0;
            if (entry.getCurrentEditor$okhttp() == null) {
                int i7 = this.valueCount;
                while (i6 < i7) {
                    this.size += entry.getLengths$okhttp()[i6];
                    i6++;
                }
            } else {
                entry.setCurrentEditor$okhttp(null);
                int i8 = this.valueCount;
                while (i6 < i8) {
                    _UtilCommonKt.deleteIfExists(this.fileSystem, entry.getCleanFiles$okhttp().get(i6));
                    _UtilCommonKt.deleteIfExists(this.fileSystem, entry.getDirtyFiles$okhttp().get(i6));
                    i6++;
                }
                it.remove();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x00c3 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00c4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void readJournal() throws java.io.IOException {
        /*
            r9 = this;
            java.lang.String r0 = ", "
            okio.FileSystem r1 = r9.fileSystem
            okio.Path r2 = r9.journalFile
            okio.Source r1 = r1.source(r2)
            okio.BufferedSource r1 = okio.Okio.buffer(r1)
            java.lang.String r2 = r1.readUtf8LineStrict()     // Catch: java.lang.Throwable -> L5b
            java.lang.String r3 = r1.readUtf8LineStrict()     // Catch: java.lang.Throwable -> L5b
            java.lang.String r4 = r1.readUtf8LineStrict()     // Catch: java.lang.Throwable -> L5b
            java.lang.String r5 = r1.readUtf8LineStrict()     // Catch: java.lang.Throwable -> L5b
            java.lang.String r6 = r1.readUtf8LineStrict()     // Catch: java.lang.Throwable -> L5b
            java.lang.String r7 = okhttp3.internal.cache.DiskLruCache.MAGIC     // Catch: java.lang.Throwable -> L5b
            boolean r7 = kotlin.jvm.internal.g0.g(r7, r2)     // Catch: java.lang.Throwable -> L5b
            if (r7 == 0) goto L89
            java.lang.String r7 = okhttp3.internal.cache.DiskLruCache.VERSION_1     // Catch: java.lang.Throwable -> L5b
            boolean r7 = kotlin.jvm.internal.g0.g(r7, r3)     // Catch: java.lang.Throwable -> L5b
            if (r7 == 0) goto L89
            int r7 = r9.appVersion     // Catch: java.lang.Throwable -> L5b
            java.lang.String r7 = java.lang.String.valueOf(r7)     // Catch: java.lang.Throwable -> L5b
            boolean r4 = kotlin.jvm.internal.g0.g(r7, r4)     // Catch: java.lang.Throwable -> L5b
            if (r4 == 0) goto L89
            int r4 = r9.valueCount     // Catch: java.lang.Throwable -> L5b
            java.lang.String r4 = java.lang.String.valueOf(r4)     // Catch: java.lang.Throwable -> L5b
            boolean r4 = kotlin.jvm.internal.g0.g(r4, r5)     // Catch: java.lang.Throwable -> L5b
            if (r4 == 0) goto L89
            int r4 = r6.length()     // Catch: java.lang.Throwable -> L5b
            if (r4 > 0) goto L89
            r0 = 0
        L51:
            java.lang.String r2 = r1.readUtf8LineStrict()     // Catch: java.lang.Throwable -> L5b java.io.EOFException -> L5d
            r9.readJournalLine(r2)     // Catch: java.lang.Throwable -> L5b java.io.EOFException -> L5d
            int r0 = r0 + 1
            goto L51
        L5b:
            r0 = move-exception
            goto Lb7
        L5d:
            java.util.LinkedHashMap<java.lang.String, okhttp3.internal.cache.DiskLruCache$Entry> r2 = r9.lruEntries     // Catch: java.lang.Throwable -> L5b
            int r2 = r2.size()     // Catch: java.lang.Throwable -> L5b
            int r0 = r0 - r2
            r9.redundantOpCount = r0     // Catch: java.lang.Throwable -> L5b
            boolean r0 = r1.exhausted()     // Catch: java.lang.Throwable -> L5b
            if (r0 != 0) goto L70
            r9.rebuildJournal$okhttp()     // Catch: java.lang.Throwable -> L5b
            goto L7d
        L70:
            okio.BufferedSink r0 = r9.journalWriter     // Catch: java.lang.Throwable -> L5b
            if (r0 == 0) goto L77
            okhttp3.internal._UtilCommonKt.closeQuietly(r0)     // Catch: java.lang.Throwable -> L5b
        L77:
            okio.BufferedSink r0 = r9.newJournalWriter()     // Catch: java.lang.Throwable -> L5b
            r9.journalWriter = r0     // Catch: java.lang.Throwable -> L5b
        L7d:
            kotlin.n1 r0 = kotlin.n1.f44123a     // Catch: java.lang.Throwable -> L5b
            if (r1 == 0) goto L87
            r1.close()     // Catch: java.lang.Throwable -> L85
            goto L87
        L85:
            r0 = move-exception
            goto Lc1
        L87:
            r0 = 0
            goto Lc1
        L89:
            java.io.IOException r4 = new java.io.IOException     // Catch: java.lang.Throwable -> L5b
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L5b
            r7.<init>()     // Catch: java.lang.Throwable -> L5b
            java.lang.String r8 = "unexpected journal header: ["
            r7.append(r8)     // Catch: java.lang.Throwable -> L5b
            r7.append(r2)     // Catch: java.lang.Throwable -> L5b
            r7.append(r0)     // Catch: java.lang.Throwable -> L5b
            r7.append(r3)     // Catch: java.lang.Throwable -> L5b
            r7.append(r0)     // Catch: java.lang.Throwable -> L5b
            r7.append(r5)     // Catch: java.lang.Throwable -> L5b
            r7.append(r0)     // Catch: java.lang.Throwable -> L5b
            r7.append(r6)     // Catch: java.lang.Throwable -> L5b
            r0 = 93
            r7.append(r0)     // Catch: java.lang.Throwable -> L5b
            java.lang.String r0 = r7.toString()     // Catch: java.lang.Throwable -> L5b
            r4.<init>(r0)     // Catch: java.lang.Throwable -> L5b
            throw r4     // Catch: java.lang.Throwable -> L5b
        Lb7:
            if (r1 == 0) goto Lc1
            r1.close()     // Catch: java.lang.Throwable -> Lbd
            goto Lc1
        Lbd:
            r1 = move-exception
            kotlin.l.a(r0, r1)
        Lc1:
            if (r0 != 0) goto Lc4
            return
        Lc4:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.cache.DiskLruCache.readJournal():void");
    }

    private final void readJournalLine(String str) throws IOException {
        String substring;
        int G3 = u.G3(str, ' ', 0, false, 6, null);
        if (G3 == -1) {
            throw new IOException("unexpected journal line: " + str);
        }
        int i6 = G3 + 1;
        int G32 = u.G3(str, ' ', i6, false, 4, null);
        if (G32 == -1) {
            substring = str.substring(i6);
            g0.o(substring, "substring(...)");
            String str2 = REMOVE;
            if (G3 == str2.length() && u.H2(str, str2, false, 2, null)) {
                this.lruEntries.remove(substring);
                return;
            }
        } else {
            substring = str.substring(i6, G32);
            g0.o(substring, "substring(...)");
        }
        Entry entry = this.lruEntries.get(substring);
        if (entry == null) {
            entry = new Entry(this, substring);
            this.lruEntries.put(substring, entry);
        }
        if (G32 != -1) {
            String str3 = CLEAN;
            if (G3 == str3.length() && u.H2(str, str3, false, 2, null)) {
                String substring2 = str.substring(G32 + 1);
                g0.o(substring2, "substring(...)");
                List<String> l52 = u.l5(substring2, new char[]{' '}, false, 0, 6, null);
                entry.setReadable$okhttp(true);
                entry.setCurrentEditor$okhttp(null);
                entry.setLengths$okhttp(l52);
                return;
            }
        }
        if (G32 == -1) {
            String str4 = DIRTY;
            if (G3 == str4.length() && u.H2(str, str4, false, 2, null)) {
                entry.setCurrentEditor$okhttp(new Editor(this, entry));
                return;
            }
        }
        if (G32 == -1) {
            String str5 = READ;
            if (G3 == str5.length() && u.H2(str, str5, false, 2, null)) {
                return;
            }
        }
        throw new IOException("unexpected journal line: " + str);
    }

    private final boolean removeOldestEntry() {
        for (Entry entry : this.lruEntries.values()) {
            g0.o(entry, "next(...)");
            Entry entry2 = entry;
            if (!entry2.getZombie$okhttp()) {
                removeEntry$okhttp(entry2);
                return true;
            }
        }
        return false;
    }

    private final void validateKey(String str) {
        if (LEGAL_KEY_PATTERN.matches(str)) {
            return;
        }
        throw new IllegalArgumentException(("keys must match regex [a-z0-9_-]{1,120}: \"" + str + '\"').toString());
    }

    @JvmOverloads
    @Nullable
    public final synchronized Editor edit(@NotNull String key, long j6) throws IOException {
        g0.p(key, "key");
        initialize();
        checkNotClosed();
        validateKey(key);
        Entry entry = this.lruEntries.get(key);
        if (j6 != ANY_SEQUENCE_NUMBER && (entry == null || entry.getSequenceNumber$okhttp() != j6)) {
            return null;
        }
        if ((entry != null ? entry.getCurrentEditor$okhttp() : null) != null) {
            return null;
        }
        if (entry != null && entry.getLockingSourceCount$okhttp() != 0) {
            return null;
        }
        if (!this.mostRecentTrimFailed && !this.mostRecentRebuildFailed) {
            BufferedSink bufferedSink = this.journalWriter;
            g0.m(bufferedSink);
            bufferedSink.writeUtf8(DIRTY).writeByte(32).writeUtf8(key).writeByte(10);
            bufferedSink.flush();
            if (this.hasJournalErrors) {
                return null;
            }
            if (entry == null) {
                entry = new Entry(this, key);
                this.lruEntries.put(key, entry);
            }
            Editor editor = new Editor(this, entry);
            entry.setCurrentEditor$okhttp(editor);
            return editor;
        }
        TaskQueue.schedule$default(this.cleanupQueue, this.cleanupTask, 0L, 2, null);
        return null;
    }

    public final boolean getClosed$okhttp() {
        return this.closed;
    }

    @NotNull
    public final Path getDirectory() {
        return this.directory;
    }

    @NotNull
    public final FileSystem getFileSystem$okhttp() {
        return this.fileSystem;
    }

    @NotNull
    public final LinkedHashMap<String, Entry> getLruEntries$okhttp() {
        return this.lruEntries;
    }

    public final int getValueCount$okhttp() {
        return this.valueCount;
    }

    public final boolean removeEntry$okhttp(@NotNull Entry entry) throws IOException {
        BufferedSink bufferedSink;
        g0.p(entry, "entry");
        if (!this.civilizedFileSystem) {
            if (entry.getLockingSourceCount$okhttp() > 0 && (bufferedSink = this.journalWriter) != null) {
                bufferedSink.writeUtf8(DIRTY);
                bufferedSink.writeByte(32);
                bufferedSink.writeUtf8(entry.getKey$okhttp());
                bufferedSink.writeByte(10);
                bufferedSink.flush();
            }
            if (entry.getLockingSourceCount$okhttp() > 0 || entry.getCurrentEditor$okhttp() != null) {
                entry.setZombie$okhttp(true);
                return true;
            }
        }
        Editor currentEditor$okhttp = entry.getCurrentEditor$okhttp();
        if (currentEditor$okhttp != null) {
            currentEditor$okhttp.detach$okhttp();
        }
        int i6 = this.valueCount;
        for (int i7 = 0; i7 < i6; i7++) {
            _UtilCommonKt.deleteIfExists(this.fileSystem, entry.getCleanFiles$okhttp().get(i7));
            this.size -= entry.getLengths$okhttp()[i7];
            entry.getLengths$okhttp()[i7] = 0;
        }
        this.redundantOpCount++;
        BufferedSink bufferedSink2 = this.journalWriter;
        if (bufferedSink2 != null) {
            bufferedSink2.writeUtf8(REMOVE);
            bufferedSink2.writeByte(32);
            bufferedSink2.writeUtf8(entry.getKey$okhttp());
            bufferedSink2.writeByte(10);
        }
        this.lruEntries.remove(entry.getKey$okhttp());
        if (journalRebuildRequired()) {
            TaskQueue.schedule$default(this.cleanupQueue, this.cleanupTask, 0L, 2, null);
        }
        return true;
    }

    public final void setClosed$okhttp(boolean z5) {
        this.closed = z5;
    }

    public final void trimToSize() throws IOException {
        while (this.size > this.maxSize) {
            if (!removeOldestEntry()) {
                return;
            }
        }
        this.mostRecentTrimFailed = false;
    }

    public final void delete() throws IOException {
        close();
        _UtilCommonKt.deleteContents(this.fileSystem, this.directory);
    }
}
