package androidx.fragment.app;

import java.io.Writer;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
final class LogWriter extends Writer {
    private StringBuilder mBuilder = new StringBuilder(128);
    private final String mTag;

    @Override // java.io.Writer
    public void write(char[] cArr, int i6, int i7) {
        for (int i8 = 0; i8 < i7; i8++) {
            char c6 = cArr[i6 + i8];
            if (c6 == '\n') {
                flushBuilder();
            } else {
                this.mBuilder.append(c6);
            }
        }
    }

    private void flushBuilder() {
        if (this.mBuilder.length() > 0) {
            this.mBuilder.toString();
            StringBuilder sb = this.mBuilder;
            sb.delete(0, sb.length());
        }
    }

    LogWriter(String str) {
        this.mTag = str;
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        flushBuilder();
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() {
        flushBuilder();
    }
}
