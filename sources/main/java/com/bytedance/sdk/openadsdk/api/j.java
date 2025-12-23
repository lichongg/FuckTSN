package com.bytedance.sdk.openadsdk.api;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Pair;
import android.util.SparseArray;
import com.bykv.j.j.j.j.a;
import com.bykv.j.j.j.j.g;
import com.bykv.vk.openvk.api.proto.Loader;
import com.bykv.vk.openvk.api.proto.Manager;
import com.bykv.vk.openvk.api.proto.Result;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.AdConfig;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.TTAdManager;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTAppContextHolder;
import com.bytedance.sdk.openadsdk.downloadnew.core.ExitInstallListener;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.bytedance.sdk.openadsdk.mediation.bridge.init.MediationInitCLassLoader;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Function;

/* loaded from: D:\Downloads\app\classes4.dex */
public abstract class j {

    /* renamed from: j, reason: collision with root package name */
    private TTAdSdk.InitCallback f27526j;

    public static abstract class cw implements TTAdManager {
        private List<WeakReference<xt<Manager>>> cw = new CopyOnWriteArrayList();

        /* renamed from: j, reason: collision with root package name */
        private volatile Manager f27528j;
        private volatile boolean xt;

        /* renamed from: com.bytedance.sdk.openadsdk.api.j$cw$1, reason: invalid class name */
        class AnonymousClass1 extends AbstractC0428j<Loader> {
            final /* synthetic */ SoftReference cw;

            /* renamed from: j, reason: collision with root package name */
            Loader f27529j;
            final xt<Manager> xt;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(SoftReference softReference) {
                super();
                this.cw = softReference;
                this.xt = new xt<Manager>() { // from class: com.bytedance.sdk.openadsdk.api.j.cw.1.1
                    @Override // com.bytedance.sdk.openadsdk.api.j.xt
                    public void j(Manager manager) {
                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                        anonymousClass1.f27529j = manager.createLoader((Context) anonymousClass1.cw.get());
                    }
                };
            }

