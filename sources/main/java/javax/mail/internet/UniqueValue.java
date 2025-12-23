package javax.mail.internet;

import javax.mail.Session;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
class UniqueValue {
    private static int id;

    public static String getUniqueBoundaryValue() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("----=_Part_");
        stringBuffer.append(getUniqueId());
        stringBuffer.append("_");
        stringBuffer.append(stringBuffer.hashCode());
        stringBuffer.append('.');
        stringBuffer.append(System.currentTimeMillis());
        return stringBuffer.toString();
    }

    private static synchronized int getUniqueId() {
        int i6;
        synchronized (UniqueValue.class) {
            i6 = id;
            id = i6 + 1;
        }
        return i6;
    }

    UniqueValue() {
    }

    public static String getUniqueMessageIDValue(Session session) {
        String str;
        InternetAddress localAddress = InternetAddress.getLocalAddress(session);
        if (localAddress != null) {
            str = localAddress.getAddress();
        } else {
            str = "javamailuser@localhost";
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(stringBuffer.hashCode());
        stringBuffer.append('.');
        stringBuffer.append(getUniqueId());
        stringBuffer.append('.');
        stringBuffer.append(System.currentTimeMillis());
        stringBuffer.append('.');
        stringBuffer.append("JavaMail.");
        stringBuffer.append(str);
        return stringBuffer.toString();
    }
}
