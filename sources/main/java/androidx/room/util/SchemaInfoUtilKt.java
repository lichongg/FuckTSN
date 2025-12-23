package androidx.room.util;

import androidx.room.ColumnInfo;
import androidx.room.util.TableInfo;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import com.tencent.connect.common.Constants;
import com.umeng.analytics.pro.d;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import io.netty.handler.codec.rtsp.RtspHeaders;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.collections.f0;
import kotlin.collections.i1;
import kotlin.collections.m;
import kotlin.collections.u1;
import kotlin.jdk7.a;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.n1;
import kotlin.text.u;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nSchemaInfoUtil.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SchemaInfoUtil.kt\nandroidx/room/util/SchemaInfoUtilKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 _Strings.kt\nkotlin/text/StringsKt___StringsKt\n+ 4 Strings.kt\nkotlin/text/StringsKt__StringsKt\n+ 5 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,378:1\n774#2:379\n865#2,2:380\n1863#2,2:382\n1053#2:384\n1557#2:385\n1628#2,3:386\n1053#2:389\n1557#2:390\n1628#2,3:391\n774#2:420\n865#2:421\n866#2:424\n1188#3,2:394\n1190#3:419\n108#4:396\n80#4,22:397\n12567#5,2:422\n*S KotlinDebug\n*F\n+ 1 SchemaInfoUtil.kt\nandroidx/room/util/SchemaInfoUtilKt\n*L\n94#1:379\n94#1:380,2\n95#1:382,2\n256#1:384\n256#1:385\n256#1:386,3\n257#1:389\n257#1:390\n257#1:391,3\n360#1:420\n360#1:421\n360#1:424\n328#1:394,2\n328#1:419\n348#1:396\n348#1:397,22\n360#1:422,2\n*E\n"})
/* loaded from: D:\Downloads\app\classes.dex */
public final class SchemaInfoUtilKt {

    @NotNull
    private static final String[] FTS_OPTIONS = {"tokenize=", "compress=", "content=", "languageid=", "matchinfo=", "notindexed=", "order=", "prefix=", "uncompress="};

    @ColumnInfo.SQLiteTypeAffinity
    public static final int findAffinity(@Nullable String str) {
        if (str == null) {
            return 5;
        }
        String upperCase = str.toUpperCase(Locale.ROOT);
        g0.o(upperCase, "toUpperCase(...)");
        if (u.l3(upperCase, "INT", false, 2, null)) {
            return 3;
        }
        if (u.l3(upperCase, "CHAR", false, 2, null) || u.l3(upperCase, "CLOB", false, 2, null) || u.l3(upperCase, "TEXT", false, 2, null)) {
            return 2;
        }
        if (u.l3(upperCase, "BLOB", false, 2, null)) {
            return 5;
        }
        return (u.l3(upperCase, "REAL", false, 2, null) || u.l3(upperCase, "FLOA", false, 2, null) || u.l3(upperCase, "DOUB", false, 2, null)) ? 4 : 1;
    }

