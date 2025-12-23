package com.kwad.sdk.liteapi.oaid.interfaces;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import androidx.annotation.Keep;
import com.kwad.sdk.liteapi.LiteApiLogger;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Keep
/* loaded from: D:\Downloads\app\classes6.dex */
public interface LenovoIDInterface extends IInterface {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a implements LenovoIDInterface {
        private IBinder aGc;

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return this.aGc;
        }

        public a(IBinder iBinder) {
            this.aGc = iBinder;
        }

        @Override // com.kwad.sdk.liteapi.oaid.interfaces.LenovoIDInterface
        public final String a(String str) {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                try {
                    obtain.writeInterfaceToken("com.zui.deviceidservice.IDeviceidInterface");
                    obtain.writeString(str);
                    this.aGc.transact(4, obtain, obtain2, 0);
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

        @Override // com.kwad.sdk.liteapi.oaid.interfaces.LenovoIDInterface
        public final boolean c() {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            boolean z5 = false;
            try {
                try {
                    obtain.writeInterfaceToken("com.zui.deviceidservice.IDeviceidInterface");
                    this.aGc.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z5 = true;
                    }
                } catch (Exception e6) {
                    LiteApiLogger.printStackTrace(e6);
                }
                return z5;
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        @Override // com.kwad.sdk.liteapi.oaid.interfaces.LenovoIDInterface
        public final String getId(String str) {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                try {
                    obtain.writeInterfaceToken("com.zui.deviceidservice.IDeviceidInterface");
                    obtain.writeString(str);
                    this.aGc.transact(5, obtain, obtain2, 0);
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

        @Override // com.kwad.sdk.liteapi.oaid.interfaces.LenovoIDInterface
        public final String getOaid() {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                try {
                    obtain.writeInterfaceToken("com.zui.deviceidservice.IDeviceidInterface");
                    this.aGc.transact(1, obtain, obtain2, 0);
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

        @Override // com.kwad.sdk.liteapi.oaid.interfaces.LenovoIDInterface
        public final String getUdid() {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                try {
                    obtain.writeInterfaceToken("com.zui.deviceidservice.IDeviceidInterface");
                    this.aGc.transact(2, obtain, obtain2, 0);
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

    String a(String str);

    boolean c();

    String getId(String str);

    String getOaid();

    String getUdid();
}
