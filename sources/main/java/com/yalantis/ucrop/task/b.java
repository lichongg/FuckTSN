package com.yalantis.ucrop.task;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import com.kuaishou.weapon.p0.g;
import com.kuaishou.weapon.p0.t;
import com.yalantis.ucrop.util.e;
import java.io.Closeable;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okio.BufferedSource;
import okio.Okio;
import okio.Sink;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class b extends AsyncTask<Void, Void, a> {

    /* renamed from: g, reason: collision with root package name */
    private static final String f42773g = "BitmapWorkerTask";

    /* renamed from: a, reason: collision with root package name */
    private final Context f42774a;

    /* renamed from: b, reason: collision with root package name */
    private Uri f42775b;

    /* renamed from: c, reason: collision with root package name */
    private Uri f42776c;

    /* renamed from: d, reason: collision with root package name */
    private final int f42777d;

    /* renamed from: e, reason: collision with root package name */
    private final int f42778e;

    /* renamed from: f, reason: collision with root package name */
    private final f3.b f42779f;

    private void a(@NonNull Uri uri, @Nullable Uri uri2) throws NullPointerException, IOException {
        InputStream inputStream;
        if (uri2 == null) {
            throw new NullPointerException("Output Uri is null - cannot copy image");
        }
        FileOutputStream fileOutputStream = null;
        try {
            inputStream = this.f42774a.getContentResolver().openInputStream(uri);
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(new File(uri2.getPath()));
                try {
                    if (inputStream == null) {
                        throw new NullPointerException("InputStream for given input Uri is null");
                    }
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = inputStream.read(bArr);
                        if (read <= 0) {
                            com.yalantis.ucrop.util.a.c(fileOutputStream2);
                            com.yalantis.ucrop.util.a.c(inputStream);
                            this.f42775b = this.f42776c;
                            return;
                        }
                        fileOutputStream2.write(bArr, 0, read);
                    }
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = fileOutputStream2;
                    com.yalantis.ucrop.util.a.c(fileOutputStream);
                    com.yalantis.ucrop.util.a.c(inputStream);
                    this.f42775b = this.f42776c;
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            th = th3;
            inputStream = null;
        }
    }

    private void c(@NonNull Uri uri, @Nullable Uri uri2) throws NullPointerException, IOException {
        Closeable closeable;
        Response response;
        if (uri2 == null) {
            throw new NullPointerException("Output Uri is null - cannot download image");
        }
        OkHttpClient okHttpClient = new OkHttpClient();
        BufferedSource bufferedSource = null;
        try {
            Response execute = okHttpClient.newCall(new Request.Builder().url(uri.toString()).build()).execute();
            try {
                BufferedSource source = execute.body().source();
                try {
                    OutputStream openOutputStream = this.f42774a.getContentResolver().openOutputStream(uri2);
                    if (openOutputStream == null) {
                        throw new NullPointerException("OutputStream for given output Uri is null");
                    }
                    Sink sink = Okio.sink(openOutputStream);
                    source.readAll(sink);
                    com.yalantis.ucrop.util.a.c(source);
                    com.yalantis.ucrop.util.a.c(sink);
                    com.yalantis.ucrop.util.a.c(execute.body());
                    okHttpClient.dispatcher().cancelAll();
                    this.f42775b = this.f42776c;
                } catch (Throwable th) {
                    th = th;
                    response = execute;
                    closeable = null;
                    bufferedSource = source;
                    com.yalantis.ucrop.util.a.c(bufferedSource);
                    com.yalantis.ucrop.util.a.c(closeable);
                    if (response != null) {
                        com.yalantis.ucrop.util.a.c(response.body());
                    }
                    okHttpClient.dispatcher().cancelAll();
                    this.f42775b = this.f42776c;
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                response = execute;
                closeable = null;
            }
        } catch (Throwable th3) {
            th = th3;
            closeable = null;
            response = null;
        }
    }

    private String d() {
        if (ContextCompat.checkSelfPermission(this.f42774a, g.f36049i) == 0) {
            return e.c(this.f42774a, this.f42775b);
        }
        return null;
    }

    private void f() throws NullPointerException, IOException {
        String scheme = this.f42775b.getScheme();
        if (master.flame.danmaku.danmaku.parser.b.f50154a.equals(scheme) || master.flame.danmaku.danmaku.parser.b.f50155b.equals(scheme)) {
            c(this.f42775b, this.f42776c);
            return;
        }
        if (!"content".equals(scheme)) {
            if (master.flame.danmaku.danmaku.parser.b.f50156c.equals(scheme)) {
                return;
            }
            throw new IllegalArgumentException("Invalid Uri scheme" + scheme);
        }
        String d6 = d();
        if (TextUtils.isEmpty(d6) || !new File(d6).exists()) {
            a(this.f42775b, this.f42776c);
        } else {
            this.f42775b = Uri.fromFile(new File(d6));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    @NonNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public a doInBackground(Void... voidArr) {
        if (this.f42775b == null) {
            return new a(new NullPointerException("Input Uri cannot be null"));
        }
        try {
            f();
            try {
                ParcelFileDescriptor openFileDescriptor = this.f42774a.getContentResolver().openFileDescriptor(this.f42775b, t.f36150k);
                if (openFileDescriptor == null) {
                    return new a(new NullPointerException("ParcelFileDescriptor was null for given Uri: [" + this.f42775b + "]"));
                }
                FileDescriptor fileDescriptor = openFileDescriptor.getFileDescriptor();
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeFileDescriptor(fileDescriptor, null, options);
                if (options.outWidth == -1 || options.outHeight == -1) {
                    return new a(new IllegalArgumentException("Bounds for bitmap could not be retrieved from the Uri: [" + this.f42775b + "]"));
                }
                options.inSampleSize = com.yalantis.ucrop.util.a.a(options, this.f42777d, this.f42778e);
                boolean z5 = false;
                options.inJustDecodeBounds = false;
                Bitmap bitmap = null;
                while (!z5) {
                    try {
                        bitmap = BitmapFactory.decodeFileDescriptor(fileDescriptor, null, options);
                        z5 = true;
                    } catch (OutOfMemoryError unused) {
                        options.inSampleSize *= 2;
                    }
                }
                if (bitmap == null) {
                    return new a(new IllegalArgumentException("Bitmap could not be decoded from the Uri: [" + this.f42775b + "]"));
                }
                com.yalantis.ucrop.util.a.c(openFileDescriptor);
                int g6 = com.yalantis.ucrop.util.a.g(this.f42774a, this.f42775b);
                int e6 = com.yalantis.ucrop.util.a.e(g6);
                int f6 = com.yalantis.ucrop.util.a.f(g6);
                com.yalantis.ucrop.model.b bVar = new com.yalantis.ucrop.model.b(g6, e6, f6);
                Matrix matrix = new Matrix();
                if (e6 != 0) {
                    matrix.preRotate(e6);
                }
                if (f6 != 1) {
                    matrix.postScale(f6, 1.0f);
                }
                return !matrix.isIdentity() ? new a(com.yalantis.ucrop.util.a.h(bitmap, matrix), bVar) : new a(bitmap, bVar);
            } catch (FileNotFoundException e7) {
                return new a(e7);
            }
        } catch (IOException | NullPointerException e8) {
            return new a(e8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(@NonNull a aVar) {
        Exception exc = aVar.f42782c;
        if (exc != null) {
            this.f42779f.onFailure(exc);
            return;
        }
        f3.b bVar = this.f42779f;
        Bitmap bitmap = aVar.f42780a;
        com.yalantis.ucrop.model.b bVar2 = aVar.f42781b;
        String path = this.f42775b.getPath();
        Uri uri = this.f42776c;
        bVar.a(bitmap, bVar2, path, uri == null ? null : uri.getPath());
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        Bitmap f42780a;

        /* renamed from: b, reason: collision with root package name */
        com.yalantis.ucrop.model.b f42781b;

        /* renamed from: c, reason: collision with root package name */
        Exception f42782c;

        public a(@NonNull Bitmap bitmap, @NonNull com.yalantis.ucrop.model.b bVar) {
            this.f42780a = bitmap;
            this.f42781b = bVar;
        }

        public a(@NonNull Exception exc) {
            this.f42782c = exc;
        }
    }

    public b(@NonNull Context context, @NonNull Uri uri, @Nullable Uri uri2, int i6, int i7, f3.b bVar) {
        this.f42774a = context;
        this.f42775b = uri;
        this.f42776c = uri2;
        this.f42777d = i6;
        this.f42778e = i7;
        this.f42779f = bVar;
    }
}
