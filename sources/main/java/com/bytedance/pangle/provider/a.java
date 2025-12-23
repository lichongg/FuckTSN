package com.bytedance.pangle.provider;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.CancellationSignal;
import androidx.annotation.Keep;
import androidx.annotation.RequiresApi;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.util.oq;
import java.io.File;

@Keep
/* loaded from: D:\Downloads\app\classes3.dex */
public class a {
    private static Uri a(String str, Uri uri) {
        return a(str, uri, (String) null);
    }

    private static Uri a(String str, Uri uri, String str2) {
        ContentProviderManager contentProviderManager = ContentProviderManager.getInstance();
        if (uri != null) {
            str2 = uri.getAuthority();
        }
        String pluginProcessNameByAuthority = contentProviderManager.getPluginProcessNameByAuthority(str2);
        String j6 = oq.j(j.j(pluginProcessNameByAuthority, str, uri));
        return Uri.parse("content://" + ContentProviderManager.getInstance().getSystemProviderInfoMap().get(pluginProcessNameByAuthority).xt + File.separator + "proxy?provider_params=" + j6);
    }

    public static int b(ContentResolver contentResolver, Uri uri, ContentValues contentValues, Bundle bundle, String str) {
        int update;
        int update2;
        if (contentResolver == null) {
            return 0;
        }
        try {
            try {
                update2 = contentResolver.update(a(uri, str), contentValues, bundle);
                return update2;
            } catch (IllegalArgumentException unused) {
                ZeusLogger.w(ZeusLogger.TAG_PROVIDER, "not found plugin provider, but found host ContentResolver execute update !!!");
                update = contentResolver.update(uri, contentValues, bundle);
                return update;
            } catch (Exception e6) {
                e = e6;
                ZeusLogger.w(ZeusLogger.TAG_PROVIDER, "ContentProviderManager#update throw exception:", e);
                return 0;
            } catch (IncompatibleClassChangeError e7) {
                e = e7;
                ZeusLogger.w(ZeusLogger.TAG_PROVIDER, "ContentProviderManager#update throw exception:", e);
                return 0;
            }
        } catch (Throwable th) {
            ZeusLogger.w(ZeusLogger.TAG_PROVIDER, "ContentProviderManager#update throw exception:", th);
            return 0;
        }
    }

    @RequiresApi(api = 16)
    public static Cursor a(ContentResolver contentResolver, Uri uri, String[] strArr, String str, String[] strArr2, String str2, CancellationSignal cancellationSignal, String str3) {
        if (contentResolver == null) {
            return null;
        }
        try {
            try {
                return contentResolver.query(a(uri, str3), strArr, str, strArr2, str2, cancellationSignal);
            } catch (IllegalArgumentException unused) {
                ZeusLogger.w(ZeusLogger.TAG_PROVIDER, "not found plugin provider, but found host ContentResolver execute query(6 params) !!!");
                return contentResolver.query(uri, strArr, str, strArr2, str2, cancellationSignal);
            } catch (Exception e6) {
                e = e6;
                ZeusLogger.w(ZeusLogger.TAG_PROVIDER, "ContentProviderManager#query(6 params) throw exception:", e);
                return null;
            } catch (IncompatibleClassChangeError e7) {
                e = e7;
                ZeusLogger.w(ZeusLogger.TAG_PROVIDER, "ContentProviderManager#query(6 params) throw exception:", e);
                return null;
            }
        } catch (Throwable th) {
            ZeusLogger.w(ZeusLogger.TAG_PROVIDER, "not found host provider-ContentProviderManager#query(6 params) throw exception:", th);
            return null;
        }
    }

