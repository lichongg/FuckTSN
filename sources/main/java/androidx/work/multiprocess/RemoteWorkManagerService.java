package androidx.work.multiprocess;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.work.Logger;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: D:\Downloads\app\classes.dex */
public class RemoteWorkManagerService extends Service {
    static final String TAG = Logger.tagWithPrefix("RemoteWorkManagerService");
    private IBinder mBinder;

    @Override // android.app.Service
    @Nullable
    public IBinder onBind(@NonNull Intent intent) {
        Logger.get().info(TAG, "Binding to RemoteWorkManager", new Throwable[0]);
        return this.mBinder;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        this.mBinder = new RemoteWorkManagerImpl(this);
    }
}
