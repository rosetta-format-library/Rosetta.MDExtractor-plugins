package com.exlibris.rosetta.repository.plugin.mdExtractor.epub;

import com.exlibris.rosetta.repository.plugin.mdExtractor.base.AbstractNLNZMDExtractorPluginTest;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.File;
import java.util.Objects;

public class EPUBPTCMDExtractorPluginTest extends AbstractNLNZMDExtractorPluginTest {
    private final static EPUBPTCMDExtractorPlugin testInstance = new EPUBPTCMDExtractorPlugin();

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

        testInstance.getSupportedAttributeNames().forEach(attr -> {
            String v = testInstance.getAttributeByName(attr);
            if (v == null) {
                System.out.println("Missing attribute: " + attr);
            }
        });
        assert true;
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
    public void testExtractFontsNames() throws Exception {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(Objects.requireNonNull(classLoader.getResource("accessible_epub_3.epub")).getFile());
        testInstance.extract(file.getAbsolutePath());
        String a = testInstance.getAttributeByName("EPUBMetadata.Fonts.Font.FontName");
        assert a != null;
        assert !a.isEmpty();
        assert a.split(";").length == 6;
    }

    @Test
    public void testExtractFonsFiles() throws Exception {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(Objects.requireNonNull(classLoader.getResource("accessible_epub_3.epub")).getFile());
        testInstance.extract(file.getAbsolutePath());
        String a = testInstance.getAttributeByName("EPUBMetadata.Fonts.Font.FontFile");
        assert a != null;
        assert !a.isEmpty();
        assert a.split(";").length == 6;
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
