package Database.entitas

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHandler(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
    companion object {
        private const val DATABASE_NAME = "UserDatabase"
        private const val DATABASE_VERSION = 1
        private const val TABLE_USERS = "Users"
        private const val COLUMN_ID = "id"
        private const val COLUMN_NAME = "name"
        private const val COLUMN_EMAIL = "email"
        private const val COLUMN_PASSWORD = "password"
        private const val COLUMN_FULLNAME = "fullname"
        private const val COLUMN_TANGGAL_LAHIR = "tanggal_lahir"
        private const val COLUMN_GENDER = "gender"
        private const val COLUMN_NOMOR_TELEPON = "nomor_telepon"
        private const val COLUMN_ALAMAT = "alamat"
    }

    override fun onCreate(db: SQLiteDatabase) {
        val createTable = ("CREATE TABLE $TABLE_USERS (" +
                "$COLUMN_ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "$COLUMN_NAME TEXT, " +
                "$COLUMN_EMAIL TEXT, " +
                "$COLUMN_PASSWORD TEXT, " +
                "$COLUMN_FULLNAME TEXT, " +
                "$COLUMN_TANGGAL_LAHIR TEXT, " +
                "$COLUMN_GENDER TEXT, " +
                "$COLUMN_NOMOR_TELEPON TEXT, " +
                "$COLUMN_ALAMAT TEXT)")
        db.execSQL(createTable)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS $TABLE_USERS")
        onCreate(db)
    }

    fun Insert(name: String, email: String, password: String, fullname: String, tanggalLahir: String, gender: String, nomorTelepon: String, alamat: String): Long {
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(COLUMN_NAME, name)
        contentValues.put(COLUMN_EMAIL, email)
        contentValues.put(COLUMN_PASSWORD, password)
        contentValues.put(COLUMN_FULLNAME, fullname)
        contentValues.put(COLUMN_TANGGAL_LAHIR, tanggalLahir)
        contentValues.put(COLUMN_GENDER, gender)
        contentValues.put(COLUMN_NOMOR_TELEPON, nomorTelepon)
        contentValues.put(COLUMN_ALAMAT, alamat)

        val result = db.insert(TABLE_USERS, null, contentValues)
        db.close()
        return result
    }

}
