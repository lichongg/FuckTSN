package ms.bz.bd.c.Pgl;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import io.netty.handler.codec.http.HttpConstants;
import io.netty.handler.codec.memcache.binary.BinaryMemcacheOpcodes;
import java.util.concurrent.LinkedBlockingQueue;
import ms.bz.bd.c.Pgl.pblk;
import okio.Utf8;

/* loaded from: D:\Downloads\app\classes8.dex */
public final class pgla {

    /* renamed from: a, reason: collision with root package name */
    private final Context f50382a;

    /* renamed from: b, reason: collision with root package name */
    public final LinkedBlockingQueue<IBinder> f50383b = new LinkedBlockingQueue<>(1024);

    /* renamed from: c, reason: collision with root package name */
    ServiceConnection f50384c = new ServiceConnectionC0976pgla();

    /* renamed from: ms.bz.bd.c.Pgl.pgla$pgla, reason: collision with other inner class name */
    final class ServiceConnectionC0976pgla implements ServiceConnection {
        ServiceConnectionC0976pgla() {
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                pgla.this.f50383b.put(iBinder);
            } catch (Exception unused) {
            }
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
        }
    }

    public final void a(pblk.pblb pblbVar) {
        try {
            this.f50382a.getPackageManager().getPackageInfo((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "de219c", new byte[]{118, 104, 76, 11, 7, 103, 114, 87, 45, 108, 102, 102, 15, 118, 19, 100, 119, 72, 102, 108, 112, 105, 85, 68, 20, 109, 67, 109, 71}), 0);
        } catch (Exception unused) {
        }
        Intent intent = new Intent();
        intent.setAction((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "cc6ac1", new byte[]{113, 110, 72, 91, 93, 53, 117, 81, 41, 60, 97, 96, 11, 20, 95, 50, 105, 77, 105, Byte.MAX_VALUE, 83, 66, 102, 48, 111, 21, 95, 102, 78, 21}));
        intent.setComponent(new ComponentName((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "ce5541", new byte[]{113, 104, 75, 15, 10, 53, 117, 87, 42, 104, 97, 102, 8, 114, 30, 54, 112, 72, 97, 104, 119, 105, 82, SignedBytes.MAX_POWER_OF_TWO, 25, Utf8.REPLACEMENT_BYTE, 68, 109, SignedBytes.MAX_POWER_OF_TWO}), (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "ace329", new byte[]{115, 110, Ascii.ESC, 9, 12, 61, 119, 81, 122, 110, 99, 96, 88, 116, 24, 62, 114, 78, 49, 110, 117, 111, 2, 70, Ascii.US, 55, 70, 107, 16, 45, 67, 116, 6, 87, 1, 43, 111, 71, HttpConstants.COLON, 119, 113, 115, 15, 99, BinaryMemcacheOpcodes.GATKQ, 10, 81, 71, 38, 117, 121, 98, 19})));
        if (this.f50382a.bindService(intent, this.f50384c, 1)) {
            try {
                String j6 = new pblb(this.f50383b.take()).j();
                if (pblbVar != null) {
                    pblbVar.j(j6);
                }
            } catch (Exception unused2) {
            } catch (Throwable th) {
                this.f50382a.unbindService(this.f50384c);
                throw th;
            }
            this.f50382a.unbindService(this.f50384c);
        }
    }

    public pgla(Context context) {
        this.f50382a = context;
    }
}
