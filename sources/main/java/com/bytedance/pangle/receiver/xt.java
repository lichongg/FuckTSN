package com.bytedance.pangle.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Handler;
import com.bytedance.pangle.log.ZeusLogger;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

/* loaded from: D:\Downloads\app\classes3.dex */
public class xt {
    private static xt xt;
    private final Map<String, j> cw = new ConcurrentHashMap();

    /* renamed from: r, reason: collision with root package name */
    private final Map<PluginBroadcastReceiver, BroadcastReceiver> f25473r = new ConcurrentHashMap();

    /* renamed from: j, reason: collision with root package name */
    public final Set<Integer> f25472j = new CopyOnWriteArraySet();

    public static class j {

        /* renamed from: j, reason: collision with root package name */
        public String f25474j;
        public final Set<PluginBroadcastReceiver> xt = new CopyOnWriteArraySet();

        public void j(Context context, Intent intent) {
            Set<PluginBroadcastReceiver> set = this.xt;
            if (set == null || set.size() <= 0) {
                return;
            }
            for (PluginBroadcastReceiver pluginBroadcastReceiver : this.xt) {
                if (pluginBroadcastReceiver != null) {
                    try {
                        pluginBroadcastReceiver.onReceive(context, intent);
                    } catch (Throwable th) {
                        ZeusLogger.w(ZeusLogger.TAG_RECEIVER, "plugin-receiver->action:" + (intent != null ? intent.getAction() : "") + "[exception]:", th);
                    }
                }
            }
        }

        public void registerReceiver(PluginBroadcastReceiver pluginBroadcastReceiver) {
            if (pluginBroadcastReceiver != null) {
                this.xt.add(pluginBroadcastReceiver);
            }
        }

        public void unregisterReceiver(PluginBroadcastReceiver pluginBroadcastReceiver) {
            if (pluginBroadcastReceiver != null) {
                try {
                    if (this.xt.size() > 0) {
                        this.xt.remove(pluginBroadcastReceiver);
                    }
                } catch (Throwable th) {
                    ZeusLogger.w(ZeusLogger.TAG_RECEIVER, "unregisterReceiver-plugin-receiver->action:" + this.f25474j + "[exception]:", th);
                }
            }
        }
    }

    public static xt j() {
        if (xt == null) {
            synchronized (com.bytedance.pangle.service.j.j.class) {
                try {
                    if (xt == null) {
                        xt = new xt();
                    }
                } finally {
                }
            }
        }
        return xt;
    }

    public Intent registerReceiver(Context context, PluginBroadcastReceiver pluginBroadcastReceiver, IntentFilter intentFilter) {
        Intent registerReceiver;
        if (intentFilter == null || intentFilter.actionsIterator() == null) {
            return null;
        }
        if (pluginBroadcastReceiver == null) {
            if (Build.VERSION.SDK_INT < 34 || context.getApplicationInfo().targetSdkVersion < 34) {
                return context.registerReceiver(null, intentFilter);
            }
            registerReceiver = context.registerReceiver(null, intentFilter, 2);
            return registerReceiver;
        }
        BroadcastReceiverProxy broadcastReceiverProxy = new BroadcastReceiverProxy();
        Intent registerReceiver2 = (Build.VERSION.SDK_INT < 34 || context.getApplicationInfo().targetSdkVersion < 34) ? context.registerReceiver(broadcastReceiverProxy, intentFilter) : context.registerReceiver(broadcastReceiverProxy, intentFilter, 2);
        this.f25473r.put(pluginBroadcastReceiver, broadcastReceiverProxy);
        j(intentFilter, pluginBroadcastReceiver);
        return registerReceiver2;
    }

    public void unregisterReceiver(Context context, PluginBroadcastReceiver pluginBroadcastReceiver) {
        Iterator<Map.Entry<String, j>> it = this.cw.entrySet().iterator();
        while (it.hasNext()) {
            j value = it.next().getValue();
            if (value != null) {
                value.unregisterReceiver(pluginBroadcastReceiver);
            }
            BroadcastReceiver broadcastReceiver = this.f25473r.get(pluginBroadcastReceiver);
            if (broadcastReceiver != null) {
                try {
                    this.f25472j.remove(Integer.valueOf(broadcastReceiver.hashCode()));
                    this.f25473r.remove(pluginBroadcastReceiver);
                    context.unregisterReceiver(broadcastReceiver);
                } catch (Throwable th) {
                    ZeusLogger.w(ZeusLogger.TAG_RECEIVER, "unregisterReceiver-移除系统注册的广播发生异常:", th);
                }
            }
        }
    }

    private xt() {
    }

    public boolean j(int i6) {
        return this.f25472j.contains(Integer.valueOf(i6));
    }

