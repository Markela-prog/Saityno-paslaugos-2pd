package lt.eif.viko.emarkevicius;

import org.apache.fop.apps.FOPException;
import org.apache.fop.apps.FOUserAgent;
import org.apache.fop.apps.Fop;
import org.apache.fop.apps.FopFactory;
import org.apache.xmlgraphics.util.MimeConstants;

import javax.xml.transform.Result;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.sax.SAXResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

public class Main {
    /**
     * The main entry point of the application.
     * It invokes the convertToPDF() method to perform the XML to PDF conversion.
     * If any exception occurs during the conversion process, it prints the stack trace.
     *
     * @param args The command-line arguments.
     */
    public static void main(String[] args) {
        try {
            convertToPDF();
        } catch (FOPException | IOException | TransformerException e) {
            e.printStackTrace();
        }
    }

    /**
     * Converts the XML file to a PDF using XSL-FO transformation.
     * The XML file and XSLT file paths are hardcoded in the method.
     * The resulting PDF is saved as "Players.pdf" in the current directory.
     *
     * @throws IOException              If an I/O error occurs while reading the XML or writing the PDF.
     * @throws FOPException             If an error occurs during the FOP processing.
     * @throws TransformerException     If an error occurs during the transformation process.
     */
    public static void convertToPDF() throws IOException, FOPException, TransformerException {
        File xsltFile = new File("C:\\Users\\Markela\\Desktop\\Paskaitos\\Saityno paslaugos\\2pd\\CasinoToPdf\\players.xsl");
        StreamSource xmlSource = new StreamSource(new File("C:\\Users\\Markela\\Desktop\\Paskaitos\\Saityno paslaugos\\2pd\\CasinoToPdf\\players.xml"));
        FopFactory fopFactory = FopFactory.newInstance(new File(".").toURI());
        FOUserAgent foUserAgent = fopFactory.newFOUserAgent();

        OutputStream out;
        out = new java.io.FileOutputStream("Players.pdf");

        try {
            Fop fop = fopFactory.newFop(MimeConstants.MIME_PDF, foUserAgent, out);
            TransformerFactory factory = TransformerFactory.newInstance();
            Transformer transformer = factory.newTransformer(new StreamSource(xsltFile));
            Result res = new SAXResult(fop.getDefaultHandler());

            transformer.transform(xmlSource, res);
        } finally {
            out.close();
        }
    }

}