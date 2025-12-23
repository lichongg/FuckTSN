package ms.bz.bd.c.Pgl;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.IBinder;
import com.google.common.base.Ascii;
import io.netty.handler.codec.http.HttpConstants;
import io.netty.handler.codec.memcache.binary.BinaryMemcacheOpcodes;
import java.util.concurrent.LinkedBlockingQueue;
import ms.bz.bd.c.Pgl.pblk;
import okio.Utf8;

/* loaded from: D:\Downloads\app\classes8.dex */
public final class pblo {

    /* renamed from: a, reason: collision with root package name */
    private final Context f50342a;

    /* renamed from: b, reason: collision with root package name */
    public final LinkedBlockingQueue<IBinder> f50343b = new LinkedBlockingQueue<>(1024);

    /* renamed from: c, reason: collision with root package name */
    ServiceConnection f50344c = new pgla();

    final class pgla implements ServiceConnection {
        pgla() {
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                pblo.this.f50343b.put(iBinder);
            } catch (Exception unused) {
            }
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
        }
    }

    public final void a(pblk.pblb pblbVar) {
        int i6 = Build.VERSION.SDK_INT;
        if (i6 != 28 && i6 < 33) {
            try {
                this.f50342a.getPackageManager().getPackageInfo((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "f8dffb", new byte[]{116, 53, 26, 92, 81, 96, 100, 14, 48, Utf8.REPLACEMENT_BYTE, 57, 50, 0, Ascii.ESC, 93}), 0);
            } catch (Exception unused) {
            }
            Intent intent = new Intent((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "61cd07", new byte[]{BinaryMemcacheOpcodes.GATKQ, 60, 29, 94, 26, 47, 49, 25, BinaryMemcacheOpcodes.SASL_AUTH, 122, 40, BinaryMemcacheOpcodes.GATK, 21, 30, 11, 37, BinaryMemcacheOpcodes.GATK, 25, 49, 49, 105, 28, 32, 53, BinaryMemcacheOpcodes.SASL_AUTH, 9, 17, BinaryMemcacheOpcodes.GATK, 13, 7, 2, 1, 38, 57, HttpConstants.COMMA, 5}));
            intent.setPackage((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "c0f2f2", new byte[]{113, 61, 24, 8, 81, 48, 97, 6, 50, 107, 60, HttpConstants.COLON, 2, 79, 93}));
            if (this.f50342a.bindService(intent, this.f50344c, 1)) {
                try {
                    String j6 = new pblp(this.f50343b.take()).j();
                    if (pblbVar != null) {
                        pblbVar.j(j6);
                    }
                } catch (Exception unused2) {
                } catch (Throwable th) {
                    this.f50342a.unbindService(this.f50344c);
                    throw th;
                }
                this.f50342a.unbindService(this.f50344c);
            }
        }
    }

    public pblo(Context context) {
        this.f50342a = context;
    }
}
