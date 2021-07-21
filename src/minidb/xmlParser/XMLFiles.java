package minidb.xmlParser;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import constants.constants;

public class XMLFiles {
    protected File xmlFile;
    protected Document doc;

    public XMLFiles(String path) {
        try {
            xmlFile = new File(path);
            new File(constants.DB_DIR_PATH).mkdir(); // create `db` directory if it doesn't exist
            boolean NoFileFound = xmlFile.createNewFile();
            load(NoFileFound);
        } catch (ParserConfigurationException | SAXException | IOException err) {
            System.out.println(err);
            err.printStackTrace();
        }
    }

    private void load(boolean NoFile) throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
        if (NoFile) {

            doc = docBuilder.newDocument();
            createFile();
        } else {
            doc = docBuilder.parse(xmlFile);
        }
    }

    protected void createFile() {
        this.updateFile();
    }

    protected void updateFile() {
        try {
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            transformer.setOutputProperty(OutputKeys.INDENT, "no");
            transformer.setOutputProperty(OutputKeys.METHOD, "xml");

            DOMSource source = new DOMSource(this.doc);
            StreamResult result = new StreamResult(this.xmlFile);
            transformer.transform(source, result);

        } catch (TransformerException err) {
            err.printStackTrace();
        }
    }
}