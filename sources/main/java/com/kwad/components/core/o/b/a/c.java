package com.kwad.components.core.o.b.a;

import com.kwad.components.offline.api.core.api.IEncrypt;
import com.kwad.sdk.utils.al;
import com.kwad.sdk.utils.bf;
import java.io.File;
import java.io.IOException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
final class c implements IEncrypt {
    c() {
    }

    @Override // com.kwad.components.offline.api.core.api.IEncrypt
    public final String getFileMD5(File file) {
        return com.kwad.sdk.utils.a.getFileMD5(file);
    }

    @Override // com.kwad.components.offline.api.core.api.IEncrypt
    public final byte[] getFileMD5Digest(File file) {
        try {
            return com.kwad.sdk.utils.a.getFileMD5Digest(file);
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // com.kwad.components.offline.api.core.api.IEncrypt
    public final String getFileSha256(File file) {
        return bf.ac(file);
    }

    @Override // com.kwad.components.offline.api.core.api.IEncrypt
    public final String getMD5(String str) {
        return al.md5(str);
    }

    @Override // com.kwad.components.offline.api.core.api.IEncrypt
    public final String getResponseData(String str) {
        return com.kwad.sdk.core.a.d.getResponseData(str);
    }

    @Override // com.kwad.components.offline.api.core.api.IEncrypt
    public final String getSha256(String str) {
        return bf.hj(str);
    }
}
