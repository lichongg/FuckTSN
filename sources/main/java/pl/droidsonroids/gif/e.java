package pl.droidsonroids.gif;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.SystemClock;
import android.widget.MediaController;
import androidx.annotation.DrawableRes;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RawRes;
import java.io.File;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Locale;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class e extends Drawable implements Animatable, MediaController.MediaPlayerControl {

    /* renamed from: a, reason: collision with root package name */
    final ScheduledThreadPoolExecutor f51803a;

    /* renamed from: b, reason: collision with root package name */
    volatile boolean f51804b;

    /* renamed from: c, reason: collision with root package name */
    long f51805c;

    /* renamed from: d, reason: collision with root package name */
    private final Rect f51806d;

    /* renamed from: e, reason: collision with root package name */
    protected final Paint f51807e;

    /* renamed from: f, reason: collision with root package name */
    final Bitmap f51808f;

    /* renamed from: g, reason: collision with root package name */
    final GifInfoHandle f51809g;

    /* renamed from: h, reason: collision with root package name */
    final ConcurrentLinkedQueue<pl.droidsonroids.gif.a> f51810h;

    /* renamed from: i, reason: collision with root package name */
    private ColorStateList f51811i;

    /* renamed from: j, reason: collision with root package name */
    private PorterDuffColorFilter f51812j;

    /* renamed from: k, reason: collision with root package name */
    private PorterDuff.Mode f51813k;

    /* renamed from: l, reason: collision with root package name */
    final boolean f51814l;

    /* renamed from: m, reason: collision with root package name */
    final m f51815m;

    /* renamed from: n, reason: collision with root package name */
    private final q f51816n;

    /* renamed from: o, reason: collision with root package name */
    private final Rect f51817o;

    /* renamed from: p, reason: collision with root package name */
    ScheduledFuture<?> f51818p;

    /* renamed from: q, reason: collision with root package name */
    private int f51819q;

    /* renamed from: r, reason: collision with root package name */
    private int f51820r;

    /* renamed from: s, reason: collision with root package name */
    private k5.b f51821s;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a extends s {
        a(e eVar) {
            super(eVar);
        }

        @Override // pl.droidsonroids.gif.s
        public void a() {
            if (e.this.f51809g.C()) {
                e.this.start();
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b extends s {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f51823b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(e eVar, int i6) {
            super(eVar);
            this.f51823b = i6;
        }

        @Override // pl.droidsonroids.gif.s
        public void a() {
            e eVar = e.this;
            eVar.f51809g.I(this.f51823b, eVar.f51808f);
            this.f51861a.f51815m.sendEmptyMessageAtTime(-1, 0L);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class c extends s {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f51825b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(e eVar, int i6) {
            super(eVar);
            this.f51825b = i6;
        }

        @Override // pl.droidsonroids.gif.s
        public void a() {
            e eVar = e.this;
            eVar.f51809g.G(this.f51825b, eVar.f51808f);
            e.this.f51815m.sendEmptyMessageAtTime(-1, 0L);
        }
    }

    public e(@NonNull Resources resources, @DrawableRes @RawRes int i6) throws Resources.NotFoundException, IOException {
        this(resources.openRawResourceFd(i6));
        float b6 = k.b(resources, i6);
        this.f51820r = (int) (this.f51809g.i() * b6);
        this.f51819q = (int) (this.f51809g.q() * b6);
    }

    private void I() {
        this.f51804b = false;
        this.f51815m.removeMessages(-1);
        this.f51809g.A();
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean canPause() {
        return true;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getAudioSessionId() {
        return 0;
    }

    @Override // android.graphics.drawable.Animatable, android.widget.MediaController.MediaPlayerControl
    public void start() {
        synchronized (this) {
            try {
                if (this.f51804b) {
                    return;
                }
                this.f51804b = true;
                J(this.f51809g.D());
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        synchronized (this) {
            try {
                if (this.f51804b) {
                    this.f51804b = false;
                    b();
                    this.f51809g.F();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private PorterDuffColorFilter K(ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }

    private void b() {
        ScheduledFuture<?> scheduledFuture = this.f51818p;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
        }
        this.f51815m.removeMessages(-1);
    }

    @Nullable
    public static e c(@NonNull Resources resources, @DrawableRes @RawRes int i6) {
        try {
            return new e(resources, i6);
        } catch (IOException unused) {
            return null;
        }
    }

    private void z() {
        if (this.f51814l && this.f51804b) {
            long j6 = this.f51805c;
            if (j6 != Long.MIN_VALUE) {
                long max = Math.max(0L, j6 - SystemClock.uptimeMillis());
                this.f51805c = Long.MIN_VALUE;
                this.f51803a.remove(this.f51816n);
                this.f51818p = this.f51803a.schedule(this.f51816n, max, TimeUnit.MILLISECONDS);
            }
        }
    }

    public void A(@IntRange(from = 0, to = 2147483647L) int i6) {
        if (i6 < 0) {
            throw new IllegalArgumentException("Position is not positive");
        }
        synchronized (this.f51809g) {
            this.f51809g.I(i6, this.f51808f);
        }
        this.f51815m.sendEmptyMessageAtTime(-1, 0L);
    }

    public void B(@IntRange(from = 0, to = 2147483647L) int i6) {
        if (i6 < 0) {
            throw new IndexOutOfBoundsException("Frame index is not positive");
        }
        this.f51803a.execute(new c(this, i6));
    }

    public Bitmap C(@IntRange(from = 0, to = 2147483647L) int i6) {
        Bitmap g6;
        if (i6 < 0) {
            throw new IndexOutOfBoundsException("Frame index is not positive");
        }
        synchronized (this.f51809g) {
            this.f51809g.G(i6, this.f51808f);
            g6 = g();
        }
        this.f51815m.sendEmptyMessageAtTime(-1, 0L);
        return g6;
    }

    public Bitmap D(@IntRange(from = 0, to = 2147483647L) int i6) {
        Bitmap g6;
        if (i6 < 0) {
            throw new IllegalArgumentException("Position is not positive");
        }
        synchronized (this.f51809g) {
            this.f51809g.I(i6, this.f51808f);
            g6 = g();
        }
        this.f51815m.sendEmptyMessageAtTime(-1, 0L);
        return g6;
    }

    public void E(@FloatRange(from = 0.0d) float f6) {
        k5.a aVar = new k5.a(f6);
        this.f51821s = aVar;
        aVar.b(this.f51806d);
    }

    public void F(@IntRange(from = 0, to = 65535) int i6) {
        this.f51809g.J(i6);
    }

    public void G(@FloatRange(from = 0.0d, fromInclusive = false) float f6) {
        this.f51809g.L(f6);
    }

    public void H(@Nullable k5.b bVar) {
        this.f51821s = bVar;
        if (bVar != null) {
            bVar.b(this.f51806d);
        }
    }

    void J(long j6) {
        if (this.f51814l) {
            this.f51805c = 0L;
            this.f51815m.sendEmptyMessageAtTime(-1, 0L);
        } else {
            b();
            this.f51818p = this.f51803a.schedule(this.f51816n, Math.max(j6, 0L), TimeUnit.MILLISECONDS);
        }
    }

    public void a(@NonNull pl.droidsonroids.gif.a aVar) {
        this.f51810h.add(aVar);
    }

    public long d() {
        return this.f51809g.b() + this.f51808f.getAllocationByteCount();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        boolean z5;
        if (this.f51812j == null || this.f51807e.getColorFilter() != null) {
            z5 = false;
        } else {
            this.f51807e.setColorFilter(this.f51812j);
            z5 = true;
        }
        k5.b bVar = this.f51821s;
        if (bVar == null) {
            canvas.drawBitmap(this.f51808f, this.f51817o, this.f51806d, this.f51807e);
        } else {
            bVar.a(canvas, this.f51807e, this.f51808f);
        }
        if (z5) {
            this.f51807e.setColorFilter(null);
        }
    }

    @Nullable
    public String e() {
        return this.f51809g.c();
    }

    @FloatRange(from = 0.0d)
    public float f() {
        k5.b bVar = this.f51821s;
        if (bVar instanceof k5.a) {
            return ((k5.a) bVar).d();
        }
        return 0.0f;
    }

    public Bitmap g() {
        Bitmap bitmap = this.f51808f;
        Bitmap copy = bitmap.copy(bitmap.getConfig(), this.f51808f.isMutable());
        copy.setHasAlpha(this.f51808f.hasAlpha());
        return copy;
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f51807e.getAlpha();
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getBufferPercentage() {
        return 100;
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        return this.f51807e.getColorFilter();
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getCurrentPosition() {
        return this.f51809g.f();
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getDuration() {
        return this.f51809g.g();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f51820r;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f51819q;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return (!this.f51809g.v() || this.f51807e.getAlpha() < 255) ? -2 : -1;
    }

    public int h() {
        return this.f51809g.d();
    }

    public int i() {
        int e6 = this.f51809g.e();
        return (e6 == 0 || e6 < this.f51809g.j()) ? e6 : e6 - 1;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean isPlaying() {
        return this.f51804b;
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.f51804b;
    }

    @NonNull
    public GifError j() {
        return GifError.fromCode(this.f51809g.l());
    }

    public int k() {
        return this.f51808f.getRowBytes() * this.f51808f.getHeight();
    }

    public int l(@IntRange(from = 0) int i6) {
        return this.f51809g.h(i6);
    }

    public long m() {
        return this.f51809g.p();
    }

    public int n() {
        return this.f51809g.j();
    }

    public long o() {
        return this.f51809g.k();
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        this.f51806d.set(rect);
        k5.b bVar = this.f51821s;
        if (bVar != null) {
            bVar.b(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        PorterDuff.Mode mode;
        ColorStateList colorStateList = this.f51811i;
        if (colorStateList == null || (mode = this.f51813k) == null) {
            return false;
        }
        this.f51812j = K(colorStateList, mode);
        return true;
    }

    public int p() {
        return this.f51809g.n();
    }

    @NonNull
    public final Paint q() {
        return this.f51807e;
    }

    public int r(@IntRange(from = 0) int i6, @IntRange(from = 0) int i7) {
        if (i6 >= this.f51809g.q()) {
            throw new IllegalArgumentException("x must be < width");
        }
        if (i7 < this.f51809g.i()) {
            return this.f51808f.getPixel(i6, i7);
        }
        throw new IllegalArgumentException("y must be < height");
    }

    public void s(@NonNull int[] iArr) {
        this.f51808f.getPixels(iArr, 0, this.f51809g.q(), 0, 0, this.f51809g.q(), this.f51809g.i());
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void seekTo(@IntRange(from = 0, to = 2147483647L) int i6) {
        if (i6 < 0) {
            throw new IllegalArgumentException("Position is not positive");
        }
        this.f51803a.execute(new b(this, i6));
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(@IntRange(from = 0, to = 255) int i6) {
        this.f51807e.setAlpha(i6);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        this.f51807e.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z5) {
        this.f51807e.setDither(z5);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z5) {
        this.f51807e.setFilterBitmap(z5);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        this.f51811i = colorStateList;
        this.f51812j = K(colorStateList, this.f51813k);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(@Nullable PorterDuff.Mode mode) {
        this.f51813k = mode;
        this.f51812j = K(this.f51811i, mode);
        invalidateSelf();
    }

    @Nullable
    public k5.b t() {
        return this.f51821s;
    }

    @NonNull
    public String toString() {
        return String.format(Locale.ENGLISH, "GIF: size: %dx%d, frames: %d, error: %d", Integer.valueOf(this.f51809g.q()), Integer.valueOf(this.f51809g.i()), Integer.valueOf(this.f51809g.n()), Integer.valueOf(this.f51809g.l()));
    }

    public boolean u() {
        return this.f51809g.u();
    }

    public boolean v() {
        return this.f51809g.w();
    }

    public boolean x(pl.droidsonroids.gif.a aVar) {
        return this.f51810h.remove(aVar);
    }

    public void y() {
        this.f51803a.execute(new a(this));
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean canSeekBackward() {
        if (p() > 1) {
            return true;
        }
        return false;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean canSeekForward() {
        if (p() > 1) {
            return true;
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        super.invalidateSelf();
        z();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        if (!super.isStateful()) {
            ColorStateList colorStateList = this.f51811i;
            if (colorStateList == null || !colorStateList.isStateful()) {
                return false;
            }
            return true;
        }
        return true;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void pause() {
        stop();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z5, boolean z6) {
        boolean visible = super.setVisible(z5, z6);
        if (!this.f51814l) {
            if (z5) {
                if (z6) {
                    y();
                }
                if (visible) {
                    start();
                    return visible;
                }
            } else if (visible) {
                stop();
            }
        }
        return visible;
    }

    public void w() {
        I();
        this.f51808f.recycle();
    }

    public e(@NonNull AssetManager assetManager, @NonNull String str) throws IOException {
        this(assetManager.openFd(str));
    }

    public e(@NonNull String str) throws IOException {
        this(new GifInfoHandle(str), null, null, true);
    }

    public e(@NonNull File file) throws IOException {
        this(file.getPath());
    }

    public e(@NonNull InputStream inputStream) throws IOException {
        this(new GifInfoHandle(inputStream), null, null, true);
    }

    public e(@NonNull AssetFileDescriptor assetFileDescriptor) throws IOException {
        this(new GifInfoHandle(assetFileDescriptor), null, null, true);
    }

    public e(@NonNull FileDescriptor fileDescriptor) throws IOException {
        this(new GifInfoHandle(fileDescriptor), null, null, true);
    }

    public e(@NonNull byte[] bArr) throws IOException {
        this(new GifInfoHandle(bArr), null, null, true);
    }

    public e(@NonNull ByteBuffer byteBuffer) throws IOException {
        this(new GifInfoHandle(byteBuffer), null, null, true);
    }

    public e(@Nullable ContentResolver contentResolver, @NonNull Uri uri) throws IOException {
        this(GifInfoHandle.y(contentResolver, uri), null, null, true);
    }

    protected e(@NonNull l lVar, @Nullable e eVar, @Nullable ScheduledThreadPoolExecutor scheduledThreadPoolExecutor, boolean z5, @NonNull h hVar) throws IOException {
        this(lVar.b(hVar), eVar, scheduledThreadPoolExecutor, z5);
    }

    e(GifInfoHandle gifInfoHandle, e eVar, ScheduledThreadPoolExecutor scheduledThreadPoolExecutor, boolean z5) {
        this.f51804b = true;
        this.f51805c = Long.MIN_VALUE;
        this.f51806d = new Rect();
        this.f51807e = new Paint(6);
        this.f51810h = new ConcurrentLinkedQueue<>();
        q qVar = new q(this);
        this.f51816n = qVar;
        this.f51814l = z5;
        this.f51803a = scheduledThreadPoolExecutor == null ? i.a() : scheduledThreadPoolExecutor;
        this.f51809g = gifInfoHandle;
        Bitmap bitmap = null;
        if (eVar != null) {
            synchronized (eVar.f51809g) {
                try {
                    if (!eVar.f51809g.w() && eVar.f51809g.i() >= gifInfoHandle.i() && eVar.f51809g.q() >= gifInfoHandle.q()) {
                        eVar.I();
                        bitmap = eVar.f51808f;
                        bitmap.eraseColor(0);
                    }
                } finally {
                }
            }
        }
        if (bitmap == null) {
            this.f51808f = Bitmap.createBitmap(gifInfoHandle.q(), gifInfoHandle.i(), Bitmap.Config.ARGB_8888);
        } else {
            this.f51808f = bitmap;
        }
        this.f51808f.setHasAlpha(!gifInfoHandle.v());
        this.f51817o = new Rect(0, 0, gifInfoHandle.q(), gifInfoHandle.i());
        this.f51815m = new m(this);
        qVar.a();
        this.f51819q = gifInfoHandle.q();
        this.f51820r = gifInfoHandle.i();
    }
}
