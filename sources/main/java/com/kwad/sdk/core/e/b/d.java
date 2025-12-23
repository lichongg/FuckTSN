package com.kwad.sdk.core.e.b;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public interface d extends IInterface {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a implements d {
        private IBinder aGc;

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return this.aGc;
        }

        public a(IBinder iBinder) {
            this.aGc = iBinder;
        }

        public final boolean getBoos() {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            boolean z5 = false;
            try {
                try {
                    obtain.writeInterfaceToken("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
                    this.aGc.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() == 0) {
                        z5 = true;
                    }
                } catch (Exception e6) {
                    com.kwad.sdk.core.d.c.printStackTrace(e6);
                }
                return z5;
            } finally {
                obtain.recycle();
                obtain2.recycle();
            }
        }

        public final String getIDs() {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                try {
                    obtain.writeInterfaceToken("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
                    this.aGc.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } catch (Exception e6) {
                    com.kwad.sdk.core.d.c.printStackTrace(e6);
                    obtain.recycle();
                    obtain2.recycle();
                    return null;
                }
            } finally {
                obtain.recycle();
                obtain2.recycle();
            }
        }
    }
}
