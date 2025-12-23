package androidx.emoji2.text;

import android.os.Build;
import android.text.TextPaint;
import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.core.graphics.PaintCompat;
import androidx.emoji2.text.EmojiCompat;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@AnyThread
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: D:\Downloads\app\classes.dex */
class DefaultGlyphChecker implements EmojiCompat.GlyphChecker {
    private static final int PAINT_TEXT_SIZE = 10;
    private static final ThreadLocal<StringBuilder> sStringBuilder = new ThreadLocal<>();
    private final TextPaint mTextPaint;

    private static StringBuilder getStringBuilder() {
        ThreadLocal<StringBuilder> threadLocal = sStringBuilder;
        if (threadLocal.get() == null) {
            threadLocal.set(new StringBuilder());
        }
        return threadLocal.get();
    }

    @Override // androidx.emoji2.text.EmojiCompat.GlyphChecker
    public boolean hasGlyph(@NonNull CharSequence charSequence, int i6, int i7, int i8) {
        int i9 = Build.VERSION.SDK_INT;
        if (i9 < 23 && i8 > i9) {
            return false;
        }
        StringBuilder stringBuilder = getStringBuilder();
        stringBuilder.setLength(0);
        while (i6 < i7) {
            stringBuilder.append(charSequence.charAt(i6));
            i6++;
        }
        return PaintCompat.hasGlyph(this.mTextPaint, stringBuilder.toString());
    }

    DefaultGlyphChecker() {
        TextPaint textPaint = new TextPaint();
        this.mTextPaint = textPaint;
        textPaint.setTextSize(10.0f);
    }
}
