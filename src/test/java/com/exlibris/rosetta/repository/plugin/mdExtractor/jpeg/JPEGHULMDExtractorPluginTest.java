package com.exlibris.rosetta.repository.plugin.mdExtractor.jpeg;

import com.exlibris.rosetta.repository.plugin.mdExtractor.base.AbstractNLNZMDExtractorPluginTest;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.File;
import java.util.Objects;

public class JPEGHULMDExtractorPluginTest extends AbstractNLNZMDExtractorPluginTest {
    private static JPEGHULMDExtractorPlugin testInstance = new JPEGHULMDExtractorPlugin();

    @BeforeClass
    public static void init() {
        testInstance.initParams(initParams);
    }

    @Test
    public void testGetAgent() {
        String agent = testInstance.getAgent();
        assert agent != null;
    }

    @Test
    public void testExtractAll() throws Exception {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(Objects.requireNonNull(classLoader.getResource("AA_Banner-progressive.jpg")).getFile());
        testInstance.extract(file.getAbsolutePath());
//        String a = testInstance.getAttributeByName("JPEGMetadata.Images.Image.NisoImageMetadata.DigitalCameraModelName");
        String a = testInstance.getAttributeByName("JPEGMetadata.Images.Image.NisoImageMetadata.XSamplingFrequency");

        assert a != null;
        assert a.equals("72/1");
    }

    @Override
    public void testGetSupportedAttributeNames() throws Exception {

    }

    @Override
    public void testExtract() throws Exception {

    }

    @Override
    protected String getExpectedFileFormatName() {
        return null;
    }

    @Override
    protected void prepareExpectedValues() {

    }
}
