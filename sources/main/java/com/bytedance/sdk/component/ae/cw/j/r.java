package com.bytedance.sdk.component.ae.cw.j;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import com.baidu.mobads.sdk.api.IAdInterListener;
import java.util.Map;
import xyz.adscope.common.v2.dev.info.ResIdentify;

/* loaded from: D:\Downloads\app\classes4.dex */
public class r {
    public Uri insert(Uri uri, ContentValues contentValues) {
        if (contentValues == null) {
            return null;
        }
        String str = uri.getPath().split("/")[3];
        Object obj = contentValues.get("value");
        if (obj != null) {
            cw.j(uri.getQueryParameter("sp_file_name"), str, obj);
        }
        return null;
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        if (contentValues == null) {
            return 0;
        }
        insert(uri, contentValues);
        return 0;
    }

    public String j() {
        return "t_sp";
    }

    public int delete(Uri uri, String str, String[] strArr) {
        String[] split = uri.getPath().split("/");
        if (split[2].equals("clean")) {
            cw.j(uri.getQueryParameter("sp_file_name"));
            return 0;
        }
        String str2 = split[3];
        if (cw.j(uri.getQueryParameter("sp_file_name"), str2)) {
            cw.xt(uri.getQueryParameter("sp_file_name"), str2);
        }
        return 0;
    }

    public String getType(Uri uri) {
        String[] split = uri.getPath().split("/");
        String str = split[2];
        String str2 = split[3];
        if (str.equals("contain")) {
            StringBuilder sb = new StringBuilder();
            sb.append(cw.j(uri.getQueryParameter("sp_file_name"), str2));
            return sb.toString();
        }
        return cw.j(uri.getQueryParameter("sp_file_name"), str2, str);
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        Map<String, ?> xt;
        if (uri.getPath().split("/")[2].equals("get_all") && (xt = cw.xt(uri.getQueryParameter("sp_file_name"))) != null) {
            MatrixCursor matrixCursor = new MatrixCursor(new String[]{"cursor_name", "cursor_type", "cursor_value"});
            for (String str3 : xt.keySet()) {
                Object[] objArr = new Object[3];
                objArr[0] = str3;
                Object obj = xt.get(str3);
                objArr[2] = obj;
                if (obj instanceof Boolean) {
                    objArr[1] = "boolean";
                } else if (obj instanceof String) {
                    objArr[1] = ResIdentify.RES_TYPE_STRING;
                } else if (obj instanceof Integer) {
                    objArr[1] = IAdInterListener.AdProdType.PRODUCT_INTERSTITIAL;
                } else if (obj instanceof Long) {
                    objArr[1] = "long";
                } else if (obj instanceof Float) {
                    objArr[1] = "float";
                }
                matrixCursor.addRow(objArr);
            }
            return matrixCursor;
        }
        return null;
    }
}
