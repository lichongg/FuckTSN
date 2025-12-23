package com.autonavi.aps.amapapi.restruct;

import android.content.Context;
import android.location.Location;
import android.os.Handler;
import android.text.TextUtils;
import com.amap.api.col.p0003l.j4;
import com.amap.api.col.p0003l.l9;
import com.amap.api.col.p0003l.o9;
import com.amap.api.services.geocoder.GeocodeSearch;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class g {

    /* renamed from: b, reason: collision with root package name */
    private File f10083b;

    /* renamed from: d, reason: collision with root package name */
    private Handler f10085d;

    /* renamed from: e, reason: collision with root package name */
    private String f10086e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f10087f;

    /* renamed from: a, reason: collision with root package name */
    private LinkedList<f> f10082a = new LinkedList<>();

    /* renamed from: c, reason: collision with root package name */
    private boolean f10084c = false;

    /* renamed from: g, reason: collision with root package name */
    private Runnable f10088g = new Runnable() { // from class: com.autonavi.aps.amapapi.restruct.g.1
        @Override // java.lang.Runnable
        public final void run() {
            if (g.this.f10084c) {
                return;
            }
            if (g.this.f10087f) {
                g.this.b();
                g.d(g.this);
            }
            if (g.this.f10085d != null) {
                g.this.f10085d.postDelayed(g.this.f10088g, 60000L);
            }
        }
    };

    static /* synthetic */ boolean d(g gVar) {
        gVar.f10087f = false;
        return false;
    }

    public final void a(boolean z5) {
        if (!z5) {
            this.f10088g.run();
        }
        Handler handler = this.f10085d;
        if (handler != null) {
            handler.removeCallbacks(this.f10088g);
        }
        this.f10084c = true;
    }

    public final void b(f fVar) {
        if (this.f10082a.size() > 0) {
            int i6 = fVar.f10074a;
            if (i6 != 6 && i6 != 5) {
                if (this.f10082a.contains(fVar)) {
                    return;
                }
                if (this.f10082a.size() >= 10) {
                    this.f10082a.removeFirst();
                }
                this.f10082a.add(fVar);
                this.f10087f = true;
                return;
            }
            f last = this.f10082a.getLast();
            if (last.f10076c == fVar.f10076c && last.f10075b == fVar.f10075b && last.f10078e == fVar.f10078e) {
                return;
            }
            if (this.f10082a.size() >= 10) {
                this.f10082a.removeFirst();
            }
            this.f10082a.add(fVar);
            this.f10087f = true;
        }
    }

    public g(Context context, Handler handler) {
        this.f10086e = null;
        this.f10085d = handler;
        String path = context.getFilesDir().getPath();
        if (this.f10086e == null) {
            this.f10086e = com.autonavi.aps.amapapi.utils.j.l(context);
        }
        try {
            this.f10083b = new File(path, "hisloc");
        } catch (Throwable th) {
            o9.a(th);
        }
        a();
        Handler handler2 = this.f10085d;
        if (handler2 != null) {
            handler2.removeCallbacks(this.f10088g);
            this.f10085d.postDelayed(this.f10088g, 60000L);
        }
    }

    public final void a(f fVar) {
        Iterator<f> it = this.f10082a.iterator();
        f fVar2 = null;
        f fVar3 = null;
        int i6 = 0;
        while (it.hasNext()) {
            f next = it.next();
            if (next.f10074a == 1) {
                if (fVar3 == null) {
                    fVar3 = next;
                }
                i6++;
                fVar2 = next;
            }
        }
        if (fVar2 != null) {
            new Location(GeocodeSearch.GPS);
            if (fVar.f10077d - fVar2.f10077d < 20000 && com.autonavi.aps.amapapi.utils.j.a(new double[]{fVar.f10075b, fVar.f10076c, fVar2.f10075b, fVar2.f10076c}) < 20.0f) {
                return;
            }
        }
        if (i6 >= 5) {
            this.f10082a.remove(fVar3);
        }
        if (this.f10082a.size() >= 10) {
            this.f10082a.removeFirst();
        }
        this.f10082a.add(fVar);
        this.f10087f = true;
    }

    private static boolean b(ArrayList<d> arrayList, ArrayList<l9> arrayList2) {
        return arrayList == null || arrayList.size() <= 0 || arrayList2 == null || arrayList2.size() <= 0 || (((long) arrayList.size()) < 4 && ((long) arrayList2.size()) < 20);
    }

    public final List<f> a(ArrayList<d> arrayList, ArrayList<l9> arrayList2) {
        if (!b(arrayList, arrayList2)) {
            return null;
        }
        long currentTimeMillis = System.currentTimeMillis();
        ArrayList arrayList3 = new ArrayList();
        Iterator<f> it = this.f10082a.iterator();
        int i6 = 0;
        while (it.hasNext()) {
            f next = it.next();
            if (currentTimeMillis - next.f10077d < 21600000000L) {
                arrayList3.add(next);
                i6++;
            }
            if (i6 == 10) {
                break;
            }
        }
        return arrayList3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        StringBuilder sb = new StringBuilder();
        Iterator<f> it = this.f10082a.iterator();
        while (it.hasNext()) {
            try {
                sb.append(j4.f(com.autonavi.aps.amapapi.security.a.a(it.next().a().getBytes("UTF-8"), this.f10086e)) + com.snail.antifake.deviceid.e.f37542d);
            } catch (UnsupportedEncodingException e6) {
                e6.printStackTrace();
            }
        }
        String sb2 = sb.toString();
        if (TextUtils.isEmpty(sb2)) {
            return;
        }
        com.autonavi.aps.amapapi.utils.j.a(this.f10083b, sb2);
    }

    private void a() {
        LinkedList<f> linkedList = this.f10082a;
        if (linkedList == null || linkedList.size() <= 0) {
            Iterator<String> it = com.autonavi.aps.amapapi.utils.j.a(this.f10083b).iterator();
            while (it.hasNext()) {
                try {
                    String str = new String(com.autonavi.aps.amapapi.security.a.b(j4.g(it.next()), this.f10086e), "UTF-8");
                    f fVar = new f();
                    fVar.a(new JSONObject(str));
                    this.f10082a.add(fVar);
                } catch (UnsupportedEncodingException e6) {
                    e6.printStackTrace();
                } catch (JSONException e7) {
                    e7.printStackTrace();
                }
            }
        }
    }
}
