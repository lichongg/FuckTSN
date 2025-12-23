package com.kwad.sdk.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import com.stub.StubApp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import java.util.Set;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class ad {
    private static ad aZw;
    private static final Object mLock = new Object();
    private final Context aZs;
    private final HashMap<BroadcastReceiver, ArrayList<b>> aZt = new HashMap<>();
    private final HashMap<String, ArrayList<b>> aZu = new HashMap<>();
    private final ArrayList<a> aZv = new ArrayList<>();
    private final Handler iK;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class b {
        boolean aZA;
        boolean aZB;
        final BroadcastReceiver aZz;
        final IntentFilter filter;

        public final String toString() {
            StringBuilder sb = new StringBuilder(128);
            sb.append("Receiver{");
            sb.append(this.aZz);
            sb.append(" filter=");
            sb.append(this.filter);
            if (this.aZB) {
                sb.append(" DEAD");
            }
            sb.append("}");
            return sb.toString();
        }

        b(IntentFilter intentFilter, BroadcastReceiver broadcastReceiver) {
            this.filter = intentFilter;
            this.aZz = broadcastReceiver;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class a {
        final ArrayList<b> aZy;
        final Intent intent;

        a(Intent intent, ArrayList<b> arrayList) {
            this.intent = intent;
            this.aZy = arrayList;
        }
    }

    public static ad cO(Context context) {
        ad adVar;
        synchronized (mLock) {
            try {
                if (aZw == null) {
                    aZw = new ad(StubApp.getOrigApplicationContext(context.getApplicationContext()));
                }
                adVar = aZw;
            } catch (Throwable th) {
                throw th;
            }
        }
        return adVar;
    }

    final void Qd() {
        int size;
        a[] aVarArr;
        while (true) {
            synchronized (this.aZt) {
                try {
                    size = this.aZv.size();
                    if (size <= 0) {
                        return;
                    }
                    aVarArr = new a[size];
                    this.aZv.toArray(aVarArr);
                    this.aZv.clear();
                } catch (Throwable th) {
                    throw th;
                }
            }
            for (int i6 = 0; i6 < size; i6++) {
                a aVar = aVarArr[i6];
                int size2 = aVar.aZy.size();
                for (int i7 = 0; i7 < size2; i7++) {
                    b bVar = aVar.aZy.get(i7);
                    if (!bVar.aZB) {
                        bVar.aZz.onReceive(this.aZs, aVar.intent);
                    }
                }
            }
        }
    }

    public final void a(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        synchronized (this.aZt) {
            try {
                b bVar = new b(intentFilter, broadcastReceiver);
                ArrayList<b> arrayList = this.aZt.get(broadcastReceiver);
                if (arrayList == null) {
                    arrayList = new ArrayList<>(1);
                    this.aZt.put(broadcastReceiver, arrayList);
                }
                arrayList.add(bVar);
                for (int i6 = 0; i6 < intentFilter.countActions(); i6++) {
                    String action = intentFilter.getAction(i6);
                    ArrayList<b> arrayList2 = this.aZu.get(action);
                    if (arrayList2 == null) {
                        arrayList2 = new ArrayList<>(1);
                        this.aZu.put(action, arrayList2);
                    }
                    arrayList2.add(bVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean i(Intent intent) {
        int match;
        synchronized (this.aZt) {
            try {
                String action = intent.getAction();
                String resolveTypeIfNeeded = intent.resolveTypeIfNeeded(this.aZs.getContentResolver());
                Uri data = intent.getData();
                String scheme = intent.getScheme();
                Set<String> categories = intent.getCategories();
                boolean z5 = (intent.getFlags() & 8) != 0;
                if (z5) {
                    intent.toString();
                }
                ArrayList<b> arrayList = this.aZu.get(intent.getAction());
                if (arrayList != null) {
                    if (z5) {
                        arrayList.toString();
                    }
                    ArrayList arrayList2 = null;
                    for (int i6 = 0; i6 < arrayList.size(); i6++) {
                        b bVar = arrayList.get(i6);
                        if (z5) {
                            Objects.toString(bVar.filter);
                        }
                        if (!bVar.aZA && (match = bVar.filter.match(action, resolveTypeIfNeeded, scheme, data, categories, "LocalBroadcastManager")) >= 0) {
                            if (z5) {
                                Integer.toHexString(match);
                            }
                            if (arrayList2 == null) {
                                arrayList2 = new ArrayList();
                            }
                            arrayList2.add(bVar);
                            bVar.aZA = true;
                        }
                    }
                    if (arrayList2 != null) {
                        for (int i7 = 0; i7 < arrayList2.size(); i7++) {
                            ((b) arrayList2.get(i7)).aZA = false;
                        }
                        this.aZv.add(new a(intent, arrayList2));
                        if (!this.iK.hasMessages(1)) {
                            this.iK.sendEmptyMessage(1);
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

    public final void unregisterReceiver(BroadcastReceiver broadcastReceiver) {
        synchronized (this.aZt) {
            try {
                ArrayList<b> remove = this.aZt.remove(broadcastReceiver);
                if (remove == null) {
                    return;
                }
                for (int size = remove.size() - 1; size >= 0; size--) {
                    b bVar = remove.get(size);
                    bVar.aZB = true;
                    for (int i6 = 0; i6 < bVar.filter.countActions(); i6++) {
                        String action = bVar.filter.getAction(i6);
                        ArrayList<b> arrayList = this.aZu.get(action);
                        if (arrayList != null) {
                            for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
                                b bVar2 = arrayList.get(size2);
                                if (bVar2.aZz == broadcastReceiver) {
                                    bVar2.aZB = true;
                                    arrayList.remove(size2);
                                }
                            }
                            if (arrayList.size() <= 0) {
                                this.aZu.remove(action);
                            }
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private ad(Context context) {
        this.aZs = context;
        this.iK = new Handler(context.getMainLooper()) { // from class: com.kwad.sdk.utils.ad.1
            @Override // android.os.Handler
            public final void handleMessage(Message message) {
                if (message.what != 1) {
                    super.handleMessage(message);
                } else {
                    ad.this.Qd();
                }
            }
        };
    }
}
