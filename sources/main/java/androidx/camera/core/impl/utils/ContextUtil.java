package androidx.camera.core.impl.utils;

import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes.dex */
public final class ContextUtil {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @RequiresApi(30)
    private static class Api30Impl {
        private Api30Impl() {
        }

        @NonNull
        @DoNotInline
        static Context createAttributionContext(@NonNull Context context, @Nullable String str) {
            return context.createAttributionContext(str);
        }

        @Nullable
        @DoNotInline
        static String getAttributionTag(@NonNull Context context) {
            return context.getAttributionTag();
        }
    }

    private ContextUtil() {
    }

    @NonNull
    public static Context getApplicationContext(@NonNull Context context) {
        String attributionTag;
        Context applicationContext = context.getApplicationContext();
        if (Build.VERSION.SDK_INT >= 30 && (attributionTag = Api30Impl.getAttributionTag(context)) != null) {
            return Api30Impl.createAttributionContext(applicationContext, attributionTag);
        }
        return applicationContext;
    }

    @Nullable
    public static Application getApplicationFromContext(@NonNull Context context) {
        for (Context applicationContext = getApplicationContext(context); applicationContext instanceof ContextWrapper; applicationContext = getBaseContext((ContextWrapper) applicationContext)) {
            if (applicationContext instanceof Application) {
                return (Application) applicationContext;
            }
        }
        return null;
    }

    @NonNull
    public static Context getBaseContext(@NonNull ContextWrapper contextWrapper) {
        String attributionTag;
        Context baseContext = contextWrapper.getBaseContext();
        if (Build.VERSION.SDK_INT >= 30 && (attributionTag = Api30Impl.getAttributionTag(contextWrapper)) != null) {
            return Api30Impl.createAttributionContext(baseContext, attributionTag);
        }
        return baseContext;
    }
}
