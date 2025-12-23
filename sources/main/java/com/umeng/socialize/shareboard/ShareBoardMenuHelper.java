package com.umeng.socialize.shareboard;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.common.ResContainer;
import com.umeng.socialize.utils.SLog;
import com.umeng.socialize.utils.UmengText;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import xyz.adscope.common.v2.dev.info.ResIdentify;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
class ShareBoardMenuHelper {
    private static String TAG = "ShareBoardMenuHelper";
    private ShareBoardConfig mShareBoardConfig;

    private View createBtnView(Context context, final SnsPlatform snsPlatform) {
        String str;
        LinearLayout linearLayout = new LinearLayout(context);
        int i6 = 0;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.weight = 1.0f;
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setGravity(17);
        if (snsPlatform != null) {
            ResContainer resContainer = ResContainer.get(context);
            View inflate = LayoutInflater.from(context).inflate(resContainer.layout("socialize_share_menu_item"), (ViewGroup) null);
            SocializeImageView socializeImageView = (SocializeImageView) inflate.findViewById(resContainer.id("socialize_image_view"));
            TextView textView = (TextView) inflate.findViewById(resContainer.id("socialize_text_view"));
            ShareBoardConfig shareBoardConfig = this.mShareBoardConfig;
            int i7 = shareBoardConfig.mMenuBgColor;
            if (i7 == 0 || shareBoardConfig.mMenuBgShape == ShareBoardConfig.BG_SHAPE_NONE) {
                socializeImageView.setPadding(0, 0, 0, 0);
            } else {
                socializeImageView.setBackgroundColor(i7, shareBoardConfig.mMenuBgPressedColor);
                ShareBoardConfig shareBoardConfig2 = this.mShareBoardConfig;
                socializeImageView.setBackgroundShape(shareBoardConfig2.mMenuBgShape, shareBoardConfig2.mMenuBgShapeAngle);
            }
            int i8 = this.mShareBoardConfig.mMenuIconPressedColor;
            if (i8 != 0) {
                socializeImageView.setPressedColor(i8);
            }
            try {
                str = snsPlatform.mShowWord;
            } catch (Exception e6) {
                SHARE_MEDIA share_media = snsPlatform.mPlatform;
                SLog.error(UmengText.SHAREBOARD.NULLNAME + (share_media == null ? "" : share_media.toString()), e6);
                str = "";
            }
            if (!TextUtils.isEmpty(str)) {
                textView.setText(snsPlatform.mShowWord);
            }
            textView.setGravity(17);
            try {
                i6 = ResContainer.getResourceId(context, ResIdentify.RES_TYPE_DRAWABLE, snsPlatform.mIcon);
            } catch (Exception e7) {
                SHARE_MEDIA share_media2 = snsPlatform.mPlatform;
                SLog.error(UmengText.SHAREBOARD.NULLNAME + (share_media2 != null ? share_media2.toString() : ""), e7);
            }
            if (i6 != 0) {
                socializeImageView.setImageResource(i6);
            }
            int i9 = this.mShareBoardConfig.mMenuTextColor;
            if (i9 != 0) {
                textView.setTextColor(i9);
            }
            inflate.setOnClickListener(new View.OnClickListener() { // from class: com.umeng.socialize.shareboard.ShareBoardMenuHelper.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    SHARE_MEDIA share_media3 = snsPlatform.mPlatform;
                    if (ShareBoardMenuHelper.this.mShareBoardConfig == null || ShareBoardMenuHelper.this.mShareBoardConfig.getShareBoardlistener() == null) {
                        return;
                    }
                    ShareBoardMenuHelper.this.mShareBoardConfig.getShareBoardlistener().onclick(snsPlatform, share_media3);
                }
            });
            linearLayout.addView(inflate);
        }
        return linearLayout;
    }

    private View createRowLayout(Context context, SnsPlatform[] snsPlatformArr, boolean z5) {
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(1);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        if (z5) {
            layoutParams.topMargin = dip2px(context, 20.0f);
        }
        linearLayout.setLayoutParams(layoutParams);
        for (SnsPlatform snsPlatform : snsPlatformArr) {
            linearLayout.addView(createBtnView(context, snsPlatform));
        }
        return linearLayout;
    }

    public View createPageLayout(Context context, SnsPlatform[][] snsPlatformArr) {
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        linearLayout.setGravity(48);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        int i6 = 0;
        while (i6 < snsPlatformArr.length) {
            linearLayout.addView(createRowLayout(context, snsPlatformArr[i6], i6 != 0));
            i6++;
        }
        return linearLayout;
    }

    public List<SnsPlatform[][]> formatPageData(List<SnsPlatform> list) {
        int i6;
        int i7 = this.mShareBoardConfig.mMenuColumnNum * 2;
        int size = list.size();
        ArrayList arrayList = new ArrayList();
        int i8 = this.mShareBoardConfig.mMenuColumnNum;
        if (size < i8) {
            SnsPlatform[][] snsPlatformArr = (SnsPlatform[][]) Array.newInstance((Class<?>) SnsPlatform.class, 1, size);
            for (int i9 = 0; i9 < list.size(); i9++) {
                snsPlatformArr[0][i9] = list.get(i9);
            }
            arrayList.add(snsPlatformArr);
            return arrayList;
        }
        int i10 = size / i7;
        int i11 = size % i7;
        if (i11 != 0) {
            i6 = (i11 / i8) + (i11 % i8 != 0 ? 1 : 0);
            i10++;
        } else {
            i6 = -1;
        }
        int i12 = 0;
        while (i12 < i10) {
            arrayList.add((SnsPlatform[][]) Array.newInstance((Class<?>) SnsPlatform.class, (i12 != i10 + (-1) || i6 == -1) ? 2 : i6, this.mShareBoardConfig.mMenuColumnNum));
            i12++;
        }
        int i13 = 0;
        for (int i14 = 0; i14 < arrayList.size(); i14++) {
            for (SnsPlatform[] snsPlatformArr2 : (SnsPlatform[][]) arrayList.get(i14)) {
                for (int i15 = 0; i15 < snsPlatformArr2.length; i15++) {
                    if (i13 < size) {
                        snsPlatformArr2[i15] = list.get(i13);
                    }
                    i13++;
                }
            }
        }
        return arrayList;
    }

    public ShareBoardMenuHelper(ShareBoardConfig shareBoardConfig) {
        this.mShareBoardConfig = shareBoardConfig;
    }

    private int dip2px(Context context, float f6) {
        return (int) ((f6 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }
}
