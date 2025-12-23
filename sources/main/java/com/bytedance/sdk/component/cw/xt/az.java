package com.bytedance.sdk.component.cw.xt;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: D:\Downloads\app\classes4.dex */
public interface az {

    /* renamed from: j, reason: collision with root package name */
    public static final az f26121j = new az() { // from class: com.bytedance.sdk.component.cw.xt.az.1
        @Override // com.bytedance.sdk.component.cw.xt.az
        public List<InetAddress> j(String str) throws UnknownHostException {
            if (str == null) {
                throw new UnknownHostException("hostname == null");
            }
            try {
                return Arrays.asList(InetAddress.getAllByName(str));
            } catch (Throwable unused) {
                return new ArrayList();
            }
        }
    };

    List<InetAddress> j(String str) throws UnknownHostException;
}
