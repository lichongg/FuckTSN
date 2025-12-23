package androidx.room;

import androidx.annotation.RequiresApi;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Target({ElementType.FIELD, ElementType.METHOD})
@kotlin.annotation.Target(allowedTargets = {AnnotationTarget.FIELD, AnnotationTarget.FUNCTION})
@Retention(RetentionPolicy.CLASS)
@kotlin.annotation.Retention(AnnotationRetention.BINARY)
/* loaded from: D:\Downloads\app\classes.dex */
public @interface ColumnInfo {
    public static final int BINARY = 2;
    public static final int BLOB = 5;

    @NotNull
    public static final Companion Companion = Companion.$$INSTANCE;

    @NotNull
    public static final String INHERIT_FIELD_NAME = "[field-name]";
    public static final int INTEGER = 3;

    @RequiresApi(21)
    public static final int LOCALIZED = 5;
    public static final int NOCASE = 3;
    public static final int REAL = 4;
    public static final int RTRIM = 4;
    public static final int TEXT = 2;
    public static final int UNDEFINED = 1;

    @RequiresApi(21)
    public static final int UNICODE = 6;
    public static final int UNSPECIFIED = 1;

    @NotNull
    public static final String VALUE_UNSPECIFIED = "[value-unspecified]";

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @RequiresApi(21)
    @Retention(RetentionPolicy.CLASS)
    @kotlin.annotation.Retention(AnnotationRetention.BINARY)
    public @interface Collate {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @Retention(RetentionPolicy.CLASS)
    @kotlin.annotation.Retention(AnnotationRetention.BINARY)
    public @interface SQLiteTypeAffinity {
    }

    @Collate
    int collate() default 1;

    String defaultValue() default "[value-unspecified]";

    boolean index() default false;

    String name() default "[field-name]";

    @SQLiteTypeAffinity
    int typeAffinity() default 1;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final int BINARY = 2;
        public static final int BLOB = 5;

        @NotNull
        public static final String INHERIT_FIELD_NAME = "[field-name]";
        public static final int INTEGER = 3;

        @RequiresApi(21)
        public static final int LOCALIZED = 5;
        public static final int NOCASE = 3;
        public static final int REAL = 4;
        public static final int RTRIM = 4;
        public static final int TEXT = 2;
        public static final int UNDEFINED = 1;

        @RequiresApi(21)
        public static final int UNICODE = 6;
        public static final int UNSPECIFIED = 1;

        @NotNull
        public static final String VALUE_UNSPECIFIED = "[value-unspecified]";

        private Companion() {
        }
    }
}
