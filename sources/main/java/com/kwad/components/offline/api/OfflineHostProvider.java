package com.kwad.components.offline.api;

import android.content.Context;
import com.kwad.components.offline.api.core.IOfflineHostApi;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class OfflineHostProvider {
    private Context mContext;
    private IOfflineHostApi mOfflineHostApi;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.kwad.components.offline.api.OfflineHostProvider$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class Holder {
        private static final OfflineHostProvider sInstance = new OfflineHostProvider(null);

        private Holder() {
        }
    }

    /* synthetic */ OfflineHostProvider(AnonymousClass1 anonymousClass1) {
        this();
    }

    private OfflineHostProvider() {
    }

    public Context getContext() {
        return this.mContext;
    }

    public void init(Context context, IOfflineHostApi iOfflineHostApi) {
        this.mContext = context;
        this.mOfflineHostApi = iOfflineHostApi;
    }

    public static OfflineHostProvider get() {
        return Holder.sInstance;
    }

    public static IOfflineHostApi getApi() {
        return get().mOfflineHostApi;
    }
}
