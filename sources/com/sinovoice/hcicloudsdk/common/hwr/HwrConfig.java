package com.sinovoice.hcicloudsdk.common.hwr;

import com.sinovoice.hcicloudsdk.common.ParamProcessor;
/* loaded from: classes.dex */
public class HwrConfig extends ParamProcessor {

    /* loaded from: classes.dex */
    public static final class AssociateConfig {
        public static final String PARAM_KEY_ASSOCIATE_MODEL = "associateModel";
        public static final String PARAM_KEY_ASSOCIATE_RECURSIVE = "recursive";
    }

    /* loaded from: classes.dex */
    public static final class InputConfig {
        public static final String PARAM_KEY_DOMAIN = "domain";
        public static final String PARAM_KEY_SPLIT_MODE = "splitMode";
        public static final String PARAM_KEY_WORD_MODE = "wordMode";
        public static final String PARAM_SUB_LANG = "subLang";
    }

    /* loaded from: classes.dex */
    public static final class ResultConfig {
        public static final String PARAM_KEY_CAND_NUM = "candNum";
        public static final String PARAM_KEY_DISP_CODE = "dispCode";
        public static final String PARAM_KEY_FULL_HALF = "fullHalf";
        public static final String PARAM_KEY_OPEN_SLANT = "openSlant";
        public static final String PARAM_KEY_RECOG_RANGE = "recogRange";
    }

    /* loaded from: classes.dex */
    public static final class SessionConfig {
        public static final String PARAM_KEY_CAP_KEY = "capKey";
        public static final String PARAM_KEY_REALTIME = "realtime";
        public static final String PARAM_KEY_RES_PREFIX = "resPrefix";
        public static final String PARAM_KEY_USER_DATA_PATH = "userDataPath";
    }
}
