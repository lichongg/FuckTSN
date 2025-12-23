package com.beizi.fusion.d.b;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public interface b extends IInterface {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a implements b {

        /* renamed from: a, reason: collision with root package name */
        private IBinder f13414a;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this.f13414a;
        }

        public a(IBinder iBinder) {
            this.f13414a = iBinder;
        }

        public String a() {
            String str;
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
                this.f13414a.transact(1, obtain, obtain2, 0);
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

        public boolean b() {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            boolean z5 = false;
            try {
                obtain.writeInterfaceToken("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
                this.f13414a.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                if (obtain2.readInt() == 0) {
                    z5 = true;
                }
            } catch (Throwable unused) {
                obtain.recycle();
                obtain2.recycle();
            }
            obtain.recycle();
            obtain2.recycle();
            return z5;
        }
    }
}
