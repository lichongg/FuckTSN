package com.kwad.framework.filedownloader.c;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.kwad.framework.filedownloader.message.MessageSnapshot;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public interface a extends IInterface {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.kwad.framework.filedownloader.c.a$a, reason: collision with other inner class name */
    public static abstract class AbstractBinderC0656a extends Binder implements a {

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        /* renamed from: com.kwad.framework.filedownloader.c.a$a$a, reason: collision with other inner class name */
        static class C0657a implements a {
            public static a aoC;
            private IBinder mRemote;

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.mRemote;
            }

            C0657a(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // com.kwad.framework.filedownloader.c.a
            public final void q(MessageSnapshot messageSnapshot) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.kwad.framework.filedownloader.i.IFileDownloadIPCCallback");
                    if (messageSnapshot != null) {
                        obtain.writeInt(1);
                        messageSnapshot.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.mRemote.transact(1, obtain, null, 1) && AbstractBinderC0656a.yI() != null) {
                        AbstractBinderC0656a.yI().q(messageSnapshot);
                        obtain.recycle();
                    } else {
                        obtain.recycle();
                    }
                } catch (Throwable th) {
                    obtain.recycle();
                    throw th;
                }
            }
        }

        public static a c(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.kwad.framework.filedownloader.i.IFileDownloadIPCCallback");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof a)) ? new C0657a(iBinder) : (a) queryLocalInterface;
        }

        public static a yI() {
            return C0657a.aoC;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i6, Parcel parcel, Parcel parcel2, int i7) {
            if (i6 == 1) {
                parcel.enforceInterface("com.kwad.framework.filedownloader.i.IFileDownloadIPCCallback");
                q(parcel.readInt() != 0 ? MessageSnapshot.CREATOR.createFromParcel(parcel) : null);
                return true;
            }
            if (i6 != 1598968902) {
                return super.onTransact(i6, parcel, parcel2, i7);
            }
            parcel2.writeString("com.kwad.framework.filedownloader.i.IFileDownloadIPCCallback");
            return true;
        }

        public AbstractBinderC0656a() {
            attachInterface(this, "com.kwad.framework.filedownloader.i.IFileDownloadIPCCallback");
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }

    void q(MessageSnapshot messageSnapshot);
}
