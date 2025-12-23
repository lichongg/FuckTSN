package com.google.common.io;

import android.support.v4.media.session.PlaybackStateCompat;
import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.math.IntMath;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@GwtIncompatible
/* loaded from: D:\Downloads\app\classes5.dex */
public final class ByteStreams {
    private static final int BUFFER_SIZE = 8192;
    private static final int MAX_ARRAY_LEN = 2147483639;
    private static final OutputStream NULL_OUTPUT_STREAM = new OutputStream() { // from class: com.google.common.io.ByteStreams.1
        @Override // java.io.OutputStream
        public void write(int i6) {
        }

        public String toString() {
            return "ByteStreams.nullOutputStream()";
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr) {
            Preconditions.checkNotNull(bArr);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i6, int i7) {
            Preconditions.checkNotNull(bArr);
        }
    };
    private static final int TO_BYTE_ARRAY_DEQUE_SIZE = 20;
    private static final int ZERO_COPY_CHUNK_SIZE = 524288;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class ByteArrayDataInputStream implements ByteArrayDataInput {
        final DataInput input;

        @Override // com.google.common.io.ByteArrayDataInput, java.io.DataInput
        public void readFully(byte[] bArr) {
            try {
                this.input.readFully(bArr);
            } catch (IOException e6) {
                throw new IllegalStateException(e6);
            }
        }

        @Override // com.google.common.io.ByteArrayDataInput, java.io.DataInput
        public boolean readBoolean() {
            try {
                return this.input.readBoolean();
            } catch (IOException e6) {
                throw new IllegalStateException(e6);
            }
        }

        @Override // com.google.common.io.ByteArrayDataInput, java.io.DataInput
        public byte readByte() {
            try {
                return this.input.readByte();
            } catch (EOFException e6) {
                throw new IllegalStateException(e6);
            } catch (IOException e7) {
                throw new AssertionError(e7);
            }
        }

        @Override // com.google.common.io.ByteArrayDataInput, java.io.DataInput
        public char readChar() {
            try {
                return this.input.readChar();
            } catch (IOException e6) {
                throw new IllegalStateException(e6);
            }
        }

        @Override // com.google.common.io.ByteArrayDataInput, java.io.DataInput
        public double readDouble() {
            try {
                return this.input.readDouble();
            } catch (IOException e6) {
                throw new IllegalStateException(e6);
            }
        }

        @Override // com.google.common.io.ByteArrayDataInput, java.io.DataInput
        public float readFloat() {
            try {
                return this.input.readFloat();
            } catch (IOException e6) {
                throw new IllegalStateException(e6);
            }
        }

        @Override // com.google.common.io.ByteArrayDataInput, java.io.DataInput
        public int readInt() {
            try {
                return this.input.readInt();
            } catch (IOException e6) {
                throw new IllegalStateException(e6);
            }
        }

        @Override // com.google.common.io.ByteArrayDataInput, java.io.DataInput
        public String readLine() {
            try {
                return this.input.readLine();
            } catch (IOException e6) {
                throw new IllegalStateException(e6);
            }
        }

        @Override // com.google.common.io.ByteArrayDataInput, java.io.DataInput
        public long readLong() {
            try {
                return this.input.readLong();
            } catch (IOException e6) {
                throw new IllegalStateException(e6);
            }
        }

        @Override // com.google.common.io.ByteArrayDataInput, java.io.DataInput
        public short readShort() {
            try {
                return this.input.readShort();
            } catch (IOException e6) {
                throw new IllegalStateException(e6);
            }
        }

        @Override // com.google.common.io.ByteArrayDataInput, java.io.DataInput
        public String readUTF() {
            try {
                return this.input.readUTF();
            } catch (IOException e6) {
                throw new IllegalStateException(e6);
            }
        }

        @Override // com.google.common.io.ByteArrayDataInput, java.io.DataInput
        public int readUnsignedByte() {
            try {
                return this.input.readUnsignedByte();
            } catch (IOException e6) {
                throw new IllegalStateException(e6);
            }
        }

        @Override // com.google.common.io.ByteArrayDataInput, java.io.DataInput
        public int readUnsignedShort() {
            try {
                return this.input.readUnsignedShort();
            } catch (IOException e6) {
                throw new IllegalStateException(e6);
            }
        }

        @Override // com.google.common.io.ByteArrayDataInput, java.io.DataInput
        public int skipBytes(int i6) {
            try {
                return this.input.skipBytes(i6);
            } catch (IOException e6) {
                throw new IllegalStateException(e6);
            }
        }

        ByteArrayDataInputStream(ByteArrayInputStream byteArrayInputStream) {
            this.input = new DataInputStream(byteArrayInputStream);
        }

        @Override // com.google.common.io.ByteArrayDataInput, java.io.DataInput
        public void readFully(byte[] bArr, int i6, int i7) {
            try {
                this.input.readFully(bArr, i6, i7);
            } catch (IOException e6) {
                throw new IllegalStateException(e6);
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class ByteArrayDataOutputStream implements ByteArrayDataOutput {
        final ByteArrayOutputStream byteArrayOutputSteam;
        final DataOutput output;

        @Override // com.google.common.io.ByteArrayDataOutput, java.io.DataOutput
        public void write(int i6) {
            try {
                this.output.write(i6);
            } catch (IOException e6) {
                throw new AssertionError(e6);
            }
        }

        @Override // com.google.common.io.ByteArrayDataOutput
        public byte[] toByteArray() {
            return this.byteArrayOutputSteam.toByteArray();
        }

        @Override // com.google.common.io.ByteArrayDataOutput, java.io.DataOutput
        public void writeBoolean(boolean z5) {
            try {
                this.output.writeBoolean(z5);
            } catch (IOException e6) {
                throw new AssertionError(e6);
            }
        }

        @Override // com.google.common.io.ByteArrayDataOutput, java.io.DataOutput
        public void writeByte(int i6) {
            try {
                this.output.writeByte(i6);
            } catch (IOException e6) {
                throw new AssertionError(e6);
            }
        }

        @Override // com.google.common.io.ByteArrayDataOutput, java.io.DataOutput
        public void writeBytes(String str) {
            try {
                this.output.writeBytes(str);
            } catch (IOException e6) {
                throw new AssertionError(e6);
            }
        }

        @Override // com.google.common.io.ByteArrayDataOutput, java.io.DataOutput
        public void writeChar(int i6) {
            try {
                this.output.writeChar(i6);
            } catch (IOException e6) {
                throw new AssertionError(e6);
            }
        }

        @Override // com.google.common.io.ByteArrayDataOutput, java.io.DataOutput
        public void writeChars(String str) {
            try {
                this.output.writeChars(str);
            } catch (IOException e6) {
                throw new AssertionError(e6);
            }
        }

        @Override // com.google.common.io.ByteArrayDataOutput, java.io.DataOutput
        public void writeDouble(double d6) {
            try {
                this.output.writeDouble(d6);
            } catch (IOException e6) {
                throw new AssertionError(e6);
            }
        }

        @Override // com.google.common.io.ByteArrayDataOutput, java.io.DataOutput
        public void writeFloat(float f6) {
            try {
                this.output.writeFloat(f6);
            } catch (IOException e6) {
                throw new AssertionError(e6);
            }
        }

        @Override // com.google.common.io.ByteArrayDataOutput, java.io.DataOutput
        public void writeInt(int i6) {
            try {
                this.output.writeInt(i6);
            } catch (IOException e6) {
                throw new AssertionError(e6);
            }
        }

        @Override // com.google.common.io.ByteArrayDataOutput, java.io.DataOutput
        public void writeLong(long j6) {
            try {
                this.output.writeLong(j6);
            } catch (IOException e6) {
                throw new AssertionError(e6);
            }
        }

        @Override // com.google.common.io.ByteArrayDataOutput, java.io.DataOutput
        public void writeShort(int i6) {
            try {
                this.output.writeShort(i6);
            } catch (IOException e6) {
                throw new AssertionError(e6);
            }
        }

        @Override // com.google.common.io.ByteArrayDataOutput, java.io.DataOutput
        public void writeUTF(String str) {
            try {
                this.output.writeUTF(str);
            } catch (IOException e6) {
                throw new AssertionError(e6);
            }
        }

        ByteArrayDataOutputStream(ByteArrayOutputStream byteArrayOutputStream) {
            this.byteArrayOutputSteam = byteArrayOutputStream;
            this.output = new DataOutputStream(byteArrayOutputStream);
        }

        @Override // com.google.common.io.ByteArrayDataOutput, java.io.DataOutput
        public void write(byte[] bArr) {
            try {
                this.output.write(bArr);
            } catch (IOException e6) {
                throw new AssertionError(e6);
            }
        }

        @Override // com.google.common.io.ByteArrayDataOutput, java.io.DataOutput
        public void write(byte[] bArr, int i6, int i7) {
            try {
                this.output.write(bArr, i6, i7);
            } catch (IOException e6) {
                throw new AssertionError(e6);
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class LimitedInputStream extends FilterInputStream {
        private long left;
        private long mark;

        @Override // java.io.FilterInputStream, java.io.InputStream
        public synchronized void mark(int i6) {
            ((FilterInputStream) this).in.mark(i6);
            this.mark = this.left;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read() throws IOException {
            if (this.left == 0) {
                return -1;
            }
            int read = ((FilterInputStream) this).in.read();
            if (read != -1) {
                this.left--;
            }
            return read;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public synchronized void reset() throws IOException {
            if (!((FilterInputStream) this).in.markSupported()) {
                throw new IOException("Mark not supported");
            }
            if (this.mark == -1) {
                throw new IOException("Mark not set");
            }
            ((FilterInputStream) this).in.reset();
            this.left = this.mark;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int available() throws IOException {
            return (int) Math.min(((FilterInputStream) this).in.available(), this.left);
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public long skip(long j6) throws IOException {
            long skip = ((FilterInputStream) this).in.skip(Math.min(j6, this.left));
            this.left -= skip;
            return skip;
        }

        LimitedInputStream(InputStream inputStream, long j6) {
            super(inputStream);
            boolean z5;
            this.mark = -1L;
            Preconditions.checkNotNull(inputStream);
            if (j6 >= 0) {
                z5 = true;
            } else {
                z5 = false;
            }
            Preconditions.checkArgument(z5, "limit must be non-negative");
            this.left = j6;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read(byte[] bArr, int i6, int i7) throws IOException {
            long j6 = this.left;
            if (j6 == 0) {
                return -1;
            }
            int read = ((FilterInputStream) this).in.read(bArr, i6, (int) Math.min(i7, j6));
            if (read != -1) {
                this.left -= read;
            }
            return read;
        }
    }

    @CanIgnoreReturnValue
    public static long copy(InputStream inputStream, OutputStream outputStream) throws IOException {
        Preconditions.checkNotNull(inputStream);
        Preconditions.checkNotNull(outputStream);
        byte[] createBuffer = createBuffer();
        long j6 = 0;
        while (true) {
            int read = inputStream.read(createBuffer);
            if (read == -1) {
                return j6;
            }
            outputStream.write(createBuffer, 0, read);
            j6 += read;
        }
    }

    @Beta
    public static ByteArrayDataInput newDataInput(byte[] bArr) {
        return newDataInput(new ByteArrayInputStream(bArr));
    }

    @Beta
    public static ByteArrayDataOutput newDataOutput() {
        return newDataOutput(new ByteArrayOutputStream());
    }

    @Beta
    public static void readFully(InputStream inputStream, byte[] bArr) throws IOException {
        readFully(inputStream, bArr, 0, bArr.length);
    }

    public static byte[] toByteArray(InputStream inputStream) throws IOException {
        Preconditions.checkNotNull(inputStream);
        return toByteArrayInternal(inputStream, new ArrayDeque(20), 0);
    }

    private static byte[] combineBuffers(Deque<byte[]> deque, int i6) {
        byte[] bArr = new byte[i6];
        int i7 = i6;
        while (i7 > 0) {
            byte[] removeFirst = deque.removeFirst();
            int min = Math.min(i7, removeFirst.length);
            System.arraycopy(removeFirst, 0, bArr, i6 - i7, min);
            i7 -= min;
        }
        return bArr;
    }

    static byte[] createBuffer() {
        return new byte[8192];
    }

    @Beta
    public static InputStream limit(InputStream inputStream, long j6) {
        return new LimitedInputStream(inputStream, j6);
    }

    @Beta
    public static ByteArrayDataInput newDataInput(byte[] bArr, int i6) {
        Preconditions.checkPositionIndex(i6, bArr.length);
        return newDataInput(new ByteArrayInputStream(bArr, i6, bArr.length - i6));
    }

    @Beta
    public static ByteArrayDataOutput newDataOutput(int i6) {
        if (i6 >= 0) {
            return newDataOutput(new ByteArrayOutputStream(i6));
        }
        throw new IllegalArgumentException(String.format("Invalid size: %s", Integer.valueOf(i6)));
    }

    @Beta
    public static OutputStream nullOutputStream() {
        return NULL_OUTPUT_STREAM;
    }

    @Beta
    public static void readFully(InputStream inputStream, byte[] bArr, int i6, int i7) throws IOException {
        int read = read(inputStream, bArr, i6, i7);
        if (read == i7) {
            return;
        }
        throw new EOFException("reached end of stream after reading " + read + " bytes; " + i7 + " bytes expected");
    }

    private static byte[] toByteArrayInternal(InputStream inputStream, Deque<byte[]> deque, int i6) throws IOException {
        int i7 = 8192;
        while (i6 < MAX_ARRAY_LEN) {
            int min = Math.min(i7, MAX_ARRAY_LEN - i6);
            byte[] bArr = new byte[min];
            deque.add(bArr);
            int i8 = 0;
            while (i8 < min) {
                int read = inputStream.read(bArr, i8, min - i8);
                if (read == -1) {
                    return combineBuffers(deque, i6);
                }
                i8 += read;
                i6 += read;
            }
            i7 = IntMath.saturatedMultiply(i7, 2);
        }
        if (inputStream.read() == -1) {
            return combineBuffers(deque, MAX_ARRAY_LEN);
        }
        throw new OutOfMemoryError("input is too large to fit in a byte array");
    }

    private ByteStreams() {
    }

    @CanIgnoreReturnValue
    @Beta
    public static long exhaust(InputStream inputStream) throws IOException {
        byte[] createBuffer = createBuffer();
        long j6 = 0;
        while (true) {
            long read = inputStream.read(createBuffer);
            if (read != -1) {
                j6 += read;
            } else {
                return j6;
            }
        }
    }

    @CanIgnoreReturnValue
    @Beta
    public static int read(InputStream inputStream, byte[] bArr, int i6, int i7) throws IOException {
        Preconditions.checkNotNull(inputStream);
        Preconditions.checkNotNull(bArr);
        if (i7 >= 0) {
            int i8 = 0;
            while (i8 < i7) {
                int read = inputStream.read(bArr, i6 + i8, i7 - i8);
                if (read == -1) {
                    break;
                }
                i8 += read;
            }
            return i8;
        }
        throw new IndexOutOfBoundsException("len is negative");
    }

    @CanIgnoreReturnValue
    @Beta
    public static <T> T readBytes(InputStream inputStream, ByteProcessor<T> byteProcessor) throws IOException {
        int read;
        Preconditions.checkNotNull(inputStream);
        Preconditions.checkNotNull(byteProcessor);
        byte[] createBuffer = createBuffer();
        do {
            read = inputStream.read(createBuffer);
            if (read == -1) {
                break;
            }
        } while (byteProcessor.processBytes(createBuffer, 0, read));
        return byteProcessor.getResult();
    }

    @Beta
    public static void skipFully(InputStream inputStream, long j6) throws IOException {
        long skipUpTo = skipUpTo(inputStream, j6);
        if (skipUpTo >= j6) {
            return;
        }
        throw new EOFException("reached end of stream after skipping " + skipUpTo + " bytes; " + j6 + " bytes expected");
    }

    private static long skipSafely(InputStream inputStream, long j6) throws IOException {
        int available = inputStream.available();
        if (available == 0) {
            return 0L;
        }
        return inputStream.skip(Math.min(available, j6));
    }

    static long skipUpTo(InputStream inputStream, long j6) throws IOException {
        byte[] createBuffer = createBuffer();
        long j7 = 0;
        while (j7 < j6) {
            long j8 = j6 - j7;
            long skipSafely = skipSafely(inputStream, j8);
            if (skipSafely == 0) {
                skipSafely = inputStream.read(createBuffer, 0, (int) Math.min(j8, createBuffer.length));
                if (skipSafely == -1) {
                    break;
                }
            }
            j7 += skipSafely;
        }
        return j7;
    }

    static byte[] toByteArray(InputStream inputStream, long j6) throws IOException {
        Preconditions.checkArgument(j6 >= 0, "expectedSize (%s) must be non-negative", j6);
        if (j6 <= 2147483639) {
            int i6 = (int) j6;
            byte[] bArr = new byte[i6];
            int i7 = i6;
            while (i7 > 0) {
                int i8 = i6 - i7;
                int read = inputStream.read(bArr, i8, i7);
                if (read == -1) {
                    return Arrays.copyOf(bArr, i8);
                }
                i7 -= read;
            }
            int read2 = inputStream.read();
            if (read2 == -1) {
                return bArr;
            }
            ArrayDeque arrayDeque = new ArrayDeque(22);
            arrayDeque.add(bArr);
            arrayDeque.add(new byte[]{(byte) read2});
            return toByteArrayInternal(inputStream, arrayDeque, i6 + 1);
        }
        throw new OutOfMemoryError(j6 + " bytes is too large to fit in a byte array");
    }

    @Beta
    public static ByteArrayDataInput newDataInput(ByteArrayInputStream byteArrayInputStream) {
        return new ByteArrayDataInputStream((ByteArrayInputStream) Preconditions.checkNotNull(byteArrayInputStream));
    }

    @Beta
    public static ByteArrayDataOutput newDataOutput(ByteArrayOutputStream byteArrayOutputStream) {
        return new ByteArrayDataOutputStream((ByteArrayOutputStream) Preconditions.checkNotNull(byteArrayOutputStream));
    }

    @CanIgnoreReturnValue
    public static long copy(ReadableByteChannel readableByteChannel, WritableByteChannel writableByteChannel) throws IOException {
        Preconditions.checkNotNull(readableByteChannel);
        Preconditions.checkNotNull(writableByteChannel);
        long j6 = 0;
        if (readableByteChannel instanceof FileChannel) {
            FileChannel fileChannel = (FileChannel) readableByteChannel;
            long position = fileChannel.position();
            long j7 = position;
            while (true) {
                WritableByteChannel writableByteChannel2 = writableByteChannel;
                long transferTo = fileChannel.transferTo(j7, PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED, writableByteChannel2);
                j7 += transferTo;
                fileChannel.position(j7);
                if (transferTo <= 0 && j7 >= fileChannel.size()) {
                    return j7 - position;
                }
                writableByteChannel = writableByteChannel2;
            }
        } else {
            ByteBuffer wrap = ByteBuffer.wrap(createBuffer());
            while (readableByteChannel.read(wrap) != -1) {
                wrap.flip();
                while (wrap.hasRemaining()) {
                    j6 += writableByteChannel.write(wrap);
                }
                wrap.clear();
            }
            return j6;
        }
    }
}
