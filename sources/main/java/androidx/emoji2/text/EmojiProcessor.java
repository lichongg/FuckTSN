package androidx.emoji2.text;

import android.text.Editable;
import android.text.Selection;
import android.text.Spannable;
import android.text.method.MetaKeyKeyListener;
import android.view.KeyEvent;
import android.view.inputmethod.InputConnection;
import androidx.annotation.AnyThread;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.emoji2.text.EmojiCompat;
import androidx.emoji2.text.MetadataRepo;
import java.util.Arrays;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@AnyThread
@RequiresApi(19)
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: D:\Downloads\app\classes.dex */
final class EmojiProcessor {
    private static final int ACTION_ADVANCE_BOTH = 1;
    private static final int ACTION_ADVANCE_END = 2;
    private static final int ACTION_FLUSH = 3;

    @Nullable
    private final int[] mEmojiAsDefaultStyleExceptions;

    @NonNull
    private EmojiCompat.GlyphChecker mGlyphChecker;

    @NonNull
    private final MetadataRepo mMetadataRepo;

    @NonNull
    private final EmojiCompat.SpanFactory mSpanFactory;
    private final boolean mUseEmojiAsDefaultStyle;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class ProcessorSm {
        private static final int STATE_DEFAULT = 1;
        private static final int STATE_WALKING = 2;
        private int mCurrentDepth;
        private MetadataRepo.Node mCurrentNode;
        private final int[] mEmojiAsDefaultStyleExceptions;
        private MetadataRepo.Node mFlushNode;
        private int mLastCodepoint;
        private final MetadataRepo.Node mRootNode;
        private int mState = 1;
        private final boolean mUseEmojiAsDefaultStyle;

        private int reset() {
            this.mState = 1;
            this.mCurrentNode = this.mRootNode;
            this.mCurrentDepth = 0;
            return 1;
        }

        private boolean shouldUseEmojiPresentationStyleForSingleCodepoint() {
            if (this.mCurrentNode.getData().isDefaultEmoji() || isEmojiStyle(this.mLastCodepoint)) {
                return true;
            }
            if (this.mUseEmojiAsDefaultStyle) {
                if (this.mEmojiAsDefaultStyleExceptions == null) {
                    return true;
                }
                if (Arrays.binarySearch(this.mEmojiAsDefaultStyleExceptions, this.mCurrentNode.getData().getCodepointAt(0)) < 0) {
                    return true;
                }
            }
            return false;
        }

        int check(int i6) {
            MetadataRepo.Node node = this.mCurrentNode.get(i6);
            int i7 = 2;
            if (this.mState != 2) {
                if (node == null) {
                    i7 = reset();
                } else {
                    this.mState = 2;
                    this.mCurrentNode = node;
                    this.mCurrentDepth = 1;
                }
            } else if (node != null) {
                this.mCurrentNode = node;
                this.mCurrentDepth++;
            } else if (isTextStyle(i6)) {
                i7 = reset();
            } else if (!isEmojiStyle(i6)) {
                if (this.mCurrentNode.getData() != null) {
                    i7 = 3;
                    if (this.mCurrentDepth != 1) {
                        this.mFlushNode = this.mCurrentNode;
                        reset();
                    } else if (shouldUseEmojiPresentationStyleForSingleCodepoint()) {
                        this.mFlushNode = this.mCurrentNode;
                        reset();
                    } else {
                        i7 = reset();
                    }
                } else {
                    i7 = reset();
                }
            }
            this.mLastCodepoint = i6;
            return i7;
        }

        EmojiMetadata getCurrentMetadata() {
            return this.mCurrentNode.getData();
        }

        EmojiMetadata getFlushMetadata() {
            return this.mFlushNode.getData();
        }

        boolean isInFlushableState() {
            if (this.mState != 2 || this.mCurrentNode.getData() == null) {
                return false;
            }
            return this.mCurrentDepth > 1 || shouldUseEmojiPresentationStyleForSingleCodepoint();
        }

        ProcessorSm(MetadataRepo.Node node, boolean z5, int[] iArr) {
            this.mRootNode = node;
            this.mCurrentNode = node;
            this.mUseEmojiAsDefaultStyle = z5;
            this.mEmojiAsDefaultStyleExceptions = iArr;
        }

        private static boolean isEmojiStyle(int i6) {
            if (i6 == 65039) {
                return true;
            }
            return false;
        }

        private static boolean isTextStyle(int i6) {
            if (i6 == 65038) {
                return true;
            }
            return false;
        }
    }

