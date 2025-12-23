package com.kwad.sdk.core.e.b;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.kwad.sdk.core.e.b.c;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public interface b extends IInterface {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class a extends Binder implements b {
        private IBinder aGc;

        public final void a(c cVar) {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.hihonor.cloudservice.oaid.IOAIDService");
                obtain.writeStrongBinder(cVar != null ? (c.a) cVar : null);
                this.aGc.transact(2, obtain, obtain2, 0);
                com.kwad.sdk.core.d.c.d("HONORDeviceIDHelper", "gets + " + this.aGc);
                obtain2.readException();
            } finally {
                try {
                } finally {
                }
            }
        }

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return this.aGc;
        }

        public a(IBinder iBinder) {
            this.aGc = iBinder;
        }

        public final void b(c cVar) {
            c.a aVar;
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.hihonor.cloudservice.oaid.IOAIDService");
                if (cVar != null) {
                    aVar = (c.a) cVar;
                } else {
                    aVar = null;
                }
                obtain.writeStrongBinder(aVar);
                this.aGc.transact(3, obtain, obtain2, 0);
                obtain2.readException();
            } finally {
                try {
                } finally {
                }
            }
        }
    }
}
