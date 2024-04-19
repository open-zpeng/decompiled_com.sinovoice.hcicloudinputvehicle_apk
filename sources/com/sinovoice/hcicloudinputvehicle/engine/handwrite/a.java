package com.sinovoice.hcicloudinputvehicle.engine.handwrite;

import com.sinovoice.hcicloudsdk.api.hwr.HciCloudHwr;
import com.sinovoice.hcicloudsdk.common.Session;
import com.sinovoice.hcicloudsdk.common.hwr.HwrAssociateWordsResult;
import com.sinovoice.hcicloudsdk.common.hwr.HwrConfig;
import java.util.ArrayList;
/* compiled from: ChineseAssWrapper.java */
/* loaded from: classes.dex */
class a implements AssociateSDKWrapper {

    /* renamed from: a  reason: collision with root package name */
    private static final String f158a = "a";

    /* renamed from: b  reason: collision with root package name */
    private Session f159b;

    @Override // com.sinovoice.hcicloudinputvehicle.engine.handwrite.AssociateSDKWrapper
    public ArrayList<String> associate(String str) {
        HwrAssociateWordsResult hwrAssociateWordsResult = new HwrAssociateWordsResult();
        int hciHwrAssociateWords = HciCloudHwr.hciHwrAssociateWords(this.f159b, null, str, hwrAssociateWordsResult);
        String str2 = f158a;
        b.b.a.b.a.c(str2, "hciHwrAssociateWords result = " + hciHwrAssociateWords);
        if (hwrAssociateWordsResult.getResultList() != null) {
            return hwrAssociateWordsResult.getResultList();
        }
        return new ArrayList<>();
    }

    @Override // com.sinovoice.hcicloudinputvehicle.engine.handwrite.AssociateSDKWrapper
    public void init() {
        this.f159b = new Session();
        HwrConfig hwrConfig = new HwrConfig();
        hwrConfig.addParam("capKey", "hwr.local.associateword");
        hwrConfig.addParam(HwrConfig.AssociateConfig.PARAM_KEY_ASSOCIATE_MODEL, "multi");
        hwrConfig.addParam("resPrefix", "cn.");
        HciCloudHwr.hciHwrSessionStart(hwrConfig.getStringConfig(), this.f159b);
    }

    @Override // com.sinovoice.hcicloudinputvehicle.engine.handwrite.AssociateSDKWrapper
    public void raisePriority(String str) {
        int hciHwrAssociateWordsAdjust = HciCloudHwr.hciHwrAssociateWordsAdjust(this.f159b, null, str);
        String str2 = f158a;
        b.b.a.b.a.c(str2, "advanceAssociateWord result = " + hciHwrAssociateWordsAdjust);
    }

    @Override // com.sinovoice.hcicloudinputvehicle.engine.handwrite.AssociateSDKWrapper
    public void release() {
        Session session = this.f159b;
        if (session != null) {
            int hciHwrSessionStop = HciCloudHwr.hciHwrSessionStop(session);
            this.f159b = null;
            String str = f158a;
            b.b.a.b.a.c(str, "stopAssociateSession return: " + hciHwrSessionStop);
        }
    }
}
