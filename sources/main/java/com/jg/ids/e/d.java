package com.jg.ids.e;

import android.os.IBinder;
import android.os.Parcel;

/* loaded from: D:\Downloads\app\classes10.dex */
final class d implements b {

    /* renamed from: a, reason: collision with root package name */
    private IBinder f35521a;

    d(IBinder iBinder) {
        this.f35521a = iBinder;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f35521a;
    }

    @Override // com.jg.ids.e.b
    public final String a() {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
            if (!this.f35521a.transact(1, obtain, obtain2, 0)) {
            }
            obtain2.readException();
            String readString = obtain2.readString();
            obtain2.recycle();
            obtain.recycle();
            return readString;
        } catch (Exception e6) {
            obtain2.recycle();
            obtain.recycle();
            return "";
        } catch (Throwable th) {
            obtain2.recycle();
            obtain.recycle();
            throw th;
        }
    }

    @Override // com.jg.ids.e.b
    public final boolean a(boolean z5) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
            obtain.writeInt(z5 ? 1 : 0);
            if (!this.f35521a.transact(2, obtain, obtain2, 0)) {
            }
            obtain2.readException();
            return obtain2.readInt() != 0;
        } catch (Exception e6) {
            return false;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
}
