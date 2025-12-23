package com.bytedance.embedapplog;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: D:\Downloads\app\classes3.dex */
public interface jy extends IInterface {

    public static abstract class j extends Binder implements jy {

        /* renamed from: com.bytedance.embedapplog.jy$j$j, reason: collision with other inner class name */
        static class C0335j implements jy {

            /* renamed from: j, reason: collision with root package name */
            private IBinder f24002j;

            @Override // com.bytedance.embedapplog.jy
            public String j() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.samsung.android.deviceidservice.IDeviceIdService");
                    this.f24002j.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f24002j;
            }

            C0335j(IBinder iBinder) {
                this.f24002j = iBinder;
            }

            @Override // com.bytedance.embedapplog.jy
            public String xt(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.samsung.android.deviceidservice.IDeviceIdService");
                    obtain.writeString(str);
                    this.f24002j.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.bytedance.embedapplog.jy
            public String j(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.samsung.android.deviceidservice.IDeviceIdService");
                    obtain.writeString(str);
                    this.f24002j.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static jy j(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.samsung.android.deviceidservice.IDeviceIdService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof jy)) ? new C0335j(iBinder) : (jy) queryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i6, Parcel parcel, Parcel parcel2, int i7) {
            if (i6 == 1) {
                parcel.enforceInterface("com.samsung.android.deviceidservice.IDeviceIdService");
                String j6 = j();
                parcel2.writeNoException();
                parcel2.writeString(j6);
                return true;
            }
            if (i6 == 2) {
                parcel.enforceInterface("com.samsung.android.deviceidservice.IDeviceIdService");
                String j7 = j(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeString(j7);
                return true;
            }
            if (i6 != 3) {
                if (i6 != 1598968902) {
                    return super.onTransact(i6, parcel, parcel2, i7);
                }
                parcel2.writeString("com.samsung.android.deviceidservice.IDeviceIdService");
                return true;
            }
            parcel.enforceInterface("com.samsung.android.deviceidservice.IDeviceIdService");
            String xt = xt(parcel.readString());
            parcel2.writeNoException();
            parcel2.writeString(xt);
            return true;
        }
    }

    String j();

    String j(String str);

    String xt(String str);
}
