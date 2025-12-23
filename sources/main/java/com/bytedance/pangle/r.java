package com.bytedance.pangle;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: D:\Downloads\app\classes3.dex */
public interface r extends IInterface {

    public static abstract class j extends Binder implements r {

        /* renamed from: com.bytedance.pangle.r$j$j, reason: collision with other inner class name */
        private static class C0388j implements r {

            /* renamed from: j, reason: collision with root package name */
            public static r f25451j;
            private IBinder xt;

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.xt;
            }

            C0388j(IBinder iBinder) {
                this.xt = iBinder;
            }

            @Override // com.bytedance.pangle.r
            public void j(String str, int i6, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.pangle.IPluginInstallListener");
                    obtain.writeString(str);
                    obtain.writeInt(i6);
                    obtain.writeString(str2);
                    if (!this.xt.transact(1, obtain, obtain2, 0) && j.j() != null) {
                        j.j().j(str, i6, str2);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static r j(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.bytedance.pangle.IPluginInstallListener");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof r)) ? new C0388j(iBinder) : (r) queryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i6, Parcel parcel, Parcel parcel2, int i7) throws RemoteException {
            if (i6 != 1) {
                if (i6 != 1598968902) {
                    return super.onTransact(i6, parcel, parcel2, i7);
                }
                parcel2.writeString("com.bytedance.pangle.IPluginInstallListener");
                return true;
            }
            parcel.enforceInterface("com.bytedance.pangle.IPluginInstallListener");
            j(parcel.readString(), parcel.readInt(), parcel.readString());
            parcel2.writeNoException();
            return true;
        }

        public j() {
            attachInterface(this, "com.bytedance.pangle.IPluginInstallListener");
        }

        public static r j() {
            return C0388j.f25451j;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }

    void j(String str, int i6, String str2) throws RemoteException;
}
