package androidx.core.app;

import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.app.PendingIntentCompat;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.io.Closeable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.concurrent.CountDownLatch;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public final class PendingIntentCompat {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public @interface Flags {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class GatedCallback implements Closeable {

        @Nullable
        private PendingIntent.OnFinished mCallback;
        private final CountDownLatch mComplete = new CountDownLatch(1);
        private boolean mSuccess = false;

        /* JADX INFO: Access modifiers changed from: private */
        public void onSendFinished(PendingIntent pendingIntent, Intent intent, int i6, String str, Bundle bundle) {
            boolean z5 = false;
            while (true) {
                try {
                    this.mComplete.await();
                    break;
                } catch (InterruptedException unused) {
                    z5 = true;
                    pendingIntent = pendingIntent;
                    intent = intent;
                    i6 = i6;
                    str = str;
                    bundle = bundle;
                } catch (Throwable th) {
                    if (!z5) {
                        throw th;
                    }
                    Thread.currentThread().interrupt();
                    throw th;
                }
            }
            if (z5) {
                Thread.currentThread().interrupt();
            }
            PendingIntent.OnFinished onFinished = this.mCallback;
            if (onFinished != null) {
                onFinished.onSendFinished(pendingIntent, intent, i6, str, bundle);
                this.mCallback = null;
            }
        }

        public void complete() {
            this.mSuccess = true;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (!this.mSuccess) {
                this.mCallback = null;
            }
            this.mComplete.countDown();
        }

        @Nullable
        public PendingIntent.OnFinished getCallback() {
            if (this.mCallback == null) {
                return null;
            }
            return new PendingIntent.OnFinished() { // from class: androidx.core.app.s
                @Override // android.app.PendingIntent.OnFinished
                public final void onSendFinished(PendingIntent pendingIntent, Intent intent, int i6, String str, Bundle bundle) {
                    PendingIntentCompat.GatedCallback.this.onSendFinished(pendingIntent, intent, i6, str, bundle);
                }
            };
        }

        GatedCallback(@Nullable PendingIntent.OnFinished onFinished) {
            this.mCallback = onFinished;
        }
    }

    @NonNull
    public static PendingIntent getActivities(@NonNull Context context, int i6, @NonNull @SuppressLint({"ArrayReturn"}) Intent[] intentArr, int i7, @Nullable Bundle bundle, boolean z5) {
        return PendingIntent.getActivities(context, i6, intentArr, addMutabilityFlags(z5, i7), bundle);
    }

    @Nullable
    public static PendingIntent getActivity(@NonNull Context context, int i6, @NonNull Intent intent, int i7, boolean z5) {
        return PendingIntent.getActivity(context, i6, intent, addMutabilityFlags(z5, i7));
    }

    @SuppressLint({"LambdaLast"})
    public static void send(@NonNull PendingIntent pendingIntent, int i6, @Nullable PendingIntent.OnFinished onFinished, @Nullable Handler handler) throws PendingIntent.CanceledException {
        GatedCallback gatedCallback = new GatedCallback(onFinished);
        try {
            pendingIntent.send(i6, gatedCallback.getCallback(), handler);
            gatedCallback.complete();
            gatedCallback.close();
        } catch (Throwable th) {
            try {
                gatedCallback.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @RequiresApi(23)
    private static class Api23Impl {
        private Api23Impl() {
        }

        @DoNotInline
        public static void send(@NonNull PendingIntent pendingIntent, @NonNull Context context, int i6, @NonNull Intent intent, @Nullable PendingIntent.OnFinished onFinished, @Nullable Handler handler, @Nullable String str, @Nullable Bundle bundle) throws PendingIntent.CanceledException {
            pendingIntent.send(context, i6, intent, onFinished, handler, str, bundle);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @RequiresApi(26)
    private static class Api26Impl {
        private Api26Impl() {
        }

        @DoNotInline
        public static PendingIntent getForegroundService(Context context, int i6, Intent intent, int i7) {
            return PendingIntent.getForegroundService(context, i6, intent, i7);
        }
    }

    private static int addMutabilityFlags(boolean z5, int i6) {
        int i7;
        if (z5) {
            if (Build.VERSION.SDK_INT >= 31) {
                i7 = CommonNetImpl.FLAG_SHARE_JUMP;
                return i7 | i6;
            }
            return i6;
        }
        if (Build.VERSION.SDK_INT >= 23) {
            i7 = 67108864;
            return i7 | i6;
        }
        return i6;
    }

    private PendingIntentCompat() {
    }

    @NonNull
    public static PendingIntent getActivities(@NonNull Context context, int i6, @NonNull @SuppressLint({"ArrayReturn"}) Intent[] intentArr, int i7, boolean z5) {
        return PendingIntent.getActivities(context, i6, intentArr, addMutabilityFlags(z5, i7));
    }

    @Nullable
    public static PendingIntent getActivity(@NonNull Context context, int i6, @NonNull Intent intent, int i7, @Nullable Bundle bundle, boolean z5) {
        return PendingIntent.getActivity(context, i6, intent, addMutabilityFlags(z5, i7), bundle);
    }

    @Nullable
    public static PendingIntent getBroadcast(@NonNull Context context, int i6, @NonNull Intent intent, int i7, boolean z5) {
        return PendingIntent.getBroadcast(context, i6, intent, addMutabilityFlags(z5, i7));
    }

    @NonNull
    @RequiresApi(26)
    public static PendingIntent getForegroundService(@NonNull Context context, int i6, @NonNull Intent intent, int i7, boolean z5) {
        return Api26Impl.getForegroundService(context, i6, intent, addMutabilityFlags(z5, i7));
    }

    @Nullable
    public static PendingIntent getService(@NonNull Context context, int i6, @NonNull Intent intent, int i7, boolean z5) {
        return PendingIntent.getService(context, i6, intent, addMutabilityFlags(z5, i7));
    }

    @SuppressLint({"LambdaLast"})
    public static void send(@NonNull PendingIntent pendingIntent, @NonNull @SuppressLint({"ContextFirst"}) Context context, int i6, @NonNull Intent intent, @Nullable PendingIntent.OnFinished onFinished, @Nullable Handler handler) throws PendingIntent.CanceledException {
        send(pendingIntent, context, i6, intent, onFinished, handler, null, null);
    }

    @SuppressLint({"LambdaLast"})
    public static void send(@NonNull PendingIntent pendingIntent, @NonNull @SuppressLint({"ContextFirst"}) Context context, int i6, @NonNull Intent intent, @Nullable PendingIntent.OnFinished onFinished, @Nullable Handler handler, @Nullable String str, @Nullable Bundle bundle) throws PendingIntent.CanceledException {
        GatedCallback gatedCallback = new GatedCallback(onFinished);
        try {
            if (Build.VERSION.SDK_INT >= 23) {
                Api23Impl.send(pendingIntent, context, i6, intent, onFinished, handler, str, bundle);
            } else {
                pendingIntent.send(context, i6, intent, gatedCallback.getCallback(), handler, str);
            }
            gatedCallback.complete();
            gatedCallback.close();
        } finally {
        }
    }
}
