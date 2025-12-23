package com.ss.android.downloadlib.j.j;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.text.TextUtils;
import com.ss.android.downloadlib.addownload.m;
import com.umeng.analytics.pro.bi;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes6.dex */
public interface r extends IInterface {

    public static abstract class j extends Binder implements r {

        /* renamed from: a, reason: collision with root package name */
        private static String f38186a = "";

        private static class a implements r {

            /* renamed from: a, reason: collision with root package name */
            private IBinder f38187a;

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f38187a;
            }

            a(IBinder iBinder) {
                if (TextUtils.isEmpty(j.f38186a)) {
                    JSONObject f6 = m.f();
                    String unused = j.f38186a = com.ss.android.socialbase.appdownloader.m.a.b(f6.optString(bi.aL), f6.optString("s"));
                }
                this.f38187a = iBinder;
            }

            @Override // com.ss.android.downloadlib.j.j.r
            public void a(xt xtVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(j.f38186a);
                    if (xtVar != null) {
                        obtain.writeInt(1);
                        xtVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f38187a.transact(1, obtain, obtain2, 0);
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

        @Override // android.os.Binder
        public boolean onTransact(int i6, Parcel parcel, Parcel parcel2, int i7) throws RemoteException {
            if (i6 == 1) {
                parcel.enforceInterface(f38186a);
                a(parcel.readInt() != 0 ? xt.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                return true;
            }
            if (i6 != 1598968902) {
                return super.onTransact(i6, parcel, parcel2, i7);
            }
            parcel2.writeString(f38186a);
            return true;
        }

        public static r e(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(f38186a);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof r)) ? new a(iBinder) : (r) queryLocalInterface;
        }
    }

    void a(xt xtVar) throws RemoteException;
}
