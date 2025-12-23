package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public abstract class zad extends com.google.android.gms.internal.base.zab implements zae {
    public zad() {
        super("com.google.android.gms.signin.internal.ISignInCallbacks");
    }

    @Override // com.google.android.gms.internal.base.zab
    protected final boolean zaa(int i6, Parcel parcel, Parcel parcel2, int i7) throws RemoteException {
        switch (i6) {
            case 3:
                com.google.android.gms.internal.base.zac.zab(parcel);
                break;
            case 4:
                com.google.android.gms.internal.base.zac.zab(parcel);
                break;
            case 5:
            default:
                return false;
            case 6:
                com.google.android.gms.internal.base.zac.zab(parcel);
                break;
            case 7:
                com.google.android.gms.internal.base.zac.zab(parcel);
                break;
            case 8:
                zak zakVar = (zak) com.google.android.gms.internal.base.zac.zaa(parcel, zak.CREATOR);
                com.google.android.gms.internal.base.zac.zab(parcel);
                zab(zakVar);
                break;
            case 9:
                com.google.android.gms.internal.base.zac.zab(parcel);
                break;
        }
        parcel2.writeNoException();
        return true;
    }
}
