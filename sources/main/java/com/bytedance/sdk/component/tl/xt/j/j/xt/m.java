package com.bytedance.sdk.component.tl.xt.j.j.xt;

import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import com.baidu.mobads.sdk.internal.bn;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONObject;
import xyz.adscope.common.v2.persistent.db.IBaseDbHelper;

/* loaded from: D:\Downloads\app\classes4.dex */
public class m extends xt {
    protected List<String> cw;

    /* renamed from: r, reason: collision with root package name */
    private final Context f26772r;
    private com.bytedance.sdk.component.tl.xt.r.xt.j up;
    protected com.bytedance.sdk.component.tl.j.up xt;

    public byte cw() {
        return (byte) 0;
    }

    @Override // com.bytedance.sdk.component.tl.xt.j.j
    public boolean j(com.bytedance.sdk.component.tl.j.xt xtVar) {
        return com.bytedance.sdk.component.tl.xt.cw.j.cw(xtVar);
    }

    @Override // com.bytedance.sdk.component.tl.xt.j.j.xt.xt
    com.bytedance.sdk.component.tl.j.up r() {
        return this.xt;
    }

    public byte xt() {
        return (byte) 2;
    }

    public m(Context context, com.bytedance.sdk.component.tl.xt.r.xt.j jVar, com.bytedance.sdk.component.tl.j.up upVar) {
        super(context, upVar, jVar == null ? com.bytedance.sdk.component.tl.xt.r.xt.j.cw() : jVar);
        this.cw = new ArrayList();
        this.f26772r = context;
        this.up = jVar;
        this.xt = upVar;
        if (jVar == null) {
            this.up = com.bytedance.sdk.component.tl.xt.r.xt.j.cw();
        }
    }

    private void r(List<com.bytedance.sdk.component.tl.j.xt> list) {
        LinkedList linkedList = new LinkedList();
        Iterator<com.bytedance.sdk.component.tl.j.xt> it = list.iterator();
        while (it.hasNext()) {
            linkedList.add(it.next().cw());
        }
        com.bytedance.sdk.component.tl.xt.j.j.xt.j(getContext(), "UPDATE " + j() + " SET retry = retry+1 WHERE " + j("id", (List<?>) linkedList, 1000, true), this.xt);
    }

    public static String up(String str) {
        return "ALTER TABLE " + str + " ADD COLUMN encrypt INTEGER default 0";
    }

    protected String cw(List<String> list) {
        j();
        list.size();
        String j6 = com.bytedance.sdk.component.tl.xt.j.j.xt.j(getContext(), "DELETE FROM " + j() + " WHERE " + j("id", (List<?>) list, 1000, true), this.xt);
        com.bytedance.sdk.component.tl.xt.cw.xt.j(com.bytedance.sdk.component.tl.xt.xt.xt.f26840j.az(), list.size(), this.xt);
        j(list);
        return j6;
    }

    @Override // com.bytedance.sdk.component.tl.xt.j.j.xt.cw
    public String delete(List<com.bytedance.sdk.component.tl.j.xt> list) {
        if (list == null || list.size() == 0) {
            return "list is empty";
        }
        LinkedList linkedList = new LinkedList();
        Iterator<com.bytedance.sdk.component.tl.j.xt> it = list.iterator();
        while (it.hasNext()) {
            linkedList.add(it.next().cw());
        }
        com.bytedance.sdk.component.tl.xt.cw.j.j(list, this.xt, j());
        String j6 = com.bytedance.sdk.component.tl.xt.j.j.xt.j(getContext(), "DELETE FROM " + j() + " WHERE " + j("id", (List<?>) linkedList, 1000, true), this.xt);
        j(linkedList);
        return j6;
    }

    @Override // com.bytedance.sdk.component.tl.xt.j.j.xt.xt
    public String j() {
        com.bytedance.sdk.component.tl.j.m xt = this.xt.xt();
        if (xt != null) {
            return xt.xt();
        }
        return null;
    }

