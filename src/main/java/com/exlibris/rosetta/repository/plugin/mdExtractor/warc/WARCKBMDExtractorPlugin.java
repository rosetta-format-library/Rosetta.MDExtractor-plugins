package com.exlibris.rosetta.repository.plugin.mdExtractor.warc;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.exlibris.core.infra.common.exceptions.logging.ExLogger;
import com.exlibris.rosetta.repository.plugin.mdExtractor.base.AbstractJhoveMDExtractorPlugin;


public class WARCKBMDExtractorPlugin extends AbstractJhoveMDExtractorPlugin {

    private static ExLogger log = ExLogger.getExLogger(WARCKBMDExtractorPlugin.class);
    private static String jhoveModule = "WARC-kb";
    private static final String PLUGIN_VERSION_INIT_PARAM = "PLUGIN_VERSION_INIT_PARAM";
    private String pluginVersion = null;

    private static List<String> attList = new ArrayList<String>();

    static {
        //WarcRecordProperties==Records.Record
//		attList.add("Records.Record.Record offset"); //
//		attList.add("Records.Record.Warc-Date");
//		attList.add("Records.Record.Warc-Record-ID");
//        attList.add("Records.Record.Record-ID-Scheme");
//        attList.add("Records.Record.Content-Type");
//        attList.add("Records.Record.Content-Length");
//        attList.add("Records.Record.Warc-Type");
//        attList.add("Records.Record.Warc-Block-Digest");
//        attList.add("Records.Record.Block-Digest-Algorithm");
//        attList.add("Records.Record.Block-Digest-Encoding");
//        attList.add("Records.Record.isValidBlockDigest");
//        attList.add("Records.Record.Warc-Payload-Digest");
//        attList.add("Records.Record.Payload-Digest-Algorithm");
//        attList.add("Records.Record.Payload-Digest-Encoding");
//        attList.add("Records.Record.isValidPayloadDigest");
//        attList.add("Records.Record.Warc-Truncated");
//        attList.add("Records.Record.hasPayload");
//        attList.add("Records.Record.PayloadLength");
//        attList.add("Records.Record.Warc-Identified-Payload-Type");
//        attList.add("Records.Record.Warc-Segment-Number");
//        attList.add("Records.Record.isNonCompliant"); //
//        attList.add("Records.Record.Computed-Block-Digest");
//        attList.add("Records.Record.Computed-Payload-Digest");

//        attList.add("Records");

//        attList.add("Records.Record.Record offset in WARC file."); //
//        attList.add("Records.Record.Warc-Date header value.");
//        attList.add("Records.Record.Warc-Record-ID header value.");
//        attList.add("Records.Record.Record-ID-Scheme value.");
//        attList.add("Records.Record.Content-Type header value.");
//        attList.add("Records.Record.Content-Length header value.");
//        attList.add("Records.Record.Warc-Type header value.");
////        attList.add("Records.Record.Warc-Block-Digest");
////        attList.add("Records.Record.Block-Digest-Algorithm");
////        attList.add("Records.Record.Block-Digest-Encoding");
////        attList.add("Records.Record.isValidBlockDigest");
////        attList.add("Records.Record.Warc-Payload-Digest");
////        attList.add("Records.Record.Payload-Digest-Algorithm");
////        attList.add("Records.Record.Payload-Digest-Encoding");
////        attList.add("Records.Record.isValidPayloadDigest");
////        attList.add("Records.Record.Warc-Truncated");
//        attList.add("Records.Record.hasPayload value.");
//        attList.add("Records.Record.PayloadLength value.");
////        attList.add("Records.Record.Warc-Identified-Payload-Type");
////        attList.add("Records.Record.Warc-Segment-Number");
//        attList.add("Records.Record.isNonCompliant value."); //
////        attList.add("Records.Record.Computed-Block-Digest");
////        attList.add("Records.Record.Computed-Payload-Digest");
//        attList.add("Records.Record.WarcFilename header value.");
    }

    @Override
    public void extract(String fileName) throws Exception {
        super.extract(fileName, jhoveModule, pluginVersion);
    }

    @Override
    public List<String> getSupportedAttributeNames() {
        return attList;
    }

    public String getAgentName() {
        return "JHOVE 1.26.1, WARC-kb " + getRelease();
    }

    public String getAgent() {
        return getAgentName() + " , Plugin Version " + pluginVersion;
    }

    public void initParams(Map<String, String> initParams) {
        this.pluginVersion = initParams.get(PLUGIN_VERSION_INIT_PARAM);
    }
}
