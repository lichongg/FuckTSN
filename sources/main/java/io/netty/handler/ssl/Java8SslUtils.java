package io.netty.handler.ssl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SNIHostName;
import javax.net.ssl.SNIMatcher;
import javax.net.ssl.SNIServerName;
import javax.net.ssl.SSLParameters;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
final class Java8SslUtils {
    static boolean checkSniHostnameMatch(Collection<?> collection, byte[] bArr) {
        int type;
        boolean matches;
        if (collection == null || collection.isEmpty()) {
            return true;
        }
        SNIHostName a6 = f.a(bArr);
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            SNIMatcher a7 = l.a(it.next());
            type = a7.getType();
            if (type == 0) {
                matches = a7.matches(a6);
                if (matches) {
                    return true;
                }
            }
        }
        return false;
    }

    static List<String> getSniHostNames(SSLParameters sSLParameters) {
        List serverNames;
        String asciiName;
        serverNames = sSLParameters.getServerNames();
        if (serverNames == null || serverNames.isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        ArrayList arrayList = new ArrayList(serverNames.size());
        Iterator it = serverNames.iterator();
        while (it.hasNext()) {
            SNIServerName a6 = g.a(it.next());
            if (!h.a(a6)) {
                throw new IllegalArgumentException("Only " + k.a().getName() + " instances are supported, but found: " + a6);
            }
            asciiName = i.a(a6).getAsciiName();
            arrayList.add(asciiName);
        }
        return arrayList;
    }

    static List getSniHostName(byte[] bArr) {
        return (bArr == null || bArr.length == 0) ? Collections.EMPTY_LIST : Collections.singletonList(f.a(bArr));
    }

    private Java8SslUtils() {
    }

    static boolean getUseCipherSuitesOrder(SSLParameters sSLParameters) {
        boolean useCipherSuitesOrder;
        useCipherSuitesOrder = sSLParameters.getUseCipherSuitesOrder();
        return useCipherSuitesOrder;
    }

    static void setSNIMatchers(SSLParameters sSLParameters, Collection<?> collection) {
        sSLParameters.setSNIMatchers(collection);
    }

    static void setSniHostNames(SSLParameters sSLParameters, List<String> list) {
        sSLParameters.setServerNames(getSniHostNames(list));
    }

    static void setUseCipherSuitesOrder(SSLParameters sSLParameters, boolean z5) {
        sSLParameters.setUseCipherSuitesOrder(z5);
    }

    static List getSniHostNames(List<String> list) {
        if (list != null && !list.isEmpty()) {
            ArrayList arrayList = new ArrayList(list.size());
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(com.bytedance.sdk.component.cw.xt.j.ae.c.a(it.next()));
            }
            return arrayList;
        }
        return Collections.EMPTY_LIST;
    }
}
