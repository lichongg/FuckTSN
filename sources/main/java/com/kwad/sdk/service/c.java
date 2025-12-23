package com.kwad.sdk.service;

import com.ksad.annotation.invoker.ForInvoker;
import com.kwad.components.ad.feed.FeedDownloadActivityProxy;
import com.kwad.components.ad.fullscreen.KsFullScreenLandScapeVideoActivityProxy;
import com.kwad.components.ad.fullscreen.KsFullScreenVideoActivityProxy;
import com.kwad.components.ad.reward.KSRewardLandScapeVideoActivityProxy;
import com.kwad.components.ad.reward.KSRewardVideoActivityProxy;
import com.kwad.components.core.internal.api.KSAdVideoPlayConfigImpl;
import com.kwad.components.core.internal.api.VideoPlayConfigImpl;
import com.kwad.components.core.page.AdWebViewActivityProxy;
import com.kwad.components.core.page.AdWebViewVideoActivityProxy;
import com.kwad.framework.filedownloader.services.FileDownloadServiceProxy;
import com.kwad.sdk.internal.api.SceneImpl;
import java.util.HashMap;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class c {
    private static final Map<Class<?>, Class<?>> aYh = new HashMap(128);
    private static final Map<Class<?>, Class<?>> aYi = new HashMap();
    private static boolean aYj = false;
    private static boolean aYk = false;

    private static synchronized void Pk() {
        synchronized (c.class) {
            if (aYj) {
                return;
            }
            Pl();
            aYj = true;
        }
    }

    private static synchronized void Pm() {
        synchronized (c.class) {
            if (aYk) {
                return;
            }
            Pn();
            aYk = true;
        }
    }

    public static void a(Class<?> cls, Class<?> cls2) {
        aYh.put(cls, cls2);
    }

    public static void b(Class cls, Class cls2) {
        aYi.put(cls, cls2);
    }

    @ForInvoker(methodId = "initComponentProxyForInvoker")
    private static void Pl() {
        FeedDownloadActivityProxy.register();
        KsFullScreenLandScapeVideoActivityProxy.register();
        KsFullScreenVideoActivityProxy.register();
        KSRewardLandScapeVideoActivityProxy.register();
        KSRewardVideoActivityProxy.register();
        com.kwad.components.core.page.a.register();
        AdWebViewActivityProxy.register();
        AdWebViewVideoActivityProxy.register();
        com.kwad.components.core.page.d.register();
        com.kwad.components.core.s.a.a.register();
        FileDownloadServiceProxy.register();
        com.kwad.sdk.collector.b.a.register();
        a.register();
    }

    @ForInvoker(methodId = "initModeImplForInvoker")
    private static void Pn() {
        KSAdVideoPlayConfigImpl.register();
        com.kwad.components.core.internal.api.d.register();
        VideoPlayConfigImpl.register();
        com.kwad.components.core.q.b.register();
        SceneImpl.register();
    }

    public static Class<?> g(Class<?> cls) {
        Pk();
        return aYh.get(cls);
    }

    public static Class<?> h(Class<?> cls) {
        Pm();
        return aYi.get(cls);
    }

    public static void init() {
        Pk();
        Pm();
    }
}
