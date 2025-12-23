package com.kwad.sdk.core.e.b;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public interface c extends IInterface {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static abstract class a extends Binder implements c {
        public abstract void a(int i6, Bundle bundle);

        @Override // android.os.Binder
        public boolean onTransact(int i6, Parcel parcel, Parcel parcel2, int i7) {
            if (i6 == 1) {
                parcel.enforceInterface("com.hihonor.cloudservice.oaid.IOAIDCallBack");
                parcel.readInt();
                parcel.readLong();
                parcel.readInt();
                parcel.readFloat();
                parcel.readDouble();
                parcel.readString();
                parcel2.writeNoException();
                return true;
            }
            if (i6 == 2) {
                parcel.enforceInterface("com.hihonor.cloudservice.oaid.IOAIDCallBack");
                a(parcel.readInt(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                return true;
            }
            if (i6 != 1598968902) {
                return super.onTransact(i6, parcel, parcel2, i7);
            }
            parcel2.writeString("com.hihonor.cloudservice.oaid.IOAIDCallBack");
            return true;
        }

        public a() {
            attachInterface(this, "com.hihonor.cloudservice.oaid.IOAIDCallBack");
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }
}
