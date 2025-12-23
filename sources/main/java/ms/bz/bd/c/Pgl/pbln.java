package ms.bz.bd.c.Pgl;

import com.bytedance.sdk.component.utils.vl;
import java.io.Closeable;
import java.io.IOException;

/* loaded from: D:\Downloads\app\classes8.dex */
public final class pbln {
    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e6) {
                vl.j(e6);
            }
        }
    }
}
