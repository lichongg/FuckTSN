package com.beizi.fusion.tool;

import android.content.Context;
import com.beizi.fusion.model.EventItem;
import com.beizi.fusion.model.FreqItem;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class s {

    /* renamed from: a, reason: collision with root package name */
    private static HashMap<String, Object> f13766a = new HashMap<>();

    /* renamed from: b, reason: collision with root package name */
    private static HashMap<String, Object> f13767b = new HashMap<>();

    /* renamed from: c, reason: collision with root package name */
    private static Comparator<EventItem> f13768c = new Comparator<EventItem>() { // from class: com.beizi.fusion.tool.s.1
        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(EventItem eventItem, EventItem eventItem2) {
            return eventItem.getTimeStamp().compareTo(eventItem2.getTimeStamp());
        }
    };

    /* renamed from: d, reason: collision with root package name */
    private static HashMap<String, Long> f13769d = new HashMap<>();

    /* renamed from: e, reason: collision with root package name */
    private static HashMap<String, FreqItem> f13770e = new HashMap<>();

    /* renamed from: f, reason: collision with root package name */
    private static HashSet<String> f13771f = new HashSet<>();

    public static void a(Context context, String str) {
        try {
            ArrayList arrayList = (ArrayList) com.beizi.fusion.a.b.a(context).a(str);
            f13766a.put(str, a(arrayList));
            f13767b.put(str, b(arrayList));
            d("adUnitId = " + str + ",platFormMap get = " + f13766a.get(str) + ",channelMap get = " + f13767b.get(str));
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    public static void b(Context context, String str) {
        if (a(str)) {
            return;
        }
        c(context, str);
        int i6 = 0;
        while (!a(str) && i6 < 100) {
            d("currentWaitInitTime = " + i6);
            try {
                Thread.sleep(5L);
                i6 += 5;
            } catch (InterruptedException e6) {
                e6.printStackTrace();
            }
        }
    }

    private static void c(final Context context, final String str) {
        e.b().c().execute(new Runnable() { // from class: com.beizi.fusion.tool.s.2
            @Override // java.lang.Runnable
            public void run() {
                s.a(context, str);
            }
        });
    }

    public static FreqItem c(String str) {
        return f13770e.get(str);
    }

    public static void d(String str) {
        aa.b("FreqUtil", str);
    }

    public static int a(String str, String str2) {
        ArrayList arrayList;
        int i6 = 0;
        if (str2 == null) {
            return 0;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("enter getTodayEventTimes channelMap != null ?  ");
        sb.append(f13767b != null);
        sb.append(",eventCode = ");
        sb.append(str2);
        d(sb.toString());
        b(com.beizi.fusion.c.b.a().e(), str);
        String valueOf = String.valueOf(a());
        if ("200.000".equalsIgnoreCase(str2)) {
            HashMap<String, Object> hashMap = f13766a;
            if (hashMap != null && hashMap.get(str) != null) {
                d("getSpaceTodayEventTimes platFormMap.containsKey(adUnitId) = " + f13766a.containsKey(str));
                HashMap hashMap2 = (HashMap) f13766a.get(str);
                if (hashMap2 != null && (arrayList = (ArrayList) hashMap2.get(str2)) != null) {
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        if (((EventItem) it.next()).getTimeStamp().compareTo(valueOf) > 0) {
                            i6++;
                        }
                    }
                }
            }
        } else {
            HashMap<String, Object> hashMap3 = f13767b;
            if (hashMap3 != null && hashMap3.get(str) != null) {
                d("getSpaceTodayEventTimes channelMap.containsKey(adUnitId) = " + f13767b.containsKey(str));
                HashMap hashMap4 = (HashMap) f13767b.get(str);
                Iterator<String> it2 = f13771f.iterator();
                while (it2.hasNext()) {
                    String next = it2.next();
                    if (hashMap4 != null && hashMap4.get(next) != null) {
                        HashMap hashMap5 = (HashMap) hashMap4.get(next);
                        d("getSpaceTodayEventTimes eventMap = " + hashMap5);
                        if (hashMap5 != null && hashMap5.get(str2) != null) {
                            ArrayList arrayList2 = (ArrayList) hashMap5.get(str2);
                            d("getSpaceTodayEventTimes itemList = " + arrayList2 + ",eventCode = " + str2);
                            if (arrayList2 != null && arrayList2.size() > 0) {
                                aa.c("BeiZis", arrayList2.toString());
                                Iterator it3 = arrayList2.iterator();
                                while (it3.hasNext()) {
                                    if (((EventItem) it3.next()).getTimeStamp().compareTo(valueOf) > 0) {
                                        i6++;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        aa.c("BeiZis", "todayEventTimes = " + i6);
        return i6;
    }

    public static long b(String str) {
        Long l6 = f13769d.get(str);
        if (l6 == null) {
            return 0L;
        }
        return l6.longValue();
    }

    private static Map<String, Map<String, List<EventItem>>> b(List<EventItem> list) {
        ArrayList arrayList;
        ArrayList arrayList2;
        if (list != null && list.size() != 0) {
            HashMap hashMap = new HashMap();
            HashMap hashMap2 = new HashMap();
            for (EventItem eventItem : list) {
                String spaceId = eventItem.getSpaceId();
                if (spaceId != null) {
                    if (!hashMap.containsKey(spaceId)) {
                        arrayList2 = new ArrayList();
                        arrayList2.add(eventItem);
                    } else {
                        arrayList2 = (ArrayList) hashMap.get(spaceId);
                        if (arrayList2 != null) {
                            arrayList2.add(eventItem);
                        }
                    }
                    hashMap.put(spaceId, arrayList2);
                }
                String channel = eventItem.getChannel();
                f13771f.add(channel);
                if (channel != null) {
                    if (!hashMap2.containsKey(channel)) {
                        arrayList = new ArrayList();
                        arrayList.add(eventItem);
                    } else {
                        arrayList = (ArrayList) hashMap2.get(channel);
                        if (arrayList != null) {
                            arrayList.add(eventItem);
                        }
                    }
                    hashMap2.put(channel, arrayList);
                }
            }
            HashMap hashMap3 = new HashMap();
            for (String str : hashMap.keySet()) {
                ArrayList arrayList3 = (ArrayList) hashMap.get(str);
                if (arrayList3 != null) {
                    hashMap3.put(str, (HashMap) a(arrayList3));
                }
            }
            for (String str2 : hashMap2.keySet()) {
                ArrayList arrayList4 = (ArrayList) hashMap2.get(str2);
                if (arrayList4 != null) {
                    hashMap3.put(str2, (HashMap) a(arrayList4));
                }
            }
            return hashMap3;
        }
        return new HashMap();
    }

    public static long a() {
        Calendar calendar = Calendar.getInstance(Locale.CHINA);
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        return calendar.getTimeInMillis();
    }

    public static boolean a(String str) {
        return f13766a.containsKey(str) && f13767b.containsKey(str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:70:0x0148, code lost:
    
        return true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean a(java.util.List<com.beizi.fusion.model.FreqItem> r18, java.lang.String r19, java.lang.String r20, java.lang.String r21) {
        /*
            Method dump skipped, instructions count: 511
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.beizi.fusion.tool.s.a(java.util.List, java.lang.String, java.lang.String, java.lang.String):boolean");
    }

    private static void a(String str, List<FreqItem> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        long b6 = b(str);
        Iterator<FreqItem> it = list.iterator();
        while (it.hasNext()) {
            b6 = Math.max(it.next().getInterval(), b6);
        }
        d("maxInterval = " + b6);
        f13769d.put(str, Long.valueOf(b6));
    }

    private static Map<String, List<EventItem>> a(List<EventItem> list) {
        ArrayList arrayList;
        if (list != null && list.size() != 0) {
            HashMap hashMap = new HashMap();
            String str = null;
            ArrayList arrayList2 = null;
            for (EventItem eventItem : list) {
                String code = eventItem.getCode();
                if (!code.equals(str)) {
                    if (str != null && arrayList2 != null) {
                        hashMap.put(str, arrayList2);
                    }
                    if (!hashMap.containsKey(code)) {
                        arrayList = new ArrayList();
                        arrayList.add(eventItem);
                    } else {
                        arrayList = (ArrayList) hashMap.get(code);
                        if (arrayList != null) {
                            arrayList.add(eventItem);
                        }
                    }
                    hashMap.put(code, arrayList);
                    arrayList2 = arrayList;
                } else if (arrayList2 != null) {
                    arrayList2.add(eventItem);
                }
                str = code;
            }
            for (String str2 : hashMap.keySet()) {
                ArrayList arrayList3 = (ArrayList) hashMap.get(str2);
                Collections.sort(arrayList3, f13768c);
                hashMap.put(str2, arrayList3);
            }
            return hashMap;
        }
        return new HashMap();
    }

    public static void a(String str, EventItem eventItem) {
        try {
            HashMap hashMap = (HashMap) f13766a.get(str);
            if (hashMap == null) {
                hashMap = new HashMap();
            }
            String code = eventItem.getCode();
            a(eventItem, hashMap, code);
            String spaceId = eventItem.getSpaceId();
            if (spaceId != null) {
                HashMap hashMap2 = (HashMap) f13767b.get(str);
                if (hashMap2 == null) {
                    hashMap2 = new HashMap();
                }
                HashMap hashMap3 = (HashMap) hashMap2.get(spaceId);
                if (hashMap3 == null) {
                    hashMap3 = new HashMap();
                }
                a(eventItem, hashMap3, code);
                hashMap2.put(spaceId, hashMap3);
            }
            String channel = eventItem.getChannel();
            f13771f.add(channel);
            if (channel != null) {
                HashMap hashMap4 = (HashMap) f13767b.get(str);
                if (hashMap4 == null) {
                    hashMap4 = new HashMap();
                }
                HashMap hashMap5 = (HashMap) hashMap4.get(channel);
                if (hashMap5 == null) {
                    hashMap5 = new HashMap();
                }
                a(eventItem, hashMap5, code);
                hashMap4.put(channel, hashMap5);
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    private static void a(EventItem eventItem, HashMap<String, List<EventItem>> hashMap, String str) {
        if (hashMap != null) {
            if (!hashMap.containsKey(str)) {
                if (str != null) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(eventItem);
                    hashMap.put(str, arrayList);
                    return;
                }
                return;
            }
            ArrayList arrayList2 = (ArrayList) hashMap.get(str);
            if (arrayList2 != null) {
                arrayList2.add(eventItem);
                Collections.sort(arrayList2, f13768c);
                hashMap.put(str, arrayList2);
            }
        }
    }
}
