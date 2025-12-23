package xyz.adscope.common.v2.dev.oaid.cn.oa.interfaces;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import xyz.adscope.common.v2.log.SDKLog;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public interface ASUSIDInterface extends IInterface {
    public static final String TAG = "ASUSIDInterface";

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class ASUSID implements ASUSIDInterface {
        private IBinder iBinder;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this.iBinder;
        }

        public ASUSID(IBinder iBinder) {
            this.iBinder = iBinder;
        }

        @Override // xyz.adscope.common.v2.dev.oaid.cn.oa.interfaces.ASUSIDInterface
        public String getID() {
            String str;
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.asus.msa.SupplementaryDID.IDidAidlInterface");
                this.iBinder.transact(3, obtain, obtain2, 0);
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

    String getID();
}
