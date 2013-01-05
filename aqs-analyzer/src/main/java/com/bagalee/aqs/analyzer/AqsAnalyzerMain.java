package com.bagalee.aqs.analyzer;

import java.io.File;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.datatype.XMLGregorianCalendar;

import com.bagalee.aqs.analyzer.dataobjects.LocationDao;
import com.bagalee.aqs.schema.jaxb.AirQualityGeoCodedDataType;
import com.bagalee.aqs.schema.jaxb.LocationType;
import com.bagalee.aqs.schema.jaxb.MeasurementEntityType;

public class AqsAnalyzerMain
{
    private final static String DATA_FILE_PATH =
            "/Users/hurroz/Ecology/AirQuality/EPA-AQS-DataMart/Data/Colorado_Criteria_Pollutants_2011/AQDM_RR_236286_pretty.xml";
    
    /**
    private final static String DATA_FILE_PATH =
            "/Users/hurroz/Ecology/AirQuality/EPA-AQS-DataMart/Data/Colorado_Criteria_Pollutants_2011/small.xml";
            **/
            
    public static void main(String[] args)
    {
        System.out.println("AqsAnalyzerMain...");
        
        parseDocument();
    }

    private static void parseDocument()
    {        
        AirQualityGeoCodedDataType measurementsContainer = null;
        
        try
        {            
            JAXBContext ctx = JAXBContext.newInstance("com.bagalee.aqs.schema.jaxb");

            Unmarshaller um = ctx.createUnmarshaller();
            
            // For debugging
            um.setEventHandler(new javax.xml.bind.helpers.DefaultValidationEventHandler());
            System.setProperty("jaxb.debug", "true");
            
            @SuppressWarnings("unchecked")
            JAXBElement<AirQualityGeoCodedDataType> jaxbElement = (JAXBElement<AirQualityGeoCodedDataType>) um.unmarshal(new File(DATA_FILE_PATH));
            
            measurementsContainer = jaxbElement.getValue();
        }
        catch (JAXBException e)
        {
            System.err.println("Trouble generating XML objects: " + e);
            return;
        }
        analyze(measurementsContainer.getGeoTemporalMeasurement());
    }
    
    private static Set<LocationDao> locationSet = new HashSet<LocationDao>();
    private static Set<XMLGregorianCalendar> dateSet = new HashSet<XMLGregorianCalendar>();

    private static void analyze(List<MeasurementEntityType> measurementList)
    {
        System.out.println("Number of measurements: " + measurementList.size());
        
        
        for (MeasurementEntityType measurement : measurementList)
        {   
            
            /***
            // Add location to location set
            LocationType geoLocation = measurement.getGeographicalLocation();
            
            // TODO: use transformer: measurement --> location Dao
            LocationDao locationDao = new LocationDao(
                    geoLocation.getLatitudeMeasure(),
                    geoLocation.getLongitudeMeasure(),
                    geoLocation.getVerticalMeasure().getVerticalMeasureValue(),
                    geoLocation.getVerticalMeasure().getVerticalMeasureUnit());
            locationSet.add(locationDao);
            ***/
            
            // Add date to date set
            dateSet.add(measurement.getDate());
            
        }
        
        System.out.println("Locations(" + locationSet.size() + "):");
        
        for (LocationDao loc : locationSet)
        {
            System.out.println(loc);
        }
        
        System.out.println("\n\nDates(" + dateSet.size() + "):");
        for (XMLGregorianCalendar date : dateSet)
        {
            System.out.println(date);
        }
    }
}
