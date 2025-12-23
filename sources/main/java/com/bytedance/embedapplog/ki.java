package com.bytedance.embedapplog;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: D:\Downloads\app\classes3.dex */
public interface ki extends IInterface {

    public static abstract class j extends Binder implements ki {

        /* renamed from: com.bytedance.embedapplog.ki$j$j, reason: collision with other inner class name */
        static class C0336j implements ki {

            /* renamed from: j, reason: collision with root package name */
            public static ki f24006j;
            private IBinder xt;

            @Override // com.bytedance.embedapplog.ki
            public void j(int i6, long j6, boolean z5, float f6, double d6, String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.hihonor.cloudservice.oaid.IOAIDCallBack");
                    obtain.writeInt(i6);
                    obtain.writeLong(j6);
                    obtain.writeInt(z5 ? 1 : 0);
                    obtain.writeFloat(f6);
                    obtain.writeDouble(d6);
                    obtain.writeString(str);
                    if (this.xt.transact(1, obtain, obtain2, 0) || j.j() == null) {
                        obtain2.readException();
                    } else {
                        j.j().j(i6, j6, z5, f6, d6, str);
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

            C0336j(IBinder iBinder) {
                this.xt = iBinder;
            }

            @Override // com.bytedance.embedapplog.ki
            public void j(int i6, Bundle bundle) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.hihonor.cloudservice.oaid.IOAIDCallBack");
                    obtain.writeInt(i6);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.xt.transact(2, obtain, obtain2, 0) && j.j() != null) {
                        j.j().j(i6, bundle);
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
        }

        public static ki j(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.hihonor.cloudservice.oaid.IOAIDCallBack");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof ki)) ? new C0336j(iBinder) : (ki) queryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i6, Parcel parcel, Parcel parcel2, int i7) {
            if (i6 == 1) {
                parcel.enforceInterface("com.hihonor.cloudservice.oaid.IOAIDCallBack");
                j(parcel.readInt(), parcel.readLong(), parcel.readInt() != 0, parcel.readFloat(), parcel.readDouble(), parcel.readString());
                parcel2.writeNoException();
                return true;
            }
            if (i6 != 2) {
                if (i6 != 1598968902) {
                    return super.onTransact(i6, parcel, parcel2, i7);
                }
                parcel2.writeString("com.hihonor.cloudservice.oaid.IOAIDCallBack");
                return true;
            }
            parcel.enforceInterface("com.hihonor.cloudservice.oaid.IOAIDCallBack");
            j(parcel.readInt(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
            parcel2.writeNoException();
            return true;
        }

        public j() {
            attachInterface(this, "com.hihonor.cloudservice.oaid.IOAIDCallBack");
        }

        public static ki j() {
            return C0336j.f24006j;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }

    void j(int i6, long j6, boolean z5, float f6, double d6, String str);

    void j(int i6, Bundle bundle);
}
