package net.timbel.hwptools;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import kr.dogfoot.hwplib.object.HWPFile;
import kr.dogfoot.hwplib.object.bodytext.BodyText;
import kr.dogfoot.hwplib.reader.HWPReader;

public class Reader {
    public static void main(String[] args) throws Exception {
        final InputStream in = ClassLoader.getSystemResourceAsStream("getting_clickhere_text.hwp");
        final HWPFile hwp = HWPReader.fromInputStream(in);

        final BodyText bodyText = hwp.getBodyText();
        bodyText.getSectionList()
                .forEach(section -> {
                    Arrays.asList(section.getParagraphs())
                        .forEach(paragraph -> {
                            try {
                                System.out.println(paragraph.getNormalString());
                            } catch (UnsupportedEncodingException e) {
                                throw new RuntimeException(e);
                            }
                        });
                });

    }
}
