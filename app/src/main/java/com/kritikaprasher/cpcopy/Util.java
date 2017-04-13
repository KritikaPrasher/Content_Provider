package com.kritikaprasher.cpcopy;

import android.net.Uri;

/**
 * Created by pranavprashar on 4/13/17.
 */

public class Util {

    public static final int DB_VERSION=1;
    public static final String DB_NAME= "Students.db";

    public static final String TAB_NAME= "User";
    public static final String USER_ID= "_ID";
    public static final String USER_NAME= "NAME";
    public static final String USER_EMAIL= "EMAIL";

    public static final String CREATE_TAB_QUERY = "create table Student(" +
            "_ID integer primary key autoincrement," +
            "NAME varchar(256)," +
            "EMAIL varchar(256)" +
            ")";

    // URI
    public static final Uri STUDENT_URI = Uri.parse("content://com.kritikaprasher.cpcopy.studentprovider/"+TAB_NAME);


}
