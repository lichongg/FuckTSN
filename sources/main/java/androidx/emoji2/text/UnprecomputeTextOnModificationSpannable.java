package androidx.emoji2.text;

import android.os.Build;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.core.text.PrecomputedTextCompat;
import androidx.core.text.i;
import java.util.stream.IntStream;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
class UnprecomputeTextOnModificationSpannable implements Spannable {

    @NonNull
    private Spannable mDelegate;
    private boolean mSafeToWrite = false;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class PrecomputedTextDetector {
        boolean isPrecomputedText(CharSequence charSequence) {
            return charSequence instanceof PrecomputedTextCompat;
        }

        PrecomputedTextDetector() {
        }
    }

    UnprecomputeTextOnModificationSpannable(@NonNull Spannable spannable) {
        this.mDelegate = spannable;
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @RequiresApi(24)
    private static class CharSequenceHelper_API24 {
        private CharSequenceHelper_API24() {
        }

        static IntStream chars(CharSequence charSequence) {
            IntStream chars;
            chars = charSequence.chars();
            return chars;
        }

        static IntStream codePoints(CharSequence charSequence) {
            IntStream codePoints;
            codePoints = charSequence.codePoints();
            return codePoints;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @RequiresApi(28)
    static class PrecomputedTextDetector_28 extends PrecomputedTextDetector {
        PrecomputedTextDetector_28() {
        }

        @Override // androidx.emoji2.text.UnprecomputeTextOnModificationSpannable.PrecomputedTextDetector
        boolean isPrecomputedText(CharSequence charSequence) {
            if (!i.a(charSequence) && !(charSequence instanceof PrecomputedTextCompat)) {
                return false;
            }
            return true;
        }
    }

    private void ensureSafeWrites() {
        Spannable spannable = this.mDelegate;
        if (!this.mSafeToWrite && precomputedTextDetector().isPrecomputedText(spannable)) {
            this.mDelegate = new SpannableString(spannable);
        }
        this.mSafeToWrite = true;
    }

    static PrecomputedTextDetector precomputedTextDetector() {
        return Build.VERSION.SDK_INT < 28 ? new PrecomputedTextDetector() : new PrecomputedTextDetector_28();
    }

    @Override // java.lang.CharSequence
    public char charAt(int i6) {
        return this.mDelegate.charAt(i6);
    }

    @Override // java.lang.CharSequence
    @NonNull
    @RequiresApi(api = 24)
    public IntStream chars() {
        return CharSequenceHelper_API24.chars(this.mDelegate);
    }

    @Override // java.lang.CharSequence
    @NonNull
    @RequiresApi(api = 24)
    public IntStream codePoints() {
        return CharSequenceHelper_API24.codePoints(this.mDelegate);
    }

    @Override // android.text.Spanned
    public int getSpanEnd(Object obj) {
        return this.mDelegate.getSpanEnd(obj);
    }

    @Override // android.text.Spanned
    public int getSpanFlags(Object obj) {
        return this.mDelegate.getSpanFlags(obj);
    }

    @Override // android.text.Spanned
    public int getSpanStart(Object obj) {
        return this.mDelegate.getSpanStart(obj);
    }

    @Override // android.text.Spanned
    public <T> T[] getSpans(int i6, int i7, Class<T> cls) {
        return (T[]) this.mDelegate.getSpans(i6, i7, cls);
    }

    Spannable getUnwrappedSpannable() {
        return this.mDelegate;
    }

    @Override // java.lang.CharSequence
    public int length() {
        return this.mDelegate.length();
    }

    @Override // android.text.Spanned
    public int nextSpanTransition(int i6, int i7, Class cls) {
        return this.mDelegate.nextSpanTransition(i6, i7, cls);
    }

    @Override // java.lang.CharSequence
    @NonNull
    public CharSequence subSequence(int i6, int i7) {
        return this.mDelegate.subSequence(i6, i7);
    }

    @Override // java.lang.CharSequence
    @NonNull
    public String toString() {
        return this.mDelegate.toString();
    }

    @Override // android.text.Spannable
    public void removeSpan(Object obj) {
        ensureSafeWrites();
        this.mDelegate.removeSpan(obj);
    }

    @Override // android.text.Spannable
    public void setSpan(Object obj, int i6, int i7, int i8) {
        ensureSafeWrites();
        this.mDelegate.setSpan(obj, i6, i7, i8);
    }

    UnprecomputeTextOnModificationSpannable(@NonNull Spanned spanned) {
        this.mDelegate = new SpannableString(spanned);
    }

    UnprecomputeTextOnModificationSpannable(@NonNull CharSequence charSequence) {
        this.mDelegate = new SpannableString(charSequence);
    }
}
