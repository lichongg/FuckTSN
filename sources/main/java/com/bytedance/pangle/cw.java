package com.bytedance.pangle;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.bytedance.pangle.r;

/* loaded from: D:\Downloads\app\classes3.dex */
public interface cw extends IInterface {

    public static abstract class j extends Binder implements cw {

        /* renamed from: com.bytedance.pangle.cw$j$j, reason: collision with other inner class name */
        private static class C0385j implements cw {

            /* renamed from: j, reason: collision with root package name */
            public static cw f25389j;
            private IBinder xt;

            @Override // com.bytedance.pangle.cw
            public boolean j(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.pangle.IPackageManager");
                    obtain.writeString(str);
                    if (!this.xt.transact(1, obtain, obtain2, 0) && j.j() != null) {
                        return j.j().j(str);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.xt;
            }

            C0385j(IBinder iBinder) {
                this.xt = iBinder;
            }

            @Override // com.bytedance.pangle.cw
            public int xt(String str) throws RemoteException {
                int readInt;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.pangle.IPackageManager");
                    obtain.writeString(str);
                    if (!this.xt.transact(2, obtain, obtain2, 0) && j.j() != null) {
                        readInt = j.j().xt(str);
                    } else {
                        obtain2.readException();
                        readInt = obtain2.readInt();
                    }
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.bytedance.pangle.cw
            public boolean j(String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.pangle.IPackageManager");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (!this.xt.transact(3, obtain, obtain2, 0) && j.j() != null) {
                        return j.j().j(str, str2);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.bytedance.pangle.cw
            public void j(int i6, r rVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.pangle.IPackageManager");
                    obtain.writeInt(i6);
                    obtain.writeStrongBinder(rVar != null ? rVar.asBinder() : null);
                    if (!this.xt.transact(4, obtain, obtain2, 0) && j.j() != null) {
                        j.j().j(i6, rVar);
                    } else {
                        obtain2.readException();
                    }
                    obtain2.recycle();
                    obtain.recycle();
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    throw th;
                }
            }

            @Override // com.bytedance.pangle.cw
            public void j(int i6) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.pangle.IPackageManager");
                    obtain.writeInt(i6);
                    if (!this.xt.transact(5, obtain, obtain2, 0) && j.j() != null) {
                        j.j().j(i6);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static cw j(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.bytedance.pangle.IPackageManager");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof cw)) ? new C0385j(iBinder) : (cw) queryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i6, Parcel parcel, Parcel parcel2, int i7) throws RemoteException {
            if (i6 == 1) {
                parcel.enforceInterface("com.bytedance.pangle.IPackageManager");
                boolean j6 = j(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeInt(j6 ? 1 : 0);
                return true;
            }
            if (i6 == 2) {
                parcel.enforceInterface("com.bytedance.pangle.IPackageManager");
                int xt = xt(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeInt(xt);
                return true;
            }
            if (i6 == 3) {
                parcel.enforceInterface("com.bytedance.pangle.IPackageManager");
                boolean j7 = j(parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                parcel2.writeInt(j7 ? 1 : 0);
                return true;
            }
            if (i6 == 4) {
                parcel.enforceInterface("com.bytedance.pangle.IPackageManager");
                j(parcel.readInt(), r.j.j(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            }
            if (i6 != 5) {
                if (i6 != 1598968902) {
                    return super.onTransact(i6, parcel, parcel2, i7);
                }
                parcel2.writeString("com.bytedance.pangle.IPackageManager");
                return true;
            }
            parcel.enforceInterface("com.bytedance.pangle.IPackageManager");
            j(parcel.readInt());
            parcel2.writeNoException();
            return true;
        }

        public j() {
            attachInterface(this, "com.bytedance.pangle.IPackageManager");
        }

        public static cw j() {
            return C0385j.f25389j;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }

    void j(int i6) throws RemoteException;

    void j(int i6, r rVar) throws RemoteException;

    boolean j(String str) throws RemoteException;

    boolean j(String str, String str2) throws RemoteException;

    int xt(String str) throws RemoteException;
}
