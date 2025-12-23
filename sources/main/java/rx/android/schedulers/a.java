package rx.android.schedulers;

import android.os.Looper;
import rx.h;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class a {

    /* renamed from: b, reason: collision with root package name */
    private static final a f52253b = new a();

    /* renamed from: a, reason: collision with root package name */
    private final h f52254a;

    public static h a(Looper looper) {
        if (looper != null) {
            return new c(looper);
        }
        throw new NullPointerException("looper == null");
    }

    public static h b() {
        return f52253b.f52254a;
    }

    private a() {
        h b6 = rx.android.plugins.a.a().b().b();
        if (b6 != null) {
            this.f52254a = b6;
        } else {
            this.f52254a = new c(Looper.getMainLooper());
        }
    }
}
