package ms.bz.bd.c.Pgl;

import android.text.TextUtils;
import com.google.common.base.Ascii;
import io.netty.handler.codec.http.HttpConstants;
import io.netty.handler.codec.memcache.binary.BinaryMemcacheOpcodes;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import ms.bz.bd.c.Pgl.pbly;

/* loaded from: D:\Downloads\app\classes8.dex */
final class h extends pbly.pgla {
    @Override // ms.bz.bd.c.Pgl.pbly.pgla
    public final Object b(long j6, String str, Object obj) throws Throwable {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface nextElement = networkInterfaces.nextElement();
                Enumeration<InetAddress> inetAddresses = nextElement.getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress nextElement2 = inetAddresses.nextElement();
                    String name = nextElement.getName();
                    if (!TextUtils.isEmpty(name) && !nextElement2.isLoopbackAddress() && (nextElement2 instanceof Inet4Address) && name.startsWith((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "b89079", new byte[]{97, 55, 68, 65, 28}))) {
                        com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "59fc1b", new byte[]{45, 53, 16, 3, 47, 113, 50, 10, 50, 32, 55, 123, Ascii.ESC, 22, 3, 112, 108});
                        nextElement.getName();
                        return nextElement.getName();
                    }
                }
            }
            return "";
        } catch (SocketException unused) {
            com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "aa0a2b", new byte[]{119, 102, 87, 85, BinaryMemcacheOpcodes.GATKQ, 101, 67, 68, 101, BinaryMemcacheOpcodes.GATK, 117, 112, 80, 85, 11, 116, 107, 76, HttpConstants.SEMICOLON});
            return "";
        }
    }

    h() {
    }
}
