package com.exlibris.rosetta.repository.plugin.mdExtractor.base;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.Before;

import com.exlibris.dps.sdk.techmd.MDExtractorPlugin;

public abstract class AbstractNLNZMDExtractorPluginTest {
    protected final static String testDirectory = System.getProperty("user.dir") + File.separator + "resources";
    protected final static Map<String, String> initParams = new HashMap<>();

    static {
        System.setProperty("digitool.home", "/tmp");
        initParams.put("PLUGIN_VERSION_INIT_PARAM", "4.2.4");
    }


    protected static final String IGNORE_COMPARISON = "<ignore comparison>";
    protected Map<String, String> expectedValues;
    protected Map<String, Boolean> comparisonType = new HashMap<String, Boolean>();

    @Before
    public final void setUp() throws Exception {
//        String currDir = System.getProperty("user.dir");
//        System.setProperty("digitool.home", currDir);
        prepareExpectedValues();
    }

    @After
    public void tearDown() throws Exception {
        if (expectedValues != null) {
            expectedValues.clear();
        }

        if (comparisonType != null) {
            comparisonType.clear();
        }
    }

    /**
     * Method to test the completeness of attribute names supported by all plugins.
     * By making this abstract, we are trying make it compulsory for the subclasses
     * to test it.
     *
     * @throws Exception
     */
    public abstract void testGetSupportedAttributeNames() throws Exception;

    protected void testGetSupportedAttributeNames(MDExtractorPlugin plugin) throws Exception {
        List<String> supportedAttributes = plugin.getSupportedAttributeNames();
        assertNotNull(supportedAttributes);

        for (String attr : expectedValues.keySet()) {
            if (!supportedAttributes.contains(attr)) {
                System.out.println(attr);
            }
        }

        assertEquals("Size of supported attributes", expectedValues.size(), supportedAttributes.size());

        /*
         * Check every attribute in the expected attributes map is covering one each attribute
         * from the plugin class.
         */
        for (String attribute : expectedValues.keySet()) {
            assertTrue("Check presence of " + attribute, supportedAttributes.contains(attribute));
        }

        /*
         * Check every attribute in the plugin class is covered by the
         * expected attributes map.
         */
        for (String attribute : supportedAttributes) {
            assertTrue("Check presence of " + attribute + " in the expected list of attributes", expectedValues.containsKey(attribute));
        }
    }

    /**
     * Method to test the extraction of attributes and the correctness of mapping the
     * values with the attributes supported by a given plugin.
     * By making this abstract, we are trying make it compulsory for the subclasses
     * to test it.
     *
     * @throws Exception
     */
    public abstract void testExtract() throws Exception;

    protected void testExtract(MDExtractorPlugin plugin, String fileName) throws Exception {
        plugin.extract(testDirectory + fileName);
        List<String> supportedAttributes = plugin.getSupportedAttributeNames();

        for (String attribute : supportedAttributes) {
            /*
             * Test individual values of each attribute from the test data file against
             * the corresponding value from the expected values Map. In some cases, the
             * comparison is ignored (if IGNORE_COMPARISON is set). In some cases, the
             * comparison is only substring comparison if the property value from the test
             * data file is very large and we are lazy to put it in the expected values map
             * (ie, the exact comparison flag is set to false). In all other cases, the comparison
             * is a full comparison.
             */
            if (attribute.contains("NisoImageMetadata")) {
                System.out.println(attribute);
            }
            String expectedValue = expectedValues.get(attribute);
            String actualValue = plugin.getAttributeByName(attribute);
            /*
             * Do the following check to avoid a null pointer exception at the subsequent steps.
             * Check to see if this particular attribute coming from the plugin/adapter is present
             * in the list of expected attribute names.
             */
            assertTrue("Check presence of " + attribute + " in the expected list of attributes", expectedValues.containsKey(attribute));
            System.out.println(attribute + ": " + actualValue);
            /*
             * If expected and actual values are both null, it is acceptable.
             */
            if (expectedValue == null && actualValue == null) {
                // Both values are null. Assert true always
                assertTrue("Expected and actual values are null for attribute " + attribute, true);
                continue; // Skip to next attribute
            }
            /*
             * Do the comparison of value of the attribute as retrieved from the test data file,
             * against the expected value.
             */
            if (IGNORE_COMPARISON.equals(expectedValue) == false) {
                assertNotNull("Test that attribute " + attribute + " is not null", actualValue);
                String trimmedActualValue = actualValue.trim();
                if (comparisonType.get(attribute).booleanValue()) // Exact comparison
                    assertEquals(attribute, expectedValue, trimmedActualValue);
                else // Substring match for long attribute values
                    assertEquals("Expected that value of " + attribute + " starts with " + expectedValue, true, trimmedActualValue.startsWith(expectedValue));
            } else {
                // Ignore the comparison. Nothing is needed here. Assert true always
                assertTrue("Comparison is ignored for attribute " + attribute, true);
            }
        }
        String expectedFileFormatVersion = getExpectedFileFormatVersion();
        assertEquals("Checking the file format version to be " + expectedFileFormatVersion,
                expectedFileFormatVersion, plugin.getFormatVersion());
        String expectedFileFormatName = getExpectedFileFormatName();
        assertEquals("Checking the file format name to be " + expectedFileFormatName,
                expectedFileFormatName, plugin.getFormatName());
    }

    protected void testGetAgent(MDExtractorPlugin plugin, String expectedAgentName) throws Exception {
        String actualAgentName = plugin.getAgent();
        assertEquals(expectedAgentName, actualAgentName);
    }

    /**
     * Returns the expected value for the file format version. Override this
     * if the plugin under test is expected to return a valid value for format
     * version.
     *
     * @return
     */
    protected String getExpectedFileFormatVersion() {
        return null;
    }

    /**
     * Returns the expected value for the file format name. Override this
     * if the plugin under test is expected to return a valid value for format
     * name.
     *
     * @return
     */
    abstract protected String getExpectedFileFormatName();

    /**
     * Prepare the map of expected attribute/value pairs for a given metadata extractor
     * plugin. The JUnit test subclass for a given plugin should implement this.
     */
    protected abstract void prepareExpectedValues();

    /**
     * A helper method for adding a attribute name/value pair into the expected values map.
     * This is for the use of the subclasses.
     *
     * @param key        Name of the attribute
     * @param value      Expected value of the attribute
     * @param exactMatch True if an exact value comparison is required while testing.
     *                   False if a substring comparison is only required.
     */
    protected final void prepareExpectedValues(String key, String value, boolean exactMatch) {
        if (expectedValues == null) expectedValues = new HashMap<String, String>();
        expectedValues.put(key, value);
        comparisonType.put(key, exactMatch);
    }

    /**
     * A helper method for adding a attribute name/value pair into the expected values map.
     * This is for the use of the subclasses. The matching done at the time of testing will
     * be exact match.
     *
     * @param key   Name of the attribute
     * @param value Expected value of the attribute
     */
    protected final void prepareExpectedValues(String key, String value) {
        prepareExpectedValues(key, value, true);
    }

}