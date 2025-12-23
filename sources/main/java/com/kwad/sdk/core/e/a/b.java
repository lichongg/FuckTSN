package com.kwad.sdk.core.e.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.kwad.sdk.core.e.a.c;
import com.kwad.sdk.core.e.b.b;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class b {
    private Context mContext;
    private final LinkedBlockingQueue<IBinder> mLinkedBlockingQueue = new LinkedBlockingQueue<>(1);
    private ServiceConnection serviceConnection = new ServiceConnection() { // from class: com.kwad.sdk.core.e.a.b.1
        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                com.kwad.sdk.core.d.c.d("HONORDeviceIDHelper", "onServiceConnected ： " + iBinder);
                b.this.mLinkedBlockingQueue.put(iBinder);
            } catch (Exception e6) {
                com.kwad.sdk.core.d.c.d("HONORDeviceIDHelper", e6);
            }
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
        }
    };

    private c.C0685c Ii() {
        Context context;
        c cVar = new c();
        cVar.mContext = this.mContext;
        try {
            Intent intent = new Intent();
            intent.setAction("com.hihonor.id.HnOaIdService");
            intent.setPackage("com.hihonor.id");
            if (c.isAdvertisingIdAvailable(this.mContext) && this.mContext.bindService(intent, this.serviceConnection, 1)) {
                try {
                    try {
                        cVar.aFR = new c.C0685c();
                        b.a aVar = new b.a(this.mLinkedBlockingQueue.take());
                        aVar.a(cVar.aFS);
                        aVar.b(cVar.aFT);
                        cVar.mCountDownLatch.await(3000L, TimeUnit.MICROSECONDS);
                        context = this.mContext;
                    } catch (Throwable th) {
                        this.mContext.unbindService(this.serviceConnection);
                        throw th;
                    }
                } catch (Exception e6) {
                    com.kwad.sdk.core.d.c.d("HONORDeviceIDHelper", e6);
                    context = this.mContext;
                }
                context.unbindService(this.serviceConnection);
            }
        } catch (Throwable th2) {
            com.kwad.sdk.core.d.c.d("HONORDeviceIDHelper", "getOAID honor service not found" + th2);
        }
        return cVar.aFR;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x004c A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String getOAID() {
        /*
            r5 = this;
            java.lang.String r0 = "oaid"
            java.lang.String r1 = ""
            android.content.Context r2 = r5.mContext     // Catch: java.lang.Throwable -> L35
            android.content.ContentResolver r2 = r2.getContentResolver()     // Catch: java.lang.Throwable -> L35
            java.lang.String r2 = android.provider.Settings.Global.getString(r2, r0)     // Catch: java.lang.Throwable -> L35
            boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch: java.lang.Throwable -> L1f
            if (r3 == 0) goto L21
            android.content.Context r3 = r5.mContext     // Catch: java.lang.Throwable -> L1f
            android.content.ContentResolver r3 = r3.getContentResolver()     // Catch: java.lang.Throwable -> L1f
            java.lang.String r2 = android.provider.Settings.Secure.getString(r3, r0)     // Catch: java.lang.Throwable -> L1f
            goto L21
        L1f:
            r0 = move-exception
            goto L37
        L21:
            java.lang.String r0 = "HONORDeviceIDHelper"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L1f
            java.lang.String r4 = "getOAID secure: "
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L1f
            r3.append(r2)     // Catch: java.lang.Throwable -> L1f
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Throwable -> L1f
            com.kwad.sdk.core.d.c.i(r0, r3)     // Catch: java.lang.Throwable -> L1f
            goto L3a
        L35:
            r0 = move-exception
            r2 = r1
        L37:
            com.kwad.sdk.core.d.c.printStackTrace(r0)
        L3a:
            if (r2 == 0) goto L43
            boolean r0 = r2.isEmpty()
            if (r0 != 0) goto L43
            return r2
        L43:
            com.kwad.sdk.core.e.a.c$c r0 = r5.Ii()
            if (r0 == 0) goto L4c
            java.lang.String r0 = r0.aoB
            return r0
        L4c:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.core.e.a.b.getOAID():java.lang.String");
    }

    public b(Context context) {
        this.mContext = context;
    }
}
