package com.huwei.sweetmusicplayer.models;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;

import com.huwei.sweetmusicplayer.models.ArtistInfo;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table ARTIST_INFO.
*/
public class ArtistInfoDao extends AbstractDao<ArtistInfo, Long> {

    public static final String TABLENAME = "ARTIST_INFO";

    /**
     * Properties of entity ArtistInfo.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property ArtistId = new Property(0, Long.class, "artistId", true, "ARTIST_ID");
        public final static Property Artist = new Property(1, String.class, "artist", false, "ARTIST");
    };


    public ArtistInfoDao(DaoConfig config) {
        super(config);
    }
    
    public ArtistInfoDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "'ARTIST_INFO' (" + //
                "'ARTIST_ID' INTEGER PRIMARY KEY ," + // 0: artistId
                "'ARTIST' TEXT);"); // 1: artist
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "'ARTIST_INFO'";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, ArtistInfo entity) {
        stmt.clearBindings();
 
        Long artistId = entity.getArtistId();
        if (artistId != null) {
            stmt.bindLong(1, artistId);
        }
 
        String artist = entity.getArtist();
        if (artist != null) {
            stmt.bindString(2, artist);
        }
    }

    /** @inheritdoc */
    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    /** @inheritdoc */
    @Override
    public ArtistInfo readEntity(Cursor cursor, int offset) {
        ArtistInfo entity = new ArtistInfo( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // artistId
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1) // artist
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, ArtistInfo entity, int offset) {
        entity.setArtistId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setArtist(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
     }
    
    /** @inheritdoc */
    @Override
    protected Long updateKeyAfterInsert(ArtistInfo entity, long rowId) {
        entity.setArtistId(rowId);
        return rowId;
    }
    
    /** @inheritdoc */
    @Override
    public Long getKey(ArtistInfo entity) {
        if(entity != null) {
            return entity.getArtistId();
        } else {
            return null;
        }
    }

    /** @inheritdoc */
    @Override    
    protected boolean isEntityUpdateable() {
        return true;
    }
    
}
