package com.bytedance.embedapplog;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: D:\Downloads\app\classes3.dex */
public interface nu extends IInterface {

    public static abstract class j extends Binder implements nu {

        /* renamed from: com.bytedance.embedapplog.nu$j$j, reason: collision with other inner class name */
        static class C0337j implements nu {

            /* renamed from: j, reason: collision with root package name */
            private IBinder f24019j;

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f24019j;
            }

            C0337j(IBinder iBinder) {
                this.f24019j = iBinder;
            }

            @Override // com.bytedance.embedapplog.nu
            public String j() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
                    this.f24019j.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.bytedance.embedapplog.nu
            public boolean xt() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
                    boolean z5 = false;
                    this.f24019j.transact(2, obtain, obtain2, 0);
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
        }

        public static nu j(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof nu)) ? new C0337j(iBinder) : (nu) queryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i6, Parcel parcel, Parcel parcel2, int i7) {
            if (i6 == 1) {
                parcel.enforceInterface("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
                String j6 = j();
                parcel2.writeNoException();
                parcel2.writeString(j6);
                return true;
            }
            if (i6 != 2) {
                if (i6 != 1598968902) {
                    return super.onTransact(i6, parcel, parcel2, i7);
                }
                parcel2.writeString("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
                return true;
            }
            parcel.enforceInterface("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
            boolean xt = xt();
            parcel2.writeNoException();
            parcel2.writeInt(xt ? 1 : 0);
            return true;
        }
    }

    String j();

    boolean xt();
}
