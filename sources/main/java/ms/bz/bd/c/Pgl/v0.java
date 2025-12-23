package ms.bz.bd.c.Pgl;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import io.netty.handler.codec.memcache.binary.BinaryMemcacheOpcodes;
import java.io.File;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* loaded from: D:\Downloads\app\classes8.dex */
public final class v0 {
    public static void a() {
        pbly.b(65537, new o0());
        pbly.b(65538, new p0());
        pbly.b(65539, new q0());
        pbly.b(InputDeviceCompat.SOURCE_TRACKBALL, new r0());
        pbly.b(65541, new s0());
        pbly.b(65542, new t0());
        pbly.b(65543, new u0());
        r1 r1Var = new r1();
        pbly.b(196609, r1Var);
        pbly.b(196610, r1Var);
        pbly.b(196611, r1Var);
        pblw o1Var = pbli.a() ? new o1() : new pblj();
        pblw.f(o1Var);
        pbly.b(IjkMediaPlayer.OnNativeInvokeListener.CTRL_WILL_TCP_OPEN, o1Var);
        pbly.b(IjkMediaPlayer.OnNativeInvokeListener.CTRL_DID_TCP_OPEN, o1Var);
        com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "cf6e7f", new byte[]{119, 114, SignedBytes.MAX_POWER_OF_TWO, Ascii.US, 28, 93, 111, SignedBytes.MAX_POWER_OF_TWO, 74, 52, 124, 101, 66, 20, 26, 49, 99, 75, 102, 38, 97, BinaryMemcacheOpcodes.GATKQ, 76, 2, 72});
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean c(Context context, String str, String str2) {
        try {
            String[] list = context.getAssets().list(str);
            if (list.length <= 0) {
                throw null;
            }
            new File(str2).mkdirs();
            for (String str3 : list) {
                c(context, str + ((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "f7d399", new byte[]{56})) + str3, str2 + ((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "5e96a0", new byte[]{107})) + str3);
            }
            return true;
        } catch (Exception unused) {
            com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "d3691d", new byte[]{118, 48, 67});
            return false;
        }
    }
}
