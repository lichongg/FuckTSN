package pl.droidsonroids.gif;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.system.ErrnoException;
import android.system.Os;
import android.view.Surface;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.RequiresApi;
import com.kuaishou.weapon.p0.t;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import kotlin.text.v0;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
final class GifInfoHandle {

    /* renamed from: a, reason: collision with root package name */
    private volatile long f51778a;

    GifInfoHandle() {
    }

    private static native void bindSurface(long j6, Surface surface, long[] jArr);

    static native int createTempNativeFileDescriptor() throws GifIOException;

    static native int extractNativeFileDescriptor(FileDescriptor fileDescriptor, boolean z5) throws GifIOException;

    private static native void free(long j6);

    private static native long getAllocationByteCount(long j6);

    private static native String getComment(long j6);

    private static native int getCurrentFrameIndex(long j6);

    private static native int getCurrentLoop(long j6);

    private static native int getCurrentPosition(long j6);

    private static native int getDuration(long j6);

    private static native int getFrameDuration(long j6, int i6);

    private static native int getHeight(long j6);

    private static native int getLoopCount(long j6);

    private static native long getMetadataByteCount(long j6);

    private static native int getNativeErrorCode(long j6);

    private static native int getNumberOfFrames(long j6);

    private static native long[] getSavedState(long j6);

    private static native long getSourceLength(long j6);

    private static native int getWidth(long j6);

    private static native void glTexImage2D(long j6, int i6, int i7);

    private static native void glTexSubImage2D(long j6, int i6, int i7);

    private static native void initTexImageDescriptor(long j6);

    private static native boolean isAnimationCompleted(long j6);

    private static native boolean isOpaque(long j6);

    static native long openByteArray(byte[] bArr) throws GifIOException;

    static native long openDirectByteBuffer(ByteBuffer byteBuffer) throws GifIOException;

    static native long openFile(String str) throws GifIOException;

    static native long openNativeFileDescriptor(int i6, long j6) throws GifIOException;

    static native long openStream(InputStream inputStream) throws GifIOException;

    private static native void postUnbindSurface(long j6);

    private static native long renderFrame(long j6, Bitmap bitmap);

    private static native boolean reset(long j6);

    private static native long restoreRemainder(long j6);

    private static native int restoreSavedState(long j6, long[] jArr, Bitmap bitmap);

    private static native void saveRemainder(long j6);

    private static native void seekToFrame(long j6, int i6, Bitmap bitmap);

    private static native void seekToFrameGL(long j6, int i6);

    private static native void seekToTime(long j6, int i6, Bitmap bitmap);

    private static native void setLoopCount(long j6, char c6);

    private static native void setOptions(long j6, char c6, boolean z5);

    private static native void setSpeedFactor(long j6, float f6);

    private static native void startDecoderThread(long j6);

    private static native void stopDecoderThread(long j6);

    synchronized void A() {
        free(this.f51778a);
        this.f51778a = 0L;
    }

    synchronized long B(Bitmap bitmap) {
        return renderFrame(this.f51778a, bitmap);
    }

    synchronized boolean C() {
        return reset(this.f51778a);
    }

    synchronized long D() {
        return restoreRemainder(this.f51778a);
    }

    synchronized int E(long[] jArr, Bitmap bitmap) {
        return restoreSavedState(this.f51778a, jArr, bitmap);
    }

    synchronized void F() {
        saveRemainder(this.f51778a);
    }

    synchronized void G(@IntRange(from = 0, to = 2147483647L) int i6, Bitmap bitmap) {
        seekToFrame(this.f51778a, i6, bitmap);
    }

    synchronized void I(@IntRange(from = 0, to = 2147483647L) int i6, Bitmap bitmap) {
        seekToTime(this.f51778a, i6, bitmap);
    }

    void L(@FloatRange(from = 0.0d, fromInclusive = false) float f6) {
        if (f6 <= 0.0f || Float.isNaN(f6)) {
            throw new IllegalArgumentException("Speed factor is not positive");
        }
        if (f6 < 4.656613E-10f) {
            f6 = 4.656613E-10f;
        }
        synchronized (this) {
            setSpeedFactor(this.f51778a, f6);
        }
    }

    synchronized long b() {
        return getAllocationByteCount(this.f51778a);
    }

    synchronized String c() {
        return getComment(this.f51778a);
    }

    synchronized int d() {
        return getCurrentFrameIndex(this.f51778a);
    }

    synchronized int e() {
        return getCurrentLoop(this.f51778a);
    }

    synchronized int f() {
        return getCurrentPosition(this.f51778a);
    }

    synchronized int g() {
        return getDuration(this.f51778a);
    }

    synchronized int h(@IntRange(from = 0) int i6) {
        O(i6);
        return getFrameDuration(this.f51778a, i6);
    }

    synchronized int i() {
        return getHeight(this.f51778a);
    }

    synchronized int j() {
        return getLoopCount(this.f51778a);
    }

