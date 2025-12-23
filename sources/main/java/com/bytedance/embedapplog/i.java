package com.bytedance.embedapplog;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: D:\Downloads\app\classes3.dex */
public interface i extends IInterface {

    public static abstract class j extends Binder implements i {

        /* renamed from: com.bytedance.embedapplog.i$j$j, reason: collision with other inner class name */
        static class C0334j implements i {

            /* renamed from: j, reason: collision with root package name */
            public static i f23996j;
            private IBinder xt;

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.xt;
            }

            C0334j(IBinder iBinder) {
                this.xt = iBinder;
            }

            @Override // com.bytedance.embedapplog.i
            public String cw() {
                String readString;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bun.lib.MsaIdInterface");
                    if (!this.xt.transact(3, obtain, obtain2, 0) && j.ae() != null) {
                        readString = j.ae().cw();
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

            @Override // com.bytedance.embedapplog.i
            public String j() {
                String readString;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bun.lib.MsaIdInterface");
                    if (!this.xt.transact(1, obtain, obtain2, 0) && j.ae() != null) {
                        readString = j.ae().j();
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

            @Override // com.bytedance.embedapplog.i
            public void m() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bun.lib.MsaIdInterface");
                    if (!this.xt.transact(6, obtain, obtain2, 0) && j.ae() != null) {
                        j.ae().m();
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.bytedance.embedapplog.i
            public boolean r() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bun.lib.MsaIdInterface");
                    boolean z5 = false;
                    if (!this.xt.transact(4, obtain, obtain2, 0) && j.ae() != null) {
                        return j.ae().r();
                    }
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z5 = true;
                    }
                    return z5;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.bytedance.embedapplog.i
            public boolean up() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bun.lib.MsaIdInterface");
                    boolean z5 = false;
                    if (!this.xt.transact(5, obtain, obtain2, 0) && j.ae() != null) {
                        return j.ae().up();
                    }
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z5 = true;
                    }
                    return z5;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.bytedance.embedapplog.i
            public String xt() {
                String readString;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bun.lib.MsaIdInterface");
                    if (!this.xt.transact(2, obtain, obtain2, 0) && j.ae() != null) {
                        readString = j.ae().xt();
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

        public static i ae() {
            return C0334j.f23996j;
        }

        public static i j(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.bun.lib.MsaIdInterface");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof i)) ? new C0334j(iBinder) : (i) queryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i6, Parcel parcel, Parcel parcel2, int i7) {
            if (i6 != 1598968902) {
                switch (i6) {
                    case 1:
                        parcel.enforceInterface("com.bun.lib.MsaIdInterface");
                        String j6 = j();
                        parcel2.writeNoException();
                        parcel2.writeString(j6);
                        return true;
                    case 2:
                        parcel.enforceInterface("com.bun.lib.MsaIdInterface");
                        String xt = xt();
                        parcel2.writeNoException();
                        parcel2.writeString(xt);
                        return true;
                    case 3:
                        parcel.enforceInterface("com.bun.lib.MsaIdInterface");
                        String cw = cw();
                        parcel2.writeNoException();
                        parcel2.writeString(cw);
                        return true;
                    case 4:
                        parcel.enforceInterface("com.bun.lib.MsaIdInterface");
                        boolean r5 = r();
                        parcel2.writeNoException();
                        parcel2.writeInt(r5 ? 1 : 0);
                        return true;
                    case 5:
                        parcel.enforceInterface("com.bun.lib.MsaIdInterface");
                        boolean up = up();
                        parcel2.writeNoException();
                        parcel2.writeInt(up ? 1 : 0);
                        return true;
                    case 6:
                        parcel.enforceInterface("com.bun.lib.MsaIdInterface");
                        m();
                        parcel2.writeNoException();
                        return true;
                    default:
                        return super.onTransact(i6, parcel, parcel2, i7);
                }
            }
            parcel2.writeString("com.bun.lib.MsaIdInterface");
            return true;
        }
    }

    String cw();

    String j();

    void m();

    boolean r();

    boolean up();

    String xt();
}
