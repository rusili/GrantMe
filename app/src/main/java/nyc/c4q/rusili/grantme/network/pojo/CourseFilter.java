package nyc.c4q.rusili.grantme.network.pojo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Millochka on 2/18/17.
 */

public class CourseFilter {

    private List<JSONCourses> mCourseList = new ArrayList<>();
    private final String LOCATION_TAB = "Location";
    private final String FIELD_TAB = "Field";
    private final String DURATION_TAB = "Duration";
    private Map<String, String> fieldKeys = new HashMap<>();
    private List<JSONCourses> fieldOtherList = new ArrayList<>();

    public CourseFilter(List<JSONCourses> courseList) {
        this.mCourseList = courseList;
        initHashMap();
    }


    public List<JSONCourses> filterList(final int position, final String fragId) {

        switch (fragId) {

            case LOCATION_TAB:

                return boroughList(position);

            case FIELD_TAB:

                return fieldList(position);

            case DURATION_TAB:

                return durationList(position);

        }

        return mCourseList;


    }


    public List<JSONCourses> boroughList(final int position) {

        String borough = "";
        List<JSONCourses> output = new ArrayList<>();


        switch (position) {
            case 0:
                borough = "Brooklyn";
                break;
            case 1:
                borough = "Bronx";
                break;
            case 2:
                borough = "Manhattan";
                break;
            case 3:
                borough = "Queens";
                break;
            case 4:
                borough = "Staten Island";
                break;

        }


        for (JSONCourses item : this.mCourseList) {
            if (item.getBorough() != null) {
                if (item.getBorough().equalsIgnoreCase(borough)) {
                    output.add(item);
                }
            }
        }
        return output;
    }

    public List<JSONCourses> fieldList(final int position) {
        String field = "";
        List<JSONCourses> output = new ArrayList<>();

        switch (position) {
            case 0:
                field = "Medical";
                break;
            case 1:
                field = "Information Technology";
                break;
            case 2:
                field = "Legal";
                break;
            case 3:
                field = "Finance";
                break;
            case 4:
                field = "Building Services";
                break;
            case 5:
                field = "Other";
                break;

        }

        for (JSONCourses item : this.mCourseList) {
            if (item.getKeywords() != null &&!field.equals("Other")) {
                if (item.getKeywords().equalsIgnoreCase(fieldKeys.get(field))) {
                    output.add(item);
                }
            } else {
                fieldOtherList.add(item);
            }
        }

        if(field.equalsIgnoreCase("Other")){
            return fieldOtherList;
        }

        return output;
    }

    public List<JSONCourses> durationList(int position) {
        List<JSONCourses> output = new ArrayList<>();
        for (JSONCourses item : this.mCourseList) {
            if (item.getBorough() != null) {
                if (item.getDuration().contains("80")) {
                    output.add(item);
                }
            }
        }
        return output;
    }

    public void initHashMap() {
        fieldKeys.put("Medical", "Health  home  attendant  Medical  NCLEX  RN  Emergency  EMS  EMT  clinical  clinic  transcription  Nurse  phlebotomy  EKG  Dentist  doctor  practitioner  physician  hygien  Can  LPN  HHA  PCA  care  aide  orderly  nursing");
        fieldKeys.put("Maintenance", "ground  commercial  fire  safety  clean  maintenance  residential  sprinkler  environment ");
        fieldKeys.put("Legal", "paralegal  law  legal  mediat  lawyer  judge  court  case");
        fieldKeys.put("Receptionist", "Receptionist  Office Clerk  Executive Secretary  Administrative Assistant  microsoft  office  account  bookkeep  audit  quickbooks  bookkeeper  bookkeeping  excel  word");
        fieldKeys.put("Carpenter", "Woodworking  woodworker  cabinet making  cabinet maker  carpenters  carpentry  machinist  machinery  grinder   polisher  CNC  assembly  assemblers  tool die makers  wood  metal  plastic  fabric  gas  glass  sew  weld  mold  furniture  craft\n");
        fieldKeys.put("Commercial Driver", "CDL  CLASS A  Class B  Class C   Bus  Passenger Vehicle   license  driver  drive  truck  commercial  brakes  air  driving lessons  air brakes  truck  warehouse operations  forklift operator  transportation");
        fieldKeys.put("Real Estate", "real estate  sale  broker  agent  agency  cl-cb  travel  retail  cashier  telemarket");
        fieldKeys.put("Landscape", "landscape  engineer  civil  drafter  survey ");
        fieldKeys.put("Social Work", "drug  counselor  alcohol  substance  social work  rehab");
        fieldKeys.put("Science", "science  scientist");
        fieldKeys.put("Designer", "Design  designers  Pro  graphic designer  adobe  autocad  CS5  indesign  website  web  art  animation  flash  artist  media  fashion");
        fieldKeys.put("Restaurant", "chef  cook  restaurant  diner  food  dishwash  servsafe  serve  wait  counter  bartend  hospitality  host  dine");
        fieldKeys.put("Property", "project manager  management  facilities  real estate  residential  property");
        fieldKeys.put("Finance", "account  bookkeep  bookkeeper  bookkeeping  financial  tax  audit  loan  peachtree  quickbook  irs  budget  credit  finance");
        fieldKeys.put("Building Services", "Construct  boiler  carpenter  Electrician  Plumber  Roofer  helper  building  construction  removal  electronic  electrical  inspector  hazardous  solar  asbestos  EHMT");
        fieldKeys.put("Industrial", "Install  Maintenance  Repair  Mechanic  Equipment  Electrical  electronic  electric  Industrial  Security Fire Alarm  Service technicians  Auto  Glass  Service  Engine  building  boiler  Heat  Air condition  Refrigerator  Appliance  plumber  weather");
        fieldKeys.put("Insurance", "Health  EMR  ehR  Pharmacy  Medical Biller  NCLEX  RN  Billing  Coding  Insurance  Emergency  EMS  EMT  clinical  clinic  transcription  Nurse  phlebotomy  EKG  Dentist  doctor  practitioner  physician  hygien  Can  LPN  HHA  PCA  Care");
        fieldKeys.put("Information Technology", "network  help desk  helpdesk  administrator   support  system  Cisco  Oracle  Windows  Server  SQL  architect   TIA  program  programmer  database  db  visual basic  vba  WAN  Microsoft  MCSE");
    }
}
