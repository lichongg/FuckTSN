package androidx.emoji2.text;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import androidx.annotation.AnyThread;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.emoji2.text.flatbuffer.MetadataItem;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@AnyThread
@RequiresApi(19)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: D:\Downloads\app\classes.dex */
public class EmojiMetadata {
    public static final int HAS_GLYPH_ABSENT = 1;
    public static final int HAS_GLYPH_EXISTS = 2;
    public static final int HAS_GLYPH_UNKNOWN = 0;
    private static final ThreadLocal<MetadataItem> sMetadataItem = new ThreadLocal<>();
    private volatile int mHasGlyph = 0;
    private final int mIndex;

    @NonNull
    private final MetadataRepo mMetadataRepo;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface HasGlyph {
    }

    @RestrictTo({RestrictTo.Scope.TESTS})
    public void resetHasGlyphCache() {
        this.mHasGlyph = 0;
    }

    private MetadataItem getMetadataItem() {
        ThreadLocal<MetadataItem> threadLocal = sMetadataItem;
        MetadataItem metadataItem = threadLocal.get();
        if (metadataItem == null) {
            metadataItem = new MetadataItem();
            threadLocal.set(metadataItem);
        }
        this.mMetadataRepo.getMetadataList().list(metadataItem, this.mIndex);
        return metadataItem;
    }

    public void draw(@NonNull Canvas canvas, float f6, float f7, @NonNull Paint paint) {
        Typeface typeface = this.mMetadataRepo.getTypeface();
        Typeface typeface2 = paint.getTypeface();
        paint.setTypeface(typeface);
        canvas.drawText(this.mMetadataRepo.getEmojiCharArray(), this.mIndex * 2, 2, f6, f7, paint);
        paint.setTypeface(typeface2);
    }

    @SuppressLint({"KotlinPropertyAccess"})
    public int getHasGlyph() {
        return this.mHasGlyph;
    }

    @NonNull
    public Typeface getTypeface() {
        return this.mMetadataRepo.getTypeface();
    }

    @SuppressLint({"KotlinPropertyAccess"})
    public void setHasGlyph(boolean z5) {
        this.mHasGlyph = z5 ? 2 : 1;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(", id:");
        sb.append(Integer.toHexString(getId()));
        sb.append(", codepoints:");
        int codepointsLength = getCodepointsLength();
        for (int i6 = 0; i6 < codepointsLength; i6++) {
            sb.append(Integer.toHexString(getCodepointAt(i6)));
            sb.append(" ");
        }
        return sb.toString();
    }

    EmojiMetadata(@NonNull MetadataRepo metadataRepo, @IntRange(from = 0) int i6) {
        this.mMetadataRepo = metadataRepo;
        this.mIndex = i6;
    }

    public int getCodepointAt(int i6) {
        return getMetadataItem().codepoints(i6);
    }

    public int getCodepointsLength() {
        return getMetadataItem().codepointsLength();
    }

    public short getCompatAdded() {
        return getMetadataItem().compatAdded();
    }

    public short getHeight() {
        return getMetadataItem().height();
    }

    public int getId() {
        return getMetadataItem().id();
    }

    public short getSdkAdded() {
        return getMetadataItem().sdkAdded();
    }

    public short getWidth() {
        return getMetadataItem().width();
    }

    public boolean isDefaultEmoji() {
        return getMetadataItem().emojiStyle();
    }
}
