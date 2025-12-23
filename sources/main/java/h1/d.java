package h1;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.stub.StubApp;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public static final int f43033a = 0;

    /* renamed from: b, reason: collision with root package name */
    public static final int f43034b = 1;

    /* renamed from: c, reason: collision with root package name */
    public static final int f43035c = 2;

    /* renamed from: d, reason: collision with root package name */
    public static final int f43036d = 3;

    /* renamed from: e, reason: collision with root package name */
    public static final int f43037e = 4;

    /* renamed from: f, reason: collision with root package name */
    public static final int f43038f = -1;

    public static int a(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) StubApp.getOrigApplicationContext(context.getApplicationContext()).getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            return 0;
        }
        if (!activeNetworkInfo.isConnected()) {
            return 1;
        }
        if (activeNetworkInfo.getType() == 9) {
            return 2;
        }
        if (activeNetworkInfo.getType() == 1) {
            return 3;
        }
        if (activeNetworkInfo.getType() == 0) {
            switch (activeNetworkInfo.getSubtype()) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                case 10:
                case 11:
                case 12:
                case 13:
                case 14:
                case 15:
                    return 4;
                default:
                    return -1;
            }
        }
        return -1;
    }
}
