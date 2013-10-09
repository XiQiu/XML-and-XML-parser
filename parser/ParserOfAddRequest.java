package parser;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;




public class ParserOfAddRequest extends DefaultHandler
{
	
	private List<Request> ListOfRequest; 
	private Request RequestObject;
	private RequestTDG RequestTDGObject = new RequestTDG();
	private StringBuilder temp;
	private File xmlFile = new File("/Users/xiqiu/Documents/workspace/myrest/src/parser/AddRestaurantRequest.xml");
	
	
	
	public void runParsing()
	{
		SAXParserFactory factory = SAXParserFactory.newInstance();
		factory.setValidating(true);
		
		try
		{
			SAXParser parser = factory.newSAXParser();
			parser.parse(xmlFile, this);
		} 
		catch(SAXException saxexception)
		{
			saxexception.printStackTrace();
		} 
		catch(IOException ioexception)
		{
			ioexception.printStackTrace();
		} 
		catch(ParserConfigurationException parserexception)
		{
			parserexception.printStackTrace();
		}
	}
	
	
	public ParserOfAddRequest()
	{
		ListOfRequest = new ArrayList<Request>();
	}
	
	
	public void characters(char[] ch, int start, int length)
	{
		temp.append(ch, start, length);
	}
	
	
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException
	{
		temp = new StringBuilder();
		if(qName.equalsIgnoreCase("Request"))
		{
			RequestObject = new Request();
			System.out.println("======== Start Element Request =======");
		}
	}
	
	
		
	public void endElement(String uri, String localName, String qName) throws SAXException
	{
		if(qName.equalsIgnoreCase("Request"))
		{
			System.out.println("======== End Element Request =======");
			try
			{
				RequestTDGObject.insertRequest(RequestObject);
			}
			catch(Exception exception) 
			{
				exception.printStackTrace();
			}
		}
		
		else if(qName.equalsIgnoreCase("RequestId"))
		{
			RequestObject.setRequestId(Integer.parseInt(temp.toString()));
			System.out.println("RequestId:" + temp.toString());
		}
		
		else if(qName.equalsIgnoreCase("ManagerId"))
		{
			RequestObject.setManagerId(Integer.parseInt(temp.toString()));
			System.out.println("ManagerId:" + temp.toString());
		}
		
		else if(qName.equalsIgnoreCase("RestaurantName"))
		{
			RequestObject.setRestaurantName(temp.toString());
			System.out.println("Restaurant:" + temp.toString());
		}
		
		else if(qName.equalsIgnoreCase("Cuisine"))
		{
			RequestObject.setCuisine(temp.toString());
			System.out.println("Cuisine:" + temp.toString());
		}
				
		else if(qName.equalsIgnoreCase("Location"))
		{
			RequestObject.setLocation(temp.toString());
			System.out.println("Location:" + temp.toString());
		}
	}
	
	public static void main(String[] args)
	{
		ParserOfAddRequest parserofrequest =  new ParserOfAddRequest();
		parserofrequest.runParsing();
	}
	

}
