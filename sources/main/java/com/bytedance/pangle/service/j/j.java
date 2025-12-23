package com.bytedance.pangle.service.j;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.plugin.Plugin;
import com.bytedance.pangle.plugin.PluginManager;
import com.bytedance.pangle.tl;
import com.bytedance.pangle.up;
import com.bytedance.sdk.openadsdk.api.m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j extends up.j {
    private static volatile j xt;
    private final HashMap<ComponentName, IBinder> cw = new HashMap<>();

    /* renamed from: r, reason: collision with root package name */
    private final HashMap<ComponentName, xt> f25502r = new HashMap<>();
    private final C0391j<Intent> up = new C0391j<>();

    /* renamed from: m, reason: collision with root package name */
    private final HashMap<ComponentName, com.bytedance.pangle.service.j> f25501m = new HashMap<>();
    private final HashSet<ComponentName> ae = new HashSet<>();
    private final HashSet<ComponentName> tl = new HashSet<>();

    /* renamed from: g, reason: collision with root package name */
    private final List<Runnable> f25499g = new ArrayList();

    /* renamed from: j, reason: collision with root package name */
    private final Handler f25500j = new Handler(Looper.getMainLooper());

    /* renamed from: com.bytedance.pangle.service.j.j$j, reason: collision with other inner class name */
    class C0391j<T> extends HashMap<tl, T> {
        C0391j() {
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public boolean containsKey(@Nullable Object obj) {
            if (super.containsKey(obj)) {
                return true;
            }
            if (!(obj instanceof tl)) {
                return false;
            }
            Iterator<tl> it = keySet().iterator();
            while (it.hasNext()) {
                try {
                } catch (RemoteException e6) {
                    m.j(e6);
                }
                if (it.next().j() == ((tl) obj).j()) {
                    return true;
                }
            }
            return false;
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        @Nullable
        public T remove(@Nullable Object obj) {
            tl tlVar;
            T t5 = (T) super.remove(obj);
            if (t5 != null) {
                return t5;
            }
            Iterator<tl> it = keySet().iterator();
            while (true) {
                if (it.hasNext()) {
                    tlVar = it.next();
                    try {
                    } catch (RemoteException e6) {
                        m.j(e6);
                    }
                    if (tlVar.j() == ((tl) obj).j()) {
                        break;
                    }
                } else {
                    tlVar = null;
                    break;
                }
            }
            return (T) super.remove(tlVar);
        }
    }

    class xt extends HashSet<tl> {
        xt() {
        }

        @Override // java.util.HashSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@Nullable Object obj) {
            if (super.contains(obj)) {
                return true;
            }
            if (!(obj instanceof tl)) {
                return false;
            }
            Iterator<tl> it = iterator();
            while (it.hasNext()) {
                try {
                } catch (RemoteException e6) {
                    m.j(e6);
                }
                if (it.next().j() == ((tl) obj).j()) {
                    return true;
                }
            }
            return false;
        }

        @Override // java.util.HashSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(@Nullable Object obj) {
            tl tlVar;
            if (super.remove(obj)) {
                return true;
            }
            Iterator it = iterator();
            while (true) {
                if (it.hasNext()) {
                    tlVar = (tl) it.next();
                    try {
                    } catch (RemoteException e6) {
                        m.j(e6);
                    }
                    if (tlVar.j() == ((tl) obj).j()) {
                        break;
                    }
                } else {
                    tlVar = null;
                    break;
                }
            }
            return super.remove(tlVar);
        }
    }

    public static j xt() {
        if (xt == null) {
            synchronized (j.class) {
                try {
                    if (xt == null) {
                        xt = new j();
                    }
                } finally {
                }
            }
        }
        return xt;
    }

    @Override // com.bytedance.pangle.up.j, android.os.IInterface
    public IBinder asBinder() {
        return null;
    }

    public void cw() {
        for (Runnable runnable : this.f25499g) {
            if (runnable != null) {
                this.f25500j.post(runnable);
            }
        }
        this.f25499g.clear();
    }

    private j() {
    }

    @Override // com.bytedance.pangle.up
    public boolean bindService(final Intent intent, final tl tlVar, final int i6, final String str) throws RemoteException {
        if (Zeus.hasInit()) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                return j(intent, tlVar, i6, str);
            }
            this.f25500j.post(new Runnable() { // from class: com.bytedance.pangle.service.j.j.4
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        j.this.j(intent, tlVar, i6, str);
                    } catch (RemoteException e6) {
                        ZeusLogger.errReport(ZeusLogger.TAG_SERVICE, "bindService failed", e6);
                    }
                }
            });
            return true;
        }
        this.f25499g.add(new Runnable() { // from class: com.bytedance.pangle.service.j.j.5
            @Override // java.lang.Runnable
            public void run() {
                try {
                    j.this.j(intent, tlVar, i6, str);
                } catch (RemoteException e6) {
                    ZeusLogger.errReport(ZeusLogger.TAG_SERVICE, "pending bindService failed", e6);
                }
            }
        });
        return true;
    }

    @Override // com.bytedance.pangle.up
    public ComponentName startService(final Intent intent, final String str) {
        if (Zeus.hasInit()) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                return j(intent, str);
            }
            this.f25500j.post(new Runnable() { // from class: com.bytedance.pangle.service.j.j.1
                @Override // java.lang.Runnable
                public void run() {
                    j.this.j(intent, str);
                }
            });
        } else {
            this.f25499g.add(new Runnable() { // from class: com.bytedance.pangle.service.j.j.2
                @Override // java.lang.Runnable
                public void run() {
                    j.this.j(intent, str);
                }
            });
        }
        return intent.getComponent();
    }

    @Override // com.bytedance.pangle.up
    public boolean stopService(final Intent intent, String str) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            xt().j(intent.getComponent());
            return true;
        }
        this.f25500j.post(new Runnable() { // from class: com.bytedance.pangle.service.j.j.3
            @Override // java.lang.Runnable
            public void run() {
                j.xt().j(intent.getComponent());
            }
        });
        return true;
    }

    @Override // com.bytedance.pangle.up
    public void unbindService(final tl tlVar) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            j(tlVar);
        } else {
            this.f25500j.post(new Runnable() { // from class: com.bytedance.pangle.service.j.j.6
                @Override // java.lang.Runnable
                public void run() {
                    j.this.j(tlVar);
                }
            });
        }
    }

    private com.bytedance.pangle.service.j cw(Intent intent, String str) {
        boolean z5;
        ComponentName component = intent.getComponent();
        Plugin plugin = PluginManager.getInstance().getPlugin(str);
        try {
            z5 = Zeus.loadPlugin(str);
            try {
                com.bytedance.pangle.service.j jVar = (com.bytedance.pangle.service.j) plugin.mClassLoader.loadClass(component.getClassName()).newInstance();
                jVar.attach(plugin);
                return jVar;
            } catch (Exception e6) {
                e = e6;
                ZeusLogger.errReport(ZeusLogger.TAG_SERVICE, "newServiceInstance failed! loadPlugin = ".concat(String.valueOf(z5)), e);
                return null;
            }
        } catch (Exception e7) {
            e = e7;
            z5 = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized ComponentName j(Intent intent, String str) {
        try {
            ComponentName component = intent.getComponent();
            if (!this.f25501m.containsKey(component)) {
                com.bytedance.pangle.service.j xt2 = xt(intent, str);
                if (xt2 == null) {
                    return component;
                }
                this.f25501m.put(component, xt2);
                this.ae.add(component);
            }
            com.bytedance.pangle.service.j jVar = this.f25501m.get(component);
            if (jVar != null) {
                jVar.onStartCommand(intent, 0, 0);
            }
            return component;
        } catch (Throwable th) {
            throw th;
        }
    }

    private com.bytedance.pangle.service.j xt(Intent intent, String str) {
        com.bytedance.pangle.service.j cw = cw(intent, str);
        if (cw != null) {
            cw.onCreate();
        }
        return cw;
    }

    private boolean xt(ComponentName componentName) {
        if (!this.ae.contains(componentName)) {
            if (this.f25502r.get(componentName) != null) {
                return false;
            }
            cw(componentName);
            return true;
        }
        if (!this.tl.contains(componentName) || this.f25502r.containsKey(componentName)) {
            return false;
        }
        cw(componentName);
        return true;
    }

    private void cw(ComponentName componentName) {
        com.bytedance.pangle.service.j remove = this.f25501m.remove(componentName);
        this.tl.remove(componentName);
        this.cw.remove(componentName);
        this.ae.remove(componentName);
        if (remove != null) {
            remove.onDestroy();
        }
    }

    public synchronized boolean j(ComponentName componentName) {
        if (!this.f25501m.containsKey(componentName)) {
            return false;
        }
        this.tl.add(componentName);
        return xt(componentName);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized boolean j(Intent intent, tl tlVar, int i6, String str) throws RemoteException {
        try {
            ComponentName component = intent.getComponent();
            if (!this.f25501m.containsKey(component)) {
                com.bytedance.pangle.service.j xt2 = xt(intent, str);
                if (xt2 == null) {
                    return false;
                }
                this.f25501m.put(component, xt2);
            }
            com.bytedance.pangle.service.j jVar = this.f25501m.get(component);
            if (!this.cw.containsKey(component)) {
                this.cw.put(component, jVar.onBind(intent));
            }
            IBinder iBinder = this.cw.get(component);
            if (iBinder != null) {
                if (this.f25502r.containsKey(component)) {
                    if (!this.f25502r.get(component).contains(tlVar)) {
                        this.f25502r.get(component).add(tlVar);
                        this.up.put(tlVar, intent);
                        tlVar.j(component, iBinder);
                    }
                } else {
                    xt xtVar = new xt();
                    xtVar.add(tlVar);
                    this.f25502r.put(component, xtVar);
                    this.up.put(tlVar, intent);
                    tlVar.j(component, iBinder);
                }
            }
            return true;
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void j(tl tlVar) {
        try {
            for (ComponentName componentName : this.f25502r.keySet()) {
                xt xtVar = this.f25502r.get(componentName);
                if (xtVar.contains(tlVar)) {
                    xtVar.remove(tlVar);
                    Intent remove = this.up.remove(tlVar);
                    if (xtVar.size() == 0) {
                        this.f25502r.remove(componentName);
                        com.bytedance.pangle.service.j jVar = this.f25501m.get(componentName);
                        if (jVar != null) {
                            jVar.onUnbind(remove);
                        }
                    }
                    xt(componentName);
                    return;
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
