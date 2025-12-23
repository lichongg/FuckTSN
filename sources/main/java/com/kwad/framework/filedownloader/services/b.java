package com.kwad.framework.filedownloader.services;

import android.text.TextUtils;
import com.kwad.framework.filedownloader.f.c;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class b implements c.d {
    @Override // com.kwad.framework.filedownloader.f.c.d
    public final int f(String str, String str2, boolean z5) {
        return g(str, str2, z5);
    }

    @Override // com.kwad.framework.filedownloader.f.c.d
    public final int g(String str, String str2, boolean z5) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        try {
            if (z5) {
                return com.kwad.framework.filedownloader.f.f.md5(com.kwad.framework.filedownloader.f.f.c("%sp%s@dir", str, str2)).hashCode();
            }
            return com.kwad.framework.filedownloader.f.f.md5(com.kwad.framework.filedownloader.f.f.c("%sp%s", str, str2)).hashCode();
        } catch (Throwable unused) {
            return str.hashCode();
        }
    }
}
