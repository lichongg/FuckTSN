package com.baidu.mobads.sdk.api;

import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class XNativeViewManager {
    private static XNativeViewManager sInstance;
    private final ArrayList<XNativeView> mViewList = new ArrayList<>();

    public static XNativeViewManager getInstance() {
        if (sInstance == null) {
            synchronized (XNativeViewManager.class) {
                try {
                    if (sInstance == null) {
                        sInstance = new XNativeViewManager();
                    }
                } finally {
                }
            }
        }
        return sInstance;
    }

    public void addItem(XNativeView xNativeView) {
        this.mViewList.add(xNativeView);
    }

    public void removeNativeView(XNativeView xNativeView) {
        if (this.mViewList.size() == 0) {
            return;
        }
        this.mViewList.remove(xNativeView);
    }

    public void resetAllPlayer(XNativeView xNativeView) {
        if (this.mViewList.size() == 0) {
            return;
        }
        Iterator<XNativeView> it = this.mViewList.iterator();
        while (it.hasNext()) {
            XNativeView next = it.next();
            if (next != xNativeView) {
                next.stop();
                next.handleCover();
            }
        }
    }

    private XNativeViewManager() {
    }
}
