package pl.droidsonroids.gif;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.DrawableRes;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RawRes;
import java.io.File;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.Locale;
import pl.droidsonroids.gif.annotations.Beta;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class GifAnimationMetaData implements Serializable, Parcelable {
    public static final Parcelable.Creator<GifAnimationMetaData> CREATOR = new a();
    private static final long serialVersionUID = 5692363926580237325L;
    private final int mDuration;
    private final int mHeight;
    private final int mImageCount;
    private final int mLoopCount;
    private final long mMetadataBytesCount;
    private final long mPixelsBytesCount;
    private final int mWidth;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class a implements Parcelable.Creator<GifAnimationMetaData> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public GifAnimationMetaData createFromParcel(Parcel parcel) {
            return new GifAnimationMetaData(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public GifAnimationMetaData[] newArray(int i6) {
            return new GifAnimationMetaData[i6];
        }

        a() {
        }
    }

    /* synthetic */ GifAnimationMetaData(Parcel parcel, a aVar) {
        this(parcel);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Beta
    public long getDrawableAllocationByteCount(@Nullable e eVar, @IntRange(from = 1, to = 65535) int i6) {
        if (i6 >= 1 && i6 <= 65535) {
            return (this.mPixelsBytesCount / (i6 * i6)) + ((eVar == null || eVar.f51808f.isRecycled()) ? ((this.mWidth * this.mHeight) * 4) / r6 : eVar.f51808f.getAllocationByteCount());
        }
        throw new IllegalStateException("Sample size " + i6 + " out of range <1, " + kotlin.jvm.internal.q.f44042c + ">");
    }

    public GifAnimationMetaData(@NonNull Resources resources, @DrawableRes @RawRes int i6) throws Resources.NotFoundException, IOException {
        this(resources.openRawResourceFd(i6));
    }

    public long getAllocationByteCount() {
        return this.mPixelsBytesCount;
    }

    public int getDuration() {
        return this.mDuration;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public int getLoopCount() {
        return this.mLoopCount;
    }

    public long getMetadataAllocationByteCount() {
        return this.mMetadataBytesCount;
    }

    public int getNumberOfFrames() {
        return this.mImageCount;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public boolean isAnimated() {
        return this.mImageCount > 1 && this.mDuration > 0;
    }

    @NonNull
    public String toString() {
        int i6 = this.mLoopCount;
        String format = String.format(Locale.ENGLISH, "GIF: size: %dx%d, frames: %d, loops: %s, duration: %d", Integer.valueOf(this.mWidth), Integer.valueOf(this.mHeight), Integer.valueOf(this.mImageCount), i6 == 0 ? "Infinity" : Integer.toString(i6), Integer.valueOf(this.mDuration));
        if (!isAnimated()) {
            return format;
        }
        return "Animated " + format;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i6) {
        parcel.writeInt(this.mLoopCount);
        parcel.writeInt(this.mDuration);
        parcel.writeInt(this.mHeight);
        parcel.writeInt(this.mWidth);
        parcel.writeInt(this.mImageCount);
        parcel.writeLong(this.mMetadataBytesCount);
        parcel.writeLong(this.mPixelsBytesCount);
    }

    public GifAnimationMetaData(@NonNull AssetManager assetManager, @NonNull String str) throws IOException {
        this(assetManager.openFd(str));
    }

    public GifAnimationMetaData(@NonNull String str) throws IOException {
        this(new GifInfoHandle(str));
    }

    public GifAnimationMetaData(@NonNull File file) throws IOException {
        this(file.getPath());
    }

    public GifAnimationMetaData(@NonNull InputStream inputStream) throws IOException {
        this(new GifInfoHandle(inputStream));
    }

    public GifAnimationMetaData(@NonNull AssetFileDescriptor assetFileDescriptor) throws IOException {
        this(new GifInfoHandle(assetFileDescriptor));
    }

    public GifAnimationMetaData(@NonNull FileDescriptor fileDescriptor) throws IOException {
        this(new GifInfoHandle(fileDescriptor));
    }

    public GifAnimationMetaData(@NonNull byte[] bArr) throws IOException {
        this(new GifInfoHandle(bArr));
    }

    public GifAnimationMetaData(@NonNull ByteBuffer byteBuffer) throws IOException {
        this(new GifInfoHandle(byteBuffer));
    }

    public GifAnimationMetaData(@Nullable ContentResolver contentResolver, @NonNull Uri uri) throws IOException {
        this(GifInfoHandle.y(contentResolver, uri));
    }

    private GifAnimationMetaData(GifInfoHandle gifInfoHandle) {
        this.mLoopCount = gifInfoHandle.j();
        this.mDuration = gifInfoHandle.g();
        this.mWidth = gifInfoHandle.q();
        this.mHeight = gifInfoHandle.i();
        this.mImageCount = gifInfoHandle.n();
        this.mMetadataBytesCount = gifInfoHandle.k();
        this.mPixelsBytesCount = gifInfoHandle.b();
        gifInfoHandle.A();
    }

    private GifAnimationMetaData(Parcel parcel) {
        this.mLoopCount = parcel.readInt();
        this.mDuration = parcel.readInt();
        this.mHeight = parcel.readInt();
        this.mWidth = parcel.readInt();
        this.mImageCount = parcel.readInt();
        this.mMetadataBytesCount = parcel.readLong();
        this.mPixelsBytesCount = parcel.readLong();
    }
}
