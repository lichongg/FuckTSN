package androidx.emoji2.text;

import android.annotation.SuppressLint;
import android.graphics.Paint;
import android.text.style.ReplacementSpan;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.util.Preconditions;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(19)
/* loaded from: D:\Downloads\app\classes.dex */
public abstract class EmojiSpan extends ReplacementSpan {

    @NonNull
    private final EmojiMetadata mMetadata;
    private final Paint.FontMetricsInt mTmpFontMetrics = new Paint.FontMetricsInt();
    private short mWidth = -1;
    private short mHeight = -1;
    private float mRatio = 1.0f;

    @RestrictTo({RestrictTo.Scope.TESTS})
    public final int getHeight() {
        return this.mHeight;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final EmojiMetadata getMetadata() {
        return this.mMetadata;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    final float getRatio() {
        return this.mRatio;
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(@NonNull Paint paint, @SuppressLint({"UnknownNullness"}) CharSequence charSequence, int i6, int i7, @Nullable Paint.FontMetricsInt fontMetricsInt) {
        paint.getFontMetricsInt(this.mTmpFontMetrics);
        Paint.FontMetricsInt fontMetricsInt2 = this.mTmpFontMetrics;
        this.mRatio = (Math.abs(fontMetricsInt2.descent - fontMetricsInt2.ascent) * 1.0f) / this.mMetadata.getHeight();
        this.mHeight = (short) (this.mMetadata.getHeight() * this.mRatio);
        short width = (short) (this.mMetadata.getWidth() * this.mRatio);
        this.mWidth = width;
        if (fontMetricsInt != null) {
            Paint.FontMetricsInt fontMetricsInt3 = this.mTmpFontMetrics;
            fontMetricsInt.ascent = fontMetricsInt3.ascent;
            fontMetricsInt.descent = fontMetricsInt3.descent;
            fontMetricsInt.top = fontMetricsInt3.top;
            fontMetricsInt.bottom = fontMetricsInt3.bottom;
        }
        return width;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    final int getWidth() {
        return this.mWidth;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    EmojiSpan(@NonNull EmojiMetadata emojiMetadata) {
        Preconditions.checkNotNull(emojiMetadata, "metadata cannot be null");
        this.mMetadata = emojiMetadata;
    }

    @RestrictTo({RestrictTo.Scope.TESTS})
    public final int getId() {
        return getMetadata().getId();
    }
}
