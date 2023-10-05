package com.exlibris.rosetta.repository.plugin.mdExtractor.pdf;

import com.exlibris.rosetta.repository.plugin.mdExtractor.base.AbstractNLNZMDExtractorPluginTest;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.File;
import java.util.Objects;

public class PDFHULMDExtractorPluginTest extends AbstractNLNZMDExtractorPluginTest {
    private static PDFHULMDExtractorPlugin testInstance = new PDFHULMDExtractorPlugin();

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
        File file = new File(Objects.requireNonNull(classLoader.getResource("sample.pdf")).getFile());
        testInstance.extract(file.getAbsolutePath());
        String a = testInstance.getAttributeByName("PDFMetadata.Pages.Page.Sequence");
        assert a != null;
        assert a.equals("1");

        String b = testInstance.getAttributeByName("PDFMetadata.Objects");
        assert b != null;
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
