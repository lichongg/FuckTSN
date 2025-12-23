package cn.jpush.android.p;

import android.content.Context;
import cn.jpush.android.ad.c;
import cn.jpush.android.d.d;
import cn.jpush.android.helper.Logger;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;

/* loaded from: D:\Downloads\app\classes2.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static List<d> f3754a = new LinkedList();

    /* renamed from: b, reason: collision with root package name */
    private static List<d> f3755b = new LinkedList();

    /* renamed from: c, reason: collision with root package name */
    private static int f3756c = 10;

    /* renamed from: d, reason: collision with root package name */
    private Context f3757d;

    /* renamed from: e, reason: collision with root package name */
    private List<Integer> f3758e;

    /* renamed from: f, reason: collision with root package name */
    private AtomicBoolean f3759f;

    private static final class a {

        /* renamed from: a, reason: collision with root package name */
        private static final b f3762a = new b();
    }

    private b() {
        this.f3758e = new ArrayList();
        this.f3759f = new AtomicBoolean(false);
    }

    private static String c(int i6) {
        return a(i6) ? "notify_inapp_data" : "inapp_data";
    }

    public d a(String str) {
        Logger.d("InAppCacheMgr", "deleteMessage msgID=" + str);
        for (d dVar : f3754a) {
            if (dVar.f3588d.equals(str)) {
                return dVar;
            }
        }
        for (d dVar2 : f3755b) {
            if (dVar2.f3588d.equals(str)) {
                return dVar2;
            }
        }
        return null;
    }

    public synchronized int b() {
        return f3754a.size() + f3755b.size();
    }

    public static b a() {
        return a.f3762a;
    }

    private void d(String str) {
        File a6 = c.a(this.f3757d, str);
        if (a6 == null) {
            Logger.w("InAppCacheMgr", "can't get files dir");
        } else if (a6.exists()) {
            a6.delete();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x0056, code lost:
    
        r3 = r3.toString();
     */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0100  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public cn.jpush.android.d.d b(java.lang.String r9) {
        /*
            Method dump skipped, instructions count: 300
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.p.b.b(java.lang.String):cn.jpush.android.d.d");
    }

    public void c() {
        this.f3758e.clear();
    }

    private static List<d> b(int i6) {
        return a(i6) ? f3754a : f3755b;
    }

    private void c(String str, List<d> list) {
        Logger.v("InAppCacheMgr", "Action - saveObjects");
        if (list == null || list.size() < 0) {
            Logger.w("InAppCacheMgr", "mObjectList is null or size is 0");
            return;
        }
        if (list.size() == 0) {
            d(str);
            return;
        }
        try {
            File a6 = c.a(this.f3757d, str);
            if (a6 == null) {
                Logger.w("InAppCacheMgr", "file is null");
                return;
            }
            new JSONArray();
            ArrayList arrayList = new ArrayList();
            int size = list.size() - 1;
            while (true) {
                if (size < 0) {
                    break;
                }
                d dVar = list.get(size);
                if (dVar != null) {
                    if (dVar.bP <= System.currentTimeMillis()) {
                        list.remove(dVar);
                        Logger.dd("InAppCacheMgr", "saveObjects message out of date, endTime: " + dVar.f3588d);
                        a(dVar, false);
                    } else {
                        arrayList.add(0, dVar.c());
                        if (arrayList.size() == f3756c) {
                            Logger.d("InAppCacheMgr", "[saveObjects] reach max cache message count: " + f3756c + ", drop message count: " + (list.size() - f3756c));
                            break;
                        }
                    }
                }
                size--;
            }
            c.a(a6.getAbsolutePath(), new JSONArray((Collection) arrayList).toString());
        } catch (Throwable th) {
            Logger.ww("InAppCacheMgr", "save Objects  error:" + th.getMessage());
        }
    }

    public void a(Context context) {
        this.f3757d = context;
        a(f3754a, "notify_inapp_data", true);
        a(f3755b, "inapp_data", true);
    }

    private void c(List<d> list) {
        if (list == null || list.size() <= 1) {
            return;
        }
        Collections.sort(list, new Comparator<d>() { // from class: cn.jpush.android.p.b.2
            @Override // java.util.Comparator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public int compare(d dVar, d dVar2) {
                int i6 = dVar.bu - dVar2.bu;
                return i6 != 0 ? i6 > 0 ? -1 : 1 : dVar.bO - dVar2.bO > 0 ? -1 : 1;
            }
        });
    }

    public void a(d dVar) {
        if (dVar == null) {
            return;
        }
        int i6 = dVar.bt;
        int i7 = dVar.ay;
        if (i7 <= 0) {
            i7 = 10;
        }
        f3756c = i7;
        a(b(i6), dVar, c(i6));
    }

    public void b(d dVar) {
        try {
            if (this.f3758e == null) {
                this.f3758e = new ArrayList();
            }
            this.f3758e.add(Integer.valueOf(dVar.bu));
        } catch (Throwable unused) {
        }
    }

    private void a(d dVar, boolean z5) {
        if (z5) {
            cn.jpush.android.helper.c.a(this.f3757d, dVar.f3588d, 2007L, 4);
        } else if (40 == dVar.bt) {
            cn.jpush.android.helper.c.a(dVar.f3588d, 1603L, this.f3757d);
        } else {
            cn.jpush.android.helper.c.a(this.f3757d, dVar.f3588d, 2002L, 4);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0071, code lost:
    
        cn.jpush.android.helper.Logger.d("InAppCacheMgr", "[loadObjects] reach max cache message count: " + cn.jpush.android.p.b.f3756c + ", drop message count: " + (r3.length() - cn.jpush.android.p.b.f3756c));
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00cd, code lost:
    
        cn.jpush.android.helper.Logger.i("InAppCacheMgr", "load object size: " + r14.size());
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00e5, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00ca, code lost:
    
        if (r12.f3759f.get() == false) goto L27;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void b(java.lang.String r13, java.util.List<cn.jpush.android.d.d> r14) {
        /*
            r12 = this;
            java.lang.String r0 = "InAppCacheMgr"
            r1 = 0
            android.content.Context r2 = r12.f3757d     // Catch: java.lang.Throwable -> L64
            java.io.File r2 = cn.jpush.android.ad.c.a(r2, r13)     // Catch: java.lang.Throwable -> L64
            if (r2 == 0) goto L9a
            boolean r3 = r2.exists()     // Catch: java.lang.Throwable -> L64
            if (r3 == 0) goto L9a
            java.lang.String r2 = cn.jpush.android.ad.c.c(r2)     // Catch: java.lang.Throwable -> L64
            boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch: java.lang.Throwable -> L64
            if (r3 != 0) goto L9a
            org.json.JSONArray r3 = new org.json.JSONArray     // Catch: java.lang.Throwable -> L64
            r3.<init>(r2)     // Catch: java.lang.Throwable -> L64
            java.util.concurrent.atomic.AtomicBoolean r2 = r12.f3759f     // Catch: java.lang.Throwable -> L64
            r4 = 0
            r2.set(r4)     // Catch: java.lang.Throwable -> L64
            int r2 = r3.length()     // Catch: java.lang.Throwable -> L64
            r5 = 1
            int r2 = r2 - r5
        L2c:
            if (r2 < 0) goto L9a
            java.lang.Object r6 = r3.get(r2)     // Catch: java.lang.Throwable -> L64
            java.lang.String r6 = r6.toString()     // Catch: java.lang.Throwable -> L64
            cn.jpush.android.d.d r6 = cn.jpush.android.d.d.b(r6)     // Catch: java.lang.Throwable -> L64
            if (r6 != 0) goto L3d
            goto L97
        L3d:
            long r7 = r6.bP     // Catch: java.lang.Throwable -> L64
            long r9 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L64
            int r11 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r11 > 0) goto L66
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L64
            r9.<init>()     // Catch: java.lang.Throwable -> L64
            java.lang.String r10 = "loadObjects message out of date, endTime: "
            r9.append(r10)     // Catch: java.lang.Throwable -> L64
            r9.append(r7)     // Catch: java.lang.Throwable -> L64
            java.lang.String r7 = r9.toString()     // Catch: java.lang.Throwable -> L64
            cn.jpush.android.helper.Logger.dd(r0, r7)     // Catch: java.lang.Throwable -> L64
            java.util.concurrent.atomic.AtomicBoolean r7 = r12.f3759f     // Catch: java.lang.Throwable -> L64
            r7.set(r5)     // Catch: java.lang.Throwable -> L64
            r12.a(r6, r4)     // Catch: java.lang.Throwable -> L64
            goto L97
        L64:
            r2 = move-exception
            goto La9
        L66:
            r14.add(r6)     // Catch: java.lang.Throwable -> L64
            int r6 = r14.size()     // Catch: java.lang.Throwable -> L64
            int r7 = cn.jpush.android.p.b.f3756c     // Catch: java.lang.Throwable -> L64
            if (r6 != r7) goto L97
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L64
            r2.<init>()     // Catch: java.lang.Throwable -> L64
            java.lang.String r4 = "[loadObjects] reach max cache message count: "
            r2.append(r4)     // Catch: java.lang.Throwable -> L64
            int r4 = cn.jpush.android.p.b.f3756c     // Catch: java.lang.Throwable -> L64
            r2.append(r4)     // Catch: java.lang.Throwable -> L64
            java.lang.String r4 = ", drop message count: "
            r2.append(r4)     // Catch: java.lang.Throwable -> L64
            int r3 = r3.length()     // Catch: java.lang.Throwable -> L64
            int r4 = cn.jpush.android.p.b.f3756c     // Catch: java.lang.Throwable -> L64
            int r3 = r3 - r4
            r2.append(r3)     // Catch: java.lang.Throwable -> L64
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> L64
            cn.jpush.android.helper.Logger.d(r0, r2)     // Catch: java.lang.Throwable -> L64
            goto L9a
        L97:
            int r2 = r2 + (-1)
            goto L2c
        L9a:
            java.util.concurrent.atomic.AtomicBoolean r2 = r12.f3759f
            boolean r2 = r2.get()
            if (r2 == 0) goto La5
        La2:
            r12.a(r13, r14)
        La5:
            cn.jpush.android.ad.m.a(r1)
            goto Lcd
        La9:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Le6
            r3.<init>()     // Catch: java.lang.Throwable -> Le6
            java.lang.String r4 = "load objects error:"
            r3.append(r4)     // Catch: java.lang.Throwable -> Le6
            java.lang.String r2 = r2.getMessage()     // Catch: java.lang.Throwable -> Le6
            r3.append(r2)     // Catch: java.lang.Throwable -> Le6
            java.lang.String r2 = r3.toString()     // Catch: java.lang.Throwable -> Le6
            cn.jpush.android.helper.Logger.w(r0, r2)     // Catch: java.lang.Throwable -> Le6
            r12.d(r13)     // Catch: java.lang.Throwable -> Le6
            java.util.concurrent.atomic.AtomicBoolean r2 = r12.f3759f
            boolean r2 = r2.get()
            if (r2 == 0) goto La5
            goto La2
        Lcd:
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            java.lang.String r1 = "load object size: "
            r13.append(r1)
            int r14 = r14.size()
            r13.append(r14)
            java.lang.String r13 = r13.toString()
            cn.jpush.android.helper.Logger.i(r0, r13)
            return
        Le6:
            r0 = move-exception
            java.util.concurrent.atomic.AtomicBoolean r2 = r12.f3759f
            boolean r2 = r2.get()
            if (r2 == 0) goto Lf2
            r12.a(r13, r14)
        Lf2:
            cn.jpush.android.ad.m.a(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.p.b.b(java.lang.String, java.util.List):void");
    }

    public boolean c(String str) {
        String str2;
        List<d> list;
        Logger.d("InAppCacheMgr", "deleteMessage msgID=" + str);
        Iterator<d> it = f3754a.iterator();
        while (true) {
            if (!it.hasNext()) {
                for (d dVar : f3755b) {
                    if (dVar.f3588d.equals(str)) {
                        f3755b.remove(dVar);
                        Logger.d("InAppCacheMgr", "deleteMessage  mInAppList remove msgID=" + str);
                        str2 = "inapp_data";
                        list = f3755b;
                    }
                }
                return false;
            }
            d next = it.next();
            if (next.f3588d.equals(str)) {
                f3754a.remove(next);
                Logger.d("InAppCacheMgr", "deleteMessage  mNotifyInAppList remove msgID=" + str);
                str2 = "notify_inapp_data";
                list = f3754a;
                break;
            }
        }
        a(str2, list);
        return true;
    }

    private void b(List<d> list) {
        if (list == null || list.size() <= 1) {
            return;
        }
        Collections.sort(list, new Comparator<d>() { // from class: cn.jpush.android.p.b.1
            @Override // java.util.Comparator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public int compare(d dVar, d dVar2) {
                return dVar.bO - dVar2.bO > 0 ? 1 : -1;
            }
        });
    }

    public void a(String str, List<d> list) {
        c(str, list);
    }

    private void a(List<d> list) {
        if (list.size() >= f3756c) {
            b(list);
            while (list.size() >= f3756c) {
                d dVar = list.get(0);
                list.remove(0);
                c.d(this.f3757d, dVar.f3588d);
                a(dVar, true);
            }
            c(list);
        }
    }

    private void a(List<d> list, d dVar, String str) {
        if (a(dVar, list)) {
            Logger.d("InAppCacheMgr", "the notify message cache already, messageId: " + dVar.f3588d);
            return;
        }
        a(list);
        list.add(dVar);
        c(list);
        c(str, list);
    }

    private void a(List<d> list, String str, boolean z5) {
        if (z5) {
            list.clear();
        }
        b(str, list);
        c(list);
    }

    private static boolean a(int i6) {
        return 40 == i6;
    }

    private boolean a(d dVar, List<d> list) {
        if (list.size() <= 0) {
            return false;
        }
        if (dVar == null) {
            return true;
        }
        Iterator<d> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().f3588d.equals(dVar.f3588d)) {
                return true;
            }
        }
        return false;
    }
}
