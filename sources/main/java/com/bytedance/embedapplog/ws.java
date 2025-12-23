package com.bytedance.embedapplog;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: D:\Downloads\app\classes3.dex */
public interface ws extends IInterface {

    public static abstract class j extends Binder implements ws {

        /* renamed from: com.bytedance.embedapplog.ws$j$j, reason: collision with other inner class name */
        static class C0341j implements ws {

            /* renamed from: j, reason: collision with root package name */
            private IBinder f24098j;

            @Override // com.bytedance.embedapplog.ws
            public String j() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.zui.deviceidservice.IDeviceidInterface");
                    this.f24098j.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.bytedance.embedapplog.ws
            public String xt() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.zui.deviceidservice.IDeviceidInterface");
                    this.f24098j.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f24098j;
            }

            C0341j(IBinder iBinder) {
                this.f24098j = iBinder;
            }

            @Override // com.bytedance.embedapplog.ws
            public boolean cw() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.zui.deviceidservice.IDeviceidInterface");
                    boolean z5 = false;
                    this.f24098j.transact(3, obtain, obtain2, 0);
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

            @Override // com.bytedance.embedapplog.ws
            public String j(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.zui.deviceidservice.IDeviceidInterface");
                    obtain.writeString(str);
                    this.f24098j.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.bytedance.embedapplog.ws
            public String xt(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.zui.deviceidservice.IDeviceidInterface");
                    obtain.writeString(str);
                    this.f24098j.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static ws j(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.zui.deviceidservice.IDeviceidInterface");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof ws)) ? new C0341j(iBinder) : (ws) queryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i6, Parcel parcel, Parcel parcel2, int i7) {
            if (i6 == 1) {
                parcel.enforceInterface("com.zui.deviceidservice.IDeviceidInterface");
                String j6 = j();
                parcel2.writeNoException();
                parcel2.writeString(j6);
                return true;
            }
            if (i6 == 2) {
                parcel.enforceInterface("com.zui.deviceidservice.IDeviceidInterface");
                String xt = xt();
                parcel2.writeNoException();
                parcel2.writeString(xt);
                return true;
            }
            if (i6 == 3) {
                parcel.enforceInterface("com.zui.deviceidservice.IDeviceidInterface");
                boolean cw = cw();
                parcel2.writeNoException();
                parcel2.writeInt(cw ? 1 : 0);
                return true;
            }
            if (i6 == 4) {
                parcel.enforceInterface("com.zui.deviceidservice.IDeviceidInterface");
                String j7 = j(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeString(j7);
                return true;
            }
            if (i6 != 5) {
                if (i6 != 1598968902) {
                    return super.onTransact(i6, parcel, parcel2, i7);
                }
                parcel2.writeString("com.zui.deviceidservice.IDeviceidInterface");
                return true;
            }
            parcel.enforceInterface("com.zui.deviceidservice.IDeviceidInterface");
            String xt2 = xt(parcel.readString());
            parcel2.writeNoException();
            parcel2.writeString(xt2);
            return true;
        }
    }

    boolean cw();

    String j();

    String j(String str);

    String xt();

    String xt(String str);
}
