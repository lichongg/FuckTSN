package cn.jpush.android.d;

import android.content.Context;
import android.text.TextUtils;
import cn.jpush.android.helper.Logger;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONArray;

/* loaded from: D:\Downloads\app\classes2.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private static Queue<a> f3584a;

    public static synchronized void a(Context context, String str) {
        synchronized (c.class) {
            if (context == null) {
                Logger.w("MsgQueueUtils", "unexcepted , context is null");
                return;
            }
            File filesDir = context.getFilesDir();
            if (filesDir == null) {
                Logger.w("MsgQueueUtils", "can't get files dir");
                return;
            }
            File file = new File(filesDir, str);
            if (file.exists()) {
                file.delete();
            }
        }
    }

    private static synchronized void a(Context context, String str, ArrayList<a> arrayList) {
        synchronized (c.class) {
            Logger.v("MsgQueueUtils", "Action - saveObjects");
            if (context == null) {
                Logger.w("MsgQueueUtils", "unexcepted , context is null");
                return;
            }
            if (arrayList == null) {
                Logger.w("MsgQueueUtils", "mObjectList is null");
                return;
            }
            try {
                File file = new File(context.getFilesDir(), str);
                JSONArray jSONArray = new JSONArray();
                for (int i6 = 0; i6 < arrayList.size(); i6++) {
                    jSONArray.put(arrayList.get(i6).a());
                }
                cn.jpush.android.ad.c.a(file.getAbsolutePath(), jSONArray.toString());
            } catch (Throwable th) {
                Logger.ww("MsgQueueUtils", "save Objects  error:" + th.getMessage());
            }
        }
    }

    private static synchronized ArrayList<a> b(Context context, String str) {
        synchronized (c.class) {
            if (context == null) {
                Logger.w("MsgQueueUtils", "unexcepted , context is null");
                return null;
            }
            ArrayList<a> arrayList = new ArrayList<>();
            try {
                File file = new File(context.getFilesDir(), str);
                if (file.exists()) {
                    String c6 = cn.jpush.android.ad.c.c(file);
                    if (!TextUtils.isEmpty(c6)) {
                        JSONArray jSONArray = new JSONArray(c6);
                        for (int i6 = 0; i6 < jSONArray.length(); i6++) {
                            arrayList.add(a.a(jSONArray.getJSONObject(i6)));
                        }
                    }
                }
            } finally {
                try {
                    return arrayList;
                } finally {
                }
            }
            return arrayList;
        }
    }

    public static boolean a(Context context, a aVar) {
        if (f3584a == null) {
            f3584a = new ConcurrentLinkedQueue();
            try {
                ArrayList<a> b6 = b(context, "msg_queue_v350");
                if (b6 != null && !b6.isEmpty()) {
                    Iterator<a> it = b6.iterator();
                    while (it.hasNext()) {
                        f3584a.offer(it.next());
                    }
                }
            } catch (Exception e6) {
                Logger.ww("MsgQueueUtils", "init lastMsgQueue failed:" + e6.getMessage());
            }
        }
        if (context == null) {
            Logger.ww("MsgQueueUtils", "#unexcepted - context was null");
            return false;
        }
        if (aVar == null) {
            Logger.ww("MsgQueueUtils", "#unexcepted - entityKey was null");
        }
        if (f3584a.contains(aVar)) {
            Logger.e("MsgQueueUtils", "Duplicated msg. Give up processing - " + aVar);
            return true;
        }
        if (f3584a.size() >= 200) {
            f3584a.poll();
        }
        f3584a.offer(aVar);
        try {
            ArrayList<a> b7 = b(context, "msg_queue_v350");
            if (b7 == null) {
                b7 = new ArrayList<>();
            }
            if (b7.size() >= 50) {
                b7.remove(0);
            }
            b7.add(aVar);
            a(context, "msg_queue_v350", b7);
        } catch (Exception e7) {
            Logger.ww("MsgQueueUtils", "msg save in sp failed:" + e7.getMessage());
        }
        return false;
    }
}
