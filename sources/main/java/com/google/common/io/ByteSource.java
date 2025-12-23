package com.google.common.io;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Ascii;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.hash.Funnels;
import com.google.common.hash.HashCode;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hasher;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@GwtIncompatible
/* loaded from: D:\Downloads\app\classes5.dex */
public abstract class ByteSource {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class AsCharSource extends CharSource {
        final Charset charset;

        AsCharSource(Charset charset) {
            this.charset = (Charset) Preconditions.checkNotNull(charset);
        }

        @Override // com.google.common.io.CharSource
        public ByteSource asByteSource(Charset charset) {
            return charset.equals(this.charset) ? ByteSource.this : super.asByteSource(charset);
        }

        @Override // com.google.common.io.CharSource
        public Reader openStream() throws IOException {
            return new InputStreamReader(ByteSource.this.openStream(), this.charset);
        }

        @Override // com.google.common.io.CharSource
        public String read() throws IOException {
            return new String(ByteSource.this.read(), this.charset);
        }

        public String toString() {
            return ByteSource.this.toString() + ".asCharSource(" + this.charset + ")";
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class ByteArrayByteSource extends ByteSource {
        final byte[] bytes;
        final int length;
        final int offset;

        ByteArrayByteSource(byte[] bArr) {
            this(bArr, 0, bArr.length);
        }

        @Override // com.google.common.io.ByteSource
        public byte[] read() {
            byte[] bArr = this.bytes;
            int i6 = this.offset;
            return Arrays.copyOfRange(bArr, i6, this.length + i6);
        }

        @Override // com.google.common.io.ByteSource
        public ByteSource slice(long j6, long j7) {
            Preconditions.checkArgument(j6 >= 0, "offset (%s) may not be negative", j6);
            Preconditions.checkArgument(j7 >= 0, "length (%s) may not be negative", j7);
            long min = Math.min(j6, this.length);
            return new ByteArrayByteSource(this.bytes, this.offset + ((int) min), (int) Math.min(j7, this.length - min));
        }

        ByteArrayByteSource(byte[] bArr, int i6, int i7) {
            this.bytes = bArr;
            this.offset = i6;
            this.length = i7;
        }

        @Override // com.google.common.io.ByteSource
        public long copyTo(OutputStream outputStream) throws IOException {
            outputStream.write(this.bytes, this.offset, this.length);
            return this.length;
        }

        @Override // com.google.common.io.ByteSource
        public HashCode hash(HashFunction hashFunction) throws IOException {
            return hashFunction.hashBytes(this.bytes, this.offset, this.length);
        }

        @Override // com.google.common.io.ByteSource
        public boolean isEmpty() {
            return this.length == 0;
        }

        @Override // com.google.common.io.ByteSource
        public InputStream openStream() {
            return new ByteArrayInputStream(this.bytes, this.offset, this.length);
        }

        @Override // com.google.common.io.ByteSource
        public <T> T read(ByteProcessor<T> byteProcessor) throws IOException {
            byteProcessor.processBytes(this.bytes, this.offset, this.length);
            return byteProcessor.getResult();
        }

        @Override // com.google.common.io.ByteSource
        public long size() {
            return this.length;
        }

        @Override // com.google.common.io.ByteSource
        public Optional<Long> sizeIfKnown() {
            return Optional.of(Long.valueOf(this.length));
        }

        public String toString() {
            return "ByteSource.wrap(" + Ascii.truncate(BaseEncoding.base16().encode(this.bytes, this.offset, this.length), 30, "...") + ")";
        }

        @Override // com.google.common.io.ByteSource
        public InputStream openBufferedStream() throws IOException {
            return openStream();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class ConcatenatedByteSource extends ByteSource {
        final Iterable<? extends ByteSource> sources;

        @Override // com.google.common.io.ByteSource
        public boolean isEmpty() throws IOException {
            Iterator<? extends ByteSource> it = this.sources.iterator();
            while (it.hasNext()) {
                if (!it.next().isEmpty()) {
                    return false;
                }
            }
            return true;
        }

        @Override // com.google.common.io.ByteSource
        public InputStream openStream() throws IOException {
            return new MultiInputStream(this.sources.iterator());
        }

        @Override // com.google.common.io.ByteSource
        public long size() throws IOException {
            Iterator<? extends ByteSource> it = this.sources.iterator();
            long j6 = 0;
            while (it.hasNext()) {
                j6 += it.next().size();
                if (j6 < 0) {
                    return Long.MAX_VALUE;
                }
            }
            return j6;
        }

        @Override // com.google.common.io.ByteSource
        public Optional<Long> sizeIfKnown() {
            Iterable<? extends ByteSource> iterable = this.sources;
            if (!(iterable instanceof Collection)) {
                return Optional.absent();
            }
            Iterator<? extends ByteSource> it = iterable.iterator();
            long j6 = 0;
            while (it.hasNext()) {
                Optional<Long> sizeIfKnown = it.next().sizeIfKnown();
                if (!sizeIfKnown.isPresent()) {
                    return Optional.absent();
                }
                j6 += sizeIfKnown.get().longValue();
                if (j6 < 0) {
                    return Optional.of(Long.MAX_VALUE);
                }
            }
            return Optional.of(Long.valueOf(j6));
        }

        public String toString() {
            return "ByteSource.concat(" + this.sources + ")";
        }

        ConcatenatedByteSource(Iterable<? extends ByteSource> iterable) {
            this.sources = (Iterable) Preconditions.checkNotNull(iterable);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class EmptyByteSource extends ByteArrayByteSource {
        static final EmptyByteSource INSTANCE = new EmptyByteSource();

        EmptyByteSource() {
            super(new byte[0]);
        }

        @Override // com.google.common.io.ByteSource.ByteArrayByteSource, com.google.common.io.ByteSource
        public byte[] read() {
            return this.bytes;
        }

        @Override // com.google.common.io.ByteSource.ByteArrayByteSource
        public String toString() {
            return "ByteSource.empty()";
        }

        @Override // com.google.common.io.ByteSource
        public CharSource asCharSource(Charset charset) {
            Preconditions.checkNotNull(charset);
            return CharSource.empty();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private final class SlicedByteSource extends ByteSource {
        final long length;
        final long offset;

        @Override // com.google.common.io.ByteSource
        public ByteSource slice(long j6, long j7) {
            Preconditions.checkArgument(j6 >= 0, "offset (%s) may not be negative", j6);
            Preconditions.checkArgument(j7 >= 0, "length (%s) may not be negative", j7);
            return ByteSource.this.slice(this.offset + j6, Math.min(j7, this.length - j6));
        }

        SlicedByteSource(long j6, long j7) {
            Preconditions.checkArgument(j6 >= 0, "offset (%s) may not be negative", j6);
            Preconditions.checkArgument(j7 >= 0, "length (%s) may not be negative", j7);
            this.offset = j6;
            this.length = j7;
        }

        private InputStream sliceStream(InputStream inputStream) throws IOException {
            long j6 = this.offset;
            if (j6 > 0) {
                try {
                    if (ByteStreams.skipUpTo(inputStream, j6) < this.offset) {
                        inputStream.close();
                        return new ByteArrayInputStream(new byte[0]);
                    }
                } finally {
                }
            }
            return ByteStreams.limit(inputStream, this.length);
        }

        @Override // com.google.common.io.ByteSource
        public boolean isEmpty() throws IOException {
            return this.length == 0 || super.isEmpty();
        }

        @Override // com.google.common.io.ByteSource
        public InputStream openBufferedStream() throws IOException {
            return sliceStream(ByteSource.this.openBufferedStream());
        }

        @Override // com.google.common.io.ByteSource
        public InputStream openStream() throws IOException {
            return sliceStream(ByteSource.this.openStream());
        }

        @Override // com.google.common.io.ByteSource
        public Optional<Long> sizeIfKnown() {
            Optional<Long> sizeIfKnown = ByteSource.this.sizeIfKnown();
            if (!sizeIfKnown.isPresent()) {
                return Optional.absent();
            }
            long longValue = sizeIfKnown.get().longValue();
            return Optional.of(Long.valueOf(Math.min(this.length, longValue - Math.min(this.offset, longValue))));
        }

        public String toString() {
            return ByteSource.this.toString() + ".slice(" + this.offset + ", " + this.length + ")";
        }
    }

    public static ByteSource concat(Iterable<? extends ByteSource> iterable) {
        return new ConcatenatedByteSource(iterable);
    }

    @CanIgnoreReturnValue
    public long copyTo(OutputStream outputStream) throws IOException {
        Preconditions.checkNotNull(outputStream);
        try {
            return ByteStreams.copy((InputStream) Closer.create().register(openStream()), outputStream);
        } finally {
        }
    }

    public abstract InputStream openStream() throws IOException;

    public byte[] read() throws IOException {
        Closer create = Closer.create();
        try {
            InputStream inputStream = (InputStream) create.register(openStream());
            Optional<Long> sizeIfKnown = sizeIfKnown();
            return sizeIfKnown.isPresent() ? ByteStreams.toByteArray(inputStream, sizeIfKnown.get().longValue()) : ByteStreams.toByteArray(inputStream);
        } catch (Throwable th) {
            try {
                throw create.rethrow(th);
            } finally {
                create.close();
            }
        }
    }

    public static ByteSource concat(Iterator<? extends ByteSource> it) {
        return concat(ImmutableList.copyOf(it));
    }

    private long countBySkipping(InputStream inputStream) throws IOException {
        long j6 = 0;
        while (true) {
            long skipUpTo = ByteStreams.skipUpTo(inputStream, 2147483647L);
            if (skipUpTo <= 0) {
                return j6;
            }
            j6 += skipUpTo;
        }
    }

    public static ByteSource empty() {
        return EmptyByteSource.INSTANCE;
    }

    public static ByteSource wrap(byte[] bArr) {
        return new ByteArrayByteSource(bArr);
    }

    public CharSource asCharSource(Charset charset) {
        return new AsCharSource(charset);
    }

    public ByteSource slice(long j6, long j7) {
        return new SlicedByteSource(j6, j7);
    }

    protected ByteSource() {
    }

    public static ByteSource concat(ByteSource... byteSourceArr) {
        return concat(ImmutableList.copyOf(byteSourceArr));
    }

    public boolean contentEquals(ByteSource byteSource) throws IOException {
        int read;
        Preconditions.checkNotNull(byteSource);
        byte[] createBuffer = ByteStreams.createBuffer();
        byte[] createBuffer2 = ByteStreams.createBuffer();
        Closer create = Closer.create();
        try {
            InputStream inputStream = (InputStream) create.register(openStream());
            InputStream inputStream2 = (InputStream) create.register(byteSource.openStream());
            do {
                read = ByteStreams.read(inputStream, createBuffer, 0, createBuffer.length);
                if (read == ByteStreams.read(inputStream2, createBuffer2, 0, createBuffer2.length) && Arrays.equals(createBuffer, createBuffer2)) {
                }
                return false;
            } while (read == createBuffer.length);
            create.close();
            return true;
        } finally {
        }
    }

    public HashCode hash(HashFunction hashFunction) throws IOException {
        Hasher newHasher = hashFunction.newHasher();
        copyTo(Funnels.asOutputStream(newHasher));
        return newHasher.hash();
    }

    public boolean isEmpty() throws IOException {
        Optional<Long> sizeIfKnown = sizeIfKnown();
        boolean z5 = false;
        if (sizeIfKnown.isPresent()) {
            if (sizeIfKnown.get().longValue() != 0) {
                return false;
            }
            return true;
        }
        try {
            if (((InputStream) Closer.create().register(openStream())).read() == -1) {
                z5 = true;
            }
            return z5;
        } finally {
        }
    }

    public InputStream openBufferedStream() throws IOException {
        InputStream openStream = openStream();
        if (openStream instanceof BufferedInputStream) {
            return (BufferedInputStream) openStream;
        }
        return new BufferedInputStream(openStream);
    }

    public long size() throws IOException {
        Optional<Long> sizeIfKnown = sizeIfKnown();
        if (sizeIfKnown.isPresent()) {
            return sizeIfKnown.get().longValue();
        }
        Closer create = Closer.create();
        try {
            return countBySkipping((InputStream) create.register(openStream()));
        } catch (IOException unused) {
            create.close();
            try {
                return ByteStreams.exhaust((InputStream) Closer.create().register(openStream()));
            } finally {
            }
        } finally {
        }
    }

    @Beta
    public Optional<Long> sizeIfKnown() {
        return Optional.absent();
    }

    @CanIgnoreReturnValue
    public long copyTo(ByteSink byteSink) throws IOException {
        Preconditions.checkNotNull(byteSink);
        Closer create = Closer.create();
        try {
            return ByteStreams.copy((InputStream) create.register(openStream()), (OutputStream) create.register(byteSink.openStream()));
        } finally {
        }
    }

    @CanIgnoreReturnValue
    @Beta
    public <T> T read(ByteProcessor<T> byteProcessor) throws IOException {
        Preconditions.checkNotNull(byteProcessor);
        try {
            return (T) ByteStreams.readBytes((InputStream) Closer.create().register(openStream()), byteProcessor);
        } finally {
        }
    }
}
