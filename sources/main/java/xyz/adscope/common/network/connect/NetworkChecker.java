package xyz.adscope.common.network.connect;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class NetworkChecker {

    /* renamed from: a, reason: collision with root package name */
    private ConnectivityManager f56562a;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public enum NetType {
        Wifi,
        Wired,
        Mobile,
        Mobile2G,
        Mobile3G,
        Mobile4G
    }

    private static boolean a(NetType netType, NetworkInfo networkInfo) {
        if (networkInfo == null) {
            return false;
        }
        switch (AnonymousClass1.f56563a[netType.ordinal()]) {
            case 1:
                if (a(networkInfo) && networkInfo.getType() == 1) {
                }
                break;
            case 2:
                if (a(networkInfo) && networkInfo.getType() == 9) {
                }
                break;
            case 3:
                if (a(networkInfo) && networkInfo.getType() == 0) {
                }
                break;
            case 4:
                if (a(NetType.Mobile, networkInfo)) {
                    break;
                }
                break;
            case 5:
                if (a(NetType.Mobile, networkInfo)) {
                    break;
                }
                break;
            case 6:
                if (a(NetType.Mobile, networkInfo)) {
                    break;
                }
                break;
        }
        return false;
    }

    public boolean isAvailable() {
        return isWifiConnected() || isWiredConnected() || isMobileConnected();
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: xyz.adscope.common.network.connect.NetworkChecker$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f56563a;

        static {
            int[] iArr = new int[NetType.values().length];
            f56563a = iArr;
            try {
                iArr[NetType.Wifi.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f56563a[NetType.Wired.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f56563a[NetType.Mobile.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f56563a[NetType.Mobile2G.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f56563a[NetType.Mobile3G.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f56563a[NetType.Mobile4G.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public final boolean isAvailable(NetType netType) {
        return a(netType, this.f56562a.getActiveNetworkInfo());
    }

    public final boolean isMobile2GConnected() {
        return isAvailable(NetType.Mobile2G);
    }

    public final boolean isMobile3GConnected() {
        return isAvailable(NetType.Mobile3G);
    }

    public final boolean isMobile4GConnected() {
        return isAvailable(NetType.Mobile4G);
    }

    public final boolean isMobileConnected() {
        return isAvailable(NetType.Mobile);
    }

    public final boolean isWifiConnected() {
        return isAvailable(NetType.Wifi);
    }

    public final boolean isWiredConnected() {
        return isAvailable(NetType.Wired);
    }

    public NetworkChecker(Context context) {
        this.f56562a = (ConnectivityManager) context.getSystemService("connectivity");
    }

    private static boolean b(NetType netType, NetworkInfo networkInfo) {
        switch (networkInfo.getType()) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
            case 16:
                if (netType == NetType.Mobile2G) {
                    return true;
                }
                return false;
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
            case 17:
                if (netType == NetType.Mobile3G) {
                    return true;
                }
                return false;
            case 13:
            case 18:
                if (netType == NetType.Mobile4G) {
                    return true;
                }
                return false;
            default:
                String subtypeName = networkInfo.getSubtypeName();
                if ((subtypeName.equalsIgnoreCase("TD-SCDMA") || subtypeName.equalsIgnoreCase("WCDMA") || subtypeName.equalsIgnoreCase("CDMA2000")) && netType == NetType.Mobile3G) {
                    return true;
                }
                return false;
        }
    }

    private static boolean a(NetworkInfo networkInfo) {
        return networkInfo != null && networkInfo.isAvailable() && networkInfo.isConnected();
    }
}
