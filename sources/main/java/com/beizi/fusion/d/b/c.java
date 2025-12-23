package com.beizi.fusion.d.b;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public interface c extends IInterface {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static abstract class a extends Binder implements c {

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        /* renamed from: com.beizi.fusion.d.b.c$a$a, reason: collision with other inner class name */
        public static class C0130a implements c {

            /* renamed from: a, reason: collision with root package name */
            private IBinder f13415a;

            @Override // com.beizi.fusion.d.b.c
            public String a() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    try {
                        obtain.writeInterfaceToken("com.zui.deviceidservice.IDeviceidInterface");
                        this.f13415a.transact(1, obtain, obtain2, 0);
                        obtain2.readException();
                        return obtain2.readString();
                    } catch (Exception e6) {
                        e6.printStackTrace();
                        obtain2.recycle();
                        obtain.recycle();
                        return null;
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return null;
            }

            @Override // com.beizi.fusion.d.b.c
            public String b() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    try {
                        obtain.writeInterfaceToken("com.zui.deviceidservice.IDeviceidInterface");
                        this.f13415a.transact(2, obtain, obtain2, 0);
                        obtain2.readException();
                        return obtain2.readString();
                    } catch (Exception e6) {
                        e6.printStackTrace();
                        obtain2.recycle();
                        obtain.recycle();
                        return null;
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public C0130a(IBinder iBinder) {
                this.f13415a = iBinder;
            }

            @Override // com.beizi.fusion.d.b.c
            public boolean c() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                boolean z5 = false;
                try {
                    obtain.writeInterfaceToken("com.zui.deviceidservice.IDeviceidInterface");
                    this.f13415a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z5 = true;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return z5;
                } catch (Throwable unused) {
                    obtain2.recycle();
                    obtain.recycle();
                    return z5;
                }
            }

            @Override // com.beizi.fusion.d.b.c
            public String a(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    try {
                        obtain.writeInterfaceToken("com.zui.deviceidservice.IDeviceidInterface");
                        this.f13415a.transact(4, obtain, obtain2, 0);
                        obtain2.readException();
                        return obtain2.readString();
                    } catch (Exception e6) {
                        e6.printStackTrace();
                        obtain2.recycle();
                        obtain.recycle();
                        return null;
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.beizi.fusion.d.b.c
            public String b(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    try {
                        obtain.writeInterfaceToken("com.zui.deviceidservice.IDeviceidInterface");
                        this.f13415a.transact(5, obtain, obtain2, 0);
                        obtain2.readException();
                        return obtain2.readString();
                    } catch (Exception e6) {
                        e6.printStackTrace();
                        obtain2.recycle();
                        obtain.recycle();
                        return null;
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        @Override // android.os.Binder
        protected boolean onTransact(int i6, Parcel parcel, Parcel parcel2, int i7) throws RemoteException {
            if (i6 == 1) {
                parcel.enforceInterface("com.zui.deviceidservice.IDeviceidInterface");
                String a6 = a();
                parcel2.writeNoException();
                parcel2.writeString(a6);
                return true;
            }
            if (i6 == 2) {
                parcel.enforceInterface("com.zui.deviceidservice.IDeviceidInterface");
                String b6 = b();
                parcel2.writeNoException();
                parcel2.writeString(b6);
                return true;
            }
            if (i6 == 3) {
                parcel.enforceInterface("com.zui.deviceidservice.IDeviceidInterface");
                boolean c6 = c();
                parcel2.writeNoException();
                parcel2.writeInt(c6 ? 1 : 0);
                return true;
            }
            if (i6 == 4) {
                parcel.enforceInterface("com.zui.deviceidservice.IDeviceidInterface");
                String a7 = a(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeString(a7);
                return true;
            }
            if (i6 != 5) {
                if (i6 != 1598968902) {
                    return super.onTransact(i6, parcel, parcel2, i7);
                }
                parcel2.writeString("com.zui.deviceidservice.IDeviceidInterface");
                return true;
            }
            parcel.enforceInterface("com.zui.deviceidservice.IDeviceidInterface");
            String b7 = b(parcel.readString());
            parcel2.writeNoException();
            parcel2.writeString(b7);
            return true;
        }
    }

    String a();

    String a(String str);

    String b();

    String b(String str);

    boolean c();
}
