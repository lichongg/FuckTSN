package androidx.emoji2.viewsintegration;

import android.annotation.SuppressLint;
import android.text.Editable;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.emoji2.text.SpannableBuilder;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
final class EmojiEditableFactory extends Editable.Factory {
    private static final Object INSTANCE_LOCK = new Object();

    @GuardedBy("INSTANCE_LOCK")
    private static volatile Editable.Factory sInstance;

    @Nullable
    private static Class<?> sWatcherClass;

    public static Editable.Factory getInstance() {
        if (sInstance == null) {
            synchronized (INSTANCE_LOCK) {
                try {
                    if (sInstance == null) {
                        sInstance = new EmojiEditableFactory();
                    }
                } finally {
                }
            }
        }
        return sInstance;
    }

    @Override // android.text.Editable.Factory
    public Editable newEditable(@NonNull CharSequence charSequence) {
        Class<?> cls = sWatcherClass;
        return cls != null ? SpannableBuilder.create(cls, charSequence) : super.newEditable(charSequence);
    }

    @SuppressLint({"PrivateApi"})
    private EmojiEditableFactory() {
        try {
            sWatcherClass = Class.forName("android.text.DynamicLayout$ChangeWatcher", false, EmojiEditableFactory.class.getClassLoader());
        } catch (Throwable unused) {
        }
    }
}
