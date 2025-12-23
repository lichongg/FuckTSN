package com.umeng.socialize.shareboard;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.umeng.socialize.shareboard.widgets.SocializePagerAdapter;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
class SocializeMenuAdapter extends SocializePagerAdapter {
    private Context mContext;
    private ShareBoardMenuHelper mMenuHelper;
    private List<SnsPlatform[][]> mPageData;

    public SocializeMenuAdapter(Context context, ShareBoardConfig shareBoardConfig) {
        this(context, shareBoardConfig, null);
    }

    public SocializeMenuAdapter(Context context, ShareBoardConfig shareBoardConfig, List<SnsPlatform> list) {
        this.mPageData = new ArrayList();
        this.mContext = context;
        this.mMenuHelper = new ShareBoardMenuHelper(shareBoardConfig);
        setData(list);
    }

    @Override // com.umeng.socialize.shareboard.widgets.SocializePagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i6, Object obj) {
        viewGroup.removeView((View) obj);
    }

    @Override // com.umeng.socialize.shareboard.widgets.SocializePagerAdapter
    public int getCount() {
        List<SnsPlatform[][]> list = this.mPageData;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // com.umeng.socialize.shareboard.widgets.SocializePagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i6) {
        View createPageLayout = this.mMenuHelper.createPageLayout(this.mContext, this.mPageData.get(i6));
        viewGroup.addView(createPageLayout);
        return createPageLayout;
    }

    @Override // com.umeng.socialize.shareboard.widgets.SocializePagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    public void setData(List<SnsPlatform> list) {
        this.mPageData.clear();
        if (list != null) {
            this.mPageData.addAll(this.mMenuHelper.formatPageData(list));
        }
        notifyDataSetChanged();
    }
}
