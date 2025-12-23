package com.beizi.fusion.tool;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import androidx.annotation.NonNull;
import com.stub.StubApp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import java.util.Set;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class z {

    /* renamed from: f, reason: collision with root package name */
    private static final Object f13782f = new Object();

    /* renamed from: g, reason: collision with root package name */
    private static z f13783g;

    /* renamed from: a, reason: collision with root package name */
    private final Context f13784a;

    /* renamed from: b, reason: collision with root package name */
    private final HashMap<BroadcastReceiver, ArrayList<b>> f13785b = new HashMap<>();

    /* renamed from: c, reason: collision with root package name */
    private final HashMap<String, ArrayList<b>> f13786c = new HashMap<>();

    /* renamed from: d, reason: collision with root package name */
    private final ArrayList<a> f13787d = new ArrayList<>();

    /* renamed from: e, reason: collision with root package name */
    private final Handler f13788e;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class b {

        /* renamed from: a, reason: collision with root package name */
        final IntentFilter f13792a;

        /* renamed from: b, reason: collision with root package name */
        final BroadcastReceiver f13793b;

        /* renamed from: c, reason: collision with root package name */
        boolean f13794c;

        /* renamed from: d, reason: collision with root package name */
        boolean f13795d;

        public String toString() {
            StringBuilder sb = new StringBuilder(128);
            sb.append("Receiver{");
            sb.append(this.f13793b);
            sb.append(" filter=");
            sb.append(this.f13792a);
            if (this.f13795d) {
                sb.append(" DEAD");
            }
            sb.append("}");
            return sb.toString();
        }

        b(IntentFilter intentFilter, BroadcastReceiver broadcastReceiver) {
            this.f13792a = intentFilter;
            this.f13793b = broadcastReceiver;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class a {

        /* renamed from: a, reason: collision with root package name */
        final Intent f13790a;

        /* renamed from: b, reason: collision with root package name */
        final ArrayList<b> f13791b;

        a(Intent intent, ArrayList<b> arrayList) {
            this.f13790a = intent;
            this.f13791b = arrayList;
        }
    }

    @NonNull
    public static z a(@NonNull Context context) {
        z zVar;
        synchronized (f13782f) {
            try {
                if (f13783g == null) {
                    f13783g = new z(StubApp.getOrigApplicationContext(context.getApplicationContext()));
                }
                zVar = f13783g;
            } catch (Throwable th) {
                throw th;
            }
        }
        return zVar;
    }

    private z(Context context) {
        this.f13784a = context;
        this.f13788e = new Handler(context.getMainLooper()) { // from class: com.beizi.fusion.tool.z.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what != 1) {
                    super.handleMessage(message);
                } else {
                    z.this.a();
                }
            }
        };
    }

    public void a(@NonNull BroadcastReceiver broadcastReceiver, @NonNull IntentFilter intentFilter) {
        synchronized (this.f13785b) {
            try {
                try {
                    b bVar = new b(intentFilter, broadcastReceiver);
                    ArrayList<b> arrayList = this.f13785b.get(broadcastReceiver);
                    if (arrayList == null) {
                        arrayList = new ArrayList<>(1);
                        this.f13785b.put(broadcastReceiver, arrayList);
                    }
                    arrayList.add(bVar);
                    for (int i6 = 0; i6 < intentFilter.countActions(); i6++) {
                        String action = intentFilter.getAction(i6);
                        ArrayList<b> arrayList2 = this.f13786c.get(action);
                        if (arrayList2 == null) {
                            arrayList2 = new ArrayList<>(1);
                            this.f13786c.put(action, arrayList2);
                        }
                        arrayList2.add(bVar);
                    }
                } catch (Exception e6) {
                    e6.printStackTrace();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void a(@NonNull BroadcastReceiver broadcastReceiver) {
        ArrayList<b> remove;
        synchronized (this.f13785b) {
            try {
                remove = this.f13785b.remove(broadcastReceiver);
            } catch (Exception e6) {
                e6.printStackTrace();
            }
            if (remove == null) {
                return;
            }
            for (int size = remove.size() - 1; size >= 0; size--) {
                b bVar = remove.get(size);
                bVar.f13795d = true;
                for (int i6 = 0; i6 < bVar.f13792a.countActions(); i6++) {
                    String action = bVar.f13792a.getAction(i6);
                    ArrayList<b> arrayList = this.f13786c.get(action);
                    if (arrayList != null) {
                        for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
                            b bVar2 = arrayList.get(size2);
                            if (bVar2.f13793b == broadcastReceiver) {
                                bVar2.f13795d = true;
                                arrayList.remove(size2);
                            }
                        }
                        if (arrayList.size() <= 0) {
                            this.f13786c.remove(action);
                        }
                    }
                }
            }
        }
    }

    public boolean a(@NonNull Intent intent) {
        int match;
        synchronized (this.f13785b) {
            try {
                try {
                    String action = intent.getAction();
                    String resolveTypeIfNeeded = intent.resolveTypeIfNeeded(this.f13784a.getContentResolver());
                    Uri data = intent.getData();
                    String scheme = intent.getScheme();
                    Set<String> categories = intent.getCategories();
                    boolean z5 = (intent.getFlags() & 8) != 0;
                    if (z5) {
                        intent.toString();
                    }
                    ArrayList<b> arrayList = this.f13786c.get(intent.getAction());
                    if (arrayList != null) {
                        if (z5) {
                            arrayList.toString();
                        }
                        ArrayList arrayList2 = null;
                        for (int i6 = 0; i6 < arrayList.size(); i6++) {
                            b bVar = arrayList.get(i6);
                            if (z5) {
                                Objects.toString(bVar.f13792a);
                            }
                            if (!bVar.f13794c && (match = bVar.f13792a.match(action, resolveTypeIfNeeded, scheme, data, categories, "LocalBroadcastManager")) >= 0) {
                                if (z5) {
                                    Integer.toHexString(match);
                                }
                                if (arrayList2 == null) {
                                    arrayList2 = new ArrayList();
                                }
                                arrayList2.add(bVar);
                                bVar.f13794c = true;
                            }
                        }
                        if (arrayList2 != null) {
                            for (int i7 = 0; i7 < arrayList2.size(); i7++) {
                                ((b) arrayList2.get(i7)).f13794c = false;
                            }
                            this.f13787d.add(new a(intent, arrayList2));
                            if (!this.f13788e.hasMessages(1)) {
                                this.f13788e.sendEmptyMessage(1);
                            }
                            return true;
                        }
                    }
                } catch (Exception e6) {
                    e6.printStackTrace();
                }
                return false;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        int size;
        a[] aVarArr;
        while (true) {
            synchronized (this.f13785b) {
                try {
                    size = this.f13787d.size();
                    if (size <= 0) {
                        return;
                    }
                    aVarArr = new a[size];
                    this.f13787d.toArray(aVarArr);
                    this.f13787d.clear();
                } catch (Throwable th) {
                    throw th;
                }
            }
            for (int i6 = 0; i6 < size; i6++) {
                a aVar = aVarArr[i6];
                int size2 = aVar.f13791b.size();
                for (int i7 = 0; i7 < size2; i7++) {
                    b bVar = aVar.f13791b.get(i7);
                    if (!bVar.f13795d) {
                        bVar.f13793b.onReceive(this.f13784a, aVar.f13790a);
                    }
                }
            }
        }
    }
}
