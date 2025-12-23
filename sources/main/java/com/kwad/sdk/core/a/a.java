package com.kwad.sdk.core.a;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.bl;
import com.kwad.sdk.utils.v;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class a implements g {
    private static String sPkgId;

    @Override // com.kwad.sdk.core.a.g
    public final String getResponseData(String str) {
        try {
            return new String(b.decompress(b.decrypt(v.eO(0), c.Hh().decode(str.getBytes()))), "UTF-8");
        } catch (Exception unused) {
            return str;
        }
    }

    private static String He() {
        if (!TextUtils.isEmpty(sPkgId)) {
            return sPkgId;
        }
        Context context = ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getContext();
        if (context == null) {
            return "";
        }
        String str = context.getPackageName() + bl.getSignMd5Str(context);
        sPkgId = str;
        return str;
    }

    @Override // com.kwad.sdk.core.a.g
    public final String as(String str) {
        try {
            String eO = v.eO(0);
            return new String(c.Hf().encode(b.encrypt(eO.getBytes("UTF-8"), b.compress(str.getBytes()))), "UTF-8");
        } catch (Exception unused) {
            return str;
        }
    }

    @Override // com.kwad.sdk.core.a.g
    public final void g(@NonNull Map<String, String> map) {
        map.put("Ks-PkgId", He());
        map.put("Ks-Encoding", "2");
    }

    @Override // com.kwad.sdk.core.a.g
    public final void a(String str, Map<String, String> map, String str2) {
        f.a(str, map, str2);
    }
}
