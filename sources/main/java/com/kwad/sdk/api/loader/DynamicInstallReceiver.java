package com.kwad.sdk.api.loader;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.AsyncTask;
import android.os.Build;
import androidx.annotation.Keep;
import com.stub.StubApp;
import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Keep
/* loaded from: D:\Downloads\app\classes6.dex */
public class DynamicInstallReceiver extends BroadcastReceiver {
    private static final AtomicBoolean HAS_REGISTER = new AtomicBoolean(false);
    private static final String TAG = "KSAd_DYI";

    @Keep
    public static void registerToApp(Context context) {
        if (context != null) {
            AtomicBoolean atomicBoolean = HAS_REGISTER;
            if (atomicBoolean.get() || StubApp.getOrigApplicationContext(context.getApplicationContext()) == null) {
                return;
            }
            IntentFilter intentFilter = new IntentFilter(context.getPackageName() + ".loader.install.DynamicApk");
            Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
            if (Build.VERSION.SDK_INT >= 33) {
                origApplicationContext.registerReceiver(new DynamicInstallReceiver(), intentFilter, 2);
            } else {
                origApplicationContext.registerReceiver(new DynamicInstallReceiver(), intentFilter);
            }
            atomicBoolean.set(true);
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(final Context context, Intent intent) {
        if (intent == null) {
            return;
        }
        String stringExtra = intent.getStringExtra("apkPath");
        final String stringExtra2 = intent.getStringExtra("sdkVersion");
        final File file = new File(stringExtra);
        if (file.exists()) {
            AsyncTask.execute(new Runnable() { // from class: com.kwad.sdk.api.loader.DynamicInstallReceiver.1
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        if (d.a(context, AnonymousClass1.class.getClassLoader(), file.getPath(), stringExtra2)) {
                            i.q(context, stringExtra2);
                            j.h(file);
                        }
                    } catch (Exception e6) {
                        e6.toString();
                        e6.printStackTrace();
                    }
                }
            });
        } else {
            file.toString();
        }
    }
}
