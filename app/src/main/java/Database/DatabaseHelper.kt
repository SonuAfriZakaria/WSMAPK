import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log

class DatabaseHandler(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_VERSION = 1
        private const val DATABASE_NAME = "UserDatabase"
        private const val TABLE_USERS = "users"

        private const val KEY_ID = "id"
        private const val KEY_NAME = "name"
        private const val KEY_EMAIL = "email"
        private const val KEY_TANGGAL_LAHIR = "tanggal_lahir"
        private const val KEY_GENDER = "gender"
        private const val KEY_NOMOR_TELEPON = "nomor_telepon"
        private const val KEY_ALAMAT = "alamat"
        private const val KEY_PASSWORD = "password"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val CREATE_USERS_TABLE = ("CREATE TABLE " + TABLE_USERS + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT,"
                + KEY_EMAIL + " TEXT," + KEY_TANGGAL_LAHIR + " TEXT,"
                + KEY_GENDER + " TEXT," + KEY_NOMOR_TELEPON + " TEXT,"
                + KEY_ALAMAT + " TEXT," + KEY_PASSWORD + " TEXT" + ")")
        db?.execSQL(CREATE_USERS_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS $TABLE_USERS")
        onCreate(db)
    }

    fun addUser(user: User): Long {
        val db = this.writableDatabase
        val values = ContentValues()
        values.put(KEY_NAME, user.name)
        values.put(KEY_EMAIL, user.email)
        values.put(KEY_TANGGAL_LAHIR, user.tanggalLahir)
        values.put(KEY_GENDER, user.gender)
        values.put(KEY_NOMOR_TELEPON, user.nomorTelepon)
        values.put(KEY_ALAMAT, user.alamat)
        values.put(KEY_PASSWORD, user.password)

        val success = db.insert(TABLE_USERS, null, values)
        Log.d("DatabaseHandler", "User added: $user, Success: $success")
        db.close()
        return success
    }

    fun getUser(id: Int): User? {
        val db = this.readableDatabase
        val cursor = db.query(TABLE_USERS, arrayOf(KEY_ID, KEY_NAME, KEY_EMAIL, KEY_TANGGAL_LAHIR,
            KEY_GENDER, KEY_NOMOR_TELEPON, KEY_ALAMAT, KEY_PASSWORD), "$KEY_ID=?",
            arrayOf(id.toString()), null, null, null, null)

        return if (cursor != null && cursor.moveToFirst()) {
            val user = User(
                cursor.getInt(0),
                cursor.getString(1),
                cursor.getString(2),
                cursor.getString(3),
                cursor.getString(4),
                cursor.getString(5),
                cursor.getString(6),
                cursor.getString(7)
            )
            Log.d("DatabaseHandler", "User retrieved: $user")
            cursor.close()
            user
        } else {
            Log.d("DatabaseHandler", "No user found with ID: $id")
            null
        }
    }

    fun getAllUsers(): List<User> {
        val userList = ArrayList<User>()
        val selectQuery = "SELECT * FROM $TABLE_USERS"
        val db = this.writableDatabase
        val cursor = db.rawQuery(selectQuery, null)
        if (cursor.moveToFirst()) {
            do {
                val user = User(
                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getString(4),
                    cursor.getString(5),
                    cursor.getString(6),
                    cursor.getString(7)
                )
                userList.add(user)
                Log.d("DatabaseHandler", "User added to list: $user")
            } while (cursor.moveToNext())
        }
        cursor.close()
        Log.d("DatabaseHandler", "Total users retrieved: ${userList.size}")
        return userList
    }

    fun updateUser(user: User): Int {
        val db = this.writableDatabase
        val values = ContentValues()
        values.put(KEY_NAME, user.name)
        values.put(KEY_EMAIL, user.email)
        values.put(KEY_TANGGAL_LAHIR, user.tanggalLahir)
        values.put(KEY_GENDER, user.gender)
        values.put(KEY_NOMOR_TELEPON, user.nomorTelepon)
        values.put(KEY_ALAMAT, user.alamat)
        values.put(KEY_PASSWORD, user.password)

        val rowsAffected = db.update(TABLE_USERS, values, "$KEY_ID = ?", arrayOf(user.id.toString()))
        Log.d("DatabaseHandler", "User updated: $user, Rows affected: $rowsAffected")
        return rowsAffected
    }

    fun deleteUser(userId: Int): Int {
        val db = this.writableDatabase
        val rowsDeleted = db.delete(TABLE_USERS, "$KEY_ID = ?", arrayOf(userId.toString()))
        Log.d("DatabaseHandler", "User deleted with ID: $userId, Rows deleted: $rowsDeleted")
        return rowsDeleted
    }

}
