package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import androidx.annotation.NonNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public interface IAccountAccessor extends IInterface {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static abstract class Stub extends com.google.android.gms.internal.common.zzb implements IAccountAccessor {
        @Override // com.google.android.gms.internal.common.zzb
        protected final boolean zza(int i6, @NonNull Parcel parcel, @NonNull Parcel parcel2, int i7) throws RemoteException {
            if (i6 != 2) {
                return false;
            }
            Account zzb = zzb();
            parcel2.writeNoException();
            com.google.android.gms.internal.common.zzc.zzd(parcel2, zzb);
            return true;
        }

        public Stub() {
            super("com.google.android.gms.common.internal.IAccountAccessor");
        }

        @NonNull
        public static IAccountAccessor asInterface(@NonNull IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IAccountAccessor");
            return queryLocalInterface instanceof IAccountAccessor ? (IAccountAccessor) queryLocalInterface : new zzw(iBinder);
        }
    }

    @NonNull
    Account zzb() throws RemoteException;
}
