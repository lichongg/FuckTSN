package androidx.core.net;

import android.net.Uri;
import androidx.annotation.NonNull;
import master.flame.danmaku.danmaku.parser.b;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public final class UriCompat {
    private UriCompat() {
    }

    @NonNull
    public static String toSafeString(@NonNull Uri uri) {
        String str;
        String scheme = uri.getScheme();
        String schemeSpecificPart = uri.getSchemeSpecificPart();
        if (scheme != null) {
            if (!scheme.equalsIgnoreCase("tel") && !scheme.equalsIgnoreCase("sip") && !scheme.equalsIgnoreCase("sms") && !scheme.equalsIgnoreCase("smsto") && !scheme.equalsIgnoreCase("mailto") && !scheme.equalsIgnoreCase("nfc")) {
                if (scheme.equalsIgnoreCase(b.f50154a) || scheme.equalsIgnoreCase(b.f50155b) || scheme.equalsIgnoreCase("ftp") || scheme.equalsIgnoreCase("rtsp")) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("//");
                    String str2 = "";
                    if (uri.getHost() == null) {
                        str = "";
                    } else {
                        str = uri.getHost();
                    }
                    sb.append(str);
                    if (uri.getPort() != -1) {
                        str2 = ":" + uri.getPort();
                    }
                    sb.append(str2);
                    sb.append("/...");
                    schemeSpecificPart = sb.toString();
                }
            } else {
                StringBuilder sb2 = new StringBuilder(64);
                sb2.append(scheme);
                sb2.append(':');
                if (schemeSpecificPart != null) {
                    for (int i6 = 0; i6 < schemeSpecificPart.length(); i6++) {
                        char charAt = schemeSpecificPart.charAt(i6);
                        if (charAt != '-' && charAt != '@' && charAt != '.') {
                            sb2.append('x');
                        } else {
                            sb2.append(charAt);
                        }
                    }
                }
                return sb2.toString();
            }
        }
        StringBuilder sb3 = new StringBuilder(64);
        if (scheme != null) {
            sb3.append(scheme);
            sb3.append(':');
        }
        if (schemeSpecificPart != null) {
            sb3.append(schemeSpecificPart);
        }
        return sb3.toString();
    }
}
