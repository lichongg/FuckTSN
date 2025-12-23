package com.huawei.agconnect;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.stub.StubApp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/* loaded from: D:\Downloads\app\classes5.dex */
public class j {

    /* renamed from: f, reason: collision with root package name */
    private static final Object f33005f = new Object();

    /* renamed from: g, reason: collision with root package name */
    private static final int f33006g = 1;

    /* renamed from: h, reason: collision with root package name */
    private static j f33007h;

    /* renamed from: a, reason: collision with root package name */
    private final Context f33008a;

    /* renamed from: b, reason: collision with root package name */
    private final HashMap<BroadcastReceiver, ArrayList<IntentFilter>> f33009b = new HashMap<>();

    /* renamed from: c, reason: collision with root package name */
    private final HashMap<String, ArrayList<c>> f33010c = new HashMap<>();

    /* renamed from: d, reason: collision with root package name */
    private final ArrayList<b> f33011d = new ArrayList<>();

    /* renamed from: e, reason: collision with root package name */
    private final Handler f33012e;

    class a extends Handler {
        a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 1) {
                j.this.b();
            } else {
                super.handleMessage(message);
            }
        }
    }

    private static class c {

        /* renamed from: a, reason: collision with root package name */
        final IntentFilter f33016a;

        /* renamed from: b, reason: collision with root package name */
        final BroadcastReceiver f33017b;

        /* renamed from: c, reason: collision with root package name */
        boolean f33018c;

        public String toString() {
            return "Receiver{" + this.f33017b + " filter=" + this.f33016a + "}";
        }

        c(IntentFilter intentFilter, BroadcastReceiver broadcastReceiver) {
            this.f33016a = intentFilter;
            this.f33017b = broadcastReceiver;
        }
    }

    private static class b {

        /* renamed from: a, reason: collision with root package name */
        final Intent f33014a;

        /* renamed from: b, reason: collision with root package name */
        final ArrayList<c> f33015b;

        b(Intent intent, ArrayList<c> arrayList) {
            this.f33014a = intent;
            this.f33015b = arrayList;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        int size;
        b[] bVarArr;
        while (true) {
            synchronized (this.f33009b) {
                try {
                    size = this.f33011d.size();
                    if (size <= 0) {
                        return;
                    }
                    bVarArr = new b[size];
                    this.f33011d.toArray(bVarArr);
                    this.f33011d.clear();
                } catch (Throwable th) {
                    throw th;
                }
            }
            for (int i6 = 0; i6 < size; i6++) {
                b bVar = bVarArr[i6];
                for (int i7 = 0; i7 < bVar.f33015b.size(); i7++) {
                    bVar.f33015b.get(i7).f33017b.onReceive(this.f33008a, bVar.f33014a);
                }
            }
        }
    }

    public static j c(Context context) {
        j jVar;
        synchronized (f33005f) {
            try {
                if (f33007h == null) {
                    f33007h = new j(StubApp.getOrigApplicationContext(context.getApplicationContext()));
                }
                jVar = f33007h;
            } catch (Throwable th) {
                throw th;
            }
        }
        return jVar;
    }

    public boolean d(Intent intent) {
        synchronized (this.f33009b) {
            try {
                String action = intent.getAction();
                String resolveTypeIfNeeded = intent.resolveTypeIfNeeded(this.f33008a.getContentResolver());
                Uri data = intent.getData();
                String scheme = intent.getScheme();
                Set<String> categories = intent.getCategories();
                ArrayList<c> arrayList = this.f33010c.get(intent.getAction());
                if (arrayList != null) {
                    ArrayList arrayList2 = null;
                    for (int i6 = 0; i6 < arrayList.size(); i6++) {
                        c cVar = arrayList.get(i6);
                        if (!cVar.f33018c && cVar.f33016a.match(action, resolveTypeIfNeeded, scheme, data, categories, "LocalBroadcastManager") >= 0) {
                            if (arrayList2 == null) {
                                arrayList2 = new ArrayList();
                            }
                            arrayList2.add(cVar);
                            cVar.f33018c = true;
                        }
                    }
                    if (arrayList2 != null) {
                        for (int i7 = 0; i7 < arrayList2.size(); i7++) {
                            ((c) arrayList2.get(i7)).f33018c = false;
                        }
                        this.f33011d.add(new b(intent, arrayList2));
                        if (!this.f33012e.hasMessages(1)) {
                            this.f33012e.sendEmptyMessage(1);
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

    public void registerReceiver(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        synchronized (this.f33009b) {
            try {
                c cVar = new c(intentFilter, broadcastReceiver);
                ArrayList<IntentFilter> arrayList = this.f33009b.get(broadcastReceiver);
                if (arrayList == null) {
                    arrayList = new ArrayList<>(1);
                    this.f33009b.put(broadcastReceiver, arrayList);
                }
                arrayList.add(intentFilter);
                for (int i6 = 0; i6 < intentFilter.countActions(); i6++) {
                    String action = intentFilter.getAction(i6);
                    ArrayList<c> arrayList2 = this.f33010c.get(action);
                    if (arrayList2 == null) {
                        arrayList2 = new ArrayList<>(1);
                        this.f33010c.put(action, arrayList2);
                    }
                    arrayList2.add(cVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void unregisterReceiver(BroadcastReceiver broadcastReceiver) {
        synchronized (this.f33009b) {
            try {
                ArrayList<IntentFilter> remove = this.f33009b.remove(broadcastReceiver);
                if (remove != null) {
                    for (int i6 = 0; i6 < remove.size(); i6++) {
                        IntentFilter intentFilter = remove.get(i6);
                        for (int i7 = 0; i7 < intentFilter.countActions(); i7++) {
                            String action = intentFilter.getAction(i7);
                            ArrayList<c> arrayList = this.f33010c.get(action);
                            if (arrayList != null) {
                                int i8 = 0;
                                while (i8 < arrayList.size()) {
                                    if (arrayList.get(i8).f33017b == broadcastReceiver) {
                                        arrayList.remove(i8);
                                        i8--;
                                    }
                                    i8++;
                                }
                                if (arrayList.size() <= 0) {
                                    this.f33010c.remove(action);
                                }
                            }
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private j(Context context) {
        this.f33008a = context;
        this.f33012e = new a(context.getMainLooper());
    }
}
