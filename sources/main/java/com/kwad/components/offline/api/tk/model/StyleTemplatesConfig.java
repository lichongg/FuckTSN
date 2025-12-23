package com.kwad.components.offline.api.tk.model;

import com.kwad.components.offline.api.core.model.BaseOfflineCompoJsonParse;
import com.kwad.sdk.utils.aa;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class StyleTemplatesConfig extends BaseOfflineCompoJsonParse<StyleTemplatesConfig> implements Serializable {
    private static final long serialVersionUID = -6279192768068169498L;
    public List<StyleTemplate> styleTemplates = new ArrayList();

    @Override // com.kwad.components.offline.api.core.model.BaseOfflineCompoJsonParse
    public void parseJson(StyleTemplatesConfig styleTemplatesConfig, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        styleTemplatesConfig.styleTemplates = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("styleTemplates");
        if (optJSONArray != null) {
            for (int i6 = 0; i6 < optJSONArray.length(); i6++) {
                StyleTemplate styleTemplate = new StyleTemplate();
                styleTemplate.parseJson(optJSONArray.optJSONObject(i6));
                styleTemplatesConfig.styleTemplates.add(styleTemplate);
            }
        }
    }

    @Override // com.kwad.components.offline.api.core.model.BaseOfflineCompoJsonParse
    public JSONObject toJson(StyleTemplatesConfig styleTemplatesConfig, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        aa.putValue(jSONObject, "styleTemplates", styleTemplatesConfig.styleTemplates);
        return jSONObject;
    }

    @Override // com.kwad.components.offline.api.core.model.BaseOfflineCompoJsonParse
    public JSONObject toJson(StyleTemplatesConfig styleTemplatesConfig) {
        return toJson(styleTemplatesConfig, (JSONObject) null);
    }
}
