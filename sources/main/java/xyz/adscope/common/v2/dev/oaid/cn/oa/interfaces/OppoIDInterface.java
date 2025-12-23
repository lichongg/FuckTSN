package xyz.adscope.common.v2.dev.oaid.cn.oa.interfaces;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import xyz.adscope.common.v2.log.SDKLog;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public interface OppoIDInterface extends IInterface {
    public static final String TAG = "OppoIDInterface";

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static abstract class up extends Binder implements OppoIDInterface {

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        public static class down implements OppoIDInterface {
            public IBinder iBinder;

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.iBinder;
            }

            public down(IBinder iBinder) {
                this.iBinder = iBinder;
            }

            public String getSerID(String str, String str2, String str3) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    try {
                        obtain.writeInterfaceToken("com.heytap.openid.IOpenID");
                        obtain.writeString(str);
                        obtain.writeString(str2);
                        obtain.writeString(str3);
                        this.iBinder.transact(1, obtain, obtain2, 0);
                        obtain2.readException();
                        return obtain2.readString();
                    } catch (Exception e6) {
                        SDKLog.stack(e6);
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

        public static OppoIDInterface genInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.heytap.openid.IOpenID");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof OppoIDInterface)) ? new down(iBinder) : (OppoIDInterface) queryLocalInterface;
        }
    }
}
