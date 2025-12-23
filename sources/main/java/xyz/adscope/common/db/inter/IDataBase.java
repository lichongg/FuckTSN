package xyz.adscope.common.db.inter;

import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public interface IDataBase<T> {
    int delete(T t5);

    Long insert(T t5);

    List<T> query(T t5);

    List<T> query(T t5, String str, String str2);

    int update(T t5, T t6);
}
