package xyz.adscope.common.v2.persistent.db;

import java.util.List;
import xyz.adscope.common.v2.model.IDatabaseModel;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public interface IBaseDBOperator {
    public static final String ORDER_BY_ASC = "asc";
    public static final String ORDER_BY_DESC = "desc";
    public static final int QUERY_NO_LIMIT = -1;

    int delete(Class<? extends IDatabaseModel> cls, String str, String[] strArr);

    int deleteBetweenPrimaryKey(Class<? extends IDatabaseModel> cls, long[] jArr);

    int deleteByPrimaryKey(Class<? extends IDatabaseModel> cls, long j6);

    int deleteEqualWhere(Class<? extends IDatabaseModel> cls, String str, String str2);

    int deleteGreaterThenWhere(Class<? extends IDatabaseModel> cls, String str, String str2);

    int deleteInPrimaryKey(Class<? extends IDatabaseModel> cls, long[] jArr);

    int deleteLessThenWhere(Class<? extends IDatabaseModel> cls, String str, String str2);

    boolean execSQL(Class<? extends IDatabaseModel> cls, String str);

    boolean execSQL(String str);

    String getOrderByAsc(String str);

    String getOrderByDesc(String str);

    long insert(IDatabaseModel iDatabaseModel);

    <E extends IDatabaseModel> List<E> query(Class<E> cls, String str);

    <E extends IDatabaseModel> List<E> query(Class<E> cls, String str, String[] strArr, String str2, int i6);

    <E extends IDatabaseModel> List<E> query(Class<E> cls, String[] strArr, String str, String[] strArr2, String str2, int i6);

    <E extends IDatabaseModel> List<E> query(Class<E> cls, String[] strArr, String str, String[] strArr2, String str2, String str3, String str4, int i6);

    <E extends IDatabaseModel> int queryNumEntries(Class<E> cls);

    <E extends IDatabaseModel> long[] queryPrimerByDeleteCount(Class<E> cls, int i6);

    int update(IDatabaseModel iDatabaseModel, String str, String[] strArr);

    int updateByPrimaryKey(IDatabaseModel iDatabaseModel, long j6);

    int updateSignalCondition(IDatabaseModel iDatabaseModel, String str, String str2, String[] strArr);

    String whereBuild(String[] strArr, String[] strArr2);
}
