package ms.bz.bd.c.Pgl;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.bytedance.sdk.component.utils.vl;
import io.netty.handler.codec.http.HttpConstants;
import io.netty.handler.codec.memcache.binary.BinaryMemcacheOpcodes;

/* loaded from: D:\Downloads\app\classes8.dex */
public final class pblt implements IInterface {

    /* renamed from: a, reason: collision with root package name */
    private final IBinder f50352a;

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return null;
    }

    public pblt(IBinder iBinder) {
        this.f50352a = iBinder;
    }

    public final String j() {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            try {
                obtain.writeInterfaceToken((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "d68e76", new byte[]{118, HttpConstants.SEMICOLON, 70, 95, 18, 52, 110, 89, 109, 48, 99, 61, 72, 20, 1, 37, 116, 18, 123, BinaryMemcacheOpcodes.GATK, 124, 55, 78, 95, BinaryMemcacheOpcodes.SASL_AUTH, 5, 98, 1, 96, 54, 112, 61, 79, 56, 6, 53, 98, 5, 111, 52, 118, 49}));
                this.f50352a.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                return obtain2.readString();
            } catch (Exception e6) {
                vl.j(e6);
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
