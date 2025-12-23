package com.google.android.gms.dynamic;

import android.content.Context;
import android.os.IBinder;
import androidx.annotation.NonNull;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@KeepForSdk
/* loaded from: D:\Downloads\app\classes5.dex */
public abstract class RemoteCreator<T> {
    private final String zza;
    private Object zzb;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @KeepForSdk
    public static class RemoteCreatorException extends Exception {
        @KeepForSdk
        public RemoteCreatorException(@NonNull String str) {
            super(str);
        }

        @KeepForSdk
        public RemoteCreatorException(@NonNull String str, @NonNull Throwable th) {
            super(str, th);
        }
    }

    @NonNull
    @KeepForSdk
    protected abstract T getRemoteCreator(@NonNull IBinder iBinder);

    @NonNull
    @KeepForSdk
    protected final T getRemoteCreatorInstance(@NonNull Context context) throws RemoteCreatorException {
        if (this.zzb == null) {
            Preconditions.checkNotNull(context);
            Context remoteContext = GooglePlayServicesUtilLight.getRemoteContext(context);
            if (remoteContext == null) {
                throw new RemoteCreatorException("Could not get remote context.");
            }
            try {
                this.zzb = getRemoteCreator((IBinder) remoteContext.getClassLoader().loadClass(this.zza).newInstance());
            } catch (ClassNotFoundException e6) {
                throw new RemoteCreatorException("Could not load creator class.", e6);
            } catch (IllegalAccessException e7) {
                throw new RemoteCreatorException("Could not access creator.", e7);
            } catch (InstantiationException e8) {
                throw new RemoteCreatorException("Could not instantiate creator.", e8);
            }
        }
        return (T) this.zzb;
    }

    @KeepForSdk
    protected RemoteCreator(@NonNull String str) {
        this.zza = str;
    }
}
