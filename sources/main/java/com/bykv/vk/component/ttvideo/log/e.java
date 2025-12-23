package com.bykv.vk.component.ttvideo.log;

import android.content.Context;
import android.provider.Settings;
import com.bykv.vk.component.ttvideo.utils.TTVideoEngineLog;
import com.stub.StubApp;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes3.dex */
public enum e {
    instance;


    /* renamed from: a, reason: collision with root package name */
    private VideoEventEngineUploader f22911a;

    /* renamed from: b, reason: collision with root package name */
    private Context f22912b;

    public void a(Context context) {
        this.f22912b = StubApp.getOrigApplicationContext(context.getApplicationContext());
    }

    public synchronized void a(VideoEventEngineUploader videoEventEngineUploader) {
        this.f22911a = videoEventEngineUploader;
    }

    private void a(JSONObject jSONObject) {
        if (((TTVideoEngineLog.LogNotifyLevel >> 2) & 1) == 1 || ((TTVideoEngineLog.LogTurnOn >> 2) & 1) == 1) {
            TTVideoEngineLog.i("VideoEventManager", jSONObject.toString());
        }
        if (((TTVideoEngineLog.LogTurnOn >> 1) & 1) == 1) {
            Context context = this.f22912b;
            String string = context != null ? Settings.Global.getString(context.getContentResolver(), "engine.debug") : "";
            if (string != null) {
                for (String str : string.split(",", -1)) {
                    if (jSONObject.opt(str) != null) {
                        TTVideoEngineLog.i("VideoEventManager", str + ":" + jSONObject.opt(str));
                    }
                }
            }
        }
    }

    protected void a(boolean z5, JSONObject jSONObject) {
        synchronized (e.class) {
            if (jSONObject != null) {
                try {
                    a(jSONObject);
                    VideoEventEngineUploader videoEventEngineUploader = this.f22911a;
                    if (videoEventEngineUploader != null) {
                        videoEventEngineUploader.onEvent("video_playq", jSONObject);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }
}
