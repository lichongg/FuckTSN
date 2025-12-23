package com.kwad.sdk.liteapi.oaid.interfaces;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import androidx.annotation.Keep;
import com.kwad.sdk.liteapi.LiteApiLogger;
import com.kwad.sdk.liteapi.oaid.interfaces.HONORProxyInterface;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Keep
/* loaded from: D:\Downloads\app\classes6.dex */
public interface HONORInterface extends IInterface {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class a extends Binder implements HONORInterface {
        private IBinder aGc;

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return this.aGc;
        }

        @Override // com.kwad.sdk.liteapi.oaid.interfaces.HONORInterface
        public final void getIDs(HONORProxyInterface hONORProxyInterface) {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.hihonor.cloudservice.oaid.IOAIDService");
                obtain.writeStrongBinder(hONORProxyInterface != null ? (HONORProxyInterface.a) hONORProxyInterface : null);
                this.aGc.transact(2, obtain, obtain2, 0);
                LiteApiLogger.d("HONORDeviceIDHelper", "gets + " + this.aGc);
                obtain2.readException();
            } finally {
                try {
                } finally {
                }
            }
        }

        public a(IBinder iBinder) {
            this.aGc = iBinder;
        }

        @Override // com.kwad.sdk.liteapi.oaid.interfaces.HONORInterface
        public final void getBoos(HONORProxyInterface hONORProxyInterface) {
            HONORProxyInterface.a aVar;
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.hihonor.cloudservice.oaid.IOAIDService");
                if (hONORProxyInterface != null) {
                    aVar = (HONORProxyInterface.a) hONORProxyInterface;
                } else {
                    aVar = null;
                }
                obtain.writeStrongBinder(aVar);
                this.aGc.transact(3, obtain, obtain2, 0);
                obtain2.readException();
            } finally {
                try {
                } finally {
                }
            }
        }
    }

    void getBoos(HONORProxyInterface hONORProxyInterface);

    void getIDs(HONORProxyInterface hONORProxyInterface);
}
