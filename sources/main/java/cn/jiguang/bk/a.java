package cn.jiguang.bk;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import cn.jiguang.bb.f;
import cn.jiguang.bg.c;
import cn.jiguang.bz.u;
import cn.jiguang.bz.v;
import com.amap.api.services.core.AMapException;
import java.nio.ByteBuffer;

/* loaded from: D:\Downloads\app\classes2.dex */
public class a {
    public static Pair<c, ByteBuffer> a(Context context, byte[] bArr, String str) {
        String str2;
        int i6;
        ByteBuffer wrap;
        if (bArr.length < 20) {
            str2 = "Error: received body-length short than common head-length, return null";
            f.j("JCommands", "Error: received body-length short than common head-length, return null");
            i6 = 1300;
        } else {
            byte[] bArr2 = new byte[20];
            System.arraycopy(bArr, 0, bArr2, 0, 20);
            c cVar = new c(false, bArr2);
            f.c("JCommands", "parsed head - " + cVar.toString());
            int i7 = cVar.f2309a - 20;
            if (i7 >= 0) {
                f.a("JCommands", "body size:" + i7);
                if (TextUtils.isEmpty(str)) {
                    str = b.a(context);
                }
                byte[] bArr3 = new byte[i7];
                System.arraycopy(bArr, 20, bArr3, 0, i7);
                if (TextUtils.isEmpty(str)) {
                    System.arraycopy(bArr, 20, bArr3, 0, i7);
                    wrap = ByteBuffer.wrap(bArr3);
                } else {
                    try {
                        wrap = ByteBuffer.wrap(cVar.f2312d == 2 ? new u().b(bArr3, str) : v.a(bArr3, str, str.substring(0, 16), false));
                    } catch (Exception e6) {
                        f.c("JCommands", "decryptBytes error:" + e6.getMessage());
                        str2 = "decryptBytes error:" + e6.getMessage();
                        i6 = 1302;
                    }
                }
                return new Pair<>(cVar, wrap);
            }
            str2 = "Error: totalBytes length error with no encrypted, return null";
            f.j("JCommands", "Error: totalBytes length error with no encrypted, return null");
            i6 = 1301;
        }
        c.a.a(context, i6, str2);
        return null;
    }

    public static boolean a(cn.jiguang.bl.a aVar, Context context, byte[] bArr) {
        try {
            Pair<c, ByteBuffer> a6 = a(context, bArr, "");
            if (a6 == null) {
                c.a.a(context, AMapException.CODE_AMAP_SERVICE_MISSING_REQUIRED_PARAMS, " recv failed parse Inner Response");
                cn.jiguang.bq.b.a().a(aVar.f2343h + ":" + aVar.f2344i, "unknown_conn", bArr.length);
                return false;
            }
            cn.jiguang.bq.b.a().a(aVar.f2343h + ":" + aVar.f2344i, "conn", bArr.length);
            cn.jiguang.d.a.f(context);
            long j6 = ((c) a6.first).f2315g;
            f.c("JCommands", "first:" + a6.first);
            cn.jiguang.bi.b.a().a(context, (c) a6.first, (ByteBuffer) a6.second);
            return true;
        } catch (Throwable th) {
            f.j("JCommands", "dispatchMessage error:" + th.getMessage());
            return false;
        }
    }
}
