package com.kwad.sdk.liteapi.oaid.interfaces;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import androidx.annotation.Keep;
import com.kwad.sdk.liteapi.LiteApiLogger;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Keep
/* loaded from: D:\Downloads\app\classes6.dex */
public interface SamsungIDInterface extends IInterface {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class a implements SamsungIDInterface {
        private IBinder aGd;

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return this.aGd;
        }

        public a(IBinder iBinder) {
            this.aGd = iBinder;
        }

        @Override // com.kwad.sdk.liteapi.oaid.interfaces.SamsungIDInterface
        public final String getID() {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                try {
                    obtain.writeInterfaceToken("com.samsung.android.deviceidservice.IDeviceIdService");
                    this.aGd.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } catch (Exception e6) {
                    LiteApiLogger.printStackTrace(e6);
                    obtain2.recycle();
                    obtain.recycle();
                    return null;
                }
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }
    }

    String getID();
}
