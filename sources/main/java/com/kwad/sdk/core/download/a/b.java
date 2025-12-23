package com.kwad.sdk.core.download.a;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.h;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class b {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface a {
        void onError(Throwable th);

        void onPreStart();

        void onStart();

        void onSuccess();

        void pU();

        boolean pV();
    }

    public static int F(Context context, String str) {
        return a(context, str, new C0682b());
    }

    public static int a(Context context, String str, @NonNull a aVar) {
        if (TextUtils.isEmpty(str) || context == null) {
            return 0;
        }
        try {
            aVar.onPreStart();
            com.kwad.sdk.core.d.c.d("DeepLinkUtil", "handleDeepLink: " + str);
            Uri parse = Uri.parse(str);
            h hVar = (h) ServiceProvider.get(h.class);
            int ch = hVar != null ? hVar.ch(parse.getScheme()) : -1;
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.setData(parse);
            com.kwad.sdk.core.d.c.d("DeepLinkUtil", "handleDeepLink: configFlags: " + ch);
            if (ch > 0) {
                intent.setFlags(ch);
            } else {
                intent.setFlags(268435456);
            }
            List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 65536);
            if (queryIntentActivities != null && queryIntentActivities.size() > 0) {
                aVar.onStart();
                context.startActivity(intent);
                aVar.onSuccess();
                return 1;
            }
            aVar.pU();
            if (!aVar.pV()) {
                return 0;
            }
            aVar.onStart();
            context.startActivity(intent);
            aVar.onSuccess();
            return 1;
        } catch (Throwable th) {
            aVar.onError(th);
            return -1;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.kwad.sdk.core.download.a.b$b, reason: collision with other inner class name */
    public static class C0682b implements a {
        @Override // com.kwad.sdk.core.download.a.b.a
        public final boolean pV() {
            return false;
        }

        @Override // com.kwad.sdk.core.download.a.b.a
        public final void onPreStart() {
        }

        @Override // com.kwad.sdk.core.download.a.b.a
        public void onStart() {
        }

        @Override // com.kwad.sdk.core.download.a.b.a
        public void onSuccess() {
        }

        @Override // com.kwad.sdk.core.download.a.b.a
        public final void pU() {
        }

        @Override // com.kwad.sdk.core.download.a.b.a
        public void onError(Throwable th) {
        }
    }
}
