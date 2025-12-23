package ms.bz.bd.c.Pgl;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import io.netty.handler.codec.memcache.binary.BinaryMemcacheOpcodes;
import okio.Utf8;

/* loaded from: D:\Downloads\app\classes8.dex */
public final class pblb implements IInterface {

    /* renamed from: a, reason: collision with root package name */
    private final IBinder f50319a;

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f50319a;
    }

    public pblb(IBinder iBinder) {
        this.f50319a = iBinder;
    }

    public final String j() {
        String str;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "6d8a6e", new byte[]{BinaryMemcacheOpcodes.GATKQ, 105, 70, 91, 8, 97, 32, 86, 39, 60, 52, 103, 5, 38, 28, 98, 37, 73, 108, 60, 34, 104, 95, 20, Ascii.ESC, 107, 17, 108, 77, Byte.MAX_VALUE, 14, 66, 66, 17, 40, 123, 49, 73, SignedBytes.MAX_POWER_OF_TWO, Utf8.REPLACEMENT_BYTE, 51, 99, 89, 19, 8, 113, 48}));
            this.f50319a.transact(3, obtain, obtain2, 0);
            obtain2.readException();
            str = obtain2.readString();
        } catch (Throwable unused) {
            obtain.recycle();
            obtain2.recycle();
            str = null;
        }
        obtain.recycle();
        obtain2.recycle();
        return str;
    }
}
