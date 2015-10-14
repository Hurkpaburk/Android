package com.hurk.comentorinfo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Hurk on 2015-10-07.
 */
public class WorkContent {

    static public final String COMENTORADDRESS = "Comentor Address";
    public static List<WorkItem> arrayListWork = new ArrayList<WorkItem>();

    public static Map<String, WorkItem> WorkHashMap  =
            new HashMap<String, WorkItem>();

    static {
        WorkItem company = new WorkItem("Comentor", "http://www.comentor.se");
        WorkItem employee1 = new WorkItem("Employee Johan Bergström on LinkedIn", "https://se.linkedin.com/in/johbe");
        WorkItem address = new WorkItem(COMENTORADDRESS, "");
        addWork(company);
        addWork(address);
        addWork(employee1);
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