    private void j(IntentFilter intentFilter, PluginBroadcastReceiver pluginBroadcastReceiver) {
        if (intentFilter == null || intentFilter.actionsIterator() == null) {
            return;
        }
        Iterator<String> actionsIterator = intentFilter.actionsIterator();
        while (actionsIterator.hasNext()) {
            String next = actionsIterator.next();
            if (next != null) {
                j jVar = this.cw.get(next);
                if (jVar != null) {
                    jVar.registerReceiver(pluginBroadcastReceiver);
                } else {
                    j jVar2 = new j();
                    jVar2.f25474j = next;
                    jVar2.registerReceiver(pluginBroadcastReceiver);
                    this.cw.put(next, jVar2);
                }
            }
        }
    }

    public Intent registerReceiver(Context context, PluginBroadcastReceiver pluginBroadcastReceiver, IntentFilter intentFilter, String str, Handler handler) {
        IntentFilter intentFilter2;
        Handler handler2;
        Intent registerReceiver;
        Intent registerReceiver2;
        if (intentFilter == null || intentFilter.actionsIterator() == null) {
            return null;
        }
        if (pluginBroadcastReceiver == null) {
            if (Build.VERSION.SDK_INT >= 34 && context.getApplicationInfo().targetSdkVersion >= 34) {
                registerReceiver2 = context.registerReceiver(null, intentFilter, 2);
                return registerReceiver2;
            }
            return context.registerReceiver(null, intentFilter);
        }
        BroadcastReceiverProxy broadcastReceiverProxy = new BroadcastReceiverProxy();
        if (Build.VERSION.SDK_INT >= 34 && context.getApplicationInfo().targetSdkVersion >= 34) {
            intentFilter2 = intentFilter;
            handler2 = handler;
            registerReceiver = context.registerReceiver(broadcastReceiverProxy, intentFilter2, str, handler2, 2);
        } else {
            intentFilter2 = intentFilter;
            handler2 = handler;
            registerReceiver = context.registerReceiver(broadcastReceiverProxy, intentFilter2, str, handler2);
        }
        this.f25473r.put(pluginBroadcastReceiver, broadcastReceiverProxy);
        if (handler2 != null) {
            this.f25472j.add(Integer.valueOf(broadcastReceiverProxy.hashCode()));
        }
        j(intentFilter2, pluginBroadcastReceiver);
        return registerReceiver;
    }

    public void j(Context context, Intent intent) {
        j value;
        if (intent == null || intent.getAction() == null) {
            return;
        }
        String action = intent.getAction();
        Map<String, j> map = this.cw;
        if (map == null || map.size() <= 0) {
            return;
        }
        for (Map.Entry<String, j> entry : this.cw.entrySet()) {
            if (action.equals(entry.getKey()) && (value = entry.getValue()) != null) {
                value.j(context, intent);
            }
        }
    }

    public Intent registerReceiver(Context context, PluginBroadcastReceiver pluginBroadcastReceiver, IntentFilter intentFilter, int i6) {
        int i7;
        Intent registerReceiver;
        Intent registerReceiver2;
        if (intentFilter == null || intentFilter.actionsIterator() == null || (i7 = Build.VERSION.SDK_INT) < 26) {
            return null;
        }
        if (pluginBroadcastReceiver == null) {
            if (i7 >= 34 && context.getApplicationInfo().targetSdkVersion >= 34) {
                registerReceiver2 = context.registerReceiver(null, intentFilter, 2);
                return registerReceiver2;
            }
            return context.registerReceiver(null, intentFilter);
        }
        BroadcastReceiverProxy broadcastReceiverProxy = new BroadcastReceiverProxy();
        registerReceiver = context.registerReceiver(broadcastReceiverProxy, intentFilter, i6);
        this.f25473r.put(pluginBroadcastReceiver, broadcastReceiverProxy);
        j(intentFilter, pluginBroadcastReceiver);
        return registerReceiver;
    }

    public Intent registerReceiver(Context context, PluginBroadcastReceiver pluginBroadcastReceiver, IntentFilter intentFilter, String str, Handler handler, int i6) {
        int i7;
        Intent registerReceiver;
        Intent registerReceiver2;
        if (intentFilter == null || intentFilter.actionsIterator() == null || (i7 = Build.VERSION.SDK_INT) < 26) {
            return null;
        }
        if (pluginBroadcastReceiver == null) {
            if (i7 >= 34 && context.getApplicationInfo().targetSdkVersion >= 34) {
                registerReceiver2 = context.registerReceiver(null, intentFilter, 2);
                return registerReceiver2;
            }
            return context.registerReceiver(null, intentFilter);
        }
        BroadcastReceiverProxy broadcastReceiverProxy = new BroadcastReceiverProxy();
        registerReceiver = context.registerReceiver(broadcastReceiverProxy, intentFilter, str, handler, i6);
        this.f25473r.put(pluginBroadcastReceiver, broadcastReceiverProxy);
        if (handler != null) {
            this.f25472j.add(Integer.valueOf(broadcastReceiverProxy.hashCode()));
        }
        j(intentFilter, pluginBroadcastReceiver);
        return registerReceiver;
    }
}
