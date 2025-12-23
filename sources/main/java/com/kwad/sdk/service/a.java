package com.kwad.sdk.service;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import androidx.work.WorkRequest;
import com.ksad.annotation.invoker.InvokeBy;
import com.kwad.sdk.DownloadTask;
import com.kwad.sdk.api.proxy.app.DownloadService;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class a extends com.kwad.sdk.m.a {
    private com.kwad.sdk.c aYc;
    private Service aYe;
    private final Map<String, Integer> aYd = new ConcurrentHashMap();
    private final HandlerC0709a aYf = new HandlerC0709a(this);

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.kwad.sdk.service.a$a, reason: collision with other inner class name */
    static class HandlerC0709a extends Handler {
        final WeakReference<a> aYg;

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            a aVar = this.aYg.get();
            if (aVar != null && message.what == 1) {
                if (aVar.aYc == null || !aVar.aYc.AG()) {
                    sendEmptyMessageDelayed(1, WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS);
                } else {
                    aVar.aYe.stopSelf();
                }
            }
        }

        public HandlerC0709a(a aVar) {
            this.aYg = new WeakReference<>(aVar);
        }
    }

    private void h(Intent intent) {
        if (intent == null) {
            return;
        }
        try {
            int intExtra = intent.getIntExtra("download_service_type_tag", 0);
            String stringExtra = intent.getStringExtra("download_service_id_tag");
            DownloadTask.DownloadRequest downloadRequest = (DownloadTask.DownloadRequest) intent.getSerializableExtra("download_service_args_tag");
            Integer num = TextUtils.isEmpty(stringExtra) ? null : this.aYd.get(stringExtra);
            int intValue = num != null ? num.intValue() : 0;
            if (intExtra == 1) {
                this.aYd.put(stringExtra, Integer.valueOf(this.aYc.a(downloadRequest, (com.kwad.sdk.a) null)));
                return;
            }
            if (intExtra == 2) {
                this.aYc.pause(intValue);
                return;
            }
            if (intExtra == 3) {
                this.aYc.resume(intValue);
                return;
            }
            if (intExtra != 4) {
                return;
            }
            if (intValue != 0) {
                this.aYc.cancel(intValue);
                return;
            }
            String stringExtra2 = intent.getStringExtra("download_service_path");
            if (stringExtra2 != null) {
                com.kwad.sdk.c.cc(stringExtra2);
            }
        } catch (Exception unused) {
        }
    }

    @InvokeBy(invokerClass = c.class, methodId = "initComponentProxyForInvoker")
    public static void register() {
        c.a(DownloadService.class, a.class);
    }

    @Override // com.kwad.sdk.m.a, com.kwad.sdk.api.proxy.IServiceProxy
    public void onCreate(Service service) {
        if (service == null) {
            return;
        }
        this.aYe = service;
        this.aYc = com.kwad.sdk.c.AA();
        this.aYf.sendEmptyMessageDelayed(1, WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS);
    }

    @Override // com.kwad.sdk.m.a, com.kwad.sdk.api.proxy.IServiceProxy
    public int onStartCommand(Service service, Intent intent, int i6, int i7) {
        h(intent);
        return super.onStartCommand(service, intent, i6, i7);
    }
}