    @RequiresApi(api = 26)
    public static Cursor a(ContentResolver contentResolver, Uri uri, String[] strArr, Bundle bundle, CancellationSignal cancellationSignal, String str) {
        Cursor query;
        Cursor query2;
        if (contentResolver == null) {
            return null;
        }
        try {
            try {
                query2 = contentResolver.query(a(uri, str), strArr, bundle, cancellationSignal);
                return query2;
            } catch (IllegalArgumentException unused) {
                ZeusLogger.w(ZeusLogger.TAG_PROVIDER, "not found plugin provider, but found host ContentResolver execute query(5 params) !!!");
                query = contentResolver.query(uri, strArr, bundle, cancellationSignal);
                return query;
            } catch (Exception e6) {
                e = e6;
                ZeusLogger.w(ZeusLogger.TAG_PROVIDER, "ContentProviderManager#query(4 params) throw exception:", e);
                return null;
            } catch (IncompatibleClassChangeError e7) {
                e = e7;
                ZeusLogger.w(ZeusLogger.TAG_PROVIDER, "ContentProviderManager#query(4 params) throw exception:", e);
                return null;
            }
        } catch (Throwable th) {
            ZeusLogger.w(ZeusLogger.TAG_PROVIDER, "not found host provider-ContentProviderManager#query(4 params) throw exception:", th);
            return null;
        }
    }

    public static Cursor a(ContentResolver contentResolver, Uri uri, String[] strArr, String str, String[] strArr2, String str2, String str3) {
        ContentResolver contentResolver2;
        String str4;
        String[] strArr3;
        String str5;
        String[] strArr4;
        if (contentResolver == null) {
            return null;
        }
        try {
            try {
                contentResolver2 = contentResolver;
                try {
                    return contentResolver2.query(a(uri, str3), strArr, str, strArr2, str2);
                } catch (IllegalArgumentException unused) {
                    strArr4 = strArr;
                    str5 = str;
                    strArr3 = strArr2;
                    str4 = str2;
                    try {
                        ZeusLogger.w(ZeusLogger.TAG_PROVIDER, "not found plugin provider, but found host ContentResolver execute query(5 params) !!!");
                        return contentResolver2.query(uri, strArr4, str5, strArr3, str4);
                    } catch (Throwable th) {
                        ZeusLogger.w(ZeusLogger.TAG_PROVIDER, "not found host provider-ContentProviderManager#query(5 params) throw exception:", th);
                        return null;
                    }
                }
            } catch (Exception e6) {
                ZeusLogger.w(ZeusLogger.TAG_PROVIDER, "ContentProviderManager#query(5 params) throw exception:", e6);
                return null;
            }
        } catch (IllegalArgumentException unused2) {
            contentResolver2 = contentResolver;
            str4 = str2;
            strArr3 = strArr2;
            str5 = str;
            strArr4 = strArr;
        }
    }

    public static String a(ContentResolver contentResolver, Uri uri, String str) {
        if (contentResolver == null) {
            return null;
        }
        try {
            try {
                return contentResolver.getType(a(uri, str));
            } catch (IllegalArgumentException unused) {
                ZeusLogger.w(ZeusLogger.TAG_PROVIDER, "not found plugin provider, but found host ContentResolver execute getType !!!");
                return contentResolver.getType(uri);
            } catch (Exception e6) {
                ZeusLogger.w(ZeusLogger.TAG_PROVIDER, "ContentProviderManager#getType throw exception:", e6);
                return null;
            }
        } catch (Throwable th) {
            ZeusLogger.w(ZeusLogger.TAG_PROVIDER, "not found host provider-ContentProviderManager#getType throw exception:", th);
            return null;
        }
    }

    public static Uri a(ContentResolver contentResolver, Uri uri, ContentValues contentValues, String str) {
        if (contentResolver == null) {
            return null;
        }
        try {
            try {
                return contentResolver.insert(a(uri, str), contentValues);
            } catch (IllegalArgumentException unused) {
                ZeusLogger.w(ZeusLogger.TAG_PROVIDER, "not found plugin provider, but found host ContentResolver execute insert !!!");
                return contentResolver.insert(uri, contentValues);
            } catch (Exception e6) {
                ZeusLogger.w(ZeusLogger.TAG_PROVIDER, "ContentProviderManager#insert throw exception:", e6);
                return null;
            }
        } catch (Throwable th) {
            ZeusLogger.w(ZeusLogger.TAG_PROVIDER, "not found host provider-ContentProviderManager#insert throw exception:", th);
            return null;
        }
    }

