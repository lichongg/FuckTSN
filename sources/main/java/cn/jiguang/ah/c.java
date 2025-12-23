package cn.jiguang.ah;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import cn.jiguang.bb.f;

/* loaded from: D:\Downloads\app\classes2.dex */
public interface c extends IInterface {

    public static abstract class a extends Binder implements c {

        /* renamed from: cn.jiguang.ah.c$a$a, reason: collision with other inner class name */
        public static class C0023a implements c {

            /* renamed from: a, reason: collision with root package name */
            private IBinder f1514a;

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f1514a;
            }

            public C0023a(IBinder iBinder) {
                this.f1514a = iBinder;
            }

            @Override // cn.jiguang.ah.c
            public String a() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(cn.jiguang.d.a.c("Halo+/ex0XYuOCl75w4mzBmlg/ol+vqLiEURlblgA+0="));
                    this.f1514a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } catch (Throwable th) {
                    try {
                        f.i("ZTEOAID", "getOAID obtain exception:" + th.getMessage());
                        obtain2.recycle();
                        obtain.recycle();
                        return null;
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
            }

            @Override // cn.jiguang.ah.c
            public boolean b() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                boolean z5 = false;
                try {
                    obtain.writeInterfaceToken(cn.jiguang.d.a.c("Halo+/ex0XYuOCl75w4mzBmlg/ol+vqLiEURlblgA+0="));
                    this.f1514a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z5 = true;
                    }
                } finally {
                    try {
                        return z5;
                    } finally {
                    }
                }
                return z5;
            }
        }
    }

    String a();

    boolean b();
}