    synchronized long k() {
        return getMetadataByteCount(this.f51778a);
    }

    synchronized int l() {
        return getNativeErrorCode(this.f51778a);
    }

    synchronized int n() {
        return getNumberOfFrames(this.f51778a);
    }

    synchronized long[] o() {
        return getSavedState(this.f51778a);
    }

    synchronized long p() {
        return getSourceLength(this.f51778a);
    }

    synchronized int q() {
        return getWidth(this.f51778a);
    }

    synchronized boolean u() {
        return isAnimationCompleted(this.f51778a);
    }

    synchronized boolean v() {
        return isOpaque(this.f51778a);
    }

    synchronized boolean w() {
        return this.f51778a == 0;
    }

    synchronized void z() {
        postUnbindSurface(this.f51778a);
    }

    GifInfoHandle(FileDescriptor fileDescriptor) throws GifIOException {
        this.f51778a = x(fileDescriptor, 0L, true);
    }

    private void O(@IntRange(from = 0) int i6) {
        int numberOfFrames = getNumberOfFrames(this.f51778a);
        if (i6 < 0 || i6 >= numberOfFrames) {
            throw new IndexOutOfBoundsException("Frame index is not in range <0;" + numberOfFrames + v0.f47962f);
        }
    }

    private static long x(FileDescriptor fileDescriptor, long j6, boolean z5) throws GifIOException {
        int m6;
        if (Build.VERSION.SDK_INT > 27) {
            try {
                m6 = m(fileDescriptor, z5);
            } catch (Exception e6) {
                throw new GifIOException(GifError.OPEN_FAILED.errorCode, e6.getMessage());
            }
        } else {
            m6 = extractNativeFileDescriptor(fileDescriptor, z5);
        }
        return openNativeFileDescriptor(m6, j6);
    }

    static GifInfoHandle y(ContentResolver contentResolver, Uri uri) throws IOException {
        if (master.flame.danmaku.danmaku.parser.b.f50156c.equals(uri.getScheme())) {
            return new GifInfoHandle(uri.getPath());
        }
        AssetFileDescriptor openAssetFileDescriptor = contentResolver.openAssetFileDescriptor(uri, t.f36150k);
        if (openAssetFileDescriptor != null) {
            return new GifInfoHandle(openAssetFileDescriptor);
        }
        throw new IOException("Could not open AssetFileDescriptor for " + uri);
    }

    void J(@IntRange(from = 0, to = 65535) int i6) {
        if (i6 < 0 || i6 > 65535) {
            throw new IllegalArgumentException("Loop count of range <0, 65535>");
        }
        synchronized (this) {
            setLoopCount(this.f51778a, (char) i6);
        }
    }

    void K(char c6, boolean z5) {
        setOptions(this.f51778a, c6, z5);
    }

    void M() {
        startDecoderThread(this.f51778a);
    }

    void N() {
        stopDecoderThread(this.f51778a);
    }

    void a(Surface surface, long[] jArr) {
        bindSurface(this.f51778a, surface, jArr);
    }

    void r(int i6, int i7) {
        glTexImage2D(this.f51778a, i6, i7);
    }

    void s(int i6, int i7) {
        glTexSubImage2D(this.f51778a, i6, i7);
    }

    void t() {
        initTexImageDescriptor(this.f51778a);
    }

    static {
        n.b();
    }

    @RequiresApi(21)
    private static int m(FileDescriptor fileDescriptor, boolean z5) throws GifIOException, ErrnoException {
        try {
            int createTempNativeFileDescriptor = createTempNativeFileDescriptor();
            Os.dup2(fileDescriptor, createTempNativeFileDescriptor);
            return createTempNativeFileDescriptor;
        } finally {
            if (z5) {
                Os.close(fileDescriptor);
            }
        }
    }

    void H(@IntRange(from = 0) int i6) {
        O(i6);
        seekToFrameGL(this.f51778a, i6);
    }

    protected void finalize() throws Throwable {
        try {
            A();
        } finally {
            super.finalize();
        }
    }

    GifInfoHandle(byte[] bArr) throws GifIOException {
        this.f51778a = openByteArray(bArr);
    }

    GifInfoHandle(ByteBuffer byteBuffer) throws GifIOException {
        this.f51778a = openDirectByteBuffer(byteBuffer);
    }

    GifInfoHandle(String str) throws GifIOException {
        this.f51778a = openFile(str);
    }

    GifInfoHandle(InputStream inputStream) throws GifIOException {
        if (inputStream.markSupported()) {
            this.f51778a = openStream(inputStream);
            return;
        }
        throw new IllegalArgumentException("InputStream does not support marking");
    }

    GifInfoHandle(AssetFileDescriptor assetFileDescriptor) throws IOException {
        try {
            this.f51778a = x(assetFileDescriptor.getFileDescriptor(), assetFileDescriptor.getStartOffset(), false);
        } finally {
            try {
                assetFileDescriptor.close();
            } catch (IOException unused) {
            }
        }
    }
}
