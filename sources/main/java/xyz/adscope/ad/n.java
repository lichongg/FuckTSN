package xyz.adscope.ad;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import com.stub.StubApp;
import java.lang.ref.WeakReference;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public abstract class n extends Handler {

    /* renamed from: a, reason: collision with root package name */
    private final WeakReference<Context> f55659a;

    public abstract void a(Message message);

    public n(Context context) {
        super(Looper.getMainLooper());
        this.f55659a = new WeakReference<>(StubApp.getOrigApplicationContext(context.getApplicationContext()));
    }

    @Override // android.os.Handler
    public void handleMessage(@NonNull Message message) {
        super.handleMessage(message);
        if (this.f55659a.get() != null) {
            a(message);
        }
    }
}
