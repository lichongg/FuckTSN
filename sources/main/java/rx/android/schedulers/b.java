package rx.android.schedulers;

import android.os.Handler;
import rx.h;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Deprecated
/* loaded from: D:\Downloads\app\classes7.dex */
public final class b extends c {
    @Deprecated
    public static b e(Handler handler) {
        if (handler != null) {
            return new b(handler);
        }
        throw new NullPointerException("handler == null");
    }

    private b(Handler handler) {
        super(handler);
    }

    @Override // rx.android.schedulers.c, rx.h
    public /* bridge */ /* synthetic */ h.a a() {
        return super.a();
    }
}
