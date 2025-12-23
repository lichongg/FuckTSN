package okhttp3.internal.connection;

import kotlin.jvm.JvmField;
import kotlin.jvm.internal.v;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class AddressPolicy {

    @JvmField
    public final long backoffDelayMillis;

    @JvmField
    public final int backoffJitterMillis;

    @JvmField
    public final int minimumConcurrentCalls;

    public AddressPolicy() {
        this(0, 0L, 0, 7, null);
    }

    public AddressPolicy(int i6, long j6, int i7) {
        this.minimumConcurrentCalls = i6;
        this.backoffDelayMillis = j6;
        this.backoffJitterMillis = i7;
    }

    public /* synthetic */ AddressPolicy(int i6, long j6, int i7, int i8, v vVar) {
        this((i8 & 1) != 0 ? 0 : i6, (i8 & 2) != 0 ? 60000L : j6, (i8 & 4) != 0 ? 100 : i7);
    }
}
