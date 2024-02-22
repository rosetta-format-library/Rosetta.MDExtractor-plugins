package com.exlibris.rosetta.repository.plugin.mdExtractor.epub;

import java.util.*;

import com.exlibris.core.infra.common.exceptions.logging.ExLogger;
import com.exlibris.rosetta.repository.plugin.mdExtractor.base.AbstractJhoveMDExtractorPlugin;
import edu.harvard.hul.ois.jhove.Property;

import javax.imageio.ImageIO;

public class EPUBPTCMDExtractorPlugin extends AbstractJhoveMDExtractorPlugin {
    private static ExLogger log = ExLogger.getExLogger(EPUBPTCMDExtractorPlugin.class);
    private static String jhoveModule = "EPUB-ptc";
    private static final String PLUGIN_VERSION_INIT_PARAM = "PLUGIN_VERSION_INIT_PARAM";
    private String pluginVersion = null;

    private static List<String> attList = new ArrayList<String>();

    static {
        attList.add("EPUBMetadata.PageCount");
        attList.add("EPUBMetadata.CharacterCount");
        attList.add("EPUBMetadata.Language");

        attList.add("EPUBMetadata.Info.Identifier");
        attList.add("EPUBMetadata.Info.Title");
        attList.add("EPUBMetadata.Info.Creator");
        attList.add("EPUBMetadata.Info.Contributor");
        attList.add("EPUBMetadata.Info.Date");
        attList.add("EPUBMetadata.Info.Publisher");
        attList.add("EPUBMetadata.Info.Subject");
        attList.add("EPUBMetadata.Info.Rights");

        attList.add("EPUBMetadata.Fonts.Fonts.FontName");
        attList.add("EPUBMetadata.Fonts.Fonts.FontFile");

        attList.add("EPUBMetadata.MediaTypes");
        attList.add("EPUBMetadata.References");
        attList.add("EPUBMetadata.Resources");
        attList.add("EPUBMetadata.hasEncryption");
        attList.add("EPUBMetadata.hasSignatures");
        attList.add("EPUBMetadata.hasAudio");
        attList.add("EPUBMetadata.hasVideo");
        attList.add("EPUBMetadata.hasFixedLayout");
        attList.add("EPUBMetadata.hasScripts");
    }

    @Override
    public void extract(String fileName) throws Exception {
        ImageIO.scanForPlugins(); //Make the container to reload com.sun.imageio.plugins.jpeg.JPEGImageReader to ignore the ambiguous classes, such as: com.twelvemonkeys.imageio.plugins.jpeg.JPEGImageReader
        super.extract(fileName, jhoveModule, pluginVersion);
    }

    @Override
    public List<String> getSupportedAttributeNames() {
        return attList;
    }

    public String getAgentName() {
        return "JHOVE 1.28.0, EPUB-ptc " + getRelease();
    }

    public String getAgent() {
        return getAgentName() + " , Plugin Version " + pluginVersion;
    }

    public void initParams(Map<String, String> initParams) {
        this.pluginVersion = initParams.get(PLUGIN_VERSION_INIT_PARAM);
    }

    @Override
    public String getAttributeByName(String attributeName) {
        if (attributeName != null && attributeName.equalsIgnoreCase("EPUBMetadata.Fonts.Fonts.FontName")) {
            Object object = this.getOriginalAttributeByName("EPUBMetadata.Fonts");
            if (object == null) {
                return null;
            }
            TreeSet<Property> fonts = (TreeSet<Property>) object;
            List<String> fontNames = new ArrayList<>();
            for (Property font : fonts) {
                if (!font.getName().equalsIgnoreCase("Font")) {
                    continue;
                }
                TreeSet<Property> fontValues = (TreeSet<Property>) font.getValue();
                for (Property fontItem : fontValues) {
                    if (!fontItem.getName().equalsIgnoreCase("FontName")) {
                        continue;
                    }
                    fontNames.add(fontItem.getValue().toString());
                }
            }
            return String.join(";", fontNames);
        } else if (attributeName != null && attributeName.equalsIgnoreCase("EPUBMetadata.Fonts.Fonts.FontFile")) {
            Object object = this.getOriginalAttributeByName("EPUBMetadata.Fonts");
            if (object == null) {
                return null;
            }
            TreeSet<Property> fonts = (TreeSet<Property>) object;
            List<String> fontFiles = new ArrayList<>();
            for (Property font : fonts) {
                if (!font.getName().equalsIgnoreCase("Font")) {
                    continue;
                }
                TreeSet<Property> fontValues = (TreeSet<Property>) font.getValue();
                for (Property fontItem : fontValues) {
                    if (!fontItem.getName().equalsIgnoreCase("FontFile")) {
                        continue;
                    }
                    fontFiles.add(fontItem.getValue().toString());
                }
            }
            return String.join(";", fontFiles);
        } else {
            return super.getAttributeByName(attributeName);
        }
    }
}
