package t1;

import android.content.Context;
import com.huawei.hms.framework.network.grs.GrsApp;
import com.huawei.secure.android.common.ssl.i;
import com.huawei.secure.android.common.ssl.k;
import f2.b;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static final HostnameVerifier f54610a = new b();

    public static HostnameVerifier a() {
        return f54610a;
    }

    public static SSLSocketFactory b(Context context) {
        try {
            return new i(new k(context.getAssets().open(GrsApp.getInstance().getBrand("/") + "grs_sp.bks"), ""));
        } catch (IOException | KeyManagementException | NoSuchAlgorithmException e6) {
            throw new AssertionError(e6);
        }
    }
}
