package com.exlibris.rosetta.repository.plugin.mdExtractor.epub;

import com.exlibris.rosetta.repository.plugin.mdExtractor.base.AbstractNLNZMDExtractorPluginTest;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.File;
import java.util.Objects;

public class EPUBPTCMDExtractorPluginTest extends AbstractNLNZMDExtractorPluginTest {
    private static EPUBPTCMDExtractorPlugin testInstance = new EPUBPTCMDExtractorPlugin();

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
        File file = new File(Objects.requireNonNull(classLoader.getResource("font-obfuscation.epub")).getFile());
        testInstance.extract(file.getAbsolutePath());
        String a = testInstance.getAttributeByName("EPUBMetadata.Fonts.Font.FontName");
        assert a != null;
        assert a.equals("AvenirLT-Roman");

        String b = testInstance.getAttributeByName("EPUBMetadata.Fonts.Font.FontFile");
        assert b != null;
        assert b.equals("true");
    }

    @Test
    public void testExtractFonts() throws Exception {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(Objects.requireNonNull(classLoader.getResource("font-obfuscation.epub")).getFile());
        testInstance.extract(file.getAbsolutePath());
        Object a = testInstance.getOriginalAttributeByName("EPUBMetadata.Fonts");
        assert a != null;
    }

    @Test
    public void testExtractFontNames() throws Exception {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(Objects.requireNonNull(classLoader.getResource("font-obfuscation.epub")).getFile());
        testInstance.extract(file.getAbsolutePath());
        String a = testInstance.getAttributeByName("EPUBMetadata.Fonts.Fonts.FontName");
        assert a != null;
        assert !a.isEmpty();
    }

    @Test
    public void testExtractFonFiles() throws Exception {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(Objects.requireNonNull(classLoader.getResource("font-obfuscation.epub")).getFile());
        testInstance.extract(file.getAbsolutePath());
        String a = testInstance.getAttributeByName("EPUBMetadata.Fonts.Fonts.FontFile");
        assert a != null;
        assert !a.isEmpty();
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
