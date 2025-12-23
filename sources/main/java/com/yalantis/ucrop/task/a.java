package com.yalantis.ucrop.task;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.net.Uri;
import android.os.AsyncTask;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.exifinterface.media.ExifInterface;
import com.yalantis.ucrop.model.c;
import com.yalantis.ucrop.util.e;
import com.yalantis.ucrop.util.f;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.ref.WeakReference;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class a extends AsyncTask<Void, Void, Throwable> {

    /* renamed from: s, reason: collision with root package name */
    private static final String f42754s = "BitmapCropTask";

    /* renamed from: a, reason: collision with root package name */
    private final WeakReference<Context> f42755a;

    /* renamed from: b, reason: collision with root package name */
    private Bitmap f42756b;

    /* renamed from: c, reason: collision with root package name */
    private final RectF f42757c;

    /* renamed from: d, reason: collision with root package name */
    private final RectF f42758d;

    /* renamed from: e, reason: collision with root package name */
    private float f42759e;

    /* renamed from: f, reason: collision with root package name */
    private float f42760f;

    /* renamed from: g, reason: collision with root package name */
    private final int f42761g;

    /* renamed from: h, reason: collision with root package name */
    private final int f42762h;

    /* renamed from: i, reason: collision with root package name */
    private final Bitmap.CompressFormat f42763i;

    /* renamed from: j, reason: collision with root package name */
    private final int f42764j;

    /* renamed from: k, reason: collision with root package name */
    private final String f42765k;

    /* renamed from: l, reason: collision with root package name */
    private final String f42766l;

    /* renamed from: m, reason: collision with root package name */
    private final com.yalantis.ucrop.model.b f42767m;

    /* renamed from: n, reason: collision with root package name */
    private final f3.a f42768n;

    /* renamed from: o, reason: collision with root package name */
    private int f42769o;

    /* renamed from: p, reason: collision with root package name */
    private int f42770p;

    /* renamed from: q, reason: collision with root package name */
    private int f42771q;

    /* renamed from: r, reason: collision with root package name */
    private int f42772r;

    private boolean a() throws IOException {
        if (this.f42761g > 0 && this.f42762h > 0) {
            float width = this.f42757c.width() / this.f42759e;
            float height = this.f42757c.height() / this.f42759e;
            int i6 = this.f42761g;
            if (width > i6 || height > this.f42762h) {
                float min = Math.min(i6 / width, this.f42762h / height);
                Bitmap createScaledBitmap = Bitmap.createScaledBitmap(this.f42756b, Math.round(r2.getWidth() * min), Math.round(this.f42756b.getHeight() * min), false);
                Bitmap bitmap = this.f42756b;
                if (bitmap != createScaledBitmap) {
                    bitmap.recycle();
                }
                this.f42756b = createScaledBitmap;
                this.f42759e /= min;
            }
        }
        if (this.f42760f != 0.0f) {
            Matrix matrix = new Matrix();
            matrix.setRotate(this.f42760f, this.f42756b.getWidth() / 2, this.f42756b.getHeight() / 2);
            Bitmap bitmap2 = this.f42756b;
            Bitmap createBitmap = Bitmap.createBitmap(bitmap2, 0, 0, bitmap2.getWidth(), this.f42756b.getHeight(), matrix, true);
            Bitmap bitmap3 = this.f42756b;
            if (bitmap3 != createBitmap) {
                bitmap3.recycle();
            }
            this.f42756b = createBitmap;
        }
        this.f42771q = Math.round((this.f42757c.left - this.f42758d.left) / this.f42759e);
        this.f42772r = Math.round((this.f42757c.top - this.f42758d.top) / this.f42759e);
        this.f42769o = Math.round(this.f42757c.width() / this.f42759e);
        int round = Math.round(this.f42757c.height() / this.f42759e);
        this.f42770p = round;
        if (!e(this.f42769o, round)) {
            e.a(this.f42765k, this.f42766l);
            return false;
        }
        ExifInterface exifInterface = new ExifInterface(this.f42765k);
        d(Bitmap.createBitmap(this.f42756b, this.f42771q, this.f42772r, this.f42769o, this.f42770p));
        if (!this.f42763i.equals(Bitmap.CompressFormat.JPEG)) {
            return true;
        }
        f.b(exifInterface, this.f42769o, this.f42770p, this.f42766l);
        return true;
    }

    private void d(@NonNull Bitmap bitmap) throws FileNotFoundException {
        Context context = this.f42755a.get();
        if (context == null) {
            return;
        }
        OutputStream outputStream = null;
        try {
            outputStream = context.getContentResolver().openOutputStream(Uri.fromFile(new File(this.f42766l)));
            bitmap.compress(this.f42763i, this.f42764j, outputStream);
            bitmap.recycle();
        } finally {
            com.yalantis.ucrop.util.a.c(outputStream);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    @Nullable
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public Throwable doInBackground(Void... voidArr) {
        Bitmap bitmap = this.f42756b;
        if (bitmap == null) {
            return new NullPointerException("ViewBitmap is null");
        }
        if (bitmap.isRecycled()) {
            return new NullPointerException("ViewBitmap is recycled");
        }
        if (this.f42758d.isEmpty()) {
            return new NullPointerException("CurrentImageRect is empty");
        }
        try {
            a();
            this.f42756b = null;
            return null;
        } catch (Throwable th) {
            return th;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(@Nullable Throwable th) {
        f3.a aVar = this.f42768n;
        if (aVar != null) {
            if (th != null) {
                aVar.b(th);
            } else {
                this.f42768n.a(Uri.fromFile(new File(this.f42766l)), this.f42771q, this.f42772r, this.f42769o, this.f42770p);
            }
        }
    }

    public a(@NonNull Context context, @Nullable Bitmap bitmap, @NonNull c cVar, @NonNull com.yalantis.ucrop.model.a aVar, @Nullable f3.a aVar2) {
        this.f42755a = new WeakReference<>(context);
        this.f42756b = bitmap;
        this.f42757c = cVar.a();
        this.f42758d = cVar.c();
        this.f42759e = cVar.d();
        this.f42760f = cVar.b();
        this.f42761g = aVar.f();
        this.f42762h = aVar.g();
        this.f42763i = aVar.a();
        this.f42764j = aVar.b();
        this.f42765k = aVar.d();
        this.f42766l = aVar.e();
        this.f42767m = aVar.c();
        this.f42768n = aVar2;
    }

    private boolean e(int i6, int i7) {
        int round = Math.round(Math.max(i6, i7) / 1000.0f) + 1;
        if (this.f42761g <= 0 || this.f42762h <= 0) {
            float f6 = round;
            if (Math.abs(this.f42757c.left - this.f42758d.left) <= f6 && Math.abs(this.f42757c.top - this.f42758d.top) <= f6 && Math.abs(this.f42757c.bottom - this.f42758d.bottom) <= f6 && Math.abs(this.f42757c.right - this.f42758d.right) <= f6 && this.f42760f == 0.0f) {
                return false;
            }
        }
        return true;
    }
}
