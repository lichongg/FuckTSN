package xyz.adscope.common.v2.dev.oaid.cn.oa.interfaces;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public interface SamsungIDInterface extends IInterface {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class Proxy implements SamsungIDInterface {
        private IBinder mIBinder;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this.mIBinder;
        }

        public Proxy(IBinder iBinder) {
            this.mIBinder = iBinder;
        }

        @Override // xyz.adscope.common.v2.dev.oaid.cn.oa.interfaces.SamsungIDInterface
        public String getID() {
            String str;
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.samsung.android.deviceidservice.IDeviceIdService");
                this.mIBinder.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                str = obtain2.readString();
            } catch (Throwable th) {
                obtain2.recycle();
                obtain.recycle();
                th.printStackTrace();
                str = null;
            }
            obtain2.recycle();
            obtain.recycle();
            return str;
        }
    }

    String getID();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static abstract class Stub extends Binder implements SamsungIDInterface {
        public SamsungIDInterface a(IBinder iBinder) {
            if (iBinder == null || iBinder.queryLocalInterface("com.samsung.android.deviceidservice.IDeviceIdService") == null) {
                return null;
            }
            return new Proxy(iBinder);
        }

        public Stub() {
            attachInterface(this, "com.samsung.android.deviceidservice.IDeviceIdService");
        }
    }
}
