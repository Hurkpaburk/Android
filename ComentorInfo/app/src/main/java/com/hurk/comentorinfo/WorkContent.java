package com.hurk.comentorinfo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Hurk on 2015-10-07.
 */
public class WorkContent {

    static public final String COMENTORADDRESS = "Comentor Office Location";
    static public final String COMENTORWEBPAGE = "Comentor Webpage";
    static public final String EMPLOYEEJOHAN = "Employee Johan Bergström";
    static public final String ABOUT = "About Application";
    public static List<WorkItem> arrayListWork = new ArrayList<WorkItem>();

    public static Map<String, WorkItem> WorkHashMap =
            new HashMap<String, WorkItem>();

    static {
        WorkItem company = new WorkItem(COMENTORWEBPAGE, "https://www.comentor.se");
        WorkItem employee1 = new WorkItem(EMPLOYEEJOHAN, "https://se.linkedin.com/in/johbe");
        WorkItem address = new WorkItem(COMENTORADDRESS, "");
        WorkItem about = new WorkItem(ABOUT, "");
        addWork(company);
        addWork(employee1);
        addWork(address);
        addWork(about);
    }

    private static void addWork(WorkItem Work) {
        arrayListWork.add(Work);
        WorkHashMap.put(Work.toString(), Work);
    }

    // Constructor
    public static class WorkItem {

        public String title = "Default";
        public String webPage = "Default";

        public WorkItem(String title, String webpage) {

            this.title = title;
            this.webPage = webpage;
        }

        public String getTitle() {
            return title;
        }

        public String getWebPage() {
            return webPage;
        }

        @Override
        public String toString() {
            return title;
        }
    }
}
