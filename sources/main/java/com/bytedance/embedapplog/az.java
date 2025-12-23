package com.bytedance.embedapplog;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: D:\Downloads\app\classes3.dex */
public interface az extends IInterface {

    public static abstract class j extends Binder implements az {

        /* renamed from: com.bytedance.embedapplog.az$j$j, reason: collision with other inner class name */
        static class C0333j implements az {

            /* renamed from: j, reason: collision with root package name */
            private IBinder f23979j;

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f23979j;
            }

            C0333j(IBinder iBinder) {
                this.f23979j = iBinder;
            }

            @Override // com.bytedance.embedapplog.az
            public String cw() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.asus.msa.SupplementaryDID.IDidAidlInterface");
                    this.f23979j.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.bytedance.embedapplog.az
            public boolean j() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.asus.msa.SupplementaryDID.IDidAidlInterface");
                    boolean z5 = false;
                    this.f23979j.transact(1, obtain, obtain2, 0);
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

            @Override // com.bytedance.embedapplog.az
            public String r() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.asus.msa.SupplementaryDID.IDidAidlInterface");
                    this.f23979j.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.bytedance.embedapplog.az
            public String up() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.asus.msa.SupplementaryDID.IDidAidlInterface");
                    this.f23979j.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.bytedance.embedapplog.az
            public String xt() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.asus.msa.SupplementaryDID.IDidAidlInterface");
                    this.f23979j.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static az j(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.asus.msa.SupplementaryDID.IDidAidlInterface");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof az)) ? new C0333j(iBinder) : (az) queryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i6, Parcel parcel, Parcel parcel2, int i7) {
            if (i6 == 1) {
                parcel.enforceInterface("com.asus.msa.SupplementaryDID.IDidAidlInterface");
                boolean j6 = j();
                parcel2.writeNoException();
                parcel2.writeInt(j6 ? 1 : 0);
                return true;
            }
            if (i6 == 2) {
                parcel.enforceInterface("com.asus.msa.SupplementaryDID.IDidAidlInterface");
                String xt = xt();
                parcel2.writeNoException();
                parcel2.writeString(xt);
                return true;
            }
            if (i6 == 3) {
                parcel.enforceInterface("com.asus.msa.SupplementaryDID.IDidAidlInterface");
                String cw = cw();
                parcel2.writeNoException();
                parcel2.writeString(cw);
                return true;
            }
            if (i6 == 4) {
                parcel.enforceInterface("com.asus.msa.SupplementaryDID.IDidAidlInterface");
                String r5 = r();
                parcel2.writeNoException();
                parcel2.writeString(r5);
                return true;
            }
            if (i6 != 5) {
                if (i6 != 1598968902) {
                    return super.onTransact(i6, parcel, parcel2, i7);
                }
                parcel2.writeString("com.asus.msa.SupplementaryDID.IDidAidlInterface");
                return true;
            }
            parcel.enforceInterface("com.asus.msa.SupplementaryDID.IDidAidlInterface");
            String up = up();
            parcel2.writeNoException();
            parcel2.writeString(up);
            return true;
        }
    }

    String cw();

    boolean j();

    String r();

    String up();

    String xt();
}
