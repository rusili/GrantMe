package nyc.c4q.rusili.grantme.network.pojo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Millochka on 2/18/17.
 */

public class CourseFilter {

    private List<JSONCourses> mCourseList=new ArrayList<>();



    public CourseFilter(List<JSONCourses> courseList){
        this.mCourseList=courseList;

    }


public List<JSONCourses> filterList(final int position, String fragId){

    switch (fragId){

        case "Location":

            return borougthList(position);


        case "Field":

             return fieldList(position);


        case "Duration":

        return durationList(position);

    }

    return mCourseList;


}

    public Set<String> getDuration(){

        Set<String> durationList= new HashSet<>();

        for(JSONCourses item:this.mCourseList){
            durationList.add(item.getDuration());

        }
        return durationList;

    }


    public List<JSONCourses> borougthList( final int position ){

        String borough = "";
        List<JSONCourses> output = new ArrayList<>();


        switch (position){
            case 0:
                borough="Brooklyn";
                break;
            case 1:
                borough="Bronx";
                break;
            case 2:
                borough="Manhattan";
                break;
            case 3:
                borough="Queens";
                break;
            case 4:
                borough="Staten Island";
                break;

        }



        for(JSONCourses item:this.mCourseList){
            if(item.getBorough()!=null) {
                if (item.getBorough().equalsIgnoreCase(borough)) {
                    output.add(item);
                }
            }
        }
        return output;
    }

    public List<JSONCourses> fieldList( int position ){

        return mCourseList;
    }

    public List<JSONCourses> durationList( int position ){
        return mCourseList;


    }
}
