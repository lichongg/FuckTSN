package com.baidu.liantian.rp.f;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.liantian.b;
import com.baidu.liantian.b.f;
import com.baidu.liantian.b.h;
import com.baidu.liantian.b.l;
import com.baidu.liantian.b.o;
import com.baidu.liantian.e;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.stub.StubApp;
import com.tencent.connect.common.Constants;
import com.umeng.analytics.pro.bi;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    e f10494a;

    /* renamed from: b, reason: collision with root package name */
    public Context f10495b;

    /* renamed from: c, reason: collision with root package name */
    com.baidu.liantian.rp.d.a.a f10496c;

    /* renamed from: d, reason: collision with root package name */
    public com.baidu.liantian.rp.e.a f10497d;

    /* renamed from: e, reason: collision with root package name */
    private HandlerC0099a f10498e = new HandlerC0099a(l.a());

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.baidu.liantian.rp.f.a$a, reason: collision with other inner class name */
    private class HandlerC0099a extends Handler {
        public HandlerC0099a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            try {
                switch (message.what) {
                    case 0:
                        a.b(a.this);
                        break;
                    case 1:
                        com.baidu.liantian.rp.b.a.a(a.this.f10495b).a((com.baidu.liantian.rp.c.a) message.obj);
                        b.a();
                        Message message2 = new Message();
                        message2.what = 10;
                        sendMessage(message2);
                        break;
                    case 2:
                        b.a();
                        a.a(a.this);
                        a.b(a.this);
                        int o5 = com.baidu.liantian.b.e.o(a.this.f10495b);
                        b.a();
                        a.a(a.this, 0, o5);
                        break;
                    case 3:
                        com.baidu.liantian.rp.a.a aVar = (com.baidu.liantian.rp.a.a) message.obj;
                        if (aVar != null) {
                            a aVar2 = a.this;
                            String b6 = aVar2.f10494a.b(aVar.f10473e);
                            com.baidu.liantian.rp.c.a aVar3 = new com.baidu.liantian.rp.c.a();
                            aVar3.f10481b = aVar.f10473e;
                            aVar3.f10486g = 0;
                            aVar3.f10482c = 1;
                            aVar3.f10484e = System.currentTimeMillis();
                            aVar3.f10485f = 1;
                            aVar3.f10483d = com.baidu.liantian.b.e.a(aVar2.f10495b, aVar, b6, false).toString();
                            com.baidu.liantian.rp.b.a.a(aVar2.f10495b).a(aVar3);
                            e eVar = aVar2.f10494a;
                            String str = aVar.f10473e;
                            eVar.f10462f.putBoolean("re_net_ins_" + str, true);
                            eVar.f10462f.commit();
                            String a6 = o.a(com.baidu.liantian.b.e.n(aVar2.f10495b).toString());
                            if (com.baidu.liantian.rp.b.a.a(aVar2.f10495b).b(a6)) {
                                aVar3.f10481b = "1001001";
                                Context context = aVar2.f10495b;
                                aVar3.f10483d = com.baidu.liantian.b.e.a(context, aVar.f10469a, aVar.f10471c, "1001001", com.baidu.liantian.b.e.n(context).toString()).toString();
                                com.baidu.liantian.rp.b.a.a(aVar2.f10495b).a(aVar3);
                                com.baidu.liantian.rp.b.a.a(aVar2.f10495b).a(a6);
                                break;
                            }
                        } else {
                            break;
                        }
                        break;
                    case 4:
                        String valueOf = String.valueOf(message.obj);
                        if (!TextUtils.isEmpty(valueOf)) {
                            com.baidu.liantian.rp.b.a.a(a.this.f10495b).a(o.a(valueOf));
                            break;
                        } else {
                            break;
                        }
                    case 5:
                        a.a(a.this);
                        a aVar4 = a.this;
                        e eVar2 = new e(aVar4.f10495b);
                        int x5 = eVar2.x();
                        Integer.toString(x5);
                        b.a();
                        long currentTimeMillis = System.currentTimeMillis() - eVar2.f10461e.getLong("re_last_ofline_time", 0L);
                        long j6 = x5 * 3600000;
                        if (currentTimeMillis >= j6) {
                            f.a(aVar4.f10495b).c();
                            com.baidu.liantian.b.e.a(aVar4.f10495b, j6);
                            eVar2.d(System.currentTimeMillis());
                        } else {
                            com.baidu.liantian.b.e.a(aVar4.f10495b, j6 - currentTimeMillis);
                        }
                        Message message3 = new Message();
                        message3.what = 10;
                        sendMessage(message3);
                        break;
                    case 6:
                        a aVar5 = a.this;
                        a.a(aVar5, 1, com.baidu.liantian.b.e.o(aVar5.f10495b));
                        break;
                    case 7:
                        a.b(a.this);
                        a aVar6 = a.this;
                        a.a(aVar6, 1, com.baidu.liantian.b.e.o(aVar6.f10495b));
                        break;
                    case 8:
                        b.a();
                        a aVar7 = a.this;
                        a.a(aVar7, 3, com.baidu.liantian.b.e.o(aVar7.f10495b));
                        break;
                    case 9:
                        a.a(a.this, 0, 2);
                        break;
                    case 10:
                        int o6 = com.baidu.liantian.b.e.o(a.this.f10495b);
                        if (2 != o6) {
                            if (1 == o6) {
                                b.a();
                                a.a(a.this, 4, o6);
                                break;
                            }
                        } else {
                            b.a();
                            if (com.baidu.liantian.rp.b.a.a(a.this.f10495b).b() < new e(a.this.f10495b).f10461e.getInt("up_nu_co", 50)) {
                                List<com.baidu.liantian.rp.c.a> a7 = com.baidu.liantian.rp.b.a.a(a.this.f10495b).a(true, o6);
                                a7.size();
                                b.a();
                                if (a7.size() > 0) {
                                    b.a();
                                    a.a(a.this, 0, o6);
                                    break;
                                }
                            } else {
                                b.a();
                                a.a(a.this, 0, o6);
                                break;
                            }
                        }
                        break;
                    case 11:
                        String valueOf2 = String.valueOf(message.obj);
                        if (!a.this.f10496c.a(new JSONArray().put(com.baidu.liantian.b.e.a(a.this.f10495b, new JSONObject(valueOf2))).toString(), a.a(new JSONObject(valueOf2)))) {
                            com.baidu.liantian.b.e.c(a.this.f10495b, valueOf2);
                            break;
                        }
                        break;
                }
            } catch (Throwable unused) {
                com.baidu.liantian.b.e.a();
            }
        }
    }

    public final void a(Message message) {
        this.f10498e.sendMessage(message);
    }

    static String a(JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject("Common_section");
            if (jSONObject2 != null && jSONObject2.has(Constants.VIA_REPORT_TYPE_SET_AVATAR)) {
                return jSONObject2.optString(Constants.VIA_REPORT_TYPE_SET_AVATAR, "");
            }
            return null;
        } catch (Throwable unused) {
            com.baidu.liantian.b.e.a();
            return null;
        }
    }

    static /* synthetic */ void b(a aVar) {
        List<com.baidu.liantian.rp.a.a> w5 = aVar.f10494a.w();
        if (w5 != null) {
            for (com.baidu.liantian.rp.a.a aVar2 : w5) {
                if (aVar.a(aVar.f10494a.f10461e.getString("li_pk_s", ""), aVar2.f10470b)) {
                    e eVar = aVar.f10494a;
                    String str = aVar2.f10472d;
                    String string = eVar.f10461e.getString("re_net_ali2_" + str, "");
                    String c6 = com.baidu.liantian.b.e.c();
                    if (!string.equals(c6)) {
                        String b6 = aVar.f10494a.b(aVar2.f10472d);
                        com.baidu.liantian.rp.c.a aVar3 = new com.baidu.liantian.rp.c.a();
                        aVar3.f10481b = aVar2.f10472d;
                        aVar3.f10486g = 0;
                        aVar3.f10482c = 2;
                        aVar3.f10484e = System.currentTimeMillis();
                        aVar3.f10485f = 1;
                        aVar3.f10488i = 5;
                        aVar3.f10483d = com.baidu.liantian.b.e.a(aVar.f10495b, aVar2, b6, true).toString();
                        com.baidu.liantian.rp.b.a.a(aVar.f10495b).a(aVar3);
                        String a6 = o.a(com.baidu.liantian.b.e.n(aVar.f10495b).toString());
                        if (com.baidu.liantian.rp.b.a.a(aVar.f10495b).b(a6)) {
                            aVar3.f10481b = "1001001";
                            aVar3.f10488i = 0;
                            Context context = aVar.f10495b;
                            aVar3.f10483d = com.baidu.liantian.b.e.a(context, aVar2.f10469a, aVar2.f10471c, "1001001", com.baidu.liantian.b.e.n(context).toString()).toString();
                            com.baidu.liantian.rp.b.a.a(aVar.f10495b).a(aVar3);
                            com.baidu.liantian.rp.b.a.a(aVar.f10495b).a(a6);
                        }
                        e eVar2 = aVar.f10494a;
                        String str2 = aVar2.f10472d;
                        eVar2.f10462f.putString("re_net_ali2_" + str2, c6);
                        eVar2.f10462f.commit();
                    }
                }
            }
        }
    }

    public a(Context context) {
        this.f10495b = StubApp.getOrigApplicationContext(context.getApplicationContext());
        this.f10494a = new e(this.f10495b);
        this.f10496c = new com.baidu.liantian.rp.d.a.a(this.f10495b);
    }

    private void a(List<com.baidu.liantian.rp.c.a> list, int i6, long j6) {
        JSONObject jSONObject;
        int length;
        int i7 = this.f10494a.f10461e.getInt("re_net_one_lt", 5);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Iterator<com.baidu.liantian.rp.c.a> it = list.iterator();
        int i8 = 0;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            com.baidu.liantian.rp.c.a next = it.next();
            try {
                String jSONObject2 = com.baidu.liantian.b.e.a(this.f10495b, new JSONObject(next.f10483d)).toString();
                try {
                    jSONObject = new JSONObject(jSONObject2);
                    length = jSONObject2.length() + i8;
                } catch (Exception unused) {
                    com.baidu.liantian.b.e.a();
                }
            } catch (Exception unused2) {
                com.baidu.liantian.b.e.a();
            }
            if (length >= 1048576 * i7) {
                b.a();
                break;
            } else {
                arrayList.add(Integer.valueOf(next.f10480a));
                arrayList2.add(new com.baidu.liantian.rp.c.b(jSONObject, next.f10489j, next.f10480a));
                i8 = length;
            }
        }
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        JSONArray jSONArray = new JSONArray();
        ArrayList arrayList3 = new ArrayList();
        for (int i9 = 0; i9 < arrayList2.size(); i9++) {
            com.baidu.liantian.rp.c.b bVar = (com.baidu.liantian.rp.c.b) arrayList2.get(i9);
            if (bVar != null) {
                String str = bVar.f10491b;
                if (TextUtils.isEmpty(str)) {
                    jSONArray.put(bVar.f10490a);
                    arrayList3.add(Integer.valueOf(bVar.f10492c));
                } else {
                    if (hashMap.containsKey(str)) {
                        JSONArray jSONArray2 = (JSONArray) hashMap.get(str);
                        if (jSONArray2 == null) {
                            jSONArray2 = new JSONArray();
                        }
                        jSONArray2.put(bVar.f10490a);
                        hashMap.put(str, jSONArray2);
                    } else {
                        JSONArray jSONArray3 = new JSONArray();
                        jSONArray3.put(bVar.f10490a);
                        hashMap.put(str, jSONArray3);
                    }
                    ArrayList arrayList4 = (ArrayList) hashMap2.get(str);
                    if (arrayList4 == null) {
                        arrayList4 = new ArrayList();
                    }
                    arrayList4.add(Integer.valueOf(bVar.f10492c));
                    hashMap2.put(str, arrayList4);
                }
            }
        }
        b.a();
        if (jSONArray.length() > 0) {
            if (this.f10496c.a(jSONArray.toString(), null)) {
                b.a();
                com.baidu.liantian.rp.b.a.a(this.f10495b).a(arrayList3);
            }
        } else {
            b.a();
        }
        if (hashMap.size() > 0) {
            for (String str2 : hashMap.keySet()) {
                JSONArray jSONArray4 = (JSONArray) hashMap.get(str2);
                if (jSONArray4 != null && jSONArray4.length() > 0 && this.f10496c.a(jSONArray4.toString(), str2)) {
                    b.a();
                    com.baidu.liantian.rp.b.a.a(this.f10495b).a((List<Integer>) hashMap2.get(str2));
                }
            }
        } else {
            b.a();
        }
        com.baidu.liantian.rp.b.a.a(this.f10495b).c();
        if (2 != i6) {
            this.f10494a.e(i8 + j6);
        }
    }

    private boolean a(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return false;
        }
        if (str2.equals(this.f10495b.getPackageName())) {
            return true;
        }
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONArray jSONArray = new JSONArray(str);
                for (int i6 = 0; i6 < jSONArray.length(); i6++) {
                    if (str2.equals(jSONArray.get(i6))) {
                        return true;
                    }
                }
            } catch (Exception unused) {
            }
        }
        return false;
    }

    static /* synthetic */ void a(a aVar) {
        if (System.currentTimeMillis() - aVar.f10494a.f10461e.getLong("re_net_pu_de", 0L) >= 86400000) {
            com.baidu.liantian.rp.d.a.a aVar2 = aVar.f10496c;
            try {
                String a6 = h.a(aVar2.f10493a, com.baidu.liantian.b.e.b() + "p/1/rs", "", false, true);
                b.a();
                JSONObject jSONObject = new JSONObject(a6).getJSONObject("c");
                e eVar = new e(aVar2.f10493a);
                int optInt = jSONObject.optInt("n");
                if (optInt > 0) {
                    eVar.f10462f.putInt("re_net_ty", optInt);
                    eVar.f10462f.commit();
                }
                int optInt2 = jSONObject.optInt("i");
                if (optInt2 > 0) {
                    eVar.f10462f.putInt("re_net_hr", optInt2);
                    eVar.f10462f.commit();
                }
                int optInt3 = jSONObject.optInt("i2");
                if (optInt3 > 0) {
                    eVar.f10462f.putInt("re_net_hr_bc", optInt3);
                    eVar.f10462f.commit();
                }
                int optInt4 = jSONObject.optInt(IAdInterListener.AdReqParam.WIDTH);
                if (optInt4 > 0) {
                    eVar.f10462f.putInt("re_net_wt", optInt4);
                    eVar.f10462f.commit();
                }
                if (jSONObject.optInt("s1") > 0) {
                    eVar.f10462f.putInt("re_net_one_lt", jSONObject.optInt("s1"));
                    eVar.f10462f.commit();
                }
                int optInt5 = jSONObject.optInt("s2");
                if (optInt5 > 0) {
                    eVar.f10462f.putInt("re_net_dy_lt", optInt5);
                    eVar.f10462f.commit();
                }
                int optInt6 = jSONObject.optInt(bi.aL);
                if (optInt6 > 0) {
                    eVar.f10462f.putInt("re_net_over", optInt6);
                    eVar.f10462f.commit();
                }
                int optInt7 = jSONObject.optInt("l1");
                if (optInt7 > 0) {
                    eVar.f10462f.putInt("up_nu_co", optInt7);
                    eVar.f10462f.commit();
                }
                int optInt8 = jSONObject.optInt("l2");
                if (optInt8 > 0) {
                    eVar.f10462f.putInt("up_nu_li", optInt8);
                    eVar.f10462f.commit();
                }
            } catch (Throwable unused) {
                com.baidu.liantian.b.e.a();
            }
            e eVar2 = aVar.f10494a;
            eVar2.f10462f.putLong("re_net_pu_de", System.currentTimeMillis());
            eVar2.f10462f.commit();
        }
    }

    static /* synthetic */ void a(a aVar, int i6, int i7) {
        List<com.baidu.liantian.rp.c.a> a6;
        if (i7 == 0) {
            b.a();
            return;
        }
        if (i6 == 1) {
            a6 = com.baidu.liantian.rp.b.a.a(aVar.f10495b).a();
            if (1 == i7) {
                a6.size();
                b.a();
            }
        } else if (i6 == 3) {
            a6 = com.baidu.liantian.rp.b.a.a(aVar.f10495b).a(false, i7);
        } else if (i6 == 4) {
            a6 = com.baidu.liantian.rp.b.a.a(aVar.f10495b).a(true, i7);
            a6.size();
            b.a();
        } else {
            a6 = com.baidu.liantian.rp.b.a.a(aVar.f10495b).a(i7);
        }
        if (a6.size() <= 0) {
            b.a();
            return;
        }
        long j6 = aVar.f10494a.f10461e.getLong("re_day_len", 0L);
        long currentTimeMillis = System.currentTimeMillis();
        long j7 = aVar.f10494a.f10461e.getLong("re_day_b_t", 0L);
        int i8 = aVar.f10494a.f10461e.getInt("re_net_dy_lt", 50);
        if (j7 == 0) {
            aVar.f10494a.f(currentTimeMillis);
            j7 = currentTimeMillis;
        }
        b.a();
        b.a();
        if (currentTimeMillis - j7 < 86400000) {
            b.a();
            if (i6 == 3) {
                int i9 = aVar.f10494a.f10461e.getInt("g_r_d_d_n", 0);
                b.a();
                if (i9 >= 5) {
                    b.a();
                    return;
                }
                aVar.f10494a.h(i9 + 1);
            }
            if (j6 > i8 * 1048576) {
                b.a();
                return;
            }
        } else {
            aVar.f10494a.e(0L);
            aVar.f10494a.f(currentTimeMillis);
            if (i6 == 3) {
                aVar.f10494a.h(0);
            }
        }
        do {
            aVar.a(a6, i7, j6);
            List<com.baidu.liantian.rp.c.a> list = null;
            if (i6 == 0 && i7 == 2) {
                list = com.baidu.liantian.rp.b.a.a(aVar.f10495b).a(i7);
            }
            a6 = list;
            if (a6 == null) {
                return;
            }
        } while (a6.size() != 0);
    }
}
