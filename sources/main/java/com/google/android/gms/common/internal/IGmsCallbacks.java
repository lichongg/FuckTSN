package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import androidx.annotation.NonNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public interface IGmsCallbacks extends IInterface {
    void onPostInitComplete(int i6, @NonNull IBinder iBinder, @NonNull Bundle bundle) throws RemoteException;

    void zzb(int i6, @NonNull Bundle bundle) throws RemoteException;

    void zzc(int i6, IBinder iBinder, zzk zzkVar) throws RemoteException;
}
