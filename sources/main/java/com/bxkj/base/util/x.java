package com.bxkj.base.util;

import java.io.ByteArrayOutputStream;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class x {

    /* renamed from: a, reason: collision with root package name */
    private final int f16647a = 117;

    /* renamed from: b, reason: collision with root package name */
    private final int f16648b = 256;

    /* renamed from: c, reason: collision with root package name */
    private final String f16649c = "RSA";

    /* renamed from: d, reason: collision with root package name */
    private final String f16650d = "RSA/ECB/PKCS1Padding";

    /* renamed from: e, reason: collision with root package name */
    private final String f16651e = "UTF-8";

    /* renamed from: f, reason: collision with root package name */
    private final String f16652f = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAq4laolA7zAk7jzsqDb3Oa5pS/uCPlZfASK8Soh/NzEmry77QDZ2koyr96M5Wx+A9cxwewQMHzi8RoOfb3UcQO4UDQlMUImLuzUnfbk3TTppijSLH+PU88XQxcgYm2JTa546c7JdZSI6dBeXOJH20quuxWyzgLk9jAlt3ytYygPQ7C6o6ZSmjcMgE3xgLaHGvixEVpOjL/pdVLzXhrMqWVAnB/snMjpCqesDVTDe5c6OOmj2q5J8n+tzIXtnvrkxQSDaUp8DWF8meMwyTErmYklMXzKic2rjdYZpHh4x98Fg0Q28sp6i2ZoWiGrJDKW29mntVQQiDNhKDawb4B45zUwIDAQAB";

    private PublicKey b(String str) throws Exception {
        return KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(cn.bluemobi.dylan.base.utils.b.a(str)));
    }

    public String a(String str) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(1, b("MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAq4laolA7zAk7jzsqDb3Oa5pS/uCPlZfASK8Soh/NzEmry77QDZ2koyr96M5Wx+A9cxwewQMHzi8RoOfb3UcQO4UDQlMUImLuzUnfbk3TTppijSLH+PU88XQxcgYm2JTa546c7JdZSI6dBeXOJH20quuxWyzgLk9jAlt3ytYygPQ7C6o6ZSmjcMgE3xgLaHGvixEVpOjL/pdVLzXhrMqWVAnB/snMjpCqesDVTDe5c6OOmj2q5J8n+tzIXtnvrkxQSDaUp8DWF8meMwyTErmYklMXzKic2rjdYZpHh4x98Fg0Q28sp6i2ZoWiGrJDKW29mntVQQiDNhKDawb4B45zUwIDAQAB"));
        int length = str.getBytes("UTF-8").length;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i6 = 0;
        int i7 = 0;
        while (true) {
            int i8 = length - i6;
            if (i8 <= 0) {
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
                return cn.bluemobi.dylan.base.utils.b.b(byteArray);
            }
            byte[] doFinal = i8 > 117 ? cipher.doFinal(str.getBytes("UTF-8"), i6, 117) : cipher.doFinal(str.getBytes("UTF-8"), i6, i8);
            byteArrayOutputStream.write(doFinal, 0, doFinal.length);
            i7++;
            i6 = i7 * 117;
        }
    }
}
