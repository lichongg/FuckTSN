package com.bytedance.embedapplog;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: D:\Downloads\app\classes3.dex */
public interface av extends IInterface {

    public static abstract class j extends Binder implements av {

        /* renamed from: com.bytedance.embedapplog.av$j$j, reason: collision with other inner class name */
        static class C0332j implements av {

            /* renamed from: j, reason: collision with root package name */
            private IBinder f23978j;

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f23978j;
            }

            C0332j(IBinder iBinder) {
                this.f23978j = iBinder;
            }

            @Override // com.bytedance.embedapplog.av
            public String j(String str, String str2, String str3) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.heytap.openid.IOpenID");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    this.f23978j.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static av j(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.heytap.openid.IOpenID");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof av)) ? new C0332j(iBinder) : (av) queryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i6, Parcel parcel, Parcel parcel2, int i7) {
            if (i6 != 1) {
                if (i6 != 1598968902) {
                    return super.onTransact(i6, parcel, parcel2, i7);
                }
                parcel2.writeString("com.heytap.openid.IOpenID");
                return true;
            }
            parcel.enforceInterface("com.heytap.openid.IOpenID");
            String j6 = j(parcel.readString(), parcel.readString(), parcel.readString());
            parcel2.writeNoException();
            parcel2.writeString(j6);
            return true;
        }
    }

    String j(String str, String str2, String str3);
}
