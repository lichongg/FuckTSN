package xyz.adscope.common.v2.dev.oaid.cn.oa.interfaces;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import xyz.adscope.common.v2.log.SDKLog;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public interface HWIDInterface extends IInterface {
    public static final String TAG = "HWIDInterface";

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class HWID implements HWIDInterface {
        private IBinder iBinder;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this.iBinder;
        }

        public HWID(IBinder iBinder) {
            this.iBinder = iBinder;
        }

        @Override // xyz.adscope.common.v2.dev.oaid.cn.oa.interfaces.HWIDInterface
        public boolean getBoos() {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            boolean z5 = false;
            try {
                obtain.writeInterfaceToken("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
                this.iBinder.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                if (obtain2.readInt() == 0) {
                    z5 = true;
                }
            } catch (Throwable unused) {
                obtain.recycle();
                obtain2.recycle();
            }
            obtain.recycle();
            obtain2.recycle();
            return z5;
        }

        @Override // xyz.adscope.common.v2.dev.oaid.cn.oa.interfaces.HWIDInterface
        public String getIDs() {
            String str;
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
                this.iBinder.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                str = obtain2.readString();
            } catch (Throwable th) {
                obtain.recycle();
                obtain2.recycle();
                SDKLog.stack(th);
                str = null;
            }
            obtain.recycle();
            obtain2.recycle();
            return str;
        }
    }

    boolean getBoos();

    String getIDs();
}
