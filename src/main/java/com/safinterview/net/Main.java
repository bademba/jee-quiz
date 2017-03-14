package com.safinterview.net;

import com.safaricom.psd.ws.GetKey;
import com.safaricom.psd.ws.TestWS;
import com.safaricom.psd.ws.TestWS_Service;
import com.safaricom.psd.ws.TransactionResult;
import com.safinterview.io.reader.FileStreamReader;
import com.safinterview.io.writer.FileStreamWriter;

import javax.xml.namespace.QName;
import javax.xml.ws.Endpoint;
import javax.xml.ws.Service;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by victor on 3/14/2017.
 */
public class Main {

    private static String filename = "C:\\Users\\victor\\Desktop\\SafInterview\\hidden_key.txt";

    public static void main(String[] args) {
        consumeGetKey();
        consumeRegister();
    }

    private static void consumeGetKey() {
        try {
            URL url = new URL("http://2a1ba6a5.ngrok.io/TestWebService/TestWS?wsdl");
            QName qname = new QName("http://ws.psd.safaricom.com/","TestWS");
            Service service = Service.create(url, qname);
            TestWS testWS = service.getPort(TestWS.class);
            TransactionResult transactionResult = testWS.getKey("red");

            String hiddenKey = transactionResult.getHiddenKey();
            String responseCode = transactionResult.getResponseCode();
            String responseDescription = transactionResult.getResponseDesc();

            new FileStreamWriter().writeStream(new File(filename), hiddenKey);

            System.out.println("Response code : " + responseCode + "\nResponse description : "
                    + responseDescription + "\nHidden Key : " + hiddenKey);

        } catch (MalformedURLException e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void consumeRegister() {

        try {
            String hiddenKey = new FileStreamReader().readFile(filename);
            URL url = new URL("http://2a1ba6a5.ngrok.io/TestWebService/TestWS?wsdl");
            QName qname = new QName("http://ws.psd.safaricom.com/","TestWS");
            Service service = Service.create(url, qname);
            TestWS testWS = service.getPort(TestWS.class);

            TransactionResult transactionResult = testWS.register("Victor Mwenda", "32361839", "0718034449", hiddenKey);


            String responseCode = transactionResult.getResponseCode();
            String responseDescription = transactionResult.getResponseDesc();

            System.out.println("Response code : " + responseCode + "\nResponse description : "
                    + responseDescription);

        } catch (MalformedURLException e) {
            System.err.println(e.getMessage());
            e.printStackTrace();

        } catch (IOException e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
