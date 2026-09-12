package com.example.a24012011180_mad_practical_7

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import java.sql.SQLException

class DatabaseHelper(context: Context): SQLiteOpenHelper(context, DB_NAME, null, DB_VERSION) {
    companion object{
        private val DB_NAME = "ContactDatabase.db"
        private val DB_VERSION = 1
        private val TABLE_CONTACT = "contacts"
        private val KEY_ID = "id"
        private val KEY_NAME = "name"
        private val KEY_PHONE = "phoneNo"
        private val KEY_EMAIL = "emailId"
        private val KEY_ADDRESS = "address"
        private val KEY_LATITUDE = "latitude"
        private val KEY_LONGITUDE = "longitude"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val createTableSQLQuery = "CREATE TABLE $TABLE_CONTACT(" +
                "$KEY_ID INTEGER PRIMARY AUTO_INCREMENT, " +
                "$KEY_NAME TEXT," +
                "$KEY_PHONE TEXT," +
                "$KEY_EMAIL TEXT," +
                "$KEY_ADDRESS TEXT," +
                "$KEY_LATITUDE REAL," +
                "$KEY_LONGITUDE REAL" +
                ");"
        db!!.execSQL(createTableSQLQuery)
    }

    override fun onUpgrade(
        db: SQLiteDatabase?,
        oldVersion: Int,
        newVersion: Int
    ) {
        val dropQuery = "DROP TABLE IF EXISTS $TABLE_CONTACT"
        db!!.execSQL(dropQuery)
        onCreate(db)
    }

    fun insertContact(contact: Person){
        val db = this.writableDatabase
        val values = ContentValues()
        values.put(KEY_ID,contact.id)
        values.put(KEY_NAME,contact.name)
        values.put(KEY_PHONE,contact.phoneNo)
        values.put(KEY_EMAIL,contact.emailId)
        values.put(KEY_ADDRESS,contact.address)
        values.put(KEY_LATITUDE, contact.latitude)
        values.put(KEY_LONGITUDE, contact.longitude)

        db.insert(TABLE_CONTACT,null,values)
        db.close()
    }

    fun updatePerson(contact: Person){
        val db = this.writableDatabase
        val values = ContentValues()
        values.put(KEY_ID,contact.id)
        values.put(KEY_NAME,contact.name)
        values.put(KEY_PHONE,contact.phoneNo)
        values.put(KEY_EMAIL,contact.emailId)
        values.put(KEY_ADDRESS,contact.address)
        values.put(KEY_LATITUDE, contact.latitude)
        values.put(KEY_LONGITUDE, contact.longitude)

        db.update(TABLE_CONTACT,values,"id=?",arrayOf(contact.id.toString()))
        db.close()
    }

    fun getPerson(id:String): Person?{
        val db = readableDatabase
        try{
            val cursor = db.query(TABLE_CONTACT,arrayOf(KEY_ID,KEY_NAME,KEY_PHONE,KEY_EMAIL,KEY_ADDRESS,KEY_LATITUDE,KEY_LONGITUDE),"$KEY_ID=?",arrayOf(id),null,null,null)

            cursor.moveToFirst()
            val returnContact = Person(cursor.getString(cursor.getColumnIndexOrThrow(KEY_ID)),
                cursor.getString(cursor.getColumnIndexOrThrow(KEY_NAME)),
                cursor.getString(cursor.getColumnIndexOrThrow(KEY_PHONE)),
                cursor.getString(cursor.getColumnIndexOrThrow(KEY_EMAIL)),
                cursor.getString(cursor.getColumnIndexOrThrow(KEY_ADDRESS)),
                cursor.getDouble(cursor.getColumnIndexOrThrow(KEY_LATITUDE)),
                cursor.getDouble(cursor.getColumnIndexOrThrow(KEY_LONGITUDE))
            )
            cursor.close()

            return returnContact
        }catch(e: SQLException){
            e.printStackTrace()
        }
        return null
    }

    fun deleteContact(id: Long) {
        val db = this.writableDatabase
        db.delete(TABLE_CONTACT, "id=?", arrayOf(id.toString()))
        db.close()
    }
}