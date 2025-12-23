package xyz.adscope.ad;

import xyz.adscope.common.v2.encrypt.impl.AesUtil;
import xyz.adscope.common.v2.log.SDKLog;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public enum d implements AesUtil.IAESConfig {
    ASNP_AES("@/.D>XVX5zhOdwj8", "\u007f}{y<usqomkigeca");


    /* renamed from: a, reason: collision with root package name */
    private final String f54938a;

    /* renamed from: b, reason: collision with root package name */
    private final String f54939b;

    private String a(String str) {
        try {
            StringBuilder sb = new StringBuilder(str);
            sb.reverse();
            for (int i6 = 0; i6 < sb.length(); i6++) {
                sb.setCharAt(i6, (char) (sb.charAt(i6) - i6));
            }
            return sb.toString();
        } catch (Exception e6) {
            SDKLog.stack(e6);
            return "";
        }
    }

    @Override // xyz.adscope.common.v2.encrypt.impl.AesUtil.IAESConfig
    public String generateAesKey() {
        return a(this.f54938a);
    }

    @Override // xyz.adscope.common.v2.encrypt.impl.AesUtil.IAESConfig
    public String generateAesVector() {
        return a(this.f54939b);
    }

    d(String str, String str2) {
        this.f54938a = str;
        this.f54939b = str2;
    }
}
