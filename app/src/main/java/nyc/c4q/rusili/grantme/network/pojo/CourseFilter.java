package nyc.c4q.rusili.grantme.network.pojo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Millochka on 2/18/17.
 */

public class CourseFilter {

    private List<JSONCourses> mCourseList=new ArrayList<>();



    public CourseFilter(List<JSONCourses> courseList){
        this.mCourseList=courseList;

    }


public List<JSONCourses> filterList(int position, int tabId){

    switch (tabId){

        case 1:

            return borougthList(position);


        case 2:

             return fieldList(position);


        case 3:

        return durationList(position);

    }

    return mCourseList;


}


    public List<JSONCourses> borougthList( int position ){

        String borough = "";
        List<JSONCourses> output = new ArrayList<>();


        switch (position){
            case 1:
                borough="Brooklyn";

                break;
            case 2:
                borough="Queens";
                break;
            case 3:
                borough="Bronx";
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
