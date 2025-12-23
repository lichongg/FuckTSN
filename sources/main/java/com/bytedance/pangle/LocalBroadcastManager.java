package com.bytedance.pangle;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import androidx.annotation.Keep;
import com.bytedance.pangle.receiver.PluginBroadcastReceiver;
import com.stub.StubApp;
import com.umeng.ccg.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

@Keep
/* loaded from: D:\Downloads\app\classes3.dex */
public final class LocalBroadcastManager {
    private static final boolean DEBUG = false;
    static final int MSG_EXEC_PENDING_BROADCASTS = 1;
    private static final String TAG = "LocalBroadcastManager";
    private static LocalBroadcastManager mInstance;
    private static final Object mLock = new Object();
    private final Context mAppContext;
    private final Handler mHandler;
    private final HashMap<PluginBroadcastReceiver, ArrayList<xt>> mReceivers = new HashMap<>();
    private final HashMap<String, ArrayList<xt>> mActions = new HashMap<>();
    private final ArrayList<j> mPendingBroadcasts = new ArrayList<>();

    private static final class xt {
        boolean cw;

        /* renamed from: j, reason: collision with root package name */
        final IntentFilter f25369j;

        /* renamed from: r, reason: collision with root package name */
        boolean f25370r;
        final PluginBroadcastReceiver xt;

        public String toString() {
            StringBuilder sb = new StringBuilder(128);
            sb.append("Receiver{");
            sb.append(this.xt);
            sb.append(" filter=");
            sb.append(this.f25369j);
            if (this.f25370r) {
                sb.append(" DEAD");
            }
            sb.append("}");
            return sb.toString();
        }

        xt(IntentFilter intentFilter, PluginBroadcastReceiver pluginBroadcastReceiver) {
            this.f25369j = intentFilter;
            this.xt = pluginBroadcastReceiver;
        }
    }

    private static final class j {

        /* renamed from: j, reason: collision with root package name */
        final Intent f25368j;
        final ArrayList<xt> xt;

        j(Intent intent, ArrayList<xt> arrayList) {
            this.f25368j = intent;
            this.xt = arrayList;
        }
    }

    public static LocalBroadcastManager getInstance(Context context) {
        LocalBroadcastManager localBroadcastManager;
        synchronized (mLock) {
            try {
                if (mInstance == null) {
                    mInstance = new LocalBroadcastManager(StubApp.getOrigApplicationContext(context.getApplicationContext()));
                }
                localBroadcastManager = mInstance;
            } catch (Throwable th) {
                throw th;
            }
        }
        return localBroadcastManager;
    }

    void executePendingBroadcasts() {
        int size;
        j[] jVarArr;
        while (true) {
            synchronized (this.mReceivers) {
                try {
                    size = this.mPendingBroadcasts.size();
                    if (size <= 0) {
                        return;
                    }
                    jVarArr = new j[size];
                    this.mPendingBroadcasts.toArray(jVarArr);
                    this.mPendingBroadcasts.clear();
                } catch (Throwable th) {
                    throw th;
                }
            }
            for (int i6 = 0; i6 < size; i6++) {
                j jVar = jVarArr[i6];
                int size2 = jVar.xt.size();
                for (int i7 = 0; i7 < size2; i7++) {
                    xt xtVar = jVar.xt.get(i7);
                    if (!xtVar.f25370r) {
                        xtVar.xt.onReceive(this.mAppContext, jVar.f25368j);
                    }
                }
            }
        }
    }

