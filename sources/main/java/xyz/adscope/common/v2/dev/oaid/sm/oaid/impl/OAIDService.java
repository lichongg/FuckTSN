package xyz.adscope.common.v2.dev.oaid.sm.oaid.impl;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.stub.StubApp;
import xyz.adscope.common.v2.dev.oaid.sm.oaid.IGetter;
import xyz.adscope.common.v2.dev.oaid.sm.oaid.OAIDException;
import xyz.adscope.common.v2.dev.oaid.sm.oaid.OAIDLog;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
class OAIDService implements ServiceConnection {
    private final RemoteCaller caller;
    private final Context context;
    private final IGetter getter;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @FunctionalInterface
    public interface RemoteCaller {
        String callRemoteInterface(IBinder iBinder);
    }

    public static void bind(Context context, Intent intent, IGetter iGetter, RemoteCaller remoteCaller) {
        new OAIDService(context, iGetter, remoteCaller).bind(intent);
    }

    private void bind(Intent intent) {
        try {
            if (!this.context.bindService(intent, this, 1)) {
                throw new OAIDException("Service binding failed");
            }
            OAIDLog.print("Service has been bound: " + intent);
        } catch (Exception e6) {
            this.getter.onOAIDGetError(e6);
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        OAIDLog.print("Service has been connected: " + componentName.getClassName());
        try {
            try {
                String callRemoteInterface = this.caller.callRemoteInterface(iBinder);
                if (callRemoteInterface == null || callRemoteInterface.length() == 0) {
                    throw new OAIDException("OAID acquire failed");
                }
                OAIDLog.print("OAID acquire success: " + callRemoteInterface);
                this.getter.onOAIDGetComplete(callRemoteInterface);
            } catch (Exception e6) {
                OAIDLog.print(e6);
                this.getter.onOAIDGetError(e6);
                try {
                    this.context.unbindService(this);
                    OAIDLog.print("Service has been unbound: " + componentName.getClassName());
                } catch (Exception e7) {
                    OAIDLog.print(e7);
                }
            }
        } finally {
            try {
                this.context.unbindService(this);
                OAIDLog.print("Service has been unbound: " + componentName.getClassName());
            } catch (Exception e8) {
                OAIDLog.print(e8);
            }
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        OAIDLog.print("Service has been disconnected: " + componentName.getClassName());
    }

    private OAIDService(Context context, IGetter iGetter, RemoteCaller remoteCaller) {
        if (context instanceof Application) {
            this.context = context;
        } else {
            this.context = StubApp.getOrigApplicationContext(context.getApplicationContext());
        }
        this.getter = iGetter;
        this.caller = remoteCaller;
    }
}
