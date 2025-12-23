package com.bytedance.embedapplog;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.bytedance.embedapplog.ki;

/* loaded from: D:\Downloads\app\classes3.dex */
public interface t extends IInterface {

    public static abstract class j extends Binder implements t {

        /* renamed from: com.bytedance.embedapplog.t$j$j, reason: collision with other inner class name */
        static class C0338j implements t {

            /* renamed from: j, reason: collision with root package name */
            public static t f24054j;
            private IBinder xt;

            @Override // com.bytedance.embedapplog.t
            public void j(int i6, long j6, boolean z5, float f6, double d6, String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.hihonor.cloudservice.oaid.IOAIDService");
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

            C0338j(IBinder iBinder) {
                this.xt = iBinder;
            }

            @Override // com.bytedance.embedapplog.t
            public void xt(ki kiVar) {
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.hihonor.cloudservice.oaid.IOAIDService");
                    if (kiVar != null) {
                        iBinder = kiVar.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    if (!this.xt.transact(3, obtain, obtain2, 0) && j.j() != null) {
                        j.j().xt(kiVar);
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

            @Override // com.bytedance.embedapplog.t
            public void j(ki kiVar) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.hihonor.cloudservice.oaid.IOAIDService");
                    obtain.writeStrongBinder(kiVar != null ? kiVar.asBinder() : null);
                    if (!this.xt.transact(2, obtain, obtain2, 0) && j.j() != null) {
                        j.j().j(kiVar);
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

        public static t j(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.hihonor.cloudservice.oaid.IOAIDService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof t)) ? new C0338j(iBinder) : (t) queryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i6, Parcel parcel, Parcel parcel2, int i7) {
            if (i6 == 1) {
                parcel.enforceInterface("com.hihonor.cloudservice.oaid.IOAIDService");
                j(parcel.readInt(), parcel.readLong(), parcel.readInt() != 0, parcel.readFloat(), parcel.readDouble(), parcel.readString());
                parcel2.writeNoException();
                return true;
            }
            if (i6 == 2) {
                parcel.enforceInterface("com.hihonor.cloudservice.oaid.IOAIDService");
                j(ki.j.j(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            }
            if (i6 != 3) {
                if (i6 != 1598968902) {
                    return super.onTransact(i6, parcel, parcel2, i7);
                }
                parcel2.writeString("com.hihonor.cloudservice.oaid.IOAIDService");
                return true;
            }
            parcel.enforceInterface("com.hihonor.cloudservice.oaid.IOAIDService");
            xt(ki.j.j(parcel.readStrongBinder()));
            parcel2.writeNoException();
            return true;
        }

        public static t j() {
            return C0338j.f24054j;
        }
    }

    void j(int i6, long j6, boolean z5, float f6, double d6, String str);

    void j(ki kiVar);

    void xt(ki kiVar);
}
