package d5;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.Date;
import org.apache.commons.net.g;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class a extends g {

    /* renamed from: u, reason: collision with root package name */
    public static final int f42990u = 37;

    /* renamed from: v, reason: collision with root package name */
    public static final long f42991v = 2208988800L;

    public Date Z() throws IOException {
        return new Date((a0() - 2208988800L) * 1000);
    }

    public long a0() throws IOException {
        return new DataInputStream(this.f50804h).readInt() & 4294967295L;
    }

    public a() {
        N(37);
    }
}
