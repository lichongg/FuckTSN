package xyz.adscope.common.v2.handle;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import com.stub.StubApp;
import java.lang.ref.WeakReference;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public abstract class WeakReferenceHandler extends Handler {
    private final WeakReference<Context> weakContext;

    public abstract void scopeHandleMessage(Message message);

    public Context getContext() {
        WeakReference<Context> weakReference = this.weakContext;
        if (weakReference == null || weakReference.get() == null) {
            return null;
        }
        return this.weakContext.get();
    }

    public WeakReferenceHandler(Context context) {
        super(Looper.getMainLooper());
        this.weakContext = new WeakReference<>(StubApp.getOrigApplicationContext(context.getApplicationContext()));
    }

    @Override // android.os.Handler
    public void handleMessage(@NonNull Message message) {
        super.handleMessage(message);
        if (this.weakContext.get() != null) {
            scopeHandleMessage(message);
        }
    }
}
