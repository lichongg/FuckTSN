package com.ss.android.downloadlib.j.j;

import android.annotation.SuppressLint;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.text.TextUtils;
import com.kuaishou.weapon.p0.t;
import com.ss.android.downloadlib.addownload.m;
import com.ss.android.downloadlib.j.j.r;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes6.dex */
public interface cw extends IInterface {

    public static abstract class j extends Binder implements cw {

        /* renamed from: a, reason: collision with root package name */
        private static String f38184a = "";

        private static class a implements cw {

            /* renamed from: a, reason: collision with root package name */
            private IBinder f38185a;

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f38185a;
            }

            a(IBinder iBinder) {
                if (TextUtils.isEmpty(j.f38184a)) {
                    JSONObject f6 = m.f();
                    String unused = j.f38184a = com.ss.android.socialbase.appdownloader.m.a.b(f6.optString(t.f36150k), f6.optString("s"));
                }
                this.f38185a = iBinder;
            }

            @Override // com.ss.android.downloadlib.j.j.cw
            public void b(xt xtVar, r rVar) throws RemoteException {
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(j.f38184a);
                    if (xtVar != null) {
                        obtain.writeInt(1);
                        xtVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (rVar != null) {
                        iBinder = rVar.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.f38185a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    obtain2.recycle();
                    obtain.recycle();
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    throw th;
                }
            }
        }

        public static cw e(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(f38184a);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof cw)) ? new a(iBinder) : (cw) queryLocalInterface;
        }

        @Override // android.os.Binder
        @SuppressLint({"WrongConstant"})
        public boolean onTransact(int i6, Parcel parcel, Parcel parcel2, int i7) throws RemoteException {
            xt xtVar;
            if (i6 != 1598968902) {
                if (i6 != 1) {
                    return super.onTransact(i6, parcel, parcel2, i7);
                }
                parcel.enforceInterface(f38184a);
                if (parcel.readInt() != 0) {
                    xtVar = xt.CREATOR.createFromParcel(parcel);
                } else {
                    xtVar = null;
                }
                b(xtVar, r.j.e(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            }
            parcel2.writeString(f38184a);
            return true;
        }
    }

    void b(xt xtVar, r rVar) throws RemoteException;
}
