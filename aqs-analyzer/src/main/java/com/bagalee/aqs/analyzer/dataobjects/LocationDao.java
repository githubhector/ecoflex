package com.bagalee.aqs.analyzer.dataobjects;

/**
 * A location: latitude, longitude, altitude
 */
public class LocationDao
{
    private String latitude;
    private String longitude;
    private String altitude;
    private String altitudeUnits;
    
    int hashCode = -1;
    
    public LocationDao(String latitude, String longitude, String altitude, String altitudeUnits)
    {
        this.latitude = latitude;
        this.longitude = longitude;
        this.altitude = altitude;
        this.altitudeUnits = altitudeUnits;
        
        hashCode = (latitude + longitude + altitude + altitudeUnits).hashCode();
    }
    
    public String toString()
    {
        return String.format("%-20s%-20s%20s %s", latitude, longitude, altitude, altitudeUnits);
    }
    
    @Override
    public boolean equals(Object obj)
    {
        if (! (obj instanceof LocationDao) )
        {
            throw new IllegalArgumentException("Equals: object not instance of AqsAnalyzerDataObject");
        }
        
        LocationDao dataObject = (LocationDao) obj;
        
        return latitude.equals(dataObject.getLatitude()) &&
               longitude.equals(dataObject.getLongitude()) &&
               altitude.equals(dataObject.getAltitude()) &&
               altitudeUnits.equals(dataObject.getAltitudeUnits());
    }
    
    @Override
    public int hashCode()
    {
        return (latitude + longitude + altitude + altitudeUnits).hashCode();
    }
    
    public String getLatitude()
    {
        return latitude;
    }
    
    public String getLongitude()
    {
        return longitude;
    }
    
    public String getAltitude()
    {
        return altitude;
    }
    
    public String getAltitudeUnits()
    {
        return altitudeUnits;
    }

}
