package okhttp3.internal.http2;

import kotlin.jvm.internal.g0;
import okhttp3.internal.http2.flowcontrol.WindowCounter;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public interface FlowControlListener {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class None implements FlowControlListener {

        @NotNull
        public static final None INSTANCE = new None();

        @Override // okhttp3.internal.http2.FlowControlListener
        public void receivingConnectionWindowChanged(@NotNull WindowCounter windowCounter) {
            g0.p(windowCounter, "windowCounter");
        }

        @Override // okhttp3.internal.http2.FlowControlListener
        public void receivingStreamWindowChanged(int i6, @NotNull WindowCounter windowCounter, long j6) {
            g0.p(windowCounter, "windowCounter");
        }

        private None() {
        }
    }

    void receivingConnectionWindowChanged(@NotNull WindowCounter windowCounter);

    void receivingStreamWindowChanged(int i6, @NotNull WindowCounter windowCounter, long j6);
}
