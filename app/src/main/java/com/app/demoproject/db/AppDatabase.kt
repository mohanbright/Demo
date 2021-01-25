package com.app.demoproject.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.app.demoproject.dataModal.RegisterDataModal
import com.app.demoproject.utils.Constants


class AppDatabase(var context: Context) :
    SQLiteOpenHelper(context, Constants.DATABASE_NAME, null, Constants.DATABASE_VERSION) {

    companion object {
        const val TABLE_REGISTER = "register"

        /**
         * Register columns
         */

        const val COLUMN_FIRSTNAME = "firstname"
        const val COLUMN_REGISTERID = "id"
        const val COLUMN_LASTNAME = "lastname"
        const val COLUMN_EMAIL = "email"
        const val COLUMN_PASSWORD = "password"
    }

    override fun onCreate(p0: SQLiteDatabase?) {
        val SQL_CREATE_REGISTER =
            ("CREATE TABLE IF NOT EXISTS " + TABLE_REGISTER + "("
                    + COLUMN_REGISTERID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + COLUMN_FIRSTNAME + " TEXT," + COLUMN_LASTNAME + " TEXT," + COLUMN_EMAIL + " TEXT," +
                    COLUMN_PASSWORD + " TEXT " +
                    ")")
        p0!!.execSQL(SQL_CREATE_REGISTER)


    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        p0!!.execSQL("DROP TABLE IF EXISTS " + TABLE_REGISTER)
        onCreate(p0)
    }

    //INSERT VALUES
    fun _insertRegister(
        registerDataModal: RegisterDataModal
    ) {
        val database = this.writableDatabase
        val sql = " INSERT INTO "+TABLE_REGISTER+" VALUES (NULL,?,?,?,?)"
        val statement = database.compileStatement(sql)
        statement.clearBindings()
        statement.bindString(1, registerDataModal.first_name)
        statement.bindString(2, registerDataModal.last_name)
        statement.bindString(3, registerDataModal.email)
        statement.bindString(4, registerDataModal.password)
        statement.executeInsert()
    }

    /**
     * This method to check user exist or not
     *
     * @param email
     * @param password
     * @return true/false
     */
    fun checkUser(email: String, password: String): Boolean {
        // array of columns to fetch
        val columns = arrayOf(
            COLUMN_REGISTERID
        )
        val db = this.readableDatabase
        // selection criteria
        val selection: String =
            "$COLUMN_EMAIL = ? AND $COLUMN_PASSWORD = ?"
        // selection arguments
        val selectionArgs = arrayOf(email, password)
        // query user table with conditions
        /**
         * Here query function is used to fetch records from user table this function works like we use sql query.
         * SQL query equivalent to this query function is
         * SELECT user_id FROM user WHERE user_email = 'jack@androidtutorialshub.com' AND user_password = 'qwerty';
         */
        val cursor = db.query(
            TABLE_REGISTER,  //Table to query
            columns,  //columns to return
            selection,  //columns for the WHERE clause
            selectionArgs,  //The values for the WHERE clause
            null,  //group the rows
            null,  //filter by row groups
            null
        ) //The sort order
        val cursorCount = cursor.count
        cursor.close()
        db.close()
        return cursorCount > 0
    }

    /**
     * This method to check user exist or not
     *
     * @param email
     * @return true/false
     */
    fun checkUserWithEmail(email: String): Boolean {

        val columns = arrayOf<String>(
            COLUMN_REGISTERID
        )
        val db = this.readableDatabase

        val selection: String = COLUMN_EMAIL.toString() + " = ?"

        val selectionArgs = arrayOf(email)

        val cursor = db.query(
            TABLE_REGISTER,  //Table to query
            columns,  //columns to return
            selection,  //columns for the WHERE clause
            selectionArgs,  //The values for the WHERE clause
            null,  //group the rows
            null,  //filter by row groups
            null
        )
        val cursorCount = cursor.count
        cursor.close()
        db.close()
        return cursorCount > 0
    }

}