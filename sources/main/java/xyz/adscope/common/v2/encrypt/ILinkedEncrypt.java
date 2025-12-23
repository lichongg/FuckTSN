package xyz.adscope.common.v2.encrypt;

import xyz.adscope.common.v2.encrypt.impl.AesUtil;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public interface ILinkedEncrypt {
    public static final String DEFAULT_CONFIG_PATTERN = "101,1001";
    public static final String DEFAULT_DEF_CFG_PATTERN = "1001";
    public static final String DEFAULT_ENCRYPT_PATTERN = "101,1001";

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public enum B64Model {
        STEP_BY_STEP,
        AS_LAST_OR_FIRST,
        NOT_APPEND
    }

    String decrypt(String str, String str2, B64Model b64Model, boolean z5);

    byte[] decrypt(byte[] bArr, String str, B64Model b64Model, boolean z5);

    String encrypt(String str, String str2, B64Model b64Model, boolean z5);

    byte[] encrypt(byte[] bArr, String str, B64Model b64Model, boolean z5);

    void initAesConfig(AesUtil.IAESConfig iAESConfig);
}
