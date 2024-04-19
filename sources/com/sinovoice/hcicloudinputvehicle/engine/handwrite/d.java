package com.sinovoice.hcicloudinputvehicle.engine.handwrite;

import com.sinovoice.hcicloudsdk.api.hwr.HciCloudHwr;
import com.sinovoice.hcicloudsdk.common.Session;
import com.sinovoice.hcicloudsdk.common.hwr.HwrAssociateWordsResult;
import com.sinovoice.hcicloudsdk.common.hwr.HwrConfig;
import java.util.ArrayList;
/* compiled from: EnglishAssWrapper.java */
/* loaded from: classes.dex */
class d implements AssociateSDKWrapper {

    /* renamed from: a  reason: collision with root package name */
    private static final String f162a = "d";

    /* renamed from: b  reason: collision with root package name */
    private Session f163b;

    @Override // com.sinovoice.hcicloudinputvehicle.engine.handwrite.AssociateSDKWrapper
    public ArrayList<String> associate(String str) {
        HwrAssociateWordsResult hwrAssociateWordsResult = new HwrAssociateWordsResult();
        HciCloudHwr.hciHwrAssociateWords(this.f163b, null, str, hwrAssociateWordsResult);
        return hwrAssociateWordsResult.getResultList();
    }

    @Override // com.sinovoice.hcicloudinputvehicle.engine.handwrite.AssociateSDKWrapper
    public void init() {
        this.f163b = new Session();
        HwrConfig hwrConfig = new HwrConfig();
        hwrConfig.addParam("capKey", "hwr.local.associateword");
        hwrConfig.addParam(HwrConfig.AssociateConfig.PARAM_KEY_ASSOCIATE_MODEL, "multi");
        hwrConfig.addParam("resPrefix", "en.");
        int hciHwrSessionStart = HciCloudHwr.hciHwrSessionStart(hwrConfig.getStringConfig(), this.f163b);
        String str = f162a;
        b.b.a.b.a.c(str, "mAssociateSession start return " + hciHwrSessionStart);
    }

    @Override // com.sinovoice.hcicloudinputvehicle.engine.handwrite.AssociateSDKWrapper
    public void raisePriority(String str) {
        b.b.a.a.a.a("SDK not support!!", false);
    }

    @Override // com.sinovoice.hcicloudinputvehicle.engine.handwrite.AssociateSDKWrapper
    public void release() {
        Session session = this.f163b;
        if (session != null) {
            int hciHwrSessionStop = HciCloudHwr.hciHwrSessionStop(session);
            this.f163b = null;
            String str = f162a;
            b.b.a.b.a.c(str, "stopAssociateSession return: " + hciHwrSessionStop);
        }
    }
}
