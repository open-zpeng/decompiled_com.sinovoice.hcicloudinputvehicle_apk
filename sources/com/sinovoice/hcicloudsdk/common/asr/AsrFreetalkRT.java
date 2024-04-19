package com.sinovoice.hcicloudsdk.common.asr;

import com.sinovoice.hcicloudsdk.api.asr.HciCloudAsr;
import com.sinovoice.hcicloudsdk.common.Session;
import com.sinovoice.hcicloudsdk.common.utils.CloudLog;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class AsrFreetalkRT extends AsrCommon {
    private static final String c = "AsrFreetalkRT";
    private int d;

    public AsrFreetalkRT(IAsrHandler iAsrHandler) {
        super(iAsrHandler);
        this.d = 0;
    }

    @Override // com.sinovoice.hcicloudsdk.common.asr.AsrCommon
    protected final int a() {
        this.d = 0;
        return 0;
    }

    @Override // com.sinovoice.hcicloudsdk.common.asr.AsrCommon
    protected final int a(Session session, byte[] bArr, int i) {
        if (i < 320000) {
            bArr = Arrays.copyOf(bArr, i);
        }
        AsrRecogResult asrRecogResult = new AsrRecogResult();
        this.d += i;
        int hciAsrRecog = HciCloudAsr.hciAsrRecog(session, bArr, this.f343b, null, asrRecogResult);
        if (hciAsrRecog == 211) {
            a(asrRecogResult.getRecogItemList());
            return 0;
        } else if (hciAsrRecog == 216) {
            return 3;
        } else {
            if (hciAsrRecog == 214) {
                return 4;
            }
            if (hciAsrRecog != 0) {
                this.f342a.onError(this, "实时反馈", hciAsrRecog);
                return 2;
            }
            return 0;
        }
    }

    @Override // com.sinovoice.hcicloudsdk.common.asr.AsrCommon
    protected final int a(Session session) {
        if (this.d == 0) {
            return 0;
        }
        AsrRecogResult asrRecogResult = new AsrRecogResult();
        int hciAsrRecog = HciCloudAsr.hciAsrRecog(session, null, this.f343b, null, asrRecogResult);
        if (hciAsrRecog == 0) {
            return a(asrRecogResult.getRecogItemList());
        }
        this.f342a.onError(this, "实时反馈尾段", hciAsrRecog);
        return 2;
    }

    @Override // com.sinovoice.hcicloudsdk.common.asr.AsrCommon
    protected final int a(Session session, byte[] bArr) {
        throw new IllegalStateException();
    }

    private int a(ArrayList<AsrRecogItem> arrayList) {
        if (arrayList != null && arrayList.size() > 0) {
            Iterator<AsrRecogItem> it = arrayList.iterator();
            while (it.hasNext()) {
                try {
                    JSONArray jSONArray = new JSONObject(it.next().getRecogResult()).getJSONArray("Segment");
                    int length = jSONArray.length();
                    for (int i = 0; i < length; i++) {
                        JSONObject jSONObject = jSONArray.getJSONObject(i);
                        this.f342a.onResult(this, new AsrResult(jSONObject.getString("Text"), jSONObject.getInt("Score"), jSONObject.getInt("StartTime"), jSONObject.getInt("EndTime")));
                    }
                } catch (JSONException e) {
                    StringWriter stringWriter = new StringWriter();
                    e.printStackTrace(new PrintWriter(stringWriter));
                    String str = c;
                    CloudLog.e(str, "实时反馈结果解析异常: " + stringWriter.toString());
                    this.f342a.onError(this, "实时反馈结果解析异常", -1);
                    return 2;
                }
            }
        }
        return 0;
    }
}
