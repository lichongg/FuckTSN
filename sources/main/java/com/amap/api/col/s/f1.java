package com.amap.api.col.s;

import android.net.Uri;
import android.text.TextUtils;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public abstract class f1 extends dz {
    @Override // com.amap.api.col.s.dz
    public String a() {
        if (TextUtils.isEmpty(h())) {
            return h();
        }
        String h6 = h();
        Uri parse = Uri.parse(h6);
        if (parse.getAuthority().startsWith("dualstack-")) {
            return h6;
        }
        if (parse.getAuthority().startsWith("restsdk.amap.com")) {
            return parse.buildUpon().authority("dualstack-arestapi.amap.com").build().toString();
        }
        return parse.buildUpon().authority("dualstack-" + parse.getAuthority()).build().toString();
    }
}
