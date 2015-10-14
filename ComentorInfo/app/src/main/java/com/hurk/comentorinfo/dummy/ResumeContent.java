package com.hurk.comentorinfo.dummy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Hurk on 2015-10-07.
 */
public class ResumeContent {


    public static List<ResumeItem> arrayListResume = new ArrayList<ResumeItem>();

    public static Map<String, ResumeItem> resumeHashMap  =
            new HashMap<String, ResumeItem>();

    static {
        ResumeItem gm = new ResumeItem(2007, 2011, "Diagnostic Algorithm Engineer", "Test GM");
        ResumeItem vcc1 = new ResumeItem(2011, 2012, "Software Architect", "Test VCC1");
        addResume(gm);
        addResume(vcc1);
    }

    private static void addResume(ResumeItem resume) {
        arrayListResume.add(resume);
        resumeHashMap.put(resume.toString(), resume);
    }

    // Constructor
    public static class ResumeItem {

        private int startYear = 0;
        private int endYear = 0;
        private String title = "Default";
        private String summary = "Default";

        public ResumeItem(int resStartYear, int resEndYear, String resTitle, String resSummary) {

            this.startYear = resStartYear;
            this.endYear = resEndYear;
            this.title = resTitle;
            this.summary = resSummary;
        }

        public int getStartYear() {
            return startYear;
        }

        public int getEndYear() {
            return endYear;
        }

        public String getTitle() {
            return title;
        }

        public String getSummary() {
            return summary;
        }

        @Override
        public String toString() {
            return title;
        }
    }
}
