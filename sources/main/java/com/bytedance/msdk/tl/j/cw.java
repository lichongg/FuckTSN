package com.bytedance.msdk.tl.j;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.LinkedList;
import java.util.List;

/* loaded from: D:\Downloads\app\classes3.dex */
public class cw {

    /* renamed from: j, reason: collision with root package name */
    private static volatile cw f25214j;
    private Uri xt;

    public static cw j() {
        if (f25214j == null) {
            synchronized (cw.class) {
                try {
                    if (f25214j == null) {
                        f25214j = new cw();
                    }
                } finally {
                }
            }
        }
        return f25214j;
    }

    private cw() {
        if (com.bytedance.msdk.core.xt.getContext() != null) {
            this.xt = Uri.parse("content://" + com.bytedance.msdk.core.xt.getContext().getPackageName() + ".TTMultiProvider/gromore_prime_rit_adn_perform");
        }
    }

    public void insert(String str, String str2, String str3, String str4) {
        if (com.bytedance.msdk.core.xt.getContext() != null && this.xt != null) {
            ContentResolver contentResolver = com.bytedance.msdk.core.xt.getContext().getContentResolver();
            ContentValues contentValues = new ContentValues();
            contentValues.put(MediationConstant.EXTRA_ADN_NAME, str);
            contentValues.put(MediationConstant.KEY_GM_PRIME_RIT, str2);
            contentValues.put("adn_rit", str3);
            contentValues.put("ad_action", str4);
            contentValues.put("time_stamp", Long.valueOf(System.currentTimeMillis()));
            contentResolver.insert(this.xt, contentValues);
        }
    }

    public List<xt> query(String str, String str2, long j6, long j7) {
        String str3;
        if (com.bytedance.msdk.core.xt.getContext() != null && this.xt != null) {
            ContentResolver contentResolver = com.bytedance.msdk.core.xt.getContext().getContentResolver();
            String[] strArr = {str, str2, String.valueOf(j6), String.valueOf(j7)};
            if (TextUtils.isEmpty(str)) {
                strArr = new String[]{str2, String.valueOf(j6), String.valueOf(j7)};
                str3 = "prime_rit=? AND time_stamp>=? AND time_stamp<?";
            } else {
                str3 = "adn_name=? AND prime_rit=? AND time_stamp>=? AND time_stamp<?";
            }
            Cursor query = contentResolver.query(this.xt, null, str3, strArr, null);
            if (query != null) {
                LinkedList linkedList = new LinkedList();
                while (query.moveToNext()) {
                    try {
                        String string = query.getString(query.getColumnIndex(MediationConstant.EXTRA_ADN_NAME));
                        String string2 = query.getString(query.getColumnIndex(MediationConstant.KEY_GM_PRIME_RIT));
                        String string3 = query.getString(query.getColumnIndex("adn_rit"));
                        String string4 = query.getString(query.getColumnIndex("ad_action"));
                        long j8 = query.getLong(query.getColumnIndex("time_stamp"));
                        xt xtVar = new xt();
                        xtVar.cw(string);
                        xtVar.j(string2);
                        xtVar.xt(string3);
                        xtVar.r(string4);
                        xtVar.j(j8);
                        linkedList.add(xtVar);
                    } finally {
                        query.close();
                    }
                }
                return linkedList;
            }
            return null;
        }
        return null;
    }

    public void j(String str, long j6) {
        if (com.bytedance.msdk.core.xt.getContext() == null || this.xt == null || j6 <= 0) {
            return;
        }
        try {
            com.bytedance.msdk.core.xt.getContext().getContentResolver().delete(this.xt, "prime_rit=? AND time_stamp<?", new String[]{str, String.valueOf(j6)});
        } catch (IllegalStateException unused) {
        }
    }
}
