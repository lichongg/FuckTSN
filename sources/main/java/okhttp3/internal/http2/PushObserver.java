package okhttp3.internal.http2;

import java.io.IOException;
import java.util.List;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.g0;
import okio.BufferedSource;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public interface PushObserver {

    @NotNull
    public static final Companion Companion = Companion.$$INSTANCE;

    @JvmField
    @NotNull
    public static final PushObserver CANCEL = new Companion.PushObserverCancel();

    boolean onData(int i6, @NotNull BufferedSource bufferedSource, int i7, boolean z5) throws IOException;

    boolean onHeaders(int i6, @NotNull List<Header> list, boolean z5);

    boolean onRequest(int i6, @NotNull List<Header> list);

    void onReset(int i6, @NotNull ErrorCode errorCode);

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        private static final class PushObserverCancel implements PushObserver {
            @Override // okhttp3.internal.http2.PushObserver
            public boolean onData(int i6, @NotNull BufferedSource source, int i7, boolean z5) throws IOException {
                g0.p(source, "source");
                source.skip(i7);
                return true;
            }

            @Override // okhttp3.internal.http2.PushObserver
            public boolean onHeaders(int i6, @NotNull List<Header> responseHeaders, boolean z5) {
                g0.p(responseHeaders, "responseHeaders");
                return true;
            }

            @Override // okhttp3.internal.http2.PushObserver
            public boolean onRequest(int i6, @NotNull List<Header> requestHeaders) {
                g0.p(requestHeaders, "requestHeaders");
                return true;
            }

            @Override // okhttp3.internal.http2.PushObserver
            public void onReset(int i6, @NotNull ErrorCode errorCode) {
                g0.p(errorCode, "errorCode");
            }
        }

        private Companion() {
        }
    }
}
