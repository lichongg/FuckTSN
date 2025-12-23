package androidx.room;

import kotlin.Deprecated;
import kotlin.ReplaceWith;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public class RoomWarnings {

    @NotNull
    public static final String AMBIGUOUS_COLUMN_IN_RESULT = "ROOM_AMBIGUOUS_COLUMN_IN_RESULT";

    @NotNull
    public static final String CANNOT_CREATE_VERIFICATION_DATABASE = "ROOM_CANNOT_CREATE_VERIFICATION_DATABASE";

    @NotNull
    public static final String CURSOR_MISMATCH = "ROOM_CURSOR_MISMATCH";

    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    public static final String DEFAULT_CONSTRUCTOR = "ROOM_DEFAULT_CONSTRUCTOR";

    @NotNull
    public static final String DOES_NOT_IMPLEMENT_EQUALS_HASHCODE = "ROOM_TYPE_DOES_NOT_IMPLEMENT_EQUALS_HASHCODE";

    @NotNull
    public static final String INDEX_FROM_EMBEDDED_ENTITY_IS_DROPPED = "ROOM_EMBEDDED_ENTITY_INDEX_IS_DROPPED";

    @NotNull
    public static final String INDEX_FROM_EMBEDDED_FIELD_IS_DROPPED = "ROOM_EMBEDDED_INDEX_IS_DROPPED";

    @NotNull
    public static final String INDEX_FROM_PARENT_FIELD_IS_DROPPED = "ROOM_PARENT_FIELD_INDEX_IS_DROPPED";

    @NotNull
    public static final String INDEX_FROM_PARENT_IS_DROPPED = "ROOM_PARENT_INDEX_IS_DROPPED";

    @NotNull
    public static final String MISMATCHED_GETTER = "ROOM_MISMATCHED_GETTER_TYPE";

    @NotNull
    public static final String MISMATCHED_SETTER = "ROOM_MISMATCHED_SETTER_TYPE";

    @NotNull
    public static final String MISSING_INDEX_ON_FOREIGN_KEY_CHILD = "ROOM_MISSING_FOREIGN_KEY_CHILD_INDEX";

    @NotNull
    public static final String MISSING_INDEX_ON_JUNCTION = "MISSING_INDEX_ON_JUNCTION";

    @NotNull
    public static final String MISSING_JAVA_TMP_DIR = "ROOM_MISSING_JAVA_TMP_DIR";

    @NotNull
    public static final String MISSING_SCHEMA_LOCATION = "ROOM_MISSING_SCHEMA_LOCATION";

    @NotNull
    public static final String PRIMARY_KEY_FROM_EMBEDDED_IS_DROPPED = "ROOM_EMBEDDED_PRIMARY_KEY_IS_DROPPED";

    @NotNull
    public static final String QUERY_MISMATCH = "ROOM_QUERY_MISMATCH";

    @NotNull
    public static final String RELATION_QUERY_WITHOUT_TRANSACTION = "ROOM_RELATION_QUERY_WITHOUT_TRANSACTION";

    @NotNull
    public static final String RELATION_TYPE_MISMATCH = "ROOM_RELATION_TYPE_MISMATCH";

    @NotNull
    public static final String UNNECESSARY_NULLABILITY_IN_DAO_RETURN_TYPE = "ROOM_UNNECESSARY_NULLABILITY_IN_DAO_RETURN_TYPE";

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.v vVar) {
            this();
        }

        private Companion() {
        }

        @Deprecated(message = "Replaced by QUERY_MISMATCH.", replaceWith = @ReplaceWith(expression = "QUERY_MISMATCH", imports = {}))
        public static /* synthetic */ void getCURSOR_MISMATCH$annotations() {
        }
    }

    @Deprecated(message = "This type should not be instantiated as it contains only static methods. ")
    public RoomWarnings() {
    }
}
