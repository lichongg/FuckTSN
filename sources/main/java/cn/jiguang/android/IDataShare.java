package cn.jiguang.android;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: D:\Downloads\app\classes2.dex */
public interface IDataShare extends IInterface {
    public static final String DESCRIPTOR = "cn.jiguang.android.IDataShare";

    public static abstract class Stub extends Binder implements IDataShare {
        static final int TRANSACTION_bind = 4;
        static final int TRANSACTION_execute = 3;
        static final int TRANSACTION_getBinderByType = 1;
        static final int TRANSACTION_onAction = 2;

        private static class a implements IDataShare {

            /* renamed from: a, reason: collision with root package name */
            private IBinder f1646a;

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f1646a;
            }

            a(IBinder iBinder) {
                this.f1646a = iBinder;
            }

            @Override // cn.jiguang.android.IDataShare
            public String bind(IDataShare iDataShare, String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IDataShare.DESCRIPTOR);
                    obtain.writeStrongInterface(iDataShare);
                    obtain.writeString(str);
                    this.f1646a.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // cn.jiguang.android.IDataShare
            public Bundle execute(String str, String str2, Bundle bundle) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IDataShare.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    _Parcel.writeTypedObject(obtain, bundle, 0);
                    this.f1646a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    return (Bundle) _Parcel.readTypedObject(obtain2, Bundle.CREATOR);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // cn.jiguang.android.IDataShare
            public IBinder getBinderByType(String str, String str2) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IDataShare.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.f1646a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readStrongBinder();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // cn.jiguang.android.IDataShare
            public void onAction(String str, String str2, Bundle bundle) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IDataShare.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    _Parcel.writeTypedObject(obtain, bundle, 0);
                    this.f1646a.transact(2, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public static IDataShare asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(IDataShare.DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IDataShare)) ? new a(iBinder) : (IDataShare) queryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i6, Parcel parcel, Parcel parcel2, int i7) {
            if (i6 >= 1 && i6 <= 16777215) {
                parcel.enforceInterface(IDataShare.DESCRIPTOR);
            }
            if (i6 == 1598968902) {
                parcel2.writeString(IDataShare.DESCRIPTOR);
                return true;
            }
            if (i6 == 1) {
                IBinder binderByType = getBinderByType(parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                parcel2.writeStrongBinder(binderByType);
            } else if (i6 == 2) {
                onAction(parcel.readString(), parcel.readString(), (Bundle) _Parcel.readTypedObject(parcel, Bundle.CREATOR));
            } else if (i6 == 3) {
                Bundle execute = execute(parcel.readString(), parcel.readString(), (Bundle) _Parcel.readTypedObject(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
                _Parcel.writeTypedObject(parcel2, execute, 1);
            } else {
                if (i6 != 4) {
                    return super.onTransact(i6, parcel, parcel2, i7);
                }
                String bind = bind(asInterface(parcel.readStrongBinder()), parcel.readString());
                parcel2.writeNoException();
                parcel2.writeString(bind);
            }
            return true;
        }

        public Stub() {
            attachInterface(this, IDataShare.DESCRIPTOR);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }

    public static class _Parcel {
        /* JADX INFO: Access modifiers changed from: private */
        public static <T extends Parcelable> void writeTypedObject(Parcel parcel, T t5, int i6) {
            if (t5 == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                t5.writeToParcel(parcel, i6);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static <T> T readTypedObject(Parcel parcel, Parcelable.Creator<T> creator) {
            if (parcel.readInt() != 0) {
                return creator.createFromParcel(parcel);
            }
            return null;
        }
    }

    String bind(IDataShare iDataShare, String str);

    Bundle execute(String str, String str2, Bundle bundle);

    IBinder getBinderByType(String str, String str2);

    void onAction(String str, String str2, Bundle bundle);

    public static class Default implements IDataShare {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // cn.jiguang.android.IDataShare
        public String bind(IDataShare iDataShare, String str) {
            return null;
        }

        @Override // cn.jiguang.android.IDataShare
        public Bundle execute(String str, String str2, Bundle bundle) {
            return null;
        }

        @Override // cn.jiguang.android.IDataShare
        public IBinder getBinderByType(String str, String str2) {
            return null;
        }

        @Override // cn.jiguang.android.IDataShare
        public void onAction(String str, String str2, Bundle bundle) {
        }
    }
}
