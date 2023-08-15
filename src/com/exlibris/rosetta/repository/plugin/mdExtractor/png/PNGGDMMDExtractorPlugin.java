package com.exlibris.rosetta.repository.plugin.mdExtractor.png;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.exlibris.core.infra.common.exceptions.logging.ExLogger;
import com.exlibris.rosetta.repository.plugin.mdExtractor.base.AbstractJhoveMDExtractorPlugin;

public class PNGGDMMDExtractorPlugin extends AbstractJhoveMDExtractorPlugin{
    private static ExLogger log = ExLogger.getExLogger(PNGGDMMDExtractorPlugin.class);
    private static String jhoveModule =  "PNG-gdm";
    private static final String PLUGIN_VERSION_INIT_PARAM = "PLUGIN_VERSION_INIT_PARAM";
    private String pluginVersion = null;

    private static List<String> attList = new ArrayList<String>();
    static {
        attList.add("Pixel unit");
        attList.add("X pixels per unit");
        attList.add("Y pixels per unit");
        attList.add("PNGMetadata.NisoImageMetadata.AutoFocus");
        attList.add("PNGMetadata.NisoImageMetadata.BackLight");
        attList.add("PNGMetadata.NisoImageMetadata.BitsPerSample");
        attList.add("PNGMetadata.NisoImageMetadata.Brightness");
        attList.add("PNGMetadata.NisoImageMetadata.ByteOrder");
        attList.add("PNGMetadata.NisoImageMetadata.ChecksumMethod");
        attList.add("PNGMetadata.NisoImageMetadata.ChecksumValue");
        attList.add("PNGMetadata.NisoImageMetadata.Class");
        attList.add("PNGMetadata.NisoImageMetadata.ColormapBitCodeValue");
        attList.add("PNGMetadata.NisoImageMetadata.ColormapBlueValue");
        attList.add("PNGMetadata.NisoImageMetadata.ColormapGreenValue");
        attList.add("PNGMetadata.NisoImageMetadata.ColormapRedValue");
        attList.add("PNGMetadata.NisoImageMetadata.ColormapReference");
        attList.add("PNGMetadata.NisoImageMetadata.ColorSpace");
        attList.add("PNGMetadata.NisoImageMetadata.ColorTemp");
        attList.add("PNGMetadata.NisoImageMetadata.CompressionLevel");
        attList.add("PNGMetadata.NisoImageMetadata.CompressionScheme");
        attList.add("PNGMetadata.NisoImageMetadata.DateTimeCreated");
        attList.add("PNGMetadata.NisoImageMetadata.DateTimeProcessed");
        attList.add("PNGMetadata.NisoImageMetadata.DeviceSource");
        attList.add("PNGMetadata.NisoImageMetadata.DigitalCameraManufacturer");
        attList.add("PNGMetadata.NisoImageMetadata.DigitalCameraModel");
        attList.add("PNGMetadata.NisoImageMetadata.DisplayOrientation");
        attList.add("PNGMetadata.NisoImageMetadata.ExposureBias");
        attList.add("PNGMetadata.NisoImageMetadata.ExposureIndex");
        attList.add("PNGMetadata.NisoImageMetadata.ExposureTime");
        attList.add("PNGMetadata.NisoImageMetadata.ExtraSamples");
        attList.add("PNGMetadata.NisoImageMetadata.FileSize");
        attList.add("PNGMetadata.NisoImageMetadata.Flash");
        attList.add("PNGMetadata.NisoImageMetadata.FlashEnergy");
        attList.add("PNGMetadata.NisoImageMetadata.FlashReturn");
        attList.add("PNGMetadata.NisoImageMetadata.FNumber");
        attList.add("PNGMetadata.NisoImageMetadata.FocalLength");
        attList.add("PNGMetadata.NisoImageMetadata.GrayResponseCurve");
        attList.add("PNGMetadata.NisoImageMetadata.GrayResponseUnit");
        attList.add("PNGMetadata.NisoImageMetadata.HostComputer");
        attList.add("PNGMetadata.NisoImageMetadata.ImageData");
        attList.add("PNGMetadata.NisoImageMetadata.ImageIdentifier");
        attList.add("PNGMetadata.NisoImageMetadata.ImageIdentifierLocation");
        attList.add("PNGMetadata.NisoImageMetadata.ImageLength");
        attList.add("PNGMetadata.NisoImageMetadata.ImageProducer");
        attList.add("PNGMetadata.NisoImageMetadata.ImageWidth");
        attList.add("PNGMetadata.NisoImageMetadata.MeteringMode");
        attList.add("PNGMetadata.NisoImageMetadata.Methodology");
        attList.add("PNGMetadata.NisoImageMetadata.MimeType");
        attList.add("PNGMetadata.NisoImageMetadata.Orientation");
        attList.add("PNGMetadata.NisoImageMetadata.OS");
        attList.add("PNGMetadata.NisoImageMetadata.OSVersion");
        attList.add("PNGMetadata.NisoImageMetadata.PerformanceData");
        attList.add("PNGMetadata.NisoImageMetadata.PixelSize");
        attList.add("PNGMetadata.NisoImageMetadata.PlanarConfiguration");
        attList.add("PNGMetadata.NisoImageMetadata.PreferredPresentation");
        attList.add("PNGMetadata.NisoImageMetadata.PrimaryChromaticitiesBlueX");
        attList.add("PNGMetadata.NisoImageMetadata.PrimaryChromaticitiesBlueY");
        attList.add("PNGMetadata.NisoImageMetadata.PrimaryChromaticitiesGreenX");
        attList.add("PNGMetadata.NisoImageMetadata.PrimaryChromaticitiesGreenY");
        attList.add("PNGMetadata.NisoImageMetadata.PrimaryChromaticitiesRedX");
        attList.add("PNGMetadata.NisoImageMetadata.PrimaryChromaticitiesRedY");
        attList.add("PNGMetadata.NisoImageMetadata.ProcessingActions");
        attList.add("PNGMetadata.NisoImageMetadata.ProcessingAgency");
        attList.add("PNGMetadata.NisoImageMetadata.ProcessingSoftwareName");
        attList.add("PNGMetadata.NisoImageMetadata.ProcessingSoftwareVersion");
        attList.add("PNGMetadata.NisoImageMetadata.ProfileName");
        attList.add("PNGMetadata.NisoImageMetadata.Profiles");
        attList.add("PNGMetadata.NisoImageMetadata.ProfileURL");
        attList.add("PNGMetadata.NisoImageMetadata.ReferenceBlackWhite");
        attList.add("PNGMetadata.NisoImageMetadata.RowsPerStrip");
        attList.add("PNGMetadata.NisoImageMetadata.SamplesPerPixel");
        attList.add("PNGMetadata.NisoImageMetadata.SamplingFrequencyPlane");
        attList.add("PNGMetadata.NisoImageMetadata.SamplingFrequencyUnit");
        attList.add("PNGMetadata.NisoImageMetadata.ScannerManufacturer");
        attList.add("PNGMetadata.NisoImageMetadata.ScannerModelName");
        attList.add("PNGMetadata.NisoImageMetadata.ScannerModelNumber");
        attList.add("PNGMetadata.NisoImageMetadata.ScannerModelSerialNo");
        attList.add("PNGMetadata.NisoImageMetadata.ScanningSoftware");
        attList.add("PNGMetadata.NisoImageMetadata.ScanningSoftwareVersionNo");
        attList.add("PNGMetadata.NisoImageMetadata.SceneIlluminant");
        attList.add("PNGMetadata.NisoImageMetadata.SegmentType");
        attList.add("PNGMetadata.NisoImageMetadata.Sensor");
        attList.add("PNGMetadata.NisoImageMetadata.SourceData");
        attList.add("PNGMetadata.NisoImageMetadata.SourceID");
        attList.add("PNGMetadata.NisoImageMetadata.SourceType");
        attList.add("PNGMetadata.NisoImageMetadata.SourceXDimension");
        attList.add("PNGMetadata.NisoImageMetadata.SourceXDimensionUnit");
        attList.add("PNGMetadata.NisoImageMetadata.SourceYDimension");
        attList.add("PNGMetadata.NisoImageMetadata.SourceYDimensionUnit");
        attList.add("PNGMetadata.NisoImageMetadata.StripByteCounts");
        attList.add("PNGMetadata.NisoImageMetadata.StripOffsets");
        attList.add("PNGMetadata.NisoImageMetadata.SubjectDistance");
        attList.add("PNGMetadata.NisoImageMetadata.TargetIDManufacturer");
        attList.add("PNGMetadata.NisoImageMetadata.TargetIDMedia");
        attList.add("PNGMetadata.NisoImageMetadata.TargetIDName");
        attList.add("PNGMetadata.NisoImageMetadata.TargetIDNo");
        attList.add("PNGMetadata.NisoImageMetadata.TargetType");
        attList.add("PNGMetadata.NisoImageMetadata.TileByteCounts");
        attList.add("PNGMetadata.NisoImageMetadata.TileLength");
        attList.add("PNGMetadata.NisoImageMetadata.TileOffsets");
        attList.add("PNGMetadata.NisoImageMetadata.TileWidth");
        attList.add("PNGMetadata.NisoImageMetadata.ViewerData");
        attList.add("PNGMetadata.NisoImageMetadata.WhitePointXValue");
        attList.add("PNGMetadata.NisoImageMetadata.WhitePointYValue");
        attList.add("PNGMetadata.NisoImageMetadata.XPhysScanResolution");
        attList.add("PNGMetadata.NisoImageMetadata.XPrintAspectRatio");
        attList.add("PNGMetadata.NisoImageMetadata.XSamplingFrequency");
        attList.add("PNGMetadata.NisoImageMetadata.XTargetedDisplayAR");
        attList.add("PNGMetadata.NisoImageMetadata.YCbCrCoefficients");
        attList.add("PNGMetadata.NisoImageMetadata.YCbCrPositioning");
        attList.add("PNGMetadata.NisoImageMetadata.YCbCrSubSampling");
        attList.add("PNGMetadata.NisoImageMetadata.YPhysScanResolution");
        attList.add("PNGMetadata.NisoImageMetadata.YPrintAspectRatio");
        attList.add("PNGMetadata.NisoImageMetadata.YSamplingFrequency");
        attList.add("PNGMetadata.NisoImageMetadata.YTargetedDisplayAR");
        attList.add("PNGMetadata.ColorType");
        attList.add("PNGMetadata.Compression");
        attList.add("PNGMetadata.Filter type");
        attList.add("PNGMetadata.Interlace");
        attList.add("PNGMetadata.Significant bits");
        attList.add("PNGMetadata.Keywords.Keyword.Key");
        attList.add("PNGMetadata.Keywords.Keyword.Value");
        attList.add("PNGMetadata.Gamma");
        attList.add("Blue background value");
        attList.add("Red background value");
        attList.add("Green background value");
        attList.add("SRGB rendering intent");
    }

    @Override
    public void extract(String fileName) throws Exception {

            super.extract(fileName,jhoveModule,pluginVersion);

    }

    @Override
    public List<String> getSupportedAttributeNames() {
        return attList;
    }

    public String getAgentName()
    {
    	return "JHOVE 1.26.1, PNG-gdm " + getRelease();
    }

    public String getAgent()
    {
    	return getAgentName() + " , Plugin Version " + pluginVersion;
    }

    public void initParams(Map<String, String> initParams) {
		this.pluginVersion = initParams.get(PLUGIN_VERSION_INIT_PARAM);
	}

    public static List<String> getAttributeList(){
        return attList;
    }
}