            @Override // com.bytedance.sdk.openadsdk.api.j.AbstractC0428j
            public void j(final xt<Loader> xtVar, int i6) {
                Loader loader = this.f27529j;
                if (loader != null) {
                    xtVar.j(loader);
                } else {
                    cw.this.call(new xt<Manager>() { // from class: com.bytedance.sdk.openadsdk.api.j.cw.1.2
                        @Override // com.bytedance.sdk.openadsdk.api.j.xt
                        public void j(Manager manager) {
                            AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                            cw.this.j(anonymousClass1.xt);
                            AnonymousClass1 anonymousClass12 = AnonymousClass1.this;
                            anonymousClass12.f27529j = manager.createLoader((Context) anonymousClass12.cw.get());
                            xtVar.j(AnonymousClass1.this.f27529j);
                        }
                    }, i6 + 10000);
                }
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdManager
        public String getBiddingToken(AdSlot adSlot) {
            return getBiddingToken(adSlot, false, adSlot.getAdType() > 0 ? adSlot.getAdType() : adSlot.getNativeAdType());
        }

        protected Object j(Object obj) {
            return obj;
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdManager
        public String getBiddingToken(AdSlot adSlot, boolean z5, int i6) {
            Function<SparseArray<Object>, Object> j6;
            Object apply;
            if (com.bytedance.sdk.openadsdk.api.up.j()) {
                return null;
            }
            if (i6 <= 0) {
                i6 = adSlot.getAdType() > 0 ? adSlot.getAdType() : adSlot.getNativeAdType();
            }
            ValueSet k6 = a.j(com.bytedance.sdk.openadsdk.i.j.cw.xt.j(adSlot)).i(13, z5).e(14, i6).e(-99999987, 2).g(-99999985, String.class).k();
            if ((this.f27528j instanceof com.bytedance.sdk.openadsdk.api.cw) && (j6 = ((com.bytedance.sdk.openadsdk.api.cw) this.f27528j).j(1)) != null) {
                apply = j6.apply(k6.sparseArray());
                if (apply instanceof String) {
                    return (String) apply;
                }
            }
            return null;
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdManager
        public String getPluginVersion() {
            return this.f27528j != null ? this.f27528j.values().stringValue(12) : "";
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdManager
        public String getSDKVersion() {
            return "7.0.1.2";
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdManager
        public int getThemeStatus() {
            if (this.f27528j != null) {
                return this.f27528j.values().intValue(11);
            }
            return 0;
        }

        protected void j(Throwable th) {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void call(final xt<Manager> xtVar, final int i6) {
            if (com.bytedance.sdk.openadsdk.api.up.j()) {
                return;
            }
            if (this.f27528j != null) {
                try {
                    xtVar.j(this.f27528j);
                    return;
                } catch (Throwable th) {
                    m.r("_tt_ad_sdk_", "Unexpected manager call error: " + th.getMessage());
                    j(th);
                    return;
                }
            }
            if (!this.xt && i6 > 10000) {
                throw new IllegalStateException("广告SDK未Ready, 请在load(请求广告）之前，先调用init and start方法，以避免无法请求广告");
            }
            com.bytedance.sdk.openadsdk.mi.j.j().j(new Runnable() { // from class: com.bytedance.sdk.openadsdk.api.j.cw.7
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (cw.this.f27528j != null) {
                            xtVar.j(cw.this.f27528j);
                            return;
                        }
                        m.r("_tt_ad_sdk_", "Not ready, no manager: " + i6);
                    } catch (Throwable th2) {
                        m.r("_tt_ad_sdk_", "Unexpected manager call error: " + th2.getMessage());
                        cw.this.j(th2);
                    }
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static <T> T xt(Manager manager, Class<T> cls, Bundle bundle) {
            Function<SparseArray<Object>, Object> j6;
            Object apply;
            if (com.bytedance.sdk.openadsdk.api.up.j()) {
                return null;
            }
            SparseArray<Object> sparseArray = a.b(3).g(9, cls).g(10, bundle).e(-99999987, 6).g(-99999985, cls).k().sparseArray();
            if ((manager instanceof com.bytedance.sdk.openadsdk.api.cw) && (j6 = ((com.bytedance.sdk.openadsdk.api.cw) manager).j(1)) != null) {
                apply = j6.apply(sparseArray);
                return (T) apply;
            }
            return null;
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdManager
        public TTAdNative createAdNative(Context context) {
            if (com.bytedance.sdk.openadsdk.api.up.j()) {
                return null;
            }
            return new up(new AnonymousClass1(new SoftReference(context))).j();
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdManager
        public <T> T getExtra(final Class<T> cls, final Bundle bundle) {
            if (com.bytedance.sdk.openadsdk.api.up.j()) {
                return null;
            }
            if (this.f27528j != null) {
                return (T) xt(this.f27528j, cls, bundle);
            }
            call(new xt<Manager>() { // from class: com.bytedance.sdk.openadsdk.api.j.cw.4
                @Override // com.bytedance.sdk.openadsdk.api.j.xt
                public void j(Manager manager) {
                    cw.xt(cw.this.f27528j, cls, bundle);
                }
            }, 6);
            return null;
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdManager
        public Bundle handleEvent(Bundle bundle) {
            Function<SparseArray<Object>, Object> j6;
            Object apply;
            ValueSet k6 = a.a().g(20, bundle).e(-99999987, 19).g(-99999985, Bundle.class).k();
            if ((this.f27528j instanceof com.bytedance.sdk.openadsdk.api.cw) && (j6 = ((com.bytedance.sdk.openadsdk.api.cw) this.f27528j).j(1)) != null) {
                apply = j6.apply(k6.sparseArray());
                if (apply instanceof Bundle) {
                    return (Bundle) apply;
                }
            }
            return null;
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdManager
        public void register(final Object obj) {
            if (com.bytedance.sdk.openadsdk.api.up.j()) {
                return;
            }
            call(new xt<Manager>() { // from class: com.bytedance.sdk.openadsdk.api.j.cw.2
                @Override // com.bytedance.sdk.openadsdk.api.j.xt
                public void j(Manager manager) {
                    Function<SparseArray<Object>, Object> j6;
                    SparseArray<Object> sparseArray = a.b(2).g(8, cw.this.j(obj)).e(-99999987, 4).g(-99999985, Void.class).k().sparseArray();
                    if (!(manager instanceof com.bytedance.sdk.openadsdk.api.cw) || (j6 = ((com.bytedance.sdk.openadsdk.api.cw) manager).j(1)) == null) {
                        return;
                    }
                    j6.apply(sparseArray);
                }
            }, 4);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdManager
        public void requestPermissionIfNecessary(final Context context) {
            if (com.bytedance.sdk.openadsdk.api.up.j()) {
                return;
            }
            call(new xt<Manager>() { // from class: com.bytedance.sdk.openadsdk.api.j.cw.5
                @Override // com.bytedance.sdk.openadsdk.api.j.xt
                public void j(Manager manager) {
                    Function<SparseArray<Object>, Object> j6;
                    SparseArray<Object> sparseArray = a.b(2).g(7, context).e(-99999987, 3).g(-99999985, Void.class).k().sparseArray();
                    if (!(manager instanceof com.bytedance.sdk.openadsdk.api.cw) || (j6 = ((com.bytedance.sdk.openadsdk.api.cw) manager).j(1)) == null) {
                        return;
                    }
                    j6.apply(sparseArray);
                }
            }, 3);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdManager
        public void setThemeStatus(final int i6) {
            if (com.bytedance.sdk.openadsdk.api.up.j()) {
                return;
            }
            call(new xt<Manager>() { // from class: com.bytedance.sdk.openadsdk.api.j.cw.6
                @Override // com.bytedance.sdk.openadsdk.api.j.xt
                public void j(Manager manager) {
                    Function<SparseArray<Object>, Object> j6;
                    ValueSet k6 = a.a().e(11, i6).e(-99999987, 1).g(-99999985, Void.class).k();
                    if (!(manager instanceof com.bytedance.sdk.openadsdk.api.cw) || (j6 = ((com.bytedance.sdk.openadsdk.api.cw) manager).j(1)) == null) {
                        return;
                    }
                    j6.apply(k6.sparseArray());
                }
            }, 1);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdManager
        public boolean tryShowInstallDialogWhenExit(Activity activity, ExitInstallListener exitInstallListener) {
            if (com.bytedance.sdk.openadsdk.api.up.j()) {
                return false;
            }
            HashMap hashMap = new HashMap();
            hashMap.put(TTDownloadField.TT_ACTIVITY, activity);
            hashMap.put(TTDownloadField.TT_EXIT_INSTALL_LISTENER, new com.bytedance.sdk.openadsdk.i.j.xt.j(exitInstallListener));
            Object apply = com.bytedance.sdk.openadsdk.downloadnew.cw.j(TTAppContextHolder.getContext()).apply(a.b(2).g(0, hashMap).e(-99999987, 0).g(-99999985, Boolean.class).k().sparseArray());
            if (apply == null) {
                return false;
            }
            return ((Boolean) apply).booleanValue();
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdManager
        public void unregister(final Object obj) {
            if (com.bytedance.sdk.openadsdk.api.up.j()) {
                return;
            }
            call(new xt<Manager>() { // from class: com.bytedance.sdk.openadsdk.api.j.cw.3
                @Override // com.bytedance.sdk.openadsdk.api.j.xt
                public void j(Manager manager) {
                    Function<SparseArray<Object>, Object> j6;
                    Object obj2 = obj;
                    if (com.bytedance.sdk.openadsdk.p.xt.j(obj2)) {
                        obj2 = new com.bytedance.sdk.openadsdk.p.xt(obj);
                    }
                    SparseArray<Object> sparseArray = a.b(2).g(8, obj2).e(-99999987, 5).g(-99999985, Void.class).k().sparseArray();
                    if (!(manager instanceof com.bytedance.sdk.openadsdk.api.cw) || (j6 = ((com.bytedance.sdk.openadsdk.api.cw) manager).j(1)) == null) {
                        return;
                    }
                    j6.apply(sparseArray);
                }
            }, 5);
        }

        public void j(boolean z5) {
            this.xt = z5;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void j(Manager manager) {
            if (com.bytedance.sdk.openadsdk.api.up.j()) {
                return;
            }
            this.f27528j = manager;
            if (this.f27528j != null) {
                Iterator<WeakReference<xt<Manager>>> it = this.cw.iterator();
                while (it.hasNext()) {
                    WeakReference<xt<Manager>> next = it.next();
                    xt<Manager> xtVar = next != null ? next.get() : null;
                    if (xtVar != null) {
                        xtVar.j(manager);
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void j(xt<Manager> xtVar) {
            if (com.bytedance.sdk.openadsdk.api.up.j()) {
                return;
            }
            this.cw.add(new WeakReference<>(xtVar));
        }
    }

    /* renamed from: com.bytedance.sdk.openadsdk.api.j$j, reason: collision with other inner class name */
    private static abstract class AbstractC0428j<T> {
        private AbstractC0428j() {
        }

        abstract void j(xt<T> xtVar, int i6);
    }

    private class r implements Function<SparseArray<Object>, Object> {
        private r() {
        }

        @Override // java.util.function.Function
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public Object apply(SparseArray<Object> sparseArray) {
            SparseArray sparseArray2;
            if (sparseArray == null || (sparseArray2 = (SparseArray) a.j(sparseArray).k().objectValue(-99999979, SparseArray.class)) == null) {
                return null;
            }
            ValueSet k6 = a.j(sparseArray2).k();
            j.this.xt(g.a().b(k6.intValue(-999900)).d(k6.stringValue(-999901)).e(k6.booleanValue(-999903)).c(a.j((SparseArray) k6.objectValue(-999902, SparseArray.class)).k()).f());
            return null;
        }
    }

    private static class up extends com.bytedance.sdk.openadsdk.i.j.j {

        /* renamed from: j, reason: collision with root package name */
        private AbstractC0428j<Loader> f27540j;

        private void j(xt<Loader> xtVar, int i6) {
            m.xt("_tt_ad_sdk_", "load ad slot type: ".concat(String.valueOf(i6)));
            this.f27540j.j(xtVar, i6);
        }

        @Override // com.bytedance.sdk.openadsdk.i.j.j
        public void ae(final ValueSet valueSet, final Function<SparseArray<Object>, Object> function) {
            j(new xt<Loader>() { // from class: com.bytedance.sdk.openadsdk.api.j.up.9
                @Override // com.bytedance.sdk.openadsdk.api.j.xt
                public void j(Loader loader) {
                    ValueSet valueSet2 = valueSet;
                    loader.load(5, a.j(valueSet2 != null ? valueSet2.sparseArray() : new SparseArray<>()).i(2, true).g(1, function).k(), null);
                }
            }, 5);
        }

        @Override // com.bytedance.sdk.openadsdk.i.j.j
        public void cw(final ValueSet valueSet, final Function<SparseArray<Object>, Object> function) {
            j(new xt<Loader>() { // from class: com.bytedance.sdk.openadsdk.api.j.up.4
                @Override // com.bytedance.sdk.openadsdk.api.j.xt
                public void j(Loader loader) {
                    ValueSet valueSet2 = valueSet;
                    loader.load(9, a.j(valueSet2 != null ? valueSet2.sparseArray() : new SparseArray<>()).g(1, function).k(), null);
                }
            }, 9);
        }

        @Override // com.bytedance.sdk.openadsdk.i.j.j
        public void g(final ValueSet valueSet, final Function<SparseArray<Object>, Object> function) {
            j(new xt<Loader>() { // from class: com.bytedance.sdk.openadsdk.api.j.up.2
                @Override // com.bytedance.sdk.openadsdk.api.j.xt
                public void j(Loader loader) {
                    ValueSet valueSet2 = valueSet;
                    loader.load(1, a.j(valueSet2 != null ? valueSet2.sparseArray() : new SparseArray<>()).i(2, true).g(1, function).k(), null);
                }
            }, 1);
        }

        @Override // com.bytedance.sdk.openadsdk.i.j.j
        public void m(final ValueSet valueSet, final Function<SparseArray<Object>, Object> function) {
            j(new xt<Loader>() { // from class: com.bytedance.sdk.openadsdk.api.j.up.8
                @Override // com.bytedance.sdk.openadsdk.api.j.xt
                public void j(Loader loader) {
                    ValueSet valueSet2 = valueSet;
                    loader.load(8, a.j(valueSet2 != null ? valueSet2.sparseArray() : new SparseArray<>()).g(1, function).k(), null);
                }
            }, 8);
        }

        @Override // com.bytedance.sdk.openadsdk.i.j.j
        public void r(final ValueSet valueSet, final Function<SparseArray<Object>, Object> function) {
            j(new xt<Loader>() { // from class: com.bytedance.sdk.openadsdk.api.j.up.5
                @Override // com.bytedance.sdk.openadsdk.api.j.xt
                public void j(Loader loader) {
                    ValueSet valueSet2 = valueSet;
                    loader.load(1, a.j(valueSet2 != null ? valueSet2.sparseArray() : new SparseArray<>()).g(1, function).k(), null);
                }
            }, 1);
        }

        @Override // com.bytedance.sdk.openadsdk.i.j.j
        public void tl(final ValueSet valueSet, final Function<SparseArray<Object>, Object> function) {
            j(new xt<Loader>() { // from class: com.bytedance.sdk.openadsdk.api.j.up.10
                @Override // com.bytedance.sdk.openadsdk.api.j.xt
                public void j(Loader loader) {
                    ValueSet valueSet2 = valueSet;
                    loader.load(9, a.j(valueSet2 != null ? valueSet2.sparseArray() : new SparseArray<>()).i(2, true).g(1, function).k(), null);
                }
            }, 9);
        }

        @Override // com.bytedance.sdk.openadsdk.i.j.j
        public void up(final ValueSet valueSet, final Function<SparseArray<Object>, Object> function) {
            j(new xt<Loader>() { // from class: com.bytedance.sdk.openadsdk.api.j.up.7
                @Override // com.bytedance.sdk.openadsdk.api.j.xt
                public void j(Loader loader) {
                    ValueSet valueSet2 = valueSet;
                    loader.load(7, a.j(valueSet2 != null ? valueSet2.sparseArray() : new SparseArray<>()).g(1, function).k(), null);
                }
            }, 7);
        }

        @Override // com.bytedance.sdk.openadsdk.i.j.j
        public void xt(final ValueSet valueSet, final Function<SparseArray<Object>, Object> function) {
            j(new xt<Loader>() { // from class: com.bytedance.sdk.openadsdk.api.j.up.3
                @Override // com.bytedance.sdk.openadsdk.api.j.xt
                public void j(Loader loader) {
                    ValueSet valueSet2 = valueSet;
                    loader.load(6, a.j(valueSet2 != null ? valueSet2.sparseArray() : new SparseArray<>()).g(1, function).k(), null);
                }
            }, 6);
        }

        up(AbstractC0428j<Loader> abstractC0428j) {
            this.f27540j = abstractC0428j;
        }

        @Override // com.bytedance.sdk.openadsdk.i.j.j
        public void j(final ValueSet valueSet, final Function<SparseArray<Object>, Object> function) {
            j(new xt<Loader>() { // from class: com.bytedance.sdk.openadsdk.api.j.up.1
                @Override // com.bytedance.sdk.openadsdk.api.j.xt
                public void j(Loader loader) {
                    ValueSet valueSet2 = valueSet;
                    loader.load(5, a.j(valueSet2 != null ? valueSet2.sparseArray() : new SparseArray<>()).g(1, function).k(), null);
                }
            }, 5);
        }

        @Override // com.bytedance.sdk.openadsdk.i.j.j
        public void j(final ValueSet valueSet, final Function<SparseArray<Object>, Object> function, final int i6) {
            j(new xt<Loader>() { // from class: com.bytedance.sdk.openadsdk.api.j.up.6
                @Override // com.bytedance.sdk.openadsdk.api.j.xt
                public void j(Loader loader) {
                    ValueSet valueSet2 = valueSet;
                    loader.load(3, a.j(valueSet2 != null ? valueSet2.sparseArray() : new SparseArray<>()).e(3, i6).g(1, function).k(), null);
                }
            }, 3);
        }

        @Override // com.bytedance.sdk.openadsdk.i.j.j
        public Pair<Integer, String> j(Exception exc) {
            m.r("_tt_ad_sdk_", "Load ad failed: " + exc.getMessage());
            if ((exc instanceof IllegalStateException) && "广告SDK未Ready, 请在load(请求广告）之前，先调用init and start方法，以避免无法请求广告".equals(exc.getMessage())) {
                return new Pair<>(4208, exc.getMessage());
            }
            return new Pair<>(Integer.valueOf(TTAdConstant.INIT_FAILED_CREATE_INVOKE_FAILED), "Load ad failed: " + exc.getMessage());
        }
    }

    private interface xt<T> {
        void j(T t5);
    }

    protected abstract com.bytedance.sdk.openadsdk.cw.cw cw();

    protected void j(Result result) {
    }

    public abstract boolean j();

    public abstract boolean j(Context context, a aVar);

    public abstract cw xt();

    public abstract void xt(Context context, a aVar);

    protected boolean xt(Context context, AdConfig adConfig, TTAdSdk.InitCallback initCallback) {
        return false;
    }

    public void j(final Context context, AdConfig adConfig, TTAdSdk.InitCallback initCallback) {
        if (com.bytedance.sdk.openadsdk.api.up.j()) {
            if (initCallback != null) {
                initCallback.fail(4209, "init csj sdk fail, that only support android os >= android 7.0（API-24）");
                return;
            }
            return;
        }
        com.bytedance.sdk.openadsdk.cw.r.j().j(cw());
        if (xt(context, adConfig, initCallback)) {
            this.f27526j = initCallback;
            final a j6 = a.j(com.bytedance.sdk.openadsdk.i.j.cw.j.j(adConfig));
            j6.f(1, SystemClock.elapsedRealtime());
            j6.h(5, "main");
            j6.i(4, true);
            j6.e(6, 999);
            j6.e(10, 7012);
            j6.h(11, "7.0.1.2");
            j6.h(12, "com.byted.pangle");
            j6.i(14, true);
            j6.g(16, com.bytedance.sdk.openadsdk.cw.r.j());
            j6.g(17, com.bytedance.sdk.openadsdk.mi.j.j().xt());
            Thread currentThread = Thread.currentThread();
            j6.h(2, currentThread.getName());
            j6.e(3, currentThread.getPriority());
            j6.g(15, new r());
            j6.g(8301, new MediationInitCLassLoader());
            if (!j(context, j6)) {
                com.bytedance.sdk.openadsdk.mi.j.j().j(new Runnable() { // from class: com.bytedance.sdk.openadsdk.api.j.1
                    @Override // java.lang.Runnable
                    public void run() {
                        j.this.xt(context, j6);
                    }
                });
            }
            xt().j(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void xt(Result result) {
        j(result);
        if (result.isSuccess()) {
            m.xt("_tt_ad_sdk_", "init sdk success ");
            TTAdSdk.InitCallback initCallback = this.f27526j;
            if (initCallback != null) {
                initCallback.success();
            }
        } else {
            m.up("_tt_ad_sdk_", "int sdk failed, code: " + result.code() + ", message: " + result.message());
            TTAdSdk.InitCallback initCallback2 = this.f27526j;
            if (initCallback2 != null) {
                initCallback2.fail(result.code(), result.message() != null ? result.message() : "");
            }
        }
        this.f27526j = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void j(Manager manager) {
        m.xt("_tt_ad_sdk_", "update manager");
        xt().j(manager);
        xt().register(com.bytedance.sdk.openadsdk.cw.r.j());
    }
}
