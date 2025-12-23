package com.kwad.sdk.api.loader;

import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import com.stub.StubApp;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class e {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class a extends Application {
        private final Context atW;

        @Override // android.content.ContextWrapper, android.content.Context
        public final Context getApplicationContext() {
            return this.atW;
        }

        @Override // android.content.ContextWrapper, android.content.Context
        public final ApplicationInfo getApplicationInfo() {
            return this.atW.getApplicationInfo();
        }

        a(Context context) {
            this.atW = context;
        }
    }

    public static Context aV(Context context) {
        if (context == null) {
            return null;
        }
        Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
        return origApplicationContext == null ? context : !origApplicationContext.getClassLoader().equals(context.getClassLoader()) ? new a(context) : StubApp.getOrigApplicationContext(context.getApplicationContext());
    }
}
