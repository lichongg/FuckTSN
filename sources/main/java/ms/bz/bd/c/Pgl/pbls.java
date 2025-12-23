package ms.bz.bd.c.Pgl;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.google.common.base.Ascii;
import io.netty.handler.codec.memcache.binary.BinaryMemcacheOpcodes;
import ms.bz.bd.c.Pgl.pblk;

/* loaded from: D:\Downloads\app\classes8.dex */
public final class pbls {

    /* renamed from: a, reason: collision with root package name */
    private final Context f50348a;

    /* renamed from: b, reason: collision with root package name */
    pblt f50349b;

    /* renamed from: c, reason: collision with root package name */
    ServiceConnection f50350c = new pgla();

    final class pgla implements ServiceConnection {
        pgla() {
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            pbls.this.f50349b = new pblt(iBinder);
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
        }
    }

    public final void a(pblk.pblb pblbVar) {
        Intent intent = new Intent();
        intent.setClassName((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "abbaa0", new byte[]{115, 111, 28, 91, 68, 50, 107, 13, 55, 52, 102, 105, 18, 16, 87, BinaryMemcacheOpcodes.GATK, 113, 70, BinaryMemcacheOpcodes.SASL_AUTH, 39, 121, 99, 20}), (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "eee3bb", new byte[]{119, 104, Ascii.ESC, 9, 71, 96, 111, 10, 48, 102, 98, 110, 21, 66, 84, 113, 117, 65, 38, 117, 125, 100, 19, 9, 121, 112, 112, 77, 55, 102, 125, 99, 37, 66, 79, 99, 111, 71, 49}));
        if (this.f50348a.bindService(intent, this.f50350c, 1)) {
            try {
                pblt pbltVar = this.f50349b;
                if (pbltVar != null) {
                    String j6 = pbltVar.j();
                    if (pblbVar != null) {
                        pblbVar.j(j6);
                    }
                }
            } catch (Throwable unused) {
            }
            this.f50348a.unbindService(this.f50350c);
        }
    }

    public pbls(Context context) {
        this.f50348a = context;
    }
}
