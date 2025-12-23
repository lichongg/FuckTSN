package com.beizi.fusion.d.b;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public interface a extends IInterface {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.beizi.fusion.d.b.a$a, reason: collision with other inner class name */
    public static final class C0129a implements a {

        /* renamed from: a, reason: collision with root package name */
        private IBinder f13413a;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this.f13413a;
        }

        public C0129a(IBinder iBinder) {
            this.f13413a = iBinder;
        }

        public String a() {
            String str;
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.asus.msa.SupplementaryDID.IDidAidlInterface");
                this.f13413a.transact(3, obtain, obtain2, 0);
                obtain2.readException();
                str = obtain2.readString();
            } catch (Throwable th) {
                obtain.recycle();
                obtain2.recycle();
                th.printStackTrace();
                str = null;
            }
            obtain.recycle();
            obtain2.recycle();
            return str;
        }
    }
}
