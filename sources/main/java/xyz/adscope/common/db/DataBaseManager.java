package xyz.adscope.common.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import java.util.List;
import xyz.adscope.common.db.inter.IDataBase;
import xyz.adscope.common.db.storage.DatabaseHelper;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class DataBaseManager<T> implements IDataBase {

    /* renamed from: a, reason: collision with root package name */
    private DatabaseHelper f56308a;

    /* renamed from: b, reason: collision with root package name */
    private SQLiteDatabase f56309b;

    /* renamed from: c, reason: collision with root package name */
    private CommonDataBase f56310c = new CommonDataBase();

    /* renamed from: d, reason: collision with root package name */
    private String f56311d;

    /* renamed from: e, reason: collision with root package name */
    private Class<T> f56312e;

    private synchronized void a() {
        if (!a(this.f56311d)) {
            b();
        }
    }

    private synchronized void b() {
        this.f56310c.createTable(this.f56309b, this.f56311d, this.f56312e, null);
    }

    @Override // xyz.adscope.common.db.inter.IDataBase
    public synchronized int delete(Object obj) {
        a();
        return this.f56310c.deleteTable(this.f56309b, this.f56311d, " = ? ", obj);
    }

    public synchronized int deleteOutTime(Object obj) {
        a();
        return this.f56310c.deleteTable(this.f56309b, this.f56311d, " < ? ", obj);
    }

    @Override // xyz.adscope.common.db.inter.IDataBase
    public synchronized Long insert(Object obj) {
        a();
        return Long.valueOf(this.f56310c.insertTable(this.f56309b, this.f56311d, obj));
    }

    @Override // xyz.adscope.common.db.inter.IDataBase
    public List query(Object obj) {
        a();
        return this.f56310c.queryTable(this.f56309b, this.f56311d, this.f56312e, obj, " = ? ");
    }

    @Override // xyz.adscope.common.db.inter.IDataBase
    public synchronized int update(Object obj, Object obj2) {
        return 0;
    }

    public void setTableNameAndModel(String str, Class cls) {
        this.f56311d = str;
        this.f56312e = cls;
    }

    public synchronized int update(Object obj, ContentValues contentValues) {
        this.f56310c.updateTable(this.f56309b, this.f56311d, contentValues, " = ? ", obj);
        return 0;
    }

    public DataBaseManager(Context context) {
        this.f56308a = DatabaseHelper.getInstance(context);
        this.f56309b = this.f56308a.getWritableDatabase();
    }

    private synchronized boolean a(String str) {
        return this.f56310c.isTableExists(this.f56309b, str);
    }

    @Override // xyz.adscope.common.db.inter.IDataBase
    public List query(Object obj, String str, String str2) {
        a();
        return this.f56310c.querySingleTable(this.f56309b, this.f56311d, this.f56312e, obj, " = ? ", str, str2);
    }

    public synchronized List query(String str, String str2) {
        a();
        return this.f56310c.queryTable(this.f56309b, this.f56311d, this.f56312e, null, null, str, str2);
    }

    public synchronized String query(Object obj, String[] strArr, String str, String str2) {
        a();
        return this.f56310c.querySingleData(this.f56309b, this.f56311d, obj, strArr, " = ? ", str, str2);
    }
}
