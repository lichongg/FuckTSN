package xyz.adscope.common.v2.dev.oaid.cn.oa.interfaces;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import xyz.adscope.common.v2.log.SDKLog;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public interface LenovoIDInterface extends IInterface {
    public static final String TAG = "LenovoIDInterface";

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static abstract class len_up extends Binder implements LenovoIDInterface {

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        public static class len_down implements LenovoIDInterface {
            private IBinder iBinder;

            @Override // xyz.adscope.common.v2.dev.oaid.cn.oa.interfaces.LenovoIDInterface
            public String a() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    try {
                        obtain.writeInterfaceToken("com.zui.deviceidservice.IDeviceidInterface");
                        this.iBinder.transact(1, obtain, obtain2, 0);
                        obtain2.readException();
                        return obtain2.readString();
                    } catch (Exception e6) {
                        SDKLog.stack(e6);
                        obtain2.recycle();
                        obtain.recycle();
                        return null;
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return null;
            }

            @Override // xyz.adscope.common.v2.dev.oaid.cn.oa.interfaces.LenovoIDInterface
            public String b() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    try {
                        obtain.writeInterfaceToken("com.zui.deviceidservice.IDeviceidInterface");
                        this.iBinder.transact(2, obtain, obtain2, 0);
                        obtain2.readException();
                        return obtain2.readString();
                    } catch (Exception e6) {
                        SDKLog.stack(e6);
                        obtain2.recycle();
                        obtain.recycle();
                        return null;
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public len_down(IBinder iBinder) {
                this.iBinder = iBinder;
            }

            @Override // xyz.adscope.common.v2.dev.oaid.cn.oa.interfaces.LenovoIDInterface
            public boolean c() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                boolean z5 = false;
                try {
                    obtain.writeInterfaceToken("com.zui.deviceidservice.IDeviceidInterface");
                    this.iBinder.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z5 = true;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return z5;
                } catch (Throwable unused) {
                    obtain2.recycle();
                    obtain.recycle();
                    return z5;
                }
            }

            @Override // xyz.adscope.common.v2.dev.oaid.cn.oa.interfaces.LenovoIDInterface
            public String a(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    try {
                        obtain.writeInterfaceToken("com.zui.deviceidservice.IDeviceidInterface");
                        this.iBinder.transact(4, obtain, obtain2, 0);
                        obtain2.readException();
                        return obtain2.readString();
                    } catch (Exception e6) {
                        SDKLog.stack(e6);
                        obtain2.recycle();
                        obtain.recycle();
                        return null;
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // xyz.adscope.common.v2.dev.oaid.cn.oa.interfaces.LenovoIDInterface
            public String b(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    try {
                        obtain.writeInterfaceToken("com.zui.deviceidservice.IDeviceidInterface");
                        this.iBinder.transact(5, obtain, obtain2, 0);
                        obtain2.readException();
                        return obtain2.readString();
                    } catch (Exception e6) {
                        SDKLog.stack(e6);
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

        public static LenovoIDInterface getHelper(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.zui.deviceidservice.IDeviceidInterface");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof LenovoIDInterface)) ? new len_down(iBinder) : (LenovoIDInterface) queryLocalInterface;
        }

        @Override // android.os.Binder
        protected boolean onTransact(int i6, Parcel parcel, Parcel parcel2, int i7) {
            if (i6 != 1598968902) {
                if (i6 != 1) {
                    if (i6 != 2) {
                        if (i6 != 3) {
                            if (i6 != 4) {
                                if (i6 != 5) {
                                    return super.onTransact(i6, parcel, parcel2, i7);
                                }
                                parcel.enforceInterface("com.zui.deviceidservice.IDeviceidInterface");
                                String b6 = b(parcel.readString());
                                parcel2.writeNoException();
                                parcel2.writeString(b6);
                                return true;
                            }
                            parcel.enforceInterface("com.zui.deviceidservice.IDeviceidInterface");
                            String a6 = a(parcel.readString());
                            parcel2.writeNoException();
                            parcel2.writeString(a6);
                            return true;
                        }
                        parcel.enforceInterface("com.zui.deviceidservice.IDeviceidInterface");
                        boolean c6 = c();
                        parcel2.writeNoException();
                        parcel2.writeInt(c6 ? 1 : 0);
                        return true;
                    }
                    parcel.enforceInterface("com.zui.deviceidservice.IDeviceidInterface");
                    String b7 = b();
                    parcel2.writeNoException();
                    parcel2.writeString(b7);
                    return true;
                }
                parcel.enforceInterface("com.zui.deviceidservice.IDeviceidInterface");
                String a7 = a();
                parcel2.writeNoException();
                parcel2.writeString(a7);
                return true;
            }
            parcel2.writeString("com.zui.deviceidservice.IDeviceidInterface");
            return true;
        }
    }

    String a();

    String a(String str);

    String b();

    String b(String str);

    boolean c();
}
