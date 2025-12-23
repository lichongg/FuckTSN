package xyz.adscope.common.v2.encrypt.impl;

import android.text.TextUtils;
import java.util.Iterator;
import java.util.LinkedList;
import xyz.adscope.common.v2.encrypt.ILinkedEncrypt;
import xyz.adscope.common.v2.encrypt.impl.AesUtil;
import xyz.adscope.common.v2.log.SDKLog;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class LinkedEncryptImpl implements ILinkedEncrypt {
    private static final String ENCRYPT_AES = "1001";
    private static final String ENCRYPT_BASE64 = "-999";
    private static final String ENCRYPT_GZIP = "101";
    private AesUtil.IAESConfig aesConfigGenerate;
    private AesUtil mAes;

    @Override // xyz.adscope.common.v2.encrypt.ILinkedEncrypt
    public String decrypt(String str, String str2, ILinkedEncrypt.B64Model b64Model, boolean z5) {
        byte[] decrypt = decrypt(str.getBytes(), str2, b64Model, z5);
        if (decrypt != null) {
            return new String(decrypt);
        }
        if (z5) {
            return str;
        }
        return null;
    }

    @Override // xyz.adscope.common.v2.encrypt.ILinkedEncrypt
    public String encrypt(String str, String str2, ILinkedEncrypt.B64Model b64Model, boolean z5) {
        byte[] encrypt = encrypt(str.getBytes(), str2, b64Model, z5);
        if (encrypt != null) {
            return new String(encrypt);
        }
        if (z5) {
            return str;
        }
        return null;
    }

    private IBaseEncrypt encryptByPattern(String str) {
        if ("1001".equals(str)) {
            if (this.mAes == null) {
                this.mAes = new AesUtil(this.aesConfigGenerate);
            }
            return this.mAes;
        }
        if (ENCRYPT_GZIP.equals(str)) {
            return GzipUtil.getInstance();
        }
        if (ENCRYPT_BASE64.equals(str)) {
            return Base64Util.getInstance();
        }
        return null;
    }

    @Override // xyz.adscope.common.v2.encrypt.ILinkedEncrypt
    public void initAesConfig(AesUtil.IAESConfig iAESConfig) {
        this.aesConfigGenerate = iAESConfig;
    }

    private byte[] decodeLinked(byte[] bArr, LinkedList<String> linkedList) {
        Iterator<String> it = linkedList.iterator();
        while (it.hasNext()) {
            IBaseEncrypt encryptByPattern = encryptByPattern(it.next());
            if (encryptByPattern != null) {
                if (bArr == null) {
                    break;
                }
                bArr = encryptByPattern.decode(bArr);
            }
        }
        return bArr;
    }

    private byte[] encodeLinked(byte[] bArr, LinkedList<String> linkedList) {
        Iterator<String> it = linkedList.iterator();
        while (it.hasNext()) {
            IBaseEncrypt encryptByPattern = encryptByPattern(it.next());
            if (encryptByPattern != null) {
                if (bArr == null) {
                    break;
                }
                bArr = encryptByPattern.encode(bArr);
            }
        }
        return bArr;
    }

    @Override // xyz.adscope.common.v2.encrypt.ILinkedEncrypt
    public byte[] decrypt(byte[] bArr, String str, ILinkedEncrypt.B64Model b64Model, boolean z5) {
        LinkedList<String> linkedList = new LinkedList<>();
        if (!TextUtils.isEmpty(str)) {
            for (String str2 : str.split(",")) {
                if (!linkedList.contains(str2)) {
                    linkedList.addFirst(str2);
                    if (b64Model == ILinkedEncrypt.B64Model.STEP_BY_STEP) {
                        linkedList.addFirst(ENCRYPT_BASE64);
                    }
                }
            }
        }
        if (b64Model == ILinkedEncrypt.B64Model.AS_LAST_OR_FIRST) {
            linkedList.addFirst(ENCRYPT_BASE64);
        }
        return decodeLinked(bArr, linkedList);
    }

    @Override // xyz.adscope.common.v2.encrypt.ILinkedEncrypt
    public byte[] encrypt(byte[] bArr, String str, ILinkedEncrypt.B64Model b64Model, boolean z5) {
        try {
            LinkedList<String> linkedList = new LinkedList<>();
            if (!TextUtils.isEmpty(str)) {
                for (String str2 : str.split(",")) {
                    String trim = str2.trim();
                    if (!linkedList.contains(trim)) {
                        linkedList.addLast(trim);
                        if (b64Model == ILinkedEncrypt.B64Model.STEP_BY_STEP) {
                            linkedList.addLast(ENCRYPT_BASE64);
                        }
                    }
                }
            }
            if (b64Model == ILinkedEncrypt.B64Model.AS_LAST_OR_FIRST) {
                linkedList.addLast(ENCRYPT_BASE64);
            }
            return encodeLinked(bArr, linkedList);
        } catch (Throwable th) {
            SDKLog.stack(th);
            return null;
        }
    }
}