    @NotNull
    public static final Set<String> parseFtsOptions(@NotNull String createStatement) {
        Character ch;
        g0.p(createStatement, "createStatement");
        if (createStatement.length() == 0) {
            return u1.k();
        }
        String substring = createStatement.substring(u.G3(createStatement, '(', 0, false, 6, null) + 1, u.V3(createStatement, ')', 0, false, 6, null));
        g0.o(substring, "substring(...)");
        ArrayList arrayList = new ArrayList();
        m mVar = new m();
        int i6 = -1;
        int i7 = 0;
        int i8 = 0;
        while (i7 < substring.length()) {
            char charAt = substring.charAt(i7);
            int i9 = i8 + 1;
            if (charAt != '\"' && charAt != '\'') {
                if (charAt != ',') {
                    if (charAt != '[') {
                        if (charAt != ']') {
                            if (charAt != '`') {
                            }
                        } else if (!mVar.isEmpty() && (ch = (Character) mVar.j()) != null && ch.charValue() == '[') {
                            f0.Q0(mVar);
                        }
                    } else if (mVar.isEmpty()) {
                        mVar.addFirst(Character.valueOf(charAt));
                    }
                } else if (mVar.isEmpty()) {
                    String substring2 = substring.substring(i6 + 1, i8);
                    g0.o(substring2, "substring(...)");
                    int length = substring2.length() - 1;
                    int i10 = 0;
                    boolean z5 = false;
                    while (i10 <= length) {
                        boolean z6 = g0.t(substring2.charAt(!z5 ? i10 : length), 32) <= 0;
                        if (z5) {
                            if (!z6) {
                                break;
                            }
                            length--;
                        } else if (z6) {
                            i10++;
                        } else {
                            z5 = true;
                        }
                    }
                    arrayList.add(substring2.subSequence(i10, length + 1).toString());
                    i6 = i8;
                }
                i7++;
                i8 = i9;
            }
            if (mVar.isEmpty()) {
                mVar.addFirst(Character.valueOf(charAt));
            } else {
                Character ch2 = (Character) mVar.j();
                if (ch2 != null && ch2.charValue() == charAt) {
                    f0.Q0(mVar);
                }
            }
            i7++;
            i8 = i9;
        }
        String substring3 = substring.substring(i6 + 1);
        g0.o(substring3, "substring(...)");
        arrayList.add(u.Z5(substring3).toString());
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            String str = (String) obj;
            String[] strArr = FTS_OPTIONS;
            int length2 = strArr.length;
            int i11 = 0;
            while (true) {
                if (i11 >= length2) {
                    break;
                }
                if (u.H2(str, strArr[i11], false, 2, null)) {
                    arrayList2.add(obj);
                    break;
                }
                i11++;
            }
        }
        return f0.f6(arrayList2);
    }

    private static final Map<String, TableInfo.Column> readColumns(SQLiteConnection sQLiteConnection, String str) {
        SQLiteStatement prepare = sQLiteConnection.prepare("PRAGMA table_info(`" + str + "`)");
        try {
            if (!prepare.step()) {
                Map<String, TableInfo.Column> z5 = i1.z();
                a.c(prepare, null);
                return z5;
            }
            int columnIndexOf = SQLiteStatementUtil.columnIndexOf(prepare, CommonNetImpl.NAME);
            int columnIndexOf2 = SQLiteStatementUtil.columnIndexOf(prepare, "type");
            int columnIndexOf3 = SQLiteStatementUtil.columnIndexOf(prepare, "notnull");
            int columnIndexOf4 = SQLiteStatementUtil.columnIndexOf(prepare, d.S);
            int columnIndexOf5 = SQLiteStatementUtil.columnIndexOf(prepare, "dflt_value");
            Map g6 = i1.g();
            do {
                String text = prepare.getText(columnIndexOf);
                g6.put(text, new TableInfo.Column(text, prepare.getText(columnIndexOf2), prepare.getLong(columnIndexOf3) != 0, (int) prepare.getLong(columnIndexOf4), prepare.isNull(columnIndexOf5) ? null : prepare.getText(columnIndexOf5), 2));
            } while (prepare.step());
            Map<String, TableInfo.Column> d6 = i1.d(g6);
            a.c(prepare, null);
            return d6;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                a.c(prepare, th);
                throw th2;
            }
        }
    }

    private static final List<ForeignKeyWithSequence> readForeignKeyFieldMappings(SQLiteStatement sQLiteStatement) {
        int columnIndexOf = SQLiteStatementUtil.columnIndexOf(sQLiteStatement, "id");
        int columnIndexOf2 = SQLiteStatementUtil.columnIndexOf(sQLiteStatement, RtspHeaders.Values.SEQ);
        int columnIndexOf3 = SQLiteStatementUtil.columnIndexOf(sQLiteStatement, Constants.FROM);
        int columnIndexOf4 = SQLiteStatementUtil.columnIndexOf(sQLiteStatement, "to");
        List j6 = f0.j();
        while (sQLiteStatement.step()) {
            j6.add(new ForeignKeyWithSequence((int) sQLiteStatement.getLong(columnIndexOf), (int) sQLiteStatement.getLong(columnIndexOf2), sQLiteStatement.getText(columnIndexOf3), sQLiteStatement.getText(columnIndexOf4)));
        }
        return f0.v5(f0.b(j6));
    }

    private static final Set<TableInfo.ForeignKey> readForeignKeys(SQLiteConnection sQLiteConnection, String str) {
        SQLiteStatement prepare = sQLiteConnection.prepare("PRAGMA foreign_key_list(`" + str + "`)");
        try {
            int columnIndexOf = SQLiteStatementUtil.columnIndexOf(prepare, "id");
            int columnIndexOf2 = SQLiteStatementUtil.columnIndexOf(prepare, RtspHeaders.Values.SEQ);
            int columnIndexOf3 = SQLiteStatementUtil.columnIndexOf(prepare, "table");
            int columnIndexOf4 = SQLiteStatementUtil.columnIndexOf(prepare, "on_delete");
            int columnIndexOf5 = SQLiteStatementUtil.columnIndexOf(prepare, "on_update");
            List<ForeignKeyWithSequence> readForeignKeyFieldMappings = readForeignKeyFieldMappings(prepare);
            prepare.reset();
            Set d6 = u1.d();
            while (prepare.step()) {
                if (prepare.getLong(columnIndexOf2) == 0) {
                    int i6 = (int) prepare.getLong(columnIndexOf);
                    ArrayList arrayList = new ArrayList();
                    ArrayList arrayList2 = new ArrayList();
                    ArrayList<ForeignKeyWithSequence> arrayList3 = new ArrayList();
                    for (Object obj : readForeignKeyFieldMappings) {
                        if (((ForeignKeyWithSequence) obj).getId() == i6) {
                            arrayList3.add(obj);
                        }
                    }
                    for (ForeignKeyWithSequence foreignKeyWithSequence : arrayList3) {
                        arrayList.add(foreignKeyWithSequence.getFrom());
                        arrayList2.add(foreignKeyWithSequence.getTo());
                    }
                    d6.add(new TableInfo.ForeignKey(prepare.getText(columnIndexOf3), prepare.getText(columnIndexOf4), prepare.getText(columnIndexOf5), arrayList, arrayList2));
                }
            }
            Set<TableInfo.ForeignKey> a6 = u1.a(d6);
            a.c(prepare, null);
            return a6;
        } finally {
        }
    }

    @NotNull
    public static final Set<String> readFtsColumns(@NotNull SQLiteConnection connection, @NotNull String tableName) {
        g0.p(connection, "connection");
        g0.p(tableName, "tableName");
        Set d6 = u1.d();
        SQLiteStatement prepare = connection.prepare("PRAGMA table_info(`" + tableName + "`)");
        try {
            if (prepare.step()) {
                int columnIndexOf = SQLiteStatementUtil.columnIndexOf(prepare, CommonNetImpl.NAME);
                do {
                    d6.add(prepare.getText(columnIndexOf));
                } while (prepare.step());
            }
            n1 n1Var = n1.f44123a;
            a.c(prepare, null);
            return u1.a(d6);
        } finally {
        }
    }

    @NotNull
    public static final Set<String> readFtsOptions(@NotNull SQLiteConnection connection, @NotNull String tableName) {
        g0.p(connection, "connection");
        g0.p(tableName, "tableName");
        SQLiteStatement prepare = connection.prepare("SELECT * FROM sqlite_master WHERE `name` = '" + tableName + '\'');
        try {
            String text = prepare.step() ? prepare.getText(SQLiteStatementUtil.columnIndexOf(prepare, "sql")) : "";
            a.c(prepare, null);
            return parseFtsOptions(text);
        } finally {
        }
    }

    private static final TableInfo.Index readIndex(SQLiteConnection sQLiteConnection, String str, boolean z5) {
        SQLiteStatement prepare = sQLiteConnection.prepare("PRAGMA index_xinfo(`" + str + "`)");
        try {
            int columnIndexOf = SQLiteStatementUtil.columnIndexOf(prepare, "seqno");
            int columnIndexOf2 = SQLiteStatementUtil.columnIndexOf(prepare, "cid");
            int columnIndexOf3 = SQLiteStatementUtil.columnIndexOf(prepare, CommonNetImpl.NAME);
            int columnIndexOf4 = SQLiteStatementUtil.columnIndexOf(prepare, "desc");
            if (columnIndexOf != -1 && columnIndexOf2 != -1 && columnIndexOf3 != -1 && columnIndexOf4 != -1) {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                while (prepare.step()) {
                    if (((int) prepare.getLong(columnIndexOf2)) >= 0) {
                        int i6 = (int) prepare.getLong(columnIndexOf);
                        String text = prepare.getText(columnIndexOf3);
                        String str2 = prepare.getLong(columnIndexOf4) > 0 ? "DESC" : "ASC";
                        linkedHashMap.put(Integer.valueOf(i6), text);
                        linkedHashMap2.put(Integer.valueOf(i6), str2);
                    }
                }
                List z52 = f0.z5(linkedHashMap.entrySet(), new Comparator() { // from class: androidx.room.util.SchemaInfoUtilKt$readIndex$lambda$13$$inlined$sortedBy$1
                    @Override // java.util.Comparator
                    public final int compare(T t5, T t6) {
                        return kotlin.comparisons.a.l((Integer) ((Map.Entry) t5).getKey(), (Integer) ((Map.Entry) t6).getKey());
                    }
                });
                ArrayList arrayList = new ArrayList(f0.d0(z52, 10));
                Iterator it = z52.iterator();
                while (it.hasNext()) {
                    arrayList.add((String) ((Map.Entry) it.next()).getValue());
                }
                List a6 = f0.a6(arrayList);
                List z53 = f0.z5(linkedHashMap2.entrySet(), new Comparator() { // from class: androidx.room.util.SchemaInfoUtilKt$readIndex$lambda$13$$inlined$sortedBy$2
                    @Override // java.util.Comparator
                    public final int compare(T t5, T t6) {
                        return kotlin.comparisons.a.l((Integer) ((Map.Entry) t5).getKey(), (Integer) ((Map.Entry) t6).getKey());
                    }
                });
                ArrayList arrayList2 = new ArrayList(f0.d0(z53, 10));
                Iterator it2 = z53.iterator();
                while (it2.hasNext()) {
                    arrayList2.add((String) ((Map.Entry) it2.next()).getValue());
                }
                TableInfo.Index index = new TableInfo.Index(str, z5, a6, f0.a6(arrayList2));
                a.c(prepare, null);
                return index;
            }
            a.c(prepare, null);
            return null;
        } finally {
        }
    }

    private static final Set<TableInfo.Index> readIndices(SQLiteConnection sQLiteConnection, String str) {
        SQLiteStatement prepare = sQLiteConnection.prepare("PRAGMA index_list(`" + str + "`)");
        try {
            int columnIndexOf = SQLiteStatementUtil.columnIndexOf(prepare, CommonNetImpl.NAME);
            int columnIndexOf2 = SQLiteStatementUtil.columnIndexOf(prepare, "origin");
            int columnIndexOf3 = SQLiteStatementUtil.columnIndexOf(prepare, "unique");
            if (columnIndexOf != -1 && columnIndexOf2 != -1 && columnIndexOf3 != -1) {
                Set d6 = u1.d();
                while (prepare.step()) {
                    if (g0.g("c", prepare.getText(columnIndexOf2))) {
                        TableInfo.Index readIndex = readIndex(sQLiteConnection, prepare.getText(columnIndexOf), prepare.getLong(columnIndexOf3) == 1);
                        if (readIndex == null) {
                            a.c(prepare, null);
                            return null;
                        }
                        d6.add(readIndex);
                    }
                }
                Set<TableInfo.Index> a6 = u1.a(d6);
                a.c(prepare, null);
                return a6;
            }
            a.c(prepare, null);
            return null;
        } finally {
        }
    }

    @NotNull
    public static final TableInfo readTableInfo(@NotNull SQLiteConnection connection, @NotNull String tableName) {
        g0.p(connection, "connection");
        g0.p(tableName, "tableName");
        return new TableInfo(tableName, readColumns(connection, tableName), readForeignKeys(connection, tableName), readIndices(connection, tableName));
    }

    @NotNull
    public static final ViewInfo readViewInfo(@NotNull SQLiteConnection connection, @NotNull String viewName) {
        g0.p(connection, "connection");
        g0.p(viewName, "viewName");
        SQLiteStatement prepare = connection.prepare("SELECT name, sql FROM sqlite_master WHERE type = 'view' AND name = '" + viewName + '\'');
        try {
            ViewInfo viewInfo = prepare.step() ? new ViewInfo(prepare.getText(0), prepare.getText(1)) : new ViewInfo(viewName, null);
            a.c(prepare, null);
            return viewInfo;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                a.c(prepare, th);
                throw th2;
            }
        }
    }
}
