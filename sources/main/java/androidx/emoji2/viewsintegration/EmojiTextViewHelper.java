package androidx.emoji2.viewsintegration;

import android.text.InputFilter;
import android.text.method.PasswordTransformationMethod;
import android.text.method.TransformationMethod;
import android.util.SparseArray;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.util.Preconditions;
import androidx.emoji2.text.EmojiCompat;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public final class EmojiTextViewHelper {
    private final HelperInternal mHelper;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @RequiresApi(19)
    private static class HelperInternal19 extends HelperInternal {
        private final EmojiInputFilter mEmojiInputFilter;
        private boolean mEnabled = true;
        private final TextView mTextView;

        @NonNull
        private InputFilter[] addEmojiInputFilterIfMissing(@NonNull InputFilter[] inputFilterArr) {
            int length = inputFilterArr.length;
            for (InputFilter inputFilter : inputFilterArr) {
                if (inputFilter == this.mEmojiInputFilter) {
                    return inputFilterArr;
                }
            }
            InputFilter[] inputFilterArr2 = new InputFilter[inputFilterArr.length + 1];
            System.arraycopy(inputFilterArr, 0, inputFilterArr2, 0, length);
            inputFilterArr2[length] = this.mEmojiInputFilter;
            return inputFilterArr2;
        }

        private SparseArray<InputFilter> getEmojiInputFilterPositionArray(@NonNull InputFilter[] inputFilterArr) {
            SparseArray<InputFilter> sparseArray = new SparseArray<>(1);
            for (int i6 = 0; i6 < inputFilterArr.length; i6++) {
                InputFilter inputFilter = inputFilterArr[i6];
                if (inputFilter instanceof EmojiInputFilter) {
                    sparseArray.put(i6, inputFilter);
                }
            }
            return sparseArray;
        }

        @Nullable
        private TransformationMethod unwrapForDisabled(@Nullable TransformationMethod transformationMethod) {
            return transformationMethod instanceof EmojiTransformationMethod ? ((EmojiTransformationMethod) transformationMethod).getOriginalTransformationMethod() : transformationMethod;
        }

        private void updateFilters() {
            this.mTextView.setFilters(getFilters(this.mTextView.getFilters()));
        }

        @NonNull
        private TransformationMethod wrapForEnabled(@Nullable TransformationMethod transformationMethod) {
            return transformationMethod instanceof EmojiTransformationMethod ? transformationMethod : transformationMethod instanceof PasswordTransformationMethod ? transformationMethod : new EmojiTransformationMethod(transformationMethod);
        }

        @Override // androidx.emoji2.viewsintegration.EmojiTextViewHelper.HelperInternal
        @NonNull
        InputFilter[] getFilters(@NonNull InputFilter[] inputFilterArr) {
            return !this.mEnabled ? removeEmojiInputFilterIfPresent(inputFilterArr) : addEmojiInputFilterIfMissing(inputFilterArr);
        }

        @Override // androidx.emoji2.viewsintegration.EmojiTextViewHelper.HelperInternal
        public boolean isEnabled() {
            return this.mEnabled;
        }

        @Override // androidx.emoji2.viewsintegration.EmojiTextViewHelper.HelperInternal
        void setAllCaps(boolean z5) {
            if (z5) {
                updateTransformationMethod();
            }
        }

        @Override // androidx.emoji2.viewsintegration.EmojiTextViewHelper.HelperInternal
        void setEnabled(boolean z5) {
            this.mEnabled = z5;
            updateTransformationMethod();
            updateFilters();
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY})
        void setEnabledUnsafe(boolean z5) {
            this.mEnabled = z5;
        }

        @Override // androidx.emoji2.viewsintegration.EmojiTextViewHelper.HelperInternal
        void updateTransformationMethod() {
            this.mTextView.setTransformationMethod(wrapTransformationMethod(this.mTextView.getTransformationMethod()));
        }

        @Override // androidx.emoji2.viewsintegration.EmojiTextViewHelper.HelperInternal
        @Nullable
        TransformationMethod wrapTransformationMethod(@Nullable TransformationMethod transformationMethod) {
            return this.mEnabled ? wrapForEnabled(transformationMethod) : unwrapForDisabled(transformationMethod);
        }

        HelperInternal19(TextView textView) {
            this.mTextView = textView;
            this.mEmojiInputFilter = new EmojiInputFilter(textView);
        }

        @NonNull
        private InputFilter[] removeEmojiInputFilterIfPresent(@NonNull InputFilter[] inputFilterArr) {
            SparseArray<InputFilter> emojiInputFilterPositionArray = getEmojiInputFilterPositionArray(inputFilterArr);
            if (emojiInputFilterPositionArray.size() == 0) {
                return inputFilterArr;
            }
            int length = inputFilterArr.length;
            InputFilter[] inputFilterArr2 = new InputFilter[inputFilterArr.length - emojiInputFilterPositionArray.size()];
            int i6 = 0;
            for (int i7 = 0; i7 < length; i7++) {
                if (emojiInputFilterPositionArray.indexOfKey(i7) < 0) {
                    inputFilterArr2[i6] = inputFilterArr[i7];
                    i6++;
                }
            }
            return inputFilterArr2;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @RequiresApi(19)
    private static class SkippingHelper19 extends HelperInternal {
        private final HelperInternal19 mHelperDelegate;

        @Override // androidx.emoji2.viewsintegration.EmojiTextViewHelper.HelperInternal
        public boolean isEnabled() {
            return this.mHelperDelegate.isEnabled();
        }

        SkippingHelper19(TextView textView) {
            this.mHelperDelegate = new HelperInternal19(textView);
        }

        private boolean skipBecauseEmojiCompatNotInitialized() {
            return !EmojiCompat.isConfigured();
        }

        @Override // androidx.emoji2.viewsintegration.EmojiTextViewHelper.HelperInternal
        @NonNull
        InputFilter[] getFilters(@NonNull InputFilter[] inputFilterArr) {
            if (skipBecauseEmojiCompatNotInitialized()) {
                return inputFilterArr;
            }
            return this.mHelperDelegate.getFilters(inputFilterArr);
        }

        @Override // androidx.emoji2.viewsintegration.EmojiTextViewHelper.HelperInternal
        void setAllCaps(boolean z5) {
            if (skipBecauseEmojiCompatNotInitialized()) {
                return;
            }
            this.mHelperDelegate.setAllCaps(z5);
        }

        @Override // androidx.emoji2.viewsintegration.EmojiTextViewHelper.HelperInternal
        void setEnabled(boolean z5) {
            if (skipBecauseEmojiCompatNotInitialized()) {
                this.mHelperDelegate.setEnabledUnsafe(z5);
            } else {
                this.mHelperDelegate.setEnabled(z5);
            }
        }

        @Override // androidx.emoji2.viewsintegration.EmojiTextViewHelper.HelperInternal
        void updateTransformationMethod() {
            if (skipBecauseEmojiCompatNotInitialized()) {
                return;
            }
            this.mHelperDelegate.updateTransformationMethod();
        }

        @Override // androidx.emoji2.viewsintegration.EmojiTextViewHelper.HelperInternal
        @Nullable
        TransformationMethod wrapTransformationMethod(@Nullable TransformationMethod transformationMethod) {
            if (skipBecauseEmojiCompatNotInitialized()) {
                return transformationMethod;
            }
            return this.mHelperDelegate.wrapTransformationMethod(transformationMethod);
        }
    }

    public EmojiTextViewHelper(@NonNull TextView textView) {
        this(textView, true);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class HelperInternal {
        public boolean isEnabled() {
            return false;
        }

        HelperInternal() {
        }

        void updateTransformationMethod() {
        }

        @NonNull
        InputFilter[] getFilters(@NonNull InputFilter[] inputFilterArr) {
            return inputFilterArr;
        }

        void setAllCaps(boolean z5) {
        }

        void setEnabled(boolean z5) {
        }

        @Nullable
        TransformationMethod wrapTransformationMethod(@Nullable TransformationMethod transformationMethod) {
            return transformationMethod;
        }
    }

    public EmojiTextViewHelper(@NonNull TextView textView, boolean z5) {
        Preconditions.checkNotNull(textView, "textView cannot be null");
        if (z5) {
            this.mHelper = new HelperInternal19(textView);
        } else {
            this.mHelper = new SkippingHelper19(textView);
        }
    }

    @NonNull
    public InputFilter[] getFilters(@NonNull InputFilter[] inputFilterArr) {
        return this.mHelper.getFilters(inputFilterArr);
    }

    public boolean isEnabled() {
        return this.mHelper.isEnabled();
    }

    public void setAllCaps(boolean z5) {
        this.mHelper.setAllCaps(z5);
    }

    public void setEnabled(boolean z5) {
        this.mHelper.setEnabled(z5);
    }

    public void updateTransformationMethod() {
        this.mHelper.updateTransformationMethod();
    }

    @Nullable
    public TransformationMethod wrapTransformationMethod(@Nullable TransformationMethod transformationMethod) {
        return this.mHelper.wrapTransformationMethod(transformationMethod);
    }
}
