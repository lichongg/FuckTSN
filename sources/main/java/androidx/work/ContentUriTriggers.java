package androidx.work;

import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import java.util.HashSet;
import java.util.Set;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: D:\Downloads\app\classes.dex */
public final class ContentUriTriggers {
    private final Set<Trigger> mTriggers = new HashSet();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class Trigger {
        private final boolean mTriggerForDescendants;

        @NonNull
        private final Uri mUri;

        public boolean equals(Object o5) {
            if (this == o5) {
                return true;
            }
            if (o5 != null && Trigger.class == o5.getClass()) {
                Trigger trigger = (Trigger) o5;
                if (this.mTriggerForDescendants == trigger.mTriggerForDescendants && this.mUri.equals(trigger.mUri)) {
                    return true;
                }
            }
            return false;
        }

        @NonNull
        public Uri getUri() {
            return this.mUri;
        }

        public int hashCode() {
            return (this.mUri.hashCode() * 31) + (this.mTriggerForDescendants ? 1 : 0);
        }

        public boolean shouldTriggerForDescendants() {
            return this.mTriggerForDescendants;
        }

        Trigger(@NonNull Uri uri, boolean triggerForDescendants) {
            this.mUri = uri;
            this.mTriggerForDescendants = triggerForDescendants;
        }
    }

    public void add(@NonNull Uri uri, boolean triggerForDescendants) {
        this.mTriggers.add(new Trigger(uri, triggerForDescendants));
    }

    public boolean equals(Object o5) {
        if (this == o5) {
            return true;
        }
        if (o5 == null || ContentUriTriggers.class != o5.getClass()) {
            return false;
        }
        return this.mTriggers.equals(((ContentUriTriggers) o5).mTriggers);
    }

    @NonNull
    public Set<Trigger> getTriggers() {
        return this.mTriggers;
    }

    public int hashCode() {
        return this.mTriggers.hashCode();
    }

    public int size() {
        return this.mTriggers.size();
    }
}
