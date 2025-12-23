package com.kwad.components.core.e.b;

import com.huawei.hms.framework.common.ContainerUtils;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class a {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.kwad.components.core.e.b.a$a, reason: collision with other inner class name */
    static class C0613a {
        private static final c OD = c.a(new int[]{7, 8, 4, 2, 0, 3, 6, 9, 1, 8});
    }

    public static long ai(String str) {
        return oS().aj(str);
    }

    private static c oS() {
        return C0613a.OD;
    }

    public static String y(long j6) {
        String z5 = oS().z(j6);
        if (z5.endsWith(ContainerUtils.KEY_VALUE_DELIMITER)) {
            return z5.replace(ContainerUtils.KEY_VALUE_DELIMITER, "");
        }
        return z5;
    }
}
