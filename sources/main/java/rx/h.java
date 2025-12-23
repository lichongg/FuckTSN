package rx;

import java.util.concurrent.TimeUnit;
import rx.functions.p;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public abstract class h {
    public abstract a a();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static abstract class a implements m {
        public abstract m d(rx.functions.a aVar);

        public abstract m e(rx.functions.a aVar, long j6, TimeUnit timeUnit);

        public m f(rx.functions.a aVar, long j6, long j7, TimeUnit timeUnit) {
            return rx.internal.schedulers.i.a(this, aVar, j6, j7, timeUnit, null);
        }

        public long b() {
            return System.currentTimeMillis();
        }
    }

    public <S extends h & m> S d(p<e<e<b>>, b> pVar) {
        return new rx.internal.schedulers.k(pVar, this);
    }

    public long b() {
        return System.currentTimeMillis();
    }
}
