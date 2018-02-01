package dangod.wechat.core.model.event;

import java.util.Map;

public class LocationEvent extends BaseEvent {
    //地理位置纬度
    private String Latitude;
    //地理位置经度
    private String Longitude;
    //地理位置精度
    private String Precision;

    public String getLatitude() {
        return Latitude;
    }

    public void setLatitude(String latitude) {
        Latitude = latitude;
    }

    public String getLongitude() {
        return Longitude;
    }

    public void setLongitude(String longitude) {
        Longitude = longitude;
    }

    public String getPrecision() {
        return Precision;
    }

    public void setPrecision(String precision) {
        Precision = precision;
    }

    public LocationEvent() {
    }

    public LocationEvent(Map xml) {
        super(xml);
        try {
            Latitude = (String)xml.get("Latitude");
            Longitude = (String)xml.get("Longitude");
            Precision = (String)xml.get("Precision");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
