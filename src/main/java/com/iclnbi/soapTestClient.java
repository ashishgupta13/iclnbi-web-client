package com.iclnbi;

import java.net.URL;

import com.iclnbi.iclnbi_v2_00.*;
import com.iclnbi.iclnbi_xsd.wsdl.*;

public class soapTestClient {
    public static void main (String args[]){
        try{

            URL url = new URL("http://icl.qintra.com/icl/services/ICL_2_0?wsdl");
            ICL2NBIDataServiceService service = new ICL2NBIDataServiceService(url);
            ICLNBIDataServicePortType port = service.getICLNBIDataServicePort();

            /*
            <?xml version="1.0" encoding="UTF-8"?>
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:xsd="http://www.w3.org/2001/XMLSchema" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance">
  <soapenv:Body>
    <SearchResourceRequest xmlns="http://www.ICLNBI.com/ICLNBI_V2.00.xsd">
      <MessageElements xmlns="">
        <MessageAddressing>
          <from>RX</from>
          <to>ICL</to>
          <replyTo>RX</replyTo>
          <messageID>1234</messageID>
          <action>SearchResource</action>
          <timestamp>28-09-2017 15:25:25</timestamp>
          <transactionID>RX1506592525675</transactionID>
          <serviceName>SearchResource</serviceName>
          <serviceVersion>3.1</serviceVersion>
        </MessageAddressing>
      </MessageElements>
      <SearchResourceDetails xmlns="">
        <commonName>1000075335-HSI</commonName>
        <objectID/>
        <sourceSystem>ARM</sourceSystem>
        <entity>Circuit</entity>
        <level>Circuit</level>
        <scope>Detailed</scope>
        <ResourceCharacteristicValue>
          <CharacteristicName>IncludeCLCLocation</CharacteristicName>
          <CharacteristicValue>True</CharacteristicValue>
        </ResourceCharacteristicValue>
        <ResourceCharacteristicValue>
          <CharacteristicName>IncludeCLCCustomer</CharacteristicName>
          <CharacteristicValue>True</CharacteristicValue>
        </ResourceCharacteristicValue>
        <ResourceCharacteristicValue>
          <CharacteristicName>IncludeRelationships</CharacteristicName>
          <CharacteristicValue>True</CharacteristicValue>
        </ResourceCharacteristicValue>
      </SearchResourceDetails>
    </SearchResourceRequest>
  </soapenv:Body>
</soapenv:Envelope>
             */
            // prepare the search criteria
            SearchResourceRequest searchResourceRequest = new SearchResourceRequest();
            MessageElements messageElements = new MessageElements();
            MessageAddressing messageAddressing = new MessageAddressing();
            messageAddressing.setFrom("RX");
            messageAddressing.setTo("ICL");
            messageAddressing.setMessageID("1234");
            messageAddressing.setAction("SearchResource");
            messageAddressing.setTimestamp("28-09-2017 15:25:25");
            messageAddressing.setTransactionID("RX1506592525675");
            messageAddressing.setServiceName("SearchResource");
            messageAddressing.setServiceVersion("3.1");
            messageElements.setMessageAddressing(messageAddressing);

            searchResourceRequest.setMessageElements(messageElements);

            SearchResourceDetails searchResourceDetails = new SearchResourceDetails();
            searchResourceDetails.setCommonName("1000075335-HSI");
            searchResourceDetails.setSourceSystem("ARM");
            searchResourceDetails.setEntity("Circuit");
            searchResourceDetails.setLevel("Circuit");
            searchResourceDetails.setScope("Detailed");

            ResourceCharacteristicValue resourceCharacteristicValue1 = new ResourceCharacteristicValue();
            resourceCharacteristicValue1.setCharacteristicName("IncludeCLCLocation");
            resourceCharacteristicValue1.setCharacteristicValue("True");

            ResourceCharacteristicValue resourceCharacteristicValue2 = new ResourceCharacteristicValue();
            resourceCharacteristicValue2.setCharacteristicName("IncludeCLCCustomer");
            resourceCharacteristicValue2.setCharacteristicValue("True");

            ResourceCharacteristicValue resourceCharacteristicValue3 = new ResourceCharacteristicValue();
            resourceCharacteristicValue3.setCharacteristicName("IncludeRelationships");
            resourceCharacteristicValue3.setCharacteristicValue("True");

            searchResourceDetails.getResourceCharacteristicValue().add(resourceCharacteristicValue1);
            searchResourceDetails.getResourceCharacteristicValue().add(resourceCharacteristicValue2);
            searchResourceDetails.getResourceCharacteristicValue().add(resourceCharacteristicValue3);

            searchResourceRequest.setSearchResourceDetails(searchResourceDetails);
            SearchResourceResponse searchResourceResponse = port.searchResource(searchResourceRequest);


        }catch (Exception e){
            System.out.println("Exception occurred: " + e);
        }
    }
}
