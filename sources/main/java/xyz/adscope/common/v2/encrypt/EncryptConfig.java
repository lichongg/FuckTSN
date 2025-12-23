package xyz.adscope.common.v2.encrypt;

import xyz.adscope.common.v2.encrypt.impl.AesUtil;
import xyz.adscope.common.v2.log.SDKLog;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public enum EncryptConfig implements AesUtil.IAESConfig {
    CONFIG_AES("@/.D>XVX5zhOdwj8", "\u007f}{y<usqomkigeca");

    private final String mKey;
    private final String mVector;

    private String decryptStr(String str) {
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
        return decryptStr(this.mKey);
    }

    @Override // xyz.adscope.common.v2.encrypt.impl.AesUtil.IAESConfig
    public String generateAesVector() {
        return decryptStr(this.mVector);
    }

    EncryptConfig(String str, String str2) {
        this.mKey = str;
        this.mVector = str2;
    }
}
