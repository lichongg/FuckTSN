package org.apache.commons.net.ntp;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class b {
    public static String a(int i6) {
        return ((i6 >>> 24) & 255) + "." + ((i6 >>> 16) & 255) + "." + ((i6 >>> 8) & 255) + "." + (i6 & 255);
    }

    public static String c(d dVar) {
        return a(dVar == null ? 0 : dVar.b());
    }

    public static String d(d dVar) {
        int b6;
        if (dVar == null || (b6 = dVar.b()) == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(4);
        for (int i6 = 24; i6 >= 0; i6 -= 8) {
            char c6 = (char) ((b6 >>> i6) & 255);
            if (c6 == 0) {
                break;
            }
            if (!Character.isLetterOrDigit(c6)) {
                return "";
            }
            sb.append(c6);
        }
        return sb.toString();
    }

    public static String b(int i6) {
        switch (i6) {
            case 0:
                return "Reserved";
            case 1:
                return "Symmetric Active";
            case 2:
                return "Symmetric Passive";
            case 3:
                return "Client";
            case 4:
                return "Server";
            case 5:
                return "Broadcast";
            case 6:
                return "Control";
            case 7:
                return "Private";
            default:
                return "Unknown";
        }
    }
}
