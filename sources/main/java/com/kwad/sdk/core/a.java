package com.kwad.sdk.core;

import android.text.TextUtils;
import com.kwad.sdk.core.download.DownloadParams;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.f;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class a {
    private ConcurrentHashMap<String, DownloadParams> awA;
    private ConcurrentHashMap<String, AdTemplate> awB;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.kwad.sdk.core.a$a, reason: collision with other inner class name */
    static final class C0674a {
        private static final a awC = new a(0);
    }

    /* synthetic */ a(byte b6) {
        this();
    }

    private a() {
        this.awA = new ConcurrentHashMap<>();
        this.awB = new ConcurrentHashMap<>();
    }

    public final void a(String str, DownloadParams downloadParams) {
        if (((f) ServiceProvider.get(f.class)).getContext() == null) {
            return;
        }
        this.awA.put(str, downloadParams);
        ((f) ServiceProvider.get(f.class)).getContext().getSharedPreferences("ksadsdk_notification_download_complete", 0).edit().putString(str, downloadParams.toJson().toString()).apply();
    }

    public final DownloadParams di(String str) {
        if (((f) ServiceProvider.get(f.class)).getContext() == null) {
            return null;
        }
        DownloadParams downloadParams = this.awA.get(str);
        if (downloadParams != null) {
            return downloadParams;
        }
        String string = ((f) ServiceProvider.get(f.class)).getContext().getSharedPreferences("ksadsdk_notification_download_complete", 0).getString(str, "");
        if (!TextUtils.isEmpty(string)) {
            DownloadParams downloadParams2 = new DownloadParams();
            try {
                downloadParams2.parseJson(new JSONObject(string));
                return downloadParams2;
            } catch (JSONException e6) {
                com.kwad.sdk.core.d.c.printStackTrace(e6);
            }
        }
        return null;
    }

    public final void dj(String str) {
        if (((f) ServiceProvider.get(f.class)).getContext() == null) {
            return;
        }
        this.awA.remove(str);
        ((f) ServiceProvider.get(f.class)).getContext().getSharedPreferences("ksadsdk_notification_download_complete", 0).edit().remove(str).apply();
    }

    public final AdTemplate dk(String str) {
        if (((f) ServiceProvider.get(f.class)).getContext() == null) {
            return null;
        }
        AdTemplate adTemplate = this.awB.get(str);
        if (adTemplate != null) {
            return adTemplate;
        }
        String string = ((f) ServiceProvider.get(f.class)).getContext().getSharedPreferences("ksadsdk_notification_download_complete", 0).getString(str, "");
        if (!TextUtils.isEmpty(string)) {
            AdTemplate adTemplate2 = new AdTemplate();
            try {
                adTemplate2.parseJson(new JSONObject(string));
                return adTemplate2;
            } catch (JSONException e6) {
                e6.printStackTrace();
            }
        }
        return null;
    }

    public final void dl(String str) {
        if (((f) ServiceProvider.get(f.class)).getContext() == null) {
            return;
        }
        this.awB.remove(str);
        ((f) ServiceProvider.get(f.class)).getContext().getSharedPreferences("ksadsdk_notification_download_complete", 0).edit().remove(str).apply();
    }

    public final void e(String str, AdTemplate adTemplate) {
        if (((f) ServiceProvider.get(f.class)).getContext() == null) {
            return;
        }
        this.awB.put(str, adTemplate);
        ((f) ServiceProvider.get(f.class)).getContext().getSharedPreferences("ksadsdk_notification_download_complete", 0).edit().putString(str, adTemplate.toJson().toString()).apply();
    }

    public static a Em() {
        return C0674a.awC;
    }
}
