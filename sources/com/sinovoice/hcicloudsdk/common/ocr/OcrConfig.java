package com.sinovoice.hcicloudsdk.common.ocr;

import com.sinovoice.hcicloudsdk.common.ParamProcessor;
/* loaded from: classes.dex */
public class OcrConfig extends ParamProcessor {

    /* loaded from: classes.dex */
    public static final class InputConfig {
        public static final String PARAM_KEY_AUTO_DESKEW = "autoDeskew";
        public static final String PARAM_KEY_AUTO_LAYOUT = "autoLayout";
        public static final String PARAM_KEY_BINARIZE = "binarize";
        public static final String PARAM_KEY_IMAGE_TYPE = "imageType";
        public static final String PARAM_KEY_LOCAL_PROCESS = "localProcess";
    }

    /* loaded from: classes.dex */
    public static final class ResultConfig {
        public static final String PARAM_KEY_DETAIL_RESULT = "detailResult";
        public static final String PARAM_KEY_DISP_CODE = "dispCode";
        public static final String PARAM_KEY_FULL_HALF = "fullHalf";
        public static final String PARAM_KEY_RECOG_RANGE = "recogRange";
    }

    /* loaded from: classes.dex */
    public static final class SessionConfig {
        public static final String PARAM_KEY_CAP_KEY = "capKey";
    }

    /* loaded from: classes.dex */
    public static final class TemplateConfig {
        public static final String PARAM_KEY_PROPTERTY = "property";
        public static final String PARAM_KEY_TEMPLATE_ID = "templateId";
        public static final String PARAM_KEY_TEMPLATE_INDEX = "templateIndex";
        public static final String PARAM_KEY_TEMPLATE_PATE_INDEX = "templatePageIndex";
    }
}
