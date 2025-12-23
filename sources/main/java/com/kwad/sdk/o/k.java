package com.kwad.sdk.o;

import android.app.Application;
import android.content.Context;
import com.kwad.sdk.api.core.ResContext;
import com.kwad.sdk.api.loader.Wrapper;
import com.kwad.sdk.service.ServiceProvider;
import com.stub.StubApp;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
final class k {
    /* JADX WARN: Multi-variable type inference failed */
    static Context aM(Context context) {
        return ((ResContext) context).getDelegatedContext();
    }

    static boolean aN(Context context) {
        return context instanceof ResContext;
    }

    static Context eh(Context context) {
        Context origApplicationContext = StubApp.getOrigApplicationContext(unwrapContextIfNeed(context).getApplicationContext());
        if (origApplicationContext instanceof Application) {
            return origApplicationContext;
        }
        for (int i6 = 0; i6 < 10; i6++) {
            origApplicationContext = StubApp.getOrigApplicationContext(origApplicationContext.getApplicationContext());
            if (origApplicationContext instanceof Application) {
                return origApplicationContext;
            }
            if (aN(origApplicationContext)) {
                origApplicationContext = aM(origApplicationContext);
            }
        }
        return origApplicationContext;
    }

    public static void onDestroy(Context context) {
        Wrapper.onDestroy(context);
    }

    static Context unwrapContextIfNeed(Context context) {
        if (aN(context)) {
            context = aM(context);
        }
        if (!aN(context)) {
            return context;
        }
        RuntimeException runtimeException = null;
        for (int i6 = 0; i6 < 10; i6++) {
            if (runtimeException == null) {
                RuntimeException runtimeException2 = new RuntimeException("expect normalContext --context:" + context.getClass().getName() + "--initFinish:" + ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).Bn());
                ((com.kwad.sdk.service.a.e) ServiceProvider.get(com.kwad.sdk.service.a.e.class)).gatherException(runtimeException2);
                runtimeException = runtimeException2;
            }
            context = aM(context);
            if (!aN(context)) {
                return context;
            }
        }
        return context;
    }

    static Context wrapContextIfNeed(Context context) {
        return Wrapper.wrapContextIfNeed(context);
    }
}
