package com.kwad.sdk.api.loader;

import com.kwad.sdk.liteapi.KsLiteApiImpl;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class r {
    public static q Dp() {
        try {
            return (q) KsLiteApiImpl.class.newInstance();
        } catch (ClassNotFoundException e6) {
            e6.printStackTrace();
            return null;
        } catch (IllegalAccessException e7) {
            e7.printStackTrace();
            return null;
        } catch (InstantiationException e8) {
            e8.printStackTrace();
            return null;
        }
    }
}
