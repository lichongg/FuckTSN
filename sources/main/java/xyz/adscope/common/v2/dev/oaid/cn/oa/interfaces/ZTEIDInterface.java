package xyz.adscope.common.v2.dev.oaid.cn.oa.interfaces;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public interface ZTEIDInterface extends IInterface {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static abstract class up extends Binder implements ZTEIDInterface {

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        public static class down implements ZTEIDInterface {
            private IBinder binder;

            @Override // xyz.adscope.common.v2.dev.oaid.cn.oa.interfaces.ZTEIDInterface
            public boolean isSupported() {
                return false;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.binder;
            }

            public down(IBinder iBinder) {
                this.binder = iBinder;
            }

            @Override // xyz.adscope.common.v2.dev.oaid.cn.oa.interfaces.ZTEIDInterface
            public boolean c() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bun.lib.MsaIdInterface");
                    this.binder.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() == 0) {
                        obtain2.recycle();
                        obtain.recycle();
                        return true;
                    }
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    th.printStackTrace();
                }
                return false;
            }

            @Override // xyz.adscope.common.v2.dev.oaid.cn.oa.interfaces.ZTEIDInterface
            public String getOAID() {
                String str;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bun.lib.MsaIdInterface");
                    this.binder.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    str = obtain2.readString();
                } catch (Throwable unused) {
                    obtain2.recycle();
                    obtain.recycle();
                    str = null;
                }
                obtain2.recycle();
                obtain.recycle();
                return str;
            }

            @Override // xyz.adscope.common.v2.dev.oaid.cn.oa.interfaces.ZTEIDInterface
            public void shutDown() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bun.lib.MsaIdInterface");
                    this.binder.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } catch (Throwable unused) {
                    obtain2.recycle();
                    obtain.recycle();
                }
                obtain2.recycle();
                obtain.recycle();
            }
        }
    }

    boolean c();

    String getOAID();

    boolean isSupported();

    void shutDown();
}
