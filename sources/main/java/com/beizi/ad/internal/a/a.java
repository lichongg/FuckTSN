package com.beizi.ad.internal.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import com.beizi.ad.internal.h.i;
import com.beizi.ad.internal.h.m;
import com.beizi.ad.internal.h.o;
import com.beizi.ad.internal.h.t;
import com.beizi.ad.internal.k;
import com.beizi.ad.lance.a.c;
import com.beizi.ad.lance.a.h;
import com.beizi.ad.model.f;
import com.beizi.fusion.events.EventBean;
import com.beizi.fusion.events.EventCar;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static a f11426a;

    /* renamed from: c, reason: collision with root package name */
    private static Map<String, LinkedList<b>> f11427c = new HashMap();

    /* renamed from: d, reason: collision with root package name */
    private static Context f11428d;

    /* renamed from: b, reason: collision with root package name */
    private String f11429b = "KEY_AD_CACHE_CONTENT_";

    public void b() {
        h.g(f11428d);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.beizi.ad.internal.a.a$6, reason: invalid class name */
    static /* synthetic */ class AnonymousClass6 {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f11442a;

        static {
            int[] iArr = new int[k.values().length];
            f11442a = iArr;
            try {
                iArr[k.NEW_SPLASH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f11442a[k.NATIVE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f11442a[k.INTERSTITIAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f11442a[k.REWARDEDVIDEO.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public static synchronized a a() {
        a aVar;
        synchronized (a.class) {
            try {
                if (f11426a == null) {
                    synchronized (a.class) {
                        f11428d = com.beizi.ad.internal.h.a().e();
                        f11426a = new a();
                    }
                }
                aVar = f11426a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return aVar;
    }

    public b b(String str) {
        b pollLast;
        try {
            LinkedList<b> linkedList = f11427c.containsKey(str) ? f11427c.get(str) : null;
            if (linkedList == null || linkedList.isEmpty()) {
                List<b> a6 = a(str);
                if (a6 != null && !a6.isEmpty()) {
                    LinkedList<b> linkedList2 = new LinkedList<>(a6);
                    f11427c.put(str, linkedList2);
                    linkedList = linkedList2;
                }
                return null;
            }
            if (linkedList.isEmpty() || (pollLast = linkedList.pollLast()) == null) {
                return null;
            }
            if (pollLast.c() < System.currentTimeMillis()) {
                return null;
            }
            return pollLast;
        } catch (Exception e6) {
            e6.printStackTrace();
            return null;
        }
    }

    private void c(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        i.a((Context) null).a(str, false, new i.a() { // from class: com.beizi.ad.internal.a.a.4
            @Override // com.beizi.ad.internal.h.i.a
            public void a() {
            }

            @Override // com.beizi.ad.internal.h.i.a
            public void a(Bitmap bitmap) {
            }
        });
    }

    private void d(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        t.a().a(f11428d, str, false, new t.a() { // from class: com.beizi.ad.internal.a.a.5
            @Override // com.beizi.ad.internal.h.t.a
            public void a() {
            }

            @Override // com.beizi.ad.internal.h.t.a
            public void a(String str2) {
            }
        });
    }

    public List<b> a(String str) {
        try {
            String a6 = m.a(f11428d, this.f11429b + str);
            if (TextUtils.isEmpty(a6)) {
                return null;
            }
            String b6 = com.beizi.ad.lance.a.b.b(a6);
            if (TextUtils.isEmpty(b6)) {
                return null;
            }
            JSONArray jSONArray = new JSONArray(b6);
            if (jSONArray.length() < 1) {
                return null;
            }
            ArrayList arrayList = null;
            for (int i6 = 0; i6 < jSONArray.length(); i6++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i6);
                if (optJSONObject != null) {
                    long optLong = optJSONObject.has("expireTime") ? optJSONObject.optLong("expireTime") : 0L;
                    if (optLong >= System.currentTimeMillis()) {
                        b bVar = new b();
                        bVar.b(optLong);
                        if (optJSONObject.has("spaceId")) {
                            bVar.a(optJSONObject.optString("spaceId"));
                        }
                        if (optJSONObject.has("cacheTime")) {
                            bVar.a(optJSONObject.optLong("cacheTime"));
                        }
                        if (optJSONObject.has("requestId")) {
                            bVar.b(optJSONObject.optString("requestId"));
                        }
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.add(bVar);
                    }
                }
            }
            Collections.sort(arrayList, new Comparator<b>() { // from class: com.beizi.ad.internal.a.a.1
                @Override // java.util.Comparator
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public int compare(b bVar2, b bVar3) {
                    if (bVar2.b() > bVar3.b()) {
                        return 1;
                    }
                    return -1;
                }
            });
            return arrayList;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public synchronized void b(final EventBean eventBean, final int i6, final com.beizi.ad.model.b bVar, final k kVar) {
        try {
            if (i6 < 1) {
                return;
            }
            try {
                c.b().d().execute(new Runnable() { // from class: com.beizi.ad.internal.a.a.3
                    @Override // java.lang.Runnable
                    public void run() {
                        final String str;
                        for (int i7 = 0; i7 < i6; i7++) {
                            try {
                                String a6 = o.a();
                                EventBean eventBean2 = eventBean;
                                if (eventBean2 != null) {
                                    eventBean2.setReqId(a6);
                                    eventBean.setEventCode("255.300");
                                    a.this.a(eventBean);
                                }
                                final String a7 = o.a();
                                com.beizi.ad.model.b bVar2 = new com.beizi.ad.model.b();
                                bVar2.b(a7);
                                bVar2.a(true);
                                com.beizi.ad.model.b bVar3 = bVar;
                                if (bVar3 != null) {
                                    str = bVar3.a();
                                    bVar2.a(str);
                                    bVar2.a(bVar.d());
                                } else {
                                    str = null;
                                }
                                new com.beizi.ad.v2.e.b().a(bVar2, new com.beizi.ad.v2.e.a() { // from class: com.beizi.ad.internal.a.a.3.1
                                    @Override // com.beizi.ad.v2.e.a
                                    public void a(int i8) {
                                    }

                                    @Override // com.beizi.ad.v2.e.a
                                    public void a(String str2) {
                                        try {
                                            com.beizi.ad.internal.f.c cVar = new com.beizi.ad.internal.f.c(str2, null, kVar);
                                            AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                                            a.this.a(cVar, str2, a7, str, kVar);
                                            if (eventBean != null) {
                                                if (cVar.h()) {
                                                    EventBean m86clone = eventBean.m86clone();
                                                    m86clone.setEventCode("255.400");
                                                    a.this.a(m86clone);
                                                } else {
                                                    EventBean m86clone2 = eventBean.m86clone();
                                                    m86clone2.setEventCode("255.500");
                                                    m86clone2.setErrorCode("3");
                                                    a.this.a(m86clone2);
                                                }
                                            }
                                        } catch (Throwable th) {
                                            th.printStackTrace();
                                        }
                                    }
                                });
                            } catch (Exception e6) {
                                e6.printStackTrace();
                            }
                        }
                    }
                });
            } catch (Throwable th) {
                th = th;
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public synchronized void a(EventBean eventBean, int i6, com.beizi.ad.model.b bVar, k kVar) {
        List<b> a6;
        int size;
        if (i6 < 1 || bVar == null) {
            return;
        }
        try {
            String a7 = bVar.a();
            LinkedList<b> linkedList = f11427c.containsKey(a7) ? f11427c.get(a7) : null;
            if ((linkedList == null || linkedList.isEmpty()) && (a6 = a(a7)) != null && a6.size() > 0) {
                linkedList = new LinkedList<>(a6);
                f11427c.put(a7, linkedList);
            }
            size = (linkedList == null || linkedList.size() <= 0) ? 0 : linkedList.size();
        } catch (Exception e6) {
            e6.printStackTrace();
        } finally {
        }
        if (i6 >= 1 && size < i6) {
            b(eventBean, i6 - size, bVar, kVar);
        }
    }

    public void a(b bVar) {
        if (bVar == null) {
            return;
        }
        try {
            System.currentTimeMillis();
            h.b(f11428d, bVar.a(), bVar.d());
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    public void a(b bVar, int i6, int i7) {
        if (bVar == null) {
            return;
        }
        try {
            if (bVar.c() >= System.currentTimeMillis() && i6 == 1) {
                String a6 = bVar.a();
                LinkedList<b> linkedList = f11427c.containsKey(a6) ? f11427c.get(a6) : null;
                if (linkedList == null || linkedList.isEmpty()) {
                    linkedList = new LinkedList<>();
                }
                linkedList.add(bVar);
                Collections.sort(linkedList, new Comparator<b>() { // from class: com.beizi.ad.internal.a.a.2
                    @Override // java.util.Comparator
                    /* renamed from: a, reason: merged with bridge method [inline-methods] */
                    public int compare(b bVar2, b bVar3) {
                        if (bVar2.b() > bVar3.b()) {
                            return 1;
                        }
                        return -1;
                    }
                });
                if (linkedList.size() > i7) {
                    linkedList.removeFirst();
                }
                if (a(linkedList, a6)) {
                    f11427c.put(a6, linkedList);
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public com.beizi.ad.internal.f.c a(b bVar, k kVar) {
        if (bVar == null) {
            return null;
        }
        try {
            String a6 = bVar.a();
            String a7 = h.a(f11428d, a6, bVar.d());
            if (TextUtils.isEmpty(a7)) {
                return null;
            }
            com.beizi.ad.internal.f.c cVar = new com.beizi.ad.internal.f.c(a7, null, kVar);
            if (!cVar.h()) {
                return null;
            }
            LinkedList<b> linkedList = f11427c.containsKey(a6) ? f11427c.get(a6) : null;
            if (linkedList != null && !linkedList.isEmpty()) {
                a(linkedList, a6);
                return cVar;
            }
            m.c(f11428d, this.f11429b + a6);
            return cVar;
        } catch (Exception e6) {
            e6.printStackTrace();
            return null;
        }
    }

    public void a(com.beizi.ad.internal.f.c cVar, String str, String str2, String str3, k kVar) {
        int V;
        try {
            if (cVar.h() && (V = cVar.V()) > 0 && h.a(f11428d, str3, str2, str)) {
                b bVar = new b();
                long currentTimeMillis = System.currentTimeMillis();
                bVar.a(currentTimeMillis);
                bVar.b(currentTimeMillis + (V * 1000));
                bVar.b(str2);
                bVar.a(str3);
                LinkedList<b> linkedList = f11427c.containsKey(str3) ? f11427c.get(str3) : null;
                if (linkedList == null || linkedList.isEmpty()) {
                    linkedList = new LinkedList<>();
                }
                linkedList.add(bVar);
                a(linkedList, str3);
                f11427c.put(str3, linkedList);
                int i6 = AnonymousClass6.f11442a[kVar.ordinal()];
                if (i6 == 1) {
                    String S = cVar.S();
                    if (cVar.T() == f.EnumC0127f.RENDER_PIC) {
                        c(S);
                        return;
                    }
                    return;
                }
                if (i6 == 2) {
                    c(((com.beizi.ad.internal.e.a) cVar.a()).b());
                    return;
                }
                if (i6 != 3) {
                    if (i6 == 4 && cVar.N()) {
                        String M = cVar.M();
                        String X = cVar.X();
                        if (!TextUtils.isEmpty(M)) {
                            d(M);
                        }
                        if (TextUtils.isEmpty(X)) {
                            return;
                        }
                        c(X);
                        return;
                    }
                    return;
                }
                boolean N = cVar.N();
                String L = cVar.L();
                String M2 = cVar.M();
                if (N) {
                    d(M2);
                } else {
                    c(L);
                }
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    private boolean a(LinkedList<b> linkedList, String str) {
        if (linkedList != null) {
            try {
                if (!linkedList.isEmpty()) {
                    String a6 = com.beizi.ad.lance.a.b.a(linkedList.toString());
                    if (TextUtils.isEmpty(a6)) {
                        return false;
                    }
                    m.a(f11428d, this.f11429b + str, a6);
                    return true;
                }
            } catch (Exception e6) {
                e6.printStackTrace();
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(EventBean eventBean) {
        EventCar.getInstance(f11428d).goRoad(eventBean);
    }
}