    public static Uri a(ContentResolver contentResolver, Uri uri, ContentValues contentValues, Bundle bundle, String str) {
        Uri insert;
        Uri insert2;
        if (contentResolver == null) {
            return null;
        }
        try {
            try {
                insert2 = contentResolver.insert(a(uri, str), contentValues, bundle);
                return insert2;
            } catch (IllegalArgumentException unused) {
                ZeusLogger.w(ZeusLogger.TAG_PROVIDER, "not found plugin provider, but found host ContentResolver execute insert !!!");
                insert = contentResolver.insert(uri, contentValues, bundle);
                return insert;
            } catch (Exception e6) {
                e = e6;
                ZeusLogger.w(ZeusLogger.TAG_PROVIDER, "ContentProviderManager#insert throw exception:", e);
                return null;
            } catch (IncompatibleClassChangeError e7) {
                e = e7;
                ZeusLogger.w(ZeusLogger.TAG_PROVIDER, "ContentProviderManager#insert throw exception:", e);
                return null;
            }
        } catch (Throwable th) {
            ZeusLogger.w(ZeusLogger.TAG_PROVIDER, "not found host provider-ContentProviderManager#insert throw exception:", th);
            return null;
        }
    }

    public static int a(ContentResolver contentResolver, Uri uri, String str, String[] strArr, String str2) {
        if (contentResolver == null) {
            return -1;
        }
        try {
            try {
                return contentResolver.delete(a(uri, str2), str, strArr);
            } catch (IllegalArgumentException unused) {
                ZeusLogger.w(ZeusLogger.TAG_PROVIDER, "not found plugin provider, but found host ContentResolver execute delete !!!");
                return contentResolver.delete(uri, str, strArr);
            } catch (Exception e6) {
                ZeusLogger.w(ZeusLogger.TAG_PROVIDER, "ContentProviderManager#delete throw exception:", e6);
                return -1;
            }
        } catch (Throwable th) {
            ZeusLogger.w(ZeusLogger.TAG_PROVIDER, "ContentProviderManager#delete throw exception:", th);
            return -1;
        }
    }

    public static int a(ContentResolver contentResolver, Uri uri, Bundle bundle, String str) {
        int delete;
        int delete2;
        if (contentResolver == null) {
            return -1;
        }
        try {
            try {
                delete2 = contentResolver.delete(a(uri, str), bundle);
                return delete2;
            } catch (IllegalArgumentException unused) {
                ZeusLogger.w(ZeusLogger.TAG_PROVIDER, "not found plugin provider, but found host ContentResolver execute delete !!!");
                delete = contentResolver.delete(uri, bundle);
                return delete;
            } catch (Exception e6) {
                e = e6;
                ZeusLogger.w(ZeusLogger.TAG_PROVIDER, "ContentProviderManager#delete throw exception:", e);
                return -1;
            } catch (IncompatibleClassChangeError e7) {
                e = e7;
                ZeusLogger.w(ZeusLogger.TAG_PROVIDER, "ContentProviderManager#delete throw exception:", e);
                return -1;
            }
        } catch (Throwable th) {
            ZeusLogger.w(ZeusLogger.TAG_PROVIDER, "ContentProviderManager#delete throw exception:", th);
            return -1;
        }
    }

