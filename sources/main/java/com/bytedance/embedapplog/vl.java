package com.bytedance.embedapplog;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: D:\Downloads\app\classes3.dex */
public interface vl extends IInterface {

    public static abstract class j extends Binder implements vl {

        /* renamed from: com.bytedance.embedapplog.vl$j$j, reason: collision with other inner class name */
        static class C0340j implements vl {

            /* renamed from: j, reason: collision with root package name */
            public static vl f24083j;
            private IBinder xt;

            @Override // com.bytedance.embedapplog.vl
            public String j(String str) {
                String readString;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.coolpad.deviceidsupport.IDeviceIdManager");
                    obtain.writeString(str);
                    if (this.xt.transact(1, obtain, obtain2, 0) || j.cw() == null) {
                        obtain2.readException();
                        readString = obtain2.readString();
                    } else {
                        readString = j.cw().j(str);
                    }
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.bytedance.embedapplog.vl
            public String xt(String str) {
                String readString;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.coolpad.deviceidsupport.IDeviceIdManager");
                    obtain.writeString(str);
                    if (this.xt.transact(2, obtain, obtain2, 0) || j.cw() == null) {
                        obtain2.readException();
                        readString = obtain2.readString();
                    } else {
                        readString = j.cw().xt(str);
                    }
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.xt;
            }

            C0340j(IBinder iBinder) {
                this.xt = iBinder;
            }

            @Override // com.bytedance.embedapplog.vl
            public String cw(String str) {
                String readString;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.coolpad.deviceidsupport.IDeviceIdManager");
                    obtain.writeString(str);
                    if (!this.xt.transact(3, obtain, obtain2, 0) && j.cw() != null) {
                        readString = j.cw().cw(str);
                    } else {
                        obtain2.readException();
                        readString = obtain2.readString();
                    }
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.bytedance.embedapplog.vl
            public String r(String str) {
                String readString;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.coolpad.deviceidsupport.IDeviceIdManager");
                    obtain.writeString(str);
                    if (!this.xt.transact(4, obtain, obtain2, 0) && j.cw() != null) {
                        readString = j.cw().r(str);
                    } else {
                        obtain2.readException();
                        readString = obtain2.readString();
                    }
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.bytedance.embedapplog.vl
            public String up(String str) {
                String readString;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.coolpad.deviceidsupport.IDeviceIdManager");
                    obtain.writeString(str);
                    if (!this.xt.transact(5, obtain, obtain2, 0) && j.cw() != null) {
                        readString = j.cw().up(str);
                    } else {
                        obtain2.readException();
                        readString = obtain2.readString();
                    }
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.bytedance.embedapplog.vl
            public boolean j() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.coolpad.deviceidsupport.IDeviceIdManager");
                    if (!this.xt.transact(6, obtain, obtain2, 0) && j.cw() != null) {
                        return j.cw().j();
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.bytedance.embedapplog.vl
            public String xt() {
                String readString;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.coolpad.deviceidsupport.IDeviceIdManager");
                    if (!this.xt.transact(7, obtain, obtain2, 0) && j.cw() != null) {
                        readString = j.cw().xt();
                    } else {
                        obtain2.readException();
                        readString = obtain2.readString();
                    }
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static vl cw() {
            return C0340j.f24083j;
        }

        public static vl j(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.coolpad.deviceidsupport.IDeviceIdManager");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof vl)) ? new C0340j(iBinder) : (vl) queryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i6, Parcel parcel, Parcel parcel2, int i7) {
            if (i6 != 1598968902) {
                switch (i6) {
                    case 1:
                        parcel.enforceInterface("com.coolpad.deviceidsupport.IDeviceIdManager");
                        String j6 = j(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeString(j6);
                        return true;
                    case 2:
                        parcel.enforceInterface("com.coolpad.deviceidsupport.IDeviceIdManager");
                        String xt = xt(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeString(xt);
                        return true;
                    case 3:
                        parcel.enforceInterface("com.coolpad.deviceidsupport.IDeviceIdManager");
                        String cw = cw(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeString(cw);
                        return true;
                    case 4:
                        parcel.enforceInterface("com.coolpad.deviceidsupport.IDeviceIdManager");
                        String r5 = r(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeString(r5);
                        return true;
                    case 5:
                        parcel.enforceInterface("com.coolpad.deviceidsupport.IDeviceIdManager");
                        String up = up(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeString(up);
                        return true;
                    case 6:
                        parcel.enforceInterface("com.coolpad.deviceidsupport.IDeviceIdManager");
                        boolean j7 = j();
                        parcel2.writeNoException();
                        parcel2.writeInt(j7 ? 1 : 0);
                        return true;
                    case 7:
                        parcel.enforceInterface("com.coolpad.deviceidsupport.IDeviceIdManager");
                        String xt2 = xt();
                        parcel2.writeNoException();
                        parcel2.writeString(xt2);
                        return true;
                    default:
                        return super.onTransact(i6, parcel, parcel2, i7);
                }
            }
            parcel2.writeString("com.coolpad.deviceidsupport.IDeviceIdManager");
            return true;
        }
    }

    String cw(String str);

    String j(String str);

    boolean j();

    String r(String str);

    String up(String str);

    String xt();

    String xt(String str);
}
