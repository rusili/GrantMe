package nyc.c4q.rusili.grantme.utilities;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import nyc.c4q.rusili.grantme.R;

/**
 * Created by huilin on 2/18/17.
 */

public class DataSets {
    private List <String> locationList;
    private List <String> fieldList;
    private List <String> durationList;
    private Map<String, Integer> pictureMap = new HashMap<>();

    public void initPictureMap() {
        pictureMap.put("Brooklyn", R.drawable.brooklyn);
        pictureMap.put("Bronx", R.drawable.bronx);
        pictureMap.put("Manhattan", R.drawable.manhattan);
        pictureMap.put("Queens", R.drawable.queens);
        pictureMap.put("Staten Island", R.drawable.statenisland);
        pictureMap.put("All", R.drawable.nyc);
        pictureMap.put("Medical", R.drawable.medical);
        pictureMap.put("Information Technology", R.drawable.infotech);
        pictureMap.put("Legal", R.drawable.legal);
        pictureMap.put("Finance", R.drawable.finance);
        pictureMap.put("Building Services", R.drawable.buildingservices);
        pictureMap.put("Other", R.drawable.otherindustries);
    }

    public Map<String, Integer> getPictureMap() {
        return pictureMap;
    }

    public List<String> getLocationList() {
        return locationList;
    }

    public void setLocationList(List<String> locationList) {
        this.locationList = locationList;
    }

    public List<String> getFieldList() {
        return fieldList;
    }

    public void setFieldList(List<String> fieldList) {
        this.fieldList = fieldList;
    }

    public List<String> getDurationList() {
        return durationList;
    }

    public void setDurationList(List<String> durationList) {
        this.durationList = durationList;
    }
}
