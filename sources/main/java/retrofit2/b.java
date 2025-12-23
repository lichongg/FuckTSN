package retrofit2;

import java.io.IOException;
import okhttp3.Request;
import okio.Timeout;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public interface b<T> extends Cloneable {
    void cancel();

    /* renamed from: clone */
    b<T> mo320clone();

    c0<T> execute() throws IOException;

    boolean isCanceled();

    boolean isExecuted();

    void j(d<T> dVar);

    Request request();

    Timeout timeout();
}
