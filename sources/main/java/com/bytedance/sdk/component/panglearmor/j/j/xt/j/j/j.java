package com.bytedance.sdk.component.panglearmor.j.j.xt.j.j;

import com.bytedance.component.sdk.annotation.DungeonFlag;
import com.bytedance.sdk.component.panglearmor.j.xt.xt;
import com.huawei.hms.feature.dynamic.f.e;
import java.io.ByteArrayInputStream;
import java.nio.ByteBuffer;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j {
    public static List<com.bytedance.sdk.component.panglearmor.j.xt.j> j(xt xtVar, com.bytedance.sdk.component.panglearmor.j.j.cw.xt xtVar2) throws Exception {
        return j(com.bytedance.sdk.component.panglearmor.j.j.xt.j.j.j(xtVar, xtVar2, 1896449818).f26695j);
    }

    public static List<com.bytedance.sdk.component.panglearmor.j.xt.j> j(ByteBuffer byteBuffer) {
        try {
            ByteBuffer j6 = com.bytedance.sdk.component.panglearmor.j.j.xt.j.j.j(byteBuffer);
            if (!j6.hasRemaining()) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            while (j6.hasRemaining()) {
                try {
                    arrayList.add(xt(com.bytedance.sdk.component.panglearmor.j.j.xt.j.j.j(j6)));
                } catch (Exception unused) {
                    return null;
                }
            }
            return arrayList;
        } catch (Exception unused2) {
            return null;
        }
    }

    @DungeonFlag
    private static com.bytedance.sdk.component.panglearmor.j.xt.j xt(ByteBuffer byteBuffer) throws Exception {
        ByteBuffer j6 = com.bytedance.sdk.component.panglearmor.j.j.xt.j.j.j(byteBuffer);
        j6.get(new byte[j6.remaining()]);
        j6.flip();
        j6.position(0);
        com.bytedance.sdk.component.panglearmor.j.j.xt.j.j.j(j6);
        byte[] xt = com.bytedance.sdk.component.panglearmor.j.j.xt.j.j.xt(com.bytedance.sdk.component.panglearmor.j.j.xt.j.j.j(j6));
        try {
            return new com.bytedance.sdk.component.panglearmor.j.xt.j(String.valueOf(((X509Certificate) CertificateFactory.getInstance(e.f33254b).generateCertificate(new ByteArrayInputStream(xt))).getSubjectDN()), xt);
        } catch (Exception unused) {
            return null;
        }
    }
}
