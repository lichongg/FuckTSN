package com.kwad.framework.filedownloader.services;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.webkit.WebView;
import androidx.annotation.Keep;
import com.ksad.annotation.invoker.InvokeBy;
import com.kwad.sdk.api.core.KsAdSdkDynamicImpl;
import com.kwad.sdk.api.proxy.app.FileDownloadService;
import com.kwad.sdk.utils.ay;
import com.stub.StubApp;
import java.lang.ref.WeakReference;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@KsAdSdkDynamicImpl(FileDownloadService.class)
@Keep
@SuppressLint({"Registered"})
/* loaded from: D:\Downloads\app\classes6.dex */
public class FileDownloadServiceProxy extends com.kwad.sdk.m.a {
    private static final String TAG = "filedownloader";
    public Service context;
    private i handler;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @KsAdSdkDynamicImpl(FileDownloadService.SeparateProcessService.class)
    @Keep
    public static class SeparateProcessServiceProxy extends FileDownloadServiceProxy {
        @Override // com.kwad.framework.filedownloader.services.FileDownloadServiceProxy, com.kwad.sdk.m.a, com.kwad.sdk.api.proxy.IServiceProxy
        public void onCreate(Service service) {
            if (Build.VERSION.SDK_INT >= 28) {
                try {
                    WebView.setDataDirectorySuffix(ay.getProcessName(StubApp.getOrigApplicationContext(service.getApplicationContext())));
                } catch (Exception unused) {
                }
            }
            super.onCreate(service);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @KsAdSdkDynamicImpl(FileDownloadService.SharedMainProcessService.class)
    @Keep
    public static class SharedMainProcessServiceProxy extends FileDownloadServiceProxy {
        @Override // com.kwad.framework.filedownloader.services.FileDownloadServiceProxy, com.kwad.sdk.m.a, com.kwad.sdk.api.proxy.IServiceProxy
        public void onCreate(Service service) {
            super.onCreate(service);
        }
    }

    @InvokeBy(invokerClass = com.kwad.sdk.service.c.class, methodId = "initComponentProxyForInvoker")
    public static void register() {
        com.kwad.sdk.service.c.a(FileDownloadService.SeparateProcessService.class, SeparateProcessServiceProxy.class);
        com.kwad.sdk.service.c.a(FileDownloadService.SharedMainProcessService.class, SharedMainProcessServiceProxy.class);
    }

    @Override // com.kwad.sdk.m.a, com.kwad.sdk.api.proxy.IServiceProxy
    public IBinder onBind(Service service, Intent intent) {
        return this.handler.zq();
    }

    @Override // com.kwad.sdk.m.a, com.kwad.sdk.api.proxy.IServiceProxy
    public void onCreate(Service service) {
        if (service == null) {
            return;
        }
        this.context = service;
        com.kwad.framework.filedownloader.f.c.aI(StubApp.getOrigApplicationContext(service.getApplicationContext()));
        try {
            com.kwad.framework.filedownloader.f.f.cf(com.kwad.framework.filedownloader.f.e.zB().apE);
            com.kwad.framework.filedownloader.f.f.ac(com.kwad.framework.filedownloader.f.e.zB().apF);
        } catch (IllegalAccessException e6) {
            e6.printStackTrace();
        }
        g gVar = new g();
        if (com.kwad.framework.filedownloader.f.e.zB().apH) {
            this.handler = new e(new WeakReference(this), gVar);
        } else {
            this.handler = new d(new WeakReference(this), gVar);
        }
    }

    @Override // com.kwad.sdk.m.a, com.kwad.sdk.api.proxy.IServiceProxy
    public void onDestroy(Service service) {
        this.handler.onDestroy();
    }

    @Override // com.kwad.sdk.m.a, com.kwad.sdk.api.proxy.IServiceProxy
    public int onStartCommand(Service service, Intent intent, int i6, int i7) {
        this.handler.zp();
        return 2;
    }
}