    static boolean handleDeleteSurroundingText(@NonNull InputConnection inputConnection, @NonNull Editable editable, @IntRange(from = 0) int i6, @IntRange(from = 0) int i7, boolean z5) {
        int max;
        int min;
        if (editable != null && inputConnection != null && i6 >= 0 && i7 >= 0) {
            int selectionStart = Selection.getSelectionStart(editable);
            int selectionEnd = Selection.getSelectionEnd(editable);
            if (hasInvalidSelection(selectionStart, selectionEnd)) {
                return false;
            }
            if (z5) {
                max = CodepointIndexFinder.findIndexBackward(editable, selectionStart, Math.max(i6, 0));
                min = CodepointIndexFinder.findIndexForward(editable, selectionEnd, Math.max(i7, 0));
                if (max == -1 || min == -1) {
                    return false;
                }
            } else {
                max = Math.max(selectionStart - i6, 0);
                min = Math.min(selectionEnd + i7, editable.length());
            }
            EmojiSpan[] emojiSpanArr = (EmojiSpan[]) editable.getSpans(max, min, EmojiSpan.class);
            if (emojiSpanArr != null && emojiSpanArr.length > 0) {
                for (EmojiSpan emojiSpan : emojiSpanArr) {
                    int spanStart = editable.getSpanStart(emojiSpan);
                    int spanEnd = editable.getSpanEnd(emojiSpan);
                    max = Math.min(spanStart, max);
                    min = Math.max(spanEnd, min);
                }
                int max2 = Math.max(max, 0);
                int min2 = Math.min(min, editable.length());
                inputConnection.beginBatchEdit();
                editable.delete(max2, min2);
                inputConnection.endBatchEdit();
                return true;
            }
        }
        return false;
    }

    private static boolean hasInvalidSelection(int i6, int i7) {
        return i6 == -1 || i7 == -1 || i6 != i7;
    }

