package ms.bz.bd.c.Pgl;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.bytedance.sdk.component.utils.vl;
import com.google.common.base.Ascii;
import io.netty.handler.codec.http.HttpConstants;

/* loaded from: D:\Downloads\app\classes8.dex */
public final class pblp implements IInterface {

    /* renamed from: a, reason: collision with root package name */
    private final IBinder f50346a;

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f50346a;
    }

    public pblp(IBinder iBinder) {
        this.f50346a = iBinder;
    }

    public final String j() {
        String str;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "f0e422", new byte[]{116, 61, Ascii.ESC, 14, 24, 42, 97, 24, 39, 42, 120, 34, 19, 78, 9, 32, 115, 24, 55, 97, 57, 51, Ascii.US, 68, 1, 107, 74, 1, 49, 106, 83, 55, 0, 73, 14, 32, 76, 21, 49, 106, 99, HttpConstants.SEMICOLON, 16, 73, 8, 55, 86, 20, 38, 114, 126, 49, 19}));
            this.f50346a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
            str = obtain2.readString();
        } catch (Throwable th) {
            obtain.recycle();
            obtain2.recycle();
            vl.j(th);
            str = null;
        }
        obtain.recycle();
        obtain2.recycle();
        return str;
    }
}