    public static int a(ContentResolver contentResolver, Uri uri, ContentValues contentValues, String str, String[] strArr, String str2) {
        if (contentResolver == null) {
            return 0;
        }
        try {
            try {
                return contentResolver.update(a(uri, str2), contentValues, str, strArr);
            } catch (IllegalArgumentException unused) {
                ZeusLogger.w(ZeusLogger.TAG_PROVIDER, "not found plugin provider, but found host ContentResolver execute update !!!");
                return contentResolver.update(uri, contentValues, str, strArr);
            } catch (Exception e6) {
                ZeusLogger.w(ZeusLogger.TAG_PROVIDER, "ContentProviderManager#update throw exception:", e6);
                return 0;
            }
        } catch (Throwable th) {
            ZeusLogger.w(ZeusLogger.TAG_PROVIDER, "ContentProviderManager#update throw exception:", th);
            return 0;
        }
    }

    public static Bundle a(ContentResolver contentResolver, Uri uri, String str, String str2, Bundle bundle, String str3) {
        if (contentResolver != null && uri != null) {
            try {
                try {
                    Uri a6 = a(uri, str3);
                    if (bundle == null) {
                        bundle = new Bundle();
                    }
                    bundle.putString("provider_params", uri.getAuthority());
                    bundle.putString(ContentProviderManager.PROVIDER_PROXY_URI, a6.toString());
                    return contentResolver.call(a6, str, str2, bundle);
                } catch (IllegalArgumentException unused) {
                    ZeusLogger.w(ZeusLogger.TAG_PROVIDER, "not found plugin provider, but found host ContentResolver execute call !!!");
                    return contentResolver.call(uri, str, str2, bundle);
                } catch (Exception e6) {
                    e = e6;
                    ZeusLogger.w(ZeusLogger.TAG_PROVIDER, "ContentProviderManager#call throw exception:", e);
                    return null;
                } catch (IncompatibleClassChangeError e7) {
                    e = e7;
                    ZeusLogger.w(ZeusLogger.TAG_PROVIDER, "ContentProviderManager#call throw exception:", e);
                    return null;
                }
            } catch (Throwable th) {
                ZeusLogger.w(ZeusLogger.TAG_PROVIDER, "ContentProviderManager#call throw exception:", th);
            }
        }
        return null;
    }

    public static Bundle a(ContentResolver contentResolver, String str, String str2, String str3, Bundle bundle, String str4) {
        Bundle call;
        Bundle call2;
        if (contentResolver == null) {
            return null;
        }
        String str5 = ContentProviderManager.getInstance().getSystemProviderInfoMap().get(ContentProviderManager.getInstance().getPluginProcessNameByAuthority(str)).xt;
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putString("provider_params", str);
        bundle.putString(ContentProviderManager.PROVIDER_PROXY_URI, a(str4, (Uri) null, str).toString());
        try {
            try {
                call2 = contentResolver.call(str5, str2, str3, bundle);
                return call2;
            } catch (IllegalArgumentException unused) {
                ZeusLogger.w(ZeusLogger.TAG_PROVIDER, "not found plugin provider, but found host ContentResolver execute call !!!");
                call = contentResolver.call(str, str2, str3, bundle);
                return call;
            } catch (Exception e6) {
                e = e6;
                ZeusLogger.w(ZeusLogger.TAG_PROVIDER, "ContentProviderManager#call throw exception:", e);
                return null;
            } catch (IncompatibleClassChangeError e7) {
                e = e7;
                ZeusLogger.w(ZeusLogger.TAG_PROVIDER, "ContentProviderManager#call throw exception:", e);
                return null;
            }
        } catch (Throwable th) {
            ZeusLogger.w(ZeusLogger.TAG_PROVIDER, "ContentProviderManager#call throw exception:", th);
            return null;
        }
    }

    public static Uri a(Uri uri, String str) {
        if (ContentProviderManager.getInstance().isPluginProvider(uri)) {
            return a(str, uri);
        }
        if (!uri.getAuthority().startsWith(Zeus.getAppApplication().getPackageName())) {
            return uri;
        }
        Uri parse = Uri.parse(uri.toString().replaceFirst(Zeus.getAppApplication().getPackageName(), str));
        return ContentProviderManager.getInstance().isPluginProvider(parse) ? a(str, parse) : uri;
    }
}
