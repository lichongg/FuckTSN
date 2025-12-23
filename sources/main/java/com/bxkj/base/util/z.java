package com.bxkj.base.util;

import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.WindowManager;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class z {

    /* renamed from: h, reason: collision with root package name */
    private static final String f16653h = "ScreenShotListenManager";

    /* renamed from: i, reason: collision with root package name */
    private static final String[] f16654i = {"_data", "datetaken"};

    /* renamed from: j, reason: collision with root package name */
    private static final String[] f16655j = {"_data", "datetaken", "width", "height"};

    /* renamed from: k, reason: collision with root package name */
    private static final String[] f16656k = {"screenshot", "screen_shot", "screen-shot", "screen shot", "screencapture", "screen_capture", "screen-capture", "screen capture", "screencap", "screen_cap", "screen-cap", "screen cap"};

    /* renamed from: l, reason: collision with root package name */
    private static Point f16657l;

    /* renamed from: b, reason: collision with root package name */
    private Context f16659b;

    /* renamed from: c, reason: collision with root package name */
    private b f16660c;

    /* renamed from: d, reason: collision with root package name */
    private long f16661d;

    /* renamed from: e, reason: collision with root package name */
    private a f16662e;

    /* renamed from: f, reason: collision with root package name */
    private a f16663f;

    /* renamed from: a, reason: collision with root package name */
    private final List<String> f16658a = new ArrayList();

    /* renamed from: g, reason: collision with root package name */
    private final Handler f16664g = new Handler(Looper.getMainLooper());

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private class a extends ContentObserver {

        /* renamed from: a, reason: collision with root package name */
        private Uri f16665a;

        public a(Uri uri, Handler handler) {
            super(handler);
            this.f16665a = uri;
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z5) {
            super.onChange(z5);
            z.this.g(this.f16665a);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface b {
        void a(String str);
    }

    private Point f() {
        Point point;
        Exception e6;
        try {
            point = new Point();
            try {
                ((WindowManager) this.f16659b.getSystemService("window")).getDefaultDisplay().getRealSize(point);
                return point;
            } catch (Exception e7) {
                e6 = e7;
                e6.printStackTrace();
                return point;
            }
        } catch (Exception e8) {
            point = null;
            e6 = e8;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(Uri uri) {
        int i6;
        int i7;
        Cursor cursor = null;
        try {
            try {
                Cursor query = this.f16659b.getContentResolver().query(uri, f16655j, null, null, "date_added desc limit 1");
                if (query == null) {
                    if (query == null || query.isClosed()) {
                        return;
                    }
                    query.close();
                    return;
                }
                if (!query.moveToFirst()) {
                    if (query.isClosed()) {
                        return;
                    }
                    query.close();
                    return;
                }
                int columnIndex = query.getColumnIndex("_data");
                int columnIndex2 = query.getColumnIndex("datetaken");
                int columnIndex3 = query.getColumnIndex("width");
                int columnIndex4 = query.getColumnIndex("height");
                String string = query.getString(columnIndex);
                long j6 = query.getLong(columnIndex2);
                if (columnIndex3 < 0 || columnIndex4 < 0) {
                    Point e6 = e(string);
                    int i8 = e6.x;
                    i6 = e6.y;
                    i7 = i8;
                } else {
                    i7 = query.getInt(columnIndex3);
                    i6 = query.getInt(columnIndex4);
                }
                h(string, j6, i7, i6);
                if (query.isClosed()) {
                    return;
                }
                query.close();
            } catch (Exception e7) {
                e7.printStackTrace();
                if (0 == 0 || cursor.isClosed()) {
                    return;
                }
                cursor.close();
            }
        } finally {
        }
    }

    private boolean c(String str) {
        if (this.f16658a.contains(str)) {
            return true;
        }
        if (this.f16658a.size() >= 20) {
            for (int i6 = 0; i6 < 5; i6++) {
                this.f16658a.remove(0);
            }
        }
        this.f16658a.add(str);
        return false;
    }

    private boolean d(String str, long j6, int i6, int i7) {
        Point point;
        int i8;
        if (j6 < this.f16661d || System.currentTimeMillis() - j6 > 10000 || (((point = f16657l) != null && ((i6 > (i8 = point.x) || i7 > point.y) && (i7 > i8 || i6 > point.y))) || TextUtils.isEmpty(str))) {
            return false;
        }
        String lowerCase = str.toLowerCase();
        for (String str2 : f16656k) {
            if (lowerCase.contains(str2)) {
                return true;
            }
        }
        return false;
    }

    private Point e(String str) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        return new Point(options.outWidth, options.outHeight);
    }

    public void j(b bVar) {
        this.f16660c = bVar;
    }

    private z(Context context) {
        if (context != null) {
            this.f16659b = context;
            if (f16657l == null) {
                Point f6 = f();
                f16657l = f6;
                if (f6 != null) {
                    Point point = f16657l;
                    int i6 = point.x;
                    int i7 = point.y;
                    return;
                }
                return;
            }
            return;
        }
        throw new IllegalArgumentException("The context must not be null.");
    }

    private static void b() {
        String str;
        if (Looper.myLooper() != Looper.getMainLooper()) {
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            if (stackTrace != null && stackTrace.length >= 4) {
                str = stackTrace[3].toString();
            } else {
                str = null;
            }
            throw new IllegalStateException("Call the method must be in main thread: " + str);
        }
    }

    private void h(String str, long j6, int i6, int i7) {
        if (d(str, j6, i6, i7) && this.f16660c != null && !c(str)) {
            this.f16660c.a(str);
        }
    }

    public static z i(Context context) {
        b();
        return new z(context);
    }

    public void k() {
        b();
        this.f16658a.clear();
        this.f16661d = System.currentTimeMillis();
        Uri uri = MediaStore.Images.Media.INTERNAL_CONTENT_URI;
        this.f16662e = new a(uri, this.f16664g);
        Uri uri2 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        this.f16663f = new a(uri2, this.f16664g);
        this.f16659b.getContentResolver().registerContentObserver(uri, false, this.f16662e);
        this.f16659b.getContentResolver().registerContentObserver(uri2, false, this.f16663f);
    }

    public void l() {
        b();
        if (this.f16662e != null) {
            try {
                this.f16659b.getContentResolver().unregisterContentObserver(this.f16662e);
            } catch (Exception e6) {
                e6.printStackTrace();
            }
            this.f16662e = null;
        }
        if (this.f16663f != null) {
            try {
                this.f16659b.getContentResolver().unregisterContentObserver(this.f16663f);
            } catch (Exception e7) {
                e7.printStackTrace();
            }
            this.f16663f = null;
        }
        this.f16661d = 0L;
        this.f16658a.clear();
    }
}
