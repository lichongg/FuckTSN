package com.kwad.sdk.liteapi.oaid.interfaces;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import androidx.annotation.Keep;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Keep
/* loaded from: D:\Downloads\app\classes6.dex */
public interface ASUSIDInterface extends IInterface {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a implements ASUSIDInterface {
        private final IBinder aGc;

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return this.aGc;
        }

        public a(IBinder iBinder) {
            this.aGc = iBinder;
        }

        @Override // com.kwad.sdk.liteapi.oaid.interfaces.ASUSIDInterface
        public final String getID() {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.asus.msa.SupplementaryDID.IDidAidlInterface");
                this.aGc.transact(3, obtain, obtain2, 0);
                obtain2.readException();
                String readString = obtain2.readString();
                obtain.recycle();
                obtain2.recycle();
                return readString;
            } catch (Exception unused) {
                obtain.recycle();
                obtain2.recycle();
                return null;
            } catch (Throwable th) {
                obtain.recycle();
                obtain2.recycle();
                throw th;
            }
        }
    }

    String getID();
}
