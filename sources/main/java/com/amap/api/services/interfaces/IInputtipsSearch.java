package com.amap.api.services.interfaces;

import com.amap.api.services.core.AMapException;
import com.amap.api.services.help.Inputtips;
import com.amap.api.services.help.InputtipsQuery;
import com.amap.api.services.help.Tip;
import java.util.ArrayList;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public interface IInputtipsSearch {
    InputtipsQuery getQuery();

    ArrayList<Tip> requestInputtips() throws AMapException;

    void requestInputtips(String str, String str2) throws AMapException;

    void requestInputtips(String str, String str2, String str3) throws AMapException;

    void requestInputtipsAsyn();

    void setInputtipsListener(Inputtips.InputtipsListener inputtipsListener);

    void setQuery(InputtipsQuery inputtipsQuery);
}