    public void registerReceiver(PluginBroadcastReceiver pluginBroadcastReceiver, IntentFilter intentFilter) {
        synchronized (this.mReceivers) {
            try {
                xt xtVar = new xt(intentFilter, pluginBroadcastReceiver);
                ArrayList<xt> arrayList = this.mReceivers.get(pluginBroadcastReceiver);
                if (arrayList == null) {
                    arrayList = new ArrayList<>(1);
                    this.mReceivers.put(pluginBroadcastReceiver, arrayList);
                }
                arrayList.add(xtVar);
                for (int i6 = 0; i6 < intentFilter.countActions(); i6++) {
                    String action = intentFilter.getAction(i6);
                    ArrayList<xt> arrayList2 = this.mActions.get(action);
                    if (arrayList2 == null) {
                        arrayList2 = new ArrayList<>(1);
                        this.mActions.put(action, arrayList2);
                    }
                    arrayList2.add(xtVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public boolean sendBroadcast(Intent intent) {
        String str;
        synchronized (this.mReceivers) {
            try {
                String action = intent.getAction();
                String resolveTypeIfNeeded = intent.resolveTypeIfNeeded(this.mAppContext.getContentResolver());
                Uri data = intent.getData();
                String scheme = intent.getScheme();
                Set<String> categories = intent.getCategories();
                boolean z5 = (intent.getFlags() & 8) != 0;
                if (z5) {
                    com.bytedance.sdk.openadsdk.api.m.j(TAG, "Resolving type " + resolveTypeIfNeeded + " scheme " + scheme + " of intent " + intent);
                }
                ArrayList<xt> arrayList = this.mActions.get(intent.getAction());
                if (arrayList != null) {
                    if (z5) {
                        com.bytedance.sdk.openadsdk.api.m.j(TAG, "Action list: ".concat(String.valueOf(arrayList)));
                    }
                    ArrayList arrayList2 = null;
                    int i6 = 0;
                    while (i6 < arrayList.size()) {
                        xt xtVar = arrayList.get(i6);
                        if (z5) {
                            com.bytedance.sdk.openadsdk.api.m.j(TAG, "Matching against filter " + xtVar.f25369j);
                        }
                        if (xtVar.cw) {
                            if (z5) {
                                com.bytedance.sdk.openadsdk.api.m.j(TAG, "  Filter's target already added");
                            }
                            str = action;
                        } else {
                            int match = xtVar.f25369j.match(action, resolveTypeIfNeeded, scheme, data, categories, TAG);
                            if (match >= 0) {
                                if (z5) {
                                    str = action;
                                    com.bytedance.sdk.openadsdk.api.m.j(TAG, "  Filter matched!  match=0x" + Integer.toHexString(match));
                                } else {
                                    str = action;
                                }
                                if (arrayList2 == null) {
                                    arrayList2 = new ArrayList();
                                }
                                arrayList2.add(xtVar);
                                xtVar.cw = true;
                            } else {
                                str = action;
                                if (z5) {
                                    com.bytedance.sdk.openadsdk.api.m.j(TAG, "  Filter did not match: ".concat(match != -4 ? match != -3 ? match != -2 ? match != -1 ? "unknown reason" : "type" : "data" : a.f41544t : "category"));
                                }
                            }
                        }
                        i6++;
                        action = str;
                    }
                    if (arrayList2 != null) {
                        for (int i7 = 0; i7 < arrayList2.size(); i7++) {
                            ((xt) arrayList2.get(i7)).cw = false;
                        }
                        this.mPendingBroadcasts.add(new j(intent, arrayList2));
                        if (!this.mHandler.hasMessages(1)) {
                            this.mHandler.sendEmptyMessage(1);
                        }
                        return true;
                    }
                }
                return false;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void unregisterReceiver(PluginBroadcastReceiver pluginBroadcastReceiver) {
        synchronized (this.mReceivers) {
            try {
                ArrayList<xt> remove = this.mReceivers.remove(pluginBroadcastReceiver);
                if (remove == null) {
                    return;
                }
                for (int size = remove.size() - 1; size >= 0; size--) {
                    xt xtVar = remove.get(size);
                    xtVar.f25370r = true;
                    for (int i6 = 0; i6 < xtVar.f25369j.countActions(); i6++) {
                        String action = xtVar.f25369j.getAction(i6);
                        ArrayList<xt> arrayList = this.mActions.get(action);
                        if (arrayList != null) {
                            for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
                                xt xtVar2 = arrayList.get(size2);
                                if (xtVar2.xt == pluginBroadcastReceiver) {
                                    xtVar2.f25370r = true;
                                    arrayList.remove(size2);
                                }
                            }
                            if (arrayList.size() <= 0) {
                                this.mActions.remove(action);
                            }
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private LocalBroadcastManager(Context context) {
        this.mAppContext = context;
        this.mHandler = new Handler(context.getMainLooper()) { // from class: com.bytedance.pangle.LocalBroadcastManager.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what != 1) {
                    super.handleMessage(message);
                } else {
                    LocalBroadcastManager.this.executePendingBroadcasts();
                }
            }
        };
    }

    public void sendBroadcastSync(Intent intent) {
        if (sendBroadcast(intent)) {
            executePendingBroadcasts();
        }
    }
}
