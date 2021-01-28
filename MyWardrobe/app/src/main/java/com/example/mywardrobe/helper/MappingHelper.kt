package com.example.mywardrobe.helper

import android.database.Cursor
import com.example.mywardrobe.db.DatabaseContract
import com.example.mywardrobe.pakaian

object MappingHelper {

    fun mapCursorToArrayList(notesCursor: Cursor?): ArrayList<pakaian> {
        val notesList = ArrayList<pakaian>()
        notesCursor?.apply {
            while (moveToNext()) {
                val id = getInt(getColumnIndexOrThrow(DatabaseContract.NoteColumns._ID))
                val title = getString(getColumnIndexOrThrow(DatabaseContract.NoteColumns.TITLE))
                val description = getString(getColumnIndexOrThrow(DatabaseContract.NoteColumns.DESCRIPTION))
                val date = getString(getColumnIndexOrThrow(DatabaseContract.NoteColumns.DATE))
                notesList.add(pakaian(id, title, description, date))
            }
        }
        return notesList
    }
}