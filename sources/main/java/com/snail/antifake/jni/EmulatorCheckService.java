package com.snail.antifake.jni;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.snail.antifake.IEmulatorCheck;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class EmulatorCheckService extends Service {

    /* renamed from: a, reason: collision with root package name */
    Handler f37546a = new Handler();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a extends IEmulatorCheck.Stub {

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        /* renamed from: com.snail.antifake.jni.EmulatorCheckService$a$a, reason: collision with other inner class name */
        class RunnableC0729a implements Runnable {
            @Override // java.lang.Runnable
            public void run() {
                System.exit(0);
            }

            RunnableC0729a() {
            }
        }

        a() {
        }

        @Override // com.snail.antifake.IEmulatorCheck
        public boolean w() throws RemoteException {
            return EmulatorDetectUtil.b(EmulatorCheckService.this);
        }

        @Override // com.snail.antifake.IEmulatorCheck
        public void x() throws RemoteException {
            EmulatorCheckService.this.stopSelf();
            EmulatorCheckService.this.f37546a.postDelayed(new RunnableC0729a(), 500L);
        }
    }

    @Override // android.app.Service
    @Nullable
    public IBinder onBind(Intent intent) {
        return new a();
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
    }
}
