package okhttp3.internal.publicsuffix;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.io.b;
import kotlin.jvm.internal.g0;
import kotlin.n1;
import okio.BufferedSource;
import okio.ByteString;
import okio.Okio;
import okio.Source;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public abstract class BasePublicSuffixList implements PublicSuffixList {
    public ByteString bytes;
    public ByteString exceptionBytes;

    @NotNull
    private final AtomicBoolean listRead = new AtomicBoolean(false);

    @NotNull
    private final CountDownLatch readCompleteLatch = new CountDownLatch(1);

    @Nullable
    private IOException readFailure;

    private final void readTheListUninterruptibly() {
        boolean z5 = false;
        while (true) {
            try {
                try {
                    readTheList();
                    break;
                } catch (InterruptedIOException unused) {
                    Thread.interrupted();
                    z5 = true;
                } catch (IOException e6) {
                    this.readFailure = e6;
                    if (!z5) {
                        return;
                    }
                }
            } finally {
                if (z5) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    @NotNull
    public abstract Object getPath();

    @NotNull
    public abstract Source listSource();

    @Override // okhttp3.internal.publicsuffix.PublicSuffixList
    public void ensureLoaded() {
        if (this.listRead.get() || !this.listRead.compareAndSet(false, true)) {
            try {
                this.readCompleteLatch.await();
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        } else {
            readTheListUninterruptibly();
        }
        if (this.bytes != null) {
            return;
        }
        IllegalStateException illegalStateException = new IllegalStateException("Unable to load " + getPath() + " resource.");
        illegalStateException.initCause(this.readFailure);
        throw illegalStateException;
    }

    @Override // okhttp3.internal.publicsuffix.PublicSuffixList
    @NotNull
    public ByteString getBytes() {
        ByteString byteString = this.bytes;
        if (byteString != null) {
            return byteString;
        }
        g0.S("bytes");
        return null;
    }

    @Override // okhttp3.internal.publicsuffix.PublicSuffixList
    @NotNull
    public ByteString getExceptionBytes() {
        ByteString byteString = this.exceptionBytes;
        if (byteString != null) {
            return byteString;
        }
        g0.S("exceptionBytes");
        return null;
    }

    public void setBytes(@NotNull ByteString byteString) {
        g0.p(byteString, "<set-?>");
        this.bytes = byteString;
    }

    public void setExceptionBytes(@NotNull ByteString byteString) {
        g0.p(byteString, "<set-?>");
        this.exceptionBytes = byteString;
    }

    private final void readTheList() throws IOException {
        try {
            BufferedSource buffer = Okio.buffer(listSource());
            try {
                ByteString readByteString = buffer.readByteString(buffer.readInt());
                ByteString readByteString2 = buffer.readByteString(buffer.readInt());
                n1 n1Var = n1.f44123a;
                b.a(buffer, null);
                synchronized (this) {
                    g0.m(readByteString);
                    setBytes(readByteString);
                    g0.m(readByteString2);
                    setExceptionBytes(readByteString2);
                }
            } finally {
            }
        } finally {
            this.readCompleteLatch.countDown();
        }
    }
}
