package io.netty.handler.ssl;

import io.netty.internal.tcnative.SSL;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import javax.net.ssl.SSLException;
import javax.net.ssl.X509ExtendedKeyManager;
import javax.net.ssl.X509KeyManager;
import javax.security.auth.x500.X500Principal;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
final class OpenSslKeyMaterialManager {
    private static final Map<String, String> KEY_TYPES;
    static final String KEY_TYPE_DH_RSA = "DH_RSA";
    static final String KEY_TYPE_EC = "EC";
    static final String KEY_TYPE_EC_EC = "EC_EC";
    static final String KEY_TYPE_EC_RSA = "EC_RSA";
    static final String KEY_TYPE_RSA = "RSA";
    private final OpenSslKeyMaterialProvider provider;

    private void setKeyMaterial(ReferenceCountedOpenSslEngine referenceCountedOpenSslEngine, String str) throws SSLException {
        OpenSslKeyMaterial openSslKeyMaterial = null;
        try {
            try {
                openSslKeyMaterial = this.provider.chooseKeyMaterial(referenceCountedOpenSslEngine.alloc, str);
                if (openSslKeyMaterial != null) {
                    referenceCountedOpenSslEngine.setKeyMaterial(openSslKeyMaterial);
                }
            } catch (SSLException e6) {
                throw e6;
            } catch (Exception e7) {
                throw new SSLException(e7);
            }
        } finally {
            if (openSslKeyMaterial != null) {
                openSslKeyMaterial.release();
            }
        }
    }

    static {
        HashMap hashMap = new HashMap();
        KEY_TYPES = hashMap;
        hashMap.put(KEY_TYPE_RSA, KEY_TYPE_RSA);
        hashMap.put("DHE_RSA", KEY_TYPE_RSA);
        hashMap.put("ECDHE_RSA", KEY_TYPE_RSA);
        hashMap.put("ECDHE_ECDSA", KEY_TYPE_EC);
        hashMap.put("ECDH_RSA", KEY_TYPE_EC_RSA);
        hashMap.put("ECDH_ECDSA", KEY_TYPE_EC_EC);
        hashMap.put(KEY_TYPE_DH_RSA, KEY_TYPE_DH_RSA);
    }

    private String chooseClientAlias(ReferenceCountedOpenSslEngine referenceCountedOpenSslEngine, String[] strArr, X500Principal[] x500PrincipalArr) {
        X509KeyManager keyManager = this.provider.keyManager();
        return keyManager instanceof X509ExtendedKeyManager ? ((X509ExtendedKeyManager) keyManager).chooseEngineClientAlias(strArr, x500PrincipalArr, referenceCountedOpenSslEngine) : keyManager.chooseClientAlias(strArr, x500PrincipalArr, null);
    }

    private String chooseServerAlias(ReferenceCountedOpenSslEngine referenceCountedOpenSslEngine, String str) {
        X509KeyManager keyManager = this.provider.keyManager();
        return keyManager instanceof X509ExtendedKeyManager ? ((X509ExtendedKeyManager) keyManager).chooseEngineServerAlias(str, null, referenceCountedOpenSslEngine) : keyManager.chooseServerAlias(str, null, null);
    }

    OpenSslKeyMaterialManager(OpenSslKeyMaterialProvider openSslKeyMaterialProvider) {
        this.provider = openSslKeyMaterialProvider;
    }

    void setKeyMaterialClientSide(ReferenceCountedOpenSslEngine referenceCountedOpenSslEngine, String[] strArr, X500Principal[] x500PrincipalArr) throws SSLException {
        String chooseClientAlias = chooseClientAlias(referenceCountedOpenSslEngine, strArr, x500PrincipalArr);
        if (chooseClientAlias != null) {
            setKeyMaterial(referenceCountedOpenSslEngine, chooseClientAlias);
        }
    }

    void setKeyMaterialServerSide(ReferenceCountedOpenSslEngine referenceCountedOpenSslEngine) throws SSLException {
        String chooseServerAlias;
        String[] authenticationMethods = SSL.authenticationMethods(referenceCountedOpenSslEngine.sslPointer());
        HashSet hashSet = new HashSet(authenticationMethods.length);
        for (String str : authenticationMethods) {
            String str2 = KEY_TYPES.get(str);
            if (str2 != null && (chooseServerAlias = chooseServerAlias(referenceCountedOpenSslEngine, str2)) != null && hashSet.add(chooseServerAlias)) {
                setKeyMaterial(referenceCountedOpenSslEngine, chooseServerAlias);
            }
        }
    }
}
