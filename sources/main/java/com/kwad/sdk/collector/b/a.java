package com.kwad.sdk.collector.b;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.Process;
import android.os.RemoteException;
import android.webkit.WebView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ksad.annotation.invoker.InvokeBy;
import com.kwad.sdk.api.proxy.app.ServiceProxyRemote;
import com.kwad.sdk.collector.AppStatusRules;
import com.kwad.sdk.collector.d;
import com.kwad.sdk.collector.model.b;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.utils.SystemUtil;
import com.kwad.sdk.utils.aa;
import com.kwad.sdk.utils.ay;
import com.kwad.sdk.utils.g;
import com.stub.StubApp;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class a extends com.kwad.sdk.m.a {
    private static AtomicBoolean avn = new AtomicBoolean(false);
    public static volatile Message avo;
    private HandlerC0671a avl = new HandlerC0671a(0);
    private Messenger avm = new Messenger(this.avl);

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.kwad.sdk.collector.b.a$a, reason: collision with other inner class name */
    static class HandlerC0671a extends Handler {
        private WeakReference<Service> avq;

        private HandlerC0671a() {
        }

        /* synthetic */ HandlerC0671a(byte b6) {
            this();
        }

        public final void a(@Nullable Service service) {
            if (service != null) {
                this.avq = new WeakReference<>(service);
            } else {
                this.avq = null;
            }
        }

        @Override // android.os.Handler
        public final void handleMessage(@NonNull Message message) {
            Service service;
            super.handleMessage(message);
            c.d("RemoteService", "handleMessage");
            WeakReference<Service> weakReference = this.avq;
            if (weakReference != null) {
                service = weakReference.get();
            } else {
                service = null;
            }
            if (service != null) {
                if (!a.DP().get()) {
                    c.d("RemoteService", "save buffered message");
                    a.avo = Message.obtain(message);
                    return;
                }
                final Messenger messenger = message.replyTo;
                int i6 = message.what;
                c.d("RemoteService", "handleMessage what: " + i6);
                if (i6 != 100) {
                    return;
                }
                final Bundle bundle = new Bundle();
                g.a(service, new g.b() { // from class: com.kwad.sdk.collector.b.a.a.1
                    @Override // com.kwad.sdk.utils.g.b
                    public final void x(List<b> list) {
                        c.d("RemoteService", "RemoteService: onAppStatusResult list: " + list);
                        if (list != null && !list.isEmpty()) {
                            c.d("RemoteService", "RemoteService: onAppStatusResult: " + list.size());
                            JSONArray P = g.a.P(list);
                            String jSONArray = P != null ? P.toString() : null;
                            c.d("RemoteService", "resultJson :" + jSONArray);
                            if (jSONArray != null) {
                                AppStatusRules Pr = g.Pr();
                                ArrayList<AppStatusRules.Strategy> allStrategy = Pr != null ? Pr.getAllStrategy() : null;
                                String jSONArray2 = allStrategy != null ? aa.S(allStrategy).toString() : null;
                                bundle.putString("resultJson", jSONArray);
                                bundle.putString("allStrategyJson", jSONArray2);
                            }
                        }
                        try {
                            Message obtain = Message.obtain();
                            obtain.what = 101;
                            obtain.setData(bundle);
                            messenger.send(obtain);
                        } catch (RemoteException unused) {
                        }
                        if (list == null || list.isEmpty()) {
                            return;
                        }
                        Iterator<b> it = list.iterator();
                        while (it.hasNext()) {
                            it.next().destroy();
                        }
                    }
                });
            }
        }
    }

    public static AtomicBoolean DP() {
        return avn;
    }

    public static void a(@NonNull Context context, ServiceConnection serviceConnection) {
        c.d("RemoteService", "bindASService");
        context.bindService(new Intent(context, (Class<?>) ServiceProxyRemote.class), serviceConnection, 1);
    }

    public static void b(@NonNull Context context, ServiceConnection serviceConnection) {
        c.d("RemoteService", "unbindASService");
        try {
            context.unbindService(serviceConnection);
        } catch (Exception e6) {
            c.printStackTrace(e6);
        }
    }

    @InvokeBy(invokerClass = com.kwad.sdk.service.c.class, methodId = "initComponentProxyForInvoker")
    public static void register() {
        try {
            com.kwad.sdk.service.c.a(Class.forName("com.kwad.sdk.api.proxy.app.ServiceProxyRemote"), a.class);
        } catch (Throwable unused) {
        }
    }

    @Override // com.kwad.sdk.m.a, com.kwad.sdk.api.proxy.IServiceProxy
    public IBinder onBind(@NonNull Service service, Intent intent) {
        return this.avm.getBinder();
    }

    private static boolean bo(Context context) {
        String processName = ay.getProcessName(context);
        if (processName == null || context.getPackageName().equals(processName)) {
            return false;
        }
        return true;
    }

    @Override // com.kwad.sdk.m.a, com.kwad.sdk.api.proxy.IServiceProxy
    public void onCreate(Service service) {
        super.onCreate(service);
        if (Build.VERSION.SDK_INT >= 28) {
            try {
                WebView.setDataDirectorySuffix(ay.getProcessName(StubApp.getOrigApplicationContext(service.getApplicationContext())));
            } catch (Exception e6) {
                c.d("RemoteService", "WebView has already been initialized " + e6.getMessage());
            }
        }
        c.d("RemoteService", "onCreate processName:" + ay.getProcessName(service));
        if (!SystemUtil.isInMainProcess(service)) {
            d.a(service, new d.a() { // from class: com.kwad.sdk.collector.b.a.1
                @Override // com.kwad.sdk.collector.d.a
                public final void cB(String str) {
                    c.e("RemoteService", "onLoadError: " + str);
                    a.avn.set(false);
                }

                @Override // com.kwad.sdk.collector.d.a
                public final void onLoaded() {
                    c.d("RemoteService", "onLoaded");
                    a.avn.set(true);
                    if (a.avo != null) {
                        a.this.avl.handleMessage(a.avo);
                        a.avo = null;
                    }
                }
            });
        } else {
            avn.set(true);
        }
        this.avl.a(service);
    }

    @Override // com.kwad.sdk.m.a, com.kwad.sdk.api.proxy.IServiceProxy
    public void onDestroy(@NonNull Service service) {
        super.onDestroy(service);
        c.d("RemoteService", "onDestroy");
        this.avl.a(null);
        if (bo(service)) {
            c.d("RemoteService", "goto kill myself");
            Process.killProcess(Process.myPid());
        }
    }
}
