package javax.mail.internet;

import java.io.InputStream;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public interface SharedInputStream {
    long getPosition();

    InputStream newStream(long j6, long j7);
}
