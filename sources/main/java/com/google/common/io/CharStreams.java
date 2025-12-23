package com.google.common.io;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.CharBuffer;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@GwtIncompatible
/* loaded from: D:\Downloads\app\classes5.dex */
public final class CharStreams {
    private static final int DEFAULT_BUF_SIZE = 2048;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class NullWriter extends Writer {
        private static final NullWriter INSTANCE = new NullWriter();

        @Override // java.io.Writer, java.lang.Appendable
        public Writer append(char c6) {
            return this;
        }

        @Override // java.io.Writer
        public void write(int i6) {
        }

        public String toString() {
            return "CharStreams.nullWriter()";
        }

        @Override // java.io.Writer
        public void write(char[] cArr) {
            Preconditions.checkNotNull(cArr);
        }

        private NullWriter() {
        }

        @Override // java.io.Writer
        public void write(char[] cArr, int i6, int i7) {
            Preconditions.checkPositionIndexes(i6, i7 + i6, cArr.length);
        }

        @Override // java.io.Writer
        public void write(String str) {
            Preconditions.checkNotNull(str);
        }

        @Override // java.io.Writer, java.lang.Appendable
        public Writer append(CharSequence charSequence) {
            Preconditions.checkNotNull(charSequence);
            return this;
        }

        @Override // java.io.Writer
        public void write(String str, int i6, int i7) {
            Preconditions.checkPositionIndexes(i6, i7 + i6, str.length());
        }

        @Override // java.io.Writer, java.lang.Appendable
        public Writer append(CharSequence charSequence, int i6, int i7) {
            Preconditions.checkPositionIndexes(i6, i7, charSequence.length());
            return this;
        }

        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // java.io.Writer, java.io.Flushable
        public void flush() {
        }
    }

    @Beta
    public static List<String> readLines(Readable readable) throws IOException {
        ArrayList arrayList = new ArrayList();
        LineReader lineReader = new LineReader(readable);
        while (true) {
            String readLine = lineReader.readLine();
            if (readLine == null) {
                return arrayList;
            }
            arrayList.add(readLine);
        }
    }

    @Beta
    public static Writer asWriter(Appendable appendable) {
        return appendable instanceof Writer ? (Writer) appendable : new AppendableWriter(appendable);
    }

    @CanIgnoreReturnValue
    public static long copy(Readable readable, Appendable appendable) throws IOException {
        if (readable instanceof Reader) {
            return appendable instanceof StringBuilder ? copyReaderToBuilder((Reader) readable, (StringBuilder) appendable) : copyReaderToWriter((Reader) readable, asWriter(appendable));
        }
        Preconditions.checkNotNull(readable);
        Preconditions.checkNotNull(appendable);
        CharBuffer createBuffer = createBuffer();
        long j6 = 0;
        while (readable.read(createBuffer) != -1) {
            createBuffer.flip();
            appendable.append(createBuffer);
            j6 += createBuffer.remaining();
            createBuffer.clear();
        }
        return j6;
    }

    static CharBuffer createBuffer() {
        return CharBuffer.allocate(2048);
    }

    private static StringBuilder toStringBuilder(Readable readable) throws IOException {
        StringBuilder sb = new StringBuilder();
        if (readable instanceof Reader) {
            copyReaderToBuilder((Reader) readable, sb);
            return sb;
        }
        copy(readable, sb);
        return sb;
    }

    private CharStreams() {
    }

    @CanIgnoreReturnValue
    static long copyReaderToBuilder(Reader reader, StringBuilder sb) throws IOException {
        Preconditions.checkNotNull(reader);
        Preconditions.checkNotNull(sb);
        char[] cArr = new char[2048];
        long j6 = 0;
        while (true) {
            int read = reader.read(cArr);
            if (read != -1) {
                sb.append(cArr, 0, read);
                j6 += read;
            } else {
                return j6;
            }
        }
    }

    @CanIgnoreReturnValue
    static long copyReaderToWriter(Reader reader, Writer writer) throws IOException {
        Preconditions.checkNotNull(reader);
        Preconditions.checkNotNull(writer);
        char[] cArr = new char[2048];
        long j6 = 0;
        while (true) {
            int read = reader.read(cArr);
            if (read != -1) {
                writer.write(cArr, 0, read);
                j6 += read;
            } else {
                return j6;
            }
        }
    }

    @CanIgnoreReturnValue
    @Beta
    public static long exhaust(Readable readable) throws IOException {
        CharBuffer createBuffer = createBuffer();
        long j6 = 0;
        while (true) {
            long read = readable.read(createBuffer);
            if (read != -1) {
                j6 += read;
                createBuffer.clear();
            } else {
                return j6;
            }
        }
    }

    @Beta
    public static Writer nullWriter() {
        return NullWriter.INSTANCE;
    }

    @Beta
    public static void skipFully(Reader reader, long j6) throws IOException {
        Preconditions.checkNotNull(reader);
        while (j6 > 0) {
            long skip = reader.skip(j6);
            if (skip != 0) {
                j6 -= skip;
            } else {
                throw new EOFException();
            }
        }
    }

    public static String toString(Readable readable) throws IOException {
        return toStringBuilder(readable).toString();
    }

    @CanIgnoreReturnValue
    @Beta
    public static <T> T readLines(Readable readable, LineProcessor<T> lineProcessor) throws IOException {
        String readLine;
        Preconditions.checkNotNull(readable);
        Preconditions.checkNotNull(lineProcessor);
        LineReader lineReader = new LineReader(readable);
        do {
            readLine = lineReader.readLine();
            if (readLine == null) {
                break;
            }
        } while (lineProcessor.processLine(readLine));
        return lineProcessor.getResult();
    }
}
