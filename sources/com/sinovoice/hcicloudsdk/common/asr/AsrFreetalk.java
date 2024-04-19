package com.sinovoice.hcicloudsdk.common.asr;

import com.sinovoice.hcicloudsdk.api.asr.HciCloudAsr;
import com.sinovoice.hcicloudsdk.common.Session;
import java.util.ArrayList;
import java.util.Arrays;
/* loaded from: classes.dex */
public final class AsrFreetalk extends AsrCommon {
    private int c;

    public AsrFreetalk(IAsrHandler iAsrHandler) {
        super(iAsrHandler);
        this.c = 0;
    }

    @Override // com.sinovoice.hcicloudsdk.common.asr.AsrCommon
    protected final int a() {
        this.c = 0;
        return 0;
    }

    @Override // com.sinovoice.hcicloudsdk.common.asr.AsrCommon
    protected final int a(Session session, byte[] bArr, int i) {
        if (i < 320000) {
            bArr = Arrays.copyOf(bArr, i);
        }
        AsrRecogResult asrRecogResult = new AsrRecogResult();
        this.c += i;
        int hciAsrRecog = HciCloudAsr.hciAsrRecog(session, bArr, this.f343b, null, asrRecogResult);
        if (hciAsrRecog == 211) {
            return 0;
        }
        if (hciAsrRecog == 216) {
            return 3;
        }
        if (hciAsrRecog == 214) {
            return 4;
        }
        if (hciAsrRecog != 0) {
            this.f342a.onError(this, "流式识别", hciAsrRecog);
            return 2;
        }
        return 0;
    }

    @Override // com.sinovoice.hcicloudsdk.common.asr.AsrCommon
    protected final int a(Session session) {
        AsrRecogItem asrRecogItem;
        String recogResult;
        if (this.c == 0) {
            return 0;
        }
        AsrRecogResult asrRecogResult = new AsrRecogResult();
        AsrResult asrResult = null;
        int hciAsrRecog = HciCloudAsr.hciAsrRecog(session, null, this.f343b, null, asrRecogResult);
        if (hciAsrRecog == 0) {
            ArrayList<AsrRecogItem> recogItemList = asrRecogResult.getRecogItemList();
            if (recogItemList != null && recogItemList.size() > 0 && (recogResult = (asrRecogItem = recogItemList.get(0)).getRecogResult()) != null && !recogResult.isEmpty()) {
                asrResult = new AsrResult(recogResult, asrRecogItem.getScore());
            }
            this.f342a.onResult(this, asrResult);
            return 0;
        }
        this.f342a.onError(this, "流式识别尾段", hciAsrRecog);
        return 2;
    }

    @Override // com.sinovoice.hcicloudsdk.common.asr.AsrCommon
    protected final int a(Session session, byte[] bArr) {
        AsrRecogResult asrRecogResult = new AsrRecogResult();
        int hciAsrRecog = HciCloudAsr.hciAsrRecog(session, bArr, this.f343b, null, asrRecogResult);
        if (hciAsrRecog == 0) {
            AsrRecogItem asrRecogItem = asrRecogResult.getRecogItemList().get(0);
            this.f342a.onResult(this, new AsrResult(asrRecogItem.getRecogResult(), asrRecogItem.getScore()));
            return 0;
        }
        this.f342a.onError(this, "非流式识别", hciAsrRecog);
        return 2;
    }
}