    int getEmojiMatch(@NonNull CharSequence charSequence) {
        return getEmojiMatch(charSequence, this.mMetadataRepo.getMetadataVersion());
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @RequiresApi(19)
    private static final class CodepointIndexFinder {
        private static final int INVALID_INDEX = -1;

        private CodepointIndexFinder() {
        }

        static int findIndexBackward(CharSequence charSequence, int i6, int i7) {
            int length = charSequence.length();
            if (i6 < 0 || length < i6 || i7 < 0) {
                return -1;
            }
            while (true) {
                boolean z5 = false;
                while (i7 != 0) {
                    i6--;
                    if (i6 < 0) {
                        if (z5) {
                            return -1;
                        }
                        return 0;
                    }
                    char charAt = charSequence.charAt(i6);
                    if (z5) {
                        if (!Character.isHighSurrogate(charAt)) {
                            return -1;
                        }
                        i7--;
                    } else if (!Character.isSurrogate(charAt)) {
                        i7--;
                    } else {
                        if (Character.isHighSurrogate(charAt)) {
                            return -1;
                        }
                        z5 = true;
                    }
                }
                return i6;
            }
        }

        static int findIndexForward(CharSequence charSequence, int i6, int i7) {
            int length = charSequence.length();
            if (i6 < 0 || length < i6 || i7 < 0) {
                return -1;
            }
            while (true) {
                boolean z5 = false;
                while (i7 != 0) {
                    if (i6 >= length) {
                        if (z5) {
                            return -1;
                        }
                        return length;
                    }
                    char charAt = charSequence.charAt(i6);
                    if (z5) {
                        if (!Character.isLowSurrogate(charAt)) {
                            return -1;
                        }
                        i7--;
                        i6++;
                    } else if (!Character.isSurrogate(charAt)) {
                        i7--;
                        i6++;
                    } else {
                        if (Character.isLowSurrogate(charAt)) {
                            return -1;
                        }
                        i6++;
                        z5 = true;
                    }
                }
                return i6;
            }
        }
    }

    private void addEmoji(@NonNull Spannable spannable, EmojiMetadata emojiMetadata, int i6, int i7) {
        spannable.setSpan(this.mSpanFactory.createSpan(emojiMetadata), i6, i7, 33);
    }

    static boolean handleOnKeyDown(@NonNull Editable editable, int i6, @NonNull KeyEvent keyEvent) {
        if (!(i6 != 67 ? i6 != 112 ? false : delete(editable, keyEvent, true) : delete(editable, keyEvent, false))) {
            return false;
        }
        MetaKeyKeyListener.adjustMetaAfterKeypress(editable);
        return true;
    }

    int getEmojiMatch(@NonNull CharSequence charSequence, int i6) {
        ProcessorSm processorSm = new ProcessorSm(this.mMetadataRepo.getRootNode(), this.mUseEmojiAsDefaultStyle, this.mEmojiAsDefaultStyleExceptions);
        int length = charSequence.length();
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        while (i7 < length) {
            int codePointAt = Character.codePointAt(charSequence, i7);
            int check = processorSm.check(codePointAt);
            EmojiMetadata currentMetadata = processorSm.getCurrentMetadata();
            if (check == 1) {
                i7 += Character.charCount(codePointAt);
                i9 = 0;
            } else if (check == 2) {
                i7 += Character.charCount(codePointAt);
            } else if (check == 3) {
                currentMetadata = processorSm.getFlushMetadata();
                if (currentMetadata.getCompatAdded() <= i6) {
                    i8++;
                }
            }
            if (currentMetadata != null && currentMetadata.getCompatAdded() <= i6) {
                i9++;
            }
        }
        if (i8 != 0) {
            return 2;
        }
        if (!processorSm.isInFlushableState() || processorSm.getCurrentMetadata().getCompatAdded() > i6) {
            return i9 == 0 ? 0 : 2;
        }
        return 1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:98:0x0124, code lost:
    
        r12 = (androidx.emoji2.text.SpannableBuilder) r11;
     */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0049 A[Catch: all -> 0x002a, TryCatch #0 {all -> 0x002a, blocks: (B:101:0x000e, B:104:0x0013, B:106:0x0017, B:108:0x0024, B:9:0x003a, B:11:0x0042, B:13:0x0045, B:15:0x0049, B:17:0x0055, B:19:0x0058, B:23:0x0065, B:29:0x0074, B:30:0x0080, B:34:0x009b, B:60:0x00ab, B:64:0x00b7, B:65:0x00c1, B:47:0x00cb, B:50:0x00d2, B:37:0x00d7, B:39:0x00e2, B:71:0x00e9, B:75:0x00f3, B:78:0x00ff, B:79:0x0104, B:81:0x010d, B:6:0x002f), top: B:100:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00d7 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00a2 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00ff A[Catch: all -> 0x002a, TryCatch #0 {all -> 0x002a, blocks: (B:101:0x000e, B:104:0x0013, B:106:0x0017, B:108:0x0024, B:9:0x003a, B:11:0x0042, B:13:0x0045, B:15:0x0049, B:17:0x0055, B:19:0x0058, B:23:0x0065, B:29:0x0074, B:30:0x0080, B:34:0x009b, B:60:0x00ab, B:64:0x00b7, B:65:0x00c1, B:47:0x00cb, B:50:0x00d2, B:37:0x00d7, B:39:0x00e2, B:71:0x00e9, B:75:0x00f3, B:78:0x00ff, B:79:0x0104, B:81:0x010d, B:6:0x002f), top: B:100:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x010d A[Catch: all -> 0x002a, TRY_LEAVE, TryCatch #0 {all -> 0x002a, blocks: (B:101:0x000e, B:104:0x0013, B:106:0x0017, B:108:0x0024, B:9:0x003a, B:11:0x0042, B:13:0x0045, B:15:0x0049, B:17:0x0055, B:19:0x0058, B:23:0x0065, B:29:0x0074, B:30:0x0080, B:34:0x009b, B:60:0x00ab, B:64:0x00b7, B:65:0x00c1, B:47:0x00cb, B:50:0x00d2, B:37:0x00d7, B:39:0x00e2, B:71:0x00e9, B:75:0x00f3, B:78:0x00ff, B:79:0x0104, B:81:0x010d, B:6:0x002f), top: B:100:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0119  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    java.lang.CharSequence process(@androidx.annotation.NonNull java.lang.CharSequence r11, @androidx.annotation.IntRange(from = 0) int r12, @androidx.annotation.IntRange(from = 0) int r13, @androidx.annotation.IntRange(from = 0) int r14, boolean r15) {
        /*
            Method dump skipped, instructions count: 305
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.emoji2.text.EmojiProcessor.process(java.lang.CharSequence, int, int, int, boolean):java.lang.CharSequence");
    }

    EmojiProcessor(@NonNull MetadataRepo metadataRepo, @NonNull EmojiCompat.SpanFactory spanFactory, @NonNull EmojiCompat.GlyphChecker glyphChecker, boolean z5, @Nullable int[] iArr) {
        this.mSpanFactory = spanFactory;
        this.mMetadataRepo = metadataRepo;
        this.mGlyphChecker = glyphChecker;
        this.mUseEmojiAsDefaultStyle = z5;
        this.mEmojiAsDefaultStyleExceptions = iArr;
    }

    private static boolean delete(@NonNull Editable editable, @NonNull KeyEvent keyEvent, boolean z5) {
        EmojiSpan[] emojiSpanArr;
        if (hasModifiers(keyEvent)) {
            return false;
        }
        int selectionStart = Selection.getSelectionStart(editable);
        int selectionEnd = Selection.getSelectionEnd(editable);
        if (!hasInvalidSelection(selectionStart, selectionEnd) && (emojiSpanArr = (EmojiSpan[]) editable.getSpans(selectionStart, selectionEnd, EmojiSpan.class)) != null && emojiSpanArr.length > 0) {
            for (EmojiSpan emojiSpan : emojiSpanArr) {
                int spanStart = editable.getSpanStart(emojiSpan);
                int spanEnd = editable.getSpanEnd(emojiSpan);
                if ((z5 && spanStart == selectionStart) || ((!z5 && spanEnd == selectionStart) || (selectionStart > spanStart && selectionStart < spanEnd))) {
                    editable.delete(spanStart, spanEnd);
                    return true;
                }
            }
        }
        return false;
    }

    private boolean hasGlyph(CharSequence charSequence, int i6, int i7, EmojiMetadata emojiMetadata) {
        if (emojiMetadata.getHasGlyph() == 0) {
            emojiMetadata.setHasGlyph(this.mGlyphChecker.hasGlyph(charSequence, i6, i7, emojiMetadata.getSdkAdded()));
        }
        if (emojiMetadata.getHasGlyph() == 2) {
            return true;
        }
        return false;
    }

    private static boolean hasModifiers(@NonNull KeyEvent keyEvent) {
        return !KeyEvent.metaStateHasNoModifiers(keyEvent.getMetaState());
    }
}
