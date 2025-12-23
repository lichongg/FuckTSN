package com.kwad.sdk.core.network.a;

import android.text.TextUtils;
import java.net.InetAddress;
import java.util.Arrays;
import java.util.List;
import okhttp3.Dns;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class d implements Dns {
    private static final Dns SYSTEM = Dns.SYSTEM;

    @Override // okhttp3.Dns
    public final List<InetAddress> lookup(String str) {
        String fY = com.kwad.sdk.ip.direct.a.fY(str);
        if (!TextUtils.isEmpty(fY)) {
            List<InetAddress> asList = Arrays.asList(InetAddress.getAllByName(fY));
            if (asList != null && !asList.isEmpty()) {
                com.kwad.sdk.core.d.c.d("IpDirect_OkHttpDns", "inetAddresses:" + asList);
                return asList;
            }
            return SYSTEM.lookup(str);
        }
        com.kwad.sdk.core.d.c.d("IpDirect_OkHttpDns", "Dns.SYSTEM.lookup(hostname):" + Dns.SYSTEM.lookup(str));
        return SYSTEM.lookup(str);
    }
}
