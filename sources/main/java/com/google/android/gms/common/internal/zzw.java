package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public final class zzw extends com.google.android.gms.internal.common.zza implements IAccountAccessor {
    @Override // com.google.android.gms.common.internal.IAccountAccessor
    public final Account zzb() throws RemoteException {
        Parcel zzB = zzB(2, zza());
        Account account = (Account) com.google.android.gms.internal.common.zzc.zza(zzB, Account.CREATOR);
        zzB.recycle();
        return account;
    }

    zzw(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.IAccountAccessor");
    }
}
