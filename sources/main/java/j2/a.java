package j2;

import android.content.Context;
import com.oplus.omes.stdsco.auth.AuthClient;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static volatile boolean f43450a;

    public static synchronized void a(Context context, String appId) {
        synchronized (a.class) {
            if (f43450a) {
                return;
            }
            f43450a = true;
            System.loadLibrary("omesStdSco");
            AuthClient.a(context, appId);
        }
    }
}
