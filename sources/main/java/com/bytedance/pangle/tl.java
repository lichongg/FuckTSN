package com.bytedance.pangle;

import android.content.ComponentName;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: D:\Downloads\app\classes4.dex */
public interface tl extends IInterface {

    public static abstract class j extends Binder implements tl {

        /* renamed from: com.bytedance.pangle.tl$j$j, reason: collision with other inner class name */
        private static class C0393j implements tl {

            /* renamed from: j, reason: collision with root package name */
            public static tl f25525j;
            private IBinder xt;

            @Override // com.bytedance.pangle.tl
            public void j(ComponentName componentName, IBinder iBinder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.pangle.ServiceConnection");
                    if (componentName != null) {
                        obtain.writeInt(1);
                        componentName.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(iBinder);
                    if (this.xt.transact(1, obtain, obtain2, 0) || j.xt() == null) {
                        obtain2.readException();
                    } else {
                        j.xt().j(componentName, iBinder);
                    }
                    obtain2.recycle();
                    obtain.recycle();
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    throw th;
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.xt;
            }

            C0393j(IBinder iBinder) {
                this.xt = iBinder;
            }

            @Override // com.bytedance.pangle.tl
            public int j() throws RemoteException {
                int readInt;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.pangle.ServiceConnection");
                    if (!this.xt.transact(2, obtain, obtain2, 0) && j.xt() != null) {
                        readInt = j.xt().j();
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
        }

        public static tl j(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.bytedance.pangle.ServiceConnection");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof tl)) ? new C0393j(iBinder) : (tl) queryLocalInterface;
        }

        public static tl xt() {
            return C0393j.f25525j;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i6, Parcel parcel, Parcel parcel2, int i7) throws RemoteException {
            if (i6 == 1) {
                parcel.enforceInterface("com.bytedance.pangle.ServiceConnection");
                j(parcel.readInt() != 0 ? (ComponentName) ComponentName.CREATOR.createFromParcel(parcel) : null, parcel.readStrongBinder());
                parcel2.writeNoException();
                return true;
            }
            if (i6 != 2) {
                if (i6 != 1598968902) {
                    return super.onTransact(i6, parcel, parcel2, i7);
                }
                parcel2.writeString("com.bytedance.pangle.ServiceConnection");
                return true;
            }
            parcel.enforceInterface("com.bytedance.pangle.ServiceConnection");
            int j6 = j();
            parcel2.writeNoException();
            parcel2.writeInt(j6);
            return true;
        }

        public j() {
            attachInterface(this, "com.bytedance.pangle.ServiceConnection");
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }

    int j() throws RemoteException;

    void j(ComponentName componentName, IBinder iBinder) throws RemoteException;
}
