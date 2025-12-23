package pl.droidsonroids.gif;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import java.lang.ref.WeakReference;
import java.util.Iterator;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
class m extends Handler {

    /* renamed from: b, reason: collision with root package name */
    static final int f51854b = -1;

    /* renamed from: a, reason: collision with root package name */
    private final WeakReference<e> f51855a;

    @Override // android.os.Handler
    public void handleMessage(@NonNull Message message) {
        e eVar = this.f51855a.get();
        if (eVar == null) {
            return;
        }
        if (message.what == -1) {
            eVar.invalidateSelf();
            return;
        }
        Iterator<a> it = eVar.f51810h.iterator();
        while (it.hasNext()) {
            it.next().a(message.what);
        }
    }

    m(e eVar) {
        super(Looper.getMainLooper());
        this.f51855a = new WeakReference<>(eVar);
    }
}