    @Override // com.bytedance.sdk.component.tl.xt.j.j.xt.cw
    public List<com.bytedance.sdk.component.tl.j.xt> j(int i6, String str, int i7, boolean z5) {
        List<com.bytedance.sdk.component.tl.j.xt> list;
        List<com.bytedance.sdk.component.tl.j.xt> list2;
        String string;
        String string2;
        int i8;
        long j6 = com.bytedance.sdk.component.tl.xt.xt.j.j(i6, getContext(), this.xt);
        com.bytedance.sdk.component.tl.xt.cw.cw.xt(j() + " query db max :" + j6 + " limit:" + i6, this.xt);
        if (j6 <= 0) {
            j6 = 1;
        } else if (j6 > 100) {
            j6 = 100;
        }
        String str2 = str + " DESC limit " + j6;
        List<com.bytedance.sdk.component.tl.j.xt> arrayList = new ArrayList<>();
        this.cw.clear();
        List<com.bytedance.sdk.component.tl.j.xt> list3 = arrayList;
        Cursor query = com.bytedance.sdk.component.tl.xt.j.j.xt.query(getContext(), j(), new String[]{"id", "value", "encrypt", "retry"}, null, null, null, null, str2, this.xt);
        if (query != null) {
            try {
                com.bytedance.sdk.component.tl.j.r r5 = this.xt.r();
                while (query.moveToNext()) {
                    try {
                        string = query.getString(query.getColumnIndex("id"));
                        string2 = query.getString(query.getColumnIndex("value"));
                        int i9 = query.getInt(query.getColumnIndex("encrypt"));
                        i8 = query.getInt(query.getColumnIndex("retry"));
                        if (i9 == 1) {
                            string2 = r5.j(string2);
                        }
                    } catch (Throwable th) {
                        th = th;
                        list2 = list3;
                    }
                    if (TextUtils.isEmpty(string2)) {
                        this.cw.add(string);
                    } else {
                        if (list3.size() > 100) {
                            break;
                        }
                        JSONObject jSONObject = new JSONObject(string2);
                        String optString = jSONObject.optString("ad_extra_data");
                        if (!TextUtils.isEmpty(optString)) {
                            JSONObject jSONObject2 = new JSONObject(optString);
                            jSONObject2.put("retry_count", i8);
                            jSONObject2.put("db_rd", System.currentTimeMillis());
                            jSONObject.put("ad_extra_data", jSONObject2.toString());
                        }
                        com.bytedance.sdk.component.tl.xt.r.j.j jVar = new com.bytedance.sdk.component.tl.xt.r.j.j(string, jSONObject);
                        jVar.j(cw());
                        jVar.xt(xt());
                        com.bytedance.sdk.component.tl.xt.cw.j.j(jSONObject, jVar, this.xt, i8);
                        list2 = list3;
                        try {
                            list2.add(jVar);
                        } catch (Throwable th2) {
                            th = th2;
                            try {
                                com.bytedance.sdk.component.tl.xt.cw.cw.cw(th.getMessage(), this.xt);
                                list3 = list2;
                            } catch (Throwable th3) {
                                th = th3;
                                try {
                                    query.close();
                                    if (!this.cw.isEmpty()) {
                                        cw(this.cw);
                                        this.cw.clear();
                                    }
                                    if (com.bytedance.sdk.component.tl.xt.cw.j.j(i7) && !z5) {
                                        j(list2, 5, bn.f10748d);
                                    }
                                } catch (Exception unused) {
                                }
                                throw th;
                            }
                        }
                        list3 = list2;
                    }
                }
                list = list3;
                try {
                    query.close();
                    if (!this.cw.isEmpty()) {
                        cw(this.cw);
                        this.cw.clear();
                    }
                    if (com.bytedance.sdk.component.tl.xt.cw.j.j(i7) && !z5) {
                        j(list, 5, bn.f10748d);
                    }
                } catch (Exception unused2) {
                }
            } catch (Throwable th4) {
                th = th4;
                list2 = list3;
            }
        } else {
            list = list3;
        }
        com.bytedance.sdk.component.tl.xt.cw.cw.xt(j() + " query db actually size :" + list.size(), this.xt);
        return list;
    }

    public static String r(String str) {
        return "CREATE TABLE IF NOT EXISTS " + str + " (_id INTEGER PRIMARY KEY AUTOINCREMENT,id TEXT UNIQUE,value TEXT ,gen_time TEXT , retry INTEGER default 0 , encrypt INTEGER default 0)";
    }

    @Override // com.bytedance.sdk.component.tl.xt.j.j.xt.cw
    public List<com.bytedance.sdk.component.tl.j.xt> j(String str, int i6, boolean z5) {
        com.bytedance.sdk.component.tl.xt.r.xt.j jVar = this.up;
        if (jVar == null) {
            return new ArrayList();
        }
        return j(jVar.xt(), str, i6, z5);
    }

    private void j(int i6, long j6) {
        long currentTimeMillis = System.currentTimeMillis() - j6;
        Context context = getContext();
        String j7 = j();
        StringBuilder sb = new StringBuilder();
        sb.append(currentTimeMillis);
        String sb2 = sb.toString();
        StringBuilder sb3 = new StringBuilder();
        sb3.append(i6);
        com.bytedance.sdk.component.tl.xt.j.j.xt.delete(context, j7, "gen_time <? OR retry >?", new String[]{sb2, sb3.toString()}, this.xt);
    }

    public void j(List<com.bytedance.sdk.component.tl.j.xt> list, int i6, long j6) {
        if (list == null || list.size() == 0) {
            return;
        }
        try {
            r(list);
            j(i6, j6);
        } catch (Exception unused) {
        }
    }

    private static String j(String str, List<?> list, int i6, boolean z5) {
        int i7;
        String str2 = z5 ? IBaseDbHelper.CONDITION_IN : " NOT IN ";
        String str3 = z5 ? " OR " : " AND ";
        int min = Math.min(i6, 1000);
        int size = list.size();
        if (size % min == 0) {
            i7 = size / min;
        } else {
            i7 = (size / min) + 1;
        }
        StringBuilder sb = new StringBuilder();
        for (int i8 = 0; i8 < i7; i8++) {
            int i9 = i8 * min;
            String j6 = j(TextUtils.join("','", list.subList(i9, Math.min(i9 + min, size))), "");
            if (i8 != 0) {
                sb.append(str3);
            }
            sb.append(str);
            sb.append(str2);
            sb.append("('");
            sb.append(j6);
            sb.append("')");
        }
        return j(sb.toString(), str + str2 + "('')");
    }

    private static String j(String str, String str2) {
        return !TextUtils.isEmpty(str) ? str : str2;
    }
}
