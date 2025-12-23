package com.bykv.vk.component.ttvideo.player;

import android.annotation.SuppressLint;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.openadsdk.l.m;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Deprecated
/* loaded from: D:\Downloads\app\classes3.dex */
public class TTPlayerLibraryLoader {
    private static final int DEGRADED_VERSION = 2925;
    private static final String TAG = "TTPlayerLibraryLoader";
    private static ILibraryLoader mDebugLibraryLoader;
    private static ILibraryLoader mLibraryLoader;
    private static ILibraryLoader mPluginLibLoader;
    private static ILibraryLoader mDefaultLibLoader = new DefaultLibraryLoader(null);
    private static boolean mLibraryLoaded = false;
    private static boolean IsErrored = false;
    private static String mErrorInfo = null;
    private static int mVersion = 0;

    /* renamed from: com.bykv.vk.component.ttvideo.player.TTPlayerLibraryLoader$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static class DefaultLibraryLoader implements ILibraryLoader {
        private DefaultLibraryLoader() {
        }

        /* synthetic */ DefaultLibraryLoader(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.bykv.vk.component.ttvideo.player.ILibraryLoader
        public boolean onLoadNativeLibs(List<String> list) {
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                try {
                    m.j(it.next());
                } catch (Throwable th) {
                    String unused = TTPlayerLibraryLoader.mErrorInfo = th.getMessage();
                    String unused2 = TTPlayerLibraryLoader.TAG;
                    String unused3 = TTPlayerLibraryLoader.mErrorInfo;
                    return false;
                }
            }
            return true;
        }
    }

    public static String getErrorInfo() {
        return mErrorInfo;
    }

    public static boolean isError() {
        return IsErrored;
    }

    public static final synchronized void loadLibrary() {
        synchronized (TTPlayerLibraryLoader.class) {
            try {
                if (mVersion == 0) {
                    mVersion = TTPlayerConfiger.getValue(13, 0) / 1000;
                }
                boolean z5 = mVersion == DEGRADED_VERSION;
                if (TTPlayerConfiger.getValue(3, false)) {
                    if (!z5) {
                        loadPlayerlibrary("ttopenssl");
                        loadPlayerlibrary("mffmpeg");
                    }
                    if (!loadPlayerlibrary("ttmplayer")) {
                        IsErrored = true;
                    }
                } else {
                    ArrayList arrayList = new ArrayList();
                    if (!z5) {
                        arrayList.add("ttopenssl");
                        arrayList.add("mffmpeg");
                    }
                    arrayList.add("ttmplayer");
                    IsErrored = !loadLibs(arrayList, false);
                }
            } catch (Throwable th) {
                IsErrored = true;
                vl.j(th);
                mErrorInfo = "load default library error." + th.toString();
            }
        }
    }

    private static boolean loadLibs(List<String> list, boolean z5) {
        boolean z6 = mLibraryLoaded;
        if ((!z5) && z6) {
            return z6;
        }
        ILibraryLoader iLibraryLoader = mLibraryLoader;
        if (iLibraryLoader != null) {
            try {
                mLibraryLoaded = iLibraryLoader.onLoadNativeLibs(list);
            } catch (Throwable th) {
                mErrorInfo = th.getMessage();
            }
        } else {
            ILibraryLoader iLibraryLoader2 = mPluginLibLoader;
            if (iLibraryLoader2 != null) {
                try {
                    mLibraryLoaded = iLibraryLoader2.onLoadNativeLibs(list);
                } catch (Throwable th2) {
                    mErrorInfo = th2.getMessage();
                }
            } else {
                mLibraryLoaded = mDefaultLibLoader.onLoadNativeLibs(list);
            }
        }
        return mLibraryLoaded;
    }

    @SuppressLint({"UnsafeDynamicallyLoadedCode"})
    private static boolean loadPlayerlibrary(String str) {
        String str2;
        try {
            TTPlayerConfiger.setLibraryName("lib" + str + ".so");
            TTPlayerConfiger.checkDebugTTPlayerLib();
            str2 = TTPlayerConfiger.getPlayerLibraryPath();
            if (str2 != null && !new File(str2).exists()) {
                str2 = null;
            }
            if (str2 != null) {
                if (mDebugLibraryLoader != null) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(str2);
                    mDebugLibraryLoader.onLoadNativeLibs(arrayList);
                } else {
                    System.load(str2);
                }
            }
        } catch (Throwable th) {
            vl.j(th);
            mErrorInfo = "load path library error." + th.toString();
            str2 = null;
        }
        if (str2 == null) {
            try {
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add(str);
                loadLibs(arrayList2, true);
                mErrorInfo = null;
            } catch (Throwable unused) {
                vl.r(TAG, "load lib failed name = ".concat(String.valueOf(str)));
                return false;
            }
        }
        return true;
    }

    public static final void setDebugLibraryLoader(ILibraryLoader iLibraryLoader) {
        mDebugLibraryLoader = iLibraryLoader;
    }

    public static final void setLibraryLoader(ILibraryLoader iLibraryLoader) {
        mLibraryLoader = iLibraryLoader;
    }

    public static final void setPluginLibraryLoader(ILibraryLoader iLibraryLoader) {
        mPluginLibLoader = iLibraryLoader;
    }
}
