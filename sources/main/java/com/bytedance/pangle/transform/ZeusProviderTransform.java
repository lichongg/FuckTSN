package com.bytedance.pangle.transform;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.CancellationSignal;
import androidx.annotation.Keep;
import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;
import com.bytedance.pangle.provider.ContentProviderManager;
import com.bytedance.pangle.util.MethodUtils;
import com.google.android.gms.actions.SearchIntents;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

@Keep
/* loaded from: D:\Downloads\app\classes4.dex */
public class ZeusProviderTransform {
    public static Bundle call(Object obj, Uri uri, String str, String str2, Bundle bundle, String str3) {
        if (obj instanceof ContentResolver) {
            return ContentProviderManager.getInstance().call((ContentResolver) obj, uri, str, str2, bundle, str3);
        }
        try {
            return (Bundle) MethodUtils.invokeMethod(obj, NotificationCompat.CATEGORY_CALL, new Object[]{uri, str, str2, bundle}, new Class[]{Uri.class, String.class, String.class, Bundle.class});
        } catch (Exception e6) {
            throw new RuntimeException(e6);
        }
    }

    public static int delete(Object obj, Uri uri, String str, String[] strArr, String str2) {
        if (obj instanceof ContentResolver) {
            return ContentProviderManager.getInstance().delete((ContentResolver) obj, uri, str, strArr, str2);
        }
        try {
            return ((Integer) MethodUtils.invokeMethod(obj, "delete", new Object[]{uri, str, strArr}, new Class[]{Uri.class, String.class, String[].class})).intValue();
        } catch (Exception e6) {
            throw new RuntimeException(e6);
        }
    }

    public static Uri insert(Object obj, Uri uri, ContentValues contentValues, String str) {
        if (obj instanceof ContentResolver) {
            return ContentProviderManager.getInstance().insert((ContentResolver) obj, uri, contentValues, str);
        }
        try {
            return (Uri) MethodUtils.invokeMethod(obj, "insert", new Object[]{uri, contentValues}, new Class[]{Uri.class, ContentValues.class});
        } catch (Exception e6) {
            throw new RuntimeException(e6);
        }
    }

    public static void notifyChange(Object obj, Uri uri, ContentObserver contentObserver, String str) {
        if (obj instanceof ContentResolver) {
            ((ContentResolver) obj).notifyChange(com.bytedance.pangle.provider.a.a(uri, str), contentObserver);
            return;
        }
        try {
            MethodUtils.invokeMethod(obj, "notifyChange", new Object[]{uri, contentObserver}, new Class[]{Uri.class, ContentObserver.class});
        } catch (Exception e6) {
            throw new RuntimeException(e6);
        }
    }

    public static Cursor query(Object obj, Uri uri, String[] strArr, String str, String[] strArr2, String str2, CancellationSignal cancellationSignal, String str3) {
        if (obj instanceof ContentResolver) {
            return ContentProviderManager.getInstance().query((ContentResolver) obj, uri, strArr, str, strArr2, str2, cancellationSignal, str3);
        }
        try {
            return (Cursor) MethodUtils.invokeMethod(obj, SearchIntents.EXTRA_QUERY, new Object[]{uri, strArr, str, strArr2, str2, cancellationSignal}, new Class[]{Uri.class, String[].class, String.class, String[].class, String.class, CancellationSignal.class});
        } catch (Exception e6) {
            throw new RuntimeException(e6);
        }
    }

    public static int update(Object obj, Uri uri, ContentValues contentValues, String str, String[] strArr, String str2) {
        if (obj instanceof ContentResolver) {
            return ContentProviderManager.getInstance().update((ContentResolver) obj, uri, contentValues, str, strArr, str2);
        }
        try {
            return ((Integer) MethodUtils.invokeMethod(obj, "update", new Object[]{uri, contentValues, str, strArr}, new Class[]{Uri.class, ContentValues.class, String.class, String[].class})).intValue();
        } catch (Exception e6) {
            throw new RuntimeException(e6);
        }
    }

    public static String getType(Object obj, Uri uri, String str) {
        if (obj instanceof ContentResolver) {
            return ContentProviderManager.getInstance().getType((ContentResolver) obj, uri, str);
        }
        try {
            return (String) MethodUtils.invokeMethod(obj, "getType", new Object[]{uri}, new Class[]{Uri.class});
        } catch (Exception e6) {
            throw new RuntimeException(e6);
        }
    }

    public static void registerContentObserver(Object obj, Uri uri, boolean z5, ContentObserver contentObserver, String str) {
        if (obj instanceof ContentResolver) {
            ((ContentResolver) obj).registerContentObserver(com.bytedance.pangle.provider.a.a(uri, str), z5, contentObserver);
            return;
        }
        try {
            MethodUtils.invokeMethod(obj, "registerContentObserver", new Object[]{uri, Boolean.valueOf(z5), contentObserver}, new Class[]{Uri.class, Boolean.TYPE, ContentObserver.class});
        } catch (Exception e6) {
            throw new RuntimeException(e6);
        }
    }

    public static void unregisterContentObserver(Object obj, ContentObserver contentObserver, String str) {
        if (obj instanceof ContentResolver) {
            ((ContentResolver) obj).unregisterContentObserver(contentObserver);
            return;
        }
        try {
            MethodUtils.invokeMethod(obj, "unregisterContentObserver", new Object[]{contentObserver}, new Class[]{ContentObserver.class});
        } catch (Exception e6) {
            throw new RuntimeException(e6);
        }
    }

