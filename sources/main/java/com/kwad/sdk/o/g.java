package com.kwad.sdk.o;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.kwad.sdk.utils.z;
import com.stub.StubApp;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class g extends Application implements b {
    private final Application bdX;
    private final h bdY;

    @Override // android.content.ContextWrapper, android.content.Context
    public final void startActivities(Intent[] intentArr) {
        this.bdX.startActivities(intentArr);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final void startActivity(Intent intent) {
        this.bdX.startActivity(intent);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final boolean bindService(Intent intent, ServiceConnection serviceConnection, int i6) {
        return this.bdX.bindService(intent, serviceConnection, i6);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final Context getApplicationContext() {
        return StubApp.getOrigApplicationContext(this.bdY.getApplicationContext());
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final AssetManager getAssets() {
        return this.bdY.getAssets();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final ClassLoader getClassLoader() {
        return this.bdY.getClassLoader();
    }

    @Override // com.kwad.sdk.o.b
    @NonNull
    public final Context getDelegatedContext() {
        return this.bdX;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final Resources getResources() {
        return this.bdY.getResources();
    }

    @Override // android.app.Application
    public final void registerActivityLifecycleCallbacks(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        this.bdX.registerActivityLifecycleCallbacks(activityLifecycleCallbacks);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final void sendBroadcast(Intent intent) {
        this.bdX.sendBroadcast(intent);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final void setTheme(int i6) {
        this.bdX.setTheme(i6);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final void startActivities(Intent[] intentArr, @Nullable Bundle bundle) {
        this.bdX.startActivities(intentArr, bundle);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final void startActivity(Intent intent, @Nullable Bundle bundle) {
        this.bdX.startActivity(intent, bundle);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    @Nullable
    @RequiresApi(api = 26)
    public final ComponentName startForegroundService(Intent intent) {
        ComponentName startForegroundService;
        startForegroundService = this.bdX.startForegroundService(intent);
        return startForegroundService;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    @Nullable
    public final ComponentName startService(Intent intent) {
        return this.bdX.startService(intent);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final boolean stopService(Intent intent) {
        return this.bdX.stopService(intent);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final void unbindService(ServiceConnection serviceConnection) {
        this.bdX.unbindService(serviceConnection);
    }

    @Override // android.app.Application
    public final void unregisterActivityLifecycleCallbacks(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        this.bdX.unregisterActivityLifecycleCallbacks(activityLifecycleCallbacks);
    }

    public g(Application application, h hVar) {
        this.bdX = application;
        this.bdY = hVar;
        try {
            z.b(this, "mBase", hVar);
        } catch (Throwable unused) {
            attachBaseContext(hVar);
        }
    }
}
