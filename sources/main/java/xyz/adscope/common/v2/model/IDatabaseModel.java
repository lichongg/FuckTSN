package xyz.adscope.common.v2.model;

import android.content.ContentValues;
import android.database.Cursor;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public interface IDatabaseModel {
    public static final String PRIMARY_KEY_COLUM = "id";

    String[] getColumns();

    ContentValues getContentValuesStruct();

    Map<String, String> getMapStruct();

    long getPrimaryID();

    void parseFromDb(Cursor cursor);

    void setPrimaryID(long j6);
}
