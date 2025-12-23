package xyz.adscope.common.v2.persistent.db;

import android.content.ContentValues;
import android.database.Cursor;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import xyz.adscope.common.v2.encrypt.impl.Base64Util;
import xyz.adscope.common.v2.log.SDKLog;
import xyz.adscope.common.v2.model.IDatabaseModel;
import xyz.adscope.common.v2.model.annotation.DataBaseNode;
import xyz.adscope.common.v2.tool.reflect.ReflectUtil;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class IBaseDatabaseModel implements IDatabaseModel {
    private String[] columns;
    protected long primaryID;

    @Override // xyz.adscope.common.v2.model.IDatabaseModel
    public String[] getColumns() {
        String[] strArr = this.columns;
        if (strArr == null || strArr.length == 0) {
            this.columns = getAllColumns();
        }
        return this.columns;
    }

    @Override // xyz.adscope.common.v2.model.IDatabaseModel
    public Map<String, String> getMapStruct() {
        HashMap hashMap = new HashMap();
        List<Field> allFields = ReflectUtil.getAllFields(getClass());
        if (!allFields.isEmpty()) {
            for (Field field : allFields) {
                if (field.isAnnotationPresent(DataBaseNode.class)) {
                    field.setAccessible(true);
                    DataBaseNode dataBaseNode = (DataBaseNode) field.getAnnotation(DataBaseNode.class);
                    if (dataBaseNode != null) {
                        String column = dataBaseNode.column();
                        try {
                            Object obj = field.get(this);
                            if (obj != null) {
                                hashMap.put(column, Base64Util.encodeToString(obj.toString()));
                            }
                        } catch (IllegalAccessException e6) {
                            SDKLog.stack(e6);
                        }
                    }
                }
            }
        }
        return hashMap;
    }

    @Override // xyz.adscope.common.v2.model.IDatabaseModel
    public long getPrimaryID() {
        return this.primaryID;
    }

    @Override // xyz.adscope.common.v2.model.IDatabaseModel
    public void parseFromDb(Cursor cursor) {
        int columnIndex;
        if (cursor != null) {
            int columnIndex2 = cursor.getColumnIndex("id");
            if (columnIndex2 != -1) {
                setPrimaryID(cursor.getLong(columnIndex2));
            }
            for (Field field : getClass().getDeclaredFields()) {
                if (field.isAnnotationPresent(DataBaseNode.class)) {
                    field.setAccessible(true);
                    DataBaseNode dataBaseNode = (DataBaseNode) field.getAnnotation(DataBaseNode.class);
                    if (dataBaseNode != null && (columnIndex = cursor.getColumnIndex(dataBaseNode.column())) != -1) {
                        try {
                            field.set(this, Base64Util.decodeToString(cursor.getString(columnIndex)));
                        } catch (IllegalAccessException e6) {
                            SDKLog.stack(e6);
                        }
                    }
                }
            }
        }
    }

    @Override // xyz.adscope.common.v2.model.IDatabaseModel
    public void setPrimaryID(long j6) {
        this.primaryID = j6;
    }

    private String[] getAllColumns() {
        Field[] declaredFields = getClass().getDeclaredFields();
        if (declaredFields.length > 0) {
            ArrayList arrayList = new ArrayList();
            for (Field field : declaredFields) {
                if (field.isAnnotationPresent(DataBaseNode.class)) {
                    field.setAccessible(true);
                    DataBaseNode dataBaseNode = (DataBaseNode) field.getAnnotation(DataBaseNode.class);
                    if (dataBaseNode != null) {
                        arrayList.add(dataBaseNode.column());
                    }
                }
            }
            if (!arrayList.isEmpty()) {
                return (String[]) arrayList.toArray(new String[0]);
            }
            return null;
        }
        return null;
    }

    @Override // xyz.adscope.common.v2.model.IDatabaseModel
    public ContentValues getContentValuesStruct() {
        Map<String, String> mapStruct = getMapStruct();
        if (mapStruct != null && !mapStruct.isEmpty()) {
            ContentValues contentValues = new ContentValues();
            for (Map.Entry<String, String> entry : mapStruct.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                if (value != null) {
                    contentValues.put(key, value);
                }
            }
            return contentValues;
        }
        return null;
    }
}