    public static Bundle call(Object obj, String str, String str2, String str3, Bundle bundle, String str4) {
        if (obj instanceof ContentResolver) {
            return ContentProviderManager.getInstance().call((ContentResolver) obj, str, str2, str3, bundle, str4);
        }
        try {
            return (Bundle) MethodUtils.invokeMethod(obj, NotificationCompat.CATEGORY_CALL, new Object[]{str, str2, str3, bundle}, new Class[]{String.class, String.class, String.class, Bundle.class});
        } catch (Exception e6) {
            throw new RuntimeException(e6);
        }
    }

    public static int delete(Object obj, Uri uri, Bundle bundle, String str) {
        if (obj instanceof ContentResolver) {
            return ContentProviderManager.getInstance().delete((ContentResolver) obj, uri, bundle, str);
        }
        try {
            return ((Integer) MethodUtils.invokeMethod(obj, "delete", new Object[]{uri, bundle}, new Class[]{Uri.class, Bundle.class})).intValue();
        } catch (Exception e6) {
            throw new RuntimeException(e6);
        }
    }

    public static Uri insert(Object obj, Uri uri, ContentValues contentValues, Bundle bundle, String str) {
        if (obj instanceof ContentResolver) {
            return ContentProviderManager.getInstance().insert((ContentResolver) obj, uri, contentValues, bundle, str);
        }
        try {
            return (Uri) MethodUtils.invokeMethod(obj, "insert", new Object[]{uri, contentValues, bundle}, new Class[]{Uri.class, ContentValues.class, Bundle.class});
        } catch (Exception e6) {
            throw new RuntimeException(e6);
        }
    }

    @RequiresApi(api = 24)
    public static void notifyChange(Object obj, Uri uri, ContentObserver contentObserver, int i6, String str) {
        if (obj instanceof ContentResolver) {
            ((ContentResolver) obj).notifyChange(com.bytedance.pangle.provider.a.a(uri, str), contentObserver, i6);
            return;
        }
        try {
            MethodUtils.invokeMethod(obj, "notifyChange", new Object[]{uri, contentObserver, Integer.valueOf(i6)}, new Class[]{Uri.class, ContentObserver.class, Integer.TYPE});
        } catch (Exception e6) {
            throw new RuntimeException(e6);
        }
    }

    public static Cursor query(Object obj, Uri uri, String[] strArr, String str, String[] strArr2, String str2, String str3) {
        if (obj instanceof ContentResolver) {
            return ContentProviderManager.getInstance().query((ContentResolver) obj, uri, strArr, str, strArr2, str2, str3);
        }
        try {
            return (Cursor) MethodUtils.invokeMethod(obj, SearchIntents.EXTRA_QUERY, new Object[]{uri, strArr, str, strArr2, str2}, new Class[]{Uri.class, String[].class, String.class, String[].class, String.class});
        } catch (Exception e6) {
            throw new RuntimeException(e6);
        }
    }

    public static int update(Object obj, Uri uri, ContentValues contentValues, Bundle bundle, String str) {
        if (obj instanceof ContentResolver) {
            return ContentProviderManager.getInstance().update((ContentResolver) obj, uri, contentValues, bundle, str);
        }
        try {
            return ((Integer) MethodUtils.invokeMethod(obj, "update", new Object[]{uri, contentValues, bundle}, new Class[]{Uri.class, ContentValues.class, Bundle.class})).intValue();
        } catch (Exception e6) {
            throw new RuntimeException(e6);
        }
    }

    public static void notifyChange(Object obj, Uri uri, ContentObserver contentObserver, boolean z5, String str) {
        if (obj instanceof ContentResolver) {
            ((ContentResolver) obj).notifyChange(com.bytedance.pangle.provider.a.a(uri, str), contentObserver, z5);
            return;
        }
        try {
            MethodUtils.invokeMethod(obj, "notifyChange", new Object[]{uri, contentObserver, Boolean.valueOf(z5)}, new Class[]{Uri.class, ContentObserver.class, Boolean.TYPE});
        } catch (Exception e6) {
            throw new RuntimeException(e6);
        }
    }

    @RequiresApi(api = 26)
    public static Cursor query(Object obj, Uri uri, String[] strArr, Bundle bundle, CancellationSignal cancellationSignal, String str) {
        if (obj instanceof ContentResolver) {
            return ContentProviderManager.getInstance().query((ContentResolver) obj, uri, strArr, bundle, cancellationSignal, str);
        }
        try {
            return (Cursor) MethodUtils.invokeMethod(obj, SearchIntents.EXTRA_QUERY, new Object[]{uri, strArr, bundle, cancellationSignal}, new Class[]{Uri.class, String[].class, Bundle.class, CancellationSignal.class});
        } catch (Exception e6) {
            throw new RuntimeException(e6);
        }
    }

    @RequiresApi(api = 30)
    public static void notifyChange(Object obj, Collection<Uri> collection, ContentObserver contentObserver, int i6, String str) {
        if (obj instanceof ContentResolver) {
            ArrayList arrayList = new ArrayList();
            Iterator<Uri> it = collection.iterator();
            while (it.hasNext()) {
                arrayList.add(com.bytedance.pangle.provider.a.a(it.next(), str));
            }
            ((ContentResolver) obj).notifyChange((Collection<Uri>) arrayList, contentObserver, i6);
            return;
        }
        try {
            MethodUtils.invokeMethod(obj, "notifyChange", new Object[]{collection, contentObserver, Integer.valueOf(i6)}, new Class[]{Collection.class, ContentObserver.class, Integer.TYPE});
        } catch (Exception e6) {
            throw new RuntimeException(e6);
        }
    }
}
