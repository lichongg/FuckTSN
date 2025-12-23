package xyz.adscope.amps.adapter.bd.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.util.Base64;

/* loaded from: D:\Downloads\app\classes9.dex */
public class Base64Util {
    public static Bitmap base64ToBitmap(String str) {
        try {
            byte[] decode = Base64.decode(str.toString().trim(), 2);
            return BitmapFactory.decodeByteArray(decode, 0, decode.length);
        } catch (Exception e6) {
            e6.printStackTrace();
            return null;
        }
    }

    public static BitmapDrawable base64ToBitmapDrawable(String str) {
        try {
            byte[] decode = Base64.decode(str.toString().trim(), 2);
            return new BitmapDrawable(BitmapFactory.decodeByteArray(decode, 0, decode.length));
        } catch (Exception e6) {
            e6.printStackTrace();
            return null;
        }
    }
}
